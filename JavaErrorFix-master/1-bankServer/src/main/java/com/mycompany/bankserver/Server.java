/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bankserver;

import javax.xml.ws.Endpoint;
/**
 *
 * @author biar
 */
public class Server {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException{
        MyAAAWSImpl implementor = new MyAAAWSImpl();
        String address = "http://localhost:9001/MyAAAWS";
        Endpoint.publish(address, implementor);

        System.out.println("MyAAAWS Started");
    }
    
}
