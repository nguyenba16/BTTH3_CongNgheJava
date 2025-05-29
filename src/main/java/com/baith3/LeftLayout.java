package com.baith3;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class LeftLayout extends JPanel {

    private JLabel imageLabel;
    private JLabel nameLabel;
    private JLabel priceLabel;
    private JLabel brandLabel;
    private JLabel descLabel;

    public LeftLayout() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(450, 400));

        // Ảnh sản phẩm
        imageLabel = new JLabel();
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        imageLabel.setHorizontalAlignment(JLabel.CENTER);
        imageLabel.setPreferredSize(new Dimension(300, 300));
        imageLabel.setMaximumSize(new Dimension(300, 300));
        imageLabel.setMinimumSize(new Dimension(300, 300));
        imageLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0)); // cách đều 10px trên-dưới

        // Panel chứa thông tin chi tiết
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
        infoPanel.setBackground(Color.WHITE);
        infoPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        infoPanel.setMaximumSize(new Dimension(400, 200)); // cố định chiều rộng tối đa
        infoPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0)); // không thêm padding dư

        // Tên sản phẩm
        nameLabel = new JLabel("Tên sản phẩm");
        nameLabel.setFont(new Font("Arial", Font.BOLD, 18));
        // nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Giá
        priceLabel = new JLabel("$0.00");
        priceLabel.setFont(new Font("Arial", Font.BOLD, 16));

        // Hãng
        brandLabel = new JLabel("Brand");
        brandLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        brandLabel.setForeground(Color.DARK_GRAY);

        // Mô tả
        descLabel = new JLabel("Mô tả sản phẩm");
        descLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        descLabel.setForeground(Color.GRAY);

        infoPanel.add(nameLabel);
        infoPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        infoPanel.add(priceLabel);
        infoPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        infoPanel.add(brandLabel);
        infoPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        infoPanel.add(descLabel);
        add(Box.createVerticalStrut(10));
        add(imageLabel);
        add(Box.createVerticalStrut(10));
        add(infoPanel);
        add(Box.createVerticalGlue());

    }

    public void updateInfo(Item item) {
        nameLabel.setText(item.getName());
        priceLabel.setText(String.format("$%.2f", item.getPrice()));
        brandLabel.setText(item.getBrand());
        descLabel.setText("This product is excluded from all promotional discounts and offers.");

        URL imageURL = getClass().getResource(item.getImagePath());
        if (imageURL != null) {
            ImageIcon icon = new ImageIcon(imageURL);
            Image scaledImage = icon.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
            imageLabel.setIcon(new ImageIcon(scaledImage));
            imageLabel.setText("");
        } else {
            imageLabel.setIcon(null);
            imageLabel.setText("Không tìm thấy ảnh");
        }
    }
}
