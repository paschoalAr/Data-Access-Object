package util;
import java.sql.*;

public class ConexaoMysql {

    public static String url = "jdbc:mysql://localhost:3306/coursejdbc";
    public static String user = "developer";
    public static String password = "1234567";

    private Connection dbconn = null;
    private Statement sqlmgr = null;
    private ResultSet resultsql = null;

    public void OpenDatabase() {

        try {

            dbconn = DriverManager.getConnection(url, user, password);
            System.out.println("Banco conectado com sucesso em " + url);
            sqlmgr = dbconn.createStatement();

        } catch (Exception e) {

            System.out.println("Erro ao conectar: " + e.getMessage());

        }

    }

    public void CloseDatabase() throws SQLException{
        sqlmgr.close();
        dbconn.close();
    }

    public int ExecutaQuery(String sql){
        try {
            sqlmgr.executeUpdate(sql);
            System.out.println("A query foi executada com sucesso \n -"+ sql);
            return 0;
        } catch (Exception e) {
            System.out.println("A query não foi executada com sucesso \n -"+ sql);
            System.out.println(e.getMessage());
        }
        return -1;
    }
}
