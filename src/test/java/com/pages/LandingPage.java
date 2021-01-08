package com.pages;

import init.settings.PageObject;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.project.Test_Cases;
import org.testng.Assert;

import java.util.List;

import static ax.generic.Waitings.*;
import static org.testng.Assert.assertEquals;

public class LandingPage extends PageObject {

    public Logger logger = Logger.getLogger(LandingPage.class);

    //Locating all page elements on landing page
    @FindBy(xpath = "//html/body/descendant::*")
    private WebElement elems_LandingPage;

    //Locating "Item Data" table on "Data Collation" page
    //OFQ//@FindBy(xpath = "//tr[@class=' urST5SelColUiGeneric']/td[@class='urST5OuterOffBrd urBorderBox urStd lsSTVertBrd']/div/div[4]/img[@class='urMsgBarImgInfo lsSTInfoIconNoDisplay']")
    //@FindBy(xpath = "//img[@class='urMsgBarImgInfo lsSTInfoIconNoDisplay']/ancestor::table[contains (@ct, 'GL')][@class = 'urFontStd urHtmlTableReset']/tbody/tr[4]")
    //@FindBy(xpath = "//span[contains(text(), 'Item Data')]/ancestor::table[@class='urFontStd urHtmlTableReset'][contains(@ct, 'GL')]/descendant::span[contains(text(), 'No data available')]")
    @FindBy(xpath = "//span[contains (text(), 'Item Data')]/ancestor::table[contains (@ct, 'P')][contains (@class, 'lsPanel urHtmlTableReset')]/tbody/tr[2]/descendant::span[contains (text(), 'No data available')]")
    private WebElement table_ItemData;

    //Locating "No data available" label in "Add Item" table
    @FindBy(xpath = "//tr[@class=' urST5SelColUiGeneric']/td[@class='urST5OuterOffBrd urBorderBox urStd lsSTVertBrd']/div/div[4]/img[@class='urMsgBarImgInfo lsSTInfoIconNoDisplay']")
    private WebElement table_ItemData_NoDataAvailable_lbl;

    //Locating rows in "Add Item" table
    @FindBy(xpath = "//td[@class='lsContainerCell lsContainerCellVAlign--top urLayoutPadless']/div[@class='urBorderBox urLayoutPadless ']/table[@class='lsHTMLContainer']/tbody/tr/td/div/table/tbody/tr[2]/td[2]/div/descendant::div")
    private WebElement rows_AddItem_tbl;

    //Locating document number
    //OFQ//@FindBy(xpath = "//div[@class='lsHTMLContainer']/div/table[@class='urMatrixLayout urHtmlTableReset']/tbody[@class='urLinStd']/tr[1]/td[2]/span[@class='lsTextView--root lsControl--valign']/span")
    @FindBy(xpath = "//span[contains(text(), 'Vehicle-Related Data Collation')]/ancestor::td[contains(@ct, 'MLC')][@class='lsContainerCell lsContainerCellVAlign--top urLayoutRPad']/ancestor::tr[2]/td[2]/descendant::tbody[@class='urLinStd'][2]/tr[1]/td[2]/descendant::span[contains(@ct, 'TV')]")
    private WebElement doc_Number;

    //Locating document status
    //OFQ//@FindBy(xpath = "//div[@class='lsHTMLContainer']/div/table[@class='urMatrixLayout urHtmlTableReset']/tbody[@class='urLinStd']/tr[2]/td[2]/div/div/table/tbody/tr/td/span/span")
    @FindBy(xpath = "//span[contains(text(), 'Vehicle-Related Data Collation')]/ancestor::td[contains(@ct, 'MLC')][@class='lsContainerCell lsContainerCellVAlign--top urLayoutRPad']/ancestor::tr[2]/td[2]/descendant::tbody[@class='urLinStd'][2]/tr[2]/td[2]/descendant::span[contains(@ct, 'TV')]")
    private WebElement doc_Status;

    //Locating "New" button
    @FindBy(xpath = "//span[contains(text(), 'New')]")
    private WebElement btn_New;

    //Locating "New" button's container
    //OFQ//@FindBy(xpath = "//div[@class='lsPageHeader--item urPgHITrans']/table[@class='lsToolbar--overflow urTWhlFlat lsTItmOvflFlat urHtmlTableReset urTBar lsToolbar']/tbody/tr/td[1]/div[@class='lsTbarOvfl']/span[11]/div")
    @FindBy(xpath = "//img[contains(@src, 'NewItem.png')]/ancestor::div[contains (@title, 'New')]")
    private WebElement btn_NewContainer;

    //Locating "Add Item" button's container
    //OFQ//@FindBy(xpath = "//table[@class='urSTCS urST3WhlBrd urST3WhlNoTit urST5SelColUiGeneric urHtmlTableReset']/thead/tr/th[@class='urST4Toolbar']/table[@class='urTWhlFlat urHtmlTableReset urTBar lsToolbar']/tbody/tr/td[1]/span[1]/div[@class='lsButton lsTbarBtnStd urInlineMetricTop urNoUserSelect urBtnRadius  lsButton--onlyImage  urBtnStdValign  lsButton--toolbar-image  urBtnImgBgColor  lsButton--up lsButton--design-standard  urBtnStd']")
    @FindBy(xpath = "//img[contains (@src, '/img/libs/Icon/AddFile.png')]/ancestor::div[contains (@title, 'Add Item')]")
    private WebElement btn_AddItemContainer;

    //Locating "CallPersonalization" button's container
    @FindBy(xpath = "//div[contains(@title, 'Call Personalization for Doc. Category')]")
    private WebElement btn_CallPersonalization;

    //Locating "Add Item" tables's first editable row (left-side)
    @FindBy(xpath = "//table[@class='urSTCS urST3WhlBrd urST3WhlNoTit urST5SelColUiGeneric urHtmlTableReset']/tbody[1]/tr[2]/td[1]/div/div[2]/table[@class='urST5OuterOffBrd urBorderBox lsSTOuterRightBorder']/tbody/tr[@class='urST4RowFirstVisible']/td[1]")
    private WebElement row_AddItemTable_Left;

    //Locating "Add Item" tables's first editable row (right-side)
    @FindBy(xpath = "//table[@class='urSTCS urST3WhlBrd urST3WhlNoTit urST5SelColUiGeneric urHtmlTableReset']/tbody[1]/tr[2]/td[2]/div/div[2]/table[@class='urST5OuterOffBrd urBorderBox lsSTOuterRightBorder']/tbody/tr[@class='urST4RowFirstVisible']")
    private WebElement row_AddItemTable_Right;

    //Locating "Header Data" panel opener/closer
    @FindBy(xpath = "//span[contains(text(), 'Header Data')]/ancestor::div[contains (@class, 'urNoUserSelect lsHdArTtlAreaBg')]/span[contains(@title, 'Expand')]")
    private WebElement toggler_HeaderPanel;

    //Locating "Header Data" panel opener/closer
    @FindBy(xpath = "//span[contains(text(), 'Document Flow')]/ancestor::div[contains (@class, 'urNoUserSelect lsHdArTtlAreaBg')]/span[contains(@title, 'Expand')]")
    private WebElement toggler_DocumentFlow;

    //Locating "Item Data" panel opener/closer
    @FindBy(xpath = "//span[contains(text(), 'Item Data')]/ancestor::div[contains (@class, 'urNoUserSelect lsHdArTtlAreaBg')]/span[contains(@title, 'Expand')]")
    private WebElement toggler_ItemDataPanel;

    //Locating "Personalize" button on "Data Collation" toolbar
    @FindBy(xpath = "//div[contains (text(), 'Data Collation')]/ancestor::table[contains (@class, 'urMatrixLayout urHtmlTableReset')][contains (@ct, 'ML')]/descendant::div[contains (@title, 'Personalize')]")
    private WebElement btn_Personalize_DC;

    //Locating "Personalize" button on "Add Item" table
    @FindBy(xpath = "//span[contains (text(), 'Item Data')]/ancestor::table[contains (@class, 'lsPanel urHtmlTableReset')][contains (@ct, 'P')]/tbody/tr[2]/descendant::table[contains (@ct, 'STCS')][contains (@class, 'urSTCS urST3WhlBrdH urST3WhlNoTit urST5SelColUiGeneric urHtmlTableReset')]/thead/descendant::div[contains(@title, 'Personalize')]")
    private WebElement btn_Personalize;

    //Locating "Set to Default" button on "Personalization" popup
    @FindBy(xpath = "//div[contains (text(), 'Personalization')]/ancestor::div[contains (@class, 'urPWOuterBorder lsPopupWindow lsPopupWindow--dialog')][contains (@ct, 'PW')]/div/div[4][contains (@class, 'sapContrast sapContrastPlus lsTwhlFooter lsTbarLarge urPWFooterBottomLine')]/descendant::span[contains (text(), 'Reset to Default')]/ancestor::div[1]")
    private WebElement btn_SetToDefault;

    //Locating "Save" button on "Personalization" popup
    @FindBy(xpath = "//div[contains (text(), 'Personalization')]/ancestor::div[contains (@class, 'urPWOuterBorder lsPopupWindow lsPopupWindow--dialog')][contains (@ct, 'PW')]/div/div[4][contains (@class, 'sapContrast sapContrastPlus lsTwhlFooter lsTbarLarge urPWFooterBottomLine')]/descendant::span[text()='Save']/ancestor::div[1]")
    private WebElement btn_SavePersonalization;


    //Locating "Data Details" panel opener/closer
    @FindBy(xpath = "//span[contains(text(), 'Detail Data')]/ancestor::div[contains (@class, 'urNoUserSelect lsHdArTtlAreaBg')]/span[contains(@title, 'Expand')]")
    private WebElement toggler_DataDetailaPanel;

    //Locating "StandardDataCollation" section on the top of the page
    // @FindBy(xpath = "//span[contains(text(), 'Transaction Type')]/ancestor::table[@class='lsTWhlNested urTWhlTrans urHtmlTableReset urTBar lsToolbar'][contains (@ct, 'T')]")
    @FindBy(xpath = "//span[contains(text(), 'Transaction Type')]/ancestor::td[contains (@class, 'lsContainerCell lsGLCTopVAlign lsContainerCellVAlign--top ')][contains (@ct, 'GLC')]")
    private WebElement header_StandardDataCollation;


    //Constructor
    public LandingPage(WebDriver driver) {
        super(driver);

    }

    JavascriptExecutor js = (JavascriptExecutor) driver;
    Actions action = new Actions(driver);


    public void mainPage_scrollToTheTop() {

        try {
            //Scroll back to the top of the page
            js.executeScript("arguments[0].scrollIntoView();", header_StandardDataCollation);
        }catch (Exception e){

            logger.error("Unable to scroll the main 'Data Collation' page to the top: " + e.getMessage());

        }
    }

    public void check_DataDetailsPanel_Displayed() {

        try {
            WebElement available_RowsInDataDetailsPanel = driver.findElement(By.ByXPath.xpath("//span[contains(text(), 'Detail Data')]/ancestor::table[contains(@class, 'lsPanel urHtmlTableReset')][contains(@ct, 'P')]/tbody/tr[2]"));

            String displayStatus = available_RowsInDataDetailsPanel.getCssValue("display");


            if (displayStatus.contains("none")) {

                //click to open "Data Details" panel
                toggler_DataDetailaPanel.click();
                // action.moveToElement(tab_Start).click().build().perform();
                //js.executeScript("arguments[0].click();", tab_Start);

                //wait till "Header Panel" gets loaded
                waitTillDescendentElementsAvailable(30, "//span[contains(text(), 'Detail Data')]/ancestor::table[contains(@class, 'lsPanel urHtmlTableReset')][contains(@ct, 'P')]/tbody/tr[2]/td/div/descendant::*", "DATA DETAILS panel");
                Thread.sleep(2000);
            }

        } catch (Exception e) {
            logger.error("Unable to detect the status of DATA DETAILS panel: " + e.getMessage());
        }
    }


    public void click_SaveBtn() {

        try {
        /*    if (Test_Cases.conf_SystemClient.equals("OGQ_100")) {
                //When using an iframe, you will first have to switch to the iframe, before selecting the elements of that iframe.
                driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src,'LOADING_TEMPLATE=POPUP_PAGE&sap-wd-popupWindowID=')]")));
            }*/

            if (Test_Cases.conf_SystemClient.equals("OFQ_100")) {

                //When using an iframe, you will first have to switch to the iframe, before selecting the elements of that iframe.
                driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@name,'URLSPW-0')]")));


                WebElement btn_SavePersonalization = driver.findElement(By.xpath("//div[contains (text(), 'Settings')]/ancestor::div[contains (@class, 'urPWOuterBorder lsPopupWindow lsPopupWindow--dialog')][contains (@ct, 'PW')]/div/div[4][contains (@class, 'sapContrast sapContrastPlus lsTwhlFooter lsTbarLarge urPWFooterBottomLine')]/descendant::span[text()='Save']/ancestor::div[1]"));

                //action.moveToElement(input_Width_1).click().build().perform();
                js.executeScript("arguments[0].click();", btn_SavePersonalization);
                //btn_New.click();

                logger.info("The 'SAVE' button (on 'PERSONALIZATION' popup) was clicked to save Default Settings.");

                //Exit iframe to have access to the main window's web-elements
                driver.switchTo().defaultContent();

                //wait till landing page is loaded again after closing "Personalization" popup
                waitTillDescendentElementsAvailable(300, "//html/body/descendant::table", "DATA COLLATION PAGE after closing PERSONALIZATION popup");
                Thread.sleep(1000);
            }


