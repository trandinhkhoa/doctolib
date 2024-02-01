package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class DoctolibService {
  List<Timeslot> getAvailableSlots(String inputDate) {
    // jdbc:<driver>://<host>:<port>/<database>
    // jdbc:<driver>:<dbFilePath>
    String dbConnString = "jdbc:sqlite:my.db";
    try {
      Class.forName("org.sqlite.JDBC");
    } catch (ClassNotFoundException e) {
      System.out.println("SQLite JDBC driver not found.");
      return null;
    }

    List<Timeslot> availabilityList = new ArrayList<>();
    try  {
      System.out.println("00 executing query...");
      Connection conn = DriverManager.getConnection(dbConnString);
      String query = "SELECT * FROM doctor_events WHERE event_start >= ? AND event_end <= ?";
      PreparedStatement stmt = conn.prepareStatement(query);
      System.out.println("01 executing query...");
      stmt.setString(1, inputDate);
      System.out.println("01 executing query...");
      SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
      Date endDate =  dateFormat.parse(inputDate);
      System.out.println("0 executing query...");

      Calendar calendar = Calendar.getInstance();
      calendar.setTime(endDate);
      calendar.add(Calendar.DAY_OF_YEAR, 7);
      endDate = calendar.getTime();

      stmt.setString(2, dateFormat.format(endDate));


      System.out.println("executing query...");
      ResultSet rs = stmt.executeQuery();

      System.out.println("OK exeucted query");
      while (rs.next()) {
        String eventType = rs.getString("event_type");
        String eventStart = rs.getString("event_start");
        String eventEnd = rs.getString("event_end");
        if (eventType.equals("opening")) {
          System.out.println(eventType + " " + eventStart + " " + eventEnd);
          Timeslot timeslot = new Timeslot();
          timeslot.start = eventStart;
          timeslot.end = eventEnd;
          timeslot.type = eventType;
          availabilityList.add(timeslot);
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    System.out.println("----------");
    return availabilityList;
  }
}
