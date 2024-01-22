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
package com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class TemperatureValidator {

  /** default constructor */
  protected TemperatureValidator() {}

  /** factory method */
  public static TemperatureValidator getInstance() {
    return new TemperatureValidator();
  }

  /** handles creation validation for a Temperature */
  public void validate(CreateTemperatureCommand temperature) throws Exception {
    Assert.notNull(temperature, "CreateTemperatureCommand should not be null");
    //		Assert.isNull( temperature.getTemperatureId(), "CreateTemperatureCommand identifier should
    // be null" );
  }

  /** handles update validation for a Temperature */
  public void validate(UpdateTemperatureCommand temperature) throws Exception {
    Assert.notNull(temperature, "UpdateTemperatureCommand should not be null");
    Assert.notNull(
        temperature.getTemperatureId(), "UpdateTemperatureCommand identifier should not be null");
  }

  /** handles delete validation for a Temperature */
  public void validate(DeleteTemperatureCommand temperature) throws Exception {
    Assert.notNull(temperature, "{commandAlias} should not be null");
    Assert.notNull(
        temperature.getTemperatureId(), "DeleteTemperatureCommand identifier should not be null");
  }

  /** handles fetchOne validation for a Temperature */
  public void validate(TemperatureFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "TemperatureFetchOneSummary should not be null");
    Assert.notNull(
        summary.getTemperatureId(), "TemperatureFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Value validation for a Temperature
   *
   * @param command AssignValueToTemperatureCommand
   */
  public void validate(AssignValueToTemperatureCommand command) throws Exception {
    Assert.notNull(command, "AssignValueToTemperatureCommand should not be null");
    Assert.notNull(
        command.getTemperatureId(),
        "AssignValueToTemperatureCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignValueToTemperatureCommand assignment should not be null");
  }

  /**
   * handles unassign Value validation for a Temperature
   *
   * @param command UnAssignValueFromTemperatureCommand
   */
  public void validate(UnAssignValueFromTemperatureCommand command) throws Exception {
    Assert.notNull(command, "UnAssignValueFromTemperatureCommand should not be null");
    Assert.notNull(
        command.getTemperatureId(),
        "UnAssignValueFromTemperatureCommand identifier should not be null");
  }
}
