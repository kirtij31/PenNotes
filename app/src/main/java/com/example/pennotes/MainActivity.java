package com.example.pennotes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    NoteModelAdapter noteModelAdapter;
    ArrayList<NoteModel> modelArrayList;
    FloatingActionButton floatingActionButton;
    MyDatabaseHelper myDatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        modelArrayList = new ArrayList<>();

        recyclerView = findViewById(R.id.rv);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));

        noteModelAdapter=new NoteModelAdapter(modelArrayList,this);
        recyclerView.setAdapter(noteModelAdapter);

        myDatabaseHelper = new MyDatabaseHelper(this);

        floatingActionButton = findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this,Add_Notes.class);
                startActivity(intent);
            }
        });

        displayNotes();
    }

    void displayNotes(){
        Cursor cursor = myDatabaseHelper.readNote();

        if(cursor.getCount()==0){

        }
        else{
            while (cursor.moveToNext()){
                modelArrayList.add(new NoteModel(cursor.getString(1),cursor.getString(2)));
            }
        }
    }
}