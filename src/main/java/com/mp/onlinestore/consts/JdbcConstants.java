package com.mp.onlinestore.consts;

public class JdbcConstants {
    /* Category constants */
    public static final String CATEGORY_TABLE_NAME = "\"categories\"";
    public static final String CATEGORY_FIND_ALL_QUERY = String.format("select * from %s",CATEGORY_TABLE_NAME);
    public static final String CATEGORY_SAVE_CATEGORY_QUERY = "Insert into %s values('%s');";
    public static final String CATEGORY_FIND_BY_ID_QUERY = "select * from %s where \"cid\" = %d";
    public static final String CATEGORY_DELETE_CATEGORY_BY_ID_QUERY = "delete from %s where \"cid\" = %d";
    public static final String CATEGORY_UPDATE_CATEGORY_QUERY = "UPDATE %s  SET \"cname\"='%s' where \"cid\"=%d";

    /* Product constants */
    public static final String PRODUCT_TABLE_NAME = "\"products\"";
    public static final String PRODUCT_FIND_ALL_QUERY = String.format("select * from %s",PRODUCT_TABLE_NAME);
    public static final String PRODUCT_SAVE_PRODUCT_QUERY = "Insert into %s (\"productName\", \"productPrice\", \"productColor\", \"categoryId\") values('%s', '%f', '%s', '%d');";
    public static final String PRODUCT_FIND_BY_ID_QUERY = "select * from %s where \"productId\" = %d";
    public static final String PRODUCT_DELETE_PRODUCT_BY_ID_QUERY = "delete from %s where \"productId\" = %d";
    public static final String PRODUCT_UPDATE_PRODUCT_QUERY = "UPDATE %s  SET \"productName\"='%s', \"productPrice\"='%f', \"productColor\"='%s', \"categoryId\"='%d' where \"productId\"=%d";

    /*User constants */
    public static final String CLIENT_TABLE_NAME = "\"clients\"";
    public static final String CLIENT_FIND_ALL_QUERY = String.format("select * from %s",CLIENT_TABLE_NAME);
    public static final String CLIENT_SAVE_USER_QUERY = "Insert into %s values('%s', '%s', '%s');";
    public static final String CLIENT_FIND_BY_ID_QUERY = "select * from %s where \"clientId\" = %d";
    public static final String CLIENT_DELETE_USER_BY_ID_QUERY = "delete from %s where \"clientId\" = %d";
    public static final String CLIENT_UPDATE_USER_QUERY = "UPDATE %s  SET \"clientName\"='%s', \"clientLogin\"='%s', \"clientEmail\"='%s' where \"clientId\"=%d";

}
