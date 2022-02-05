import junit.framework.TestCase;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CountWordTest extends TestCase {

    Set<String> testSet = new HashSet<>();
    Map<String, Integer> expectedMap = new HashMap<>();

    @Override
    protected void setUp() throws Exception {
        testSet.add(new String("first second"));
        testSet.add(new String("два second"));
        testSet.add(new String("-3 second"));
        testSet.add(new String("два"));
    }

    public void testCount() {
        expectedMap.put("first", 1);
        expectedMap.put("second", 3);
        expectedMap.put("два", 2);

        CountWords countWords = new CountWords();
        Map<String, Integer> actualMap = countWords.count(testSet);

        assertEquals(expectedMap, actualMap);
    }

    @Override
    protected void tearDown() throws Exception {

    }

}
