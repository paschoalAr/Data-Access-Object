package application;

import java.sql.Connection;

import entities.Seller;
import interfacesDao.SellerDao;
import util.ConexaoMysql;
import util.DaoFactory;

public class Main {

    public static void main(String[] args) {
        ConexaoMysql db = new ConexaoMysql();
        db.OpenDatabase();
        Connection conn = null;
        conn = db.getConnection(conn);

        SellerDao sellerDao = DaoFactory.creatSellerDao(conn);

        Seller seller = sellerDao.findById(3);
    

        System.out.println(seller);
       
    }
}
