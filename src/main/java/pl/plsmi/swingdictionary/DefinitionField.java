package pl.plsmi.swingdictionary;

import javax.swing.*;
import java.awt.*;

public class DefinitionField extends JTextArea {

    DefinitionField() {
        this.setPreferredSize(new Dimension(200,200));
        this.setLineWrap(true);
    }

}
