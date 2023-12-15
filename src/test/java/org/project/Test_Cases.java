package org.project;


import ax.generic.FileProcessing;
import com.pages.*;
import init.settings.SeleniumSetUp;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.SkipException;
import org.testng.annotations.*;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import static ax.generic.FileProcessing.*;
import static ax.generic.Graphics_Screenshots.*;
import static ax.generic.Waitings.*;
import static org.testng.Assert.assertTrue;

public class Test_Cases extends SeleniumSetUp {

    public Logger logger = Logger.getLogger(Test_Cases.class);


    JavascriptExecutor js = (JavascriptExecutor) driver;

    //global variable that stores the status of "Customer Role Check" popup as displayed/not displayed
    public static boolean popup_CustomerRoleCheck = false;

    //global variable that stores the status of "WARNING" (after clicking on "REVERSE" button) popup as displayed/not displayed
    public static boolean popup_Warning = false;


    //global variable for "Item Category"
    public static String itemType;
    public static String itemType2;
    public static String itemType3;
    public static String doc_Num;
    public static String doc_Num2;
    public static String doc_NumReversed;
    public static String conf_SystemClient;
    public static String num_GoodsMovementDocNum_1;
    public static String num_GoodsMovementDocNum_2;
    public static String Material2;
    public static String Quantity2;
    public static String Plant2;
    public static String BaseUnitOfMeasure2;
    public static String StorageLocation2;
    public static String ValuationType2;
    public static String HandlingType2;
    public static String Material3;
    public static String Quantity3;
    public static String Plant3;
    public static String BaseUnitOfMeasure3;
    public static String StorageLocation3;
    public static String ValuationType3;
    public static String HandlingType3;
    public static String MaterialDocumentNumber2;
    public static String MaterialDocumentNumber3;
    public static Boolean FirstMaterialDocPage = false;
    public static Boolean SecondMaterialDocPage = false;


    @BeforeSuite
    public void preTestSettinngs() throws Exception {

        //Delete previously created screenshots from .\src\main\resources\current_images folder
        deleteFilesFromFolder(".\\src\\main\\resources\\current_images");

        //Delete previously created screenshots from .\src\main\resources\error_images folder
        deleteFilesFromFolder(".\\src\\main\\resources\\error_images");

        //Delete previously created log4j files from /log_files_temp folder
        deleteFilesFromFolder(".\\src\\main\\resources\\log_files_temp");
    }


    @BeforeTest
    public void preTestConfigurations() throws Exception {

        //Delete previously created log4j files
        deleteOld_Files(".\\src\\main\\resources\\log_files", "LOG files from 'log_files' folder:");

        //Path to the Log4j logger config file
        PropertyConfigurator.configure(".\\src\\main\\resources\\log4j.properties");

        //Turn on logging level
        //Logger.getRootLogger().setLevel(Level.INFO);


    }

    @Test(priority = 0)
    @Parameters({"target_System_Client", "item_Type_1"})
    public void openDataCollationPage_Testing(String target_System_Client, String item_Type_1) throws Exception {

        driver.manage().window().maximize();

        //assign document item type LOS to a global variable
        itemType = item_Type_1;

        conf_SystemClient = target_System_Client;
        System.out.println("Current System: " + conf_SystemClient);


        //Select correct URL for a particular System/Client
        switch (target_System_Client) {

            //Open Data Collation page on OFQ/100
            case "OFQ_100":

                driver.navigate().to("https://ldciofq.wdf.sap.corp:44300/sap/bc/webdynpro/pat/ui_wa_main?WDCONFIGURATIONID=%2fPAT%2fDC_AC_VEHICLE&sap-client=100&sap-language=EN#");

                break;

            default:
        }


        LandingPage landingPage = new LandingPage(driver); //Instantiating object of "LandingPage" class
        landingPage.timeToLoad_LandingPage(); //measuring the time needed to load the landing page
        Thread.sleep(1000);

        assertTrue(landingPage.check_DocNumberAndDocStatusEmpty()); //confirm that the "Document Number" and "Document Status" fields are empty

        landingPage.check_HeaderDataPanel_Displayed();//if "Header Data" panel is closed then open it
        landingPage.check_ItemDataPanel_Displayed();//if "Item Data" panel is closed then open it

        //click on "Personalize" button on the "Data Collation" toolbar
        landingPage.click_PersonalizeBtn_DataCollationPage(conf_SystemClient);
        Thread.sleep(1000);

        //Select "Set to Default" menu item from "Personalize" dropdown on the "Data Collation" toolbar
        landingPage.click_SetToDefault_DataCollationPage();
        Thread.sleep(1000);

        //click on "Personalize" button on the "Item Data" table
        landingPage.click_PersonalizeBtn(conf_SystemClient);
        Thread.sleep(1000);

        //check whether the "Set to Default" button is disabled or enabled. If enabled them click on to display all columns and set the columns' width. If it disabled then
        //simply set the columns' width
        landingPage.check_SetToDefaultBtn_SetColumnsWidth(conf_SystemClient);

        // Adjust width of the columns for better visibility.
        //Check that check-marks a set for the 6 columns "Item status", "Transfer posting", "Item Number", "Sequence Number of the Item", "Posting Sequence" and "Item Category"
        if (landingPage.check_AvailableColumns_Section_Empty() == true) {
            landingPage.set_WidthOfColumns_in_DisplayedColumns_Section(conf_SystemClient);
        }


        //Click on "Save" button on the "Personalization" popup and wait till the landing page gets downloaded again
        landingPage.click_SaveBtn(conf_SystemClient);

        assertTrue(landingPage.isInitialized()); //confirm that page elements are available (i.e. "No data available" icon is visible in the "Add Item" table)
        captureWebElementScreenshot("//body", "Data_Collation_Page_Empty_FullSize.", "EMPTY DATA COLLATION PAGE", ".\\src\\main\\resources\\current_images\\"); //take a screenshot of empty "Data Collation" page after it is opened

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


        //confirm that the "Add Item" table is empty
        if (landingPage.check_BlankTable_AddItem() != false) {
            logger.error("The first record in the 'ADD ITEM' table is detected as editable. However, it is expected to be empty after saving PERSONOLIZED settings.");

            //take a screenshot of empty "Data Collation" page after it is opened in case it has errors
            captureErrorScreenshot("//body", "Data_Collation_Page_Empty_FullSize_Error.", ".\\src\\main\\resources\\error_images\\");

            //stop execution and exit
            driver.close();
        }

    }


    @Test(dependsOnMethods = {"openDataCollationPage_Testing"})
    @Parameters({"input_VehicleNumber"})

    public void add_NewItemRow_Testing(String input_VehicleNumber) throws Exception {

        LandingPage landingPage = new LandingPage(driver); //Instantiating object of "LandingPage" class
        AddItemTable addItemTable = new AddItemTable(driver); //Instantiating object of "addItemTable" class

        //confirm that the "New" button is enabled
        if (landingPage.check_NewBtnEnabledDisabledStatus() == false) {

            //take a screenshot of the toolbar with "NEW" button
            captureErrorScreenshot(landingPage.btn_NewDisabled_OFQ, "New_Btn_Disabled_NotFound_Error.", ".\\src\\main\\resources\\error_images\\");

            //stop execution and exit
            driver.close();

        } else {

            //click on "New" button
            landingPage.click_NewBtn();

            //check whether "NEW" button changed its status to 'disabled' after clicking on it
            if (landingPage.check_NewBtnEnabledDisabledStatus() != false) {
                logger.warn("'NEW' button did not get DISABLED after clicking action!");
            }
        }


        //Check if "Vehicle" tab is selected by default
        addItemTable.checkVehicleTab_isOpen();
        Thread.sleep(1000);

        //Find "Vehicle Number" input field, and provide a value
        addItemTable.fillIn_VehicleNumber(input_VehicleNumber);

        //Check if "Overview for the Reference Object" popup gets displayed after providing value into "Vehicle Number" input
        if (addItemTable.popup_OverviewRefObject_isOpen() == true) {

            //Select first row and click on "Transfer the Reference Object" button to close the popup
            addItemTable.filling_OverviewRefObject_popup();

        }


        //wait till new status is displayed after providing value into "Vehicle Number" field
        explicitWaitsUntilElementPresent(20, String.format(addItemTable.message_AfterClosingOverviewRefObjPopup_OFQ, input_VehicleNumber), "Status update after providing VEHICLE NUMBER value");
        Thread.sleep(1000);


        //Check that the "Plant for Vehicle" field got auto filled (not empty).
        addItemTable.check_PlantForVehicle_notEmpty();

        //Check that the "Storage Location for Vehicle" field got auto filled (not empty).
        addItemTable.check_StorageLocationForVehicle_notEmpty();

        //confirm that the "Add Item" button is enabled
        if (landingPage.check_AddItemBtnEnabledDisabledStatus() == false) {

            //take a screenshot of the toolbar with "ADD ITEM" button
            captureErrorScreenshot(landingPage.toolbar_AddItem_OFQ, "AddItem_Btn_Disabled_NotFound_Error.", ".\\src\\main\\resources\\error_images\\");

            //stop execution and exit
            driver.close();

        } else {//if "Add Item" button is enabled then ...

            //check whether the "Item Data" table already has automatically added first row
            if (landingPage.check_BlankTable_AddItem() == false) {

                //click on "Add Item" button
                landingPage.click_AddItemBtn();

                logger.info("'ADD ITEM' button was clicked because the 'ITEM DATA' table has NO editable rows yet.");

                addItemTable.timeToLoad_AddItemEditableFirstRow(); //waiting till the first editable row is loaded in the "Add Item" table

            } else {

                logger.info("The 'ITEM DATA' table already has one editable row which was added automatically.");

            }
        }
    }


