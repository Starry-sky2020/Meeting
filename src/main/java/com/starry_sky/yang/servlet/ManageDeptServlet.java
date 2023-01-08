package com.starry_sky.yang.servlet;

import com.starry_sky.yang.bean.Dept;
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

@WebServlet({"/ManageDept","/UpdateDept","/DelDept"})
public class ManageDeptServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String servletPath = request.getServletPath();

        if (servletPath.equals("/ManageDept")){
            ManageDept(request,response);
        } else if (servletPath.equals("/UpdateDept")) {
            UpdateDept(request,response);
        } else if (servletPath.equals("/DelDept")) {
            DelDept(request,response);
        }
    }

    public void ManageDept(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DBUtil.getConnection();

            String sql = "select * from department";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            List<Dept> deptList = new ArrayList<>();

            while (resultSet.next()){
                Dept dept = new Dept();
                dept.setId(resultSet.getString("id"));
                dept.setDep_name(resultSet.getString("dep_name"));
                dept.setPerson_num(resultSet.getString("person_num"));
                dept.setManage_id(resultSet.getString("manage_id"));
                dept.setManage_name(resultSet.getString("manage_name"));

                deptList.add(dept);
            }

            request.setAttribute("deptList",deptList);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                DBUtil.close(connection,preparedStatement,resultSet);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ManageDept.jsp");
        requestDispatcher.forward(request,response);
    }

    public void UpdateDept(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String dep_name = request.getParameter("dep_name");
        String person_num = request.getParameter("person_num");
        String manage_id = request.getParameter("manage_id");
        String manage_name = request.getParameter("manage_name");
        String id = request.getParameter("id");

        try {
            connection = DBUtil.getConnection();

            String sql = "update department set dep_name=?, person_num=?, manage_id=?, manage_name=?" +
                    "where id=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,dep_name);
            preparedStatement.setString(2,person_num);
            preparedStatement.setString(3,manage_id);
            preparedStatement.setString(4,manage_name);
            preparedStatement.setString(5,id);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                DBUtil.close(connection,preparedStatement,resultSet);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ManageDept");
        requestDispatcher.forward(request,response);
    }

    public void DelDept(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String id = request.getParameter("id");

        try {
            connection = DBUtil.getConnection();

            String sql = "delete from department where id=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,id);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                DBUtil.close(connection,preparedStatement,resultSet);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ManageDept");
        requestDispatcher.forward(request,response);
    }
}
