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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.userdefinedmodels.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class OverexcitationLimiterUserDefinedValidator {

  /** default constructor */
  protected OverexcitationLimiterUserDefinedValidator() {}

  /** factory method */
  public static OverexcitationLimiterUserDefinedValidator getInstance() {
    return new OverexcitationLimiterUserDefinedValidator();
  }

  /** handles creation validation for a OverexcitationLimiterUserDefined */
  public void validate(
      CreateOverexcitationLimiterUserDefinedCommand overexcitationLimiterUserDefined)
      throws Exception {
    Assert.notNull(
        overexcitationLimiterUserDefined,
        "CreateOverexcitationLimiterUserDefinedCommand should not be null");
    //		Assert.isNull( overexcitationLimiterUserDefined.getOverexcitationLimiterUserDefinedId(),
    // "CreateOverexcitationLimiterUserDefinedCommand identifier should be null" );
  }

  /** handles update validation for a OverexcitationLimiterUserDefined */
  public void validate(
      UpdateOverexcitationLimiterUserDefinedCommand overexcitationLimiterUserDefined)
      throws Exception {
    Assert.notNull(
        overexcitationLimiterUserDefined,
        "UpdateOverexcitationLimiterUserDefinedCommand should not be null");
    Assert.notNull(
        overexcitationLimiterUserDefined.getOverexcitationLimiterUserDefinedId(),
        "UpdateOverexcitationLimiterUserDefinedCommand identifier should not be null");
  }

  /** handles delete validation for a OverexcitationLimiterUserDefined */
  public void validate(
      DeleteOverexcitationLimiterUserDefinedCommand overexcitationLimiterUserDefined)
      throws Exception {
    Assert.notNull(overexcitationLimiterUserDefined, "{commandAlias} should not be null");
    Assert.notNull(
        overexcitationLimiterUserDefined.getOverexcitationLimiterUserDefinedId(),
        "DeleteOverexcitationLimiterUserDefinedCommand identifier should not be null");
  }

  /** handles fetchOne validation for a OverexcitationLimiterUserDefined */
  public void validate(OverexcitationLimiterUserDefinedFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "OverexcitationLimiterUserDefinedFetchOneSummary should not be null");
    Assert.notNull(
        summary.getOverexcitationLimiterUserDefinedId(),
        "OverexcitationLimiterUserDefinedFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Proprietary validation for a OverexcitationLimiterUserDefined
   *
   * @param command AssignProprietaryToOverexcitationLimiterUserDefinedCommand
   */
  public void validate(AssignProprietaryToOverexcitationLimiterUserDefinedCommand command)
      throws Exception {
    Assert.notNull(
        command, "AssignProprietaryToOverexcitationLimiterUserDefinedCommand should not be null");
    Assert.notNull(
        command.getOverexcitationLimiterUserDefinedId(),
        "AssignProprietaryToOverexcitationLimiterUserDefinedCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignProprietaryToOverexcitationLimiterUserDefinedCommand assignment should not be null");
  }

  /**
   * handles unassign Proprietary validation for a OverexcitationLimiterUserDefined
   *
   * @param command UnAssignProprietaryFromOverexcitationLimiterUserDefinedCommand
   */
  public void validate(UnAssignProprietaryFromOverexcitationLimiterUserDefinedCommand command)
      throws Exception {
    Assert.notNull(
        command,
        "UnAssignProprietaryFromOverexcitationLimiterUserDefinedCommand should not be null");
    Assert.notNull(
        command.getOverexcitationLimiterUserDefinedId(),
        "UnAssignProprietaryFromOverexcitationLimiterUserDefinedCommand identifier should not be null");
  }
}
