import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Zakupy {
    List<String> list = new ArrayList<>();
    static int licznik = 0;

    public Zakupy(){

    }

    public void dodajProdukt(){
        String[] tab = new String[100];
        Scanner scan = new Scanner(System.in);
        for(int i = 0; ;i++){
            String dec;
            wybierzProdukt();
            dec = scan.nextLine();

            if(dec.equals("exit")) break;
            switch(dec){
                case "0":
                    return;
                case "1":
                    wpiszProdukt();
                    tab[i] = scan.nextLine();
                    Warzywa warzywa = new Warzywa(tab[i]);
                    break;
                case "2":
                    wpiszProdukt();
                    tab[i] = scan.nextLine();
                    Owoce owoce = new Owoce(tab[i]);
                    break;
                case "3":
                    wpiszProdukt();
                    tab[i] = scan.nextLine();
                    Mieso mieso = new Mieso(tab[i]);
                    break;
                case "4":
                    wpiszProdukt();
                    tab[i] = scan.nextLine();
                    Pieczywo pieczywo = new Pieczywo(tab[i]);
                    break;
                case "5":
                    wpiszProdukt();
                    tab[i] = scan.nextLine();
                    Nabial nabial = new Nabial(tab[i]);
                    break;
                case "6":
                    wpiszProdukt();
                    tab[i] = scan.nextLine();
                    Chemia chemia = new Chemia(tab[i]);
                    break;
                case "exit":
                    break;
                default:
                    System.out.println("Zly numer, wpisz od 1 do 3");
                    continue;
            }

            if(tab[i].equals("exit")) break;
        }
    }


    public void wpiszProdukt(){
        System.out.println("Wpisz nazwe produktu: ");
    }

    public void wybierzProdukt(){
        System.out.println("Wpisz produkt jaki chcesz dodac:\n" +
                "0) Zakoncz\n" +
                "1) Warzywa\n" +
                "2) Owoce\n" +
                "3) Mieso\n" +
                "4) Pieczywo\n" +
                "5) Nabiał\n" +
                "6) Chemia\n");
    }

}
