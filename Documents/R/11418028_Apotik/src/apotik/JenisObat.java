//Enum
package apotik;


public enum JenisObat {
    Pil,Tablet,Sirup;
    
    public String toString(){
        switch(this){
            case Pil:
                return "Pil";
            case Tablet:
                return "Tablet";
            case Sirup:
                return "Sirup";
            default : return "undifined";
        }
    }
}


/*
Nama : Permana
NIM  : 11418028
Kelas: 42TRPL1
Tanggal : 13-12-2019
 */
