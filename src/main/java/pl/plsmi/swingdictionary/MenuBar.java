package pl.plsmi.swingdictionary;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class MenuBar extends JMenuBar implements ActionListener {

    JMenu fileMenu;
    JMenuItem loadFileMenuItem;
    JMenuItem saveFileMenuItem;
    JMenuItem saveAsFileMenuItem;
    DictionaryListModel dictionaryListModel;
    File currentFile;

    MenuBar(DictionaryListModel dictionaryListModel, File currentFile) {
        this.fileMenu = new JMenu("File");

        this.loadFileMenuItem = new JMenuItem("Load from CSV");
        this.saveFileMenuItem = new JMenuItem("Save");
        this.saveAsFileMenuItem = new JMenuItem("Save as");

        this.currentFile = currentFile;
        this.dictionaryListModel = dictionaryListModel;

        this.loadFileMenuItem.addActionListener(this);
        this.saveFileMenuItem.addActionListener(this);
        this.saveAsFileMenuItem.addActionListener(this);

        fileMenu.add(loadFileMenuItem);
        fileMenu.add(saveFileMenuItem);
        fileMenu.add(saveAsFileMenuItem);

        this.add(fileMenu);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == this.loadFileMenuItem) {
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showOpenDialog(null);
            if (response == JFileChooser.APPROVE_OPTION) {
                currentFile = new File(fileChooser.getSelectedFile().getAbsolutePath());
                this.dictionaryListModel.setContentsFromFile(currentFile);
            }
        } else if (event.getSource() == this.saveFileMenuItem) {
            if (currentFile == null) {
                JFileChooser fileChooser = new JFileChooser();
                if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                    currentFile = fileChooser.getSelectedFile();
                }
            }
            this.dictionaryListModel.saveContentsToFile(currentFile);
        } else if (event.getSource() == this.saveAsFileMenuItem) {
            JFileChooser fileChooser = new JFileChooser();
            if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                currentFile = fileChooser.getSelectedFile();
            }
            this.dictionaryListModel.saveContentsToFile(currentFile);
        }
    }
}
