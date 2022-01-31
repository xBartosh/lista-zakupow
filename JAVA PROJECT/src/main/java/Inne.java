import java.util.ArrayList;
import java.util.List;

public class Inne extends Zakupy{
    static List<String> inne = new ArrayList<String>();
    static int licznik = 0;

    public Inne(){}

    public Inne(String nazwa){
        inne.add(licznik, nazwa);
        licznik++;
    }


    public List zbierzListe(){
        return inne;
    }

    public void wyczyscListe(){
        inne.clear();
        licznik = 0;
    }
}
