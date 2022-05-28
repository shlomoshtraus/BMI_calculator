/*
/ -------------------------------------------------------------------
/      This class connects the calculations in the "model" class
/      to the "view" class.
/      Realizes events to the buttons.
/ -------------------------------------------------------------------
 */

import javax.swing.*;
import java.awt.*;

public class Controller {

    public static void main(String[] args) {

        View view = new View();
        Model model = new Model();

        // Add a ActionListener to the sum button (from the view)
        view.getSum().addActionListener(e -> {

            try { // Checks if same of the important values is empty.
                if (view.getActualWeightBox() > 0 && view.getBodyFrameGroupText() != null && view.getBodyFrameGroupNumber() > 0) {
                    Color color;
                    double bmiInDouble = Double.parseDouble(model.getBmi(view.getActualWeightBox(), view.getUserHeightInMeter()));
                    String bmi = model.getBmi(view.getActualWeightBox(), view.getUserHeightInMeter());
                    String weight = model.getIdealWeight(view.getUserHeight(), view.getAgeBox(), view.getBodyFrameGroupNumber());
                    String status = model.getStatus(bmiInDouble);

                    switch (status) {
                        case "Anorexic":
                        case "Extreme Obese":
                            color = new Color(255, 0, 0);
                            view.setBmiTextColor(color);
                            break;
                        case "Underweight":
                        case "Obese":
                            color = new Color(255, 165, 0);
                            view.setBmiTextColor(color);
                            break;
                        case "Overweight":
                            color = new Color(240, 215, 0);
                            view.setBmiTextColor(color);
                            break;
                        default:
                            color = new Color(29, 183, 48);
                            view.setBmiTextColor(color);
                            break;
                    }

                    view.setResultText(bmi, status, weight);
                } else {
                    throw new NullPointerException();
                }
            }
            catch(NullPointerException ignored){
                JOptionPane.showMessageDialog(null,"Oops you forgot to fill in some detail.");
            }
        });
    }
}
