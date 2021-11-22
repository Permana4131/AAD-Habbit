package apotik;

public class Obat{
     String namaObat,kdObat;
     int stok,harga;
     JenisObat jenisObat;

    public Obat() {
        
    }

    public Obat(String kdObat,String namaObat, int stok, int harga,JenisObat jenisObat) {
        this.kdObat = kdObat;
        this.namaObat = namaObat;
        this.stok = stok;
        this.harga = harga;
        this.jenisObat = jenisObat;
    }

  
    
    public void setObat(String kdObat,String namaObat, int stok, int harga,JenisObat jenisObat){
        this.kdObat = kdObat;
        this.namaObat = namaObat;
        this.stok = stok;
        this.harga = harga;
        this.jenisObat = jenisObat;
    }
    
      public JenisObat getJenisObat() {
        return jenisObat;
    }

    public void setJenisObat(JenisObat jenisObat) {
        this.jenisObat = jenisObat;
    }
    
    public void setKdObat(String kdObat){
        this.kdObat = kdObat;
    }
    
    public String getKdObat(){
        return kdObat;
    }
    
    public void setNamaObat(String namaObat){
        this.namaObat = namaObat;
    }
    
    public void setStok(int stok) {
        this.stok = stok;
    }

    
    public void setHarga(int harga) {
        this.harga = harga;
    }
  
    
    public String getNamaObat() {
        return namaObat;
    }
    
    public int getStok(){
        return stok;
    }
    
    public int getHarga() {
        return harga;
    }
    
    public void dataObat(){
         System.out.println("Nama Obat : "+getNamaObat()+" | "
                 +"Kode Obat : "+getKdObat()+" | "+
                 "Persediaan : "+getStok()+" | "+
                 "Harga : "+getHarga()+" | "+
                 "Jenis Obat : "+jenisObat);
                   
         System.out.println((char)27+"[01;32m ============================================================================ "+(char)27+"[00;00m");
    }
}

/*
Nama : Permana
NIM  : 11418028
Kelas: 42TRPL1
Tanggal : 13-12-2019
 */

