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

public class DiscontinuousExcitationControlUserDefinedValidator {

  /** default constructor */
  protected DiscontinuousExcitationControlUserDefinedValidator() {}

  /** factory method */
  public static DiscontinuousExcitationControlUserDefinedValidator getInstance() {
    return new DiscontinuousExcitationControlUserDefinedValidator();
  }

  /** handles creation validation for a DiscontinuousExcitationControlUserDefined */
  public void validate(
      CreateDiscontinuousExcitationControlUserDefinedCommand
          discontinuousExcitationControlUserDefined)
      throws Exception {
    Assert.notNull(
        discontinuousExcitationControlUserDefined,
        "CreateDiscontinuousExcitationControlUserDefinedCommand should not be null");
    //		Assert.isNull(
    // discontinuousExcitationControlUserDefined.getDiscontinuousExcitationControlUserDefinedId(),
    // "CreateDiscontinuousExcitationControlUserDefinedCommand identifier should be null" );
  }

  /** handles update validation for a DiscontinuousExcitationControlUserDefined */
  public void validate(
      UpdateDiscontinuousExcitationControlUserDefinedCommand
          discontinuousExcitationControlUserDefined)
      throws Exception {
    Assert.notNull(
        discontinuousExcitationControlUserDefined,
        "UpdateDiscontinuousExcitationControlUserDefinedCommand should not be null");
    Assert.notNull(
        discontinuousExcitationControlUserDefined.getDiscontinuousExcitationControlUserDefinedId(),
        "UpdateDiscontinuousExcitationControlUserDefinedCommand identifier should not be null");
  }

  /** handles delete validation for a DiscontinuousExcitationControlUserDefined */
  public void validate(
      DeleteDiscontinuousExcitationControlUserDefinedCommand
          discontinuousExcitationControlUserDefined)
      throws Exception {
    Assert.notNull(discontinuousExcitationControlUserDefined, "{commandAlias} should not be null");
    Assert.notNull(
        discontinuousExcitationControlUserDefined.getDiscontinuousExcitationControlUserDefinedId(),
        "DeleteDiscontinuousExcitationControlUserDefinedCommand identifier should not be null");
  }

  /** handles fetchOne validation for a DiscontinuousExcitationControlUserDefined */
  public void validate(DiscontinuousExcitationControlUserDefinedFetchOneSummary summary)
      throws Exception {
    Assert.notNull(
        summary, "DiscontinuousExcitationControlUserDefinedFetchOneSummary should not be null");
    Assert.notNull(
        summary.getDiscontinuousExcitationControlUserDefinedId(),
        "DiscontinuousExcitationControlUserDefinedFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Proprietary validation for a DiscontinuousExcitationControlUserDefined
   *
   * @param command AssignProprietaryToDiscontinuousExcitationControlUserDefinedCommand
   */
  public void validate(AssignProprietaryToDiscontinuousExcitationControlUserDefinedCommand command)
      throws Exception {
    Assert.notNull(
        command,
        "AssignProprietaryToDiscontinuousExcitationControlUserDefinedCommand should not be null");
    Assert.notNull(
        command.getDiscontinuousExcitationControlUserDefinedId(),
        "AssignProprietaryToDiscontinuousExcitationControlUserDefinedCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignProprietaryToDiscontinuousExcitationControlUserDefinedCommand assignment should not be null");
  }

  /**
   * handles unassign Proprietary validation for a DiscontinuousExcitationControlUserDefined
   *
   * @param command UnAssignProprietaryFromDiscontinuousExcitationControlUserDefinedCommand
   */
  public void validate(
      UnAssignProprietaryFromDiscontinuousExcitationControlUserDefinedCommand command)
      throws Exception {
    Assert.notNull(
        command,
        "UnAssignProprietaryFromDiscontinuousExcitationControlUserDefinedCommand should not be null");
    Assert.notNull(
        command.getDiscontinuousExcitationControlUserDefinedId(),
        "UnAssignProprietaryFromDiscontinuousExcitationControlUserDefinedCommand identifier should not be null");
  }
}
