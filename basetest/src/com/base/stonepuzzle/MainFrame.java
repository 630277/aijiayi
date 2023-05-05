package com.base.stonepuzzle;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MainFrame extends JFrame {
    int [][] data = {
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12},
            {13,14,15,0}
    };
    public MainFrame(){
        initFrame();
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
}
