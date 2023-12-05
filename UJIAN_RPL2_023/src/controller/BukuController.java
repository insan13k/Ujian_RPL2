
package controller;

import configuration.BukuTableModel;
import configuration.HibernateUtil;
import dao.BukuDao;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Buku;
import model.GenreBuku;
import ujian_rpl2_023.BukuView;

public class BukuController {
    private final BukuView bukuView;
    private BukuTableModel bukuTableModel;
    private List<Buku> bukus;
    private final BukuDao bukuDao = HibernateUtil.getBukuDao();

    public BukuController(BukuView bukuView) {
        this.bukuView = bukuView;
    }

    public void tampilData() {
        bukus = bukuDao.getBukus();
        bukuTableModel = new BukuTableModel(bukus);
        this.bukuView.getTabel().setModel(bukuTableModel);
    }

    public void show() {
        int index = this.bukuView.getTabel().getSelectedRow();

        this.bukuView.getIdBuku().setText(String.valueOf(
        this.bukuView.getTabel().getValueAt(index, 0)));
        this.bukuView.getJudulBuku().setText(String.valueOf(
        this.bukuView.getTabel().getValueAt(index, 1)));
        this.bukuView.getGenreBuku().setText(String.valueOf(
        this.bukuView.getTabel().getValueAt(index, 2)));
        this.bukuView.getTanggalTerbit().setText(String.valueOf(
        this.bukuView.getTabel().getValueAt(index, 3)));
        this.bukuView.getPenulisBuku().setText(String.valueOf(
        this.bukuView.getTabel().getValueAt(index, 4)));
    }

    public void clear() {
        this.bukuView.getIdBuku().setText("");
        this.bukuView.getJudulBuku().setText("");
        this.bukuView.getGenreBuku().setText("");
        this.bukuView.getTanggalTerbit().setText("");
        this.bukuView.getPenulisBuku().setText("");
    }

    public void saveBuku() {
        Buku buku = new Buku();
        buku.setJudulBuku(this.bukuView.getJudulBuku().getText());
        buku.setGenreBuku(GenreBuku.valueOf(this.bukuView.getGenreBuku().getText()));
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        try {
            buku.setTanggalTerbit(dateFormat.parse(this.bukuView.getTanggalTerbit().getText()));
        } catch (ParseException ex) {
            Logger.getLogger(BukuController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        buku.setPenulisBuku(this.bukuView.getPenulisBuku().getText());

        bukuDao.save(buku);
        JOptionPane.showMessageDialog(null, "Data Berhasil di Simpan", "info",
                JOptionPane.INFORMATION_MESSAGE);
        clear();
        tampilData();
    }

    public void updateBuku() {
        Buku buku = new Buku();
        buku.setIdBuku(this.bukuView.getIdBuku().getText());
        buku.setJudulBuku(this.bukuView.getJudulBuku().getText());
        buku.setGenreBuku(GenreBuku.valueOf(this.bukuView.getGenreBuku().getText()));
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        try {
            buku.setTanggalTerbit(dateFormat.parse(this.bukuView.getTanggalTerbit().getText()));
        } catch (ParseException ex) {
            Logger.getLogger(BukuController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        buku.setPenulisBuku(this.bukuView.getPenulisBuku().getText());
        bukuDao.update(buku);
        JOptionPane.showMessageDialog(null, "Data Berhasil di Edit", "info",
        JOptionPane.INFORMATION_MESSAGE);
        clear();
        tampilData();
    }

    public void deleteBuku() {
        if (this.bukuView.getIdBuku().getText() == null) {
            JOptionPane.showMessageDialog(null, "Buku belum dipilih", "error",
                    JOptionPane.ERROR_MESSAGE);
        } else {
            Buku buku = new Buku();
            buku.setIdBuku(this.bukuView.getIdBuku().getText());
            int pilih = JOptionPane.showConfirmDialog(null,"Apakah data ingin dihapus ?", "Warning", 
                    JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if (pilih == JOptionPane.YES_OPTION) {
                bukuDao.delete(buku);
                JOptionPane.showMessageDialog(null,"Data Berhasil di Hapus", "info",JOptionPane.INFORMATION_MESSAGE);
                clear();
                tampilData();
            }
        }
    }
}