import java.util.ArrayList;
import java.util.List;

public class Warzywa extends Zakupy{
    static List<String> warzywa = new ArrayList<String>();
    static int licznik = 0;
    public Warzywa(){

    }
    public Warzywa(String nazwa){
        warzywa.add(licznik, nazwa);
        licznik++;
    }

    public List zbierzListe(){
        return warzywa;
    }

    public void wyczyscListe(){
        warzywa.clear();
        licznik = 0;
    }
}
