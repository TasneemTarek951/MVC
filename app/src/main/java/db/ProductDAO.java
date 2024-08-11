package db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.desiggn_paterns_1.Product;

import java.util.List;

@Dao
public interface ProductDAO {
    @Query("SELECT * FROM products_table")
    LiveData<List<Product>> getAllProducts();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void InsertProduct(Product product);

    @Delete
    void DeleteProduct(Product product);
}
