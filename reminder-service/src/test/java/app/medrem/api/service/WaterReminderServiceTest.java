package app.medrem.api.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import app.medrem.api.constant.ReminderType;
import app.medrem.api.constant.WaterUnit;
import app.medrem.api.model.Water;
import app.medrem.api.model.WaterDose;
import app.medrem.api.repository.WaterReminderRepository;

@ExtendWith(MockitoExtension.class)
public class WaterReminderServiceTest {

    @InjectMocks
    private WaterReminderServiceImpl waterReminderServiceImpl;

    @Mock
    private WaterReminderRepository waterReminderRepository;

    @Test
    public void getWaterReminderTest() {

	Water water = new Water("MR9454318045", 60, new WaterDose(100, WaterUnit.ML), 10, 10, 5, "8:30AM", "10:30PM");
	water.setId("6188d254ee97ed79200f1e37");
	water.setNotes("Abc notes");
	water.setReminderType(ReminderType.WATER);
	when(this.waterReminderRepository.findByAccountNumber(Mockito.anyString())).thenReturn(water);
	assertNotNull(this.waterReminderServiceImpl.getWaterReminder("MR9454318045"));
	assertEquals(this.waterReminderServiceImpl.getWaterReminder("MR9454318045"), water);
    }

    @Test
    public void createWaterReminderTest() {
	Water water = new Water("MR9454318045", 60, new WaterDose(100, WaterUnit.ML), 10, 10, 5, "8:30AM", "10:30PM");
	water.setId("6188d254ee97ed79200f1e37");
	water.setNotes("Abc notes");
	water.setReminderType(ReminderType.WATER);
	when(this.waterReminderRepository.save(Mockito.any())).thenReturn(water);
	assertNotNull(waterReminderServiceImpl.createWaterReminder(water));
	assertEquals(this.waterReminderServiceImpl.createWaterReminder(water), water);
    }

    @Test
    public void updateAccountTest() {
	Water water = new Water("MR9454318045", 60, new WaterDose(100, WaterUnit.ML), 10, 10, 5, "8:30AM", "10:30PM");
	water.setId("6188d254ee97ed79200f1e37");
	water.setNotes("Abc notes");
	when(this.waterReminderRepository.save(Mockito.any())).thenReturn(water);
	assertNotNull(waterReminderServiceImpl.updateWaterReminder(water));
	assertEquals(waterReminderServiceImpl.updateWaterReminder(water), water);
    }
    
    @Test
    public void deleteAccount() {
	this.waterReminderServiceImpl.deleteWaterReminder(new String("MR9454318045"));
	verify(waterReminderRepository, Mockito.times(1)).deleteByAccountNumber(new String("MR9454318045"));
    }
}
