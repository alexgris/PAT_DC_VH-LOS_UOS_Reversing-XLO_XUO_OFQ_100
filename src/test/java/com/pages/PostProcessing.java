package com.pages;

import init.settings.PageObject;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.project.Test_Cases;

import java.util.List;

import static ax.generic.Waitings.*;

public class PostProcessing extends PageObject {

    public Logger logger = Logger.getLogger(PostProcessing.class);

    //Locating "Check" button in the toolbar
    @FindBy(xpath = "//span[contains(text(), 'Check')]")
    private WebElement btn_Check;

    //Locating "Check" button's container
    //OFQ//@FindBy(xpath = "//div[@class='lsPageHeader--item urPgHITrans']/table[@class='lsToolbar--overflow urTWhlFlat lsTItmOvflFlat urHtmlTableReset urTBar lsToolbar']/tbody/tr/td[1]/div[@class='lsTbarOvfl']/span[13]/div")
    @FindBy(xpath = "//div[@class='lsPageHeader--item urPgHITrans']/div/div[1]/descendant::div[contains (@title, 'Check Document')]")
    private WebElement btn_CheckContainer;

    //Locating "Release" button's container
    //OFQ//@FindBy(xpath = "//div[@class='lsPageHeader--item urPgHITrans']/table[@class='lsToolbar--overflow urTWhlFlat lsTItmOvflFlat urHtmlTableReset urTBar lsToolbar']/tbody/tr/td[1]/div[@class='lsTbarOvfl']/span[14]/div")
    @FindBy(xpath = "//div[@class='lsPageHeader--item urPgHITrans']/div/div[1]/descendant::div[contains (@title, 'Release Document')]")
    private WebElement btn_ReleaseContainer;

    //Locating "Release" button in the toolbar
    @FindBy(xpath = "//span[contains(text(), 'Release')]")
    private WebElement btn_Release;

    //Locating "Save" button's container
    //OFQ//@FindBy(xpath = "//div[@class='lsPageHeader--item urPgHITrans']/table[@class='lsToolbar--overflow urTWhlFlat lsTItmOvflFlat urHtmlTableReset urTBar lsToolbar']/tbody/tr/td[1]/div[@class='lsTbarOvfl']/span[1]/div")
    @FindBy(xpath = "//div[@class='lsPageHeader--item urPgHITrans']/div/div[1]/descendant::div[contains (@title, '(Ctrl+S)')]")
    private WebElement btn_SaveContainer;

    //Locating "Save" button in the toolbar
    @FindBy(xpath = "//span[contains(text(), 'Save')]")
    private WebElement btn_Save;

    //Locating "Process" button's container
    //OFQ//@FindBy(xpath = "//div[@class='lsPageHeader--item urPgHITrans']/table[@class='lsToolbar--overflow urTWhlFlat lsTItmOvflFlat urHtmlTableReset urTBar lsToolbar']/tbody/tr/td[1]/div[@class='lsTbarOvfl']/span[15]/div")
    @FindBy(xpath = "//div[@class='lsPageHeader--item urPgHITrans']/div/div[1]/descendant::div[contains (@title, 'Process Document')]")
    private WebElement btn_ProcessContainer;

    //Locating "Process" button in the toolbar
    @FindBy(xpath = "//span[contains(text(), 'Process')]")
    private WebElement btn_Process;

    //Locating "StandardDataCollation" section on the top of the page
   // @FindBy(xpath = "//span[contains(text(), 'Transaction Type')]/ancestor::table[@class='lsTWhlNested urTWhlTrans urHtmlTableReset urTBar lsToolbar'][contains (@ct, 'T')]")
    @FindBy(xpath = "//span[contains(text(), 'Transaction Type')]/ancestor::td[contains (@class, 'lsContainerCell lsGLCTopVAlign lsContainerCellVAlign--top ')][contains (@ct, 'GLC')]")
    private WebElement header_StandardDataCollation;

    //Locating "Reverse" button's container
    //OFQ//@FindBy(xpath = "//div[@class='lsPageHeader--item urPgHITrans']/table[@class='lsToolbar--overflow urTWhlFlat lsTItmOvflFlat urHtmlTableReset urTBar lsToolbar']/tbody/tr/td[1]/div[@class='lsTbarOvfl']/span[18]/div")
    @FindBy(xpath = "//div[@class='lsPageHeader--item urPgHITrans']/descendant::div[contains (@class, 'lsToolbar--standards-leftItems')]/span[18]/div")
    private WebElement btn_ReverseContainer;