    @Test(dependsOnMethods = {"add_NewItemRow_Testing"})
    public void fill_in_NewItemFields_Testing() throws Exception {

        LandingPage landingPage = new LandingPage(driver); //Instantiating object of "LandingPage" class
        AddItemTable addItemTable = new AddItemTable(driver); //Instantiating object of "addItemTable" class

        assertTrue(addItemTable.isInitialized()); //checking whether or not the first editable row is displayed in the "Add Item" table
        Thread.sleep(2000);
        assertTrue(landingPage.check_DocNumberAndDocStatus()); //confirm that the "Document Number" is empty and "Document Status" fields is set to A

    }


    @Test(dependsOnMethods = {"fill_in_NewItemFields_Testing"}/*, dataProvider="ItemCategories", dataProviderClass= DataproviderClass.class*/)
    public void fill_in_ItemCategory_Testing() throws Exception {

        AddItemTable addItemTable = new AddItemTable(driver); //Instantiating object of "addItemTable" class

        // provide value "LOS" into "ItemCategory" field
        addItemTable.find_ItemCategoryField_andFillItIn_VDG(itemType, "1");

        waitForExtAjaxIsReadyState(15, "Updating ADD ITEM TABLE");
        waitTillWebElementChangesInitialProperty(15, String.format(addItemTable.rightPartColumns_AddItem_Table_OFQ, 1, 3), "urSTTDRo2", "RIGHT PART of ADD ITEM TABLE -> 1st ROW");
        Thread.sleep(2000);

    }


    @Test(dependsOnMethods = {"fill_in_ItemCategory_Testing"})
    @Parameters({"cell_Material_1", "cell_Qty_1", "cell_Plant_1", "cell_StorgLocatn_1", "cell_ValtnType_1", "cell_HandlingType_1", "auto_cell_MaterialDescription_1", "auto_cell_BaseUnitOfMeasure_1"})
    public void fill_in_RightPartOfTable_Testing(String cell_Material_1, String cell_Qty_1, String cell_Plant_1, String cell_StorgLocatn_1,
                                                 String cell_ValtnType_1, String cell_HandlingType_1,
                                                 String auto_cell_MaterialDescription_1, String auto_cell_BaseUnitOfMeasure_1) throws Exception {


        AddItemTable addItemTable = new AddItemTable(driver); //Instantiating object of "addItemTable" class

        addItemTable.filling_AllRemainingFields_VDG("1", cell_Material_1, cell_Qty_1, cell_Plant_1, cell_StorgLocatn_1, cell_ValtnType_1, cell_HandlingType_1); //fill in all fields in the right part of the table
        Thread.sleep(2000);

        addItemTable.check_AutocompeteFields_VDG(conf_SystemClient,"1", auto_cell_MaterialDescription_1, auto_cell_BaseUnitOfMeasure_1); //check that non-editable fields have automatically been assigned values (i.e. not just empty)


    }


    @Test(dependsOnMethods = {"fill_in_RightPartOfTable_Testing"})
    @Parameters({"item_Type_2", "cell_Material_2", "cell_Qty_2", "cell_Plant_2", "cell_StorgLocatn_2", "cell_ValtnType_2", "cell_HandlingType_2", "auto_cell_MaterialDescription_2", "auto_cell_BaseUnitOfMeasure_2"})
    public void filling_SecondRowforAddItemTable_Testing(String item_Type_2, String cell_Material_2, String cell_Qty_2, String cell_Plant_2, String cell_StorgLocatn_2,
                                                         String cell_ValtnType_2, String cell_HandlingType_2,
                                                         String auto_cell_MaterialDescription_2, String auto_cell_BaseUnitOfMeasure_2) throws Exception {

        LandingPage landingPage = new LandingPage(driver); //Instantiating object of "LandingPage" class
        AddItemTable addItemTable = new AddItemTable(driver); //Instantiating object of "addItemTable" class

        //Assign doc type UOS to a global variable
        itemType2 = item_Type_2;

        //click on "Add Item" button
        landingPage.click_AddItemBtn();

        logger.info("'ADD ITEM' button was clicked to add the second row into the 'ITEM DATA' table.");

        addItemTable.timeToLoad_AddItemEditableSecondRow(); //waiting till the second editable row is loaded in the "Add Item" table
        Thread.sleep(1000);


        // provide value "UOS" into "ItemCategory" field
        addItemTable.find_ItemCategoryField_andFillItIn_VDG(itemType2, "2");

        waitForExtAjaxIsReadyState(15, "Updating ADD ITEM TABLE");
        waitTillWebElementChangesInitialProperty(15, String.format(addItemTable.rightPartColumns_AddItem_Table_OFQ, 2, 3), "urSTTDRo2", "RIGHT PART of ADD ITEM TABLE -> 2nd ROW");
        Thread.sleep(2000);

        addItemTable.filling_AllRemainingFields_VDG("2", cell_Material_2, cell_Qty_2, cell_Plant_2, cell_StorgLocatn_2, cell_ValtnType_2, cell_HandlingType_2); //fill in all fields in the right part of the table
        Thread.sleep(2000);

        addItemTable.check_AutocompeteFields_VDG(conf_SystemClient,"2", auto_cell_MaterialDescription_2, auto_cell_BaseUnitOfMeasure_2); //check that non-editable fields have automatically been assigned values (i.e. not just empty)

    }


    @Test(dependsOnMethods = {"filling_SecondRowforAddItemTable_Testing"})
    public void finalize_ProcessingOfVehicleRelatedDocument_Testing() throws Exception {

        PostProcessing postProcess = new PostProcessing(driver); //Instantiating object of "PostProcessing" class
        LandingPage landingPage = new LandingPage(driver); //Instantiating object of "LandingPage" class


        //confirm that the "Check" button is enabled
        if (postProcess.check_CheckBtnEnabledDisabledStatus() == false) {

            //take a screenshot of the toolbar with "CHECK" button
            captureErrorScreenshot(postProcess.toolbar_CheckBtn_OFQ, "Check_Btn_Disabled_NotFound_Error.", ".\\src\\main\\resources\\error_images\\");

            //stop execution and exit
            driver.close();

        } else {
            //click on "Check" button
            postProcess.click_CheckBtn_StatusCheck();
            explicitWaitsUntilElementPresent(120, postProcess.status_afterReleaseBtn_OFQ, "'PAT DOCUMENT IS COMPLETE' status message");
            Thread.sleep(1000);

            assertTrue(landingPage.check_DocNumberAndDocStatus()); //confirm that the "Document Number" is empty and "Document Status" fields is set to B
        }

        //confirm that the "Release" button is enabled
        if (postProcess.check_ReleaseBtnEnabledDisabledStatus() == false) {

            //take a screenshot of the toolbar with "RELEASE" button
            captureErrorScreenshot(postProcess.toolbar_ReleaseBtn_OFQ, "Release_Btn_Disabled_NotFound_Error.", ".\\src\\main\\resources\\error_images\\");

            //stop execution and exit
            driver.close();

        } else {
            //click on "Release" button
            postProcess.click_ReleaseBtn_StatusCheck();
            explicitWaitsUntilElementPresent(120, postProcess.status_afterSaveBtn_OFQ, "'PAT DOCUMENT WAS RELEASED' status message");
            Thread.sleep(1000);

            assertTrue(landingPage.check_DocNumberAndDocStatus()); //confirm that the "Document Number" is empty and "Document Status" fields is set to C
        }


        //confirm that the "Save" button is enabled
        if (postProcess.check_SaveBtnEnabledDisabledStatus() == false) {

            //take a screenshot of the toolbar with "SAVE" button
            captureErrorScreenshot(postProcess.toolbar_SaveBtn_OFQ, "Save_Btn_Disabled_NotFound_Error.", ".\\src\\main\\resources\\error_images\\");

            //stop execution and exit
            driver.close();

        } else {
            //click on "Save" button
            postProcess.click_SaveBtn_StatusCheck();
            explicitWaitsUntilElementPresent(120, postProcess.status_DocSaved_OFQ, "'PAT DOCUMENT WAS SAVED' status message");
            Thread.sleep(1000);

            //assign document number to a global variable
            doc_Num = landingPage.retrieve_DocNumber();

            assertTrue(landingPage.check_DocNumberAndDocStatus()); //confirm that the "Document Number" is empty and "Document Status" fields is set to C
        }

        //confirm that the "Process" button is enabled
        if (postProcess.check_ProcessBtnEnabledDisabledStatus() == false) {

            //take a screenshot of the toolbar with "PROCESS" button
            captureErrorScreenshot(postProcess.toolbar_ProcessBtn_OFQ, "Process_Btn_Disabled_NotFound_Error.", ".\\src\\main\\resources\\error_images\\");

            //stop execution and exit
            driver.close();

        } else {
            //click on "Process" button
            postProcess.click_ProcessBtn_StatusCheck(doc_Num);
            explicitWaitsUntilElementPresent(120, String.format(postProcess.status_DocumentPosted_OFQ, doc_Num, doc_Num), "PROCESSING OPERATION NOTIFICATION");

            Thread.sleep(2000);

            //check whether the processing has ended with an error or without
           /* if (postProcess.retrieve_DocProcessingStatus() == false) {

                //if error was displayed then click on "Process" button again
                postProcess.click_ProcessBtn();
                explicitWaitsUntilElementPresent(120, "//span[contains(text(), 'PAT document "+doc_Num+" was posted')]", "PROCESSING SUCCESSFULL NOTIFICATION");
                Thread.sleep(1000);

                explicitWaitsUntilElementPresent(40, "//div[@class='lsHTMLContainer']/div/table[@class='urMatrixLayout urHtmlTableReset']/tbody[@class='urLinStd']/tr[2]/td[2]/div/div/table/tbody/tr/td/descendant::span[contains(text(),'F')]", "DOCUMENT STATUS 'F'");
                Thread.sleep(1000);
                assertTrue(landingPage.check_DocNumberAndDocStatus()); //confirm that the "Document Number" is displayed and "Document Status" fields is set to F

            }else{
                explicitWaitsUntilElementPresent(40, "//div[@class='lsHTMLContainer']/div/table[@class='urMatrixLayout urHtmlTableReset']/tbody[@class='urLinStd']/tr[2]/td[2]/div/div/table/tbody/tr/td/descendant::span[contains(text(),'F')]", "DOCUMENT STATUS 'F'");
                assertTrue(landingPage.check_DocNumberAndDocStatus()); //confirm that the "Document Number" is displayed and "Document Status" fields is set to F
            }*/

            explicitWaitsUntilElementPresent(40, postProcess.status_F_DocProcessed_OFQ, "DOCUMENT STATUS 'F'");
            assertTrue(landingPage.check_DocNumberAndDocStatus()); //confirm that the "Document Number" is displayed and "Document Status" fields is set to F
            captureWebElementScreenshot("//body", "Data_Collation_Page_Completed_FullSize.", "COMPLETED DATA COLLATION PAGE", ".\\src\\main\\resources\\current_images\\"); //take a screenshot of empty "Data Collation" page after it is opened

        }

    }


