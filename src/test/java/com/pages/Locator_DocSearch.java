package com.pages;

import init.settings.PageObject;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.project.Test_Cases;

import static ax.generic.Waitings.waitTillElementDetected;

public class Locator_DocSearch extends PageObject {

    public Logger logger = Logger.getLogger(Locator_DocSearch.class);


    //Locating document number
    //@FindBy(xpath = "//span[contains(text(), 'Standard Data Collation')]/ancestor::td[contains(@ct, 'MLC')][@class='lsContainerCell lsContainerCellVAlign--top urLayoutRPad']/parent::tr/td[2]/descendant::tbody[@class='urLinStd']/tr[1]/td[2]/descendant::span[contains(@ct, 'TV')]")
    @FindBy(xpath = "//span[contains(text(), 'Standard Data Collation') or ('Forwarding Agent-Related Data Collation') or ('Data collation with connection to the IDM transport planning') or ('Vehicle-Related Data Collation')]/ancestor::td[contains(@ct, 'MLC')][@class='lsContainerCell lsContainerCellVAlign--top urLayoutRPad']/parent::tr/td[2]/descendant::tbody[@class='urLinStd']/tr[1]/td[2]/descendant::span[contains(@ct, 'TV')]")
    private WebElement doc_Number;

    //Locating document status
    @FindBy(xpath = "//span[contains(text(), 'Standard Data Collation') or ('Forwarding Agent-Related Data Collation') or ('Data collation with connection to the IDM transport planning') or ('Vehicle-Related Data Collation')]/ancestor::td[contains(@ct, 'MLC')][@class='lsContainerCell lsContainerCellVAlign--top urLayoutRPad']/parent::tr/td[2]/descendant::tbody[@class='urLinStd']/tr[2]/td[2]/descendant::span[contains(@ct, 'TV')]")
    private WebElement doc_Status;




    //Constructor
    public Locator_DocSearch(WebDriver driver) {
        super(driver);

    }

    JavascriptExecutor js = (JavascriptExecutor) driver;
    Actions action = new Actions(driver);


    public boolean check_IfElementIsPresent(String xPath) {

        boolean elAvailability = false;

        try {//check if every column contains column title text
            driver.findElement(By.xpath(xPath));
            elAvailability = true;
        } catch (NoSuchElementException e) {
            elAvailability = false;
        }
        return elAvailability;
    }



    public void click_OnFirstRowWithFoundDoc() throws Exception {

        try {
            //Get the first row with document in the "Search Results" table
            // WebElement first_RowInSearchResultsTable = driver.findElement(By.ByXPath.xpath("//span[contains (text(), 'Results List:')]/ancestor::table[@class='urSTCS urST3WhlBrdH urST3WhlNoTit urST5SelColUiGeneric urHtmlTableReset'][contains (@ct, 'STCS')]/descendant::div[contains (@bisposelement, 'X')][contains (@class, 'urBorderBox')]/table[@class='urST5OuterOffBrd urBorderBox'][contains(@id,'mrss-cont-none-content')]/tbody/descendant::tr[1]"));
            WebElement first_RowInSearchResultsTable = driver.findElement(By.ByXPath.xpath("//span[contains (text(), 'Results List:')]/ancestor::table[@class='urSTCS urST3WhlBrdH urST3WhlNoTit urST5SelColUiGeneric urHtmlTableReset'][contains (@ct, 'STCS')]/tbody[1]/tr[2]/td[2]/descendant::span[contains(text(), '"+ Test_Cases.doc_Num+"')]"));



            //js.executeScript("arguments[0].click();", first_RowInSearchResultsTable);
            //action.click(first_RowInSearchResultsTable).build().perform();
            first_RowInSearchResultsTable.click();

            logger.info("The FIRST ROW in SEARCH RESULTS was SUCCESSFULLY clicked on.");

            //wait till document's status icon is displayed on "Standard Data Collation" page
            waitTillElementDetected(15, "//span[contains(text(), 'Vehicle-Related Data Collation')]/ancestor::td[contains(@ct, 'MLC')][@class='lsContainerCell lsContainerCellVAlign--top urLayoutRPad'][2]/parent::tr/td[2]/descendant::tbody[@class='urLinStd'][2]/tr[2]/td[2]/descendant::img[contains(@ct, 'IMG')]", "DOCUMENT's STATUS ICON");

            Thread.sleep(3000);

        } catch (NoSuchElementException e) {
            logger.error("No such element - Error while retrieving the first row with document details from the 'SEARCH RESULTS' table: " + e.getMessage());
        }

    }




}