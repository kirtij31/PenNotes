package com.example.pennotes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class Add_Notes extends AppCompatActivity {

    EditText title_text;
    EditText description_text;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__notes);

          title_text =findViewById(R.id.add_title);
          description_text = findViewById(R.id.add_description);
          imageView = findViewById(R.id.image_add);

          imageView.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  MyDatabaseHelper myDatabaseHelper = new MyDatabaseHelper(Add_Notes.this);

                  if(description_text.getText().toString().length()>0||title_text.getText().toString().length()>0){
                  myDatabaseHelper.add_note(title_text.getText().toString().trim(),description_text.getText().toString().trim());}
              }
          });
    }
}