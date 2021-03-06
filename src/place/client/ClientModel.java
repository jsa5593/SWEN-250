package place.client;

import place.PlaceBoard;
import place.PlaceColor;
import place.PlaceException;
import place.PlaceTile;

import java.awt.*;
import java.util.Observable;

public class ClientModel extends Observable {

    public enum colors {
        ZERO, ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, A, B, C, D, E, F,
    }

    private static PlaceBoard board;
    //private ClientModel.colors[][] model;
    private int dim;
    private final static int MINDIM = 5;

    public int getDim() {
        return dim;
    }

    public void allocate(PlaceBoard b) throws PlaceException {
        this.board = b;
        dim = board.DIM;
    }

    public void close() {
        super.setChanged();
        super.notifyObservers();
    }

    public String printBoard() {
        return board.toString();
    }

    public void makeMove(PlaceTile tile) {
        board.setTile(tile);
        super.setChanged();
        super.notifyObservers();
    }

    public PlaceTile getContents(int row, int col) {
        return this.board.getTile(row, col);
    }

}