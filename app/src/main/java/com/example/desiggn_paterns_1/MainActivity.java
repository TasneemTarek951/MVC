package com.example.desiggn_paterns_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.desiggn_paterns_1.AllProducts.AllProductActivity;
import com.example.desiggn_paterns_1.favoriteProducts.FavoriteProductsActivity;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button allbtn;
    Button favbtn;
    Button exit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        allbtn = (Button) findViewById(R.id.AllProduct_btn);
        favbtn = (Button) findViewById(R.id.FavoriteProduct_btn);
        exit = (Button) findViewById(R.id.Exit_btn);

        allbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AllProductActivity.class);
                startActivity(intent);
            }
        });

        favbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, FavoriteProductsActivity.class);
                startActivity(intent);
            }
        });

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }

}