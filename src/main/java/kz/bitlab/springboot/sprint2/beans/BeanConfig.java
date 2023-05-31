package kz.bitlab.springboot.sprint2.beans;

import kz.bitlab.springboot.sprint2.dbconnect.DBConnector;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;


@Configuration
public class BeanConfig {


    @Bean
    public DBConnector connection(){
        DBConnector dbConnector = new DBConnector("jdbc:mysql://localhost:3306/techbootdb", "root", "");
        return dbConnector;
    }

}