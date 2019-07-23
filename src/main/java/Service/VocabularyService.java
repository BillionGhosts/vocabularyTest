package Service;

import dao.EntityDao;
import dao.vocabularyDao;
import models.Vocabulary;

import java.util.List;

/**
 * Created by Bill on 14.04.2019.
 */
public class VocabularyService {

    private vocabularyDao vocDao = new vocabularyDao();
    private Vocabulary voc;
    private EntityDao<Vocabulary> entityDao = new EntityDao<Vocabulary>(voc);

    public VocabularyService(Vocabulary v) {
        this.voc = v;
    }

    public Vocabulary findVocabulary (int id) {
        return entityDao.findById(id);
    }

    public void saveVocabulary() {
        entityDao.save();
    }

    public void deleteVocabulary() {
        entityDao.delete();
    }

    public void updateVocabulary() {
        entityDao.update();
    }

    public List<Vocabulary> showAllVocabulary() {
         return entityDao.showAll();
    }

    public List<Vocabulary> firstLetterVocabulary(char first) {
        return vocDao.firstLetterQuery(first);
    }

    public Vocabulary getVoc() {
        return voc;
    }
}
