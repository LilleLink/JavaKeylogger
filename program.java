import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.lang.annotation.Native;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.TimerTask;

public class program implements NativeKeyListener, ActionListener {

    private static LinkedList<String> keypressList = new LinkedList<String>();

    public static void main(String[]args) {

        //Initiate Native Keylistener

        try {
            GlobalScreen.registerNativeHook();
        } catch (NativeHookException e) {
            e.printStackTrace();
        }
        GlobalScreen.addNativeKeyListener(new program());

        //Initiate t
        timerInitiation();


    }

    public static void timerInitiation() {
        t = new Timer();
    }

    @Override
    public void nativeKeyPressed(NativeKeyEvent e) {
        keypressList.addLast(e.getKeyText(e.getKeyCode()));
    }

    @Override
    public void nativeKeyTyped(NativeKeyEvent e) {

    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent e) {
        if (e.isActionKey()) {
            keypressList.addLast(e.getKeyText(e.getKeyCode()) + " released");
        }
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
}
