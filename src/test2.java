import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class test2 {
    public static void main(String[] args) {
        ObservableList<Integer> array = FXCollections.observableArrayList();
        array.add(15);
        // array.remove(15);
        System.out.println(array.get(0));
    }
}
