package br.com.softbit.couchmobile.modelo;

/**
 * Created by elton on 09/11/15.
 */
public class RotinaSemanal {

    private Treino[] treinosDaSemana;

    public RotinaSemanal(){
        treinosDaSemana = new Treino[7];
    }

    public void adicionarTreino(Treino treino, int posicao){
        treinosDaSemana[posicao] = treino;
    }

    public void removeTreino(int posicao){
        treinosDaSemana[posicao]= null;
    }
}
