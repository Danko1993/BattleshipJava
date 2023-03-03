package game;

import util.Display;
import util.Input;

import java.util.HashMap;
import java.util.Map;

public class Menu {
    Display display = new Display();
    Input input = new Input();

    Map<String,String> mainMenu= new HashMap<String,String>();
    public String choise;
    public void menu(){
        mainMenu.put("0","-Exit game\n");
        mainMenu.put("2","-Credits\n");
        mainMenu.put("1","-New game\n");
        while(true){
            choise = input.menuInput(mainMenu);
            if(choise.equals("1")){
                Game game = new Game();
                game.start();
            }if (choise.equals("2")){
                display.clearConsole();
                display.printString("RK Entertainment team:" +
                        "\nMarcin Rasala - CEO" +
                        "\nDaniel Kosk- senior MS Paint operative\n" +
                        "Special thanks to MS Paint \n\n");
            } if (choise.equals("0")){break;}

        }
    }
}