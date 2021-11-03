package app.medrem.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.medrem.api.model.Medicine;
import app.medrem.api.repository.MedicineRepository;

@Service
public class MedicineReminderServiceImpl implements MedicineReminderService {

    @Autowired
    private MedicineRepository medicineRepository;
    
    @Override
    public Medicine createMedicineReminder(Medicine medicine) {
	return this.medicineRepository.save(medicine);
    }

    @Override
    public Medicine getMedicineReminder(String accountNumber) {
	return this.medicineRepository.findByAccountNumber(accountNumber);
    }

    @Override
    public Medicine updateMedicineReminder(Medicine medicine) {
	return this.medicineRepository.save(medicine);
    }

    @Override
    public void deleteMedicineReminder(String accountNumber) {
	this.medicineRepository.deleteByAccountNumber(accountNumber);
    }
}
