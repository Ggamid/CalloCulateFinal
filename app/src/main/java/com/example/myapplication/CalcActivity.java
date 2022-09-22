package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
import java.util.HashMap;
import java.util.Map;


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
            weightCalcOfCalories_view, fateEP_view, volumeFeedingInFact, NameCalc_view, FatherNameCalc_view,
            LastNameCalc_view, ageCalc_view;



    TextView calcLiquid_result, calcEnteral_result, calcPFCC_result, Sodium_result,
            Pottasium_result, Calcium_result, Magnesium_result, Glukoza_result, VFateEmuls_result,
            calcAmionkislot_result, volumePerGlucose_result, VnutrVeniGlukoza_result,
            definitionOfVGlukoza_result, Volume10Glukoze_result, InfusionSpeed_result,
            InfusionSpeed_result2, calcOfCalories_result;

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

    Map<String,String> resultDictionary = new HashMap<String,String>();





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newcalc);

        Bundle data = getIntent().getExtras();

        double weight = Double.parseDouble(data.get("weightChild").toString());

        String Name = data.get("Name").toString();
        String LastName = data.get("LastName").toString();
        String FatherName = data.get("FatherName").toString();
        String age = data.get("age").toString();
        String mixture = data.get("mixture").toString();

        resultDictionary.put("Name", Name);
        resultDictionary.put("LastName", LastName);
        resultDictionary.put("FatherName", FatherName);
        resultDictionary.put("age", age);
        resultDictionary.put("calcLiquid", "-");
        resultDictionary.put("calcEnteral", "-");
        resultDictionary.put("calcPFCC", "-");
        resultDictionary.put("sodium", "-");
        resultDictionary.put("potassium", "-");
        resultDictionary.put("calcium", "-");
        resultDictionary.put("magnesium", "-");
        resultDictionary.put("glukoza", "-");
        resultDictionary.put("fateEmuls", "-");
        resultDictionary.put("calcAmionkislot", "-");
        resultDictionary.put("volumePerGlucose", "-");
        resultDictionary.put("vnutrVeniGlukoza", "-");
        resultDictionary.put("definitionOfVGlukoza", "-");
        resultDictionary.put("definitionOfVGlukoza2", "-");
        resultDictionary.put("infusionSpeed", "-");
        resultDictionary.put("infusionSpeed2", "-");
        resultDictionary.put("calcOfCalories", "-");

        init();


        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        NameCalc_view = findViewById(R.id.NameCalc);
        FatherNameCalc_view = findViewById(R.id.FatherNameCalc);
        LastNameCalc_view = findViewById(R.id.LastNameCalc);
        ageCalc_view = findViewById(R.id.ageCalc);
        NameCalc_view.setText(Name);
        LastNameCalc_view.setText(LastName);
        FatherNameCalc_view.setText(FatherName);
        ageCalc_view.setText(age);



        indeed_view = findViewById(R.id.indeed);
        boluses_view = findViewById(R.id.boluses);
        weight_view = findViewById(R.id.weight);
        weight_view.setText(Double.toString(weight));


        vSingleFeeding_view = findViewById(R.id.vSingleFeeding);
        countFeeding_view = findViewById(R.id.countFeeding);



        volumeFeedingInFact = findViewById(R.id.voulumeFeedingInFacts);
        smes = findViewById(R.id.spinner);

        switch (mixture) {
            case ("Нутрилон 1 с рождения"):
                smes.setSelection(0);
                break;
            case ("Нутрилон Пре 1 (с 1800 грамм)"):
                smes.setSelection(1);
                break;
            case ("Нутрилон Пепти гастро"):
                smes.setSelection(2);
                break;
            case ("Нутрилон Пре0"):
                smes.setSelection(3);
                break;
            case ("Нутрилон Пре 1"):
                smes.setSelection(4);
                break;
            case ("Similac Premium"):
                smes.setSelection(5);
                break;
            case ("Similac NEO шур"):
                smes.setSelection(6);
                break;
            case ("Пре NAN"):
                smes.setSelection(7);
                break;
            case ("Similac Особая Забота"):
                smes.setSelection(8);
                break;
        }

        indeedNa_view = findViewById(R.id.indeedNa);
        weightSodium_view = findViewById(R.id.weightSodium);
        weightSodium_view.setText(Double.toString(weight));


        indeedK_view = findViewById(R.id.indeedK);
        weightPottasium_view = findViewById(R.id.weightPottasium);
        weightPottasium_view.setText(Double.toString(weight));

        indeedC_view = findViewById(R.id.indeedC);
        weightCalcium_view = findViewById(R.id.weightCalcium);
        weightCalcium_view.setText(Double.toString(weight));

        indeedMg_view = findViewById(R.id.indeedMg);
        weigthMagnesium_view = findViewById(R.id.weightMagnesium);
        weigthMagnesium_view.setText(Double.toString(weight));



        speedOfUtil_view = findViewById(R.id.speedOfUtil);
        weightGlukoza_view = findViewById(R.id.weightGlukoza);
        weightGlukoza_view.setText(Double.toString(weight));
        weightVFateEmuls_view = findViewById(R.id.weightVFateEmuls);
        weightVFateEmuls_view.setText(Double.toString(weight));


        doseOfFlate_view = findViewById(R.id.doseOfFlate);
        fateEP_view = findViewById(R.id.fateEP);
        concentrationOfFateEmulsion_view = findViewById(R.id.concentrationOfFateEmulsion);
        weightAminokislot_view = findViewById(R.id.weightAmionkislot);
        weightAminokislot_view.setText(Double.toString(weight));


        doseOfAminokislot_view = findViewById(R.id.doseOfAminokislot);
        proteinEP_view = findViewById(R.id.proteinEP);
        concentrationOfAmino_view = findViewById(R.id.concentrationOfAmino);



        generalLiquid_view = findViewById(R.id.generalLiquid);
        vEnteral_view = findViewById(R.id.vEnteral);
        vElectrolits_view = findViewById(R.id.vElectolits);
        vFlateEmuls_view = findViewById(R.id.vFlateEmuls);
        vAminokislot_view = findViewById(R.id.vAmionkislot);


        doseOfGlukoza_view = findViewById(R.id.doseOfGlukoza);

        doseOfGlukoza2_view = findViewById(R.id.doseOfGlukoza2);
        doseOfGlukoza3_view = findViewById(R.id.doseOfGlukoza3);

        carbohydratesEnteral_view = findViewById(R.id.carbohydratesEnteral);

        c1_view = findViewById(R.id.c1);
        c2_view = findViewById(R.id.c2);
        v_view = findViewById(R.id.v);
        V_view = findViewById(R.id.V);
        V2_40_percentOfGlukoze_view = findViewById(R.id.V2_40_percentOfGlukoze);


        generalVInfusion_view = findViewById(R.id.generalVInfusion);
        VInfusion_view = findViewById(R.id.VInfusion);

        weightCalcOfCalories_view = findViewById(R.id.weightCalcOfCalories);
        enteralCal_view = findViewById(R.id.enteralCal);
        uglevodi_view = findViewById(R.id.uglevodi);
        protein_view = findViewById(R.id.protein);
        flat_view = findViewById(R.id.flat);


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
        VnutrVeniGlukoza_result  = findViewById(R.id.VnutrVeniGlukoza_result);
        definitionOfVGlukoza_result = findViewById(R.id.definitionOfVGlukoza_result);
        Volume10Glukoze_result = findViewById(R.id.Volume10Glukoze_result);
        InfusionSpeed_result = findViewById(R.id.InfusionSpeed_result);
        InfusionSpeed_result2 = findViewById(R.id.InfusionSpeed_result2);
        calcOfCalories_result = findViewById(R.id.calcOfCalories_result);
    }
    //0
    public void confirm_btn(View view) {

        if (!LastNameCalc_view.getText().toString().equals("") && !NameCalc_view.getText().toString().equals("")
                && !FatherNameCalc_view.getText().toString().equals("") && !ageCalc_view.getText().toString().equals("")) {

            String Name = NameCalc_view.getText().toString();
            String LastName = LastNameCalc_view.getText().toString();
            String FatherName = FatherNameCalc_view.getText().toString();
            String age = ageCalc_view.getText().toString();

            resultDictionary.put("Name", Name);
            resultDictionary.put("LastName", LastName);
            resultDictionary.put("FatherName", FatherName);
            resultDictionary.put("age", age);

        } else {
            Toast.makeText(getApplicationContext(), "Заполните все поля пункта Данные ребенка", Toast.LENGTH_SHORT).show();
        }
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

            resultDictionary.put("calcLiquid", result + " мл");

        }
        else {
            Toast.makeText(getApplicationContext(), "Заполните все поля пункта 1.1", Toast.LENGTH_SHORT).show();
        }
    }

    //2.1
    public void calcEnteral_btn(View view){
        DecimalFormat decimalFormat = new DecimalFormat( "#.###" );


        if (!vSingleFeeding_view.getText().toString().equals("") && !countFeeding_view.getText().toString().equals("")){

            double vSingleFeeding = Double.parseDouble(vSingleFeeding_view.getText().toString());
            double countFeeding = Double.parseDouble(countFeeding_view.getText().toString());

            String result = decimalFormat.format(calcEnteral(vSingleFeeding, countFeeding));

            calcEnteral_result.setText(result);

            resultDictionary.put("calcEnteral", result + " мл");


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

            String result = "Углеводов энетерально = " + decimalFormat.format(result_double[0]) + "гр" + "\n" +
                    "Белка энетерально = " + decimalFormat.format(result_double[1]) + "гр" + "\n" +
                    "Жира энетерально = " + decimalFormat.format(result_double[2]) + "гр" + "\n" +
                    "Калорий энетерально = " + decimalFormat.format(result_double[3]) + "ккал"
                    ;
            calcPFCC_result.setText(result);

            resultDictionary.put("calcPFCC", result);



        }

        else {
            Toast.makeText(getApplicationContext(), "Заполните все поля пункта 2.2", Toast.LENGTH_SHORT).show();
        }
    }

    public void sodiumCalc(View view){

        DecimalFormat decimalFormat = new DecimalFormat( "#.###" );

        if (!indeedNa_view.getText().toString().equals("") && !weightSodium_view.getText().toString().equals("")){


            double indeedNa = Double.parseDouble(indeedNa_view.getText().toString());
            double weightSodium = Double.parseDouble(weightSodium_view.getText().toString());

            String result = decimalFormat.format(sodium(weightSodium, indeedNa));

            Sodium_result.setText(result);
            resultDictionary.put("sodium", result + " мл");


        }
        else {
            Toast.makeText(getApplicationContext(), "Заполните все поля пункта 3.1", Toast.LENGTH_SHORT).show();
        }
    }

    public void calcPottasium(View view){

        DecimalFormat decimalFormat = new DecimalFormat( "#.###" );


        if (!indeedK_view.getText().toString().equals("") && !weightPottasium_view.getText().toString().equals("")){


            double indeedK = Double.parseDouble(indeedK_view.getText().toString());
            double weightPottasium = Double.parseDouble(weightPottasium_view.getText().toString());

            String result = decimalFormat.format(potassium(indeedK, weightPottasium));

            Pottasium_result.setText(result);

            resultDictionary.put("potassium", result + " мл");


        }
        else {
            Toast.makeText(getApplicationContext(), "Заполните все поля пункта 3.2", Toast.LENGTH_SHORT).show();
        }
    }

    public void calcCalcium(View view){

        DecimalFormat decimalFormat = new DecimalFormat( "#.###" );


        if (!indeedC_view.getText().toString().equals("") && !weightCalcium_view.getText().toString().equals("")){


            double indeedC = Double.parseDouble(indeedC_view.getText().toString());
            double weightCalcium = Double.parseDouble(weightCalcium_view.getText().toString());

            String result = decimalFormat.format(calcium(indeedC, weightCalcium));

            Calcium_result.setText(result);

            resultDictionary.put("calcium", result + " мл");


        }
        else {
            Toast.makeText(getApplicationContext(), "Заполните все поля пункта 3.3", Toast.LENGTH_SHORT).show();
        }
    }

    public void calcMagnesium(View view){

        DecimalFormat decimalFormat = new DecimalFormat( "#.###" );


        if (!indeedMg_view.getText().toString().equals("") && !weigthMagnesium_view.getText().toString().equals("")){


            double indeedMg = Double.parseDouble(indeedMg_view.getText().toString());
            double weightMagnesium = Double.parseDouble(weigthMagnesium_view.getText().toString());

            String result = decimalFormat.format(magnesium(indeedMg, weightMagnesium));

            Magnesium_result.setText(result);

            resultDictionary.put("magnesium", result + " мл");


        }
        else {
            Toast.makeText(getApplicationContext(), "Заполните все поля пункта 3.4", Toast.LENGTH_SHORT).show();
        }
    }

    public void calcGlukoza(View view){

        DecimalFormat decimalFormat = new DecimalFormat( "#.###" );


        if (!speedOfUtil_view.getText().toString().equals("") && !weightGlukoza_view.getText().toString().equals("")){


            double speedOfUtil = Double.parseDouble(speedOfUtil_view.getText().toString());
            double weightGlukoza = Double.parseDouble(weightGlukoza_view.getText().toString());

            String result = decimalFormat.format(glukoza(speedOfUtil, weightGlukoza));

            Glukoza_result.setText(result);
            doseOfGlukoza_view.setText(result);
            doseOfGlukoza2_view.setText(result);
            doseOfGlukoza3_view.setText(result);

            resultDictionary.put("glukoza", result + " г/сут");


        }
        else {
            Toast.makeText(getApplicationContext(), "Заполните все поля пункта 4.1", Toast.LENGTH_SHORT).show();
        }
    }

