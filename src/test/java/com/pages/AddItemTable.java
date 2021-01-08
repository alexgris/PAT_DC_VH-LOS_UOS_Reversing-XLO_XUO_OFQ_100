package com.pages;


import init.settings.PageObject;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.project.Test_Cases;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;


import java.util.List;

import static ax.generic.Waitings.*;


public class AddItemTable extends PageObject {

    public Logger logger = Logger.getLogger(AddItemTable.class);

    //Locating "Add Item" tables's first editable row (left-side)
    //OFQ//@FindBy(xpath = "//div/span/img[contains(@src, 'libs/Icon/ProgressOpen.png')]")
    @FindBy(xpath = "//span[text()='Item Data']/ancestor::table[contains (@ct, 'P')][contains (@class, 'lsPanel urHtmlTableReset')][1]/tbody/tr[2]/descendant::table[contains (@shscrollcontentid, 'mrss-hdr-none-content')][contains (@ct, 'STCS')]/tbody[contains (@id, 'content')]/tr[contains (@vpm, 'mrss-cont')]/td[1]/descendant::table[contains (@id, 'mrss-cont-left-content')]/tbody/tr[1]/descendant::img[contains(@src, 'libs/Icon/ProgressOpen.png')]")
    private WebElement row1_AddItemTable_Left;

    //Locating "Add Item" tables's first editable row (right-side)
    @FindBy(xpath = "//span[text()='Item Data']/ancestor::table[contains (@ct, 'P')][contains (@class, 'lsPanel urHtmlTableReset')][1]/tbody/tr[2]/descendant::table[contains (@shscrollcontentid, 'mrss-hdr-none-content')][contains (@ct, 'STCS')]/tbody[contains (@id, 'content')]/tr[contains (@vpm, 'mrss-cont')]/td[2]/descendant::table[contains (@id, 'mrss-cont-none-content')]/tbody/tr[@class='urST4RowFirstVisible'][contains(@bseturst4rowfirstvisible, 'X')]")
    private WebElement row1_AddItemTable_Right;

    //Locating "Add Item" tables's second editable row (left-side)
    //OFQ//@FindBy(xpath = "//div/span/img[contains(@src, 'libs/Icon/ProgressOpen.png')]")
    @FindBy(xpath = "//span[text()='Item Data']/ancestor::table[contains (@ct, 'P')][contains (@class, 'lsPanel urHtmlTableReset')][1]/tbody/tr[2]/descendant::table[contains (@shscrollcontentid, 'mrss-hdr-none-content')][contains (@ct, 'STCS')]/tbody[contains (@id, 'content')]/tr[contains (@vpm, 'mrss-cont')]/td[1]/descendant::table[contains (@id, 'mrss-cont-left-content')]/tbody/tr[2]/descendant::img[contains(@src, 'libs/Icon/ProgressOpen.png')]")
    private WebElement row2_AddItemTable_Left;

    //Locating "Add Item" tables's second editable row (right-side)
    @FindBy(xpath = "//span[text()='Item Data']/ancestor::table[contains (@ct, 'P')][contains (@class, 'lsPanel urHtmlTableReset')][1]/tbody/tr[2]/descendant::table[contains (@shscrollcontentid, 'mrss-hdr-none-content')][contains (@ct, 'STCS')]/tbody[contains (@id, 'content')]/tr[contains (@vpm, 'mrss-cont')]/td[2]/descendant::table[contains (@id, 'mrss-cont-none-content')]/tbody/tr[2]")
    private WebElement row2_AddItemTable_Right;

    //Locating first row in the table on "Customer Role Check" popup
    @FindBy(xpath = "//table[@class='urST5OuterOffBrd urBorderBox'][contains(@id, 'mrss-cont-none-content')]/tbody/tr[@class='urST4RowFirstVisible'][1]/td[1]/div/span/span")
    private WebElement firstRow_CustomerRoleCheck;

    //Locating first row in the table on "Customer Role Check" popup (on OGQ_100)
    @FindBy(xpath = "//table[@class='urST5OuterOffBrd urBorderBox'][contains(@id, 'mrss-cont-none-content')]/tbody/tr[@class='urST4RowFirstVisible'][1]/td[1]/div/span")
    private WebElement firstRow_CustomerRoleCheck_OGQ_100;

    //Locating "Transfer the Reference Object" button on "Customer Role Check" popup
    //@FindBy(xpath = "//span[@class='lsButton__text '][contains(text(), 'Transfer the Reference Object')]")
    //private WebElement button_CustomerRoleCheck;

    //Locating first completed row in the "Add Item" table
    //OFQ//@FindBy(xpath = "//div[contains(@id, 'mrss-cont-left')]/div[contains(@bisposelement, 'X')][@class='urBorderBox']/table/tbody/tr/td[1]/div/div")
    @FindBy(xpath = "//span[contains (text(), 'Item Data')]/ancestor::table[contains (@ct, 'P')][contains (@class, 'lsPanel urHtmlTableReset')]/tbody/tr[2]/descendant::tbody[contains (@class, 'urLinStd')]/descendant::table[contains (@ct, 'STCS')][contains (@class, 'urSTCS urST3WhlBrd urST3WhlNoTit urST5SelColUiGeneric urHtmlTableReset')]/descendant::div[contains(@id, 'mrss-cont-left')]/div[contains(@bisposelement, 'X')][@class='urBorderBox']/table/tbody/tr/td[1]/div/div")
    private WebElement table_FirstCompletedRow;

    //Locating "Purchasing" tab
    //OFQ//@FindBy(xpath = "//div[text()='Transfer Posting'][@class='lsTbsv5-ItemTitle']")
    //@FindBy(xpath = "//td[contains (@class, 'lsTbsPanel2')]/div[@class, 'lsTbsOvfl']/div[@class, 'lsTbsv5-FirstItemSel'][1]/div[contains (@class, 'lsTbsv5-ItemTitle')][text()='Purchasing']")
    // @FindBy(xpath = "//span[contains (@class, 'lsHdArTitle')][contains (text(), 'Detail Data')]/ancestor::table[contains (@class, 'lsPanel urHtmlTableReset')][contains (@ct, 'P')]/tbody/tr[2]/descendant::tbody[contains (@class, 'urLinStd')]/tr[2]/descendant::td[contains (@class, 'lsTbsPanel2')]/div/div[1]")
    @FindBy(xpath = "//span[contains (@class, 'lsHdArTitle')][contains (text(), 'Detail Data')]/ancestor::table[contains (@class, 'lsPanel urHtmlTableReset')][contains (@ct, 'P')]/tbody/tr[2]/descendant::tbody[contains (@class, 'urLinStd')][2]/tr[2]/descendant::td[contains (@class, 'lsTbsPanel2')]/div/descendant::div[text()='Purchasing'][1]/ancestor::div[1]")
    // @FindBy(xpath = "//div[text()='Purchasing' | text()='Purchasing-']")
    private WebElement tab_Purchasing;

    //Locating input field "Stock Transfer Plant"
    //OFQ//@FindBy(xpath = "//input[contains (@title, 'Stock Transfer Plant')][@class='lsField__input urEdf2TxtEnbl lsEdfLeftBrdRadius lsEdf3TxtHlpBtn urBorderBox lsControl--explicitwidth']")
    @FindBy(xpath = "//input[contains (@title, 'Stock Transfer Plant')][contains (@class, 'urEdf2TxtEnbl lsEdfLeftBrdRadius lsEdf3TxtHlpBtn urBorderBox lsControl--explicitwidth')]")
    private WebElement input_PlantOfStockTransfer;

    //Locating input field "Stock Transfer Plant" when it was clicked and focus was set on it
    @FindBy(xpath = "//input[contains (@title, 'Stock Transfer Plant')][contains (@class, 'lsEdFieldFocus')]")
    private WebElement input_PlantOfStockTransferEditable;

    //Locating input field "Supplying Plant"
    @FindBy(xpath = "//span[text()='Supplying Plant']/ancestor::tr[1]/descendant::input[contains (@title, 'SPlt')][contains (@class, 'lsField__input')]")
    private WebElement input_SupplyingPlant;

    //Locating input field "Supplying Plant" when it was clicked and focus was set on it
    @FindBy(xpath = "//input[contains (@title, 'SPlt')][contains (@class, 'lsEdFieldFocus')]")
    private WebElement input_SupplyingPlantEditable;

    //Locating input field "Purchasing Group"
    @FindBy(xpath = "//span[text()='Purchasing group']/ancestor::tr[1]/descendant::input[contains (@title, 'PGr')][contains (@class, 'lsField__input')]")
    private WebElement input_PurchasingGroup;

    //Locating input field "Purchasing Group" when it was clicked and focus was set on it
    @FindBy(xpath = "//input[contains (@title, 'PGr')][contains (@class, 'lsEdFieldFocus')]")
    private WebElement input_PurchasingGroupEditable;

    //Locating input field "Purchasing Organization"
    @FindBy(xpath = "//span[text()='Purch. Organization']/ancestor::tr[1]/descendant::input[contains (@title, 'POrg')][contains (@class, 'lsField__input')]")
    private WebElement input_PurchasingOrganization;

    //Locating input field "Purchasing Organization" when it was clicked and focus was set on it
    @FindBy(xpath = "//input[contains (@title, 'POrg')][contains (@class, 'lsEdFieldFocus')]")
    private WebElement input_PurchasingOrganizationEditable;

    //Locating input field "SLoc of Stock Transfer"
    @FindBy(xpath = "//input[contains (@title, 'SLoc of Stock Transfer')][contains (@class, 'lsField__input')]")
    private WebElement input_SlockOfStockTransfer;

    //Locating input field "SLoc of Stock Transfer" when it was clicked and focus was set on it
    @FindBy(xpath = "//input[contains (@title, 'SLoc of Stock Transfer')][contains (@class, 'lsEdFieldFocus')]")
    private WebElement input_SlockOfStockTransferEditable;

    //Locating input field "Purchasing Doc. Type"
    @FindBy(xpath = "//span[text()='Purchasing Doc. Type']/ancestor::tr[1]/descendant::input[contains (@title, 'Type')][contains (@class, 'lsField__input')]")
    private WebElement input_PurchasingDocType;

    //Locating check-box "Stock Transfer in Stock in Transit"
    @FindBy(xpath = "//span[contains (@title, 'Stock Transfer in Transit')]")
    private WebElement chkbox_StockInTransit;

    //Locating input field "Acct. Assignment Cat."
    @FindBy(xpath = "//span[text()='Acct Assignment Cat.']/ancestor::tr[1]/descendant::input[@title='A'][contains (@class, 'lsField__input')]")
    private WebElement input_AcctAssignmentCat;

    //Locating input field "Price Date"
    @FindBy(xpath = "//span[text()='Price Date']/ancestor::tr[1]/descendant::input[contains (@title, 'Price Date')][contains (@class, 'lsField__input')]")
    private WebElement input_PriceDate;

    //Locating input field "Time"
    @FindBy(xpath = "//span[text()='Time']/ancestor::tr[1]/descendant::input[contains (@title, 'Time')][contains (@class, 'lsField__input')]")
    private WebElement input_Time;

    //Locating input field "Handling Type"
    @FindBy(xpath = "//span[text()='Handling Type']/ancestor::tr[1]/descendant::input[@title='HT'][contains (@class, 'lsField__input')]")
    private WebElement input_HandlingType;

    //Locating input field "Storage Location of Stock Transfer"
    //@FindBy(xpath = "//input[contains (@title, 'SLoc of Stock Transfer')][@class='lsField__input urEdf2TxtEnbl lsEdfLeftBrdRadius lsEdf3TxtHlpBtn urBorderBox lsControl--explicitwidth']")
    @FindBy(xpath = "//input[contains (@title, 'SLoc of Stock Transfer')][contains (@class, 'urEdf2TxtEnbl lsEdfLeftBrdRadius lsEdf3TxtHlpBtn urBorderBox lsControl--explicitwidth')]")
    private WebElement input_StorageLocationOfStockTransfer;

    //Locating input field "Storage Location of Stock Transfer" when it was clicked and focus was set on it
    @FindBy(xpath = "//input[contains (@title, 'SLoc of Stock Transfer')][contains (@class,'lsEdFieldFocus')]")
    private WebElement input_StorageLocationOfStockTransferEditable;

    //Locating "Transfer the Reference Object" button on "Customer Role Check" popup
    @FindBy(xpath = "//span[contains (@class, 'lsButton__text')][contains(text(), 'Transfer the Reference Object')]")
    private WebElement button_CustomerRoleCheck;

    //Locating "Detail Data" table
    @FindBy(xpath = "//span[contains(text(), 'Detail Data')]/ancestor::table[contains (@class, 'lsPanel urHtmlTableReset')][contains (@ct, 'P')]")
    private WebElement table_DetailData;

    //Locating "OK" button on WARNING popup
    @FindBy(xpath = "//table/tbody/tr/td/div[contains (@ct, 'PAGE')]/div[contains (@class, 'lsPopupWindow--warning')]/div/div[4]/descendant::td[contains (@class, 'lsPopupWindow_Footer-buttons')]/descendant::div[contains(@title, 'OK')]")
    private WebElement button_WarningOK;


    //Constructor
    public AddItemTable(WebDriver driver) {
        super(driver);

    }

    JavascriptExecutor js = (JavascriptExecutor) driver;
    Actions action = new Actions(driver);

