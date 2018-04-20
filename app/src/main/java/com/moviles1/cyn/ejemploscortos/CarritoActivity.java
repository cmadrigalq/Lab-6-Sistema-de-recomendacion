package com.moviles1.cyn.ejemploscortos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class CarritoActivity extends AppCompatActivity {
    final public static String TOTAL_A_PAGAR = "TOTAL_A_PAGAR";
    Button btnPagar;
    RecyclerView recyclerView;
    CarritoAdapter adapter;
    List<Producto> listaProductosCarrito;
    Model model;
    double totalApagar = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrito);
        setTitle("Carrito de Compras");

        listaProductosCarrito = model.getListaProductosCarrito();

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new CarritoAdapter(this, listaProductosCarrito,this);
        adapter.setOnAdapterListener(new OnAdapterListener() {
            @Override
            public void onProductoClicked(int position, String nombreProducto, int id) {
                listaProductosCarrito.add(listaProductosCarrito.get(position));
                Toast toast = Toast.makeText(getApplicationContext(), "Agregado: " + nombreProducto, Toast.LENGTH_SHORT);
                toast.show();
            }
            @Override
            public void calcularPrecioFinal(Double precio) {
                CarritoActivity.this.upDateTextViewPrecio();
            }

        });
        recyclerView.setAdapter(adapter);
        //TextView precio = (TextView)findViewById(R.id.textViewPrecio);
        //precio.setText(precioFinal());
        btnPagar =  (Button) findViewById(R.id.btnPagar);
        btnPagar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(CarritoActivity.this.totalApagar > 0) {
                    Intent i = new Intent(CarritoActivity.this, Activity_Pagos.class);
                    i.putExtra(CarritoActivity.TOTAL_A_PAGAR, CarritoActivity.this.totalApagar);
                    startActivity(i);
                }else{
                    Toast toast = Toast.makeText(getApplicationContext(),"No hay productos en el carrito.",Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });
        upDateTextViewPrecio();
    }

    void precioFinal(){
        totalApagar = 0;
        for(Producto p : listaProductosCarrito){
            this.totalApagar+= (p.getPrice() * p.getCantidad());
        }
    }
    double getTotalApagar(){
        return this.totalApagar;
    }
    void setTotalApagar(double t){
        this.totalApagar = t;
    }
    public void upDateTextViewPrecio(){
        this.precioFinal();
        TextView t = super.findViewById(R.id.textViewPrecio);
        t.setText(String.valueOf(this.totalApagar));
    }
}
