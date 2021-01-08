package com.pages;

import init.settings.PageObject;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.project.Test_Cases;

import java.util.List;

import static ax.generic.Waitings.*;

public class Locator_DocCompare extends PageObject {

    public Logger logger = Logger.getLogger(Locator_DocCompare.class);

    //Locating "Locator" button's container
    //OFQ//@FindBy(xpath = "//div[@class='lsPageHeader--item urPgHITrans']/table[@class='lsToolbar--overflow urTWhlFlat lsTItmOvflFlat urHtmlTableReset urTBar lsToolbar']/tbody/tr/td[1]/div[@class='lsTbarOvfl']/span[6]/div")
    @FindBy(xpath = "//div[@class='lsPageHeader--item urPgHITrans']/div/div[1]/descendant::div[contains (@title, 'Locator On/Off')]")
    private WebElement btn_LocatorContainer;

    //Locating "Locator" button in the toolbar
    @FindBy(xpath = "//span[contains(text(), 'Locator')]")
    private WebElement btn_Locator;

    //Locating "Document Number" dropdown in "Locator" panel
    @FindBy(xpath = "//span[contains (text(), 'Search Criteria')]/ancestor::table[@class='lsPanel urHtmlTableReset']/tbody/tr[2]/td/div/table/tbody/tr[3]/td[1]/table/tbody/tr/td[1]/input")
    private WebElement dropdown_DocNumber;

    //Locating "Document Number" value in the "Document Number" dropdown
    //OFQ//@FindBy(xpath = "//div[contains (@class, 'lsListbox__value')][contains (text(), 'Document Number')]")
    @FindBy(xpath = "//div[contains (@id, 'sapwd_main_window_root_-asso')]/descendant::div[contains (@class, 'lsLCDropShadow')]/descendant::*[contains (text(), 'Document Number')]")
    private WebElement dropdown_DocNumber_value;

    //Locating "Condition" dropdown in "Locator" panel
   /* @FindBy(xpath = "//span[contains (text(), 'Search Criteria')]/ancestor::table[@class='lsPanel urHtmlTableReset']/tbody/tr[2]/td/div/table/tbody/tr[3]/td[2]/table/tbody/tr/td[1]/input")
    private WebElement dropdown_Condition;*/

    //Locating "Is between" value in the "Condition" dropdown
    //OFQ//@FindBy(xpath = "//div[contains (@class, 'lsListbox__value')][contains (text(), 'is between')]")
   /* @FindBy(xpath = "//div[contains (@id, 'sapwd_main_window_root_-asso')]/descendant::div[contains (@class, 'lsLCDropShadow')]/descendant::*[contains (text(), 'is between')]")
    private WebElement dropdown_Condition_value;*/

    //Locating "Locator" panel
    @FindBy(xpath = "//span[contains (text(), 'Locator')]/ancestor::td[@class='urSpTPTD'][1]")
    private WebElement panel_Locator;

    //Locating "Document FROM" input
    @FindBy(xpath = "//span[contains (text(), 'Search Criteria')]/ancestor::table[@class='lsPanel urHtmlTableReset']/tbody/tr[2]/td/div/table/tbody/tr[3]/td[3]/table/tbody/tr/td[1]/input")
    private WebElement input_DocumentFROM;

    //Locating "Document TO" input
    @FindBy(xpath = "//span[contains (text(), 'Search Criteria')]/ancestor::table[@class='lsPanel urHtmlTableReset']/tbody/tr[2]/td/div/table/tbody/tr[3]/td[4]/table/tbody/tr/td/div/table/tbody/tr/td[2]/table/tbody/tr/td/input")
    //@FindBy(xpath = "//td[contains (@ct, 'MLC')][contains (@class, 'lsContainerCell lsContainerCellVAlign--top urLayoutLRNoPad')]/table[contains (@class, 'urEdf2WhlTbl')]/descendant::input[contains (@class, 'urEdf2TxtEnbl urEdf2TxtRadius urBorderBox lsControl--explicitwidth')][contains (@title, 'Document Number- Upper Interval Limit')]")
    private WebElement input_DocumentTO;

    //Locating "Search" button
    //@FindBy(xpath = "//span[contains (text(), 'Search Criteria')]/ancestor::table[@class='lsPanel urHtmlTableReset']/tbody/tr[2]/td/div/table/tbody/tr[10]/td[1]/div/div/table/tbody/tr[2]/td[1]/div/span/span[1]/div/span/span[contains(@title, 'Search ')]")
    @FindBy(xpath = "//span[contains (text(), 'Search Criteria')]/ancestor::table[@class='lsPanel urHtmlTableReset']/descendant::div[contains(@title, 'Search')]")
    private WebElement btn_Search;

    //Locating "Personalize" button on "Localization" panel
    @FindBy(xpath = "//span[contains (text(), 'Results List: 0 Documents')]/ancestor::table[contains (@class, 'urSTCS urST3WhlBrdH urST3WhlNoTit urST5SelColUiGeneric urHtmlTableReset')][contains (@ct, 'STCS')]/thead/tr[2]/descendant::div[contains (@title, 'Personalize ')]")
    private WebElement btn_Personalize_LocatorPnl;

    //Locating "Set to Default" button on "Personalization" popup for "Locator" panel
    @FindBy(xpath = "//div[contains (text(), 'Personalization')]/ancestor::div[contains (@class, 'urPWOuterBorder lsPopupWindow lsPopupWindow--dialog')][contains (@ct, 'PW')]/div/div[4][contains (@class, 'sapContrast sapContrastPlus lsTwhlFooter lsTbarLarge urPWFooterBottomLine')]/descendant::span[contains (text(), 'Reset to Default')]/ancestor::div[1]")
    private WebElement btn_SetToDefault_Persnlzd_Locator;


    //Constructor
    public Locator_DocCompare(WebDriver driver) {
        super(driver);

    }

    JavascriptExecutor js = (JavascriptExecutor) driver;
    Actions action = new Actions(driver);

    String docStatus_Row1 = "";
    String docStatus_Row2 = "";
    String docNumber_Row1 = "";
    String docNumber_Row2 = "";



    public void fillout_SearchCriteria_FailedAutoRefresh() {

        try {
            String document_Number = dropdown_DocNumber.getAttribute("value");
            System.out.println("DOCUMENT NUMBER dropdown value: " + document_Number);

            //check whether "Document Number" is selected by default in the first input field - if not set it to "Document Number"
            if (!document_Number.contains("Document Number")) {

                //click on "Document Number" field to open its dropdown
                js.executeScript("arguments[0].click();", dropdown_DocNumber);
                //dropdown_DocNumber.click();

                //wait till the dropdown gets displayed
                //OFQ//explicitWaitsUntilElementPresent(15, "//div[contains (@class, 'lsListbox__value')][contains (text(), 'Document Number')]", "DOCUMENT NUMBER DROPDOWN");
                explicitWaitsUntilElementPresent(15, "//div[contains (@id, 'sapwd_main_window_root_-asso')]/descendant::div[contains (@class, 'lsLCDropShadow')]/descendant::*[contains (text(), 'Document Number')]", "DOCUMENT NUMBER DROPDOWN");

                //click to select "Document Number" value from the dropdown
                js.executeScript("arguments[0].click();", dropdown_DocNumber_value);
                //dropdown_DocNumber_value.click();

                logger.info("The 'DOCUMENT NUMBER' input has been changed to 'DOCUMENT NUMBER' value.");

            } else {
                logger.info("The 'DOCUMENT NUMBER' input has 'Document Number' value selected by default as expected.");
            }

            WebElement dropdown_Condition = driver.findElement(By.xpath("//span[contains (text(), 'Search Criteria')]/ancestor::table[@class='lsPanel urHtmlTableReset']/tbody/tr[2]/td/div/table/tbody/tr[3]/td[2]/table/tbody/tr/td[1]/input"));

            String document_Condition = dropdown_Condition.getAttribute("value");
            System.out.println("DOCUMENT CONDITION dropdown value: " + document_Condition);

            //check whether "Is between" is selected by default in the second input field - if not set it to "Is between"
            if (!document_Number.contains("is")) {

                //click on "Document Condition" field to open its dropdown
                //js.executeScript("arguments[0].click();", dropdown_Condition);
                //dropdown_Condition.click();
                action.moveToElement(dropdown_Condition).click().perform();

                //wait till the dropdown gets displayed
                //OFQ//explicitWaitsUntilElementPresent(15, "//div[contains (@class, 'lsListbox__value')][contains (text(), 'is between')]", "DOCUMENT CONDITION DROPDOWN");
                explicitWaitsUntilElementPresent(15, "//div[contains (@id, 'sapwd_main_window_root_-asso')]/descendant::div[contains (@class, 'lsLCDropShadow')]/descendant::*[contains (text(), 'is')]", "DOCUMENT CONDITION DROPDOWN");

                WebElement dropdown_Condition_value = driver.findElement(By.xpath("//div[contains (@id, 'sapwd_main_window_root_-asso')]/descendant::div[contains (@class, 'lsLCDropShadow')]/descendant::*[contains (text(), 'is')]"));

                //click to select "is" value from the "Condition" dropdown
                js.executeScript("arguments[0].click();", dropdown_Condition_value);
                //dropdown_Condition_value.click();

                logger.info("The 'DOCUMENT CONDITION' input has been changed to 'IS' value.");

            } else {
                logger.info("The 'DOCUMENT CONDITION' input has 'IS' value selected by default as expected.");
            }


            //check whether the "Document Number" input is not outside of the "Locator" panel
            bringElementIntoViewHorizontallyInLocatorPanel(input_DocumentFROM);

            //Click and fill in "Document Number" field
            js.executeScript("arguments[0].click();", input_DocumentFROM);
            //Thread.sleep(2000);
            input_DocumentFROM.clear();

            //increment current document number by 1
            Integer doc_reversed = Integer.valueOf(Test_Cases.doc_Num);
            Test_Cases.doc_Num = Integer.toString(doc_reversed + 1);


            input_DocumentFROM.sendKeys(Test_Cases.doc_Num);
            //input_DocumentFROM.sendKeys(Keys.RETURN);
            logger.info("DOCUMENT NUMBER input field is SUCCESSFULLY filled in with '" + Test_Cases.doc_Num + "'.");

        } catch (Exception e) {

            logger.error("Error while filling out SEARCH CRITERIA fields on LOCATOR panel: " + e.getMessage());

        }

    }

