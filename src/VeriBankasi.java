import java.util.ArrayList;
import java.util.List;

public class VeriBankasi {

    static List<Araba> arabalar = new ArrayList<>();
    static List<Musteri> musteriler = new ArrayList<>();
    static List<String> markalar = new ArrayList<>();
    static List<String> modeller = new ArrayList<>();
    static List<String> vitesler = new ArrayList<>();

    public static void arabaListesi(){
        arabalar.add(new Araba("Audi","A3","Otomatik",100));
        arabalar.add(new Araba("Audi","A4","Otomatik",150));
        arabalar.add(new Araba("Audi","A6","Manuel",170));
        arabalar.add(new Araba("Opel","Astra","Otomatik",90));
        arabalar.add(new Araba("Opel","Astra","Manuel",80));
        arabalar.add(new Araba("Volvo","XC90","Otomatik",120));
        arabalar.add(new Araba("Volvo","XC90","Manuel",100));
        arabalar.add(new Araba("Volvo","S60","Otomatik",110));

        for(Araba araba : arabalar){
            System.out.println(araba.getId()+"  "+araba.getMarka()+"        "+araba.getModel()+"        "+araba.getVites()+"        "+araba.getGunlukUcret());
        }

    }
    public static void arabaMarka(){

        for (Araba arb: arabalar){
            if (!markalar.contains(arb.getMarka())){
                markalar.add(arb.getMarka());
            }
        }
        System.out.println(markalar);
    }
    public static void arabaModel(){

        for (Araba arb: arabalar){
            if (!modeller.contains(arb.getModel())){
                modeller.add(arb.getModel());
            }
        }
        System.out.println(modeller);
    }
    public static void arabaVites(){

        for (Araba arb: arabalar){
            if (!vitesler.contains(arb.getVites())){
                vitesler.add(arb.getVites());
            }
        }
        System.out.println(vitesler);
    }

}
