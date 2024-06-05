package algorithms.search;

import java.io.Serializable;

public  abstract class AState  {
    private int cost;
    private AState parent;  // Renamed for clarity

    public AState() {
        this.parent = null;
        this.cost = 0;
    }

    public AState(int cost, AState parent) {
        this.cost = cost;
        this.parent = parent;
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

    // Override equals and hashCode if necessary, based on specific use case
}
