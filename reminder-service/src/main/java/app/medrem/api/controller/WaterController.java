package app.medrem.api.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.medrem.api.constant.ErrorMessage;
import app.medrem.api.entity.WaterReminder;
import app.medrem.api.exception.ConflictException;
import app.medrem.api.exception.InvaliedRequestException;
import app.medrem.api.exception.RecordNotFound;
import app.medrem.api.service.WaterService;
import app.medrem.api.util.ServiceMapUtil;

@RestController
@RequestMapping("/api/v1/water")
public class WaterController {

    @Autowired
    private WaterService waterService;

    @Autowired
    private ServiceMapUtil serviceMapUtil;

    @PostMapping
    public ResponseEntity<WaterReminder> createWaterReminder(@RequestBody WaterReminder water) {
	return ResponseEntity.ok(Optional.of(this.waterService.createWaterReminder(water))
		.orElseThrow(() -> new InvaliedRequestException(ErrorMessage.INVALID_REQUEST.value())));
    }

    @GetMapping("/{accountNumber}")
    public ResponseEntity<WaterReminder> getWaterReminder(@PathVariable("accountNumber") String accountNumber) {
	if (this.waterService.getWaterReminder(accountNumber) != null) {
	    return ResponseEntity.status(HttpStatus.OK)
		    .body(Optional.of(this.waterService.getWaterReminder(accountNumber)).orElseThrow());
	} else {
	    throw new RecordNotFound(ErrorMessage.ACCOUNT_NOT_FOUND.value());
	}
    }

    @PutMapping("/{accountNumber}")
    public ResponseEntity<WaterReminder> updateWaterReminser(@RequestBody WaterReminder waterReminder,
	    @PathVariable("accountNumber") String accountNumber) {

	WaterReminder waterReminderDb = this.waterService.getWaterReminder(accountNumber);
	if (waterReminderDb != null) {
	    waterReminder.setId(waterReminderDb.getId());
	    waterReminder.setAccountNumber(accountNumber);

	    if (waterReminderDb.equals(waterReminder)) {
		throw new ConflictException(ErrorMessage.ACCOUNT_EXISTS.value());
	    } else {
		return ResponseEntity.status(HttpStatus.OK).body(Optional.ofNullable(waterReminderDb).map(reminder -> {
		    return this.waterService
			    .updateWaterReminder(this.serviceMapUtil.updateWaterReminderMap(waterReminder, reminder));
		}).orElseThrow());
	    }
	} else {
	    waterReminder.setAccountNumber(accountNumber);
	    return ResponseEntity.status(HttpStatus.OK).body(this.waterService.createWaterReminder(waterReminder));
	}
    }

    @DeleteMapping("/{accountNumber}")
    public ResponseEntity<WaterReminder> deleteWaterReminder(@PathVariable("accountNumber") String accountNumber) {
	WaterReminder waterReminder = this.waterService.getWaterReminder(accountNumber);
	if (waterReminder == null) {
	    throw new RecordNotFound(ErrorMessage.ACCOUNT_NOT_FOUND.value());
	}
	this.waterService.deleteWaterReminder(accountNumber);
	return ResponseEntity.status(HttpStatus.OK).body(waterReminder);
    }
}
