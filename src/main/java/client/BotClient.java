package main.java.client;

import java.util.concurrent.ThreadLocalRandom;

public class BotClient extends Client {

    public static void main(String[] args) {

        BotClient botClient = new BotClient();
        botClient.run();
    }

    public class BotSocketThread extends SocketThread {

    }

    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    @Override
    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    @Override
    protected String getUserName() {
        return "date_bot_" + ThreadLocalRandom.current().nextInt(100);
    }
}
