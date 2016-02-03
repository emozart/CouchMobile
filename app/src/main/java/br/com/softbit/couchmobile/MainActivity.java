package br.com.softbit.couchmobile;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity
        implements PerfilPessoalFragment.OnFragmentInteractionListener,TreinosFragment.OnFragmentInteractionListener,
        AlimentacaoFragment.OnFragmentInteractionListener, BuscarProfissionalFragment.OnFragmentInteractionListener,
        PlayerTreinoFragment.OnFragmentInteractionListener, SobreFragment.OnFragmentInteractionListener,
        NavigationView.OnNavigationItemSelectedListener {

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

        PlayerTreinoFragment fragment = PlayerTreinoFragment.newInstance(null,null);
        android.app.FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_conteiner, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
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
            PerfilPessoalFragment fragment =  PerfilPessoalFragment.newInstance(null,null); //new PerfilPessoalFragment();
            android.app.FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_conteiner, fragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        } else if (id == R.id.nav_treinos) {
            TreinosFragment fragment = TreinosFragment.newInstance(null,null); //new TreinosFragment();
            android.app.FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_conteiner, fragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        } else if (id == R.id.nav_alimentacao) {
            AlimentacaoFragment fragment = AlimentacaoFragment.newInstance(null,null); //new AlimentacaoFragment();
            android.app.FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_conteiner, fragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        } else if (id == R.id.nav_buscar_profissional) {
            BuscarProfissionalFragment fragment = BuscarProfissionalFragment.newInstance(null,null); //new BuscarProfissionalFragment();
            android.app.FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_conteiner, fragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        } else if (id == R.id.nav_player_de_treino) {
            PlayerTreinoFragment fragment = PlayerTreinoFragment.newInstance(null,null); //new PlayerTreinoFragment();
            android.app.FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_conteiner, fragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        } else if (id == R.id.nav_sobre) {
            SobreFragment fragment = SobreFragment.newInstance(null,null); //new SobreFragment();
            android.app.FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
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
}
