package pl.plsmi.swingdictionary;

import javax.swing.*;
import java.util.Collections;
import java.util.List;

public class DictionaryListModel extends DefaultListModel<DictionaryEntry> {

    public void sort() {
        //seems like a very inefficient solution TODO: try to make it better...
        List<DictionaryEntry> elementList = Collections.list(this.elements());
        Collections.sort(elementList);
        this.clear();
        for(DictionaryEntry entry:elementList){
            this.addElement(entry);
        }
        fireContentsChanged(this, 0, this.size());
    }
}
