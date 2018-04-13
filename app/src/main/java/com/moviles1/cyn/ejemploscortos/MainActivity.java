package com.moviles1.cyn.ejemploscortos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    CheckBox cb1;
    CheckBox cb2;
    EditText txt;
    Button btnPagar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("PRODUCTOS");
        //initEvents();
        alt2();

        btnPagar =  (Button) findViewById(R.id.btnPagar);
        btnPagar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i = new Intent(MainActivity.this, Activity_Pagos.class);
                startActivity(i);
            }
        });
    }
    void initEvents(){
        cb1 = (CheckBox) super.findViewById(R.id.checkBox1);
        cb2 = (CheckBox) super.findViewById(R.id.checkBox2);
        txt = (EditText) super.findViewById(R.id.txt);
        cb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cb2.setChecked(false);
                txt.setText(cb1.getText());
            }
        });
        cb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cb1.setChecked(false);
                txt.setText(cb2.getText());
            }
        });
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
