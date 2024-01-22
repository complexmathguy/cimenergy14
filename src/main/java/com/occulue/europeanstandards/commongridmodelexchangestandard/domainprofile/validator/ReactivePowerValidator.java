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

public class ReactivePowerValidator {

  /** default constructor */
  protected ReactivePowerValidator() {}

  /** factory method */
  public static ReactivePowerValidator getInstance() {
    return new ReactivePowerValidator();
  }

  /** handles creation validation for a ReactivePower */
  public void validate(CreateReactivePowerCommand reactivePower) throws Exception {
    Assert.notNull(reactivePower, "CreateReactivePowerCommand should not be null");
    //		Assert.isNull( reactivePower.getReactivePowerId(), "CreateReactivePowerCommand identifier
    // should be null" );
  }

  /** handles update validation for a ReactivePower */
  public void validate(UpdateReactivePowerCommand reactivePower) throws Exception {
    Assert.notNull(reactivePower, "UpdateReactivePowerCommand should not be null");
    Assert.notNull(
        reactivePower.getReactivePowerId(),
        "UpdateReactivePowerCommand identifier should not be null");
  }

  /** handles delete validation for a ReactivePower */
  public void validate(DeleteReactivePowerCommand reactivePower) throws Exception {
    Assert.notNull(reactivePower, "{commandAlias} should not be null");
    Assert.notNull(
        reactivePower.getReactivePowerId(),
        "DeleteReactivePowerCommand identifier should not be null");
  }

  /** handles fetchOne validation for a ReactivePower */
  public void validate(ReactivePowerFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "ReactivePowerFetchOneSummary should not be null");
    Assert.notNull(
        summary.getReactivePowerId(), "ReactivePowerFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Value validation for a ReactivePower
   *
   * @param command AssignValueToReactivePowerCommand
   */
  public void validate(AssignValueToReactivePowerCommand command) throws Exception {
    Assert.notNull(command, "AssignValueToReactivePowerCommand should not be null");
    Assert.notNull(
        command.getReactivePowerId(),
        "AssignValueToReactivePowerCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignValueToReactivePowerCommand assignment should not be null");
  }

  /**
   * handles unassign Value validation for a ReactivePower
   *
   * @param command UnAssignValueFromReactivePowerCommand
   */
  public void validate(UnAssignValueFromReactivePowerCommand command) throws Exception {
    Assert.notNull(command, "UnAssignValueFromReactivePowerCommand should not be null");
    Assert.notNull(
        command.getReactivePowerId(),
        "UnAssignValueFromReactivePowerCommand identifier should not be null");
  }
}
