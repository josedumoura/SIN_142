
package IOBound;

import java.io.*;

public class IOBoundConcorrente2Threads extends Thread{
    //alterar os FILEs para copiar os diretórios
    File src1 = new File("C:\\Users\\henri\\OneDrive\\Área de Trabalho\\Curso\\Ano 2\\Programação Concorrente e Distribuída\\IO Bound\\Concorrente\\source1"); //Digitar o primeiro diretório que deseja copiar
    File src2 = new File("C:\\Users\\henri\\OneDrive\\Área de Trabalho\\Curso\\Ano 2\\Programação Concorrente e Distribuída\\IO Bound\\Concorrente\\source2"); //Digitar o segundo diretório que deseja copiar
    File dst = new File("C:\\Users\\henri\\OneDrive\\Área de Trabalho\\Curso\\Ano 2\\Programação Concorrente e Distribuída\\IO Bound\\Concorrente\\destino"); //Digitar o destino da cópia do diretório
        
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
        
        t1.start();
        t2.start();
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
            
            if (!srcPath.exists()) { //se o diretorio fonte nao existir, imprime um erro
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
        
        System.out.println("Diretorio copiado com sucesso.");
        
    }
    
    @Override
    public String toString(){
        return this.nome;
    } 
}
