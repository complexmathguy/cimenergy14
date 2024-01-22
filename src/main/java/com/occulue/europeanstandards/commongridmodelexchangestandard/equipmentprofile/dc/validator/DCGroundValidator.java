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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.dc.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class DCGroundValidator {

  /** default constructor */
  protected DCGroundValidator() {}

  /** factory method */
  public static DCGroundValidator getInstance() {
    return new DCGroundValidator();
  }

  /** handles creation validation for a DCGround */
  public void validate(CreateDCGroundCommand dCGround) throws Exception {
    Assert.notNull(dCGround, "CreateDCGroundCommand should not be null");
    //		Assert.isNull( dCGround.getDCGroundId(), "CreateDCGroundCommand identifier should be null"
    // );
  }

  /** handles update validation for a DCGround */
  public void validate(UpdateDCGroundCommand dCGround) throws Exception {
    Assert.notNull(dCGround, "UpdateDCGroundCommand should not be null");
    Assert.notNull(dCGround.getDCGroundId(), "UpdateDCGroundCommand identifier should not be null");
  }

  /** handles delete validation for a DCGround */
  public void validate(DeleteDCGroundCommand dCGround) throws Exception {
    Assert.notNull(dCGround, "{commandAlias} should not be null");
    Assert.notNull(dCGround.getDCGroundId(), "DeleteDCGroundCommand identifier should not be null");
  }

  /** handles fetchOne validation for a DCGround */
  public void validate(DCGroundFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "DCGroundFetchOneSummary should not be null");
    Assert.notNull(
        summary.getDCGroundId(), "DCGroundFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Inductance validation for a DCGround
   *
   * @param command AssignInductanceToDCGroundCommand
   */
  public void validate(AssignInductanceToDCGroundCommand command) throws Exception {
    Assert.notNull(command, "AssignInductanceToDCGroundCommand should not be null");
    Assert.notNull(
        command.getDCGroundId(), "AssignInductanceToDCGroundCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignInductanceToDCGroundCommand assignment should not be null");
  }

  /**
   * handles unassign Inductance validation for a DCGround
   *
   * @param command UnAssignInductanceFromDCGroundCommand
   */
  public void validate(UnAssignInductanceFromDCGroundCommand command) throws Exception {
    Assert.notNull(command, "UnAssignInductanceFromDCGroundCommand should not be null");
    Assert.notNull(
        command.getDCGroundId(),
        "UnAssignInductanceFromDCGroundCommand identifier should not be null");
  }
  /**
   * handles assign R validation for a DCGround
   *
   * @param command AssignRToDCGroundCommand
   */
  public void validate(AssignRToDCGroundCommand command) throws Exception {
    Assert.notNull(command, "AssignRToDCGroundCommand should not be null");
    Assert.notNull(
        command.getDCGroundId(), "AssignRToDCGroundCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignRToDCGroundCommand assignment should not be null");
  }

  /**
   * handles unassign R validation for a DCGround
   *
   * @param command UnAssignRFromDCGroundCommand
   */
  public void validate(UnAssignRFromDCGroundCommand command) throws Exception {
    Assert.notNull(command, "UnAssignRFromDCGroundCommand should not be null");
    Assert.notNull(
        command.getDCGroundId(), "UnAssignRFromDCGroundCommand identifier should not be null");
  }
}
