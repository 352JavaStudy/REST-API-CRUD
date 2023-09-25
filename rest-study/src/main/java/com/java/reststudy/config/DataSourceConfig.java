package com.java.reststudy.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
public class DataSourceConfig {

    @Bean
    public DataSource dataSource() throws SQLException {
        OracleDataSource dataSource = new OracleDataSource();
        String path = this.getClass().getResource("/Wallet_HJ2HIMFY8ML9X9DU").getPath();
        String os = System.getProperty("os.name").toLowerCase();
        if(os.contains("win"))
            path = path.replaceFirst("/", "");

        System.out.println(path);
        dataSource.setURL("jdbc:oracle:thin:@hj2himfy8ml9x9du_high?TNS_ADMIN=" + path);
        dataSource.setUser("KIMJEON");
        dataSource.setPassword("RestApiEx2023!");
        return dataSource;
    }
}
