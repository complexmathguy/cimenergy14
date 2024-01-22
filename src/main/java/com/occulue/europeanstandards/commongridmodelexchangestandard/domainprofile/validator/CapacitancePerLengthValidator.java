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

public class CapacitancePerLengthValidator {

  /** default constructor */
  protected CapacitancePerLengthValidator() {}

  /** factory method */
  public static CapacitancePerLengthValidator getInstance() {
    return new CapacitancePerLengthValidator();
  }

  /** handles creation validation for a CapacitancePerLength */
  public void validate(CreateCapacitancePerLengthCommand capacitancePerLength) throws Exception {
    Assert.notNull(capacitancePerLength, "CreateCapacitancePerLengthCommand should not be null");
    //		Assert.isNull( capacitancePerLength.getCapacitancePerLengthId(),
    // "CreateCapacitancePerLengthCommand identifier should be null" );
  }

  /** handles update validation for a CapacitancePerLength */
  public void validate(UpdateCapacitancePerLengthCommand capacitancePerLength) throws Exception {
    Assert.notNull(capacitancePerLength, "UpdateCapacitancePerLengthCommand should not be null");
    Assert.notNull(
        capacitancePerLength.getCapacitancePerLengthId(),
        "UpdateCapacitancePerLengthCommand identifier should not be null");
  }

  /** handles delete validation for a CapacitancePerLength */
  public void validate(DeleteCapacitancePerLengthCommand capacitancePerLength) throws Exception {
    Assert.notNull(capacitancePerLength, "{commandAlias} should not be null");
    Assert.notNull(
        capacitancePerLength.getCapacitancePerLengthId(),
        "DeleteCapacitancePerLengthCommand identifier should not be null");
  }

  /** handles fetchOne validation for a CapacitancePerLength */
  public void validate(CapacitancePerLengthFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "CapacitancePerLengthFetchOneSummary should not be null");
    Assert.notNull(
        summary.getCapacitancePerLengthId(),
        "CapacitancePerLengthFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Value validation for a CapacitancePerLength
   *
   * @param command AssignValueToCapacitancePerLengthCommand
   */
  public void validate(AssignValueToCapacitancePerLengthCommand command) throws Exception {
    Assert.notNull(command, "AssignValueToCapacitancePerLengthCommand should not be null");
    Assert.notNull(
        command.getCapacitancePerLengthId(),
        "AssignValueToCapacitancePerLengthCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignValueToCapacitancePerLengthCommand assignment should not be null");
  }

  /**
   * handles unassign Value validation for a CapacitancePerLength
   *
   * @param command UnAssignValueFromCapacitancePerLengthCommand
   */
  public void validate(UnAssignValueFromCapacitancePerLengthCommand command) throws Exception {
    Assert.notNull(command, "UnAssignValueFromCapacitancePerLengthCommand should not be null");
    Assert.notNull(
        command.getCapacitancePerLengthId(),
        "UnAssignValueFromCapacitancePerLengthCommand identifier should not be null");
  }
}