    @Test(dependsOnMethods = {"finalize_ProcessingOfVehicleRelatedDocument_Testing"})
    public void postprocessing_SearchPostedVehicleRelatedDoc_Testing() throws Exception {

        Locator_DocCompare docCompare = new Locator_DocCompare(driver); //Instantiating object of "Locator_DocCompare" class
        LandingPage landingPage = new LandingPage(driver); //Instantiating object of "LandingPage" class

        //confirm that the "Locator" button is enabled
        if (docCompare.check_LocatorBtnEnabledDisabledStatus() == false) {

            //take a screenshot of the toolbar with "LOCATOR" button
            captureErrorScreenshot(docCompare.toolbar_LocatorBtn_OFQ, "Locator_Btn_Disabled_NotFound_Error.", ".\\src\\main\\resources\\error_images\\");

            //stop execution and exit
            driver.close();

        } else {
            //click on "LOCATOR" button
            docCompare.click_LocatorBtn_StatusCheck();

            //wait till "Locator" panel gets displayed
            explicitWaitsUntilElementPresent(40, docCompare.panel_Locator_OFQ, "LOCATOR PANEL");
            Thread.sleep(1000);

            //Click on "Personalize" button in "Locator" panel
            docCompare.click_PersonalizeBtn_LocatorPanel(conf_SystemClient);
            Thread.sleep(1000);

            //check whether the "Set to Default" button is disabled or enabled. If enabled them click on it to display all columns and set the columns' width. If it disabled then
            //simply set the columns' width
            docCompare.check_SetToDefaultBtn_PersonolizedPopup_LocatorPanel(conf_SystemClient);
            Thread.sleep(1000);

            // Adjust width of the columns for better visibility.
            //Check that check-marks a set for the 6 columns "Item status", "Transfer posting", "Item Number", "Sequence Number of the Item", "Posting Sequence" and "Item Category"
            if (landingPage.check_AvailableColumns_Section_Empty() == true) {
                docCompare.set_WidthOfColumns_in_DisplayedColumns_Section_Persnlztn_Locator(conf_SystemClient);
                Thread.sleep(1000);
            }

            //Click on "Save" button on the "Personalization" popup (for "Locator" panel) and wait till the landing page gets downloaded again
            landingPage.click_SaveBtn(conf_SystemClient);
            Thread.sleep(1000);

            //providing Document number into Search Criteria field
            docCompare.fillout_SearchCriteria(doc_Num);
            Thread.sleep(1000);

            //click on "Search" button and wait till documents are displayed in the lower table
            docCompare.click_SearchBtn(doc_Num);
            Thread.sleep(1000);

            //check the status of the found document
            docCompare.check_StatusOfFoundDocument();
            Thread.sleep(1000);

            //check if DocStatus correctly correlates with DocNum in the "Results" table
            docCompare.correlate_DocStatusAndDocNum(doc_Num);
            Thread.sleep(1000);

            //take a screenshot of the "Locator" panel
            captureWebElementScreenshot(docCompare.wholePanel_Locator_OFQ, "Locator_Panel_DocStatus.", "LOCATOR PANEL WITH DOCUMENT STATUS", ".\\src\\main\\resources\\current_images\\");

            Thread.sleep(2000);

            //confirm that the "Locator" button is enabled
            if (docCompare.check_LocatorBtnEnabledDisabledStatus() == false) {
                logger.error("LOCATOR button is DISABLED. It is expected to be ENABLED to continue!");

                //stop execution and exit
                driver.close();
            } else {
                docCompare.click_LocatorBtn();//click on "LOCATOR" button to close "Locator" panel

            }
            Thread.sleep(3000);
        }

    }


    @Test(dependsOnMethods = {"postprocessing_SearchPostedVehicleRelatedDoc_Testing"})
    @Parameters({"item_Type_3"})
    public void postprocessing_ReverseOrder_Testing(String item_Type_3) throws Exception {

        PostProcessing postProcess = new PostProcessing(driver); //Instantiating object of "PostProcessing" class
        LandingPage landingPage = new LandingPage(driver); //Instantiating object of "LandingPage" class
        AddItemTable addItemTable = new AddItemTable(driver); //Instantiating object of "AddItemTable" class

        //assigning item type XLO_XUO of reversed document to a global variable
        itemType3 = item_Type_3;

        //confirm that the "Reverse" button is enabled
        if (postProcess.check_ReverseBtnEnabledDisabledStatus() == false) {

            //take a screenshot of the toolbar with "REVERSE" button
            captureErrorScreenshot(postProcess.toolbar_ReverseBtn_OFQ, itemType3.toUpperCase() + "-Reverse_Btn_Disabled_NotFound_Error.", ".\\src\\main\\resources\\error_images\\");

            //stop execution and exit
            driver.close();

        } else {
            //click on "Reverse" button
            postProcess.click_ReverseBtn_StatusCheck_RoundTwo();
            Thread.sleep(2000);

            //Select the parent web element for "Warning" popup depending on the system and client
            if (conf_SystemClient.equals("OFQ_100")) {
                driver.switchTo().frame(driver.findElement(By.xpath(landingPage.iFrame_1_OFQ)));

                waitTillPredefinedDescendentElements(20, postProcess.popup_ReverseWarning_OFQ, "WARNING POPUP ON REVERSE ACTION", 4);
                Thread.sleep(1000);

                //check if "WARNING" popup is really displayed
                popup_Warning = addItemTable.check_IfWarningOnReversePopupDisplayed_OFQ();

                //if "Warning" popup is displayed
                if (popup_Warning == true) {

                    //close the "Warning" popup and wait till it gets escaped
                    landingPage.close_WarningPOPUP();

                    driver.switchTo().defaultContent();

                    waitForExtAjaxIsReadyState(40, "MAIN PAGE after closing WARNING POPUP");
                    Thread.sleep(2000);
                }

            }

            if (conf_SystemClient.equals("OGQ_100")) {

                driver.switchTo().frame(driver.findElement(By.xpath(landingPage.iFrame_1_OGQ)));

                waitTillPredefinedDescendentElements(20, postProcess.popup_ReverseWarning_OFQ, "WARNING POPUP ON REVERSE ACTION", 4);
                Thread.sleep(1000);

                //check if "WARNING" popup is really displayed
                addItemTable.check_IfWarningOnReversePopupDisplayed_OFQ();

                //if "Warning" popup is displayed
                if (popup_Warning == true) {

                    //close the "Warning" popup and wait till it gets escaped
                    landingPage.close_WarningPOPUP_OGQ();

                    driver.switchTo().defaultContent();

                    waitForExtAjaxIsReadyState(40, "WARNING POPUP");
                    Thread.sleep(2000);

                }
            }


            //Check the status of reversed document, as well as "Item Category", "Reference Number" and "Reference Item" for LOS -> XLO
            landingPage.check_ReversedDocDetails_XLO_XUO(doc_Num, itemType.toUpperCase(), conf_SystemClient);

            //Check the status of reversed document, as well as "Item Category", "Reference Number" and "Reference Item" for UOS -> XUO
            landingPage.check_ReversedDocDetails_XLO_XUO(doc_Num, itemType2.toUpperCase(), conf_SystemClient);

            //assign document number to a global variable
            doc_NumReversed = landingPage.retrieve_ReversedDocNumber();

            //Make the screenshot of the page with reversed document
            captureWebElementScreenshot("//body", itemType3.toUpperCase() + "-Reversed_Document_Page_Completed_FullSize.", "REVERSED DOCUMENT PAGE", ".\\src\\main\\resources\\current_images\\"); //take a screenshot of a "Data Collation" page after the document was reversed

        }
    }


