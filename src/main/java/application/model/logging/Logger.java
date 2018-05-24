package application.model.logging;

import application.model.action.Action;
import application.model.generated.Situation;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {

    private static Logger instance;
    private StringBuilder stringBuilder;

    private Logger() {
        newLog();
    }

    public static Logger getInstance() {
        if (instance == null)
            instance = new Logger();
        return instance;
    }

    public void newLog() {
        this.stringBuilder = new StringBuilder();
    }

    public void LogAction(Action action) {
        stringBuilder.append(action.toString());
    }

    public void LogAction(String action) {
        stringBuilder.append(action);
    }

    public void LogCurrentSituation(Situation situation) {
        stringBuilder.append(situation.toString());
    }

    public void LogCurrentSituation(String situation) {
        stringBuilder.append(situation);
    }

    public void writeLog() {
        try {
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm"));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File( timestamp + ".txt")));
            bufferedWriter.write(stringBuilder.toString());
            bufferedWriter.close();
            this.newLog();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
