package application;

import java.util.Date;

import entities.Department;
import entities.Seller;
import util.ConexaoMysql;

public class Main {

    public static void main(String[] args) {
        ConexaoMysql db = new ConexaoMysql();

        db.OpenDatabase();

        Department dp = new Department(1, "teste");
        Seller seller = new Seller(1, "a", "a", new Date(), 50000.00, dp);

        System.out.println(seller);
        
    }
}
