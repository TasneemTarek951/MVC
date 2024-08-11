package com.example.desiggn_paterns_1.favoriteProducts;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.desiggn_paterns_1.Product;
import com.example.desiggn_paterns_1.R;
import com.example.desiggn_paterns_1.Repository;

import java.util.ArrayList;
import java.util.List;

public class FavoriteProductsActivity extends AppCompatActivity implements onfavoriteclickListener {

    RecyclerView recycl;
    FavoriteAdapter adapter;
    RecyclerView.LayoutManager layoutManager;
    Repository repo = new Repository(this);
    List<Product> products = new ArrayList<Product>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite_products);
        recycl = findViewById(R.id.recycler);

        adapter = new FavoriteAdapter(this,new ArrayList<Product>(),this);
        LinearLayoutManager layout = new LinearLayoutManager(this);
        layout.setOrientation(LinearLayoutManager.HORIZONTAL);
        recycl.setLayoutManager(layout);
        recycl.setAdapter(adapter);

        Observer<List<Product>> observer = new Observer<List<Product>>() {
            @Override
            public void onChanged(List<Product> productList) {
                adapter.setList(productList);
            }
        };

        LiveData<List<Product>> observable = repo.getstoredProducts();
        observable.observe(this,observer);


    }

    @Override
    public void OnfavClickListener(Product product) {
        Toast.makeText(FavoriteProductsActivity.this, "deleted", Toast.LENGTH_SHORT).show();
        repo.delete(product);
        adapter.notifyDataSetChanged();

    }
}