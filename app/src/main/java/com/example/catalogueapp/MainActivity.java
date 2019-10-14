package com.example.catalogueapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.catalogueapp.database.CatalogueDatabase;
import com.example.catalogueapp.database.DatabaseReceiver;
import com.example.catalogueapp.database.DatabaseTask;
import com.example.catalogueapp.database.Product;

import java.util.List;

public class MainActivity extends AppCompatActivity implements DatabaseReceiver {

    public static String MESSAGE = "com.example.catalogueApp.MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void actionFromButton(View view){
        Log.d("CLICKED" , "FROM VIEW " + view);
    }

    public void getAll(List<Product> products){

        LayoutInflater inflater = getLayoutInflater();
        ViewGroup table = findViewById(R.id.catalogueList);
        for (Product actual:products) {
            Log.d("Hello","PRODUCTS NAME HERE! " + actual.name);
            View row = inflater.inflate(R.layout.row_layout,table, false );
            TextView vw = row.findViewById(R.id.productName);
            vw.setText(actual.name);
            table.addView(row);
        }
    }
    public void doAction(View view){

        DatabaseTask task = new DatabaseTask(getApplicationContext(), this);
        Product p = new Product();
        task.execute(p);
        /*
        Log.d("CUSTOM","CLICK ON  ME!");
        TextView v = findViewById(R.id.editText);
        TextView vt = findViewById(R.id.viewTitleText);
        vt.setText(v.getText());

        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(MESSAGE,""+v.getText());
        Log.d("TEXT " ,"" + v.getText());
        startActivity(intent);*/
    }
}
