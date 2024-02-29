import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Calculator {
    private final Connection connection; // Assume this is your MySQL database connection

    public Calculator(Connection connection) {
        this.connection = connection;
    }

    public int add(int a, int b) {
        int result = a + b;
        saveCalculation("add", a, b, result);
        return result;
    }

    public int subtract(int a, int b) {
        int result = a - b;
        saveCalculation("subtract", a, b, result);
        return result;
    }

    public int multiply(int a, int b) {
        int result = a * b;
        saveCalculation("multiply", a, b, result);
        return result;
    }

    public double divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        double result = (double) a / b;
        saveCalculation("divide", a, b, result);
        return result;
    }

    private void saveCalculation(String operation, int num1, int num2, double result) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO calculation_results (operation, num1, num2, result) VALUES (?, ?, ?, ?)"
        )) {
            preparedStatement.setString(1, operation);
            preparedStatement.setInt(2, num1);
            preparedStatement.setInt(3, num2);
            preparedStatement.setDouble(4, result);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
    }
}
