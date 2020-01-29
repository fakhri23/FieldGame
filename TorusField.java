package edu.kit.informatik;

/**
 * modelling a torus field
 * it allows for more streak possibilities having open field limits
 *
 * @author Fakhreddine Milouchi
 * @version 1.3
 */
public class TorusField extends Field {

    /**
     * construct a torus field
     */
    public TorusField() {
        super();
    }

    @Override
    public Stone getStoneAt(int i, int j) {
        int row = getActualAddress(i);
        int column = getActualAddress(j);
        return super.getStoneAt(row, column);
    }

    private int getActualAddress(int i) {
        if (i >= 0) {
            return i % 6;
        } else {
            return 6 - (Math.abs(i) % 6);
        }
    }

    @Override
    public void placeAt(Stone stone, int i, int j) {
        int row = getActualAddress(i);
        int column = getActualAddress(j);
        if (this.getStoneAt(row, column) != null) {
            throw new InputException("this address is already taken.");
        }
        super.placeAt(stone, row, column);
    }

    @Override
    public String rowString(int row) {
        int newRow = getActualAddress(row);
        return super.rowString(newRow);
    }

    @Override
    public String colString(int column) {
        int newCol = getActualAddress(column);
        return super.rowString(newCol);
    }
}
