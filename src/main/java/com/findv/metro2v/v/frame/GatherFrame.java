package com.findv.metro2v.v.frame;

import com.findv.metro2v.model.Line;
import com.findv.metro2v.model.Point;
import com.findv.metro2v.model.V;
import com.findv.metro2v.utils.WindowJumper;
import com.google.gson.GsonBuilder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;


/**
 * @author MOILING
 */
public class GatherFrame extends BaseFrame {

    private int picWidth, picHeight;
    private int currentId = 0;
    private V v;

    public GatherFrame() {
        super("MetroV", 500, 200);
    }

    @Override
    protected JPanel onSetContentPane() {
        return new GatherPanel();
    }

    class GatherPanel extends JPanel {
        private JLabel mImageLabel;
        private List<Integer> circleX = new ArrayList<>(), circleY = new ArrayList<>();
        private int circleR;
        private TextFrame textFrame;

        GatherPanel() {
            initV();
            setLayout(new BorderLayout());
            ImageIcon image = new ImageIcon(WindowJumper.extra);
            mImageLabel = new JLabel(image);
            setSize(picWidth = image.getIconWidth(), picHeight = image.getIconHeight());
            GatherFrame.this.setSize(image.getIconWidth(), image.getIconHeight());
            this.add(mImageLabel, BorderLayout.CENTER);

            mImageLabel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    super.mouseClicked(e);
                    double x = e.getX() / (double) picWidth;
                    double y = e.getY() / (double) picHeight;
                    String name = JOptionPane.showInputDialog(null, "请输入站点名");
                    if (name == null) {
                        return;
                    }
                    Point point = new Point(currentId++, name, x, y);
                    paintCircle(e.getX(), e.getY());
                    v.getPoint().add(point);
                    if (textFrame == null) {
                        textFrame = new TextFrame("TextV", 300, 500,
                                GatherFrame.this.getX() + getWidth(), GatherFrame.this.getY(),
                                new GsonBuilder().setPrettyPrinting().create().toJson(v));
                    } else {
                        textFrame.setText(new GsonBuilder().setPrettyPrinting().create().toJson(v));
                    }

                    System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(v));
                }
            });
        }

        private void initV() {
            v = new V(new ArrayList<>(), new ArrayList<>());
            v.getLine().add(new Line(0, "", new ArrayList<>()));
        }

        private void paintCircle(int x, int y) {
            paintCircle(4, x, y);
        }

        private void paintCircle(int r, int x, int y) {
            circleR = r;
            circleX.add(x);
            circleY.add(y);
            repaint();
        }

        @Override
        public void paint(Graphics g) {
            super.paint(g);
            for (int i = 0; i < circleX.size(); i++) {
                g.setColor(Color.CYAN);
                g.fillOval(circleX.get(i) - circleR, circleY.get(i) - circleR, 2 * circleR, 2 * circleR);
                /*
                if (i != 0)
                    g.drawLine(circleX.get(i - 1) - circleR, circleY.get(i - 1) - circleR,
                            circleX.get(i) - circleR, circleY.get(i) - circleR);
                */
                g.setColor(Color.DARK_GRAY);
                g.drawString(i + ": " + v.getPoint().get(i).getName(), circleX.get(i) - circleR, circleY.get(i) - circleR);
            }
        }
    }
}
