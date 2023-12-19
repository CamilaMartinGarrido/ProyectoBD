package services;
import dto.MealPlan;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class MealPlanService {
    //List of MealPlans
    public static LinkedList<MealPlan> getPlan() throws SQLException {
        LinkedList<MealPlan> list = new LinkedList<>();
        Connection connection = ServicesLocator.getConnection();
        ResultSet res = connection.createStatement().executeQuery(
                "SELECT meal_plan.*" +
                        "FROM public.meal_plan"
        );
        while (res.next()) {
            list.add(new MealPlan(
                    res.getInt("id_plan"),
                    res.getString("plan_type"),
                    res.getDouble("plan_cost"))
            );
        }
        return list;
    }
    //Add
    public void add_meal_plan(MealPlan m) throws SQLException {
        String function = "{call add_meal_plan(?,?)}";
        Connection connection = ServicesLocator.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);

        preparedFunction.setString(1, m.getPlan_type());
        preparedFunction.setDouble(1, m.getPlan_cost());

        preparedFunction.executeQuery();

        preparedFunction.close();
    }
    //Delete
    public void delete_meal_plan(MealPlan m) throws SQLException {
        String function = "{call delete_meal_plan(?)";
        Connection connection = ServicesLocator.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);

        preparedFunction.setInt(1, m.getId_plan());

        preparedFunction.executeQuery();
        preparedFunction.close();
    }
    //Update
    public void update_meal_plan(MealPlan m) throws SQLException {
        String function = "{call update_meal_plan(?,?,?)}";
        Connection connection = ServicesLocator.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);

        preparedFunction.setInt(1, m.getId_plan());
        preparedFunction.setString(1, m.getPlan_type());
        preparedFunction.setDouble(1, m.getPlan_cost());

        preparedFunction.executeQuery();

        preparedFunction.close();
    }
}
