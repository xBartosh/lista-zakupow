import java.util.ArrayList;
import java.util.List;

public class Owoce extends Zakupy {
    static List<String> owoce = new ArrayList<String>();
    static int licznik = 0;

    public Owoce(){}

    public Owoce(String nazwa){
        owoce.add(licznik, nazwa);
        licznik++;
    }

    public List zbierzListe(){
        return owoce;
    }

    public void wyczyscListe(){
        owoce.clear();
        licznik = 0;
    }
}
