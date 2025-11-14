package AsishPratapProblems.EASY.LoggingFrameWork.V1.Entities.OutputDestination;

import AsishPratapProblems.EASY.LoggingFrameWork.V1.Entities.LogMessage;

import java.io.FileWriter;
import java.io.IOException;

public class FileLog implements OutputDestination{
    String filePath;
    public FileLog(String filePath){
        this.filePath = filePath;
    }

    @Override
    public void processLog(LogMessage message) {
        try(FileWriter fw = new FileWriter(filePath, true)) {
            fw.write(message.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