//    5.1

    public void calcFateEmuls(View view){

        DecimalFormat decimalFormat = new DecimalFormat( "#.###" );


        if (!weightVFateEmuls_view.getText().toString().equals("") && !doseOfFlate_view.getText().toString().equals("")
                && !fateEP_view.getText().toString().equals("") && !concentrationOfFateEmulsion_view.getText().toString().equals("")){


            double weightVFateEmuls = Double.parseDouble(weightVFateEmuls_view.getText().toString());
            double doseOfFate= Double.parseDouble(doseOfFlate_view.getText().toString());
            double fateEP = Double.parseDouble(fateEP_view.getText().toString());
            double concentrationOfFateEmulsion = Double.parseDouble(concentrationOfFateEmulsion_view.getText().toString());

            String result = decimalFormat.format(fateEmuls(weightVFateEmuls,doseOfFate,fateEP,concentrationOfFateEmulsion));

            VFateEmuls_result.setText(result);
            resultDictionary.put("fateEmuls", result + " мл");


        }
        else {
            Toast.makeText(getApplicationContext(), "Заполните все поля пункта 5.1", Toast.LENGTH_SHORT).show();
        }
    }

// 6.1

    //        calcAmionkislot(weight, doseOfAminokislot, proteinEP, concentrationOfAmino);

    public void calcAminokislot(View view){

        DecimalFormat decimalFormat = new DecimalFormat( "#.###" );


        if (!weightAminokislot_view.getText().toString().equals("") && !doseOfAminokislot_view.getText().toString().equals("")
                && !protein_view.getText().toString().equals("") && !concentrationOfAmino_view.getText().toString().equals("")){


            double weightAminokislot = Double.parseDouble(weightAminokislot_view.getText().toString());
            double doseOfAminokislot= Double.parseDouble(doseOfAminokislot_view.getText().toString());
            double protein = Double.parseDouble(protein_view.getText().toString());
            double concentrationOfAmino = Double.parseDouble(concentrationOfAmino_view.getText().toString());

            String result = decimalFormat.format(calcAmionkislot(weightAminokislot,doseOfAminokislot,protein,concentrationOfAmino));

            calcAmionkislot_result.setText(result);
            resultDictionary.put("calcAmionkislot", result + " мл");


        }
        else {
            Toast.makeText(getApplicationContext(), "Заполните все поля пункта 6.1", Toast.LENGTH_SHORT).show();
        }
    }
    //7.1
    //        volumePerGlucose(generalLiquid, vEnteral, vElectolits, vFlateEmuls, vAmionkislot);

    public void calcVolumePerGLucose(View view){

        DecimalFormat decimalFormat = new DecimalFormat( "#.###" );


        if (!generalLiquid_view.getText().toString().equals("") && !vEnteral_view.getText().toString().equals("")
                && !vElectrolits_view.getText().toString().equals("") && !vFlateEmuls_view.getText().toString().equals("")
                && !vAminokislot_view.getText().toString().equals("")){


            double generalLiquid = Double.parseDouble(generalLiquid_view.getText().toString());
            double vEnteral= Double.parseDouble(vEnteral_view.getText().toString());
            double vElectrolits = Double.parseDouble(vElectrolits_view.getText().toString());
            double vFlateEmuls = Double.parseDouble(vFlateEmuls_view.getText().toString());
            double vAminokislot = Double.parseDouble(vAminokislot_view.getText().toString());

            String result = decimalFormat.format(volumePerGlucose(generalLiquid,vEnteral,vElectrolits,vFlateEmuls,vAminokislot));

            volumePerGlucose_result.setText(result);

            resultDictionary.put("volumePerGlucose", result + " мл");


        }
        else {
            Toast.makeText(getApplicationContext(), "Заполните все поля пункта 7.1", Toast.LENGTH_SHORT).show();
        }
    }

    // 7.2
