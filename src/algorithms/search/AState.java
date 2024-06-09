package algorithms.search;

public  abstract class AState  {
    private int cost;
    private AState parent;  // Renamed for clarity

    private boolean is_visited;

    public AState() {
        this.is_visited = false;

    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public AState getParent() {
        return parent;
    }

    public void setParent(AState parent) {
        this.parent = parent;
    }

    public boolean isIs_visited() {
        return is_visited;
    }

    // Override equals and hashCode if necessary, based on specific use case
}
