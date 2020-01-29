package edu.kit.informatik;

/**
 * a game stone
 * with 4 features and a number
 *
 * @author Fakhreddine Milouchi
 * @version 2.0
 */
public class Stone {

    private final Color color;
    private final Size size;
    private final Form form;
    private final Fullness fullness;
    private int number;

    /**
     * construct a game stone
     *
     * @param color    of the stone
     * @param form     of the stone
     * @param size     of the stone
     * @param fullness of the stone
     * @param number   of the stone
     */
    public Stone(Color color, Form form, Size size, Fullness fullness, int number) {
        this.color = color;
        this.size = size;
        this.form = form;
        this.fullness = fullness;
        this.number = number;
    }

    //getters and setters

    /**
     * @return the color of this stone
     */
    public Color getColor() {
        return color;
    }

    /**
     * @return the fullness of this stone
     */
    public Fullness getFullness() {
        return fullness;
    }

    /**
     * @return the form of this stone
     */
    public Form getForm() {
        return form;
    }

    /**
     * @return the form of this stone
     */
    public Size getSize() {
        return size;
    }

    /**
     * @return the number of this stone
     */
    public int getNumber() {
        return number;
    }

    //comparing stone

    /**
     * @param other the other stone
     * @return whether the stone have the same color
     */
    public boolean hasSameColor(Stone other) {
        if (other == null) {
            return false;
        }
        return getColor() == other.getColor();
    }

    /**
     * @param other the other stone
     * @return whether the stone have the same size
     */
    public boolean hasSameSize(Stone other) {
        if (other == null) {
            return false;
        }
        return getSize() == other.getSize();
    }

    /**
     * @param other the other stone
     * @return whether the stone have the same fullness
     */
    public boolean hasSameFullness(Stone other) {
        if (other == null) {
            return false;
        }
        return getFullness() == other.getFullness();
    }

    /**
     * @param other the other stone
     * @return whether the stone have the same form
     */
    public boolean hasSameForm(Stone other) {
        if (other == null) {
            return false;
        }
        return getForm() == other.getForm();
    }

    @Override
    public String toString() {
        return Integer.toString(this.getNumber());
    }

    /**
     * modeling the possible colors
     */
    enum Color {
        /**
         * white color
         */
        WHITE,
        /**
         * black color
         */
        BLACK
    }

    /**
     * modeling the possible sizes
     */
    enum Size {
        /**
         * small size
         */
        SMALL,
        /**
         * big size
         */
        BIG
    }

    /**
     * modeling the possible forms
     */
    enum Form {
        /**
         * angular form
         */
        ANGULAR,
        /**
         * cylindrical form
         */
        CYLINDRICAL
    }

    /**
     * modeling the possible fullness types
     */
    enum Fullness {
        /**
         * empty
         */
        EMPTY,
        /**
         * full
         */
        FULL
    }
}


