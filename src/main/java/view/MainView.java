package view;

import Service.EruditService;
import Service.UserInterfaceService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Bill on 23.07.2019.
 */
public class MainView {

    public static void showView() {
        JFrame mainFrame = new JFrame(); //Создал фрейм

        JLabel label1 = new JLabel("Выберите режим программы:");
        //label1.setBounds(100, 60, 200, 30);
        mainFrame.add(label1);

        JButton button1 = new JButton("1. Управление базой"); //создал кнопку, в конструкторе указал название
        //button.setBounds(130, 100, 200, 40); //указал позицию кнопки на фрейме и ее раземр; x, y, ширина, высота
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)  {
                try {
                    UserInterfaceService userInterface = new UserInterfaceService();
                    userInterface.showInterface();
                } catch (Exception exc) {}
            }
        });
        mainFrame.add(button1); // добавил на фрейм кнопку
        JButton button2 = new JButton("2. Помощник Эрудита");
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    new EruditService().showInterface();
                } catch (Exception exc) {}

            }
        });
        mainFrame.add(button2);

        mainFrame.setSize(400, 500); //установил размер фрейма; ширина, высота
        mainFrame.setLayout(new GridLayout(3, 1, 20, 20)); //установил лэйаут, можно и NULL оставить (строки, столбцы, отступ по горизонту, отсуп по вертикали)
        mainFrame.setVisible(true); //делаю фрейм видимым
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //добавление закрытия программы через крестик, иначе она тупо не остановится
    }
}
