package edu.kit.informatik;

/**
 * managing the game
 *
 * @author Fakhreddine Milouchi
 * @version 1.0
 */
public class GameManager {

    private final Player player1;
    private final Player player2;
    private FieldManager fieldManager;
    private Bag bag;
    private int turnCounter;
    private Player activePlayer;
    private Stone selectedStone;
    private boolean over;

    /**
     * construct a game with two players
     */
    public GameManager() {
        player1 = new Player(1);
        player2 = new Player(2);
        activePlayer = player1;
    }

    /**
     * start a game in the selected mode
     *
     * @param mode of the field
     * @throws InputException by unrecognized field mode
     */

    public void start(String mode) throws InputException {

        Field playingField;

        if (mode.equals("standard")) {
            playingField = new StandardField();
        } else if (mode.equals("torus")) {
            playingField = new TorusField();
        } else {
            throw new InputException("Mode must be standard or torus.");
        }

        fieldManager = new FieldManager(playingField);
        turnCounter = 0;
        bag = new Bag();
        over = false;
    }

    /**
     * select the stone with this number from the field
     *
     * @param stoneNumber the number of the stone
     * @throws InputException the game has ended or an other stone is already selected
     */
    public void select(int stoneNumber) throws InputException {

        if (over) {
            throw new InputException("the game is over");
        }
        if (selectedStone != null) {
            throw new InputException("the selected stone must be placed, "
                    + "before any new stone can be selected.");
        }

        selectedStone = bag.getStone(stoneNumber);
        changePlayer();
    }

    private void changePlayer() {
        if (activePlayer.equals(player1)) {
            activePlayer = player2;
        } else {
            activePlayer = player1;
        }
    }

    /**
     * place the stone in this coordinate
     *
     * @param row    coordinate
     * @param column coordinate
     * @throws InputException if the game is over or no stone is selected
     */
    public void place(int row, int column) throws InputException {

        if (over) {
            throw new InputException("the game is over.");
        }

        if (selectedStone == null) {
            throw new InputException("No play stone has been selected.");
        }

        fieldManager.placeAt(selectedStone, row, column);
        selectedStone = null;
        decideGameEnd();
        turnCounter++;
    }

    private void decideGameEnd() {

        over = fieldManager.checkStreak();

        if (over) {
            Terminal.printLine(String.format("%s wins", activePlayer.toString()));
        }

        if (bag.isEmpty()) {
            over = true;
            Terminal.printLine("draw");
        }

        if (over) {
            Terminal.printLine(turnCounter);
        }
    }

    /**
     *
     * @return whether the game is over or not
     */
    public boolean isGameOver() {
        return over;
    }

    /**
     * print this row
     *
     * @param row to print
     */
    public void rowPrint(int row) {
        Terminal.printLine(fieldManager.rowString(row));
    }

    /**
     * print this column
     *
     * @param column to print
     */
    public void colPrint(int column) {
        Terminal.printLine(fieldManager.colString(column));
    }

    /**
     * print the bag
     */
    public void printBag() {
        Terminal.printLine(bag);
    }

}
