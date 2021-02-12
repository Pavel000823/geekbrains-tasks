package javaCore1.lesson8;

import javaCore1.lesson8.actions.CleanerAction;
import javaCore1.lesson8.actions.SendMessageAction;

import javax.swing.*;
import java.awt.*;

public class Chat extends JFrame {

    private JButton send;
    private JButton removeMessage;

    private JButton exit;
    private JTextArea messageArea;
    private JTextField inputField;


    // создаем наши панели
    private void initializationPanels() {
        setTextField();
        setButtons();
        setArea();
    }

    // создаем окно
    public void myWindow() {
        setTitle("Chat");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setScreenSize();
        setResizable(true);
        initializationPanels();
        setVisible(true);
    }

    // надстройка тектовой области
    private void setArea() {
        messageArea = new JTextArea(8, 20);
        messageArea.setEditable(false);
        ScrollPane scrollPane = new ScrollPane(ScrollPane.SCROLLBARS_ALWAYS);
        scrollPane.add(messageArea);
        add(scrollPane, BorderLayout.CENTER);
    }

    // надстройка кнопок
    private void setButtons() {
        JPanel buttonPanel = new JPanel();
        send = new JButton("Отправьте сообщение");
        removeMessage = new JButton("Удалить сообщение");
        exit = new JButton("Выйти");

        buttonPanel.add(send);
        buttonPanel.add(removeMessage);
        buttonPanel.add(exit);

        add(buttonPanel, BorderLayout.NORTH);

        // временно, до появления бека
        send.addActionListener(new SendMessageAction(this));
        removeMessage.addActionListener(new CleanerAction(this));
        exit.addActionListener(e -> System.exit(0));
    }

    // надстройка поля ввода
    private void setTextField() {
        JPanel underPanel = new JPanel();
        inputField = new JTextField();
        underPanel.setLayout(new GridLayout(2, 1));
        underPanel.add(new JLabel("Введите сообщение"));
        underPanel.add(inputField);
        ;
        add(underPanel, BorderLayout.SOUTH);
        inputField.addActionListener(new SendMessageAction(this));
    }

    // формируем размер окна в зависимости от экрана
    private void setScreenSize() {
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        setBounds(0, 0, screenWidth / 3, screenHeight / 3);
    }

    public JButton getSend() {
        return send;
    }

    public JButton getRemoveMessage() {
        return removeMessage;
    }

    public JButton getExit() {
        return exit;
    }

    public JTextArea getMessageArea() {
        return messageArea;
    }

    public JTextField getInputField() {
        return inputField;
    }
}
