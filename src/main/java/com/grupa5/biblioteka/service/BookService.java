package com.grupa5.biblioteka.service;

import com.grupa5.biblioteka.model.Book;
import com.grupa5.biblioteka.model.User;
import com.grupa5.biblioteka.repository.BookRepository;
import com.grupa5.biblioteka.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final UserRepository userRepository;

    @Autowired
    DataSource dataSource;

    @Autowired
    public BookService(BookRepository bookRepository, UserRepository userRepository) {
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
    }

    public Iterable<Book> getBooks() {
        return bookRepository.findAll();
    }


    public List<User> getUsersByBookId(Long id) throws SQLException {

        List<User> userList = new ArrayList<>();

        final String SQL_STATEMENT = " SELECT u.id, u.login, u.password, u.name, u.surname, u.enabled, u.USER_ROLE " +
                "FROM users u LEFT JOIN users_books ON users_books.user_id = u.id " +
                "WHERE users_books.book_id = " + id + ";";
        //ResultSet rs = bookRepository.findUsersById(id);

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = dataSource.getConnection();
            stmt = conn.prepareStatement(SQL_STATEMENT);
            rs = stmt.executeQuery();

            while(rs.next()) {
                Long user_id = rs.getLong("id");
                Optional<User> user = userRepository.findById(user_id);

                if(user != null) {
                    userList.add(user.get());
                }
            }
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

        return userList;

    }
}
