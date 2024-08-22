package application;

import entities.Department;
import util.ConexaoMysql;

public class Main {

    public static void main(String[] args) {
        ConexaoMysql db = new ConexaoMysql();

        db.OpenDatabase();

        Department dep = new Department(1, "Teste");

        System.out.println(dep);
        
    }
}
