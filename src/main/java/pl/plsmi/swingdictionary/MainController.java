package pl.plsmi.swingdictionary;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainController implements ActionListener {

    DefaultListModel<DictionaryEntry> dictionaryListModel;
    JTextArea definitionField;

    MainController(DefaultListModel<DictionaryEntry> dictionaryListModel,
                   JTextArea definitionField) {
        this.dictionaryListModel = dictionaryListModel;
        this.definitionField = definitionField;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }

}
