package algorithms.search;

import java.util.PriorityQueue;

public class BestFirstSearch extends  BreadthFirstSearch{

public BestFirstSearch()
{
    super();
    //Defining the queue as a priority queue with a comparator that compares the cost of the states
    queue = new PriorityQueue<AState>((a,b) -> (int)(a.getCost() - b.getCost()));
}
    @Override
    public Solution solve(ISearchable searchable)
    {
        return super.solve(searchable);
    }

    @Override
    public String getName() {
        return "Best First Search";
    }
}
