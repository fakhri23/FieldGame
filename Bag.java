package edu.kit.informatik;

/**
 * The bag of game stones
 *
 * @author Fakhreddine Milouchi
 * @version 1.0
 */
public class Bag {

    private static final Stone[] STONES_BAG = {
            new Stone(Stone.Color.BLACK, Stone.Form.ANGULAR,
                    Stone.Size.SMALL, Stone.Fullness.EMPTY, 0),
            new Stone(Stone.Color.BLACK, Stone.Form.ANGULAR,
                    Stone.Size.SMALL, Stone.Fullness.FULL, 1),
            new Stone(Stone.Color.BLACK, Stone.Form.ANGULAR,
                    Stone.Size.BIG, Stone.Fullness.EMPTY, 2),
            new Stone(Stone.Color.BLACK, Stone.Form.ANGULAR,
                    Stone.Size.BIG, Stone.Fullness.FULL, 3),
            new Stone(Stone.Color.BLACK, Stone.Form.CYLINDRICAL,
                    Stone.Size.SMALL, Stone.Fullness.EMPTY, 4),
            new Stone(Stone.Color.BLACK, Stone.Form.CYLINDRICAL,
                    Stone.Size.SMALL, Stone.Fullness.FULL, 5),
            new Stone(Stone.Color.BLACK, Stone.Form.CYLINDRICAL,
                    Stone.Size.BIG, Stone.Fullness.EMPTY, 6),
            new Stone(Stone.Color.BLACK, Stone.Form.CYLINDRICAL,
                    Stone.Size.BIG, Stone.Fullness.FULL, 7),
            new Stone(Stone.Color.WHITE, Stone.Form.ANGULAR,
                    Stone.Size.SMALL, Stone.Fullness.EMPTY, 8),
            new Stone(Stone.Color.WHITE, Stone.Form.ANGULAR,
                    Stone.Size.SMALL, Stone.Fullness.FULL, 9),
            new Stone(Stone.Color.WHITE, Stone.Form.ANGULAR,
                    Stone.Size.BIG, Stone.Fullness.EMPTY, 10),
            new Stone(Stone.Color.WHITE, Stone.Form.ANGULAR,
                    Stone.Size.BIG, Stone.Fullness.FULL, 11),
            new Stone(Stone.Color.WHITE, Stone.Form.CYLINDRICAL,
                    Stone.Size.SMALL, Stone.Fullness.EMPTY, 12),
            new Stone(Stone.Color.WHITE, Stone.Form.CYLINDRICAL,
                    Stone.Size.SMALL, Stone.Fullness.FULL, 13),
            new Stone(Stone.Color.WHITE, Stone.Form.CYLINDRICAL,
                    Stone.Size.BIG, Stone.Fullness.EMPTY, 14),
            new Stone(Stone.Color.WHITE, Stone.Form.CYLINDRICAL,
                    Stone.Size.BIG, Stone.Fullness.FULL, 15)
    };
    private static final int SIZE = STONES_BAG.length;
    private boolean[] used;

    /**
     * construct a full bag
     */
    public Bag() {
        this.used = new boolean[SIZE];
    }

    /**
     * get the game stone at with this number
     *
     * @param number of the stone
     * @return the stone
     * @throws InputException in case of attempt to duplicate use a stone or
     *                        giving an invalid stone number
     */
    public Stone getStone(int number) throws InputException {
        if (!(number > -1 && number < SIZE)) {
            throw new InputException("Stone number must be in the closed interval [0,15].");
        } else if (used[number]) {
            throw new InputException("A stone can't be used more than one time.");
        } else {
            used[number] = true;
            return STONES_BAG[number];
        }
    }

    /**
     * check weather the bag is empty
     *
     * @return whether the bag is empty
     */
    public boolean isEmpty() {
        for (boolean b : used) {
            if (!b) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {

        String separator = "";
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < SIZE; i++) {

            if (!used[i]) {
                result.append(separator);
                result.append(i);
                separator = " ";
            }
        }
        return result.toString();
    }
}
