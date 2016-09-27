package br.guiabrasil.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import br.guiabrasil.R;
import br.guiabrasil.model.Cupom;

/**
 * Created by 0118431 on 27/09/2016.
 */
public class CupomAdapter extends ArrayAdapter<Cupom>{

    private Context mContext;
    private int mResource;

    public CupomAdapter(Context context, int resource, List<Cupom> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView==null){
            LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
            convertView = inflater.inflate(mResource, parent, false);
        }

        TextView txtPorcentagem = (TextView) convertView.findViewById(R.id.txtPorcentagem);
        TextView txtTitulo      = (TextView) convertView.findViewById(R.id.txtTitulo);
        TextView txtDescricao   = (TextView) convertView.findViewById(R.id.txtDescricao);
        LinearLayout llQuero    = (LinearLayout) convertView.findViewById(R.id.llQuero);

        txtPorcentagem.setText(getItem(position).getPorcentagem());
        txtTitulo.setText(getItem(position).getTitulo());
        txtDescricao.setText(getItem(position).getDescricao());

        llQuero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return convertView;
    }
}
