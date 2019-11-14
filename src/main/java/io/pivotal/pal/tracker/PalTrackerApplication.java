package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

@SpringBootApplication
public class PalTrackerApplication {


//    @Qualifier("timeEntryRepository")
//    private JdbcTimeEntryRepository timeEntryRepository;
//    @Autowired
//    private DataSource dataSource;


    public static void main(String[] args){
        SpringApplication.run(PalTrackerApplication.class, args);

    }

    @Bean("timeEntryRepository")
    public TimeEntryRepository getTimeEntryRepository(DataSource dataSource) {
        return new JdbcTimeEntryRepository(dataSource);
    }


}