    @Test(dependsOnMethods = {"postprocessing_ReverseOrder_Testing"})
    public void postprocessing_SearchingCancelledOrder_Testing() throws Exception {

        LandingPage landingPage = new LandingPage(driver); //Instantiating object of "LandingPage" class
        Locator_DocCompare docCompare = new Locator_DocCompare(driver); //Instantiating object of "Locator_DocCompare" class
        Locator_DocSearch locatorDocSearch = new Locator_DocSearch(driver); //Instantiating object of "Locator_DocSearch" class

        //open "Locator" panel
        docCompare.click_LocatorBtn_StatusCheck();

        //wait till "Locator" panel gets displayed
        explicitWaitsUntilElementPresent(40, docCompare.panel_Locator_OFQ, "LOCATOR PANEL");
        Thread.sleep(1000);

        //filling out all Search Criteria fields
        //docCompare.fillout_SearchCriteria_Reversed(doc_Num, doc_NumReversed);
        docCompare.fillout_SearchCriteria_FailedAutoRefresh(doc_Num);
        Thread.sleep(1000);

        //click on "Search" button and wait till documents are displayed in the lower table
        docCompare.click_SearchBtn(doc_NumReversed);
        Thread.sleep(1000);

        //check that reversed document found in search results
        if (locatorDocSearch.check_IfElementIsPresent(locatorDocSearch.status_NoneEntriesFound)) {
            logger.warn("NONE ENTRIES FOR THE 'REVERSED' DOCUMENT ARE FOUND after clicking on 'SEARCH' button on LOCATOR panel.");

            //stop execution and exit
            driver.close();
        } else {
            locatorDocSearch.click_OnFirstRowWithFoundDoc(doc_Num);//clicking on the row with found document

            //wait till the reversed document number is displayed on the main page
            waitTillElementDetectedByProperty(120, landingPage.enabledButton_Process_OFQ, "innerText", doc_NumReversed, "UPDATED 'VEHICLE-RELATED DATA COLLATION' page after clicking on the result in LOCATOR panel");
            Thread.sleep(1000);

            //Scroll back to the top of the page
            landingPage.mainPage_scrollToTheTop();
            Thread.sleep(1000);

            docCompare.click_LocatorBtn();//click on "LOCATOR" button to close "Locator" panel
            waitForExtAjaxIsReadyState(40, "UPDATED MAIN PAGE after closing LOCATOR PANEL");
            Thread.sleep(2000);
        }
    }


    @Test(dependsOnMethods = {"postprocessing_SearchingCancelledOrder_Testing"})
    public void postprocessing_ProcessReversedOrder_Testing() throws Exception {

        PostProcessing postProcess = new PostProcessing(driver); //Instantiating object of "PostProcessing" class
        LandingPage landingPage = new LandingPage(driver); //Instantiating object of "LandingPage" class


        //click on "Process" button
        postProcess.click_ProcessBtn_StatusCheck_AfterCancellation();

        Integer doc_reversed_number = Integer.valueOf(doc_NumReversed);
        //doc_reversed_number = doc_reversed_number + 1;
        //String ttt = Integer.toString(doc_number + 1);

        explicitWaitsUntilElementPresent(40, String.format(postProcess.status_DocumentPosted_OFQ, doc_NumReversed, doc_NumReversed), "PROCESSING COMPLETED NOTIFICATION");
        explicitWaitsUntilElementPresent(40, postProcess.status_F_DocProcessed_OFQ, "DOCUMENT STATUS 'F'");
        Thread.sleep(1000);

        assertTrue(landingPage.check_DocNumberAndDocStatus()); //confirm that the "Document Number" is displayed and "Document Status" fields is set to F

        //check that "Item Category" has changed to XLO and XUO.
        postProcess.verifyUpdatedItemCategories();

        //check that:
        // 1) “Reference Document” in “Item Data” table is assigned a value “Current Document Number - 1”;
        // 2) “Reference Item” in “Item Data” table is assigned a value “000010” for XLO and value “000020” for XUO.
        postProcess.verifyUpdatedReferenceDocumentAndReferenceItem(conf_SystemClient, doc_NumReversed);

        captureWebElementScreenshot("//body", itemType3.toUpperCase() + "-ReProcessed_Document_Page_FullSize.", "REPROCESSED DOCUMENT PAGE", ".\\src\\main\\resources\\current_images\\"); //take a screenshot of the processed "Data Collation" page after it was reversed
        Thread.sleep(8000);

    }


    @Test(dependsOnMethods = {"postprocessing_ProcessReversedOrder_Testing"})
    public void postprocessing_Read_StockTransportOrderNumber_Testing() throws Exception {

        LandingPage landingPage = new LandingPage(driver); //Instantiating object of "LandingPage" class


        landingPage.check_DocumentFlowPanel_Displayed();//if "Document Flow" panel is closed then open it
        Thread.sleep(1000);

        landingPage.click_FirstRow_in_DocumentFlowTable_XLO_XUO(doc_NumReversed);//find the first row in "Document Flow" table and click on the arrow to open lower-level rows
        Thread.sleep(1000);

        landingPage.click_2ndSubRow_in_DocumentFlowTable();//find the 2nd sub-row in "Document Flow" table and click on the arrow to open lower-level rows with documents
        Thread.sleep(1000);

        num_GoodsMovementDocNum_1 = landingPage.read_CancelledGoodsMovementDocNumber_from_DocumentFlowTable_First();//find the third row in "Document Flow" table and read the number of Cancelled Goods Movement number and save it in global variable
        Thread.sleep(1000);

        num_GoodsMovementDocNum_2 = landingPage.read_CancelledGoodsMovementDocNumber_from_DocumentFlowTable_Second();//find the third row in "Document Flow" table and read the number of  Goods Movement number and save it in global variable
        Thread.sleep(1000);

        //capture completed "Document Flow" section
        captureWebElementScreenshot("//body", "DocumentFlow_Section_Completed_FullSize.", "DOCUMENT FLOW SECTION COMPLETED", ".\\src\\main\\resources\\current_images\\");

    }


    @Test(dependsOnMethods = {"postprocessing_Read_StockTransportOrderNumber_Testing"})
    @Parameters({"target_System_Client"})
    public void displayFirstMaterialDocumentPage_Testing(String target_System_Client) throws Exception {

        MaterialDocPage pageMaterialDoc = new MaterialDocPage(driver); //Instantiating object of "MaterialDocPage" class
        LandingPage landingPage = new LandingPage(driver); //Instantiating object of "LandingPage" class


        conf_SystemClient = target_System_Client;
        System.out.println("Current System: " + conf_SystemClient);

        String currentHandle = driver.getWindowHandle();
        System.out.println("Current Handle TAB: " + currentHandle);

        //First you have to save current handles of all opened windows:
        Set<String> windowHandlersSet = driver.getWindowHandles();

        //Select correct URL for a particular System/Client
      /*  switch (target_System_Client) {

            //Open "Display Material Document" page on OFQ/100
            case "OFQ_100":

                // driver.navigate().to("https://ldciofq.wdf.sap.corp:44300/sap/bc/gui/sap/its/webgui;~sysid=OFQ;~service=3200?%7etransaction=*APB_LPD_CALL_TRANS%20P_ROLE%3dPAT%3bP_APPL%3dPAT_FRW%3bP_TCODE%3d%2fPAT%2fUI_MIGO_CALL%3bP_SELSCR%3d%3bP_PNP%3d%3bP_ENCMTH%3d%3bP_OBJECT%3dGOACTION%2521A04%2525MBLNR%"+num_GoodsMovementDocNum_1+"%2525MJAHR%25212020%2525OKCODE%2521MIGO_OK_GO%2525REFDOC%2521R02%3bDYNP_OKCODE%3donli&%7enosplash=1&sap-client=100&sap-language=EN#");

                break;

            //Open Data Collation page on OGQ/100
            case "OGQ_100":*/

        //  driver.navigate().to("https://ldciofq.wdf.sap.corp:44300/sap/bc/gui/sap/its/webgui;~sysid=OGQ;~service=3200?%7etransaction=*APB_LPD_CALL_TRANS%20P_ROLE%3dPAT%3bP_APPL%3dPAT_FRW%3bP_TCODE%3d%2fPAT%2fUI_MIGO_CALL%3bP_SELSCR%3d%3bP_PNP%3d%3bP_ENCMTH%3d%3bP_OBJECT%3dGOACTION%2521A04%2525MBLNR%"+num_GoodsMovementDocNum_1+"%2525MJAHR%25212020%2525OKCODE%2521MIGO_OK_GO%2525REFDOC%2521R02%3bDYNP_OKCODE%3donli&%7enosplash=1&sap-client=100&sap-language=EN#");

        WebElement third_RowInFlowPanelPanel = driver.findElement(By.ByXPath.xpath(String.format(landingPage.allHyperlinks_GoodsMovementRow_OFQ, 3)));

        //click to expand the lower level rows in "Document Flow" table
        third_RowInFlowPanelPanel.click();
        // action.moveToElement(tab_Start).click().build().perform();
        //js.executeScript("arguments[0].click();", second_RowInFlowPanelPanel);
        // Thread.sleep(2000);

          /*      break;
            default:
        }*/

        //ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        //driver.switchTo().window(tabs.get(2));
        // driver.close();
        // driver.switchTo().window(tabs.get(2));
      /* ArrayList tabs = new ArrayList (driver.getWindowHandles());
        System.out.println(tabs.size());
        driver.switchTo().window((String) tabs.get(2));

        String current_Handle = driver.getWindowHandle();
       //driver.switchTo().window(driver..window_handles[1]);*/


        // Then wait for a new window/tab open:
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(driver -> !driver.getWindowHandles().equals(windowHandlersSet));


        //getting all the handles currently available
        Set<String> handles = driver.getWindowHandles();
        System.out.println("Number of currently opened Web-Browser tabs: " + handles.size());

        for (String actual : handles) {
            System.out.println("Name of currently opened Tab: " + actual);
            if (!actual.equalsIgnoreCase(currentHandle)) {
                driver.switchTo().window(actual);
            }
        }


        waitTillElementDetected(3, pageMaterialDoc.page_DisplayMaterialDoc_OFQ, "FIRST 'MATERIAL DOCUMENT' PAGE");
        Thread.sleep(1000);

        try {

            WebElement pageTitle = driver.findElement(By.xpath(landingPage.page_DisplayMaterialDocument_OFQ));
            FirstMaterialDocPage = true;

        } catch (NoSuchElementException e) {
            FirstMaterialDocPage = false;
            System.out.println("Expected 'MATERIAL DOCUMENT' PAGE was not found!");
            logger.warn("Expected 'MATERIAL DOCUMENT' PAGE was not found!");

        }

        try {

            if (FirstMaterialDocPage == true) {

                MaterialDocumentNumber2 = pageMaterialDoc.retrieve_MaterialDocumentNumber();


                Actions actions = new Actions(driver);

                // Scroll Down using Actions class
                // actions.keyDown(Keys.CONTROL).sendKeys(Keys.PAGE_DOWN).perform();

                actions.sendKeys(Keys.PAGE_DOWN).build().perform();
                actions.sendKeys(Keys.PAGE_DOWN).build().perform();

                //  JavascriptExecutor js2 = (JavascriptExecutor) driver;
                //scroll to bring 'Display Items' table into view
                // js2.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//form[contains (@name, 'webguiform0')]/descendant::table[contains (@ct, 'STCS')][contains (@shscrollcontentid, '-mrss-hdr-none-content')]/tbody[contains (@id, '-content')]")));
                // js2.executeScript("window.scrollBy(0,document.body.scrollHeight)");


                Thread.sleep(1000);
            } else {
                System.out.println("Incorrect Document Page was opened!");
                logger.warn("Incorrect Document Page was opened!");
            }


        } catch (Exception e) {
            System.out.println("Unable to retrieve the number of the 1st material document on the 'MATERIAL DOCUMENT' PAGE: " + e.getMessage());
            logger.warn("Unable to retrieve the number of the 1st material document on the 'MATERIAL DOCUMENT' PAGE: " + e.getMessage());
        }
    }


