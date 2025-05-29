package com.baith3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.List;

public class RightLayout extends JPanel {
     private JPanel selectedCard = null;  // lưu card đang chọn
    private final Color defaultBorderColor = new Color(200, 200, 200);
    private final Color selectedBorderColor = new Color(30, 144, 255);
    public RightLayout(List<Item> items, LeftLayout leftPanel) {
        setBackground(Color.WHITE);
        setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        setLayout(new GridLayout(0, 3, 10, 10));

        for (Item item : items) {
            JPanel card = new JPanel();
            card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
            card.setBackground(Color.WHITE);
            card.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1, true));
            card.setPreferredSize(new Dimension(180, 280));
            JLabel titleLabel = new JLabel(item.getName());
            titleLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
            titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            JLabel descLabel = new JLabel("<html><center>" + item.getDesc() + "</center></html>");
            descLabel.setFont(new Font("SansSerif", Font.PLAIN, 12));
            descLabel.setForeground(Color.GRAY);
            descLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            JLabel imgLabel;
            URL imageURL = getClass().getResource(item.getImagePath());
            if (imageURL != null) {
                ImageIcon imageIcon = new ImageIcon(imageURL);
                Image img = imageIcon.getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH);
                imgLabel = new JLabel(new ImageIcon(img));
            } else {
                imgLabel = new JLabel("No image");
            }
            imgLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            JPanel bottomPanel = new JPanel(new BorderLayout());
            bottomPanel.setMaximumSize(new Dimension(160, 30));
            bottomPanel.setOpaque(false);
            JLabel brandLabel = new JLabel(item.getBrand());
            brandLabel.setFont(new Font("SansSerif", Font.PLAIN, 12));
            bottomPanel.add(brandLabel, BorderLayout.WEST);
            JLabel priceLabel = new JLabel("$" + item.getPrice());
            priceLabel.setFont(new Font("SansSerif", Font.BOLD, 12));
            bottomPanel.add(priceLabel, BorderLayout.EAST);
            card.add(Box.createRigidArea(new Dimension(0, 5)));
            card.add(titleLabel);
            card.add(Box.createRigidArea(new Dimension(0, 5)));
            card.add(descLabel);
            card.add(Box.createRigidArea(new Dimension(0, 5)));
            card.add(imgLabel);
            card.add(Box.createRigidArea(new Dimension(0, 5)));
            card.add(bottomPanel);
            card.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    leftPanel.updateInfo(item);
                }
            });
            
            card.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    // Bỏ chọn card cũ
                    if (selectedCard != null) {
                        selectedCard.setBorder(BorderFactory.createLineBorder(defaultBorderColor, 2, true));
                    }
                    // Chọn card mới
                    selectedCard = card;
                    selectedCard.setBorder(BorderFactory.createLineBorder(selectedBorderColor, 3, true));

                    // Cập nhật bên trái
                    leftPanel.updateInfo(item);

                    // Refresh giao diện
                    repaint();
                    revalidate();
                }
            });

            add(card);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        // Giả định mỗi card cao 280 + khoảng cách 10px, tối đa 3 cột
        int rows = (int) Math.ceil(getComponentCount() / 3.0);
        int height = rows * (280 + 10) + 10; // khoảng cách trên dưới
        int width = 3 * (180 + 10) + 10; // 3 cột + khoảng cách
        return new Dimension(width, height);
    }
}
