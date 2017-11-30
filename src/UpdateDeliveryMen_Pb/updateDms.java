package UpdateDeliveryMen_Pb;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author X455LD
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class updateDms{
   
    public static void main(String[]args){ 
        JFrame frame = new JFrame();
        JTable table = new JTable(); 
        Object[] columns = {"Name","IC","Address","PhoneNo","Email","Emergency Call","Status"};
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);
        table.setModel(model);
        
        table.setBackground(Color.LIGHT_GRAY);
        table.setForeground(Color.black);
        Font font = new Font("",1,22);
        table.setFont(font);
        table.setRowHeight(30);
        
        JTextField txtName = new JTextField();
        JTextField txtIC= new JTextField();
        JTextField txtAddress = new JTextField();
        JTextField txtPhoneNo = new JTextField();
        JTextField txtEmail = new JTextField();
        JTextField txtEmergencycall= new JTextField();
        JTextField txtStatus = new JTextField();
        JLabel address = new JLabel("Address: ");
        JLabel phone = new JLabel("Phone No: ");
        JLabel status = new JLabel("Status: ");
  
        JButton btnAdd = new JButton("Add");
        JButton btnUpdate = new JButton("Update");  

       
       address.setBounds(20, 200, 100, 25);
      txtAddress.setBounds(20, 220, 100, 25);
      
      phone.setBounds(20, 240, 100, 25);
       txtPhoneNo.setBounds(20, 260, 100, 25);
       
       status.setBounds(20, 280, 100, 25);
       txtStatus.setBounds(20, 300, 100, 25);

        btnUpdate.setBounds(20, 350, 100, 25);
       
        JScrollPane pane = new JScrollPane(table);
        pane.setBounds(0, 0, 1000, 200);
        
        frame.setLayout(null);    
        frame.add(pane);
       
        frame.add(txtName);
        frame.add(txtIC);
        frame.add(txtAddress);
        frame.add(txtPhoneNo);
        frame.add(txtEmail);
        frame.add(txtEmergencycall);
        frame.add(txtStatus);
        frame.add(btnUpdate);
        frame.add(address);
        frame.add(phone);
        frame.add(status);
        
        Object[] row = new Object[8];
        for(int i=0;i<5;i++){
        row[0] = txtName.getText();
        row[1] = txtIC.getText();
        row[2] = txtAddress.getText();
        row[3] = txtPhoneNo.getText();
        row[4] = txtEmail.getText();
        row[5] = txtEmergencycall.getText();
        row[6] = txtStatus.getText();
        model.addRow(row);
        }
      table.addMouseListener(new MouseAdapter(){
     public void mouseClicked(MouseEvent e){
            int i = table.getSelectedRow();

            txtName.setText(model.getValueAt(i, 0).toString());
            txtIC.setText(model.getValueAt(i, 1).toString());
            txtAddress.setText(model.getValueAt(i, 2).toString());
            txtPhoneNo.setText(model.getValueAt(i, 3).toString());
            txtEmail.setText(model.getValueAt(i, 4).toString());
            txtEmergencycall.setText(model.getValueAt(i, 5).toString());
            txtStatus.setText(model.getValueAt(i, 6).toString());
     }}); 
      
      btnUpdate.addActionListener(new ActionListener(){
               public void actionPerformed(ActionEvent e) {
                    int i = table.getSelectedRow();
                    
                     if(i >= 0) 
                {
              
                   model.setValueAt(txtName.getText(), i, 0);
                   model.setValueAt(txtIC.getText(), i, 1);
                   model.setValueAt(txtAddress.getText(), i, 2);
                   model.setValueAt(txtPhoneNo.getText(), i, 3);
                   model.setValueAt(txtEmail.getText(), i, 4);
                   model.setValueAt(txtEmergencycall.getText(), i, 5);
                   model.setValueAt(txtStatus.getText(), i, 6);
                }
                else{
                    System.out.println("Update Error");
                }
            }
        });
     
      frame.setSize(1010,450);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
              }
}
    

