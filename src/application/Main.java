package application;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

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
        
        List<Seller> listSellers = new ArrayList<>();

        listSellers = sellerDao.findAll();
    
        listSellers.forEach(System.out:: println);
       
    }
}
