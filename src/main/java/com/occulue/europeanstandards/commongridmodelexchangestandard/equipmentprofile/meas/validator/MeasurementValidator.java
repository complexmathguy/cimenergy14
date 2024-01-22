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

public class MeasurementValidator {

  /** default constructor */
  protected MeasurementValidator() {}

  /** factory method */
  public static MeasurementValidator getInstance() {
    return new MeasurementValidator();
  }

  /** handles creation validation for a Measurement */
  public void validate(CreateMeasurementCommand measurement) throws Exception {
    Assert.notNull(measurement, "CreateMeasurementCommand should not be null");
    //		Assert.isNull( measurement.getMeasurementId(), "CreateMeasurementCommand identifier should
    // be null" );
  }

  /** handles update validation for a Measurement */
  public void validate(UpdateMeasurementCommand measurement) throws Exception {
    Assert.notNull(measurement, "UpdateMeasurementCommand should not be null");
    Assert.notNull(
        measurement.getMeasurementId(), "UpdateMeasurementCommand identifier should not be null");
  }

  /** handles delete validation for a Measurement */
  public void validate(DeleteMeasurementCommand measurement) throws Exception {
    Assert.notNull(measurement, "{commandAlias} should not be null");
    Assert.notNull(
        measurement.getMeasurementId(), "DeleteMeasurementCommand identifier should not be null");
  }

  /** handles fetchOne validation for a Measurement */
  public void validate(MeasurementFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "MeasurementFetchOneSummary should not be null");
    Assert.notNull(
        summary.getMeasurementId(), "MeasurementFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign MeasurementType validation for a Measurement
   *
   * @param command AssignMeasurementTypeToMeasurementCommand
   */
  public void validate(AssignMeasurementTypeToMeasurementCommand command) throws Exception {
    Assert.notNull(command, "AssignMeasurementTypeToMeasurementCommand should not be null");
    Assert.notNull(
        command.getMeasurementId(),
        "AssignMeasurementTypeToMeasurementCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignMeasurementTypeToMeasurementCommand assignment should not be null");
  }

  /**
   * handles unassign MeasurementType validation for a Measurement
   *
   * @param command UnAssignMeasurementTypeFromMeasurementCommand
   */
  public void validate(UnAssignMeasurementTypeFromMeasurementCommand command) throws Exception {
    Assert.notNull(command, "UnAssignMeasurementTypeFromMeasurementCommand should not be null");
    Assert.notNull(
        command.getMeasurementId(),
        "UnAssignMeasurementTypeFromMeasurementCommand identifier should not be null");
  }

  /**
   * handles add to Measurements validation for a Measurement
   *
   * @param command AssignMeasurementsToMeasurementCommand
   */
  public void validate(AssignMeasurementsToMeasurementCommand command) throws Exception {
    Assert.notNull(command, "AssignMeasurementsToMeasurementCommand should not be null");
    Assert.notNull(
        command.getMeasurementId(),
        "AssignMeasurementsToMeasurementCommand identifier should not be null");
    Assert.notNull(
        command.getAddTo(),
        "AssignMeasurementsToMeasurementCommand addTo attribute should not be null");
  }

  /**
   * handles remove from Measurements validation for a Measurement
   *
   * @param command RemoveMeasurementsFromMeasurementCommand
   */
  public void validate(RemoveMeasurementsFromMeasurementCommand command) throws Exception {
    Assert.notNull(command, "RemoveMeasurementsFromMeasurementCommand should not be null");
    Assert.notNull(
        command.getMeasurementId(),
        "RemoveMeasurementsFromMeasurementCommand identifier should not be null");
    Assert.notNull(
        command.getRemoveFrom(),
        "RemoveMeasurementsFromMeasurementCommand removeFrom attribute should not be null");
    Assert.notNull(
        command.getRemoveFrom().getMeasurementId(),
        "RemoveMeasurementsFromMeasurementCommand removeFrom attribubte identifier should not be null");
  }
}
