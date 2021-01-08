package ax.generic;

import init.settings.SeleniumSetUp;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.Point;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;

public class Graphics_Screenshots extends SeleniumSetUp {

    public static Logger logger = org.apache.log4j.Logger.getLogger  (Graphics_Screenshots.class);

    //Use this method to create a current image of a certain form or page
    public static void captureWebElementScreenshot(String ElemXpath, String FileName, String WindowName, String fullPath)  {

        try {
            //Locate Image element to capture screenshot.
            WebElement Image1 = driver.findElement (By.xpath (ElemXpath));

            //Capture entire page screenshot as buffer.
            File screen = ((TakesScreenshot) driver).getScreenshotAs (OutputType.FILE);

            //Used selenium getSize() method to get height and width of element.
            //Retrieve width of element.
            int ImageWidth = Image1.getSize ( ).getWidth ( );
            //Retrieve height of element.
            int ImageHeight = Image1.getSize ( ).getHeight ( );

            //Use selenium Point class to get x y coordinates of Image element.
            //get location(x y coordinates) of the element.
            Point point = Image1.getLocation ( );
            int xcord = point.getX ( );
            int ycord = point.getY ( );

            String format = "png";

            fullPath = fullPath + FileName + format;

            //Reading full image screenshot.
            BufferedImage img = ImageIO.read (screen);

            //cut Image using height, width and x y coordinates parameters.
            BufferedImage dest = img.getSubimage (xcord, ycord, ImageWidth, ImageHeight);
            ImageIO.write (dest, format, new File (fullPath));

            logger.info (WindowName + " window screenshot was made. ");


        } catch (Exception e9) {
            logger.error ("Unable to run 'captureWebElementScreenshot' method: " + e9.getMessage ( ));
        }
    }


    //Use this method to create a current image of a certain form or page
    public static void captureErrorScreenshot(String ElemXpath, String FileName, String fullPath)  {

        try {
            //Locate Image element to capture screenshot.
            WebElement Image1 = driver.findElement (By.xpath (ElemXpath));

            //Capture entire page screenshot as buffer.
            File screen = ((TakesScreenshot) driver).getScreenshotAs (OutputType.FILE);

            //Used selenium getSize() method to get height and width of element.
            //Retrieve width of element.
            int ImageWidth = Image1.getSize ( ).getWidth ( );
            //Retrieve height of element.
            int ImageHeight = Image1.getSize ( ).getHeight ( );

            //Use selenium Point class to get x y coordinates of Image element.
            //get location(x y coordinates) of the element.
            Point point = Image1.getLocation ( );
            int xcord = point.getX ( );
            int ycord = point.getY ( );

            String format = "png";

            fullPath = fullPath + FileName + format;

            //Reading full image screenshot.
            BufferedImage img = ImageIO.read (screen);

            //cut Image using height, width and x y coordinates parameters.
            BufferedImage dest = img.getSubimage (xcord, ycord, ImageWidth, ImageHeight);
            ImageIO.write (dest, format, new File (fullPath));



        } catch (Exception e9) {
            logger.error ("Unable to run 'captureWebElementScreenshot' method: " + e9.getMessage ( ));
        }
    }

    public static void deleteFilesFromFolder(String file_path){

        //Deleting old image files from 'current_images' folder
        File file = new File (file_path);
        String[] myFiles;
        if (file.isDirectory ( )) {

            try {
                myFiles = file.list ( );
                for (int i = 0; i < myFiles.length; i++) {
                    File myFile = new File (file, myFiles[i]);
                    myFile.delete ( );
                }
            } catch (Exception e) {
                logger.error ("Unable to delete old image files from '"+ file_path +"' folder: " + e.getMessage ( ));
            }
        }

    }

    public static boolean checkFileExists(String file_path){

        //Checking whether a specific file exists in a specific folder
        File file = new File (file_path);
        Boolean fileExists=false;

        if (file.isFile ( )) {
            try {
                if (file.exists()){
                    fileExists=true;
                }

            } catch (Exception e) {
                logger.error ("Error while checking file existance in the folder '"+ file_path + e.getMessage ( ));
            }
        }

        return fileExists;
    }


}
