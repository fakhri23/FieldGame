package edu.kit.informatik;

/**
 * modelling a standard field with closed limits
 * @author Fakhreddine Milouchi
 * @version 1.8
 */
public class StandardField extends Field {

    /**
     * construct  a standard field
     */
    public StandardField() {
        super();
    }

    @Override
    public Stone getStoneAt(int row, int col) {
        if (inTheCorrectInterval(row) && inTheCorrectInterval(col)) {
            return this.getField()[row][col];
        } else {
            throw new InputException("Both indexes must be between 0 and 5 inclusive.");
        }
    }

    private boolean inTheCorrectInterval(int i) {
        return (0 <= i && i < this.getLength());
    }

    @Override
    public void placeAt(Stone stone, int row, int col) {
        if (!inTheCorrectInterval(row) || !inTheCorrectInterval(col)) {
            throw new InputException("Both indexes must be between 0 and 5 inclusive.");
        }
        if (this.getStoneAt(row, col) != null) {
            throw new InputException("This address is already taken.");
        }
        super.placeAt(stone, row, col);
    }

    @Override
    public String rowString(int row) {
        if (!inTheCorrectInterval(row)) {
            throw new InputException("Row must be strictly greater than -1 "
                    + "and strictly smaller than the length of the field");
        }
        return super.rowString(row);
    }

    @Override
    public String colString(int column) {
        if (!inTheCorrectInterval(column)) {
            throw new InputException("Row must be strictly greater than -1 "
                    + "and strictly smaller than the length of the field");
        }
        return super.rowString(column);
    }
}