            if (Test_Cases.conf_SystemClient.equals("OGQ_100")) {

                driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@name,'URLSPW-0')]")));

                //action.moveToElement(input_Width_1).click().build().perform();
                js.executeScript("arguments[0].click();", btn_SavePersonalization);
                //btn_New.click();

                logger.info("The 'SAVE' button (on 'PERSONALIZATION' popup) was clicked to save Default Settings.");

                //Exit iframe to have access to the main window's web-elements
                driver.switchTo().defaultContent();


                //wait till landing page is loaded again after closing "Personalization" popup
                waitTillDescendentElementsAvailable(300, "//html/body/descendant::table", "DATA COLLATION PAGE after closing PERSONALIZATION popup");
                Thread.sleep(1000);
            }

        } catch (Exception e) {
            logger.error("Error while clicking on SAVE button on PERSONALIZATION popup: " + e.getMessage());
        }
    }


    public void select_Rows(String title_Column, WebElement element_2) {

        try {

            if (Test_Cases.conf_SystemClient.equals("OFQ_100")) {

                WebElement scroller_DisplayedColumns = driver.findElement(By.xpath("//span[contains (text(), 'Displayed Columns')]/ancestor::table[contains (@class, 'urSTCS urST3WhlBrd urST3WhlNoTit urST5SelColUiGeneric urHtmlTableReset')]/tbody[1]/tr[2]/td[3]/div/table/tbody/tr[3]/td/div"));

                switch (title_Column) {
                    case "Item Status":

                        WebElement input_Width_1 = element_2.findElement(By.xpath("td[2]/div"));

                        //action.moveToElement(input_Width_1).click().build().perform();
                        //js.executeScript("arguments[0].click();", input_Width_1);
                        input_Width_1.click();

                        logger.info("The 'Item Status' WIDTH field (on 'PERSONALIZATION' popup) was clicked for editing.");

                        waitTillWebElementAvailable(5, input_Width_1.findElement(By.xpath("span/input")), "'Item Status' WIDTH field");

                        WebElement input_Field_1 = input_Width_1.findElement(By.xpath("span/input"));
                        input_Field_1.clear();
                        action.sendKeys(input_Field_1, "71").perform();
                        //input_Field_1.sendKeys("71");
                        //js.executeScript("arguments[0].value='71';", input_Field_1);
                        // Thread.sleep(1000);
                        // input_NetPrice_input.sendKeys(Keys.ENTER);
                        logger.info("Width for ITEM STATUS input field was SUCCESSFULLY changed.");


                        //Check availability of 'Fixed' check-mark
                        WebElement check_mark_1 = element_2.findElement(By.xpath("td[3]/div/span"));

                        String valueClass = check_mark_1.getAttribute("class");
                        System.out.println("The class value for "+title_Column+" check-box is: " + valueClass);

                        if (!valueClass.contains("lsCheckBox--checked")) {//if not selected then click on it to select it
                            js.executeScript("arguments[0].click();", check_mark_1);
                            logger.info("ITEM STATUS input field was clicked to be selected in the FIXED column.");
                        } else {
                            logger.info("ITEM STATUS input field was selected in the FIXED column BY DEFAULT.");
                        }

                        //click vertical scroller to move the list one row up
                        //action.click(scroller_DisplayedColumns).perform();
                        js.executeScript("arguments[0].click();", scroller_DisplayedColumns);

                        break;


                    case "Transfer Posting":

                        WebElement input_Width_2 = element_2.findElement(By.xpath("td[2]/div"));

                        //action.moveToElement(input_Width_1).click().build().perform();
                        //js.executeScript("arguments[0].click();", input_Width_1);
                        input_Width_2.click();

                        logger.info("The 'Transfer Posting' WIDTH field (on 'PERSONALIZATION' popup) was clicked for editing.");

                        waitTillWebElementAvailable(5, input_Width_2.findElement(By.xpath("span/input")), "'Transfer Posting' WIDTH field");

                        WebElement input_Field_2 = input_Width_2.findElement(By.xpath("span/input"));
                        input_Field_2.clear();
                        action.sendKeys(input_Field_2, "98").perform();
                        //input_Field_2.sendKeys("98");
                        //js.executeScript("arguments[0].value='98';", input_Field_2);
                        // Thread.sleep(1000);
                        // input_NetPrice_input.sendKeys(Keys.ENTER);
                        logger.info("Width for TRANSFER POSTING input field was SUCCESSFULLY changed.");


                        //Check availability of 'Fixed' check-mark
                        WebElement check_mark_2 = element_2.findElement(By.xpath("td[3]/div/span"));

                        String valueClass2 = check_mark_2.getAttribute("class");
                        System.out.println("The class value for "+title_Column+" check-box is: " + valueClass2);

                        if (!valueClass2.contains("lsCheckBox--checked")) {//if not selected then click on it to select it
                            js.executeScript("arguments[0].click();", check_mark_2);
                            logger.info("TRANSFER POSTING input field was clicked to be selected in the FIXED column.");
                        } else {
                            logger.info("TRANSFER POSTING input field was selected in the FIXED column BY DEFAULT.");
                        }

                        //click vertical scroller to move the list one row up
                        // action.click(scroller_DisplayedColumns).perform();
                        js.executeScript("arguments[0].click();", scroller_DisplayedColumns);

                        break;


                    case "Item Number":

                        WebElement input_Width_3 = element_2.findElement(By.xpath("td[2]/div"));

                        //action.moveToElement(input_Width_1).click().build().perform();
                        //js.executeScript("arguments[0].click();", input_Width_1);
                        input_Width_3.click();

                        logger.info("The 'Item Number' WIDTH field (on 'PERSONALIZATION' popup) was clicked for editing.");

                        waitTillWebElementAvailable(5, input_Width_3.findElement(By.xpath("span/input")), "'Item Number' WIDTH field");

                        WebElement input_Field_3 = input_Width_3.findElement(By.xpath("span/input"));
                        input_Field_3.clear();
                        action.sendKeys(input_Field_3, "94").perform();
                        //input_Field_3.sendKeys("94");
                        //js.executeScript("arguments[0].value='10,00';", input_NetPrice_input);
                        // Thread.sleep(1000);
                        // input_NetPrice_input.sendKeys(Keys.ENTER);
                        logger.info("Width for ITEM NUMBER input field was SUCCESSFULLY changed.");


                        //Check availability of 'Fixed' check-mark
                        WebElement check_mark_3 = element_2.findElement(By.xpath("td[3]/div/span"));

                        String valueClass3 = check_mark_3.getAttribute("class");
                        System.out.println("The class value for "+title_Column+" check-box is: " + valueClass3);

                        if (!valueClass3.contains("lsCheckBox--checked")) {//if not selected then click on it to select it
                            js.executeScript("arguments[0].click();", check_mark_3);
                            logger.info("ITEM NUMBER input field was clicked to be selected in the FIXED column.");
                        } else {
                            logger.info("ITEM NUMBER input field was selected in the FIXED column BY DEFAULT.");
                        }

                        //click vertical scroller to move the list one row up
                        //action.click(scroller_DisplayedColumns).perform();
                        js.executeScript("arguments[0].click();", scroller_DisplayedColumns);

                        break;


                    case "Sequence Number of the Item":

                        WebElement input_Width_4 = element_2.findElement(By.xpath("td[2]/div"));

                        //action.moveToElement(input_Width_1).click().build().perform();
                        //js.executeScript("arguments[0].click();", input_Width_1);
                        input_Width_4.click();

                        logger.info("The 'Sequence Number of the Item' WIDTH field (on 'PERSONALIZATION' popup) was clicked for editing.");

                        waitTillWebElementAvailable(5, input_Width_4.findElement(By.xpath("span/input")), "'Sequence Number of the Item' WIDTH field");

                        WebElement input_Field_4 = input_Width_4.findElement(By.xpath("span/input"));
                        input_Field_4.clear();
                        action.sendKeys(input_Field_4, "134").perform();
                        //input_NetPrice.sendKeys("10");
                        //js.executeScript("arguments[0].value='10,00';", input_NetPrice_input);
                        // Thread.sleep(1000);
                        // input_NetPrice_input.sendKeys(Keys.ENTER);
                        logger.info("Width for SEQUENCE NUMBER OF THE ITEM input field was SUCCESSFULLY changed.");


                        //Check availability of 'Fixed' check-mark
                        WebElement check_mark_4 = element_2.findElement(By.xpath("td[3]/div/span"));

                        String valueClass4 = check_mark_4.getAttribute("class");
                        System.out.println("The class value for "+title_Column+" check-box is: " + valueClass4);

                        if (!valueClass4.contains("lsCheckBox--checked")) {//if not selected then click on it to select it
                            js.executeScript("arguments[0].click();", check_mark_4);
                            logger.info("SEQUENCE NUMBER OF THE ITEM input field was clicked to be selected in the FIXED column.");
                        } else {
                            logger.info("SEQUENCE NUMBER OF THE ITEM input field was selected in the FIXED column BY DEFAULT.");
                        }

                        //click vertical scroller to move the list one row up
                        //action.click(scroller_DisplayedColumns).perform();
                        js.executeScript("arguments[0].click();", scroller_DisplayedColumns);

                        break;


                    case "Posting Sequence":

                        WebElement input_Width_5 = element_2.findElement(By.xpath("td[2]/div"));

                        //action.moveToElement(input_Width_1).click().build().perform();
                        //js.executeScript("arguments[0].click();", input_Width_1);
                        input_Width_5.click();

                        logger.info("The 'Posting Sequence' WIDTH field (on 'PERSONALIZATION' popup) was clicked for editing.");

                        waitTillWebElementAvailable(5, input_Width_5.findElement(By.xpath("span/input")), "'Posting Sequence' WIDTH field");

                        WebElement input_Field_5 = input_Width_5.findElement(By.xpath("span/input"));
                        input_Field_5.clear();
                        action.sendKeys(input_Field_5, "115").perform();
                        //input_NetPrice.sendKeys("10");
                        //js.executeScript("arguments[0].value='10,00';", input_NetPrice_input);
                        // Thread.sleep(1000);
                        // input_NetPrice_input.sendKeys(Keys.ENTER);
                        logger.info("Width for POSTING SEQUENCE input field was SUCCESSFULLY changed.");


                        //Check availability of 'Fixed' check-mark
                        WebElement check_mark_5 = element_2.findElement(By.xpath("td[3]/div/span"));

                        String valueClass5 = check_mark_5.getAttribute("class");
                        System.out.println("The class value for "+title_Column+" check-box is: " + valueClass5);

                        if (!valueClass5.contains("lsCheckBox--checked")) {//if not selected then click on it to select it
                            js.executeScript("arguments[0].click();", check_mark_5);
                            logger.info("POSTING SEQUENCE input field was clicked to be selected in the FIXED column.");
                        } else {
                            logger.info("POSTING SEQUENCE input field was selected in the FIXED column BY DEFAULT.");
                        }

                        //click vertical scroller to move the list one row up
                        //action.click(scroller_DisplayedColumns).perform();
                        js.executeScript("arguments[0].click();", scroller_DisplayedColumns);

                        break;


                    case "Item Category":

                        WebElement input_Width_6 = element_2.findElement(By.xpath("td[2]/div"));

                        //action.moveToElement(input_Width_1).click().build().perform();
                        //js.executeScript("arguments[0].click();", input_Width_1);
                        input_Width_6.click();

                        logger.info("The 'Item Category' WIDTH field (on 'PERSONALIZATION' popup) was clicked for editing.");

                        waitTillWebElementAvailable(5, input_Width_6.findElement(By.xpath("span/input")), "'Item Category' WIDTH field");

                        WebElement input_Field_6 = input_Width_6.findElement(By.xpath("span/input"));
                        input_Field_6.clear();
                        action.sendKeys(input_Field_6, "92").perform();
                        //input_NetPrice.sendKeys("10");
                        //js.executeScript("arguments[0].value='10,00';", input_NetPrice_input);
                        // Thread.sleep(1000);
                        // input_NetPrice_input.sendKeys(Keys.ENTER);
                        logger.info("Width for ITEM CATEGORY input field was SUCCESSFULLY changed.");


                        //Check availability of 'Fixed' check-mark
                        WebElement check_mark_6 = element_2.findElement(By.xpath("td[3]/div/span"));

                        String valueClass6 = check_mark_6.getAttribute("class");
                        System.out.println("The class value for "+title_Column+" check-box is: " + valueClass6);

                        if (!valueClass6.contains("lsCheckBox--checked")) {//if not selected then click on it to select it
                            js.executeScript("arguments[0].click();", check_mark_6);
                            logger.info("ITEM CATEGORY input field was clicked to be selected in the FIXED column.");
                        } else {
                            logger.info("ITEM CATEGORY input field was selected in the FIXED column BY DEFAULT.");
                        }

                        //click vertical scroller to move the list one row up
                        //action.click(scroller_DisplayedColumns).perform();
                        js.executeScript("arguments[0].click();", scroller_DisplayedColumns);

                        break;


                    case "Reference Document":

                        WebElement input_Width_7 = element_2.findElement(By.xpath("td[2]/div"));

                        //action.moveToElement(input_Width_1).click().build().perform();
                        //js.executeScript("arguments[0].click();", input_Width_1);
                        input_Width_7.click();

                        logger.info("The 'Reference Document' WIDTH field (on 'PERSONALIZATION' popup) was clicked for editing.");

                        waitTillWebElementAvailable(5, input_Width_7.findElement(By.xpath("span/input")), "'Reference Document' WIDTH field");

                        WebElement input_Field_7 = input_Width_7.findElement(By.xpath("span/input"));
                        input_Field_7.clear();
                        action.sendKeys(input_Field_7, "127").perform();
                        //input_Field_7.sendKeys("127");
                        //js.executeScript("arguments[0].value='10,00';", input_NetPrice_input);
                        // Thread.sleep(1000);
                        // input_NetPrice_input.sendKeys(Keys.ENTER);
                        logger.info("Width for REFERENCE DOCUMENT input field was SUCCESSFULLY changed.");


                        //Check availability of 'Fixed' check-mark
                        WebElement check_mark_7 = element_2.findElement(By.xpath("td[3]/div/span"));

                        String valueClass7 = check_mark_7.getAttribute("class");
                        System.out.println("The class value for "+title_Column+" check-box is: " + valueClass7);

                        if (valueClass7.contains("lsCheckBox--checked")) {//if not selected then click on it to select it
                            js.executeScript("arguments[0].click();", check_mark_7);
                            logger.info("REFERENCE DOCUMENT input field was clicked to be unselected in the FIXED column.");
                        } else {
                            logger.info("REFERENCE DOCUMENT input field was unselected in the FIXED column BY DEFAULT.");
                        }

                        //click vertical scroller to move the list one row up
                        //action.click(scroller_DisplayedColumns).perform();
                        js.executeScript("arguments[0].click();", scroller_DisplayedColumns);

                        break;


                    case "Reference Item":

                        WebElement input_Width_8 = element_2.findElement(By.xpath("td[2]/div"));

                        //action.moveToElement(input_Width_1).click().build().perform();
                        //js.executeScript("arguments[0].click();", input_Width_1);
                        input_Width_8.click();

                        logger.info("The 'Reference Item' WIDTH field (on 'PERSONALIZATION' popup) was clicked for editing.");

                        waitTillWebElementAvailable(5, input_Width_8.findElement(By.xpath("span/input")), "'Reference Item' WIDTH field");

                        WebElement input_Field_8 = input_Width_8.findElement(By.xpath("span/input"));
                        input_Field_8.clear();
                        action.sendKeys(input_Field_8, "97").perform();
                        //input_NetPrice.sendKeys("10");
                        //js.executeScript("arguments[0].value='10,00';", input_NetPrice_input);
                        // Thread.sleep(1000);
                        // input_NetPrice_input.sendKeys(Keys.ENTER);
                        logger.info("Width for REFERENCE ITEM input field was SUCCESSFULLY changed.");


                        //Check availability of 'Fixed' check-mark
                        WebElement check_mark_8 = element_2.findElement(By.xpath("td[3]/div/span"));

                        String valueClass8 = check_mark_8.getAttribute("class");
                        System.out.println("The class value for "+title_Column+" check-box is: " + valueClass8);

                        if (valueClass8.contains("lsCheckBox--checked")) {//if not selected then click on it to select it
                            js.executeScript("arguments[0].click();", check_mark_8);
                            logger.info("REFERENCE ITEM input field was clicked to be unselected in the FIXED column.");
                        } else {
                            logger.info("REFERENCE ITEM input field was unselected in the FIXED column BY DEFAULT.");
                        }

                        //click vertical scroller to move the list one row up
                        //action.click(scroller_DisplayedColumns).perform();
                        js.executeScript("arguments[0].click();", scroller_DisplayedColumns);

                        break;


                    case "Material":

                        WebElement input_Width_9 = element_2.findElement(By.xpath("td[2]/div"));

                        //action.moveToElement(input_Width_1).click().build().perform();
                        //js.executeScript("arguments[0].click();", input_Width_1);
                        input_Width_9.click();

                        logger.info("The 'Material' WIDTH field (on 'PERSONALIZATION' popup) was clicked for editing.");

                        waitTillWebElementAvailable(5, input_Width_9.findElement(By.xpath("span/input")), "'Material' WIDTH field");

                        WebElement input_Field_9 = input_Width_9.findElement(By.xpath("span/input"));
                        input_Field_9.clear();
                        action.sendKeys(input_Field_9, "64").perform();
                        //input_NetPrice.sendKeys("10");
                        //js.executeScript("arguments[0].value='10,00';", input_NetPrice_input);
                        // Thread.sleep(1000);
                        // input_NetPrice_input.sendKeys(Keys.ENTER);
                        logger.info("Width for MATERIAL input field was SUCCESSFULLY changed.");


                        //Check availability of 'Fixed' check-mark
                        WebElement check_mark_9 = element_2.findElement(By.xpath("td[3]/div/span"));

                        String valueClass9 = check_mark_9.getAttribute("class");
                        System.out.println("The class value for "+title_Column+" check-box is: " + valueClass9);

                        if (valueClass9.contains("lsCheckBox--checked")) {//if not selected then click on it to select it
                            js.executeScript("arguments[0].click();", check_mark_9);
                            logger.info("MATERIAL input field was clicked to be unselected in the FIXED column.");
                        } else {
                            logger.info("MATERIAL ITEM input field was unselected in the FIXED column BY DEFAULT.");
                        }

                        //click vertical scroller to move the list one row up
                        //action.click(scroller_DisplayedColumns).perform();
                        js.executeScript("arguments[0].click();", scroller_DisplayedColumns);

                        break;


                    case "Material description":

                        WebElement input_Width_10 = element_2.findElement(By.xpath("td[2]/div"));

                        //action.moveToElement(input_Width_1).click().build().perform();
                        //js.executeScript("arguments[0].click();", input_Width_1);
                        input_Width_10.click();

                        logger.info("The 'Material description' WIDTH field (on 'PERSONALIZATION' popup) was clicked for editing.");

                        waitTillWebElementAvailable(5, input_Width_10.findElement(By.xpath("span/input")), "'Material description' WIDTH field");

                        WebElement input_Field_10 = input_Width_10.findElement(By.xpath("span/input"));
                        input_Field_10.clear();
                        action.sendKeys(input_Field_10, "126").perform();
                        //input_NetPrice.sendKeys("10");
                        //js.executeScript("arguments[0].value='10,00';", input_NetPrice_input);
                        // Thread.sleep(1000);
                        // input_NetPrice_input.sendKeys(Keys.ENTER);
                        logger.info("Width for MATERIAL DESCRIPTION input field was SUCCESSFULLY changed.");


                        //Check availability of 'Fixed' check-mark
                        WebElement check_mark_10 = element_2.findElement(By.xpath("td[3]/div/span"));

                        String valueClass10 = check_mark_10.getAttribute("class");
                        System.out.println("The class value for "+title_Column+" check-box is: " + valueClass10);

                        if (valueClass10.contains("lsCheckBox--checked")) {//if not selected then click on it to select it
                            js.executeScript("arguments[0].click();", check_mark_10);
                            logger.info("MATERIAL DESCRIPTION input field was clicked to be unselected in the FIXED column.");
                        } else {
                            logger.info("MATERIAL DESCRIPTION input field was unselected in the FIXED column BY DEFAULT.");
                        }

                        //click vertical scroller to move the list one row up
                        //action.click(scroller_DisplayedColumns).perform();
                        js.executeScript("arguments[0].click();", scroller_DisplayedColumns);

                        break;


                    case "Quantity":

                        WebElement input_Width_11 = element_2.findElement(By.xpath("td[2]/div"));

                        //action.moveToElement(input_Width_1).click().build().perform();
                        //js.executeScript("arguments[0].click();", input_Width_1);
                        input_Width_11.click();

                        logger.info("The 'Quantity' WIDTH field (on 'PERSONALIZATION' popup) was clicked for editing.");

                        waitTillWebElementAvailable(5, input_Width_11.findElement(By.xpath("span/input")), "'Quantity' WIDTH field");

                        WebElement input_Field_11 = input_Width_11.findElement(By.xpath("span/input"));
                        input_Field_11.clear();
                        action.sendKeys(input_Field_11, "74").perform();
                        //input_NetPrice.sendKeys("10");
                        //js.executeScript("arguments[0].value='10,00';", input_NetPrice_input);
                        // Thread.sleep(1000);
                        // input_NetPrice_input.sendKeys(Keys.ENTER);
                        logger.info("Width for QUANTITY input field was SUCCESSFULLY changed.");


                        //Check availability of 'Fixed' check-mark
                        WebElement check_mark_11 = element_2.findElement(By.xpath("td[3]/div/span"));

                        String valueClass11 = check_mark_11.getAttribute("class");
                        System.out.println("The class value for "+title_Column+" check-box is: " + valueClass11);

                        if (valueClass11.contains("lsCheckBox--checked")) {//if not selected then click on it to select it
                            js.executeScript("arguments[0].click();", check_mark_11);
                            logger.info("QUANTITY input field was clicked to be unselected in the FIXED column.");
                        } else {
                            logger.info("QUANTITY input field was unselected in the FIXED column BY DEFAULT.");
                        }

                        //click vertical scroller to move the list one row up
                        //action.click(scroller_DisplayedColumns).perform();
                        js.executeScript("arguments[0].click();", scroller_DisplayedColumns);

                        break;


                    case "Base Unit of Measure":

                        WebElement input_Width_12 = element_2.findElement(By.xpath("td[2]/div"));

                        //action.moveToElement(input_Width_1).click().build().perform();
                        //js.executeScript("arguments[0].click();", input_Width_1);
                        input_Width_12.click();

                        logger.info("The 'Base Unit of Measure' WIDTH field (on 'PERSONALIZATION' popup) was clicked for editing.");

                        waitTillWebElementAvailable(5, input_Width_12.findElement(By.xpath("span/input")), "'Base Unit of Measure' WIDTH field");

                        WebElement input_Field_12 = input_Width_12.findElement(By.xpath("span/input"));
                        input_Field_12.clear();
                        action.sendKeys(input_Field_12, "128").perform();
                        //input_NetPrice.sendKeys("10");
                        //js.executeScript("arguments[0].value='10,00';", input_NetPrice_input);
                        // Thread.sleep(1000);
                        // input_NetPrice_input.sendKeys(Keys.ENTER);
                        logger.info("Width for BASE UNIT OF MEASURE input field was SUCCESSFULLY changed.");


                        //Check availability of 'Fixed' check-mark
                        WebElement check_mark_12 = element_2.findElement(By.xpath("td[3]/div/span"));

                        String valueClass12 = check_mark_12.getAttribute("class");
                        System.out.println("The class value for "+title_Column+" check-box is: " + valueClass12);

                        if (valueClass12.contains("lsCheckBox--checked")) {//if not selected then click on it to select it
                            js.executeScript("arguments[0].click();", check_mark_12);
                            logger.info("BASE UNIT OF MEASURE input field was clicked to be unselected in the FIXED column.");
                        } else {
                            logger.info("BASE UNIT OF MEASURE input field was unselected in the FIXED column BY DEFAULT.");
                        }

                        //click vertical scroller to move the list one row up
                        //action.click(scroller_DisplayedColumns).perform();
                        js.executeScript("arguments[0].click();", scroller_DisplayedColumns);

                        break;


                    case "Plant":

                        WebElement input_Width_13 = element_2.findElement(By.xpath("td[2]/div"));

                        //action.moveToElement(input_Width_1).click().build().perform();
                        //js.executeScript("arguments[0].click();", input_Width_1);
                        input_Width_13.click();

                        logger.info("The 'Plant' WIDTH field (on 'PERSONALIZATION' popup) was clicked for editing.");

                        waitTillWebElementAvailable(5, input_Width_13.findElement(By.xpath("span/input")), "'Plant' WIDTH field");

                        WebElement input_Field_13 = input_Width_13.findElement(By.xpath("span/input"));
                        input_Field_13.clear();
                        action.sendKeys(input_Field_13, "62").perform();
                        //input_NetPrice.sendKeys("10");
                        //js.executeScript("arguments[0].value='10,00';", input_NetPrice_input);
                        // Thread.sleep(1000);
                        // input_NetPrice_input.sendKeys(Keys.ENTER);
                        logger.info("Width for PLANT input field was SUCCESSFULLY changed.");


                        //Check availability of 'Fixed' check-mark
                        WebElement check_mark_13 = element_2.findElement(By.xpath("td[3]/div/span"));

                        String valueClass13 = check_mark_13.getAttribute("class");
                        System.out.println("The class value for "+title_Column+" check-box is: " + valueClass13);

                        if (valueClass13.contains("lsCheckBox--checked")) {//if not selected then click on it to select it
                            js.executeScript("arguments[0].click();", check_mark_13);
                            logger.info("PLANT input field was clicked to be unselected in the FIXED column.");
                        } else {
                            logger.info("PLANT input field was unselected in the FIXED column BY DEFAULT.");
                        }

                        //click vertical scroller to move the list one row up
                        //action.click(scroller_DisplayedColumns).perform();
                        js.executeScript("arguments[0].click();", scroller_DisplayedColumns);

                        break;


                    case "Storage location":

                        WebElement input_Width_14 = element_2.findElement(By.xpath("td[2]/div"));

                        //action.moveToElement(input_Width_1).click().build().perform();
                        //js.executeScript("arguments[0].click();", input_Width_1);
                        input_Width_14.click();

                        logger.info("The 'Storage location' WIDTH field (on 'PERSONALIZATION' popup) was clicked for editing.");

                        waitTillWebElementAvailable(5, input_Width_14.findElement(By.xpath("span/input")), "'Storage location' WIDTH field");

                        WebElement input_Field_14 = input_Width_14.findElement(By.xpath("span/input"));
                        input_Field_14.clear();
                        action.sendKeys(input_Field_14, "106").perform();
                        //input_NetPrice.sendKeys("10");
                        //js.executeScript("arguments[0].value='10,00';", input_NetPrice_input);
                        // Thread.sleep(1000);
                        // input_NetPrice_input.sendKeys(Keys.ENTER);
                        logger.info("Width for STORAGE LOCATION input field was SUCCESSFULLY changed.");


                        //Check availability of 'Fixed' check-mark
                        WebElement check_mark_14 = element_2.findElement(By.xpath("td[3]/div/span"));

                        String valueClass14 = check_mark_14.getAttribute("class");
                        System.out.println("The class value for "+title_Column+" check-box is: " + valueClass14);

                        if (valueClass14.contains("lsCheckBox--checked")) {//if not selected then click on it to select it
                            js.executeScript("arguments[0].click();", check_mark_14);
                            logger.info("STORAGE LOCATION input field was clicked to be unselected in the FIXED column.");
                        } else {
                            logger.info("STORAGE LOCATION input field was unselected in the FIXED column BY DEFAULT.");
                        }

                        //click vertical scroller to move the list one row up
                        //action.click(scroller_DisplayedColumns).perform();
                        js.executeScript("arguments[0].click();", scroller_DisplayedColumns);

                        break;


                    case "Valuation Type":

                        WebElement input_Width_15 = element_2.findElement(By.xpath("td[2]/div"));

                        //action.moveToElement(input_Width_1).click().build().perform();
                        //js.executeScript("arguments[0].click();", input_Width_1);
                        input_Width_15.click();

                        logger.info("The 'Valuation Type' WIDTH field (on 'PERSONALIZATION' popup) was clicked for editing.");

                        waitTillWebElementAvailable(5, input_Width_15.findElement(By.xpath("span/input")), "'Valuation Type' WIDTH field");

                        WebElement input_Field_15 = input_Width_15.findElement(By.xpath("span/input"));
                        input_Field_15.clear();
                        action.sendKeys(input_Field_15, "95").perform();
                        //input_NetPrice.sendKeys("10");
                        //js.executeScript("arguments[0].value='10,00';", input_NetPrice_input);
                        // Thread.sleep(1000);
                        // input_NetPrice_input.sendKeys(Keys.ENTER);
                        logger.info("Width for VALUATION TYPE input field was SUCCESSFULLY changed.");


                        //Check availability of 'Fixed' check-mark
                        WebElement check_mark_15 = element_2.findElement(By.xpath("td[3]/div/span"));

                        String valueClass15 = check_mark_15.getAttribute("class");
                        System.out.println("The class value for "+title_Column+" check-box is: " + valueClass15);

                        if (valueClass15.contains("lsCheckBox--checked")) {//if not selected then click on it to select it
                            js.executeScript("arguments[0].click();", check_mark_15);
                            logger.info("VALUATION TYPE input field was clicked to be unselected in the FIXED column.");
                        } else {
                            logger.info("VALUATION TYPE input field was unselected in the FIXED column BY DEFAULT.");
                        }

                        //click vertical scroller to move the list one row up
                        //action.click(scroller_DisplayedColumns).perform();
                        js.executeScript("arguments[0].click();", scroller_DisplayedColumns);

                        break;


                    case "Handling Type":

                        WebElement input_Width_16 = element_2.findElement(By.xpath("td[2]/div"));

                        //action.moveToElement(input_Width_1).click().build().perform();
                        //js.executeScript("arguments[0].click();", input_Width_1);
                        input_Width_16.click();

                        logger.info("The 'Handling Type' WIDTH field (on 'PERSONALIZATION' popup) was clicked for editing.");

                        waitTillWebElementAvailable(5, input_Width_16.findElement(By.xpath("span/input")), "'Handling Type' WIDTH field");

                        WebElement input_Field_16 = input_Width_16.findElement(By.xpath("span/input"));
                        input_Field_16.clear();
                        action.sendKeys(input_Field_16, "95").perform();
                        //input_NetPrice.sendKeys("10");
                        //js.executeScript("arguments[0].value='10,00';", input_NetPrice_input);
                        // Thread.sleep(1000);
                        // input_NetPrice_input.sendKeys(Keys.ENTER);
                        logger.info("Width for HANDLING TYPE input field was SUCCESSFULLY changed.");


                        //Check availability of 'Fixed' check-mark
                        WebElement check_mark_16 = element_2.findElement(By.xpath("td[3]/div/span"));

                        String valueClass16 = check_mark_16.getAttribute("class");
                        System.out.println("The class value for "+title_Column+" check-box is: " + valueClass16);

                        if (valueClass16.contains("lsCheckBox--checked")) {//if not selected then click on it to select it
                            js.executeScript("arguments[0].click();", check_mark_16);
                            logger.info("HANDLING TYPE input field was clicked to be unselected in the FIXED column.");
                        } else {
                            logger.info("HANDLING TYPE input field was unselected in the FIXED column BY DEFAULT.");
                        }

                        //click vertical scroller to move the list one row up
                        //action.click(scroller_DisplayedColumns).perform();
                        js.executeScript("arguments[0].click();", scroller_DisplayedColumns);

                        break;


                    case "Posting Date":

                        WebElement input_Width_17 = element_2.findElement(By.xpath("td[2]/div"));

                        //action.moveToElement(input_Width_1).click().build().perform();
                        //js.executeScript("arguments[0].click();", input_Width_1);
                        input_Width_17.click();

                        logger.info("The 'Posting Date' WIDTH field (on 'PERSONALIZATION' popup) was clicked for editing.");

                        waitTillWebElementAvailable(5, input_Width_17.findElement(By.xpath("span/input")), "'Posting Date' WIDTH field");

                        WebElement input_Field_17 = input_Width_17.findElement(By.xpath("span/input"));
                        input_Field_17.clear();
                        action.sendKeys(input_Field_17, "88").perform();
                        //input_NetPrice.sendKeys("10");
                        //js.executeScript("arguments[0].value='10,00';", input_NetPrice_input);
                        // Thread.sleep(1000);
                        // input_NetPrice_input.sendKeys(Keys.ENTER);
                        logger.info("Width for POSTING DATE input field was SUCCESSFULLY changed.");


                        //Check availability of 'Fixed' check-mark
                        WebElement check_mark_17 = element_2.findElement(By.xpath("td[3]/div/span"));

                        String valueClass17 = check_mark_17.getAttribute("class");
                        System.out.println("The class value for "+title_Column+" check-box is: " + valueClass17);

                        if (valueClass17.contains("lsCheckBox--checked")) {//if not selected then click on it to select it
                            js.executeScript("arguments[0].click();", check_mark_17);
                            logger.info("POSTING DATE input field was clicked to be unselected in the FIXED column.");
                        } else {
                            logger.info("POSTING DATE input field was unselected in the FIXED column BY DEFAULT.");
                        }

                        //click vertical scroller to move the list one row up
                        //action.click(scroller_DisplayedColumns).perform();
                        js.executeScript("arguments[0].click();", scroller_DisplayedColumns);

                        break;


                    case "Partner Function":

                        WebElement input_Width_18 = element_2.findElement(By.xpath("td[2]/div"));

                        //action.moveToElement(input_Width_1).click().build().perform();
                        //js.executeScript("arguments[0].click();", input_Width_1);
                        input_Width_18.click();

                        logger.info("The 'Partner Function' WIDTH field (on 'PERSONALIZATION' popup) was clicked for editing.");

                        waitTillWebElementAvailable(5, input_Width_18.findElement(By.xpath("span/input")), "'Partner Function' WIDTH field");

                        WebElement input_Field_18 = input_Width_18.findElement(By.xpath("span/input"));
                        input_Field_18.clear();
                        action.sendKeys(input_Field_18, "108").perform();
                        //input_NetPrice.sendKeys("10");
                        //js.executeScript("arguments[0].value='10,00';", input_NetPrice_input);
                        // Thread.sleep(1000);
                        // input_NetPrice_input.sendKeys(Keys.ENTER);
                        logger.info("Width for PARTNER FUNCTION input field was SUCCESSFULLY changed.");


                        //Check availability of 'Fixed' check-mark
                        WebElement check_mark_18 = element_2.findElement(By.xpath("td[3]/div/span"));

                        String valueClass18 = check_mark_18.getAttribute("class");
                        System.out.println("The class value for "+title_Column+" check-box is: " + valueClass18);

                        if (valueClass18.contains("lsCheckBox--checked")) {//if not selected then click on it to select it
                            js.executeScript("arguments[0].click();", check_mark_18);
                            logger.info("PARTNER FUNCTION input field was clicked to be unselected in the FIXED column.");
                        } else {
                            logger.info("PARTNER FUNCTION input field was unselected in the FIXED column BY DEFAULT.");
                        }

                        //click vertical scroller to move the list one row up
                        //action.click(scroller_DisplayedColumns).perform();
                        js.executeScript("arguments[0].click();", scroller_DisplayedColumns);

                        break;


                    case "Tank number":

                        WebElement input_Width_19 = element_2.findElement(By.xpath("td[2]/div"));

                        //action.moveToElement(input_Width_1).click().build().perform();
                        //js.executeScript("arguments[0].click();", input_Width_19);
                        input_Width_19.click();

                        logger.info("The 'Tank number' WIDTH field (on 'PERSONALIZATION' popup) was clicked for editing.");

                        waitTillWebElementAvailable(5, input_Width_19.findElement(By.xpath("span/input")), "'Tank number' WIDTH field");

                        WebElement input_Field_19 = input_Width_19.findElement(By.xpath("span/input"));
                        input_Field_19.clear();
                        action.sendKeys(input_Field_19, "72").perform();
                        //input_NetPrice.sendKeys("10");
                        //js.executeScript("arguments[0].value='10,00';", input_NetPrice_input);
                        // Thread.sleep(1000);
                        // input_NetPrice_input.sendKeys(Keys.ENTER);
                        logger.info("Width for TANK NUMBER input field was SUCCESSFULLY changed.");


                        //Check availability of 'Fixed' check-mark
                        WebElement check_mark_19 = element_2.findElement(By.xpath("td[3]/div/span"));

                        String valueClass19 = check_mark_19.getAttribute("class");
                        System.out.println("The class value for "+title_Column+" check-box is: " + valueClass19);

                        if (valueClass19.contains("lsCheckBox--checked")) {//if not selected then click on it to select it
                            js.executeScript("arguments[0].click();", check_mark_19);
                            logger.info("TANK NUMBER input field was clicked to be unselected in the FIXED column.");
                        } else {
                            logger.info("TANK NUMBER input field was unselected in the FIXED column BY DEFAULT.");
                        }

                        //click vertical scroller to move the list one row up
                        //action.click(scroller_DisplayedColumns).perform();
                        js.executeScript("arguments[0].click();", scroller_DisplayedColumns);

                        break;


                    case "Partners":

                        WebElement input_Width_20 = element_2.findElement(By.xpath("td[2]/div"));

                        //action.moveToElement(input_Width_1).click().build().perform();
                        //js.executeScript("arguments[0].click();", input_Width_1);
                        input_Width_20.click();

                        logger.info("The 'Partners' WIDTH field (on 'PERSONALIZATION' popup) was clicked for editing.");

                        waitTillWebElementAvailable(5, input_Width_20.findElement(By.xpath("span/input")), "'Partners' WIDTH field");


                        WebElement input_Field_20 = input_Width_20.findElement(By.xpath("span/input"));
                        input_Field_20.clear();
                        action.sendKeys(input_Field_20, "72").perform();
                        //input_NetPrice.sendKeys("10");
                        //js.executeScript("arguments[0].value='10,00';", input_NetPrice_input);
                        // Thread.sleep(1000);
                        // input_NetPrice_input.sendKeys(Keys.ENTER);
                        logger.info("Width for PARTNERS input field was SUCCESSFULLY changed.");


                        //Check availability of 'Fixed' check-mark
                        WebElement check_mark_20 = element_2.findElement(By.xpath("td[3]/div/span"));

                        String valueClass20 = check_mark_20.getAttribute("class");
                        System.out.println("The class value for "+title_Column+" check-box is: " + valueClass20);

                        if (valueClass20.contains("lsCheckBox--checked")) {//if not selected then click on it to select it
                            js.executeScript("arguments[0].click();", check_mark_20);
                            logger.info("PARTNERS input field was clicked to be unselected in the FIXED column.");
                        } else {
                            logger.info("PARTNERS input field was unselected in the FIXED column BY DEFAULT.");
                        }

                        //click vertical scroller to move the list one row up
                        //action.click(scroller_DisplayedColumns).perform();
                        js.executeScript("arguments[0].click();", scroller_DisplayedColumns);

                        break;


                    case "Net Price":

                        WebElement input_Width_21 = element_2.findElement(By.xpath("td[2]/div"));

                        //action.moveToElement(input_Width_1).click().build().perform();
                        //js.executeScript("arguments[0].click();", input_Width_1);
                        input_Width_21.click();

                        logger.info("The 'Net Price' WIDTH field (on 'PERSONALIZATION' popup) was clicked for editing.");

                        waitTillWebElementAvailable(5, input_Width_21.findElement(By.xpath("span/input")), "'Net Price' WIDTH field");

                        WebElement input_Field_21 = input_Width_21.findElement(By.xpath("span/input"));
                        input_Field_21.clear();
                        action.sendKeys(input_Field_21, "81").perform();
                        //input_NetPrice.sendKeys("10");
                        //js.executeScript("arguments[0].value='10,00';", input_NetPrice_input);
                        // Thread.sleep(1000);
                        // input_NetPrice_input.sendKeys(Keys.ENTER);
                        logger.info("Width for NET PRICE input field was SUCCESSFULLY changed.");


                        //Check availability of 'Fixed' check-mark
                        WebElement check_mark_21 = element_2.findElement(By.xpath("td[3]/div/span"));

                        String valueClass21 = check_mark_21.getAttribute("class");
                        System.out.println("The class value for "+title_Column+" check-box is: " + valueClass21);

                        if (valueClass21.contains("lsCheckBox--checked")) {//if not selected then click on it to select it
                            js.executeScript("arguments[0].click();", check_mark_21);
                            logger.info("NET PRICE input field was clicked to be unselected in the FIXED column.");
                        } else {
                            logger.info("NET PRICE input field was unselected in the FIXED column BY DEFAULT.");
                        }

                        //click vertical scroller to move the list one row up
                        //action.click(scroller_DisplayedColumns).perform();
                        js.executeScript("arguments[0].click();", scroller_DisplayedColumns);

                        break;


                    case "Currency":

                        WebElement input_Width_22 = element_2.findElement(By.xpath("td[2]/div"));

                        //action.moveToElement(input_Width_1).click().build().perform();
                        //js.executeScript("arguments[0].click();", input_Width_1);
                        input_Width_22.click();

                        logger.info("The 'Currency' WIDTH field (on 'PERSONALIZATION' popup) was clicked for editing.");

                        waitTillWebElementAvailable(5, input_Width_22.findElement(By.xpath("span/input")), "'Currency' WIDTH field");

                        WebElement input_Field_22 = input_Width_22.findElement(By.xpath("span/input"));
                        input_Field_22.clear();
                        action.sendKeys(input_Field_22, "79").perform();
                        //input_NetPrice.sendKeys("10");
                        //js.executeScript("arguments[0].value='10,00';", input_NetPrice_input);
                        // Thread.sleep(1000);
                        // input_NetPrice_input.sendKeys(Keys.ENTER);
                        logger.info("Width for CURRENCY input field was SUCCESSFULLY changed.");


                        //Check availability of 'Fixed' check-mark
                        WebElement check_mark_22 = element_2.findElement(By.xpath("td[3]/div/span"));

                        String valueClass22 = check_mark_22.getAttribute("class");
                        System.out.println("The class value for "+title_Column+" check-box is: " + valueClass22);

                        if (valueClass22.contains("lsCheckBox--checked")) {//if not selected then click on it to select it
                            js.executeScript("arguments[0].click();", check_mark_22);
                            logger.info("CURRENCY input field was clicked to be unselected in the FIXED column.");
                        } else {
                            logger.info("CURRENCY input field was unselected in the FIXED column BY DEFAULT.");
                        }

                        //click vertical scroller to move the list one row up
                        //action.click(scroller_DisplayedColumns).perform();
                        js.executeScript("arguments[0].click();", scroller_DisplayedColumns);

                        break;


                    case "Pricing Unit":

                        WebElement input_Width_23 = element_2.findElement(By.xpath("td[2]/div"));

                        //action.moveToElement(input_Width_1).click().build().perform();
                        //js.executeScript("arguments[0].click();", input_Width_1);
                        input_Width_23.click();

                        logger.info("The 'Pricing Unit' WIDTH field (on 'PERSONALIZATION' popup) was clicked for editing.");

                        waitTillWebElementAvailable(5, input_Width_23.findElement(By.xpath("span/input")), "'Pricing Unit' WIDTH field");

                        WebElement input_Field_23 = input_Width_23.findElement(By.xpath("span/input"));
                        input_Field_23.clear();
                        action.sendKeys(input_Field_23, "96").perform();
                        //input_NetPrice.sendKeys("10");
                        //js.executeScript("arguments[0].value='10,00';", input_NetPrice_input);
                        // Thread.sleep(1000);
                        // input_NetPrice_input.sendKeys(Keys.ENTER);
                        logger.info("Width for PRICING UNIT input field was SUCCESSFULLY changed.");


                        //Check availability of 'Fixed' check-mark
                        WebElement check_mark_23 = element_2.findElement(By.xpath("td[3]/div/span"));

                        String valueClass23 = check_mark_23.getAttribute("class");
                        System.out.println("The class value for "+title_Column+" check-box is: " + valueClass23);

                        if (valueClass23.contains("lsCheckBox--checked")) {//if not selected then click on it to select it
                            js.executeScript("arguments[0].click();", check_mark_23);
                            logger.info("PRICING UNIT input field was clicked to be unselected in the FIXED column.");
                        } else {
                            logger.info("PRICING UNIT input field was unselected in the FIXED column BY DEFAULT.");
                        }

                        //click vertical scroller to move the list one row up
                        //action.click(scroller_DisplayedColumns).perform();
                        js.executeScript("arguments[0].click();", scroller_DisplayedColumns);

                        break;


                    case "Unit of Measure":

                        WebElement input_Width_24 = element_2.findElement(By.xpath("td[2]/div"));

                        //action.moveToElement(input_Width_1).click().build().perform();
                        //js.executeScript("arguments[0].click();", input_Width_1);
                        input_Width_24.click();

                        logger.info("The 'Unit of Measure' WIDTH field (on 'PERSONALIZATION' popup) was clicked for editing.");

                        waitTillWebElementAvailable(5, input_Width_24.findElement(By.xpath("span/input")), "'Unit of Measure' WIDTH field");

                        WebElement input_Field_24 = input_Width_24.findElement(By.xpath("span/input"));
                        input_Field_24.clear();
                        action.sendKeys(input_Field_24, "90").perform();
                        //input_NetPrice.sendKeys("10");
                        //js.executeScript("arguments[0].value='10,00';", input_NetPrice_input);
                        // Thread.sleep(1000);
                        // input_NetPrice_input.sendKeys(Keys.ENTER);
                        logger.info("Width for UNIT OF MEASURE input field was SUCCESSFULLY changed.");


                        //Check availability of 'Fixed' check-mark
                        WebElement check_mark_24 = element_2.findElement(By.xpath("td[3]/div/span"));

                        String valueClass24 = check_mark_24.getAttribute("class");
                        System.out.println("The class value for "+title_Column+" check-box is: " + valueClass24);

                        if (valueClass24.contains("lsCheckBox--checked")) {//if not selected then click on it to select it
                            js.executeScript("arguments[0].click();", check_mark_24);
                            logger.info("UNIT OF MEASURE input field was clicked to be unselected in the FIXED column.");
                        } else {
                            logger.info("UNIT OF MEASURE input field was unselected in the FIXED column BY DEFAULT.");
                        }

                        //click vertical scroller to move the list one row up
                        //action.click(scroller_DisplayedColumns).perform();
                        js.executeScript("arguments[0].click();", scroller_DisplayedColumns);

                        break;


                    case "Quantity in Percent":

                        WebElement input_Width_25 = element_2.findElement(By.xpath("td[2]/div"));

                        //action.moveToElement(input_Width_1).click().build().perform();
                        //js.executeScript("arguments[0].click();", input_Width_1);
                        input_Width_25.click();

                        logger.info("The 'Quantity in Percent' WIDTH field (on 'PERSONALIZATION' popup) was clicked for editing.");

                        waitTillWebElementAvailable(5, input_Width_25.findElement(By.xpath("span/input")), "'Quantity in Percent' WIDTH field");

                        WebElement input_Field_25 = input_Width_25.findElement(By.xpath("span/input"));
                        input_Field_25.clear();
                        action.sendKeys(input_Field_25, "70").perform();
                        //input_NetPrice.sendKeys("10");
                        //js.executeScript("arguments[0].value='10,00';", input_NetPrice_input);
                        // Thread.sleep(1000);
                        // input_NetPrice_input.sendKeys(Keys.ENTER);
                        logger.info("Width for QUANTITY IN PERCENT input field was SUCCESSFULLY changed.");


                        //Check availability of 'Fixed' check-mark
                        WebElement check_mark_25 = element_2.findElement(By.xpath("td[3]/div/span"));

                        String valueClass25 = check_mark_25.getAttribute("class");
                        System.out.println("The class value for "+title_Column+" check-box is: " + valueClass25);

                        if (valueClass25.contains("lsCheckBox--checked")) {//if not selected then click on it to select it
                            js.executeScript("arguments[0].click();", check_mark_25);
                            logger.info("QUANTITY IN PERCENT input field was clicked to be unselected in the FIXED column.");
                        } else {
                            logger.info("QUANTITY IN PERCENT input field was unselected in the FIXED column BY DEFAULT.");
                        }

                        //click vertical scroller to move the list one row up
                        //action.click(scroller_DisplayedColumns).perform();
                        js.executeScript("arguments[0].click();", scroller_DisplayedColumns);

                        break;


                    case "Stock":

                        WebElement input_Width_26 = element_2.findElement(By.xpath("td[2]/div"));

                        //action.moveToElement(input_Width_1).click().build().perform();
                        //js.executeScript("arguments[0].click();", input_Width_1);
                        input_Width_26.click();

                        logger.info("The 'Stock' WIDTH field (on 'PERSONALIZATION' popup) was clicked for editing.");

                        waitTillWebElementAvailable(5, input_Width_26.findElement(By.xpath("span/input")), "'Stock' WIDTH field");

                        WebElement input_Field_26 = input_Width_26.findElement(By.xpath("span/input"));
                        input_Field_26.clear();
                        action.sendKeys(input_Field_26, "70").perform();
                        //input_NetPrice.sendKeys("10");
                        //js.executeScript("arguments[0].value='10,00';", input_NetPrice_input);
                        // Thread.sleep(1000);
                        // input_NetPrice_input.sendKeys(Keys.ENTER);
                        logger.info("Width for STOCK input field was SUCCESSFULLY changed.");


                        //Check availability of 'Fixed' check-mark
                        WebElement check_mark_26 = element_2.findElement(By.xpath("td[3]/div/span"));

                        String valueClass26 = check_mark_26.getAttribute("class");
                        System.out.println("The class value for "+title_Column+" check-box is: " + valueClass26);

                        if (valueClass26.contains("lsCheckBox--checked")) {//if not selected then click on it to select it
                            js.executeScript("arguments[0].click();", check_mark_26);
                            logger.info("STOCK input field was clicked to be unselected in the FIXED column.");
                        } else {
                            logger.info("STOCK input field was unselected in the FIXED column BY DEFAULT.");
                        }

                        //click vertical scroller to move the list one row up
                        //action.click(scroller_DisplayedColumns).perform();
                        js.executeScript("arguments[0].click();", scroller_DisplayedColumns);

                        break;


                    case "UoM for Quantity from Dipping":

                        WebElement input_Width_27 = element_2.findElement(By.xpath("td[2]/div"));

                        //action.moveToElement(input_Width_1).click().build().perform();
                        //js.executeScript("arguments[0].click();", input_Width_1);
                        input_Width_27.click();

                        logger.info("The 'UoM for Quantity from Dipping' WIDTH field (on 'PERSONALIZATION' popup) was clicked for editing.");

                        waitTillWebElementAvailable(5, input_Width_27.findElement(By.xpath("span/input")), "'UoM for Quantity from Dipping' WIDTH field");

                        WebElement input_Field_27 = input_Width_27.findElement(By.xpath("span/input"));
                        input_Field_27.clear();
                        action.sendKeys(input_Field_27, "70").perform();
                        //input_NetPrice.sendKeys("10");
                        //js.executeScript("arguments[0].value='10,00';", input_NetPrice_input);
                        // Thread.sleep(1000);
                        // input_NetPrice_input.sendKeys(Keys.ENTER);
                        logger.info("Width for UOM FOR QUANTITY FROM DIPPING input field was SUCCESSFULLY changed.");


                        //Check availability of 'Fixed' check-mark
                        WebElement check_mark_27 = element_2.findElement(By.xpath("td[3]/div/span"));

                        String valueClass27 = check_mark_27.getAttribute("class");
                        System.out.println("The class value for "+title_Column+" check-box is: " + valueClass27);

                        if (valueClass27.contains("lsCheckBox--checked")) {//if not selected then click on it to select it
                            js.executeScript("arguments[0].click();", check_mark_27);
                            logger.info("UOM FOR QUANTITY FROM DIPPING input field was clicked to be unselected in the FIXED column.");
                        } else {
                            logger.info("UOM FOR QUANTITY FROM DIPPING input field was unselected in the FIXED column BY DEFAULT.");
                        }

                        //click vertical scroller to move the list one row up
                        //action.click(scroller_DisplayedColumns).perform();
                        js.executeScript("arguments[0].click();", scroller_DisplayedColumns);

                        break;

                    case "Difference Reason":

                        WebElement input_Width_28 = element_2.findElement(By.xpath("td[2]/div"));

                        //action.moveToElement(input_Width_1).click().build().perform();
                        //js.executeScript("arguments[0].click();", input_Width_1);
                        input_Width_28.click();

                        logger.info("The 'DIFFERENCE REASON' WIDTH field (on 'PERSONALIZATION' popup) was clicked for editing.");

                        waitTillWebElementAvailable(5, input_Width_28.findElement(By.xpath("span/input")), "'Difference Reason' WIDTH field");

                        WebElement input_Field_28 = input_Width_28.findElement(By.xpath("span/input"));
                        input_Field_28.clear();
                        action.sendKeys(input_Field_28, "70").perform();
                        //input_NetPrice.sendKeys("10");
                        //js.executeScript("arguments[0].value='10,00';", input_NetPrice_input);
                        // Thread.sleep(1000);
                        // input_NetPrice_input.sendKeys(Keys.ENTER);
                        logger.info("Width for DIFFERENCE REASON input field was SUCCESSFULLY changed.");


                        //Check availability of 'Fixed' check-mark
                        WebElement check_mark_28 = element_2.findElement(By.xpath("td[3]/div/span"));

                        String valueClass28 = check_mark_28.getAttribute("class");
                        System.out.println("The class value for "+title_Column+" check-box is: " + valueClass28);

                        if (valueClass28.contains("lsCheckBox--checked")) {//if not selected then click on it to select it
                            js.executeScript("arguments[0].click();", check_mark_28);
                            logger.info("DIFFERENCE REASON input field was clicked to be unselected in the FIXED column.");
                        } else {
                            logger.info("DIFFERENCE REASON FROM DIPPING input field was unselected in the FIXED column BY DEFAULT.");
                        }

                        //click vertical scroller to move the list one row up
                        //action.click(scroller_DisplayedColumns).perform();
                        js.executeScript("arguments[0].click();", scroller_DisplayedColumns);

                        break;

                    default:
                }


            }

            if (Test_Cases.conf_SystemClient.equals("OGQ_100")) {

                WebElement scroller_DisplayedColumns = driver.findElement(By.xpath("//span[contains (text(), 'Displayed Columns')]/ancestor::table[contains (@class, 'urSTCS urST3WhlBrd urST3WhlNoTit urST5SelColUiGeneric urHtmlTableReset')]/tbody[1]/tr[2]/td[3]/div/table/tbody/tr[3]/td/div"));

                switch (title_Column) {
                    case "Item Status":

                        WebElement input_Width_1 = element_2.findElement(By.xpath("td[2]/div"));

                        //action.moveToElement(input_Width_1).click().build().perform();
                        //js.executeScript("arguments[0].click();", input_Width_1);
                        input_Width_1.click();

                        logger.info("The 'Item Status' WIDTH field (on 'PERSONALIZATION' popup) was clicked for editing.");

                        waitTillWebElementAvailable(5, input_Width_1.findElement(By.xpath("span/input")), "'Item Status' WIDTH field");
                        //Thread.sleep(500);

                        WebElement input_Field_1 = input_Width_1.findElement(By.xpath("span/input"));
                        input_Field_1.clear();
                        action.sendKeys(input_Field_1, "71").perform();
                        //input_Field_1.sendKeys("71");
                        //js.executeScript("arguments[0].value='71';", input_Field_1);
                        // Thread.sleep(1000);
                        // input_NetPrice_input.sendKeys(Keys.ENTER);
                        logger.info("Width for ITEM STATUS input field was SUCCESSFULLY changed.");


                        //Check availability of 'Fixed' check-mark
                        WebElement check_mark_1 = element_2.findElement(By.xpath("td[3]/div/span/input"));

                        if (!check_mark_1.isSelected()) {//if not selected then click on it to select it
                            js.executeScript("arguments[0].click();", check_mark_1);
                            logger.info("ITEM STATUS input field was clicked to be selected in the FIXED column.");
                        } else {
                            logger.info("ITEM STATUS input field was selected in the FIXED column BY DEFAULT.");
                        }

                        //click vertical scroller to move the list one row up
                        //action.click(scroller_DisplayedColumns).perform();
                        js.executeScript("arguments[0].click();", scroller_DisplayedColumns);

                        break;


                    case "Transfer Posting":

                        WebElement input_Width_2 = element_2.findElement(By.xpath("td[2]/div"));

                        //action.moveToElement(input_Width_1).click().build().perform();
                        //js.executeScript("arguments[0].click();", input_Width_1);
                        input_Width_2.click();

                        logger.info("The 'Transfer Posting' WIDTH field (on 'PERSONALIZATION' popup) was clicked for editing.");

                        waitTillWebElementAvailable(5, input_Width_2.findElement(By.xpath("span/input")), "'Transfer Posting' WIDTH field");
                        //Thread.sleep(500);

                        WebElement input_Field_2 = input_Width_2.findElement(By.xpath("span/input"));
                        input_Field_2.clear();
                        action.sendKeys(input_Field_2, "98").perform();
                        //input_Field_2.sendKeys("98");
                        //js.executeScript("arguments[0].value='98';", input_Field_2);
                        // Thread.sleep(1000);
                        // input_NetPrice_input.sendKeys(Keys.ENTER);
                        logger.info("Width for TRANSFER POSTING input field was SUCCESSFULLY changed.");


                        //Check availability of 'Fixed' check-mark
                        WebElement check_mark_2 = element_2.findElement(By.xpath("td[3]/div/span/input"));

                        if (!check_mark_2.isSelected()) {//if not selected then click on it to select it
                            js.executeScript("arguments[0].click();", check_mark_2);
                            logger.info("TRANSFER POSTING input field was clicked to be selected in the FIXED column.");
                        } else {
                            logger.info("TRANSFER POSTING input field was selected in the FIXED column BY DEFAULT.");
                        }

                        //click vertical scroller to move the list one row up
                        // action.click(scroller_DisplayedColumns).perform();
                        js.executeScript("arguments[0].click();", scroller_DisplayedColumns);

                        break;


                    case "Item Number":

                        WebElement input_Width_3 = element_2.findElement(By.xpath("td[2]/div"));

                        //action.moveToElement(input_Width_1).click().build().perform();
                        //js.executeScript("arguments[0].click();", input_Width_1);
                        input_Width_3.click();

                        logger.info("The 'Item Number' WIDTH field (on 'PERSONALIZATION' popup) was clicked for editing.");

                        waitTillWebElementAvailable(5, input_Width_3.findElement(By.xpath("span/input")), "'Item Number' WIDTH field");
                        //Thread.sleep(500);

                        WebElement input_Field_3 = input_Width_3.findElement(By.xpath("span/input"));
                        input_Field_3.clear();
                        action.sendKeys(input_Field_3, "94").perform();
                        //input_Field_3.sendKeys("94");
                        //js.executeScript("arguments[0].value='10,00';", input_NetPrice_input);
                        // Thread.sleep(1000);
                        // input_NetPrice_input.sendKeys(Keys.ENTER);
                        logger.info("Width for ITEM NUMBER input field was SUCCESSFULLY changed.");


                        //Check availability of 'Fixed' check-mark
                        WebElement check_mark_3 = element_2.findElement(By.xpath("td[3]/div/span/input"));

                        if (!check_mark_3.isSelected()) {//if not selected then click on it to select it
                            js.executeScript("arguments[0].click();", check_mark_3);
                            logger.info("ITEM NUMBER input field was clicked to be selected in the FIXED column.");
                        } else {
                            logger.info("ITEM NUMBER input field was selected in the FIXED column BY DEFAULT.");
                        }

                        //click vertical scroller to move the list one row up
                        //action.click(scroller_DisplayedColumns).perform();
                        js.executeScript("arguments[0].click();", scroller_DisplayedColumns);

                        break;


                    case "Sequence Number of the Item":

                        WebElement input_Width_4 = element_2.findElement(By.xpath("td[2]/div"));

                        //action.moveToElement(input_Width_1).click().build().perform();
                        //js.executeScript("arguments[0].click();", input_Width_1);
                        input_Width_4.click();

                        logger.info("The 'Sequence Number of the Item' WIDTH field (on 'PERSONALIZATION' popup) was clicked for editing.");

                        waitTillWebElementAvailable(5, input_Width_4.findElement(By.xpath("span/input")), "'Sequence Number of the Item' WIDTH field");
                        //Thread.sleep(500);

                        WebElement input_Field_4 = input_Width_4.findElement(By.xpath("span/input"));
                        input_Field_4.clear();
                        action.sendKeys(input_Field_4, "134").perform();
                        //input_NetPrice.sendKeys("10");
                        //js.executeScript("arguments[0].value='10,00';", input_NetPrice_input);
                        // Thread.sleep(1000);
                        // input_NetPrice_input.sendKeys(Keys.ENTER);
                        logger.info("Width for SEQUENCE NUMBER OF THE ITEM input field was SUCCESSFULLY changed.");


                        //Check availability of 'Fixed' check-mark
                        WebElement check_mark_4 = element_2.findElement(By.xpath("td[3]/div/span/input"));

                        if (!check_mark_4.isSelected()) {//if not selected then click on it to select it
                            js.executeScript("arguments[0].click();", check_mark_4);
                            logger.info("SEQUENCE NUMBER OF THE ITEM input field was clicked to be selected in the FIXED column.");
                        } else {
                            logger.info("SEQUENCE NUMBER OF THE ITEM input field was selected in the FIXED column BY DEFAULT.");
                        }

                        //click vertical scroller to move the list one row up
                        //action.click(scroller_DisplayedColumns).perform();
                        js.executeScript("arguments[0].click();", scroller_DisplayedColumns);

                        break;


                    case "Posting Sequence":

                        WebElement input_Width_5 = element_2.findElement(By.xpath("td[2]/div"));

                        //action.moveToElement(input_Width_1).click().build().perform();
                        //js.executeScript("arguments[0].click();", input_Width_1);
                        input_Width_5.click();

                        logger.info("The 'Posting Sequence' WIDTH field (on 'PERSONALIZATION' popup) was clicked for editing.");

                        waitTillWebElementAvailable(5, input_Width_5.findElement(By.xpath("span/input")), "'Posting Sequence' WIDTH field");
                        //Thread.sleep(500);

                        WebElement input_Field_5 = input_Width_5.findElement(By.xpath("span/input"));
                        input_Field_5.clear();
                        action.sendKeys(input_Field_5, "115").perform();
                        //input_NetPrice.sendKeys("10");
                        //js.executeScript("arguments[0].value='10,00';", input_NetPrice_input);
                        // Thread.sleep(1000);
                        // input_NetPrice_input.sendKeys(Keys.ENTER);
                        logger.info("Width for POSTING SEQUENCE input field was SUCCESSFULLY changed.");


                        //Check availability of 'Fixed' check-mark
                        WebElement check_mark_5 = element_2.findElement(By.xpath("td[3]/div/span/input"));

                        if (!check_mark_5.isSelected()) {//if not selected then click on it to select it
                            js.executeScript("arguments[0].click();", check_mark_5);
                            logger.info("POSTING SEQUENCE input field was clicked to be selected in the FIXED column.");
                        } else {
                            logger.info("POSTING SEQUENCE input field was selected in the FIXED column BY DEFAULT.");
                        }

                        //click vertical scroller to move the list one row up
                        //action.click(scroller_DisplayedColumns).perform();
                        js.executeScript("arguments[0].click();", scroller_DisplayedColumns);

                        break;


                    case "Item Category":

                        WebElement input_Width_6 = element_2.findElement(By.xpath("td[2]/div"));

                        //action.moveToElement(input_Width_1).click().build().perform();
                        //js.executeScript("arguments[0].click();", input_Width_1);
                        input_Width_6.click();

                        logger.info("The 'Item Category' WIDTH field (on 'PERSONALIZATION' popup) was clicked for editing.");

                        waitTillWebElementAvailable(5, input_Width_6.findElement(By.xpath("span/input")), "'Item Category' WIDTH field");
                        //Thread.sleep(500);

                        WebElement input_Field_6 = input_Width_6.findElement(By.xpath("span/input"));
                        input_Field_6.clear();
                        action.sendKeys(input_Field_6, "92").perform();
                        //input_NetPrice.sendKeys("10");
                        //js.executeScript("arguments[0].value='10,00';", input_NetPrice_input);
                        // Thread.sleep(1000);
                        // input_NetPrice_input.sendKeys(Keys.ENTER);
                        logger.info("Width for ITEM CATEGORY input field was SUCCESSFULLY changed.");


                        //Check availability of 'Fixed' check-mark
                        WebElement check_mark_6 = element_2.findElement(By.xpath("td[3]/div/span/input"));

                        if (!check_mark_6.isSelected()) {//if not selected then click on it to select it
                            js.executeScript("arguments[0].click();", check_mark_6);
                            logger.info("ITEM CATEGORY input field was clicked to be selected in the FIXED column.");
                        } else {
                            logger.info("ITEM CATEGORY input field was selected in the FIXED column BY DEFAULT.");
                        }

                        //click vertical scroller to move the list one row up
                        //action.click(scroller_DisplayedColumns).perform();
                        js.executeScript("arguments[0].click();", scroller_DisplayedColumns);

                        break;


                    case "Reference Document":

                        WebElement input_Width_7 = element_2.findElement(By.xpath("td[2]/div"));

                        //action.moveToElement(input_Width_1).click().build().perform();
                        //js.executeScript("arguments[0].click();", input_Width_1);
                        input_Width_7.click();

                        logger.info("The 'Reference Document' WIDTH field (on 'PERSONALIZATION' popup) was clicked for editing.");

                        waitTillWebElementAvailable(5, input_Width_7.findElement(By.xpath("span/input")), "'Reference Document' WIDTH field");
                        //Thread.sleep(500);

                        WebElement input_Field_7 = input_Width_7.findElement(By.xpath("span/input"));
                        input_Field_7.clear();
                        action.sendKeys(input_Field_7, "127").perform();
                        //input_NetPrice.sendKeys("10");
                        //js.executeScript("arguments[0].value='10,00';", input_NetPrice_input);
                        // Thread.sleep(1000);
                        // input_NetPrice_input.sendKeys(Keys.ENTER);
                        logger.info("Width for REFERENCE DOCUMENT input field was SUCCESSFULLY changed.");


                        //Check availability of 'Fixed' check-mark
                        WebElement check_mark_7 = element_2.findElement(By.xpath("td[3]/div/span/input"));

                        if (check_mark_7.isSelected()) {//if selected, then click on it to unselect it
                            js.executeScript("arguments[0].click();", check_mark_7);
                            logger.info("REFERENCE DOCUMENT input field was clicked to be unselected in the FIXED column.");
                        } else {
                            logger.info("REFERENCE DOCUMENT input field was unselected in the FIXED column BY DEFAULT.");
                        }

                        //click vertical scroller to move the list one row up
                        //action.click(scroller_DisplayedColumns).perform();
                        js.executeScript("arguments[0].click();", scroller_DisplayedColumns);

                        break;


                    case "Reference Item":

                        WebElement input_Width_8 = element_2.findElement(By.xpath("td[2]/div"));

                        //action.moveToElement(input_Width_1).click().build().perform();
                        //js.executeScript("arguments[0].click();", input_Width_1);
                        input_Width_8.click();

                        logger.info("The 'Reference Item' WIDTH field (on 'PERSONALIZATION' popup) was clicked for editing.");

                        waitTillWebElementAvailable(5, input_Width_8.findElement(By.xpath("span/input")), "'Reference Item' WIDTH field");
                        //Thread.sleep(500);

                        WebElement input_Field_8 = input_Width_8.findElement(By.xpath("span/input"));
                        input_Field_8.clear();
                        action.sendKeys(input_Field_8, "97").perform();
                        //input_NetPrice.sendKeys("10");
                        //js.executeScript("arguments[0].value='10,00';", input_NetPrice_input);
                        // Thread.sleep(1000);
                        // input_NetPrice_input.sendKeys(Keys.ENTER);
                        logger.info("Width for REFERENCE ITEM input field was SUCCESSFULLY changed.");


                        //Check availability of 'Fixed' check-mark
                        WebElement check_mark_8 = element_2.findElement(By.xpath("td[3]/div/span/input"));

                        if (check_mark_8.isSelected()) {//if selected, then click on it to unselect it
                            js.executeScript("arguments[0].click();", check_mark_8);
                            logger.info("REFERENCE ITEM input field was clicked to be unselected in the FIXED column.");
                        } else {
                            logger.info("REFERENCE ITEM input field was unselected in the FIXED column BY DEFAULT.");
                        }

                        //click vertical scroller to move the list one row up
                        //action.click(scroller_DisplayedColumns).perform();
                        js.executeScript("arguments[0].click();", scroller_DisplayedColumns);

                        break;


                    case "Material":

                        WebElement input_Width_9 = element_2.findElement(By.xpath("td[2]/div"));

                        //action.moveToElement(input_Width_1).click().build().perform();
                        //js.executeScript("arguments[0].click();", input_Width_1);
                        input_Width_9.click();

                        logger.info("The 'Material' WIDTH field (on 'PERSONALIZATION' popup) was clicked for editing.");

                        waitTillWebElementAvailable(5, input_Width_9.findElement(By.xpath("span/input")), "'Material' WIDTH field");
                        //Thread.sleep(500);

                        WebElement input_Field_9 = input_Width_9.findElement(By.xpath("span/input"));
                        input_Field_9.clear();
                        action.sendKeys(input_Field_9, "64").perform();
                        //input_NetPrice.sendKeys("10");
                        //js.executeScript("arguments[0].value='10,00';", input_NetPrice_input);
                        // Thread.sleep(1000);
                        // input_NetPrice_input.sendKeys(Keys.ENTER);
                        logger.info("Width for MATERIAL input field was SUCCESSFULLY changed.");


                        //Check availability of 'Fixed' check-mark
                        WebElement check_mark_9 = element_2.findElement(By.xpath("td[3]/div/span/input"));

                        if (check_mark_9.isSelected()) {//if selected, then click on it to unselect it
                            js.executeScript("arguments[0].click();", check_mark_9);
                            logger.info("MATERIAL input field was clicked to be unselected in the FIXED column.");
                        } else {
                            logger.info("MATERIAL ITEM input field was unselected in the FIXED column BY DEFAULT.");
                        }

                        //click vertical scroller to move the list one row up
                        //action.click(scroller_DisplayedColumns).perform();
                        js.executeScript("arguments[0].click();", scroller_DisplayedColumns);

                        break;


                    case "Material description":

                        WebElement input_Width_10 = element_2.findElement(By.xpath("td[2]/div"));

                        //action.moveToElement(input_Width_1).click().build().perform();
                        //js.executeScript("arguments[0].click();", input_Width_1);
                        input_Width_10.click();

                        logger.info("The 'Material description' WIDTH field (on 'PERSONALIZATION' popup) was clicked for editing.");

                        waitTillWebElementAvailable(5, input_Width_10.findElement(By.xpath("span/input")), "'Material description' WIDTH field");
                        //Thread.sleep(500);

                        WebElement input_Field_10 = input_Width_10.findElement(By.xpath("span/input"));
                        input_Field_10.clear();
                        action.sendKeys(input_Field_10, "126").perform();
                        //input_NetPrice.sendKeys("10");
                        //js.executeScript("arguments[0].value='10,00';", input_NetPrice_input);
                        // Thread.sleep(1000);
                        // input_NetPrice_input.sendKeys(Keys.ENTER);
                        logger.info("Width for MATERIAL DESCRIPTION input field was SUCCESSFULLY changed.");


                        //Check availability of 'Fixed' check-mark
                        WebElement check_mark_10 = element_2.findElement(By.xpath("td[3]/div/span/input"));

                        if (check_mark_10.isSelected()) {//if selected, then click on it to unselect it
                            js.executeScript("arguments[0].click();", check_mark_10);
                            logger.info("MATERIAL DESCRIPTION input field was clicked to be unselected in the FIXED column.");
                        } else {
                            logger.info("MATERIAL DESCRIPTION input field was unselected in the FIXED column BY DEFAULT.");
                        }

                        //click vertical scroller to move the list one row up
                        //action.click(scroller_DisplayedColumns).perform();
                        js.executeScript("arguments[0].click();", scroller_DisplayedColumns);

                        break;


                    case "Quantity":

                        WebElement input_Width_11 = element_2.findElement(By.xpath("td[2]/div"));

                        //action.moveToElement(input_Width_1).click().build().perform();
                        //js.executeScript("arguments[0].click();", input_Width_1);
                        input_Width_11.click();

                        logger.info("The 'Quantity' WIDTH field (on 'PERSONALIZATION' popup) was clicked for editing.");

                        waitTillWebElementAvailable(5, input_Width_11.findElement(By.xpath("span/input")), "'Quantity' WIDTH field");
                        //Thread.sleep(500);

                        WebElement input_Field_11 = input_Width_11.findElement(By.xpath("span/input"));
                        input_Field_11.clear();
                        action.sendKeys(input_Field_11, "74").perform();
                        //input_NetPrice.sendKeys("10");
                        //js.executeScript("arguments[0].value='10,00';", input_NetPrice_input);
                        // Thread.sleep(1000);
                        // input_NetPrice_input.sendKeys(Keys.ENTER);
                        logger.info("Width for QUANTITY input field was SUCCESSFULLY changed.");


                        //Check availability of 'Fixed' check-mark
                        WebElement check_mark_11 = element_2.findElement(By.xpath("td[3]/div/span/input"));

                        if (check_mark_11.isSelected()) {//if selected, then click on it to unselect it
                            js.executeScript("arguments[0].click();", check_mark_11);
                            logger.info("QUANTITY input field was clicked to be unselected in the FIXED column.");
                        } else {
                            logger.info("QUANTITY input field was unselected in the FIXED column BY DEFAULT.");
                        }

                        //click vertical scroller to move the list one row up
                        //action.click(scroller_DisplayedColumns).perform();
                        js.executeScript("arguments[0].click();", scroller_DisplayedColumns);

                        break;


                    case "Base Unit of Measure":

                        WebElement input_Width_12 = element_2.findElement(By.xpath("td[2]/div"));

                        //action.moveToElement(input_Width_1).click().build().perform();
                        //js.executeScript("arguments[0].click();", input_Width_1);
                        input_Width_12.click();

                        logger.info("The 'Base Unit of Measure' WIDTH field (on 'PERSONALIZATION' popup) was clicked for editing.");

                        waitTillWebElementAvailable(5, input_Width_12.findElement(By.xpath("span/input")), "'Base Unit of Measure' WIDTH field");
                        //Thread.sleep(500);

                        WebElement input_Field_12 = input_Width_12.findElement(By.xpath("span/input"));
                        input_Field_12.clear();
                        action.sendKeys(input_Field_12, "128").perform();
                        //input_NetPrice.sendKeys("10");
                        //js.executeScript("arguments[0].value='10,00';", input_NetPrice_input);
                        // Thread.sleep(1000);
                        // input_NetPrice_input.sendKeys(Keys.ENTER);
                        logger.info("Width for BASE UNIT OF MEASURE input field was SUCCESSFULLY changed.");


                        //Check availability of 'Fixed' check-mark
                        WebElement check_mark_12 = element_2.findElement(By.xpath("td[3]/div/span/input"));

                        if (check_mark_12.isSelected()) {//if selected, then click on it to unselect it
                            js.executeScript("arguments[0].click();", check_mark_12);
                            logger.info("BASE UNIT OF MEASURE input field was clicked to be unselected in the FIXED column.");
                        } else {
                            logger.info("BASE UNIT OF MEASURE input field was unselected in the FIXED column BY DEFAULT.");
                        }

                        //click vertical scroller to move the list one row up
                        //action.click(scroller_DisplayedColumns).perform();
                        js.executeScript("arguments[0].click();", scroller_DisplayedColumns);

                        break;


                    case "Plant":

                        WebElement input_Width_13 = element_2.findElement(By.xpath("td[2]/div"));

                        //action.moveToElement(input_Width_1).click().build().perform();
                        //js.executeScript("arguments[0].click();", input_Width_1);
                        input_Width_13.click();

                        logger.info("The 'Plant' WIDTH field (on 'PERSONALIZATION' popup) was clicked for editing.");

                        waitTillWebElementAvailable(5, input_Width_13.findElement(By.xpath("span/input")), "'Plant' WIDTH field");
                        //Thread.sleep(500);

                        WebElement input_Field_13 = input_Width_13.findElement(By.xpath("span/input"));
                        input_Field_13.clear();
                        action.sendKeys(input_Field_13, "62").perform();
                        //input_NetPrice.sendKeys("10");
                        //js.executeScript("arguments[0].value='10,00';", input_NetPrice_input);
                        // Thread.sleep(1000);
                        // input_NetPrice_input.sendKeys(Keys.ENTER);
                        logger.info("Width for PLANT input field was SUCCESSFULLY changed.");


                        //Check availability of 'Fixed' check-mark
                        WebElement check_mark_13 = element_2.findElement(By.xpath("td[3]/div/span/input"));

                        if (check_mark_13.isSelected()) {//if selected, then click on it to unselect it
                            js.executeScript("arguments[0].click();", check_mark_13);
                            logger.info("PLANT input field was clicked to be unselected in the FIXED column.");
                        } else {
                            logger.info("PLANT input field was unselected in the FIXED column BY DEFAULT.");
                        }

                        //click vertical scroller to move the list one row up
                        //action.click(scroller_DisplayedColumns).perform();
                        js.executeScript("arguments[0].click();", scroller_DisplayedColumns);

                        break;


                    case "Storage location":

                        WebElement input_Width_14 = element_2.findElement(By.xpath("td[2]/div"));

                        //action.moveToElement(input_Width_1).click().build().perform();
                        //js.executeScript("arguments[0].click();", input_Width_1);
                        input_Width_14.click();

                        logger.info("The 'Storage location' WIDTH field (on 'PERSONALIZATION' popup) was clicked for editing.");

                        waitTillWebElementAvailable(5, input_Width_14.findElement(By.xpath("span/input")), "'Storage location' WIDTH field");
                        //Thread.sleep(500);

                        WebElement input_Field_14 = input_Width_14.findElement(By.xpath("span/input"));
                        input_Field_14.clear();
                        action.sendKeys(input_Field_14, "106").perform();
                        //input_NetPrice.sendKeys("10");
                        //js.executeScript("arguments[0].value='10,00';", input_NetPrice_input);
                        // Thread.sleep(1000);
                        // input_NetPrice_input.sendKeys(Keys.ENTER);
                        logger.info("Width for STORAGE LOCATION input field was SUCCESSFULLY changed.");


                        //Check availability of 'Fixed' check-mark
                        WebElement check_mark_14 = element_2.findElement(By.xpath("td[3]/div/span/input"));

                        if (check_mark_14.isSelected()) {//if selected, then click on it to unselect it
                            js.executeScript("arguments[0].click();", check_mark_14);
                            logger.info("STORAGE LOCATION input field was clicked to be unselected in the FIXED column.");
                        } else {
                            logger.info("STORAGE LOCATION input field was unselected in the FIXED column BY DEFAULT.");
                        }

                        //click vertical scroller to move the list one row up
                        //action.click(scroller_DisplayedColumns).perform();
                        js.executeScript("arguments[0].click();", scroller_DisplayedColumns);

                        break;


                    case "Valuation Type":

                        WebElement input_Width_15 = element_2.findElement(By.xpath("td[2]/div"));

                        //action.moveToElement(input_Width_1).click().build().perform();
                        //js.executeScript("arguments[0].click();", input_Width_1);
                        input_Width_15.click();

                        logger.info("The 'Valuation Type' WIDTH field (on 'PERSONALIZATION' popup) was clicked for editing.");

                        waitTillWebElementAvailable(5, input_Width_15.findElement(By.xpath("span/input")), "'Valuation Type' WIDTH field");
                        //Thread.sleep(500);

                        WebElement input_Field_15 = input_Width_15.findElement(By.xpath("span/input"));
                        input_Field_15.clear();
                        action.sendKeys(input_Field_15, "95").perform();
                        //input_NetPrice.sendKeys("10");
                        //js.executeScript("arguments[0].value='10,00';", input_NetPrice_input);
                        // Thread.sleep(1000);
                        // input_NetPrice_input.sendKeys(Keys.ENTER);
                        logger.info("Width for VALUATION TYPE input field was SUCCESSFULLY changed.");


                        //Check availability of 'Fixed' check-mark
                        WebElement check_mark_15 = element_2.findElement(By.xpath("td[3]/div/span/input"));

                        if (check_mark_15.isSelected()) {//if selected, then click on it to unselect it
                            js.executeScript("arguments[0].click();", check_mark_15);
                            logger.info("VALUATION TYPE input field was clicked to be unselected in the FIXED column.");
                        } else {
                            logger.info("VALUATION TYPE input field was unselected in the FIXED column BY DEFAULT.");
                        }

                        //click vertical scroller to move the list one row up
                        //action.click(scroller_DisplayedColumns).perform();
                        js.executeScript("arguments[0].click();", scroller_DisplayedColumns);

                        break;


                    case "Handling Type":

                        WebElement input_Width_16 = element_2.findElement(By.xpath("td[2]/div"));

                        //action.moveToElement(input_Width_1).click().build().perform();
                        //js.executeScript("arguments[0].click();", input_Width_1);
                        input_Width_16.click();

                        logger.info("The 'Handling Type' WIDTH field (on 'PERSONALIZATION' popup) was clicked for editing.");

                        waitTillWebElementAvailable(5, input_Width_16.findElement(By.xpath("span/input")), "'Handling Type' WIDTH field");
                        //Thread.sleep(500);

                        WebElement input_Field_16 = input_Width_16.findElement(By.xpath("span/input"));
                        input_Field_16.clear();
                        action.sendKeys(input_Field_16, "95").perform();
                        //input_NetPrice.sendKeys("10");
                        //js.executeScript("arguments[0].value='10,00';", input_NetPrice_input);
                        // Thread.sleep(1000);
                        // input_NetPrice_input.sendKeys(Keys.ENTER);
                        logger.info("Width for HANDLING TYPE input field was SUCCESSFULLY changed.");


                        //Check availability of 'Fixed' check-mark
                        WebElement check_mark_16 = element_2.findElement(By.xpath("td[3]/div/span/input"));

                        if (check_mark_16.isSelected()) {//if selected, then click on it to unselect it
                            js.executeScript("arguments[0].click();", check_mark_16);
                            logger.info("HANDLING TYPE input field was clicked to be unselected in the FIXED column.");
                        } else {
                            logger.info("HANDLING TYPE input field was unselected in the FIXED column BY DEFAULT.");
                        }

                        //click vertical scroller to move the list one row up
                        //action.click(scroller_DisplayedColumns).perform();
                        js.executeScript("arguments[0].click();", scroller_DisplayedColumns);

                        break;


                    case "Posting Date":

                        WebElement input_Width_17 = element_2.findElement(By.xpath("td[2]/div"));

                        //action.moveToElement(input_Width_1).click().build().perform();
                        //js.executeScript("arguments[0].click();", input_Width_1);
                        input_Width_17.click();

                        logger.info("The 'Posting Date' WIDTH field (on 'PERSONALIZATION' popup) was clicked for editing.");

                        waitTillWebElementAvailable(5, input_Width_17.findElement(By.xpath("span/input")), "'Posting Date' WIDTH field");
                        //Thread.sleep(500);

                        WebElement input_Field_17 = input_Width_17.findElement(By.xpath("span/input"));
                        input_Field_17.clear();
                        action.sendKeys(input_Field_17, "88").perform();
                        //input_NetPrice.sendKeys("10");
                        //js.executeScript("arguments[0].value='10,00';", input_NetPrice_input);
                        // Thread.sleep(1000);
                        // input_NetPrice_input.sendKeys(Keys.ENTER);
                        logger.info("Width for POSTING DATE input field was SUCCESSFULLY changed.");


                        //Check availability of 'Fixed' check-mark
                        WebElement check_mark_17 = element_2.findElement(By.xpath("td[3]/div/span/input"));

                        if (check_mark_17.isSelected()) {//if selected, then click on it to unselect it
                            js.executeScript("arguments[0].click();", check_mark_17);
                            logger.info("POSTING DATE input field was clicked to be unselected in the FIXED column.");
                        } else {
                            logger.info("POSTING DATE input field was unselected in the FIXED column BY DEFAULT.");
                        }

                        //click vertical scroller to move the list one row up
                        //action.click(scroller_DisplayedColumns).perform();
                        js.executeScript("arguments[0].click();", scroller_DisplayedColumns);

                        break;


                    case "Partner Function":

                        WebElement input_Width_18 = element_2.findElement(By.xpath("td[2]/div"));

                        //action.moveToElement(input_Width_1).click().build().perform();
                        //js.executeScript("arguments[0].click();", input_Width_1);
                        input_Width_18.click();

                        logger.info("The 'Partner Function' WIDTH field (on 'PERSONALIZATION' popup) was clicked for editing.");

                        waitTillWebElementAvailable(5, input_Width_18.findElement(By.xpath("span/input")), "'Partner Function' WIDTH field");
                        //Thread.sleep(500);

                        WebElement input_Field_18 = input_Width_18.findElement(By.xpath("span/input"));
                        input_Field_18.clear();
                        action.sendKeys(input_Field_18, "108").perform();
                        //input_NetPrice.sendKeys("10");
                        //js.executeScript("arguments[0].value='10,00';", input_NetPrice_input);
                        // Thread.sleep(1000);
                        // input_NetPrice_input.sendKeys(Keys.ENTER);
                        logger.info("Width for PARTNER FUNCTION input field was SUCCESSFULLY changed.");


                        //Check availability of 'Fixed' check-mark
                        WebElement check_mark_18 = element_2.findElement(By.xpath("td[3]/div/span/input"));

                        if (check_mark_18.isSelected()) {//if selected, then click on it to unselect it
                            js.executeScript("arguments[0].click();", check_mark_18);
                            logger.info("PARTNER FUNCTION input field was clicked to be unselected in the FIXED column.");
                        } else {
                            logger.info("PARTNER FUNCTION input field was unselected in the FIXED column BY DEFAULT.");
                        }

                        //click vertical scroller to move the list one row up
                        //action.click(scroller_DisplayedColumns).perform();
                        js.executeScript("arguments[0].click();", scroller_DisplayedColumns);

                        break;


                    case "Tank number":

                        WebElement input_Width_19 = element_2.findElement(By.xpath("td[2]/div"));

                        //action.moveToElement(input_Width_1).click().build().perform();
                        //js.executeScript("arguments[0].click();", input_Width_19);
                        input_Width_19.click();

                        logger.info("The 'Tank number' WIDTH field (on 'PERSONALIZATION' popup) was clicked for editing.");

                        waitTillWebElementAvailable(5, input_Width_19.findElement(By.xpath("span/input")), "'Tank number' WIDTH field");
                        //Thread.sleep(500);

                        WebElement input_Field_19 = input_Width_19.findElement(By.xpath("span/input"));
                        input_Field_19.clear();
                        action.sendKeys(input_Field_19, "72").perform();
                        //input_NetPrice.sendKeys("10");
                        //js.executeScript("arguments[0].value='10,00';", input_NetPrice_input);
                        // Thread.sleep(1000);
                        // input_NetPrice_input.sendKeys(Keys.ENTER);
                        logger.info("Width for TANK NUMBER input field was SUCCESSFULLY changed.");


                        //Check availability of 'Fixed' check-mark
                        WebElement check_mark_19 = element_2.findElement(By.xpath("td[3]/div/span/input"));

                        if (check_mark_19.isSelected()) {//if selected, then click on it to unselect it
                            js.executeScript("arguments[0].click();", check_mark_19);
                            logger.info("TANK NUMBER input field was clicked to be unselected in the FIXED column.");
                        } else {
                            logger.info("TANK NUMBER input field was unselected in the FIXED column BY DEFAULT.");
                        }

                        //click vertical scroller to move the list one row up
                        //action.click(scroller_DisplayedColumns).perform();
                        js.executeScript("arguments[0].click();", scroller_DisplayedColumns);

                        break;


                    case "Partners":

                        WebElement input_Width_20 = element_2.findElement(By.xpath("td[2]/div"));

                        //action.moveToElement(input_Width_1).click().build().perform();
                        //js.executeScript("arguments[0].click();", input_Width_1);
                        input_Width_20.click();

                        logger.info("The 'Partners' WIDTH field (on 'PERSONALIZATION' popup) was clicked for editing.");

                        waitTillWebElementAvailable(5, input_Width_20.findElement(By.xpath("span/input")), "'Partners' WIDTH field");
                        //Thread.sleep(500);

                        WebElement input_Field_20 = input_Width_20.findElement(By.xpath("span/input"));
                        input_Field_20.clear();
                        action.sendKeys(input_Field_20, "72").perform();
                        //input_NetPrice.sendKeys("10");
                        //js.executeScript("arguments[0].value='10,00';", input_NetPrice_input);
                        // Thread.sleep(1000);
                        // input_NetPrice_input.sendKeys(Keys.ENTER);
                        logger.info("Width for PARTNERS input field was SUCCESSFULLY changed.");


                        //Check availability of 'Fixed' check-mark
                        WebElement check_mark_20 = element_2.findElement(By.xpath("td[3]/div/span/input"));

                        if (check_mark_20.isSelected()) {//if selected, then click on it to unselect it
                            js.executeScript("arguments[0].click();", check_mark_20);
                            logger.info("PARTNERS input field was clicked to be unselected in the FIXED column.");
                        } else {
                            logger.info("PARTNERS input field was unselected in the FIXED column BY DEFAULT.");
                        }

                        //click vertical scroller to move the list one row up
                        //action.click(scroller_DisplayedColumns).perform();
                        js.executeScript("arguments[0].click();", scroller_DisplayedColumns);

                        break;


                    case "Net Price":

                        WebElement input_Width_21 = element_2.findElement(By.xpath("td[2]/div"));

                        //action.moveToElement(input_Width_1).click().build().perform();
                        //js.executeScript("arguments[0].click();", input_Width_1);
                        input_Width_21.click();

                        logger.info("The 'Net Price' WIDTH field (on 'PERSONALIZATION' popup) was clicked for editing.");

                        waitTillWebElementAvailable(5, input_Width_21.findElement(By.xpath("span/input")), "'Net Price' WIDTH field");
                        //Thread.sleep(500);

                        WebElement input_Field_21 = input_Width_21.findElement(By.xpath("span/input"));
                        input_Field_21.clear();
                        action.sendKeys(input_Field_21, "81").perform();
                        //input_NetPrice.sendKeys("10");
                        //js.executeScript("arguments[0].value='10,00';", input_NetPrice_input);
                        // Thread.sleep(1000);
                        // input_NetPrice_input.sendKeys(Keys.ENTER);
                        logger.info("Width for NET PRICE input field was SUCCESSFULLY changed.");


                        //Check availability of 'Fixed' check-mark
                        WebElement check_mark_21 = element_2.findElement(By.xpath("td[3]/div/span/input"));

                        if (check_mark_21.isSelected()) {//if selected, then click on it to unselect it
                            js.executeScript("arguments[0].click();", check_mark_21);
                            logger.info("NET PRICE input field was clicked to be unselected in the FIXED column.");
                        } else {
                            logger.info("NET PRICE input field was unselected in the FIXED column BY DEFAULT.");
                        }

                        //click vertical scroller to move the list one row up
                        //action.click(scroller_DisplayedColumns).perform();
                        js.executeScript("arguments[0].click();", scroller_DisplayedColumns);

                        break;


                    case "Currency":

                        WebElement input_Width_22 = element_2.findElement(By.xpath("td[2]/div"));

                        //action.moveToElement(input_Width_1).click().build().perform();
                        //js.executeScript("arguments[0].click();", input_Width_1);
                        input_Width_22.click();

                        logger.info("The 'Currency' WIDTH field (on 'PERSONALIZATION' popup) was clicked for editing.");

                        waitTillWebElementAvailable(5, input_Width_22.findElement(By.xpath("span/input")), "'Currency' WIDTH field");
                        //Thread.sleep(500);

                        WebElement input_Field_22 = input_Width_22.findElement(By.xpath("span/input"));
                        input_Field_22.clear();
                        action.sendKeys(input_Field_22, "79").perform();
                        //input_NetPrice.sendKeys("10");
                        //js.executeScript("arguments[0].value='10,00';", input_NetPrice_input);
                        // Thread.sleep(1000);
                        // input_NetPrice_input.sendKeys(Keys.ENTER);
                        logger.info("Width for CURRENCY input field was SUCCESSFULLY changed.");


                        //Check availability of 'Fixed' check-mark
                        WebElement check_mark_22 = element_2.findElement(By.xpath("td[3]/div/span/input"));

                        if (check_mark_22.isSelected()) {//if selected, then click on it to unselect it
                            js.executeScript("arguments[0].click();", check_mark_22);
                            logger.info("CURRENCY input field was clicked to be unselected in the FIXED column.");
                        } else {
                            logger.info("CURRENCY input field was unselected in the FIXED column BY DEFAULT.");
                        }

                        //click vertical scroller to move the list one row up
                        //action.click(scroller_DisplayedColumns).perform();
                        js.executeScript("arguments[0].click();", scroller_DisplayedColumns);

                        break;


                    case "Pricing Unit":

                        WebElement input_Width_23 = element_2.findElement(By.xpath("td[2]/div"));

                        //action.moveToElement(input_Width_1).click().build().perform();
                        //js.executeScript("arguments[0].click();", input_Width_1);
                        input_Width_23.click();

                        logger.info("The 'Pricing Unit' WIDTH field (on 'PERSONALIZATION' popup) was clicked for editing.");

                        waitTillWebElementAvailable(5, input_Width_23.findElement(By.xpath("span/input")), "'Pricing Unit' WIDTH field");
                        //Thread.sleep(500);

                        WebElement input_Field_23 = input_Width_23.findElement(By.xpath("span/input"));
                        input_Field_23.clear();
                        action.sendKeys(input_Field_23, "96").perform();
                        //input_NetPrice.sendKeys("10");
                        //js.executeScript("arguments[0].value='10,00';", input_NetPrice_input);
                        // Thread.sleep(1000);
                        // input_NetPrice_input.sendKeys(Keys.ENTER);
                        logger.info("Width for PRICING UNIT input field was SUCCESSFULLY changed.");


                        //Check availability of 'Fixed' check-mark
                        WebElement check_mark_23 = element_2.findElement(By.xpath("td[3]/div/span/input"));

                        if (check_mark_23.isSelected()) {//if selected, then click on it to unselect it
                            js.executeScript("arguments[0].click();", check_mark_23);
                            logger.info("PRICING UNIT input field was clicked to be unselected in the FIXED column.");
                        } else {
                            logger.info("PRICING UNIT input field was unselected in the FIXED column BY DEFAULT.");
                        }

                        //click vertical scroller to move the list one row up
                        //action.click(scroller_DisplayedColumns).perform();
                        js.executeScript("arguments[0].click();", scroller_DisplayedColumns);

                        break;


                    case "Unit of Measure":

                        WebElement input_Width_24 = element_2.findElement(By.xpath("td[2]/div"));

                        //action.moveToElement(input_Width_1).click().build().perform();
                        //js.executeScript("arguments[0].click();", input_Width_1);
                        input_Width_24.click();

                        logger.info("The 'Unit of Measure' WIDTH field (on 'PERSONALIZATION' popup) was clicked for editing.");

                        waitTillWebElementAvailable(5, input_Width_24.findElement(By.xpath("span/input")), "'Unit of Measure' WIDTH field");
                        //Thread.sleep(500);

                        WebElement input_Field_24 = input_Width_24.findElement(By.xpath("span/input"));
                        input_Field_24.clear();
                        action.sendKeys(input_Field_24, "90").perform();
                        //input_NetPrice.sendKeys("10");
                        //js.executeScript("arguments[0].value='10,00';", input_NetPrice_input);
                        // Thread.sleep(1000);
                        // input_NetPrice_input.sendKeys(Keys.ENTER);
                        logger.info("Width for UNIT OF MEASURE input field was SUCCESSFULLY changed.");


                        //Check availability of 'Fixed' check-mark
                        WebElement check_mark_24 = element_2.findElement(By.xpath("td[3]/div/span/input"));

                        if (check_mark_24.isSelected()) {//if selected, then click on it to unselect it
                            js.executeScript("arguments[0].click();", check_mark_24);
                            logger.info("UNIT OF MEASURE input field was clicked to be unselected in the FIXED column.");
                        } else {
                            logger.info("UNIT OF MEASURE input field was unselected in the FIXED column BY DEFAULT.");
                        }

                        //click vertical scroller to move the list one row up
                        //action.click(scroller_DisplayedColumns).perform();
                        js.executeScript("arguments[0].click();", scroller_DisplayedColumns);

                        break;


                    case "Quantity in Percent":

                        WebElement input_Width_25 = element_2.findElement(By.xpath("td[2]/div"));

                        //action.moveToElement(input_Width_1).click().build().perform();
                        //js.executeScript("arguments[0].click();", input_Width_1);
                        input_Width_25.click();

                        logger.info("The 'Quantity in Percent' WIDTH field (on 'PERSONALIZATION' popup) was clicked for editing.");

                        waitTillWebElementAvailable(5, input_Width_25.findElement(By.xpath("span/input")), "'Quantity in Percent' WIDTH field");
                        //Thread.sleep(500);

                        WebElement input_Field_25 = input_Width_25.findElement(By.xpath("span/input"));
                        input_Field_25.clear();
                        action.sendKeys(input_Field_25, "70").perform();
                        //input_NetPrice.sendKeys("10");
                        //js.executeScript("arguments[0].value='10,00';", input_NetPrice_input);
                        // Thread.sleep(1000);
                        // input_NetPrice_input.sendKeys(Keys.ENTER);
                        logger.info("Width for QUANTITY IN PERCENT input field was SUCCESSFULLY changed.");


                        //Check availability of 'Fixed' check-mark
                        WebElement check_mark_25 = element_2.findElement(By.xpath("td[3]/div/span/input"));

                        if (check_mark_25.isSelected()) {//if selected, then click on it to unselect it
                            js.executeScript("arguments[0].click();", check_mark_25);
                            logger.info("QUANTITY IN PERCENT input field was clicked to be unselected in the FIXED column.");
                        } else {
                            logger.info("QUANTITY IN PERCENT input field was unselected in the FIXED column BY DEFAULT.");
                        }

                        //click vertical scroller to move the list one row up
                        //action.click(scroller_DisplayedColumns).perform();
                        js.executeScript("arguments[0].click();", scroller_DisplayedColumns);

                        break;


                    case "Stock":

                        WebElement input_Width_26 = element_2.findElement(By.xpath("td[2]/div"));

                        //action.moveToElement(input_Width_1).click().build().perform();
                        //js.executeScript("arguments[0].click();", input_Width_1);
                        input_Width_26.click();

                        logger.info("The 'Stock' WIDTH field (on 'PERSONALIZATION' popup) was clicked for editing.");

                        waitTillWebElementAvailable(5, input_Width_26.findElement(By.xpath("span/input")), "'Stock' WIDTH field");
                        //Thread.sleep(500);

                        WebElement input_Field_26 = input_Width_26.findElement(By.xpath("span/input"));
                        input_Field_26.clear();
                        action.sendKeys(input_Field_26, "70").perform();
                        //input_NetPrice.sendKeys("10");
                        //js.executeScript("arguments[0].value='10,00';", input_NetPrice_input);
                        // Thread.sleep(1000);
                        // input_NetPrice_input.sendKeys(Keys.ENTER);
                        logger.info("Width for STOCK input field was SUCCESSFULLY changed.");


                        //Check availability of 'Fixed' check-mark
                        WebElement check_mark_26 = element_2.findElement(By.xpath("td[3]/div/span/input"));

                        if (check_mark_26.isSelected()) {//if selected, then click on it to unselect it
                            js.executeScript("arguments[0].click();", check_mark_26);
                            logger.info("STOCK input field was clicked to be unselected in the FIXED column.");
                        } else {
                            logger.info("STOCK input field was unselected in the FIXED column BY DEFAULT.");
                        }

                        //click vertical scroller to move the list one row up
                        //action.click(scroller_DisplayedColumns).perform();
                        js.executeScript("arguments[0].click();", scroller_DisplayedColumns);

                        break;


                    case "UoM for Quantity from Dipping":

                        WebElement input_Width_27 = element_2.findElement(By.xpath("td[2]/div"));

                        //action.moveToElement(input_Width_1).click().build().perform();
                        //js.executeScript("arguments[0].click();", input_Width_1);
                        input_Width_27.click();

                        logger.info("The 'UoM for Quantity from Dipping' WIDTH field (on 'PERSONALIZATION' popup) was clicked for editing.");

                        waitTillWebElementAvailable(5, input_Width_27.findElement(By.xpath("span/input")), "'UoM for Quantity from Dipping' WIDTH field");
                        //Thread.sleep(500);

                        WebElement input_Field_27 = input_Width_27.findElement(By.xpath("span/input"));
                        input_Field_27.clear();
                        action.sendKeys(input_Field_27, "70").perform();
                        //input_NetPrice.sendKeys("10");
                        //js.executeScript("arguments[0].value='10,00';", input_NetPrice_input);
                        // Thread.sleep(1000);
                        // input_NetPrice_input.sendKeys(Keys.ENTER);
                        logger.info("Width for UOM FOR QUANTITY FROM DIPPING input field was SUCCESSFULLY changed.");


                        //Check availability of 'Fixed' check-mark
                        WebElement check_mark_27 = element_2.findElement(By.xpath("td[3]/div/span/input"));

                        if (check_mark_27.isSelected()) {//if selected, then click on it to unselect it
                            js.executeScript("arguments[0].click();", check_mark_27);
                            logger.info("UOM FOR QUANTITY FROM DIPPING input field was clicked to be unselected in the FIXED column.");
                        } else {
                            logger.info("UOM FOR QUANTITY FROM DIPPING input field was unselected in the FIXED column BY DEFAULT.");
                        }

                        //click vertical scroller to move the list one row up
                        //action.click(scroller_DisplayedColumns).perform();
                        js.executeScript("arguments[0].click();", scroller_DisplayedColumns);

                        break;

                    case "Difference Reason":

                        WebElement input_Width_28 = element_2.findElement(By.xpath("td[2]/div"));

                        //action.moveToElement(input_Width_1).click().build().perform();
                        //js.executeScript("arguments[0].click();", input_Width_1);
                        input_Width_28.click();

                        logger.info("The 'Difference Reason' WIDTH field (on 'PERSONALIZATION' popup) was clicked for editing.");

                        waitTillWebElementAvailable(5, input_Width_28.findElement(By.xpath("span/input")), "'Difference Reason' WIDTH field");
                        //Thread.sleep(500);

                        WebElement input_Field_28 = input_Width_28.findElement(By.xpath("span/input"));
                        input_Field_28.clear();
                        action.sendKeys(input_Field_28, "70").perform();
                        //input_NetPrice.sendKeys("10");
                        //js.executeScript("arguments[0].value='10,00';", input_NetPrice_input);
                        // Thread.sleep(1000);
                        // input_NetPrice_input.sendKeys(Keys.ENTER);
                        logger.info("Width for DIFFERENCE REASON input field was SUCCESSFULLY changed.");


                        //Check availability of 'Fixed' check-mark
                        WebElement check_mark_28 = element_2.findElement(By.xpath("td[3]/div/span/input"));

                        if (check_mark_28.isSelected()) {//if selected, then click on it to unselect it
                            js.executeScript("arguments[0].click();", check_mark_28);
                            logger.info("DIFFERENCE REASON input field was clicked to be unselected in the FIXED column.");
                        } else {
                            logger.info("DIFFERENCE REASON input field was unselected in the FIXED column BY DEFAULT.");
                        }

                        //click vertical scroller to move the list one row up
                        //action.click(scroller_DisplayedColumns).perform();
                        js.executeScript("arguments[0].click();", scroller_DisplayedColumns);

                        break;

                    default:
                }

            }
        } catch (Exception e) {
            logger.error("Error while executing 'select_Rows' method: " + e.getMessage());
        }

    }


    public void set_WidthOfColumns_in_DisplayedColumns_Section() {

        try {
            int TbodySection = 1;
            int numberOfDefaultTbodySections = 0;
            int numberOfUpdatedTbodySections = 0;


            if (Test_Cases.conf_SystemClient.equals("OFQ_100")) {

                //When using an iframe, you will first have to switch to the iframe, before selecting the elements of that iframe.
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

                        String title = row_Title.getText();
                        System.out.println("Row's title = " + title);

                        select_Rows(title, element_1_3);

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

            }

            if (Test_Cases.conf_SystemClient.equals("OGQ_100")) {

                //When using an iframe, you will first have to switch to the iframe, before selecting the elements of that iframe.
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

                        String title = row_Title.getText();
                        System.out.println("Row's title = " + title);

                        select_Rows(title, element_1_3);

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

            }


        } catch (Exception e) {
            logger.error("Error while setting width of columns in 'DISPLAYED COLUMNS' section on PERSONALIZATION popup: " + e.getMessage());
        }

    }


    public boolean check_AvailableColumns_Section_Empty() {

        boolean empty = true;

        try {

            driver.switchTo().defaultContent();
            //When using an iframe, you will first have to switch to the iframe, before selecting the elements of that iframe.
            driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@name,'URLSPW-0')]")));


            //Select the parent web element
            List<WebElement> elm = driver.findElements(By.xpath("//span[contains (text(), 'Available Columns')]/ancestor::table[contains (@class, 'urSTCS urST3WhlBrd urST3WhlNoTit urST5SelColUiGeneric urHtmlTableReset')]/tbody[contains (@id, 'content')]/tr[2]/td[2]/div/div[2]/table/tbody/descendant::tr"));
            System.out.println("Number of records in 'AVAILABLE COLUMNS' section on PERSONALIZATION popup: " + elm.size() + ". EXPECTED is '1'");

            if (elm.size() > 1) {
                empty = false;
            }


            //Exit iframe to have access to the main window's web-elements
            driver.switchTo().defaultContent();


        } catch (Exception e) {
            logger.error("Unable to read the content of 'AVAILABLE COLUMNS' section on PERSONALIZATION popup: " + e.getMessage());
        }
        return empty;
    }


    public void check_SetToDefaultBtn_SetColumnsWidth() {

        try {
            if (Test_Cases.conf_SystemClient.equals("OFQ_100")) {
                //When using an iframe, you will first have to switch to the iframe, before selecting the elements of that iframe.
                driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@name,'URLSPW-0')]")));


                WebElement btn_SetToDefault = driver.findElement(By.xpath("//div[contains (text(), 'Settings')]/ancestor::div[contains (@class, 'urPWOuterBorder lsPopupWindow lsPopupWindow--dialog')][contains (@ct, 'PW')]/div/div[4][contains (@class, 'sapContrast sapContrastPlus lsTwhlFooter lsTbarLarge urPWFooterBottomLine')]/descendant::span[contains (text(), 'Reset to Default')]/ancestor::div[1]"));

                String btn_Status = btn_SetToDefault.getAttribute("class");
                System.out.println("Class value for 'Set to Default' button: " + btn_Status);

                if (!btn_Status.contains("lsButton--disabled")) {//if the "Set to Default" button is enabled then click on it and wait/check that "Available Columns" section is empty

                    logger.info("The 'Set to Default' button (on 'PERSONALIZATION' popup) was detected to be ENABLED.");

                    //action.moveToElement(btn_New).click().build().perform();
                    js.executeScript("arguments[0].click();", btn_SetToDefault);
                    //btn_New.click();

                    logger.info("The 'Set to Default' button (on 'PERSONALIZATION' popup) was clicked.");

                    //waitTillDescendentElementsLessThanExpected(10, "//span[contains (text(), 'Available Columns')]/ancestor::table[contains (@class, 'urSTCS urST3WhlBrd urST3WhlNoTit urST5SelColUiGeneric urHtmlTableReset')]/tbody[contains (@id, 'content')][1]/tr[2]/td[2]/div/div[2]/table/tbody/descendant::tr", "'AVAILABLE COLUMNS' with EMPTY RECORDS", 1);

                    //Exit iframe to have access to the main window's web-elements
                    driver.switchTo().defaultContent();

                    //wait till landing page is loaded again after closing "Personalization" popup
                    waitTillDescendentElementsAvailable(300, "//html/body/descendant::table", "DATA COLLATION PAGE after closing PERSONALIZATION popup");
                    Thread.sleep(1000);

                    //re-open "Personolized" popup to customize WIDTH of the columns
                    click_PersonalizeBtn();

                }

            }

            if (Test_Cases.conf_SystemClient.equals("OGQ_100")) {
                //When using an iframe, you will first have to switch to the iframe, before selecting the elements of that iframe.
                driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@name,'URLSPW-0')]")));

                String btn_Status = btn_SetToDefault.getAttribute("class");
                System.out.println("Class value for 'Set to Default' button: " + btn_Status);

                if (!btn_Status.contains("urBtnStdDsbl")) {//if the "Set to Default" button is enabled then click on it and wait/check that "Available Columns" section is empty

                    logger.info("The 'Set to Default' button (on 'PERSONALIZATION' popup) was detected to be ENABLED.");

                    //action.moveToElement(btn_New).click().build().perform();
                    js.executeScript("arguments[0].click();", btn_SetToDefault);
                    //btn_New.click();

                    logger.info("The 'Set to Default' button (on 'PERSONALIZATION' popup) was clicked.");

                    // waitTillDescendentElementsLessThanExpected(10, "//span[contains (text(), 'Available Columns')]/ancestor::table[contains (@class, 'urSTCS urST3WhlBrd urST3WhlNoTit urST5SelColUiGeneric urHtmlTableReset')]/tbody[contains (@id, 'content')][1]/tr[2]/td[2]/div/div[2]/table/tbody/descendant::tr", "'AVAILABLE COLUMNS' with EMPTY RECORDS", 1);
                    //Exit iframe to have access to the main window's web-elements
                    // driver.switchTo().defaultContent();

                    //wait till landing page is loaded again after closing "Personalization" popup
                    waitTillDescendentElementsAvailable(300, "//html/body/descendant::table", "DATA COLLATION PAGE after closing PERSONALIZATION popup");
                    Thread.sleep(1000);

                    //Exit iframe to have access to the main window's web-elements
                    driver.switchTo().defaultContent();

                    //re-open "Personolized" popup to customize WIDTH of the columns
                    click_PersonalizeBtn();

                }


            }

        } catch (Exception e) {
            logger.error("Unable to process the status of 'SET TO DEFAULT' button: " + e.getMessage());
        }

    }


    public void click_PersonalizeBtn() {
        try {
            //wait till "Personalization" popup gets displayed
            //OFQ//waitTillPredefinedDescendentElements(20, "//table[@class='urMatrixLayout urHtmlTableReset']/tbody[@class='urLinStd']/tr[2]/td/table/tbody/tr[3]/td/div[1]/div/div/div[@class='lsRasterLayout']/descendant::input", "Editable HEADER DATA Table", 5);


            if (Test_Cases.conf_SystemClient.equals("OFQ_100")) {

                WebElement btn_Personalize= driver.findElement(By.xpath("//span[contains (text(), 'Item Data')]/ancestor::table[contains (@class, 'lsPanel urHtmlTableReset')][contains (@ct, 'P')]/tbody/tr[2]/descendant::table[contains (@ct, 'STCS')][contains (@class, 'urSTCS urST3WhlBrdH urST3WhlNoTit urST5SelColUiGeneric urHtmlTableReset')]/thead/descendant::div[contains(@title, 'Settings')]"));

                //action.moveToElement(btn_New).click().build().perform();
                js.executeScript("arguments[0].click();", btn_Personalize);
                //btn_New.click();

                logger.info("'PERSONALIZATION' button on 'ITEM DATA' table was clicked SUCCESSFULLY.");

                //When using an iframe, you will first have to switch to the iframe, before selecting the elements of that iframe.
                driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@name,'URLSPW-0')]")));

                waitTillDescendentElementsAvailable(5, "//span[contains (text(), 'Displayed Columns')]/ancestor::table[contains (@class, 'urSTCS urST3WhlBrd urST3WhlNoTit urST5SelColUiGeneric urHtmlTableReset')]/tbody[contains (@id, 'content')]/tr[2]/td[2]/descendant::*", "PERSONALIZATION POPUP");
                //Thread.sleep(1000);
                driver.switchTo().defaultContent();
            }

            if (Test_Cases.conf_SystemClient.equals("OGQ_100")) {

                //action.moveToElement(btn_New).click().build().perform();
                js.executeScript("arguments[0].click();", btn_Personalize);
                //btn_New.click();

                logger.info("'PERSONALIZATION' button on 'ITEM DATA' table was clicked SUCCESSFULLY.");

                //When using an iframe, you will first have to switch to the iframe, before selecting the elements of that iframe.
                driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@name,'URLSPW-0')]")));

                waitTillDescendentElementsAvailable(15, "//span[contains (text(), 'Displayed Columns')]/ancestor::table[contains (@class, 'urSTCS urST3WhlBrd urST3WhlNoTit urST5SelColUiGeneric urHtmlTableReset')]/tbody[contains (@id, 'content')]/tr[2]/td[2]/descendant::*", "PERSONALIZATION POPUP");
                Thread.sleep(1000);

                //Exit iframe to have access to the main window's web-elements
                driver.switchTo().defaultContent();
            }

        } catch (Exception e) {
            logger.error("Failed to open 'PERSONALIZATION' popup: " + e.getMessage());
        }
    }


    public void click_SetToDefault_DataCollationPage() {
        try{

            //Hover over the "Set to Default" menu item
            //action.moveToElement(driver.findElement(By.xpath("//div[contains (@id, 'sapwd_main_window_root')]/div/descendant::div[contains (@id, 'pageContentViewAssoc')]/descendant::span[contains (@class, 'urNoUserSelect lsLCDropShadow')][contains (@pmnu, 'X')]/descendant::span[text()='Reset to Default']/ancestor::tr[1]"))).click().build().perform();
            action.moveToElement(driver.findElement(By.xpath("//div[contains (@id, 'sapwd_main_window_root')]/div/descendant::div[contains (@id, 'pageContentViewAssoc')]/descendant::span[contains (@class, 'lsLCDropShadow')][contains (@pmnu, 'X')]/descendant::span[text()='Reset to Default']/ancestor::tr[1]"))).click().build().perform();

            //div[contains (@id, 'sapwd_main_window_root')]/div/descendant::div[contains (@id, 'pageContentViewAssoc')]/descendant::span[contains (@class, 'lsLCDropShadow')][contains (@pmnu, 'X')]/descendant::span[text()='Reset to Default']/ancestor::tr[1]
            // action.click(menuItem_SetToDefault_DC).build().perform();
            /*String mouseOverScript = "var element = arguments[0];"
                    + "var mouseEventObj = document.createEvent('MouseEvents');"
                    + "mouseEventObj.initEvent( 'mouseover', true, true );"
                    + "element.dispatchEvent(mouseEventObj);";
            js.executeScript(mouseOverScript, menuItem_SetToDefault_DC);*/

            //js.executeScript("arguments[0].click();", menuItem_SetToDefault_DC);

            logger.info("SET TO DEFAULT menu item was SUCCESSFULLY clicked on.");

            //wait till landing page is loaded again after closing "Personalization" popup
            waitTillDescendentElementsAvailable(300, "//html/body/descendant::table", "DATA COLLATION PAGE after clicking on 'SET TO DEFAULT' menu item on PERSONALIZATION dropdown");
            //Thread.sleep(1000);

        }catch (Exception e){
            logger.error("Failed to click on 'Set to Default' menu item on 'PERSONALIZATION' droplist in the 'Data Collation'toolbar: " + e.getMessage());
        }
    }


    public void click_PersonalizeBtn_DataCollationPage() {
        try {

            if (Test_Cases.conf_SystemClient.equals("OFQ_100")) {

                WebElement btn_Personalize_DC = driver.findElement(By.xpath("//div[contains (text(), 'Data Collation')]/ancestor::table[contains (@class, 'urMatrixLayout urHtmlTableReset')][contains (@ct, 'ML')]/descendant::div[contains (@title, 'Settings')]"));

                //js.executeScript("arguments[0].click();", btn_Personalize_DC);
                btn_Personalize_DC.click();

                explicitWaitsUntilElementPresent(5, "//div[contains (@id, 'sapwd_main_window_root')]/div/descendant::div[contains (@id, 'pageContentViewAssoc')]/descendant::span[contains (@class, 'lsLCDropShadow')][contains (@pmnu, 'X')]/descendant::span[text()='Reset to Default']/ancestor::tr[1]", "'RESET TO DEFAULT DATA COLLATION PAGE' menu item");
                //Thread.sleep(1000);

            }

            if (Test_Cases.conf_SystemClient.equals("OGQ_100")) {

           /* @FindBy(xpath = "//div[contains (text(), 'Data Collation')]/ancestor::table[contains (@class, 'urMatrixLayout urHtmlTableReset')][contains (@ct, 'ML')]/descendant::div[contains (@title, 'Personalize')]")
            private WebElement btn_Personalize_DC;*/

                //js.executeScript("arguments[0].click();", btn_Personalize_DC);
                btn_Personalize_DC.click();

                explicitWaitsUntilElementPresent(5, "//div[contains (@id, 'sapwd_main_window_root')]/div/descendant::div[contains (@id, 'pageContentViewAssoc')]/descendant::span[contains (@class, 'lsLCDropShadow')][contains (@pmnu, 'X')]/descendant::span[text()='Reset to Default']/ancestor::tr[1]", "'RESET TO DEFAULT DATA COLLATION PAGE' menu item");
                //Thread.sleep(1000);

            }

        }catch (Exception e){
            logger.error("Failed to open 'PERSONALIZATION' droplist in the 'Data Collation'toolbar: " + e.getMessage());
        }
    }


    public void timeToLoad_LandingPage() throws Exception {

        //wait till landing page is loaded
        waitTillDescendentElementsAvailable(300, "//html/body/descendant::table", "ENTIRE of DATA COLLATION PAGE");


    }

    public boolean isInitialized() {

        return table_ItemData.isDisplayed();
    }

    public int check_BlankTable_AddItem() {

        //AddItemTable addItemTable = new AddItemTable(driver); //Instantiating object of "addItemTable" class

        Integer row_data = 0;

        //check if the "Add Item" table is displayed in the screen boundaries
        //addItemTable.isWebElementVisibleOnScreen(/*WebElement el1*/);

        //Count the number of DIV elements in the "Add Item" table i.e. 4 DIV means the "Add Item" table is empty
        //Check that the first row in the Right part of the "Add Item" table does not have any data
        try {
            List<WebElement> available_items = driver.findElements(By.xpath("//td[@class='lsContainerCell lsContainerCellVAlign--top urLayoutPadless']/div[@class='urBorderBox urLayoutPadless ']/table[@class='lsHTMLContainer']/tbody/tr/td/div/table/tbody[contains (@id, 'content')]/tr[2]/td[2]/div/div[2]/table/tbody/tr[1]/descendant::td"));

            row_data = available_items.size();
            System.out.println("Detected columns with data in the first row in 'Add Item table': " + row_data);

            logger.warn("The following number of editable columns is detected in the first row of 'Add Item' table: " + row_data+". Where '0' is EMPTY TABLE. Other than '0' means the first editable row was added automatically.");

        } catch (Exception e) {
            logger.error("Unable to read the first row in the 'Add Item' table: " + e.getMessage());
        }

        return row_data;

    }


    public boolean check_DocNumberAndDocStatusEmpty() {

        boolean doc_Details = false;

        String doc_Num = doc_Number.getAttribute("innerText");
        System.out.println("Document Number: " + doc_Num);

        String doc_Stat = doc_Status.getAttribute("innerText");
        System.out.println("Document Status: " + doc_Stat);

        if (doc_Num.equals("")) { //if no document number is displayed
            if (doc_Stat.equals("")) { //if no document status is displayed
                doc_Details = true;
                logger.info("Document Number and Document Status fields are empty as expected.");
            } else {
                logger.error("Document status is NOT EMPTY: " + doc_Stat);
            }
        } else {
            logger.error("Document number is NOT EMPTY: " + doc_Num);
        }
        return doc_Details;
    }


    public boolean check_DocNumberAndDocStatus() {

        boolean doc_Details = false;
        try {
            Test_Cases.doc_Num = doc_Number.getAttribute("innerText");
            System.out.println("Document Number: " + Test_Cases.doc_Num);

            String doc_Stat = doc_Status.getAttribute("innerText");
            System.out.println("Document Status: " + doc_Stat);


            if (Test_Cases.doc_Num.equals("")) { //if no document number is displayed

                switch (doc_Stat) {
                    case "A":
                        doc_Details = true;
                        logger.info("Document Status field is in 'A' status as expected.");
                        break;

                    case "B":
                        doc_Details = true;
                        logger.info("Document Status field is in 'B' status as expected.");
                        break;

                    case "C":
                        doc_Details = true;
                        logger.info("Document Status field is in 'C' status as expected.");
                        break;

                    case "D":
                        doc_Details = true;
                        logger.info("Document Status field is in 'D' status as expected.");
                        break;

                    case "E":
                        doc_Details = true;
                        logger.info("Document Status field is in 'E' status as expected.");
                        break;

                    default:
                }

            } else {
                switch (doc_Stat) {

                    case "C":
                        doc_Details = true;
                        logger.info("Document Status field is in 'C' status as expected. Document Number is " + Test_Cases.doc_Num + ".");
                        break;

                    case "F":
                        doc_Details = true;
                        logger.info("Document Status field is in 'F' status as expected. Document Number is " + Test_Cases.doc_Num + ".");
                        break;
                    default:
                }
            }
        } catch (Exception e) {
            logger.error("Unable to process Document Status and/or Document Number in 'check_DocNumberAndDocStatus()' method: " + e.getMessage());
        }
        return doc_Details;
    }


    public String get_ReversedDocItemCategory() {


        //check the value in the "Item Category" field
        int ColumnCount = 0;
        int neededColumns = 1;
        boolean elAvailability = false;
        String reversedDoc_ItemCategory = "";


        try {
            //Get all columns in the LEFT part of "Add Item" table
            //OFQ//List<WebElement> available_ColumnsInLeftPartOfTable = driver.findElements(By.ByXPath.xpath("//div[@bisposelement='X'][@class='urBorderBox']/table[@class='urST5OuterOffBrd urBorderBox lsSTOuterRightBorder'][contains(@id,'mrss-hdr-left-content')]/tbody/tr/descendant::th"));
            List<WebElement> available_ColumnsInLeftPartOfTable = driver.findElements(By.ByXPath.xpath("//div[@bisposelement='X'][@class='urBorderBox']/table[@class='urST5OuterOffBrd urBorderBox lsSTOuterRightBorder'][contains(@id,'mrss-hdr-left-content')]/tbody/tr/descendant::th"));

            System.out.println("Number of columns in the LEFT part: " + available_ColumnsInLeftPartOfTable.size());

            //Loop through all found coulmns
            for (WebElement element : available_ColumnsInLeftPartOfTable) {
                ColumnCount++; //column counter
                if (neededColumns < 2) {
                    try {//check if every column contains column title text
                        element.findElement(By.xpath("div/table/tbody/tr/td[1]/div/span/span"));
                        elAvailability = true;
                    } catch (NoSuchElementException e) {
                        elAvailability = false;
                    }

                    //if column contains a column title text then read it
                    if (elAvailability) {

                        String name_TableColumn = element.getAttribute("innerText");
                        System.out.println("SPAN element Text in the LEFT part: " + name_TableColumn);

                        //check if the column title text is equal to "Item Category"
                        if (name_TableColumn.contains("Item Category")) {

                            WebElement field_ItemCategory = null;

                            //Find input field below the "Material description" column title and check whether the input field is enabled/editable
                            if (Test_Cases.conf_SystemClient.equals("OFQ_100")) {
                                WebElement elm = driver.findElement(By.ByXPath.xpath("//div[contains(@bisposelement, 'X')][@class='urBorderBox']/table/tbody/tr/td[" + ColumnCount + "]/div/span/span"));
                                field_ItemCategory = elm;
                            }
                            if (Test_Cases.conf_SystemClient.equals("OGQ_100")) {
                                WebElement elm = driver.findElement(By.ByXPath.xpath("//tr[contains(@vpm, 'mrss-cont')]/td[1]/div/div[contains(@bisposelement, 'X')][@class='urBorderBox']/table/tbody/tr/td[" + ColumnCount + "]/div/span"));
                                field_ItemCategory = elm;
                            }


                            reversedDoc_ItemCategory = field_ItemCategory.getAttribute("innerText");
                            neededColumns++;

                        }
                    }
                }
            }


        } catch (Exception e) {
            logger.error("Unable to retrieve the Reversed Document ITEM CATEGORY: " + e.getMessage());
        }

        return reversedDoc_ItemCategory;

    }


    public String get_ReversedDocItemCategory_Row2() {


        //check the value in the "Item Category" field
        int ColumnCount = 0;
        int neededColumns = 1;
        boolean elAvailability = false;
        String reversedDoc_ItemCategory = "";


        try {
            //Get all columns in the LEFT part of "Add Item" table
            //OFQ//List<WebElement> available_ColumnsInLeftPartOfTable = driver.findElements(By.ByXPath.xpath("//div[@bisposelement='X'][@class='urBorderBox']/table[@class='urST5OuterOffBrd urBorderBox lsSTOuterRightBorder'][contains(@id,'mrss-hdr-left-content')]/tbody/tr/descendant::th"));
            List<WebElement> available_ColumnsInLeftPartOfTable = driver.findElements(By.ByXPath.xpath("//div[@bisposelement='X'][@class='urBorderBox']/table[@class='urST5OuterOffBrd urBorderBox lsSTOuterRightBorder'][contains(@id,'mrss-hdr-left-content')]/tbody/tr[2]/descendant::th"));

            System.out.println("Number of columns in the LEFT part: " + available_ColumnsInLeftPartOfTable.size());

            //Loop through all found coulmns
            for (WebElement element : available_ColumnsInLeftPartOfTable) {
                ColumnCount++; //column counter
                if (neededColumns < 2) {
                    try {//check if every column contains column title text
                        element.findElement(By.xpath("div/table/tbody/tr/td[1]/div/span/span"));
                        elAvailability = true;
                    } catch (NoSuchElementException e) {
                        elAvailability = false;
                    }

                    //if column contains a column title text then read it
                    if (elAvailability) {

                        String name_TableColumn = element.getAttribute("innerText");
                        System.out.println("SPAN element Text in the LEFT part: " + name_TableColumn);

                        //check if the column title text is equal to "Item Category"
                        if (name_TableColumn.contains("Item Category")) {

                            WebElement field_ItemCategory = null;

                            //Find input field below the "Material description" column title and check whether the input field is enabled/editable
                            if (Test_Cases.conf_SystemClient.equals("OFQ_100")) {
                                WebElement elm = driver.findElement(By.ByXPath.xpath("//div[contains(@bisposelement, 'X')][@class='urBorderBox']/table/tbody/tr/td[" + ColumnCount + "]/div/span/span"));
                                field_ItemCategory = elm;
                            }
                            if (Test_Cases.conf_SystemClient.equals("OGQ_100")) {
                                WebElement elm = driver.findElement(By.ByXPath.xpath("//tr[contains(@vpm, 'mrss-cont')]/td[1]/div/div[contains(@bisposelement, 'X')][@class='urBorderBox']/table/tbody/tr/td[" + ColumnCount + "]/div/span"));
                                field_ItemCategory = elm;
                            }


                            reversedDoc_ItemCategory = field_ItemCategory.getAttribute("innerText");
                            neededColumns++;

                        }
                    }
                }
            }


        } catch (Exception e) {
            logger.error("Unable to retrieve the Reversed Document ITEM CATEGORY: " + e.getMessage());
        }

        return reversedDoc_ItemCategory;

    }


    public void get_ReversedDocRefNum_and_RefItem() {

        int ColumnCount = 0;
        int neededColumns = 1;
        boolean elAvailability = false;
        try {
            //Get all columns in the RIGHT part of "Add Item" table
            //List<WebElement> available_ColumnsInRightPartOfTable0 = driver.findElements(By.ByXPath.xpath("//div[@bisposelement='X'][@class='urBorderBox']/table[@class='urST5OuterOffBrd urBorderBox lsSTOuterRightBorder'][contains(@id,'mrss-hdr-left-content')]/tbody/tr/descendant::th"));
            //OFQ//List<WebElement> available_ColumnsInRightPartOfTable = driver.findElements(By.ByXPath.xpath("//div[@bisposelement='X'][@class='urBorderBox']/table[@class='urST5OuterOffBrd urBorderBox lsSTOuterRightBorder'][contains(@id,'mrss-hdr-none-content')]/tbody/tr/descendant::th"));
            List<WebElement> available_ColumnsInRightPartOfTable = driver.findElements(By.ByXPath.xpath("//span[contains (text(), 'Reference Document')]/ancestor::th[contains (@subct, 'HC')]/ancestor::tr[contains (@sst, '4')]/descendant::th"));
            System.out.println("Number of columns in the RIGHT part: " + available_ColumnsInRightPartOfTable.size());


            //Loop through all found coulmns
            for (WebElement element : available_ColumnsInRightPartOfTable) {
                ColumnCount++; //column counter
                if (neededColumns <= 2) {
                    System.out.println("Counter of Needed columns: " + neededColumns);
                    try {//check if every column contains column title text
                        //scroll the field to be visible (if outside of vision portal) and click on it
                        //js.executeScript("arguments[0].scrollIntoView(true);", element);

                        element.findElement(By.xpath("div/table/tbody/tr/td[1]/div/span/span"));
                        elAvailability = true;
                    } catch (NoSuchElementException e) {
                        elAvailability = false;
                    }

                    //if column contains a column title text then read it
                    if (elAvailability) {

                        String name_TableColumn = element.getAttribute("innerText");
                        System.out.println("SPAN element Text in the RIGHT part: " + name_TableColumn);

                        //Trim found column title to text only
                        if (name_TableColumn.contains("Reference Document")) {
                            name_TableColumn = "Reference Document";
                        }
                        if (name_TableColumn.contains("Reference Item")) {
                            name_TableColumn = "Reference Item";
                        }


                        switch (name_TableColumn) {

                            case "Reference Document":

                                WebElement field_RefDoc = null;

                                //Find input field below the "Reference Document" column title and check whether the input field is enabled/editable
                                //OFQ//WebElement field_RefDoc = driver.findElement(By.ByXPath.xpath("//tr[@class=' urST5SelColUiGeneric'][contains(@vpm, 'mrss-cont')]/td[2]/div/div[contains(@bisposelement, 'X')][@class='urBorderBox']/table/tbody/tr/td[" + ColumnCount + "]/div/span/span"));

                                if (Test_Cases.conf_SystemClient.equals("OFQ_100")) {
                                    WebElement elm = driver.findElement(By.ByXPath.xpath("//tr[contains(@vpm, 'mrss-cont')]/td[2]/div/div[contains(@bisposelement, 'X')][@class='urBorderBox']/table/tbody/tr/td[" + ColumnCount + "]/div/span/span"));
                                    field_RefDoc = elm;
                                }
                                if (Test_Cases.conf_SystemClient.equals("OGQ_100")) {
                                    WebElement elm = driver.findElement(By.ByXPath.xpath("//tr[contains(@vpm, 'mrss-cont')]/td[2]/div/div[contains(@bisposelement, 'X')][@class='urBorderBox']/table/tbody/tr/td[" + ColumnCount + "]/div/span"));
                                    field_RefDoc = elm;
                                }

                                String inputStatus1 = field_RefDoc.getAttribute("innerText");

                                Assert.assertNotEquals("0000000000", inputStatus1);

                                logger.info("Reference Document number for Reversed document is " + inputStatus1 + ".");
                                neededColumns++;

                                break;

                            case "Reference Item":

                                WebElement field_RefItem = null;
                                //Find input field below the "Reference Item" column title and check whether the input field is enabled/editable
                                //OFQ//WebElement field_RefItem = driver.findElement(By.ByXPath.xpath("//tr[@class=' urST5SelColUiGeneric'][contains(@vpm, 'mrss-cont')]/td[2]/div/div[contains(@bisposelement, 'X')][@class='urBorderBox']/table/tbody/tr/td[" + ColumnCount + "]/div/span/span"));


                                if (Test_Cases.conf_SystemClient.equals("OFQ_100")) {
                                    WebElement elm = driver.findElement(By.ByXPath.xpath("//tr[contains(@vpm, 'mrss-cont')]/td[2]/div/div[contains(@bisposelement, 'X')][@class='urBorderBox']/table/tbody/tr/td[" + ColumnCount + "]/div/span/span"));
                                    field_RefItem = elm;
                                }
                                if (Test_Cases.conf_SystemClient.equals("OGQ_100")) {
                                    WebElement elm = driver.findElement(By.ByXPath.xpath("//tr[contains(@vpm, 'mrss-cont')]/td[2]/div/div[contains(@bisposelement, 'X')][@class='urBorderBox']/table/tbody/tr/td[" + ColumnCount + "]/div/span"));
                                    field_RefItem = elm;
                                }

                                String inputStatus2 = field_RefItem.getAttribute("innerText");

                                Assert.assertNotEquals("000000", inputStatus2);

                                logger.info("Reference Item number for Reversed document is " + inputStatus2 + ".");
                                neededColumns++;
                                break;
                            default:
                        }

                    }
                } else {
                    return;// break the cycle when all required fields have been filled in
                }
            }
        } catch (NoSuchElementException e) {
            logger.error("No such element - Error while retrieving the column titles and fields in the RIGHT part of 'ADD ITEM' table: " + e.getMessage());
        }

    }


    public boolean check_ReversedDocDetails() {

        boolean doc_Details = false;
        boolean doc_itemType = false;
        try {
            Test_Cases.doc_NumReversed = doc_Number.getAttribute("innerText");
            System.out.println("Reversed Document Number: " + Test_Cases.doc_NumReversed);
            Integer doc_reversed = Integer.valueOf(Test_Cases.doc_NumReversed);

            //if reversed document number is bigger by 1 than the original document number
            if ((Integer.toString(doc_reversed - 1)).equals(Test_Cases.doc_Num)) {

                System.out.println("ORG Document Number: " + Test_Cases.doc_Num);

                logger.info("Reversed Document Number is bigger by 1 than the original document number as expected. Reversed Document Number is " + Integer.toString(doc_reversed) + " Original Document Number is " + Test_Cases.doc_Num + ".");

                //check that the reversed document status is "C"
                String doc_Stat = doc_Status.getAttribute("innerText");
                System.out.println("Document Status: " + doc_Stat);

                if (doc_Stat.equals("C")) { //check that the reversed document number is "C"

                    //check the value in the "Item Category" field in the 1st row
                    String addItem_value;
                    addItem_value = get_ReversedDocItemCategory();

                    switch (Test_Cases.itemType) {

                        case "CSN":
                            assertEquals(addItem_value, "XCS");
                            logger.info("Reversed Document ITEM CATEGORY is 'XCS' for 'CSN' document type.");
                            doc_itemType = true;
                            break;

                        case "SPN":
                            assertEquals(addItem_value, "XSP");
                            logger.info("Reversed Document ITEM CATEGORY is 'XSP' for 'SPN' document type.");
                            doc_itemType = true;
                            break;
                        case "CLN":
                            assertEquals(addItem_value, "XCL");
                            logger.info("Reversed Document ITEM CATEGORY is 'XCL' for 'CLN' document type.");
                            doc_itemType = true;
                            break;
                        case "LOS":
                            assertEquals(addItem_value, "XLO");
                            logger.info("Reversed Document ITEM CATEGORY is 'XLO' for 'LOS' document type.");
                            doc_itemType = true;
                            break;
                        case "UOS":
                            assertEquals(addItem_value, "XUO");
                            logger.info("Reversed Document ITEM CATEGORY is 'XUO' for 'UOS' document type.");
                            doc_itemType = true;
                            break;
                        default:
                    }

                    //if Item Categpry is correct for the reversed document, then check the "Reference Document" and "Reference Item" fields to be updated
                    if (doc_itemType == true) {
                        get_ReversedDocRefNum_and_RefItem();
                        doc_Details = true;
                    }

                    //check the value in the "Item Category" field in the 2nd row
                    addItem_value = get_ReversedDocItemCategory_Row2();

                    switch (Test_Cases.itemType) {

                        case "CSN":
                            assertEquals(addItem_value, "XCS");
                            logger.info("Reversed Document ITEM CATEGORY is 'XCS' for 'CSN' document type.");
                            doc_itemType = true;
                            break;

                        case "SPN":
                            assertEquals(addItem_value, "XSP");
                            logger.info("Reversed Document ITEM CATEGORY is 'XSP' for 'SPN' document type.");
                            doc_itemType = true;
                            break;
                        case "CLN":
                            assertEquals(addItem_value, "XCL");
                            logger.info("Reversed Document ITEM CATEGORY is 'XCL' for 'CLN' document type.");
                            doc_itemType = true;
                            break;
                        case "LOS":
                            assertEquals(addItem_value, "XLO");
                            logger.info("Reversed Document ITEM CATEGORY is 'XLO' for 'LOS' document type.");
                            doc_itemType = true;
                            break;
                        case "UOS":
                            assertEquals(addItem_value, "XUO");
                            logger.info("Reversed Document ITEM CATEGORY is 'XUO' for 'UOS' document type.");
                            doc_itemType = true;
                            break;
                        default:
                    }

                    //if Item Categpry is correct for the reversed document, then check the "Reference Document" and "Reference Item" fields to be updated
                    if (doc_itemType == true) {
                        get_ReversedDocRefNum_and_RefItem();
                        doc_Details = true;
                    }

                }
            }
        } catch (Exception e) {
            logger.error("Unable to process the details of reversed document 'check_ReversedDocDetails()' method: " + e.getMessage());
        }
        return doc_Details;
    }


    public boolean check_NewBtnEnabledDisabledStatus() {

        boolean btn_Status = false;

        try {
            String btn_StatusIndicator = btn_NewContainer.getAttribute("class");
            System.out.println("Class of NEW button: " + btn_StatusIndicator);

            //OFQ// if (btn_StatusIndicator.equals("lsButton lsTbarBtnStd urInlineMetricTop urNoUserSelect urBtnRadius  urBtnStdValign  lsButton--toolbar-image  lsButton--up lsButton--design-standard  urBtnStd")) {
            if (!btn_StatusIndicator.contains("lsButton--disabled")) {
                btn_Status = true;
                logger.info("Button 'NEW' is in ENABLED status.");
            } else {
                logger.warn("Button 'NEW' is in DISABLED status.");
            }

        } catch (Exception e) {
            logger.error("Button 'NEW' is not detected: " + e.getMessage());
        }

        return btn_Status;
    }


    public void click_NewBtn() throws Exception {

        try {
            //action.moveToElement(btn_New).click().build().perform();
            js.executeScript("arguments[0].click();", btn_New);
            //btn_New.click();

            //wait till "Header Data" table is updated and gets editable
            //OFQ//waitTillPredefinedDescendentElements(20, "//table[@class='urMatrixLayout urHtmlTableReset']/tbody[@class='urLinStd']/tr[2]/td/table/tbody/tr[3]/td/div[1]/div/div/div[@class='lsRasterLayout']/descendant::input", "Editable HEADER DATA Table", 5);
            waitTillPredefinedDescendentElements(20, "//table[@class='urMatrixLayout urHtmlTableReset']/tbody[@class='urLinStd']/tr[2]/td/table/tbody/tr[3]/td/div[1]/div/div[@class='urBorderBox urLayoutPadless ']/descendant::input", "Editable HEADER DATA Table", 5);

        } catch (Exception e) {

            logger.error("Unable to click on 'NEW' button: " + e.getMessage());

        }
        Thread.sleep(1000);
    }


    public boolean check_AddItemBtnEnabledDisabledStatus() {

        boolean btn_Status = false;

        try {
            String btn_StatusIndicator = btn_AddItemContainer.getAttribute("class");
            System.out.println("Class of ADD ITEM button: " + btn_StatusIndicator);

            //OFQ//if (btn_StatusIndicator.equals("lsButton lsTbarBtnStd urInlineMetricTop urNoUserSelect urBtnRadius  lsButton--onlyImage  urBtnStdValign  lsButton--toolbar-image  urBtnImgBgColor  lsButton--up lsButton--design-standard  urBtnStd")) {
            if (!btn_StatusIndicator.equals("lsButton--disabled")) {
                btn_Status = true;
                logger.info("Button 'ADD ITEM' is in ENABLED status.");
            } else {
                logger.error("Button 'ADD ITEM' is in DISABLED status.");
            }
        } catch (Exception e) {
            logger.error("Button 'ADD ITEM' is not detected: " + e.getMessage());
        }

        return btn_Status;
    }


    public void click_AddItemBtn() {

        btn_AddItemContainer.click();
        // action.moveToElement(btn_AddItemContainer).click().build().perform();
        //js.executeScript("arguments[0].click();", btn_AddItemContainer);

    }


    public void check_HeaderDataPanel_Displayed() {

        try {
            WebElement available_RowsInHeaderDataPanel = driver.findElement(By.ByXPath.xpath("//span[contains(text(), 'Header Data')]/ancestor::table[contains(@class, 'lsPanel urHtmlTableReset')][contains(@ct, 'P')]/tbody/tr[2]"));

            String displayStatus = available_RowsInHeaderDataPanel.getCssValue("display");


            if (displayStatus.contains("none")) {

                //click to open "Header Data" panel
                toggler_HeaderPanel.click();
                // action.moveToElement(tab_Start).click().build().perform();
                //js.executeScript("arguments[0].click();", tab_Start);

                //wait till "Header Panel" gets loaded
                waitTillDescendentElementsAvailable(30, "//span[contains(text(), 'Header Data')]/ancestor::table[contains(@class, 'lsPanel urHtmlTableReset')][contains(@ct, 'P')]/tbody/tr[2]/td/div/descendant::*", "HEADER DATA panel");
            }

        } catch (Exception e) {
            logger.error("Unable to detect the status of HEADER DATA panel: " + e.getMessage());
        }
    }


    public void check_DocumentFlowPanel_Displayed() {

        try {
            WebElement available_RowsInFlowPanelPanel = driver.findElement(By.ByXPath.xpath("//span[contains(text(), 'Document Flow')]/ancestor::table[contains(@class, 'lsPanel urHtmlTableReset')][contains(@ct, 'P')]/tbody/tr[2]"));

            String displayStatus = available_RowsInFlowPanelPanel.getCssValue("display");

            //scroll to bring 'Document Flow' panel's title into view
            js.executeScript("arguments[0].scrollIntoView();", available_RowsInFlowPanelPanel);


            if (displayStatus.contains("none")) {

                //click to open "Document Flow" panel
                toggler_DocumentFlow.click();
                // action.moveToElement(tab_Start).click().build().perform();
                //js.executeScript("arguments[0].click();", tab_Start);

                //wait till "Document Flow" gets loaded
                waitTillDescendentElementsAvailable(30, "//span[contains(text(), 'Document Flow')]/ancestor::table[contains(@class, 'lsPanel urHtmlTableReset')][contains(@ct, 'P')]/tbody/tr[2]/td/div/descendant::*", "DOCUMENT FLOW panel");
            }else{
                logger.info("The DOCUMENT FLOW panel is open by default.");
            }

        } catch (Exception e) {
            logger.warn("Unable to detect the status of DOCUMENT FLOW panel: " + e.getMessage());
            driver.close();
            driver.quit();
        }
    }

    public void click_2ndSubRow_in_DocumentFlowTable() {

        try {

            WebElement second_SubRowInFlowPanelPanel = driver.findElement(By.ByXPath.xpath("//span[contains(text(), 'Document Flow')]/ancestor::table[contains(@class, 'lsPanel urHtmlTableReset')][contains(@ct, 'P')]/tbody/tr[2]/td/div/table/tbody/tr[2]/descendant::tbody[contains (@id, 'content')]/tr[2]/td[2]/descendant::table[contains (@id, 'mrss-cont-none-content')]/tbody/tr[2]/descendant::td[contains (@class, 'lsSTHierarchicalSpace')]"));

            //click to expand the 2nd sub-row in "Document Flow" table
            second_SubRowInFlowPanelPanel.click();
            // action.moveToElement(tab_Start).click().build().perform();
            //js.executeScript("arguments[0].click();", tab_Start);

            //wait till 3rd row with cancelled document gets loaded in "Document Flow" table
            waitTillDescendentElementsAvailable(30, "//span[contains(text(), 'Document Flow')]/ancestor::table[contains(@class, 'lsPanel urHtmlTableReset')][contains(@ct, 'P')]/tbody/tr[2]/td/div/table/tbody/tr[2]/descendant::tbody[contains (@id, 'content')]/tr[2]/td[2]/descendant::table[contains (@id, 'mrss-cont-none-content')]/tbody/tr[3]/descendant::span[contains(text(), '- Cancelled goods movement') or contains(text(), '- Cancelled Goods Movement')]", "DOCUMENT FLOW table -> 3rd SUB-ROW");

            //wait till 4th row with cancelled document gets loaded in "Document Flow" table
            waitTillDescendentElementsAvailable(30, "//span[contains(text(), 'Document Flow')]/ancestor::table[contains(@class, 'lsPanel urHtmlTableReset')][contains(@ct, 'P')]/tbody/tr[2]/td/div/table/tbody/tr[2]/descendant::tbody[contains (@id, 'content')]/tr[2]/td[2]/descendant::table[contains (@id, 'mrss-cont-none-content')]/tbody/tr[4]/descendant::span[contains(text(), '- Cancelled goods movement') or contains(text(), '- Cancelled Goods Movement')]", "DOCUMENT FLOW table -> 4th SUB-ROW");


        } catch (Exception e) {
            logger.error("Unable to click (and open 3rd and 4th sub-rows) in the DOCUMENT FLOW panel: " + e.getMessage());
            driver.close();
            driver.quit();
        }
    }


    public void click_FirstRow_in_DocumentFlowTable() {

        try {
            // WebElement first_RowInFlowPanelPanel = driver.findElement(By.ByXPath.xpath("//span[contains(text(), 'Document Flow')]/ancestor::table[contains(@class, 'lsPanel urHtmlTableReset')][contains(@ct, 'P')]/tbody/tr[2]/td/div/table/tbody/tr[2]/descendant::tbody[contains (@id, 'content')]/tr[2]/td[2]/descendant::a[contains(text(), 'Data Collation')]/parent::tr/td[2][contains (@class, 'lsSTHierarchicalSpace')]"));
            WebElement first_RowInFlowPanelPanel = driver.findElement(By.ByXPath.xpath("//span[contains(text(), 'Document Flow')]/ancestor::table[contains(@class, 'lsPanel urHtmlTableReset')][contains(@ct, 'P')]/tbody/tr[2]/td/div/table/tbody/tr[2]/descendant::tbody[contains (@id, 'content')]/tr[2]/td[2]/descendant::a[contains(@title, 'Data Collation')]/ancestor::tr[1]/td[2][contains (@class, 'lsSTHierarchicalSpace')]"));


            //scroll to bring 'Document Flow' panel's first row into view
            js.executeScript("arguments[0].scrollIntoView();", first_RowInFlowPanelPanel);

            //click to expand the lower level rows in "Document Flow" table
            first_RowInFlowPanelPanel.click();
            // action.moveToElement(tab_Start).click().build().perform();
            //js.executeScript("arguments[0].click();", tab_Start);

            //wait till second-level row get loaded in "Document Flow" table
            waitTillDescendentElementsAvailable(30, "//span[contains(text(), 'Document Flow')]/ancestor::table[contains(@class, 'lsPanel urHtmlTableReset')][contains(@ct, 'P')]/tbody/tr[2]/td/div/table/tbody/tr[2]/descendant::tbody[contains (@id, 'content')]/tr[2]/td[2]/descendant::table[contains (@id, 'mrss-cont-none-content')]/tbody/tr[2]/descendant::span[contains(text(), '"+Test_Cases.doc_Num+" - Data Collation')]", "DOCUMENT FLOW table -> 2nd SUB-ROW");

        } catch (Exception e) {
            logger.error("Unable to click (and open 2nd sub-row) in the DOCUMENT FLOW panel: " + e.getMessage());
            driver.close();
            driver.quit();
        }
    }




    public void read_CancelledGoodsMovementDocNumber_from_DocumentFlowTable_First() {

        try {
            WebElement third_RowInFlowPanelPanel = driver.findElement(By.ByXPath.xpath("//span[contains(text(), 'Document Flow')]/ancestor::table[contains(@class, 'lsPanel urHtmlTableReset')][contains(@ct, 'P')]/tbody/tr[2]/td/div/table/tbody/tr[2]/descendant::tbody[contains (@id, 'content')]/tr[2]/td[2]/descendant::table[contains (@id, 'mrss-cont-none-content')]/tbody/tr[3]/descendant::span[contains(text(), '- Cancelled goods movement') or contains(text(), '- Cancelled Goods Movement')]"));

            //scroll to bring 'Document Flow' panel's second row into view
            js.executeScript("arguments[0].scrollIntoView();", third_RowInFlowPanelPanel);

            String textWithNumber = third_RowInFlowPanelPanel.getText();
            System.out.println("The text from the 3rd row in the DOCUMENT FLOW table: " + textWithNumber);

            String num_StockTransportOrder = textWithNumber.replaceAll("[^0-9]+", "");
            System.out.println("ROW# 3 - Retrieved 'CANCELLED GOODS MOVEMENT' number = " + num_StockTransportOrder);

            /*Pattern p = Pattern.compile("\\d+"); //read only digits from the string
            Matcher m = p.matcher(textWithNumber);

            System.out.println("Retrived 'STOCK TRANSPORT ORDER' number = " + m.toString());

            String num_StockTransportOrder = m.toString();*/


            if(num_StockTransportOrder !=null){

                if(num_StockTransportOrder.length()==14) {

                    Test_Cases.num_GoodsMovementDocNum_1 = num_StockTransportOrder;

                    logger.info("'Cancelled Goods Movement Document' number was successfully retrieved from the 3rd row of the DOCUMENT FLOW table. It is equal to '" + Test_Cases.num_GoodsMovementDocNum_1 + "' ");


                }else{

                    logger.warn("Retrieved 'Cancelled Goods Movement Document' number (in ROW# 3) consists of "+num_StockTransportOrder.length()+" instead of expected 14 digits!");

                }

            }else{
                logger.error("The 'Cancelled Goods Movement Document' number (from the 3rd row of the DOCUMENT FLOW table) is NULL. This means that XLO document was not properly created!");
            }


        } catch (Exception e) {
            logger.error("Unable to retrieve 'CANCELLED GOODS MOVEMENT DOCUMENT' number from the 3rd row of DOCUMENT FLOW ptable: " + e.getMessage());
            driver.close();
            driver.quit();
        }
    }


    public void read_CancelledGoodsMovementDocNumber_from_DocumentFlowTable_Second() {

        try {
            WebElement third_RowInFlowPanelPanel = driver.findElement(By.ByXPath.xpath("//span[contains(text(), 'Document Flow')]/ancestor::table[contains(@class, 'lsPanel urHtmlTableReset')][contains(@ct, 'P')]/tbody/tr[2]/td/div/table/tbody/tr[2]/descendant::tbody[contains (@id, 'content')]/tr[2]/td[2]/descendant::table[contains (@id, 'mrss-cont-none-content')]/tbody/tr[4]/descendant::span[contains(text(), 'Cancelled goods movement') or contains(text(), '- Cancelled Goods Movement')]"));

            //scroll to bring 'Document Flow' panel's second row into view
            js.executeScript("arguments[0].scrollIntoView();", third_RowInFlowPanelPanel);

            String textWithNumber = third_RowInFlowPanelPanel.getText();
            System.out.println("The text from the 4th row in the DOCUMENT FLOW table: " + textWithNumber);

            String num_StockTransportOrder = textWithNumber.replaceAll("[^0-9]+", "");
            System.out.println("ROW# 4 - Retrieved 'CANCELLED GOODS MOVEMENT' number = " + num_StockTransportOrder);

            /*Pattern p = Pattern.compile("\\d+"); //read only digits from the string
            Matcher m = p.matcher(textWithNumber);

            System.out.println("Retrived 'STOCK TRANSPORT ORDER' number = " + m.toString());

            String num_StockTransportOrder = m.toString();*/


            if(num_StockTransportOrder !=null){

                if(num_StockTransportOrder.length()==14) {

                    Test_Cases.num_GoodsMovementDocNum_2 = num_StockTransportOrder;

                    logger.info("'Cancelled Goods Movement Document' number was successfully retrieved from the 4th row of the DOCUMENT FLOW table. It is equal to '" + Test_Cases.num_GoodsMovementDocNum_2 + "' ");

                    //Scroll back to the top of the page
                    //js.executeScript("arguments[0].scrollIntoView();", header_StandardDataCollation);

                }else{

                    logger.warn("Retrieved 'Cancelled Goods Movement Document' number (in ROW# 4) consists of "+num_StockTransportOrder.length()+" instead of expected 14 digits!");

                }

            }else{
                logger.error("The 'Cancelled Goods Movement Document' number (from the 4th row of the DOCUMENT FLOW table) is NULL. This means that XUO document was not properly created!");
            }


        } catch (Exception e) {
            logger.error("Unable to retrieve 'CANCELLED GOODS MOVEMENT DOCUMENT' number from the 4th row of DOCUMENT FLOW ptable: " + e.getMessage());
            driver.close();
            driver.quit();
        }
    }




    public void check_ItemDataPanel_Displayed() {

        try {
            WebElement available_RowsInHeaderDataPanel = driver.findElement(By.ByXPath.xpath("//span[contains(text(), 'Item Data')]/ancestor::table[contains(@class, 'lsPanel urHtmlTableReset')][contains(@ct, 'P')]/tbody/tr[2]"));

            String displayStatus = available_RowsInHeaderDataPanel.getCssValue("display");


            if (displayStatus.contains("none")) {

                //click to open "Header Data" panel
                toggler_ItemDataPanel.click();
                // action.moveToElement(tab_Start).click().build().perform();
                //js.executeScript("arguments[0].click();", tab_Start);

                //wait till "Item Data" panel gets loaded
                waitTillDescendentElementsAvailable(30, "//span[contains(text(), 'Item Data')]/ancestor::table[contains(@class, 'lsPanel urHtmlTableReset')][contains(@ct, 'P')]/tbody/tr[2]/td/div/descendant::*", "ITEM DATA panel");
            }

        } catch (Exception e) {
            logger.error("Unable to detect the status of HEADER DATA panel: " + e.getMessage());
        }
    }

}
