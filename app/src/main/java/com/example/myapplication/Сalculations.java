package com.example.myapplication;

public class Сalculations {

    public static double calcLiquid(double indeed, double weight, double boluses){
        return indeed * weight - boluses;
    }

    public static double calcEnteral(double vSingleFeeding, double countFeeding){
        return vSingleFeeding * countFeeding;
    }

    public static double[] calcPFCC(Mixtures mixture, double enteral){
        double proteinEnteral = enteral * mixture.getProtein() / 100;
        double fateEnteral = enteral * mixture.getFats() / 100;
        double carbohydratesEnteral = enteral * mixture.getCarbohydrates() / 100;
        double caloriesEnteral = enteral * mixture.getCalories() / 100;

        double[] data = new double[] {proteinEnteral, fateEnteral, carbohydratesEnteral, caloriesEnteral};

        return data;
    }

    public static double sodium(double weight, double indeedNa){
        return weight * indeedNa * 0.66;
    }

    public static double potassium(double weight, double indeedK){
        return weight * indeedK * 1.85;
    }

    public static double calcium(double weight, double indeedC){
        return weight * indeedC * 4.4;
    }
    public static double magnesium(double weight, double indeedMg){
        return weight * indeedMg;
    }

    public static double glukoza(double speedOfUtil, double weight){
        return speedOfUtil * weight * 1.44;
    }

    public static double fateEmuls(double weight, double doseOfFate, double fateEP, double concentrationOfFateEmulsion){
        return (weight * doseOfFate - fateEP * 100) / concentrationOfFateEmulsion;
    }
    public static double calcAmionkislot(double weight, double doseOfAminokislot, double proteinEP, double concentrationOfAmino){
        return (weight*doseOfAminokislot-proteinEP*100)/concentrationOfAmino;
    }
    public static double volumePerGlucose(double generalLiquid, double vEnteral, double vElectolits, double vFlateEmuls, double vAmionkislot){
        return generalLiquid - vEnteral - vElectolits - vFlateEmuls - vAmionkislot;
    }
    public static double vnutrVeniGlukoza(double doseOfGlukoza, double carbohydratesEnteral){
        return  doseOfGlukoza - carbohydratesEnteral;
    }
    public static double[] definitionOfVGlukoza(double doseOfGlukoza, double c1, double v, double c2){
        double v2 = (doseOfGlukoza * 100 - c1 * v) / c2 - c1;
        double v1 = v - v2;
        double[] data = new double[] {v2, v1};
        return data;
    }
    public static double[] infusionSpeed(double generalVInfusion, double doseOfGlukoza, double VInfusion){
        double mlPerHour = generalVInfusion/24;
        double concentrationOfGlukozaInInfusionMixture = doseOfGlukoza * 100/VInfusion;
        double[] data = new double[] {mlPerHour, concentrationOfGlukozaInInfusionMixture};
        return data;
    }
    public static double[] calcOfCalories(double enteralCal, double uglevodi, double protein, double flat, double weight){
        double enteral = enteralCal * uglevodi * 3.4;
        double protein1 = protein*4;
        double flat1 = flat*9;
        double generalCal = (enteral + protein1 + flat1) / weight;
        double[] data = new double[] {enteral, protein1, flat1, generalCal};

        return data;
    }




//калий натрий кальций магний
//potassium sodium calcium magnesium
}
