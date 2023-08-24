package pl.plsmi.swingdictionary;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class MenuBar extends JMenuBar implements ActionListener {

    JMenu fileMenu;
    JMenuItem loadFileMenuItem;

    MenuBar() {
        this.fileMenu = new JMenu("File");
        this.loadFileMenuItem = new JMenuItem("Load file");

        this.loadFileMenuItem.addActionListener(this);

        fileMenu.add(loadFileMenuItem);

        this.add(fileMenu);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == this.loadFileMenuItem) {
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showOpenDialog(null);
            if (response == JFileChooser.APPROVE_OPTION) {
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.println(file);
            }
        }
    }
}
