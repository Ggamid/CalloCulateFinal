package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class InfoReadActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_read);
        TextView Name, LastName, FatherName;
        EditText weight, birthday, mixture_view;
        AlertDialog.Builder builder;
        ImageView button;
        Button calc;

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        calc = findViewById(R.id.button4);
        Name = findViewById(R.id.FirstNameInfoActivity);
        LastName = findViewById(R.id.LastNameInfoActivity);
        FatherName = findViewById(R.id.FatherNameInfloActivity);
        weight = (EditText) findViewById(R.id.Weight);
        birthday = (EditText) findViewById(R.id.BirthDayInfoActivity);
        mixture_view = (EditText) findViewById(R.id.Mixture);
        button = findViewById(R.id.imageView8);


        Bundle data = getIntent().getExtras();
        String name = data.get("NameChild").toString();
        String lastName = data.get("LastChild").toString();
        String fatherName = data.get("FatherChild").toString();
        String setage = data.get("ageChild").toString();
        String setweight = data.get("weightChild").toString();
        String setBirthDay= data.get("BirthChild").toString();
        String id = data.get("id").toString();
        String mixture = data.get("mixture").toString();

        Name.setText(name);
        LastName.setText(lastName);
        FatherName.setText(fatherName);
        weight.setText(setweight);
        mixture_view.setText(mixture);
        birthday.setText(setBirthDay);


        weight.setEnabled(false);
        mixture_view.setEnabled(false);
        birthday.setEnabled(false);

        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InfoReadActivity.this,CalcActivity.class);
                intent.putExtra("weightChild", setweight);
                intent.putExtra("mixture", mixture);
                intent.putExtra("Name", name);
                intent.putExtra("LastName", lastName);
                intent.putExtra("FatherName", fatherName);
                intent.putExtra("age", setage);
                startActivity(intent);
            }
        });
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

