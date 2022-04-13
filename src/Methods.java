import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Methods extends VeriBankasi{
    static Scanner scan = new Scanner(System.in);

    public static void girisEkrani(){
        System.out.println("Yeni hesap olusturmak icin 1\nHesabınıza giris yapmak icin 2\nÇıkış için 3'ü tuşlayın");
        int islem= scan.nextInt();
        scan.nextLine();
        if (islem ==1){
            yeniMusteriKaydi();
        }else if (islem ==2){
            musteriGiris();
        }else if(islem == 3){
            System.out.println("Yine bekleriz");
            System.exit(0);
        }else girisEkrani();

    }
    public static void yeniMusteriKaydi(){
        musteriler.add(new Musteri());
        musteriGiris();
    }
    public static void musteriGiris(){
        boolean login= false;
        System.out.println("Kullanıcı adınızı giriniz");
        String girilenIsim= scan.nextLine();

        System.out.println("Şifrenizi giriniz");
        String girilenSifre = scan.nextLine();

        for (Musteri musteri : musteriler) {
            if (musteri.getIsimSoyisim().equals(girilenIsim) && musteri.getSifre().equals(girilenSifre)) {
                login = true;
                System.out.println("Giriş başarılı");
                arabaListele(musteri);
            }
        }
        if (!login){
            System.out.println("Kullanıcı adı veya sifre yanlış");
            musteriGiris();
        }

    }

    public static void arabaListele(Musteri musteri){
        System.out.println("**** Mevcut arabalarımız ****");
        arabaListesi();
        System.out.println("Araba secimi yapmak icin 1\nFiltreleme yapmak icin 2'yi tuslayın");
        int secim = scan.nextInt();
        scan.nextLine();
        if (secim == 1){
            arabaKirala(musteri);
        }else if (secim == 2){
            arabaFiltrele(musteri);
        }else arabaListele(musteri);
    }
    public static void arabaFiltrele(Musteri musteri){

            System.out.println("Filtre olarak \nMarka : 1\nModel : 2\nVites : 3\nFiyat : 4 secebilirsiniz ");
            int secim = scan.nextInt();

            switch(secim){
                case 1:
                    System.out.println("Secebileceginiz araba markaları : ");
                    VeriBankasi.arabaMarka();
                    System.out.println("Sectiginiz marka id'sini girin");
                    String markaFiltre = VeriBankasi.markalar.get(scan.nextInt()-1);

                    for (Araba araba: arabalar){
                        if(araba.getMarka().equals(markaFiltre)){
                            System.out.println(araba.getId()+"  "+araba.getMarka()+"        "+araba.getModel()+"        "+araba.getVites()+"        "+araba.getGunlukUcret());
                        }
                    }
                    break;
                case 2:
                    System.out.println("Secebileceginiz araba modelleri : ");
                    VeriBankasi.arabaModel();
                    System.out.println("Sectiginiz model id'sini girin");
                    String modelFiltre = VeriBankasi.modeller.get(scan.nextInt()-1);

                    for (Araba araba: arabalar){
                        if(araba.getModel().equals(modelFiltre)){
                            System.out.println(araba.getId()+"  "+araba.getMarka()+"        "+araba.getModel()+"        "+araba.getVites()+"        "+araba.getGunlukUcret());
                        }
                    }
                    break;
                case 3:
                    System.out.println("Secebileceginiz araba vites cesitleri : ");
                    VeriBankasi.arabaVites();
                    System.out.println("Sectiginiz vites id'sini girin");
                    String vitesFiltre = VeriBankasi.vitesler.get(scan.nextInt()-1);

                    for (Araba araba: arabalar){
                        if(araba.getVites().equals(vitesFiltre)){
                            System.out.println(araba.getId()+"  "+araba.getMarka()+"        "+araba.getModel()+"        "+araba.getVites()+"        "+araba.getGunlukUcret());
                        }
                    }
                    break;
                case 4:
                    System.out.println("Max fiyatınızı girin");
                    double fiyatFiltre = scan.nextDouble();
                    scan.nextLine();
                    for (Araba araba: arabalar){
                        if(araba.getGunlukUcret()<=fiyatFiltre){
                            System.out.println(araba.getId()+"  "+araba.getMarka()+"        "+araba.getModel()+"        "+araba.getVites()+"        "+araba.getGunlukUcret());
                        }
                    }
                    break;
            }
           arabaKirala(musteri);
    }

    public static void arabaKirala(Musteri musteri){
        Kiralama kiralama = new Kiralama();

        System.out.println("Sectiginiz arabanın id'sini girin");
        kiralama.setAraba(VeriBankasi.arabalar.get(scan.nextInt()-1));

        System.out.println("Sectiginiz Araba "+ kiralama.getAraba() );

        System.out.println("Teslim alacagınız tarihi girin : GG.AA.YYYY");
        String tarih = scan.next();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy", Locale.ENGLISH);

        System.out.println("Kac gün kullanacaksınız");

        kiralama.setGunSayisi(scan.nextInt());
        kiralama.setTeslimGunu(LocalDate.parse(tarih, formatter));
        kiralama.setIadeGunu(kiralama.getTeslimGunu().plusDays(kiralama.getGunSayisi()));
        System.out.println(kiralama);

        System.out.println("Onaylıyorsanız 1\nIsleme yeniden baslamak icin 2");
        int onay = scan.nextInt();
        if(onay==1){
            odeme(musteri,kiralama);
        }else {
            arabaKirala(musteri);
        }

    }
    public static void odeme(Musteri musteri, Kiralama kiralama){

        kiralama.setToplamUcret();
        System.out.println("Toplam borcunuz : "+ kiralama.getToplamUcret());
        System.out.println("Bakiyeniz : "+musteri.getBakiye());

        if (musteri.getBakiye()<kiralama.getToplamUcret()){
            System.out.println("Bakiyeniz yetersiz. Lütfen para yükleyin");
            musteri.setBakiye();
            odeme(musteri,kiralama);
        }else {
            musteri.setBakiye(musteri.getBakiye()- kiralama.getToplamUcret());
            System.out.println("Ödeme başarıyla gerçeklesti");
            System.out.println("Kalan bakiyeniz : "+ musteri.getBakiye());
        }
    }
}
