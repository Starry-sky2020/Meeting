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
import java.sql.*;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username);
        System.out.println(password);

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {

            connection = DBUtil.getConnection();

            String sql = "select * from staff";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                String name = resultSet.getString("staff_name");
                String phone = resultSet.getString("staff_phone");
                System.out.println(name);

                if (name.equals(username)){
                    if (phone.equals(password)){
                        HttpSession session = request.getSession(false);
                        session.setAttribute("staff_name",name);
                        request.setAttribute("errorLogin",1);
                        request.getServletContext().setAttribute("staff_id",password);
                        response.sendRedirect(request.getContextPath()+"/welcom.jsp");
                    } else {
                        request.setAttribute("errorLogin",2);
                        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ManagerLogin.jsp");
                        requestDispatcher.forward(request,response);
                    }
                }else{
                    request.setAttribute("errorLogin",3);
                    RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ManagerLogin.jsp");
                    requestDispatcher.forward(request,response);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                DBUtil.close(connection,preparedStatement,resultSet);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}