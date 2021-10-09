package app.medrem.api;

import java.time.LocalTime;

import org.springframework.core.convert.converter.Converter;

public class StringToLocalTime implements Converter<String, LocalTime> {

    @Override
    public LocalTime convert(String source) {
	return LocalTime.parse(source);
    }
}
 