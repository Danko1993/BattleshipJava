package board;

/**
 * List of possible square statuses and their graphic representations
 */
public enum SquareStatus {
    EMPTY("\uD83D\uDFE6"), SHIP("\uD83D\uDEA2"), HIT("❎"), MISSED("❌");
    /**
     * Graphic representation based on status
     */
    private final String character;

    /**
     * Square status constructor
     * @param character Graphic representation
     */
    SquareStatus(String character){this.character=character;}

    /**
     * Allows to get Graphic representation based on status
     * @return Graphic representation based on status
     */
    public String GetCharacter(){return character;}}