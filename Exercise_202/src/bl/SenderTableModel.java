package bl;

import java.util.LinkedList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Matthias
 */
public class SenderTableModel extends AbstractTableModel{

    private static String[] columns = {"Sender", "Frequenz", "Band"};
    private LinkedList<Sender> senders = new LinkedList<>();

    public void add(Sender s) {
        senders.add(s);
        fireTableRowsInserted(senders.size()-1, senders.size()-1);
    }
    
    public void hideBand() {
        columns = new String[]{"Sender", "Frequenz"};
        fireTableStructureChanged();
    }
    
    public void showBand() {
        columns = new String[]{"Sender", "Frequenz", "Band"};
        fireTableStructureChanged();
    }
    
    @Override
    public int getRowCount() {
        return senders.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Sender s = senders.get(rowIndex);
        
        switch(columnIndex) {
            case 0: return s.getName();
            case 1: return s.getFrequency();
            case 2: return s.getBand();
        }
        return "?";
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }
}
