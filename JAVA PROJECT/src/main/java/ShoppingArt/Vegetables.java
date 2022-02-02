package ShoppingArt;

import java.util.ArrayList;
import java.util.List;

public class Vegetables extends Shopping {
    static List<String> vegList = new ArrayList<>();
    static int number = 0;

    public Vegetables() {
    }

    public Vegetables(String name) {
        vegList.add(number, name);
        number++;
    }

    public void clearList() {
        super.clearList(vegList);
        number = 0;
    }

    public List getList() {
        return vegList;
    }

}
