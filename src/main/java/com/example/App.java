
package com.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        DoctolibService doctolibService = new DoctolibService();
        List<Timeslot> timeslots = doctolibService.getAvailableSlots("2024-02-03 00:00");
        for (Timeslot timeslot : timeslots) {
            System.out.println(timeslot.type + " " + timeslot.start + " " + timeslot.end);
        }
    }
}
