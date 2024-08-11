package com.example.desiggn_paterns_1;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.util.List;

@Entity(tableName = "products_table")
public class Product {
    @PrimaryKey
    @NonNull
    @SerializedName("title")
    private String _title;
    @SerializedName("price")
    private String _price;
    @SerializedName("brand")
    private String _brand;
    @SerializedName("description")
    private String _desc;
    @SerializedName("rating")
    private double _rate;
    @SerializedName("thumbnail")
    private String thumbnailUrl;



    public Product(String title, String price, String brand, String desc, double rate, String url){
        _title = title;
        _price = price;
        _brand = brand;
        _desc = desc;
        _rate = rate;
        thumbnailUrl = url;
    }

    public void SetTitle(String title){
        _title = title;
    }

    public void SetPrice(String price){
        _price = price;
    }
    public void SetBrand(String brand){
        _brand = brand;
    }
    public void SetDesc(String desc){
        _desc = desc;
    }
    public void SetRate(double rate){
        _rate = rate;
    }
    public void SetUrl(String url){
        thumbnailUrl = url;
    }

    public String getTitle(){
        return _title;
    }

    public String getPrice(){
        return _price;
    }

    public String getBrand(){
        return _brand;
    }

    public String getDesc(){
        return _desc;
    }
    public double getRate(){
        return _rate;
    }
    public String getUrl(){
        return thumbnailUrl;
    }

}
