public class Araba {

    private static int idSayac;
    private int id;
    private String marka;
    private String model;
    private String vites;
    private double gunlukFiyat;

    Araba(){
        this.id = ++idSayac;
    }
    Araba(String marka,String model, String vites, double gunlukFiyat) {
        this.id = ++idSayac;
        this.marka = marka;
        this.model = model;
        this.vites = vites;
        this.gunlukFiyat = gunlukFiyat;
    }

    public int getId() {
        return id;
    }
    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getVites() {
        return vites;
    }

    public void setVites(String vites) {
        this.vites = vites;
    }

    public double getGunlukUcret() {
        return gunlukFiyat;
    }

    public void setGunlukUcret(double gunlukUcret) {
        this.gunlukFiyat = gunlukUcret;
    }

    @Override
    public String toString() {
        return  "Marka : " + marka +
                " Model : " + model +
                " Vites : " + vites +
                " Gunluk Fiyat :" + gunlukFiyat;
    }
}
