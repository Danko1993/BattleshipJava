package board;


public class Square {
    /**
     * Square x coordinate
     */
    private int x;
    /**
     * Square y coordinate
     */
    private int y;
    /**
     * Describes current square status
     */
    private SquareStatus status;
    /**
     * Describes square graphic representation
     */
    private String sign;

    public Square(int x, int y){
        this.x=x;
        this.y=y;
        this.status=SquareStatus.EMPTY;
        this.sign= this.status.GetCharacter();
    }
    public Square(int x, int y, SquareStatus status){
        this.x=x;
        this.y=y;
        this.status = status;
        this.sign= this.status.GetCharacter();


    }

    /**
     * Allows to get x coordinate
     * @return x coordinate
     */
    public int getX(){return x;}

    /**
     * Allows to get y coordinate
     * @return y coordinate
     */
    public int getY(){return y;}

    /**
     * Allows to get current square status
     * @return current square status
     */
    public SquareStatus getStatus(){return status;}

    /**
     * Allows to set square status
     * @param status square status
     */
    public void setStatus(SquareStatus status){this.status=status;
        this.sign = status.GetCharacter();
    }

    /**
     * Allows to get square graphic representation
     * @return square graphic representation
     */
    public String getSign(){return sign;}


}