    @Test(dependsOnMethods = {"displayFirstMaterialDocumentPage_Testing"})
    @Parameters({"target_System_Client"})
    public void retrieve_AddItemDataForMaterialDocument1_Testing() throws Exception {

        MaterialDocPage pageMaterialDoc = new MaterialDocPage(driver); //Instantiating object of "MaterialDocPage" class


        if (FirstMaterialDocPage == true) {

            //Declare an array and set ist size the same as the number of global variables
            String [] vallues_Array = new String [7];

            //read all fields in the "All Items" table
            vallues_Array = pageMaterialDoc.read_AllItemsTableFields_RightPart_1();

            Thread.sleep(2000);

            Material2 = vallues_Array[0];
            System.out.println("The value of String 'Material_Gain = '"+ Material2);

            Quantity2 = vallues_Array[1];
            System.out.println("The value of String 'Quantity_Gain = '"+ Quantity2);

            BaseUnitOfMeasure2 = vallues_Array[2];
            System.out.println("The value of String 'BaseUnitOfMeasure_Gain = '"+ BaseUnitOfMeasure2);

            Plant2 = vallues_Array[3];
            System.out.println("The value of String 'Plant_Gain = '"+ Plant2);

            StorageLocation2 = vallues_Array[4];
            System.out.println("The value of String 'StorageLocation_Gain2 = '"+ StorageLocation2);

            ValuationType2 = vallues_Array[5];
            System.out.println("The value of String 'ValuationType_Gain = '"+ ValuationType2);

            HandlingType2 = vallues_Array[6];
            System.out.println("The value of String 'HandlingType_Gain = '"+ HandlingType2);

        } else {
            System.out.println("Skipping execution of test 'retrieve_AddItemDataForMaterialDocument1_Testing' as incorrect Document Page was opened.");
            logger.warn("Skipping execution of test 'retrieve_AddItemDataForMaterialDocument1_Testing' as incorrect Document Page was opened.");
            throw new SkipException("Skipping execution of test 'retrieve_AddItemDataForMaterialDocument1_Testing' as incorrect Document Page was opened.");
        }

    }


    @Test(dependsOnMethods = {"retrieve_AddItemDataForMaterialDocument1_Testing"})
    public void close_currentAddItemDataForMaterialDocumentTab_Testing() throws Exception {

        MaterialDocPage pageMaterialDoc = new MaterialDocPage(driver); //Instantiating object of "MaterialDocPage" class


        String currentHandle = driver.getWindowHandle();
        System.out.println("Current Handle TAB: " + currentHandle);

        Set<String> handlesSet = driver.getWindowHandles();
        List<String> handlesList = new ArrayList<String>(handlesSet);

        for (String actual : handlesList) {
            System.out.println("Name of currently opened Tab: " + actual);
            if (actual.equalsIgnoreCase(currentHandle)) {
                driver.close();
                driver.switchTo().window(handlesList.get(0));
                // driver.switchTo().window(actual);
            }
        }

       /* driver.switchTo().window(handlesList.get(1));
        driver.close();
        driver.switchTo().window(handlesList.get(0));*/

      /*  String currentHandle2 = driver.getWindowHandle();
        System.out.println("Current Handle TAB (after closing the previous tab): " + currentHandle2);

        //getting all the handles currently available
        Set<String> handles = driver.getWindowHandles();
        System.out.println("Number of currently opened Web-Browser tabs: " + handles.size());

        for (String actual:handles){
            System.out.println("Name of currently opened Tab: " +actual);
            if (actual.equalsIgnoreCase(currentHandle2)){
                driver.switchTo().window(actual);
            }
        }*/

        Thread.sleep(2000);

    }


    @Test(dependsOnMethods = {"close_currentAddItemDataForMaterialDocumentTab_Testing"})
    @Parameters({"target_System_Client"})
    public void displaySecondMaterialDocumentPage_Testing(String target_System_Client) throws Exception {

        MaterialDocPage pageMaterialDoc = new MaterialDocPage(driver); //Instantiating object of "MaterialDocPage" class
        LandingPage landingPage = new LandingPage(driver); //Instantiating object of "LandingPage" class

        conf_SystemClient = target_System_Client;
        System.out.println("Current System: " + conf_SystemClient);

        String currentHandle = driver.getWindowHandle();
        System.out.println("Current Handle TAB: " + currentHandle);

        //First you have to save current handles of all opened windows:
        Set<String> windowHandlersSet = driver.getWindowHandles();

        //Select correct URL for a particular System/Client
      /*  switch (target_System_Client) {

            //Open "Display Material Document" page on OFQ/100
            case "OFQ_100":

                // driver.navigate().to("https://ldciofq.wdf.sap.corp:44300/sap/bc/gui/sap/its/webgui;~sysid=OFQ;~service=3200?%7etransaction=*APB_LPD_CALL_TRANS%20P_ROLE%3dPAT%3bP_APPL%3dPAT_FRW%3bP_TCODE%3d%2fPAT%2fUI_MIGO_CALL%3bP_SELSCR%3d%3bP_PNP%3d%3bP_ENCMTH%3d%3bP_OBJECT%3dGOACTION%2521A04%2525MBLNR%"+num_GoodsMovementDocNum_1+"%2525MJAHR%25212020%2525OKCODE%2521MIGO_OK_GO%2525REFDOC%2521R02%3bDYNP_OKCODE%3donli&%7enosplash=1&sap-client=100&sap-language=EN#");

                break;

            //Open Data Collation page on OGQ/100
            case "OGQ_100":*/

        //  driver.navigate().to("https://ldciofq.wdf.sap.corp:44300/sap/bc/gui/sap/its/webgui;~sysid=OGQ;~service=3200?%7etransaction=*APB_LPD_CALL_TRANS%20P_ROLE%3dPAT%3bP_APPL%3dPAT_FRW%3bP_TCODE%3d%2fPAT%2fUI_MIGO_CALL%3bP_SELSCR%3d%3bP_PNP%3d%3bP_ENCMTH%3d%3bP_OBJECT%3dGOACTION%2521A04%2525MBLNR%"+num_GoodsMovementDocNum_1+"%2525MJAHR%25212020%2525OKCODE%2521MIGO_OK_GO%2525REFDOC%2521R02%3bDYNP_OKCODE%3donli&%7enosplash=1&sap-client=100&sap-language=EN#");

        WebElement fourth_RowInFlowPanelPanel = driver.findElement(By.ByXPath.xpath(String.format(landingPage.allHyperlinks_GoodsMovementRow_OFQ, 4)));

        //click to expand the lower level rows in "Document Flow" table
        fourth_RowInFlowPanelPanel.click();
        // action.moveToElement(tab_Start).click().build().perform();
        //js.executeScript("arguments[0].click();", second_RowInFlowPanelPanel);
        // Thread.sleep(2000);

         /*       break;
            default:
        }*/

        //ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        //driver.switchTo().window(tabs.get(2));
        // driver.close();
        // driver.switchTo().window(tabs.get(2));
      /* ArrayList tabs = new ArrayList (driver.getWindowHandles());
        System.out.println(tabs.size());
        driver.switchTo().window((String) tabs.get(2));

        String current_Handle = driver.getWindowHandle();
       //driver.switchTo().window(driver..window_handles[1]);*/


        // Then wait for a new window/tab open:
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(driver -> !driver.getWindowHandles().equals(windowHandlersSet));


        //getting all the handles currently available
        Set<String> handles = driver.getWindowHandles();
        System.out.println("Number of currently opened Web-Browser tabs: " + handles.size());

        for (String actual : handles) {
            System.out.println("Name of currently opened Tab: " + actual);
            if (!actual.equalsIgnoreCase(currentHandle)) {
                driver.switchTo().window(actual);
            }
        }

        waitTillElementDetected(3, pageMaterialDoc.page_DisplayMaterialDoc_OFQ,  "SECOND 'MATERIAL DOCUMENT' PAGE");
        Thread.sleep(1000);

        try {

            WebElement pageTitle = driver.findElement(By.xpath(landingPage.page_DisplayMaterialDocument_OFQ));
            SecondMaterialDocPage = true;

        } catch (NoSuchElementException e) {
            SecondMaterialDocPage = false;
            System.out.println("Expected 'MATERIAL DOCUMENT' PAGE was not found!");
            logger.warn("Expected 'MATERIAL DOCUMENT' PAGE was not found!");
        }

        try {

            if (SecondMaterialDocPage == true) {

                MaterialDocumentNumber3 = pageMaterialDoc.retrieve_MaterialDocumentNumber();

                Actions actions = new Actions(driver);

                // Scroll Down using Actions class
                // actions.keyDown(Keys.CONTROL).sendKeys(Keys.PAGE_DOWN).perform();

                actions.sendKeys(Keys.PAGE_DOWN).build().perform();
                actions.sendKeys(Keys.PAGE_DOWN).build().perform();

                //  JavascriptExecutor js2 = (JavascriptExecutor) driver;
                //scroll to bring 'Display Items' table into view
                // js2.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//form[contains (@name, 'webguiform0')]/descendant::table[contains (@ct, 'STCS')][contains (@shscrollcontentid, '-mrss-hdr-none-content')]/tbody[contains (@id, '-content')]")));
                // js2.executeScript("window.scrollBy(0,document.body.scrollHeight)");

                Thread.sleep(1000);
            } else {
                System.out.println("Incorrect Document Page was opened!");
                logger.warn("Incorrect Document Page was opened!");
            }

        } catch (Exception e) {
            System.out.println("Unable to retrieve the number of the 2nd material document on the 'MATERIAL DOCUMENT' PAGE: " + e.getMessage());
            logger.warn("Unable to retrieve the number of the 2nd material document on the 'MATERIAL DOCUMENT' PAGE: " + e.getMessage());
        }
    }

