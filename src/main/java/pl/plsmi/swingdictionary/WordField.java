package pl.plsmi.swingdictionary;

import javax.swing.*;
import java.awt.*;

public class WordField extends JTextArea {

    WordField() {
        this.setPreferredSize(new Dimension(200,20));
        this.setLineWrap(true);
    }

}
