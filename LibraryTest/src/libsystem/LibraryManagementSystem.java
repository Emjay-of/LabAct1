package libsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LibraryManagementSystem extends JFrame {
    private DynamicArray<String> dynamicArray;
    private JTextArea textArea;
    private JTextField indexField, valueField;
    private JButton addButton, insertButton, removeButton, getButton, sizeButton, isEmptyButton;

    public LibraryManagementSystem() {
        dynamicArray = new DynamicArray<>();

        setTitle("Library Management System");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7, 2));

        panel.add(new JLabel("Index:"));
        indexField = new JTextField();
        panel.add(indexField);

        panel.add(new JLabel("Value:"));
        valueField = new JTextField();
        panel.add(valueField);

        addButton = new JButton("Add");
        insertButton = new JButton("Insert");
        removeButton = new JButton("Remove");
        getButton = new JButton("Get");
        sizeButton = new JButton("CheckSize");
        isEmptyButton = new JButton("CheckisEmpty");

        panel.add(addButton);
        panel.add(insertButton);
        panel.add(removeButton);
        panel.add(getButton);
        panel.add(sizeButton);
        panel.add(isEmptyButton);

        add(panel, BorderLayout.SOUTH);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String value = valueField.getText();
                dynamicArray.add(value);
                updateTextArea();
            }
        });

        insertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int index = Integer.parseInt(indexField.getText());
                    String value = valueField.getText();
                    dynamicArray.insert(index, value);
                    updateTextArea();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid index");
                }
            }
        });

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int index = Integer.parseInt(indexField.getText());
                    dynamicArray.remove(index);
                    updateTextArea();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid index");
                }
            }
        });

        getButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int index = Integer.parseInt(indexField.getText());
                    String value = dynamicArray.get(index);
                    JOptionPane.showMessageDialog(null, "Book found at index " + index + ": " + value);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid index");
                }
            }
        });

        sizeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Number of Books in Library: " + dynamicArray.size());
            }
        });

        isEmptyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "No books in library: " + dynamicArray.isEmpty());
            }
        });
    }

    private void updateTextArea() {
        textArea.setText("");
        for (int i = 0; i < dynamicArray.size(); i++) {
            textArea.append(i + ": " + dynamicArray.get(i) + "\n");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new LibraryManagementSystem().setVisible(true);
        });
    }
}
