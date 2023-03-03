package game;
import java.util.ArrayList;

import board.Board;
import board.SquareStatus;
import ship.Ship;
import board.Square;
import util.Display;
import util.Input;

public class Player {
    final int SIZE_OF_BOARD =10;
    ArrayList<Ship> ships;
    String name;
    Board ocean;
    Display display = new Display();
    Input input = new Input();
    ArrayList <Integer> shot;



    public Player(String name) {
        this.ocean = new Board(SIZE_OF_BOARD);
        this.name = name;
        this.ships = new ArrayList<>();
    }

    public boolean isAlive(){
//
        for (Ship ship:ships
        ) {if(!ship.isSunk()){return true;}

        }
        return false;
    }
    private void addShips(Ship ship){
        ships.add(ship);
    }
    private boolean isShot(int x , int y,Player opponent){
        for (Ship ship: opponent.ships
        ) {
            for (Square square:ship.getSquares()
            ) {

                if (square.getX() == x && square.getY() == y && square.getStatus() == SquareStatus.SHIP)
                {
                    square.setStatus(SquareStatus.HIT);
                    return true;}


            }
        }


        return false;

    }
    private void setValuesAfterShot(int x,int y,Player opponent){
        if(isShot(x,y,opponent)){
            opponent.ocean.getOcean()[x][y].setStatus(SquareStatus.HIT);
        }
        else{
            opponent.ocean.getOcean()[x][y].setStatus(SquareStatus.MISSED);
        }

    }
    private ArrayList<Integer> getInputShot(){
        display.printString(this.name + "Please give coordinates to shot: ");
        return input.properlyCoordinates();



    }
    public void logicPlayerHits(Player opponent){
        display.printBoard(opponent.ocean);
        shot = getInputShot();
        setValuesAfterShot(shot.get(0),shot.get(1),opponent);
        display.printBoard(opponent.ocean);
        input.pressEnterToContinue();
        display.clearConsole();

    }
}