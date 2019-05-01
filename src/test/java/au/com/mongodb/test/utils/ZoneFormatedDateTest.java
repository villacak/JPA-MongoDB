package au.com.mongodb.test.utils;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ZoneFormatedDateTest {

    private String testDateTimeString;
    private ZoneFormatedDate zfd;


    @Before
    public void startup() {
    }


    @After
    public void cleanup() {
        testDateTimeString = null;
        zfd = null;
    }


    @Test
    public void testSuccessDefaultConstructorZoneFormatedDate() {
        LocalDateTime tempLDT = LocalDateTime.now(ZoneId.systemDefault());
        testDateTimeString = tempLDT.toString();
        zfd = new ZoneFormatedDate(testDateTimeString);
        assertNotNull(zfd.getLocalDateTime());
        assertEquals(zfd.getLocalDateTime(), tempLDT);
    }


    @Test
    public void testSuccessSecondConstructorZoneFormatedDate() {
        LocalDateTime tempLDT = LocalDateTime.now(ZoneId.systemDefault());
        testDateTimeString = tempLDT.toString();
        zfd = new ZoneFormatedDate(testDateTimeString, ZoneId.systemDefault());
        assertNotNull(zfd.getLocalDateTime());
        assertEquals(zfd.getLocalDateTime(), tempLDT);
    }


    @Test
    public void testSuccessLastConstructorZoneFormatedDate() {
        final String ZONED = "Z";
        LocalDateTime tempLDT = LocalDateTime.now(ZoneId.systemDefault());
        ZonedDateTime tempZDT = ZonedDateTime.of(tempLDT, ZoneId.systemDefault());
        testDateTimeString = tempLDT.toString();

        zfd = new ZoneFormatedDate(testDateTimeString, DateTimeFormatter.ISO_ZONED_DATE_TIME, ZoneId.systemDefault());
        assertNotNull(zfd.getLocalDateTime());
        assertEquals(zfd.getLocalDateTime(), tempLDT);
        assertEquals(zfd.getDateTimeStr(), testDateTimeString + ZONED);
        assertEquals(zfd.getZonedDateTime(), tempZDT);
        assertEquals(zfd.getFormatedDateTimeStrFromLocal(), tempLDT.toString());
        assertEquals(zfd.getFormatedDateTimeStrFromZoned(), tempZDT.toString());
    }


    @Test(expected = DateTimeException.class)
    public void testFailDefaultConstructorZoneFormatedDate() {
        LocalDateTime tempLDT = null;
        zfd = new ZoneFormatedDate(testDateTimeString);
    }
}
