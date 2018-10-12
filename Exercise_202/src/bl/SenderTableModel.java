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
        int i;
        for (i = 0; i < senders.size(); i++) {
            if(senders.get(i).getFrequency() > s.getFrequency())
                break;
        }
        senders.add(i, s);
        fireTableRowsInserted(i, i);
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
        return senders.get(rowIndex);
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }
}
