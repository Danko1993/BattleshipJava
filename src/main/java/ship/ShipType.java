package ship;


public enum ShipType{
    Destroyer(2),
    Submarine(3),
    Battleship(3),
    Cruiser(4),
    Carrier(5);

    /**
     * Determines how many squares is ship taking on a board
     */
    int length;

    ShipType(int length) {
        this.length = length;
    }

    /**
     * Allows to get ship length
     * @return ship length
     */
    public int getLength() {
        return length;
    }

}