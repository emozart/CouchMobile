package br.com.softbit.couchmobile.modelo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by elton on 09/11/15.
 */
public class Treino {

    private String nome;
    private List<Exercicio> listaExercicios;
    private int intervaloEntreExercicios;

    public Treino(String nome){
        this.nome = nome;
        listaExercicios = new ArrayList<Exercicio>();
        intervaloEntreExercicios = 2;
    }

    public void adicionarExercicio(Exercicio exercicio){
        listaExercicios.add(exercicio);
    }

    public void removeEcercicio(int position){
        listaExercicios.remove(position);
    }

    public void removeEcercicio(Exercicio exercicio){
        listaExercicios.remove(exercicio);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Exercicio> getListaExercicios(){ return this.listaExercicios; }

    public void setListaExercicios (List<Exercicio> listaExercicios){
        this.listaExercicios = listaExercicios;
    }

    public int getIntervaloEntreExercicios() {
        return intervaloEntreExercicios;
    }

    public void setIntervaloEntreExercicios (int intervaloEntreExercicios) {
        this.intervaloEntreExercicios = intervaloEntreExercicios;
    }
}
