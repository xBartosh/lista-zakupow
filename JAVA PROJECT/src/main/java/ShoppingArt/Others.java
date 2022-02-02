package ShoppingArt;

import java.util.ArrayList;
import java.util.List;

public class Others extends Shopping {
    static List<String> othList = new ArrayList<>();
    static int number = 0;

    public Others() {
    }

    public Others(String name) {
        othList.add(number, name);
        number++;
    }

    public void clearList() {
        super.clearList(othList);
        number = 0;
    }

    public List getList() {
        return othList;
    }
}
