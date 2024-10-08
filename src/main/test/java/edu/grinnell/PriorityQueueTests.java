package java.edu.grinnell;

import static org.junit.Assert.*;
import java.util.Comparator;
import org.junit.Before;
import org.junit.Test;
import edu.grinnell.csc207.linear.BuiltinPriorityQueue;

public class PriorityQueueTests {
  @Test
  public void test1() throws Exception {
    BuiltinPriorityQueue<Integer> testQueue = new BuiltinPriorityQueue<Integer>(3,new IntComparator());
    testQueue.put(1);
    testQueue.put(2);
    testQueue.put(3);
    assertEquals("Equals 1",1,testQueue.get().intValue());
    assertEquals("Equals 2",2,testQueue.get().intValue());
    assertEquals("Equals 3",3,testQueue.get().intValue());

  }
  class StringComparator implements Comparator<String> {
    public int compare(String str1, String str2) {
      // Efficiency hack: If two strings occupy the same memory
      // they are equal.
      if (str1 == str2) { return 0; }
      // Safety check: If either string is null, compareTo may fail,
      // so we make sure neither is null.  We treat null as "smaller"
      // than any other string.
      if (str1 == null) { return -1; }
      if (str2 == null) { return 1; }
      // Finally, we can use the built-in `compareTo` method.
      return str1.compareTo(str2);
    } // compare(String, STring)
  } // StringComparator
  
  class IntComparator implements Comparator<Integer> {
    public int compare(Integer i, Integer j) {
      // While this method sometimes gets implemented as i-j, that
      // implementation presents overflow risks, so we choose a
      // somewhat more verbose approach.
      if (i < j) { return -1; }
      else if (j < i) { return 1; }
      else return 0;
    } // compare(Integer, Integer)
  } // IntegerComparator
}
