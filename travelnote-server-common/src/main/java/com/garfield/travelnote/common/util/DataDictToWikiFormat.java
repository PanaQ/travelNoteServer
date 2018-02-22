package com.garfield.travelnote.common.util;

import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 数据字典导出wiki格式工具
 *
 * @author zhenggaojie 2015-12-11.
 */
public class DataDictToWikiFormat {

    public static void main(String[] args) throws SQLException {
        //String url = "jdbc:mysql://120.55.118.130:3306/gzseed_vancelle_order";
        String url = "jdbc:mysql://192.168.30.36:3306/";
        String user = "root";
        String password = "123456";
        String schemaName = "travel_note";
        String tableName = null;
        handleData(url, user, password, schemaName, tableName);
    }

    private static void handleData(String url, String user, String password, String schemaName, String tableName) throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        ResultSet tableResult = null;
        ResultSet columnResult = null;
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, password);
            String schema_name = schemaName == null ? "kalemao" : schemaName;

            String tableSql = "SELECT t.TABLE_SCHEMA,t.TABLE_NAME,t.ENGINE,t.table_comment from information_schema.TABLES t where LOWER(TABLE_SCHEMA)='"
                    + schema_name + "'";
            // and t.TABLE_NAME like 'gss_weidian_after_sale%'
            if (tableName != null) {
                tableSql += " AND LOWER(TABLE_NAME) = '" + tableName + "'";
            }
            // String sql = "select 1 from gss_users limit 1";
            tableResult = connection.createStatement().executeQuery(tableSql);
            System.out.println("# " + schema_name);
//            System.out.println("{{toc}}");//redmine wiki 支持，其他不支持
            StringBuilder tocBuf = new StringBuilder();
            StringBuilder sbu = new StringBuilder();

            while (tableResult.next()) {
                String sql = "SELECT\n" + "information_schema.COLUMNS.COLUMN_NAME,\n"
                        + "information_schema.COLUMNS.COLUMN_TYPE,\n"
                        + "information_schema.COLUMNS.COLUMN_COMMENT,\n"
                        + "information_schema.COLUMNS.COLUMN_DEFAULT,\n"
                        + "information_schema.COLUMNS.IS_NULLABLE\n" + "FROM information_schema.COLUMNS\n"
                        + "WHERE\n" + "LOWER(table_name) = '" + tableResult.getString(2).toLowerCase() + "' AND\n"
                        + "LOWER(information_schema.COLUMNS.TABLE_SCHEMA)='"
                        + tableResult.getString(1).toLowerCase() + "'";
                columnResult = connection.createStatement().executeQuery(sql);

                sbu.append("##  ");
                StringBuilder sb = new StringBuilder();
                //.append(tableResult.getString(3))
                sb.append(tableResult.getString(2)).append(tableResult.getString(4));
                String encode = URLEncoder.encode(sb.toString());
                tocBuf.append("- [" + sb.toString() + "]" + "(#" + encode + ")\n");
                sbu.append(sb).append("\n");
                sbu.append("| 名称 | 类型 | 描述 | 默认值 | 是否空 |\n").append("| ----------- | ---------- | ----- | --------------- | ----- |\n");
                while (columnResult.next()) {
                    sbu.append("| " + columnResult.getString(1) + " | " + columnResult.getString(2) + " | "
                            + columnResult.getString(3) + " | " + columnResult.getString(4) + " | "
                            + columnResult.getString(5) + " |\n");
                }

            }
            System.out.println(tocBuf);
            System.out.println(sbu);
        } finally {
            if (null != tableResult) {
                tableResult.close();
            }
            if (null != columnResult) {
                columnResult.close();
            }
            if (null != connection) {
                connection.close();
            }
        }
    }
}
