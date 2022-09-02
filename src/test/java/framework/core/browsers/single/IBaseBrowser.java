package framework.core.browsers.single;

public interface IBaseBrowser {
     void goToBaseUrl() throws Throwable;
     void open() throws Throwable;
     void restart() throws Throwable;
     void quit();

}
