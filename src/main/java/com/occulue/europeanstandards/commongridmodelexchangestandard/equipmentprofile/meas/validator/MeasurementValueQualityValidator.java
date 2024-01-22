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

public class MeasurementValueQualityValidator {

  /** default constructor */
  protected MeasurementValueQualityValidator() {}

  /** factory method */
  public static MeasurementValueQualityValidator getInstance() {
    return new MeasurementValueQualityValidator();
  }

  /** handles creation validation for a MeasurementValueQuality */
  public void validate(CreateMeasurementValueQualityCommand measurementValueQuality)
      throws Exception {
    Assert.notNull(
        measurementValueQuality, "CreateMeasurementValueQualityCommand should not be null");
    //		Assert.isNull( measurementValueQuality.getMeasurementValueQualityId(),
    // "CreateMeasurementValueQualityCommand identifier should be null" );
  }

  /** handles update validation for a MeasurementValueQuality */
  public void validate(UpdateMeasurementValueQualityCommand measurementValueQuality)
      throws Exception {
    Assert.notNull(
        measurementValueQuality, "UpdateMeasurementValueQualityCommand should not be null");
    Assert.notNull(
        measurementValueQuality.getMeasurementValueQualityId(),
        "UpdateMeasurementValueQualityCommand identifier should not be null");
  }

  /** handles delete validation for a MeasurementValueQuality */
  public void validate(DeleteMeasurementValueQualityCommand measurementValueQuality)
      throws Exception {
    Assert.notNull(measurementValueQuality, "{commandAlias} should not be null");
    Assert.notNull(
        measurementValueQuality.getMeasurementValueQualityId(),
        "DeleteMeasurementValueQualityCommand identifier should not be null");
  }

  /** handles fetchOne validation for a MeasurementValueQuality */
  public void validate(MeasurementValueQualityFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "MeasurementValueQualityFetchOneSummary should not be null");
    Assert.notNull(
        summary.getMeasurementValueQualityId(),
        "MeasurementValueQualityFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign MeasurementValueQuality validation for a MeasurementValueQuality
   *
   * @param command AssignMeasurementValueQualityToMeasurementValueQualityCommand
   */
  public void validate(AssignMeasurementValueQualityToMeasurementValueQualityCommand command)
      throws Exception {
    Assert.notNull(
        command,
        "AssignMeasurementValueQualityToMeasurementValueQualityCommand should not be null");
    Assert.notNull(
        command.getMeasurementValueQualityId(),
        "AssignMeasurementValueQualityToMeasurementValueQualityCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignMeasurementValueQualityToMeasurementValueQualityCommand assignment should not be null");
  }

  /**
   * handles unassign MeasurementValueQuality validation for a MeasurementValueQuality
   *
   * @param command UnAssignMeasurementValueQualityFromMeasurementValueQualityCommand
   */
  public void validate(UnAssignMeasurementValueQualityFromMeasurementValueQualityCommand command)
      throws Exception {
    Assert.notNull(
        command,
        "UnAssignMeasurementValueQualityFromMeasurementValueQualityCommand should not be null");
    Assert.notNull(
        command.getMeasurementValueQualityId(),
        "UnAssignMeasurementValueQualityFromMeasurementValueQualityCommand identifier should not be null");
  }
}
