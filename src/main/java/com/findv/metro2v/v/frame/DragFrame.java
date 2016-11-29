package com.findv.metro2v.v.frame;


import com.findv.metro2v.utils.WindowJumper;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetAdapter;
import java.awt.dnd.DropTargetDropEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author MOILING
 */
public class DragFrame extends BaseFrame {

    public DragFrame() {
        super("DragV", 300, 300);
    }

    @Override
    protected JPanel onSetContentPane() {
        return new DragPanel();
    }

    class DragPanel extends JPanel {
        DragPanel() {
            setBackground(Color.LIGHT_GRAY);
            setLayout(new BorderLayout());
            JLabel text = new JLabel("< 将图片拖拽于此 >", JLabel.CENTER);
            add(text, BorderLayout.CENTER);
            drag();
        }
        private void drag() {
            new DropTarget(this, DnDConstants.ACTION_COPY_OR_MOVE, new DropTargetAdapter() {
                public void drop(DropTargetDropEvent event) {
                    try {
                        if (event.isDataFlavorSupported(DataFlavor.javaFileListFlavor)) {
                            event.acceptDrop(DnDConstants.ACTION_COPY_OR_MOVE);
                            @SuppressWarnings("unchecked")
                            List<File> files = (List<File>) event.getTransferable().getTransferData(DataFlavor.javaFileListFlavor);
                            event.dropComplete(true);
                            // 只允许拖入一张图片！
                            WindowJumper.jump(DragFrame.this, GatherFrame.class, files.get(0).getAbsolutePath());
                        } else {
                            event.rejectDrop();
                        }
                    } catch (UnsupportedFlavorException | IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}
