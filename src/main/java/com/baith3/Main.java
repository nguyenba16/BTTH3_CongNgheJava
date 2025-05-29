package com.baith3;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Item> items = new ArrayList<>();
        items.add(new Item("4DFWD Pulse Shoes", "Adidas", 16000.0, "This product is excluded from This product is excluded from...", "/assets/img1.png"));
        items.add(new Item("4DFWD Pulse Shoes", "Adidas", 16000.0, "This product is excluded from This product is excluded from...", "/assets/img2.png"));
        items.add(new Item("4DFWD Pulse Shoes", "Adidas", 16000.0, "This product is excluded from This product is excluded from...", "/assets/img3.png"));
        items.add(new Item("4DFWD Pulse Shoes", "Adidas", 16000.0, "This product is excluded from This product is excluded from...", "/assets/img4.png"));
        items.add(new Item("4DFWD Pulse Shoes", "Adidas", 16000.0, "This product is excluded from This product is excluded from...", "/assets/img5.png"));
        items.add(new Item("4DFWD Pulse Shoes", "Adidas", 16000.0, "This product is excluded from This product is excluded from...", "/assets/img6.png"));

        JFrame frame = new JFrame("Shop GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1180, 600);

        JPanel mainPanel = new JPanel(new BorderLayout());

        LeftLayout leftPanel = new LeftLayout();
        leftPanel.updateInfo(items.get(0));

        RightLayout rightPanel = new RightLayout(items, leftPanel);

        JScrollPane scrollPane = new JScrollPane(rightPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16); // cuộn mượt hơn

        mainPanel.add(leftPanel, BorderLayout.WEST);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        frame.setContentPane(mainPanel);
        frame.setVisible(true);
    }
}
