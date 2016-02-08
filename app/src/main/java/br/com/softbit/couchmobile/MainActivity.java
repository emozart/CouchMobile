package br.com.softbit.couchmobile;

import android.app.FragmentTransaction;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.softbit.couchmobile.modelo.Flower;
import br.com.softbit.couchmobile.parsers.ProfissionalJSONParser;

public class MainActivity extends AppCompatActivity
        implements LoadFragment.OnFragmentInteractionListener, PerfilPessoalFragment.OnFragmentInteractionListener,
        AlimentacaoFragment.OnFragmentInteractionListener, BuscarProfissionalFragment.OnFragmentInteractionListener,
        PlayerTreinoFragment.OnFragmentInteractionListener, SobreFragment.OnFragmentInteractionListener,
        TreinosFragment.OnFragmentInteractionListener, NavigationView.OnNavigationItemSelectedListener {

    private String fragmentMessage;
    private TextView messageLog;
    private ProgressBar loading;
    private List<Flower> flowerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        LoadFragment fragment = LoadFragment.newInstance(null,null);
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.fragment_conteiner, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

        if (isOnLine()){
            //requestData("http://services.hanselandpetal.com/feeds/flowers.json");
            requestData("http://services.hanselandpetal.com/secure/flowers.json");
        }else{
            Toast.makeText(this, "Internet não disponível para sincronização de dados", Toast.LENGTH_LONG).show();
        }
    }

    private void requestData(String uri) {
        MyTask task = new MyTask();
        task.execute(uri);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            drawer.openDrawer(GravityCompat.START);
            //super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.nav_perfil) {
            PerfilPessoalFragment fragment =  PerfilPessoalFragment.newInstance(null,null);
            FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_conteiner, fragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        } else if (id == R.id.nav_treinos) {
            TreinosFragment fragment = TreinosFragment.newInstance(null,null);
            FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_conteiner, fragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        } else if (id == R.id.nav_alimentacao) {
            AlimentacaoFragment fragment = AlimentacaoFragment.newInstance(null,null);
            FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_conteiner, fragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        } else if (id == R.id.nav_buscar_profissional) {
            BuscarProfissionalFragment fragment = BuscarProfissionalFragment.newInstance(fragmentMessage,null);
            FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_conteiner, fragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        } else if (id == R.id.nav_player_de_treino) {
            PlayerTreinoFragment fragment = PlayerTreinoFragment.newInstance(null,null);
            FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_conteiner, fragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        } else if (id == R.id.nav_sobre) {
            SobreFragment fragment = SobreFragment.newInstance(null,null);
            FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_conteiner, fragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        } else if (id == R.id.nav_sair) {
            finish();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    protected boolean isOnLine(){
        ConnectivityManager conectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = conectivityManager.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnectedOrConnecting()){
            return true;
        }else{
            return false;
        }
    }

    private class MyTask extends AsyncTask<String, String, String> {

        @Override
        protected void onPreExecute() {
            Log.i("update", "Executado antes da tarefa.");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        @Override
        protected String doInBackground(String... params) {
            Log.i("update", "Executando a tarefa.");
            String content = HttpManager.getData(params[0], "feeduser", "feedpassword");
            return content;
        }

        @Override
        protected void onPostExecute(String result) {

            //flowerList = new ArrayList<Flower>();
            flowerList = ProfissionalJSONParser.parseFeed(result);

            for(int i = 0; i < flowerList.size(); i++) {
                Log.i("update", flowerList.get(i).getName());
            }
            Log.i("update", "Tarefa finalizada.");

            PlayerTreinoFragment fragment = PlayerTreinoFragment.newInstance(null,null);
            FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_conteiner, fragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }

        @Override
        protected void onProgressUpdate(String... values) {
            Log.i("update", values[0]);
        }
    }
}
