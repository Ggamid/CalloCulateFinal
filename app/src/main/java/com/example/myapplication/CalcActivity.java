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
        setContentView(R.layout.activity_newcalc);

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

        Bundle data = getIntent().getExtras();
        double weight = Integer.parseInt(data.get("weightChild").toString());
        double age = Integer.parseInt(data.get("ageChild").toString());

        double indeed = 1;
        double boluses = 1;

        double vSingleFeeding = 1;
        double countFeeding = 1;

        byte enteral = 1;

        double indeedNa = 1;

        double indeedK = 1;

        double indeedC = 1;

        double indeedMg = 1;

        double speedOfUtil = 1;

        double doseOfFate= 1;
        double fateEP= 1;
        double concentrationOfFateEmulsion= 1;

        double doseOfAminokislot = 1;
        double proteinEP = 1;
        double concentrationOfAmino = 1;

        double generalLiquid = 1;
        double vEnteral = 1;
        double vElectolits = 1;
        double vFlateEmuls = 1;
        double vAmionkislot = 1;

        double doseOfGlukoza = glukoza(speedOfUtil, weight);

        double carbohydratesEnteral = 1;

        double c1 = 1;
        double v = 1;
        double c2 = 1;

        double generalVInfusion = 1;
        double VInfusion = 1;

        double enteralCal = 1;
        double uglevodi = 1;
        double protein = 1;
        double flat = 1;

        // 1

        calcLiquid(indeed, weight, boluses);

        // 2

        calcEnteral(vSingleFeeding, countFeeding);

        // 3

        calcPFCC(similac_neo_shur, enteral);

        // 4

        sodium(weight, indeedNa);

        // 5

        potassium(weight, indeedK);

        // 6

        calcium(weight, indeedC);

        //7

        magnesium(weight, indeedMg);

        // 8

        glukoza(speedOfUtil, weight);

        //9

        fateEmuls(weight, doseOfFate, fateEP, concentrationOfFateEmulsion);

        // 10

        calcAmionkislot(weight, doseOfAminokislot, proteinEP, concentrationOfAmino);

        // 11

        volumePerGlucose(generalLiquid, vEnteral, vElectolits, vFlateEmuls, vAmionkislot);

        // 12

        vnutrVeniGlukoza(doseOfGlukoza, carbohydratesEnteral);

        //13

        definitionOfVGlukoza(doseOfGlukoza, c1, v, c2);

        // 14

        infusionSpeed(generalVInfusion, doseOfGlukoza, VInfusion);

        // 15

        calcOfCalories(enteralCal, uglevodi, protein, flat, weight);



    }





}