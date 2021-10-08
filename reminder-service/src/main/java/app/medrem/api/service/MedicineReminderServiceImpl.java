package app.medrem.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.medrem.api.entity.MedicineReminder;
import app.medrem.api.repository.MedicineReminderRepository;

@Service
public class MedicineReminderServiceImpl implements MedicineReminderService {

    @Autowired
    private MedicineReminderRepository medicineReminderRepository;
    
    @Override
    public MedicineReminder getReminder(String accountNumber) {
	return this.medicineReminderRepository.findByAccountNumber(accountNumber);
    }

    @Override
    public MedicineReminder createReminder(MedicineReminder medicineReminder) {
	return this.medicineReminderRepository.save(medicineReminder);
    }

    @Override
    public MedicineReminder updateReminder(MedicineReminder medicineReminder) {
	return this.medicineReminderRepository.save(medicineReminder);
    }

    @Override
    public void deleteReminder(String accountNumber) {
	this.medicineReminderRepository.deleteByAccount(accountNumber);
    }

}
