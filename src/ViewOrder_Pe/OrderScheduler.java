package ViewOrder_Pe;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.*;
import com.toedter.calendar.JDateChooser;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.String.format;
import static java.lang.String.format;
import java.text.DateFormat;
import static java.text.MessageFormat.format;
import java.util.Calendar;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class OrderScheduler extends JPanel {

    private ImageIcon imgLogo = new ImageIcon(getClass().getResource("/Image/Order Scheduler.png"));
    private JLabel jlLogo = new JLabel(imgLogo);
    private JButton jbDelivered = new JButton("Delivered");
    private JButton jbSearch = new JButton("Search");

    private JDateChooser jdcDate = new JDateChooser();
    private JLabel jlable1 = new JLabel();
    //private JTextField jtextField = new JTextField();

    private String[] columnNames
            = {"Date", "Order ID", "Quantity", "Price", "Address", "Owner"};

    private Object[][] data = {
        {"30-11-2017", "O0050", 2, "RM" + 30, "63, Bukit Pelandok ,79600, Port Dick Son", "Ms Tan"},
        {"02-12-2017", "O0052", 3, "RM" + 40, "No68, Jalan Cina, Bukit Belantok, 15000, Kuala Lumpur", "Vivian Hao"},
        {"09-11-2017", "O0054", 1, "RM" + 15, "6A- 18 PV13, JALAN DANAU SAUJANA TAMAN DANAU KOTA, Kuala Lumpur", "Danial Ting"},
        {"26-11-2017", "O0055", 5, "RM" + 65, "75 Sugai Ramal Luar, 43000, Kajang, Kuala Lumpur", "Ms Teoh"},
        {"23-11-2017", "O0056", 2, "RM" + 37, "388, MK6, Jalan Lintang, 11500, Kuala Lumpur", "Mrs Tan"},
        {"30-11-2017", "O0070", 2, "RM" + 45, "3B- 20, Jalan Langkawi, 11600, Kuala Lumpur", "Tun Hafiza"},
        {"02-11-2017", "O0080", 3, "RM" + 66, "7C- 10 PV15, JALAN DANAU SAUJANA TAMAN DANAU KOTA, Kuala Lumpur", "Ms Lim"}
    };
    private DefaultTableModel model = new DefaultTableModel(data, columnNames);
    private JTable jTable = new JTable(model);
    private TableColumnModel tcm = jTable.getColumnModel();

    private TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(jTable.getModel());

//    String date = dcn.format(jdcDate.getDate() );
    public OrderScheduler() {
        jTable.setRowSorter(rowSorter);
        for (int i = 0; i < (tcm.getColumnCount()); i++) {
            tcm.getColumn(0).setPreferredWidth(90);
            tcm.getColumn(1).setPreferredWidth(90);
            tcm.getColumn(2).setPreferredWidth(90);
            tcm.getColumn(3).setPreferredWidth(90);
            tcm.getColumn(4).setPreferredWidth(500);
            tcm.getColumn(5).setPreferredWidth(150);
        }

        //jTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        jdcDate.setDateFormatString("dd-MM-yyyy");

        //jlable1.setText(jdcDate);
        Date date = jdcDate.getDate();
//        String strDate = DateFormat.getDateInstance().format(date);
//String date1  = ((JLabel)jdcDate.getDateEditor().getUiComponent()).getText();
//jlable1.setText(date1);

        jTable.setMinimumSize(new Dimension(400, 200));
        JTableHeader header = jTable.getTableHeader();
        JScrollPane pane = new JScrollPane(jTable);
        pane.setMinimumSize(new Dimension(600, 23));
        jTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        setLayout(new BorderLayout());
        JPanel panel1 = new JPanel();
        panel1.add(jlLogo, BorderLayout.NORTH);
        panel1.setBackground(Color.WHITE);
        
        JPanel panel2 = new JPanel();
        panel2.add(jdcDate, BorderLayout.EAST);
        panel2.add(jbSearch, BorderLayout.CENTER);
        panel2.add(new JScrollPane(jTable), BorderLayout.SOUTH);
        //panel2.setBackground(Color.WHITE);
        

        add(panel1, BorderLayout.NORTH);
        add(panel2, BorderLayout.CENTER);
        add(jbDelivered, BorderLayout.SOUTH);

        jbDelivered.addActionListener(new approveListener());
        jbSearch.addActionListener(new searchListener());

    }

    private class searchListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
//         Date date = jdcDate.getDate();
//            DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
//            jlable1.setText(format.format(date));

            for (int i = 0; i <= (tcm.getColumnCount()); i++) {
                String value = jTable.getValueAt(i, 0).toString();
                jdcDate.getDate();
                jdcDate.setDateFormatString("dd-MM-yyyy");

                String d1 = ((JTextField) jdcDate.getDateEditor().getUiComponent()).getText();

                //JOptionPane.showMessageDialog(null, d1, "TITLE", JOptionPane.WARNING_MESSAGE);
                if (d1.equals(value)) {

                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + value));
                }

            }

        }
    }

    private class approveListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            int selRow = jTable.getSelectedRow();

            String status = jTable.getValueAt(selRow, 2).toString();
            if (selRow != -1) {
                model.removeRow(selRow);
            }
        }
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame1 = new JFrame("Order Scheduler");
                frame1.add(new OrderScheduler());
                frame1.setSize(800, 700);
                frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame1.setLocationRelativeTo(null);
                frame1.setVisible(true);
            }

        });

    }

}
