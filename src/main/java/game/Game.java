package game;

import board.Board;
import board.BoardFactory;
import board.Square;
import board.SquareStatus;
import ship.ShipType;
import util.Display;
import util.Input;
import ship.Ship;

import java.util.ArrayList;
import java.util.Random;

public class Game {
    Player player1;
    Player player2;
    Input input = new Input();
    Display display = new Display();
    BoardFactory factory = new BoardFactory();
    Random random = new Random();


    /**
     * setting players names and their boards
     */
    private void setPlayers(){
        display.printString("First Player what's your name? ");
        player1 = new Player(input.text());
        player1.ships = phasePlacement();
        display.printString("Second Player what's your name? ");
        player2 = new Player(input.text());
        player2.ships = phasePlacement();


    }

    /**
     * Starts the game
     */
    public void start(){
        setPlayers();
        loopGame(player1,player2);
    }

    /**
     * Logic for game loop
     * @param player current player
     * @param opponent players opponent
     */
    private void loopGame(Player player, Player opponent){
        while(true){
            roundPlayer(player,opponent);
            if(!opponent.isAlive()){
                break;
            }
            roundPlayer(opponent,player);
            if(!player.isAlive()){
                break;
            }

        }

    }
    private void roundPlayer(Player player, Player oponent){
        player.logicPlayerHits(oponent);
    }

    /**
     * Logic for placement phase
     * @return list of current players ships
     */
    private ArrayList<Ship> phasePlacement (){
        Board tempBoard = new Board(10);
        ArrayList<Ship> tempShips = new ArrayList<>();
        boolean isManual = input.isTrue("Do You want to place ships manually?(Y/N): ");
        for (ShipType type:ShipType.values()
        ) {
            ArrayList<Square> shipSquares;
            ArrayList<Integer> cords;
            boolean isHorisontal;
            while (true) {
                if (!isManual){
                    cords = input.initRandomCords();
                    isHorisontal= input.initRandomHorizontal();

                }else {
                    display.printString("Please provide coordinates of a head of a ship: ");
                    cords =input.properlyCoordinates();
                    isHorisontal=input.isTrue("What to place ship horizontal?(Y/N): ");
                }
               if(tempBoard.isPlacementOk(factory.manualPlacement(cords, type, isHorisontal, tempBoard))){
                   shipSquares=factory.manualPlacement(cords, type, isHorisontal, tempBoard);
                   if (shipSquares.size()==type.getLength()){
                   for (Square shipSquare:shipSquares
                        ) {tempBoard.getOcean()[shipSquare.getX()][shipSquare.getY()].setStatus(SquareStatus.SHIP);
                   }
                   break;
                   }
               }
            }
            display.printBoard(tempBoard);
            Ship ship = new Ship(type,shipSquares);
            tempShips.add(ship);
        }
        return tempShips;
    }

}