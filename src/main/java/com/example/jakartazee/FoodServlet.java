package com.example.jakartazee;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet (name="food-serrvlet", value = "/foods")
    public class FoodServlet extends HelloServlet {


        @Override
        public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
            super.doGet(req, resp);
        }



    }
