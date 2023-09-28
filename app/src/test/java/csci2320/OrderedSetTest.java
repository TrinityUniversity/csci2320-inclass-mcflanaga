package csci2320;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;

public class OrderedSetTest {

  @Test void addContains() {
    var set = new OrderedSet<Integer>();
    assertTrue(set.add(5));
    assertTrue(set.add(3));
    assertTrue(set.add(8));
    assertTrue(set.add(6));
    assertTrue(set.add(2));
    assertTrue(set.add(1));
    assertTrue(set.add(9));
    assertFalse(set.add(3));
    System.out.println(set.toStringPreorder());
    System.out.println(set.toStringPostorder());
    System.out.println(set.toString());
    assertTrue(set.contains(5));
    assertTrue(set.contains(3));
    assertTrue(set.contains(8));
    assertTrue(set.contains(6));
    assertTrue(set.contains(2));
    assertTrue(set.contains(1));
    assertTrue(set.contains(9));
    assertFalse(set.contains(4));

  }

 /* @Test void subrange() {
    var set = new OrderedSet<Integer>();
    assertTrue(set.add(5));
    assertTrue(set.add(3));
    assertTrue(set.add(8));
    assertTrue(set.add(6));
    assertTrue(set.add(2));
    assertTrue(set.add(1));
    assertTrue(set.add(9));
    assertFalse(set.add(3));
    var subset = set.searchRange(4, 6);
    assertTrue(subset.contains(5));
    assertTrue(subset.contains(6));
    assertFalse(subset.contains(7));
    assertFalse(subset.contains(4));
    var subset2 = set.searchRange(7, 9);
    assertTrue(subset2.contains(7));
    assertTrue(subset2.contains(8));
    assertFalse(subset2.contains(9));
    assertFalse(subset2.contains(4));
  }
  */
}
