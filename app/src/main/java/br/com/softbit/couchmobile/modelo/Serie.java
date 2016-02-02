package br.com.softbit.couchmobile.modelo;

/**
 * Created by elton on 09/11/15.
 */
public class Serie {

    private int numRepeticoesMinutos;
    private boolean e_PorTempo;

    public Serie(int numRepeticoesminutos, boolean e_PorTempo){
        setNumRepeticoes(numRepeticoesMinutos);
        setE_PorTempo(e_PorTempo);
    }

    public int getNumRepeticoesMinutos() {
        return numRepeticoesMinutos;
    }

    public void setNumRepeticoes(int numRepeticoesMinutos) {
        this.numRepeticoesMinutos = numRepeticoesMinutos;
    }

    public boolean getE_PorTempo() {
        return e_PorTempo;
    }

    public void setE_PorTempo(boolean e_porTempo) {
        this.e_PorTempo = e_porTempo;
    }
}
