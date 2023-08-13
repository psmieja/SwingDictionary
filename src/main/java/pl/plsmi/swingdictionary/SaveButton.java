package pl.plsmi.swingdictionary;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SaveButton extends JButton implements ActionListener {

    MutableInt currentlyEditedIdx;
    DefinitionField definitionField;
//    JList<DictionaryEntry> dictionaryJList;
    DefaultListModel<DictionaryEntry> dictionaryListModel;

    SaveButton(
//            JList<DictionaryEntry> dictionaryJList,
            DefaultListModel<DictionaryEntry> dictionaryListModel,
            MutableInt currentlyEditedIdx,
            DefinitionField definitionField) {

//        this.dictionaryJList = dictionaryJList;
        this.dictionaryListModel = dictionaryListModel;
        this.currentlyEditedIdx = currentlyEditedIdx;
        this.definitionField = definitionField;

        this.setText("Save");

        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        dictionaryListModel.getElementAt(currentlyEditedIdx.getValue()).definition = definitionField.getText();
        System.out.println(currentlyEditedIdx + " " + definitionField.getText());
    }

}