package algorithms.search;

import java.util.*;

public class BreadthFirstSearch extends ASearchingAlgorithm {



    public Solution solve(ISearchable searchable) {
        if (searchable == null) return null;
        Queue<AState> queue = new LinkedList<AState>();

        AState startState = searchable.getStartState();
        AState goalState = searchable.getGoalState();

        queue.add(startState);
        Set<AState> visited = new HashSet<>();  // Set to track visited states
        visited.add(startState);

        while (!queue.isEmpty()) {
            AState currentState = queue.poll();

            // If the current state is the goal state, reconstruct the path from start to goal
            if (currentState.equals(goalState)) {
                return reconstructPath(currentState);
            }

            // Explore adjacent states
            for (AState neighbor : searchable.getAllPossibleStates(currentState)) {
                if (!visited.contains(neighbor)) {
                    neighbor.setParent(currentState);  // Set the current state as the parent for path reconstruction
                    queue.add(neighbor);
                    visited.add(neighbor);
                }
            }
        }

        return null;  // Return null if no solution is found
    }

    private Solution reconstructPath(AState goalState) {
        Solution solution = new Solution();
        AState current = goalState;
        while (current != null) {
            solution.add_State(current);
            current = current.getParent();
        }
        Collections.reverse(solution.getPath());  // Reverse the path to start from the initial state
        return solution;
    }

    @Override
    public String getName() {
        return "BreadthFirstSearch";
    }
}
