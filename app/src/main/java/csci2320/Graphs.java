package csci2320;

import java.util.List;
import java.util.Set;
import java.util.HashSet;

public class Graphs {
  int[][] matrix = {
    {1,1,1,0},
    {0,0,1,1},
    {0,0,0,1},
    {0,1,0,0}
  };

  List<Set<Integer>> adjList = List.of(
    Set.of(0,1,2),
    Set.of(2,3),
    Set.of(3),
    Set.of(1)
  );

  int[][] maze = {
    {0,1,0,0,0,0,0,0,0,0},
    {0,1,0,1,1,1,0,0,1,0},
    {0,1,0,0,0,1,0,0,1,0},
    {0,1,1,1,0,1,1,1,1,0},
    {0,0,0,0,0,0,0,0,1,0},
    {0,1,1,1,1,0,1,1,1,0},
    {0,1,0,0,0,0,0,0,1,0},
    {0,1,0,1,1,1,1,0,1,0},
    {0,1,0,1,0,0,1,0,1,0},
    {0,1,0,0,0,0,0,0,1,0}
  };

  public static Graphs makeEmpty() {
    return new Graphs();
  }

  public static int recursiveDFSShort( List<List<Integer>> graph, int current, int end) {
    return recursiveDFSShort2(graph, current, end, new HashSet<Integer>());
  }

  private static int recursiveDFSShort2(List<List<Integer>> graph, int current, int end, Set<Integer> visited) {
    if (current == end) {
        return 0;
    } else {
      int minDist = 1000000000;
      Set<Integer> newVisited = new HashSet<>(visited);
      newVisited.add(current);
      for (int dest: graph.get(current)) {
        if (!newVisited.contains(dest)) {
          int dist = recursiveDFSShort2(graph, dest, end, newVisited);
          if (dist < minDist) minDist = dist;
       }
      }
      return minDist + 1;
    }
  }
}