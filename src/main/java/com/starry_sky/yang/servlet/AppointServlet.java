package com.starry_sky.yang.servlet;

import com.starry_sky.yang.util.DBUtil;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


@WebServlet("/appoint")
public class AppointServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String room = request.getParameter("room");
        String start_time =  request.getParameter("start_time");
        String end_time =  request.getParameter("end_time");
        String people = request.getParameter("people");
        String department_id = request.getParameter("department_id");
        String staff_id = (String) request.getServletContext().getAttribute("staff_id");

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int cnt = 0;
        System.out.println("hh");
        try {
            connection = DBUtil.getConnection();
            String sql = "insert into appoint_room (start_time,end_time,people,department_id,room_id,staff_id) " +
                    "values (?,?,?,?,?,?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,start_time);
            preparedStatement.setString(2,end_time);
            preparedStatement.setString(3,people);
            preparedStatement.setString(4,department_id);
            preparedStatement.setString(5,room);
            preparedStatement.setString(6,staff_id);
            cnt = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                DBUtil.close(connection, preparedStatement, null);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        RequestDispatcher dispatcher;
        if (cnt == 1){
            dispatcher = request.getRequestDispatcher("/Appoint.jsp");
        } else {
            dispatcher = request.getRequestDispatcher("/error.jsp");
        }
        dispatcher.forward(request, response);
    }
}
