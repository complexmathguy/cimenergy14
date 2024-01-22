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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class ConductorValidator {

  /** default constructor */
  protected ConductorValidator() {}

  /** factory method */
  public static ConductorValidator getInstance() {
    return new ConductorValidator();
  }

  /** handles creation validation for a Conductor */
  public void validate(CreateConductorCommand conductor) throws Exception {
    Assert.notNull(conductor, "CreateConductorCommand should not be null");
    //		Assert.isNull( conductor.getConductorId(), "CreateConductorCommand identifier should be
    // null" );
  }

  /** handles update validation for a Conductor */
  public void validate(UpdateConductorCommand conductor) throws Exception {
    Assert.notNull(conductor, "UpdateConductorCommand should not be null");
    Assert.notNull(
        conductor.getConductorId(), "UpdateConductorCommand identifier should not be null");
  }

  /** handles delete validation for a Conductor */
  public void validate(DeleteConductorCommand conductor) throws Exception {
    Assert.notNull(conductor, "{commandAlias} should not be null");
    Assert.notNull(
        conductor.getConductorId(), "DeleteConductorCommand identifier should not be null");
  }

  /** handles fetchOne validation for a Conductor */
  public void validate(ConductorFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "ConductorFetchOneSummary should not be null");
    Assert.notNull(
        summary.getConductorId(), "ConductorFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Length validation for a Conductor
   *
   * @param command AssignLengthToConductorCommand
   */
  public void validate(AssignLengthToConductorCommand command) throws Exception {
    Assert.notNull(command, "AssignLengthToConductorCommand should not be null");
    Assert.notNull(
        command.getConductorId(), "AssignLengthToConductorCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignLengthToConductorCommand assignment should not be null");
  }

  /**
   * handles unassign Length validation for a Conductor
   *
   * @param command UnAssignLengthFromConductorCommand
   */
  public void validate(UnAssignLengthFromConductorCommand command) throws Exception {
    Assert.notNull(command, "UnAssignLengthFromConductorCommand should not be null");
    Assert.notNull(
        command.getConductorId(),
        "UnAssignLengthFromConductorCommand identifier should not be null");
  }
}
