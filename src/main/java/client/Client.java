package main.java.client;

import main.java.Connection;
import main.java.ConsoleHelper;
import main.java.Message;
import main.java.MessageType;

import java.io.IOException;

public class Client {
    protected Connection connection;
    private volatile boolean clientConnected;

    public class SocketThread extends Thread {

    }

    protected String getServerAddress() {
        ConsoleHelper.writeMessage("Please enter the server ip address");
        return ConsoleHelper.readString();
    }

    protected int getServerPort() {
        ConsoleHelper.writeMessage("Please enter the server port number");
        return ConsoleHelper.readInt();
    }

    protected String getUserName() {
        ConsoleHelper.writeMessage("Please enter the user name");
        return ConsoleHelper.readString();
    }

    protected boolean shouldSendTextFromConsole() {
        return true;
    }

    protected SocketThread getSocketThread() {
        return new SocketThread();
    }

    protected void sendTextMessage(String text) {
        try {
            Message message = new Message(MessageType.TEXT, text);
            connection.send(message);
        } catch (IOException e) {
            ConsoleHelper.writeMessage("The message can not be delivered");
            clientConnected = false;
        }
    }
}
