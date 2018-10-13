package bl;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Matthias
 */
public class SenderTableModel extends AbstractTableModel {

    private static String[] columns = {"Sender", "Frequenz", "Band"};
    private static int hideLastCol = 0;
    private LinkedList<Sender> senders = new LinkedList<>();

    public void add(Sender s) {
        int i;
        for (i = 0; i < senders.size(); i++) {
            if (senders.get(i).getFrequency() > s.getFrequency()) {
                break;
            }
        }
        senders.add(i, s);
        fireTableRowsInserted(i, i);
    }

    public void hideBand() {
        hideLastCol = 1;
        fireTableStructureChanged();
    }

    public void showBand() {
        hideLastCol = 0;
        fireTableStructureChanged();
    }

    public void loadSenders(File f) throws Exception {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
        try {
            Object obj;
            while ((obj = ois.readObject()) instanceof Sender) {
                add((Sender) obj);
            }
            hideLastCol = (int) obj;
            fireTableStructureChanged();
        } catch (EOFException e) {
        }
        ois.close();
    }

    public void saveSenders(File f) throws Exception {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
        for (Sender sender : senders) {
            oos.writeObject(sender);
        }
        oos.writeObject(hideLastCol);
    }

    @Override
    public int getRowCount() {
        return senders.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length - hideLastCol;
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
