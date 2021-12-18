package app.medrem.api.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import app.medrem.api.constant.ReminderType;
import app.medrem.api.constant.WaterUnit;
import app.medrem.api.exception.ConflictException;
import app.medrem.api.exception.InvaliedRequestException;
import app.medrem.api.exception.RecordNotFound;
import app.medrem.api.model.Water;
import app.medrem.api.model.WaterDose;
import app.medrem.api.repository.WaterReminderRepository;
import app.medrem.api.service.WaterReminderService;

@SpringBootTest
@AutoConfigureMockMvc
public class WaterReminderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private WaterReminderService waterReminderService;

    @MockBean
    private WaterReminderRepository waterReminderRepository;

    @Test
    public void getWaterReminderTest() throws Exception {
	Water water = new Water("MR9454318045", 60, new WaterDose(100, WaterUnit.ML), 10, 10, 5, "8:30AM", "10:30PM");
	water.setId("6188d254ee97ed79200f1e37");
	water.setNotes("Abc notes");
	water.setReminderType(ReminderType.WATER);

	when(this.waterReminderService.getWaterReminder(Mockito.anyString())).thenReturn(water);
	this.mockMvc.perform(get("/api/v1/water/MR9454318049")).andExpect(status().isOk())
		.andExpect(jsonPath("$.accountNumber", is(new String("MR9454318045"))));
    }

    @Test
    public void getWaterReminder_ExceptionTest() throws Exception {
	when(this.waterReminderService.getWaterReminder(Mockito.anyString())).thenReturn(null);
	this.mockMvc.perform(get("/api/v1/water/MR9454318045").contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isNotFound()).andExpect(result -> assertThat(result instanceof RecordNotFound));
    }

    @Test
    public void createWaterReminderTest() throws Exception {
	Water water = new Water("MR9454318045", 60, new WaterDose(100, WaterUnit.ML), 10, 10, 5, "8:30AM", "10:30PM");
	water.setId("6188d254ee97ed79200f1e37");
	water.setNotes("Abc notes");
	water.setReminderType(ReminderType.WATER);

	String accountObject = new ObjectMapper().writeValueAsString(water);
	when(this.waterReminderService.createWaterReminder(Mockito.any())).thenReturn(water);
	this.mockMvc.perform(post("/api/v1/water").contentType(MediaType.APPLICATION_JSON).content(accountObject))
		.andExpect(status().isOk()).andExpect(jsonPath("$.accountNumber", is(new String("MR9454318045"))));
    }

    @Test
    public void createWaterReminder_ExceptionTest() throws Exception {
	Water water = new Water("MR9454318045", 60, new WaterDose(100, WaterUnit.ML), 10, 10, 5, "8:30AM", "10:30PM");
	water.setId("6188d254ee97ed79200f1e37");
	water.setNotes("Abc notes");
	water.setReminderType(ReminderType.WATER);
	String waterReminderObject = new ObjectMapper().writeValueAsString(water);

	when(this.waterReminderService.createWaterReminder(Mockito.any())).thenReturn(water);
	this.mockMvc.perform(post("/api/v1/water").contentType(MediaType.APPLICATION_JSON).content(waterReminderObject))
		.andExpect(status().isOk()).andExpect(result -> assertThat(result instanceof InvaliedRequestException));
    }

    @Test
    public void updateWaterReminderTest() throws Exception {
	Water water = new Water("MR9454318045", 60, new WaterDose(100, WaterUnit.ML), 10, 10, 5, "8:30AM", "10:30PM");
	water.setId("6188d254ee97ed79200f1e37");
	water.setNotes("Abc notes");
	water.setReminderType(ReminderType.WATER);
	String waterReminderObject = new ObjectMapper().writeValueAsString(water);

	when(this.waterReminderService.updateWaterReminder(water)).thenReturn(water);
	this.mockMvc
		.perform(put("/api/v1/water/MR9454318045").contentType(MediaType.APPLICATION_JSON)
			.content(waterReminderObject))
		.andExpect(status().isOk())
		.andExpect(result -> assertThat(result.toString().equals(waterReminderObject)));
    }

    @Test
    public void updateWaterReminder_Exception() throws Exception {
	Water water = new Water("MR9454318045", 60, new WaterDose(100, WaterUnit.ML), 10, 10, 5, "8:30AM", "10:30PM");
	water.setId("6188d254ee97ed79200f1e37");
	water.setNotes("Abc notes");
	water.setReminderType(ReminderType.WATER);
	String waterReminderObject = new ObjectMapper().writeValueAsString(water);

	when(this.waterReminderService.getWaterReminder(Mockito.anyString())).thenReturn(water);
	when(this.waterReminderService.updateWaterReminder(Mockito.any())).thenReturn(water);
	this.mockMvc
		.perform(put("/api/v1/water/MR9454318045").contentType(MediaType.APPLICATION_JSON)
			.content(waterReminderObject))
		.andExpect(status().isConflict()).andExpect(result -> assertThat(result instanceof ConflictException));
    }

    @Test
    public void deleteWaterReminderTest() throws Exception {
	Water water = new Water("MR9454318045", 60, new WaterDose(100, WaterUnit.ML), 10, 10, 5, "8:30AM", "10:30PM");
	water.setId("6188d254ee97ed79200f1e37");
	water.setNotes("Abc notes");
	water.setReminderType(ReminderType.WATER);

	when(this.waterReminderService.getWaterReminder(Mockito.anyString())).thenReturn(water);
	Mockito.doNothing().when(this.waterReminderService).deleteWaterReminder(Mockito.anyString());
	this.mockMvc.perform(delete("/api/v1/water/MR9454318045").contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk());
	verify(waterReminderService, Mockito.times(1)).deleteWaterReminder(new String("MR9454318045"));
    }

    @Test
    public void deleteWaterReminderTest_Exception() throws Exception {
	when(this.waterReminderService.getWaterReminder(Mockito.anyString())).thenReturn(null);
	this.mockMvc.perform(delete("/api/v1/water/MR9454318045").contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isNotFound()).andExpect(result -> assertThat(result instanceof RecordNotFound));
    }
}
