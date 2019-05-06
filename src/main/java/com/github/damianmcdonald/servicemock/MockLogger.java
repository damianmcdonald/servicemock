package com.github.damianmcdonald.servicemock;

import com.github.javafaker.Faker;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.nio.file.AccessDeniedException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

@Component
public class MockLogger {

    private static final Logger LOGGER = LogManager.getLogger(MockLogger.class);
    private static final int ERROR_ITEM = 12;
    private static final int FATAL_ITEM = 33;
    private static final int DEBUG_ITEM = 22;
    private static final int MIN_RANGE = 0;
    private static final int MAX_RANGE = 4;
    private static final String NARRATIVE_RETREIVE_ID = "Request to retreive id: %s";
    private static final String NARRATIVE_RETREIVE_USER = "Retrieved user: %s";
    private static final String NARRATIVE_UPDATE_OLD_ADDRESS = "Updating address - old address: %s";
    private static final String NARRATIVE_UPDATE_NEW_ADDRESS = "Updating address - new address: %s";
    private static final String NARRATIVE_UPDATE_OLD_PHONE = "Updating phoneNumber - old phoneNumber: %s";
    private static final String NARRATIVE_UPDATE_NEW_PHONE = "Updating phoneNumber - new phoneNumber: %s";
    private static final String NARRATIVE_TRANSFER = "Transfer of: €%s to IBAN: %s";
    private static final String NARRATIVE_EXCEPTION_REQUEST_TIMEOUT = "Request timeout to external payment system with transaction id: %s";
    private static final String NARRATIVE_EXCEPTION_ILLEGAL_ARGUMENT = "External payment failed with id: %s";
    private static final String NARRATIVE_EXCEPTION_FILE_NOT_FOUND = "Missing XML file on external payment system for id: %s";
    private static final String NARRATIVE_EXCEPTION_ACCESS_DENIED = "Access denied on external payment system for id: %s";
    private static final String NARRATIVE_EXCEPTION_MALFORMED_URL = "External payment system endpoint not available for id: %s";

    private final Queue<String> loggingQueue = new LinkedList<>();
    private final Faker faker = new Faker();

    @Autowired
    public MockLogger() {
        fillQueue();
    }

    @Scheduled(fixedDelay = 2000, initialDelay = 2000)
    public void scheduleFixedDelayTask() {
        int counter = 0;
        for(final String item : loggingQueue) {
            switch (counter) {
                case ERROR_ITEM:
                    LOGGER.error(item);
                    break;
                case FATAL_ITEM:
                    LOGGER.fatal(item);
                    break;
                case DEBUG_ITEM:
                    LOGGER.debug(item);
                    break;
                default:
                    LOGGER.info(item);
            }
            counter++;
        }

        // throw an exception
        LOGGER.throwing(Level.ERROR, getExceptions()[getRandomIntFromRange()]);

        //refill the queue
        fillQueue();

    }

