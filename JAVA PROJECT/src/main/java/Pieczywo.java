import java.util.ArrayList;
import java.util.List;

public class Pieczywo extends Zakupy {
    static List<String> pieczywo = new ArrayList<String>();
    static int licznik = 0;

    public Pieczywo(){}

    public Pieczywo(String nazwa){
        pieczywo.add(licznik, nazwa);
        licznik++;
    }

    public List zbierzListe(){
        return pieczywo;
    }

    public void wyczyscListe(){
        pieczywo.clear();
        licznik = 0;
    }
}
