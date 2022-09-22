package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class Result extends AppCompatActivity {
    TextView Result, generalInfo;

    ClipboardManager clipboardManager;
    ClipData clipData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);



        Bundle data = getIntent().getExtras();
        String result = data.get("ResultList").toString();
        String generalInfotxt = data.get("generalInfo").toString();

        Result = findViewById(R.id.Result);
        generalInfo = findViewById(R.id.generalInfo);


        Result.setText(result);
        generalInfo.setText(generalInfotxt);

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);




    }

    public void copyData(View view) {

        clipboardManager=(ClipboardManager)getSystemService(CLIPBOARD_SERVICE);

        String text = Result.getText().toString();
        clipData = ClipData.newPlainText("text",text);
        clipboardManager.setPrimaryClip(clipData);

        Toast.makeText(getApplicationContext(),"Text Copied ",Toast.LENGTH_SHORT).show();
    }

}