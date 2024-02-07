package com.kamatech.parkingmanager.consoles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.UUID;

public class CreateParkingSpot {
  String user = System.getenv("DB_USER");
  String password = System.getenv("DB_PASSWORD");
  String url = System.getenv("DB_URL");
  Connection con;
  Statement stm;
  String driver = "org.postgresql.Driver";

  public CreateParkingSpot(String parkingSpot) {
    try {
      Class.forName(driver);
      con = DriverManager.getConnection(url, user, password);
      stm = con.createStatement();
      UUID uuid = UUID.randomUUID();
      String sql = String.format("insert into tb_parking_spot (parking_spot_number, "
          + "id_external_parking_spot, is_occupied) values('%s','%s', false)", parkingSpot, uuid);
      stm.executeUpdate(sql);
      con.close();
    } catch (Exception e) {
      System.out.println("Erro: " + e);
    }
  }
}
