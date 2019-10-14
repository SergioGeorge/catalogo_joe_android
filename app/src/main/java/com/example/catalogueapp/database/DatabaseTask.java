package com.example.catalogueapp.database;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;

import androidx.room.Room;

import com.example.catalogueapp.MainActivity;

import java.util.List;

public class DatabaseTask extends AsyncTask<Product,Void, List<Product>> {
    CatalogueDatabase db;
    DatabaseReceiver receiver;
    public DatabaseTask(Context ctx , DatabaseReceiver receiver){
        this.receiver = receiver;
        db = Room.databaseBuilder(ctx,
                CatalogueDatabase.class ,
                "catalogue-database").build();
    }
    @Override
    public void onPreExecute(){
    }
    @Override
    protected List<Product> doInBackground(Product... params) {
        return db.productDao().getAll();
    }
    @Override
    public void onPostExecute(List<Product> result){
        // do something on ui!
        receiver.getAll(result);
    }
}
