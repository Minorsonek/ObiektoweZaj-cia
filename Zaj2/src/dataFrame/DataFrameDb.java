package dataFrame;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.*;

public class DataFrameDb
{
    public DataFrameDb(String filePath)
    {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection("jdbc:sqlite:test.db");
            Statement stmt = connection.createStatement();

            String row;
            BufferedReader csvReader = new BufferedReader(new FileReader(filePath));
            boolean hasColumnNames = false;
            String[] columnNames = null;
            while ((row = csvReader.readLine()) != null) {
                String[] data = row.split(",");

                if (!hasColumnNames)
                {
                    columnNames = data;
                    String sql = "CREATE TABLE IF NOT EXISTS DataFrameDb " +
                            "(IdPK INTEGER PRIMARY KEY AUTOINCREMENT";

                    for (String columnName: columnNames) {
                        sql += ",  " + columnName + "     CHAR(900)   NOT NULL ";
                    }

                    sql += ")";

                    stmt.executeUpdate(sql);
                    hasColumnNames = true;
                    continue;
                }

                String sql = "INSERT INTO DataFrameDb (IdPK";

                for (String columnName: columnNames) {
                    sql += ", " + columnName;
                }

                sql += ") VALUES (NULL";

                for (String cell: data) {
                    sql += ", '" + cell + "'";
                }

                sql += ");";
                stmt.executeUpdate(sql);

            }
            csvReader.close();

            stmt.close();
            connection.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Opened database successfully");
    }
}
