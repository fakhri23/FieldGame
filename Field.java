package edu.kit.informatik;

/**
 * an abstraction of a play field
 *
 * @author Fakhreddine Milouchi
 * @version 1.0
 */
public abstract class Field {

    private final int length = 6;

    private Stone[][] field;

    /**
     * construct an empty game field
     */
    protected Field() {
        this.field = new Stone[6][6];
    }

    /**
     * @return the length of the field.
     */
    public int getLength() {
        return this.length;
    }

    /**
     * @return the field as a matrix
     */
    public Stone[][] getField() {
        return this.field;
    }

    /**
     * get the stone at this coordinate
     *
     * @param row in the field
     * @param col in the field
     * @return the stone at this coordinate
     */
    protected Stone getStoneAt(int row, int col) {
        return this.field[row][col];
    }

    /**
     * place the stone at this coordinate
     *
     * @param stone to place on the field
     * @param row   in the field
     * @param col   in the field
     */
    protected void placeAt(Stone stone, int row, int col) {
        this.field[row][col] = stone;
    }

    /**
     * @param row the selected row
     * @return a string representation of the row
     */
    public String rowString(int row) {
        StringBuilder result = new StringBuilder();
        for (int column = 0; column < length; column++) {
            appendStringRepresentation(result, row, column);
        }
        result.deleteCharAt(result.length() - 1);
        return result.toString();
    }

    /**
     * @param column the selected column
     * @return a string representation of the column
     */
    public String colString(int column) {
        StringBuilder result = new StringBuilder();
        for (int row = 0; row < length; row++) {
            appendStringRepresentation(result, row, column);
        }
        result.deleteCharAt(result.length() - 1);
        return result.toString();
    }

    private void appendStringRepresentation(StringBuilder result, int row, int column) {
        Stone stone = getStoneAt(row, column);
        result.append((stone != null) ? stone.toString() : "#");
        result.append(" ");
    }
}
