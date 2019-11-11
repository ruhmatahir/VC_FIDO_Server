package io.swagger;

import com.fasterxml.jackson.databind.util.ISO8601DateFormat;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.SimpleDateFormat;
import java.util.Date;


@SuppressWarnings("deprecation")
public class RFC3339DateFormat extends ISO8601DateFormat {

    private static final long serialVersionUID = 1L;

    // Same as ISO8601DateFormat but serialising milliseconds.
    @Override
    public StringBuffer format(Date date, StringBuffer toAppendTo, FieldPosition fieldPosition) {
//    String value = ISO8601Utils.format(date, true);
        DateFormat value = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        toAppendTo.append(value);
        return toAppendTo;
    }
}