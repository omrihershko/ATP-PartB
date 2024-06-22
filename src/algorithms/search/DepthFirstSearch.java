package algorithms.search;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DepthFirstSearch extends  ASearchingAlgorithm
{
    @Override
    public Solution solve(ISearchable searchable)
    {
        if (searchable == null) return new Solution();
        Stack<AState> stack = new Stack<AState>();
        stack.push(searchable.getStartState());
        while(!stack.isEmpty())
        {
           AState currentState = stack.pop();
           currentState.SetVisit();
           if(currentState.equals(searchable.getGoalState()))
           {
               Solution solution = reconstructPath(currentState);
               this.setNumberOfNodesEvaluated(solution.getPath().size()-1);
               solution.reverse();//______________________________________________________________________________________ i add
               searchable.restartMaze();
               return solution;
           }
            List<AState> neighbors = searchable.getAllPossibleStates(currentState);
           if(neighbors != null) {
               for (AState neighbor : neighbors) {
                   if (!neighbor.Is_visited()) {
                       neighbor.setParent(currentState);
                       stack.push(neighbor);
                       neighbor.SetVisit();
                   }
               }
           }
        }
        searchable.restartMaze();
        return null;
    }

    @Override
    public String getName() {
        return "Depth First Search";
    }
}
