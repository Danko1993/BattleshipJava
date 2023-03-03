package util;


import board.Board;
import java.util.Map;


public class Display {

    public static final String RESET = "\033[0m";
    public static final String WHITE = "\033[0;37m";
    public static final String SMALL_SPACE ="\u2006";
    public static final String DARK_BLUE_CUSTOM_BG = "\033[48;2;18;1;195m";

    /**
     * Method used to print strings in console
     * @param string string to be printed
     */
    public void printString(String string) {
        System.out.print(string);
    }

    public void printMenu(Map<String,String> menu){
        menu.forEach((k,v) -> printString(k+" "+v) );

    }

    /**
     * Method to print boards in console
     * @param board board to be printed
     */
    public void printBoard( Board board){
        int size = board.getSize();
        String string= "ABCDEFGHIJ";
        printString(WHITE+DARK_BLUE_CUSTOM_BG+" "+SMALL_SPACE+SMALL_SPACE+RESET);
        for (int i = 0; i <string.length() ; i++) {
            printString(WHITE+DARK_BLUE_CUSTOM_BG+" "+string.charAt(i)+SMALL_SPACE+RESET);
        }
        printString("\n");
        for (int row = 0; row < size ; row++) {
            if(row < size-1){
                printString(WHITE+DARK_BLUE_CUSTOM_BG+" "+Integer.toString(row+1)+RESET);
            }else {
                printString(WHITE+DARK_BLUE_CUSTOM_BG+Integer.toString(row+1)+RESET);
            }
            for (int element = 0; element < size; element++) {
                printString(board.getOcean()[row][element].getSign());

            }
            printString("\n");
        }
    }
    public static void clearConsole(){

    }
}