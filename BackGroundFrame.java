import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.NativeLibraryLocator;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

public class BackGroundFrame extends JFrame implements NativeKeyListener {

    private boolean iscPressed;
    private boolean isControlPressed;
    private LinkedList<String> clipList = new LinkedList<String>();

    public BackGroundFrame() {

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        this.pack();

        try {
            GlobalScreen.registerNativeHook();
        } catch (NativeHookException ex) {
            //ex.printStackTrace();
        }

        GlobalScreen.addNativeKeyListener(this);

        System.out.println("Initiating BG-listenerframe");

    }

    public String getClip() {
        String clip = "";
        try {
            clip = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
            return clip;
        } catch (UnsupportedFlavorException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return clip;
    }

    @Override
    public void nativeKeyPressed(NativeKeyEvent e) {

        System.out.println("SOMETHING PRESSED");

        if (e.getKeyCode() == e.VC_CONTROL) {
            isControlPressed = true;
        } else if (e.getKeyCode() == e.VC_C) {
            iscPressed = true;
        }

        if (iscPressed & isControlPressed) {
            System.out.println("COMBINATION PRESSED");
            clipList.addFirst(getClip());
        }
    }

    @Override
    public void nativeKeyTyped(NativeKeyEvent e) {

    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent e) {
        if (e.getKeyCode() == e.VC_CONTROL) {
            isControlPressed = false;
        } else if (e.getKeyCode() == e.VC_C) {
            iscPressed = false;
        }
    }
}
