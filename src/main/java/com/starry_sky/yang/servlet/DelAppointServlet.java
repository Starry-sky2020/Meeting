package com.starry_sky.yang.servlet;

import com.starry_sky.yang.bean.Appoint;
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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet({"/lookAppoint", "/delAppoint"})
public class DelAppointServlet extends HttpServlet {

    public void lookAppoint(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet =null;

        try {
            connection = DBUtil.getConnection();
            String sql = "select * from appoint_room";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            List<Appoint> appointList = new ArrayList<>();

            while (resultSet.next()){
                Appoint appoint = new Appoint();
                appoint.setAppoint_id(resultSet.getInt("appoint_id"));
                appoint.setStart_time(resultSet.getString("start_time"));
                appoint.setEnd_time(resultSet.getString("end_time"));
                appoint.setPeople(resultSet.getInt("people"));
                appoint.setRoom_id(resultSet.getInt("room_id"));
                appoint.setDepartment_id(resultSet.getInt("department_id"));
                appoint.setStaff_id(resultSet.getString("staff_id"));

                appointList.add(appoint);
            }

            request.setAttribute("appointList",appointList);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                DBUtil.close(connection,preparedStatement,resultSet);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/delAppoint.jsp");
        requestDispatcher.forward(request,response);

    }

    public void delAppoint( HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;


        try {
            connection = DBUtil.getConnection();
            String sql = "delete from appoint_room where appoint_id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, (String) request.getParameter("delAppoint_id"));
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.close(connection,preparedStatement,null);
        }

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/lookAppoint");
        requestDispatcher.forward(request,response);
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String servletPath = request.getServletPath();

        if (servletPath.equals("/lookAppoint")){
            lookAppoint(request,response);
        } else if (servletPath.equals("/delAppoint")){
            try {
                delAppoint(request,response);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}