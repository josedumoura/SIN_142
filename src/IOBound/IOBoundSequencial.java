
package IOBound;

import java.io.*;

public class IOBoundSequencial {

    public static void main(String[] args) throws IOException {

        IOBoundSequencial cd = new IOBoundSequencial();
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        
        //alterar os FILEs para copiar os diretórios antes de executar
        
        File src1 = new File("ALTERE AQUI"); //Digitar o primeiro diretório que deseja copiar
        File src2 = new File("ALTERE AQUI"); //Digitar o segundo diretório que deseja copiar
        File dst = new File("ALTERE AQUI"); //Digitar o destino da cópia do diretório
        
        long startTime1 = System.currentTimeMillis();
        
        cd.copyDirectory(src1, dst);
        cd.copyDirectory(src2, dst);
        
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
        
        System.out.println("Bytes copiados com sucesso.");
        
    }
}

