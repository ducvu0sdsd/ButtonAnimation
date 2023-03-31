package Component;

import javax.swing.*;
import java.awt.*;

public class Childrendoc extends JPanel {
    public Childrendoc () {
        setBackground(null);
        setOpaque(false);
        setBorder(null);
        setLayout(null);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int w = getWidth(), h = getHeight();
        GradientPaint gp = new GradientPaint(0, 0, Color.decode("#ffffff"), w, h, Color.decode("#ffffff"));
        g2d.setPaint(gp);
        g2d.fillRoundRect(0, 0, w, h,40,40);
    }
}
