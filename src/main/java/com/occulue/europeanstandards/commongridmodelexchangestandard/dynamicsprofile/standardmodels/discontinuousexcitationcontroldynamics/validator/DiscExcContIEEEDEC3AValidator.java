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

public class DiscExcContIEEEDEC3AValidator {

  /** default constructor */
  protected DiscExcContIEEEDEC3AValidator() {}

  /** factory method */
  public static DiscExcContIEEEDEC3AValidator getInstance() {
    return new DiscExcContIEEEDEC3AValidator();
  }

  /** handles creation validation for a DiscExcContIEEEDEC3A */
  public void validate(CreateDiscExcContIEEEDEC3ACommand discExcContIEEEDEC3A) throws Exception {
    Assert.notNull(discExcContIEEEDEC3A, "CreateDiscExcContIEEEDEC3ACommand should not be null");
    //		Assert.isNull( discExcContIEEEDEC3A.getDiscExcContIEEEDEC3AId(),
    // "CreateDiscExcContIEEEDEC3ACommand identifier should be null" );
  }

  /** handles update validation for a DiscExcContIEEEDEC3A */
  public void validate(UpdateDiscExcContIEEEDEC3ACommand discExcContIEEEDEC3A) throws Exception {
    Assert.notNull(discExcContIEEEDEC3A, "UpdateDiscExcContIEEEDEC3ACommand should not be null");
    Assert.notNull(
        discExcContIEEEDEC3A.getDiscExcContIEEEDEC3AId(),
        "UpdateDiscExcContIEEEDEC3ACommand identifier should not be null");
  }

  /** handles delete validation for a DiscExcContIEEEDEC3A */
  public void validate(DeleteDiscExcContIEEEDEC3ACommand discExcContIEEEDEC3A) throws Exception {
    Assert.notNull(discExcContIEEEDEC3A, "{commandAlias} should not be null");
    Assert.notNull(
        discExcContIEEEDEC3A.getDiscExcContIEEEDEC3AId(),
        "DeleteDiscExcContIEEEDEC3ACommand identifier should not be null");
  }

  /** handles fetchOne validation for a DiscExcContIEEEDEC3A */
  public void validate(DiscExcContIEEEDEC3AFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "DiscExcContIEEEDEC3AFetchOneSummary should not be null");
    Assert.notNull(
        summary.getDiscExcContIEEEDEC3AId(),
        "DiscExcContIEEEDEC3AFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Tdr validation for a DiscExcContIEEEDEC3A
   *
   * @param command AssignTdrToDiscExcContIEEEDEC3ACommand
   */
  public void validate(AssignTdrToDiscExcContIEEEDEC3ACommand command) throws Exception {
    Assert.notNull(command, "AssignTdrToDiscExcContIEEEDEC3ACommand should not be null");
    Assert.notNull(
        command.getDiscExcContIEEEDEC3AId(),
        "AssignTdrToDiscExcContIEEEDEC3ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignTdrToDiscExcContIEEEDEC3ACommand assignment should not be null");
  }

  /**
   * handles unassign Tdr validation for a DiscExcContIEEEDEC3A
   *
   * @param command UnAssignTdrFromDiscExcContIEEEDEC3ACommand
   */
  public void validate(UnAssignTdrFromDiscExcContIEEEDEC3ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignTdrFromDiscExcContIEEEDEC3ACommand should not be null");
    Assert.notNull(
        command.getDiscExcContIEEEDEC3AId(),
        "UnAssignTdrFromDiscExcContIEEEDEC3ACommand identifier should not be null");
  }
  /**
   * handles assign Vtmin validation for a DiscExcContIEEEDEC3A
   *
   * @param command AssignVtminToDiscExcContIEEEDEC3ACommand
   */
  public void validate(AssignVtminToDiscExcContIEEEDEC3ACommand command) throws Exception {
    Assert.notNull(command, "AssignVtminToDiscExcContIEEEDEC3ACommand should not be null");
    Assert.notNull(
        command.getDiscExcContIEEEDEC3AId(),
        "AssignVtminToDiscExcContIEEEDEC3ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignVtminToDiscExcContIEEEDEC3ACommand assignment should not be null");
  }

  /**
   * handles unassign Vtmin validation for a DiscExcContIEEEDEC3A
   *
   * @param command UnAssignVtminFromDiscExcContIEEEDEC3ACommand
   */
  public void validate(UnAssignVtminFromDiscExcContIEEEDEC3ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignVtminFromDiscExcContIEEEDEC3ACommand should not be null");
    Assert.notNull(
        command.getDiscExcContIEEEDEC3AId(),
        "UnAssignVtminFromDiscExcContIEEEDEC3ACommand identifier should not be null");
  }
}
