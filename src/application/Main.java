package application;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;

import entities.Department;
import interfacesDao.DepartmentDao;
import util.ConexaoMysql;
import util.DaoFactory;

public class Main {

    public static void main(String[] args) throws ParseException, SQLException {

        ConexaoMysql db = new ConexaoMysql();
        db.OpenDatabase();
        Connection conn = null;
        conn = db.getConnection(conn);

        DepartmentDao depDao = DaoFactory.createDepartmentDao(conn);

        Department dep = depDao.findById(2);

        System.out.println(dep);

        db.CloseDatabase();
    }
}
