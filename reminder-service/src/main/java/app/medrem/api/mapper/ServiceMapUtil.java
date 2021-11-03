package app.medrem.api.mapper;

import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import app.medrem.api.model.Medicine;
import app.medrem.api.model.MedicineDose;
import app.medrem.api.model.Water;
import app.medrem.api.model.WaterDose;

@Component
public class ServiceMapUtil {

    public Water updateWaterReminderMap(Water water) {
	Water updatedWater = new Water();
	return Optional.of(updatedWater).map(waterRem -> {
	    WaterDose waterDose = new WaterDose();
	    waterDose.setDoseSize(water.getWaterDose().getDoseSize());
	    waterDose.setDoseUnit(water.getWaterDose().getDoseUnit());
	    waterRem.setWaterDose(waterDose);
	    waterRem.setWeight(water.getWeight());
	    waterRem.setFrequency(water.getFrequency());
	    waterRem.setWaterIntake(water.getWaterIntake());
	    waterRem.setConsumed(water.getConsumed());
	    waterRem.setBedTime(water.getBedTime());
	    waterRem.setWakeupTime(water.getWakeupTime());
	    return waterRem;
	}).get();
    }

    public Medicine updateMedicineReminderMap(Medicine medicine) {

	Medicine updatedMed = new Medicine();
	return Optional.of(updatedMed).map(medRem -> {
	    medRem.setAccountNumber(medicine.getAccountNumber());
	    medRem.setId(medicine.getId());
	    medRem.setReminderType(medicine.getReminderType());
	    medRem.setIllness(medicine.getIllness());
	    medRem.setFillingDate(medicine.getFillingDate());
	    medRem.setMedFrequency(medicine.getMedFrequency());
	    medRem.setFillingDate(medicine.getFillingDate());
	    medRem.setInstructions(medicine.getInstructions());
	    medRem.setNotes(medicine.getNotes());
	    medRem.setMedicineDetails(medicine.getMedicineDetails().stream().map(med -> {
		MedicineDose medDose = new MedicineDose();
		medDose.setMedName(med.getMedName());
		medDose.setDoseSize(med.getDoseSize());
		medDose.setDoseUnit(med.getDoseUnit());
		medDose.setMedicineType(med.getMedicineType());
		return medDose;
	    }).collect(Collectors.toList()));
	    return medRem;
	}).get();
    }
}
