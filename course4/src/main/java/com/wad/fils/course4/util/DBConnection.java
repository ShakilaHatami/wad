package com.wad.fils.course4.util;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DBConnection {
  public static Connection getConnection() {
    Connection connection=null;
    try {
      Context ctx = new InitialContext();
      DataSource ds = (DataSource)ctx.lookup("java:/comp/env/jdbc/TestDB");
      connection=ds.getConnection();
    } catch (NamingException | SQLException ex) {
      ex.printStackTrace();
    }
    return connection;
  }

}
