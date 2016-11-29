package com.findv.metro2v.utils;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author MOILING
 */
public class WindowHandler extends WindowAdapter {
    @Override
    public void windowActivated(WindowEvent e) {
        super.windowActivated(e);
    }

    @Override
    public void windowClosed(WindowEvent e) {
        super.windowClosed(e);
    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        super.windowDeactivated(e);
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        super.windowDeiconified(e);
    }
}
