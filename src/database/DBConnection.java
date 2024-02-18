package src.database;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class DBConnection {
    private Connection con;
    private Statement st;
    protected ResultSet rs;

    public DBConnection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_test", "root", "wjddyddks1!");
            st = con.createStatement();
        }catch (Exception e){
            System.out.println("데이터베이스 연결 오류 : " + e.getMessage());
        }
    }

    public boolean isAdmin(String userName, String userPassword){
        try{
            String SQL = "select * from jdbc_test.user where userName = '" + userName + "' and userPassword = '" + userPassword + "'";
            rs = st.executeQuery(SQL);
            if(rs.next()){
                return true;
            }
        }catch (Exception e){
            System.out.println("데이터베이스 검색 오류 : " + e.getMessage());
        }
        return false;
    }
}