//        vnutrVeniGlukoza(doseOfGlukoza, carbohydratesEnteral);

    public void calcVnutrVeni(View view){

        DecimalFormat decimalFormat = new DecimalFormat( "#.###" );


        if (!doseOfGlukoza_view.getText().toString().equals("") && !carbohydratesEnteral_view.getText().toString().equals("")){


            double doseOfGlukoza = Double.parseDouble(doseOfGlukoza_view.getText().toString());
            double carbohydrates= Double.parseDouble(carbohydratesEnteral_view.getText().toString());


            String result = decimalFormat.format(vnutrVeniGlukoza(doseOfGlukoza, carbohydrates));

            VnutrVeniGlukoza_result.setText(result);

            resultDictionary.put("vnutrVeniGlukoza", result + " мл");


        }
        else {
            Toast.makeText(getApplicationContext(), "Заполните все поля пункта 7.2", Toast.LENGTH_SHORT).show();
        }
    }


    //8.1

    public void calcDefinitionOfGlukoza(View view){

        DecimalFormat decimalFormat = new DecimalFormat( "#.###" );


        if (!doseOfGlukoza2_view.getText().toString().equals("") && !c1_view.getText().toString().equals("")
                && !v_view.getText().toString().equals("") && !c2_view.getText().toString().equals("")){


            double doseOfGlukoza = Double.parseDouble(doseOfGlukoza2_view.getText().toString());
            double c1 = Double.parseDouble(c1_view.getText().toString());
            double v = Double.parseDouble(v_view.getText().toString());
            double c2 = Double.parseDouble(c2_view.getText().toString());



            String result = decimalFormat.format(definitionOfVGlukoza(doseOfGlukoza, c1, v, c2)[0]);

            definitionOfVGlukoza_result.setText(result);

            V_view.setText(v_view.getText().toString());
            V2_40_percentOfGlukoze_view.setText(result);

            resultDictionary.put("definitionOfVGlukoza", result + " мл 40% глюкозы");



        }
        else {
            Toast.makeText(getApplicationContext(), "Заполните все поля пункта 8.1", Toast.LENGTH_SHORT).show();
        }
    }

    //8.2


    public void calcVolume10Glukoze(View view){

        DecimalFormat decimalFormat = new DecimalFormat( "#.###" );


        if (!V_view.getText().toString().equals("") && !V2_40_percentOfGlukoze_view.getText().toString().equals("")){


            double V = Double.parseDouble(V_view.getText().toString());
            double V2_40_percentOfGlukoza = Double.parseDouble(V2_40_percentOfGlukoze_view.getText().toString());


            double result_double = V - V2_40_percentOfGlukoza;
            String result = decimalFormat.format(result_double);

            Volume10Glukoze_result.setText(result);

            resultDictionary.put("definitionOfVGlukoza2", result + " мл 10% глюкозы");


        }
        else {
            Toast.makeText(getApplicationContext(), "Заполните все поля пункта 8.2", Toast.LENGTH_SHORT).show();
        }
    }

    // 9.1

    public void calcInfusionSpeed(View view){

        DecimalFormat decimalFormat = new DecimalFormat( "#.###" );


        if (!generalVInfusion_view.getText().toString().equals("") && !doseOfGlukoza3_view.getText().toString().equals("")
                && !VInfusion_view.getText().toString().equals("")){


            double generalVInfusion = Double.parseDouble(generalVInfusion_view.getText().toString());
            double doseOfGlukoza = Double.parseDouble(doseOfGlukoza3_view .getText().toString());
            double VInfusion = Double.parseDouble(VInfusion_view.getText().toString());



            String result = decimalFormat.format(infusionSpeed(generalVInfusion, doseOfGlukoza, VInfusion)[0]);
            String result2 = decimalFormat.format(infusionSpeed(generalVInfusion, doseOfGlukoza, VInfusion)[1]);

            InfusionSpeed_result.setText(result);
            InfusionSpeed_result2.setText(result2);

            resultDictionary.put("infusionSpeed", result + " мл/час");
            resultDictionary.put("infusionSpeed2", result2 + " % раствор глюкозы");


        }
        else {
            Toast.makeText(getApplicationContext(), "Заполните все поля пункта 9.1", Toast.LENGTH_SHORT).show();
        }
    }

    // 10.1 calcOfCalories
