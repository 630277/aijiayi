package com.base.stonepuzzle;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainFrame extends JFrame implements KeyListener {
    int [][] data = {
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12},
            {13,14,15,0}
    };
    public MainFrame(){
        this.addKeyListener(this);
        initFrame();
        initData();
        paintView();

        setVisible(true);
    }
//    JFrame frame = new JFrame();
    /**
     *
     */
    public void initFrame(){


        setSize(514, 595);
        super.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Test");
        setAlwaysOnTop(true);
        setLocationRelativeTo(null);
        setLayout(null);


    }

    public void initData(){
        Random r = new Random();
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                int rx = r.nextInt(4);
                int ry = r.nextInt(4);

                int temp = data[i][j];
                data[i][j] = data[rx][ry];
                data[rx][ry] = temp;
            }
        }
    }

    public void paintView(){

        List<JLabel> jLabelList = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                String path = "E:\\image\\" + data[i][j] + ".png";
                JLabel jLabel = new JLabel(new ImageIcon(path));
                int x = j * 100 + 50;
                int y = i * 100 + 90;
                jLabel.setBounds(x, y, 100, 100);
                jLabelList.add(jLabel);
                getContentPane().add(jLabel);
            }
        }
        String path = "E:\\image\\background.png";
        JLabel background = new JLabel(new ImageIcon(path));
        background.setBounds(26,30,450,484);
        getContentPane().add(background);
    }
    @Override
    public void keyPressed(KeyEvent e) {
        move(e);
    }

    /**
     *
     * @param e
     */
    private static void move(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode==37){
            System.out.println("左");
        }else if (keyCode==38){
            System.out.println("上");
        }else if (keyCode==39){
            System.out.println("右");
        }else if (keyCode==40){
            System.out.println("下");
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }


    @Override
    public void keyReleased(KeyEvent e) {

    }
}
