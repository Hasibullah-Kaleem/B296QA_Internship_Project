package getlandestate.utilities;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBUtils {

    public static Connection connection;
    public static Statement statement;
    public static ResultSet resultSet;
    public static ResultSet resultSetUtil;

    public static Connection connectToDatabase() {

        try {
            connection = DriverManager.getConnection("jdbc:postgresql://64.227.123.49:5432/prettierhomes", "techprotester", "myPassword");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return connection;
    }


    // This method calls the connectToDatabase() method and returns a PreparedStatement.
    public static PreparedStatement createPreparedStatement(String query) {
        PreparedStatement preparedStatement;
        try {
            connection = connectToDatabase();
            preparedStatement = connection.prepareStatement(query);
        } catch (SQLException e) {
            throw new RuntimeException("Failed to create PreparedStatement", e);
        }
        return preparedStatement;
    }

    //This method calls the connectToDatabase() method and returns a statement.
    public static Statement createStatement() {
        try {
            statement = connectToDatabase().createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return statement;
    }



    //This method executes a String SQL query by calling the createStatement() method and returns a boolean.
    public static boolean execute(String sql) {

        try {
            return createStatement().execute(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    //This method executes a String SQL query by calling the createStatement() method and returns a ResultSet.
    public static ResultSet executeQuery(String sql){

        try {
            return createStatement().executeQuery(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    //This method executes a query based on the specified table and column name and returns the related column objects as a list.
    public static List<Object> getColumnList(String table, String column) throws SQLException {

        List<Object> list = new ArrayList<>();
        String query = "select " + column + " from " + table;

        resultSetUtil = executeQuery(query);
        while (resultSetUtil.next()) {
            list.add(resultSetUtil.getObject(column));
        }

        return list;
    }


    public static void closeConnection(){

        try {
//            connection.close();
//            statement.close();
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}