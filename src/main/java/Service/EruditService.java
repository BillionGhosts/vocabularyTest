package Service;

import models.Vocabulary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bill on 14.04.2019.
 */
public class EruditService {
    /**
     * Модуль помощника эрудита
     */

    private VocabularyService vocService;
    private Vocabulary voc1;

    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private List<String> listOfWords = new ArrayList<String>();                 //лист слов для сравнивания, полученный из слов из listOfVocabulary, чтобы сравнивать String
    private List<Vocabulary> listOfVocabularyForIteration;                      //костыль для итерации, чтобы достать все слова из квери
    private List<Vocabulary> listOfVocabulary = new ArrayList<Vocabulary>();    //непосредственно список готовых сущностей для сравнивания
    private String inputLetters;                                                //входище буквы, которые вводит пользователь
    private String[] letters;                                                   //массив этих самых букв, в каждой ячейке - буква. Тоже костыль наверн, чтобы потом достать из ячейки чар

    public EruditService() {

        vocService = new VocabularyService();
        voc1 = new Vocabulary();
    }

    public void showInterface() throws IOException{
        System.out.println("Введите буквы, которые у вас есть. Вводить с пробелом");
        inputLetters = reader.readLine();
        letters = inputLetters.split(" ");
        for (String e : letters) {
            System.out.println(e);
        }
        gameLogic();

    }

    public void gameLogic() {
        /*char firstLetter = letters[0].charAt(0);
        System.out.println("Первая буква: "+firstLetter);*/
        String result = "";
        ArrayList<String> resultArray = new ArrayList<String>();
        for (int i=0;i< letters.length;i++) {
            listOfVocabularyForIteration = (vocService.firstLetterVocabulary(letters[i].charAt(0)));
            for (Vocabulary e: listOfVocabularyForIteration) {
                listOfVocabulary.add(e);
            }
        }

        for (Vocabulary e: listOfVocabulary) {
            listOfWords.add(e.getWord());
            System.out.println(e.getWord());
        }

        //Достаем слова из массива и делим их на буквы
        for (String e: listOfWords) {
            e = e.toUpperCase();
            String[] a = e.split("");
            ArrayList<String> b = new ArrayList<String>();
            for (String es: letters) {
                b.add(es);
            }
            //проверим равняется ли количество введенных буквы количеству букв, которое есть в слове
            if (a.length == letters.length) {
                for (int i = 0; i < a.length ;i++) {
                    for (int j=0; j < b.size();j++ ) {
                        if (a[i].equals(b.get(j))) {
                            result = result+b.get(j);
                            b.remove(j);
                            break;
                        }
                    }
                }
            }
            if (result.equals(e)) {System.out.println(result); resultArray.add(result);} else result = "";
        }
        if (resultArray.isEmpty()) System.out.println("Слов не найдено"); else {
            System.out.println("Список подходящих слов:");
            for (String e: resultArray) {
                System.out.println(e);
            }
        }

    }

}
