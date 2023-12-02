package student.examples.ggengine;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class GgengineApplication {

	public static void main(String[] args) {
//		long currentTimestamp = System.currentTimeMillis();
//		
//		// Get the current timestamp
//        long currentTimestamp1 = System.currentTimeMillis();
//
//        // Calculate the timestamp for 24 hours ago
//        long twentyFourHoursAgo = currentTimestamp1 - (24 * 60 * 60 * 1000);
//
//        // Convert to Instant for better date manipulation
//        Instant twentyFourHoursAgoInstant = Instant.ofEpochMilli(twentyFourHoursAgo);
//
//        // Save the result as an int (truncate to int)
//        int last24HoursTimestamp = (int) twentyFourHoursAgo;
//
//        System.out.println("Current Timestamp: " + currentTimestamp1);
//        System.out.println("Instant for 24 Hours Ago: " + twentyFourHoursAgoInstant);
//        System.out.println("Last 24 Hours Timestamp (as int): " + last24HoursTimestamp);
//        
//        System.out.println(6<<1);
//        System.out.println(currentTimestamp>>10);//>>10000000
//        System.out.println(currentTimestamp & Integer.MAX_VALUE);

		SpringApplication.run(GgengineApplication.class, args);

	}

}
