package app.medrem.api.service;

import app.medrem.api.entity.WaterReminder;

public interface WaterReminderService {

    public WaterReminder getReminder(String accountNumber);

    public WaterReminder createReminder(WaterReminder reminder);

    public WaterReminder updateReminder(WaterReminder reminder);

    public void deleteReminder(String accountNumber);
}
