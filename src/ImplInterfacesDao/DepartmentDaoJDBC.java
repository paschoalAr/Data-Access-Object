package ImplInterfacesDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entities.Department;
import interfacesDao.DepartmentDao;

public class DepartmentDaoJDBC implements DepartmentDao{

    private Connection conn;

    public DepartmentDaoJDBC(Connection conn){
        this.conn = conn;
    }

    @Override
    public void insert(Department dep) {
        PreparedStatement pst = null;

        String sql = "insert into department (Name) values (?)";

        try {
            pst = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            pst.setString(1, dep.getName());

            int rowsAffected = pst.executeUpdate();

            if (rowsAffected > 0) {
                ResultSet rs = pst.getGeneratedKeys();
                if (rs.next()){
                    int id = rs.getInt(1);
                    dep.setId(id);
                }
            } else {
                throw new SQLException("Nenhuma linha adicionada");
            }
        } catch (Exception e) {
            System.out.println("Erro ao executar a funcao insert na tabela department \n" + e.getMessage());
        }
    }

    @Override
    public void update(Department dep) {
        PreparedStatement pst = null;

        String sql = "update department set Name = ? where Id = ?";

        try {
            pst = conn.prepareStatement(sql);

            pst.setString(1, dep.getName());
            pst.setInt(2, dep.getId());

            pst.executeUpdate();

        } catch (Exception e) {
            System.out.println("Erro ao executar a funcao update na tabela department \n" + e.getMessage());
        }
    }

    @Override
    public void deleteById(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }

    @Override
    public Department findById(Integer id) {
        PreparedStatement pst = null;
        ResultSet rs = null;

        String Sql = "select * from department where Id = ?";

        try {
            pst = conn.prepareStatement(Sql);

            pst.setInt(1, id);

            rs = pst.executeQuery();

            if(rs.next()){
                Department dep = new Department(rs.getInt("Id"), rs.getString("Name"));

                return dep;
            }

        } catch (Exception e) {
            System.out.println("Erro ao executar a funcao findById na tabela department \n" + e.getMessage());
        }

        return null;
    }

    @Override
    public List<Department> findAll() {
        PreparedStatement pst = null;
        ResultSet rs = null;

        String sql = "select * from department";

        List<Department> listDepartments = new ArrayList<>();

        try {
            pst = conn.prepareStatement(sql);

            rs = pst.executeQuery();
            while (rs.next()) {
                Department dep = new Department(rs.getInt("Id"), rs.getString("Name"));

                listDepartments.add(dep);
            }

            return listDepartments;
        } catch (Exception e) {
            System.out.println("Erro ao executar a funcao findAll na tabela department \n" + e.getMessage());
        }

        return null;
    }
    
}
