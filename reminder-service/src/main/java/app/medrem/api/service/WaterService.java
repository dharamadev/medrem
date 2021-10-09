package app.medrem.api.service;

import app.medrem.api.entity.WaterReminder;

public interface WaterService {

    public WaterReminder createWaterReminder(WaterReminder water);

    public WaterReminder getWaterReminder(String accountNumber);

    public WaterReminder updateWaterReminder(WaterReminder water);

    public void deleteWaterReminder(String accountNumber);
}
