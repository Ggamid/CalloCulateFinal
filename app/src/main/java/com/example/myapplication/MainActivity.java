package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Toast;

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
    ArrayList<Child>childList = new ArrayList<Child>();
    RecyclerView rv;
    RvAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        childList = new ArrayList<>();
        mDataBase = FirebaseDatabase.getInstance().getReference("Child");
        rv = findViewById(R.id.rv1);
        RvAdapter.OnStateClickListener stateClickListener = new RvAdapter.OnStateClickListener() {
            @Override
            public void onStateClick(Child child, int position) {
                Intent intent = new Intent(MainActivity.this, InfoReadActivity.class);
                intent.putExtra("NameChild", child.getFirstName());
                intent.putExtra("LastChild", child.getLastName());
                intent.putExtra("FatherChild", child.getFatherName());
                intent.putExtra("ageChild", child.getAge());
                intent.putExtra("BirthChild", child.getBirthDay());
                intent.putExtra("weightChild", child.getWeight());
                intent.putExtra("id", child.getId());
                if (!child.getSmes().equals("")){
                intent.putExtra("mixture", child.getSmes());
                }
                startActivity(intent);
            }
        };
        adapter = new RvAdapter(childList, stateClickListener);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplication(), LinearLayoutManager.VERTICAL, false);
        rv.setLayoutManager(linearLayoutManager);
        rv.setAdapter(adapter);
        getDataDB();


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
        adapter.notifyDataSetChanged();
        }
        @Override
        public void onCancelled(@NonNull DatabaseError error) {

        }
    };
    mDataBase.addValueEventListener(vListener);
    }



}