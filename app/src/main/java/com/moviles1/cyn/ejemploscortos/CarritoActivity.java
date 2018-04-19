package com.moviles1.cyn.ejemploscortos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class CarritoActivity extends AppCompatActivity {
    Button btnPagar;
    RecyclerView recyclerView;
    CarritoAdapter adapter; // todo Cambiar
    List<Producto> listaProductosCarrito;
    Model model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrito);
        setTitle("Carrito de Compras");

        listaProductosCarrito = model.getListaProductosCarrito();

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new CarritoAdapter(this, listaProductosCarrito);
        adapter.setOnAdapterListener(new OnAdapterListener() {
            @Override
            public void onProductoClicked(int position, String nombreProducto, int id) {
                listaProductosCarrito.add(listaProductosCarrito.get(position));
                Toast toast = Toast.makeText(getApplicationContext(), "Agregado: " + nombreProducto, Toast.LENGTH_SHORT);
                toast.show();
            }
        });
        recyclerView.setAdapter(adapter);
        TextView precio = (TextView)findViewById(R.id.textViewPrecio);
        precio.setText(precioFinal());
        btnPagar =  (Button) findViewById(R.id.btnPagar);
        btnPagar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i = new Intent(CarritoActivity.this, Activity_Pagos.class);
                startActivity(i);
            }
        });
    }

    public String precioFinal(){
        Double precio = 0.0;
        for(int i = 0; i < listaProductosCarrito.size(); i++){
            precio = precio + listaProductosCarrito.get(i).getPrice();
        }
        return Double.toString(precio);
    }

}
