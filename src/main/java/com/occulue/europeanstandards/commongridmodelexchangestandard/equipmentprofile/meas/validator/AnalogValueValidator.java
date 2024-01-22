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

public class AnalogValueValidator {

  /** default constructor */
  protected AnalogValueValidator() {}

  /** factory method */
  public static AnalogValueValidator getInstance() {
    return new AnalogValueValidator();
  }

  /** handles creation validation for a AnalogValue */
  public void validate(CreateAnalogValueCommand analogValue) throws Exception {
    Assert.notNull(analogValue, "CreateAnalogValueCommand should not be null");
    //		Assert.isNull( analogValue.getAnalogValueId(), "CreateAnalogValueCommand identifier should
    // be null" );
  }

  /** handles update validation for a AnalogValue */
  public void validate(UpdateAnalogValueCommand analogValue) throws Exception {
    Assert.notNull(analogValue, "UpdateAnalogValueCommand should not be null");
    Assert.notNull(
        analogValue.getAnalogValueId(), "UpdateAnalogValueCommand identifier should not be null");
  }

  /** handles delete validation for a AnalogValue */
  public void validate(DeleteAnalogValueCommand analogValue) throws Exception {
    Assert.notNull(analogValue, "{commandAlias} should not be null");
    Assert.notNull(
        analogValue.getAnalogValueId(), "DeleteAnalogValueCommand identifier should not be null");
  }

  /** handles fetchOne validation for a AnalogValue */
  public void validate(AnalogValueFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "AnalogValueFetchOneSummary should not be null");
    Assert.notNull(
        summary.getAnalogValueId(), "AnalogValueFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Value validation for a AnalogValue
   *
   * @param command AssignValueToAnalogValueCommand
   */
  public void validate(AssignValueToAnalogValueCommand command) throws Exception {
    Assert.notNull(command, "AssignValueToAnalogValueCommand should not be null");
    Assert.notNull(
        command.getAnalogValueId(),
        "AssignValueToAnalogValueCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignValueToAnalogValueCommand assignment should not be null");
  }

  /**
   * handles unassign Value validation for a AnalogValue
   *
   * @param command UnAssignValueFromAnalogValueCommand
   */
  public void validate(UnAssignValueFromAnalogValueCommand command) throws Exception {
    Assert.notNull(command, "UnAssignValueFromAnalogValueCommand should not be null");
    Assert.notNull(
        command.getAnalogValueId(),
        "UnAssignValueFromAnalogValueCommand identifier should not be null");
  }

  /**
   * handles add to AnalogValues validation for a AnalogValue
   *
   * @param command AssignAnalogValuesToAnalogValueCommand
   */
  public void validate(AssignAnalogValuesToAnalogValueCommand command) throws Exception {
    Assert.notNull(command, "AssignAnalogValuesToAnalogValueCommand should not be null");
    Assert.notNull(
        command.getAnalogValueId(),
        "AssignAnalogValuesToAnalogValueCommand identifier should not be null");
    Assert.notNull(
        command.getAddTo(),
        "AssignAnalogValuesToAnalogValueCommand addTo attribute should not be null");
  }

  /**
   * handles remove from AnalogValues validation for a AnalogValue
   *
   * @param command RemoveAnalogValuesFromAnalogValueCommand
   */
  public void validate(RemoveAnalogValuesFromAnalogValueCommand command) throws Exception {
    Assert.notNull(command, "RemoveAnalogValuesFromAnalogValueCommand should not be null");
    Assert.notNull(
        command.getAnalogValueId(),
        "RemoveAnalogValuesFromAnalogValueCommand identifier should not be null");
    Assert.notNull(
        command.getRemoveFrom(),
        "RemoveAnalogValuesFromAnalogValueCommand removeFrom attribute should not be null");
    Assert.notNull(
        command.getRemoveFrom().getAnalogValueId(),
        "RemoveAnalogValuesFromAnalogValueCommand removeFrom attribubte identifier should not be null");
  }
}
