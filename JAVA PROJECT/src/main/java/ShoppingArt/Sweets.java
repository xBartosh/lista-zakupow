package ShoppingArt;

import java.util.ArrayList;
import java.util.List;

public class Sweets extends Shopping {

    static List<String> sweList = new ArrayList<>();
    static int number = 0;

    public Sweets() {
    }

    public Sweets(String name) {
        sweList.add(number, name);
        number++;
    }

    public void clearList() {
        super.clearList(sweList);
        number = 0;
    }

    public List getList() {
        return sweList;
    }
}
