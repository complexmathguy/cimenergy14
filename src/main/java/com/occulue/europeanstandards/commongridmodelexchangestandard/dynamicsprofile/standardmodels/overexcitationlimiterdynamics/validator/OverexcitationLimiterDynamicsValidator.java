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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.overexcitationlimiterdynamics.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class OverexcitationLimiterDynamicsValidator {

  /** default constructor */
  protected OverexcitationLimiterDynamicsValidator() {}

  /** factory method */
  public static OverexcitationLimiterDynamicsValidator getInstance() {
    return new OverexcitationLimiterDynamicsValidator();
  }

  /** handles creation validation for a OverexcitationLimiterDynamics */
  public void validate(CreateOverexcitationLimiterDynamicsCommand overexcitationLimiterDynamics)
      throws Exception {
    Assert.notNull(
        overexcitationLimiterDynamics,
        "CreateOverexcitationLimiterDynamicsCommand should not be null");
    //		Assert.isNull( overexcitationLimiterDynamics.getOverexcitationLimiterDynamicsId(),
    // "CreateOverexcitationLimiterDynamicsCommand identifier should be null" );
  }

  /** handles update validation for a OverexcitationLimiterDynamics */
  public void validate(UpdateOverexcitationLimiterDynamicsCommand overexcitationLimiterDynamics)
      throws Exception {
    Assert.notNull(
        overexcitationLimiterDynamics,
        "UpdateOverexcitationLimiterDynamicsCommand should not be null");
    Assert.notNull(
        overexcitationLimiterDynamics.getOverexcitationLimiterDynamicsId(),
        "UpdateOverexcitationLimiterDynamicsCommand identifier should not be null");
  }

  /** handles delete validation for a OverexcitationLimiterDynamics */
  public void validate(DeleteOverexcitationLimiterDynamicsCommand overexcitationLimiterDynamics)
      throws Exception {
    Assert.notNull(overexcitationLimiterDynamics, "{commandAlias} should not be null");
    Assert.notNull(
        overexcitationLimiterDynamics.getOverexcitationLimiterDynamicsId(),
        "DeleteOverexcitationLimiterDynamicsCommand identifier should not be null");
  }

  /** handles fetchOne validation for a OverexcitationLimiterDynamics */
  public void validate(OverexcitationLimiterDynamicsFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "OverexcitationLimiterDynamicsFetchOneSummary should not be null");
    Assert.notNull(
        summary.getOverexcitationLimiterDynamicsId(),
        "OverexcitationLimiterDynamicsFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign OverexcitationLimiterDynamics validation for a OverexcitationLimiterDynamics
   *
   * @param command AssignOverexcitationLimiterDynamicsToOverexcitationLimiterDynamicsCommand
   */
  public void validate(
      AssignOverexcitationLimiterDynamicsToOverexcitationLimiterDynamicsCommand command)
      throws Exception {
    Assert.notNull(
        command,
        "AssignOverexcitationLimiterDynamicsToOverexcitationLimiterDynamicsCommand should not be null");
    Assert.notNull(
        command.getOverexcitationLimiterDynamicsId(),
        "AssignOverexcitationLimiterDynamicsToOverexcitationLimiterDynamicsCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignOverexcitationLimiterDynamicsToOverexcitationLimiterDynamicsCommand assignment should not be null");
  }

  /**
   * handles unassign OverexcitationLimiterDynamics validation for a OverexcitationLimiterDynamics
   *
   * @param command UnAssignOverexcitationLimiterDynamicsFromOverexcitationLimiterDynamicsCommand
   */
  public void validate(
      UnAssignOverexcitationLimiterDynamicsFromOverexcitationLimiterDynamicsCommand command)
      throws Exception {
    Assert.notNull(
        command,
        "UnAssignOverexcitationLimiterDynamicsFromOverexcitationLimiterDynamicsCommand should not be null");
    Assert.notNull(
        command.getOverexcitationLimiterDynamicsId(),
        "UnAssignOverexcitationLimiterDynamicsFromOverexcitationLimiterDynamicsCommand identifier should not be null");
  }
}
