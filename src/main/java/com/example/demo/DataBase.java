package com.example.demo;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBase {
	private long id;
	public String Data;
	public int pageIndex = 0;
	public int pageNum = 0;
	 public long getId() {
		    return id;
		  }

		  public void setId(long id) {
		    this.id = id;
		  }

		  public String getDataBase() {
		    return Data;
		  }

		  public void setDataBase() {
			    // データベースに接続
			    String url = "jdbc:mysql://localhost:3306/sakila";
			    String user = "root";
			    String password = "enter5103";
			    this.Data = "ID,氏,名,更新日" ;
			    try{
			     Connection  conne = DriverManager.getConnection(url, user, password);
			     // SQL文の実行
				    PreparedStatement pstmt = conne.prepareStatement("select * from actor");
				    ResultSet rs = pstmt.executeQuery();

				     Statement statement=conne.createStatement();


				     //データ数取得
				     String cntSql = "SELECT COUNT(*) cnt FROM actor";
				     ResultSet rs2 = statement.executeQuery(cntSql);
				     rs2.next();

				    int dataNum = rs2.getInt("cnt");
				    this.pageNum = dataNum/20;

				    while (rs.next()) {
				      int id = rs.getInt("actor_id");
				      String fn = rs.getString("first_name");
				      String ln = rs.getString("last_name");
				      Date lu = rs.getDate("last_update");
				      int is_delete =  rs.getInt("is_delete");

				     if ( is_delete == 0) {

				    	  this.Data +=","+ id + "," + ln + "," + fn + "," + lu;
				      }

				    }
				    // 後処理（リソースのクローズ）
				    rs.close();
				    pstmt.close();
				    conne.close();

			      // データベースに対する処理

			    }catch (SQLException e){
			    	 System.out.println(e);		    }


		  }

}
