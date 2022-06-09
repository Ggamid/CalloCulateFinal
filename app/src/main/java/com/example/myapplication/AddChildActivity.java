package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddChildActivity extends AppCompatActivity {
    EditText firstName,lastName,fatherName, birthDay, age, weight;
    Spinner smes;
    DatabaseReference firebaseDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_child);
        init();
    }
    public void init(){
        firstName = findViewById(R.id.childName);
        lastName = findViewById(R.id.childLastName);
        fatherName = findViewById(R.id.childFatherName);
        birthDay = findViewById(R.id.RegActivityBirthDay);
        age = findViewById(R.id.Age);
        weight = findViewById(R.id.weight);
        smes = findViewById(R.id.spinner);
        firebaseDatabase  = FirebaseDatabase.getInstance().getReference("Child");


    }
    public void setBD(View view){
        if(!firstName.getText().toString().equals("") && !lastName.getText().toString().equals("") && !fatherName.getText().toString().equals("") && !age.getText().toString().equals("")  && !weight.getText().toString().equals("") && !birthDay.getText().toString().equals("")) {
            Child child = new Child(firstName.getText().toString(), lastName.getText().toString(), fatherName.getText().toString(), birthDay.getText().toString(), age.getText().toString(), weight.getText().toString(), smes.getSelectedItem().toString());
            firebaseDatabase.push().setValue(child);
            startActivity(new Intent(AddChildActivity.this, MainActivity.class));
        }
        else{
            Toast.makeText(getApplicationContext(), "Заполните все поля", Toast.LENGTH_SHORT).show();
//
        }
    }
}