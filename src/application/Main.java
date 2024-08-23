package application;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;

import interfacesDao.SellerDao;
import util.ConexaoMysql;
import util.DaoFactory;

public class Main {

    public static void main(String[] args) throws ParseException, SQLException {

        ConexaoMysql db = new ConexaoMysql();
        db.OpenDatabase();
        Connection conn = null;
        conn = db.getConnection(conn);

        SellerDao sellerDao = DaoFactory.creatSellerDao(conn);

        sellerDao.deleteById(20);

        db.CloseDatabase();
    }
}
