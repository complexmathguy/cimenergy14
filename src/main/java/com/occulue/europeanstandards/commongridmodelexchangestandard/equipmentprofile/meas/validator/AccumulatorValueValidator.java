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

public class AccumulatorValueValidator {

  /** default constructor */
  protected AccumulatorValueValidator() {}

  /** factory method */
  public static AccumulatorValueValidator getInstance() {
    return new AccumulatorValueValidator();
  }

  /** handles creation validation for a AccumulatorValue */
  public void validate(CreateAccumulatorValueCommand accumulatorValue) throws Exception {
    Assert.notNull(accumulatorValue, "CreateAccumulatorValueCommand should not be null");
    //		Assert.isNull( accumulatorValue.getAccumulatorValueId(), "CreateAccumulatorValueCommand
    // identifier should be null" );
  }

  /** handles update validation for a AccumulatorValue */
  public void validate(UpdateAccumulatorValueCommand accumulatorValue) throws Exception {
    Assert.notNull(accumulatorValue, "UpdateAccumulatorValueCommand should not be null");
    Assert.notNull(
        accumulatorValue.getAccumulatorValueId(),
        "UpdateAccumulatorValueCommand identifier should not be null");
  }

  /** handles delete validation for a AccumulatorValue */
  public void validate(DeleteAccumulatorValueCommand accumulatorValue) throws Exception {
    Assert.notNull(accumulatorValue, "{commandAlias} should not be null");
    Assert.notNull(
        accumulatorValue.getAccumulatorValueId(),
        "DeleteAccumulatorValueCommand identifier should not be null");
  }

  /** handles fetchOne validation for a AccumulatorValue */
  public void validate(AccumulatorValueFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "AccumulatorValueFetchOneSummary should not be null");
    Assert.notNull(
        summary.getAccumulatorValueId(),
        "AccumulatorValueFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Value validation for a AccumulatorValue
   *
   * @param command AssignValueToAccumulatorValueCommand
   */
  public void validate(AssignValueToAccumulatorValueCommand command) throws Exception {
    Assert.notNull(command, "AssignValueToAccumulatorValueCommand should not be null");
    Assert.notNull(
        command.getAccumulatorValueId(),
        "AssignValueToAccumulatorValueCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignValueToAccumulatorValueCommand assignment should not be null");
  }

  /**
   * handles unassign Value validation for a AccumulatorValue
   *
   * @param command UnAssignValueFromAccumulatorValueCommand
   */
  public void validate(UnAssignValueFromAccumulatorValueCommand command) throws Exception {
    Assert.notNull(command, "UnAssignValueFromAccumulatorValueCommand should not be null");
    Assert.notNull(
        command.getAccumulatorValueId(),
        "UnAssignValueFromAccumulatorValueCommand identifier should not be null");
  }

  /**
   * handles add to AccumulatorValues validation for a AccumulatorValue
   *
   * @param command AssignAccumulatorValuesToAccumulatorValueCommand
   */
  public void validate(AssignAccumulatorValuesToAccumulatorValueCommand command) throws Exception {
    Assert.notNull(command, "AssignAccumulatorValuesToAccumulatorValueCommand should not be null");
    Assert.notNull(
        command.getAccumulatorValueId(),
        "AssignAccumulatorValuesToAccumulatorValueCommand identifier should not be null");
    Assert.notNull(
        command.getAddTo(),
        "AssignAccumulatorValuesToAccumulatorValueCommand addTo attribute should not be null");
  }

  /**
   * handles remove from AccumulatorValues validation for a AccumulatorValue
   *
   * @param command RemoveAccumulatorValuesFromAccumulatorValueCommand
   */
  public void validate(RemoveAccumulatorValuesFromAccumulatorValueCommand command)
      throws Exception {
    Assert.notNull(
        command, "RemoveAccumulatorValuesFromAccumulatorValueCommand should not be null");
    Assert.notNull(
        command.getAccumulatorValueId(),
        "RemoveAccumulatorValuesFromAccumulatorValueCommand identifier should not be null");
    Assert.notNull(
        command.getRemoveFrom(),
        "RemoveAccumulatorValuesFromAccumulatorValueCommand removeFrom attribute should not be null");
    Assert.notNull(
        command.getRemoveFrom().getAccumulatorValueId(),
        "RemoveAccumulatorValuesFromAccumulatorValueCommand removeFrom attribubte identifier should not be null");
  }
}
