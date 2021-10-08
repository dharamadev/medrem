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
    public WaterReminder getReminder(String accountNumber) {
	return this.waterReminderRepository.findByAccountNumber(accountNumber);
    }

    @Override
    public WaterReminder createReminder(WaterReminder waterReminder) {
	return this.waterReminderRepository.save(waterReminder);
    }

    @Override
    public WaterReminder updateReminder(WaterReminder waterReminder) {
	return this.waterReminderRepository.save(waterReminder);
    }

    @Override
    public void deleteReminder(String accountNumber) {
	this.waterReminderRepository.deleteByAccount(accountNumber);
    }

}
