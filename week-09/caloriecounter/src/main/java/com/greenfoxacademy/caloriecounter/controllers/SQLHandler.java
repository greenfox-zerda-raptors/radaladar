/// Created by BB on 2017-01-02.
package com.greenfoxacademy.caloriecounter.controllers;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

@Component
public class SQLHandler {

    private Connection conn;
    private Properties properties;
    private Statement statement;

    public SQLHandler() throws SQLException{
        properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "Asdasd11_");
        properties.setProperty("useSSL", "false");
        properties.setProperty("autoReconnect", "true");
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/caloriecounter", properties);
        statement = conn.createStatement();
    }

    @Bean
    public SQLHandler SQLHandlerBean() throws SQLException{
        return new SQLHandler();
    }

    public ArrayList<Meal> loadMeals() throws SQLException {
        ArrayList<Meal> meals = new ArrayList<>();
        String sql = "SELECT * FROM MEALS";
        ResultSet rows = statement.executeQuery(sql);
        while (rows.next()) {
            meals.add(new Meal(rows.getInt("id"), rows.getString("date"), rows.getString("type"), rows.getString("name"), rows.getInt("calories")));
        }
        return meals;
    }

    public int loadCaloriesSum() throws SQLException{
        String sql = "SELECT SUM(CALORIES) FROM MEALS";
        ResultSet sum = statement.executeQuery(sql);
        sum.next();
        return sum.getInt(1);
    }

    public void deleteMeal(int id) throws SQLException{
        String sql = "DELETE FROM MEALS WHERE id=\""+ id + "\"";
        statement.execute(sql);
    }
}
