package algorithms.mazeGenerators;

public class Position {
    private int row;
    private int column;
    public Position(int row, int column)
    {
        this.row = row;
        this.column = column;
    }
    public int getRowIndex() {
        return row;
    }

    public int getColumnIndex() {
        return column;
    }

       public boolean equals(Position p) {
        return (this.row == p.getRowIndex() && this.column == p.getColumnIndex());
    }
    public boolean SameAsOther(int row, int column) {
        return (this.row == row && this.column == column);
    }
    @Override
    public String toString() {
        return "{" + column + "," + row + "}";
    }
}