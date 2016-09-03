package br.guiabrasil.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import br.guiabrasil.R;

public class MainActivity extends Activity {

    private EditText edtLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        edtLogin = (EditText) findViewById(R.id.edtLogin);
        edtLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), TelaInicial.class);
                startActivity(intent);
            }
        });
    }

}
