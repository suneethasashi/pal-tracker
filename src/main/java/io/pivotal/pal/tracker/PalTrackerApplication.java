package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sql.DataSource;

@SpringBootApplication
public class PalTrackerApplication {


    @Qualifier("timeEntryRepository")
    private static JdbcTimeEntryRepository timeEntryRepository;
    private static DataSource dataSource;


    public static void main(String[] args){
        timeEntryRepository = new JdbcTimeEntryRepository(dataSource);
        SpringApplication.run(PalTrackerApplication.class, args);

    }

    public TimeEntryRepository getTimeEntryRepository() {
        return timeEntryRepository;
    }


}
