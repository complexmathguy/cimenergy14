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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.discontinuousexcitationcontroldynamics.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class DiscontinuousExcitationControlDynamicsValidator {

  /** default constructor */
  protected DiscontinuousExcitationControlDynamicsValidator() {}

  /** factory method */
  public static DiscontinuousExcitationControlDynamicsValidator getInstance() {
    return new DiscontinuousExcitationControlDynamicsValidator();
  }

  /** handles creation validation for a DiscontinuousExcitationControlDynamics */
  public void validate(
      CreateDiscontinuousExcitationControlDynamicsCommand discontinuousExcitationControlDynamics)
      throws Exception {
    Assert.notNull(
        discontinuousExcitationControlDynamics,
        "CreateDiscontinuousExcitationControlDynamicsCommand should not be null");
    //		Assert.isNull(
    // discontinuousExcitationControlDynamics.getDiscontinuousExcitationControlDynamicsId(),
    // "CreateDiscontinuousExcitationControlDynamicsCommand identifier should be null" );
  }

  /** handles update validation for a DiscontinuousExcitationControlDynamics */
  public void validate(
      UpdateDiscontinuousExcitationControlDynamicsCommand discontinuousExcitationControlDynamics)
      throws Exception {
    Assert.notNull(
        discontinuousExcitationControlDynamics,
        "UpdateDiscontinuousExcitationControlDynamicsCommand should not be null");
    Assert.notNull(
        discontinuousExcitationControlDynamics.getDiscontinuousExcitationControlDynamicsId(),
        "UpdateDiscontinuousExcitationControlDynamicsCommand identifier should not be null");
  }

  /** handles delete validation for a DiscontinuousExcitationControlDynamics */
  public void validate(
      DeleteDiscontinuousExcitationControlDynamicsCommand discontinuousExcitationControlDynamics)
      throws Exception {
    Assert.notNull(discontinuousExcitationControlDynamics, "{commandAlias} should not be null");
    Assert.notNull(
        discontinuousExcitationControlDynamics.getDiscontinuousExcitationControlDynamicsId(),
        "DeleteDiscontinuousExcitationControlDynamicsCommand identifier should not be null");
  }

  /** handles fetchOne validation for a DiscontinuousExcitationControlDynamics */
  public void validate(DiscontinuousExcitationControlDynamicsFetchOneSummary summary)
      throws Exception {
    Assert.notNull(
        summary, "DiscontinuousExcitationControlDynamicsFetchOneSummary should not be null");
    Assert.notNull(
        summary.getDiscontinuousExcitationControlDynamicsId(),
        "DiscontinuousExcitationControlDynamicsFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign DiscontinuousExcitationControlDynamics validation for a
   * DiscontinuousExcitationControlDynamics
   *
   * @param command
   *     AssignDiscontinuousExcitationControlDynamicsToDiscontinuousExcitationControlDynamicsCommand
   */
  public void validate(
      AssignDiscontinuousExcitationControlDynamicsToDiscontinuousExcitationControlDynamicsCommand
          command)
      throws Exception {
    Assert.notNull(
        command,
        "AssignDiscontinuousExcitationControlDynamicsToDiscontinuousExcitationControlDynamicsCommand should not be null");
    Assert.notNull(
        command.getDiscontinuousExcitationControlDynamicsId(),
        "AssignDiscontinuousExcitationControlDynamicsToDiscontinuousExcitationControlDynamicsCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignDiscontinuousExcitationControlDynamicsToDiscontinuousExcitationControlDynamicsCommand assignment should not be null");
  }

  /**
   * handles unassign DiscontinuousExcitationControlDynamics validation for a
   * DiscontinuousExcitationControlDynamics
   *
   * @param command
   *     UnAssignDiscontinuousExcitationControlDynamicsFromDiscontinuousExcitationControlDynamicsCommand
   */
  public void validate(
      UnAssignDiscontinuousExcitationControlDynamicsFromDiscontinuousExcitationControlDynamicsCommand
          command)
      throws Exception {
    Assert.notNull(
        command,
        "UnAssignDiscontinuousExcitationControlDynamicsFromDiscontinuousExcitationControlDynamicsCommand should not be null");
    Assert.notNull(
        command.getDiscontinuousExcitationControlDynamicsId(),
        "UnAssignDiscontinuousExcitationControlDynamicsFromDiscontinuousExcitationControlDynamicsCommand identifier should not be null");
  }
}
