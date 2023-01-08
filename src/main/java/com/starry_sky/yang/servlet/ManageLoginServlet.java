package com.starry_sky.yang.servlet;

import com.starry_sky.yang.util.DBUtil;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/managerLogin")
public class ManageLoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String password = request.getParameter("password");
        String username = request.getParameter("username");

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DBUtil.getConnection();
            String sql = "select * from manager";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                if (resultSet.getString("manager_id").equals(password)){
                    if (resultSet.getString("manager_name").equals(username)){
                        HttpSession session = request.getSession(false);
                        session.setAttribute("manager_name",username);

                        request.setAttribute("errorLogin",1);
                        response.sendRedirect(request.getContextPath()+"/ManagerWelcome.jsp");
                    } else {
                        request.setAttribute("errorLogin",2);
                        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ManagerLogin.jsp");
                        requestDispatcher.forward(request,response);
                    }
                } else {
                    request.setAttribute("errorLogin",3);
                    RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ManagerLogin.jsp");
                    requestDispatcher.forward(request,response);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                DBUtil.close(connection,preparedStatement,resultSet);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
