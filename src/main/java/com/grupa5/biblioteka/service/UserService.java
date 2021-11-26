package com.grupa5.biblioteka.service;

import com.grupa5.biblioteka.model.USER_ROLE;
import com.grupa5.biblioteka.model.User;
import com.grupa5.biblioteka.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import javax.transaction.Transactional;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    DataSource dataSource;

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public List<User> getUsers() {
        return userRepository.findAllQUERY();
    }

    public User getUserById(Long id) {
        Optional<User> mockUser = userRepository.findById(id);

        return mockUser.get();
    }



    public User saveMockUser() {
        return userRepository.save(new User("AAAAAA", "BBBBB", "C", "d", true,USER_ROLE.USER));
    }


    public User saveUser(User user) {
        return userRepository.save(new User(
                    user.getLogin(),
                    user.getPassword(),
                    user.getName(),
                    user.getSurname(),
                    true,
                    USER_ROLE.USER
                )
        );
    }


    @Transactional
    public User deleteUser(Long id) {
        Optional<User> user = userRepository.findById(id);
        userRepository.deleteById(id);

        return user.get();
    }


    public void addBook(Long user_id, Long book_id) {
        final String SQL_STATEMENT = "INSERT INTO users_books VALUES (" + user_id + ", " + book_id + ")";
        //ResultSet rs = bookRepository.findUsersById(id);

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = dataSource.getConnection();
            stmt = conn.prepareStatement(SQL_STATEMENT);
            rs = stmt.executeQuery();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        finally {
            try {
                if(stmt != null){
                    stmt.close();
                }
                if(conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
