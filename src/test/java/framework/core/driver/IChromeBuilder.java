package framework.core.driver;

import org.openqa.selenium.PageLoadStrategy;

import java.io.File;

public interface IChromeBuilder {

    String DISABLE_NOTIFICATIONS = "disable-notifications";
    String START_INCOGNITO = "--incognito";
    String IGNORE_CERTIFICATE_ERRORS = "--ignore-certificate-errors";

    String SAFE_BROWSING_ENABLED = "safebrowsing.enabled";
    String PROFILE_DEFAULT_SETTINGS_POPUP = "profile.default_content_settings.popups";
    String PROMPT_FOR_DOWNLOAD = "download.prompt_for_download";
    String DOWNLOAD_DIRECTORY = "download.default_directory";

    IChromeBuilder addCustomOptionArgument(Object argument);
    IChromeBuilder addCustomPreference(Object pref, Object value);
    IChromeBuilder disableNotifications();
    IChromeBuilder startIncognito();
    IChromeBuilder ignoreCertificateErrors();
    IChromeBuilder enableAutomation();
    IChromeBuilder enableSafeBrowsing();
    IChromeBuilder setDownloadDirectory(File directory);
    IChromeBuilder allowPopups();
    IChromeBuilder suppressDownloadPrompt();
    IChromeBuilder setPageLoadStrategy(PageLoadStrategy strategy);
    void build();
}
