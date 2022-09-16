package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Spinner;

import static com.example.myapplication.Сalculations.*;


public class CalcActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newcalc);
        EditText weight_view, indeed_view, boluses_view, vSingleFeeding_view,
                countFeeding_view, indeedK_view, weightSodium, indeedNa_view,
                weightPottasium_view, indeedC_view, weightCalcium_view, indeedMg_view,
                weigthMagnesium_view, speedOfUtil_view, weightGlukoza_view,
                weightVFateEmuls_view, doseOfFlate_view, concentrationOfFateEmulsion_view,
                weightAminokislot_view, doseOfAminokislot_view, proteinEP_view, concentrationOfAmino_view,
                generalLiquid_view, vEnteral_view, vElectrolits_view, vFlateEmuls_view, vAminokislot_view,
                doseOfGlukoza_view, carbohydratesEnteral_view, doseOfGlukoza2_view, c1_view, v_view,
                c2_view, V_view, V2_40_percentOfGlukoze_view, generalVInfusion_view, doseOfGlukoza3_view,
                VInfusion_view, enteralCal_view, uglevodi_view, protein_view, flat_view,
                weightCalcOfCalories_view, fateEP_view;

        Spinner mixture;
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


        indeed_view = findViewById(R.id.indeed);
        boluses_view = findViewById(R.id.boluses);
        double indeed = 1;
        double boluses = 1;


        vSingleFeeding_view = findViewById(R.id.vSingleFeeding);
        countFeeding_view = findViewById(R.id.countFeeding);
        double vSingleFeeding = 1;
        double countFeeding = 1;

        //
        double enteral = calcEnteral(vSingleFeeding, countFeeding);

        indeedNa_view = findViewById(R.id.indeedNa);
        double indeedNa = 1;

        indeedK_view = findViewById(R.id.indeedK);
        double indeedK = 1;

        indeedC_view = findViewById(R.id.indeedC);
        double indeedC = 1;

        indeedMg_view = findViewById(R.id.indeedMg);
        double indeedMg = 1;

        speedOfUtil_view = findViewById(R.id.speedOfUtil);
        double speedOfUtil = 1;

        doseOfFlate_view = findViewById(R.id.doseOfFlate);
        fateEP_view = findViewById(R.id.fateEP);
        concentrationOfFateEmulsion_view = findViewById(R.id.concentrationOfFateEmulsion);
        double doseOfFate= 1;
        double fateEP= 1;
        double concentrationOfFateEmulsion= 1;

        doseOfAminokislot_view = findViewById(R.id.doseOfAminokislot);
        proteinEP_view = findViewById(R.id.proteinEP);
        concentrationOfAmino_view = findViewById(R.id.concentrationOfAmino);
        double doseOfAminokislot = 1;
        double proteinEP = 1;
        double concentrationOfAmino = 1;

        generalLiquid_view = findViewById(R.id.generalLiquid);
        vEnteral_view = findViewById(R.id.vEnteral);
        vElectrolits_view = findViewById(R.id.vElectolits);
        vFlateEmuls_view = findViewById(R.id.vFlateEmuls);
        vAminokislot_view = findViewById(R.id.vAmionkislot);
        double generalLiquid = 1;
        double vEnteral = 1;
        double vElectolits = 1;
        double vFlateEmuls = 1;
        double vAmionkislot = 1;

        doseOfGlukoza_view = findViewById(R.id.doseOfGlukoza);
        double doseOfGlukoza = glukoza(speedOfUtil, weight);

        carbohydratesEnteral_view = findViewById(R.id.carbohydratesEnteral);
        double carbohydratesEnteral = 1;

        c1_view = findViewById(R.id.c1);
        c2_view = findViewById(R.id.c2);
        v_view = findViewById(R.id.v);
        double c1 = 1;
        double v = 1;
        double c2 = 1;

        generalVInfusion_view = findViewById(R.id.generalVInfusion);
        VInfusion_view = findViewById(R.id.VInfusion);
        double generalVInfusion = 1;
        double VInfusion = 1;

        enteralCal_view = findViewById(R.id.enteralCal);
        uglevodi_view = findViewById(R.id.uglevodi);
        protein_view = findViewById(R.id.protein);
        flat_view = findViewById(R.id.flat);
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