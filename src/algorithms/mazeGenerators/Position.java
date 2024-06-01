package algorithms.mazeGenerators;

public class Position {
    private int row;
    private int column;

    public int getRowIndex() {
        return row;
    }

    public int getColumnIndex() {
        return column;
    }

    @Override
    public String toString() {
        return "{" + column + "," + row + "}";
    }
}