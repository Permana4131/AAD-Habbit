//Generic && inheritece && polymorhysm

package apotik;

public class Transaksi<T,V> extends Pembeli<T,V>{
    private int stokPembelian;
    private int harga;
    String namaObat,kdTrans,kdObat;

    public Transaksi() {
    }
    
    
    
    public Transaksi(T nama,V alamat,String kdTrans,String kdObat, String namaObat,int harga,int stokPembelian) {
       super(nama,alamat);
       this.kdTrans = kdTrans;
       this.kdObat = kdObat;
       this.namaObat = namaObat;
       this.harga = harga;
       this.stokPembelian = stokPembelian;
    }
    
      
      public void setTransaksi(T nama,V alamat,String kdTrans,String kdObat, String namaObat,int harga,int stokPembelian){
          this.nama =nama;
          this.alamat = alamat;
          this.kdTrans = kdTrans;
          this.kdObat = kdObat;
          this.namaObat = namaObat;
          this.harga = harga;
          this.stokPembelian = stokPembelian;
      }

    public int getStokPembelian() {
        return stokPembelian;
    }

    public void setStokPembelian(int stokPembelian) {
        this.stokPembelian = stokPembelian;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public String getNamaObat() {
        return namaObat;
    }

    public void setNamaObat(String namaObat) {
        this.namaObat = namaObat;
    }

    public String getKdTrans() {
        return kdTrans;
    }

    public void setKdTrans(String kdTrans) {
        this.kdTrans = kdTrans;
    }

    public String getKdObat() {
        return kdObat;
    }

    public void setKdObat(String kdObat) {
        this.kdObat = kdObat;
    }
      
      public long getTotal(int stokPembelian,int harga){
           return stokPembelian*harga;
      }
      
    @Override
      public void showTransaksi(){
        System.out.println(
//                "Kode Transaksi :"+kdTrans +(char)27+"[01;32m | "+(char)27+"[00;00m"
                "Nama Pembeli :"+getNama() +(char)27+"[01;32m | "+(char)27+"[00;00m"
                +"Alamat :"+getAlamat() +(char)27+"[01;32m | "+(char)27+"[00;00m"
                + "Kode Obat :"+kdObat +(char)27+"[01;32m | "+(char)27+"[00;00m"
                + "Nama Obat :"+namaObat +(char)27+"[01;32m | "+(char)27+"[00;00m"
                + "Harga Obat :"+harga +(char)27+"[01;32m | "+(char)27+"[00;00m"
                +"Banyak Pembelian :"+stokPembelian +(char)27+"[01;32m | "+(char)27+"[00;00m"
                +"Total :"+getTotal(stokPembelian, harga) +(char)27+"[01;32m "+(char)27+"[00;00m"
        );
        System.out.println((char)27+"[01;32m ============================================================================ "+(char)27+"[00;00m");
      }
      
      public void harga(int harga){
          System.out.println("Harga 1 obat : "+harga);
      }
      public void harga(int harga1,int harga2){
          System.out.println("Harga 1 obat : "+(harga1+harga2));
      }
      
      public void harga(int harga1,int harga2,int harga3){
          System.out.println("Harga 1 obat : "+(harga1+harga2+harga3));
      }
}

/*
Nama : Permana
NIM  : 11418028
Kelas: 42TRPL1
Tanggal : 13-12-2019
 */