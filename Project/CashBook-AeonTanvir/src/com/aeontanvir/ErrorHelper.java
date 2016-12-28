/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeontanvir;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author aeon
 */
public class ErrorHelper {
    static DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    static Calendar cal = Calendar.getInstance();
    
    public static void loginError(String e) throws Exception{
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File("logerror.txt"), true));
        String err =  "--" + dateFormat.format(cal.getTime()) + " -- Login Error : \t\t" + e ;
        bw.append(err);
        bw.newLine();
        bw.flush();
        bw.close();
    }
    public static void login(String e) throws Exception{
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File("loginfo.txt"), true));
        String err =  "--" + dateFormat.format(cal.getTime()) + " -- Login : \t\t" + e ;
        bw.append(err);
        bw.newLine();
        bw.flush();
        bw.close();
    }
    
    public static void exceptionError(String e) throws Exception{
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File("exceptionerror.txt"), true));
        String err =  "--" + dateFormat.format(cal.getTime()) + " -- Exception Error : \t\t" + e ;
        bw.append(err);
        bw.newLine();
        bw.flush();
        bw.close();
    }


    
}
