import java.sql.*;

public class LAB15 {
    public static void main(String[] args) {
        String URL = "jdbc:mysql://localhost:3306/mydb3";
        String username = "root";
        String password = "mysql@sit";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(URL,username,password);
            Statement statement = con.createStatement();
            String sql = "select * from student";
            ResultSet result = statement.executeQuery(sql);
            ResultSetMetaData rsMetaData = result.getMetaData();

            for (int i = 1; i<=rsMetaData.getColumnCount(); i++){
                System.out.println(rsMetaData.getColumnName(i));
            }

            while (result.next()){
                for(int i = 1; i <= rsMetaData.getColumnCount(); i++){
                    System.out.printf("%-12s\t",result.getObject(i));
                    System.out.println();
                }
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }
    }
