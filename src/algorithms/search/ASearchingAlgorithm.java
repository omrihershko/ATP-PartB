package algorithms.search;

import java.util.Collections;

public abstract class ASearchingAlgorithm implements ISearchingAlgorithm {
    protected int numberOfNodesEvaluated = 0;


    @Override
        public int getNumberOfNodesEvaluated() {
            return numberOfNodesEvaluated;
    }
    public void setNumberOfNodesEvaluated(int numberOfNodesEvaluated) {
        this.numberOfNodesEvaluated = numberOfNodesEvaluated;
    }
    static Solution reconstructPath(AState goalState)
    {
        Solution solution = new Solution();
        AState current = goalState;
        while (current != null)
        {
            solution.add_State(current);
            current = current.getParent();
        }
        Collections.reverse(solution.getPath());  // Reverse the path to start from the initial state
        return solution;
    }
}
