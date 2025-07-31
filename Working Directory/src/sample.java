import java.util.Arrays;
import java.util.List;

public class sample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3);
        List<Integer> finNumbers = numbers.stream().map(x->x*2).toList();
        for (Integer nn:finNumbers){
            System.out.println(nn);
        }
    }
}
