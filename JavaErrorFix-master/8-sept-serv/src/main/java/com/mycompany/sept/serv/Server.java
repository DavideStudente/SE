package com.mycompany.sept.serv;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author biar
 */
public class Server {
    public static void main(String args[]) throws Exception {
        FlightProductor productor = new FlightProductor();
        productor.start();      
    }
}
