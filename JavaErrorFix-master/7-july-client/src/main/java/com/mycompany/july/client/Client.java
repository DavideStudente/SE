/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.july.client;

import com.mycompany.july.server.Director;
import com.mycompany.july.server.Exam;
import com.mycompany.july.server.ExamImpl;
import com.mycompany.july.server.Movie;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author biar
 */
public class Client {
    public static void main(String[] args) {
        List<Integer> movies = new LinkedList<>();
        ExamImpl port;
        try {
            ExamImpl service = new ExamImpl();
            //Exam port = service.getExamImplPort();
            port = service;
            movies = port.getMovies();
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        Director director;
        Movie movie;
        for(int i = 0; i < movies.size(); i++) {
            try {
                ExamImpl service = new ExamImpl();
                //Exam port = service.getExamImplPort();
                port = service;

                movie = port.getMovie(movies.get(i));
                director = port.getDirector(movie.getDirectorID());

                System.out.println("[C] Movie " + movie.getID() + ": "
                                   + movie.getTitle() + " (" + movie.getYear() + ")\n"
                                   + "Director " + director.getID() + ": "
                                   + director.getName() + " (" + director.getYearOfBirth() + ")\n");

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
