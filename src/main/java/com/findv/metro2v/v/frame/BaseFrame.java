package com.findv.metro2v.v.frame;


import com.findv.metro2v.utils.WindowHandler;

import javax.swing.*;
import java.awt.*;

/**
 * @author MOILING
 */
public abstract class BaseFrame<T extends JPanel> extends JFrame {

    private JFrame parentFrame;
    private JFrame currentFrame;
    private T contentPanel;

    protected T getContentPanel() {
        return contentPanel;
    }

    public JFrame getCurrentFrame() {
        return currentFrame;
    }

    public void setCurrentFrame(JFrame currentFrame) {
        this.currentFrame = currentFrame;
    }

    public JFrame getParentFrame() {
        return parentFrame;
    }

    public void setParentFrame(JFrame parentFrame) {
        this.parentFrame = parentFrame;
    }

    public BaseFrame(String title, int width, int height) {
        currentFrame = this;
        setSize(width, height);
        setTitle(title);

        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        setLocation((screenWidth - width) / 2, (screenHeight - height) / 2);
        setLocationByPlatform(false);

        contentPanel = onSetContentPane();
        setContentPane(contentPanel);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);

        addWindowListener(new WindowHandler());
    }

    protected abstract T onSetContentPane();

}
