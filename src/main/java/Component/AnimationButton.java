package Component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AnimationButton extends JButton {
    public Color getColor1() {
        return color1;
    }

    public void setColor1(Color color1) {
        this.color1 = color1;
    }

    public Color getColor2() {
        return color2;
    }

    public void setColor2(Color color2) {
        this.color2 = color2;
    }

    private Color color1 = Color.decode("#111111");
    private Color color2 = Color.decode("#111111");
    private String status = "Close";
    private int xlocate = 0;
    private Childrendoc doc;
    public AnimationButton () {
        setBackground(null);
        setBorder(null);
        setOpaque(false);
        setLayout(null);
        setContentAreaFilled(false);
        doc = new Childrendoc();
        doc.setBounds(xlocate,0,40, 40);
        add(doc);
        addActionListener(new ActionListener() {
            private Timer t1;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (status.equals("Close")) {
                    status = "Open";
                    setColor1(Color.decode("#bc4e9c"));
                    setColor2(Color.decode("#f80759"));
                    t1 = new Timer(1, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if (xlocate < 40) {
                                xlocate += 2;
                                doc.setBounds(xlocate, 0, 40, 40);
                                invalidate();
                                validate();
                                repaint();
                            }
                            else {
                                xlocate = 40;
                                t1.stop();
                            }

                        }
                    });
                    t1.start();

                } else {
                    status = "Close";
                    setColor1(Color.decode("#111111"));
                    setColor2(Color.decode("#111111"));
                    t1 = new Timer(1, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if (xlocate > 0) {
                                xlocate -= 2;
                                doc.setBounds(xlocate, 0, 40, 40);
                                invalidate();
                                validate();
                                repaint();
                            }
                            else {
                                xlocate = 0;
                                t1.stop();
                            }
                        }
                    });
                    t1.start();
                }
            }
        });
    }

    // use function (Paint Component)
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int w = getWidth(), h = getHeight();
        GradientPaint gp = new GradientPaint(0, 0, color1, w, h, color2);
        g2d.setPaint(gp);
        g2d.fillRoundRect(0, 0, w, h,40,40);
    }



    // Thank For Watching !!!!!!
}
