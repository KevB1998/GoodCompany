package com.project.GoodCompany;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class GoodCompanyService {
    String database = "GoodCompany";
    String dbUser = "GoodCompanyUser";
    String dbPassword = "GoodCompanyPassword";
    String ip = "localhost";
    String port = "3306";

    public String getEmployeeInfo(String eid, String password) {
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://" + ip + ":" + port + "/" + database + "?allowMultiQueries=true", dbUser, dbPassword);
            conn.setAutoCommit(false);

            stmt = conn.createStatement();
            String query = "SELECT Name, Salary, SSN FROM employee WHERE EID=\"" + eid + "\" AND Password=\"" + password + "\";";
            System.out.println(query);
            String out = "";

            boolean hasMoreResultSets = stmt.execute(query);
            System.out.println("Done");
            while ( hasMoreResultSets || stmt.getUpdateCount() != -1 ) {
                System.out.println("OUTSIDER");
                if ( hasMoreResultSets ) {
                    ResultSet results = stmt.getResultSet();
                    ResultSetMetaData resultsData = results.getMetaData();
                    int cols = resultsData.getColumnCount();
                    System.out.println("OUTSIDE");
                    while(results.next()) {
                        System.out.println("INSIDE");
                        for(int i = 1; i <= cols; i++) {
                            out += resultsData.getColumnName(i) + ": " + results.getString(i) + "\n";
                        }
                        out += "\n";
                    }
                }
                else {
                    int queryResult = stmt.getUpdateCount();
                    if ( queryResult == -1 ) {
                        break;
                    }
                }
                hasMoreResultSets = stmt.getMoreResults();
            }
            System.out.println("OUT");

            return out;
        } catch (Exception e) {
            //Return exception
            String exc = e.getClass().getName() + ": " + e.getMessage();
            return exc;
        }
    }

    public boolean changePassword(String eid, String cPassword, String nPassword) {
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://" + ip + ":" + port + "/" + database + "?allowMultiQueries=true", dbUser, dbPassword);
            conn.setAutoCommit(false);

            stmt = conn.createStatement();
            String query = "UPDATE employee SET Password=\"" + nPassword + "\" WHERE EID=\"" + eid + "\" AND Password=\"" + cPassword + "\";";
            stmt.execute(query);
            conn.commit();
            return true;
        } catch (Exception e) {
            //Return exception
            return false;
        }
    }
}
