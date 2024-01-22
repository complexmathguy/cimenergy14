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

public class LoadUserDefinedValidator {

  /** default constructor */
  protected LoadUserDefinedValidator() {}

  /** factory method */
  public static LoadUserDefinedValidator getInstance() {
    return new LoadUserDefinedValidator();
  }

  /** handles creation validation for a LoadUserDefined */
  public void validate(CreateLoadUserDefinedCommand loadUserDefined) throws Exception {
    Assert.notNull(loadUserDefined, "CreateLoadUserDefinedCommand should not be null");
    //		Assert.isNull( loadUserDefined.getLoadUserDefinedId(), "CreateLoadUserDefinedCommand
    // identifier should be null" );
  }

  /** handles update validation for a LoadUserDefined */
  public void validate(UpdateLoadUserDefinedCommand loadUserDefined) throws Exception {
    Assert.notNull(loadUserDefined, "UpdateLoadUserDefinedCommand should not be null");
    Assert.notNull(
        loadUserDefined.getLoadUserDefinedId(),
        "UpdateLoadUserDefinedCommand identifier should not be null");
  }

  /** handles delete validation for a LoadUserDefined */
  public void validate(DeleteLoadUserDefinedCommand loadUserDefined) throws Exception {
    Assert.notNull(loadUserDefined, "{commandAlias} should not be null");
    Assert.notNull(
        loadUserDefined.getLoadUserDefinedId(),
        "DeleteLoadUserDefinedCommand identifier should not be null");
  }

  /** handles fetchOne validation for a LoadUserDefined */
  public void validate(LoadUserDefinedFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "LoadUserDefinedFetchOneSummary should not be null");
    Assert.notNull(
        summary.getLoadUserDefinedId(),
        "LoadUserDefinedFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Proprietary validation for a LoadUserDefined
   *
   * @param command AssignProprietaryToLoadUserDefinedCommand
   */
  public void validate(AssignProprietaryToLoadUserDefinedCommand command) throws Exception {
    Assert.notNull(command, "AssignProprietaryToLoadUserDefinedCommand should not be null");
    Assert.notNull(
        command.getLoadUserDefinedId(),
        "AssignProprietaryToLoadUserDefinedCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignProprietaryToLoadUserDefinedCommand assignment should not be null");
  }

  /**
   * handles unassign Proprietary validation for a LoadUserDefined
   *
   * @param command UnAssignProprietaryFromLoadUserDefinedCommand
   */
  public void validate(UnAssignProprietaryFromLoadUserDefinedCommand command) throws Exception {
    Assert.notNull(command, "UnAssignProprietaryFromLoadUserDefinedCommand should not be null");
    Assert.notNull(
        command.getLoadUserDefinedId(),
        "UnAssignProprietaryFromLoadUserDefinedCommand identifier should not be null");
  }
}
