package com.starry_sky.yang.servlet;


import com.starry_sky.yang.bean.Record;
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

@WebServlet({"/ManageRecord", "/DelRecord"})
public class ManageRecordServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String servletPath = request.getServletPath();

        if (servletPath.equals("/ManageRecord")) {
            ManageRecord(request, response);
        } else if (servletPath.equals("/DelRecord")) {
            DelRecord(request, response);
        }

    }

    public void ManageRecord(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DBUtil.getConnection();

            String sql = "select * from meeting_record";

            preparedStatement = connection.prepareStatement(sql);

            resultSet = preparedStatement.executeQuery();

            List<Record> recordList = new ArrayList<>();

            while (resultSet.next()){

                Record record = new Record();
                record.setRecord_id(Integer.valueOf(resultSet.getString("record_id")));
                record.setStart_time(resultSet.getDate("start_time"));
                record.setEnd_time(resultSet.getDate("end_time"));
                record.setDepartment_id(Integer.valueOf(resultSet.getString("department_id")));

                recordList.add(record);
            }

            request.setAttribute("recordList",recordList);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                DBUtil.close(connection,preparedStatement,resultSet);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ManageRecord.jsp");
        requestDispatcher.forward(request,response);
    }

    public void DelRecord(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String record_id = request.getParameter("record_id");

        try {
            connection = DBUtil.getConnection();

            String sql = "delete from meeting_record where record_id=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,record_id);
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

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ManageRecord");
        requestDispatcher.forward(request,response);
    }
}
