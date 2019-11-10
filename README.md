# SIN_142
Trabalho de SIN 142

O código CPU bound não precisa de nenhuma modificação para rodar, apenas compilar e executar.
Classes com main: TesteSequencial.java; TesteConcorrente2Threads.java; TesteConcorrente4Threads.java;

O código I/O bound precisa ter um diretório criado para funcionar.
Classes com main: IOBoundSequencial.java; IOBoundConcorrente2Threads.java;

Primeiro crie um diretório com o nome Arquivos e então adicione duas pastas, uma chamada source1 e outra chamada source2.

Crie um .txt dentro do diretório Arquivos/source1/ com qualquer nome (source1.txt). Faça o mesmo para a pasta source2.

Coloque algum arquivo pesado dentro da pasta source1 (usamos a .iso do Linux ubuntu: http://releases.ubuntu.com/18.04.3/ubuntu-18.04.3-desktop-amd64.iso?
_ga=2.253572160.833757403.1573396773-278341719.1573396773 (alteramos o nome para ubuntu-src1.iso))
Coloque algum arquivo pesado dento da pasta source 2 (usamos a mesma .iso, apenas alteramos o nome para ubuntu-src2.iso(IMPORTANTE ALTERAR
O NOME SE O ARQUIVO FOR O MESMO))

Abra os códigos I/O bound e então altere os Files src1, src2 para o diretório que voce criou. Tanto para o código Sequencial quanto para
o Concorrente(2 Threads).
O File dst necessita de um diretório qualquer (é para onde os arquivos serão copiados).
Caso o File dst seja o mesmo para os dois códigos, recomendo apagar o diretório de destino antes do código ser executado para evitar 
arquivos corrompidos.
Feito isso os códigos poderão ser executados.
