package service;

import Entity.Word;
import dao.WordDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

    @org.springframework.stereotype.Service
public class Service {

    @Autowired
    private WordDAO wordDAO;

    @Transactional
    public List<Word> getAllWords() {
        return wordDAO.getAllWords();
    }

    @Transactional
    public void saveWord(String str, Integer count) {
        wordDAO.saveWord(str, count);
    }


}
