package place.client;

import place.PlaceException;
import java.util.Observable;

public class ClientModel extends Observable{

    public enum colors{
        ZERO, ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, A, B, C, D, E, F,
    }

    private ClientModel.colors[][] board;
    private int rows;
    private int cols;
    private final static int MINDIM = 5;

    private int getRows(){
        return rows;
    }

    private int getCols(){
        return cols;
    }

    public void allocate(int dim) throws  PlaceException{
        if(dim < MINDIM){
            throw new PlaceException("Board too small");
        }
        this.board = new ClientModel.colors[dim][dim];
        this.rows = dim;
        this.cols = dim;
    }

    public void initializeGame(){
        for(int x = 0; x < rows; ++x){
            for(int y = 0; y < cols; ++y){
                board[x][y] = colors.THREE;
            }
        }
    }

    public void update(String r, String c, String color){
        switch (color){
            case "A":
                board[Integer.parseInt(r)][Integer.parseInt(c)] = colors.A;
                break;
            case "B":
                board[Integer.parseInt(r)][Integer.parseInt(c)] = colors.B;
                break;
            case "C":
                board[Integer.parseInt(r)][Integer.parseInt(c)] = colors.C;
                break;
            case "D":
                board[Integer.parseInt(r)][Integer.parseInt(c)] = colors.D;
                break;
            case "E":
                board[Integer.parseInt(r)][Integer.parseInt(c)] = colors.E;
                break;
            case "F":
                board[Integer.parseInt(r)][Integer.parseInt(c)] = colors.F;
                break;
            case "0":
                board[Integer.parseInt(r)][Integer.parseInt(c)] = colors.ZERO;
                break;
            case "1":
                board[Integer.parseInt(r)][Integer.parseInt(c)] = colors.ONE;
                break;
            case "2":
                board[Integer.parseInt(r)][Integer.parseInt(c)] = colors.TWO;
                break;
            case "3":
                board[Integer.parseInt(r)][Integer.parseInt(c)] = colors.THREE;
                break;
            case "4":
                board[Integer.parseInt(r)][Integer.parseInt(c)] = colors.FOUR;
                break;
            case "5":
                board[Integer.parseInt(r)][Integer.parseInt(c)] = colors.FIVE;
                break;
            case "6":
                board[Integer.parseInt(r)][Integer.parseInt(c)] = colors.SIX;
                break;
            case "7":
                board[Integer.parseInt(r)][Integer.parseInt(c)] = colors.SEVEN;
                break;
            case "8":
                board[Integer.parseInt(r)][Integer.parseInt(c)] = colors.EIGHT;
                break;
            case "9":
                board[Integer.parseInt(r)][Integer.parseInt(c)] = colors.NINE;
                break;
        }

    }

    public void close(){
        super.setChanged();
        super.notifyObservers();
    }

    public String toString(){
        String s = "";
        for(int x = 0; x < rows; ++x){
            for(int y = 0; y < cols; ++y){
                switch (board[x][y]){
                    case ZERO:
                        s+= "0 ";
                        break;
                    case ONE:
                        s += "1 ";
                        break;
                    case TWO:
                        s+= "2 ";
                        break;
                    case THREE:
                        s += "3 ";
                        break;
                    case FOUR:
                        s+= "4 ";
                        break;
                    case FIVE:
                        s += "5 ";
                        break;
                    case SIX:
                        s+= "6 ";
                        break;
                    case SEVEN:
                        s += "7 ";
                        break;
                    case EIGHT:
                        s+= "8 ";
                        break;
                    case NINE:
                        s += "9 ";
                        break;
                    default:
                        s += board[x][y]+" ";
                        break;
                }
            }
            s += "\n";
        }
        return s;
    }
}