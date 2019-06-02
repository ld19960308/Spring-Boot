package com;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import com.entity.User;

@SpringBootApplication
public class Application  {//implements CommandLineRunner

    public static void main(String args[]) {
        SpringApplication.run(Application.class, args);
    }

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void run(String... strings) throws Exception {

        System.out.println("Creating tables");

        //jdbcTemplate.execute("DROP TABLE customers IF EXISTS");
        //jdbcTemplate.execute("CREATE TABLE customers(" + "id SERIAL, first_name VARCHAR(255), last_name VARCHAR(255))");

        // Split up the array of whole names into an array of first/last names
        List<Object[]> splitUpNames = Arrays.asList("Woo John", "Dean John", "Bloch John", "Long John").stream()
                .map(name -> name.split(" "))
                .collect(Collectors.toList());

        // Use a Java 8 stream to print out each tuple of the list
        splitUpNames.forEach(name -> System.out.println(String.format("Inserting customer record for %s %s", name[0], name[1])));

        // Uses JdbcTemplate's batchUpdate operation to bulk load data
        jdbcTemplate.batchUpdate("INSERT INTO user(id, name) VALUES (?,?)", splitUpNames);

        System.out.println("Querying for user records where id = 'Long':");
        jdbcTemplate.query(
                "SELECT id, name FROM user WHERE id = ?", new Object[] { "Long" },
                (rs, rowNum) -> new User(rs.getString("id"), rs.getString("name"))
        ).forEach(user -> System.out.println(user.toString()));
    }
}