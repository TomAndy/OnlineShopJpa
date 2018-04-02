package com.mp.onlinestore.consts;

public class ErrorCodes {

    /*Generic errors*/
    public static final String GEN_ERR = "GEN_ERR_100";
    public static final String BAD_REQUEST_CLIENT = "Bad request. No such client id";
    public static final String ORDER_DTO_ERR = "ORD_ERR_400";
    public static final String NO_CLIENT_IN_DB = "CLN_ERR_100";
    public static final String INVALID_CLIENT = "CLN_ERR_200";
    public static final String CLIENT_NAME_NOT_SPECIFIED = "CLN_ERR_220";
    public static final String CLIENT_LOGIN_NOT_SPECIFIED = "CLN_ERR_225";
    public static final String INVALID_CATEGORY_ID = "CTG_ERR_105";
    public static final String INVALID_CATEGORY_NAME = "CTG_ERR_100";
    public static final String INVALID_PRODUCT_NAME = "PRD_ERR_100";
    public static final String INVALID_PRODUCT_COLOR = "PRD_ERR_120";
    public static final String INVALID_PRODUCT_PRICE = "PRD_ERR_140";
    public static final String INVALID_PRODUCT_ID = "PRD_ERR_160";
    public static final String NO_PRODUCTS_IN_ORDER = "PRD_ERR_120";

    /*DB errors*/
    public static final String DB_SQL_ERR = "DB_ERR_100";
    public static final String DB_CONN_ERR = "DB_ERR_200";
    public static final String DB_GEN_ERR = "DB_ERR_300";
    public static final String DB_TABLE_ERROR = "DB_ERR_400";

    /*Validation errors*/
    public static final String VAL_ERR = "VAL_ERR_100";



    private ErrorCodes() {
    }
}
