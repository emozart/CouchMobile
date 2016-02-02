package br.com.softbit.couchmobile.modelo;

/**
 * Created by elton on 09/11/15.
 */
public class PerfilDoUsuario extends Perfil {

    private float peso;
    private float altura;
    private String objetivo;

    public PerfilDoUsuario(){

    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }
}
