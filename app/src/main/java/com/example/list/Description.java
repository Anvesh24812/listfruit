package com.example.list;

import static java.lang.Integer.parseInt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Description extends AppCompatActivity {
    private Button returnButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);
        returnButton = (Button) findViewById(R.id.ReturnButton);
        returnButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) { finish(); }
        });
        Intent intent = getIntent();
        String fruitName = intent.getStringExtra("fruitName");
        String fruitDescription = intent.getStringExtra("fruitDescription");
        int fruitimg = intent.getIntExtra("fruitImage", 1);
        TextView nameTextView = findViewById(R.id.textName);
        TextView descriptionTextView = findViewById(R.id.textDescription);
        ImageView img = findViewById(R.id.imageView3);
        nameTextView.setText(fruitName);
        descriptionTextView.setText(fruitDescription);
        img.setImageResource(fruitimg);
    }
}


