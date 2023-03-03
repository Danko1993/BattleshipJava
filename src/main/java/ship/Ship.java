package ship;
import board.Square;
import board.SquareStatus;

import java.util.ArrayList;

public class Ship {
    /**
     * describes ship type
     */
    private ShipType shipType;
    /**
     * List of squares taken by ship
     */
    private ArrayList<Square> squares;
    /**
     * Describes if ship is sunk(all ship squares have status HIT)
     */
    private boolean isSunk;

    public Ship(ShipType shipType) {
        this.squares=new ArrayList<>();
        this.isSunk = false;
        this.shipType = shipType;
    }

    public Ship(ShipType shipType, ArrayList<Square> squares){
        this.squares=squares;
        this.isSunk=false;
        this.shipType=shipType;

    }

    /**
     * Allows to set ship squares
     * @param squares list of ship squares
     */
    public void setSquares(ArrayList<Square> squares) {
        this.squares = squares;
    }

    /**
     * Allows to get ship squares
     * @return ship squares
     */
    public ArrayList<Square> getSquares() {
        return squares;
    }

    /**
     * Allow to sink the ship
     * @param sunk current sunk value
     */
    public void setSunk(boolean sunk) {
        this.isSunk = sunk;
    }

    /**
     * Checks if ship is sunk
     * @return false if ship not sunt true if ship sunk
     */
    public boolean isSunk() {

        for (Square square:squares
        ) {if(square.getStatus()== SquareStatus.SHIP){
            setSunk(false);
            return this.isSunk;
        }
            setSunk(true);

        }
        return this.isSunk;
    }

}