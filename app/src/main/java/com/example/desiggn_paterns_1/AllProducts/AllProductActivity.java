package com.example.desiggn_paterns_1.AllProducts;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.desiggn_paterns_1.Product;
import com.example.desiggn_paterns_1.R;
import com.example.desiggn_paterns_1.Repository;

import java.util.ArrayList;
import java.util.List;

import db.AppDataBase;
import db.Network;
import db.NetworkCallback;
import db.ProductDAO;

public class AllProductActivity extends AppCompatActivity implements NetworkCallback,onproductclicklistener{
    RecyclerView allRecycler;
    AllproductAdaoter allproductAdaoter;
    Network network;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_product);
        allRecycler = findViewById(R.id.recycler);
        network = new Network();
        network.Makenetworkcallback(this);
        LinearLayoutManager layout = new LinearLayoutManager(this);
        layout.setOrientation(LinearLayoutManager.HORIZONTAL);

        allproductAdaoter = new AllproductAdaoter(this,new ArrayList<>(),this);
        allRecycler.setLayoutManager(layout);
        allRecycler.setAdapter(allproductAdaoter);


    }

    @Override
    public void onSuccessResult(List<Product> products) {
        allproductAdaoter.SetList(products);
        allproductAdaoter.notifyDataSetChanged();

    }

    @Override
    public void onfailureResult(String errorMsg) {
        allRecycler.setVisibility(View.GONE);
        Toast.makeText(AllProductActivity.this, errorMsg, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void OnproductClickListener(Product product) {
        Toast.makeText(AllProductActivity.this, "Adding item!", Toast.LENGTH_SHORT).show();
        Repository repo = new Repository(this);
        repo.insert(product);

    }
}