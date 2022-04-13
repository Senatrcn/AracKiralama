import java.time.LocalDate;

public class Kiralama {

    private static int idSayac;
    private int id;
    private Araba araba;
    private LocalDate teslimGunu;
    private LocalDate iadeGunu;
    private int gunSayisi;
    private double toplamUcret;


    Kiralama(){
        id=++idSayac;
    }
    Kiralama(LocalDate teslimGunu, int gunSayisi){
        id=++idSayac;
        this.teslimGunu=teslimGunu;
        this.gunSayisi=gunSayisi;
    }

    public Araba getAraba() {
        return araba;
    }

    public void setAraba(Araba araba) {
        this.araba = araba;
    }

    public LocalDate getTeslimGunu() {
        return teslimGunu;
    }

    public void setTeslimGunu(LocalDate teslimGunu) {
        this.teslimGunu = teslimGunu;
    }

    public int getGunSayisi() {
        return gunSayisi;
    }

    public void setGunSayisi(int gunSayisi) {
        this.gunSayisi = gunSayisi;
    }

    public LocalDate getIadeGunu() {
        return iadeGunu;
    }

    public void setIadeGunu(LocalDate iadeGunu) {
        this.iadeGunu = iadeGunu;
    }

    public double getToplamUcret() {
        return toplamUcret;
    }

    public void setToplamUcret() {
        toplamUcret = araba.getGunlukUcret()*gunSayisi;
    }

    @Override
    public String toString() {
        return   araba +
                "\nTeslim Gunu : " + teslimGunu +
                "\nIade Gunu : " + iadeGunu +
                "\nGun Sayisi : " + gunSayisi;
    }
}
