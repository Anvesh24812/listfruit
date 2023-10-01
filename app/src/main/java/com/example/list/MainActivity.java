package com.example.list;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    public final static String fruitDescription = "fruitDescription";
    ListView simpleList;
    ArrayList<Item> fruitList = new ArrayList<>();
    HashMap<String, String> Data = new HashMap<String, String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Data.put("grapes","color of most grapes is black, available year-round.");
        Data.put("greenapple","Mostly grows in cool climatic conditions.");
        Data.put("mango","Mango is known as king of fruits.");
        Data.put("orange","Orange is a kind of citrus fruit.");
        fruitList.add(new Item("grapes",R.drawable.grapes_fruit));
        fruitList.add(new Item("greenapple",R.drawable.greenapple_fruit));
        fruitList.add(new Item("mango",R.drawable.mango_fruit));
        fruitList.add(new Item("orange",R.drawable.orange_fruit));
        simpleList = (ListView) findViewById(R.id.simpleListView);
        MyAdapter myAdapter = new MyAdapter(
                this, R.layout.list_view_item, fruitList);
        simpleList.setAdapter(myAdapter);
        simpleList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Item item = (Item)simpleList.getItemAtPosition(position);
                item = (Item) parent.getItemAtPosition(position);
                // Creating the intent to go to the Description activity
                Intent send = new Intent(MainActivity.this, Description.class);
                send.putExtra("fruitName", item.getFruitName());
                send.putExtra("fruitDescription", Data.get(item.getFruitName()));
                send.putExtra("fruitImage", item.getFruitImage());

                startActivity(send);
            }
        });
    }
}