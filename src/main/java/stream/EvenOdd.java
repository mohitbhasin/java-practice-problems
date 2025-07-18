package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EvenOdd {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(4,2,6,7,1,0,8,5,9,3);

        List<Integer> evenNums = list.stream().filter(a -> a%2==0).sorted().toList();
        System.out.println(evenNums);
        List<Integer> oddNums = list.stream().filter(a -> a%2==1).sorted().toList();
        System.out.println(oddNums);


        List<Integer> evenNums2 = list.stream().filter(a -> a%2==0).sorted().collect(Collectors.toList());
        System.out.println(evenNums2);
    }
}
