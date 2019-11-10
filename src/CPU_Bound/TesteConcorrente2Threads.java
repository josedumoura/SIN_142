package CPU_Bound;

import java.util.Arrays;
import java.util.Random;


public class TesteConcorrente2Threads {
    
    private static final Random random = new Random(42);
    
    public static void main (String[] args) {
        
        int TAM = 100000000;
        
        int[] a = criarArrayAleatorio(TAM);
        
        //imprimirArray(a);
        
        MergeSortConcorrente mergeConcorrente = new MergeSortConcorrente();
        
        
        int[] left  = Arrays.copyOfRange(a, 0, a.length / 2);
        int[] right = Arrays.copyOfRange(a, a.length / 2, a.length);

        long startTime1 = System.currentTimeMillis();
        
        Thread lThread = new Thread(new Sorter(left, 0, left.length - 1));
        Thread rThread = new Thread(new Sorter(right, 0 , right.length - 1));
        lThread.start();
        rThread.start();

        try {
                lThread.join();
                rThread.join();
        } catch (InterruptedException ie) {}

        // merge them back together
        mergeConcorrente.merge(left, right, a);
        
        long endTime1 = System.currentTimeMillis();
        
        //imprimirArray(a);
        
        System.out.printf("Merge Sort Concorrente 2 Threads: %d elements  =>  %6d ms \n", TAM, endTime1 - startTime1);
        
        
    }
    
    public static int[] criarArrayAleatorio(int tam) {
        
        int[] a = new int[tam];
        
        for (int i = 0; i < tam; i++) {
                a[i] = random.nextInt(100000000);
                
        }
        
        return a;
    }
    
    public static void imprimirArray (int temp[]) {
        int i;
        for (i = 0; i < temp.length; i++) {
            System.out.print(temp[i] + " ");
        }
        System.out.printf("\n\n");
    }
}
