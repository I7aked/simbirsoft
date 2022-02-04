import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CountWords {
    public Map<String, Integer> count(Set<String> set) {
        Map<String, Integer> countWordsMap = new HashMap<>();
        String regex = "^([a-z]*[а-я]*)$";
        Pattern pattern = Pattern.compile(regex);

        for (String oneString : set) {
            String[] localString = oneString.split("\\s");

            for (int i = 0; i < localString.length; i++) {
                Matcher matcher = pattern.matcher(localString[i]);
                if (matcher.matches()) {
                    countWordsMap.put(localString[i], countWordsMap.getOrDefault(localString[i], 0) + 1);
                }
            }
        }

        countWordsMap.remove("");
        return countWordsMap;
    }


}
