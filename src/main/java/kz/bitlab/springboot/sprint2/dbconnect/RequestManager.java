package kz.bitlab.springboot.sprint2.dbconnect;

import kz.bitlab.springboot.sprint2.db.ApplicationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

@Component
public class RequestManager {

    @Autowired
    private DBConnector dbConnector;

    public ArrayList<ApplicationRequest> getRequestList(){
        ArrayList<ApplicationRequest> requests = new ArrayList<>();
        try{
            PreparedStatement preparedStatement = dbConnector.getConnection()
                    .prepareStatement("SELECT * FROM requests");

            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                ApplicationRequest req = new ApplicationRequest();
                req.setId(resultSet.getLong("id"));
                req.setUserName(resultSet.getString("userName"));
                req.setCourseName(resultSet.getString("courseName"));
                req.setCommentary(resultSet.getString("commentary"));
                req.setPhone(resultSet.getString("phone"));
                req.setHandled(resultSet.getBoolean("handled"));
                requests.add(req);
            }

            preparedStatement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return requests;
    }

    public void addRequest(ApplicationRequest req){
        try{
            PreparedStatement preparedStatement = dbConnector.getConnection()
                    .prepareStatement("INSERT INTO requests (userName, courseName, commentary, phone, handled) " +
                            "VALUES (?,?,?,?,?)" );

            preparedStatement.setString(1, req.getUserName());
            preparedStatement.setString(2, req.getCourseName());
            preparedStatement.setString(3, req.getCommentary());
            preparedStatement.setString(4, req.getPhone());
            preparedStatement.setBoolean(5, req.isHandled());

            preparedStatement.executeUpdate();

            preparedStatement.close();



            preparedStatement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
