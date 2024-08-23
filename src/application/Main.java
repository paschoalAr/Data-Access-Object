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

        Department dep = new Department(1, "Computers");

        Seller seller = new Seller(null, "João", "joao@gmail.com",
                new java.util.Date(sdf.parse("16/03/2005").getTime()), 8000.0, dep);

        sellerDao.insert(seller);

        db.CloseDatabase();
    }
}
