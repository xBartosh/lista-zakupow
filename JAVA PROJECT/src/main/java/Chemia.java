import java.util.ArrayList;
import java.util.List;

public class Chemia extends Zakupy {
    static List<String> chemia = new ArrayList<String>();
    static int licznik = 0;

    public Chemia() {
    }

    public Chemia(String nazwa) {
        chemia.add(licznik, nazwa);
        licznik++;
    }


    public List zbierzListe() {
        return chemia;
    }

    public void wyczyscListe(){
        chemia.clear();
        licznik = 0;
    }

}
