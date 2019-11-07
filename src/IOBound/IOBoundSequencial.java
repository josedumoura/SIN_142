
package IOBound;

import java.io.*;

public class IOBoundSequencial {

    public static void main(String[] args) throws IOException {

        IOBoundSequencial cd = new IOBoundSequencial();
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        
        File src1 = new File("C:\\Users\\henri\\OneDrive\\Área de Trabalho\\Curso\\Ano 2\\Programação Concorrente e Distribuída\\IO Bound\\Sequencial\\source1"); //Digitar o primeiro diretório que deseja copiar
        File src2 = new File("C:\\Users\\henri\\OneDrive\\Área de Trabalho\\Curso\\Ano 2\\Programação Concorrente e Distribuída\\IO Bound\\Sequencial\\source2"); //Digitar o segundo diretório que deseja copiar
        File dst = new File("C:\\Users\\henri\\OneDrive\\Área de Trabalho\\Curso\\Ano 2\\Programação Concorrente e Distribuída\\IO Bound\\Sequencial\\destino"); //Digitar o destino da cópia do diretório

        cd.copyDirectory(src1, dst);
        cd.copyDirectory(src2, dst);
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
}

