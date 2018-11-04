package com.grayliu.kafka;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by liuhui-ds9 on 2018/2/6.
 */
public class InputFive extends JFrame {

    private static int WindowWidth = 500;
    private static int WindowHeight = 200;

    public static void main(String... args) {

//        EventQueue.invokeLater(new Thread() {
//            public void run() {
//
//            }
//        });

        InputFive inputFive = new InputFive();
        inputFive.setSize(WindowWidth, WindowHeight);

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        inputFive.setLocation((int) toolkit.getScreenSize().getWidth() / 2 - WindowWidth, (int) toolkit.getScreenSize().getHeight() / 2 - WindowHeight);
        inputFive.setVisible(true);

        final StateMonitor stateMonitor = new InputFive().new StateMonitor();

        inputFive.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
                if (Character.valueOf(e.getKeyChar()).toString().equals(Character.valueOf(stateMonitor.getChar()).toString().toLowerCase())) {
                    System.out.println(e);
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                System.out.println(e);
            }
        });

        JPanel jPanel = new JPanel();
        jPanel.setSize(WindowWidth, WindowHeight);

        inputFive.add(jPanel);

    }

    class StateMonitor {
        char c = 'a';

        public char getChar() {
            return c;
        }

        public void setChar(char c) {
            this.c = c;
        }
    }

}


//for(int i =0 ; i < 26; i++){
//            int m = 'A' + i;
//            final char c = (char)m;
//            JButton button = new JButton(c + "");
//            button.setSize(10, 10);
////        A.addActionListener(new ActionListener(){
////            @Override
////            public void actionPerformed(ActionEvent e) {
////                System.out.print(e);
////            }
////        });
//            button.addKeyListener(new KeyListener() {
//
//                @Override
//                public void keyTyped(KeyEvent e) {
//                    if(Character.valueOf(e.getKeyChar()).toString().equals(Character.valueOf(c).toString().toLowerCase())){
//                        System.out.println(e);
//                    }
//                }
//
//                @Override
//                public void keyPressed(KeyEvent e) {
////                    System.out.println(e);
//                }
//
//                @Override
//                public void keyReleased(KeyEvent e) {
////                System.out.println(e);
//                }
//            });
//            jPanel.add(button);
//        }