package dao.impl;

import dao.UserDao;
import model.User;
import config.DBConnect; // Import class DBConnect
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {
    @Override
    public User get(String username) {
        User user = null;
        String sql = "SELECT * FROM users WHERE username = ?";
        
        // Sử dụng DBConnect để lấy Connection
        try (Connection conn = DBConnect.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUserName(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                // Thêm các thuộc tính khác nếu có
                user.setFullName(rs.getString("fullname"));
                user.setEmail(rs.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}