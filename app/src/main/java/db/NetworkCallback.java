package db;

import com.example.desiggn_paterns_1.Product;

import java.util.List;

public interface NetworkCallback {

    public void onSuccessResult(List<Product> products);
    public void onfailureResult(String errorMsg);
}
