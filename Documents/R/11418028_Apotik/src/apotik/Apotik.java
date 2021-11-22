/*
Nama : Permana
NIM  : 11418028
Kelas: 42TRPL1
 */

/*
=========< Tambahan Week[7-9] >===============
*/

package apotik;

//import java.util.Scanner;
import java.util.*;

public class Apotik {
    
    //Nested Class
    private class Apot{
        private String Apotik = " is-Apotik";
        private void apotik(){
            System.out.printf((char)27+"[01;35mSelamat Datang di Apotik"+Apotik);
        }
    }
    
  
    private class Owner{
        private String nama = "Permana";
        private int umur = 20;
        private void identitas(){
            System.out.println((char)27+"[01;35mNama Pemilik:" +nama);
            System.out.println((char)27+"[01;35mUsia Umur:" +umur);
        }
    }
    
    
    Pemesanan pemesanan;
    static String namaObat,kdObat,nama,alamat,kdTrans;
    static int stok,harga,stokPesanan,totalHarga,stokPembelian;
    static JenisObat jenisObat;
    public static void main(String[] args) {
        try{//Exception Handling
        Scanner keyboard = new Scanner(System.in);
       
       
        Transaksi trans = new Transaksi();
        //Collection menggunakan Vecotr
        Vector<Transaksi>  transaksi= new Vector<>(); // Collection
        int t = 0;
        String Username,Password;

        
        transaksi.add(new Transaksi("Permana","Del","2s2","2w2","Paramex",2000,50));
        Pemesanan pemesanan[] = new Pemesanan[100];
        for(int i = 0; i<pemesanan.length;i++){
        pemesanan[i] = new Pemesanan();
        }
        pemesanan[0].setPemesanan("2w2","Ptoramol",1000,1000,100000);
        pemesanan[1].setPemesanan("2z2","Paramex",20,2000,40000);
                
        Obat obat[] = new Obat[100];
        
        for(int i = 0 ;i<obat.length;i++){
            obat[i] = new Obat(namaObat,kdObat,stok,harga,jenisObat);
        }
        
        obat[0].setObat("2z2","Paramex", 20,2000,jenisObat.Pil);
        obat[1].setObat("2w2","Protamol",25,1000,jenisObat.Sirup);
        int option,option1;            
        
        do{
            System.out.printf((char)27+"[01;34m=============="+(char)27+"[00;00m");
            
            Apotik a = new Apotik();
            Apotik.Apot apotik =  a.new Apot();
            Apotik.Owner  owner = a.new Owner();
            apotik.apotik();
     
            System.out.println((char)27+"[01;34m=============="+(char)27+"[00;00m");
            owner.identitas();
            System.out.println("1.Login\n"
                    + "2.Masuk Sebagai Pembeli\n"
                    + (char)27+"[01;31m0.Out"+(char)27+"[00;00m");
            System.out.printf("Pilihan : ");
            option = keyboard.nextInt();
        
                if(option == 1){
                    System.out.print("Username : ");
        //            System.out.println((char)27+"[01;32m Teks warna hijau"+(char)27+"[00;00m");
                    keyboard.nextLine();
                    Username = keyboard.nextLine();
                    System.out.print("Password : ");
                    Password = keyboard.nextLine();
                    User pemilik = new Pemilik();
                    User apoteker = new Apoteker();

                    if(Username.equals(pemilik.getUsername())&& Password.equals(pemilik.getPassowrd())){
                        System.out.println((char)27+"[01;34m        Welcome "+(char)27+"[00;00m"+pemilik.getUsername());
                        do{
                            System.out.println("1.Riwayat Pembelian\n"
                                    +"2.Riwayat Pemesanan\n"
                                    + "3.Harga\n"
                                    + (char)27+"[01;31m0.Out"+(char)27+"[00;00m");
                            
                            System.out.printf("Pilihan anda : ");
                            option1 = keyboard.nextInt();
                            if(option1 == 1){
                                                                
                                for(int i  = 0;i<transaksi.size();i++){
                                    System.out.printf(i+1+"."+" ");
                                    transaksi.get(i).showTransaksi();
                                }
                            }
                            if(option1 == 2){
                                System.out.println("Daftar Pemesanan");
                                for(int i = 0; i < pemesanan.length;i++){                           
                                    if(pemesanan[i].getStokPesanan() !=  0){
                                        System.out.printf(i+1+".");
                                        pemesanan[i].dataPemesanan();
                                    }else{
                                        break;
                                    }
                                }
                            }if(option1==3){
                                trans.harga(20);
                                trans.harga(20,50);
                                trans.harga(20, 45, 60);
                            }
                        }while(option1 != 0);
                    }
                    else if(Username.equals(apoteker.getUsername()) && Password.equals(apoteker.getPassowrd())){
                        System.out.println((char)27+"[01;34m        Welcome "+(char)27+"[00;00m"+apoteker.getUsername());
                        do{    
                         System.out.println("1.Tampilkan Data Obat\n"
                                 +"2.Tambahkan Obat\n"
                                 +"3.Edit\n"
                                 + "4.Hapus\n"
                                 + "5.Cari\n"
                                 + "6.Pesan Obat\n"
                                 + (char)27+"[01;31m0.Out"+(char)27+"[00;00m");
                            System.out.printf("Masukkan Pilihan : ");
                        option1 = keyboard.nextInt();
                    if(option1 == 1){ 
                        for(int i=0 ; i<obat.length;i++){
                       if(obat[i].getNamaObat()!=null){
                          System.out.printf(i+1+".");
                          obat[i].dataObat();
                        }else{
                           break;
                       }
                    }





                    }else if(option1 == 2){
                    int x =0;
                      for(int i = 0 ; i<obat.length;i++){
                          if(obat[i].getNamaObat()== null){
                               t = i;
                               x = 1;
                              break;
                          }else{

                             }
                          }
                      if(x == 1){   
                           System.out.println("Daftar jenis obat yg bisa di tambahkan : 1=Pil,2=Tablet,3=Sirup");
                          System.out.printf("Masukkan Jenis Obat : ");
                         int jen = keyboard.nextInt();
                        switch(jen){
                            case 1:
                                jenisObat = JenisObat.Pil;
                                break;
                            case 2:
                                 jenisObat = JenisObat.Tablet;
                                break;
                            case 3:
                                 jenisObat = JenisObat.Sirup;
                                break;
                            default: System.out.println("Menu tidak tersedia");
                                break;
                        }
                        obat[t].setJenisObat(jenisObat);
                        System.out.printf("Nama Obat : ");
                        keyboard.nextLine();
                        namaObat = keyboard.nextLine();
                        obat[t].setNamaObat(namaObat);
                        System.out.printf("Kode Obat : ");
                        kdObat = keyboard.nextLine();
                        obat[t].setKdObat(kdObat);
                        System.out.printf("Perseidaan : ");
                        stok = keyboard.nextInt();
                        obat[t].setStok(stok);
                        System.out.printf("Harga : ");
                        keyboard.nextLine();
                        harga = keyboard.nextInt();
                        obat[t].setHarga(harga);                
                        System.out.println((char)27+"[01;32m Data Sukses Ditambahkan "+(char)27+"[00;00m");
                         

                        
                          System.out.println("==============");
//                          System.out.println(jenisObat);
                        }else{
                          System.out.println("Data gagal di tambahkan");
                      }
                }else if(option1 == 3){
                    for(int i =0 ; i<obat.length;i++){
                    if(obat[i].getNamaObat()!=null){
                            System.out.printf(i+1+".");
                            obat[i].dataObat();
                            }else{
                           break;
                       }
                    }
                    System.out.printf("Pilihan : ");
                    int in = keyboard.nextInt();
                    int ac = in - 1;
                    Apotik.inputan();
                    obat[ac].setObat(kdObat,namaObat,stok,harga,jenisObat);
                }else if(option1 == 4){
                    System.out.println((char)27+"[01;34m Daftar Obat yang dapat dihapus "+(char)27+"[00;00m");
                    for(int i =0 ; i<obat.length;i++){
                    if(obat[i].getNamaObat()!=null){
                        System.out.printf(i+1+".");
                           obat[i].dataObat();
                            }else{
                           break;
                       }
                    }
                    System.out.printf("Masukkan Pilihan : ");
                    int in = keyboard.nextInt();
                    int ac = in - 1;
                    obat[ac].setObat(null,null, 0, 0,null);
                    System.out.println("-----Data Sukses di Hapus-----");
                    for(int i=ac+1;i<obat.length;i++){
                        obat[i-1] = obat[i];
                    }
                    obat[obat.length-1].setObat(null,null,0,0,null);
                }else if(option1 == 5){
                    int x=0;
                    System.out.printf("Masukkan obat yang akan di cari by Kode Obat : ");
                    keyboard.nextLine();
                    String cari = keyboard.nextLine();
                        for (int i = 0;i< obat.length ; i++) {
                            if (cari.equals(obat[i].getKdObat())) {
                                System.out.println("Data Ditemukan");
                                obat[i].dataObat();
                                x=1;
                                 System.out.printf((char)27+"[01;31m0.Back "+(char)27+"[00;00m");
                                 System.out.println((char)27+"[01;32m | "+(char)27+"[00;00m");
                                 System.out.println("1.Pesan Obat?");
                                 System.out.println("2.Edit Obat?");
                                 System.out.printf("Pilihan anda :");
                                 int pilihan = keyboard.nextInt();
                                 if(pilihan == 1){
                                     int Stok1 = obat[i].getStok();
                                     System.out.printf("Masukkan Jumlah Pesanan : ");
                                     int jumlahPesan = keyboard.nextInt();
                                     obat[i].setStok(jumlahPesan+Stok1);
                                    for(int y =0 ; y<pemesanan.length;y++){
                                    if(pemesanan[y].getStokPesanan() == 0 && jumlahPesan != 0){
                                        kdObat = obat[i].getKdObat();
                                        namaObat = obat[i].getNamaObat();
                                        stokPesanan = jumlahPesan;
                                        harga = obat[i].getHarga();
                                        totalHarga =harga*stokPesanan;
                                        pemesanan[y].setPemesanan(namaObat,kdObat, stokPesanan, harga,totalHarga);
                                        System.out.println("==Obat sukses dipesan==");
                                        break;
                                    }else{
                                       }
                                    }
                                     
                                     
                                 }if(pilihan == 2){
                                     Apotik.inputan();
                                    obat[i].setObat(namaObat,kdObat,stok,harga,jenisObat.Sirup);
                                   System.out.println("==Data Obat suskes di edit==");
                                 }
                                break;
                                
                            }
                        }
                    if(x==0){
                        System.out.println("Data tidak ditemukan");
                    }
                }else if(option1 == 6){
                    for(int i =0 ; i<obat.length;i++){
                    if(obat[i].getNamaObat()!=null){
                           System.out.printf(i+1+".");
                           obat[i].dataObat();
                            }else{
                           break;
                       }
                    }
                        System.out.printf("Masukkan No. Obat yang akan dipesan : ");
                    int pesan = keyboard.nextInt();
                    int pesanan = pesan -1;         
                    int Stok1 = obat[pesanan].getStok();
                    System.out.printf("Masukkan Jumlah Pesanan : ");
                    int jumlahPesan = keyboard.nextInt();
                            System.out.println("Harga Obat : "
                                    +obat[pesanan].namaObat
                                    +" Rp."+ obat[pesanan].getHarga()*jumlahPesan
                                    +"\n Yakin ingin membeli?"+"\n0.Out 1.Yes");

                            int set = keyboard.nextInt();

                            if (set == 1) {
                                 obat[pesanan].setStok(jumlahPesan+Stok1);
                                 System.out.println("Selamat!! Obat berhasil di pesan");
                                 System.out.println("Jumlah Persedaain sekarang : "+obat[pesanan].getStok());
                                 int x = 0;
                                 for(int i =0 ; i<pemesanan.length;i++){
                              if(pemesanan[i].getStokPesanan() == 0 && jumlahPesan != 0){
                                   t = i;
                                   x = 1;
                                  break;
                              }else{
                                 }
                              }
                          if(x == 1){
                              kdObat = obat[pesanan].getKdObat();
                              namaObat = obat[pesanan].getNamaObat();
                              stokPesanan = jumlahPesan;
                              harga = obat[pesanan].getHarga();
                              totalHarga =harga*stokPesanan;
                              pemesanan[t].setPemesanan(kdObat,namaObat, stokPesanan, harga,totalHarga);
                                  }

                            }else{
                                System.out.println("-----Batal memesan Obat-----");
                            }


                }else{
                        System.out.println("Menu tidak tersedia");
                }
                    } while(option1 != 0);
                }else{
                        System.out.println("Id tidak ada");
                    }
                }if(option == 2){
            
            do {
                System.out.println("1.Tampilkan Data Obat");
                System.out.println("2.Cari Obat");
                System.out.println((char)27+"[01;31m0.Back"+(char)27+"[00;00m");
                System.out.printf("Masukkan Pilihan : ");
                option1 = keyboard.nextInt();
                if(option1 == 1){
                
                   for(int i = 0; i<obat.length;i++){
                       if(obat[i].getNamaObat()!=null){
                             System.out.printf(i+1+".");
                             obat[i].dataObat();
                             
                       }
                   }
                   System.out.printf((char)27+"[01;31m0.Back "+(char)27+"[00;00m");
                   System.out.printf((char)27+"[01;32m | "+(char)27+"[00;00m");
                   System.out.printf("Pesan Obat : ");
                   int pilihan = keyboard.nextInt();
                   int pilihan1 = pilihan -1;
                   if(pilihan1 == -1){
                       
                   }else{
                    int stok1 = obat[pilihan1].getStok();
                    System.out.printf("Masukkan Jumlah yang akan dibeli : ");
                    int jumlahBeli = keyboard.nextInt();
                    if(jumlahBeli >= stok1+1){
                        System.out.println("Persediaan tidak cukup");
                    }else if(jumlahBeli <=0){
                        System.out.println("Pesanan harus lebih dari samadengenan 1 ");
                   }else{
                      keyboard.nextLine();
                      System.out.printf("Masukkan nama anda : ");
                      nama = keyboard.nextLine();
                      System.out.printf("Masukkan alamat anda : ");
                      alamat = keyboard.nextLine();
                     System.out.println("Harga Obat : "+obat[pilihan1].namaObat
                           +" sebanyak : "+jumlahBeli
                           +" seharga Rp."+ obat[pilihan1].getHarga()*jumlahBeli
                           +"\nNama anda : "+nama
                           +"\nAlamat anda : "+alamat
                           +"\n Yakin ingin membeli?"+"\n1.Yes 0.Out");
                       int set = keyboard.nextInt();
                       if(set == 1){
                           obat[pilihan1].setStok(stok1-jumlahBeli);
                           int x = 0;
                         for(int i =0 ; i<transaksi.size();i++){
                      if(jumlahBeli != 0){
                           t = i;
                           x = 1;
                          break;
                      }else{
                          }
                      }
                  if(x == 1){
                      kdTrans = null;
                      namaObat = obat[pilihan].getNamaObat();
                      kdObat = obat[pilihan1].getKdObat();
                      stokPembelian = jumlahBeli;
                      harga = obat[pilihan1].getHarga();
                      totalHarga =harga*stokPesanan;
//                      transaksi[t].setTransaksi(nama,alamat,kdTrans,kdObat,namaObat,harga,stokPembelian);
                      transaksi.add(new Transaksi(nama,alamat,kdTrans,kdObat,namaObat,harga,stokPembelian));
                      System.out.println((char)27+"[01;36mSelamat anda berhasil membeli Obat"+(char)27+"[00;00m");
                       }else{
                      break;
                  }

                             
                    }
                }
                   }
                }else if(option1 ==2){
                    int x = 0;
                    System.out.printf("Cari Obat dengan Kode Obat : ");
                    keyboard.nextLine();
                    String cari = keyboard.nextLine();
                    for (int i=0;i<obat.length;i++) {
                    if (cari.equals(obat[i].getKdObat())) {
                        System.out.println((char)27+"[01;32m ============================================================================ "+(char)27+"[00;00m");
                        System.out.println("--------Data Ditemukan---------");
                        System.out.println("Nama Obat : "+obat[i].getNamaObat()+" | "+"Kode Obat : "+obat[i].kdObat+" | Persediaan : "+obat[i].getStok()+" | Harga : "+obat[i].getHarga());
                        System.out.println((char)27+"[01;32m ============================================================================ "+(char)27+"[00;00m");
                        System.out.printf("Masukkan jumlah obat yang dibeli : ");
                        int pesan = keyboard.nextInt();
                        keyboard.nextLine();
                        System.out.printf("Masukkan nama anda : ");
                        nama = keyboard.nextLine();
                        System.out.printf("Masukkan alamat anda : ");
                        alamat = keyboard.nextLine();
                          System.out.println("Harga Obat : "+obat[i].namaObat
                           +" sebanyak : "+pesan
                           +" seharga Rp."+ obat[i].getHarga()*pesan
                           +"\nNama anda : "+nama
                           +"\nAlamat anda : "+alamat
                           +"\n Yakin ingin membeli?"+"\n1.Yes 0.Out");
                       int set = keyboard.nextInt();
                        if(set == 1){
                        int beli = obat[i].getStok()-pesan;
                        obat[i].setStok(beli);                       
                         for(int y =0 ; y<transaksi.size();y++){
                      if(pesan != 0){
                           t = y;
                           x = 1;
                          break;
                      }else{
                         }
                      }
                  if(x == 1){
                      kdTrans = null;
                      namaObat = obat[i].getNamaObat();
                      kdObat = obat[i].getKdObat();
                      stokPembelian = pesan;
                      harga = obat[i].getHarga();
                      totalHarga =harga*stokPesanan;
                      transaksi.add(new Transaksi(nama,alamat,kdTrans,kdObat,namaObat,harga,stokPembelian));
//                      transaksi[t].setTransaksi(nama,alamat,kdTrans,kdObat,namaObat,harga,stokPembelian);
                      System.out.println((char)27+"[01;36mSelamat anda berhasil membeli Obat"+(char)27+"[00;00m");
                       }else{
                      break;
                  }
                        }
                    }
                }
            if(x==0){
                System.out.println("------Data tidak ditemukan-------");
            }
                }else{
                    System.out.println("-----Menu Tidak Tersedia------");
                }
            } while (option1 != 0);
            
        }
    }while(option != 0);
        }catch(Exception e){
            System.out.println("Terdapat kesalahan pada " +e);
}finally{
            System.out.println("Program Selesai");
        }
}

    public static void inputan(){
        Scanner keyboard = new Scanner(System.in);
        System.out.printf("Nama Obat  : ");
        namaObat = keyboard.nextLine();
        System.out.printf("Kode Obat  : ");
        kdObat = keyboard.nextLine();
        System.out.printf("Stok Obat  : ");
        stok = keyboard.nextInt();
        System.out.printf("Harga  : ");
        harga = keyboard.nextInt();
        System.out.println("Daftar jenis obat yg bisa di tambahkan : Pil,Tablet,Sirup");
        System.out.printf("Masukkan Jenis Obat : ");
        keyboard.nextLine();
        String tes = keyboard.nextLine();
        jenisObat = JenisObat.valueOf(tes);
        
    }
}

/*
Nama : Permana
NIM  : 11418028
Kelas: 42TRPL1
Tanggal : 13-12-2019
 */