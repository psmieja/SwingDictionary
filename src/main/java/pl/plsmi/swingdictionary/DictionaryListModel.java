package pl.plsmi.swingdictionary;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import javax.swing.*;
import java.io.*;
import java.util.Collections;
import java.util.Dictionary;
import java.util.List;

public class DictionaryListModel extends DefaultListModel<DictionaryEntry> {

    public void sort() {
        //seems like a very inefficient solution TODO: try to make it better...
        List<DictionaryEntry> elementList = Collections.list(this.elements());
        Collections.sort(elementList);
        this.clear();
        for (DictionaryEntry entry : elementList) {
            this.addElement(entry);
        }
        fireContentsChanged(this, 0, this.size());
    }

    // TODO: better exception handling
    public void setContentsFromFile(File file) {
        try (FileReader fileReader = new FileReader(file)) {
            CSVReader csvReader = new CSVReader(fileReader);
            String[] line;
            while ((line = csvReader.readNext()) != null) {
                this.addElement(new DictionaryEntry(line[0], line[1]));
            }
        } catch (IOException e) {
            System.out.println("Unable to load file");
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
    }

    // TODO: better exception handling
    public void saveContentsToFile(File file) {
        try (FileWriter fileWriter = new FileWriter(file)) {
            CSVWriter csvWriter = new CSVWriter(fileWriter);
            for (int i = 0; i < this.size(); i++) {
                DictionaryEntry entry = this.getElementAt(i);
                csvWriter.writeNext(entry.toStringArray());
            }
        } catch (IOException e) {
            System.out.println("Unable to write to file");
        }
    }
}
