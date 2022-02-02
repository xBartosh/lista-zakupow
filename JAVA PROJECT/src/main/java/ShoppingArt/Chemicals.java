package ShoppingArt;

import java.util.ArrayList;
import java.util.List;

public class Chemicals extends Shopping {

    static List<String> chemList = new ArrayList<>();
    static int number = 0;

    public Chemicals() {
    }

    public Chemicals(String name) {
        chemList.add(number, name);
        number++;
    }

    public void clearList() {
        super.clearList(chemList);
        number = 0;
    }

    public List getList() {
        return chemList;
    }

}
