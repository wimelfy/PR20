package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText edName, edSName, edMail;

    Button btnSave, btnRead;

    private DatabaseReference myDataBase;

    final String USER_KEY = "User";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edName = findViewById(R.id.edName);
        edMail = findViewById(R.id.edMail);

        myDataBase = FirebaseDatabase.getInstance().getReference(USER_KEY);
    }

    @Override
    public void onClick(View view) {

        if(view.getId() == btnSave.getId()) {
            Person person = new Person();
            person.SetName(edName.getText().toString());
            person.SetAddress(edMail.getText().toString());

            myDataBase.child("Person").setValue(person);
        }
    }
}

class Person{
    String name;
    String address;

    public void SetName(String namee){
        name = namee;
    }
    public void SetAddress(String addresss){
        address = addresss;
    }
}