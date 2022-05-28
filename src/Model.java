/*
/ ------------------------------------------------
/     This class contains all the formulas
/     that will come into use in the program.
/ ------------------------------------------------
 */

import java.text.DecimalFormat;

import static java.lang.Math.pow;

public class Model {

    // This method uses a formula for calculating BMI
    // and calculates it based on the input.
    public String getBmi(double weight, double height) {

        return (new DecimalFormat("##.###").format(weight/pow(height,2)));
    }

    // This method uses the formula for calculating the Ideal Weight
    // and calculates it according to the input.
    public String getIdealWeight(double height, int age, double slimness) {
        return new DecimalFormat("##.###").format((height - 100.0 + (age / 10.0)) * 0.9 * slimness);
    }

    // This method returns the status
    // according to the calculation of the BMI.
    public String getStatus(double bmi) {

        String status = "";
        if (bmi < 15)
            status += "Anorexic";
        else if (15 < bmi && bmi < 18.5)
            status += "Underweight";
        else if (18.5 < bmi && bmi < 24.9)
            status += "Normal";
        else if (25.0 < bmi && bmi < 29.9)
            status += "Overweight";
        else if (30 < bmi && bmi < 35)
            status += "Obese";
        else
            status += "Extreme Obese";

        return status;
    }

}