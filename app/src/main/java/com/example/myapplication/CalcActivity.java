package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.myapplication.Сalculations.*;

import java.text.DecimalFormat;


public class CalcActivity extends AppCompatActivity {

    EditText weight_view, indeed_view, boluses_view, vSingleFeeding_view,
            countFeeding_view, indeedK_view, weightSodium_view, indeedNa_view,
            weightPottasium_view, indeedC_view, weightCalcium_view, indeedMg_view,
            weigthMagnesium_view, speedOfUtil_view, weightGlukoza_view,
            weightVFateEmuls_view, doseOfFlate_view, concentrationOfFateEmulsion_view,
            weightAminokislot_view, doseOfAminokislot_view, proteinEP_view, concentrationOfAmino_view,
            generalLiquid_view, vEnteral_view, vElectrolits_view, vFlateEmuls_view, vAminokislot_view,
            doseOfGlukoza_view, carbohydratesEnteral_view, doseOfGlukoza2_view, c1_view, v_view,
            c2_view, V_view, V2_40_percentOfGlukoze_view, generalVInfusion_view, doseOfGlukoza3_view,
            VInfusion_view, enteralCal_view, uglevodi_view, protein_view, flat_view,
            weightCalcOfCalories_view, fateEP_view, volumeFeedingInFact;



    TextView calcLiquid_result, calcEnteral_result, calcPFCC_result, Sodium_result,
            Pottasium_result, Calcium_result, Magnesium_result, Glukoza_result, VFateEmuls_result,
            calcAmionkislot_result, volumePerGlucose_result, VnutrVeniGlukoza_result,
            definitionOfVGlukoza_result, Volume10Glukoze_result, InfusionSpeed_result,
            InfusionSpeed_result2;

    Mixtures nutrilon_from_birth = new Mixtures(1.3,3.4, 7.3, 66);
    Mixtures nutrilon_pre1_1800gramm = new Mixtures(2.0, 3.9,7.4,74);
    Mixtures nutrilon_pepti_gastro = new Mixtures(1.8,3.4, 7.0, 66);
    Mixtures nutrilon_pre0 = new Mixtures(2.6,3.8,8.3,79);
    Mixtures nutrilon_pre1 = new Mixtures(2.2,4.4,8.0, 123);
    Mixtures similac_premium = new Mixtures(1.33,3.3,7.35,64);
    Mixtures similac_neo_shur = new Mixtures(1.9,4.1,7.7,74);
    Mixtures pre_nan = new Mixtures(2.32,4.2,8.57,80);
    Mixtures similac_special_care = new Mixtures(2.67,4.35,8.10,82);





    Spinner smes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newcalc);

        init();


        Spinner mixture;
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // add mixtures



        // common values


        Bundle data = getIntent().getExtras();

        double weight = Integer.parseInt(data.get("weightChild").toString());







        indeed_view = findViewById(R.id.indeed);
        boluses_view = findViewById(R.id.boluses);
        weight_view = findViewById(R.id.weight);
        weight_view.setText(Double.toString(weight));




        vSingleFeeding_view = findViewById(R.id.vSingleFeeding);
        countFeeding_view = findViewById(R.id.countFeeding);


        //
        volumeFeedingInFact = findViewById(R.id.voulumeFeedingInFacts);
        smes = findViewById(R.id.spinner);
//        double enteral = calcEnteral(vSingleFeeding, countFeeding);

        indeedNa_view = findViewById(R.id.indeedNa);
        weightSodium_view = findViewById(R.id.weightSodium);
        weightSodium_view.setText(Double.toString(weight));
//        double indeedNa = 1;


        indeedK_view = findViewById(R.id.indeedK);
        weightPottasium_view = findViewById(R.id.weightPottasium);
        weightPottasium_view.setText(Double.toString(weight));
        double indeedK = 1;

        indeedC_view = findViewById(R.id.indeedC);
        weightCalcium_view = findViewById(R.id.weightCalcium);
        weightCalcium_view.setText(Double.toString(weight));
        double indeedC = 1;

        indeedMg_view = findViewById(R.id.indeedMg);
        weigthMagnesium_view = findViewById(R.id.weightMagnesium);
        weigthMagnesium_view.setText(Double.toString(weight));

        double indeedMg = 1;


        speedOfUtil_view = findViewById(R.id.speedOfUtil);
        weightGlukoza_view = findViewById(R.id.weightGlukoza);
        weightGlukoza_view.setText(Double.toString(weight));
        weightVFateEmuls_view = findViewById(R.id.weightVFateEmuls);
        weightVFateEmuls_view.setText(Double.toString(weight));

        double speedOfUtil = 1;

        doseOfFlate_view = findViewById(R.id.doseOfFlate);
        fateEP_view = findViewById(R.id.fateEP);
        concentrationOfFateEmulsion_view = findViewById(R.id.concentrationOfFateEmulsion);
        weightAminokislot_view = findViewById(R.id.weightAmionkislot);
        weightAminokislot_view.setText(Double.toString(weight));

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



        // 3

//        calcPFCC(similac_neo_sh, enteral);

        // 4

