
package dao;

import java.util.List;
import model.Buku;

public interface BukuDao {
    public void save(Buku buku);
    public void update(Buku buku);
    public void delete(Buku buku);
    public Buku getBuku(String idBuku);
    public List<Buku> getBukus();
}