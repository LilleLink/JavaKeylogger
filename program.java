import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.Timer;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

public class program implements NativeKeyListener {

    private static LinkedList<Character> keypressList = new LinkedList<Character>();

    public static void main(String[]args) {

        //Initiate Native Keylistener here

        try {
            GlobalScreen.registerNativeHook();
        } catch (NativeHookException e) {
            e.printStackTrace();
        }
        GlobalScreen.addNativeKeyListener(new program());


        ActionListener taskPerformer = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                for (char c : keypressList) {
                    System.out.println(c);
                }
            }
        };
        new Timer(1000, taskPerformer).start();
        
    }

    @Override
    public void nativeKeyPressed(NativeKeyEvent e) {
        keypressList.addLast(e.getKeyChar());
    }

    @Override
    public void nativeKeyTyped(NativeKeyEvent e) {

    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent e) {
        /*if (e.isActionKey()) {
            keypressList.addLast(NativeKeyEvent.getKeyText(e.getKeyCode()) + " released");
        }*/
    }

    
}
