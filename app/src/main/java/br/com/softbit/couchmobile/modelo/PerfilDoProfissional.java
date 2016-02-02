package br.com.softbit.couchmobile.modelo;

import java.util.List;

/**
 * Created by elton on 09/11/15.
 */
public class PerfilDoProfissional {

    private List<String> especialidades;

    public PerfilDoProfissional(){

    }

    public void adicionarEspecialidade(String especialidade){
        especialidades.add(especialidade);
    }
}
