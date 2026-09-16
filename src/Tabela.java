public abstract class Tabela {

    protected String nomes[];

    protected int tabela[][];
    /*
     * 0 - pontos PTS
     * 1 - partidas PJ
     * 2 - vitorias VIT
     * 3 - empates E
     * 4 - derrotas DER
     * 5 - gols marcados GM
     * 6 - gols contra GC
     * 7 - saldo de gols SG
     */

    Tabela(){
        nomes = new String[20];
        tabela = new int[20][8];
    }

    public void adicionaClube(String nomeClube)
    {
        boolean inserido = false;
        for (int i = 0; i < 20; i++) {
            if ( nomes[i] == nomeClube ) {
                System.err.println("Clube já inserido");
                break;
            }
            if ( !inserido && nomes[i] == null ) {
                nomes[i] = nomeClube;
                inserido = true;
            }
        }
        if (!inserido) {
            System.err.println("Clube não inserido. Tabela cheia");
        }
    }

    public void adicionaVitoria(String nomeClube, int golsMarcados, int golsSofridos) {
        for (int i = 0; i < 20; i++) {
            if ( nomes[i] == nomeClube ) {
                tabela[i][0] += 3; // Vitoria é mais 3 pontos
                tabela[i][1]++;    // Mais uma partida realizada
                tabela[i][2]++;    // Mais uma vitoria
                tabela[i][5] += golsMarcados;
                tabela[i][6] += golsSofridos;
                tabela[i][7] += tabela[i][5] - tabela[i][6];
                break;
            }
        }
    }

    public void adicionaEmpate(String nomeClube, int golsMarcados, int golsSofridos) {
        for (int i = 0; i < 20; i++) {
            if (nomes[i] == nomeClube) {
                tabela[i][0] += 1;
                tabela[i][1]++;
                tabela[i][3]++;
                tabela[i][5] += golsMarcados;
                tabela[i][6] += golsSofridos;
                tabela[i][7] += tabela[i][5] - tabela[i][6];
                break;
            }
        }
    }

    public void adicionaDerrota(String nomeClube, int golsMarcados, int golsSofridos) {
        for (int i = 0; i < 20; i++) {
            if (nomes[i] == nomeClube) {
                tabela[i][1]++;
                tabela[i][4]++;
                tabela[i][5] += golsMarcados;
                tabela[i][6] += golsSofridos;
                tabela[i][7] += tabela[i][5] - tabela[i][6];
                break;
            }
        }
    }

    public String primeiroLugar() {

        int maiorPontuacao = tabela[0][0]; 
        int primeiro = 0;

        for (int i = 1; i < 20; i++) {
            if ( tabela[i][0] > maiorPontuacao ) {
                primeiro = i;
                maiorPontuacao = tabela[i][0];
            }
        }

        return nomes[primeiro];
    }

    public void imprimeTabela() {

        System.out.printf("%15s %4s%4s%4s%4s%4s%4s%4s%4s\n","TIME","PTS","PJ","VIT","E","DER","GM","GC","SG");
        for (int i = 0; i < 20; i++) {
            System.out.printf("%15s  ", nomes[i]);
            for (int valor : tabela[i]) {
                System.out.printf("%3d ",valor);
            }
            System.out.println();
        }
    }
}