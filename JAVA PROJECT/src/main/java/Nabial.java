import java.util.ArrayList;
import java.util.List;

public class Nabial extends Zakupy{
    static List<String> nabial = new ArrayList<String>();
    static int licznik = 0;

    public Nabial(){}

    public Nabial(String nazwa){
        nabial.add(licznik, nazwa);
        licznik++;
    }


    public List zbierzListe(){
        return nabial;
    }

    public void wyczyscListe(){
        nabial.clear();
        licznik = 0;
    }
}
