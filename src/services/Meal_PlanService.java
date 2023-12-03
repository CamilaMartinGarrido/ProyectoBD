package services;

import java.sql.CallableStatement;
import java.sql.SQLException;

public class Meal_PlanService {
    public void add_meal_plan(String plan, double cost) throws SQLException {
        String function = "{call add_meal_plan(?,?)}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);

        preparedFunction.setString(1, plan);
        preparedFunction.setDouble(2, cost);
        preparedFunction.execute();

        preparedFunction.close();
    }

    public void delete_meal_plan(int cod) throws SQLException {
        String function = "{call delete_meal_plan(?)";
        java.sql.Connection connection = ServicesLocator.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);

        preparedFunction.setInt(1, cod);
        preparedFunction.execute();
        preparedFunction.close();

    }

    public void update_meal_plan(int cod, String plan, double cost) throws SQLException {
        String function = "{call update_meal_plan(?,?,?)}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);

        preparedFunction.setInt(1, cod);
        preparedFunction.setString(2, plan);
        preparedFunction.setDouble(3, cost);

        preparedFunction.execute();

        preparedFunction.close();
    }
}
