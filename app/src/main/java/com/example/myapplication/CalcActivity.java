package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import static com.example.myapplication.Сalculations.*;


public class CalcActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // add mixtures

        Mixtures nutrilon_from_birth = new Mixtures(1.3,3.4, 7.3, 66);
        Mixtures nutrilon_pre1_1800gramm = new Mixtures(2.0, 3.9,7.4,74);
        Mixtures nutrilon_pepti_gastro = new Mixtures(1.8,3.4, 7.0, 66);
        Mixtures nutrilon_pre0 = new Mixtures(2.6,3.8,8.3,79);
        Mixtures nutrilon_pre1 = new Mixtures(2.2,4.4,8.0, 123);
        Mixtures similac_premium = new Mixtures(1.33,3.3,7.35,64);
        Mixtures similac_neo_shur = new Mixtures(1.9,4.1,7.7,74);
        Mixtures pre_nan = new Mixtures(2.32,4.2,8.57,80);
        Mixtures similac_special_care = new Mixtures(2.67,4.35,8.10,82);

        // common values




    }





}