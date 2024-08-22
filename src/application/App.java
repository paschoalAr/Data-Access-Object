package application;

import util.ConexaoMysql;

public class App {
    public static void main(String[] args) throws Exception {

        ConexaoMysql db1 = new ConexaoMysql();

        String slq = "select * from department";

        db1.OpenDatabase();
        //db1.ExecutaQuery(slq);
    }
}
