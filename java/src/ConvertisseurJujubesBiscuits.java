/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convertisseurjujubesbiscuits;

import javax.swing.JOptionPane;

/**
 *
 * @author mehdibenouhoud
 */
public class ConvertisseurJujubesBiscuits {
    static boolean userIsDone = false;
    enum Snack {
        biscuits, jujubes
    }
    static String snackTypeToString(Snack snack) {
        return snack == Snack.biscuits ? "biscuits" : "jujubes";
    }
    static String snackTypeToOtherSnackString(Snack snack) {
        return snack == Snack.biscuits ? "jujubes" : "biscuits";
    }
    static float convertSnack(Snack snackType, float amount) {
        float convertedAmount = 0;
        if (snackType == Snack.biscuits) {
            convertedAmount = amount*2;
        } else if (snackType == Snack.jujubes) {
            convertedAmount = amount/2;
        }
        return convertedAmount;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String[] converterOptions = {"Biscuits -> Jujubes", "Jujubes -> Biscuits", "Quitter"};
        while (!userIsDone) {
            int userChoice = JOptionPane.showOptionDialog(null, "Choisissez un type de conversion", "Choix de conversion",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, converterOptions, null);
            Snack userSnack = null;
            switch (userChoice) {
                case 0 -> {
                    System.out.println(converterOptions[0]);
                    userSnack = Snack.biscuits;
                }
                case 1 -> { 
                    System.out.println(converterOptions[1]);
                    userSnack = Snack.jujubes;
                }
                case 2 -> {
                    System.out.println(converterOptions[2]);
                    System.exit(0);
                }
                default -> {
                }
            }
            String snackQuantity = JOptionPane.showInputDialog("Combien de " 
                    + snackTypeToString(userSnack) + " avez vous?");
            float result = convertSnack(userSnack, Float.parseFloat(snackQuantity));
            JOptionPane.showMessageDialog(null, "Cela donne " + result + " " 
                    + snackTypeToOtherSnackString(userSnack) + "!");
            
            String[] continueOptions = {"Continue", "Quit"};
            userIsDone = JOptionPane.showOptionDialog(null, "Voulez-vous continuer?", "Voulez-vous continuer?", 
                    JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, continueOptions, continueOptions[0]) == 1;
        }
        
    }
    
}
