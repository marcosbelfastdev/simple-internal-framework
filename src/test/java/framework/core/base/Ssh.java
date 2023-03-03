package framework.core.base;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.Channel;
import framework.core.utils.Timer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Ssh {

	public final static String ENTER = "\r";
	private final static int RESPONSE_ASYNC = 2;
	private final int MIN_RETRY_TIMEOUT = 1000;
	private int responseMode;
	private int retryTimeout;

	private JSch jSch = null;
	private Session session = null;
	private Channel channel = null;
	private InputStream inputStream = null;
	private OutputStream outputStream = null;


	private String host;
	private int port;
	private String user;
	private String password;
	private int timeout;


	private String lastResponse;
	private String allResponses;


	public Ssh(String host, int port, String user, String password, int timeout) {
		this.host = host;
		this.port = port;
		this.user = user;
		this.password = password;
		this.timeout = timeout;
		this.responseMode = 1;
	}

	public boolean isConnected() {
		return channel.isConnected();
	}

	public void connect() {

		this.jSch = new JSch();

		JSch.setConfig("PreferredAuthentications", "publickey,keyboard-interactive,password");
		java.util.Properties config = new java.util.Properties();
		config.put("StrictHostKeyChecking", "no");
		JSch.setConfig(config);

		try {

			this.session = this.jSch.getSession(user, host, port);
			this.session.setPassword(password);
			this.session.connect(timeout);
			this.channel = this.session.openChannel("shell");
			this.channel.connect();

			this.inputStream = this.channel.getInputStream();
			this.outputStream = this.channel.getOutputStream();

		} catch (Exception exp) {
			// error
			exp.printStackTrace();
		}
	}

	/**
	 * Suitable when you want to use commands such as a find file with a pattern:
	 * You may get results immediately and stop getting results, and start getting results after a while.
	 * The retryTimeout for RESPONSE_ASYNC should be the maximum time to wait until results start coming in again.
	 * @param retryTimeout
	 */
	public void setResponseModeAsync(int retryTimeout) {
		this.responseMode = RESPONSE_ASYNC;
		this.retryTimeout = Math.max(MIN_RETRY_TIMEOUT, retryTimeout);
	}

	public void setDefaultResponseMode() {
		this.retryTimeout = MIN_RETRY_TIMEOUT;
		this.responseMode = 1;
	}


	public void mtype(String... commands) {
	    for(String command : commands) {
			type(command);
        }
    }


	public void type(String command) {
		try {

		    if (this.outputStream != null) {
		        System.out.println(command);
		        this.outputStream.write(command.getBytes());
		        this.outputStream.flush();
		    }


		} catch (Exception exp) {
			exp.printStackTrace();
		}

		getBuffer();
	}

	private void addResponse(String response) {
		StringBuilder sb = new StringBuilder();
		sb.append(allResponses);
		sb.append(response);
		allResponses = sb.toString();
	}

	public String getLastResponse() {
		return lastResponse;
	}

	public String getAllResponses() {
		return allResponses;
	}

	private void getBuffer() {

		StringBuilder sb = new StringBuilder();
		String response = null;
		try {
			Timer timer = new Timer(60*1000);
			while (true) {

				while (inputStream.available() < 1 && !timer.timedOut()) {
					timer.sleep(500); // tempo maximo a esperar para receber algo
				}
				// here  u can use input stream let check have or not data from input stream
				// let recv
				int bytes = this.inputStream.available();
				// receiving all data
				while (bytes > 0) {
					// creating buffer let recv data
					byte[] buffer = new byte[bytes];
					// check byte read from input stream
					int read = this.inputStream.read(buffer);
					// check byte read finished or not
					bytes = bytes - read;
					sb.append(new String(buffer));
				}

				Timer retryTimer = responseMode == 1 ? new Timer(MIN_RETRY_TIMEOUT) : new Timer(retryTimeout);
				while (inputStream.available() < 1 && !retryTimer.timedOut()) {
					retryTimer.sleep(200);
				}
				if (inputStream.available() < 1)
					break;

			}

		} catch (Exception exp) {
			exp.printStackTrace();
		}

		this.lastResponse = sb.toString();
		addResponse(lastResponse);
	}

	public void close() {
		if (this.session != null) {
			this.session.disconnect();
		}
		if (this.channel != null) {
			this.channel.isClosed();
		}

		if (this.inputStream != null) {
			try {
				this.inputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (this.outputStream != null) {
			try {
				this.outputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.jSch = null;
	}


}
