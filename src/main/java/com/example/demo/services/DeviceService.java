package com.example.demo.services;

import com.example.demo.demo.DBConfig;
import com.example.demo.demo.DBConnection;
import com.example.demo.entity.Device;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class DeviceService {

    public Device getDeviceById(int id) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(DBConfig.class);

        DBConnection dbConnection = applicationContext.getBean(DBConnection.class);

        Connection connection = dbConnection.getConnection();

        String sql = "SELECT * FROM device where device_id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();

            final Device device = new Device();
            device.setId(resultSet.getInt("device_id"));
            device.setType(resultSet.getString("type"));
            device.setName(resultSet.getString("name"));
            device.setPrice(resultSet.getDouble("price"));
            device.setDate(resultSet.getDate("date"));
            device.setDescription(resultSet.getString("description"));
            device.setAvailability(resultSet.getBoolean("availability"));
            device.setFactoryId(resultSet.getInt("factory_id"));

            return device;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Device> getDevices() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(DBConfig.class);

        DBConnection dbConnection = applicationContext.getBean(DBConnection.class);

        Connection connection = dbConnection.getConnection();

        String sql = "SELECT * FROM device";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            List<Device> devices = new ArrayList<>();

            while (resultSet.next()) {
                final Device device = new Device();
                device.setId(resultSet.getInt("device_id"));
                device.setType(resultSet.getString("type"));
                device.setName(resultSet.getString("name"));
                device.setPrice(resultSet.getDouble("price"));
                device.setDate(resultSet.getDate("date"));
                device.setDescription(resultSet.getString("description"));
                device.setAvailability(resultSet.getBoolean("availability"));
                device.setFactoryId(resultSet.getInt("factory_id"));
                devices.add(device);
            }

            return devices;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
