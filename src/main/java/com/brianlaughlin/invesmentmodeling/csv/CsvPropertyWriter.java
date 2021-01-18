package com.brianlaughlin.invesmentmodeling.csv;

import com.brianlaughlin.invesmentmodeling.citiesandproperty.Property;
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
    List<Property> properties;

    ICsvBeanWriter beanWriter = new CsvBeanWriter(new FileWriter(csvFileName),
            CsvPreference.STANDARD_PREFERENCE);

    public CsvPropertyWriter(String csvFileName, List<Property> properties) throws IOException {
        this.csvFileName = csvFileName;
        this.properties = properties;
    }

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


//    String[] header = {"Address", "City", "Zip", "Price", "Rehab", "Rent", "Gross %", "Est ARV", "Take out cost", "TOI Gross %", "Status"};

    int count = properties.size();
    String[] header = new String[count];

    public void makeHeader() {
        for (int i = 0; i < count; i++) header[i] = "Column" + count;
    }

//    public void write(Processor processor) {
//        for (Property p : properties) {
//            beanWriter.write(p, header, processor);
//        }
}


