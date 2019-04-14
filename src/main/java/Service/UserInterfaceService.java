package Service;

import models.Vocabulary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Created by Bill on 14.04.2019.
 */
public class UserInterfaceService {

    private VocabularyService vocService;
    private Vocabulary voc1; //моя изначальная чистая сущность, которую я потом могу внести в бд
    private Vocabulary voc2; //моя сущность, которую я получаю из бд. С ней уже можно апдейтить/удалять записи

    public BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public UserInterfaceService(VocabularyService vocService, Vocabulary voc1) {
        this.vocService = vocService;
        this.voc1 = voc1;
    }

    public void showInterface() throws IOException {
        int i = 10;
        while (i != 0) {
            System.out.println("Выберите действие: \n1. Создание новой записи в бд\n2. Удаление записи в бд\n3. Обновление записи в бд \n4. Поиск записи в бд \n5. Показать все записи \n0. Выход из программы");
            i = Integer.parseInt(reader.readLine());
            switch (i) {
                case 1: insertQuery(); break;
                case 2: deleteQuery(); break;
                case 3: updateQuery(); break;
                case 4: selectQuery(); break;
                case 5: selectAllQuery(); break;

            }
        }
    }

    public void insertQuery() throws IOException {
        System.out.println("Введите слово:");
        voc1.setWord(reader.readLine());
        System.out.println("Введите комментарий");
        voc1.setComment(reader.readLine());
        System.out.println("Сохраняю в бд");
        vocService.saveVocabulary(voc1);
        System.out.println("Сохраненный обьект: \n"+voc1.toString() );
    }

    public void selectQuery() throws IOException {
        System.out.println("Введите айдишник");
        System.out.println(vocService.findVocabulary(Integer.parseInt(reader.readLine())).toString());
    }

    public void updateQuery() throws IOException {
        System.out.println("Введите айдишник записи, которую хотите проапдейтить");
        voc2 = vocService.findVocabulary(Integer.parseInt(reader.readLine()));
        System.out.println("Введите новое название слова");
        voc2.setWord(reader.readLine());
        System.out.println("Введите новый комментарий");
        voc2.setComment(reader.readLine());
        vocService.updateVocabulary(voc2);
        System.out.println("Апдейт выполнен");
        vocService.findVocabulary(voc2.getId());
    }

    public void deleteQuery() throws IOException {
        System.out.println("Введите айдишник записи, которую хотите удалить");
        voc2 = vocService.findVocabulary(Integer.parseInt(reader.readLine()));
        vocService.deleteVocabulary(voc2);
        System.out.println("Запись удалена");

    }

    public void selectAllQuery() {
        System.out.println("Показываю все, что есть");
        List<Vocabulary> list = vocService.showAllVocabulary();
        for(Vocabulary e: list) {
            System.out.println(e.toString());
        }
    }

}
