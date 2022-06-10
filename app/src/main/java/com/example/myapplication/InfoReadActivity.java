package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.nio.charset.StandardCharsets;

public class InfoReadActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_read);
        TextView Name, LastName, FatherName;
        EditText weight, birthday, age;
        AlertDialog.Builder builder;
        ImageView button;


        Name = findViewById(R.id.FirstNameInfoActivity);
        LastName = findViewById(R.id.LastNameInfoActivity);
        FatherName = findViewById(R.id.FatherNameInfloActivity);
        weight = (EditText) findViewById(R.id.Weight);
        birthday = (EditText) findViewById(R.id.BirthDayInfoActivity);
        age = (EditText) findViewById(R.id.AgeInDays);
        button = findViewById(R.id.imageView8);


        Bundle data = getIntent().getExtras();
        String name = data.get("NameChild").toString();
        String lastName = data.get("LastChild").toString();
        String fatherName = data.get("FatherChild").toString();
        String setage = data.get("ageChild").toString();
        String setweight = data.get("weightChild").toString();
        String setBirthDay= data.get("BirthChild").toString();
        String id = data.get("id").toString();

        Name.setText(name);
        LastName.setText(lastName);
        FatherName.setText(fatherName);
        weight.setText(setweight);
        age.setText(setage);
        birthday.setText(setBirthDay);


        weight.setEnabled(false);
        age.setEnabled(false);
        birthday.setEnabled(false);

        builder = new AlertDialog.Builder(this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                builder.setTitle("Осторожно.")
                        .setMessage("Вы уверены что хотите удалить эти данные?")
                        .setCancelable(true)
                        .setPositiveButton("Да", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
                                Query applesQuery = ref.child("Child").orderByChild("id").equalTo(id);

                                applesQuery.addListenerForSingleValueEvent(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(DataSnapshot dataSnapshot) {
                                        for (DataSnapshot appleSnapshot: dataSnapshot.getChildren()) {
                                            appleSnapshot.getRef().removeValue();
                                        }
                                    }

                                    @Override
                                    public void onCancelled(DatabaseError databaseError) {
//                Log.e(TAG, "onCancelled", databaseError.toException());
                                    }
                                });
                                Intent intent = new Intent(InfoReadActivity.this, MainActivity.class);
                                startActivity(intent);
                            }
                        })
                        .setNegativeButton("Нет", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        })
                        .show();
            }
        });

    }

}

