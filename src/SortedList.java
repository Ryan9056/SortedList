import java.util.ArrayList;

public class SortedList {


    ArrayList<String> list = new ArrayList<>();

    public void addString(String string) {

        int point = Sort(string);
        list.add(point, string);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

    }

    public int Sort(String string) {

        int low = 0;
        int high = list.size() - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            String midString = list.get(mid);
            if (midString.compareTo(string) < 0) {
                low = mid + 1;
            } else  {
                high = mid - 1;
            }

        }
        return low;

    }

    public boolean search(String string) {

        int point = Sort(string);

        if (list.get(point).equals(string) && point < list.size()) {
            return true;
        } else {
            return false;
        }

    }


}