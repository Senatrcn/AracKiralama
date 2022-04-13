public class Musteri {
    private static int idSayac;
    private int id;
    private String kullaniciAdi;
    private String sifre;
    private double bakiye;

    Musteri(){
        this.id=++idSayac;
        setIsimSoyisim();
        setSifre();
        setBakiye();
        System.out.println("Yeni müsteri kaydı olusturuldu");
    }
    Musteri(String isimSoyisim, String sifre,String telNo,double bakiye){
        this.kullaniciAdi=isimSoyisim;
        this.sifre=sifre;
        this.bakiye=bakiye;
    }

    public String getIsimSoyisim() {
        return kullaniciAdi;
    }

    public void setIsimSoyisim() {
        System.out.println("Kullanıcı adınızı belirleyin");
        this.kullaniciAdi = Methods.scan.nextLine();
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre() {
        System.out.println("Sifrenizi belirleyin");
        this.sifre = Methods.scan.nextLine();
    }

    public double getBakiye() {
        return bakiye;
    }

    public void setBakiye() {
        System.out.println("Bakiyenizi belirleyin");
        this.bakiye += Methods.scan.nextDouble();
        Methods.scan.nextLine();
    }
    public void setBakiye(double bakiye) {
        this.bakiye = bakiye;
    }

    @Override
    public String toString() {
        return "Musteri{" +
                "id=" + id +
                ", isimSoyisim='" + kullaniciAdi + '\'' +
                ", bakiye=" + bakiye +
                '}';
    }
}
