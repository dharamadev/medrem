package app.medrem.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.medrem.api.entity.WaterReminder;
import app.medrem.api.repository.WaterReminderRepository;

@Service
public class WaterReminderServiceImpl implements WaterReminderService {

    @Autowired
    private WaterReminderRepository waterReminderRepository;
    
    @Override
    public WaterReminder createWaterReminder(WaterReminder waterReminder) {
	return waterReminderRepository.save(waterReminder);
    }

    @Override
    public WaterReminder getWaterReminder(String accountNumber) {
	return waterReminderRepository.findByAccountNumber(accountNumber);
    }

    @Override
    public WaterReminder updateWaterReminder(WaterReminder waterReminder) {
	return waterReminderRepository.save(waterReminder);
    }

    @Override
    public void deleteWaterReminder(String accountNumber) {
	this.waterReminderRepository.deleteByAccountNumber(accountNumber);
    }

}
