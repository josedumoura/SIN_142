/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CPU_Bound;

/**
 *
 * @author thiago
 */
public class MergeSortSequencial {
    
    void mergesort(int v[], int l, int r) {
    
        int m = (l + r) / 2;
        if (l < r) {
            /*divisão*/
            mergesort(v, l, m);
            mergesort(v, m + 1, r);
            /*conquista*/
            merge(v, l, m, r);
        }
    }
    
   
    void merge(int v[], int l, int m, int r) {
        
        int MAX = v.length;
        int aux[] = new int[MAX];
        int i = l, j = m + 1, k = 0;
        
        /*intercala*/
        while (i <= m && j <= r)
            if (v[i] <= v[j])
                aux[k++] = v[i++];
            else
                aux[k++] = v[j++];
        
        /*copia o resto do subvetor que não terminou*/
        while (i <= m)
            aux[k++] = v[i++];
        while (j <= r)
            aux[k++] = v[j++];
        /*copia de volta para v*/
        for (i = l, k = 0; i <= r; i++, k++)
            v[i] = aux[k];
    }
}
