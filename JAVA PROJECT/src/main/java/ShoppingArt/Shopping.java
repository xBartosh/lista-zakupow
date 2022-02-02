package ShoppingArt;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Shopping {

    public Shopping(){ }


    public void clearList(List<String> list){
        list.clear();
    }

    public void sortListAlf(List<String> list){
        list.sort(Comparator.naturalOrder());
    }




}
