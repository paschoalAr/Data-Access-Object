package util;

import java.sql.Connection;

import ImplInterfacesDao.DepartmentDaoJDBC;
import ImplInterfacesDao.SellerDaoJDBC;
import interfacesDao.DepartmentDao;
import interfacesDao.SellerDao;

public class DaoFactory {
    
    public static SellerDao creatSellerDao(Connection conn){
        return new SellerDaoJDBC(conn);
    }

    public static DepartmentDao createDepartmentDao(Connection conn){
        return new DepartmentDaoJDBC(conn);
    }

}
