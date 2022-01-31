import java.util.ArrayList;
import java.util.List;

public class Slodycze extends Zakupy{
    static List<String> slodycze = new ArrayList<String>();
    static int licznik = 0;

    public Slodycze() {
    }

    public Slodycze(String nazwa) {
        slodycze.add(licznik, nazwa);
        licznik++;
    }

    public List zbierzListe() {
        return slodycze;
    }

    public void wyczyscListe(){
        slodycze.clear();
        licznik = 0;
    }
}
