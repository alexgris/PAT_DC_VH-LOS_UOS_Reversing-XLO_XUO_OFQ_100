package init.settings;

import org.apache.log4j.Logger;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import java.io.File;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;


public class SeleniumSetUp {

    public Logger logger = Logger.getLogger(SeleniumSetUp.class);

    public static WebDriver driver;
    //public static PhantomJSDriver driver;


    @BeforeClass

    @Parameters({"browser", "FireFoxProfileName"})
    public static void setUp(String browser, @Optional String FireFoxProfileName) throws Exception {



        // If the browser is Chrome, then do this
        if (browser.equalsIgnoreCase("chrome")) {
            File driverFile = new File("C://SeleniumWebDrivers//Chrome//chromedriver.exe");
            System.setProperty("webdriver.chrome.driver", driverFile.getAbsolutePath());

            //Start Chrome browser with a specific extension
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--incognito");
            options.addArguments("disable-notifications");
            //options.addExtensions(new File("src//test//resources//extensions//extension.crx"));

            DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();
            LoggingPreferences logPrefs = new LoggingPreferences();
            logPrefs.enable(LogType.BROWSER, Level.ALL);
            desiredCapabilities.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
            desiredCapabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
            desiredCapabilities.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT, true);
            desiredCapabilities.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
            //desiredCapabilities.setCapability("chrome.switches", Arrays.asList("--ignore-certificate-errors"));
            desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, options);


            //Headless Browser Driver. It is same as Chrome, IE, or FireFox driver, but it does not have GUI so one cannot see the test execution on screen.
            //driver = new HtmlUnitDriver(desiredCapabilities);

            driver = new ChromeDriver(desiredCapabilities);
            driver.manage().deleteAllCookies();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            // If the browser is Firefox, then do this
        } else if (browser.equalsIgnoreCase("firefox")) {

            //Start FireFox browser
            File driverFile = new File("C://SeleniumWebDrivers//FireFox//geckodriver.exe");
            System.setProperty("webdriver.gecko.driver", driverFile.getAbsolutePath());

            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("-private");


            LoggingPreferences logPrefs = new LoggingPreferences();
            logPrefs.enable(LogType.PERFORMANCE, Level.ALL);

            // FirefoxOptions options = new FirefoxOptions();
            // options.setBinary("C://Program Files//Mozilla Firefox//firefox.exe"); //Location where Firefox is installed

            ProfilesIni profile = new ProfilesIni();
            FirefoxProfile firefoxProfile = profile.getProfile(FireFoxProfileName);

            //FirefoxProfile firefoxProfile = new FirefoxProfile();
            //firefoxProfile.setPreference("extensions.lastPlatformVersion", "50.0");
            // firefoxProfile.setPreference("intl.accept_languages", "en-us");
            firefoxProfile.setAcceptUntrustedCertificates(true);
            firefoxProfile.setAssumeUntrustedCertificateIssuer(true);
            //firefoxProfile.setPreference("browser.private.browsing.autostart", false);
            //firefoxProfile.setPreference("permissions.default.stylesheet", 2);
            //firefoxProfile.setPreference("permissions.default.image", 2);
            //firefoxProfile.setPreference("browser.download.folderList", 2);
            //firefoxProfile.setPreference("browser.helperApps.alwaysAsk.force", false);


            DesiredCapabilities capbl = DesiredCapabilities.firefox();
            //capbl.setCapability("marionette", true);
            capbl.setCapability("javascriptEnabled", true);
            capbl.setCapability("acceptSslCerts", true);
            capbl.setCapability("networkConnectionEnabled", true);
            capbl.setCapability("browserConnectionEnabled", true);
            //capbl.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
            capbl.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
            //capbl.setCapability(CapabilityType.PROXY, Context.getProxy());
            capbl.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
            capbl.setCapability(FirefoxDriver.PROFILE, firefoxProfile);
            // capbl.setCapability("moz:firefoxOptions",options);


            driver = new FirefoxDriver(capbl);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            // If the browser is InternetExplorer, then do this
        } else if (browser.equalsIgnoreCase("ie")) {

            //Start IE11 browser
            //Initialize IE and IEDriver and set path to IEDriverServer.exe on local box
            File driverFile = new File("C://SeleniumWebDrivers//IE//IEDriverServer.exe");
            System.setProperty("webdriver.ie.driver", driverFile.getAbsolutePath());

            //Instantiating Desired Capabilities on IE11
            DesiredCapabilities ieCaps = DesiredCapabilities.internetExplorer();

            ieCaps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
            ieCaps.internetExplorer().setCapability("ignoreProtectedModeSettings", true);
            ieCaps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
            ieCaps.setJavascriptEnabled(true);
            ieCaps.setCapability("requireWindowFocus", true);
            ieCaps.setCapability("enablePersistentHover", false);
            //Clear the cache, cookies, history, and saved form data. Clears for all running instances of IE, including those started manually.
            ieCaps.setCapability("ie.ensureCleanSession", true);


            //Instantiating IE driver with the list of Desired Capabilities
             driver = new InternetExplorerDriver(ieCaps);
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

            // If the browser should not open and tests need to be run in the background, then do this
        } else if (browser.equalsIgnoreCase("headless")) {

            // Declaring and initialising the HtmlUnitWebDriver
         /*   HtmlUnitDriver unitDriver = new HtmlUnitDriver(BrowserVersion.BEST_SUPPORTED);
            unitDriver.setJavascriptEnabled(true);
            driver = unitDriver;*/

            System.setProperty("phantomjs.binary.path", ".\\src\\main\\resources\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe");
            driver = new PhantomJSDriver();

        }

    }


    @AfterClass
    public void cleanUp() {

       /* Test_Cases testCases = new Test_Cases(); //Instantiating object of "Test_Cases" class

        testCases.insertLinksIntoLogFile();*/

        driver.manage().deleteAllCookies();
        // driver.close(); //close the current browser window
        driver.quit(); //quit the whole browser session along with all the associated browser windows, tabs and pop-ups.

    }


 /*   @AfterSuite
  public static void tearDown() {
        driver.manage().deleteAllCookies();
        driver.close(); //close the current browser window
        driver.quit (); //quit the whole browser session along with all the associated browser windows, tabs and pop-ups.
       }*/


}
