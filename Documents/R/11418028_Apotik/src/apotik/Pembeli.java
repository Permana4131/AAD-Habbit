//Generics & abstract && polymopysm
package apotik;


abstract class Pembeli<T,V>{
   public T nama;
   public V alamat;

    public Pembeli() {
    }

   
    public Pembeli(T nama, V alamat) {
        this.nama = nama;
        this.alamat = alamat;
    }

    public T getNama() {
        return nama;
    }

    public V getAlamat() {
        return alamat;
    }
    
    public void  showTransaksi(){
        System.out.println("Transaksi");
    }

}


/*
Nama : Permana
NIM  : 11418028
Kelas: 42TRPL1
Tanggal : 13-12-2019
 */
