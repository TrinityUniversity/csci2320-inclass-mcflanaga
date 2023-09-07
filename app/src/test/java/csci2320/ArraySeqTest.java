package csci2320;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ArraySeqTest {
    @Test void insert1() {
        ArraySeq<Integer> seq = new ArraySeq<>();
        seq.insert(0, 7);
        assertEquals(7, seq.get(0), "Wrong value at index 0.");
      }
}
