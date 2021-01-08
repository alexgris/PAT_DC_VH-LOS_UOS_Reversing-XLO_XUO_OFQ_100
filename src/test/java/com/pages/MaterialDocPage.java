package com.pages;

import init.settings.PageObject;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.internal.Locatable;
import org.project.Test_Cases;

import java.util.List;

public class MaterialDocPage extends PageObject {

    public Logger logger = Logger.getLogger(MaterialDocPage.class);

    //Constructor
    public MaterialDocPage(WebDriver driver) {
        super(driver);
    }

    JavascriptExecutor js = (JavascriptExecutor) driver;
    Actions action = new Actions(driver);


    public void read_AllItemsTableFields_RightPart_1() {

        int ColumnCount = 0;
        int neededColumns = 1;
        boolean elAvailability = false;

        try {

            //  if (Test_Cases.conf_SystemClient.equals("OGQ_100")) {

            // driver.switchTo().defaultContent();
            //driver.switchTo().frame("ITSFRAME1");
            //  driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains (@id, 'ITSFRAME1')]")));

            try {
                //Get all columns in the RIGHT part of "All Items" table
                List<WebElement> available_ColumnsInRightPartOfTable = driver.findElements(By.ByXPath.xpath("//form[contains (@name, 'webguiform0')]/descendant::table[contains (@ct, 'STCS')][contains (@shscrollcontentid, '-mrss-hdr-none-content')]/tbody[contains (@id, '-content')]/tr[contains (@vpm, 'mrss-hdr')]/td[2]/descendant::table[contains (@id, '-mrss-hdr-none-content')]/tbody/tr/descendant::th[contains (@class, 'urST3HUnsel')]"));

                System.out.println("Number of columns in the RIGHT part: " + available_ColumnsInRightPartOfTable.size());


                //Loop through all found coulmns
                for (WebElement element : available_ColumnsInRightPartOfTable) {
                    ColumnCount++; //column counter

                    System.out.println("Column CLASS: " + element.getAttribute("class"));

                    if (neededColumns <= 8) {
                        System.out.println("Counter of Needed columns in the RIGHT part of ITEM OVERVIEW table: " + neededColumns);

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
                               /* if (name_TableColumn.contains("Mat. Short Text")) {
                                    name_TableColumn = "Mat. Short Text";
                                }*/
                            if (name_TableColumn.contains("Material")) {
                                if (!name_TableColumn.contains("Material Trfr Pstg")) {
                                    name_TableColumn = "Material";
                                }
                            }
                            if (name_TableColumn.contains("Quantity")) {
                                name_TableColumn = "Quantity";
                            }
                            if (name_TableColumn.contains("Base Unit")) {
                                name_TableColumn = "Base Unit";
                            }
                            if (name_TableColumn.contains("Plant")) {
                                if (!name_TableColumn.contains("Plant Trfr Pstg")) {
                                    name_TableColumn = "Plant";
                                }
                            }

                            if (name_TableColumn.contains("SLoc Transfer Pstg")) {
                                name_TableColumn = "SLoc Transfer Pstg";
                            }
                            if (name_TableColumn.contains("Valuation Type")) {
                                name_TableColumn = "Valuation Type";
                            }
                            if (name_TableColumn.contains("Handling Type")) {
                                name_TableColumn = "Handling Type";
                            }


                            switch (name_TableColumn) {

                                 /*   case "Mat. Short Text":

                                        //check whether this column is within the screen boundaries and scroll to the column
                                        // bringElementIntoViewHorizontally("Material Description");

                                        //Find input field below the "Mat. Short Text" column title and check whether the input field is enabled/editable
                                        WebElement field_MaterialDescription = driver.findElement(By.ByXPath.xpath("//form[contains (@name, 'webguiform0')]/descendant::table[contains (@ct, 'STCS')][contains (@shscrollcontentid, '-mrss-hdr-none-content')]/tbody[contains (@id, '-content')]/tr[contains (@vpm, 'mrss-cont')]/td[2]/descendant::table[contains (@id, '-mrss-cont-none-content')]/tbody/tr[1]/td[" + ColumnCount + "]/div/span/span"));

                                        //Read value from the "Material Description" input field
                                        String value_MaterialDescription = field_MaterialDescription.getAttribute("innerText");
                                        System.out.println("Retrieved 'Material Description' value: " + value_MaterialDescription);

                                        Test_Cases.MaterialDescription2 = value_MaterialDescription;

                                        logger.info("MATERIAL DESCRIPTION value has been SUCCESSFULLY read from ADD ITEM table for comparison: " + Test_Cases.MaterialDescription2 + ".");
                                        neededColumns++;


                                        break;*/


                                case "Material":

                                    //check whether this column is within the screen boundaries and scroll to the column
                                    // bringElementIntoViewHorizontally_DisplayMatrDoc_AddItem("Material");

                                    //Find input field below the "Material" column title and check whether the input field is enabled/editable
                                    WebElement field_Material = driver.findElement(By.ByXPath.xpath("//form[contains (@name, 'webguiform0')]/descendant::table[contains (@ct, 'STCS')][contains (@shscrollcontentid, '-mrss-hdr-none-content')]/tbody[contains (@id, '-content')]/tr[contains (@vpm, 'mrss-cont')]/td[2]/descendant::table[contains (@id, '-mrss-cont-none-content')]/tbody/tr[1]/td[" + ColumnCount + "]/div/span/span[1]"));


                                    //Read value from the "Material" input field
                                    String value_Material = field_Material.getAttribute("innerText");
                                    System.out.println("Retrieved 'Material' value: " + value_Material);

                                    Test_Cases.Material2 = value_Material;

                                    logger.info("MATERIAL value has been SUCCESSFULLY read from ADD ITEM table for comparison: " + Test_Cases.Material2 + ".");
                                    neededColumns++;


                                    break;

                                case "Quantity":

                                    //check whether this column is within the screen boundaries and scroll to the column
                                    //bringElementIntoViewHorizontally_DisplayMatrDoc_AddItem("Quantity");

                                    //Find input field below the "Order Quantity" column title and check whether the input field is enabled/editable
                                    WebElement field_Quantity = driver.findElement(By.ByXPath.xpath("//form[contains (@name, 'webguiform0')]/descendant::table[contains (@ct, 'STCS')][contains (@shscrollcontentid, '-mrss-hdr-none-content')]/tbody[contains (@id, '-content')]/tr[contains (@vpm, 'mrss-cont')]/td[2]/descendant::table[contains (@id, '-mrss-cont-none-content')]/tbody/tr[1]/td[" + ColumnCount + "]/div/span/span[1]"));


                                    //Read value from the "Quantity" input field
                                    String value_Quantity = field_Quantity.getAttribute("innerText");
                                    System.out.println("Retrieved 'Quantity' value: " + value_Quantity);

                                    Test_Cases.Quantity2 = value_Quantity;

                                    logger.info("QUANTITY value has been SUCCESSFULLY read from ADD ITEM table for comparison: " + Test_Cases.Quantity2 + ".");
                                    neededColumns++;

                                    break;

                                case "Base Unit":

                                    //check whether this column is within the screen boundaries and scroll to the column
                                    //bringElementIntoViewHorizontally_DisplayMatrDoc_AddItem("Base Unit");

                                    //Find input field below the "Base Unit of Measure" column title and check whether the input field is enabled/editable
                                    WebElement field_BaseUnit = driver.findElement(By.ByXPath.xpath("//form[contains (@name, 'webguiform0')]/descendant::table[contains (@ct, 'STCS')][contains (@shscrollcontentid, '-mrss-hdr-none-content')]/tbody[contains (@id, '-content')]/tr[contains (@vpm, 'mrss-cont')]/td[2]/descendant::table[contains (@id, '-mrss-cont-none-content')]/tbody/tr[1]/td[" + ColumnCount + "]/div/span/span[1]"));


                                    //Read value from the "Base Unit" input field
                                    String value_BaseUnit = field_BaseUnit.getAttribute("innerText");
                                    System.out.println("Retrieved 'Base Unit of Measurement' value: " + value_BaseUnit);

                                    Test_Cases.BaseUnitOfMeasure2 = value_BaseUnit;

                                    logger.info("BASE UNIT value has been SUCCESSFULLY read from ADD ITEM table for comparison: " + Test_Cases.BaseUnitOfMeasure2 + ".");
                                    neededColumns++;

                                    break;


                                case "Plant":

                                    //check whether this column is within the screen boundaries and scroll to the column
                                    //bringElementIntoViewHorizontally_DisplayMatrDoc_AddItem("Plant");

                                    //Find input field below the "Plant" column title and check whether the input field is enabled/editable
                                    WebElement field_Plant = driver.findElement(By.ByXPath.xpath("//form[contains (@name, 'webguiform0')]/descendant::table[contains (@ct, 'STCS')][contains (@shscrollcontentid, '-mrss-hdr-none-content')]/tbody[contains (@id, '-content')]/tr[contains (@vpm, 'mrss-cont')]/td[2]/descendant::table[contains (@id, '-mrss-cont-none-content')]/tbody/tr[1]/td[" + ColumnCount + "]/div/span/span[1]"));


                                    //Read value from the "Plant" input field
                                    String value_Plant = field_Plant.getAttribute("innerText");
                                    System.out.println("Retrieved 'Plant' value: " + value_Plant);

                                    Test_Cases.Plant2 = value_Plant;

                                    logger.info("PLANT value has been SUCCESSFULLY read from ADD ITEM table for comparison: " + Test_Cases.Plant2 + ".");
                                    neededColumns++;

                                    break;


                                // case "\n\nStorage location\n\n\n ":
                                case "SLoc Transfer Pstg":
                                    //check whether this column is within the screen boundaries and scroll to the column
                                    //bringElementIntoViewHorizontally_DisplayMatrDoc_AddItem("Stor. Location");

                                    //Find input field below the "Storage Location" column title and check whether the input field is enabled/editable
                                    WebElement field_StorageLocation = driver.findElement(By.ByXPath.xpath("//form[contains (@name, 'webguiform0')]/descendant::table[contains (@ct, 'STCS')][contains (@shscrollcontentid, '-mrss-hdr-none-content')]/tbody[contains (@id, '-content')]/tr[contains (@vpm, 'mrss-cont')]/td[2]/descendant::table[contains (@id, '-mrss-cont-none-content')]/tbody/tr[1]/td[" + ColumnCount + "]/div/span/span[1]"));


                                    //Read value from the "Storage Location" input field
                                    String value_StorageLocation = field_StorageLocation.getAttribute("innerText");
                                    System.out.println("Retrieved 'Storage Location' value: " + value_StorageLocation);

                                    Test_Cases.StorageLocation2 = value_StorageLocation;

                                    logger.info("STORAGE LOCATION value has been SUCCESSFULLY read from ADD ITEM table for comparison: " + Test_Cases.StorageLocation2 + ".");
                                    neededColumns++;

                                    break;


                                case "Valuation Type":
                                    //check whether this column is within the screen boundaries and scroll to the column
                                    //bringElementIntoViewHorizontally_DisplayMatrDoc_AddItem("Valuation Type");

                                    //Find input field below the "Valuation Type" column title and check whether the input field is enabled/editable
                                    WebElement field_ValuationType = driver.findElement(By.ByXPath.xpath("//form[contains (@name, 'webguiform0')]/descendant::table[contains (@ct, 'STCS')][contains (@shscrollcontentid, '-mrss-hdr-none-content')]/tbody[contains (@id, '-content')]/tr[contains (@vpm, 'mrss-cont')]/td[2]/descendant::table[contains (@id, '-mrss-cont-none-content')]/tbody/tr[1]/td[" + ColumnCount + "]/div/span/span[1]"));


                                    //Read value from the "Valuation Type" input field
                                    String value_ValuationType = field_ValuationType.getAttribute("innerText");
                                    System.out.println("Retrieved 'Valuation Type' value: " + value_ValuationType);

                                    Test_Cases.ValuationType2 = value_ValuationType;

                                    logger.info("VALUATION TYPE value has been SUCCESSFULLY read from ADD ITEM table for comparison: " + Test_Cases.ValuationType2 + ".");
                                    neededColumns++;

                                    break;

                                case "Handling Type":
                                    //check whether this column is within the screen boundaries and scroll to the column
                                    //bringElementIntoViewHorizontally_DisplayMatrDoc_AddItem("Handling Type");

                                    //Find input field below the "Handling Type" column title and check whether the input field is enabled/editable
                                    WebElement field_HandlingType = driver.findElement(By.ByXPath.xpath("//form[contains (@name, 'webguiform0')]/descendant::table[contains (@ct, 'STCS')][contains (@shscrollcontentid, '-mrss-hdr-none-content')]/tbody[contains (@id, '-content')]/tr[contains (@vpm, 'mrss-cont')]/td[2]/descendant::table[contains (@id, '-mrss-cont-none-content')]/tbody/tr[1]/td[" + ColumnCount + "]/div/span/span[1]"));


                                    //Read value from the "Handling Type" input field
                                    String value_HandlingType = field_HandlingType.getAttribute("innerText");
                                    System.out.println("Retrieved 'Handling Type' value: " + value_HandlingType);

                                    Test_Cases.HandlingType2 = value_HandlingType;

                                    logger.info("HANDLING TYPE value has been SUCCESSFULLY read from ADD ITEM table for comparison: " + Test_Cases.HandlingType2 + ".");
                                    neededColumns++;

                                    break;

                                default:
                            }

                        }
                    } else {
                        // driver.switchTo().defaultContent();
                        return;// break the cycle when all required fields have been filled in
                    }
                }
            } catch (NoSuchElementException e) {
                logger.error("No such element - Error while retrieving the column titles and fields in the RIGHT part of 'ALL ITEMS' table on DISPLAY MATERIAL page: " + e.getMessage());
            }
            //   }


        } catch (Exception e) {
            logger.error("Error while executing method 'filling_ItemOverviewTableFields()': " + e.getMessage());
        }

    }


    public void read_AllItemsTableFields_RightPart_2() {

        int ColumnCount = 0;
        int neededColumns = 1;
        boolean elAvailability = false;

        try {

            //  if (Test_Cases.conf_SystemClient.equals("OGQ_100")) {

            // driver.switchTo().defaultContent();
            //driver.switchTo().frame("ITSFRAME1");
            //  driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains (@id, 'ITSFRAME1')]")));

            try {
                //Get all columns in the RIGHT part of "All Items" table
                List<WebElement> available_ColumnsInRightPartOfTable = driver.findElements(By.ByXPath.xpath("//form[contains (@name, 'webguiform0')]/descendant::table[contains (@ct, 'STCS')][contains (@shscrollcontentid, '-mrss-hdr-none-content')]/tbody[contains (@id, '-content')]/tr[contains (@vpm, 'mrss-hdr')]/td[2]/descendant::table[contains (@id, '-mrss-hdr-none-content')]/tbody/tr/descendant::th[contains (@class, 'urST3HUnsel')]"));

                System.out.println("Number of columns in the RIGHT part: " + available_ColumnsInRightPartOfTable.size());


                //Loop through all found coulmns
                for (WebElement element : available_ColumnsInRightPartOfTable) {
                    ColumnCount++; //column counter

                    System.out.println("Column CLASS: " + element.getAttribute("class"));

                    if (neededColumns <= 7) {
                        System.out.println("Counter of Needed columns in the RIGHT part of ITEM OVERVIEW table: " + neededColumns);

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
                               /* if (name_TableColumn.contains("Mat. Short Text")) {
                                    name_TableColumn = "Mat. Short Text";
                                }*/
                            if (name_TableColumn.contains("Material")) {
                                if (!name_TableColumn.contains("Material Trfr Pstg")) {
                                    name_TableColumn = "Material";
                                }
                            }
                            if (name_TableColumn.contains("Quantity")) {
                                name_TableColumn = "Quantity";
                            }
                            if (name_TableColumn.contains("Base Unit")) {
                                name_TableColumn = "Base Unit";
                            }
                            if (name_TableColumn.contains("Plant")) {
                                if (!name_TableColumn.contains("Plant Trfr Pstg")) {
                                    name_TableColumn = "Plant";
                                }
                            }
                            if (name_TableColumn.contains("Stor. Location")) {
                                name_TableColumn = "Stor. Location";
                            }
                            if (name_TableColumn.contains("Valuation Type")) {
                                name_TableColumn = "Valuation Type";
                            }
                            if (name_TableColumn.contains("Handling Type")) {
                                name_TableColumn = "Handling Type";
                            }


                            switch (name_TableColumn) {

                                 /*   case "Mat. Short Text":

                                        //check whether this column is within the screen boundaries and scroll to the column
                                        // bringElementIntoViewHorizontally("Material Description");

                                        //Find input field below the "Mat. Short Text" column title and check whether the input field is enabled/editable
                                        WebElement field_MaterialDescription = driver.findElement(By.ByXPath.xpath("//form[contains (@name, 'webguiform0')]/descendant::table[contains (@ct, 'STCS')][contains (@shscrollcontentid, '-mrss-hdr-none-content')]/tbody[contains (@id, '-content')]/tr[contains (@vpm, 'mrss-cont')]/td[2]/descendant::table[contains (@id, '-mrss-cont-none-content')]/tbody/tr[1]/td[" + ColumnCount + "]/div/span/span"));

                                        //Read value from the "Material Description" input field
                                        String value_MaterialDescription = field_MaterialDescription.getAttribute("innerText");
                                        System.out.println("Retrieved 'Material Description' value: " + value_MaterialDescription);

                                        Test_Cases.MaterialDescription2 = value_MaterialDescription;

                                        logger.info("MATERIAL DESCRIPTION value has been SUCCESSFULLY read from ADD ITEM table for comparison: " + Test_Cases.MaterialDescription2 + ".");
                                        neededColumns++;


                                        break;*/


                                case "Material":

                                    //check whether this column is within the screen boundaries and scroll to the column
                                    // bringElementIntoViewHorizontally_DisplayMatrDoc_AddItem("Material");

                                    //Find input field below the "Material" column title and check whether the input field is enabled/editable
                                    WebElement field_Material = driver.findElement(By.ByXPath.xpath("//form[contains (@name, 'webguiform0')]/descendant::table[contains (@ct, 'STCS')][contains (@shscrollcontentid, '-mrss-hdr-none-content')]/tbody[contains (@id, '-content')]/tr[contains (@vpm, 'mrss-cont')]/td[2]/descendant::table[contains (@id, '-mrss-cont-none-content')]/tbody/tr[1]/td[" + ColumnCount + "]/div/span/span[1]"));


                                    //Read value from the "Material" input field
                                    String value_Material = field_Material.getAttribute("innerText");
                                    System.out.println("Retrieved 'Material' value: " + value_Material);

                                    Test_Cases.Material3 = value_Material;

                                    logger.info("MATERIAL value has been SUCCESSFULLY read from ADD ITEM table for comparison: " + Test_Cases.Material3 + ".");
                                    neededColumns++;


                                    break;

                                case "Quantity":

                                    //check whether this column is within the screen boundaries and scroll to the column
                                    //bringElementIntoViewHorizontally_DisplayMatrDoc_AddItem("Quantity");

                                    //Find input field below the "Order Quantity" column title and check whether the input field is enabled/editable
                                    WebElement field_Quantity = driver.findElement(By.ByXPath.xpath("//form[contains (@name, 'webguiform0')]/descendant::table[contains (@ct, 'STCS')][contains (@shscrollcontentid, '-mrss-hdr-none-content')]/tbody[contains (@id, '-content')]/tr[contains (@vpm, 'mrss-cont')]/td[2]/descendant::table[contains (@id, '-mrss-cont-none-content')]/tbody/tr[1]/td[" + ColumnCount + "]/div/span/span[1]"));


                                    //Read value from the "Quantity" input field
                                    String value_Quantity = field_Quantity.getAttribute("innerText");
                                    System.out.println("Retrieved 'Quantity' value: " + value_Quantity);

                                    Test_Cases.Quantity3 = value_Quantity;

                                    logger.info("QUANTITY value has been SUCCESSFULLY read from ADD ITEM table for comparison: " + Test_Cases.Quantity3 + ".");
                                    neededColumns++;

                                    break;

                                case "Base Unit":

                                    //check whether this column is within the screen boundaries and scroll to the column
                                    //bringElementIntoViewHorizontally_DisplayMatrDoc_AddItem("Base Unit");

                                    //Find input field below the "Base Unit of Measure" column title and check whether the input field is enabled/editable
                                    WebElement field_BaseUnit = driver.findElement(By.ByXPath.xpath("//form[contains (@name, 'webguiform0')]/descendant::table[contains (@ct, 'STCS')][contains (@shscrollcontentid, '-mrss-hdr-none-content')]/tbody[contains (@id, '-content')]/tr[contains (@vpm, 'mrss-cont')]/td[2]/descendant::table[contains (@id, '-mrss-cont-none-content')]/tbody/tr[1]/td[" + ColumnCount + "]/div/span/span[1]"));


                                    //Read value from the "Base Unit" input field
                                    String value_BaseUnit = field_BaseUnit.getAttribute("innerText");
                                    System.out.println("Retrieved 'Base Unit of Measurement' value: " + value_BaseUnit);

                                    Test_Cases.BaseUnitOfMeasure3 = value_BaseUnit;

                                    logger.info("BASE UNIT value has been SUCCESSFULLY read from ADD ITEM table for comparison: " + Test_Cases.BaseUnitOfMeasure3 + ".");
                                    neededColumns++;

                                    break;


                                case "Plant":

                                    //check whether this column is within the screen boundaries and scroll to the column
                                    //bringElementIntoViewHorizontally_DisplayMatrDoc_AddItem("Plant");

                                    //Find input field below the "Plant" column title and check whether the input field is enabled/editable
                                    WebElement field_Plant = driver.findElement(By.ByXPath.xpath("//form[contains (@name, 'webguiform0')]/descendant::table[contains (@ct, 'STCS')][contains (@shscrollcontentid, '-mrss-hdr-none-content')]/tbody[contains (@id, '-content')]/tr[contains (@vpm, 'mrss-cont')]/td[2]/descendant::table[contains (@id, '-mrss-cont-none-content')]/tbody/tr[1]/td[" + ColumnCount + "]/div/span/span[1]"));


                                    //Read value from the "Plant" input field
                                    String value_Plant = field_Plant.getAttribute("innerText");
                                    System.out.println("Retrieved 'Plant' value: " + value_Plant);

                                    Test_Cases.Plant3 = value_Plant;

                                    logger.info("PLANT value has been SUCCESSFULLY read from ADD ITEM table for comparison: " + Test_Cases.Plant3 + ".");
                                    neededColumns++;

                                    break;


                                // case "\n\nStorage location\n\n\n ":
                                case "Stor. Location":
                                    //check whether this column is within the screen boundaries and scroll to the column
                                    //bringElementIntoViewHorizontally_DisplayMatrDoc_AddItem("Stor. Location");

                                    //Find input field below the "Storage Location" column title and check whether the input field is enabled/editable
                                    WebElement field_StorageLocation = driver.findElement(By.ByXPath.xpath("//form[contains (@name, 'webguiform0')]/descendant::table[contains (@ct, 'STCS')][contains (@shscrollcontentid, '-mrss-hdr-none-content')]/tbody[contains (@id, '-content')]/tr[contains (@vpm, 'mrss-cont')]/td[2]/descendant::table[contains (@id, '-mrss-cont-none-content')]/tbody/tr[1]/td[" + ColumnCount + "]/div/span/span[1]"));


                                    //Read value from the "Storage Location" input field
                                    String value_StorageLocation = field_StorageLocation.getAttribute("innerText");
                                    System.out.println("Retrieved 'Storage Location' value: " + value_StorageLocation);

                                    Test_Cases.StorageLocation3 = value_StorageLocation;

                                    logger.info("STORAGE LOCATION value has been SUCCESSFULLY read from ADD ITEM table for comparison: " + Test_Cases.StorageLocation3 + ".");
                                    neededColumns++;

                                    break;


                                case "Valuation Type":
                                    //check whether this column is within the screen boundaries and scroll to the column
                                    //bringElementIntoViewHorizontally_DisplayMatrDoc_AddItem("Valuation Type");

                                    //Find input field below the "Valuation Type" column title and check whether the input field is enabled/editable
                                    WebElement field_ValuationType = driver.findElement(By.ByXPath.xpath("//form[contains (@name, 'webguiform0')]/descendant::table[contains (@ct, 'STCS')][contains (@shscrollcontentid, '-mrss-hdr-none-content')]/tbody[contains (@id, '-content')]/tr[contains (@vpm, 'mrss-cont')]/td[2]/descendant::table[contains (@id, '-mrss-cont-none-content')]/tbody/tr[1]/td[" + ColumnCount + "]/div/span/span[1]"));


                                    //Read value from the "Valuation Type" input field
                                    String value_ValuationType = field_ValuationType.getAttribute("innerText");
                                    System.out.println("Retrieved 'Valuation Type' value: " + value_ValuationType);

                                    Test_Cases.ValuationType3 = value_ValuationType;

                                    logger.info("VALUATION TYPE value has been SUCCESSFULLY read from ADD ITEM table for comparison: " + Test_Cases.ValuationType3 + ".");
                                    neededColumns++;

                                    break;

                                case "Handling Type":
                                    //check whether this column is within the screen boundaries and scroll to the column
                                    //bringElementIntoViewHorizontally_DisplayMatrDoc_AddItem("Handling Type");

                                    //Find input field below the "Handling Type" column title and check whether the input field is enabled/editable
                                    WebElement field_HandlingType = driver.findElement(By.ByXPath.xpath("//form[contains (@name, 'webguiform0')]/descendant::table[contains (@ct, 'STCS')][contains (@shscrollcontentid, '-mrss-hdr-none-content')]/tbody[contains (@id, '-content')]/tr[contains (@vpm, 'mrss-cont')]/td[2]/descendant::table[contains (@id, '-mrss-cont-none-content')]/tbody/tr[1]/td[" + ColumnCount + "]/div/span/span[1]"));


                                    //Read value from the "Handling Type" input field
                                    String value_HandlingType = field_HandlingType.getAttribute("innerText");
                                    System.out.println("Retrieved 'Handling Type' value: " + value_HandlingType);

                                    Test_Cases.HandlingType3 = value_HandlingType;

                                    logger.info("HANDLING TYPE value has been SUCCESSFULLY read from ADD ITEM table for comparison: " + Test_Cases.HandlingType3 + ".");
                                    neededColumns++;

                                    break;

                                default:
                            }

                        }
                    } else {
                        // driver.switchTo().defaultContent();
                        return;// break the cycle when all required fields have been filled in
                    }
                }
            } catch (NoSuchElementException e) {
                logger.error("No such element - Error while retrieving the column titles and fields in the RIGHT part of 'ALL ITEMS' table on DISPLAY MATERIAL page: " + e.getMessage());
            }
            //   }


        } catch (Exception e) {
            logger.error("Error while executing method 'filling_ItemOverviewTableFields()': " + e.getMessage());
        }

    }


    public String retrieve_MaterialDocumentNumber() {

        String MaterialDocNum = null;

        try {

            WebElement field_MaterialDocNum = driver.findElement(By.xpath("//input[contains (@title, 'Material Document')][contains (@ct, 'CBS')]"));

            MaterialDocNum = field_MaterialDocNum.getAttribute("value");
            System.out.println("Retrieved 'MATERIAL DOCUMENT NUMBER' from newly opened tab is: " + MaterialDocNum);

            WebElement field_MaterialDocNumYear = driver.findElement(By.xpath("//input[contains (@title, 'Material Document Year')][contains (@ct, 'CBS')]"));

            String MaterialDocNumYear = field_MaterialDocNumYear.getAttribute("value");
            System.out.println("Retrieved 'MATERIAL DOCUMENT NUMBER YEAR' from newly opened tab is: " + MaterialDocNumYear);

            MaterialDocNum = MaterialDocNum+MaterialDocNumYear;

            logger.info("Retrieved full 'MATERIAL DOCUMENT NUMBER' from newly opened tab is: " + MaterialDocNum);

        } catch (Exception e) {
            logger.warn("Error while retrieving 'Material Document Number' on new tab: " + e.getMessage());
        }
        return MaterialDocNum;
    }

    public void bringElementIntoViewHorizontally(String columnTitle) {

        try {

            if (Test_Cases.conf_SystemClient.equals("OFQ_100")) {

                try {

                    //Column title in every column of the right-hand part of "All Items" table
                    WebElement el1 = driver.findElement(By.xpath("//span[contains (text(), 'All Items')]/ancestor::table[contains (@ct, 'STCS')][contains (@class, 'urSTCS urST3WhlBrd urST3WhlNoTit urST5SelColUiMulti urHtmlTableReset')][1]/tbody[1]/tr[contains (@vpm, 'mrss-hdr')]/td[2]/div/div[2]/table/tbody/tr/descendant::span[text()='" + columnTitle + "']/ancestor::th[1]"));

                    //Horizontal slider in the second part of "All Items" table
                    WebElement webElement = driver.findElement(By.xpath("//span[contains (text(), 'All Items')]/ancestor::table[contains (@ct, 'STCS')][contains (@class, 'urSTCS urST3WhlBrd urST3WhlNoTit urST5SelColUiMulti urHtmlTableReset')][1]/tbody[2]/tr/td[2]/div/table/tbody/tr/td[2]/descendant::span[contains (@id, 'hscroll-hdl')][contains (@acf, 'Hndl')]"));

                    System.out.println("HORIZONTAL SCROLLER DETECTED!!!");

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
                    logger.warn("Error while bringing element into view horizontally on the screen: " + e.getMessage());
                }
            }


            if (Test_Cases.conf_SystemClient.equals("OGQ_100")) {

                try {

                    //Column title in every column of the right-hand part of "All Items" table
                    WebElement el1 = driver.findElement(By.xpath("//form[contains (@name, 'webguiform0')]/descendant::table[contains (@ct, 'STCS')][contains (@shscrollcontentid, '-mrss-hdr-none-content')]/tbody[contains (@id, '-content')]/tr[contains (@vpm, 'mrss-hdr')]/td[2]/descendant::table[contains (@id, '-mrss-hdr-none-content')]/tbody/tr/descendant::span[contains (text(), '" + columnTitle + "']/ancestor::th[1]"));

                    //Horizontal slider in the second part of "All Items" table
                    WebElement webElement = driver.findElement(By.xpath("//form[contains (@name, 'webguiform0')]/descendant::table[contains (@ct, 'STCS')][contains (@shscrollcontentid, '-mrss-hdr-none-content')]/tbody[2]/tr/td[2]/descendant::span[contains (@id, 'hscroll-hdl')][contains (@acf, 'Hndl')]"));

                    System.out.println("HORIZONTAL SCROLLER DETECTED!!!");

                    int offset_Value = 0;

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
                    logger.warn("Error while bringing element into view horizontally on the screen: " + e.getMessage());
                }

            }

        } catch (Exception e) {
            logger.error("Error while executing method 'bringElementIntoViewHorizontally': " + e.getMessage());
        }
    }

    public void compare_AllItemsDetails(String orgDocNum, String retrievedDocNum, String orgMaterial, String orgQty, String orgPlant, String orgStorgLocatn, String orgValtnType, String orgHandlingType, String orgBaseUnitOfMeasure, String retrievedMaterial, String retrievedQty, String retrievedPlant, String retrievedStorgLocatn, String retrievedValtnType, String retrievedHandlingType, String retrievedBaseUnitOfMeasure) {
        try {

            //if document numbers coincide with each other, then compare other table values
            if (orgDocNum.equalsIgnoreCase(retrievedDocNum)) {

                logger.info("Document Number from 'DC' and 'Display Material' pages are identical as EXPECTED: " + orgDocNum + " vs. " + retrievedDocNum);

                if (orgMaterial.equalsIgnoreCase(retrievedMaterial)) {
                    logger.info("Materials for Document Number " + orgDocNum + " are identical as EXPECTED (" + orgMaterial + " vs. " + retrievedMaterial + ").");
                } else {
                    logger.warn("Materials for Document Number " + orgDocNum + " are NOT identical (" + orgMaterial + " vs. " + retrievedMaterial + ").");
                }

                if (orgQty.equalsIgnoreCase(retrievedQty)) {
                    logger.info("Quantities for Document Number " + orgDocNum + " are identical as EXPECTED (" + orgQty + " vs. " + retrievedQty + ").");
                } else {
                    logger.warn("Quantities for Document Number " + orgDocNum + " are NOT identical (" + orgQty + " vs. " + retrievedQty + ").");
                }

                if (orgPlant.equalsIgnoreCase(retrievedPlant)) {
                    logger.info("Plants for Document Number " + orgDocNum + " are identical as EXPECTED (" + orgPlant + " vs. " + retrievedPlant + ").");
                } else {
                    logger.warn("Plants for Document Number " + orgDocNum + " are NOT identical (" + orgPlant + " vs. " + retrievedPlant + ").");
                }

                if (orgStorgLocatn.equalsIgnoreCase(retrievedStorgLocatn)) {
                    logger.info("Storage Locations for Document Number " + orgDocNum + " are identical as EXPECTED (" + orgStorgLocatn + " vs. " + retrievedStorgLocatn + ").");
                } else {
                    logger.warn("Storage Locations for Document Number " + orgDocNum + " are NOT identical (" + orgStorgLocatn + " vs. " + retrievedStorgLocatn + ").");
                }

                if (orgValtnType.equalsIgnoreCase(retrievedValtnType)) {
                    logger.info("Valuation Types for Document Number " + orgDocNum + " are identical as EXPECTED (" + orgValtnType + " vs. " + retrievedValtnType + ").");
                } else {
                    logger.warn("Valuation Types for Document Number " + orgDocNum + " are NOT identical (" + orgValtnType + " vs. " + retrievedValtnType + ").");
                }

                if (orgHandlingType.equalsIgnoreCase(retrievedHandlingType)) {
                    logger.info("Handling Types for Document Number " + orgDocNum + " are identical as EXPECTED (" + orgHandlingType + " vs. " + retrievedHandlingType + ").");
                } else {
                    logger.warn("Handling Types for Document Number " + orgDocNum + " are NOT identical (" + orgHandlingType + " vs. " + retrievedHandlingType + ").");
                }

                if (orgBaseUnitOfMeasure.equalsIgnoreCase(retrievedBaseUnitOfMeasure)) {
                    logger.info("Base Units of Measure for Document Number " + orgDocNum + " are identical as EXPECTED (" + orgBaseUnitOfMeasure + " vs. " + retrievedBaseUnitOfMeasure + ").");
                } else {
                    logger.warn("Base Units of Measure for Document Number " + orgDocNum + " are NOT identical (" + orgBaseUnitOfMeasure + " vs. " + retrievedBaseUnitOfMeasure + ").");
                }

            } else {
                logger.warn("Document Number from 'DC' and 'Display Material' pages are different: " + orgDocNum + " vs. " + retrievedDocNum);
            }


        } catch (Exception e) {
            logger.error("Error while executing method 'compare_AllItemsDetails': " + e.getMessage());
        }
    }


    public void bringElementIntoViewHorizontally_DisplayMatrDoc_AddItem(String columnTitle) {

        try {

            if (Test_Cases.conf_SystemClient.equals("OFQ_100")) {

                try {

                    //Column title in every column of the right-hand part of "All Items" table
                    WebElement el1 = driver.findElement(By.xpath("//span[contains (text(), 'All Items')]/ancestor::table[contains (@ct, 'STCS')][contains (@class, 'urSTCS urST3WhlBrd urST3WhlNoTit urST5SelColUiMulti urHtmlTableReset')][1]/tbody[1]/tr[contains (@vpm, 'mrss-hdr')]/td[2]/div/div[2]/table/tbody/tr/descendant::span[text()='" + columnTitle + "']/ancestor::th[1]"));

                    //Horizontal slider in the second part of "All Items" table
                    WebElement webElement = driver.findElement(By.xpath("//span[contains (text(), 'All Items')]/ancestor::table[contains (@ct, 'STCS')][contains (@class, 'urSTCS urST3WhlBrd urST3WhlNoTit urST5SelColUiMulti urHtmlTableReset')][1]/tbody[2]/tr/td[2]/div/table/tbody/tr/td[2]/descendant::span[contains (@id, 'hscroll-hdl')][contains (@acf, 'Hndl')]"));

                    System.out.println("HORIZONTAL SCROLLER DETECTED!!!");

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
                    logger.warn("Error while bringing element into view horizontally on the screen: " + e.getMessage());
                }
            }


            if (Test_Cases.conf_SystemClient.equals("OGQ_100")) {

                try {

                    //Column title in every column of the right-hand part of "All Items" table
                    WebElement el1 = driver.findElement(By.xpath("//form[contains (@name, 'webguiform0')]/descendant::table[contains (@ct, 'STCS')][contains (@shscrollcontentid, '-mrss-hdr-none-content')]/tbody[contains (@id, '-content')]/tr[contains (@vpm, 'mrss-hdr')]/td[2]/descendant::table[contains (@id, '-mrss-hdr-none-content')]/tbody/tr/descendant::span[contains (text(), '" + columnTitle + "')]/ancestor::th[1]"));

                    //Horizontal slider in the second part of "All Items" table
                    WebElement webElement = driver.findElement(By.xpath("//form[contains (@name, 'webguiform0')]/descendant::table[contains (@ct, 'STCS')][contains (@shscrollcontentid, '-mrss-hdr-none-content')]/tbody[2]/tr/td[2]/descendant::span[contains (@id, 'hscroll-hdl')][contains (@acf, 'Hndl')]/span"));

                    System.out.println("HORIZONTAL SCROLLER DETECTED!!!");


                    //Horizontal slider container in the second part of "All Items" table
                    WebElement webElementContainer = driver.findElement(By.xpath("//form[contains (@name, 'webguiform0')]/descendant::table[contains (@ct, 'STCS')][contains (@shscrollcontentid, '-mrss-hdr-none-content')]/tbody[2]/tr/td[2]/descendant::span[contains (@id, 'hscroll-hdl')][contains (@acf, 'Hndl')]/ancestor::div[1]"));

                    System.out.println("HORIZONTAL SCROLLER CONTAINER DETECTED!!!");

                    int offset_Value = 0;

                    //Get Browser window height
                    /*int contentHeight = ((Number) js.executeScript("return window.innerHeight")).intValue();
                    System.out.println("Browser window height Is " + contentHeight + " pixels");*/

                    //Get Browser window width
                    int contentWidth = ((Number) js.executeScript("return window.innerWidth")).intValue();
                    System.out.println("Browser window width Is " + contentWidth + " pixels");

                    Point point = el1.getLocation();

                    //Get column's X location
                    int column_X = point.getX();
                    System.out.println("Column's Position from left side is: " + point.getX() + " pixels.");

                    //Get column's Y location
                    //int column_Y = point.getY();
                    //System.out.println("Column's Position from top is: " + point.getY() + " pixels.");

                    //Get width of column.
                    int columnWidth = el1.getSize().getWidth();
                    System.out.println("Column's width Is " + columnWidth + " pixels");

                    //Get coordinates of horizontal slider
                  /*  Locatable element = (Locatable)webElement;
                    Point point2 = element.getCoordinates().inViewPort();*/

                    Coordinates coordinate = ((Locatable) webElement).getCoordinates();
                    coordinate.onPage();
                    Point point2 = coordinate.inViewPort();


                    //Get element's X location
                    int slider_X = point2.getX();
                    System.out.println("Slider's Position from left side is: " + slider_X + " pixels.");

                    //Get element's Y location
                    // int slider_Y = point2.getY();
                    // System.out.println("Slider's Position from top is: " + point2.getY() + " pixels.");

                    //Get width of slider.
                    int sliderWidth = webElement.getSize().getWidth();
                    System.out.println("Slider's width Is " + sliderWidth + " pixels");

                    //Get width of slider container.
                    int slider_containerWidth = webElementContainer.getSize().getWidth();
                    System.out.println("Slider's width Is " + slider_containerWidth + " pixels");

                    //Get height of slider.
                    // int elementHeight = el1.getSize().getHeight();
                    //System.out.println("Element height Is " + elementHeight + " pixels");

                    //End coordinate of Column on X axis
                    int column_total_X = column_X + columnWidth;

                    //Operatable slider part
                    int slider_operatable = slider_containerWidth - sliderWidth;

                    //Distance from browser right border till requested column
                    int distance_to_column = column_total_X - contentWidth;

                    //End coordinate of Column on Y axis
                    // int total_Y = element_Y + contentHeight;

                    if (column_total_X >= contentWidth) {
                        //if element is outside of view port then calculate how many pixels are needed to bring it into the view


                       /* Coordinates coordinate = ((Locatable)el1).getCoordinates();
                        coordinate.onPage();
                        coordinate.inViewPort();*/

                        //Get offset between browser width and element location
                        // offset_Value = element_X + elementWidth - contentWidth;
                        // System.out.println("Offset between browser width and the outbordered element: " + offset_Value + " pixels");

                        offset_Value = (int) Math.round(slider_operatable * (slider_operatable / distance_to_column));
                        System.out.println("Offset for SLIDER in case of outbordered element: " + offset_Value + " pixels");

                        js.executeScript("window.scroll(140, 140)", webElement);

                        Thread.sleep(2000);
                        // js.executeScript("arguments[0].scrollIntoView();",webElement);
                      /*  action.moveToElement(webElement).clickAndHold();
                        action.moveByOffset(100, 0);
                        action.release();
                        action.perform();*/

                    }
                      /*else {

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
                    }*/


                } catch (Exception e) {
                    logger.warn("Error while bringing element into view horizontally on the screen: " + e.getMessage());
                }

            }

        } catch (Exception e) {
            logger.error("Error while executing method 'bringElementIntoViewHorizontally_DisplayMatrDoc_AddItem': " + e.getMessage());
        }
    }

}
