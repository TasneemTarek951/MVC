package db;

import com.example.desiggn_paterns_1.ProductResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Network {
    public static final String base_url = "https://dummyjson.com/";
    productService proservice;

    public Network(){
        Retrofit retrofit = new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).baseUrl(base_url).build();
        proservice = retrofit.create(productService.class);
    }



    public void Makenetworkcallback(NetworkCallback networkCallback){
        proservice.getProducts().enqueue(new Callback<ProductResponse>() {
            @Override
            public void onResponse(Call<ProductResponse> call, Response<ProductResponse> response) {
                if(response.isSuccessful()){
                    networkCallback.onSuccessResult(response.body().getProducts());
                }
            }

            @Override
            public void onFailure(Call<ProductResponse> call, Throwable t) {
                networkCallback.onfailureResult(t.getMessage());
                t.printStackTrace();
            }
        });
    }


}