    public void click_LocatorBtn()  {

        try {
            js.executeScript("arguments[0].click();", btn_Locator);
            //action.click(btn_Check).build().perform();

            logger.info("The 'LOCATOR' button was SUCCESSFULLY clicked on.");

        } catch (Exception e) {
            logger.error("Unable to detect/click on 'LOCATOR' button: " + e.getMessage());
        }
    }


    public void select_Rows_PersnztnPopup_Locator(String title_Column, WebElement element_2) {

        try {

            if (Test_Cases.conf_SystemClient.equals("OFQ_100")) {

                WebElement scroller_DisplayedColumns = driver.findElement(By.xpath("//span[contains (text(), 'Displayed Columns')]/ancestor::table[contains (@class, 'urSTCS urST3WhlBrd urST3WhlNoTit urST5SelColUiGeneric urHtmlTableReset')]/tbody[1]/tr[2]/td[3]/div/table/tbody/tr[3]/td/div"));
                switch (title_Column) {

                    case "Document Status":
                    case "Document status":

                        WebElement input_Width_1 = element_2.findElement(By.xpath("td[2]/div"));

                        //action.moveToElement(input_Width_1).click().build().perform();
                        //js.executeScript("arguments[0].click();", input_Width_1);
                        input_Width_1.click();

                        logger.info("The 'Document Status' WIDTH field (on 'PERSONALIZATION' popup) was clicked for editing.");

                        waitTillWebElementAvailable(5, input_Width_1.findElement(By.xpath("span/input")), "'Document Number' WIDTH field");
                        Thread.sleep(500);

                        WebElement input_Field_1 = input_Width_1.findElement(By.xpath("span/input"));

                        String valueSize = input_Field_1.getAttribute("title");
                        System.out.println("The size of 'DOCUMENT STATUS' cell is equeal to: " + valueSize);

                        if (!valueSize.equals("98")) {

                            input_Field_1.clear();
                            action.sendKeys(input_Field_1, "98").perform();
                            //input_Field_2.sendKeys("98");
                            //js.executeScript("arguments[0].value='98';", input_Field_2);
                            // Thread.sleep(1000);
                            // input_NetPrice_input.sendKeys(Keys.ENTER);
                            logger.info("Width for DOCUMENT STATUS input field was SUCCESSFULLY changed.");


                            //Check availability of 'Fixed' check-mark
                            WebElement check_mark_1 = element_2.findElement(By.xpath("td[3]/div/span"));

                            String valueClass = check_mark_1.getAttribute("class");
                            System.out.println("The class value for " + title_Column + " check-box is: " + valueClass);

                            if (valueClass.contains("lsCheckBox--checked")) {//if not selected then click on it to select it
                                js.executeScript("arguments[0].click();", check_mark_1);
                                logger.info("DOCUMENT STATUS input field was clicked to be unselected in the FIXED column.");
                            } else {
                                logger.info("DOCUMENT STATUS input field was unselected in the FIXED column BY DEFAULT.");
                            }
                        }

                        //click vertical scroller to move the list one row up
                        // action.click(scroller_DisplayedColumns).perform();
                        js.executeScript("arguments[0].click();", scroller_DisplayedColumns);

                        break;

                    case "Document Number":
                    case "Document number":

                        WebElement input_Width_2 = element_2.findElement(By.xpath("td[2]/div"));

                        //action.moveToElement(input_Width_1).click().build().perform();
                        //js.executeScript("arguments[0].click();", input_Width_1);
                        input_Width_2.click();

                        logger.info("The 'Document Number' WIDTH field (on 'PERSONALIZATION' popup) was clicked for editing.");

                        waitTillWebElementAvailable(5, input_Width_2.findElement(By.xpath("span/input")), "'Document Number' WIDTH field");
                        Thread.sleep(500);

                        WebElement input_Field_2 = input_Width_2.findElement(By.xpath("span/input"));
                        input_Field_2.clear();
                        action.sendKeys(input_Field_2, "112").perform();
                        //input_Field_2.sendKeys("98");
                        //js.executeScript("arguments[0].value='98';", input_Field_2);
                        // Thread.sleep(1000);
                        // input_NetPrice_input.sendKeys(Keys.ENTER);
                        logger.info("Width for DOCUMENT NUMBER input field was SUCCESSFULLY changed.");


                        //Check availability of 'Fixed' check-mark
                        WebElement check_mark_2 = element_2.findElement(By.xpath("td[3]/div/span"));

                        String valueClass2 = check_mark_2.getAttribute("class");
                        System.out.println("The class value for " + title_Column + " check-box is: " + valueClass2);

                        if (valueClass2.contains("lsCheckBox--checked")) {//if not selected then click on it to select it
                            js.executeScript("arguments[0].click();", check_mark_2);
                            logger.info("DOCUMENT NUMBER input field was clicked to be unselected in the FIXED column.");
                        } else {
                            logger.info("DOCUMENT NUMBER input field was unselected in the FIXED column BY DEFAULT.");
                        }

                        //click vertical scroller to move the list one row up
                        // action.click(scroller_DisplayedColumns).perform();
                        js.executeScript("arguments[0].click();", scroller_DisplayedColumns);

                        break;

                    case "Created on":
                    case "Created On":

                        WebElement input_Width_4 = element_2.findElement(By.xpath("td[2]/div"));

                        //action.moveToElement(input_Width_1).click().build().perform();
                        //js.executeScript("arguments[0].click();", input_Width_1);
                        input_Width_4.click();

                        logger.info("The 'Created on' WIDTH field (on 'PERSONALIZATION' popup) was clicked for editing.");

                        waitTillWebElementAvailable(5, input_Width_4.findElement(By.xpath("span/input")), "'Created on' WIDTH field");
                        Thread.sleep(500);

                        WebElement input_Field_4 = input_Width_4.findElement(By.xpath("span/input"));
                        input_Field_4.clear();
                        action.sendKeys(input_Field_4, "98").perform();
                        //input_NetPrice.sendKeys("10");
                        //js.executeScript("arguments[0].value='10,00';", input_NetPrice_input);
                        // Thread.sleep(1000);
                        // input_NetPrice_input.sendKeys(Keys.ENTER);
                        logger.info("Width for CREATED ON input field was SUCCESSFULLY changed.");


                        //Check availability of 'Fixed' check-mark
                        WebElement check_mark_4 = element_2.findElement(By.xpath("td[3]/div/span"));

                        String valueClass4 = check_mark_4.getAttribute("class");
                        System.out.println("The class value for " + title_Column + " check-box is: " + valueClass4);

                        if (valueClass4.contains("lsCheckBox--checked")) {//if not selected then click on it to select it
                            js.executeScript("arguments[0].click();", check_mark_4);
                            logger.info("CREATED ON input field was clicked to be unselected in the FIXED column.");
                        } else {
                            logger.info("CREATED ON input field was unselected in the FIXED column BY DEFAULT.");
                        }

                        //click vertical scroller to move the list one row up
                        //action.click(scroller_DisplayedColumns).perform();
                        js.executeScript("arguments[0].click();", scroller_DisplayedColumns);

                        break;


                    case "Created by":
                    case "Created By":

                        WebElement input_Width_5 = element_2.findElement(By.xpath("td[2]/div"));

                        //action.moveToElement(input_Width_1).click().build().perform();
                        //js.executeScript("arguments[0].click();", input_Width_1);
                        input_Width_5.click();

                        logger.info("The 'Created by' WIDTH field (on 'PERSONALIZATION' popup) was clicked for editing.");

                        waitTillWebElementAvailable(5, input_Width_5.findElement(By.xpath("span/input")), "'Created by' WIDTH field");
                        Thread.sleep(500);

                        WebElement input_Field_5 = input_Width_5.findElement(By.xpath("span/input"));
                        input_Field_5.clear();
                        action.sendKeys(input_Field_5, "84").perform();
                        //input_NetPrice.sendKeys("10");
                        //js.executeScript("arguments[0].value='10,00';", input_NetPrice_input);
                        // Thread.sleep(1000);
                        // input_NetPrice_input.sendKeys(Keys.ENTER);
                        logger.info("Width for CREATED BY input field was SUCCESSFULLY changed.");


                        //Check availability of 'Fixed' check-mark
                        WebElement check_mark_5 = element_2.findElement(By.xpath("td[3]/div/span"));

                        String valueClass5 = check_mark_5.getAttribute("class");
                        System.out.println("The class value for " + title_Column + " check-box is: " + valueClass5);

                        if (valueClass5.contains("lsCheckBox--checked")) {//if not selected then click on it to select it
                            js.executeScript("arguments[0].click();", check_mark_5);
                            logger.info("CREATED BY input field was clicked to be unselected in the FIXED column.");
                        } else {
                            logger.info("CREATED BY input field was unselected in the FIXED column BY DEFAULT.");
                        }

                        //click vertical scroller to move the list one row up
                        //action.click(scroller_DisplayedColumns).perform();
                        js.executeScript("arguments[0].click();", scroller_DisplayedColumns);

                        break;


                    case "Changed On":
                    case "Changed on":

                        WebElement input_Width_6 = element_2.findElement(By.xpath("td[2]/div"));

                        //action.moveToElement(input_Width_1).click().build().perform();
                        //js.executeScript("arguments[0].click();", input_Width_1);
                        input_Width_6.click();

                        logger.info("The 'Changed On' WIDTH field (on 'PERSONALIZATION' popup) was clicked for editing.");

                        waitTillWebElementAvailable(5, input_Width_6.findElement(By.xpath("span/input")), "'Changed On' WIDTH field");
                        Thread.sleep(500);

                        WebElement input_Field_6 = input_Width_6.findElement(By.xpath("span/input"));
                        input_Field_6.clear();
                        action.sendKeys(input_Field_6, "96").perform();
                        //input_NetPrice.sendKeys("10");
                        //js.executeScript("arguments[0].value='10,00';", input_NetPrice_input);
                        // Thread.sleep(1000);
                        // input_NetPrice_input.sendKeys(Keys.ENTER);
                        logger.info("Width for CHANGED ON input field was SUCCESSFULLY changed.");


                        //Check availability of 'Fixed' check-mark
                        WebElement check_mark_6 = element_2.findElement(By.xpath("td[3]/div/span"));

                        String valueClass6 = check_mark_6.getAttribute("class");
                        System.out.println("The class value for " + title_Column + " check-box is: " + valueClass6);

                        if (valueClass6.contains("lsCheckBox--checked")) {//if not selected then click on it to select it
                            js.executeScript("arguments[0].click();", check_mark_6);
                            logger.info("CHANGED ON input field was clicked to be unselected in the FIXED column.");
                        } else {
                            logger.info("CHANGED ON input field was unselected in the FIXED column BY DEFAULT.");
                        }

                        //click vertical scroller to move the list one row up
                        //action.click(scroller_DisplayedColumns).perform();
                        js.executeScript("arguments[0].click();", scroller_DisplayedColumns);

                        break;


                    case "Changed by":
                    case "Changed By":

                        WebElement input_Width_7 = element_2.findElement(By.xpath("td[2]/div"));

                        //action.moveToElement(input_Width_1).click().build().perform();
                        //js.executeScript("arguments[0].click();", input_Width_1);
                        input_Width_7.click();

                        logger.info("The 'Changed by' WIDTH field (on 'PERSONALIZATION' popup) was clicked for editing.");

                        waitTillWebElementAvailable(5, input_Width_7.findElement(By.xpath("span/input")), "'Changed by' WIDTH field");
                        Thread.sleep(500);

                        WebElement input_Field_7 = input_Width_7.findElement(By.xpath("span/input"));
                        input_Field_7.clear();
                        // action.sendKeys(input_Field_7, "96").perform();
                        input_Field_7.sendKeys("96");
                        //js.executeScript("arguments[0].value='10,00';", input_NetPrice_input);
                        // Thread.sleep(1000);
                        input_Field_7.sendKeys(Keys.TAB);
                        logger.info("Width for CHANGED BY input field was SUCCESSFULLY changed.");


                        //Check availability of 'Fixed' check-mark
                        WebElement check_mark_7 = element_2.findElement(By.xpath("td[3]/div/span"));

                        String valueClass7 = check_mark_7.getAttribute("class");
                        System.out.println("The class value for " + title_Column + " check-box is: " + valueClass7);

                        if (valueClass7.contains("lsCheckBox--checked")) {//if not selected then click on it to select it
                            js.executeScript("arguments[0].click();", check_mark_7);
                            logger.info("CHANGED BY input field was clicked to be unselected in the FIXED column.");
                        } else {
                            logger.info("CHANGED BY input field was unselected in the FIXED column BY DEFAULT.");
                        }

                        //click vertical scroller to move the list one row up
                        //action.click(scroller_DisplayedColumns).perform();
                        //js.executeScript("arguments[0].click();", scroller_DisplayedColumns);

                        break;


                    default:
                }
            }

            if (Test_Cases.conf_SystemClient.equals("OGQ_100")) {

                WebElement scroller_DisplayedColumns = driver.findElement(By.xpath("//span[contains (text(), 'Displayed Columns')]/ancestor::table[contains (@class, 'urSTCS urST3WhlBrd urST3WhlNoTit urST5SelColUiGeneric urHtmlTableReset')]/tbody[1]/tr[2]/td[3]/div/table/tbody/tr[3]/td/div"));
                switch (title_Column) {

                    case "Document Status":
                    case "Document status":

                        WebElement input_Width_1 = element_2.findElement(By.xpath("td[2]/div"));

                        //action.moveToElement(input_Width_1).click().build().perform();
                        //js.executeScript("arguments[0].click();", input_Width_1);
                        input_Width_1.click();

                        logger.info("The 'Document Status' WIDTH field (on 'PERSONALIZATION' popup) was clicked for editing.");

                        waitTillWebElementAvailable(5, input_Width_1.findElement(By.xpath("span/input")), "'Document Number' WIDTH field");
                        Thread.sleep(500);

                        WebElement input_Field_1 = input_Width_1.findElement(By.xpath("span/input"));

                        String valueSize = input_Field_1.getAttribute("title");
                        System.out.println("The size of 'DOCUMENT STATUS' cell is equal to: " + valueSize);

                        if (!valueSize.equals("98")) {

                            input_Field_1.clear();
                            action.sendKeys(input_Field_1, "98").perform();
                            //input_Field_2.sendKeys("98");
                            //js.executeScript("arguments[0].value='98';", input_Field_2);
                            // Thread.sleep(1000);
                            // input_NetPrice_input.sendKeys(Keys.ENTER);
                            logger.info("Width for DOCUMENT STATUS input field was SUCCESSFULLY changed.");


                            //Check availability of 'Fixed' check-mark
                            WebElement check_mark_1 = element_2.findElement(By.xpath("td[3]/div/span/input"));

                            if (check_mark_1.isSelected()) {//if not selected then click on it to select it
                                js.executeScript("arguments[0].click();", check_mark_1);
                                logger.info("DOCUMENT STATUS input field was clicked to be unselected in the FIXED column.");
                            } else {
                                logger.info("DOCUMENT STATUS input field was unselected in the FIXED column BY DEFAULT.");
                            }
                        }

                        //click vertical scroller to move the list one row up
                        // action.click(scroller_DisplayedColumns).perform();
                        js.executeScript("arguments[0].click();", scroller_DisplayedColumns);

                        break;

                    case "Document Number":
                    case "Document number":

                        WebElement input_Width_2 = element_2.findElement(By.xpath("td[2]/div"));

                        //action.moveToElement(input_Width_1).click().build().perform();
                        //js.executeScript("arguments[0].click();", input_Width_1);
                        input_Width_2.click();

                        logger.info("The 'Document Number' WIDTH field (on 'PERSONALIZATION' popup) was clicked for editing.");

                        waitTillWebElementAvailable(5, input_Width_2.findElement(By.xpath("span/input")), "'Document Number' WIDTH field");
                        Thread.sleep(500);

                        WebElement input_Field_2 = input_Width_2.findElement(By.xpath("span/input"));
                        input_Field_2.clear();
                        action.sendKeys(input_Field_2, "112").perform();
                        //input_Field_2.sendKeys("98");
                        //js.executeScript("arguments[0].value='98';", input_Field_2);
                        // Thread.sleep(1000);
                        // input_NetPrice_input.sendKeys(Keys.ENTER);
                        logger.info("Width for DOCUMENT NUMBER input field was SUCCESSFULLY changed.");


                        //Check availability of 'Fixed' check-mark
                        WebElement check_mark_2 = element_2.findElement(By.xpath("td[3]/div/span/input"));

                        if (check_mark_2.isSelected()) {//if not selected then click on it to select it
                            js.executeScript("arguments[0].click();", check_mark_2);
                            logger.info("DOCUMENT NUMBER input field was clicked to be unselected in the FIXED column.");
                        } else {
                            logger.info("DOCUMENT NUMBER input field was unselected in the FIXED column BY DEFAULT.");
                        }

                        //click vertical scroller to move the list one row up
                        // action.click(scroller_DisplayedColumns).perform();
                        js.executeScript("arguments[0].click();", scroller_DisplayedColumns);

                        break;

                    case "Created On":
                    case "Created on":

                        WebElement input_Width_4 = element_2.findElement(By.xpath("td[2]/div"));

                        //action.moveToElement(input_Width_1).click().build().perform();
                        //js.executeScript("arguments[0].click();", input_Width_1);
                        input_Width_4.click();

                        logger.info("The 'Created on' WIDTH field (on 'PERSONALIZATION' popup) was clicked for editing.");

                        waitTillWebElementAvailable(5, input_Width_4.findElement(By.xpath("span/input")), "'Created on' WIDTH field");
                        Thread.sleep(500);

                        WebElement input_Field_4 = input_Width_4.findElement(By.xpath("span/input"));
                        input_Field_4.clear();
                        action.sendKeys(input_Field_4, "98").perform();
                        //input_NetPrice.sendKeys("10");
                        //js.executeScript("arguments[0].value='10,00';", input_NetPrice_input);
                        // Thread.sleep(1000);
                        // input_NetPrice_input.sendKeys(Keys.ENTER);
                        logger.info("Width for CREATED ON input field was SUCCESSFULLY changed.");


                        //Check availability of 'Fixed' check-mark
                        WebElement check_mark_4 = element_2.findElement(By.xpath("td[3]/div/span/input"));

                        if (check_mark_4.isSelected()) {//if not selected then click on it to select it
                            js.executeScript("arguments[0].click();", check_mark_4);
                            logger.info("CREATED ON input field was clicked to be unselected in the FIXED column.");
                        } else {
                            logger.info("CREATED ON input field was unselected in the FIXED column BY DEFAULT.");
                        }

                        //click vertical scroller to move the list one row up
                        //action.click(scroller_DisplayedColumns).perform();
                        js.executeScript("arguments[0].click();", scroller_DisplayedColumns);

                        break;


                    case "Created by":
                    case "Created By":

                        WebElement input_Width_5 = element_2.findElement(By.xpath("td[2]/div"));

                        //action.moveToElement(input_Width_1).click().build().perform();
                        //js.executeScript("arguments[0].click();", input_Width_1);
                        input_Width_5.click();

                        logger.info("The 'Created by' WIDTH field (on 'PERSONALIZATION' popup) was clicked for editing.");

                        waitTillWebElementAvailable(5, input_Width_5.findElement(By.xpath("span/input")), "'Created by' WIDTH field");
                        Thread.sleep(500);

                        WebElement input_Field_5 = input_Width_5.findElement(By.xpath("span/input"));
                        input_Field_5.clear();
                        action.sendKeys(input_Field_5, "84").perform();
                        //input_NetPrice.sendKeys("10");
                        //js.executeScript("arguments[0].value='10,00';", input_NetPrice_input);
                        // Thread.sleep(1000);
                        // input_NetPrice_input.sendKeys(Keys.ENTER);
                        logger.info("Width for CREATED BY input field was SUCCESSFULLY changed.");


                        //Check availability of 'Fixed' check-mark
                        WebElement check_mark_5 = element_2.findElement(By.xpath("td[3]/div/span/input"));

                        if (check_mark_5.isSelected()) {//if not selected then click on it to select it
                            js.executeScript("arguments[0].click();", check_mark_5);
                            logger.info("CREATED BY input field was clicked to be unselected in the FIXED column.");
                        } else {
                            logger.info("CREATED BY input field was unselected in the FIXED column BY DEFAULT.");
                        }

                        //click vertical scroller to move the list one row up
                        //action.click(scroller_DisplayedColumns).perform();
                        js.executeScript("arguments[0].click();", scroller_DisplayedColumns);

                        break;


                    case "Changed On":
                    case "Changed on":

                        WebElement input_Width_6 = element_2.findElement(By.xpath("td[2]/div"));

                        //action.moveToElement(input_Width_1).click().build().perform();
                        //js.executeScript("arguments[0].click();", input_Width_1);
                        input_Width_6.click();

                        logger.info("The 'Changed On' WIDTH field (on 'PERSONALIZATION' popup) was clicked for editing.");

                        waitTillWebElementAvailable(5, input_Width_6.findElement(By.xpath("span/input")), "'Changed On' WIDTH field");
                        Thread.sleep(500);

                        WebElement input_Field_6 = input_Width_6.findElement(By.xpath("span/input"));
                        input_Field_6.clear();
                        action.sendKeys(input_Field_6, "96").perform();
                        //input_NetPrice.sendKeys("10");
                        //js.executeScript("arguments[0].value='10,00';", input_NetPrice_input);
                        // Thread.sleep(1000);
                        // input_NetPrice_input.sendKeys(Keys.ENTER);
                        logger.info("Width for CHANGED ON input field was SUCCESSFULLY changed.");


                        //Check availability of 'Fixed' check-mark
                        WebElement check_mark_6 = element_2.findElement(By.xpath("td[3]/div/span/input"));

                        if (check_mark_6.isSelected()) {//if not selected then click on it to select it
                            js.executeScript("arguments[0].click();", check_mark_6);
                            logger.info("CHANGED ON input field was clicked to be unselected in the FIXED column.");
                        } else {
                            logger.info("CHANGED ON input field was unselected in the FIXED column BY DEFAULT.");
                        }

                        //click vertical scroller to move the list one row up
                        //action.click(scroller_DisplayedColumns).perform();
                        js.executeScript("arguments[0].click();", scroller_DisplayedColumns);

                        break;


                    case "Changed by":
                    case "Changed By":

                        WebElement input_Width_7 = element_2.findElement(By.xpath("td[2]/div"));

                        //action.moveToElement(input_Width_1).click().build().perform();
                        //js.executeScript("arguments[0].click();", input_Width_1);
                        input_Width_7.click();

                        logger.info("The 'Changed by' WIDTH field (on 'PERSONALIZATION' popup) was clicked for editing.");

                        waitTillWebElementAvailable(5, input_Width_7.findElement(By.xpath("span/input")), "'Changed by' WIDTH field");
                        Thread.sleep(500);

                        WebElement input_Field_7 = input_Width_7.findElement(By.xpath("span/input"));
                        input_Field_7.clear();
                        // action.sendKeys(input_Field_7, "96").perform();
                        input_Field_7.sendKeys("96");
                        //js.executeScript("arguments[0].value='10,00';", input_NetPrice_input);
                        // Thread.sleep(1000);
                        input_Field_7.sendKeys(Keys.TAB);
                        logger.info("Width for CHANGED BY input field was SUCCESSFULLY changed.");


                        //Check availability of 'Fixed' check-mark
                        WebElement check_mark_7 = element_2.findElement(By.xpath("td[3]/div/span/input"));

                        if (check_mark_7.isSelected()) {//if not selected then click on it to select it
                            js.executeScript("arguments[0].click();", check_mark_7);
                            logger.info("CHANGED BY input field was clicked to be unselected in the FIXED column.");
                        } else {
                            logger.info("CHANGED BY input field was unselected in the FIXED column BY DEFAULT.");
                        }

                        //click vertical scroller to move the list one row up
                        //action.click(scroller_DisplayedColumns).perform();
                        //js.executeScript("arguments[0].click();", scroller_DisplayedColumns);

                        break;


                    default:
                }
            }

        } catch (Exception e) {
            logger.error("Error while executing 'select_Rows' method: " + e.getMessage());
        }

    }


