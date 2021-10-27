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
import app.medrem.api.entity.Water;
import app.medrem.api.exception.ConflictException;
import app.medrem.api.exception.InvaliedRequestException;
import app.medrem.api.exception.RecordNotFound;
import app.medrem.api.service.WaterReminderService;
import app.medrem.api.util.ServiceMapUtil;

@RestController
@RequestMapping("/api/v1/water")
public class WaterController {

    @Autowired
    private WaterReminderService waterReminderService;

    @Autowired
    private ServiceMapUtil serviceMapUtil;

    @PostMapping
    public ResponseEntity<Water> createWaterReminder(@RequestBody Water waterReminder) {
	return ResponseEntity.ok(Optional.of(this.waterReminderService.createWaterReminder(waterReminder))
		.orElseThrow(() -> new InvaliedRequestException(ErrorMessage.INVALID_REQUEST.value())));
    }

    @GetMapping("/{accountNumber}")
    public ResponseEntity<Water> getWaterReminder(@PathVariable("accountNumber") String accountNumber) {
	if (this.waterReminderService.getWaterReminder(accountNumber) == null) {
	    throw new RecordNotFound(ErrorMessage.ACCOUNT_NOT_FOUND.value());
	} else {
	    return ResponseEntity.status(HttpStatus.OK)
		    .body(Optional.of(this.waterReminderService.getWaterReminder(accountNumber)).orElseThrow());
	}
    }

    @PutMapping("/{accountNumber}")
    public ResponseEntity<Water> updateWaterReminser(@RequestBody Water waterReminder,
	    @PathVariable("accountNumber") String accountNumber) {

	Water waterReminderDb = this.waterReminderService.getWaterReminder(accountNumber);
	if (waterReminderDb != null) {
	    waterReminder.setId(waterReminderDb.getId());
	    waterReminder.setAccountNumber(accountNumber);

	    if (waterReminderDb.equals(waterReminder)) {
		throw new ConflictException(ErrorMessage.ACCOUNT_EXISTS.value());
	    } else {
		return ResponseEntity.status(HttpStatus.OK).body(Optional.ofNullable(waterReminderDb).map(reminder -> {
		    return this.waterReminderService
			    .updateWaterReminder(this.serviceMapUtil.updateWaterReminderMap(waterReminder, reminder));
		}).orElseThrow());
	    }
	} else {
	    waterReminder.setAccountNumber(accountNumber);
	    return ResponseEntity.status(HttpStatus.OK)
		    .body(this.waterReminderService.createWaterReminder(waterReminder));
	}
    }

    @DeleteMapping("/{accountNumber}")
    public ResponseEntity<Water> deleteWaterReminder(@PathVariable("accountNumber") String accountNumber) {
	Water waterReminder = this.waterReminderService.getWaterReminder(accountNumber);
	if (waterReminder == null) {
	    throw new RecordNotFound(ErrorMessage.ACCOUNT_NOT_FOUND.value());
	}
	this.waterReminderService.deleteWaterReminder(accountNumber);
	return ResponseEntity.status(HttpStatus.OK).body(waterReminder);
    }
}
