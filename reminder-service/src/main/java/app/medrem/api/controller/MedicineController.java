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
import app.medrem.api.exception.ConflictException;
import app.medrem.api.exception.InvaliedRequestException;
import app.medrem.api.exception.RecordNotFound;
import app.medrem.api.mapper.ServiceMapUtil;
import app.medrem.api.model.Medicine;
import app.medrem.api.service.MedicineReminderService;

@RestController
@RequestMapping("/api/v1/medicine")
public class MedicineController {

    @Autowired
    private MedicineReminderService medicineReminderService;

    @Autowired
    private ServiceMapUtil serviceMapUtil;

    @PostMapping
    public ResponseEntity<Medicine> createWaterReminder(@RequestBody Medicine medicine) {
	return ResponseEntity.ok(Optional.of(this.medicineReminderService.createMedicineReminder(medicine))
		.orElseThrow(() -> new InvaliedRequestException(ErrorMessage.INVALID_REQUEST.value())));
    }

    @GetMapping("/{accountNumber}")
    public ResponseEntity<Medicine> getWaterReminder(@PathVariable("accountNumber") String accountNumber) {
	if (this.medicineReminderService.getMedicineReminder(accountNumber) == null) {
	    throw new RecordNotFound(ErrorMessage.ACCOUNT_NOT_FOUND.value());
	} else {
	    return ResponseEntity.status(HttpStatus.OK)
		    .body(Optional.of(this.medicineReminderService.getMedicineReminder(accountNumber)).orElseThrow());
	}
    }

    @PutMapping("/{accountNumber}")
    public ResponseEntity<Medicine> updateWaterReminser(@RequestBody Medicine medicine,
	    @PathVariable("accountNumber") String accountNumber) {

	Medicine medicineReminderDb = this.medicineReminderService.getMedicineReminder(accountNumber);
	if (medicineReminderDb != null) {
	    medicine.setId(medicineReminderDb.getId());
	    medicine.setAccountNumber(accountNumber);

	    if (medicineReminderDb.equals(medicine)) {
		throw new ConflictException(ErrorMessage.ACCOUNT_EXISTS.value());
	    } else {
		return ResponseEntity.status(HttpStatus.OK)
			.body(Optional.ofNullable(medicineReminderDb).map(reminder -> {
			    return this.medicineReminderService
				    .updateMedicineReminder(this.serviceMapUtil.updateMedicineReminderMap(medicine));
			}).orElseThrow());
	    }
	} else {
	    medicine.setAccountNumber(accountNumber);
	    return ResponseEntity.status(HttpStatus.OK)
		    .body(this.medicineReminderService.createMedicineReminder(medicine));
	}
    }

    @DeleteMapping("/{accountNumber}")
    public ResponseEntity<Medicine> deleteWaterReminder(@PathVariable("accountNumber") String accountNumber) {
	Medicine medicineReminder = this.medicineReminderService.getMedicineReminder(accountNumber);
	if (medicineReminder == null) {
	    throw new RecordNotFound(ErrorMessage.ACCOUNT_NOT_FOUND.value());
	}
	this.medicineReminderService.deleteMedicineReminder(accountNumber);
	return ResponseEntity.status(HttpStatus.OK).body(medicineReminder);
    }
}
