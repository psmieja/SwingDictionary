package pl.plsmi.swingdictionary;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class SaveButton extends JButton implements ActionListener {

    MutableInt currentlyEditedIdx;
    WordField wordField;
    DefinitionField definitionField;
    DictionaryListModel dictionaryListModel;

    SaveButton(
            DictionaryListModel dictionaryListModel,
            MutableInt currentlyEditedIdx,
            WordField wordField,
            DefinitionField definitionField) {

        this.dictionaryListModel = dictionaryListModel;
        this.currentlyEditedIdx = currentlyEditedIdx;
        this.wordField = wordField;
        this.definitionField = definitionField;

        this.setText("Save");

        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (currentlyEditedIdx.equals(-2)) { // new word
            System.out.println("new word added");
            dictionaryListModel.addElement(
                    new DictionaryEntry(
                            wordField.getText(),
                            definitionField.getText())
            );
        } else { // edited existing word
            dictionaryListModel.getElementAt(currentlyEditedIdx.getValue()).word = wordField.getText();
            dictionaryListModel.getElementAt(currentlyEditedIdx.getValue()).definition = definitionField.getText();
        }
        dictionaryListModel.sort();
        currentlyEditedIdx.setValue(dictionaryListModel.size() - 1);
    }
}