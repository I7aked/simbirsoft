package dao;

import Entity.Word;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class WordDAOimpl implements WordDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Word> getAllWords() {
        Session session = sessionFactory.getCurrentSession();
        Query<Word> query = session.createQuery("from Word", Word.class);
        List<Word> allWords = query.getResultList();
        return allWords;
    }

    @Override
    public void saveWord(String str, Integer count) {
        Session session = sessionFactory.getCurrentSession();
        Word word = new Word(str, count);
        session.save(word);
    }

    public WordDAOimpl() {
    }
}
