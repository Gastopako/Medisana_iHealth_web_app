package com.medisanaspace.model.fixture;

import com.medisanaspace.model.Thermodock;
import com.medisanaspace.model.base.BaseModelWithoutMeal;
import com.medisanaspace.library.RandomHelper;

import java.util.Date;

/**
 * Generator for random Thermodock entries.
 * 
 * @author Clemens Lode, <clemens.lode@medisanaspace.com>
 */
public class ThermodockFixture {

	private final Thermodock thermodock;
	private final Date expectedMeasurementDate;
	private final Integer expectedActivityStatus;
	private final Integer expectedMood;
	private final String expectedNote;
	private final String expectedModuleSerialId;
	private final Float expectedBodyTemperature;
	private final Float expectedBodyTemperatureTargetMin;
	private final Float expectedBodyTemperatureTargetMax;

	public ThermodockFixture(final int index, final Thermodock lastThermodock) {
		this.thermodock = new Thermodock();
		this.expectedMeasurementDate = new Date(new Date().getTime()
				- (long) index * 3600L * 24L * 1000L);
		this.expectedActivityStatus = RandomHelper.generateInt(
				BaseModelWithoutMeal.MIN_ACTIVITY_STATUS,
				BaseModelWithoutMeal.MAX_ACTIVITY_STATUS);
		this.expectedMood = RandomHelper.generateInt(
				BaseModelWithoutMeal.MIN_MOOD, BaseModelWithoutMeal.MAX_MOOD);
		this.expectedNote = "";
		this.expectedModuleSerialId = "[Autogenerated Item]";

		if (lastThermodock == null) {
			this.expectedBodyTemperature = 36.8f;
		} else {
			Float generatedValue = lastThermodock.getBodyTemperature()
					+ RandomHelper.generateFloat(0, 2) - 1.0f;
			// normalize
			if (generatedValue < 36.8f) {
				generatedValue += 0.1f;
			} else if (generatedValue > 36.8f) {
				generatedValue -= 0.1f;
			}

			if (generatedValue < 35.0f) {
				this.expectedBodyTemperature = 35.5f - RandomHelper
						.generateFloat(0, 1);
			} else if (generatedValue > 41.5f) {
				this.expectedBodyTemperature = 41f + RandomHelper
						.generateFloat(0, 1);
			} else {
				this.expectedBodyTemperature = generatedValue;
			}
		}

		this.expectedBodyTemperatureTargetMin = 35.9f;
		this.expectedBodyTemperatureTargetMax = 37.8f;

		this.thermodock.setActivityStatus(this.expectedActivityStatus);
		this.thermodock.setBodyTemperature(this.expectedBodyTemperature);
		this.thermodock
				.setBodyTemperatureTargetMax(this.expectedBodyTemperatureTargetMax);
		this.thermodock
				.setBodyTemperatureTargetMin(this.expectedBodyTemperatureTargetMin);
		this.thermodock.setMeasurementDate(this.expectedMeasurementDate);
		this.thermodock.setMood(this.expectedMood);
		this.thermodock.setNote(this.expectedNote);
		this.thermodock.setModuleSerialId(this.expectedModuleSerialId);
	}

	public final Thermodock getThermodock() {
		return this.thermodock;
	}

	public final Date getExpectedMeasurementDate() {
		return new Date(this.expectedMeasurementDate.getTime());
	}

	public final Integer getExpectedActivityStatus() {
		return this.expectedActivityStatus;
	}

	public final Integer getExpectedMood() {
		return this.expectedMood;
	}

	public final String getExpectedNote() {
		return this.expectedNote;
	}

	public final String getExpectedModuleSerialId() {
		return this.expectedModuleSerialId;
	}

	public final Float getExpectedBodyTemperature() {
		return this.expectedBodyTemperature;
	}

	public final Float getExpectedBodyTemperatureTargetMin() {
		return this.expectedBodyTemperatureTargetMin;
	}

	public final Float getExpectedBodyTemperatureTargetMax() {
		return this.expectedBodyTemperatureTargetMax;
	}
}
