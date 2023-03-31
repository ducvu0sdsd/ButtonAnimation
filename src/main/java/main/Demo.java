package main;

import Component.AnimationButton;

import javax.swing.*;

public class Demo extends JFrame {
    public Demo () {
        super("Button Animation");
        setSize(300,300);
        setLocationRelativeTo(null);
        setLayout(null);
        AnimationButton btn = new AnimationButton();
        btn.setBounds(100,100, 80, 40);
        add(btn);
    }
    public static void main(String[] args) {
        new Demo().setVisible(true);
    }
}
