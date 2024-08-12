package com.example.desiggn_paterns_1.AllProducts;

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

import java.util.List;

public class AllproductAdaoter extends RecyclerView.Adapter<AllproductAdaoter.ViewHolder> {
    private Context context;
    private List<Product> products;
    private onproductclicklistener listener;


    public AllproductAdaoter(Context con, List<Product> productList, onproductclicklistener li){
        context = con;
        products = productList;
        listener = li;
    }

    public void SetList(List<Product> productList){
        products = productList;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View row = inflater.inflate(R.layout.product,parent,false);
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


        holder.add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.OnproductClickListener(product);
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
        Button add_btn;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title_text = itemView.findViewById(R.id.Title_value);
            price_text = itemView.findViewById(R.id.price_value);
            brand_text = itemView.findViewById(R.id.brand_value);
            desc_text = itemView.findViewById(R.id.Descript_value);
            pro_img = itemView.findViewById(R.id.product_imag);
            rat = itemView.findViewById(R.id.ratingBar_value);
            add_btn = itemView.findViewById(R.id.Addbtn);
        }
    }
}
