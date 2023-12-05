
package configuration;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Buku;

public class BukuTableModel extends AbstractTableModel {
    private List<Buku> bukus = new ArrayList<>();
    private final String HEADER[] = {"ID Buku", "Judul Buku",
    "Genre Buku", "Tanggal Terbit", "Penulis"};

    public BukuTableModel(List<Buku> bukus) {
        this.bukus = bukus;
    }

    @Override
    public int getRowCount() {
        return bukus.size();
    }

    @Override
    public int getColumnCount() {
        return HEADER.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return HEADER[columnIndex];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
    Buku buku = bukus.get(rowIndex);

    switch (columnIndex) {
        case 0:
            return buku.getIdBuku();
        case 1:
            return buku.getJudulBuku();
        case 2:
            return buku.getGenreBuku();
        case 3:
            return buku.getTanggalTerbit();
        case 4:
            return buku.getPenulisBuku();
        default:
            return null;
    }}
}