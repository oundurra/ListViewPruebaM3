package com.example.ejercicioprueba;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ProductAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private ArrayList<Product> products;


    public ProductAdapter(Context context, int layout, ArrayList<Product> products){
        this.context = context;
        this.layout = layout;
        this.products = products;
    }

    @Override
    public int getCount() {
        return this.products.size();
    }

    @Override
    public Object getItem(int position) {
        return this.products.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        String currentName;
        int currentImage;
        LayoutInflater layoutInflater = LayoutInflater.from(this.context);

        v= layoutInflater.inflate(R.layout.product_list, null);
        currentImage = products.get(position).getImage();
        currentName = products.get(position).getName();

        ImageView imageView = (ImageView) v.findViewById(R.id.imgProducto);
        TextView textView = (TextView) v.findViewById(R.id.lblProducto);
        imageView.setImageResource(currentImage);
        textView.setText(currentName);
        return v;
    }
}
