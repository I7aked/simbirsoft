import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class HTMLParser {
    public Set<String> doc(String webAdres) throws IOException {

        Document doc = Jsoup.connect(webAdres).get();
        String bodySite = doc.body().toString();
        Document siteDoc = Jsoup.parse(bodySite);

        String allWEBSiteText = siteDoc.outerHtml().replaceAll("<script.*?</script>", "");
        allWEBSiteText = allWEBSiteText.replaceAll("<.*?[\\n]?.*?[\\t]?.*?>", "");
        String[] masOfStrings = allWEBSiteText.split("\\n");
        Set<String> setOfStrings = Arrays.stream(masOfStrings)
                .map(str -> str.replaceAll("\\,", " "))
                .map(str -> str.replaceAll("\"", " "))
                .map(str -> str.replaceAll("\',", " "))
                .map(str -> str.replaceAll("\\.", " "))
                .map(str -> str.replaceAll("\\!", " "))
                .map(str -> str.replaceAll("\\?", " "))
                .map(str -> str.replaceAll("\\r", " "))
                .map(str -> str.replaceAll("\\t", " "))
                .map(str -> str.replaceAll("\\;", " "))
                .map(str -> str.replaceAll("\\“", " "))
                .map(str -> str.replaceAll("\\:", " "))
                .map(str -> str.replaceAll("\\(", " "))
                .map(str -> str.replaceAll("\\)", " "))
                .map(str -> str.replaceAll("\\]", " "))
                .map(str -> str.replaceAll("\\[", " "))
                .map(str -> str.replaceAll("\\t", " "))
                .map(str -> str.replaceAll("»", " "))
                .map(str -> str.replaceAll("«", " "))
                .map(str -> str.replaceAll("'", " "))
                .map(str -> str.trim())
                .collect(Collectors.toSet());

        return setOfStrings;


    }
}


