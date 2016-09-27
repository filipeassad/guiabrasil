package br.guiabrasil.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import br.guiabrasil.R;
import br.guiabrasil.adapters.MenuAdapter;
import br.guiabrasil.fragment.DashFragment;
import br.guiabrasil.interfaces.FragmentInterface;
import br.guiabrasil.util.Animacoes;
import br.guiabrasil.util.ChangeScreen;


public class TelaInicial extends FragmentActivity implements FragmentInterface {

    private LinearLayout llBranco;
    private LinearLayout llMenu;
    private LinearLayout llFragments;
    private LinearLayout llTitulo;
    private ImageView btnMenu;
    private ImageView btnVoltar;
    private ListView lvMenu;
    private EditText edtBusca;
    private Bundle saved;
    private FragmentManager fm = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        saved = savedInstanceState;

        setContentView(R.layout.activity_tela_inicial);

        llBranco    = (LinearLayout) findViewById(R.id.llBranco);
        llMenu      = (LinearLayout) findViewById(R.id.llMenu);
        btnMenu     = (ImageView) findViewById(R.id.btnMenu);
        btnVoltar   = (ImageView) findViewById(R.id.btnVoltar);
        lvMenu      = (ListView) findViewById(R.id.lvMenu);
        llFragments = (LinearLayout) findViewById(R.id.llFragments);
        llTitulo    = (LinearLayout) findViewById(R.id.llTitulo);
        edtBusca    = (EditText) findViewById(R.id.edtBusca);

        carregaFragment();
        carregaMenu();
        acaoBtn();
    }

    private void acaoBtn(){

        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                llMenu.setVisibility(View.VISIBLE);
                Animacoes.animaEntradaMenu(llMenu,llBranco);
            }
        });

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animacoes.animaSaidaMenu(llMenu,llBranco);
            }
        });

        llBranco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animacoes.animaSaidaMenu(llMenu,llBranco);
            }
        });

    }

    private void carregaMenu(){

        List<String> menuLabels = new ArrayList<>();

        menuLabels.add("CUPONS");
        menuLabels.add("EMPRESAS");
        menuLabels.add("HOSPITAIS E CLINICAS");
        menuLabels.add("ÓRGÃOS PUBLICOS");

        MenuAdapter menuAdapter = new MenuAdapter(this,R.layout.adapter_menu,menuLabels);
        lvMenu.setAdapter(menuAdapter);

        acaoMenu();

    }

    private void acaoMenu(){

        lvMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selecionado = (String) lvMenu.getItemAtPosition(position);
                changeScreen(selecionado);
                Animacoes.animaSaidaMenu(llMenu,llBranco);
            }
        });

    }

    private void carregaFragment(){

        if(saved == null){
            DashFragment dashFragment = new DashFragment();
            FragmentTransaction ft = fm.beginTransaction();
            dashFragment.setFragmentInterface(this);
            ft.add(R.id.llFragments, dashFragment, "Dash");
            ft.commit();
        }

    }

    @Override
    public void changeScreen(String nome) {
        ChangeScreen.change(nome,fm,R.id.llFragments,this);
    }

    @Override
    public void voltar() {
        onBackPressed();
        Animacoes.animaSaidaMenu(llMenu,llBranco);
    }

    @Override
    public void mostraTitulo() {
        edtBusca.setVisibility(View.GONE);
        llTitulo.setVisibility(View.VISIBLE);
    }

    @Override
    public void tiraTitulo() {
        edtBusca.setVisibility(View.VISIBLE);
        llTitulo.setVisibility(View.GONE);
    }
}
