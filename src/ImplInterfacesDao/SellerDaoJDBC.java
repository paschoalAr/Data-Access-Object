package ImplInterfacesDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import entities.Department;
import entities.Seller;
import interfacesDao.SellerDao;

public class SellerDaoJDBC implements SellerDao {

    private Connection conn;

    public SellerDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    public SellerDaoJDBC() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public void insert(Seller dep) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insert'");
    }

    @Override
    public void update(Seller dep) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void deleteById(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }

    @Override
    public Seller findById(Integer id) {

        PreparedStatement pst = null;
        ResultSet rs = null;

        String sql = "select seller.*, department.Name as DepName from seller join department " +
                "on department.Id = seller.DepartmentId " +
                "where seller.Id = ?";
        try {
            pst = conn.prepareStatement(sql);

            pst.setInt(1, id);

            rs = pst.executeQuery();

            if (rs.next()) {

                Department dep = new Department((Integer) rs.getInt("DepartmentId"), rs.getString("DepName"));

                Seller seller = new Seller(id, rs.getString("Name"), rs.getString("Email"),
                        (Date) rs.getDate("BirthDate"), rs.getDouble("BaseSalary"), dep);

                return seller;
            }
            return null;
        } catch (Exception e) {
            System.out.println("Erro ao executar a função findById \n " + e.getMessage());
        }

        return null;
    }

    @Override
    public List<Seller> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public List<Seller> findByDepartment(Department department) {

        PreparedStatement pst = null;
        ResultSet rs = null;

        String sql = "select seller.*, department.Name as DepName from seller join department " +
                "on department.Id = seller.DepartmentId " +
                "where DepartmentId = ? " + 
                "Order by Name";

        List<Seller> listSellers = new ArrayList<>();
        Map<Integer, Department> map = new HashMap();

        try {
            pst = conn.prepareStatement(sql);

            pst.setInt(1, department.getId());

            rs = pst.executeQuery();

            while (rs.next()) {

                Department dep = map.get(rs.getInt("DepartmentId"));

                //Feito para não estanciar um novo departamento para cada novo vendedor encontrado
                if (dep == null){
                    dep = new Department(rs.getInt("DepartmentId"), rs.getString("DepName"));
                    map.put(rs.getInt("DepartmentId"), dep);
                }

                Seller seller = new Seller(rs.getInt("Id"), rs.getString("Name"), rs.getString("Email"),
                        (Date) rs.getDate("BirthDate"), rs.getDouble("BaseSalary"), dep);

                listSellers.add(seller);
            }
            return listSellers;

        } catch (Exception e) {
            System.out.println("Erro ao executar a função findByDepartment \n " + e.getMessage());
        }

        return null;

    }

}