    private void fillQueue() {
        loggingQueue.add(String.format(NARRATIVE_RETREIVE_ID, generateIdNumber()));
        loggingQueue.add(String.format(NARRATIVE_RETREIVE_USER, generateName()));
        loggingQueue.add(String.format(NARRATIVE_UPDATE_OLD_ADDRESS, generateAddress()));
        loggingQueue.add(String.format(NARRATIVE_UPDATE_NEW_ADDRESS, generateAddress()));

        loggingQueue.add(String.format(NARRATIVE_RETREIVE_ID, generateIdNumber()));
        loggingQueue.add(String.format(NARRATIVE_RETREIVE_USER, generateName()));
        loggingQueue.add(String.format(NARRATIVE_UPDATE_OLD_PHONE, generatePhoneNumber()));
        loggingQueue.add(String.format(NARRATIVE_UPDATE_NEW_PHONE, generatePhoneNumber()));

        loggingQueue.add(String.format(NARRATIVE_RETREIVE_ID, generateIdNumber()));
        loggingQueue.add(String.format(NARRATIVE_RETREIVE_USER, generateName()));
        loggingQueue.add(String.format(NARRATIVE_TRANSFER, generatePrice(), generateIBAN()));

        loggingQueue.add(String.format(NARRATIVE_RETREIVE_ID, generateIdNumber()));
        loggingQueue.add(String.format(NARRATIVE_RETREIVE_USER, generateName()));
        loggingQueue.add(String.format(NARRATIVE_UPDATE_OLD_ADDRESS, generateAddress()));
        loggingQueue.add(String.format(NARRATIVE_UPDATE_NEW_ADDRESS, generateAddress()));

        loggingQueue.add(String.format(NARRATIVE_RETREIVE_ID, generateIdNumber()));
        loggingQueue.add(String.format(NARRATIVE_RETREIVE_USER, generateName()));
        loggingQueue.add(String.format(NARRATIVE_UPDATE_OLD_PHONE, generatePhoneNumber()));
        loggingQueue.add(String.format(NARRATIVE_UPDATE_NEW_PHONE, generatePhoneNumber()));

        loggingQueue.add(String.format(NARRATIVE_RETREIVE_ID, generateIdNumber()));
        loggingQueue.add(String.format(NARRATIVE_RETREIVE_USER, generateName()));
        loggingQueue.add(String.format(NARRATIVE_TRANSFER, generatePrice(), generateIBAN()));

        loggingQueue.add(String.format(NARRATIVE_RETREIVE_ID, generateIdNumber()));
        loggingQueue.add(String.format(NARRATIVE_RETREIVE_USER, generateName()));
        loggingQueue.add(String.format(NARRATIVE_UPDATE_OLD_ADDRESS, generateAddress()));
        loggingQueue.add(String.format(NARRATIVE_UPDATE_NEW_ADDRESS, generateAddress()));

        loggingQueue.add(String.format(NARRATIVE_RETREIVE_ID, generateIdNumber()));
        loggingQueue.add(String.format(NARRATIVE_RETREIVE_USER, generateName()));
        loggingQueue.add(String.format(NARRATIVE_UPDATE_OLD_PHONE, generatePhoneNumber()));
        loggingQueue.add(String.format(NARRATIVE_UPDATE_NEW_PHONE, generatePhoneNumber()));

        loggingQueue.add(String.format(NARRATIVE_RETREIVE_ID, generateIdNumber()));
        loggingQueue.add(String.format(NARRATIVE_RETREIVE_USER, generateName()));
        loggingQueue.add(String.format(NARRATIVE_TRANSFER, generatePrice(), generateIBAN()));

        loggingQueue.add(String.format(NARRATIVE_RETREIVE_ID, generateIdNumber()));
        loggingQueue.add(String.format(NARRATIVE_RETREIVE_USER, generateName()));
        loggingQueue.add(String.format(NARRATIVE_UPDATE_OLD_ADDRESS, generateAddress()));
        loggingQueue.add(String.format(NARRATIVE_UPDATE_NEW_ADDRESS, generateAddress()));

        loggingQueue.add(String.format(NARRATIVE_RETREIVE_ID, generateIdNumber()));
        loggingQueue.add(String.format(NARRATIVE_RETREIVE_USER, generateName()));
        loggingQueue.add(String.format(NARRATIVE_UPDATE_OLD_PHONE, generatePhoneNumber()));
        loggingQueue.add(String.format(NARRATIVE_UPDATE_NEW_PHONE, generatePhoneNumber()));

        loggingQueue.add(String.format(NARRATIVE_RETREIVE_ID, generateIdNumber()));
        loggingQueue.add(String.format(NARRATIVE_RETREIVE_USER, generateName()));
        loggingQueue.add(String.format(NARRATIVE_TRANSFER, generatePrice(), generateIBAN()));
    }

    private Exception[] getExceptions() {
        return new Exception[]{
                new SocketTimeoutException(String.format(NARRATIVE_EXCEPTION_REQUEST_TIMEOUT, generateIdNumber())),
                new IllegalArgumentException(String.format(NARRATIVE_EXCEPTION_ILLEGAL_ARGUMENT, generateIdNumber())),
                new FileNotFoundException(String.format(NARRATIVE_EXCEPTION_FILE_NOT_FOUND, generateIdNumber())),
                new AccessDeniedException(String.format(NARRATIVE_EXCEPTION_ACCESS_DENIED, generateIdNumber())),
                new MalformedURLException(String.format(NARRATIVE_EXCEPTION_MALFORMED_URL, generateIdNumber()))
        };
    }

    private int getRandomIntFromRange() {
        return new Random().nextInt((MAX_RANGE - MIN_RANGE) + 1) + MIN_RANGE;
    }

    private String generateName() {
        return faker.name().fullName();
    }

    private String generateAddress() {
        return faker.address().fullAddress();
    }

    private String generateIdNumber() {
        return faker.idNumber().validSvSeSsn();
    }

    private String generatePhoneNumber() {
        return faker.phoneNumber().phoneNumber();
    }

    private String generateIBAN() {
        return faker.finance().iban();
    }

    private String generatePrice() {
        return faker.commerce().price();
    }

}


