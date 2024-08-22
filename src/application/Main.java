package application;

import interfacesDao.SellerDao;
import util.ConexaoMysql;
import util.DaoFactory;

public class Main {

    public static void main(String[] args) {
        ConexaoMysql db = new ConexaoMysql();

        db.OpenDatabase();

        SellerDao sellseDao = DaoFactory.creatSellerDao();
        
    }
}
