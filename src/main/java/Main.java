import Service.EruditService;
import Service.UserInterfaceService;
import Service.VocabularyService;
import models.Vocabulary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

/**
 * Created by Bill on 14.04.2019.
 */
public class Main {

    public static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main (String[] args) throws SQLException, IOException {
        Vocabulary voc1 = new Vocabulary();
        VocabularyService vocService = new VocabularyService(voc1);
        int i = 10;
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
        }

    }


}
