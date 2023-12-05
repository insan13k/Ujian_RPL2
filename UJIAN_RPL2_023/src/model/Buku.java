
package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name = "tb_buku")
public class Buku implements Serializable {
    
    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(generator = "uuid2")
    @Column(name = "id_buku", length = 150)
    private String idBuku;
    public void setIdBuku(String idBuku){
        this.idBuku = idBuku;
    }
    public String getIdBuku(){
        return  idBuku;
    }

    @Column(name = "judul_buku", length = 50)
    private String judulBuku;
    public void setJudulBuku(String judulBuku){
        this.judulBuku = judulBuku;
    }
    public String getJudulBuku(){
        return  judulBuku;
    }

    @Column(name = "genre_buku", length = 10)
    @Enumerated(EnumType.STRING)
    private GenreBuku genreBuku;
    public void setGenreBuku(GenreBuku genreBuku){
        this.genreBuku = genreBuku;
    }
    
    public GenreBuku getGenreBuku(){
        return  genreBuku;
    }

    @Column(name = "tanggal_terbit")
    @Temporal(TemporalType.DATE)
    private Date tanggalTerbit;
    public void setTanggalTerbit(Date tanggalTerbit){
        this.tanggalTerbit = tanggalTerbit;
    }
    
    public Date getTanggalTerbit(){
        return  tanggalTerbit;
    }

    @Column(name = "penulis_buku", length = 50)
    private String penulisBuku;
    public void setPenulisBuku(String penulisBuku){
        this.penulisBuku = penulisBuku;
    }
    public String getPenulisBuku(){
        return  penulisBuku;
    }
}