package com.findv.metro2v.v.frame;

import javax.swing.*;
import java.awt.*;

/**
 * @author MOILING
 */
public class TextFrame extends BaseFrame {

    private JScrollPane scrollPane;
    private JTextArea textArea;

    public TextFrame(String title, int width, int height, int x, int y, String text) {
        super(title, width, height);
        setLocation(x, y);
        setText(text);
    }

    @Override
    protected JPanel onSetContentPane() {
        return new TextPanel();
    }

    class TextPanel extends JPanel {
        TextPanel() {
            setLayout(new BorderLayout());
            initScrollPane();
        }

        private void initScrollPane() {
            scrollPane = new JScrollPane();
            add(scrollPane, BorderLayout.CENTER);
            textArea = new JTextArea();
            scrollPane.setViewportView(textArea);
        }
    }

    public void setText(String text) {
        textArea.setText(text);
    }
}
