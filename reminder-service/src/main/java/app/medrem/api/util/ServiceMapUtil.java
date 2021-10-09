package app.medrem.api.util;

import java.util.Optional;

import org.springframework.stereotype.Component;

import app.medrem.api.entity.WaterReminder;

@Component
public class ServiceMapUtil {

    public WaterReminder updateWaterReminderMap(WaterReminder waterReminder, WaterReminder updateWaterReminder) {
	return Optional.of(updateWaterReminder).map(waterRem -> {
	    waterRem.setGender(waterReminder.getGender());
	    waterRem.setDoseSize(waterReminder.getDoseSize());
	    waterRem.setFrequency(waterReminder.getFrequency());
	    waterRem.setWaterIntake(waterReminder.getWaterIntake());
	    waterRem.setConsumed(waterReminder.getConsumed());
	    waterRem.setBedTime(waterReminder.getBedTime());
	    waterRem.setWakeupTime(waterReminder.getWakeupTime());
	    return waterRem;
	}).get();
    }
}
