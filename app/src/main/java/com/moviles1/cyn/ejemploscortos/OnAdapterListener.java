package com.moviles1.cyn.ejemploscortos;

import java.util.ArrayList;

public interface OnAdapterListener {
    void onProductoClicked(int position, String nombreProducto, int id);
    void calcularPrecioFinal(Double precio);
}