//        sodium(weight, indeedNa);

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

    public void init(){
        calcLiquid_result = findViewById(R.id.calcLiquid_result);
        calcEnteral_result = findViewById(R.id.calcEnteral_result);
        calcPFCC_result = findViewById(R.id.calcPFCC_result);
        Sodium_result = findViewById(R.id.Sodium_result);
        Pottasium_result = findViewById(R.id.Pottasium_result);
        Calcium_result = findViewById(R.id.Calcium_result);
        Magnesium_result = findViewById(R.id.Magnesium_result);
        Glukoza_result = findViewById(R.id.Glukoza_result);
        VFateEmuls_result = findViewById(R.id.VFateEmuls_result);
        calcAmionkislot_result = findViewById(R.id.calcAmionkislot_result);
        volumePerGlucose_result  = findViewById(R.id.volumePerGlucose_result);
        VnutrVeniGlukoza_result  = findViewById(R.id.textVnutrVeniGlukoza);
        definitionOfVGlukoza_result = findViewById(R.id.definitionOfVGlukoza_result);
        Volume10Glukoze_result = findViewById(R.id.Volume10Glukoze_result);
        InfusionSpeed_result = findViewById(R.id.InfusionSpeed_result);
        InfusionSpeed_result2 = findViewById(R.id.InfusionSpeed_result2);
    }

    //1

    public void calcLiquid_btn(View view){

        if (!indeed_view.getText().toString().equals("") && !boluses_view.getText().toString().equals("")
                && !weight_view.getText().toString().equals("")){
        double indeed = Double.parseDouble(indeed_view.getText().toString());
        double boluses = Double.parseDouble(boluses_view.getText().toString());
        double weight = Double.parseDouble(weight_view.getText().toString());
        double result_double = calcLiquid(indeed, weight, boluses);
        String result = Double.toString(result_double);
        calcLiquid_result.setText(result);

        }
        else {
            Toast.makeText(getApplicationContext(), "Заполните все поля пункта 1.1", Toast.LENGTH_SHORT).show();
        }
    }

    //2.1
    public void calcEnteral_btn(View view){

        if (!vSingleFeeding_view.getText().toString().equals("") && !countFeeding_view.getText().toString().equals("")){

            double vSingleFeeding = Double.parseDouble(vSingleFeeding_view.getText().toString());
            double countFeeding = Double.parseDouble(countFeeding_view.getText().toString());

            double result_double = calcEnteral(vSingleFeeding, countFeeding);;
            String result = Double.toString(result_double);

            calcEnteral_result.setText(result);

        }
        else {
            Toast.makeText(getApplicationContext(), "Заполните все поля пункта 2.1", Toast.LENGTH_SHORT).show();
        }
    }
    //2.2
    public void calcPFCC_btn(View view){

        if (!volumeFeedingInFact.getText().toString().equals("")){


            DecimalFormat decimalFormat = new DecimalFormat( "#.###" );

            String mixture = smes.getSelectedItem().toString();
            double voulumeFeedingInFacts_var = Double.parseDouble(volumeFeedingInFact.getText().toString());
            double [] result_double = new double[2];

            switch (mixture) {
                case  ("Нутрилон 1 с рождения"): result_double = calcPFCC(nutrilon_from_birth, voulumeFeedingInFacts_var);
                break;
                case ("Нутрилон Пре 1 (с 1800 грамм)"): result_double = calcPFCC(nutrilon_pre1_1800gramm, voulumeFeedingInFacts_var);
                break;
                case ("Нутрилон Пепти гастро"): result_double = calcPFCC(nutrilon_pepti_gastro, voulumeFeedingInFacts_var);
                break;
                case ("Нутрилон Пре0"): result_double = calcPFCC(nutrilon_pre0, voulumeFeedingInFacts_var);
                break;
                case ("Нутрилон Пре 1"): result_double = calcPFCC(nutrilon_pre1, voulumeFeedingInFacts_var);
                break;
                case ("Similac Premium"): result_double = calcPFCC(similac_premium, voulumeFeedingInFacts_var);
                break;
                case ("Similac NEO шур"): result_double = calcPFCC(similac_neo_shur, voulumeFeedingInFacts_var);
                break;
                case ("Пре NAN"): result_double = calcPFCC(pre_nan, voulumeFeedingInFacts_var);
                break;
                case ("Similac Особая Забота"): result_double = calcPFCC(similac_special_care, voulumeFeedingInFacts_var);
                break;
            }

            String result = "Углеводов энетерально = " + decimalFormat.format(result_double[0]) + "\n" +
                    "Белка энетерально = " + decimalFormat.format(result_double[1]) + "\n" +
                    "Жира энетерально = " + decimalFormat.format(result_double[2]) + "\n" +
                    "Калорий энетерально = " + decimalFormat.format(result_double[3]) + "\n"
                    ;
            calcPFCC_result.setText(result);
        }

        else {
            Toast.makeText(getApplicationContext(), "Заполните все поля пункта 2.2", Toast.LENGTH_SHORT).show();
        }
    }

    public void sodiumCalc(View view){

        if (!indeedNa_view.getText().toString().equals("") && !weightSodium_view.getText().toString().equals("")){


            double indeedNa = Double.parseDouble(indeedNa_view.getText().toString());
            double weightSodium = Double.parseDouble(weightSodium_view.getText().toString());

            double result_double = sodium(weightSodium, indeedNa);
            String result = Double.toString(result_double);

            Sodium_result.setText(result);

        }
        else {
            Toast.makeText(getApplicationContext(), "Заполните все поля пункта 2.1", Toast.LENGTH_SHORT).show();
        }
    }






}