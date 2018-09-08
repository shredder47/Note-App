package com.example.shred.simplenoteapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddNote extends AppCompatActivity {

    EditText details_et;
    String content;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        details_et = (EditText) findViewById(R.id.details_et);

        Intent intent = getIntent();

        content =intent.getStringExtra("Content");
        id = intent.getIntExtra("ID",-1);

        details_et.setText(content);
    }
    public void save(View view)
    {
        String newDetail=  details_et.getText().toString().trim();

        if(id>=0) {
            MainActivity.notes.set(id, newDetail);
            MainActivity.arrayAdapter.notifyDataSetChanged();
            Intent i = new Intent(AddNote.this,MainActivity.class);
            startActivity(i);
        }
        else
        {
            MainActivity.notes.add(newDetail);
            Intent i = new Intent(AddNote.this,MainActivity.class);
            startActivity(i);
        }
    }

}
