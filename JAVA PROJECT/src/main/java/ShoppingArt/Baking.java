package ShoppingArt;

import java.util.ArrayList;
import java.util.List;

public class Baking extends Shopping {

    static List<String> bakList = new ArrayList<>();
    static int number = 0;

    public Baking() {
    }

    public Baking(String name) {
        bakList.add(number, name);
        number++;
    }

    public void clearList() {
        super.clearList(bakList);
        number = 0;
    }

    public List getList() {
        return bakList;
    }
}
