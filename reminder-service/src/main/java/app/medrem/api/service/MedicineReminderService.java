package app.medrem.api.service;

import app.medrem.api.entity.MedicineReminder;

public interface MedicineReminderService {

    public MedicineReminder getReminder(String accountNumber);

    public MedicineReminder createReminder(MedicineReminder medicineReminder);

    public MedicineReminder updateReminder(MedicineReminder medicineReminder);

    public void deleteReminder(String accountNumber);
}
