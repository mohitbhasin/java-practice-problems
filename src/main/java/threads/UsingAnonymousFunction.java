package threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class UsingAnonymousFunction {
    public static void main(String[] args) throws InterruptedException {
        String[] words = {"Enormous","Hodgepodge","Delightful","Fluster","Corridor","Bargains","Sincere","Vulnerable","Feasible","Intriguing","Gleeful","Bothers","Plast)r","Gladiolus","Canvass","Nostalgia","Jocular","Novice","Obdurate","Corduroy"};
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        List<Future<Integer>> stringSizeList = new ArrayList<>();

        for(String word: words) {
            Callable<Integer> task = () -> {
                return getWordSize(word);
            };

            Future<Integer> future = executorService.submit(task);
            stringSizeList.add(future);
        }

        executorService.shutdown();


        for(int i=0; i<words.length; i++) {
            try {
                System.out.println(words[i]+": "+stringSizeList.get(i).get());
            } catch (Exception e) {
                System.out.println("Exception: "+e);
            }
        }

    }

    public static int getWordSize(String s) {
        return s.length();
    }
}
