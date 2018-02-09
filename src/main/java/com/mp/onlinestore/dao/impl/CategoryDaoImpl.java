package com.mp.onlinestore.dao.impl;

import com.mp.onlinestore.Exceptions.GenericException;
import com.mp.onlinestore.consts.ErrorCodes;
import com.mp.onlinestore.consts.JdbcConstants;
import com.mp.onlinestore.dao.CategoryDao;
import com.mp.onlinestore.model.Category;
import com.mp.onlinestore.util.ConnectToDb;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;

@Repository
public class CategoryDaoImpl implements CategoryDao{

    private String categoryTable = "Category";

    static Logger log = Logger.getLogger(CategoryDaoImpl.class.toString());

    @Override
    public boolean createCategory(final Category category) throws GenericException {
        log.info("Need to store category into db: " + category);

        Connection conn = new ConnectToDb().getConnection();

        try {
            PreparedStatement st = conn.prepareStatement(String.format(JdbcConstants.CATEGORY_SAVE_CATEGORY_QUERY, JdbcConstants.CATEGORY_TABLE_NAME,
                    category.getCategoryName()));
            int rowsInserted = st.executeUpdate();
            if(rowsInserted>=1) {
                st.close();
                return true;
            }
            else {
                //System.out.println("No categories were saved");
                log.info("No categories were saved");
                st.close();
                return false;
            }
        } catch (SQLException e) {
            throw new GenericException(ErrorCodes.DB_TABLE_ERROR);
        } finally {
            ConnectToDb.closeConnection(conn);
        }
    }

    @Override
    public Category findById(final Long categoryID) throws GenericException {
        String categoryName = "";

        Connection conn = new ConnectToDb().getConnection();
        try {
            Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery(String.format(JdbcConstants.CATEGORY_FIND_BY_ID_QUERY, JdbcConstants.CATEGORY_TABLE_NAME, categoryID));
            if(!rs.next()) {
                //System.out.println("No such category in DB");
                log.info("No such category in DB");
                return null;
            }
            else {
                rs.beforeFirst();
                while(rs.next()) {
                    categoryName = String.valueOf(rs.getString("categoryName"));
                }
            }
            rs.first();
            rs.close();
            stmt.close();
        } catch (SQLException e) {
//            e.printStackTrace();
            throw new GenericException(ErrorCodes.DB_TABLE_ERROR);
        } finally {
            ConnectToDb.closeConnection(conn);
        }
        return new Category(categoryID, categoryName);
    }

    @Override
    public boolean updateCategory(final Category category) throws GenericException {
        Connection conn = new ConnectToDb().getConnection();

        try {
            PreparedStatement st = conn.prepareStatement(String.format(JdbcConstants.CATEGORY_UPDATE_CATEGORY_QUERY, JdbcConstants.CATEGORY_TABLE_NAME,
                    category.getCategoryName(), category.getCategoryId()));

            int rowsUpdated = st.executeUpdate();
            if(rowsUpdated>=1) {
                st.close();
                return true;
            }
            else {
                //System.out.println("No categories were updated");
                log.info("No categories were updated");
                st.close();
                return false;
            }
        } catch (SQLException e) {
//            e.printStackTrace();
            throw new GenericException(ErrorCodes.DB_TABLE_ERROR);
        } finally {
            ConnectToDb.closeConnection(conn);
        }
    }

    @Override
    public boolean deleteCategory(final Long categoryID) throws GenericException {
        Connection conn = new ConnectToDb().getConnection();

        try {
            PreparedStatement st = conn.prepareStatement(String.format(JdbcConstants.CATEGORY_DELETE_CATEGORY_BY_ID_QUERY,
                    JdbcConstants.CATEGORY_TABLE_NAME, categoryID));

            int rowsDeleted = st.executeUpdate();
            if(rowsDeleted>=1) {
                st.close();
                return true;
            }
            else {
                //System.out.println("No categories were deleted");
                log.info("No categories were deleted");
                st.close();
                return false;
            }
        }
        catch (SQLException e) {
//            e.printStackTrace();
            throw new GenericException(ErrorCodes.DB_TABLE_ERROR);
        } finally {
            ConnectToDb.closeConnection(conn);
        }
    }

    @Override
    public Collection<Category> findAll() throws GenericException {
        List<Category> categoryList = new ArrayList<Category>();
        Connection conn = new ConnectToDb().getConnection();
        try {
            Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery(JdbcConstants.CATEGORY_FIND_ALL_QUERY);
            if(!rs.next()) {
                System.out.println("No categories in DB");
                return null;
            }
            else {
                rs.beforeFirst();
                while(rs.next()) {
                    Long categoryId = Long.valueOf(rs.getString("categoryId"));
                    String categoryName = String.valueOf(rs.getString("categoryName"));
                    categoryList.add(new Category(categoryId, categoryName));
                }
            }
            rs.first();
            rs.close();
            stmt.close();
        } catch (SQLException e) {
//            e.printStackTrace();
            throw new GenericException(ErrorCodes.DB_TABLE_ERROR);
        } finally {
            ConnectToDb.closeConnection(conn);
        }
        return categoryList;
    }
}
