package board;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {
    @Test
    public void shipCanBePlacedAtEmptySquare() {
        //Given
        ArrayList<Square> shipSquares = new ArrayList<>();
        Board board = new Board(10);
        Square square = new Square(0, 0);
        Square square1 = new Square(1, 0);
        Square square2 = new Square(2, 0);
        shipSquares.add(square);
        shipSquares.add(square1);
        shipSquares.add(square2);
        //When
        boolean result=board.isPlacementOk(shipSquares);
        //Then
        assertTrue(result);
    }
    @Test
    public void shipCanNotBePlacedAtOtherShipSquare() {
        //Given
        ArrayList<Square> shipSquares = new ArrayList<>();
        Board board = new Board(10);
        board.getOcean()[0][0].setStatus(SquareStatus.SHIP);
        board.getOcean()[1][0].setStatus(SquareStatus.SHIP);
        board.getOcean()[2][0].setStatus(SquareStatus.SHIP);
        Square square = new Square(0, 0);
        Square square1 = new Square(1, 0);
        Square square2 = new Square(2, 0);
        shipSquares.add(square);
        shipSquares.add(square1);
        shipSquares.add(square2);
        //When
        boolean result=board.isPlacementOk(shipSquares);
        //Then
        assertFalse(result);
    }
    @Test
    public void shipCanNotBePlacedNextToOtherShip() {
        //Given
        ArrayList<Square> shipSquares = new ArrayList<>();
        Board board = new Board(10);
        board.getOcean()[0][0].setStatus(SquareStatus.SHIP);
        board.getOcean()[1][0].setStatus(SquareStatus.SHIP);
        board.getOcean()[2][0].setStatus(SquareStatus.SHIP);
        Square square = new Square(0, 1);
        Square square1 = new Square(1, 1);
        Square square2 = new Square(2, 1);
        shipSquares.add(square);
        shipSquares.add(square1);
        shipSquares.add(square2);
        //When
        boolean result=board.isPlacementOk(shipSquares);
        //Then
        assertFalse(result);
    }
    @Test
    public void shipCanBePlacedOneSquareAwayFromOtherShip() {
        //Given
        ArrayList<Square> shipSquares = new ArrayList<>();
        Board board = new Board(10);
        board.getOcean()[0][0].setStatus(SquareStatus.SHIP);
        board.getOcean()[1][0].setStatus(SquareStatus.SHIP);
        board.getOcean()[2][0].setStatus(SquareStatus.SHIP);
        Square square = new Square(0, 2);
        Square square1 = new Square(1, 2);
        Square square2 = new Square(2, 2);
        shipSquares.add(square);
        shipSquares.add(square1);
        shipSquares.add(square2);
        //When
        boolean result=board.isPlacementOk(shipSquares);
        //Then
        assertTrue(result);
    }

}