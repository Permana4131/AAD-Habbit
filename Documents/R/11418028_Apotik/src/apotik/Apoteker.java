package apotik;

public class Apoteker implements User {
     private String username = "apoteker";
    private String password = "apoteker";

    
    Apoteker(){
        
    }
    @Override
    public String getUsername(){
        return this.username;
    }
    
    @Override
    public String getPassowrd(){
        return this.password;
    }
}


/*
Nama : Permana
NIM  : 11418028
Kelas: 42TRPL1
Tanggal : 13-12-2019
 */
