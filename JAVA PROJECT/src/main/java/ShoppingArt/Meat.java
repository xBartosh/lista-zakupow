package ShoppingArt;

import java.util.ArrayList;
import java.util.List;

public class Meat extends Shopping {

    static List<String> meaList = new ArrayList<>();
    static int number = 0;

    public Meat() {
    }

    public Meat(String name) {
        meaList.add(number, name);
        number++;
    }

    public void clearList() {
        super.clearList(meaList);
        number = 0;
    }

    public List getList() {
        return meaList;
    }

}
