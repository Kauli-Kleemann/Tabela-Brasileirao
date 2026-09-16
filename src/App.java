/*
 * Considere as classes deste projeto e:
 * 1) crie uma classe TabelaBrasileirao, filha de Tabela, e sobreponha o método
 *    primeiroLugar para que considere como segundo critério de desempate o 
 *    saldo de gols;
 * 2) sobrecarregue o método adicionaVitoria na nova classe TabelaBrasileirao
 *    para que se possa indicar a posição (linha) na tabela para o clube que se
 *    deseja adicionar a vitória, ao invés de indicar o nome.
 * 3) sobreponha o método toString, herdado da classe Object, de maneira que 
 *    seja impressa a tabela quando imprimimos uma tabela passando apenas a 
 *    referêcia da instância. 
 *    Por exemplo:
 *      Tabela tabela = new Tabela();
 *      System.out.println(tabela);
 * 4) demonstre os métodos da classe TabelaBrasileirao no App.
 * 5) (OPCIONAL) Implemente os outros métodos, como aqueles para empates, 
 *    derrotas, e algum outro que desejar.
 */
public class App {
    
    public static void main(String[] args) {
        
        TabelaBrasileirao tabela = new TabelaBrasileirao();

        tabela.adicionaClube("Novo Hamburgo");
        tabela.adicionaClube("15 de Novembro");
        tabela.adicionaClube("Internacional");
        tabela.adicionaClube("Grêmio");
        tabela.adicionaVitoria(3, 5, 2);

        tabela.adicionaDerrota("Internacional", 0, 3);
        tabela.adicionaEmpate("15 de Novembro", 1, 1);
        tabela.adicionaVitoria("Grêmio", 7, 2);

        tabela.adicionaVitoria("Novo Hamburgo", 3, 2);
        tabela.adicionaVitoria("15 de Novembro", 2,0);
        tabela.imprimeTabela();

        System.out.println("Primeiro na tabela: " + tabela.primeiroLugar());

        System.out.println(tabela);
    }
}


