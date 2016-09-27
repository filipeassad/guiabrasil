package br.guiabrasil.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.guiabrasil.R;
import br.guiabrasil.interfaces.FragmentInterface;

public class DashFragment extends Fragment {

    private FragmentInterface fragmentInterface;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_dash, container, false);
        fragmentInterface.tiraTitulo();
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

    }

    public void setFragmentInterface(FragmentInterface fragmentInterface) {
        this.fragmentInterface = fragmentInterface;
    }
}
