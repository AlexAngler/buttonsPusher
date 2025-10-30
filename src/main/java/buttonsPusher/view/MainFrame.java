package buttonsPusher.view;

import buttonsPusher.controller.ButtonsController;
import buttonsPusher.controller.FileReaderController;

import javax.swing.*;
import java.awt.*;

public class MainFrame {

    public MainFrame() {
    }

    public static void run() {

//      Вычисление размеров экрана
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height;

        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("ButtonsPusher");
            frame.setLayout(new BorderLayout());
            frame.setMinimumSize(new Dimension(300, 200));
            frame.setResizable(true);
            frame.setSize(width / 3, height / 5); //вычисление размера окна;
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true); // показать фрейм

            // Панель для размещения текстового поля
            JPanel northPanel = new JPanel();
            JTextField pathFile = new JTextField(45);
            northPanel.add(pathFile);
            frame.add(northPanel, BorderLayout.NORTH);

            // Панель для размещения для значений рандомайзера
            JPanel centerPanel = new JPanel();
            JTextField MinValue = new JTextField("2", 10);
            JTextField MaxValue = new JTextField("30", 10);
            centerPanel.add(MinValue);
            centerPanel.add(MaxValue);
            frame.add(centerPanel, BorderLayout.CENTER);

            // Создаем панель для размещения кнопки
            JPanel southPanel = new JPanel();

            JButton button = new JButton("Push");
            button.setPreferredSize(new Dimension(150, 40)); //Устанавливаем размер кнопки
            button.addActionListener(e -> {
                FileReaderController fileReader = null;
                try {
                    fileReader = new FileReaderController(pathFile.getText(), new ButtonsController(new Robot()));
                } catch (AWTException ex) {
                    throw new RuntimeException(ex);
                }
                fileReader.SymbolicTraversal(MinValue.getText(), MaxValue.getText());
            });

            southPanel.add(button);
            frame.add(southPanel, BorderLayout.SOUTH);
        });
    }
}
