package com.example.desiggn_paterns_1.favoriteProducts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.desiggn_paterns_1.Product;
import com.example.desiggn_paterns_1.R;

import java.util.ArrayList;
import java.util.List;

public class FavoriteAdapter extends RecyclerView.Adapter<FavoriteAdapter.ViewHolder>{
    private Context context;
    private List<Product> products = new ArrayList<Product>();
    private onfavoriteclickListener listener;


    public FavoriteAdapter(Context con, List<Product> productList, onfavoriteclickListener li){
        context = con;
        products = productList;
        listener = li;
        products =  productList;
    }

    public void setList(List<Product> productList){
        products = productList;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View row = inflater.inflate(R.layout.favorite,parent,false);
        ViewHolder viewHolder = new ViewHolder(row);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Product product = products.get(position);
        holder.title_text.setText(product.get_title());
        holder.price_text.setText(product.get_price());
        holder.brand_text.setText(product.get_brand());
        holder.desc_text.setText(product.get_desc());
        holder.rat.setRating((float) product.get_rate());

        Glide.with(context).load(product.getThumbnailUrl()).apply(new RequestOptions().override(150,150).placeholder(R.drawable.ic_launcher_background).error(R.drawable.ic_launcher_background)).into(holder.pro_img);

        holder.remove_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.OnfavClickListener(product);
            }
        });


    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title_text;
        TextView price_text;
        TextView brand_text;
        TextView desc_text;
        ImageView pro_img;
        RatingBar rat;
        Button remove_btn;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title_text = itemView.findViewById(R.id.title_value);
            price_text = itemView.findViewById(R.id.Price_value);
            brand_text = itemView.findViewById(R.id.Brand_value);
            desc_text = itemView.findViewById(R.id.desc_value);
            pro_img = itemView.findViewById(R.id.pro_imag);
            rat = itemView.findViewById(R.id.rating_value);
            remove_btn = itemView.findViewById(R.id.remove_btn);
        }
    }
}
