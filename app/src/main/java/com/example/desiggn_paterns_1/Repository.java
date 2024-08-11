package com.example.desiggn_paterns_1;

import android.content.Context;

import androidx.lifecycle.LiveData;

import java.util.List;

import db.AppDataBase;
import db.ProductDAO;

public class Repository {
    private Context context;
    private ProductDAO dao;
    private LiveData<List<Product>> storedProducts;

    public Repository(Context con){
        context = con;
        AppDataBase db = AppDataBase.getinstance(context.getApplicationContext());
        dao = db.getProductDAO();
        storedProducts = dao.getAllProducts();
    }

    public LiveData<List<Product>> getstoredProducts(){
        return storedProducts;
    }

    public void delete(Product product){
        new Thread(new Runnable() {
            @Override
            public void run() {
                dao.DeleteProduct(product);
            }
        }).start();
    }

    public void insert(Product product){
        new Thread(new Runnable() {
            @Override
            public void run() {
                dao.InsertProduct(product);
            }
        }).start();
    }
}
