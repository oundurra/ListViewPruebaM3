package com.example.ejercicioprueba;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView lstProductos;
    private ImageView imgProductoSel;
    private TextView lblProductoSel;
    private ArrayList<Product> products;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lstProductos = (ListView) findViewById(R.id.lstProductos);
        lblProductoSel = (TextView) findViewById(R.id.lblProductoSel);
        imgProductoSel = (ImageView) findViewById(R.id.imgProductoSel);

        products = new ArrayList<Product>();
        products.add(new Product(R.drawable.eosrp,"Canon RP"));
        products.add(new Product(R.drawable.eosr5,"Canon R5"));
        products.add(new Product(R.drawable.fujixt4,"Fujifilm XT4"));
        products.add(new Product(R.drawable.omd1,"Olympus OMD EM1 Mark III"));
        products.add(new Product(R.drawable.om52,"Olympus OMD EM5 Mark II"));

        lstProductos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                imgProductoSel.setImageResource(products.get(position).getImage());
                lblProductoSel.setText(products.get(position).getName());
            }
        });

        ProductAdapter productAdapterAdapter = new ProductAdapter(this, R.layout.product_list, products);
        lstProductos.setAdapter(productAdapterAdapter);
    }
}