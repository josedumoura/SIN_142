package CPU_Bound;

import java.util.Arrays;
import java.util.Random;

public class TesteSequencial {
    
    private static final Random random = new Random(42);
   
    public static void main (String[] args) {
        
        int TAM = 100000000;
        
        int[] a = criarArrayAleatorio(TAM);
        
        //imprimirArray(a);
        
        MergeSortSequencial mergeSequencial = new MergeSortSequencial();
        
        //long startTime1 = System.currentTimeMillis();
			
	mergeSequencial.mergeSort(a, 0, a.length - 1);
        
        //long endTime1 = System.currentTimeMillis();
        
        //imprimirArray(a);
        
        //System.out.printf("Merge Sort Sequencial: %d elements  =>  %6d ms \n", TAM, endTime1 - startTime1);
        
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
