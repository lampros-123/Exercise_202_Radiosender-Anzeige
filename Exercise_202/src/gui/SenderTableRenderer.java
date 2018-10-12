package gui;

import bl.Sender;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Matthias
 */
public class SenderTableRenderer implements TableCellRenderer{

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Sender sender = (Sender) value;
        JLabel label = new JLabel();
        label.setOpaque(true);
        
        switch(column) {
            case 0: label.setText(sender.getName()); break;
            case 1: label.setText(String.format("%.2f", sender.getFrequency())); break;
            case 2: label.setText(sender.getBand()); break;
        }
        return label;
   }
    
}
