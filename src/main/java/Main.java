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
        VocabularyService vocService = new VocabularyService();
        Vocabulary voc1 = new Vocabulary();
        int i = 10;
        while (i!=0) {
            System.out.println("Выберете режим \n1. Управление БД \n0. Выход");
            i = Integer.parseInt(bufferedReader.readLine());
            switch (i) {
                case 1: UserInterfaceService userInterface = new UserInterfaceService(vocService, voc1);
                        userInterface.showInterface();
                        break;
            }
        }

    }


}
