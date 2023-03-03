package board;

import ship.ShipType;
import util.Display;

import java.util.ArrayList;

public class BoardFactory {
    util.Display display= new Display();

    /**
     * Allows to place ship manually
     * @param cord initial cord - head square of ship
     * @param shipType type of ship
     * @param isHorizontal determines if ship is oriented vertically(facing lef) or horizontally (facing up)
     * @param board board on which placement will be made
     * @return squares that ship will be taken by ship
     */
    public ArrayList<Square> manualPlacement(ArrayList<Integer> cord, ShipType shipType, boolean isHorizontal, Board board){
        ArrayList<Square> squares = new ArrayList<Square>();
        int x = cord.get(0);
        int y = cord.get(1);
        if (isHorizontal){
            if (isCordOnBoardHorizontal(y,shipType,board)){
            for (int i = 0; i < shipType.getLength() ; i++) {
                squares.add(board.getOcean()[x][y+i]);
                }
            }
        } else if (!isHorizontal) {
            if (isCordOnBoardVertical(x,shipType,board)){
                for (int i = 0; i < shipType.getLength() ; i++) {
                    squares.add(board.getOcean()[x + i][y]);
                }
            }
        }
        return squares;
    }

    /**
     * Checks if Horizontal ships cords are on board
     * @param y y coordinate of head square of a ship
     * @param shipType type of  ship
     * @param board board for at which is placement made
     * @return true if all ship is on given board false if not
     */
    private boolean isCordOnBoardHorizontal(int y, ShipType shipType, Board board){
        if (y+shipType.getLength()< board.getSize()){
            return true;
        } return false;

    }
    /**
     * Checks if vertical ships cords are on board
     * @param x x coordinate of head square of a ship
     * @param shipType type of  ship
     * @param board board for at which is placement made
     * @return true if all ship is on given board false if not
     */
    private boolean isCordOnBoardVertical(int x,ShipType shipType, Board board){
        if (x+shipType.getLength()< board.getSize()){
            return true;
        }return false;
    }
}
