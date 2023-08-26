package pl.plsmi.swingdictionary;

import javax.swing.*;
import java.awt.*;

public class RightPanel extends JPanel {

    RightPanel() {
        this.setBackground(Color.BLUE);
        this.setPreferredSize(new Dimension(500,200));
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }
}
