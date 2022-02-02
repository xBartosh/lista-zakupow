package ShoppingArt;

import java.util.ArrayList;
import java.util.List;

public class Dairy extends Shopping {

    static List<String> daiList = new ArrayList<>();
    static int number = 0;

    public Dairy() {
    }

    public Dairy(String name) {
        daiList.add(number, name);
        number++;
    }

    public void clearList() {
        super.clearList(daiList);
        number = 0;
    }

    public List getList() {
        return daiList;
    }
}
