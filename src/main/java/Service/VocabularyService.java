package Service;

import dao.vocabularyDao;
import models.Vocabulary;

import java.util.List;

/**
 * Created by Bill on 14.04.2019.
 */
public class VocabularyService {

    private vocabularyDao vocDao = new vocabularyDao();

    public VocabularyService() {}

    public Vocabulary findVocabulary (int id) {
        return vocDao.findById(id);
    }

    public void saveVocabulary(Vocabulary voc) {
        vocDao.save(voc);
    }

    public void deleteVocabulary(Vocabulary voc) {
        vocDao.delete(voc);
    }

    public void updateVocabulary(Vocabulary voc) {
        vocDao.update(voc);
    }

    public List<Vocabulary> showAllVocabulary() {
        return vocDao.showAll();
    }

    public List<Vocabulary> firstLetterVocabulary(char first) {
        return vocDao.firstLetterQuery(first);
    }


}
