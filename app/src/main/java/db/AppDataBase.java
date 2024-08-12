package db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.desiggn_paterns_1.Product;

@Database(entities = {Product.class},version = 1,exportSchema = false)
public abstract class AppDataBase extends RoomDatabase {
    private static AppDataBase instance = null;
    public abstract ProductDAO getProductDAO();
    public static synchronized AppDataBase getinstance(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),AppDataBase.class,"productsdb").build();

        }
        return instance;
    }
}
