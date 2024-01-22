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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.underexcitationlimiterdynamics.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class UnderexcitationLimiterDynamicsValidator {

  /** default constructor */
  protected UnderexcitationLimiterDynamicsValidator() {}

  /** factory method */
  public static UnderexcitationLimiterDynamicsValidator getInstance() {
    return new UnderexcitationLimiterDynamicsValidator();
  }

  /** handles creation validation for a UnderexcitationLimiterDynamics */
  public void validate(CreateUnderexcitationLimiterDynamicsCommand underexcitationLimiterDynamics)
      throws Exception {
    Assert.notNull(
        underexcitationLimiterDynamics,
        "CreateUnderexcitationLimiterDynamicsCommand should not be null");
    //		Assert.isNull( underexcitationLimiterDynamics.getUnderexcitationLimiterDynamicsId(),
    // "CreateUnderexcitationLimiterDynamicsCommand identifier should be null" );
  }

  /** handles update validation for a UnderexcitationLimiterDynamics */
  public void validate(UpdateUnderexcitationLimiterDynamicsCommand underexcitationLimiterDynamics)
      throws Exception {
    Assert.notNull(
        underexcitationLimiterDynamics,
        "UpdateUnderexcitationLimiterDynamicsCommand should not be null");
    Assert.notNull(
        underexcitationLimiterDynamics.getUnderexcitationLimiterDynamicsId(),
        "UpdateUnderexcitationLimiterDynamicsCommand identifier should not be null");
  }

  /** handles delete validation for a UnderexcitationLimiterDynamics */
  public void validate(DeleteUnderexcitationLimiterDynamicsCommand underexcitationLimiterDynamics)
      throws Exception {
    Assert.notNull(underexcitationLimiterDynamics, "{commandAlias} should not be null");
    Assert.notNull(
        underexcitationLimiterDynamics.getUnderexcitationLimiterDynamicsId(),
        "DeleteUnderexcitationLimiterDynamicsCommand identifier should not be null");
  }

  /** handles fetchOne validation for a UnderexcitationLimiterDynamics */
  public void validate(UnderexcitationLimiterDynamicsFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "UnderexcitationLimiterDynamicsFetchOneSummary should not be null");
    Assert.notNull(
        summary.getUnderexcitationLimiterDynamicsId(),
        "UnderexcitationLimiterDynamicsFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign UnderexcitationLimiterDynamics validation for a UnderexcitationLimiterDynamics
   *
   * @param command AssignUnderexcitationLimiterDynamicsToUnderexcitationLimiterDynamicsCommand
   */
  public void validate(
      AssignUnderexcitationLimiterDynamicsToUnderexcitationLimiterDynamicsCommand command)
      throws Exception {
    Assert.notNull(
        command,
        "AssignUnderexcitationLimiterDynamicsToUnderexcitationLimiterDynamicsCommand should not be null");
    Assert.notNull(
        command.getUnderexcitationLimiterDynamicsId(),
        "AssignUnderexcitationLimiterDynamicsToUnderexcitationLimiterDynamicsCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignUnderexcitationLimiterDynamicsToUnderexcitationLimiterDynamicsCommand assignment should not be null");
  }

  /**
   * handles unassign UnderexcitationLimiterDynamics validation for a UnderexcitationLimiterDynamics
   *
   * @param command UnAssignUnderexcitationLimiterDynamicsFromUnderexcitationLimiterDynamicsCommand
   */
  public void validate(
      UnAssignUnderexcitationLimiterDynamicsFromUnderexcitationLimiterDynamicsCommand command)
      throws Exception {
    Assert.notNull(
        command,
        "UnAssignUnderexcitationLimiterDynamicsFromUnderexcitationLimiterDynamicsCommand should not be null");
    Assert.notNull(
        command.getUnderexcitationLimiterDynamicsId(),
        "UnAssignUnderexcitationLimiterDynamicsFromUnderexcitationLimiterDynamicsCommand identifier should not be null");
  }
}
