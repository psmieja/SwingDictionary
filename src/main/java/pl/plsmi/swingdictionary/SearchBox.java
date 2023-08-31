package pl.plsmi.swingdictionary;

import javax.swing.*;
import javax.swing.text.Caret;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class SearchBox extends JTextArea implements KeyListener {

    DictionaryListModel dictionaryListModel;
    boolean defaultContent;

    SearchBox(DictionaryListModel dictionaryListModel) {
        this.addKeyListener(this);
        this.dictionaryListModel = dictionaryListModel;
        this.setContentToDefault();
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {}

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        if (this.defaultContent) {
            this.setText("");
            this.defaultContent = false;
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        dictionaryListModel.filter(this.getText());
        if (this.getText().isEmpty()) {
            this.setContentToDefault();
        }
    }

    void setContentToDefault() {
        this.defaultContent = true;
        this.setText("Search");
        this.setCaretPosition(0);
    }

}
