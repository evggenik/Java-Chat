package main.java.client;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.ThreadLocalRandom;

public class BotClient extends Client {

    public static void main(String[] args) {

        BotClient botClient = new BotClient();
        botClient.run();
    }

    public class BotSocketThread extends SocketThread {

        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            sendTextMessage("Hello chat. I am bot. I accept these commands: " +
                    "date, day, month, year, time, hour, minutes, seconds.");
            super.clientMainLoop();
        }

        @Override
        protected void processIncomingMessage(String message) {
            super.processIncomingMessage(message);
            if (!message.contains(":")) return;
            String[] parts = message.split(":", 2);
            if (parts.length != 2) return;

            String userName = parts[0];
            String text = parts[1].trim();

            String pattern;

            switch (text) {
                case "дата" -> pattern = "d.MM.YYYY";
                case "день" -> pattern = "d";
                case "месяц" -> pattern = "MMMM";
                case "год" -> pattern = "YYYY";
                case "время" -> pattern = "H:mm:ss";
                case "час" -> pattern = "H";
                case "минуты" -> pattern = "m";
                case "секунды" -> pattern = "s";
                default -> { return; }
            }
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            String result = sdf.format(Calendar.getInstance().getTime());
            sendTextMessage(
                    "Информация для " + userName + ": " + result
            );
        }

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
