package hashroll;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
public class AppTest{
    RabinKarpRollingHash rabinKorp = new RabinKarpRollingHash();
    @Test
    public void smallSequenceTest()
    {
        
        String originalString = "ababababab";
        String pattern = "abab";
        ArrayList<Integer> answer = new ArrayList<>();
        answer.add(0);
        answer.add(2);
        answer.add(4);
        answer.add(6);
        assertTrue(answer.equals(rabinKorp.search(pattern, originalString)));

    }


    @Test
    public void mediumSequenceTest()
    {
        
        String originalString = "thequickbrownfoxjumpsoverthelazydogthequickbrownfoxjumpsoverthelazydog";
        String pattern = "quickbrown";
        ArrayList<Integer> answer = new ArrayList<>();
        answer.add(3);
        answer.add(38);
        assertTrue(answer.equals(rabinKorp.search(pattern, originalString)));

    }

    @Test
    public void largeSequenceTest()
    {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 34; i++) { 
            sb.append("abc");
        }

        String originalString = sb.toString();
        String pattern = "abcabc";
        ArrayList<Integer> answer = new ArrayList<>(Arrays.asList(0, 3, 6, 9, 12, 15, 18, 21, 24, 27, 30, 33, 36, 39, 42, 45, 48, 51, 54, 57,
        60, 63, 66, 69, 72, 75, 78, 81, 84, 87, 90, 93, 96));
        assertTrue(answer.equals(rabinKorp.search(pattern, originalString)));

    }
    
}
