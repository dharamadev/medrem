package app.medrem.api.service;

import app.medrem.api.entity.WaterReminder;

public interface WaterReminderService {

    public WaterReminder createWaterReminder(WaterReminder water);

    public WaterReminder getWaterReminder(String accountNumber);

    public WaterReminder updateWaterReminder(WaterReminder water);

    public void deleteWaterReminder(String accountNumber);
}
