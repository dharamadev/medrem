package app.medrem.api.service;

import app.medrem.api.model.Medicine;

public interface MedicineReminderService {

    public Medicine createMedicineReminder(Medicine medicine);

    public Medicine getMedicineReminder(String accountNumber);

    public Medicine updateMedicineReminder(Medicine medicine);

    public void deleteMedicineReminder(String accountNumber);
}
