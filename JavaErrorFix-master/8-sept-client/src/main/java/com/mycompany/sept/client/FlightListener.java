/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sept.client;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicSession;
import javax.jms.TopicSubscriber;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;


import java.sql.*;
import java.sql.Connection;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author biar
 */
public class FlightListener implements javax.jms.MessageListener {
    private Connection connection;
    private TopicConnection jmsConnection;
    private final static Pattern statusPattern = Pattern.compile(".* : (.*)"); //define pattern of message


    public FlightListener() {
        try {
            Properties props = new Properties();
            props.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.apache.activemq.jndi.ActiveMQInitialContextFactory");
            props.setProperty(Context.PROVIDER_URL, "tcp://localhost:61616");
            Context ctx = new InitialContext(props);

            ConnectionFactory connectionFactory = (ConnectionFactory)ctx.lookup("ConnectionFactory");
            jmsConnection = (TopicConnection)connectionFactory.createConnection();
            TopicSession session = (TopicSession) jmsConnection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            Destination destination = (Destination)ctx.lookup("dynamicTopics/Flights");
            TopicSubscriber subscriber = session.createSubscriber((Topic)destination);
            subscriber.setMessageListener(this);

            Class.forName("org.sqlite.JDBC");
        } catch (JMSException | NamingException | ClassNotFoundException err) {
            err.printStackTrace();
            System.exit(1);
        }
    }


    public void onMessage(Message msg) {
        try {
            String flight = msg.getStringProperty("flight");
            String text = ((TextMessage)msg).getText();

            Matcher matcher = statusPattern.matcher(text); //define matcher from pattern
            if (matcher.find()) {
                String status = matcher.group(1);

                PreparedStatement statement = connection.prepareStatement("INSERT INTO flights VALUES(?, ?)");
                statement.setQueryTimeout(30);

                statement.setString(1, flight);
                statement.setString(2, status);
                statement.executeUpdate();

                System.out.println(String.format("%s -> %s", flight, status));
            }
        } catch (JMSException | SQLException err) {
            err.printStackTrace();
        }
    }


    public void start() {
        try {
            jmsConnection.start();
            connection = DriverManager.getConnection("jdbc:sqlite:/home/biar/flights2.db");
        } catch (JMSException | SQLException err) {
            err.printStackTrace();
        }
    }


    public void stop() {
        try {
            jmsConnection.stop();
            if (connection != null) {
                connection.close();
            }
        } catch (JMSException | SQLException err) {
            err.printStackTrace();
        }
    }
}
