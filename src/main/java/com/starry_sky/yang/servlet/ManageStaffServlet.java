package com.starry_sky.yang.servlet;

import com.starry_sky.yang.bean.Staff;
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

@WebServlet({"/ManageStaff","/updateStaff","/delStaff"})
public class ManageStaffServlet extends HttpServlet {

    //解雇员工
    private void delStaff(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String staff_id = request.getParameter("staff_id");
        try {
            connection = DBUtil.getConnection();
            String sql = "delete from staff where staff_id=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,staff_id);
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

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ManageStaff");
        requestDispatcher.forward(request,response);
    }

    public void updateStaff(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String staff_id = request.getParameter("staff_id");
        String staff_name = request.getParameter("staff_name");
        String staff_age = request.getParameter("staff_age");
        String staff_address = request.getParameter("staff_address");
        String staff_phone = request.getParameter("staff_phone");

        int cnt = 0;
        try {
            connection = DBUtil.getConnection();
            String sql = "update staff set staff_name=?,staff_age=?,staff_address=?,staff_phone=?where staff_id=?";

            preparedStatement=connection.prepareStatement(sql);

            preparedStatement.setString(1,staff_name);
            preparedStatement.setString(2, staff_age);
            preparedStatement.setString(3,staff_address);
            preparedStatement.setString(4, staff_phone);
            preparedStatement.setString(5, staff_id);

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


        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ManageStaff");
        requestDispatcher.forward(request,response);
    }

    public void manageStaff(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DBUtil.getConnection();
            String sql = "select * from staff";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            List<Staff> staffList = new ArrayList<>();

            while (resultSet.next()){
                Staff staff = new Staff();
                staff.setStaff_id(resultSet.getString("staff_id"));
                staff.setStaff_name(resultSet.getString("staff_name"));
                staff.setStaff_age(resultSet.getInt("staff_age"));
                staff.setStaff_phone(resultSet.getString("staff_phone"));
                staff.setStaff_address(resultSet.getString("staff_address"));

                staffList.add(staff);
            }

            request.setAttribute("staffList",staffList);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                DBUtil.close(connection,preparedStatement,resultSet);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ManageStaff.jsp");
        requestDispatcher.forward(request,response);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String servletPath = request.getServletPath();
        if (servletPath.equals("/delStaff")){
            delStaff(request,response);
        } else if (servletPath.equals("/updateStaff")) {
            updateStaff(request,response);
        } else if (servletPath.equals("/ManageStaff")){
            manageStaff(request,response);
        }

    }
}
