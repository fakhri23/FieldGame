package edu.kit.informatik;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameManagerTest {

    GameManager game;

    @BeforeEach
    void setUp() {
        game = new GameManager();
    }

    @Test()
    void testTorus()  {
        game.start("torus");
        game.select(1);
        game.place(12,12);
        game.select(3);
        game.place(-14,457);
        printField(game);
        Exception exception = assertThrows(InputException.class, () ->
                game.place(12,15));
        Exception exceptionSelect = assertThrows(InputException.class, () ->
                game.select(1));
    }

    @Test
    void select() {
        game.start("standard");
        game.select(1);
        game.place(1,1);
        Exception used = assertThrows(InputException.class, () ->
                game.select(1));
        game.select(3);
        assertThrows(InputException.class, () ->
                game.select(5));
        printField(game);
    }

    @Test
    void place() {
        game.start("standard");
        assertThrows(InputException.class, ()->
                game.place(5,5));
        game.select(4);
        assertThrows(InputException.class, ()->
                game.place(66,57868));
        printField(game);
    }

    @Test
    void isGameOver() {
        game.start("standard");
        game.select(1);
        game.place(0,0);
        printField(game);
        game.select(2);
        game.place(0,1);
        printField(game);
        game.select(3);
        game.place(0,2);
        printField(game);
        game.select(4);
        game.place(0,3);
        printField(game);
        assertThrows(InputException.class,()->
                game.select(5));
        game.start("standard");
        game.select(1);
        game.place(0,0);
        game.select(2);
        game.place(0,1);
        game.select(3);
        game.place(0,2);
        game.select(4);
        game.place(0,5);
        game.select(5);
        game.place(0,3);
        printField(game);
        assertThrows(InputException.class,()->
                game.select(5));

    }


    @Test
    void testDiagonalDown() {
        game.start("standard");
        game.select(1);
        game.place(0,0);
        printField(game);
        game.select(2);
        game.place(1,1);
        printField(game);
        game.select(3);
        game.place(2,2);
        printField(game);
        game.select(4);
        game.place(3,3);
        printField(game);
        assertThrows(InputException.class,()->
                game.select(5));
    }

    @Test
    void testDiagonalUp() {
        game.start("standard");
        game.select(1);
        game.place(5,5);
        game.select(2);
        game.place(4,4);
        game.select(3);
        game.place(3,3);
        game.select(4);
        game.place(2,2);
        assertThrows(InputException.class,()->
                game.select(5));
        game.printBag();
    }

    @Test
    void testDiagonalDownFail() {
        game.start("standard");
        game.select(1);
        game.place(5,5);
        game.select(2);
        game.place(4,4);
        game.select(3);
        game.place(3,3);
    }
    public void printField(GameManager game){
        for(int i = 0; i<6;i++){
            game.rowPrint(i);
        }
    }

    @Test
    void testExample(){
        game.start("torus");
        game.select(11);
        game.place(1,4);
        game.select(7);
        game.place(3,0);
        game.select(5);
        game.place(4,1);
        game.select(15);
        game.place(2,5);
        printField(game);


    }
}