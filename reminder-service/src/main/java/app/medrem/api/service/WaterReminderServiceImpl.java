package app.medrem.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.medrem.api.model.Water;
import app.medrem.api.repository.WaterReminderRepository;

@Service
public class WaterReminderServiceImpl implements WaterReminderService {

    @Autowired
    private WaterReminderRepository waterReminderRepository;
    
    @Override
    public Water createWaterReminder(Water waterReminder) {
	return waterReminderRepository.save(waterReminder);
    }

    @Override
    public Water getWaterReminder(String accountNumber) {
	return waterReminderRepository.findByAccountNumber(accountNumber);
    }

    @Override
    public Water updateWaterReminder(Water waterReminder) {
	return waterReminderRepository.save(waterReminder);
    }

    @Override
    public void deleteWaterReminder(String accountNumber) {
	this.waterReminderRepository.deleteByAccountNumber(accountNumber);
    }

}
