package com.moviles1.cyn.ejemploscortos;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LENOVO on 17/4/2018.
 */

public class Model {
    static List<Producto> productoList = new ArrayList<>();
    static List<Producto> listaProductosCarrito = new ArrayList<>();

    public static List<Producto> getProductoList() {
        return productoList;
    }

    public static void setProductoList(List<Producto> productoList) {
        productoList = productoList;
    }

    public static List<Producto> getListaProductosCarrito() {
        return listaProductosCarrito;
    }

    public static void setListaProductosCarrito(List<Producto> listaProductosCarrito) {
        listaProductosCarrito = listaProductosCarrito;
    }

    public static void initProductoList(){
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
