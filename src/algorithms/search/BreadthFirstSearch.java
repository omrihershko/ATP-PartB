package algorithms.search;

import java.util.*;

public class BreadthFirstSearch extends ASearchingAlgorithm {



    public Solution solve(ISearchable searchable)
    {

        if (searchable == null) return null;
        Queue<AState> queue = new LinkedList<AState>();

        AState startState = searchable.getStartState();
        AState goalState = searchable.getGoalState();

        queue.add(startState);
        Set<AState> visited = new HashSet<>();  // Set to track visited states
        visited.add(startState);

        while (!queue.isEmpty())
        {
            AState currentState = queue.poll();

            // If the current state is the goal state, reconstruct the path from start to goal
            if (currentState.equals(goalState))
            {
                Solution solution = reconstructPath(currentState);
                this.setNumberOfNodesEvaluated(solution.getPath().size());
                return solution;
            }

            // Explore adjacent states
            for (AState neighbor : searchable.getAllPossibleStates(currentState))
            {
                if (!visited.contains(neighbor)) {
                    neighbor.setParent(currentState);  // Set the current state as the parent for path reconstruction
                    queue.add(neighbor);
                    visited.add(neighbor);
                }
            }
        }

        return null;  // Return null if no solution is found
    }



    @Override
    public String getName() {
        return "BreadthFirstSearch";
    }
}
