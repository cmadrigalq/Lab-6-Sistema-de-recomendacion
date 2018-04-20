package com.moviles1.cyn.ejemploscortos;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MantenimientoUsuariosActivity extends AppCompatActivity {
    ArrayList<Usuario> userList;
    Model model;
    public static final int request_Code=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mantenimiento_usuarios);
        setTitle("Mantenimiento Usuarios");
        userList = model.getListaUsuarios();
        dibujaTabla(userList);

        Button buscar = findViewById(R.id.btnBuscar);
        buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dibujaTabla(userList);
            }
        });

        Button nuevoUser = findViewById(R.id.btnNuevoUsuario);
        nuevoUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentNuevo = new Intent(MantenimientoUsuariosActivity.this, FormularioUsuarioActivity.class);
                startActivityForResult(intentNuevo,request_Code);
            }
        });
    }

    @Override
    public void finish() {
        model.setListaUsuarios(userList);
        super.finish();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if((requestCode == request_Code) && (resultCode == RESULT_OK)){
            if(data.hasExtra("accion")){
                String acc = data.getStringExtra("accion");
                if(acc.equals("nuevo")){
                    Usuario usuarioNuevo = (Usuario) data.getExtras().getSerializable("NuevoUsuario");
                    agregaUsuario(usuarioNuevo);
                    mostrarToast("Usuario agregado");
                }
                if(acc.equals("editado")){
                    Usuario usuarioEditado = (Usuario) data.getExtras().getSerializable("UsuarioEditado");
                    String cUser = data.getStringExtra("UserName");
                    String pUser = data.getStringExtra("ContraseñaUsuario");
                    editarUsuario(cUser,pUser,usuarioEditado);
                    mostrarToast("Usuario actualizado");
                }
            }
        }
    }

    private void editarUsuario(String cedula, String pass, Usuario u){
        for(int i = 0; i<userList.size(); i++){
            if(userList.get(i).getUserName().equals(cedula) && userList.get(i).getPassword().equals(pass)){
                userList.get(i).setUserName(u.getUserName());
                userList.get(i).setPassword(u.getPassword());
                userList.get(i).setTipo(u.getTipo());
                break;
            }
        }
        dibujaTabla(userList);
    }

    private void agregaUsuario(Usuario u){
        userList.add(u);
        dibujaTabla(userList);
    }

    private void mostrarToast(String mensaje){
        Toast toast= new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER, 0, 0);
        TextView tv = new TextView(MantenimientoUsuariosActivity.this);
        tv.setBackgroundColor(Color.GREEN);
        tv.setTextColor(Color.WHITE);
        tv.setTextSize(25);
        Typeface t = Typeface.create("arial", Typeface.NORMAL);
        tv.setTypeface(t);
        tv.setPadding(10,10,10,10);
        tv.setText(mensaje);
        toast.setView(tv);
        toast.show();
    }

    private void dibujaTabla(ArrayList<Usuario> u){
        TableLayout tabla = findViewById(R.id.idTableUsuarios);
        limpiaTabla(tabla);
        TableRow row;
        TextView tv1;
        TextView tv2;
        ImageButton btnEdit;
        ImageButton btnElim;
        TextView buscUserName = findViewById(R.id.txBuscUserName);
        for(int i=0;i<u.size();i++){
            if(u.get(i).getUserName().toLowerCase().contains(buscUserName.getText().toString().toLowerCase())) {
                if(u.get(i).getTipo() == 1 || u.get(i).getTipo() == 2) {
                    row = new TableRow(getBaseContext());
                    tv1 = new TextView(getBaseContext());
                    tv2 = new TextView(getBaseContext());
                    btnEdit = new ImageButton(getBaseContext());
                    btnEdit.setImageResource(R.drawable.ic_if_new_24_103173);
                    btnElim = new ImageButton(getBaseContext());
                    btnElim.setImageResource(R.drawable.ic_if_delete_301791);
                    tv1.setGravity(Gravity.CENTER);
                    tv2.setGravity(Gravity.CENTER);
                    tv1.setPadding(15, 15, 15, 15);
                    tv2.setPadding(15, 15, 15, 15);
                    tv1.setText(u.get(i).getUserName());
                    String tipo = "Administrador";
                    if(u.get(i).getTipo() == 2)
                        tipo = "Cliente";
                    tv2.setText(tipo);
                    final Usuario user = u.get(i);
                    btnEdit.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent iEditar = new Intent(MantenimientoUsuariosActivity.this, FormularioUsuarioActivity.class);
                            iEditar.putExtra("usuarioEdit", user);
                            startActivityForResult(iEditar, request_Code);
                        }
                    });
                    btnElim.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(MantenimientoUsuariosActivity.this);
                            builder.setTitle("Eliminar").setMessage("¿Desea eliminar el Usuario?")
                                    .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            eliminaUsuario(user.getUserName(), user.getPassword());
                                        }
                                    })
                                    .setNegativeButton("No", null).setCancelable(false);
                            AlertDialog alert = builder.create();
                            alert.show();
                        }
                    });
                    row.addView(tv1);
                    row.addView(tv2);
                    row.addView(btnEdit);
                    row.addView(btnElim);
                    tabla.addView(row);
                }
            }
        }
    }

    private void limpiaTabla(TableLayout tabla){
        int tam = tabla.getChildCount();
        for(int i=1; i<tam; i++){
            View fila = tabla.getChildAt(i);
            if(fila instanceof TableRow)
                ((ViewGroup) fila).removeAllViews();
        }
    }

    private void eliminaUsuario(String ced, String pass){
        for(int i=0;i<userList.size();i++){
            if(userList.get(i).getUserName().equals(ced) && userList.get(i).getPassword().equals(pass)){
                userList.remove(i);
                break;
            }
        }
        dibujaTabla(userList);
    }

}