    @Test(dependsOnMethods = {"displaySecondMaterialDocumentPage_Testing"})
    public void retrieve_AddItemDataForMaterialDocument2_Testing() throws Exception {

        MaterialDocPage pageMaterialDoc = new MaterialDocPage(driver); //Instantiating object of "MaterialDocPage" class

        if (SecondMaterialDocPage == true) {

            //Declare an array and set ist size the same as the number of global variables
            String [] vallues_Array = new String [7];

            //read all fields in the "All Items" table
            vallues_Array = pageMaterialDoc.read_AllItemsTableFields_RightPart_2();

            Thread.sleep(2000);

            Material3 = vallues_Array[0];
            System.out.println("The value of String 'Material_Gain = '"+ Material3);

            Quantity3 = vallues_Array[1];
            System.out.println("The value of String 'Quantity_Gain = '"+ Quantity3);

            BaseUnitOfMeasure3 = vallues_Array[2];
            System.out.println("The value of String 'BaseUnitOfMeasure_Gain = '"+ BaseUnitOfMeasure3);

            Plant3 = vallues_Array[3];
            System.out.println("The value of String 'Plant_Gain = '"+ Plant3);

            StorageLocation3 = vallues_Array[4];
            System.out.println("The value of String 'StorageLocation_Gain2 = '"+ StorageLocation3);

            ValuationType3 = vallues_Array[5];
            System.out.println("The value of String 'ValuationType_Gain = '"+ ValuationType3);

            HandlingType3 = vallues_Array[6];
            System.out.println("The value of String 'HandlingType_Gain = '"+ HandlingType3);

        } else {
            System.out.println("Skipping execution of test 'retrieve_AddItemDataForMaterialDocument2_Testing' as incorrect Document Page was opened.");
            logger.warn("Skipping execution of test 'retrieve_AddItemDataForMaterialDocument2_Testing' as incorrect Document Page was opened.");
            throw new SkipException("Skipping execution of test 'retrieve_AddItemDataForMaterialDocument2_Testing' as incorrect Document Page was opened.");
        }


    }

    @Test(dependsOnMethods = {"retrieve_AddItemDataForMaterialDocument2_Testing"})
    @Parameters({"cell_Material_2", "cell_Qty_2", "cell_Plant_2", "cell_StorgLocatn_2", "cell_ValtnType_2", "cell_HandlingType_2", "auto_cell_BaseUnitOfMeasure_2"})
    public void comparing_AddItemDetails_Testing(String cell_Material_2, String cell_Qty_2, String cell_Plant_2, String cell_StorgLocatn_2,
                                                 String cell_ValtnType_2, String cell_HandlingType_2,
                                                 String auto_cell_BaseUnitOfMeasure_2) throws Exception {

        MaterialDocPage pageMaterialDoc = new MaterialDocPage(driver); //Instantiating object of "MaterialDocPage" class


        if (FirstMaterialDocPage == true) {
            pageMaterialDoc.compare_AllItemsDetails(num_GoodsMovementDocNum_1, MaterialDocumentNumber2, cell_Material_2, cell_Qty_2, cell_Plant_2, cell_StorgLocatn_2, cell_ValtnType_2, cell_HandlingType_2, auto_cell_BaseUnitOfMeasure_2, Material2, Quantity2, Plant2, StorageLocation2, ValuationType2, HandlingType2, BaseUnitOfMeasure2);
            Thread.sleep(2000);
        } else {
            System.out.println("Skipping document #1 comparison as incorrect Document Page was opened.");
            logger.warn("Skipping document #1 comparison as incorrect Document Page was opened.");
        }

        if (SecondMaterialDocPage == true) {
            pageMaterialDoc.compare_AllItemsDetails(num_GoodsMovementDocNum_2, MaterialDocumentNumber3, cell_Material_2, cell_Qty_2, cell_Plant_2, cell_StorgLocatn_2, cell_ValtnType_2, cell_HandlingType_2, auto_cell_BaseUnitOfMeasure_2, Material3, Quantity3, Plant3, StorageLocation3, ValuationType3, HandlingType3, BaseUnitOfMeasure3);
            Thread.sleep(2000);
        } else {
            System.out.println("Skipping document #2 comparison as incorrect Document Page was opened.");
            logger.warn("Skipping document #2 comparison as incorrect Document Page was opened.");
        }

        Integer docNum = Integer.valueOf(doc_NumReversed);

        //deminish reversed Doc number by 1 to set it to the 1st doc number
        doc_Num = Integer.toString(docNum - 1);
        System.out.println("DocNUM of the 1st document: "+doc_Num);

        //assign reversed doc number to
        doc_Num2 = doc_NumReversed;
        System.out.println("DocNUM of the 2nd document: "+doc_Num2);

        //re-set doc_NumReversed variable to empty
        doc_NumReversed="";
        System.out.println("ReSet Reversed DocNUM: "+doc_NumReversed);

    }




