package com.charniauski.training.horsesrace.web.controller;

import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ivc4 on 25.11.2016.
 */
//@WebServlet("/test")
public class SomeServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<String> list = new ArrayList<>();
        list.add("item1");
        list.add("item2");
        list.add("item3");
        list.add("item3");
        list.add("item3");
        list.add("item3");
        list.add("item3");
        list.add("item3");
        list.add("item3");
        String json = new Gson().toJson(list);

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(json);
    }
}
