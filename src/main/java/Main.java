import Service.VocabularyService;
import models.Vocabulary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

import static view.MainView.showView;

/**
 * Created by Bill on 14.04.2019.
 */
public class Main {

    public static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main (String[] args) throws SQLException, IOException {
        VocabularyService vocService = new VocabularyService();
        Vocabulary voc1 = new Vocabulary();

        /**
         * статический метод из @MainView
         */
        showView(); //

        //Логика для тесктового интерфейса
        /*int i = 10;
        while (i!=0) {
            System.out.println("Выберете режим \n1. Управление БД \n2. Помощник эрудита \n0. Выход");
            i = Integer.parseInt(bufferedReader.readLine());
            switch (i) {
                case 1:
                        UserInterfaceService userInterface = new UserInterfaceService(vocService, voc1);
                        userInterface.showInterface();
                        break;
                case 2:
                        new EruditService(vocService, voc1).showInterface(); break;
            }
        }*/

    }


}
