package br.guiabrasil.adapters;

import android.app.Activity;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import br.guiabrasil.R;

/**
 * Created by 0118431 on 27/09/2016.
 */
public class MenuAdapter extends ArrayAdapter<String>{

    private Context mContext;
    private int mResource;

    public MenuAdapter(Context context, int resource, List<String> objects) {
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

        TextView txtMenu        = (TextView) convertView.findViewById(R.id.txtMenu);
        ImageView imgLateral    = (ImageView) convertView.findViewById(R.id.imgLateral);

        txtMenu.setText(getItem(position));

        if(getItem(position).equals("CUPONS")){
            imgLateral.setImageBitmap(BitmapFactory.decodeResource(mContext.getResources(), R.drawable.cupons));
        }else if(getItem(position).equals("EMPRESAS")){
            imgLateral.setImageBitmap(BitmapFactory.decodeResource(mContext.getResources(), R.drawable.empresa));
        }else if(getItem(position).equals("HOSPITAIS E CLINICAS")){
            imgLateral.setImageBitmap(BitmapFactory.decodeResource(mContext.getResources(), R.drawable.hosp));
        }else if(getItem(position).equals("ÓRGÃOS PUBLICOS")){
            imgLateral.setImageBitmap(BitmapFactory.decodeResource(mContext.getResources(), R.drawable.org));
        }else{
            imgLateral.setImageBitmap(BitmapFactory.decodeResource(mContext.getResources(), R.drawable.cupons));
        }

        return convertView;
    }
}
