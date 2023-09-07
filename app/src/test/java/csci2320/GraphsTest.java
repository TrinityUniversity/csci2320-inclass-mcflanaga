package csci2320;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import org.junit.jupiter.api.Test;

public class GraphsTest {
    @Test void simpleGraphNoCycles() {
        List<List<Integer>> graph = List.of(
            List.of(1,2),
            List.of(2),
            List.of(3),
            List.of()
        );
        var dist = Graphs.recursiveDFSShort(graph, 0, 3);
        assertEquals(2, dist, "Wrong distance on simple graph with no cycles.");
    }
    @Test void smallGraphCycles() {
    List<List<Integer>> graph = List.of(
      List.of(0,1,2),
      List.of(2),
      List.of(1,3),
      List.of()
    );
    var dist = Graphs.recursiveDFSShort(graph, 0, 3);
    assertEquals(2, dist, "Wrong distance on simple graph with cycles.");
  }
}
