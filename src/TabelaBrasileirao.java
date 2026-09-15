public class TabelaBrasileirao extends Tabela {
    
   // @Override 
    public String primeiroLugar() {

        int maiorPontuacao = tabela[0][0];
        int primeiro = 0;
        int maiorSaldo = tabela[0][7];

        for (int i = 1; i < 20; i++) {
            if (tabela[i][0] > maiorPontuacao) {
                primeiro = i;
                maiorPontuacao = tabela[i][0];
                maiorSaldo = tabela[i][7];
            } else if (tabela[i][0] == maiorPontuacao) {
                if (tabela[i][7] > maiorSaldo) {
                    maiorSaldo = tabela[i][7];
                    primeiro = i;
                }
            }
        }

        return nomes[primeiro];
    }

    public void adicionaVitoria(int posicao, int golsMarcados, int golsSofridos) {
        tabela[posicao][0] += 3; // Mais 3 pontos
        tabela[posicao][1] ++; // Mais uma partida realizada
        tabela[posicao][2] ++; // Mais uma vitoria
        tabela[posicao][5] += golsMarcados;
        tabela[posicao][6] += golsSofridos;
        tabela[posicao][7] += tabela[posicao][5] - tabela[posicao][6]; 
    }

    public String toString() {
        String resultado = String.format("%15s %4s%4s%4s%4s%4s%4s%4s%4s\n","TIME","PTS","PJ","VIT","E","DER","GM","GC","SG");

        for (int i = 0; i < 20; i++) {
            String dados = String.format("%15s %4s%4s%4s%4s%4s%4s%4s%4s\n", nomes[i], tabela[i][0], tabela[i][1], tabela[i][2], tabela[i][3], tabela[i][4], tabela[i][5], tabela[i][6], tabela[i][7]);
            resultado += dados;
        }
        return resultado;
    }
}
