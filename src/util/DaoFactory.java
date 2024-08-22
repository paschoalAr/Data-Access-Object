package util;

import ImplInterfacesDao.SellerDaoJDBC;
import interfacesDao.SellerDao;

public class DaoFactory {
    
    public static SellerDao creatSellerDao(){
        return new SellerDaoJDBC();
    }

}
