/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeontanvir;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CashAccount {

    public static int cashIn(String type, String details, String date, String dr_ac, String cr_ac ) {
        int row = 0;
        Connection conn = null;
        PreparedStatement psm = null;
        try {
            conn = DatabaseConnection.getConnection();
            String sql = "INSERT INTO cash_ac(type, details, date, dr_ac, cr_ac) VALUES(?,?,?,?,?)";
            psm = conn.prepareStatement(sql);
            psm.setString(1, type);
            psm.setString(2, details);
            psm.setString(3, date);
            psm.setString(4, dr_ac);
            psm.setString(5, cr_ac);

            row = psm.executeUpdate();

        } catch (Exception ex) {
            System.out.println("cashIn" + ex);
        }finally{
            try {
                conn.close();
                psm.close();
            } catch (SQLException ex) {
                Logger.getLogger(CashAccount.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return row;
    }
}
