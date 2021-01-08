package ax.generic;

import init.settings.SeleniumSetUp;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.jsoup.Jsoup;

import java.awt.*;
import java.awt.datatransfer.*;
import java.io.*;

public class FileProcessing extends SeleniumSetUp {

    final static Logger logger = Logger.getLogger(FileProcessing.class);

    public static void deleteOld_Files(String filepath, String filename) throws Exception {

        //Deleting old files
        File file = new File(filepath);

        String[] myFiles;
        if (file.isDirectory ( )) {
            try {
                LogManager.resetConfiguration ( );
                myFiles = file.list ( );
                for (int l = 0; l < myFiles.length; l++) {
                    File myFile4 = new File (file, myFiles[l]);
                      myFile4.delete();
                }
            } catch (Exception e) {
                logger.error("Unable to delete old " + filename + " " + e.getMessage());
            }
        } else {

            logger.error("Unable to find old " + filename);

        }
    }

    public static void writeVariable_intoTXTfile(int number) throws Exception {

        try {
            PrintWriter writer = new PrintWriter(".\\src\\main\\resources\\temp_files\\*.txt", "UTF-8");

            writer.println(number);

            writer.close();
        } catch (Exception e) {

            logger.error("Unable to save variable into 'STORE_VAR.TXT' file: " + e.getMessage());

        }
    }


    public static Integer readVariable_fromTXTfile() throws IOException {

        int number = 0;
        try {
            FileReader fr = new FileReader(".\\src\\main\\resources\\temp_files\\*.txt");
            BufferedReader br = new BufferedReader(fr);

            number = Integer.parseInt(br.readLine());

        } catch (Exception e) {
            logger.error("Unable to find 'STORE_VAR.TXT' file: " + e.getMessage());
            driver.quit();
        }
        return number;
    }


    public static void writeToClipboard(String s, ClipboardOwner owner) {

        //String myString = "This text will be copied into clipboard when running this code!";
        StringSelection stringSelection = new StringSelection(s);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);

    }


    public static Integer getClipboard() {
        Transferable t = Toolkit.getDefaultToolkit().getSystemClipboard().getContents(null);
        Integer i = 0;
        try {
            if (t != null && t.isDataFlavorSupported(DataFlavor.stringFlavor)) {
                String text = (String) t.getTransferData(DataFlavor.stringFlavor);
                i = Integer.valueOf(text.trim());

            }
        } catch (Exception e) {
        }

        return i;
    }


    public static String copyToClipBoard() throws IOException, UnsupportedFlavorException {
        String clipText = "";

        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        Transferable contents = clipboard.getContents(null);
        if ((contents != null) && contents.isDataFlavorSupported(DataFlavor.stringFlavor)) {

            clipText = (String) contents.getTransferData(DataFlavor.stringFlavor);

        }
        return clipText;
    }



    public static void insertingScreenshotLinksIntoLoggerHTMLfile(String filePrefix, String tdLineBeforeChange, String baselineScreen, String endText) throws IOException {

        File input = new File (".\\src\\main\\resources\\log_files_temp\\"+filePrefix.toUpperCase()+"-log4j-application.html");
       org.jsoup.nodes.Document doc = Jsoup.parse (input, "UTF-8", "");
        FileWriter fWriter= null;
        BufferedWriter writer = null;


        String html2 = doc.outerHtml ( ).toString ( );

        String tdLineAfterChange = baselineScreen + " " + endText;

        if (html2.contains (tdLineBeforeChange)) {
            String replaceLine = html2.replace(tdLineBeforeChange,tdLineAfterChange);


            try {
                fWriter = new FileWriter(".\\src\\main\\resources\\log_files_temp\\"+filePrefix.toUpperCase()+"-log4j-application.html");
                writer = new BufferedWriter (fWriter);
                writer.write (replaceLine);
                writer.newLine ( ); //this is not actually needed for html files - can make your code more readable though
                writer.close ( ); //make sure you close the writer object

            } catch (Exception e) {
                logger.error ("Unable to write changes into '"+filePrefix.toUpperCase()+"-log4j-application.html' file: " + e.getMessage ( ));
            }

        }
    }


    public static void renameLogHTMLfile(String ItemCategory) throws IOException {

        File input = new File (".\\src\\main\\resources\\log_files\\log4j-application.html");
        File output = new File (".\\src\\main\\resources\\log_files_temp\\"+ItemCategory.toUpperCase()+"-log4j-application.html");

        InputStream inputStream = null;
        OutputStream outputStream = null;


            try {

                inputStream = new FileInputStream(input);
                outputStream = new FileOutputStream(output);

                byte[] buffer = new byte[1024];
                int length = 0;
                while ((length = inputStream.read(buffer)) > 0) {
                    outputStream.write(buffer, 0, length);
                }

            } finally {
            inputStream.close();
            outputStream.close();
        }

        }

}
