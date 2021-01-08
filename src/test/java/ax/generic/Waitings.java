package ax.generic;

import init.settings.SeleniumSetUp;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Waitings extends SeleniumSetUp {

    public static Logger logger = Logger.getLogger(Waitings.class);


    public static void waitTillElementDetected(int searchAttempts, String XPath, String PageName) {
        long startTime = System.nanoTime();
        int secondsCounter = 0;

        try {
            for (int i = 1; i <= searchAttempts; i++) {

                try {
                    //Locate the web element
                    driver.findElement(By.xpath(XPath));
                } catch (NoSuchElementException e) {
                    Thread.sleep(1000);
                    secondsCounter++;
                }


                if (secondsCounter == searchAttempts) {

                    long endTime = System.nanoTime();
                    double elapsedTimeInSeconds = TimeUnit.MILLISECONDS.convert((endTime - startTime), TimeUnit.NANOSECONDS) / 1000.0;

                    logger.info("Timed out on " + PageName + " after " + elapsedTimeInSeconds + " seconds");
                    return;
                }
            }
                    long endTime = System.nanoTime();
                    double elapsedTimeInSeconds = TimeUnit.MILLISECONDS.convert((endTime - startTime), TimeUnit.NANOSECONDS) / 1000.0;

                    logger.info("TOTAL TIME that the " + PageName + " web-element was loading: " + elapsedTimeInSeconds + " seconds.");

                   // return;


        } catch (Exception e) {
            logger.error("Unable to implement waiting algorithm in the 'waitTillElementDetected' method!");
        }

    }


    public static void waitTillDescendentElementsAvailable(int maxSeconds, String XPath, String PageName) throws Exception {
        long startTime = System.nanoTime();
        int secondsCounter = 0;
        int elementListSize = 0;

        for (int i = 1; i <= maxSeconds; i++) {

            //Select the parent web element
            List<WebElement> elm = driver.findElements(By.xpath(XPath));

            if (elm.size() == 0) { //wait 1 second if no elements were found
                Thread.sleep(1000);
                secondsCounter++;

                if (secondsCounter == maxSeconds) {//stop waiting when maximum allowed time is exceeded
                    logger.info("Timed out on " + PageName + " after " + maxSeconds + " seconds");
                    break;
                }

            } else {
                if (elm.size() != elementListSize) { //if more elements were found after waiting yet another 1 second then continue waiting till no more new elements found
                    Thread.sleep(1000);
                    elementListSize = elm.size();
                    secondsCounter++;

                    if (secondsCounter == maxSeconds) {
                        logger.info("Timed out on " + PageName + " after " + maxSeconds + " seconds");
                        break;
                    }
                } else {
                    long endTime = System.nanoTime();
                    double elapsedTimeInSeconds = TimeUnit.MILLISECONDS.convert((endTime - startTime), TimeUnit.NANOSECONDS) / 1000.0;

                    //logger.info ("TOTAL TIME that the " + PageName + " page was loading: " + elapsedTimeInSeconds + " seconds.");
                    //System.out.println("TOTAL TIME that the " + PageName + " page was loading: " + elapsedTimeInSeconds + " seconds.");
                    logger.info("TOTAL TIME that the " + PageName + " page was loading: " + elapsedTimeInSeconds + " seconds.");
                    //System.out.println("elm.size() =" + elm.size());
                    //System.out.println("elementListSize =" + elementListSize);
                    return;
                }
            }

        }
        throw new RuntimeException("Unable to implement waiting algorithm in the 'waitTillDescendentElementsAvailable' method!");
    }


    public static void waitTillElementDetectedByStyle(int maxSeconds, String XPath, String elmntAttribute, String elmAttributeValue, String PageName) throws Exception {
        long startTime = System.nanoTime();
        int secondsCounter = 0;
        boolean statusField = false;

        for (int i = 1; i <= maxSeconds; i++) {

            //Select the parent web element
            WebElement elm = driver.findElement(By.xpath(XPath));
            String statusIndicator = elm.getCssValue(elmntAttribute);

            //if detected value of the web-element's attribute is not the same as the expected one then wait 1 second more
            if (!statusIndicator.contains(elmAttributeValue)) {
                Thread.sleep(1000);
                secondsCounter++;

                if (secondsCounter == maxSeconds) {
                    logger.info("Timed out on " + PageName + " after " + maxSeconds + " seconds");
                    break;
                }
            } else {
                long endTime = System.nanoTime();
                double elapsedTimeInSeconds = TimeUnit.MILLISECONDS.convert((endTime - startTime), TimeUnit.NANOSECONDS) / 1000.0;

                logger.info("TOTAL TIME that the " + PageName + " web-element was loading: " + elapsedTimeInSeconds + " seconds.");

                return;
            }
        }
        throw new RuntimeException("Unable to implement waiting algorithm in the 'waitTillDescendentElementsAvailable' method!");
    }


    public static void waitTillElementDetectedByProperty(int maxSeconds, String XPath, String elmntAttribute, String elmAttributeValue, String PageName) throws Exception {
        long startTime = System.nanoTime();
        int secondsCounter = 0;
        boolean statusField = false;

        for (int i = 1; i <= maxSeconds; i++) {

            //Select the parent web element
            WebElement elm = driver.findElement(By.xpath(XPath));
            String statusIndicator = elm.getAttribute(elmntAttribute);

            //if detected value of the web-element's attribute is not the same as the expected one then wait 1 second more
            if (!statusIndicator.contains(elmAttributeValue)) {
                Thread.sleep(1000);
                secondsCounter++;

                if (secondsCounter == maxSeconds) {
                    logger.info("Timed out on " + PageName + " after " + maxSeconds + " seconds");
                    break;
                }
            } else {
                long endTime = System.nanoTime();
                double elapsedTimeInSeconds = TimeUnit.MILLISECONDS.convert((endTime - startTime), TimeUnit.NANOSECONDS) / 1000.0;

                logger.info("TOTAL TIME that the " + PageName + " web-element was loading: " + elapsedTimeInSeconds + " seconds.");

                return;
            }
        }
        throw new RuntimeException("Unable to implement waiting algorithm in the 'waitTillDescendentElementsAvailable' method!");
    }


    public static void waitTillPredefinedDescendentElements(int maxSeconds, String xPath, String pageName, Integer elNumber) throws Exception {
        long startTime = System.nanoTime();
        int secondsCounter = 0;

        for (int i = 1; i <= maxSeconds; i++) {

            //Select the parent web element
            List<WebElement> elm = driver.findElements(By.xpath(xPath));
            System.out.println("Number of input fields in HEADER DATA table: " + elm.size());

            if (elm.size() == 0 || elm.size() != elNumber) {
                Thread.sleep(1000);
                secondsCounter++;

                if (secondsCounter == maxSeconds) {
                    logger.info("Timed out on " + pageName + " after " + maxSeconds + " seconds");
                    break;
                }

            } else {
                long endTime = System.nanoTime();
                double elapsedTimeInSeconds = TimeUnit.MILLISECONDS.convert((endTime - startTime), TimeUnit.NANOSECONDS) / 1000.0;

                //logger.info ("TOTAL TIME that the " + PageName + " page was loading: " + elapsedTimeInSeconds + " seconds.");
                //System.out.println("TOTAL TIME that the " + PageName + " page was loading: " + elapsedTimeInSeconds + " seconds.");
                logger.info("TOTAL TIME that the " + pageName + " page was loading: " + elapsedTimeInSeconds + " seconds.");
                return;
            }

        }
        throw new RuntimeException("Unable to implement waiting algorithm in the 'waitTillDescendentElementsAvailable' method!");
    }


    public static void waitTillWebElementAvailable(int maxSeconds, WebElement el, String PageName) throws Exception {

        WebDriverWait wait = new WebDriverWait(driver, maxSeconds); // seconds

        long startTime = System.nanoTime();

        try {

            wait.until(ExpectedConditions.visibilityOf(el));

            long endTime = System.nanoTime();
            double elapsedTimeInSeconds = TimeUnit.MILLISECONDS.convert((endTime - startTime), TimeUnit.NANOSECONDS) / 1000.0;

            logger.info("TOTAL TIME that " + PageName + " page was loading: " + elapsedTimeInSeconds + " seconds.");
            return;


        } catch (NoSuchElementException e) {
            logger.error(PageName + " page has timed out after " + maxSeconds + " seconds because specified WebElement was not detected: " + e);

        } catch (TimeoutException e) {
            logger.error(PageName + " page has timed out after " + maxSeconds + " seconds: " + e);

        }

        throw new RuntimeException("Unable to implement waiting algorithm in the 'waitTillWebElementsAvailable' method!");
    }


    public static void explicitWaitsUntilElementPresent(int maxSeconds, String elementXPath, String PageName) throws Exception {

        WebDriverWait wait = new WebDriverWait(driver, maxSeconds); // seconds

        long startTime = System.nanoTime();

        try {

            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(elementXPath)));

            long endTime = System.nanoTime();
            double elapsedTimeInSeconds = TimeUnit.MILLISECONDS.convert((endTime - startTime), TimeUnit.NANOSECONDS) / 1000.0;

            logger.info("TOTAL TIME that " + PageName + " page was loading: " + elapsedTimeInSeconds + " seconds.");
            return;


        } catch (NoSuchElementException e) {
            logger.error(PageName + " page has timed out after " + maxSeconds + " seconds because specified WebElement was not detected: " + e);

        } catch (TimeoutException e) {
            logger.error(PageName + " page has timed out after " + maxSeconds + " seconds: " + e);

        }

        throw new RuntimeException("Unable to implement waiting algorithm in the 'explicitWaitsUntilElementPresent' method!");
    }


    public static void waitForExtAjaxIsReadyState(int maxSeconds, String PageName) throws Exception {
        boolean is_ajax_complete = false;
        long startTime = System.nanoTime();

        for (int i = 1; i <= maxSeconds; i++) {

            is_ajax_complete = (boolean) ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            if (is_ajax_complete) {

                long endTime = System.nanoTime();
                double elapsedTimeInSeconds = TimeUnit.MILLISECONDS.convert((endTime - startTime), TimeUnit.NANOSECONDS) / 1000.0;
                logger.info("TOTAL TIME that the " + PageName + " page was loading: " + elapsedTimeInSeconds + " seconds.");

                return;
            }
            Thread.sleep(1000);
        }
        throw new RuntimeException("Timed out on " + PageName + " after " + maxSeconds + " seconds");

    }

    public static void waitForExtAjaxIsLoading(int maxSeconds, String PageName) throws Exception {
        boolean is_ajax_complete = false;
        long startTime = System.nanoTime();

        for (int i = 1; i <= maxSeconds; i++) {

            is_ajax_complete = (boolean) ((JavascriptExecutor) driver).executeScript("return !Ext.Ajax.isLoading();");
            if (is_ajax_complete) {

                long endTime = System.nanoTime();
                double elapsedTimeInSeconds = TimeUnit.MILLISECONDS.convert((endTime - startTime), TimeUnit.NANOSECONDS) / 1000.0;
                logger.info("TOTAL TIME that the " + PageName + " page was loading: " + elapsedTimeInSeconds + " seconds.");

                return;
            }
            Thread.sleep(1000);
        }
        throw new RuntimeException("Timed out on " + PageName + " after " + maxSeconds + " seconds");
    }


    public static void waitTillWebElementsDisapper(int maxSeconds, String xPath, String PageName) throws Exception {

        long startTime = System.nanoTime();
        int secondsCounter = 0;

        for (int i = 1; i <= maxSeconds; i++) {

            List<WebElement> gg = driver.findElements(By.xpath(xPath));
            System.out.println("WAITING DESCENDANTS: " + gg.size());


            if (!driver.findElements(By.xpath(xPath)).isEmpty()) {
                Thread.sleep(1000);
                secondsCounter++;

                if (secondsCounter == maxSeconds) {
                    logger.info("Timed out on " + PageName + " after " + maxSeconds + " seconds");
                    break;
                }

            } else {
                long endTime = System.nanoTime();
                double elapsedTimeInSeconds = TimeUnit.MILLISECONDS.convert((endTime - startTime), TimeUnit.NANOSECONDS) / 1000.0;

                //logger.info ("TOTAL TIME that the " + PageName + " page was loading: " + elapsedTimeInSeconds + " seconds.");
                //System.out.println("TOTAL TIME that the " + PageName + " page was loading: " + elapsedTimeInSeconds + " seconds.");
                logger.info("TOTAL TIME that the " + PageName + " was unloading: " + elapsedTimeInSeconds + " seconds.");
                return;
            }

        }
        throw new RuntimeException("Unable to implement waiting algorithm in the 'waitTillDescendentElementsAvailable' method!");
    }


    public static void waitTillWebElementEscapes(int maxSeconds, String singleElementxPath, String PageName) throws Exception {

        long startTime = System.nanoTime();
        int secondsCounter = 0;

        for (int i = 1; i <= maxSeconds; i++) {
            try {
                if (driver.findElement(By.xpath(singleElementxPath)) != null) {
                    Thread.sleep(1000);
                    secondsCounter++;

                    if (secondsCounter == maxSeconds) {
                        logger.error("Timed out on " + PageName + " after " + maxSeconds + " seconds: element did not escape.");
                        break;
                    }
                }
            } catch (Exception e) {
                long endTime = System.nanoTime();
                double elapsedTimeInSeconds = TimeUnit.MILLISECONDS.convert((endTime - startTime), TimeUnit.NANOSECONDS) / 1000.0;

                logger.info("TOTAL TIME that the " + PageName + " was unloading: " + elapsedTimeInSeconds + " seconds.");
                return;
            }
        }
    }

    public static void waitTillWebElementChangesInitialProperty(int maxSeconds, String singleElementxPath, String initialProperty, String PageName) throws Exception {

        long startTime = System.nanoTime();
        int secondsCounter = 0;

        String elm_Attribite = "";

        for (int i = 1; i <= maxSeconds; i++) {
            //try {
            elm_Attribite = driver.findElement(By.xpath(singleElementxPath)).getAttribute("class");

            if (elm_Attribite.contains(initialProperty)) {
                Thread.sleep(1000);
                secondsCounter++;

                if (secondsCounter == maxSeconds) {
                    logger.error("Timed out on " + PageName + " after " + maxSeconds + " seconds: element did not change its status.");
                    break;
                }
            } else {

                long endTime = System.nanoTime();
                double elapsedTimeInSeconds = TimeUnit.MILLISECONDS.convert((endTime - startTime), TimeUnit.NANOSECONDS) / 1000.0;

                logger.info("TOTAL TIME that the " + PageName + " was observed for changing its status: " + elapsedTimeInSeconds + " seconds.");
                return;
            }
        }
        throw new RuntimeException("Timed out on " + PageName + " after " + maxSeconds + " seconds");
    }

}
