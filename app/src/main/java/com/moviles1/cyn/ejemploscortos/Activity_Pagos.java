package com.moviles1.cyn.ejemploscortos;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Spinner;

import java.util.Calendar;
import java.util.Locale;

public class Activity_Pagos extends AppCompatActivity {
    RadioButton rb1;
    RadioButton rb2;
    Spinner spn;

    Calendar mCalendar = Calendar.getInstance();
    String mesActual = mCalendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__pagos);
        setTitle("PANTALLA DE PAGO");
    }
    void alt2(){
        rb1 = (RadioButton) super.findViewById(R.id.radioCredit);
        rb2 = (RadioButton) super.findViewById(R.id.radioPaypal);
        View.OnClickListener evento = new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                CheckBox ck = (CheckBox)v;
                if(ck.getId() == rb1.getId()){
                    rb2.setChecked(false);
                }else{
                    rb1.setChecked(false);
                }
            }
        };
        rb1.setOnClickListener(evento);
        rb2.setOnClickListener(evento);
    }

}
