package app.medrem.api.util;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToLocalTime implements Converter<String, String> {

    @Override
    public String convert(String source) {
	return LocalTime.parse(source, DateTimeFormatter.ofPattern("HH:mm:ss")).format(DateTimeFormatter.ofPattern("hh:mm:ss a"));
    }
}
 