    //Locating "Process" button in the toolbar
    @FindBy(xpath = "//span[contains(text(), 'Reverse')]")
    private WebElement btn_Reverse;

    //Locating PROCESSING STATUS panel
   // @FindBy(xpath = "//td[contains (text(), 'Data Collation')]/ancestor::div[contains (@ct, 'PHM')][contains (@class, 'urPgHSmall sapLSStandalonePH')]/div[2]/descendant::tr[contains(@rr, '1')][contains (@rt, '0')]/td[2]/descendant::span[contains (@class, 'urTxtStd urTxtColor')]")
    @FindBy(xpath = "//div[contains (text(), 'Data Collation')]/ancestor::div[contains (@ct, 'PHM')][contains (@class, 'urPgHSmall sapLSStandalonePH')]/div[3]/descendant::tr[contains(@rr, '1')][contains (@rt, '0')]/td[2]/descendant::span[contains (@ct, 'TV')]")
    private WebElement textStatus_Panel;



    //Constructor
    public PostProcessing(WebDriver driver) {
        super(driver);

    }

    JavascriptExecutor js = (JavascriptExecutor) driver;
    Actions action = new Actions(driver);

    public void verifyUpdatedReferenceDocumentAndReferenceItem(){

        int ColumnCount = 0;
        int neededColumns = 1;
        boolean elAvailability = false;
        try {
            //Get all columns in the RIGHT part of "Add Item" table
            //List<WebElement> available_ColumnsInRightPartOfTable0 = driver.findElements(By.ByXPath.xpath("//div[@bisposelement='X'][@class='urBorderBox']/table[@class='urST5OuterOffBrd urBorderBox lsSTOuterRightBorder'][contains(@id,'mrss-hdr-left-content')]/tbody/tr/descendant::th"));
            //OFQ//List<WebElement> available_ColumnsInRightPartOfTable = driver.findElements(By.ByXPath.xpath("//div[@bisposelement='X'][@class='urBorderBox']/table[@class='urST5OuterOffBrd urBorderBox lsSTOuterRightBorder'][contains(@id,'mrss-hdr-none-content')]/tbody/tr/descendant::th"));
            List<WebElement> available_ColumnsInRightPartOfTable = driver.findElements(By.ByXPath.xpath("//span[contains (text(), 'Reference Document')]/ancestor::th[contains (@subct, 'HC')]/ancestor::tr[contains (@sst, '4')]/descendant::th"));

            System.out.println("Number of columns in the RIGHT part: " + available_ColumnsInRightPartOfTable.size());


            //Loop through all found columns
            for (WebElement element : available_ColumnsInRightPartOfTable) {
                ColumnCount++; //column counter
                if (neededColumns <= 2) {
                    System.out.println("Counter of Needed columns: " + neededColumns);

                    try {//check if every column contains column title text
                        element.findElement(By.xpath("div/table/tbody/tr/td[1]/div/span/span"));
                        elAvailability = true;
                    } catch (NoSuchElementException e) {
                        elAvailability = false;
                    }

                    //if column contains a column title text then read it
                    if (elAvailability) {

                        String name_TableColumn = element.getAttribute("innerText");
                        System.out.println("SPAN element Text in the RIGHT part: " + name_TableColumn);

                        if (name_TableColumn.contains("Reference Document")) {
                            name_TableColumn = "Reference Document";
                        }
                        if (name_TableColumn.contains("Reference Item")) {
                            name_TableColumn = "Reference Item";
                        }

                        switch (name_TableColumn) {
                            case "Reference Document":

                                WebElement field_ReferenceDocument = null;

                                //Find input field below the "Reference Document" column title
                                for (int i =1; i<=2; i++) {
                                    if (Test_Cases.conf_SystemClient.equals("OFQ_100")) {
                                        WebElement elm = driver.findElement(By.ByXPath.xpath("//tr[contains(@vpm, 'mrss-cont')]/td[2]/div/div[contains(@bisposelement, 'X')][@class='urBorderBox']/table/tbody/tr[" + i + "]/td[" + ColumnCount + "]/div/span/span"));
                                        field_ReferenceDocument = elm;
                                    }
                                    if (Test_Cases.conf_SystemClient.equals("OGQ_100")) {
                                        WebElement elm = driver.findElement(By.ByXPath.xpath("//tr[contains(@vpm, 'mrss-cont')]/td[2]/div/div[contains(@bisposelement, 'X')][@class='urBorderBox']/table/tbody/tr[" + i + "]/td[" + ColumnCount + "]/div/span"));
                                        field_ReferenceDocument = elm;
                                    }


                                    String inputValue1 = field_ReferenceDocument.getAttribute("innerText");


                                    if (inputValue1.length() > 4)
                                    {
                                        inputValue1 = inputValue1.substring(inputValue1.length() - 4);
                                        System.out.println("Truncated 'REFERENCE DOCUMENT' is equal to: "+ inputValue1);
                                    }

                                    int reversedNum = Integer.valueOf(Test_Cases.doc_Num) -1;
                                    System.out.println("The 'reversedNum' is equal to: " + reversedNum);
                                    String reversedNumString = Integer.toString(reversedNum);
                                    System.out.println("The 'reversedNumString' is equal to: " + reversedNumString);

                                    if (inputValue1.equals(reversedNumString)) {

                                        logger.info("REFERENCE DOCUMENT # '"+inputValue1+"' in ROW # "+i+" IS LESSER by 1 than the REVERSED DOCUMNET # '"+Test_Cases.doc_Num+"' AS EXPECTED.");
                                        //neededColumns++;
                                    } else {
                                        logger.warn("REFERENCE DOCUMENT # '"+inputValue1+"' in ROW # "+i+" IS NOT LESSER by 1 than the REVERSED DOCUMNET # '"+Test_Cases.doc_Num+"' !!!");
                                        //neededColumns++;
                                    }
                                }
                                neededColumns++;
                                break;


                            case "Reference Item":

                                //Find input field below the "Reference Item" column title and check whether the input field is enabled/editable
                                //OFQ//WebElement field_BaseUOF = driver.findElement(By.ByXPath.xpath("//tr[@class=' urST5SelColUiGeneric'][contains(@vpm, 'mrss-cont')]/td[2]/div/div[contains(@bisposelement, 'X')][@class='urBorderBox']/table/tbody/tr/td[" + ColumnCount + "]/div/span/span"));
                                WebElement field_RefItem = null;
                                String inputValue2 = "";

                                //Find input field below the "Reference Item" column title and check whether the input field is enabled/editable
                                for (int i =1; i<=2; i++) {
                                    if (Test_Cases.conf_SystemClient.equals("OFQ_100")) {
                                        WebElement elm = driver.findElement(By.ByXPath.xpath("//tr[contains(@vpm, 'mrss-cont')]/td[2]/div/div[contains(@bisposelement, 'X')][@class='urBorderBox']/table/tbody/tr["+i+"]/td[" + ColumnCount + "]/div/span/span"));
                                        field_RefItem = elm;
                                        inputValue2 = field_RefItem.getAttribute("innerText");
                                    }
                                    if (Test_Cases.conf_SystemClient.equals("OGQ_100")) {
                                        WebElement elm = driver.findElement(By.ByXPath.xpath("//tr[contains(@vpm, 'mrss-cont')]/td[2]/div/div[contains(@bisposelement, 'X')][@class='urBorderBox']/table/tbody/tr["+i+"]/td[" + ColumnCount + "]/div/span/span"));
                                        field_RefItem = elm;
                                        //inputValue2 = field_BaseUOF.getAttribute("value");
                                        inputValue2 = field_RefItem.getAttribute("innerText");
                                    }


                                    if (inputValue2.equals("000020") || inputValue2.equals("000010")) {

                                        logger.info("REFERENCE ITEM # '"+inputValue2+"' in ROW # "+i+" IS EQUAL to '"+inputValue2+"' AS EXPECTED.");
                                        //neededColumns++;
                                    } else {
                                        logger.warn("REFERENCE ITEM # '"+inputValue2+"' in ROW # "+i+" IS NOT EQUAL to '000010' or '000020' !!!");
                                        //neededColumns++;
                                    }
                                }
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


    public void verifyUpdatedItemCategories() {

        int ColumnCount = 0;
        int neededColumns = 0;
        boolean elAvailability = false;


        try {
            //Get all columns in the LEFT part of "Add Item" table
            List<WebElement> available_ColumnsInLeftPartOfTable = driver.findElements(By.ByXPath.xpath("//div[@bisposelement='X'][@class='urBorderBox']/table[@class='urST5OuterOffBrd urBorderBox lsSTOuterRightBorder'][contains(@id,'mrss-hdr-left-content')]/tbody/tr/descendant::th"));

            System.out.println("Number of columns in the LEFT part: " + available_ColumnsInLeftPartOfTable.size());

            //Loop through all found coulmns
            for (WebElement element : available_ColumnsInLeftPartOfTable) {
                ColumnCount++; //column counter
                if (neededColumns < 1) {
                    System.out.println("Counter of Needed columns in the LEFT part of ADD ITEM table: " + neededColumns);

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
                        if (name_TableColumn.contains("Item Category") || name_TableColumn.contains("Item category")) {

                            for (int i=1; i<=2; i++) {
                                //Find input field below the "Item Caregory" column title and provide a value into it
                                WebElement input_ItemCategory = driver.findElement(By.ByXPath.xpath("//span[text()='Item Data']/ancestor::table[contains (@ct, 'P')][contains (@class, 'lsPanel urHtmlTableReset')][1]/tbody/tr[2]/descendant::table[contains (@shscrollcontentid, 'mrss-hdr-none-content')][contains (@ct, 'STCS')]/tbody[contains (@id, 'content')]/tr[contains (@vpm, 'mrss-cont')]/td[1]/descendant::table[contains (@id, 'mrss-cont-left-content')]/tbody/tr[" + i + "]/td[" + ColumnCount + "]/div/span/span"));
                                String categoryItem = input_ItemCategory.getAttribute("innerText");
                                System.out.println("'ITEM CATEGORY' after REVERSING in ROW# '"+i+"' is equal to: " + categoryItem);

                                if(categoryItem.equalsIgnoreCase("XLO") || categoryItem.equalsIgnoreCase("XUO")){
                                    logger.info("'ITEM CATEGORY' after REVERSING in ROW# '"+i+"' is equal to : " + categoryItem.toUpperCase() + " AS EXPECTED.");
                                }else{
                                    logger.warn("WRONG 'ITEM CATEGORY' after REVERSING in ROW# '"+i+"'!!! Actual value is : " + categoryItem.toUpperCase() + " INSTEAD OF EXPECTED 'XLO' or 'XUO'.");
                                }


                            }
                            neededColumns++;
                        }
                    }
                } else {
                    return;// break the cycle when all required fields have been filled in
                }
            }

        } catch (NoSuchElementException e) {
            logger.error("No such element - Error while retrieving the 'Item Category' column: " + e.getMessage());
        }

    }

    public void click_CheckBtn_StatusCheck() {

        boolean statusAvailability= false;

        try {

            //Scroll back to the top of the page
            js.executeScript("arguments[0].scrollIntoView();", header_StandardDataCollation);
           /* js.executeScript("window.scrollBy(0,-250)");
            js.executeScript("window.scrollTo(0, -250)");
            js.executeScript("window.scrollTo(document.body.scrollHeight,0)");*/

            //driver.findElement(By.xpath("//table[@class='urMatrixLayout urHtmlTableReset']/tbody[@class='urLinStd']/tr[1]/td/div[@class='urPgHSmall sapLSStandalonePH']/div[2][@class='lsPageHeader--item urPgHITrans']/div/div/descendant::*[contains(text(), 'Sales partners were supplemented from customer master of customer') or contains(text(), 'Purchasing organization GPUR was added')]"));
            statusAvailability = true;
        } catch (NoSuchElementException e) {
            statusAvailability = false;
        }


        try {
            //wait till new status is displayed after clicking on "Check" button
            //explicitWaitsUntilElementPresent(20, "//span[contains(text(), 'Sales partners were supplemented from customer master of customer') or contains(text(), 'Purchasing organization GPUR was added')]", "Status update after clicking on CHECK button");


            //check if the document's status of "Sales partners were supplemented from customer master of customer" or "Purchasing organization GPUR was added" is displayed
            if (statusAvailability==true)  {

                //logger.info("The expected pre-conditioned status before clicking on CHECK button is displayed.");
                logger.info("The pre-conditioned status before clicking on CHECK button is hidden as expected.");

                js.executeScript("arguments[0].click();", btn_Check);
                //action.click(btn_Check).build().perform();

            } else {
                logger.error("The pre-conditioned status should be hidden before clicking on CHECK button!");
            }
        }catch (Exception e){

            logger.error("Unable to detect/click on 'CHECK' button: " + e.getMessage());

        }
    }


    public void click_ReleaseBtn_StatusCheck()  {

        AddItemTable addItmPg = new AddItemTable(driver); //Instantiating object of "AddItemTable" class

        try {
            //wait till new status is displayed after clicking on "Release" button
            explicitWaitsUntilElementPresent(20, "//span[contains(text(), 'PAT document is complete')]", "Status update after clicking on RELEASE button");

            //check if the document's current status is "Sales partners were supplemented from customer master of customer"
            if (addItmPg.check_IfElementIsPresent("//span[contains(text(), 'PAT document is complete')]")) {

                logger.info("The preconditioned status 'PAT document is complete' is displayed as expected before clicking on RELEASE button");

                js.executeScript("arguments[0].click();", btn_Release);
                //action.click(btn_Check).build().perform();

            } else {
                logger.error("The document does not appear to have a pre-conditioned status of 'PAT document is complete'.");
            }
        }catch (Exception e){

            logger.error("Unable to detect/click on 'RELEASE' button: " + e.getMessage());

        }
    }


    public void click_SaveBtn_StatusCheck() {

        AddItemTable addItmPg = new AddItemTable(driver); //Instantiating object of "AddItemTable" class

        try {
            //wait till new status is displayed after clicking on "Release" button
            explicitWaitsUntilElementPresent(20, "//span[contains(text(), 'PAT document was released')]", "Status update after clicking on SAVE button");

            //wait till "Process" button gets enabled
            //explicitWaitsUntilElementPresent(20, "//span[contains(text(), 'PAT document was released')]", "Status update after clicking on SAVE button");


            //check if the document's current status is "Sales partners were supplemented from customer master of customer"
            if (addItmPg.check_IfElementIsPresent("//span[contains(text(), 'PAT document was released')]")) {

                logger.info("The preconditioned status 'PAT document was released' is displayed as expected before clicking on RELEASE button");

                js.executeScript("arguments[0].click();", btn_Save);
                //action.click(btn_Check).build().perform();

            } else {
                logger.error("The document does not appear to have a pre-conditioned status of 'PAT document was released'.");
            }
        }catch (Exception e){

            logger.error("Unable to detect/click on 'SAVE' button: " + e.getMessage());

        }
    }

    public void click_ProcessBtn()  {

        AddItemTable addItmPg = new AddItemTable(driver); //Instantiating object of "AddItemTable" class

        try {

            js.executeScript("arguments[0].click();", btn_Process);
                //action.click(btn_Check).build().perform();

            logger.info("The PROCESS button was clicked SUCCESSFULLY");

        }catch (Exception e){
            logger.error("Unable to detect/click on 'PROCESS' button: " + e.getMessage());
        }
    }

    public void click_ProcessBtn_StatusCheck()  {

        AddItemTable addItmPg = new AddItemTable(driver); //Instantiating object of "AddItemTable" class

        try {
            //wait till "Process" button gets enabled
            //explicitWaitsUntilElementPresent(20, "//tbody/tr/td[1]/div[@class='lsTbarOvfl']/span[15]/div[contains(@class, 'lsButton lsTbarBtnStd urInlineMetricTop urNoUserSelect urBtnRadius  urBtnStdValign  lsButton--toolbar-image  lsButton--up lsButton--design-standard  urBtnStd') or ('lsButton lsTbarBtnStd urNoUserSelect urBtnRadius  urBtnStdValign  urInlineMetricTop  urBtnStdWithImg urBtnStd')]", "PROCESS button gets ENABLED");
            explicitWaitsUntilElementPresent(20, "//div[@class='lsPageHeader--item urPgHITrans']/div/div[1]/descendant::div[contains (@title, 'Process Document')][contains(@class, 'lsButton--active  lsButton--hoverable  lsButton--focusable  lsButton--up lsButton--design-standard')]", "PROCESS button gets ENABLED");



            //check if the document's current status is "Sales partners were supplemented from customer master of customer"
            if (addItmPg.check_IfElementIsPresent("//span[contains(text(), 'was saved')]")) {

                logger.info("The preconditioned status 'Document '"+ Test_Cases.doc_Num+"' was saved' is displayed as expected before clicking on PROCESS button");

                js.executeScript("arguments[0].click();", btn_Process);
                //action.click(btn_Check).build().perform();

            } else {
                logger.error("The document does not appear to have a pre-conditioned status of 'Document #### was saved'.");
            }
        }catch (Exception e){

            logger.error("Unable to detect/click on 'PROCESS' button: " + e.getMessage());

        }
    }


    public void click_ProcessBtn_StatusCheck_AfterCancellation()  {

        try {
            //wait till "Process" button gets enabled
           // explicitWaitsUntilElementPresent(20, "//tbody/tr/td[1]/div[@class='lsTbarOvfl']/span[15]/div[contains(@class, 'lsButton lsTbarBtnStd urInlineMetricTop urNoUserSelect urBtnRadius  urBtnStdValign  lsButton--toolbar-image  lsButton--up lsButton--design-standard  urBtnStd') or ('lsButton lsTbarBtnStd urNoUserSelect urBtnRadius  urBtnStdValign  urInlineMetricTop  urBtnStdWithImg urBtnStd')]", "PROCESS button gets ENABLED");
           // waitTillWebElementChangesInitialProperty(20, "//div[@class='lsPageHeader--item urPgHITrans']/table[contains (@class, 'urTWhlFlat lsTItmOvflFlat urHtmlTableReset urTBar lsToolbar')]/tbody/tr/td[1]/div[@class='lsTbarOvfl']/span[15]/div", "urBtnStdDsbl", "PROCESS button gets ENABLED");
                js.executeScript("arguments[0].click();", btn_Process);
                //action.click(btn_Check).build().perform();

        }catch (Exception e){
            logger.error("Unable to detect/click on 'PROCESS' button: " + e.getMessage());
        }
    }


    public boolean check_CheckBtnEnabledDisabledStatus() {

        boolean btn_Status = false;

        try {
            String btn_StatusIndicator = btn_CheckContainer.getAttribute("class");
            System.out.println("Class of CHECK button: " + btn_StatusIndicator);

            if (!btn_StatusIndicator.contains("urBtnStdDsbl")) {

                btn_Status = true;
                logger.info("Button 'CHECK' is in ENABLED status.");
            } else {
                logger.error("Button 'CHECK' is in DISABLED status.");
            }

        } catch (Exception e) {
            logger.error("Button 'CHECK' is not detected: " + e.getMessage());
        }

        return btn_Status;
    }


    public boolean check_ReleaseBtnEnabledDisabledStatus() {

        boolean btn_Status = false;

        try {
            String btn_StatusIndicator = btn_ReleaseContainer.getAttribute("class");
            System.out.println("Class of RELEASE button: " + btn_StatusIndicator);

            if (!btn_StatusIndicator.contains("urBtnStdDsbl")) {
                btn_Status = true;
                logger.info("Button 'RELEASE' is in ENABLED status.");
            } else {
                logger.error("Button 'RELEASE' is in DISABLED status.");
            }

        } catch (Exception e) {
            logger.error("Button 'RELEASE' is not detected: " + e.getMessage());
        }

        return btn_Status;
    }



    public boolean check_SaveBtnEnabledDisabledStatus() {

        boolean btn_Status = false;

        try {
            String btn_StatusIndicator = btn_SaveContainer.getAttribute("class");
            System.out.println("Class of SAVE button: " + btn_StatusIndicator);

            if (!btn_StatusIndicator.contains("urBtnStdDsbl")) {
                btn_Status = true;
                logger.info("Button 'SAVE' is in ENABLED status.");
            } else {
                logger.error("Button 'SAVE' is in DISABLED status.");
            }

        } catch (Exception e) {
            logger.error("Button 'SAVE' is not detected: " + e.getMessage());
        }

        return btn_Status;
    }


    public boolean check_ProcessBtnEnabledDisabledStatus()  {

        boolean btn_Status = false;

        try {
            String btn_StatusIndicator = btn_ProcessContainer.getAttribute("class");
            System.out.println("Class of PROCESS button: " + btn_StatusIndicator);

            if (!btn_StatusIndicator.contains("urBtnStdDsbl")) {
                btn_Status = true;
                logger.info("Button 'PROCESS' is in ENABLED status.");
            } else {
                logger.error("Button 'PROCESS' is in DISABLED status.");
            }

        } catch (Exception e) {
            logger.error("Button 'PROCESS' is not detected: " + e.getMessage());
        }

        return btn_Status;
    }


    public boolean check_ReverseBtnEnabledDisabledStatus() {

        boolean btn_Status = false;

        try {
            String btn_StatusIndicator = btn_ReverseContainer.getAttribute("class");
            System.out.println("Class of REVERSE button: " + btn_StatusIndicator);

            //OFQ//if (btn_StatusIndicator.equals("lsButton lsTbarBtnStd urInlineMetricTop urNoUserSelect urBtnRadius  urBtnStdValign  lsButton--toolbar-image  lsButton--up lsButton--design-standard  urBtnStd")) {
            if (!btn_StatusIndicator.contains("lsButton--disabled")) {
                btn_Status = true;
                logger.info("Button 'REVERSE' is in ENABLED status.");
            } else {
                logger.error("Button 'REVERSE' is in DISABLED status.");
            }

        } catch (Exception e) {
            logger.error("Button 'REVERSE' is not detected: " + e.getMessage());
        }

        return btn_Status;
    }


    public void click_ReverseBtn_StatusCheck()  {

        AddItemTable addItmPg = new AddItemTable(driver); //Instantiating object of "AddItemTable" class

        try {
            //wait till "Reverse" button gets enabled
            //OFQ//explicitWaitsUntilElementPresent(20, "//tbody/tr/td[1]/div[@class='lsTbarOvfl']/span[18]/div[contains(@class, 'lsButton lsTbarBtnStd urInlineMetricTop urNoUserSelect urBtnRadius  urBtnStdValign  lsButton--toolbar-image  lsButton--up lsButton--design-standard  urBtnStd')]", "REVERSE button gets ENABLED");
            waitTillWebElementChangesInitialProperty(20, "//div[@class='lsPageHeader--item urPgHITrans']/descendant::div[contains (@class, 'lsToolbar--standards-leftItems')]/span[18]/div", "lsButton--disabled", "REVERSE button gets ENABLED");

            //check if the document's current status is "PAT document <number> was posted"
          //  if (addItmPg.check_IfElementIsPresent("//span[contains(text(), 'was posted')]")) {

               // logger.info("The preconditioned status 'Document '"+ Test_Cases.doc_Num+"' was posted' is displayed as expected before clicking on REVERSE button");

                js.executeScript("arguments[0].click();", btn_Reverse);
                //action.click(btn_Check).build().perform();

            logger.info("'REVERSE' button was clicked SUCCESSFULLY.");

          /*  } else {
                logger.error("The document does not appear to have a pre-conditioned status of 'Document #### was posted'.");
            }*/
        }catch (Exception e){

            logger.error("Unable to detect/click on 'REVERSE' button: " + e.getMessage());

        }
    }


    public boolean retrieve_DocProcessingStatus() {

        boolean post_processing_Status = false;

        try {
            //Find "Stock Transfer in Stock in Transit" check-box and check if it is unselected
            String status_Text= textStatus_Panel.getText();
            System.out.println("Status of the document after clicling on 'PROCESSING' button is: " + status_Text);

            if(status_Text.contains("01 items could not be successfully posted")){// if the processing has failed

                logger.warn("PROCESSING did NOT finish successfully!");
                post_processing_Status = false;

            }else{
                if(status_Text.contains("PAT document "+Test_Cases.doc_Num+" was posted")) {// if the processing has succeeded
                    logger.info("PROCESSING finish SUCCESSFULLY!");
                    post_processing_Status = true;
                }
            }

        } catch (Exception e) {
            logger.error("Error while retrieving document processing status after clicking PROCESSING button: " + e.getMessage());
        }

        return post_processing_Status;
    }

}
