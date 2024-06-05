package algorithms.search;

public class MazeState extends AState{

    private int row;

    private int col;

    private int cost;

    private MazeState last_step;  // last_step state in the path


    public MazeState(int row, int col) {
        this.row = row;
        this.col = col;
        this.cost=0;
        this.last_step = null;
    }
    public int getRow() {
        return row;
    }

    public int getColumn() {
        return col;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public MazeState getParent() {
        return last_step;
    }

    public void last_step(MazeState parent) {
        this.last_step = parent;
    }


    public void setRow(int row) {
        this.row = row;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public void setLast_step(MazeState last_step) {
        this.last_step = last_step;
    }
}
