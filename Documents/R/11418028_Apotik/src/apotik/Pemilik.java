//Pemanggilan Interface

package apotik;

public class Pemilik implements User{
    private final String username = "pemilik";
    private final String password = "pemilik";

    Pemilik(){
        
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
