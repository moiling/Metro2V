package com.findv.metro2v.v.panel;

import java.awt.*;

/**
 * @author MOILING
 */
public class PointPanel extends Panel {

    private int r, x, y;

    public PointPanel(int x, int y) {
        this(10, x, y);
    }

    public PointPanel(int r, int x, int y) {
        this.r = r;
        this.x = x;
        this.y = y;
    }
}
