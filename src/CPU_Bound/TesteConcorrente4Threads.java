package CPU_Bound;

import java.util.Arrays;
import java.util.Random;


public class TesteConcorrente4Threads {
    
    private static final Random random = new Random(42);
    
    public static void main (String[] args) {
        
        int TAM = 100000000;
        
        int metade = TAM / 2;
        
        int[] a = criarArrayAleatorio(TAM);
        
        //imprimirArray(a);
        
        MergeSortConcorrente mergeConcorrente = new MergeSortConcorrente();
        
        
        int[] part1 = Arrays.copyOfRange(a, 0, metade/2);
        int[] part2 = Arrays.copyOfRange(a, metade/2, TAM/2);
        int[] part3 = Arrays.copyOfRange(a, TAM/2, (metade+TAM)/2);
        int[] part4 = Arrays.copyOfRange(a, (metade+TAM)/2, TAM);
        
        long startTime1 = System.currentTimeMillis();
        
        Thread t1 = new Thread(new Sorter(part1, 0, part1.length - 1));
        Thread t2 = new Thread(new Sorter(part2, 0, part2.length - 1));
        Thread t3 = new Thread(new Sorter(part3, 0, part3.length - 1));
        Thread t4 = new Thread(new Sorter(part4, 0, part4.length - 1));
        t1.start();
        t2.start();
        t3.start();
        t4.start();

        try {
                t1.join();
                t2.join();
                t3.join();
                t4.join();
        } catch (InterruptedException ie) {}
        
        int temp1[] = new int[part1.length + part2.length];
        int temp2[] = new int[part3.length + part4.length];

        // merge them back together
        mergeConcorrente.merge(part1, part2, temp1);
        mergeConcorrente.merge(part3, part4, temp2);
        mergeConcorrente.merge(temp1, temp2, a);
        
        long endTime1 = System.currentTimeMillis();
        
        //imprimirArray(a);
        
        System.out.printf("Merge Sort Concorrente 4 Threads: %d elements  =>  %6d ms \n", TAM, endTime1 - startTime1);
        
    
        
    }
    
    public static int[] criarArrayAleatorio(int tam) {
        
        int[] a = new int[tam];
        
        for (int i = 0; i < tam; i++) {
                a[i] = random.nextInt(1000000);
                
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
