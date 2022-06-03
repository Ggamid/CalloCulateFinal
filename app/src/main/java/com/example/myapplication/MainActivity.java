package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    FirebaseUser fUser;
    DatabaseReference mDataBase;
    ArrayList<Child> arrayList;
    List<Child> childList;
    RecyclerView rv;
    ArrayAdapter<Child> adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        childList = new ArrayList<>();
        mDataBase = FirebaseDatabase.getInstance().getReference("Child");
        rv = findViewById(R.id.rv1);
        arrayList = new ArrayList<>();

        getDataDB();

        arrayList.addAll(childList);
        RvAdapter rvAdapter = new RvAdapter(arrayList);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplication(), LinearLayoutManager.VERTICAL, false);
        rv.setLayoutManager(linearLayoutManager);
        rv.setAdapter(rvAdapter);

    }
    private void init(){

    }


    @Override
    protected void onStart() {
        super.onStart();
        fUser = FirebaseAuth.getInstance().getCurrentUser();
        if(fUser==null){
            startActivity(new Intent(MainActivity.this,LoginActivity.class));
        }

    }
    public void click(View view){
        startActivity(new Intent(MainActivity.this,AddChildActivity.class));
    }
    public void getDataDB(){
    ValueEventListener vListener = new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot snapshot) {
        childList.clear();
        for (DataSnapshot ds : snapshot.getChildren())
        {
            Child child = ds.getValue(Child.class);
            assert child != null;
            childList.add(child);
        }
        }
        @Override
        public void onCancelled(@NonNull DatabaseError error) {

        }
    };
    mDataBase.addValueEventListener(vListener);
    }



}