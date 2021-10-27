package app.medrem.api.util;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.medrem.api.entity.Dose;
import app.medrem.api.entity.Water;

@Component
public class ServiceMapUtil {

    @Autowired
    private Dose dose;

    public Water updateWaterReminderMap(Water waterReminder, Water updateWaterReminder) {
	return Optional.of(updateWaterReminder).map(waterRem -> {
	    waterRem.setWeight(waterReminder.getWeight());
	    dose.setDoseSize(waterReminder.getDose().getDoseSize());
	    dose.setDoseUnit(waterReminder.getDose().getDoseUnit());
	    waterRem.setDose(dose);
	    waterRem.setFrequency(waterReminder.getFrequency());
	    waterRem.setWaterIntake(waterReminder.getWaterIntake());
	    waterRem.setConsumed(waterReminder.getConsumed());
	    waterRem.setBedTime(waterReminder.getBedTime());
	    waterRem.setWakeupTime(waterReminder.getWakeupTime());
	    return waterRem;
	}).get();
    }
}
