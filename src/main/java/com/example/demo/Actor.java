package com.example.demo;

import lombok.Data;

import java.sql.*;


@Data
public class Actor {
	public long id;
	public String first_name;
	public String last_name;

	public void EditDataBase() {

		 // データベースに接続
	    String url = "jdbc:mysql://localhost:3306/sakila";
	    String user = "root";
	    String password = "enter5103";

	    try{
	     Connection  conne = DriverManager.getConnection(url, user, password);
	     Statement statement=conne.createStatement();

	     // SQL文の実行
	     String sql = "update actor set first_name = '"+ this.first_name +"',last_name = '"+this.last_name+
	    		 "' where actor_id = "+this.id+";";

	     int result=statement.executeUpdate(sql);
	     System.out.println(result+" products are changed.");
	    }catch (SQLException e){
	    	 System.out.println(e);		    }
 }

	public void SubmitDataBase() {

		 // データベースに接続
	    String url = "jdbc:mysql://localhost:3306/sakila";
	    String user = "root";
	    String password = "enter5103";

	    try{
	     Connection  conne = DriverManager.getConnection(url, user, password);
	     Statement statement=conne.createStatement();

	     // SQL文の実行

	     //データ数取得
	     String cntSql = "SELECT COUNT(*) cnt FROM actor";
	     ResultSet rs = statement.executeQuery(cntSql);
	     rs.next();

	     int dataNum = rs.getInt("cnt")+1;

	     String sql = "insert into actor values("+dataNum+",'"+this.first_name+"','"+this.last_name+"',CURRENT_DATE,0);";

	     statement.executeUpdate(sql);

	    }catch (SQLException e){
	    	 System.out.println(e);		    }
}

	public void DeleteDataBase() {

		 // データベースに接続
	    String url = "jdbc:mysql://localhost:3306/sakila";
	    String user = "root";
	    String password = "enter5103";

	    try{
	     Connection  conne = DriverManager.getConnection(url, user, password);
	     Statement statement=conne.createStatement();

	     // SQL文の実行
	     System.out.println(this.id);

	     String sql = "update actor set is_delete = 1 where actor_id = "+this.id+";";

	     int result=statement.executeUpdate(sql);
	     System.out.println(result+" products are changed.");

	    }catch (SQLException e){
	    	 System.out.println(e);		    }
}
		}