package pl.plsmi.swingdictionary;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame {

    MenuBar menuBar;
    LeftPanel leftPanel;
    RightPanel rightPanel;

    JList<DictionaryEntry> dictionaryJList;
    DictionaryListModel dictionaryListModel;

    EditButton editButton;
    AddButton addButton;

    WordField wordField;
    DefinitionField definitionField;
    SaveButton saveButton;

    MutableInt currentlyEditedIdx;

    MainWindow() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800,500);
        this.setLayout(new BorderLayout());
        this.setVisible(true);

        //================================= menu
        this.menuBar = new MenuBar();
        this.setJMenuBar(menuBar);
        //================================= contents

        leftPanel = new LeftPanel();
        rightPanel = new RightPanel();

        dictionaryListModel = new DictionaryListModel();
        dictionaryListModel.addElement(new DictionaryEntry("potato", "ziemniak"));
        dictionaryListModel.addElement(new DictionaryEntry("bird", "ptak"));
        dictionaryListModel.addElement(new DictionaryEntry("cat", "kot"));
        dictionaryListModel.addElement(new DictionaryEntry("dog", "pies"));
        dictionaryListModel.sort();

        dictionaryJList = new JList<DictionaryEntry>(dictionaryListModel);
        MutableInt currentlyEditedIdx = new MutableInt();

        wordField = new WordField();
        definitionField = new DefinitionField();

        editButton = new EditButton(dictionaryJList, dictionaryListModel, currentlyEditedIdx, wordField, definitionField);
        saveButton = new SaveButton(dictionaryListModel, currentlyEditedIdx, wordField, definitionField);
        addButton  = new AddButton(dictionaryListModel, currentlyEditedIdx, wordField, definitionField);

        leftPanel.add(dictionaryJList);
        leftPanel.add(editButton);
        leftPanel.add(addButton);

        rightPanel.add(wordField);
        rightPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        rightPanel.add(definitionField);
        rightPanel.add(saveButton);

        this.add(leftPanel, BorderLayout.WEST);
        this.add(rightPanel, BorderLayout.EAST);
    }
}