//        calcOfCalories(enteralCal, uglevodi, protein, flat, weight);

    public void calcOfCalories_btnLast(View view){

        DecimalFormat decimalFormat = new DecimalFormat( "#.###" );


        if (!enteralCal_view.getText().toString().equals("") && !uglevodi_view.getText().toString().equals("")
                && !protein_view.getText().toString().equals("") && !flat_view.getText().toString().equals("")
                && !weightCalcOfCalories_view.getText().toString().equals("")){


            double enteralCal = Double.parseDouble(enteralCal_view.getText().toString());
            double uglevodi = Double.parseDouble(uglevodi_view.getText().toString());
            double protein = Double.parseDouble(protein_view.getText().toString());
            double flat = Double.parseDouble(flat_view.getText().toString());
            double weight = Double.parseDouble(weightCalcOfCalories_view.getText().toString());


            double [] result_double= calcOfCalories(enteralCal, uglevodi, protein, flat, weight);
            String result = "Энтеральных = " + decimalFormat.format(result_double[0]) + "\n" +
                    "Белки = " + decimalFormat.format(result_double[1]) + "\n" +
                    "Жиры = " + decimalFormat.format(result_double[2]) + "\n" +
                    "Всего ккал = " + decimalFormat.format(result_double[3]) + "\n"
                    ;
            calcOfCalories_result.setText(result);

            resultDictionary.put("calcOfCalories", result);


        }
        else {
            Toast.makeText(getApplicationContext(), "Заполните все поля пункта 10.1", Toast.LENGTH_SHORT).show();
        }
    }

    public void checkResult(View view){

        String generalInfo = "ФИО: " + resultDictionary.get("LastName")+ " " +resultDictionary.get("Name") + " " + resultDictionary.get("FatherName") +"\n"
                + "Возраст в сутках: " + resultDictionary.get("age")+"\n";

        String strResult =
                    "1. Расчет общего количества жидкости"+"\n"
                + "Суточная потребность (СПЖ): " + resultDictionary.get("calcLiquid")+"\n"+"\n"
                    + "2. Расчет энтерального питания"+"\n"
                + "Объем питания фактический: " + resultDictionary.get("calcEnteral")+"\n"
                + "" + resultDictionary.get("calcPFCC")+"\n"+"\n"
                    + "3. Расчет необходимого кол-ва электролитов" +"\n"
                + "V NaCL 10% раствор: " + resultDictionary.get("sodium")+"\n"
                + "V (мл) 4% KCL: " + resultDictionary.get("potassium")+"\n"
                + "V (мл 10% Ca Глюконат): " + resultDictionary.get("calcium")+"\n"
                + "V (мл 25% MgSO4): " + resultDictionary.get("magnesium")+"\n"+"\n"
                            + "4. Расчет дозы глюкозы, исходя из скорости утилизации"+"\n"
                + "Доза глюкозы (г/сут): " + resultDictionary.get("glukoza")+"\n"+"\n"
                            + "5. Расчет объема жировой эмульсии"+"\n"
                + "V жировой эмульсии: " + resultDictionary.get("fateEmuls")+"\n"+"\n"
                            + "6. расчет необходимой дозы аминокислот"+"\n"
                + "V аминокислот: " + resultDictionary.get("calcAmionkislot")+"\n"+"\n"
                            + "7. определение объема приходящегося на глюкозу"+"\n"
                + "V глюкозы: " + resultDictionary.get("volumePerGlucose")+"\n"
                + "Глюкоза в/в: " + resultDictionary.get("vnutrVeniGlukoza")+"\n"+"\n"
                            + "8. Подбор необходимого объема глюкозы различных концентраций"+"\n"
                + "V2 (объем 40% глюкозы): " + resultDictionary.get("definitionOfVGlukoza")+"\n"
                + "V1 (объем 10% глюкозы): " + resultDictionary.get("definitionOfVGlukoza2")+"\n"+"\n"
                            + "9. скорость инфузии составит"+"\n"
                + "Скорость инфузии: " + resultDictionary.get("infusionSpeed")+"\n"
                + "Концентрация глюкозы в инфуз. растворе (C1%): " + "\n" + resultDictionary.get("infusionSpeed2")+"\n"+"\n"
                + "10. Расчет суточного каллоража: " + "\n" + resultDictionary.get("calcOfCalories")+"\n"

                ;


        Intent intent = new Intent(CalcActivity.this, Result.class);
        intent.putExtra("ResultList", strResult);
        intent.putExtra("generalInfo", generalInfo);
        startActivity(intent);

    }

}