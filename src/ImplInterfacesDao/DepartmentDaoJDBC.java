package ImplInterfacesDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insert'");
    }

    @Override
    public void update(Department dep) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }
    
}
