import java.util.ArrayList;
import java.util.List;

public class week3 {
    public static void main(String[] args) {


        // 3.3d)
        List<Integer> values = new ArrayList<>();
        for(int i = 1;i<10;i++){
            values.add(i);
        }
        
        values.stream()
            .filter(x -> x % 2==0)
            .map(x -> x*x)
            .forEach(System.out::println);

    }
}
