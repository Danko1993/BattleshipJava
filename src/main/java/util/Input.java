package util;

import java.util.ArrayList;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

/**
 * The class uses to get data from user input.
 */
public class Input {
    /**
     * The data insert by user.
     */
    private String userInput;
    private int numberInCordinates;
    private int numberFromLetter;
    private String letters ="ABCDEFGHIJ";
    ArrayList<Integer> cord;
    Display display = new Display();

    Random random= new Random();


    Scanner scaner;

    {
        scaner = new Scanner(System.in);
    }
    public String getUserInput() {
        return userInput;
    }

    public void setUserInput(String userInput) {
        this.userInput = userInput;
    }
    /**
     * Returns the value given by user.
     */
    public String text(){
        setUserInput(scaner.next());
        return getUserInput();
    }
    /**
     * Convert coordinates, which user input and return like [x,y].
     */

    private ArrayList<Integer> convert(String coordinates){
        ArrayList<Integer> cord = new ArrayList<>();
        numberInCordinates = Integer.parseInt(coordinates.substring(1));
        numberFromLetter = convertLetterToInt(coordinates.substring(0,1).toUpperCase());
        cord.add(numberInCordinates-1);
        cord.add(numberFromLetter);
        return cord;
    }
    /**
     * Convert letter to number in coordinates, which user input.
     */
    private int convertLetterToInt(String letter){
        return letters.indexOf(letter);}
    /**
     * Check if input user parameters are valid.
     */
    private boolean isValidationInputCords(String cords) {

        if ((letters.contains(cords.substring(0, 1).toUpperCase())&&isStringIsNumber(cords))&&
                ((cords.length() == 2 && Integer.parseInt(cords.substring(1, 2)) > 0) ||
                        (cords.length() == 3 && Integer.parseInt(cords.substring(1, 3)) == 10))){
            return true;
        }
        else{return false;}
    }
    /**
     * Return valid coordinates input by user.
     */
    public ArrayList<Integer> properlyCoordinates(){
        boolean flag = true;
        while(flag){
            userInput = text();
            if (isValidationInputCords(userInput)){
                cord = convert(userInput);
                flag = false;

            }
            else{display.printString("Please input valid coordinates");}
        }
        return cord;
    }
    private boolean isStringIsNumber(String value){
        try{
            Integer.parseInt(value.substring(1));
            return true;
        }
        catch (Exception e){return false;}
    }

    /**
     * Pauses game until enter key is entered
     */
    public void pressEnterToContinue()
    {
        display.printString("Next Player please press Enter key ...");
        try
        {
            System.in.read();
        }
        catch(Exception e)
        {}
    }

    /**
     * Used to make decisions which require answer Yes/No
     * @param string question how to set some parameter in a game
     * @return true for Yes false for No
     */
    public boolean isTrue(String string){
        String answer = new String();
        while (answer.equals("")){
            display.printString(string);
            String input = text();
            if(input.equals("Y") || input.equals("N") ){
                answer=input;
                break;
            }else {display.printString("Please insert correct input\n");}
        }
        if (answer.equals("Y")){
            return true;
        }else {
            return false;
        }
    }

    /**
     * Is randomly getting coordinates for automatic placement
     * @return cord to initialize boat placement
     */
    public ArrayList<Integer> initRandomCords(){
        ArrayList<Integer> cords = new ArrayList<>();
        cords.add(random.nextInt(0,10));
        cords.add(random.nextInt(0,10));
        return cords;
    }

    /**
     * Randomly decides if ship is oriented horizontally or not
     * @return true if ship is oriented horizontally false if not
     */
    public boolean initRandomHorizontal(){
        int randomint =random.nextInt(0,2);
        if (randomint==1) return true;
        else return false;
    }
    public String menuInput(Map<String,String> menu){
        String choise;
        while(true){
            display.printMenu(menu);
            choise=text();
            for (String key: menu.keySet()) {
                if (choise.equals(key)) {

                    return choise;
                 }
                }
        }
    }

}