    public void set_WidthOfColumns_in_DisplayedColumns_Section_Persnlztn_Locator(){

        int TbodySection = 1;
        int numberOfDefaultTbodySections = 0;
        int numberOfUpdatedTbodySections = 0;


        try {

            driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@name,'URLSPW-0')]")));

            //check the number of TBODY elements displayed by default
            List<WebElement> initialNumberOfTBODY = driver.findElements(By.xpath("//span[contains (text(), 'Displayed Columns')]/ancestor::table[contains (@class, 'urSTCS urST3WhlBrd urST3WhlNoTit urST5SelColUiGeneric urHtmlTableReset')]/tbody[1][contains (@id, 'content')]/tr[2][contains (@vpm, 'mrss-cont')]/td[2]/div/div[2]/table/descendant::tbody"));
            numberOfDefaultTbodySections = initialNumberOfTBODY.size();

            while (TbodySection <= numberOfDefaultTbodySections) {

                WebElement elm_1_1 = driver.findElement(By.xpath("//span[contains (text(), 'Displayed Columns')]/ancestor::table[contains (@class, 'urSTCS urST3WhlBrd urST3WhlNoTit urST5SelColUiGeneric urHtmlTableReset')]/tbody[1][contains (@id, 'content')]/tr[2][contains (@vpm, 'mrss-cont')]/td[2]/div/div[2]/table/tbody[" + TbodySection + "]"));
                //System.out.println("Number of TBODY tags in 'DISPLAYED COLUMNS' section on PERSONALIZATION popup: " + elm_1.size());

                List<WebElement> elm_1_2 = elm_1_1.findElements(By.xpath("descendant::tr"));
                System.out.println("Number of TR tags in TBODY [" + TbodySection + "] tag in 'DISPLAYED COLUMNS' section on PERSONALIZATION popup: " + elm_1_2.size());

                for (WebElement element_1_3 : elm_1_2) {//loop through all <tr> tags in current <tbody> tag

                    WebElement row_Title = element_1_3.findElement(By.xpath("td[1]/div/descendant::span[contains (@ct, 'TV')]"));

                    String title = row_Title.getAttribute("innerText");
                    System.out.println("Row's title = " + title);

                    select_Rows_PersnztnPopup_Locator(title, element_1_3);

                    //check whether new TBODY got displayed dynamically
                    List<WebElement> newDynamicTBODY = driver.findElements(By.xpath("//span[contains (text(), 'Displayed Columns')]/ancestor::table[contains (@class, 'urSTCS urST3WhlBrd urST3WhlNoTit urST5SelColUiGeneric urHtmlTableReset')]/tbody[1][contains (@id, 'content')]/tr[2][contains (@vpm, 'mrss-cont')]/td[2]/div/div[2]/table/descendant::tbody"));
                    numberOfUpdatedTbodySections = newDynamicTBODY.size();

                    if (numberOfUpdatedTbodySections > numberOfDefaultTbodySections) {
                        numberOfDefaultTbodySections = numberOfUpdatedTbodySections;
                        System.out.println("Number of TBODY sections was dynamically updated to [" + numberOfUpdatedTbodySections + "]");

                    }
                }
                TbodySection++;
                System.out.println("Number of new dynamic TBODY tags in 'DISPLAYED COLUMNS' section on PERSONALIZATION popup: " + numberOfUpdatedTbodySections);

            }

