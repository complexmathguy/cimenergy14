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

public class PFVArControllerType2UserDefinedValidator {

  /** default constructor */
  protected PFVArControllerType2UserDefinedValidator() {}

  /** factory method */
  public static PFVArControllerType2UserDefinedValidator getInstance() {
    return new PFVArControllerType2UserDefinedValidator();
  }

  /** handles creation validation for a PFVArControllerType2UserDefined */
  public void validate(CreatePFVArControllerType2UserDefinedCommand pFVArControllerType2UserDefined)
      throws Exception {
    Assert.notNull(
        pFVArControllerType2UserDefined,
        "CreatePFVArControllerType2UserDefinedCommand should not be null");
    //		Assert.isNull( pFVArControllerType2UserDefined.getPFVArControllerType2UserDefinedId(),
    // "CreatePFVArControllerType2UserDefinedCommand identifier should be null" );
  }

  /** handles update validation for a PFVArControllerType2UserDefined */
  public void validate(UpdatePFVArControllerType2UserDefinedCommand pFVArControllerType2UserDefined)
      throws Exception {
    Assert.notNull(
        pFVArControllerType2UserDefined,
        "UpdatePFVArControllerType2UserDefinedCommand should not be null");
    Assert.notNull(
        pFVArControllerType2UserDefined.getPFVArControllerType2UserDefinedId(),
        "UpdatePFVArControllerType2UserDefinedCommand identifier should not be null");
  }

  /** handles delete validation for a PFVArControllerType2UserDefined */
  public void validate(DeletePFVArControllerType2UserDefinedCommand pFVArControllerType2UserDefined)
      throws Exception {
    Assert.notNull(pFVArControllerType2UserDefined, "{commandAlias} should not be null");
    Assert.notNull(
        pFVArControllerType2UserDefined.getPFVArControllerType2UserDefinedId(),
        "DeletePFVArControllerType2UserDefinedCommand identifier should not be null");
  }

  /** handles fetchOne validation for a PFVArControllerType2UserDefined */
  public void validate(PFVArControllerType2UserDefinedFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "PFVArControllerType2UserDefinedFetchOneSummary should not be null");
    Assert.notNull(
        summary.getPFVArControllerType2UserDefinedId(),
        "PFVArControllerType2UserDefinedFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Proprietary validation for a PFVArControllerType2UserDefined
   *
   * @param command AssignProprietaryToPFVArControllerType2UserDefinedCommand
   */
  public void validate(AssignProprietaryToPFVArControllerType2UserDefinedCommand command)
      throws Exception {
    Assert.notNull(
        command, "AssignProprietaryToPFVArControllerType2UserDefinedCommand should not be null");
    Assert.notNull(
        command.getPFVArControllerType2UserDefinedId(),
        "AssignProprietaryToPFVArControllerType2UserDefinedCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignProprietaryToPFVArControllerType2UserDefinedCommand assignment should not be null");
  }

  /**
   * handles unassign Proprietary validation for a PFVArControllerType2UserDefined
   *
   * @param command UnAssignProprietaryFromPFVArControllerType2UserDefinedCommand
   */
  public void validate(UnAssignProprietaryFromPFVArControllerType2UserDefinedCommand command)
      throws Exception {
    Assert.notNull(
        command,
        "UnAssignProprietaryFromPFVArControllerType2UserDefinedCommand should not be null");
    Assert.notNull(
        command.getPFVArControllerType2UserDefinedId(),
        "UnAssignProprietaryFromPFVArControllerType2UserDefinedCommand identifier should not be null");
  }
}
