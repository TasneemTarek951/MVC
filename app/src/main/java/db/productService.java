package db;


import com.example.desiggn_paterns_1.ProductResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface productService {

    @GET("products")
    public Call<ProductResponse> getProducts();
}
