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

public class StringMeasurementValueValidator {

  /** default constructor */
  protected StringMeasurementValueValidator() {}

  /** factory method */
  public static StringMeasurementValueValidator getInstance() {
    return new StringMeasurementValueValidator();
  }

  /** handles creation validation for a StringMeasurementValue */
  public void validate(CreateStringMeasurementValueCommand stringMeasurementValue)
      throws Exception {
    Assert.notNull(
        stringMeasurementValue, "CreateStringMeasurementValueCommand should not be null");
    //		Assert.isNull( stringMeasurementValue.getStringMeasurementValueId(),
    // "CreateStringMeasurementValueCommand identifier should be null" );
  }

  /** handles update validation for a StringMeasurementValue */
  public void validate(UpdateStringMeasurementValueCommand stringMeasurementValue)
      throws Exception {
    Assert.notNull(
        stringMeasurementValue, "UpdateStringMeasurementValueCommand should not be null");
    Assert.notNull(
        stringMeasurementValue.getStringMeasurementValueId(),
        "UpdateStringMeasurementValueCommand identifier should not be null");
  }

  /** handles delete validation for a StringMeasurementValue */
  public void validate(DeleteStringMeasurementValueCommand stringMeasurementValue)
      throws Exception {
    Assert.notNull(stringMeasurementValue, "{commandAlias} should not be null");
    Assert.notNull(
        stringMeasurementValue.getStringMeasurementValueId(),
        "DeleteStringMeasurementValueCommand identifier should not be null");
  }

  /** handles fetchOne validation for a StringMeasurementValue */
  public void validate(StringMeasurementValueFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "StringMeasurementValueFetchOneSummary should not be null");
    Assert.notNull(
        summary.getStringMeasurementValueId(),
        "StringMeasurementValueFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Value validation for a StringMeasurementValue
   *
   * @param command AssignValueToStringMeasurementValueCommand
   */
  public void validate(AssignValueToStringMeasurementValueCommand command) throws Exception {
    Assert.notNull(command, "AssignValueToStringMeasurementValueCommand should not be null");
    Assert.notNull(
        command.getStringMeasurementValueId(),
        "AssignValueToStringMeasurementValueCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignValueToStringMeasurementValueCommand assignment should not be null");
  }

  /**
   * handles unassign Value validation for a StringMeasurementValue
   *
   * @param command UnAssignValueFromStringMeasurementValueCommand
   */
  public void validate(UnAssignValueFromStringMeasurementValueCommand command) throws Exception {
    Assert.notNull(command, "UnAssignValueFromStringMeasurementValueCommand should not be null");
    Assert.notNull(
        command.getStringMeasurementValueId(),
        "UnAssignValueFromStringMeasurementValueCommand identifier should not be null");
  }

  /**
   * handles add to StringMeasurementValues validation for a StringMeasurementValue
   *
   * @param command AssignStringMeasurementValuesToStringMeasurementValueCommand
   */
  public void validate(AssignStringMeasurementValuesToStringMeasurementValueCommand command)
      throws Exception {
    Assert.notNull(
        command, "AssignStringMeasurementValuesToStringMeasurementValueCommand should not be null");
    Assert.notNull(
        command.getStringMeasurementValueId(),
        "AssignStringMeasurementValuesToStringMeasurementValueCommand identifier should not be null");
    Assert.notNull(
        command.getAddTo(),
        "AssignStringMeasurementValuesToStringMeasurementValueCommand addTo attribute should not be null");
  }

  /**
   * handles remove from StringMeasurementValues validation for a StringMeasurementValue
   *
   * @param command RemoveStringMeasurementValuesFromStringMeasurementValueCommand
   */
  public void validate(RemoveStringMeasurementValuesFromStringMeasurementValueCommand command)
      throws Exception {
    Assert.notNull(
        command,
        "RemoveStringMeasurementValuesFromStringMeasurementValueCommand should not be null");
    Assert.notNull(
        command.getStringMeasurementValueId(),
        "RemoveStringMeasurementValuesFromStringMeasurementValueCommand identifier should not be null");
    Assert.notNull(
        command.getRemoveFrom(),
        "RemoveStringMeasurementValuesFromStringMeasurementValueCommand removeFrom attribute should not be null");
    Assert.notNull(
        command.getRemoveFrom().getStringMeasurementValueId(),
        "RemoveStringMeasurementValuesFromStringMeasurementValueCommand removeFrom attribubte identifier should not be null");
  }
}
