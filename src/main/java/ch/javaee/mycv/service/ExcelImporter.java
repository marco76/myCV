package ch.javaee.mycv.service;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import javax.ejb.Stateless;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by marco on 14/03/16.
 */

@Stateless
public class ExcelImporter {

    public void importExcelFile() throws FileNotFoundException {

        FileInputStream inp = new FileInputStream( new File(""));
        Workbook workbook = null;
        try {
            workbook = WorkbookFactory.create( inp );
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }

        // Get the first Sheet.
        Sheet sheet = workbook.getSheetAt( 0 );

        // Start constructing JSON.
        JsonObject value = Json.createObjectBuilder().build();
        // Iterate through the rows.
        JsonArrayBuilder rowsBuilder = Json.createArrayBuilder();

    }
}
