package br.com.softbit.couchmobile;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

import br.com.softbit.couchmobile.modelo.Treino;

/**
 * Created by elton on 11/11/15.
 */
public class MyExpListAdapter extends BaseExpandableListAdapter implements ExpandableListView.OnChildClickListener{

    private List<Treino> itens;
    private Context context;

    public MyExpListAdapter(Context context, List<Treino> itens) {
        this.context = context;
        this.itens = itens;
    }

    @Override
    public int getGroupCount() {
        return itens.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return itens.get(groupPosition).getListaExercicios().size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return itens.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return itens.get(groupPosition).getListaExercicios().get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

        String nomeDoTreino = itens.get(groupPosition).getNome();

        if (convertView == null){
            LayoutInflater layoutInflater = (LayoutInflater) this.context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.exp_list_view_item_principal, null);
        }

        TextView textView = (TextView) convertView.findViewById(R.id.item_principal);
        textView.setText(nomeDoTreino);

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

        String nomeDoExercicio = itens.get(groupPosition).getListaExercicios().get(childPosition).getNome();
        String numSeries = "Series: " + itens.get(groupPosition).getListaExercicios().get(childPosition).getNumSeries();

        String numRepeticoes = "Repetiçoes: ";
        int[] repeticoes = itens.get(groupPosition).getListaExercicios().get(childPosition).getRepeticoesDasSeries();
        for (int i=0; i< repeticoes.length; i++){
            if (i==0){
                numRepeticoes += "" + repeticoes[i];
            }else{
                numRepeticoes += "/" + repeticoes[i];
            }
        }

        String intervalo = "Intervalo: " + itens.get(groupPosition).getListaExercicios().get(childPosition).getIntervaloEntreSeries();
        String comentario = "Comentário: \n" + itens.get(groupPosition).getListaExercicios().get(childPosition).getNome();

        if (convertView == null){
            LayoutInflater layoutInflater = (LayoutInflater) this.context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.exp_list_view_item_filho, null);
        }

        TextView textViewNomeDoExercicio = (TextView) convertView.findViewById(R.id.item_filho);
        textViewNomeDoExercicio.setText(nomeDoExercicio);

        TextView textViewNumSeries = (TextView) convertView.findViewById(R.id.item_filho_detalhe_num_series);
        textViewNumSeries.setText(numSeries);

        TextView textViewRepeticoes = (TextView) convertView.findViewById(R.id.item_filho_detalhe_num_repeticoes);
        textViewRepeticoes.setText(numRepeticoes);

        TextView textViewIntervalo = (TextView) convertView.findViewById(R.id.item_filho_detalhe_intervalo);
        textViewIntervalo.setText(intervalo);

        TextView textViewComentario = (TextView) convertView.findViewById(R.id.item_filho_detalhe_comentario);
        textViewComentario.setText(comentario);

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    @Override
    public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {

        if (v == null){
            LayoutInflater layoutInflater = (LayoutInflater) this.context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            v = layoutInflater.inflate(R.layout.exp_list_view_item_filho, null);
        }

        RelativeLayout detalhes = (RelativeLayout) v.findViewById(R.id.item_filho_detalhe);
        RelativeLayout.LayoutParams mostrarDetalhes = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
        RelativeLayout.LayoutParams esconderDetalhes = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,0);

        if (detalhes.getHeight()==0){
            detalhes.setLayoutParams(mostrarDetalhes);
        }else{
            detalhes.setLayoutParams(esconderDetalhes);
        }

        return true;
    }
}