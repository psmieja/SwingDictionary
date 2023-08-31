package pl.plsmi.swingdictionary;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.io.File;

public class MainWindow extends JFrame {

    MenuBar menuBar;
    LeftPanel leftPanel;
    RightPanel rightPanel;

    SearchBox searchBox;
    JList<DictionaryEntry> dictionaryJList;
    DictionaryListModel dictionaryListModel;

    EditButton editButton;
    AddButton addButton;

    WordField wordField;
    DefinitionField definitionField;
    SaveButton saveButton;

    MutableInt currentlyEditedIdx;
    File currentFile;

    MainWindow() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(800,500));
        this.setResizable(false);
        this.setBackground(Color.GRAY);
        this.setLayout(null);

        this.dictionaryListModel = new DictionaryListModel();

        currentFile = null;
        currentlyEditedIdx = new MutableInt();

        searchBox = new SearchBox(dictionaryListModel);
        searchBox.setBounds(5,5,200,25);
        searchBox.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
        this.add(searchBox);

        dictionaryJList = new JList<DictionaryEntry>(dictionaryListModel);
        dictionaryJList.setBounds(5,35,200,300);
        dictionaryJList.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
        dictionaryJList.setLayoutOrientation(JList.VERTICAL);
        this.add(dictionaryJList);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(dictionaryJList);
        scrollPane.setBounds(5,35,200,300);
//        scrollPane.setBounds(205,5,10,300);
        this.add(scrollPane);

        menuBar = new MenuBar(this.dictionaryListModel, this.currentFile);
        this.setJMenuBar(menuBar);

        wordField = new WordField();
        wordField.setBounds(250,5,545,25);
        wordField.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
        this.add(wordField);

        definitionField = new DefinitionField();
        definitionField.setBounds(250,35,545,250);
        definitionField.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
        this.add(definitionField);

        editButton = new EditButton(dictionaryJList, dictionaryListModel, currentlyEditedIdx, wordField, definitionField);
        editButton.setBounds(5,340,100,50);
        this.add(editButton);

        addButton  = new AddButton(dictionaryListModel, currentlyEditedIdx, wordField, definitionField);
        addButton.setBounds(105,340,100,50);
        this.add(addButton);

        saveButton = new SaveButton(dictionaryListModel, currentlyEditedIdx, wordField, definitionField);
        saveButton.setBounds(695,290,100,50);
        this.add(saveButton);

        this.pack();
        this.setVisible(true);
    }
}
