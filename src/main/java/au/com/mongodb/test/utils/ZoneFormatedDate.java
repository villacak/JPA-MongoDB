package au.com.mongodb.test.utils;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;


/**
 * Format date for Local and Zoned datetime
 *
 */
public class ZoneFormatedDate {

    private final String ZONED = "Z";

    private String dateTimeStr;
    private ZonedDateTime zonedDateTime;
    private LocalDateTime localDateTime;


    /**
     * Basic constructor just with the string datetime to be formatted
     *
     * @param dateTimeStr
     */
    public ZoneFormatedDate(final String dateTimeStr) {
        this(dateTimeStr, null, null);
    }


    /**
     * Constructor with string datetime and zone id
     *
     * @param dateTimeStr
     * @param zoneId
     */
    public ZoneFormatedDate(final String dateTimeStr, final ZoneId zoneId) {
        this(dateTimeStr, null, zoneId);
    }


    /**
     * Complete constructor
     *
     * @param dateTimeStr
     * @param dateTimeFormatter
     * @param zoneId
     */
    public ZoneFormatedDate(String dateTimeStr, DateTimeFormatter dateTimeFormatter, ZoneId zoneId) {
        if (dateTimeStr != null && !dateTimeStr.endsWith(ZONED)) {
            dateTimeStr = dateTimeStr + ZONED;
        } else {
            throw new DateTimeException("Not allowed value to format be null.");
        }
        if (dateTimeFormatter == null) {
            dateTimeFormatter = DateTimeFormatter.ISO_ZONED_DATE_TIME;
        }

        if (zoneId == null) {
            zoneId = ZoneId.systemDefault();
        }
        this.dateTimeStr = dateTimeStr;
        this.localDateTime = LocalDateTime.parse(dateTimeStr, dateTimeFormatter);
        this.zonedDateTime = localDateTime.atZone(zoneId);
    }


    /**
     * Get the dateTime string
     *
     * @return
     */
    public String getDateTimeStr() {
        return dateTimeStr;
    }


    /**
     * Get LocalDateTime formatted
     *
     * @return
     */
    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }


    /**
     * Get ZonedDateTime formatted
     *
     * @return
     */
    public ZonedDateTime getZonedDateTime() {
        return zonedDateTime;
    }


    /**
     * Get LocalDateTime formatted as String
     *
     * @return
     */
    public String getFormatedDateTimeStrFromLocal() {
        final String tempLocalDateTime = this.localDateTime.toString();
        return tempLocalDateTime;
    }


    /**
     * Get ZonedDateTime formatted as Strin
     *
     * @return
     */
    public String getFormatedDateTimeStrFromZoned() {
        final String tempZonedDateTime = this.zonedDateTime.toString();
        return tempZonedDateTime;
    }
}
