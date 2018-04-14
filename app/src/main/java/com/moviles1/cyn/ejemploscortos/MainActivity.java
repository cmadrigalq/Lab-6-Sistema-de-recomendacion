package com.moviles1.cyn.ejemploscortos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button btnPagar;
    RecyclerView recyclerView;
    ProductAdapter adapter;
    List<Producto> productoList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Catálogo de Productos");

        productoList = new ArrayList<>();
        initProductoList();

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ProductAdapter(this, productoList);
        recyclerView.setAdapter(adapter);


        btnPagar =  (Button) findViewById(R.id.btnPagar);
        btnPagar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i = new Intent(MainActivity.this, Activity_Pagos.class);
                startActivity(i);
            }
        });
    }

    public void initProductoList(){
        productoList.add(
                new Producto(
                        1,
                        "Apple MacBook Air Core i5 5th Gen - (8 GB/128 GB SSD/Mac OS Sierra)",
                        "13.3 inch, Silver, 1.35 kg",
                        4.3,
                        900000,
                        R.drawable.macbook));

        productoList.add(
                new Producto(
                        2,
                        "Dell Inspiron 7000 Core i5 7th Gen - (8 GB/1 TB HDD/Windows 10 Home)",
                        "14 inch, Gray, 1.659 kg",
                        4.3,
                        500000,
                        R.drawable.dellinspiron));

        productoList.add(
                new Producto(
                        3,
                        "Microsoft Surface Pro 4 Core m3 6th Gen - (4 GB/128 GB SSD/Windows 10)",
                        "13.3 inch, Silver, 1.35 kg",
                        4.5,
                        450000,
                        R.drawable.surface));

        productoList.add(
                new Producto(
                        4,
                        "AMD E-Series 1.65 GHz, 2 GB RAM, 500 GB disco duro, Windows 7 Starter, HDMI",
                        "14.3 inch, Black, 1.15 kg",
                        2.3,
                        250000,
                        R.drawable.hp));

        productoList.add(
                new Producto(
                        5,
                        "INTEL Dual Core 2 GHz, 4 GB RAM, 640 GB disco duro, Windows 7 Home Premium, HDMI",
                        "14.0 inch, Black, 1.65 kg",
                        4.0,
                        350000,
                        R.drawable.toshiba));

        productoList.add(
                new Producto(
                        6,
                        "INTEL Dual Core 2.13 GHz, 4 GB RAM, 500 GB disco duro, Windows 7 Starter",
                        "14.0 inch, Black, 1.25 kg",
                        3.2,
                        320000,
                        R.drawable.samsung));

        productoList.add(
                new Producto(
                        7,
                        "AMD E-Series 1.65 GHz, 2 GB RAM, 500 GB disco duro, Windows 7 Starter, HDMI",
                        "14.0 inch, Black, 1.15 kg",
                        2.1,
                        250000,
                        R.drawable.gateway));
    }

}
