package edu.kit.informatik;

/**
 * modelling a player in the game
 *
 * @author Fakhreddine Milouchi
 * @version 1.4.1
 */
public class Player {
    private final int number;

    /**
     * construct a player with the corresponding number
     * @param number the player number,
     *               typically 1 or 2
     */
    public Player(int number) {
        this.number = number;
    }

    /**
     * get the number of the player
     *
     * @return the number of this player typically 1 or 2
     */
    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return String.format("P%d", getNumber());
    }

    /**
     * check if two players are equals
     *
     * @param other the other player
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Player)) {
            return false;
        }
        return this.getNumber() == ((Player) other).getNumber();
    }
}
