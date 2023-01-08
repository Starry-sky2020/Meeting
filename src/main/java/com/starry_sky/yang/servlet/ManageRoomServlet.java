package com.starry_sky.yang.servlet;

import com.starry_sky.yang.bean.Room;
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

@WebServlet({"/ManageRoom", "/UpdateManageRoom", "/DelManageRoom"})
public class ManageRoomServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String servletPath = request.getServletPath();

        if (servletPath.equals("/ManageRoom")){
            ManageRoom(request,response);
        } else if (servletPath.equals("/UpdateManageRoom")) {
            UpdateManageRoom(request,response);
        } else if (servletPath.equals("/DelManageRoom")) {
            DelManageRoom(request,response);
        }
    }

    public void ManageRoom(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DBUtil.getConnection();

            String sql = "select * from meeting_room";

            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            List<Room> roomList = new ArrayList<>();

            while (resultSet.next()){
                Room room = new Room();
                room.setRoom_id(resultSet.getString("room_id"));
                room.setStart_time(resultSet.getDate("start_time"));
                room.setEnd_time(resultSet.getDate("end_time"));
                room.setAddress(resultSet.getString("address"));
                room.setMax_people(resultSet.getInt("max_people"));

                roomList.add(room);
            }

            request.setAttribute("roomList",roomList);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                DBUtil.close(connection, preparedStatement, resultSet);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ManageRoom.jsp");
        requestDispatcher.forward(request, response);
    }

    public void UpdateManageRoom(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String start_time = request.getParameter("start_time");
        String end_time = request.getParameter("end_time");
        String address = request.getParameter("address");
        String max_people = request.getParameter("max_people");
        String room_id = request.getParameter("room_id");

        try {
            connection = DBUtil.getConnection();

            String sql = "update meeting_room set start_time=?,end_time=?," +
                    "address=?,max_people=? where room_id=?";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,start_time);
            preparedStatement.setString(2, end_time);
            preparedStatement.setString(3,address);
            preparedStatement.setString(4,max_people);
            preparedStatement.setString(5,room_id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                DBUtil.close(connection,preparedStatement,null);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ManageRoom");
        requestDispatcher.forward(request, response);
    }

    public void DelManageRoom(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String room_id = request.getParameter("room_id");

        try {
            connection = DBUtil.getConnection();

            String sql = "delete from meeting_room where room_id=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,room_id);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                DBUtil.close(connection,preparedStatement,null);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ManageRoom");
        requestDispatcher.forward(request, response);
    }
}