package application;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import entities.Department;
import entities.Seller;
import interfacesDao.SellerDao;
import util.ConexaoMysql;
import util.DaoFactory;

public class Main {

    public static void main(String[] args) throws ParseException, SQLException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
        ConexaoMysql db = new ConexaoMysql();
        db.OpenDatabase();
        Connection conn = null;
        conn = db.getConnection(conn);

        SellerDao sellerDao = DaoFactory.creatSellerDao(conn);

        Seller seller = sellerDao.findById(1);

        System.out.println(seller);

        seller.setBaseSalary(600.0);

        sellerDao.update(seller);

        seller = sellerDao.findById(1);

        System.out.println(seller);

        db.CloseDatabase();
    }
}
