package algorithms.search;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DepthFirstSearch extends  ASearchingAlgorithm
{
    Solution MySol = new Solution();
    @Override
    public Solution solve(ISearchable searchable)
    {
        if (searchable == null) return null;
        Stack<AState> stack = new Stack<AState>();
        stack.push(searchable.getStartState());
        while(!stack.isEmpty())
        {
           AState currentState = stack.pop();
           if(currentState.equals(searchable.getGoalState()))
           {
               Solution solution = reconstructPath(currentState);
               this.setNumberOfNodesEvaluated(solution.getPath().size()-1);
               solution.reverse();//______________________________________________________________________________________ i add
               return solution;
           }
           for(AState neighbor : searchable.getAllPossibleStates(currentState))
           {
               if(!neighbor.Is_visited())
               {
                   neighbor.setParent(currentState);
                   stack.push(neighbor);
                   neighbor.SetVisit();
               }
           }
        }
        return null;
    }

    @Override
    public String getName() {
        return "Depth First Search";
    }
}
