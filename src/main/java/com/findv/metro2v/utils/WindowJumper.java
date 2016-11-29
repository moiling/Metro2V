package com.findv.metro2v.utils;
import com.findv.metro2v.v.frame.BaseFrame;

import java.awt.*;

/**
 * @author MOILING
 */
public class WindowJumper {

    public static String extra;

    public static void jump(final BaseFrame<?> from, final Class<?> clazz) {
        jump(from, clazz, "");
    }

    public static void jump(final BaseFrame<?> from, final Class<?> clazz, String info) {
        EventQueue.invokeLater(() -> {
            try {
                extra = info;
                BaseFrame<?> to = (BaseFrame<?>) clazz.newInstance();
                to.setParentFrame(from);
                from.setVisible(false);
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        });
    }

    public static void back(final BaseFrame<?> thisFrame) {
        back(thisFrame, "");
    }

    public static void back(final BaseFrame<?> thisFrame, String info) {
        EventQueue.invokeLater(() -> {
            extra = info;
            thisFrame.dispose();
            thisFrame.getParentFrame().setVisible(true);
        });
    }
}
