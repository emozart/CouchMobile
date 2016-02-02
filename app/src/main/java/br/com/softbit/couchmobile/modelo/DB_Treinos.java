package br.com.softbit.couchmobile.modelo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by elton on 09/11/15.
 */
public class DB_Treinos {
    public Treino treinoA;
    public Treino treinoB;
    public Treino treinoC;

    public DB_Treinos(){

        List<Serie> seriePadrao = new ArrayList<Serie>();
        seriePadrao.add(new Serie(20, false));
        seriePadrao.add(new Serie(20, false));
        seriePadrao.add(new Serie(20, false));

        List<Serie> serieCombinada = new ArrayList<Serie>();
        serieCombinada.add(new Serie(15, false));
        serieCombinada.add(new Serie(15, false));
        serieCombinada.add(new Serie(15, false));
        serieCombinada.add(new Serie(15, false));
        serieCombinada.add(new Serie(15, false));
        serieCombinada.add(new Serie(15, false));

        List<Serie> serieAerobia = new ArrayList<Serie>();
        serieAerobia.add(new Serie(3, true));
        serieAerobia.add(new Serie(1, true));
        serieAerobia.add(new Serie(3, true));
        serieAerobia.add(new Serie(1, true));
        serieAerobia.add(new Serie(3, true));
        serieAerobia.add(new Serie(1, true));
        serieAerobia.add(new Serie(3, true));
        serieAerobia.add(new Serie(1, true));
        serieAerobia.add(new Serie(3, true));
        serieAerobia.add(new Serie(1, true));

        Exercicio exercicio1 = new Exercicio("Fly inclinado com alteres", seriePadrao, 30);
        Exercicio exercicio2 = new Exercicio("Supino reto na barra", seriePadrao, 30);
        Exercicio exercicio3 = new Exercicio("Crucifixo reto na máquina", seriePadrao, 30);
        Exercicio exercicio4 = new Exercicio("Tríceps pulley invertido unilateral", seriePadrao, 30);
        Exercicio exercicio5 = new Exercicio("Tríceps Corda UNILATERAL:", seriePadrao, 30);
        Exercicio exercicio6 = new Exercicio("Tríceps Francês com Halter SIMULTÂNEO:", seriePadrao, 30);
        Exercicio exercicio7 = new Exercicio("Abdominal Reto no Solo / Deitado:", seriePadrao, 30);
        Exercicio exercicio8 = new Exercicio("Abdominal reto na prancha / declinado:", seriePadrao, 30);
        Exercicio exercicio9 = new Exercicio("Aeróbio: Corrida intervalada", serieAerobia, 0);
        exercicio9.setComentarios("Exercício Aeróbio sem intervalo anternando entre corrida moderada (3min) e corrida rápida (1min).");
        Exercicio exercicio10 = null;
        Exercicio exercicio11 = null;

        treinoA = new Treino("Treino A");
        treinoA.adicionarExercicio(exercicio1);
        treinoA.adicionarExercicio(exercicio2);
        treinoA.adicionarExercicio(exercicio3);
        treinoA.adicionarExercicio(exercicio4);
        treinoA.adicionarExercicio(exercicio5);
        treinoA.adicionarExercicio(exercicio6);
        treinoA.adicionarExercicio(exercicio7);
        treinoA.adicionarExercicio(exercicio8);
        treinoA.adicionarExercicio(exercicio9);

        exercicio1 = new Exercicio("Puxador na frente com barra aberta / Hammer", seriePadrao, 30);
        exercicio2 = new Exercicio("Puxador frente com triângulo", seriePadrao, 30);
        exercicio3 = new Exercicio("Remada na máquina unilateral", seriePadrao, 30);
        exercicio4 = new Exercicio("Remada baixa com triângulo", seriePadrao, 30);
        exercicio5 = new Exercicio("Hiper-Extensão de Lombar", seriePadrao, 30);
        exercicio5.setComentarios("Para fortalecimento: sem carga ou com pouca carga");
        exercicio6 = new Exercicio("Rosca direta livre na barra", seriePadrao, 30);
        exercicio7 = new Exercicio("Rosca alternada com halteres", seriePadrao, 30);
        exercicio8 = new Exercicio("Rosca scoth no banco", seriePadrao, 30);
        exercicio9 = new Exercicio("Rosca martelo unilateral", seriePadrao, 30);
        exercicio10 = new Exercicio("Abdominal infra - vela", seriePadrao, 30);
        exercicio11 = new Exercicio("Aeróbio: Corrida intervalada", serieAerobia, 0);
        exercicio11.setComentarios("Exercício Aeróbio sem intervalo anternando entre corrida moderada (3min) e corrida rápida (1min).");

        treinoB = new Treino("Treino B");
        treinoB.adicionarExercicio(exercicio1);
        treinoB.adicionarExercicio(exercicio2);
        treinoB.adicionarExercicio(exercicio3);
        treinoB.adicionarExercicio(exercicio4);
        treinoB.adicionarExercicio(exercicio5);
        treinoB.adicionarExercicio(exercicio6);
        treinoB.adicionarExercicio(exercicio7);
        treinoB.adicionarExercicio(exercicio8);
        treinoB.adicionarExercicio(exercicio9);
        treinoB.adicionarExercicio(exercicio10);
        treinoB.adicionarExercicio(exercicio11);

        exercicio1 = new Exercicio("Cadeira extensora", seriePadrao, 30);
        exercicio2 = new Exercicio("Leg press 45 graus", seriePadrao, 30);
        exercicio3 = new Exercicio("Remada na máquina unilateral", seriePadrao, 30);
        exercicio4 = new Exercicio("Cadeira flexora", seriePadrao, 30);
        exercicio5 = new Exercicio("Cadeira Adutora", seriePadrao, 30);
        exercicio6 = new Exercicio("cadeira abdutora", seriePadrao, 30);
        exercicio7 = new Exercicio("Gêmeos em pé no smith", seriePadrao, 30);
        exercicio8 = new Exercicio("Desenvolvimento com halteres", seriePadrao, 30);
        exercicio9 = new Exercicio("Elevação frontal alternada", seriePadrao, 30);
        exercicio10 = new Exercicio("Encolhimento com halteres", seriePadrao, 30);
        exercicio11 = new Exercicio("Abdominal cruzado no solo", serieAerobia, 0);

        treinoC = new Treino("Treino C");
        treinoC.adicionarExercicio(exercicio1);
        treinoC.adicionarExercicio(exercicio2);
        treinoC.adicionarExercicio(exercicio3);
        treinoC.adicionarExercicio(exercicio4);
        treinoC.adicionarExercicio(exercicio5);
        treinoC.adicionarExercicio(exercicio6);
        treinoC.adicionarExercicio(exercicio7);
        treinoC.adicionarExercicio(exercicio8);
        treinoC.adicionarExercicio(exercicio9);
        treinoC.adicionarExercicio(exercicio10);
        treinoC.adicionarExercicio(exercicio11);

    }

    public List<Treino> getListaDeTreinos(){
        List<Treino> lt = new ArrayList<Treino>();
        lt.add(treinoA);
        lt.add(treinoB);
        lt.add(treinoC);

        return lt;
    }
}
