package pl.plsmi.swingdictionary;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import javax.swing.*;
import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Dictionary;
import java.util.List;

public class DictionaryListModel extends DefaultListModel<DictionaryEntry> {

    ArrayList<DictionaryEntry> allContents;

    DictionaryListModel() {
        this.allContents = new ArrayList<DictionaryEntry>();
    }

    public void filter(String filter) {
        for (DictionaryEntry entry : allContents) {
            if (entry.word.toLowerCase().contains(filter.toLowerCase())) {
                if (!this.contains(entry)) {
                    this.addElement(entry);
                }
            } else {
                if (this.contains(entry)) {
                    this.removeElement(entry);
                }
            }
        }
    }

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
        // first remove old contents
        // TODO: add warning if unsaved changes
        this.allContents.clear();
        this.clear();
        // then add new ones
        try (FileReader fileReader = new FileReader(file)) {
            CSVReader csvReader = new CSVReader(fileReader);
            String[] line;
            while ((line = csvReader.readNext()) != null) {
                DictionaryEntry newEntry = new DictionaryEntry(line[0], line[1]);
                this.allContents.add(newEntry); // we add to the arraylist of unfiltered contents
                this.addElement(newEntry); // and to the currently displayed contents
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
