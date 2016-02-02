package br.com.softbit.couchmobile.modelo;

import android.net.Uri;

import java.util.List;

/**
 * Created by elton on 09/11/15.
 */
public class Exercicio {

    private String nome;
    private List<Serie> series;
    private int intervaloEntreSeries;
    private int carga;
    private Uri linkVideo;
    private String comentarios;

    public Exercicio(){

    }
    public Exercicio(String nome, List<Serie> series, int intervaloEntreSeries){
        setNome(nome);
        this.series = series;
        setIntervaloEntreSeries(30);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumSeries() {
        return series.size();
    }

    public int[] getRepeticoesDasSeries(){
        int[] repeticoes = new int[series.size()];
        for (int i=0; i < repeticoes.length; i++){
            repeticoes[i] = series.get(i).getNumRepeticoesMinutos();
        }
        return repeticoes;
    }

    public void addSeries(Serie serie) {
        this.series.add(serie);
    }
    public void removeSerie(int position){
        this.series.remove(position);
    }

    public int getIntervaloEntreSeries() {
        return intervaloEntreSeries;
    }

    public void setIntervaloEntreSeries(int intervaloEntreSeries) {
        this.intervaloEntreSeries = intervaloEntreSeries;
    }

    public int getCarga() {
        return carga;
    }

    public void setCarga(int carga) {
        this.carga = carga;
    }

    public Uri getLinkVideo() {
        return linkVideo;
    }

    public void setLinkVideo(Uri linkVideo) {
        this.linkVideo = linkVideo;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }
}
