package app.medrem.api.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.medrem.api.constant.ErrorMessage;
import app.medrem.api.entity.WaterReminder;
import app.medrem.api.exception.InvaliedRequestException;
import app.medrem.api.service.WaterReminderService;

@RestController
@RequestMapping("/api/v1/reminder")
public class ReminderController {

    @Autowired
    private WaterReminderService waterReminderService;
    
    @PostMapping
    public ResponseEntity<WaterReminder> createReminder(@RequestBody WaterReminder waterReminder) {
	return ResponseEntity.ok(Optional.of(this.waterReminderService.createReminder(waterReminder))
		.orElseThrow(() -> new InvaliedRequestException(ErrorMessage.INVALID_REQUEST.value())));
    }
}
