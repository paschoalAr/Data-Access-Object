package util;

import java.sql.Connection;

import ImplInterfacesDao.SellerDaoJDBC;
import interfacesDao.SellerDao;

public class DaoFactory {
    
    public static SellerDao creatSellerDao(Connection conn){
        return new SellerDaoJDBC(conn);
    }

}
