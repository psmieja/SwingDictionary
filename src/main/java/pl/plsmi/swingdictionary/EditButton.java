package pl.plsmi.swingdictionary;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditButton extends JButton implements ActionListener {

    MutableInt currentlyEditedIdx;
    DefinitionField definitionField;
    JList<DictionaryEntry> dictionaryJList;
    DefaultListModel<DictionaryEntry> dictionaryListModel;

    EditButton(
            JList<DictionaryEntry> dictionaryJList,
            DefaultListModel<DictionaryEntry> dictionaryListModel,
            MutableInt currentlyEditedIdx,
            DefinitionField definitionField) {

        this.dictionaryJList = dictionaryJList;
        this.dictionaryListModel = dictionaryListModel;
        this.currentlyEditedIdx = currentlyEditedIdx;
        this.definitionField = definitionField;

        this.setText("Edit");

        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        currentlyEditedIdx.setValue(dictionaryJList.getSelectedIndex());
        definitionField.setText(
                dictionaryListModel.getElementAt(currentlyEditedIdx.getValue()).definition
        );
    }

}
