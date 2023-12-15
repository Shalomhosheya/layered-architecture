package com.example.layeredarchitecture.Doa;

import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.CustomerDTO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CustomerDOAimpl {
    public ArrayList<CustomerDTO> getAllcustomer() throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery("SELECT * FROM Customer");
        ArrayList<CustomerDTO>  getAllcustomer = new ArrayList<>();
        while(rst.next()){
            CustomerDTO customerDTO = new CustomerDTO(rst.getString("id"),rst.getString("name"),rst.getString("address"));
            getAllcustomer.add(customerDTO);
        }
        return getAllcustomer;
    }
}