    @AfterTest
    @Parameters({"target_System"})
    public void insertLinksIntoLogFile(String target_System) {

        FileProcessing fileProcessing = new FileProcessing(); //Instantiating object of "FileProcessing" class


        //create a separate log file for every Item Category
        try {
            fileProcessing.renameLogHTMLfile("XLO_XUO");
        } catch (IOException e) {
            logger.error("Unable to run the 'fileProcessing.renameLogHTMLfile(itemType)' method: " + e.getMessage());
        }

        //inserting "DATA COLLATION" empty page screenshot link into "log4j-application.html" file
        try {


            //first check if the file was created and saved in the directory
            if (checkFileExists(".\\src\\main\\resources\\current_images\\Data_Collation_Page_Empty_FullSize.png")) {
                String tdLineBeforeChange = "EMPTY DATA COLLATION PAGE window screenshot was made.";
                String baselineScreen = "<a href=" + Paths.get(".\\src\\main\\resources\\current_images\\Data_Collation_Page_Empty_FullSize.png").toRealPath().toUri().toURL() + ">LOS_UOS_EMPTY_DATA_COLLATION_PAGE</a>";
                String endText = "window screenshot was made.";

                //inserting "DATA COLLATION" empty page screenshot links into "log4j-application.html" file
                insertingScreenshotLinksIntoLoggerHTMLfile("XLO_XUO", tdLineBeforeChange, baselineScreen, endText);

                //logger.info("URL Link for Empty DATA COLLATION page was successfully added to the 'log4j-application.html' file");
            }

        } catch (IOException e) {
            logger.error("Unable to run the 'insertingScreenshotLinksIntoLoggerHTMLfile' method for Empty DATA COLLATION page: " + e.getMessage());
        }


        //inserting "DOCUMENT FLOW SECTION COMPLETED" page screenshot link into "log4j-application.html" file
        try {


            //first check if the file was created and saved in the directory
            if (checkFileExists(".\\src\\main\\resources\\current_images\\DocumentFlow_Section_Completed_FullSize.png")) {
                String tdLineBeforeChange = "DOCUMENT FLOW SECTION COMPLETED window screenshot was made.";
                String baselineScreen = "<a href=" + Paths.get(".\\src\\main\\resources\\current_images\\DocumentFlow_Section_Completed_FullSize.png").toRealPath().toUri().toURL() + ">"+itemType3.toUpperCase() + "_DOCUMENT FLOW SECTION COMPLETED</a>";
                String endText = "window screenshot was made.";

                //inserting "DATA COLLATION" empty page screenshot links into "log4j-application.html" file
                insertingScreenshotLinksIntoLoggerHTMLfile("XLO_XUO", tdLineBeforeChange, baselineScreen, endText);

                //logger.info("URL Link for Empty DATA COLLATION page was successfully added to the 'log4j-application.html' file");
            }

        } catch (IOException e) {
            logger.error("Unable to run the 'insertingScreenshotLinksIntoLoggerHTMLfile' method for Empty DATA COLLATION page: " + e.getMessage());
        }


        //inserting "DATA COLLATION with ERROR(s)" empty page screenshot link into "log4j-application.html" file
        try {

            //first check if the file was created and saved in the directory
            if (checkFileExists(".\\src\\main\\resources\\error_images\\Data_Collation_Page_Empty_FullSize_Error.png")) {
                String tdLineBeforeChange = "One or more records detected in the 'ADD ITEM' table. However it is expected to be empty.";
                String baselineScreen = "<a href=" + Paths.get(".\\src\\main\\resources\\error_images\\Data_Collation_Page_Empty_FullSize_Error.png").toRealPath().toUri().toURL() + ">LOS_UOS_One_or_more_records_detected_in_the_'ADD_ITEM'_table.</a>";
                String endText = "However it is expected to be empty.";

                //inserting "DATA COLLATION" empty page screenshot links into "log4j-application.html" file
                insertingScreenshotLinksIntoLoggerHTMLfile("XLO_XUO", tdLineBeforeChange, baselineScreen, endText);
            }

            //logger.info("URL Link for Empty DATA COLLATION page WITH ERROR was successfully added to the 'log4j-application.html' file");

        } catch (IOException e) {
            logger.error("Unable to run the 'insertingScreenshotLinksIntoLoggerHTMLfile' method for Empty DATA COLLATION page with ERROR: " + e.getMessage());
        }

        //inserting "Button 'NEW' is disabled or not found!" screenshot link into "log4j-application.html" file
        try {

            //first check if the file was created and saved in the directory
            if (checkFileExists(".\\src\\main\\resources\\error_images\\New_Btn_Disabled_NotFound_Error.png")) {
                String tdLineBeforeChange = "Button 'NEW' is in DISABLED status.";
                String baselineScreen = "<a href=" + Paths.get(".\\src\\main\\resources\\error_images\\New_Btn_Disabled_NotFound_Error.png").toRealPath().toUri().toURL() + ">LOS_UOS_Button_'NEW'</a>";
                String endText = "is in DISABLED status.";

                //inserting "DATA COLLATION" empty page screenshot links into "log4j-application.html" file
                insertingScreenshotLinksIntoLoggerHTMLfile("XLO_XUO", tdLineBeforeChange, baselineScreen, endText);
            }

            //logger.info("URL Link for Empty DATA COLLATION page WITH ERROR was successfully added to the 'log4j-application.html' file");

        } catch (IOException e) {
            logger.error("Unable to run the 'insertingScreenshotLinksIntoLoggerHTMLfile' method for 'NEW' button is disabled or not found ERROR: " + e.getMessage());
        }


        //inserting "Button 'ADD ITEM' is disabled or not found!" screenshot link into "log4j-application.html" file
        try {

            //first check if the file was created and saved in the directory
            if (checkFileExists(".\\src\\main\\resources\\error_images\\AddItem_Btn_Disabled_NotFound_Error.png")) {
                String tdLineBeforeChange = "Button 'ADD ITEM' is in DISABLED status.";
                String baselineScreen = "<a href=" + Paths.get(".\\src\\main\\resources\\error_images\\AddItem_Btn_Disabled_NotFound_Error.png").toRealPath().toUri().toURL() + ">LOS_UOS_Button_'ADD_ITEM'</a>";
                String endText = "is in DISABLED status.";

                //inserting "DATA COLLATION" empty page screenshot links into "log4j-application.html" file
                insertingScreenshotLinksIntoLoggerHTMLfile("XLO_XUO", tdLineBeforeChange, baselineScreen, endText);
            }

            //logger.info("URL Link for Empty DATA COLLATION page WITH ERROR was successfully added to the 'log4j-application.html' file");

        } catch (IOException e) {
            logger.error("Unable to run the 'insertingScreenshotLinksIntoLoggerHTMLfile' method for 'ADD ITEM' button is disabled or not found ERROR: " + e.getMessage());
        }


        //inserting "Button 'CHECK' is disabled or not found!" screenshot link into "log4j-application.html" file
        try {

            //first check if the file was created and saved in the directory
            if (checkFileExists(".\\src\\main\\resources\\error_images\\Check_Btn_Disabled_NotFound_Error.png")) {
                String tdLineBeforeChange = "Button 'CHECK' is in DISABLED status.";
                String baselineScreen = "<a href=" + Paths.get(".\\src\\main\\resources\\error_images\\Check_Btn_Disabled_NotFound_Error.png").toRealPath().toUri().toURL() + ">LOS_UOS_Button_'CHECK'</a>";
                String endText = "is in DISABLED status.";

                //inserting "DATA COLLATION" empty page screenshot links into "log4j-application.html" file
                insertingScreenshotLinksIntoLoggerHTMLfile("XLO_XUO", tdLineBeforeChange, baselineScreen, endText);
            }

            //logger.info("URL Link for Empty DATA COLLATION page WITH ERROR was successfully added to the 'log4j-application.html' file");

        } catch (IOException e) {
            logger.error("Unable to run the 'insertingScreenshotLinksIntoLoggerHTMLfile' method for 'CHECK' button is disabled or not found ERROR: " + e.getMessage());
        }

        //inserting "Button 'RELEASE' is disabled or not found!" screenshot link into "log4j-application.html" file
        try {

            //first check if the file was created and saved in the directory
            if (checkFileExists(".\\src\\main\\resources\\error_images\\Release_Btn_Disabled_NotFound_Error.png")) {
                String tdLineBeforeChange = "Button 'RELEASE' is in DISABLED status.";
                String baselineScreen = "<a href=" + Paths.get(".\\src\\main\\resources\\error_images\\Release_Btn_Disabled_NotFound_Error.png").toRealPath().toUri().toURL() + ">LOS_UOS_Button_'RELEASE'</a>";
                String endText = "is in DISABLED status.";

                //inserting "RELEASE" button screenshot links into "log4j-application.html" file
                insertingScreenshotLinksIntoLoggerHTMLfile("XLO_XUO", tdLineBeforeChange, baselineScreen, endText);
            }
            //logger.info("URL Link for Empty DATA COLLATION page WITH ERROR was successfully added to the 'log4j-application.html' file");

        } catch (IOException e) {
            logger.error("Unable to run the 'insertingScreenshotLinksIntoLoggerHTMLfile' method for 'RELEASE' button is disabled or not found ERROR: " + e.getMessage());
        }


        //inserting "Button 'SAVE' is disabled or not found!" screenshot link into "log4j-application.html" file
        try {

            //first check if the file was created and saved in the directory
            if (checkFileExists(".\\src\\main\\resources\\error_images\\Save_Btn_Disabled_NotFound_Error.png")) {
                String tdLineBeforeChange = "Button 'SAVE' is in DISABLED status.";
                String baselineScreen = "<a href=" + Paths.get(".\\src\\main\\resources\\error_images\\Save_Btn_Disabled_NotFound_Error.png").toRealPath().toUri().toURL() + ">LOS_UOS_Button_'SAVE'</a>";
                String endText = "is in DISABLED status.";

                //inserting "SAVE" button screenshot links into "log4j-application.html" file
                insertingScreenshotLinksIntoLoggerHTMLfile("XLO_XUO", tdLineBeforeChange, baselineScreen, endText);
            }
            //logger.info("URL Link for Empty DATA COLLATION page WITH ERROR was successfully added to the 'log4j-application.html' file");

        } catch (IOException e) {
            logger.error("Unable to run the 'insertingScreenshotLinksIntoLoggerHTMLfile' method for 'SAVE' button is disabled or not found ERROR: " + e.getMessage());
        }


        //inserting "Button 'PROCESS' is disabled or not found!" screenshot link into "log4j-application.html" file
        try {

            //first check if the file was created and saved in the directory
            if (checkFileExists(".\\src\\main\\resources\\error_images\\Process_Btn_Disabled_NotFound_Error.png")) {
                String tdLineBeforeChange = "Button 'PROCESS' is in DISABLED status.";
                String baselineScreen = "<a href=" + Paths.get(".\\src\\main\\resources\\error_images\\Process_Btn_Disabled_NotFound_Error.png").toRealPath().toUri().toURL() + ">LOS_UOS_Button_'PROCESS'</a>";
                String endText = "is in DISABLED status.";

                //inserting "SAVE" button screenshot links into "log4j-application.html" file
                insertingScreenshotLinksIntoLoggerHTMLfile("XLO_XUO", tdLineBeforeChange, baselineScreen, endText);
            }
            //logger.info("URL Link for Empty DATA COLLATION page WITH ERROR was successfully added to the 'log4j-application.html' file");

        } catch (IOException e) {
            logger.error("Unable to run the 'insertingScreenshotLinksIntoLoggerHTMLfile' method for 'PROCESS' button is disabled or not found ERROR: " + e.getMessage());
        }


        //inserting "Button 'REVERSE' is disabled or not found!" screenshot link into "log4j-application.html" file
        try {

            //first check if the file was created and saved in the directory
            if (checkFileExists(".\\src\\main\\resources\\error_images\\" + itemType3.toUpperCase() + "-Reverse_Btn_Disabled_NotFound_Error.png")) {
                String tdLineBeforeChange = "Button 'REVERSE' is in DISABLED status.";
                String baselineScreen = "<a href=" + Paths.get(".\\src\\main\\resources\\error_images\\" + itemType3.toUpperCase() + "-Reverse_Btn_Disabled_NotFound_Error.png").toRealPath().toUri().toURL() + ">" + itemType3.toUpperCase() + "_Button_'REVERSE'</a>";
                String endText = "is in DISABLED status.";

                //inserting "SAVE" button screenshot links into "log4j-application.html" file
                insertingScreenshotLinksIntoLoggerHTMLfile("XLO_XUO", tdLineBeforeChange, baselineScreen, endText);
            }
            //logger.info("URL Link for Empty DATA COLLATION page WITH ERROR was successfully added to the 'log4j-application.html' file");

        } catch (IOException e) {
            logger.error("Unable to run the 'insertingScreenshotLinksIntoLoggerHTMLfile' method for 'REVERSE' button is disabled or not found ERROR: " + e.getMessage());
        }


        //inserting "DATA COLLATION" completed page screenshot link into "log4j-application.html" file
        try {

            //first check if the file was created and saved in the directory
            if (checkFileExists(".\\src\\main\\resources\\current_images\\Data_Collation_Page_Completed_FullSize.png")) {
                String tdLineBeforeChange = "COMPLETED DATA COLLATION PAGE window screenshot was made.";
                String baselineScreen = "<a href=" + Paths.get(".\\src\\main\\resources\\current_images\\Data_Collation_Page_Completed_FullSize.png").toRealPath().toUri().toURL() + ">LOS_UOS_COMPLETED-DATA-COLLATION-PAGE</a>";
                String endText = "window screenshot was made.";

                //inserting "DATA COLLATION" completed page screenshot links into "log4j-application.html" file
                insertingScreenshotLinksIntoLoggerHTMLfile("XLO_XUO", tdLineBeforeChange, baselineScreen, endText);

                //logger.info("URL Link for Empty DATA COLLATION page was successfully added to the 'log4j-application.html' file");
            }

        } catch (IOException e) {
            logger.error("Unable to run the 'insertingScreenshotLinksIntoLoggerHTMLfile' method for Completed DATA COLLATION page: " + e.getMessage());
        }


        //inserting "DATA COLLATION" postprocessing completed page screenshot link into "log4j-application.html" file
        try {

            //first check if the file was created and saved in the directory
            if (checkFileExists(".\\src\\main\\resources\\current_images\\LOS_UOS-Data_Collation_Page_PostProcessing_Completed_FullSize.png")) {
                String tdLineBeforeChange = "COMPLETED POSTPROCESSING DATA COLLATION PAGE window screenshot was made.";
                String baselineScreen = "<a href=" + Paths.get(".\\src\\main\\resources\\current_images\\LOS_UOS-Data_Collation_Page_PostProcessing_Completed_FullSize.png").toRealPath().toUri().toURL() + ">" + itemType.toUpperCase() + "_COMPLETED-POSTPROCESSING-DATA-COLLATION-PAGE</a>";
                String endText = "window screenshot was made.";

                //inserting "DATA COLLATION" completed page screenshot links into "log4j-application.html" file
                insertingScreenshotLinksIntoLoggerHTMLfile("XLO_XUO", tdLineBeforeChange, baselineScreen, endText);

                //logger.info("URL Link for Empty DATA COLLATION page was successfully added to the 'log4j-application.html' file");
            }

        } catch (IOException e) {
            logger.error("Unable to run the 'insertingScreenshotLinksIntoLoggerHTMLfile' method for Completed Postprocessing DATA COLLATION page: " + e.getMessage());
        }

        //inserting "REVERSED DOCUMENT PAGE" completed page screenshot link into "log4j-application.html" file
        try {

            //first check if the file was created and saved in the directory
            if (checkFileExists(".\\src\\main\\resources\\current_images\\" + itemType3.toUpperCase() + "-Reversed_Document_Page_Completed_FullSize.png")) {
                String tdLineBeforeChange = "REVERSED DOCUMENT PAGE window screenshot was made.";
                String baselineScreen = "<a href=" + Paths.get(".\\src\\main\\resources\\current_images\\" + itemType3.toUpperCase() + "-Reversed_Document_Page_Completed_FullSize.png").toRealPath().toUri().toURL() + ">" + itemType3.toUpperCase()+"_REVERSED_DOCUMENT_PAGE</a>";
                String endText = "window screenshot was made.";

                //inserting "REVERSED DOCUMENT PAGE" completed page screenshot links into "log4j-application.html" file
                insertingScreenshotLinksIntoLoggerHTMLfile("XLO_XUO", tdLineBeforeChange, baselineScreen, endText);

                //logger.info("URL Link for Empty DATA COLLATION page was successfully added to the 'log4j-application.html' file");
            }

        } catch (IOException e) {
            logger.error("Unable to run the 'insertingScreenshotLinksIntoLoggerHTMLfile' method for REVERSED DOCUMENT page: " + e.getMessage());
        }


        //inserting "PROCESSED REVERSED DOCUMENT PAGE" completed page screenshot link into "log4j-application.html" file
        try {

            //first check if the file was created and saved in the directory
            if (checkFileExists(".\\src\\main\\resources\\current_images\\" + itemType3.toUpperCase() + "-ReProcessed_Document_Page_FullSize.png")) {
                String tdLineBeforeChange = "REPROCESSED DOCUMENT PAGE window screenshot was made.";
                String baselineScreen = "<a href=" + Paths.get(".\\src\\main\\resources\\current_images\\" + itemType3.toUpperCase() + "-ReProcessed_Document_Page_FullSize.png").toRealPath().toUri().toURL() + ">" + itemType3.toUpperCase() + "_REPROCESSED_DOCUMENT_PAGE</a>";
                String endText = "window screenshot was made.";

                //inserting "REVERSED DOCUMENT PAGE" completed page screenshot links into "log4j-application.html" file
                insertingScreenshotLinksIntoLoggerHTMLfile("XLO_XUO", tdLineBeforeChange, baselineScreen, endText);

                //logger.info("URL Link for Empty DATA COLLATION page was successfully added to the 'log4j-application.html' file");
            }

        } catch (IOException e) {
            logger.error("Unable to run the 'insertingScreenshotLinksIntoLoggerHTMLfile' method for REPROCESSED DOCUMENT PAGE page: " + e.getMessage());
        }


        //inserting "Button 'LOCATOR' is disabled or not found!" screenshot link into "log4j-application.html" file
        try {

            //first check if the file was created and saved in the directory
            if (checkFileExists(".\\src\\main\\resources\\error_images\\Locator_Btn_Disabled_NotFound_Error.png")) {
                String tdLineBeforeChange = "Button 'LOCATOR' is in DISABLED status.";
                String baselineScreen = "<a href=" + Paths.get(".\\src\\main\\resources\\error_images\\Locator_Btn_Disabled_NotFound_Error.png").toRealPath().toUri().toURL() + ">LOS_UOS_Button_'LOCATOR'</a>";
                String endText = "is in DISABLED status.";

                //inserting "SAVE" button screenshot links into "log4j-application.html" file
                insertingScreenshotLinksIntoLoggerHTMLfile("XLO_XUO", tdLineBeforeChange, baselineScreen, endText);
            }
            //logger.info("URL Link for Empty DATA COLLATION page WITH ERROR was successfully added to the 'log4j-application.html' file");

        } catch (IOException e) {
            logger.error("Unable to run the 'insertingScreenshotLinksIntoLoggerHTMLfile' method for 'LOCATOR' button is disabled or not found ERROR: " + e.getMessage());
        }


        //inserting "LOCATOR" screenshot link into "log4j-application.html" file
        try {

            //first check if the file was created and saved in the directory
            if (checkFileExists(".\\src\\main\\resources\\current_images\\Locator_Panel_DocStatus.png")) {
                String tdLineBeforeChange = "LOCATOR PANEL WITH DOCUMENT STATUS window screenshot was made.";
                String baselineScreen = "<a href=" + Paths.get(".\\src\\main\\resources\\current_images\\Locator_Panel_DocStatus.png").toRealPath().toUri().toURL() + ">LOS_UOS_LOCATOR PANEL WITH DOCUMENT STATUS'</a>";
                String endText = "window screenshot was made.";

                //inserting "SAVE" button screenshot links into "log4j-application.html" file
                insertingScreenshotLinksIntoLoggerHTMLfile("XLO_XUO", tdLineBeforeChange, baselineScreen, endText);
            }
            //logger.info("URL Link for Empty DATA COLLATION page WITH ERROR was successfully added to the 'log4j-application.html' file");

        } catch (IOException e) {
            logger.error("Unable to run the 'insertingScreenshotLinksIntoLoggerHTMLfile' method for LOCATOR PANEL WITH DOCUMENT STATUS page: " + e.getMessage());
        }





        //adding test name and document number into a an external text file
        addDocumentNumsToTXT_file(target_System, "PAT_DC_VH-LOS_UOS_Reversing-XLO_XUO_OFQ_100", doc_Num, doc_Num2, doc_NumReversed);

    }


}

