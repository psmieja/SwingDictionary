package pl.plsmi.swingdictionary;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddButton extends JButton implements ActionListener {

    MutableInt currentlyEditedIdx;
    WordField wordField;
    DefinitionField definitionField;
    JList<DictionaryEntry> dictionaryJList;
    DefaultListModel<DictionaryEntry> dictionaryListModel;

    AddButton(
            DictionaryListModel dictionaryListModel,
            MutableInt currentlyEditedIdx,
            WordField wordField,
            DefinitionField definitionField) {

        this.dictionaryListModel = dictionaryListModel;
        this.currentlyEditedIdx = currentlyEditedIdx;
        this.wordField = wordField;
        this.definitionField = definitionField;

        this.setText("Add");
        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        currentlyEditedIdx.setValue(-2); // -1 means no selected item
        wordField.setText("");
        definitionField.setText("");
    }
}