            driver.switchTo().defaultContent();


        } catch (Exception e) {
            logger.warn("Unable to find/process TBODY [" + TbodySection + "] tag in 'DISPLAYED COLUMNS' section on PERSONALIZATION popup: " + e.getMessage());
        }

    }

    public void check_SetToDefaultBtn_PersonolizedPopup_LocatorPanel (){

        try {
            //check whether the "Set to Default" button is disabled or enabled.
            if (Test_Cases.conf_SystemClient.equals("OFQ_100")) {

                //When using an iframe, you will first have to switch to the iframe, before selecting the elements of that iframe.
                driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@name,'URLSPW-0')]")));

                WebElement btn_SetToDefault_Persnlzd_Locator = driver.findElement(By.xpath("//div[contains (text(), 'Settings')]/ancestor::div[contains (@class, 'urPWOuterBorder lsPopupWindow lsPopupWindow--dialog')][contains (@ct, 'PW')]/div/div[4][contains (@class, 'sapContrast sapContrastPlus lsTwhlFooter lsTbarLarge urPWFooterBottomLine')]/descendant::span[contains (text(), 'Reset to Default')]/ancestor::div[1]"));

                String btn_Status = btn_SetToDefault_Persnlzd_Locator.getAttribute("class");
                System.out.println("Class value for 'Set to Default' button: " + btn_Status);

                if (!btn_Status.contains("lsButton--disabled")) {//if the "Set to Default" button is enabled then click on it and wait/check that "Available Columns" section is empty

                    logger.info("The 'Set to Default' button (on 'PERSONALIZATION' popup) was detected to be ENABLED.");

                    //action.moveToElement(btn_New).click().build().perform();
                    js.executeScript("arguments[0].click();", btn_SetToDefault_Persnlzd_Locator);
                    //btn_New.click();

                    logger.info("The 'Set to Default' button (on 'PERSONALIZATION' popup) was clicked.");

                    //waitTillDescendentElementsLessThanExpected(10, "//span[contains (text(), 'Available Columns')]/ancestor::table[contains (@class, 'urSTCS urST3WhlBrd urST3WhlNoTit urST5SelColUiGeneric urHtmlTableReset')]/tbody[contains (@id, 'content')][1]/tr[2]/td[2]/div/div[2]/table/tbody/descendant::tr", "'AVAILABLE COLUMNS' with EMPTY RECORDS", 1);

                    //Exit iframe to have access to the main window's web-elements
                    driver.switchTo().defaultContent();

                    //wait till landing page is loaded again after closing "Personalization" popup
                    waitTillDescendentElementsAvailable(300, "//html/body/descendant::table", "DATA COLLATION PAGE after closing PERSONALIZATION popup on LOCATOR PANEL");
                    Thread.sleep(1000);

                    //re-open "Personolized" popup to customize WIDTH of the columns
                    click_PersonalizeBtn_LocatorPanel();

                }

                driver.switchTo().defaultContent();

            }

            if (Test_Cases.conf_SystemClient.equals("OGQ_100")) {
                //When using an iframe, you will first have to switch to the iframe, before selecting the elements of that iframe.
                driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@name,'URLSPW-0')]")));

                String btn_Status = btn_SetToDefault_Persnlzd_Locator.getAttribute("class");
                System.out.println("Class value for 'Set to Default' button: " + btn_Status);

                if (!btn_Status.contains("urBtnStdDsbl")) {//if the "Set to Default" button is enabled then click on it and wait/check that "Available Columns" section is empty

                    logger.info("The 'Set to Default' button (on 'PERSONALIZATION' popup) was detected to be ENABLED.");

                    //action.moveToElement(btn_New).click().build().perform();
                    js.executeScript("arguments[0].click();", btn_SetToDefault_Persnlzd_Locator);
                    //btn_New.click();

                    logger.info("The 'Set to Default' button (on 'PERSONALIZATION' popup) was clicked.");

                    // waitTillDescendentElementsLessThanExpected(10, "//span[contains (text(), 'Available Columns')]/ancestor::table[contains (@class, 'urSTCS urST3WhlBrd urST3WhlNoTit urST5SelColUiGeneric urHtmlTableReset')]/tbody[contains (@id, 'content')][1]/tr[2]/td[2]/div/div[2]/table/tbody/descendant::tr", "'AVAILABLE COLUMNS' with EMPTY RECORDS", 1);
                    //Exit iframe to have access to the main window's web-elements
                    driver.switchTo().defaultContent();

                    //wait till landing page is loaded again after closing "Personalization" popup
                    waitTillDescendentElementsAvailable(300, "//html/body/descendant::table", "DATA COLLATION PAGE after closing PERSONALIZATION popup on LOCATOR PANEL");
                    Thread.sleep(1000);

                    //re-open "Personolized" popup to customize WIDTH of the columns
                    click_PersonalizeBtn_LocatorPanel();

                }

                //Exit iframe to have access to the main window's web-elements
                // driver.switchTo().defaultContent();
            }

        } catch (Exception e) {
            logger.error("Unable to process the status of 'SET TO DEFAULT' button on PERSONALIZATION popup belonging to LOCATOR panel: " + e.getMessage());
        }

    }


    public void click_PersonalizeBtn_LocatorPanel() {

        try {

            if (Test_Cases.conf_SystemClient.equals("OFQ_100")) {

                // WebElement btn_Personalize_LocatorPnl = driver.findElement(By.xpath("//span[contains (text(), 'Results List: 0 Documents')]/ancestor::table[contains (@class, 'urSTCS urST3WhlBrdH urST3WhlNoTit urST5SelColUiGeneric urHtmlTableReset')][contains (@ct, 'STCS')]/thead/tr[2]/descendant::div[contains (@title, 'Settings')]"));

                // waitTillDescendentElementsAvailable(5, "//span[contains (text(), 'Displayed Columns')]/ancestor::table[contains (@class, 'urSTCS urST3WhlBrd urST3WhlNoTit urST5SelColUiGeneric urHtmlTableReset')]/tbody[contains (@id, 'content')]/tr[2]/td[2]/descendant::*", "PERSONALIZATION POPUP");

                WebElement btn_Personalize_LocatorPnl = driver.findElement(By.xpath("//span[contains (text(), 'Results List: 0 Documents')]/ancestor::table[contains (@class, 'urSTCS urST3WhlBrdH urST3WhlNoTit urST5SelColUiGeneric urHtmlTableReset')][contains (@ct, 'STCS')]/thead/tr[2]/descendant::div[contains (@title, 'Settings')]"));

                //js.executeScript("arguments[0].click();", btn_Personalize_DC);
                btn_Personalize_LocatorPnl.click();

                waitForExtAjaxIsReadyState(15, "PERSONALIZATION POPUP");
                Thread.sleep(3000);

                //When using an iframe, you will first have to switch to the iframe, before selecting the elements of that iframe.
               // driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@name,'URLSPW-0')]")));


              //  waitTillDescendentElementsAvailable(5, "//span[contains (text(), 'Displayed Columns')]/ancestor::table[contains (@class, 'urSTCS urST3WhlBrd urST3WhlNoTit urST5SelColUiGeneric urHtmlTableReset')]/tbody[contains (@id, 'content')]/tr[2]/td[2]/descendant::*", "PERSONALIZATION POPUP");

                //Exit iframe to have access to the main window's web-elements
              //  driver.switchTo().defaultContent();

            }
            if (Test_Cases.conf_SystemClient.equals("OGQ_100")) {
                //When using an iframe, you will first have to switch to the iframe, before selecting the elements of that iframe.
                // driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src,'LOADING_TEMPLATE=POPUP_PAGE&sap-wd-popupWindowID=')]")));

                //js.executeScript("arguments[0].click();", btn_Personalize_DC);
                btn_Personalize_LocatorPnl.click();

                waitForExtAjaxIsReadyState(15, "PERSONALIZATION POPUP");
                Thread.sleep(3000);
                //waitTillDescendentElementsAvailable(5, "//span[contains (text(), 'Displayed Columns')]/ancestor::table[contains (@class, 'urSTCS urST3WhlBrd urST3WhlNoTit urST5SelColUiGeneric urHtmlTableReset')]/tbody[contains (@id, 'content')]/tr[2]/td[2]/descendant::*", "PERSONALIZATION POPUP");

                //Exit iframe to have access to the main window's web-elements
                // driver.switchTo().defaultContent();
            }


        } catch (Exception e) {
            logger.error("Failed to open 'PERSONALIZATION' popup from the 'LOCATOR'popup: " + e.getMessage());
        }
    }


    public boolean check_LocatorBtnEnabledDisabledStatus() {

        boolean btn_Status = false;

        try {
            String btn_StatusIndicator = btn_LocatorContainer.getAttribute("class");
            System.out.println("Class of LOCATOR button: " + btn_StatusIndicator);

            if (!btn_StatusIndicator.contains("urBtnStdDsbl")) {

                btn_Status = true;
                logger.info("Button 'LOCATOR' is in ENABLED status.");
            } else {
                logger.error("Button 'LOCATOR' is in DISABLED status.");
            }

        } catch (Exception e) {
            logger.error("Button 'LOCATOR' is not detected: " + e.getMessage());
        }

        return btn_Status;
    }


    public void click_LocatorBtn_StatusCheck()  {

        try {
            js.executeScript("arguments[0].click();", btn_Locator);
            //action.click(btn_Check).build().perform();

            logger.info("The 'LOCATOR' button was SUCCESSFULLY clicked on.");

        } catch (Exception e) {
            logger.error("Unable to detect/click on 'LOCATOR' button: " + e.getMessage());
        }
    }


    public void fillout_SearchCriteria() {

        try {
            String document_Number = dropdown_DocNumber.getAttribute("value");
            System.out.println("DOCUMENT NUMBER dropdown value: " + document_Number);

            //check whether "Document Number" is selected by default in the first input field - if not set it to "Document Number"
            if (!document_Number.contains("Document Number")) {

                //click on "Document Number" field to open its dropdown
                js.executeScript("arguments[0].click();", dropdown_DocNumber);
                //dropdown_DocNumber.click();

                //wait till the dropdown gets displayed
                //OFQ//explicitWaitsUntilElementPresent(15, "//div[contains (@class, 'lsListbox__value')][contains (text(), 'Document Number')]", "DOCUMENT NUMBER DROPDOWN");
                explicitWaitsUntilElementPresent(15, "//div[contains (@id, 'sapwd_main_window_root_-asso')]/descendant::div[contains (@class, 'lsLCDropShadow')]/descendant::*[contains (text(), 'Document Number')]", "DOCUMENT NUMBER DROPDOWN");

                //click to select "Document Number" value from the dropdown
                js.executeScript("arguments[0].click();", dropdown_DocNumber_value);
                //dropdown_DocNumber_value.click();

                logger.info("The 'DOCUMENT NUMBER' input has been changed to 'DOCUMENT NUMBER' value.");

            } else {
                logger.info("The 'DOCUMENT NUMBER' input has 'Document Number' value selected by default as expected.");
            }

            Thread.sleep(2000);

            WebElement dropdown_Condition = driver.findElement(By.xpath("//span[contains (text(), 'Search Criteria')]/ancestor::table[@class='lsPanel urHtmlTableReset']/tbody/tr[2]/td/div/table/tbody/tr[3]/td[2]/table/tbody/tr/td[1]/input"));

            String document_Condition = dropdown_Condition.getAttribute("value");
            System.out.println("DOCUMENT CONDITION dropdown value: " + document_Condition);

            //check whether "Is between" is selected by default in the second input field - if not set it to "Is between"
            if (!document_Number.contains("is")) {

                //click on "Document Condition" field to open its dropdown
                //js.executeScript("arguments[0].click();", dropdown_Condition);
                //dropdown_Condition.click();
                action.moveToElement(dropdown_Condition).click().perform();

                //wait till the dropdown gets displayed
                //OFQ//explicitWaitsUntilElementPresent(15, "//div[contains (@class, 'lsListbox__value')][contains (text(), 'is between')]", "DOCUMENT CONDITION DROPDOWN");
                explicitWaitsUntilElementPresent(15, "//div[contains (@id, 'sapwd_main_window_root_-asso')]/descendant::div[contains (@class, 'lsLCDropShadow')]/descendant::*[contains (text(), 'is')]", "DOCUMENT CONDITION DROPDOWN");

                WebElement dropdown_Condition_value = driver.findElement(By.xpath("//div[contains (@id, 'sapwd_main_window_root_-asso')]/descendant::div[contains (@class, 'lsLCDropShadow')]/descendant::*[contains (text(), 'is')]"));

                //click to select "is" value from the "Condition" dropdown
                js.executeScript("arguments[0].click();", dropdown_Condition_value);
                //dropdown_Condition_value.click();

                logger.info("The 'DOCUMENT CONDITION' input has been changed to 'IS' value.");

            } else {
                logger.info("The 'DOCUMENT CONDITION' input has 'IS' value selected by default as expected.");
            }

            Thread.sleep(2000);

            //check whether the "Document Number" input is not outside of the "Locator" panel
            bringElementIntoViewHorizontallyInLocatorPanel(input_DocumentFROM);

            //Click and fill in "Document Number" field
            js.executeScript("arguments[0].click();", input_DocumentFROM);
            //Thread.sleep(2000);
            input_DocumentFROM.clear();
            input_DocumentFROM.sendKeys(Test_Cases.doc_Num);
            //input_DocumentFROM.sendKeys(Keys.RETURN);
            logger.info("DOCUMENT NUMBER input field is SUCCESSFULLY filled in with '" + Test_Cases.doc_Num + "'.");

            Thread.sleep(2000);

        } catch (Exception e) {

            logger.error("Error while filling out SEARCH CRITERIA fields on LOCATOR panel: " + e.getMessage());

        }

    }


    //click on "Search" button and wait till documents are displayed in the lower table
    public void click_SearchBtn() {

        try {
            //js.executeScript("arguments[0].click();", btn_Search);
            //action.click(btn_Search).build().perform();
            String val_DocFROM = input_DocumentFROM.getAttribute("value");
            // String val_DocTO = input_DocumentTO.getAttribute("value");

            if (val_DocFROM.equals("")) {

                //Click and fill in "Document From" field
                js.executeScript("arguments[0].click();", input_DocumentFROM);
                //Thread.sleep(2000);
                input_DocumentFROM.clear();
                String org_DocNum = Test_Cases.doc_Num;
                input_DocumentFROM.sendKeys(org_DocNum);
                logger.info("DOCUMENT input field had two filling attempts!");

            }

            btn_Search.click();

            logger.info("The 'SEARCH' button was SUCCESSFULLY clicked on.");

            //wait till results list is displayed in the lower table after clicking on "Search" button on "Locator" panel
            //OFQ//waitTillWebElementEscapes(30, "//span[contains (text(), 'Results List:')]/ancestor::table[@class='urSTCS urST3WhlBrdH urST3WhlNoTit urST5SelColUiGeneric urHtmlTableReset'][contains (@ct, 'STCS')]/descendant::span[contains (text(), 'No data available')]", "RESULTS LIST TABLE");
            // waitTillWebElementEscapes(30, "//span[contains (text(), 'Results List:')]/ancestor::table[@class='urSTCS urST3WhlBrdH urST3WhlNoTit urST5SelColUiGeneric urHtmlTableReset'][contains (@ct, 'STCS')]/descendant::span[contains (text(), 'No data available')]", "RESULTS LIST TABLE");
            // waitTillWebElementEscapes(10, "//span[contains (text(), 'Results List:')]/ancestor::table[@class='urSTCS urST3WhlBrdH urST3WhlNoTit urST5SelColUiGeneric urHtmlTableReset'][contains (@ct, 'STCS')]/tbody[contains(@id, 'content')]/tr[2][contains(@vpm, 'mrss-cont')]/td[2]/descendant::img[contains (@class, 'urMsgBarImgInfo lsSTInfoIconNoDisplay')]", "RESULTS LIST TABLE");
            explicitWaitsUntilElementPresent(10, "//span[contains (text(), 'Results List:')]/ancestor::table[@class='urSTCS urST3WhlBrdH urST3WhlNoTit urST5SelColUiGeneric urHtmlTableReset'][contains (@ct, 'STCS')]/tbody[contains(@id, 'content')]/tr[2][contains(@vpm, 'mrss-cont')]/td[2]/div/div[2]/descendant::tr[contains (@class, 'urST4RowFirstVisible')][1]", "RESULTS LIST TABLE");


        } catch (Exception e) {
            logger.error("Error while clicking on 'SEARCH' button or fetching searched documents into Results List: " + e.getMessage());
        }
    }


    public void bringElementIntoViewHorizontallyInLocatorPanel(WebElement childElement) {
        try {

            Point point_LocatorPanel = childElement.getLocation();

            //Get X of element.
            int childEl_X = point_LocatorPanel.getX();
            System.out.println("Element's X coordinate Is " + childEl_X + " pixels");

            //Get Y of element.
            int childEl_Y = point_LocatorPanel.getY();
            System.out.println("Element's Y coordinate Is " + childEl_Y + " pixels");

            //Get width of element.
            int elementWidth1 = childElement.getSize().getWidth();
            System.out.println("Element's width Is " + elementWidth1 + " pixels");

            //Get height of element.
            int elementHeight1 = childElement.getSize().getHeight();
            System.out.println("Element's height Is " + elementHeight1 + " pixels");


            //Get width of LOCATOR panel element.
            int elementWidth2 = panel_Locator.getSize().getWidth();
            System.out.println("LOCATOR panel's width Is " + elementWidth2 + " pixels");

            //Get height of LOCATOR panel element.
            int elementHeight2 = panel_Locator.getSize().getHeight();
            System.out.println("LOCATOR panel's height Is " + elementHeight2 + " pixels");

            //End coordinate of Web element on X axis
            int total_X = childEl_X + elementWidth1;

            //End coordinate of Web element on Y axis
            int total_Y = childEl_Y + elementHeight1;


            if (total_X >= elementWidth2) {
                //if element is outside of view port then calculate how many pixels are needed to bring it into the view

                js.executeScript("arguments[0].scrollIntoView();", childElement);

            }

        } catch (Exception e) {
            logger.error("Error while bringing element into view horizontally on the LOCATOR panel: " + e.getMessage());
        }
    }


    public void check_StatusOfFoundDocument() {

        int ColumnCount = 0;
        int neededColumns = 1;
        boolean elAvailability = false;


        try {
            //Get all non-empty rows in the "Search Results" table
            //OFQ//List<WebElement> available_RowsInSearchResultsTable = driver.findElements(By.ByXPath.xpath("//div[contains (@id, '-mrss-cont-none')][contains (@hpm, 'none')][contains (@vpm, 'mrss-cont')][contains (@segcc, '7')][contains (@segrc, '2')][contains (@segori, '1')][contains (@segoci, '1')][@class=' lsSTEmptySpace']/div[@bisposelement='X'][@class='urBorderBox']/table[@class='urST5OuterOffBrd urBorderBox'][contains(@id,'mrss-cont-none-content')]/tbody/descendant::tr"));
            List<WebElement> available_RowsInSearchResultsTable = driver.findElements(By.ByXPath.xpath("//span[contains (text(), 'Results List:')]/ancestor::table[@class='urSTCS urST3WhlBrdH urST3WhlNoTit urST5SelColUiGeneric urHtmlTableReset'][contains (@ct, 'STCS')]/descendant::div[contains (@bisposelement, 'X')][contains (@class, 'urBorderBox')]/table[@class='urST5OuterOffBrd urBorderBox'][contains(@id,'mrss-cont-none-content')]/tbody/descendant::tr"));

            int number_Rows = available_RowsInSearchResultsTable.size();
            System.out.println("Number of non-empty rows in the SEARCH RESULTS table: " + number_Rows);

            //when "Search Results" table has 1 non-empty row as was expected then read the document number and its status
            if (number_Rows == 1) {

                //Get all columns in "Search Results" table
                //OFQ//List<WebElement> available_ColumnsInSearchResultsTable = driver.findElements(By.ByXPath.xpath("//div[contains (@id, '-mrss-cont-none')][contains (@hpm, 'none')][contains (@vpm, 'mrss-cont')][contains (@segcc, '7')][contains (@segrc, '2')][contains (@segori, '1')][contains (@segoci, '1')][@class=' lsSTEmptySpace']/ancestor::tbody[contains (@id, '-content')]/tr[1]/td[2]/div/div[@bisposelement='X'][@class='urBorderBox']/table[@class='urST5OuterOffBrd urBorderBox lsSTOuterRightBorder'][contains(@id,'mrss-hdr-none-content')]/tbody/tr/descendant::th"));
                List<WebElement> available_ColumnsInSearchResultsTable = driver.findElements(By.ByXPath.xpath("//span[contains (text(), 'Results List:')]/ancestor::table[@class='urSTCS urST3WhlBrdH urST3WhlNoTit urST5SelColUiGeneric urHtmlTableReset'][contains (@ct, 'STCS')]/descendant::tr[contains(@vpm,'mrss-hdr')]/descendant::div[@bisposelement='X'][@class='urBorderBox']/table[@class='urST5OuterOffBrd urBorderBox lsSTOuterRightBorder'][contains(@id,'mrss-hdr-none-content')]/tbody/tr/descendant::th"));



                int number_Columns = available_ColumnsInSearchResultsTable.size();
                System.out.println("Number of columns in the SEARCH RESULTS table: " + number_Columns);


                //Loop through all found coulmns
                for (WebElement element : available_ColumnsInSearchResultsTable) {
                    ColumnCount++; //column counter
                    if (neededColumns <= 2) {
                        System.out.println("Counter of Needed columns in the SEARCH RESULTS table: " + neededColumns);
                        try {//check if every column contains column title text
                            element.findElement(By.xpath("div/table/tbody/tr/td[1]/div/span/span"));
                            elAvailability = true;
                        } catch (NoSuchElementException e) {
                            elAvailability = false;
                        }

                        //if column contains a column title text then read it
                        if (elAvailability) {

                            String name_TableColumn = element.getAttribute("innerText");
                            System.out.println("SPAN element Text in the SEARCH RESULTS table: " + name_TableColumn);

                            if (name_TableColumn.contains("Document Status")) {
                                name_TableColumn = "Document Status";
                            }
                            if (name_TableColumn.contains("Document Number")) {
                                name_TableColumn = "Document Number";
                            }

                            switch (name_TableColumn) {

                                case "Document Status":

                                    //check whether this column is within the screen boundaries and scroll to the column
                                    // bringElementIntoViewHorizontally("Net Price");

                                    //Find input field below the "Document Status" column title in row #1 and retrieve the status value
                                    //OFQ//WebElement field_DocStatus1 = driver.findElement(By.ByXPath.xpath("//div[contains (@id, '-mrss-cont-none')][contains (@hpm, 'none')][contains (@vpm, 'mrss-cont')][contains (@segcc, '7')][contains (@segrc, '2')][contains (@segori, '1')][contains (@segoci, '1')][@class=' lsSTEmptySpace']/div[@bisposelement='X'][@class='urBorderBox']/table[@class='urST5OuterOffBrd urBorderBox'][contains(@id,'-mrss-cont-none-content')]/tbody/tr[1]/td[" + ColumnCount + "]/div/span/img"));
                                    WebElement field_DocStatus1 = driver.findElement(By.ByXPath.xpath("//span[contains (text(), 'Results List:')]/ancestor::table[@class='urSTCS urST3WhlBrdH urST3WhlNoTit urST5SelColUiGeneric urHtmlTableReset'][contains (@ct, 'STCS')]/descendant::tr[contains (@vpm, 'mrss-cont')]/td[2]/descendant::div[@bisposelement='X'][@class='urBorderBox']/table[@class='urST5OuterOffBrd urBorderBox'][contains(@id, '-mrss-cont-none-content')]/tbody/tr[1]/td[" + ColumnCount + "]/div/descendant::img"));

                                    docStatus_Row1 = field_DocStatus1.getAttribute("title");

                                    logger.info("DOCUMNET STATUS in row #1 is equal to: " + docStatus_Row1);

                                    neededColumns++;

                                    break;

                                case "Document Number":

                                    //check whether this column is within the screen boundaries and scroll to the column
                                    // bringElementIntoViewHorizontally("Net Price");

                                    //Find input field below the "Document Number" column title in row #1 and retrieve the status value
                                    //OFQ//WebElement field_DocNumber1 = driver.findElement(By.ByXPath.xpath("//div[contains (@id, '-mrss-cont-none')][contains (@hpm, 'none')][contains (@vpm, 'mrss-cont')][contains (@segcc, '7')][contains (@segrc, '2')][contains (@segori, '1')][contains (@segoci, '1')][@class=' lsSTEmptySpace']/div[@bisposelement='X'][@class='urBorderBox']/table[@class='urST5OuterOffBrd urBorderBox'][contains(@id,'-mrss-cont-none-content')]/tbody/tr[1]/td[" + ColumnCount + "]/div/span/span"));
                                    WebElement field_DocNumber1 = driver.findElement(By.ByXPath.xpath("//span[contains (text(), 'Results List:')]/ancestor::table[@class='urSTCS urST3WhlBrdH urST3WhlNoTit urST5SelColUiGeneric urHtmlTableReset'][contains (@ct, 'STCS')]/descendant::tr[contains (@vpm, 'mrss-cont')]/td[2]/descendant::div[@bisposelement='X'][@class='urBorderBox']/table[@class='urST5OuterOffBrd urBorderBox'][contains(@id, '-mrss-cont-none-content')]/tbody/tr[1]/td[" + ColumnCount + "]/div/descendant::span[contains (@ct, 'TV')]"));
                                    docNumber_Row1 = field_DocNumber1.getAttribute("innerText");

                                    logger.info("DOCUMNET NUMBER in row #1 is equal to: " + docNumber_Row1);

                                    neededColumns++;

                                    break;

                                default:
                            }
                        }
                    } else {
                        //break;
                        return;// break the cycle when all required fields have been filled in
                    }
                }

            } else {
                logger.error("The number of records in the SEARCH RESULTS table is not equal to expected. Found non-empty rows = " + number_Rows);
            }


        } catch (NoSuchElementException e) {
            logger.error("No such element - Error while retrieving the non-empty rows from the 'SEARCH RESULTS' table: " + e.getMessage());
        }
    }

    public void correlate_DocStatusAndDocNum() {

        try {

            //Correlating document status and document number from row #1
            if (docStatus_Row1.equals("Posted") && docNumber_Row1.equals(Test_Cases.doc_Num)) {

                logger.info("DOCUMNET STATUS is correctly correlated with DOCUMENT NUMBER in row #1: " + docStatus_Row1.toUpperCase() + " and " + docNumber_Row1);

            } else {

                logger.error("DOCUMNET STATUS is NOT correctly correlated with DOCUMENT NUMBER in row #1: " + docStatus_Row1.toUpperCase() + " and " + docNumber_Row1);
                //driver.close();
                //driver.quit();
                throw new AssertionError("DOCUMNET STATUS is NOT correctly correlated with DOCUMENT NUMBER in row #1: " + docStatus_Row1.toUpperCase() + " and " + docNumber_Row1);


            }

        } catch (Exception e) {
            logger.error("Error while making correlation of DOCUMNET STATUS with DOCUMENT NUMBER from RESULTS table: " + e.getMessage());
        }


    }

}
