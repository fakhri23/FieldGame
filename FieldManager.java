package edu.kit.informatik;

import java.util.Arrays;

/**
 * a class to operate on the selected fields
 *
 * @author Fakhreddine Milouchi
 * @version 1.2
 */

public class FieldManager {

    private final int streakLength = 4;
    private final int streakStart;
    private Field playField;
    private int startRow;
    private int startColumn;
    private int endRow;
    private int endColumn;

    /**
     * construct a field manager
     *
     * @param playField playing field
     *                  which corresponds directly to the mode of game
     */
    public FieldManager(Field playField) {
        this.playField = playField;
        this.streakStart = calculateStreakStart();
    }

    private int calculateStreakStart() {
        if (this.playField instanceof StandardField) {
            return playField.getLength() - this.streakLength;
        } else if (this.playField instanceof TorusField) {
            return playField.getLength();
        } else {
            throw new InputException("unrecognised field");
        }
    }

    /**
     * get the stone at this coordinate
     *
     * @param row    coordinate
     * @param column coordinate
     * @return the stone at the coordinate
     */
    public Stone getStoneAt(int row, int column) {
        return playField.getStoneAt(row, column);
    }

    /**
     * place the stone at this coordinate
     *
     * @param stone  to place at the corresponding coordinate
     * @param row    coordinate
     * @param column coordinate
     */
    public void placeAt(Stone stone, int row, int column) {
        this.playField.placeAt(stone, row, column);
    }

    /**
     * check whether a streak has been found
     * scanning the field vertically, horizontally and diagonally
     *
     * @return whether a streak has been made
     */
    public boolean checkStreak() {
        return checkDiagonalDown() || checkDiagonalUp() || checkHorizontal() || checkVertical();
    }

    private boolean checkVertical() {

        startRow = 0;
        endRow = this.streakStart;
        startColumn = 0;
        endColumn = playField.getLength();

        for (int column = startColumn; column < endColumn; column++) {

            for (int row = startRow; row < endRow; row++) {

                if (compareAllToLeading(row, column, 1, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean checkHorizontal() {
        startRow = 0;
        endRow = playField.getLength();
        startColumn = 0;
        endColumn = this.streakStart;
        for (int row = startRow; row < endRow; row++) {

            for (int column = startColumn; column < endColumn; column++) {

                if (compareAllToLeading(row, column, 0, 1)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean checkDiagonalDown() {
        startRow = 0;
        endRow = this.streakStart;
        startColumn = 0;
        endColumn = this.streakStart;

        for (int row = startRow; row < endRow; row++) {

            for (int column = startColumn; column < endColumn; column++) {

                if (compareAllToLeading(row, column, 1, 1)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean checkDiagonalUp() {
        startRow = playField.getLength() - 1;
        endRow = playField.getLength() - this.streakStart;
        startColumn = playField.getLength() - 1;
        endColumn = playField.getLength() - this.streakStart;

        for (int row = startColumn; row >= endRow; row--) {

            for (int column = startColumn; column >= endColumn; column--) {

                if (compareAllToLeading(row, column, -1, -1)) {
                    return true;
                }
            }
        }

        return false;

    }

    private boolean compareAllToLeading(int row, int column, int verticalStep, int horizontalStep) {

        boolean[] commonFeatures = new boolean[4];
        Stone comparedStone;
        Stone leadingStone = getStoneAt(row, column);

        if (leadingStone == null) {
            return false;

        } else {

            Arrays.fill(commonFeatures, true);

            for (int step = 1; step < this.streakLength; step++) {
                comparedStone = getStoneAt(row + step * verticalStep, column + step * horizontalStep);
                compareToLeading(commonFeatures, leadingStone, comparedStone);
            }
            return atLeastOneIsTrue(commonFeatures);
        }
    }

    private void compareToLeading(boolean[] features, Stone leadingStone, Stone comparedStone) {

        if (comparedStone == null) {

            Arrays.fill(features, false);
        } else {

            features[0] = features[0] && leadingStone.hasSameColor(comparedStone);
            features[1] = features[1] && leadingStone.hasSameForm(comparedStone);
            features[2] = features[2] && leadingStone.hasSameSize(comparedStone);
            features[3] = features[3] && leadingStone.hasSameFullness(comparedStone);
        }
    }

    private boolean atLeastOneIsTrue(boolean[] array) {

        for (boolean b : array) {

            if (b) {
                return true;
            }
        }

        return false;
    }

    /**
     * @param row to represent as string
     * @return a string representation of this row
     */
    public String rowString(int row) {
        return this.playField.rowString(row);
    }

    /**
     * @param column to represent as string
     * @return a string representation of this column
     */
    public String colString(int column) {
        return this.playField.colString(column);
    }

}
