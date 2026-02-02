package com.edutech.progressive.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

public class DatabaseConnectionManager {

    @Autowired
    private static Environment env;

    private static Properties properties = new Properties();

    private static void loadProperties()throws IOException{
        properties.load(new FileInputStream("/home/coder/app/server/src/main/resources/application.properties"));
        // String url = env.getProperty("spring.datasource.url");
        // String username = env.getProperty("spring.datasource.username");
        // String password = env.getProperty("spring.datasource.password");
        

        // properties.put("url" , url);
        // properties.put("username", username);
        // properties.put("password", password);
    }

    public static Connection getConnection() throws SQLException{

        try{
            loadProperties();
        }catch(IOException e){
            System.out.println(e);
        }
        Connection connection = DriverManager.getConnection(properties.getProperty("spring.datasource.url"),properties.getProperty("spring.datasource.username"),properties.getProperty("spring.datasource.password"));
        return connection;
    }
}
