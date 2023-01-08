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

@WebServlet("/record")
public class RecordServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String sql = "select * from meeting_record";

        try {
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            List<Record> list = new ArrayList<>();

            while(resultSet.next()){
                Record record = new Record();
                record.setRecord_id(resultSet.getInt("record_id"));
                record.setStart_time(resultSet.getDate("start_time"));
                record.setEnd_time(resultSet.getTime("end_time"));
                record.setDepartment_id(resultSet.getInt("department_id"));
                list.add(record);
            }
            request.setAttribute("list", list);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                DBUtil.close(connection,preparedStatement,resultSet);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/record.jsp");
        dispatcher.forward(request, response);

    }
}
