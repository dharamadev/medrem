package app.medrem.api.service;

import app.medrem.api.entity.WaterReminder;

public interface WaterReminderService {

    public WaterReminder getReminder(String accountNumber);

    public WaterReminder createReminder(WaterReminder waterReminder);

    public WaterReminder updateReminder(WaterReminder waterReminder);

    public void deleteReminder(String accountNumber);
}
