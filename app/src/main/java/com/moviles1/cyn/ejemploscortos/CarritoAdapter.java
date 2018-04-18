package com.moviles1.cyn.ejemploscortos;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by LENOVO on 17/4/2018.
 */

public class CarritoAdapter extends RecyclerView.Adapter<CarritoAdapter.ProductViewHolder>
        implements OnProductoListener{
    //this context we will use to inflate the layout
    private Context mCtx;

    //we are storing all the products in a list
    private List<Producto> productList;
    private OnAdapterListener onAdapterListener;

    public void setOnAdapterListener(OnAdapterListener onAdapterListener) {
        this.onAdapterListener = onAdapterListener;
    }

    //getting the context and product list with constructor
    public CarritoAdapter(Context mCtx, List<Producto> productList) {
        this.mCtx = mCtx;
        this.productList = productList;
    }

    @Override
    public CarritoAdapter.ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.carritolist_layout, null);
        return new CarritoAdapter.ProductViewHolder(view, this);
    }

    @Override
    public void onBindViewHolder(CarritoAdapter.ProductViewHolder holder, int position) {
        //getting the product of the specified position
        Producto product = productList.get(position);

        //binding the data with the viewholder views
        holder.textViewTitle.setText(product.getTitle());
        holder.textViewShortDesc.setText(product.getShortdesc());
        holder.textViewRating.setText(String.valueOf(product.getRating()));
        holder.textViewPrice.setText("₡"+String.valueOf(product.getPrice()));
        holder.imageView.setImageDrawable(mCtx.getResources().getDrawable(product.getImage()));

    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    @Override
    public void onCheckBoxSelected(int position) {
        onAdapterListener.onProductoClicked(position,productList.get(position).getTitle(),productList.get(position).getId());
    }

    @Override
    public void onCheckBoxUnselected(int position) {
        onAdapterListener.onProductoClicked(position,productList.get(position).getTitle(),productList.get(position).getId());
    }

    class ProductViewHolder extends RecyclerView.ViewHolder {

        TextView textViewTitle, textViewShortDesc, textViewRating, textViewPrice;
        ImageView imageView;

        public ProductViewHolder(View itemView, final OnProductoListener onProductoListener) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewShortDesc = itemView.findViewById(R.id.textViewShortDesc);
            textViewRating = itemView.findViewById(R.id.textViewRating);
            textViewPrice = itemView.findViewById(R.id.textViewPrice);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}
