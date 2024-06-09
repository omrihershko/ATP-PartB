package algorithms.search;

import algorithms.mazeGenerators.Position;

public class MazeState extends AState{

   private Position current;

    public MazeState(Position my_position) {
        current=my_position;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        MazeState mazeState = (MazeState) obj;
        return current.getRowIndex() == mazeState.current.getRowIndex() &&
                current.getColumnIndex() == mazeState.current.getColumnIndex();
    }

    public Position getCurrent() {
        return current;
    }

    public void setCurrent(Position current) {
        this.current = current;
    }
    @Override
    public String toString() {
        return
                "(" + current.getRowIndex() + ", " + current.getColumnIndex() + ")";

    }
}
