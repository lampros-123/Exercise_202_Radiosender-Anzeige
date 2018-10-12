package gui;

import bl.Sender;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Matthias
 */
public class SenderTableRenderer implements TableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Sender sender = (Sender) value;
        JLabel label = new JLabel();
        label.setOpaque(true);
        label.setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 14));
        label.setForeground(Color.lightGray);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        if (sender.getBand().equals("AM")) {
            label.setBackground(Color.blue);
        } else {
            label.setBackground(Color.red);
        }

        switch (column) {
            case 0:
                label.setText(sender.getName());
                break;
            case 1:
                label.setText(String.format("%.2f", sender.getFrequency()));
                break;
            case 2:
                label.setText(sender.getBand());
                break;
        }

        return label;
    }

}
