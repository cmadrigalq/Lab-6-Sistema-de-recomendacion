package com.moviles1.cyn.ejemploscortos;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

public class Activity_Pagos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__pagos);
        setTitle("Cobro");
    }
    void alt2(){
        cb1 = (CheckBox) super.findViewById(R.id.checkBox1);
        cb2 = (CheckBox) super.findViewById(R.id.checkBox2);
        txt = (EditText) super.findViewById(R.id.txt);
        View.OnClickListener evento = new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                CheckBox ck = (CheckBox)v;
                if(ck.getId() == cb1.getId()){
                    cb2.setChecked(false);
                }else{
                    cb1.setChecked(false);
                }
                txt.setText(ck.getText());
            }
        };
        cb1.setOnClickListener(evento);
        cb2.setOnClickListener(evento);
    }
}
