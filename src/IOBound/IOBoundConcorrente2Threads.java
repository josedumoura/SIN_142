
package IOBound;

import java.io.*;

public class IOBoundConcorrente2Threads extends Thread{
    
    //alterar os FILEs para copiar os diretórios antes de executar
    
    public static File src1 = new File("ALTERE AQUI"); //Digitar o primeiro diretório que deseja copiar
    public static File src2 = new File("ALTERE AQUI"); //Digitar o segundo diretório que deseja copiar
    public static File dst = new File("ALTERE AQUI"); //Digitar o destino da cópia do diretório
        
    public void preencheFiles(String sorc1, String sorc2, String dest){
        src1 = new File(sorc1);
        src2 = new File(sorc2);
        dst = new File(dest);
    }
    
    private String nome;
    
    public IOBoundConcorrente2Threads(String nome){
        this.nome = nome;
    }
    
    public IOBoundConcorrente2Threads(){}
    
    public static void main(String[] args) throws IOException {

        
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

         
        Thread t1 = new IOBoundConcorrente2Threads("1"){
            @Override
            public void run() {
                IOBoundConcorrente2Threads cd = new IOBoundConcorrente2Threads();

                System.out.println("\nThread " +this.toString()+" iniciada.");

                try {
                    cd.copyDirectory(src1, dst);
                } catch (IOException ex) {

                }
                
                System.out.println("\nThread " +this.toString()+" finalizada.");

            }
        };
        Thread t2 = new IOBoundConcorrente2Threads("2"){
            @Override
            public void run() {
                IOBoundConcorrente2Threads cd = new IOBoundConcorrente2Threads();

                System.out.println("\nThread " +this.toString()+" iniciada.");

                try {
                    cd.copyDirectory(src2, dst);
                } catch (IOException ex) {

                }
                
                System.out.println("\nThread " +this.toString()+" finalizada.");
                
            }
        };
        
        long startTime1 = System.currentTimeMillis();
        
        t1.start();
        t2.start();
        
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException ie) {}
        
        long endTime1 = System.currentTimeMillis();
        
        System.out.printf("\nArquivos copiados em %6d ms \n", endTime1 - startTime1);
    }

    public void copyDirectory(File srcPath, File dstPath) throws IOException {

        if (srcPath.isDirectory()) { //verifica se o diretório fonte existe
            if (!dstPath.exists()) { //se o diretorio de destino não existir, ele cria
                dstPath.mkdir();
            }

            String files[] = srcPath.list();

            for (int i = 0; i < files.length; i++) {
                copyDirectory(new File(srcPath, files[i]),new File(dstPath, files[i]));
            }

        } else {
            
            if (!srcPath.exists()) { //se o diretorio fonte nao existir, imprime um erro e fecha o programa
                System.out.println("Diretório inexistente.");
                System.exit(0);
                
            } else {
                
                InputStream in = new FileInputStream(srcPath);
                OutputStream out = new FileOutputStream(dstPath);
                // Transfere os bytes
                byte[] buf = new byte[1024];

                int len;

                while ((len = in.read(buf)) > 0) {
                    out.write(buf, 0, len);
                }
                
                in.close();
                out.close();
                
            }
        }
        
        System.out.println("Bytes copiados com sucesso.");
        
    }
    
    @Override
    public String toString(){
        return this.nome;
    } 
}
