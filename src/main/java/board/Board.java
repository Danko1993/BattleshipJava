package board;



import java.util.ArrayList;

public class Board {

    private int size;
    /**
     * Describes a size of board
     */

    private Square[][] ocean;

    /**
     * Property for all possible coordinates on a board
     */

    public Board(int size) {
        this.size = size;
        this.ocean = new Square[size][size];
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                this.ocean[x][y] = new Square(x, y);
            }
        }
    }


    /**
     * allows to get board size
     *
     * @return board size
     */
    public int getSize() {
        return size;
    }

    /**
     * allows to get ocean property
     *
     * @return ocean
     */
    public Square[][] getOcean() {
        return ocean;
    }

    /**
     * Allows to set board size
     *
     * @param size is desired size of a board
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * Method is checking if ship can be placed on given coordinate
     * @param shipSquares list of square where a ship will be placed
     * @return true for correct placement false for wrong placement
     */
    public boolean isPlacementOk(ArrayList<Square> shipSquares) {
        ArrayList<Square> squaresToCheckStatus = prepareSquaresToCheckStatus(shipSquares);
        for (Square square : squaresToCheckStatus
        ) {
            if (square.getStatus() == SquareStatus.SHIP) {
                return false;
            }
        }
        return true;
    }

    /**
     * Prepares list of squares which will be around the boat and where boat is placed dependent on ship square position on the board
     * @param shipSquares list of square where a ship will be placed
     * @return list of squares which will be around the boat to check their status
     */
    private ArrayList<Square> prepareSquaresToCheckStatus(ArrayList<Square> shipSquares) {
        ArrayList<Square> squaresToCheckStatus = new ArrayList<>();
        for (Square square : shipSquares
        ) {
            int x = square.getX();
            int y = square.getY();
            if (x == 0 && y == 0) {
                addIfLeftUpperCorner(x, y, squaresToCheckStatus);
            }
            if (x == 0 && y == size - 1) {
                addIfRightUpperCorner(x, y, squaresToCheckStatus);
            }
            if (x == 0 && y > 0 && y < size - 1) {
                addIfOnTopSide(x, y, squaresToCheckStatus);
            }
            if (y == 0 && x > 0 && x < size - 1) {
                addIfOnLeftSide(x, y, squaresToCheckStatus);
            }
            if (y == size && x > 0 && x < size - 1) {
                addIfOnRightSide(x, y, squaresToCheckStatus);
            }
            if (x == size - 1 && y == 0) {
                addIfLeftBottomCorner(x, y, squaresToCheckStatus);
            }
            if (x == size - 1 && y == size - 1) {
                addIfRightBottomCorner(x, y, squaresToCheckStatus);
            }
            if (x == size - 1 && y > 0 && y < size - 1) {
                addIfBottomSide(x, y, squaresToCheckStatus);
            }
            if (x > 0 && x < size - 1 && y > 0 && y < size - 1) {
                addIfInner(x, y, squaresToCheckStatus);
            }
        }
        return squaresToCheckStatus;
    }

    /**
     * Method that prevents squares on list to check to duplicate
     * @param x ship square x coordinate
     * @param y ship square y coordinate
     * @param i row iterator
     * @param j element in a row iterator
     * @param squaresToCheckStatus list of squares around the boat and where boat is placed
     * @return true if given square is already on a list false if is not
     */
    private boolean isAdded(int x, int y, int i, int j, ArrayList<Square> squaresToCheckStatus){
        for (Square square:squaresToCheckStatus
             ) {if ((x + i) == square.getX() && (y + j) == square.getY()){return true;}
        }return false;
    }

    /**
     * Loop adding a squares for coordinates inside(not on any edge or corner) of a board
     * @param x ship square x coordinate
     * @param y ship square y coordinate
     * @param squaresToCheckStatus list of squares which statuses will be checked to determine if placement is correct
     */
    private void addIfInner(int x, int y, ArrayList<Square> squaresToCheckStatus) {
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if (!isAdded(x,y,i,j,squaresToCheckStatus)) {
                    squaresToCheckStatus.add(ocean[x + i][y + j]);
                }
            }
        }
    }

    /**
     * Loop adding a squares for coordinates at bottom row of a board (excluding corners)
     * @param x ship square x coordinate
     * @param y ship square y coordinate
     * @param squaresToCheckStatus list of squares which statuses will be checked to determine if placement is correct
     */
    private void addIfBottomSide(int x, int y, ArrayList<Square> squaresToCheckStatus) {
        for (int i = 0; i > -2; i--) {
            for (int j = -1; j < 2; j++) {
                if (!isAdded(x,y,i,j,squaresToCheckStatus)) {
                    squaresToCheckStatus.add(ocean[x + i][y + j]);
                }
            }

        }
    }
    /**
     * Loop adding a squares for coordinates at right bottom corner of a board
     * @param x ship square x coordinate
     * @param y ship square y coordinate
     * @param squaresToCheckStatus list of squares which statuses will be checked to determine if placement is correct
     */
    private void addIfRightBottomCorner(int x, int y, ArrayList<Square> squaresToCheckStatus) {
        for (int i = 0; i > -2; i--) {
            for (int j = 0; j > -2; j--) {
                if (!isAdded(x,y,i,j,squaresToCheckStatus)) {
                    squaresToCheckStatus.add(ocean[x + i][y + j]);
                }
            }

        }
    }
    /**
     * Loop adding a squares for coordinates left bottom corner of a board
     * @param x ship square x coordinate
     * @param y ship square y coordinate
     * @param squaresToCheckStatus list of squares which statuses will be checked to determine if placement is correct
     */
    private void addIfLeftBottomCorner(int x, int y, ArrayList<Square> squaresToCheckStatus) {
        for (int i = 0; i > -2; i--) {
            for (int j = 0; j < 2; j++) {
                if (!isAdded(x,y,i,j,squaresToCheckStatus)) {
                    squaresToCheckStatus.add(ocean[x + i][y + j]);
                }
            }

        }
    }
    /**
     * Loop adding a squares for coordinates at right edge column of a board (excluding corners)
     * @param x ship square x coordinate
     * @param y ship square y coordinate
     * @param squaresToCheckStatus list of squares which statuses will be checked to determine if placement is correct
     */
    private void addIfOnRightSide(int x, int y, ArrayList<Square> squaresToCheckStatus) {
        for (int i = -1; i < 2; i++) {
            for (int j = 0; j > -2; j--) {
                if (!isAdded(x,y,i,j,squaresToCheckStatus)) {
                    squaresToCheckStatus.add(ocean[x + i][y + j]);
                }
            }

        }
    }
    /**
     * Loop adding a squares for coordinates at left edge column of a board (excluding corners)
     * @param x ship square x coordinate
     * @param y ship square y coordinate
     * @param squaresToCheckStatus list of squares which statuses will be checked to determine if placement is correct
     */
    private void addIfOnLeftSide(int x, int y, ArrayList<Square> squaresToCheckStatus) {
        for (int i = -1; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                if (!isAdded(x,y,i,j,squaresToCheckStatus)) {
                    squaresToCheckStatus.add(ocean[x + i][y + j]);
                }
            }

        }
    }
    /**
     * Loop adding a squares for coordinates at top row of a board (excluding corners)
     * @param x ship square x coordinate
     * @param y ship square y coordinate
     * @param squaresToCheckStatus list of squares which statuses will be checked to determine if placement is correct
     */
    private void addIfOnTopSide(int x, int y, ArrayList<Square> squaresToCheckStatus) {
        for (int i = 0; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if (!isAdded(x,y,i,j,squaresToCheckStatus)) {
                    squaresToCheckStatus.add(ocean[x + i][y + j]);
                }
            }

        }
    }
    /**
     * Loop adding a squares for coordinates at left top corner of a board
     * @param x ship square x coordinate
     * @param y ship square y coordinate
     * @param squaresToCheckStatus list of squares which statuses will be checked to determine if placement is correct
     */
    private void addIfLeftUpperCorner(int x, int y, ArrayList<Square> squaresToCheckStatus) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                if (!isAdded(x,y,i,j,squaresToCheckStatus)) {
                    squaresToCheckStatus.add(ocean[x + i][y + j]);
                }
            }

        }
    }
    /**
     * Loop adding a squares for coordinates right top corner of a board
     * @param x ship square x coordinate
     * @param y ship square y coordinate
     * @param squaresToCheckStatus list of squares which statuses will be checked to determine if placement is correct
     */
    private void addIfRightUpperCorner(int x, int y, ArrayList<Square> squaresToCheckStatus) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j > -2; j--) {
                if (!isAdded(x,y,i,j,squaresToCheckStatus)) {
                    squaresToCheckStatus.add(ocean[x + i][y + j]);
                }
            }

        }
    }
}




