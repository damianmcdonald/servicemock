package com.github.damianmcdonald.servicemock.loggers.latin;

import com.github.damianmcdonald.servicemock.AbstractMockLogger;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.IntStream;

@Component
public class LatinMockLogger extends AbstractMockLogger{

    private static final Logger LOGGER = LogManager.getLogger(LatinMockLogger.class);
    private static final int ERROR_ITEM = 20;
    private static final int FATAL_ITEM = 5;
    private static final int DEBUG_ITEM = 15;
    private static final int WARN_ITEM = 25;
    private static final int TRACE_ITEM = 10;
    private static final int MIN_QUEUE_RANGE=1;
    private static final int MAX_QUEUE_RANGE=40;
    private static final String NARRATIVE_RETREIVE_ID = "Peto, ut id retreive: %s";
    private static final String NARRATIVE_RETREIVE_USER = "Receptum usor: %s";
    private static final String NARRATIVE_UPDATE_OLD_ADDRESS = "Adaequationis oratio - vetus inscriptio: %s";
    private static final String NARRATIVE_UPDATE_NEW_ADDRESS = "Adaequationis oratio - novus oratio: %s";
    private static final String NARRATIVE_UPDATE_OLD_PHONE = "PhoneNumber adaequationis - vetus phoneNumber: %s";
    private static final String NARRATIVE_UPDATE_NEW_PHONE = "PhoneNumber adaequationis - novus phoneNumber: %s";
    private static final String NARRATIVE_TRANSFER = "De translatione: %s € ut IBAN: %s";
    private final Queue<String> loggingQueue = new LinkedList<>();

    @Scheduled(cron = "${logger.latin.schedule}")
    public void scheduleFixedDelayTask() {

        // fill the queue is it is empty
        if(loggingQueue.isEmpty()) fillQueue();

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
                case TRACE_ITEM:
                    LOGGER.trace(item);
                    break;
                case WARN_ITEM:
                    LOGGER.warn(item);
                    break;
                default:
                    LOGGER.info(item);
            }
            counter++;
        }

        // throw an exception
        LOGGER.throwing(Level.ERROR, generateException());

        //refill the queue
        fillQueue();

    }

    private void fillQueue() {
        IntStream.rangeClosed(MIN_QUEUE_RANGE, MAX_QUEUE_RANGE).forEach(nbr ->
                {
                    populateLogsWithAddressUpdate();
                    populateLogsWithPhoneNumberUpdate();
                    populateLogsWithFundsTransfer();
                }
        );
    }

    private void populateLogsWithAddressUpdate() {
        loggingQueue.add(String.format(NARRATIVE_RETREIVE_ID, generateIdNumber()));
        loggingQueue.add(String.format(NARRATIVE_RETREIVE_USER, generateName()));
        loggingQueue.add(String.format(NARRATIVE_UPDATE_OLD_ADDRESS, generateAddress()));
        loggingQueue.add(String.format(NARRATIVE_UPDATE_NEW_ADDRESS, generateAddress()));
    }

    private void populateLogsWithPhoneNumberUpdate() {
        loggingQueue.add(String.format(NARRATIVE_RETREIVE_ID, generateIdNumber()));
        loggingQueue.add(String.format(NARRATIVE_RETREIVE_USER, generateName()));
        loggingQueue.add(String.format(NARRATIVE_UPDATE_OLD_PHONE, generatePhoneNumber()));
        loggingQueue.add(String.format(NARRATIVE_UPDATE_NEW_PHONE, generatePhoneNumber()));
    }

    private void populateLogsWithFundsTransfer() {
        loggingQueue.add(String.format(NARRATIVE_RETREIVE_ID, generateIdNumber()));
        loggingQueue.add(String.format(NARRATIVE_RETREIVE_USER, generateName()));
        loggingQueue.add(String.format(NARRATIVE_TRANSFER, generatePrice(), generateIBAN()));
    }
}
