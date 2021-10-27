package app.medrem.api.service;

import app.medrem.api.entity.Water;

public interface WaterReminderService {

    public Water createWaterReminder(Water water);

    public Water getWaterReminder(String accountNumber);

    public Water updateWaterReminder(Water water);

    public void deleteWaterReminder(String accountNumber);
}
