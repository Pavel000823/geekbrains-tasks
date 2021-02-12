package javaCore1.lesson8.actions;

import javaCore1.lesson8.Chat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CleanerAction implements ActionListener {

    private final Chat chat;

    public CleanerAction(Chat chat) {
        this.chat = chat;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        chat.getInputField().setText("");
    }
}
