package com.starry_sky.yang.servlet;

import com.starry_sky.yang.util.DBUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/submit")
public class SubmitServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String age = request.getParameter("age");
        String address = request.getParameter("address");

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int cnt = 0;

        try {

            connection = DBUtil.getConnection();
            String sql = "insert into staff(staff_name, staff_phone, staff_age, staff_address)" +
                    "values(?,?,?,?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            preparedStatement.setString(3,age);
            preparedStatement.setString(4,address);
            cnt = preparedStatement.executeUpdate();
            System.out.println(cnt);
            request.setAttribute("update",cnt);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                DBUtil.close(connection,preparedStatement, null);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println(cnt);
        if (cnt == 1){
            response.sendRedirect(request.getContextPath()+"/index.jsp");
        } else {
            response.sendRedirect(request.getContextPath()+"/submit.jsp");
        }
    }
}
