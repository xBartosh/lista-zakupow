package ShoppingArt;

import java.util.ArrayList;
import java.util.List;

public class Fruits extends Shopping {

    static List<String> fruList = new ArrayList<>();
    static int number = 0;

    public Fruits() {
    }

    public Fruits(String name) {
        fruList.add(number, name);
        number++;
    }

    public void clearList() {
        super.clearList(fruList);
        number = 0;
    }

    public List getList() {
        return fruList;
    }
}
