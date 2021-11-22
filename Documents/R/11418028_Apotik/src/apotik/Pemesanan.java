package apotik;

public class Pemesanan {
//    private T t;
     private String kdObat,namaObat;
     private int stokPesanan,harga,totalHarga;

    public Pemesanan(){

    }
    
    public void setPemesanan(String kdObat,String namaObat,int stokPesanan, int harga,int totalHarga) {
        this.kdObat = kdObat;
        this.namaObat = namaObat;
        this.stokPesanan = stokPesanan;
        this.harga = harga;
        this.totalHarga = totalHarga;
    }

    public String getKdObat(){
        return kdObat;
    }
    public void setKodeObat(String kdObat){
        this.kdObat = kdObat;
    }
    public String getNamaObat() {
        return namaObat;
    }

    public void setNamaObat(String namaObat) {
        this.namaObat = namaObat;
    }

    public int getStokPesanan() {
        return stokPesanan;
    }

    public void setStokPesanan(int stokPesanan) {
        this.stokPesanan = stokPesanan;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }
    
    public void setTotalHarga(int totalHarga){
        this.totalHarga = totalHarga;
    }
    
    public int getTotalHarga(){
        return totalHarga;
    }
    
    public void dataPemesanan(){
        System.out.println("Nama Obat : "+getNamaObat()+(char)27+"[01;32m | "+(char)27+"[00;00m"
                +"Kode Obat : "+getKdObat()+(char)27+"[01;32m | "+(char)27+"[00;00m"
                +"Jumlah Pesanan : "+getStokPesanan()+(char)27+"[01;32m | "+(char)27+"[00;00m"
                +"Harga : " + getHarga() +(char)27+"[01;32m | "+(char)27+"[00;00m"
                +"Toal Harga : "+getTotalHarga());
        System.out.println((char)27+"[01;32m ============================================================================ "+(char)27+"[00;00m");
    }
}


/*
Nama : Permana
NIM  : 11418028
Kelas: 42TRPL1
Tanggal : 13-12-2019
 */
