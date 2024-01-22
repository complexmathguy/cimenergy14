/**
 * ***************************************************************************** Turnstone Biologics
 * Confidential
 *
 * <p>2018 Turnstone Biologics All Rights Reserved.
 *
 * <p>This file is subject to the terms and conditions defined in file 'license.txt', which is part
 * of this source code package.
 *
 * <p>Contributors : Turnstone Biologics - General Release
 * ****************************************************************************
 */
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.meas.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class MeasurementValueValidator {

  /** default constructor */
  protected MeasurementValueValidator() {}

  /** factory method */
  public static MeasurementValueValidator getInstance() {
    return new MeasurementValueValidator();
  }

  /** handles creation validation for a MeasurementValue */
  public void validate(CreateMeasurementValueCommand measurementValue) throws Exception {
    Assert.notNull(measurementValue, "CreateMeasurementValueCommand should not be null");
    //		Assert.isNull( measurementValue.getMeasurementValueId(), "CreateMeasurementValueCommand
    // identifier should be null" );
  }

  /** handles update validation for a MeasurementValue */
  public void validate(UpdateMeasurementValueCommand measurementValue) throws Exception {
    Assert.notNull(measurementValue, "UpdateMeasurementValueCommand should not be null");
    Assert.notNull(
        measurementValue.getMeasurementValueId(),
        "UpdateMeasurementValueCommand identifier should not be null");
  }

  /** handles delete validation for a MeasurementValue */
  public void validate(DeleteMeasurementValueCommand measurementValue) throws Exception {
    Assert.notNull(measurementValue, "{commandAlias} should not be null");
    Assert.notNull(
        measurementValue.getMeasurementValueId(),
        "DeleteMeasurementValueCommand identifier should not be null");
  }

  /** handles fetchOne validation for a MeasurementValue */
  public void validate(MeasurementValueFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "MeasurementValueFetchOneSummary should not be null");
    Assert.notNull(
        summary.getMeasurementValueId(),
        "MeasurementValueFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign SensorAccuracy validation for a MeasurementValue
   *
   * @param command AssignSensorAccuracyToMeasurementValueCommand
   */
  public void validate(AssignSensorAccuracyToMeasurementValueCommand command) throws Exception {
    Assert.notNull(command, "AssignSensorAccuracyToMeasurementValueCommand should not be null");
    Assert.notNull(
        command.getMeasurementValueId(),
        "AssignSensorAccuracyToMeasurementValueCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignSensorAccuracyToMeasurementValueCommand assignment should not be null");
  }

  /**
   * handles unassign SensorAccuracy validation for a MeasurementValue
   *
   * @param command UnAssignSensorAccuracyFromMeasurementValueCommand
   */
  public void validate(UnAssignSensorAccuracyFromMeasurementValueCommand command) throws Exception {
    Assert.notNull(command, "UnAssignSensorAccuracyFromMeasurementValueCommand should not be null");
    Assert.notNull(
        command.getMeasurementValueId(),
        "UnAssignSensorAccuracyFromMeasurementValueCommand identifier should not be null");
  }
  /**
   * handles assign TimeStamp validation for a MeasurementValue
   *
   * @param command AssignTimeStampToMeasurementValueCommand
   */
  public void validate(AssignTimeStampToMeasurementValueCommand command) throws Exception {
    Assert.notNull(command, "AssignTimeStampToMeasurementValueCommand should not be null");
    Assert.notNull(
        command.getMeasurementValueId(),
        "AssignTimeStampToMeasurementValueCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignTimeStampToMeasurementValueCommand assignment should not be null");
  }

  /**
   * handles unassign TimeStamp validation for a MeasurementValue
   *
   * @param command UnAssignTimeStampFromMeasurementValueCommand
   */
  public void validate(UnAssignTimeStampFromMeasurementValueCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTimeStampFromMeasurementValueCommand should not be null");
    Assert.notNull(
        command.getMeasurementValueId(),
        "UnAssignTimeStampFromMeasurementValueCommand identifier should not be null");
  }

  /**
   * handles add to MeasurementValues validation for a MeasurementValue
   *
   * @param command AssignMeasurementValuesToMeasurementValueCommand
   */
  public void validate(AssignMeasurementValuesToMeasurementValueCommand command) throws Exception {
    Assert.notNull(command, "AssignMeasurementValuesToMeasurementValueCommand should not be null");
    Assert.notNull(
        command.getMeasurementValueId(),
        "AssignMeasurementValuesToMeasurementValueCommand identifier should not be null");
    Assert.notNull(
        command.getAddTo(),
        "AssignMeasurementValuesToMeasurementValueCommand addTo attribute should not be null");
  }

  /**
   * handles remove from MeasurementValues validation for a MeasurementValue
   *
   * @param command RemoveMeasurementValuesFromMeasurementValueCommand
   */
  public void validate(RemoveMeasurementValuesFromMeasurementValueCommand command)
      throws Exception {
    Assert.notNull(
        command, "RemoveMeasurementValuesFromMeasurementValueCommand should not be null");
    Assert.notNull(
        command.getMeasurementValueId(),
        "RemoveMeasurementValuesFromMeasurementValueCommand identifier should not be null");
    Assert.notNull(
        command.getRemoveFrom(),
        "RemoveMeasurementValuesFromMeasurementValueCommand removeFrom attribute should not be null");
    Assert.notNull(
        command.getRemoveFrom().getMeasurementValueId(),
        "RemoveMeasurementValuesFromMeasurementValueCommand removeFrom attribubte identifier should not be null");
  }
}
