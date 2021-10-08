package app.medrem.api.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.medrem.api.constant.ErrorMessage;
import app.medrem.api.entity.MedicineReminder;
import app.medrem.api.exception.InvaliedRequestException;
import app.medrem.api.service.MedicineReminderService;

@RestController
@RequestMapping("/api/v1/medicineReminder")
public class MedicineReminderController {

    @Autowired
    private MedicineReminderService medicineReminderService;

    @PostMapping
    public ResponseEntity<MedicineReminder> createReminder(@RequestBody MedicineReminder medicineReminder) {
	return ResponseEntity.ok(Optional.of(this.medicineReminderService.createReminder(medicineReminder))
		.orElseThrow(() -> new InvaliedRequestException(ErrorMessage.INVALID_REQUEST.value())));
    }
}
