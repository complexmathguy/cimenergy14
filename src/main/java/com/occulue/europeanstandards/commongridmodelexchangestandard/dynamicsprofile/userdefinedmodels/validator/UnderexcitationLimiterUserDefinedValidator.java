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

public class UnderexcitationLimiterUserDefinedValidator {

  /** default constructor */
  protected UnderexcitationLimiterUserDefinedValidator() {}

  /** factory method */
  public static UnderexcitationLimiterUserDefinedValidator getInstance() {
    return new UnderexcitationLimiterUserDefinedValidator();
  }

  /** handles creation validation for a UnderexcitationLimiterUserDefined */
  public void validate(
      CreateUnderexcitationLimiterUserDefinedCommand underexcitationLimiterUserDefined)
      throws Exception {
    Assert.notNull(
        underexcitationLimiterUserDefined,
        "CreateUnderexcitationLimiterUserDefinedCommand should not be null");
    //		Assert.isNull( underexcitationLimiterUserDefined.getUnderexcitationLimiterUserDefinedId(),
    // "CreateUnderexcitationLimiterUserDefinedCommand identifier should be null" );
  }

  /** handles update validation for a UnderexcitationLimiterUserDefined */
  public void validate(
      UpdateUnderexcitationLimiterUserDefinedCommand underexcitationLimiterUserDefined)
      throws Exception {
    Assert.notNull(
        underexcitationLimiterUserDefined,
        "UpdateUnderexcitationLimiterUserDefinedCommand should not be null");
    Assert.notNull(
        underexcitationLimiterUserDefined.getUnderexcitationLimiterUserDefinedId(),
        "UpdateUnderexcitationLimiterUserDefinedCommand identifier should not be null");
  }

  /** handles delete validation for a UnderexcitationLimiterUserDefined */
  public void validate(
      DeleteUnderexcitationLimiterUserDefinedCommand underexcitationLimiterUserDefined)
      throws Exception {
    Assert.notNull(underexcitationLimiterUserDefined, "{commandAlias} should not be null");
    Assert.notNull(
        underexcitationLimiterUserDefined.getUnderexcitationLimiterUserDefinedId(),
        "DeleteUnderexcitationLimiterUserDefinedCommand identifier should not be null");
  }

  /** handles fetchOne validation for a UnderexcitationLimiterUserDefined */
  public void validate(UnderexcitationLimiterUserDefinedFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "UnderexcitationLimiterUserDefinedFetchOneSummary should not be null");
    Assert.notNull(
        summary.getUnderexcitationLimiterUserDefinedId(),
        "UnderexcitationLimiterUserDefinedFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Proprietary validation for a UnderexcitationLimiterUserDefined
   *
   * @param command AssignProprietaryToUnderexcitationLimiterUserDefinedCommand
   */
  public void validate(AssignProprietaryToUnderexcitationLimiterUserDefinedCommand command)
      throws Exception {
    Assert.notNull(
        command, "AssignProprietaryToUnderexcitationLimiterUserDefinedCommand should not be null");
    Assert.notNull(
        command.getUnderexcitationLimiterUserDefinedId(),
        "AssignProprietaryToUnderexcitationLimiterUserDefinedCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignProprietaryToUnderexcitationLimiterUserDefinedCommand assignment should not be null");
  }

  /**
   * handles unassign Proprietary validation for a UnderexcitationLimiterUserDefined
   *
   * @param command UnAssignProprietaryFromUnderexcitationLimiterUserDefinedCommand
   */
  public void validate(UnAssignProprietaryFromUnderexcitationLimiterUserDefinedCommand command)
      throws Exception {
    Assert.notNull(
        command,
        "UnAssignProprietaryFromUnderexcitationLimiterUserDefinedCommand should not be null");
    Assert.notNull(
        command.getUnderexcitationLimiterUserDefinedId(),
        "UnAssignProprietaryFromUnderexcitationLimiterUserDefinedCommand identifier should not be null");
  }
}
