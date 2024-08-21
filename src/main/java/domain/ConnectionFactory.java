package domain;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionFactory {
    public Connection recuperarConexao() {
        try {
            return createDataSource().getConnection();
        } catch (SQLException e) {
            throw  new RuntimeException(e);
        }
    }

    public HikariDataSource createDataSource() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql://localhost:3306/cali_bank");
        config.setUsername("root");
        config.setPassword("Cali020730");
        config.setMaximumPoolSize(10);

        return new HikariDataSource(config);
    }
}


