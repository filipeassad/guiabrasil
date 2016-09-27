package br.guiabrasil.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import br.guiabrasil.R;
import br.guiabrasil.adapters.CupomAdapter;
import br.guiabrasil.interfaces.FragmentInterface;
import br.guiabrasil.model.Cupom;

/**
 * Created by 0118431 on 27/09/2016.
 */
public class CupomFragment extends Fragment {

    private FragmentInterface fragmentInterface;
    private ImageView imgVoltar;
    private ListView llCupons;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_cupom, container, false);

        llCupons = (ListView) view.findViewById(R.id.llCupons);
        imgVoltar = (ImageView) view.findViewById(R.id.imgVoltar);

        fragmentInterface.mostraTitulo();
        carregaCopuns();
        acaoBotoes();
        return view;
    }

    public void setFragmentInterface(FragmentInterface fragmentInterface) {
        this.fragmentInterface = fragmentInterface;
    }

    private void carregaCopuns(){

        List<Cupom> listaC = new ArrayList<>();
        listaC.add(new Cupom(1,"Tênis","Promoção de Tênis Tabajara!","30%"));
        listaC.add(new Cupom(2,"Boné","Boné da moda! Super promoção","10%"));
        listaC.add(new Cupom(3,"Camiseta","Qualquer camisa com qualquer estampa!","40%"));
        listaC.add(new Cupom(4,"Dildo","Com prazer!","100%"));
        listaC.add(new Cupom(5,"Ingresso","Assista qualquer filme em cartais!","15%"));
        listaC.add(new Cupom(6,"Jantar","Jantar romantico para duas pessoas!","25%"));

        CupomAdapter cupomAdapter = new CupomAdapter(getContext(),R.layout.adapter_cupom, listaC);

        llCupons.setAdapter(cupomAdapter);

    }

    private void acaoBotoes(){

        imgVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentInterface.voltar();
            }
        });

    }

}
