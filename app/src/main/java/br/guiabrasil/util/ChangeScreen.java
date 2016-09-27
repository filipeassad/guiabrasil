package br.guiabrasil.util;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import br.guiabrasil.fragment.CupomFragment;
import br.guiabrasil.fragment.DashFragment;
import br.guiabrasil.interfaces.FragmentInterface;

/**
 * Created by 0118431 on 27/09/2016.
 */
public class ChangeScreen {

    public static void change(String nome, FragmentManager fm, int resource, FragmentInterface fragInter){

        if(nome.equals("DASH")){
            DashFragment fragmentInicial = new DashFragment();
            fragmentInicial.setFragmentInterface(fragInter);
            preparaFragment(fragmentInicial, "Dash", fm, resource);
        }else if(nome.equals("CUPONS")){
            CupomFragment cupomFragment = new CupomFragment();
            cupomFragment.setFragmentInterface(fragInter);
            preparaFragment(cupomFragment, "Cupom", fm, resource);
        }

    }

    public static void preparaFragment(Fragment fragment, String name, FragmentManager fm, int resource){

        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(resource, fragment, name);
        if(fm.findFragmentByTag(name) != null){
            fm.popBackStack(name, 1);
        }
        ft.addToBackStack(name);
        ft.commit();
    }
}
