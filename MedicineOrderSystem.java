package Med_System;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import com.toedter.calendar.JDateChooser;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class MedicineOrderSystem extends JFrame {

    // Database connection details
    private static final String DB_URL = "jdbc:mysql://localhost:3306/userorder&paymentdb"; // Use correct database name
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    
    private JTextField txtMedicine, txtQuantity, txtPrice;
    private JDateChooser txtDate;
    private JComboBox<String> cmbPaymentMethod;
    private JTable table;
    private DefaultTableModel tableModel;

    public MedicineOrderSystem() {
        initComponents();
        loadTableData();
    }

    private void initComponents() {
        
        setTitle("");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000, 550);
        setLayout(null);
        getContentPane().setBackground(Color.RED);

        
        JLabel lblMedicine = createLabel("Medicine Name:", 20, 20);
        JLabel lblQuantity = createLabel("Quantity:", 20, 70);
        JLabel lblPrice = createLabel("Price:", 20, 120);
        JLabel lblDate = createLabel("Delivery Date:", 20, 170);
        JLabel lblPaymentMethod = createLabel("Payment Method:", 20, 220);

   
        txtMedicine = createTextField(150, 20);
        txtQuantity = createTextField(150, 70);
        txtPrice = createTextField(150, 120);
        txtDate = new JDateChooser();
        txtDate.setBounds(150, 170, 200, 30);
        add(txtDate);

        cmbPaymentMethod = new JComboBox<>(new String[]{"Cash", "Credit Card", "Gcash"});
        cmbPaymentMethod.setBounds(150, 220, 200, 30);
        add(cmbPaymentMethod);

        
        JButton btnInsert = createButton("ORDER", 20, 270);
        JButton btnDelete = createButton("CANCEL", 120, 270);
        JButton btnClear = createButton("DELETE", 220, 270);

        JButton btnGenerateReceipt = new JButton("Generate Receipt");
        btnGenerateReceipt.setBackground(Color.LIGHT_GRAY);
        btnGenerateReceipt.setFont(new Font("Arial", Font.BOLD, 14));
        add(btnGenerateReceipt);

        // Dynamically calculate position below the table
        int buttonWidth = 180;
        int buttonHeight = 40;

        // Assuming the table is already added
        int tableBottomY = 420; // Use table.getBounds().y + table.getBounds().height if table's position is dynamic
        int centerX = (getWidth() - buttonWidth) / 2; // Center horizontally in the window
        int centerY = tableBottomY + 20; // Position 20 pixels below the table's bottom edge

        btnGenerateReceipt.setBounds(centerX, centerY, buttonWidth, buttonHeight);


        
        JButton btnSignOut = new JButton("SIGN OUT");
        int signOutX = getWidth() - 120; 
        int signOutY = 20; 
        btnSignOut.setBounds(signOutX, signOutY, 100, 30);
        btnSignOut.setBackground(Color.LIGHT_GRAY);
        btnSignOut.setFont(new Font("Arial", Font.BOLD, 12));
        add(btnSignOut);

        
        btnInsert.addActionListener(e -> insertRecord());
        btnDelete.addActionListener(e -> deleteRecord());
        btnClear.addActionListener(e -> clearFields());
        btnGenerateReceipt.addActionListener(e -> generateReceipt());

    
        btnSignOut.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Thank you for ordering!", "Sign Out", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0); // Close the application
        });

        
        tableModel = new DefaultTableModel(new Object[]{"ID", "Medicine", "Quantity", "Price", "Delivery Date"}, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(400, 20, 460, 400);
        add(scrollPane);
    }

    private JLabel createLabel(String text, int x, int y) {
        JLabel label = new JLabel(text);
        label.setBounds(x, y, 120, 30);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Arial", Font.BOLD, 14));
        add(label);
        return label;
    }

    private JTextField createTextField(int x, int y) {
        JTextField textField = new JTextField();
        textField.setBounds(x, y, 200, 30);
        add(textField);
        return textField;
    }

    private JButton createButton(String text, int x, int y) {
        JButton button = new JButton(text);
        button.setBounds(x, y, 100, 30);
        button.setBackground(Color.LIGHT_GRAY);
        button.setFont(new Font("Arial", Font.BOLD, 12));
        add(button);
        return button;
    }

    private void insertRecord() {
        String medicine = txtMedicine.getText();
        String quantity = txtQuantity.getText();
        String price = txtPrice.getText();
        java.util.Date date = txtDate.getDate();

        if (medicine.isEmpty() || quantity.isEmpty() || price.isEmpty() || date == null) {
            JOptionPane.showMessageDialog(this, "All fields are required.");
            return;
        }

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String query = "INSERT INTO orders (medicine_name, quantity, price, delivery_date) VALUES (?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, medicine);
            pstmt.setInt(2, Integer.parseInt(quantity));
            pstmt.setDouble(3, Double.parseDouble(price));
            pstmt.setDate(4, new java.sql.Date(date.getTime()));
            pstmt.executeUpdate();
            loadTableData();
            clearFields();
            JOptionPane.showMessageDialog(this, "Record added successfully!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error inserting data: " + ex.getMessage());
        }
    }

    private void loadTableData() {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String query = "SELECT * FROM orders";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            tableModel.setRowCount(0); // Clear existing data
            while (rs.next()) {
                tableModel.addRow(new Object[]{
                        rs.getInt("id"),
                        rs.getString("medicine_name"),
                        rs.getInt("quantity"),
                        rs.getDouble("price"),
                        rs.getDate("delivery_date")
                });
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error loading data: " + e.getMessage());
        }
    }

    private void deleteRecord() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "No row selected!");
            return;
        }

        int id = (int) tableModel.getValueAt(selectedRow, 0);
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String query = "DELETE FROM orders WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            loadTableData();
            JOptionPane.showMessageDialog(this, "Record deleted successfully!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error deleting data: " + ex.getMessage());
        }
    }

    private void clearFields() {
        txtMedicine.setText("");
        txtQuantity.setText("");
        txtPrice.setText("");
        txtDate.setDate(null);
    }

    private void generateReceipt() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "No row selected to generate a receipt!");
            return;
        }

        String medicine = (String) tableModel.getValueAt(selectedRow, 1);
        int quantity = (int) tableModel.getValueAt(selectedRow, 2);
        double price = (double) tableModel.getValueAt(selectedRow, 3);
        String deliveryDate = tableModel.getValueAt(selectedRow, 4).toString();
        String paymentMethod = (String) cmbPaymentMethod.getSelectedItem();

        String receipt = String.format(
                "----- RECEIPT -----\nMedicine: %s\nQuantity: %d\nPrice: $%.2f\nTotal: $%.2f\nDelivery Date: %s\nPayment Method: %s\n-------------------",
                medicine, quantity, price, price * quantity, deliveryDate, paymentMethod
        );

        JOptionPane.showMessageDialog(this, receipt, "Receipt", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MedicineOrderSystem().setVisible(true));
    }
}