    public void timeToLoad_AddItemEditableFirstRow() throws Exception {

        waitTillWebElementAvailable(20, row1_AddItemTable_Left, "Editable first row of ADD ITEM Table - 'LEFT part'");
        waitTillWebElementAvailable(20, row1_AddItemTable_Right, "Editable first row of ADD ITEM Table - 'RIGHT part'");

    }


    public void timeToLoad_AddItemEditableSecondRow() throws Exception {

        waitTillWebElementAvailable(20, row2_AddItemTable_Left, "Editable second row of ADD ITEM Table - 'LEFT part'");
        waitTillWebElementAvailable(20, row2_AddItemTable_Right, "Editable second row of ADD ITEM Table - 'RIGHT part'");

    }


    public boolean isInitialized() {
        return row1_AddItemTable_Left.isDisplayed();
    }


    public void find_ItemCategoryField_andFillItIn(String itemType, String row_SequNum) throws Exception {

        int ColumnCount = 0;
        int neededColumns = 0;
        boolean elAvailability = false;
        Test_Cases.itemType = itemType; //assign Item Category value to a global variable

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
                        if (name_TableColumn.contains("Item Category")) {

                            //Find input field below the "Item Caregory" column title and provide a value into it
                            //OFQ//WebElement field_ItemCategory = driver.findElement(By.ByXPath.xpath("//div[contains(@bisposelement, 'X')][@class='urBorderBox']/table/tbody/tr/td[" + ColumnCount + "]/div/span/span"));
                           // WebElement field_ItemCategory = driver.findElement(By.ByXPath.xpath("//span[text()='Item Data']/ancestor::table[contains (@ct, 'P')][contains (@class, 'lsPanel urHtmlTableReset')][1]/tbody/tr[2]/descendant::table[contains (@shscrollcontentid, 'mrss-hdr-none-content')][contains (@ct, 'STCS')]/tbody[contains (@id, 'content')]/tr[contains (@vpm, 'mrss-cont')]/td[1]/descendant::table[contains (@id, 'mrss-cont-left-content')]/tbody/tr["+row_SequNum+"]/descendant::img[contains(@src, 'libs/Icon/ProgressOpen.png')]/ancestor::tr[contains (@class, 'urST4RowFirstVisible')]/td[" + ColumnCount + "]/div/span/*"));
                            WebElement field_ItemCategory = driver.findElement(By.ByXPath.xpath("//span[text()='Item Data']/ancestor::table[contains (@ct, 'P')][contains (@class, 'lsPanel urHtmlTableReset')][1]/tbody/tr[2]/descendant::table[contains (@shscrollcontentid, 'mrss-hdr-none-content')][contains (@ct, 'STCS')]/tbody[contains (@id, 'content')]/tr[contains (@vpm, 'mrss-cont')]/td[1]/descendant::table[contains (@id, 'mrss-cont-left-content')]/tbody/tr["+row_SequNum+"]/descendant::img[contains(@src, 'libs/Icon/ProgressOpen.png')]/ancestor::tr[1]/td[" + ColumnCount + "]/div/span/*"));

                            //WebElement field_ItemCategory = driver.findElement(By.xpath("//table[@class='urSTCS urST3WhlBrd urST3WhlNoTit urST5SelColUiGeneric urHtmlTableReset']/tbody/tr[@class=' urST5SelColUiGeneric'][@vpm='mrss-cont']/td[@class='urST5OuterOffBrd urBorderBox urStd lsSTSepBrdRight']/div/div[@bisposelement='X'][@class='urBorderBox']/table/tbody/tr[@class='urST4RowFirstVisible']/td["+ColumnCount+"]/div/span/span"));
                            field_ItemCategory.click();
                            //OFQ//WebElement input_ItemCategory = driver.findElement(By.ByXPath.xpath("//div[contains(@bisposelement, 'X')][@class='urBorderBox']/table/tbody/tr/td[" + ColumnCount + "]/div/span"));
                            //WebElement input_ItemCategory = driver.findElement(By.ByXPath.xpath("//span[text()='Item Data']/ancestor::table[contains (@ct, 'P')][contains (@class, 'lsPanel urHtmlTableReset')][1]/tbody/tr[2]/descendant::table[contains (@shscrollcontentid, 'mrss-hdr-none-content')][contains (@ct, 'STCS')]/tbody[contains (@id, 'content')]/tr[contains (@vpm, 'mrss-cont')]/td[1]/descendant::table[contains (@id, 'mrss-cont-left-content')]/tbody/tr["+row_SequNum+"]/descendant::img[contains(@src, 'libs/Icon/ProgressOpen.png')]/ancestor::tr[contains (@class, 'urST4RowFirstVisible')]/td[" + ColumnCount + "]/div/span"));
                            WebElement input_ItemCategory = driver.findElement(By.ByXPath.xpath("//span[text()='Item Data']/ancestor::table[contains (@ct, 'P')][contains (@class, 'lsPanel urHtmlTableReset')][1]/tbody/tr[2]/descendant::table[contains (@shscrollcontentid, 'mrss-hdr-none-content')][contains (@ct, 'STCS')]/tbody[contains (@id, 'content')]/tr[contains (@vpm, 'mrss-cont')]/td[1]/descendant::table[contains (@id, 'mrss-cont-left-content')]/tbody/tr["+row_SequNum+"]/descendant::img[contains(@src, 'libs/Icon/ProgressOpen.png')]/ancestor::tr[1]/td[" + ColumnCount + "]/div/span"));
                            input_ItemCategory = input_ItemCategory.findElement(By.xpath("input"));
                            input_ItemCategory.clear();
                            input_ItemCategory.sendKeys(itemType);
                            input_ItemCategory.sendKeys(Keys.RETURN);
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


    public void filling_AllRemainingFields(String row_SequNum, String cell_Material, String cell_Qty, String cell_Plant, String cell_StorgLocatn, String cell_ValtnType, String cell_HandlingType) throws Exception {

        int ColumnCount = 0;
        int neededColumns = 1;
        boolean elAvailability = false;
        try {
            //Get all columns in the RIGHT part of "Add Item" table
            //List<WebElement> available_ColumnsInRightPartOfTable0 = driver.findElements(By.ByXPath.xpath("//div[@bisposelement='X'][@class='urBorderBox']/table[@class='urST5OuterOffBrd urBorderBox lsSTOuterRightBorder'][contains(@id,'mrss-hdr-left-content')]/tbody/tr/descendant::th"));
            // List<WebElement> available_ColumnsInRightPartOfTable = driver.findElements(By.ByXPath.xpath("//div[@bisposelement='X'][@class='urBorderBox']/table[@class='urST5OuterOffBrd urBorderBox lsSTOuterRightBorder'][contains(@id,'mrss-hdr-none-content')]/tbody/tr/descendant::th"));
            //OFQ//List<WebElement> available_ColumnsInRightPartOfTable = driver.findElements(By.ByXPath.xpath("//span[contains (text(), 'Reference Document')]/ancestor::td[@class='urST5OuterOffBrd urBorderBox urStd lsSTHdrSepBrdTop lsSTHdrSepBrdBottom lsSTVertBrd']/div[contains (@id, '-mrss-hdr-none')][@class='urSTSHL1 urST4LbHdrBg']/div[@bisposelement='X'][@class='urBorderBox']/table[@class='urST5OuterOffBrd urBorderBox lsSTOuterRightBorder'][contains(@id,'mrss-hdr-none-content')]/tbody/tr/descendant::th"));
            List<WebElement> available_ColumnsInRightPartOfTable = driver.findElements(By.ByXPath.xpath("//span[contains (text(), 'Reference Document')]/ancestor::th[contains (@subct, 'HC')]/ancestor::tr[contains (@sst, '4')]/descendant::th"));


            System.out.println("Number of columns in the RIGHT part: " + available_ColumnsInRightPartOfTable.size());


            //Loop through all found coulmns
            for (WebElement element : available_ColumnsInRightPartOfTable) {
                ColumnCount++; //column counter
                if (neededColumns <= 6) {
                    System.out.println("Counter of Needed columns in the RIGHT part of ADD ITEM table: " + neededColumns);
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
                        if (name_TableColumn.contains("Material")) {
                            if (!name_TableColumn.contains("Material description")) {
                                name_TableColumn = "Material";
                            }
                        }
                        if (name_TableColumn.contains("Quantity")) {
                            name_TableColumn = "Quantity";
                        }
                        if (name_TableColumn.contains("Plant")) {
                            name_TableColumn = "Plant";
                        }
                        if (name_TableColumn.contains("Storage location")) {
                            name_TableColumn = "Storage location";
                        }
                        if (name_TableColumn.contains("Valuation Type")) {
                            name_TableColumn = "Valuation Type";
                        }
                        if (name_TableColumn.contains("Handling Type")) {
                            name_TableColumn = "Handling Type";
                        }


                        switch (name_TableColumn) {
                            // case "\n\nMaterial\n\n\n ":
                            case "Material":


                                //check whether this column is within the screen boundaries and scroll to the column
                                bringElementIntoViewHorizontally("Material");

                                //Find input field below the "Material" column title and check whether the input field is enabled/editable
                                //OFQ//WebElement field_Material = driver.findElement(By.ByXPath.xpath("//tr[@class=' urST5SelColUiGeneric'][contains(@vpm, 'mrss-cont')]/td[2]/div/div[contains(@bisposelement, 'X')][@class='urBorderBox']/table/tbody/tr/td[" + ColumnCount + "]/div/span"));
                                WebElement field_Material = driver.findElement(By.ByXPath.xpath("//tr[contains(@vpm, 'mrss-cont')]/td[2]/div/div[contains(@bisposelement, 'X')][@class='urBorderBox']/table/tbody/tr["+row_SequNum+"]/td[" + ColumnCount + "]/div/span"));


                                String inputStatus1 = field_Material.getAttribute("class");

                                //OFQ//if (!inputStatus1.contains("lsField--disabled")) {
                                if (!inputStatus1.contains("readonly")) {
                                    //scroll the field to be visible (if outside of vision portal) and click on it
                                    // js.executeScript("arguments[0].scrollIntoView();", field_Material);

                                    //field_Material.click();
                                    js.executeScript("arguments[0].click();", field_Material);

                                    //Provide value into the "Material" input field
                                    //OFQ//WebElement input_Material = driver.findElement(By.ByXPath.xpath("//tr[@class=' urST5SelColUiGeneric'][contains(@vpm, 'mrss-cont')]/td[2]/div/div[contains(@bisposelement, 'X')][@class='urBorderBox']/table/tbody/tr/td[" + ColumnCount + "]/div/span"));
                                    WebElement input_Material = driver.findElement(By.ByXPath.xpath("//tr[contains(@vpm, 'mrss-cont')]/td[2]/div/div[contains(@bisposelement, 'X')][@class='urBorderBox']/table/tbody/tr["+row_SequNum+"]/td[" + ColumnCount + "]/div/span"));
                                    input_Material = input_Material.findElement(By.xpath("input"));
                                    input_Material.clear();
                                    input_Material.sendKeys(cell_Material);
                                    logger.info("MATERIAL input field is SUCCESSFULLY filled in.");
                                    neededColumns++;
                                } else {
                                    logger.error("MATERIAL input field is in DISABLED status!");
                                    neededColumns++;
                                }
                                break;


                            // case "\n\nQuantity\n\n\n ":
                            case "Quantity":

                                //check whether this column is within the screen boundaries and scroll to the column
                                bringElementIntoViewHorizontally("Quantity");

                                //Find input field below the "Quantity" column title and check whether the input field is enabled/editable
                                //OFQ//WebElement field_Quantity = driver.findElement(By.ByXPath.xpath("//tr[@class=' urST5SelColUiGeneric'][contains(@vpm, 'mrss-cont')]/td[2]/div/div[contains(@bisposelement, 'X')][@class='urBorderBox']/table/tbody/tr/td[" + ColumnCount + "]/div/span"));
                                WebElement field_Quantity = driver.findElement(By.ByXPath.xpath("//tr[contains(@vpm, 'mrss-cont')]/td[2]/div/div[contains(@bisposelement, 'X')][@class='urBorderBox']/table/tbody/tr["+row_SequNum+"]/td[" + ColumnCount + "]/div/span"));

                                String inputStatus2 = field_Quantity.getAttribute("class");

                                //OFQ//if (!inputStatus2.contains("lsField--disabled")) {
                                if (!inputStatus2.contains("readonly")) {
                                    //scroll the field to be visible (if outside of vision portal) and click on it
                                    // js.executeScript("arguments[0].scrollIntoView();", field_Quantity);
                                    //field_Quantity.click();
                                    js.executeScript("arguments[0].click();", field_Quantity);

                                    //Provide value into the "Quantity" input field
                                    WebElement input_Qty = driver.findElement(By.ByXPath.xpath("//tr[contains(@vpm, 'mrss-cont')]/td[2]/div/div[contains(@bisposelement, 'X')][@class='urBorderBox']/table/tbody/tr["+row_SequNum+"]/td[" + ColumnCount + "]/div/span"));
                                    input_Qty = input_Qty.findElement(By.xpath("input"));
                                    input_Qty.clear();
                                    js.executeScript("arguments[0].value='" + cell_Qty + "';", input_Qty);
                                    //input_Qty.sendKeys("100");
                                    input_Qty.sendKeys(Keys.TAB);
                                    logger.info("QUANTITY input field is SUCCESSFULLY filled in.");
                                    neededColumns++;
                                } else {
                                    logger.error("QUANTITY input field is in DISABLED status!");
                                    neededColumns++;
                                }
                                break;

                            // case "\n\nPlant\n\n\n ":
                            case "Plant":


                                //check whether this column is within the screen boundaries and scroll to the column
                                bringElementIntoViewHorizontally("Plant");

                                //Find input field below the "Plant" column title and check whether the input field is enabled/editable
                                WebElement field_Plant = driver.findElement(By.ByXPath.xpath("//tr[contains(@vpm, 'mrss-cont')]/td[2]/div/div[contains(@bisposelement, 'X')][@class='urBorderBox']/table/tbody/tr["+row_SequNum+"]/td[" + ColumnCount + "]/div/span"));

                                String inputStatus3 = field_Plant.getAttribute("class");

                                //OFQ//if (!inputStatus3.contains("lsField--disabled")) {
                                if (!inputStatus3.contains("readonly")) {
                                    //scroll the field to be visible (if outside of vision portal) and click on it
                                    // js.executeScript("arguments[0].scrollIntoView();", field_Plant);
                                    //field_Plant.click();
                                    js.executeScript("arguments[0].click();", field_Plant);

                                    //Provide value into the "Plant" input field
                                    WebElement input_Plant = driver.findElement(By.ByXPath.xpath("//tr[contains(@vpm, 'mrss-cont')]/td[2]/div/div[contains(@bisposelement, 'X')][@class='urBorderBox']/table/tbody/tr["+row_SequNum+"]/td[" + ColumnCount + "]/div/span"));
                                    input_Plant = input_Plant.findElement(By.xpath("input"));
                                    input_Plant.clear();
                                    input_Plant.sendKeys(cell_Plant);
                                    logger.info("PLANT input field is SUCCESSFULLY filled in.");
                                    neededColumns++;
                                } else {
                                    logger.error("PLANT input field is in DISABLED status!");
                                    neededColumns++;
                                }
                                break;


                            // case "\n\nStorage location\n\n\n ":
                            case "Storage location":
                                //check whether this column is within the screen boundaries and scroll to the column
                                bringElementIntoViewHorizontally("Storage location");

                                //Find input field below the "Storage Location" column title and check whether the input field is enabled/editable
                                WebElement field_StorageLocation = driver.findElement(By.ByXPath.xpath("//tr[contains(@vpm, 'mrss-cont')]/td[2]/div/div[contains(@bisposelement, 'X')][@class='urBorderBox']/table/tbody/tr["+row_SequNum+"]/td[" + ColumnCount + "]/div/span"));

                                String inputStatus4 = field_StorageLocation.getAttribute("class");

                                //OFQ//if (!inputStatus4.contains("lsField--disabled")) {
                                if (!inputStatus4.contains("readonly")) {
                                    //scroll the field to be visible (if outside of vision portal) and click on it
                                    //js.executeScript("arguments[0].scrollIntoView();", field_StorageLocation);
                                    //field_StorageLocation.click();
                                    js.executeScript("arguments[0].click();", field_StorageLocation);

                                    //Provide value into the "Storage Location" input field
                                    WebElement input_StorLoc = driver.findElement(By.ByXPath.xpath("//tr[contains(@vpm, 'mrss-cont')]/td[2]/div/div[contains(@bisposelement, 'X')][@class='urBorderBox']/table/tbody/tr["+row_SequNum+"]/td[" + ColumnCount + "]/div/span"));
                                    input_StorLoc = input_StorLoc.findElement(By.xpath("input"));
                                    input_StorLoc.clear();
                                    input_StorLoc.sendKeys(cell_StorgLocatn);
                                    logger.info("STORAGE LOCATION input field is SUCCESSFULLY filled in.");
                                    neededColumns++;
                                } else {
                                    logger.error("STORAGE LOCATION input field is in DISABLED status!");
                                    neededColumns++;
                                }
                                break;

                            // case "\n\nValuation Type\n\n\n ":
                            case "Valuation Type":

                                //check whether this column is within the screen boundaries and scroll to the column
                                bringElementIntoViewHorizontally("Valuation Type");

                                //Find input field below the "Valuation Type column title and check whether the input field is enabled/editable
                                WebElement field_ValuationType = driver.findElement(By.ByXPath.xpath("//tr[contains(@vpm, 'mrss-cont')]/td[2]/div/div[contains(@bisposelement, 'X')][@class='urBorderBox']/table/tbody/tr["+row_SequNum+"]/td[" + ColumnCount + "]/div/span"));

                                String inputStatus5 = field_ValuationType.getAttribute("class");

                                //OFQ//if (!inputStatus5.contains("lsField--disabled")) {
                                if (!inputStatus5.contains("readonly")) {
                                    //scroll the field to be visible (if outside of vision portal) and click on it
                                    //field_ValuationType.click();
                                    js.executeScript("arguments[0].click();", field_ValuationType);

                                    //Provide value into the "Valuation Type" input field
                                    WebElement input_ValType = driver.findElement(By.ByXPath.xpath("//tr[contains(@vpm, 'mrss-cont')]/td[2]/div/div[contains(@bisposelement, 'X')][@class='urBorderBox']/table/tbody/tr["+row_SequNum+"]/td[" + ColumnCount + "]/div/span"));
                                    input_ValType = input_ValType.findElement(By.xpath("input"));
                                    input_ValType.clear();
                                    input_ValType.sendKeys(cell_ValtnType);
                                    logger.info("VALUATION TYPE input field is SUCCESSFULLY filled in.");
                                    neededColumns++;
                                } else {
                                    logger.error("VALUATION TYPE input field is in DISABLED status!");
                                    neededColumns++;
                                }
                                break;

                            // case "\n\nHandling Type\n\n\n ":
                            case "Handling Type":

                                //check whether this column is within the screen boundaries and scroll to the column
                                bringElementIntoViewHorizontally("Handling Type");

                                //Find input field below the "Handling Type" column title and check whether the input field is enabled/editable
                                WebElement field_HandlingType = driver.findElement(By.ByXPath.xpath("//tr[contains(@vpm, 'mrss-cont')]/td[2]/div/div[contains(@bisposelement, 'X')][@class='urBorderBox']/table/tbody/tr["+row_SequNum+"]/td[" + ColumnCount + "]/div/span"));

                                String inputStatus6 = field_HandlingType.getAttribute("class");

                                //OFQ//if (!inputStatus6.contains("lsField--disabled")) {
                                if (!inputStatus6.contains("readonly")) {
                                    //scroll the field to be visible (if outside of vision portal) and click on it

                                    //field_HandlingType.click();
                                    js.executeScript("arguments[0].click();", field_HandlingType);

                                    //Provide value into the "Handling Type" input field
                                    WebElement input_HndlType = driver.findElement(By.ByXPath.xpath("//tr[contains(@vpm, 'mrss-cont')]/td[2]/div/div[contains(@bisposelement, 'X')][@class='urBorderBox']/table/tbody/tr["+row_SequNum+"]/td[" + ColumnCount + "]/div/span"));
                                    input_HndlType = input_HndlType.findElement(By.xpath("input"));
                                    input_HndlType.clear();
                                    input_HndlType.sendKeys(cell_HandlingType);
                                    input_HndlType.sendKeys(Keys.RETURN);
                                    Thread.sleep(2000);
                                    logger.info("HANDLING TYPE input field is SUCCESSFULLY filled in.");
                                    neededColumns++;
                                } else {
                                    logger.error("HANDLING TYPE input field is in DISABLED status!");
                                    neededColumns++;
                                }
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


    public void filling_AllRemainingFieldsForOtherDocuments() {

        int ColumnCount = 0;
        int neededColumns = 1;
        boolean elAvailability = false;
        try {
            //Get all columns in the RIGHT part of "Add Item" table
            //List<WebElement> available_ColumnsInRightPartOfTable0 = driver.findElements(By.ByXPath.xpath("//div[@bisposelement='X'][@class='urBorderBox']/table[@class='urST5OuterOffBrd urBorderBox lsSTOuterRightBorder'][contains(@id,'mrss-hdr-left-content')]/tbody/tr/descendant::th"));
            // List<WebElement> available_ColumnsInRightPartOfTable = driver.findElements(By.ByXPath.xpath("//div[@bisposelement='X'][@class='urBorderBox']/table[@class='urST5OuterOffBrd urBorderBox lsSTOuterRightBorder'][contains(@id,'mrss-hdr-none-content')]/tbody/tr/descendant::th"));
            //OFQ//List<WebElement> available_ColumnsInRightPartOfTable = driver.findElements(By.ByXPath.xpath("//span[contains (text(), 'Reference Document')]/ancestor::td[@class='urST5OuterOffBrd urBorderBox urStd lsSTHdrSepBrdTop lsSTHdrSepBrdBottom lsSTVertBrd']/div[contains (@id, '-mrss-hdr-none')][@class='urSTSHL1 urST4LbHdrBg']/div[@bisposelement='X'][@class='urBorderBox']/table[@class='urST5OuterOffBrd urBorderBox lsSTOuterRightBorder'][contains(@id,'mrss-hdr-none-content')]/tbody/tr/descendant::th"));
            List<WebElement> available_ColumnsInRightPartOfTable = driver.findElements(By.ByXPath.xpath("//span[contains (text(), 'Reference Document')]/ancestor::th[contains (@subct, 'HC')]/ancestor::tr[contains (@sst, '4')]/descendant::th"));


            System.out.println("Number of columns in the RIGHT part: " + available_ColumnsInRightPartOfTable.size());


            //Loop through all found coulmns
            for (WebElement element : available_ColumnsInRightPartOfTable) {
                ColumnCount++; //column counter
                if (neededColumns <= 1) {
                    System.out.println("Counter of Needed columns in the RIGHT part of ADD ITEM table: " + neededColumns);
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


                        switch (name_TableColumn) {
                            // case "\n\nMaterial\n\n\n ":
                            case "Reference Document":


                                //check whether this column is within the screen boundaries and scroll to the column
                                bringElementIntoViewHorizontally("Reference Document");

                                //Find input field below the "Reference Document" column title and check whether the input field is enabled/editable
                                //OFQ//WebElement field_Material = driver.findElement(By.ByXPath.xpath("//tr[@class=' urST5SelColUiGeneric'][contains(@vpm, 'mrss-cont')]/td[2]/div/div[contains(@bisposelement, 'X')][@class='urBorderBox']/table/tbody/tr/td[" + ColumnCount + "]/div/span"));
                                WebElement field_ReferenceDocument = driver.findElement(By.ByXPath.xpath("//tr[contains(@vpm, 'mrss-cont')]/td[2]/div/div[contains(@bisposelement, 'X')][@class='urBorderBox']/table/tbody/tr/td[" + ColumnCount + "]/div/span"));


                                String inputStatus1 = field_ReferenceDocument.getAttribute("class");

                                //OFQ//if (!inputStatus1.contains("lsField--disabled")) {
                                if (!inputStatus1.contains("readonly")) {
                                    //scroll the field to be visible (if outside of vision portal) and click on it
                                    // js.executeScript("arguments[0].scrollIntoView();", field_Material);

                                    //field_Material.click();
                                    js.executeScript("arguments[0].click();", field_ReferenceDocument);

                                    //Provide value into the "Material" input field
                                    //OFQ//WebElement input_Material = driver.findElement(By.ByXPath.xpath("//tr[@class=' urST5SelColUiGeneric'][contains(@vpm, 'mrss-cont')]/td[2]/div/div[contains(@bisposelement, 'X')][@class='urBorderBox']/table/tbody/tr/td[" + ColumnCount + "]/div/span"));
                                    WebElement input_ReferenceDocument = driver.findElement(By.ByXPath.xpath("//tr[contains(@vpm, 'mrss-cont')]/td[2]/div/div[contains(@bisposelement, 'X')][@class='urBorderBox']/table/tbody/tr/td[" + ColumnCount + "]/div/span"));
                                    input_ReferenceDocument = input_ReferenceDocument.findElement(By.xpath("input"));
                                    input_ReferenceDocument.clear();
                                    input_ReferenceDocument.sendKeys(Test_Cases.num_StockTransportOrder);
                                    input_ReferenceDocument.sendKeys(Keys.RETURN);
                                    logger.info("REFERENCE DOCUMENT input field is SUCCESSFULLY filled in.");
                                    neededColumns++;

                                } else {
                                    logger.error("REFERENCE DOCUMENT input field is in DISABLED status!");
                                    neededColumns++;
                                }
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


    public boolean check_IfWarningOnReversePopupDisplayed() throws Exception {

        try {//check if WARNING popup is loaded and if yes, how long did it take to load it

            // long startTime = System.nanoTime();
            // int secondsCounter = 1;


            //  for (int i = 1; i <= 3; i++) {

            //Select the parent web element
            List<WebElement> elm = driver.findElements(By.xpath("//div[@id='ALL_POPUPS']/div[contains(@id, 'POP_CONT')]/descendant::div"));

            if (elm.size() == 0) { //wait 1 second if no elements were found
                // Thread.sleep(1000);
                // secondsCounter++;

                // if (secondsCounter == 3) {//stop waiting when maximum allowed time is exceeded
                // logger.info("Timed out after 3 seconds on 'WARNING POPUP' after doing reverse");
                Test_Cases.popup_Warning = false;
                // break;
                //  }

            } else {
                   /* long endTime = System.nanoTime();
                    double elapsedTimeInSeconds = TimeUnit.MILLISECONDS.convert((endTime - startTime), TimeUnit.NANOSECONDS) / 1000.0;

                    logger.info("TOTAL TIME that the 'WARNING' popup was loading: " + elapsedTimeInSeconds + " seconds.");*/
                Test_Cases.popup_Warning = true;
                // break;
            }

            // }
        } catch (NoSuchElementException e) {
            Test_Cases.popup_Warning = false;
        }
        return Test_Cases.popup_Warning;
    }


    public boolean check_IfWarningOnReversePopupDisplayed_OGQ() throws Exception {

        try {//check if WARNING popup is loaded

            //Select the parent web element
            List<WebElement> elm = driver.findElements(By.xpath("//table/tbody/tr/td/div[contains (@ct, 'PAGE')]/div[contains (@class, 'lsPopupWindow--warning')]/descendant::div"));

            if (elm.size() == 0) {
                Test_Cases.popup_Warning = false;
            } else {
                Test_Cases.popup_Warning = true;
            }


        } catch (NoSuchElementException e) {
            Test_Cases.popup_Warning = false;
        }
        return Test_Cases.popup_Warning;
    }


    public boolean check_IfElementIsPresent(String xPath) throws Exception {

        boolean elAvailability = false;

        try {//check if every column contains column title text
            driver.findElement(By.xpath(xPath));
            elAvailability = true;
        } catch (NoSuchElementException e) {
            elAvailability = false;
        }
        return elAvailability;
    }


    public boolean check_IfDescendantElementsArePresent(String xPath) throws Exception {

        boolean elAvailability = false;

        try {//check if every column contains column title text
            driver.findElements(By.xpath(xPath));
            elAvailability = true;
        } catch (NoSuchElementException e) {
            elAvailability = false;
        }
        return elAvailability;
    }


    public void filling_CustomerRoleCheck_popup() throws Exception {

        try {

            //Select the parent web element for "Customer Role Check" popup depending on the system and client
            if (Test_Cases.conf_SystemClient.equals("OFQ_100")) {
                //Click on the first row in the table on the "Customer Roller Check" popup
                //js.executeScript("arguments[0].scrollIntoView()", firstRow_CustomerRoleCheck);
                //action.moveToElement(firstRow_CustomerRoleCheck).click().build().perform();
                firstRow_CustomerRoleCheck.click();
                //js.executeScript("arguments[0].click();", firstRow_CustomerRoleCheck);

                Thread.sleep(2000);

                //WebElement button_CustomerRoleCheck = driver.findElement(By.xpath("//span[@class='lsButton__text '][contains(text(), 'Transfer the Reference Object')]"));

                //Set focus on "TRANSFER THE REFERENCE OBJECT" button
                //js.executeScript("arguments[0].scrollIntoView(true)", button_CustomerRoleCheck);
                js.executeScript("arguments[0].click();", button_CustomerRoleCheck);
                //action.moveToElement(button_CustomerRoleCheck).click().perform();
                //button_CustomerRoleCheck.click();
            }
            if (Test_Cases.conf_SystemClient.equals("OGQ_100")) {

                driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src, 'LOADING_TEMPLATE=POPUP_PAGE&sap-wd-popupWindowID=')]")));
                firstRow_CustomerRoleCheck_OGQ_100.click();
                //js.executeScript("arguments[0].click();", firstRow_CustomerRoleCheck);

                Thread.sleep(2000);

                js.executeScript("arguments[0].click();", button_CustomerRoleCheck);
                driver.switchTo().defaultContent();
            }


            logger.info("'CUSTOMER ROLE CHECKUP'popup was closed.");


        } catch (Exception e) {
            logger.error("Error while locating an element on the 'CUSTOMER ROLE CHECKUP'popup: " + e.getMessage());
        }
    }


    public void filling_OverviewRefObject_popup() throws Exception {

        try {
            driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@name,'URLSPW-0')]")));

            WebElement firstRow_OverviewRefObject = driver.findElement(By.xpath("//table[contains (@ct, 'STCS')][contains (@class, 'urST5SelColUiGeneric urHtmlTableReset')]/tbody[contains (@id, 'content')]/tr[2]/td[2]/descendant::table[contains (@id, 'mrss-cont-none-content')]/tbody/tr[1]/td[1]/div"));

            firstRow_OverviewRefObject.click();
            //js.executeScript("arguments[0].click();", firstRow_CustomerRoleCheck);

            Thread.sleep(2000);

            WebElement button_TransferRefObject = driver.findElement(By.xpath("//span[contains (text(), 'Transfer the Reference Object')]/ancestor::div[1]"));

            js.executeScript("arguments[0].click();", button_TransferRefObject);
            driver.switchTo().defaultContent();

            logger.info("'OVERVIEW FOR THE REFERENCE OBJECT' popup was closed.");


        } catch (Exception e) {
            logger.warn("Unable to locate an element on the 'OVERVIEW FOR THE REFERENCE OBJECT'popup or the popup itself: " + e.getMessage());
            driver.switchTo().defaultContent();
        }
    }


    public void check_AutocompeteFields(String row_SequNum, String auto_cell_MaterialDescription, String auto_cell_BaseUnitOfMeasure) throws Exception {

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
                        element.findElement(By.xpath("div/table/tbody/tr/td[1]/div/span/span"));
                        elAvailability = true;
                    } catch (NoSuchElementException e) {
                        elAvailability = false;
                    }

                    //if column contains a column title text then read it
                    if (elAvailability) {

                        String name_TableColumn = element.getAttribute("innerText");
                        System.out.println("SPAN element Text in the RIGHT part: " + name_TableColumn);

                        if (name_TableColumn.contains("Material description")) {
                            name_TableColumn = "Material description";
                        }
                        if (name_TableColumn.contains("Base Unit of Measure")) {
                            name_TableColumn = "Base Unit of Measure";
                        }

                        switch (name_TableColumn) {
                            case "Material description":

                                WebElement field_MaterialDescription = null;

                                //Find input field below the "Material description" column title and check whether the input field is enabled/editable
                                if (Test_Cases.conf_SystemClient.equals("OFQ_100")) {
                                    WebElement elm = driver.findElement(By.ByXPath.xpath("//tr[contains(@vpm, 'mrss-cont')]/td[2]/div/div[contains(@bisposelement, 'X')][@class='urBorderBox']/table/tbody/tr["+row_SequNum+"]/td[" + ColumnCount + "]/div/span/span"));
                                    field_MaterialDescription = elm;
                                }
                                if (Test_Cases.conf_SystemClient.equals("OGQ_100")) {
                                    WebElement elm = driver.findElement(By.ByXPath.xpath("//tr[contains(@vpm, 'mrss-cont')]/td[2]/div/div[contains(@bisposelement, 'X')][@class='urBorderBox']/table/tbody/tr["+row_SequNum+"]/td[" + ColumnCount + "]/div/span"));
                                    field_MaterialDescription = elm;
                                }


                                String inputValue1 = field_MaterialDescription.getAttribute("innerText");

                                if (!(inputValue1 != null || inputValue1.contains(auto_cell_MaterialDescription))) {

                                    logger.error("MATERIAL DESCRIPTION input field has NO AUTOFILLED VALUE!");
                                    neededColumns++;
                                } else {
                                    logger.info("MATERIAL DESCRIPTION input field is AUTOFILLED with the value '" + inputValue1 + "'.");
                                    neededColumns++;
                                }
                                break;


                            case "Base Unit of Measure":

                                //Find input field below the "Quantity" column title and check whether the input field is enabled/editable
                                //OFQ//WebElement field_BaseUOF = driver.findElement(By.ByXPath.xpath("//tr[@class=' urST5SelColUiGeneric'][contains(@vpm, 'mrss-cont')]/td[2]/div/div[contains(@bisposelement, 'X')][@class='urBorderBox']/table/tbody/tr/td[" + ColumnCount + "]/div/span/span"));
                                WebElement field_BaseUOF = null;
                                String inputValue2 = "";

                                //Find input field below the "Base Unit of Measure" column title and check whether the input field is enabled/editable
                                if (Test_Cases.conf_SystemClient.equals("OFQ_100")) {
                                    WebElement elm = driver.findElement(By.ByXPath.xpath("//tr[contains(@vpm, 'mrss-cont')]/td[2]/div/div[contains(@bisposelement, 'X')][@class='urBorderBox']/table/tbody/tr/td[" + ColumnCount + "]/div/span/span"));
                                    field_BaseUOF = elm;
                                    inputValue2 = field_BaseUOF.getAttribute("innerText");
                                }
                                if (Test_Cases.conf_SystemClient.equals("OGQ_100")) {
                                    WebElement elm = driver.findElement(By.ByXPath.xpath("//tr[contains(@vpm, 'mrss-cont')]/td[2]/div/div[contains(@bisposelement, 'X')][@class='urBorderBox']/table/tbody/tr/td[" + ColumnCount + "]/div/span/span"));
                                    field_BaseUOF = elm;
                                    //inputValue2 = field_BaseUOF.getAttribute("value");
                                    inputValue2 = field_BaseUOF.getAttribute("innerText");
                                }


                                if (!(inputValue2 != null || inputValue2.contains(auto_cell_BaseUnitOfMeasure))) {

                                    logger.error("BASE UNIT OF MEASURE input field has NO AUTOFILLED VALUE!");
                                    neededColumns++;
                                } else {
                                    logger.info("BASE UNIT OF MEASURE input field is AUTOFILLED with the value '" + inputValue2 + "'.");
                                    neededColumns++;
                                }
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


    public void check_AutocompeteFieldsForOtherDocuments(String auto_cell_Material, String auto_cell_MaterialDescription, String auto_cell_Qty, String auto_cell_BaseUnitOfMeasure, String auto_cell_Plant, String auto_cell_StorgLocatn, String auto_cell_ValtnType, String cell_HandlingType) throws Exception {

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
                if (neededColumns <= 8) {
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

                        if (name_TableColumn.contains("Material")) {
                            if (!name_TableColumn.contains("Material description")) {
                                name_TableColumn = "Material";
                            }
                        }
                        if (name_TableColumn.contains("Material description")) {
                            name_TableColumn = "Material description";
                        }
                        if (name_TableColumn.contains("Quantity")) {
                            name_TableColumn = "Quantity";
                        }
                        if (name_TableColumn.contains("Base Unit of Measure")) {
                            name_TableColumn = "Base Unit of Measure";
                        }
                        if (name_TableColumn.contains("Plant")) {
                            name_TableColumn = "Plant";
                        }
                        if (name_TableColumn.contains("Storage location")) {
                            name_TableColumn = "Storage location";
                        }
                        if (name_TableColumn.contains("Valuation Type")) {
                            name_TableColumn = "Valuation Type";
                        }
                        if (name_TableColumn.contains("Handling Type")) {
                            name_TableColumn = "Handling Type";
                        }

                        switch (name_TableColumn) {
                            case "Material":

                                WebElement field_Material = null;

                                //Find input field below the "Material" column title and check whether the input field is enabled/editable
                                if (Test_Cases.conf_SystemClient.equals("OFQ_100")) {
                                    WebElement elm = driver.findElement(By.ByXPath.xpath("//tr[contains(@vpm, 'mrss-cont')]/td[2]/div/div[contains(@bisposelement, 'X')][@class='urBorderBox']/table/tbody/tr/td[" + ColumnCount + "]/div/span/span"));
                                    field_Material = elm;
                                }
                                if (Test_Cases.conf_SystemClient.equals("OGQ_100")) {
                                    WebElement elm = driver.findElement(By.ByXPath.xpath("//tr[contains(@vpm, 'mrss-cont')]/td[2]/div/div[contains(@bisposelement, 'X')][@class='urBorderBox']/table/tbody/tr/td[" + ColumnCount + "]/div/span/span"));
                                    field_Material = elm;
                                }

                                String inputValue0 = field_Material.getAttribute("innerText");

                                if (!(inputValue0 != null || inputValue0.contains(auto_cell_Material))) {

                                    logger.error("MATERIAL input field has NO AUTOFILLED VALUE!");
                                    neededColumns++;
                                } else {
                                    if (inputValue0.equalsIgnoreCase(auto_cell_Material)) {
                                        logger.info("MATERIAL input field is AUTOFILLED with the value '" + inputValue0 + "'.");
                                    } else {
                                        logger.warn("MATERIAL input field is AUTOFILLED with the value '" + inputValue0 + "'. EXPECTED value should be '" + auto_cell_Material + "'!");
                                    }
                                    neededColumns++;

                                }
                                break;


                            case "Material description":

                                WebElement field_MaterialDescription = null;

                                //Find input field below the "Material description" column title and check whether the input field is enabled/editable
                                if (Test_Cases.conf_SystemClient.equals("OFQ_100")) {
                                    WebElement elm = driver.findElement(By.ByXPath.xpath("//tr[contains(@vpm, 'mrss-cont')]/td[2]/div/div[contains(@bisposelement, 'X')][@class='urBorderBox']/table/tbody/tr/td[" + ColumnCount + "]/div/span/span"));
                                    field_MaterialDescription = elm;
                                }
                                if (Test_Cases.conf_SystemClient.equals("OGQ_100")) {
                                    WebElement elm = driver.findElement(By.ByXPath.xpath("//tr[contains(@vpm, 'mrss-cont')]/td[2]/div/div[contains(@bisposelement, 'X')][@class='urBorderBox']/table/tbody/tr/td[" + ColumnCount + "]/div/span/span"));
                                    field_MaterialDescription = elm;
                                }


                                String inputValue1 = field_MaterialDescription.getAttribute("innerText");

                                if (!(inputValue1 != null || inputValue1.contains(auto_cell_MaterialDescription))) {

                                    logger.error("MATERIAL DESCRIPTION input field has NO AUTOFILLED VALUE!");
                                    neededColumns++;
                                } else {
                                    if (inputValue1.equalsIgnoreCase(auto_cell_MaterialDescription)) {
                                        logger.info("MATERIAL DESCRIPTION input field is AUTOFILLED with the value '" + inputValue1 + "'.");
                                    } else {
                                        logger.warn("MATERIAL DESCRIPTION input field is AUTOFILLED with the value '" + inputValue1 + "'. EXPECTED value should be '" + auto_cell_MaterialDescription + "'!");
                                    }
                                    neededColumns++;
                                }
                                break;


                            case "Quantity":

                                WebElement field_Quantity = null;

                                //Find input field below the "Quantity" column title and check whether the input field is enabled/editable
                                if (Test_Cases.conf_SystemClient.equals("OFQ_100")) {
                                    WebElement elm = driver.findElement(By.ByXPath.xpath("//tr[contains(@vpm, 'mrss-cont')]/td[2]/div/div[contains(@bisposelement, 'X')][@class='urBorderBox']/table/tbody/tr/td[" + ColumnCount + "]/div/span/span"));
                                    field_Quantity = elm;
                                }
                                if (Test_Cases.conf_SystemClient.equals("OGQ_100")) {
                                    WebElement elm = driver.findElement(By.ByXPath.xpath("//tr[contains(@vpm, 'mrss-cont')]/td[2]/div/div[contains(@bisposelement, 'X')][@class='urBorderBox']/table/tbody/tr/td[" + ColumnCount + "]/div/span/span"));
                                    field_Quantity = elm;
                                }


                                String inputValue2 = field_Quantity.getAttribute("innerText");

                                if (!(inputValue2 != null || inputValue2.contains(auto_cell_Qty))) {

                                    logger.error("QUANTITY input field has NO AUTOFILLED VALUE!");
                                    neededColumns++;
                                } else {
                                    if (inputValue2.equalsIgnoreCase(auto_cell_Qty) || inputValue2.contains("100,000")) {
                                        logger.info("QUANTITY input field is AUTOFILLED with the value '" + inputValue2 + "'.");
                                    } else {
                                        logger.warn("QUANTITY input field is AUTOFILLED with the value '" + inputValue2 + "'. EXPECTED value should be '" + auto_cell_Qty + "'!");
                                    }
                                    neededColumns++;
                                }
                                break;


                            case "Base Unit of Measure":

                                //Find input field below the "Quantity" column title and check whether the input field is enabled/editable
                                //OFQ//WebElement field_BaseUOF = driver.findElement(By.ByXPath.xpath("//tr[@class=' urST5SelColUiGeneric'][contains(@vpm, 'mrss-cont')]/td[2]/div/div[contains(@bisposelement, 'X')][@class='urBorderBox']/table/tbody/tr/td[" + ColumnCount + "]/div/span/span"));
                                WebElement field_BaseUOF = null;
                                String inputValue3 = "";

                                //Find input field below the "Base Unit of Measure" column title and check whether the input field is enabled/editable
                                if (Test_Cases.conf_SystemClient.equals("OFQ_100")) {
                                    WebElement elm = driver.findElement(By.ByXPath.xpath("//tr[contains(@vpm, 'mrss-cont')]/td[2]/div/div[contains(@bisposelement, 'X')][@class='urBorderBox']/table/tbody/tr/td[" + ColumnCount + "]/div/span/span"));
                                    field_BaseUOF = elm;
                                    inputValue3 = field_BaseUOF.getAttribute("innerText");
                                }
                                if (Test_Cases.conf_SystemClient.equals("OGQ_100")) {
                                    WebElement elm = driver.findElement(By.ByXPath.xpath("//tr[contains(@vpm, 'mrss-cont')]/td[2]/div/div[contains(@bisposelement, 'X')][@class='urBorderBox']/table/tbody/tr/td[" + ColumnCount + "]/div/span/span"));
                                    field_BaseUOF = elm;
                                    inputValue3 = field_BaseUOF.getAttribute("innerText");
                                }


                                if (!(inputValue3 != null || inputValue3.contains(auto_cell_BaseUnitOfMeasure))) {

                                    logger.error("BASE UNIT OF MEASURE input field has NO AUTOFILLED VALUE!");
                                    neededColumns++;
                                } else {
                                    if (inputValue3.equalsIgnoreCase(auto_cell_BaseUnitOfMeasure)) {
                                        logger.info("BASE UNIT OF MEASURE input field is AUTOFILLED with the value '" + inputValue3 + "'.");
                                    } else {
                                        logger.warn("BASE UNIT OF MEASURE input field is AUTOFILLED with the value '" + inputValue3 + "'. EXPECTED value should be '" + auto_cell_BaseUnitOfMeasure + "'!");
                                    }
                                    neededColumns++;
                                }
                                break;


                            case "Plant":

                                //Find input field below the "Quantity" column title and check whether the input field is enabled/editable
                                //OFQ//WebElement field_BaseUOF = driver.findElement(By.ByXPath.xpath("//tr[@class=' urST5SelColUiGeneric'][contains(@vpm, 'mrss-cont')]/td[2]/div/div[contains(@bisposelement, 'X')][@class='urBorderBox']/table/tbody/tr/td[" + ColumnCount + "]/div/span/span"));
                                WebElement field_Plant = null;
                                String inputValue4 = "";

                                //Find input field below the "Plant" column title and check whether the input field is enabled/editable
                                if (Test_Cases.conf_SystemClient.equals("OFQ_100")) {
                                    WebElement elm = driver.findElement(By.ByXPath.xpath("//tr[contains(@vpm, 'mrss-cont')]/td[2]/div/div[contains(@bisposelement, 'X')][@class='urBorderBox']/table/tbody/tr/td[" + ColumnCount + "]/div/span/span"));
                                    field_Plant = elm;
                                    inputValue4 = field_Plant.getAttribute("innerText");
                                }
                                if (Test_Cases.conf_SystemClient.equals("OGQ_100")) {
                                    WebElement elm = driver.findElement(By.ByXPath.xpath("//tr[contains(@vpm, 'mrss-cont')]/td[2]/div/div[contains(@bisposelement, 'X')][@class='urBorderBox']/table/tbody/tr/td[" + ColumnCount + "]/div/span/span"));
                                    field_Plant = elm;
                                    inputValue4 = field_Plant.getAttribute("innerText");
                                }


                                if (!(inputValue4 != null || inputValue4.contains(auto_cell_Plant))) {

                                    logger.error("PLANT input field has NO AUTOFILLED VALUE!");
                                    neededColumns++;
                                } else {
                                    if (inputValue4.equalsIgnoreCase(auto_cell_Plant)) {
                                        logger.info("PLANT input field is AUTOFILLED with the value '" + inputValue4 + "'.");
                                    } else {
                                        logger.warn("PLANT input field is AUTOFILLED with the value '" + inputValue4 + "'. EXPECTED value should be '" + auto_cell_Plant + "'!");
                                    }
                                    neededColumns++;
                                }
                                break;


                            case "Storage location":

                                //Find input field below the "Quantity" column title and check whether the input field is enabled/editable
                                //OFQ//WebElement field_BaseUOF = driver.findElement(By.ByXPath.xpath("//tr[@class=' urST5SelColUiGeneric'][contains(@vpm, 'mrss-cont')]/td[2]/div/div[contains(@bisposelement, 'X')][@class='urBorderBox']/table/tbody/tr/td[" + ColumnCount + "]/div/span/span"));
                                WebElement field_StorageLocation = null;
                                String inputValue5 = "";

                                //Find input field below the "Plant" column title and check whether the input field is enabled/editable
                                if (Test_Cases.conf_SystemClient.equals("OFQ_100")) {
                                    WebElement elm = driver.findElement(By.ByXPath.xpath("//tr[contains(@vpm, 'mrss-cont')]/td[2]/div/div[contains(@bisposelement, 'X')][@class='urBorderBox']/table/tbody/tr/td[" + ColumnCount + "]/div/span/span"));
                                    field_StorageLocation = elm;
                                    inputValue5 = field_StorageLocation.getAttribute("innerText");
                                }
                                if (Test_Cases.conf_SystemClient.equals("OGQ_100")) {
                                    WebElement elm = driver.findElement(By.ByXPath.xpath("//tr[contains(@vpm, 'mrss-cont')]/td[2]/div/div[contains(@bisposelement, 'X')][@class='urBorderBox']/table/tbody/tr/td[" + ColumnCount + "]/div/span/span"));
                                    field_StorageLocation = elm;
                                    inputValue5 = field_StorageLocation.getAttribute("innerText");
                                }


                                if (!(inputValue5 != null || inputValue5.contains(auto_cell_StorgLocatn))) {

                                    logger.error("STORAGE LOCATION input field has NO AUTOFILLED VALUE!");
                                    neededColumns++;
                                } else {
                                    if (inputValue5.equalsIgnoreCase(auto_cell_StorgLocatn)) {
                                        logger.info("STORAGE LOCATION input field is AUTOFILLED with the value '" + inputValue5 + "'.");
                                    } else {
                                        logger.warn("STORAGE LOCATION input field is AUTOFILLED with the value '" + inputValue5 + "'. EXPECTED value should be '" + auto_cell_StorgLocatn + "'!");
                                    }
                                    neededColumns++;
                                }
                                break;


                            case "Valuation Type":

                                //Find input field below the "Quantity" column title and check whether the input field is enabled/editable
                                //OFQ//WebElement field_BaseUOF = driver.findElement(By.ByXPath.xpath("//tr[@class=' urST5SelColUiGeneric'][contains(@vpm, 'mrss-cont')]/td[2]/div/div[contains(@bisposelement, 'X')][@class='urBorderBox']/table/tbody/tr/td[" + ColumnCount + "]/div/span/span"));
                                WebElement field_ValuationType = null;
                                String inputValue6 = "";

                                //Find input field below the "Plant" column title and check whether the input field is enabled/editable
                                if (Test_Cases.conf_SystemClient.equals("OFQ_100")) {
                                    WebElement elm = driver.findElement(By.ByXPath.xpath("//tr[contains(@vpm, 'mrss-cont')]/td[2]/div/div[contains(@bisposelement, 'X')][@class='urBorderBox']/table/tbody/tr/td[" + ColumnCount + "]/div/span/span"));
                                    field_ValuationType = elm;
                                    inputValue6 = field_ValuationType.getAttribute("innerText");
                                }
                                if (Test_Cases.conf_SystemClient.equals("OGQ_100")) {
                                    WebElement elm = driver.findElement(By.ByXPath.xpath("//tr[contains(@vpm, 'mrss-cont')]/td[2]/div/div[contains(@bisposelement, 'X')][@class='urBorderBox']/table/tbody/tr/td[" + ColumnCount + "]/div/span/span"));
                                    field_ValuationType = elm;
                                    inputValue6 = field_ValuationType.getAttribute("innerText");
                                }


                                if (!(inputValue6 != null || inputValue6.contains(auto_cell_ValtnType))) {

                                    logger.error("VALUATION TYPE input field has NO AUTOFILLED VALUE!");
                                    neededColumns++;
                                } else {
                                    if (inputValue6.equalsIgnoreCase(auto_cell_ValtnType)) {
                                        logger.info("VALUATION TYPE input field is AUTOFILLED with the value '" + inputValue6 + "'.");
                                    } else {
                                        logger.warn("VALUATION TYPE input field is AUTOFILLED with the value '" + inputValue6 + "'. EXPECTED value should be '" + auto_cell_ValtnType + "'!");
                                    }
                                    neededColumns++;
                                }
                                break;

                            case "Handling Type":

                                //Find input field below the "Quantity" column title and check whether the input field is enabled/editable
                                //OFQ//WebElement field_BaseUOF = driver.findElement(By.ByXPath.xpath("//tr[@class=' urST5SelColUiGeneric'][contains(@vpm, 'mrss-cont')]/td[2]/div/div[contains(@bisposelement, 'X')][@class='urBorderBox']/table/tbody/tr/td[" + ColumnCount + "]/div/span/span"));
                                WebElement field_HandlingType = null;
                                String inputValue7 = "";

                                //Find input field below the "Plant" column title and check whether the input field is enabled/editable
                                if (Test_Cases.conf_SystemClient.equals("OFQ_100")) {
                                    WebElement elm = driver.findElement(By.ByXPath.xpath("//tr[contains(@vpm, 'mrss-cont')]/td[2]/div/div[contains(@bisposelement, 'X')][@class='urBorderBox']/table/tbody/tr/td[" + ColumnCount + "]/div/span/span"));
                                    field_HandlingType = elm;
                                    inputValue7 = field_HandlingType.getAttribute("innerText");
                                }
                                if (Test_Cases.conf_SystemClient.equals("OGQ_100")) {
                                    WebElement elm = driver.findElement(By.ByXPath.xpath("//tr[contains(@vpm, 'mrss-cont')]/td[2]/div/div[contains(@bisposelement, 'X')][@class='urBorderBox']/table/tbody/tr/td[" + ColumnCount + "]/div/span/span"));
                                    field_HandlingType = elm;
                                    inputValue7 = field_HandlingType.getAttribute("innerText");
                                }


                                if (!(inputValue7 != null || inputValue7.contains(cell_HandlingType))) {

                                    logger.error("HANDLING TYPE input field has NO AUTOFILLED VALUE!");
                                    neededColumns++;
                                } else {
                                    if (inputValue7.equalsIgnoreCase(cell_HandlingType)) {
                                        logger.info("HANDLING TYPE input field is AUTOFILLED with the value '" + inputValue7 + "'.");
                                    } else {
                                        logger.warn("HANDLING TYPE input field is AUTOFILLED with the value '" + inputValue7 + "'. EXPECTED value should be '" + cell_HandlingType + "'!");
                                    }
                                    neededColumns++;
                                }
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


    public void filling_NetPriceField(String cell_NetPrice) throws Exception {

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
                if (neededColumns <= 1) {
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

                        if (name_TableColumn.contains("Net Price")) {
                            name_TableColumn = "Net Price";
                        }

                        switch (name_TableColumn) {

                            case "Net Price":


                                //check whether this column is within the screen boundaries and scroll to the column
                                bringElementIntoViewHorizontally("Net Price");

                                //Find input field below the "Material" column title and check whether the input field is enabled/editable
                                WebElement field_NetPrice = driver.findElement(By.ByXPath.xpath("//tr[contains(@vpm, 'mrss-cont')]/td[2]/div/div[contains(@bisposelement, 'X')][@class='urBorderBox']/table/tbody/tr/td[" + ColumnCount + "]/div/span"));

                                String inputStatus1 = field_NetPrice.getAttribute("class");

                                //OFQ//if (!inputStatus1.contains("lsField--disabled")) {
                                if (!inputStatus1.contains("readonly")) {
                                    //scroll the field to be visible (if outside of vision portal) and click on it

                                    //field_NetPrice.click();
                                    js.executeScript("arguments[0].click();", field_NetPrice);

                                    //Provide value into the "Net Price" input field
                                    WebElement input_NetPrice_Span = driver.findElement(By.ByXPath.xpath("//tr[contains(@vpm, 'mrss-cont')]/td[2]/div/div[contains(@bisposelement, 'X')][@class='urBorderBox']/table/tbody/tr/td[" + ColumnCount + "]/div/span"));
                                    WebElement input_NetPrice_input = input_NetPrice_Span.findElement(By.xpath("input"));
                                    input_NetPrice_input.clear();
                                    //input_NetPrice.sendKeys("10");
                                    //js.executeScript("arguments[0].value='10,00';", input_NetPrice_input);
                                    // Thread.sleep(1000);
                                    // input_NetPrice_input.sendKeys(Keys.ENTER);

                                    action.sendKeys(input_NetPrice_input, cell_NetPrice).sendKeys(Keys.ENTER).perform();

                                    logger.info("NET PRICE input field is SUCCESSFULLY filled in.");
                                    neededColumns++;
                                } else {
                                    logger.error("NET PRICE input field is in DISABLED status!");
                                    neededColumns++;
                                }
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

    public void clickFirstRow_InvokeDetailsSection() {
        try {
            //click to select the first completed row in the "Add Item" table
            //js.executeScript("arguments[0].click();", table_FirstCompletedRow);
            table_FirstCompletedRow.click();

            //Wait/locate the "Details" section on the page
            explicitWaitsUntilElementPresent(30, "//table[contains (@class, 'lsHTMLContainer')][contains(@ct, 'SC')]/tbody/tr/td/div/div[contains (@class, 'urBorderBox')][1]/table/tbody/tr[5]/td/div/table/tbody/tr/td[contains (@class, 'lsContainerCell lsGLCTopVAlign lsContainerCellVAlign--top')]/table[@class='lsPanel urHtmlTableReset'][contains(@ct, 'P')]", "DETAIL DATA Section");

            //if necessary bring into view vertically the "Detail Data"
            // bringElementIntoViewVertically("//span[contains(text(), 'Detail Data')]/ancestor::table[@class='lsPanel urHtmlTableReset'][contains (@ct, 'P')]");
            //bringElementIntoViewVertically("//div[contains(@ct, 'PAGE')][contains (@role, 'main')]/div[1]/table/tbody/tr[2]");
            js.executeScript("arguments[0].scrollIntoView();", table_DetailData);

        } catch (Exception e) {
            logger.error("Error while clicking on the first completed row in the 'Add Item' table: " + e.getMessage());
        }
    }


    public void click_toOpenPurchasingTab() {
        try {
            //Click on "Transfer Posting" tab
            js.executeScript("arguments[0].click();", tab_Purchasing);

            //Wait for the "Purchasing" tab's contents to load
            explicitWaitsUntilElementPresent(30, "//span[text()='Purchasing Doc. Type']", "PURCHASING TAB Content");

        } catch (Exception e) {
            logger.error("Error while clicking on the 'TRANSFER POSTING' tab: " + e.getMessage());
        }
    }

    public boolean openPurchasingTab() {
        boolean openStatus = false;
        try {

            //Click on "Purchasing" tab
            js.executeScript("arguments[0].click();", tab_Purchasing);
            // tab_TransferPosting.click();

            //Wait for the "Purchasing" tab's contents to load
            //explicitWaitsUntilElementPresent(30, "//table[@class='urMatrixLayout urHtmlTableReset'][contains(@ct, 'ML')]/tbody[@class='urLinStd']/tr[1]/td[@class='lsContainerCell lsContainerCellVAlign--top urLayoutPadless'][contains(@ct, 'MLC')]/div[@class='lsRasterLayout'][contains(@ct, 'RL')]", "TRANSFER POSTING TAB Content");
            //explicitWaitsUntilElementPresent(30, "//table[@class='urMatrixLayout urHtmlTableReset'][contains(@ct, 'ML')]/tbody[@class='urLinStd']/tr[1]/td[contains (@class, 'lsContainerCell lsContainerCellVAlign--top urLayoutPadless')][contains(@ct, 'MLC')]", "TRANSFER POSTING TAB Content");
            explicitWaitsUntilElementPresent(30, "//span[contains (text(), 'Purchasing Doc. Type')]", "PURCHASING TAB Content");


            Thread.sleep(2000);

            openStatus = true;
            //Find "Plant of Stock Transfer" and "Storage Location of Stock Transfer" fields, clean them and enter values

        } catch (Exception e) {
            logger.error("Error while clicking/opening the 'Transfer Posting' tab: " + e.getMessage());
        }

        return openStatus;
    }

    public void checkVehicleTab_isOpen() {

        try {

            WebElement tab_Vehicle = driver.findElement(By.xpath("//span[contains (text(), 'Header Data')]/ancestor::table[contains (@class, 'lsPanel urHtmlTableReset')][1]/tbody/tr[2]/descendant::div[contains (text(), 'Vehicle')]/ancestor::div[1]"));

            String classValue = tab_Vehicle.getAttribute("class");
            System.out.println("The CLASS value for 'VEHICLE' tab is: " + classValue);

            if (!classValue.contains("ItemSel")) {

                //Click on "Vehicle" tab
                js.executeScript("arguments[0].click();", tab_Vehicle);
                // tab_TransferPosting.click();

                //Wait for the "Vehicle" tab's contents to load
                //explicitWaitsUntilElementPresent(30, "//table[@class='urMatrixLayout urHtmlTableReset'][contains(@ct, 'ML')]/tbody[@class='urLinStd']/tr[1]/td[@class='lsContainerCell lsContainerCellVAlign--top urLayoutPadless'][contains(@ct, 'MLC')]/div[@class='lsRasterLayout'][contains(@ct, 'RL')]", "TRANSFER POSTING TAB Content");
                //explicitWaitsUntilElementPresent(30, "//table[@class='urMatrixLayout urHtmlTableReset'][contains(@ct, 'ML')]/tbody[@class='urLinStd']/tr[1]/td[contains (@class, 'lsContainerCell lsContainerCellVAlign--top urLayoutPadless')][contains(@ct, 'MLC')]", "TRANSFER POSTING TAB Content");
                explicitWaitsUntilElementPresent(30, "//span[contains (text(), 'Header Data')]/ancestor::table[contains (@class, 'lsPanel urHtmlTableReset')][1]/descendant::table[contains (@ct, 'TS_standards')][contains (@class, 'lsTbsPanelDesign lsPanel')]/tbody/tr[3]/descendant::input[contains (@title, 'Vehicle No')]", "VEHICLE TAB Content");

                Thread.sleep(2000);

            }

        } catch (Exception e) {
            logger.error("Error while clicking/opening the 'VEHICLE' tab: " + e.getMessage());
        }
    }



    public void check_PlantForVehicle_notEmpty () {

        try {

           // WebElement input_PlantForVehicle = driver.findElement(By.xpath("//span[contains (text(), 'Plant for Vehicle')]/parent::tr[1]/td[3]/descendant::input"));

            WebElement input_PlantForVehicle = driver.findElement(By.xpath("//div[text()= 'Vehicle'][contains (@class, 'lsTbsv5-ItemTitle')]/ancestor::table[contains (@ct, 'TS_standards')][contains (@class, 'lsTbsPanelDesign lsPanel')]/tbody/tr[3]/td/div[1]/descendant::table[contains (@class, 'urFontStd urHtmlTableReset')]/tbody/tr[2]/td[3]/descendant::input"));


            String value_PlantForVehicle = input_PlantForVehicle.getAttribute("value");
            System.out.println("The 'value' property of 'Plant for Vehicle' input is: " + value_PlantForVehicle);

            if (value_PlantForVehicle == null) {
                logger.warn("The PLANT FOR VEHICLE input has NOT BEEN AUTOFILLED after providing value in 'Vehicle Number' input on HEADER DATA section -> VEHICLE tab!");

            } else {
                logger.info("The PLANT FOR VEHICLE input has been autofilled with value: " + value_PlantForVehicle);
            }

        } catch (Exception e) {
            logger.warn("Unable to retrieve value from the 'PLANT FOR VEHICLE' input: " + e.getMessage());
        }
    }


    public void check_StorageLocationForVehicle_notEmpty () {

        try {

            WebElement input_StorageLocationForVehicle = driver.findElement(By.xpath("//div[text()= 'Vehicle'][contains (@class, 'lsTbsv5-ItemTitle')]/ancestor::table[contains (@ct, 'TS_standards')][contains (@class, 'lsTbsPanelDesign lsPanel')]/tbody/tr[3]/td/div[1]/descendant::table[contains (@class, 'urFontStd urHtmlTableReset')]/tbody/tr[3]/td[3]/descendant::input"));

            String value_input_StorageLocationForVehicleForVehicle = input_StorageLocationForVehicle.getAttribute("value");
            System.out.println("The 'value' property of 'Storage Location for Vehicle' input is: " + value_input_StorageLocationForVehicleForVehicle);

            if (value_input_StorageLocationForVehicleForVehicle == null) {
                logger.warn("The STORAGE LOCATION FOR VEHICLE input has NOT BEEN AUTOFILLED after providing value in 'Vehicle Number' input on HEADER DATA section -> VEHICLE tab!");

            } else {
                logger.info("The STORAGE LOCATION FOR VEHICLE input has been autofilled with value: " + value_input_StorageLocationForVehicleForVehicle);
            }

        } catch (Exception e) {
            logger.warn("Unable to retrieve value from the 'STORAGE LOCATION FOR VEHICLE' input: " + e.getMessage());
        }
    }


    public boolean popup_OverviewRefObject_isOpen() {

        boolean popup_Displayed = false;

        try {

            // Wait till the main page gets updated
            waitForExtAjaxIsReadyState(15, "MAIN PAGE after providing 'VEHICLE NUMBER'");

           WebElement iframe_OverviewRefObject = driver.findElement(By.xpath("//iframe[contains(@name,'URLSPW-0')]"));

            String status_iFrame = iframe_OverviewRefObject.getAttribute("inuse");
            System.out.println("The 'inuse' status of iFrame is: " + status_iFrame);

            if (status_iFrame.contains("true")) {
                //When using an iframe, you will first have to switch to the iframe, before selecting the elements of that iframe.
                driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@name,'URLSPW-0')]")));

                WebElement popup_OverviewRefObject = driver.findElement(By.xpath("//div[contains (text(), 'Overview for the Reference Object')]"));
                popup_Displayed = true;

                driver.switchTo().defaultContent();
            } else {
                logger.warn("The OVERVIEW FOR THE REFERENCE OBJECT popup was NOT DETECTED as displayed after filling in 'Vehicle Number' input on HEADER DATA section -> VEHICLE tab.");
            }


        } catch (Exception e) {
            logger.warn("The OVERVIEW FOR THE REFERENCE OBJECT popup was NOT DETECTED as displayed after filling in 'Vehicle Number' input on HEADER DATA section -> VEHICLE tab: " + e.getMessage());

            driver.switchTo().defaultContent();

        }
        return popup_Displayed;
    }


    public void fillIn_VehicleNumber(String input_VehicleNumber) {
        try {

            WebElement dropdown_VehicleNumber = driver.findElement(By.xpath("//span[contains (text(), 'Header Data')]/ancestor::table[contains (@class, 'lsPanel urHtmlTableReset')][1]/descendant::table[contains (@ct, 'TS_standards')][contains (@class, 'lsTbsPanelDesign lsPanel')]/tbody/tr[3]/descendant::input[contains (@title, 'Vehicle No')]"));

            //click on "Vehicle Number" field to open its dropdown
            js.executeScript("arguments[0].click();", dropdown_VehicleNumber);
            //dropdown_DocNumber.click();

            //Wait till "Vehicle Number" field change its status to FOCUS SET
            waitTillElementDetectedByProperty(15, "//span[contains (text(), 'Header Data')]/ancestor::table[contains (@class, 'lsPanel urHtmlTableReset')][1]/descendant::table[contains (@ct, 'TS_standards')][contains (@class, 'lsTbsPanelDesign lsPanel')]/tbody/tr[3]/descendant::input[contains (@title, 'Vehicle No')]/ancestor::table[1]", "class", "lsField--focus", "INPUT 'VEHICLE NUMBER' EDITABLE");
            Thread.sleep(2000);

            //Clean "Vehicle Number" field
            //input_PlantOfStockTransferEditable.clear();
            js.executeScript("arguments[0].value ='';", dropdown_VehicleNumber);


            //Enter value into "Vehicle Number" field and click ENTER
            js.executeScript("arguments[0].value='" + input_VehicleNumber + "';", dropdown_VehicleNumber);
            dropdown_VehicleNumber.sendKeys(Keys.ENTER);
            // action.sendKeys(input_PlantOfStockTransferEditable, "GP01").sendKeys(Keys.RETURN).perform();

            logger.info("VEHICLE NUMBER input field is SUCCESSFULLY filled in with value: " + input_VehicleNumber.toUpperCase());

            Thread.sleep(2000);

        } catch (Exception e) {
            logger.error("Error while filling in 'Vehicle Number' input on HEADER DATA section -> VEHICLE tab: " + e.getMessage());
        }
    }


    public void fillIn_SlockOfStockTransfer(String input_SlockOfStockTrnsfr) {
        try {
            //Find "SLock of Stock Transfer" field and click on it
            js.executeScript("arguments[0].click();", input_SlockOfStockTransfer);

            //Wait till "SLock of Stock Transfer" field change its status to FOCUS SET
            waitTillElementDetectedByProperty(40, "//span[text()='SLoc of Stock Transfer']/ancestor::tr[1]/descendant::input[contains (@title, 'SLoc of Stock Transfer')][contains (@class, 'lsField__input')]/ancestor::table[1]", "class", "lsField--focus", "INPUT 'SLOCK OF STOCK TRANSFER' EDITABLE");

            //Clean "SLock of Stock Transfer" field
            //input_PlantOfStockTransferEditable.clear();
            js.executeScript("arguments[0].value ='';", input_SlockOfStockTransfer);


            //Enter value into "SLock of Stock Transfer" field and click ENTER
            js.executeScript("arguments[0].value='" + input_SlockOfStockTrnsfr + "';", input_SlockOfStockTransfer);
            input_SlockOfStockTransfer.sendKeys(Keys.ENTER);
            // action.sendKeys(input_PlantOfStockTransferEditable, "GP01").sendKeys(Keys.RETURN).perform();

            logger.info("SLOCK OF STOCK TRANSFER input field is SUCCESSFULLY filled in.");

            Thread.sleep(2000);

            //Check whether the following fields were auto-filled i.e. "Acct. Assignment Cat.", "Price Date", "Time", "Handling Type" (i.e. the fields should not be empty)
            autofill_RestOfFields();


        } catch (Exception e) {
            logger.error("Error while filling in 'Purchasing Organization' input on DETAIL DATA section -> PURCHASING tab: " + e.getMessage());
        }
    }

    public void autofill_RestOfFields() {
        try {
            //Read the value of the "Acct. Assignment Cat." field
            String value_AcctAssignmentCat = input_AcctAssignmentCat.getAttribute("value");
            System.out.println("The 'Acct. Assignment Cat.' field is auto-filled with the value: " + value_AcctAssignmentCat);

            //Read the value of the "Price Date" field
            String value_PriceDate = input_PriceDate.getAttribute("value");
            System.out.println("The 'Price Date' field is auto-filled with the value: " + value_PriceDate);

            //Read the value of the "Input Time" field
            String value_InputTime = input_Time.getAttribute("value");
            System.out.println("The 'Input Time' field is auto-filled with the value: " + value_InputTime);

            //Read the value of the "Handling Type" field
            String value_HandlingType = input_HandlingType.getAttribute("value");
            System.out.println("The 'Handling Type' field is auto-filled with the value: " + value_HandlingType);


            //Check whether the value is not equal to NULL in the "Acct. Assignment Cat." field
            if (value_AcctAssignmentCat.contains("") || value_AcctAssignmentCat.equals(null)) {
                logger.info("ACCT. ASSIGNMENT CAT. input field is EMPTY as aspected (i.e. no auto-fill).");
            } else {
                logger.error("ACCT. ASSIGNMENT CAT. input field was auto-filled with value '" + value_AcctAssignmentCat + "' after providing a value into the 'SLOCK OF STOCK TRANSFER' field! However, it should remain blank.");
            }

            //Check whether the value is not equal to NULL in the "Price Date" field
            if (!value_PriceDate.contains("") || !value_PriceDate.equals(null)) {
                logger.info("PRICE DATE input field is SUCCESSFULLY auto-filled with the value: " + value_PriceDate);
            } else {
                logger.error("PRICE DATE input field was NOT auto-filled after providing a value into the 'SLOCK OF STOCK TRANSFER' field!");
            }

            //Check whether the value is not equal to NULL in the "Input Time" field
            if (!value_InputTime.contains("") || !value_InputTime.equals(null)) {
                logger.info("INPUT TIME input field is SUCCESSFULLY auto-filled with the value: " + value_InputTime);
            } else {
                logger.error("INPUT TIME input field was NOT auto-filled after providing a value into the 'SLOCK OF STOCK TRANSFER' field!");
            }

            //Check whether the value is not equal to NULL in the "Handling Type" field
            if (!value_HandlingType.contains("") || !value_HandlingType.equals(null)) {
                logger.info("HANDLING TYPE input field is SUCCESSFULLY auto-filled with the value: " + value_HandlingType);
            } else {
                logger.error("HANDLING TYPE input field was NOT auto-filled after providing a value into the 'SLOCK OF STOCK TRANSFER' field!");
            }

        } catch (Exception e) {
            logger.error("Error while accessing/reading values in the DOCUMENT ITEM section in DETAIL DATA table -> PURCHASING tab: " + e.getMessage());
        }
    }

    public void fillIn_PurchasingOrganization(String input_PurchsngOrganization) {
        try {

            if (Test_Cases.conf_SystemClient.equals("OGQ_100")) {
                //Find "Purchasing Organization" field and click on it
                js.executeScript("arguments[0].click();", input_PurchasingOrganization);

                //Wait till "Purchasing Organization" field change its status to FOCUS SET
                waitTillElementDetectedByProperty(40, "//span[text()='Purch. Organization']/ancestor::tr[1]/descendant::input[contains (@title, 'POrg')][contains (@class, 'lsField__input')]/ancestor::table[1]", "class", "lsField--focus", "INPUT 'PURCHASING ORGANIZATION' EDITABLE");

                //Clean "Purchasing Organization" field
                //input_PlantOfStockTransferEditable.clear();
                js.executeScript("arguments[0].value ='';", input_PurchasingOrganization);


                //Enter value into "Purcasing Organization" field and click ENTER
                js.executeScript("arguments[0].value='" + input_PurchsngOrganization + "';", input_PurchasingOrganization);
                input_PurchasingOrganization.sendKeys(Keys.ENTER);
                // action.sendKeys(input_PlantOfStockTransferEditable, "GP01").sendKeys(Keys.RETURN).perform();

                logger.info("PURCHASING ORGANIZATION input field is SUCCESSFULLY filled in.");

                Thread.sleep(2000);

                //Check whether the "Purchasing Doc. Type" field was auto-filled (i.e. is not empty)
                autofill_PurchDocType();
            }


            if (Test_Cases.conf_SystemClient.equals("OFQ_100")) {

                WebElement input_PurchasingOrganization = driver.findElement(By.xpath("//span[text()='Purch. organization']/ancestor::tr[1]/descendant::input[contains (@title, 'POrg')][contains (@class, 'lsField__input')]"));

                //Find "Purchasing Organization" field and click on it
                js.executeScript("arguments[0].click();", input_PurchasingOrganization);

                //Wait till "Purchasing Organization" field change its status to FOCUS SET
                waitTillElementDetectedByProperty(40, "//span[text()='Purch. organization']/ancestor::tr[1]/descendant::input[contains (@title, 'POrg')][contains (@class, 'lsField__input')]/ancestor::table[1]", "class", "lsField--focus", "INPUT 'PURCHASING ORGANIZATION' EDITABLE");

                //Clean "Purchasing Organization" field
                //input_PlantOfStockTransferEditable.clear();
                js.executeScript("arguments[0].value ='';", input_PurchasingOrganization);


                //Enter value into "Purcasing Organization" field and click ENTER
                js.executeScript("arguments[0].value='" + input_PurchsngOrganization + "';", input_PurchasingOrganization);
                input_PurchasingOrganization.sendKeys(Keys.ENTER);
                // action.sendKeys(input_PlantOfStockTransferEditable, "GP01").sendKeys(Keys.RETURN).perform();

                logger.info("PURCHASING ORGANIZATION input field is SUCCESSFULLY filled in.");

                Thread.sleep(2000);

                //Check whether the "Purchasing Doc. Type" field was auto-filled (i.e. is not empty)
                autofill_PurchDocType();
            }


        } catch (Exception e) {
            logger.error("Error while filling in 'Purchasing Organization' input on DETAIL DATA section -> PURCHASING tab: " + e.getMessage());
        }
    }


    public void autofill_PurchDocType() {
        try {

            //  if (Test_Cases.conf_SystemClient.equals("OGQ_100")) {
            //Read the value of the "Purchasing Doc. Type" field
            String value_PurchDocType = input_PurchasingDocType.getAttribute("value");
            System.out.println("The 'Purchasing Doc. Type' field is auto-filled with the value: " + value_PurchDocType);

            //Check whether the value is not equal to NULL
            if (!value_PurchDocType.contains("") || !value_PurchDocType.equals(null)) {
                logger.info("PURCHASING DOC. TYPE input field is SUCCESSFULLY auto-filled with the value: " + value_PurchDocType);
            } else {
                logger.error("PURCHASING DOC. TYPE input field was NOT auto-filled after providing a value into the 'PURCHASING ORGANIZATION' field!");
            }
            //  }

           /* if (Test_Cases.conf_SystemClient.equals("OFQ_100")) {

                WebElement input_PurchasingDocType = driver.findElement(By.xpath("//span[text()='Purchasing Doc. Type']/ancestor::tr[1]/descendant::input[contains (@title, 'Type')][contains (@class, 'lsField__input')]"));

                //Read the value of the "Purchasing Doc. Type" field
                String value_PurchDocType = input_PurchasingDocType.getAttribute("value");
                System.out.println("The 'Purchasing Doc. Type' field is auto-filled with the value: " + value_PurchDocType);

                //Check whether the value is not equal to NULL
                if (!value_PurchDocType.contains("") || !value_PurchDocType.equals(null)) {
                    logger.info("PURCHASING DOC. TYPE input field is SUCCESSFULLY auto-filled with the value: " + value_PurchDocType);
                } else {
                    logger.error("PURCHASING DOC. TYPE input field was NOT auto-filled after providing a value into the 'PURCHASING ORGANIZATION' field!");
                }

            }*/

        } catch (Exception e) {
            logger.error("Error while accessing/reading value in 'Purchasing Doc. Type' input on DETAIL DATA section -> PURCHASING tab: " + e.getMessage());
        }
    }


    public void fillIn_PurchasingGroup(String input_PurchsngGroup) {
        try {

            if (Test_Cases.conf_SystemClient.equals("OGQ_100")) {

                //Find "Purchasing Group" field and click on it
                js.executeScript("arguments[0].click();", input_PurchasingGroup);

                //Wait till "Purchasing Group" field change its status to FOCUS SET
                waitTillElementDetectedByProperty(40, "//span[text()='Purchasing group']/ancestor::tr[1]/descendant::input[contains (@title, 'PGr')][contains (@class, 'lsField__input')]/ancestor::table[1]", "class", "lsField--focus", "INPUT 'PURCHASING GROUP' EDITABLE");

                //Clean "Purchasing Group" field
                //input_PlantOfStockTransferEditable.clear();
                js.executeScript("arguments[0].value ='';", input_PurchasingGroup);


                //Enter value into "Purcasing Group" field and click ENTER
                js.executeScript("arguments[0].value='" + input_PurchsngGroup + "';", input_PurchasingGroup);
                input_PurchasingGroup.sendKeys(Keys.ENTER);
                // action.sendKeys(input_PlantOfStockTransferEditable, "GP01").sendKeys(Keys.RETURN).perform();

                logger.info("PURCHASING GROUP input field is SUCCESSFULLY filled in.");
            }


            if (Test_Cases.conf_SystemClient.equals("OFQ_100")) {

                WebElement input_PurchasingGroup = driver.findElement(By.xpath("//span[text()='Purchasing Group']/ancestor::tr[1]/descendant::input[contains (@title, 'PGr')][contains (@class, 'lsField__input')]"));

                //Find "Purchasing Group" field and click on it
                js.executeScript("arguments[0].click();", input_PurchasingGroup);

                //Wait till "Purchasing Group" field change its status to FOCUS SET
                waitTillElementDetectedByProperty(40, "//span[text()='Purchasing Group']/ancestor::tr[1]/descendant::input[contains (@title, 'PGr')][contains (@class, 'lsField__input')]/ancestor::table[1]", "class", "lsField--focus", "INPUT 'PURCHASING GROUP' EDITABLE");

                //Clean "Purchasing Group" field
                //input_PlantOfStockTransferEditable.clear();
                js.executeScript("arguments[0].value ='';", input_PurchasingGroup);


                //Enter value into "Purcasing Group" field and click ENTER
                js.executeScript("arguments[0].value='" + input_PurchsngGroup + "';", input_PurchasingGroup);
                input_PurchasingGroup.sendKeys(Keys.ENTER);
                // action.sendKeys(input_PlantOfStockTransferEditable, "GP01").sendKeys(Keys.RETURN).perform();

                logger.info("PURCHASING GROUP input field is SUCCESSFULLY filled in.");

            }

        } catch (Exception e) {
            logger.error("Error while filling in 'Purchasing Group' input on DETAIL DATA section -> PURCHASING tab: " + e.getMessage());
        }
    }

    public void fillIn_SupplyingPlant(String input_SpplyPlant) {
        try {
            //Find "Supplying Plant" field and click on it
            js.executeScript("arguments[0].click();", input_SupplyingPlant);

            //Wait till "Supplying Plant" field change its status to FOCUS SET
            waitTillElementDetectedByProperty(40, "//input[contains (@title, 'SPlt')][contains (@class, 'lsField__input')]/ancestor::table[1]", "class", "lsField--focus", "INPUT 'SUPPLYING PLANT' EDITABLE");

            //Clean "Supplying Plant" field
            //input_PlantOfStockTransferEditable.clear();
            js.executeScript("arguments[0].value ='';", input_SupplyingPlant);


            //Enter value into "Supplying Plant" field and click ENTER
            js.executeScript("arguments[0].value='" + input_SpplyPlant + "';", input_SupplyingPlant);
            input_SupplyingPlant.sendKeys(Keys.ENTER);
            // action.sendKeys(input_PlantOfStockTransferEditable, "GP01").sendKeys(Keys.RETURN).perform();

            logger.info("SUPPLYING PLANT input field is SUCCESSFULLY filled in.");

        } catch (Exception e) {
            logger.error("Error while filling in 'Supplying Plant' input on DETAIL DATA section -> PURCHASING tab: " + e.getMessage());
        }
    }

    public void fillIn_StockInTransit() {
        try {
            //Find "Stock Transfer in Stock in Transit" check-box and check if it is unselected
            String status_ChkBox = chkbox_StockInTransit.getAttribute("class");
            System.out.println("Status for 'Stock Transfer in Stock in Transit' check-box is: " + status_ChkBox);

            if (status_ChkBox.contains("unchecked")) {// if the check-box is not selected then click on it to select
                js.executeScript("arguments[0].click();", chkbox_StockInTransit);
                //action.click(chkbox_StockInTransit.findElement(By.xpath("input"))).perform();

                logger.info("STOCK TRANSFER IN STOCK IN TRANSIT check-box is SUCCESSFULLY selected.");
            } else {

                logger.warn("STOCK TRANSFER IN STOCK IN TRANSIT check-box might have already been selected BY DEFAULT!");

            }

        } catch (Exception e) {
            logger.error("Error while selecting 'Stock Transfer in Stock in Transit' check-box on DETAIL DATA section -> PURCHASING tab: " + e.getMessage());
        }
    }


    public void bringElementIntoViewVertically(String xPath) {

        try {

            int offset_Value = 0;
            WebElement el1 = driver.findElement(By.xpath(xPath));

/*
        // java - get screen size using the Toolkit class
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        // the screen height
            int screenHeight = screenSize.height;
            System.out.println("Screen HEIGHT is: " + screenHeight);

            // the screen width
            int screenWidth = screenSize.width;
            System.out.println("Screen WIDTH is: " + screenWidth);*/

            //Get Browser window height
            int contentHeight = ((Number) js.executeScript("return window.innerHeight")).intValue();
            System.out.println("Browser window height Is " + contentHeight + " pixels");

            //Get Browser window width
            // int contentWidth = ((Number) js.executeScript("return window.innerWidth")).intValue();
            // System.out.println("Browser window width Is " + contentWidth + " pixels");

            Point point = el1.getLocation();

            //Get element's X location
            //int element_X = point.getX();
            //System.out.println("Element's Position from left side is: " + point.getX() + " pixels.");

            //Get element's Y location
            int element_Y = point.getY();
            System.out.println("Element's Position from top is: " + point.getY() + " pixels.");

            //Get width of element.
            // int elementWidth = table_AddItem.getSize().getWidth();
            //System.out.println("Element width Is " + elementWidth + " pixels");

            //Get height of element.
            int elementHeight = el1.getSize().getHeight();
            System.out.println("Element height Is " + elementHeight + " pixels");

            //End coordinate of Web element on X axis
            //int total_X = element_X + contentWidth;

            //End coordinate of Web element on Y axis
            int total_Y = element_Y + contentHeight;

            if (element_Y >= contentHeight) {

                //System.out.println("COLUMN DIV DETECTED!!!");
                //js.executeScript("arguments[0].scrollIntoView();", table_AddItem);

                //Get offset between browser width and element location
                offset_Value = element_Y + elementHeight - contentHeight;
                System.out.println("Offset between browser height and the outbordered element: " + offset_Value + " pixels");

                offset_Value = (int) Math.round(offset_Value);
                System.out.println("Offset for SLIDER in case of outbordered element: " + offset_Value + " pixels");

                //js.executeScript("window.scroll(140, %s)", webElement );
                // js.executeScript("arguments[0].scrollIntoView();",el1);
                js.executeScript("window.scrollBy(0," + offset_Value + ")", "");
            } else {

                //if element is partly outside of view port then calculate how many pixels are needed to bring it into the view
                if (element_Y < contentHeight && element_Y + elementHeight > contentHeight) {

                    //Get offset between browser height and partly visible element
                    offset_Value = contentHeight - element_Y;
                    offset_Value = elementHeight - offset_Value;
                    offset_Value = (int) Math.round(offset_Value);
                    System.out.println("Offset between browser height and the partly outbordered element: " + offset_Value + " pixels");

                    // js.executeScript("window.scroll(0, "+offset_Value+")", el1 );
                    //js.executeScript("arguments[0].scrollIntoView();",el1);
                    //js.executeScript("document.scrollBy(0, "+offset_Value+")", "");

                    //Body page element
                    WebElement el2 = driver.findElement(By.xpath("//div[contains(@ct, 'PAGE')][contains (@role, 'main')]/div[1]/table/tbody/tr[2]"));
                    action.moveToElement(el2);
                    action.moveByOffset(0, offset_Value);
                    action.release();
                    action.perform();
                    Thread.sleep(10000);
                }
            }

        } catch (Exception e) {
            logger.error("Error while bringing element into view vertically on the screen : " + e.getMessage());
        }

    }


    public void bringElementIntoViewHorizontally(String columnTitle) {
        try {

            //Column title in every column of the right-hand part of "Add Item" table
            WebElement el1 = driver.findElement(By.xpath("//td/div/span/span[text()='" + columnTitle + "']/ancestor::td[1]"));

            //Horizontal slider in the second part of "Add Item" table
            WebElement webElement = driver.findElement(By.xpath("//td[@class='urSCBBdy lsScrollbar__track urBorderBox urSCBDimHeight'][contains(@acf, 'PNext')]/span[@class='urSCBBdr lsScrollbar__thumb urBorderBox urSCBHHdl urSCBDimHeight'][contains (@acf, 'Hndl')]/span[@class='urSCBBtn urBorderBox urSCBGrip']"));
            System.out.println("COLUMN DIV DETECTED!!!");

            int offset_Value = 0;


/*
        // java - get screen size using the Toolkit class
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        // the screen height
            int screenHeight = screenSize.height;
            System.out.println("Screen HEIGHT is: " + screenHeight);

            // the screen width
            int screenWidth = screenSize.width;
            System.out.println("Screen WIDTH is: " + screenWidth);*/

            //Get Browser window height
            int contentHeight = ((Number) js.executeScript("return window.innerHeight")).intValue();
            System.out.println("Browser window height Is " + contentHeight + " pixels");

            //Get Browser window width
            int contentWidth = ((Number) js.executeScript("return window.innerWidth")).intValue();
            System.out.println("Browser window width Is " + contentWidth + " pixels");

            Point point = el1.getLocation();

            //Get element's X location
            int element_X = point.getX();
            System.out.println("Element's Position from left side is: " + point.getX() + " pixels.");

            //Get element's Y location
            int element_Y = point.getY();
            System.out.println("Element's Position from top is: " + point.getY() + " pixels.");

            //Get width of element.
            int elementWidth = el1.getSize().getWidth();
            System.out.println("Element width Is " + elementWidth + " pixels");

            //Get height of element.
            int elementHeight = el1.getSize().getHeight();
            System.out.println("Element height Is " + elementHeight + " pixels");

            //End coordinate of Web element on X axis
            int total_X = element_X + contentWidth;

            //End coordinate of Web element on Y axis
            int total_Y = element_Y + contentHeight;

           /* if (total_Y >= contentHeight) {

                //"Add Item" table
                // WebElement table_AddItem = driver.findElement(By.xpath("//td[@class='lsCnArFaceEmph lsCnArBrdBox lsPnCntPadStd'][contains(@id, 'caCnt')]/div/table[@class='urMatrixLayout urHtmlTableReset'][contains (@ct, 'ML')]"));

                //System.out.println("COLUMN DIV DETECTED!!!");

            }*/

            if (element_X >= contentWidth) {
                //if element is outside of view port then calculate how many pixels are needed to bring it into the view


                //Get offset between browser width and element location
                offset_Value = element_X + elementWidth - contentWidth;
                System.out.println("Offset between browser width and the outbordered element: " + offset_Value + " pixels");

                offset_Value = (int) Math.round((offset_Value) * 0.4);
                System.out.println("Offset for SLIDER in case of outbordered element: " + offset_Value + " pixels");

                //js.executeScript("window.scroll(140, %s)", webElement );
                // js.executeScript("arguments[0].scrollIntoView();",webElement);
                action.moveToElement(webElement).clickAndHold();
                action.moveByOffset(offset_Value, 0);
                action.release();
                action.perform();

            } else {

                //if element is partly outside of view port then calculate how many pixels are needed to bring it into the view
                if (element_X < contentWidth && element_X + elementWidth > contentWidth) {

                    //Get offset between browser width and partly visible element
                    offset_Value = contentWidth - element_X;
                    offset_Value = elementWidth - offset_Value;
                    offset_Value = (int) Math.round((offset_Value) * 0.7);
                    System.out.println("Offset between browser width and the partly outbordered element: " + offset_Value + " pixels");

                    //js.executeScript("window.scroll(140, %s)", webElement );
                    // js.executeScript("arguments[0].scrollIntoView();",webElement);
                    action.moveToElement(webElement).clickAndHold();
                    action.moveByOffset(offset_Value, 0);
                    action.release();
                    action.perform();
                }
            }


        } catch (Exception e) {
            logger.error("Error while bringing element into view horizontally on the screen: " + e.getMessage());
        }


    }

    public void close_WarningPOPUP() {
        try {
            //Click "OK" button on the "WARNING" popup to close it
            js.executeScript("arguments[0].click();", button_WarningOK);
            //action.moveToElement(button_CustomerRoleCheck).click().perform();
            //button_CustomerRoleCheck.click();

            logger.info("'OK' button was SUCCESSFULLY clicked on WARNING popup.");

          //  waitTillWebElementEscapes(20, "//div[@id='ALL_POPUPS']/div[contains(@id, 'POP_CONT')]/div[1]", "WARNING POPUP");

        } catch (Exception e) {
            logger.error("Error while closing 'WARNING'popup: " + e);

        }

    }

    public void close_WarningPOPUP_OGQ() {
        try {

            //Click "OK" button on the "WARNING" popup to close it
            js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//span[contains (text(), 'OK')]")));
            //action.moveToElement(button_CustomerRoleCheck).click().perform();
            //button_CustomerRoleCheck.click();

            logger.info("'OK' button was SUCCESSFULLY clicked on WARNING popup.");

            driver.switchTo().defaultContent();

            //waitTillWebElementEscapes(20, "//div[@id='ALL_POPUPS']/div[contains(@id, 'POP_CONT')]/div[1]", "WARNING POPUP");
            waitTillElementDetectedByStyle(20, "//iframe[@id='URLSPW-0']", "display", "none", "WARNING POPUP");

        } catch (Exception e) {
            logger.error("Error while closing 'WARNING'popup: " + e);

        }

    }


}