package service;

import Entity.Word;
import dao.WordDAOimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

    @Service
public class ServiceWord {

    @Autowired
    private WordDAOimpl wordDAO;

    @Transactional
    public List<Word> getAllWords() {
        return wordDAO.getAllWords();
    }

    @Transactional
    public void saveWord(String str, Integer count) {
        wordDAO.saveWord(str, count);
    }


}
