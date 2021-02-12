package javaCore1.lesson8.actions;

import javaCore1.lesson8.Chat;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class SendMessageAction implements ActionListener, KeyListener {
    private final Chat chat;


    public SendMessageAction(Chat chat) {
        this.chat = chat;
    }

    private void sendMessage() {
        JTextArea area = chat.getMessageArea();
        String message = chat.getInputField().getText();
        if (message.equals("")) {
            return;
        }
        chat.getInputField().setText("");
        area.append(message + " \n");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        sendMessage();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            sendMessage();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("Здесь пока нет события");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("Здесь пока нет события");
    }
}
