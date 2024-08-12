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


    public Product(){}
    public Product(String title, String price, String brand, String desc, double rate, String url){
        _title = title;
        _price = price;
        _brand = brand;
        _desc = desc;
        _rate = rate;
        thumbnailUrl = url;
    }

    @NonNull
    public String get_title() {
        return _title;
    }

    public void set_title(@NonNull String _title) {
        this._title = _title;
    }

    public String get_price() {
        return _price;
    }

    public void set_price(String _price) {
        this._price = _price;
    }

    public String get_brand() {
        return _brand;
    }

    public void set_brand(String _brand) {
        this._brand = _brand;
    }

    public String get_desc() {
        return _desc;
    }

    public void set_desc(String _desc) {
        this._desc = _desc;
    }

    public double get_rate() {
        return _rate;
    }

    public void set_rate(double _rate) {
        this._rate = _rate;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }
}
