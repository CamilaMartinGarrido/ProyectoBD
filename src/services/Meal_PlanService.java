package services;

import dto.Daily_Activity;
import dto.Meal_Plan;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class Meal_PlanService {

    public static LinkedList<Meal_Plan> getPlan() throws SQLException {
        LinkedList<Meal_Plan> list = new LinkedList<>();
        Connection connection = ServicesLocator.getConnection();
        ResultSet res = connection.createStatement().executeQuery(
                "SELECT meal_plan.*" +
                        "FROM public.meal_plan"
        );
        while (res.next()) {
            list.add(new Meal_Plan(res.getInt("id_plan"),
                    res.getString("plan_type"),
                    res.getDouble("plan_cost")

            ));
        }
        return list;
    }
    public void add_meal_plan(Meal_Plan m) throws SQLException {
        String function = "{call add_meal_plan(?,?)}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);

        preparedFunction.setString(1, m.getPlan_type());
        preparedFunction.setDouble(1, m.getPlan_cost());
        preparedFunction.execute();

        preparedFunction.close();
    }

    public void delete_meal_plan(Meal_Plan m) throws SQLException {
        String function = "{call delete_meal_plan(?)";
        java.sql.Connection connection = ServicesLocator.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);

        preparedFunction.setInt(1, m.getId_plan());
        preparedFunction.execute();
        preparedFunction.close();

    }

    public void update_meal_plan(Meal_Plan m) throws SQLException {
        String function = "{call update_meal_plan(?,?,?)}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);

        preparedFunction.setInt(1, m.getId_plan());
        preparedFunction.setString(1, m.getPlan_type());
        preparedFunction.setDouble(1, m.getPlan_cost());

        preparedFunction.execute();

        preparedFunction.close();
    }
}
