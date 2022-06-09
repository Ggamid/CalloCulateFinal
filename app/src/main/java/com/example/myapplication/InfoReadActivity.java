package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import java.nio.charset.StandardCharsets;

public class InfoReadActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_read);
        TextView Name, LastName, FatherName;
        EditText weight, birthday, age;

        Name = findViewById(R.id.FirstNameInfoActivity);
        LastName = findViewById(R.id.LastNameInfoActivity);
        FatherName = findViewById(R.id.FatherNameInfloActivity);
        weight = findViewById(R.id.Weight);
        birthday = findViewById(R.id.BirthDayInfoActivity);
        age = findViewById(R.id.AgeInDays);

        Bundle data = getIntent().getExtras();
        String name = data.get("NameChild").toString();
        String lastName = data.get("LastChild").toString();
        String fatherName = data.get("FatherChild").toString();
        String setage = data.get("ageChild").toString();
        String setweight = data.get("weightChild").toString();
        String setBirthDay= data.get("BirthChild").toString();

        Name.setText(name);
        LastName.setText(lastName);
        FatherName.setText(fatherName);
        weight.setText(setweight);
        age.setText(setage);
        birthday.setText(setBirthDay);

    }
}