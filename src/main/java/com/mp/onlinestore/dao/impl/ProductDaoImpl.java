package com.mp.onlinestore.dao.impl;

import com.mp.onlinestore.Exceptions.GenericException;
import com.mp.onlinestore.consts.ErrorCodes;
import com.mp.onlinestore.consts.JdbcConstants;
import com.mp.onlinestore.dao.ProductDao;
import com.mp.onlinestore.model.Product;
import com.mp.onlinestore.util.ConnectToDb;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

@Repository
public class ProductDaoImpl implements ProductDao{
    private String productTable = "Product";

    @Override
    public Collection<Product> findAll() throws GenericException {
        List<Product> productList = new ArrayList<Product>();

        Connection conn = new ConnectToDb().getConnection();
        try {
            Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery(JdbcConstants.PRODUCT_FIND_ALL_QUERY);
            if(!rs.next()) {
                System.out.println("No products in DB");
                return null;
            }
            else {
                rs.beforeFirst();
                while(rs.next()) {
                    Long productId = Long.valueOf(rs.getString("productId"));
                    String productName = String.valueOf(rs.getString("productName"));
                    double productPrice = Double.valueOf(rs.getString("productPrice"));
                    String productColor = String.valueOf(rs.getString("productColor"));
                    int categoryId = Integer.valueOf(rs.getString("categoryId"));
                    productList.add(new Product(productId, productName, productPrice, productColor, categoryId));
                }
            }
            rs.first();
            rs.close();
            stmt.close();
        } catch (SQLException e) {
//            e.printStackTrace();
            throw new GenericException(ErrorCodes.DB_SQL_ERR);
        } finally {
            ConnectToDb.closeConnection(conn);
        }

        return productList;
    }


    public Product findById(final Long productID) throws GenericException {
        Product product = null;

        Connection conn = new ConnectToDb().getConnection();
        try {
            Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery(String.format(JdbcConstants.PRODUCT_FIND_BY_ID_QUERY, JdbcConstants.PRODUCT_TABLE_NAME, productID));
            if(!rs.next()) {
                System.out.println("No such products in DB");
                return null;
            }
            else {
                rs.beforeFirst();
                while(rs.next()) {
                    String productName = String.valueOf(rs.getString("productName"));
                    double productPrice = Double.valueOf(rs.getString("productPrice"));
                    String productColor = String.valueOf(rs.getString("productColor"));
                    int categoryId = Integer.valueOf(rs.getString("categoryId"));
                    product = new Product(productID, productName, productPrice, productColor, categoryId);
                }
            }
            rs.first();
            rs.close();
            stmt.close();
        } catch (SQLException e) {
//            e.printStackTrace();
            throw new GenericException(ErrorCodes.DB_SQL_ERR);
        } finally {
            ConnectToDb.closeConnection(conn);
        }
        return product;
    }


    public boolean createProduct(final Product product) throws GenericException {
        Connection conn = new ConnectToDb().getConnection();

        try {
            PreparedStatement st = conn.prepareStatement(String.format(Locale.ROOT,JdbcConstants.PRODUCT_SAVE_PRODUCT_QUERY, JdbcConstants.PRODUCT_TABLE_NAME,
                    product.getProductName(), product.getProductPrice(), product.getProductColor()/*, product.getCategoryId()*/));

            int rowsInserted = st.executeUpdate();
            if(rowsInserted>=1) {
                st.close();
                return true;
            }
            else {
                System.out.println("No products were saved");
                st.close();
                return false;
            }
        } catch (SQLException e) {
//            e.printStackTrace();
            throw new GenericException(ErrorCodes.DB_SQL_ERR);
        } finally {
            ConnectToDb.closeConnection(conn);
        }
    }


    public boolean updateProduct(final Product product) throws GenericException {
        Connection conn = new ConnectToDb().getConnection();

        try {
            PreparedStatement st = conn.prepareStatement(String.format(Locale.ROOT, JdbcConstants.PRODUCT_UPDATE_PRODUCT_QUERY, JdbcConstants.PRODUCT_TABLE_NAME,
                    product.getProductName(), product.getProductPrice(), product.getProductColor()/*, product.getCategoryId()*/, product.getProductId()));
            int rowsUpdated = st.executeUpdate();
            if(rowsUpdated>=1) {
                st.close();
                return true;
            }
            else {
                System.out.println("No products were updated");
                st.close();
                return false;
            }
        } catch (SQLException e) {
//            e.printStackTrace();
            throw new GenericException(ErrorCodes.DB_SQL_ERR);
        } finally {
            ConnectToDb.closeConnection(conn);
        }
    }


    public boolean deleteProduct(final Long productID) throws GenericException {
        Connection conn = new ConnectToDb().getConnection();

        try {
            PreparedStatement st = conn.prepareStatement(String.format(JdbcConstants.PRODUCT_DELETE_PRODUCT_BY_ID_QUERY, JdbcConstants.PRODUCT_TABLE_NAME, productID));
            int rowsDeleted = st.executeUpdate();
            if(rowsDeleted>=1) {
                st.close();
                return true;
            }
            else {
                System.out.println("No products were deleted");
                st.close();
                return false;
            }
        }
        catch (SQLException e) {
//            e.printStackTrace();
            throw new GenericException(ErrorCodes.DB_SQL_ERR);
        } finally {
            ConnectToDb.closeConnection(conn);
        }
    }


}
