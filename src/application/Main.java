package application;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

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

        Department dep = new Department(null,"Buy");

        depDao.insert(dep);

        List<Department> listDepartments = depDao.findAll();

        listDepartments.forEach(System.out:: println);
        
        db.CloseDatabase();
    }
}
