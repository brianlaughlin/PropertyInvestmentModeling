package com.brianlaughlin.invesmentmodeling.csv;

import com.brianlaughlin.invesmentmodeling.model.PropertyExport;
import org.supercsv.cellprocessor.ParseDouble;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CsvPropertyWriter {

    String csvFileName;
    List<PropertyExport> properties;

    ICsvBeanWriter beanWriter = null;
    CellProcessor[] processor = new CellProcessor[]{
            new NotNull(),      // Address
            new NotNull(),      // City
            new NotNull(),      // Zip
            new ParseDouble(),  // Price
            new ParseDouble(),  // Rehab
            new ParseDouble(),  // Rent
            new ParseDouble(),  // Gross %
            new ParseDouble(),  // Est ARV
            new ParseDouble(),  // Take out cost
            new ParseDouble(),  // TOI Gross %
            new NotNull()      // Status
    };

    public CsvPropertyWriter(String csvFileName, List<PropertyExport> properties) throws IOException {
        this.csvFileName = csvFileName;
        this.properties = properties;
    }


    public void write() throws IOException {

        beanWriter = new CsvBeanWriter(new FileWriter(csvFileName), CsvPreference.STANDARD_PREFERENCE);
        String[] header = {"street", "city", "zipcode", "purchaseprice", "rehab", "rent", "cashoncashreturn", "estarv", "takeoutcost", "toipercentage", "status"};
        beanWriter.writeHeader(header);

        for (PropertyExport p : properties) {
            beanWriter.write(p, header, processor);
        }

        beanWriter.close();
    }
}

