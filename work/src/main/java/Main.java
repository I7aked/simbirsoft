import service.ServiceWord;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;

import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class.getName());
    private static final Marker INPUT_HISTORY_MARKER = MarkerManager.getMarker("INPUT_HISTORY");
    private static final Marker EXCEPTION_MARKER = MarkerManager.getMarker("EXCEPTION");


    public static void main(String[] args) {

        ServiceWord serviceWord = new ServiceWord();
        Set<String> wordsSet = new HashSet<String>();
        HTMLParser parser = new HTMLParser();
        System.out.println("Введите сайт, который будем парсить");
        Scanner scanner = new Scanner(System.in);
        String webAdres = scanner.nextLine();
        LOGGER.info(INPUT_HISTORY_MARKER,"Пользователь ввёл сайт {}",webAdres);

        try {
            wordsSet = parser.doc(webAdres);
        } catch (Exception e) {
            System.out.println("Возможно Вы ошиблись или такого сайта не существует");
            LOGGER.error(EXCEPTION_MARKER,"Ошибка при указании адреса сайта");
        }

        CountWords countWords = new CountWords();
        Map<String, Integer> resultMap = countWords.count(wordsSet);

        resultMap.entrySet().forEach(entry -> {
//            service.saveWord(entry.getKey(),entry.getValue() );
            System.out.println(entry.getKey() + " " + entry.getValue());
        });

//        service.getAllWords().forEach(System.out::println);


    }
}
