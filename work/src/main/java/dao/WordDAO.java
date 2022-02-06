package dao;

import Entity.Word;

import java.util.List;

public interface WordDAO
{
    public List<Word> getAllWords();

    public void saveWord(String str, Integer count);



}
