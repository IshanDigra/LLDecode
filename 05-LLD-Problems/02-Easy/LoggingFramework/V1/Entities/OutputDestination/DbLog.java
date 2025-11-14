package AsishPratapProblems.EASY.LoggingFrameWork.V1.Entities.OutputDestination;

import AsishPratapProblems.EASY.LoggingFrameWork.V1.Entities.LogMessage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DbLog implements OutputDestination{
    private String url ;
    private String username;
    private String password;
    private final String query = "INSERT into logs (level, message, timestamp) values (?,?,?)";
    public DbLog(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    @Override
    public void processLog(LogMessage message) {
        try(Connection connection = DriverManager.getConnection(url,username, password)){
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, message.getLvl().toString());
            statement.setString(2, message.getContent());
            statement.setTimestamp(3, message.getTime());

            statement.executeUpdate();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
