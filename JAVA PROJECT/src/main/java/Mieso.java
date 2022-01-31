import java.util.ArrayList;
import java.util.List;

public class Mieso extends Zakupy {
    static List<String> mieso = new ArrayList<String>();
    static int licznik = 0;

    public Mieso() {
    }

    public Mieso(String nazwa) {
        mieso.add(licznik, nazwa);
        licznik++;
    }

    public List zbierzListe() {
        return mieso;
    }

    public void wyczyscListe(){
        mieso.clear();
        licznik = 0;
    }


}
