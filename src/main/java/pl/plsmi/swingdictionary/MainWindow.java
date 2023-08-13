package pl.plsmi.swingdictionary;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame {

    LeftPanel leftPanel;
    RightPanel rightPanel;

    JList<DictionaryEntry> dictionaryJList;
    DefaultListModel<DictionaryEntry> dictionaryListModel;

    JButton editButton;
    DefinitionField definitionField;
    JButton saveButton;
    MutableInt currentlyEditedIdx;

    MainWindow() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800,500);
        this.setLayout(new BorderLayout());
        this.setVisible(true);

        leftPanel = new LeftPanel();
        rightPanel = new RightPanel();

        dictionaryListModel = new DefaultListModel<DictionaryEntry>();
        dictionaryListModel.addElement(new DictionaryEntry("potato", "ziemniak"));
        dictionaryListModel.addElement(new DictionaryEntry("bird", "ptak"));
        dictionaryListModel.addElement(new DictionaryEntry("cat", "kot"));
        dictionaryListModel.addElement(new DictionaryEntry("dog", "pies"));
        dictionaryJList = new JList<DictionaryEntry>(dictionaryListModel);
        MutableInt currentlyEditedIdx = new MutableInt();

        definitionField = new DefinitionField();

        editButton = new EditButton(dictionaryJList, dictionaryListModel, currentlyEditedIdx, definitionField);
        saveButton = new SaveButton(dictionaryListModel, currentlyEditedIdx, definitionField);

        leftPanel.add(dictionaryJList);
        leftPanel.add(editButton);

        rightPanel.add(definitionField);
        rightPanel.add(saveButton);

        this.add(leftPanel, BorderLayout.WEST);
        this.add(rightPanel, BorderLayout.EAST);
    }
}
