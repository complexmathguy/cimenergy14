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

public class ReactanceValidator {

  /** default constructor */
  protected ReactanceValidator() {}

  /** factory method */
  public static ReactanceValidator getInstance() {
    return new ReactanceValidator();
  }

  /** handles creation validation for a Reactance */
  public void validate(CreateReactanceCommand reactance) throws Exception {
    Assert.notNull(reactance, "CreateReactanceCommand should not be null");
    //		Assert.isNull( reactance.getReactanceId(), "CreateReactanceCommand identifier should be
    // null" );
  }

  /** handles update validation for a Reactance */
  public void validate(UpdateReactanceCommand reactance) throws Exception {
    Assert.notNull(reactance, "UpdateReactanceCommand should not be null");
    Assert.notNull(
        reactance.getReactanceId(), "UpdateReactanceCommand identifier should not be null");
  }

  /** handles delete validation for a Reactance */
  public void validate(DeleteReactanceCommand reactance) throws Exception {
    Assert.notNull(reactance, "{commandAlias} should not be null");
    Assert.notNull(
        reactance.getReactanceId(), "DeleteReactanceCommand identifier should not be null");
  }

  /** handles fetchOne validation for a Reactance */
  public void validate(ReactanceFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "ReactanceFetchOneSummary should not be null");
    Assert.notNull(
        summary.getReactanceId(), "ReactanceFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Value validation for a Reactance
   *
   * @param command AssignValueToReactanceCommand
   */
  public void validate(AssignValueToReactanceCommand command) throws Exception {
    Assert.notNull(command, "AssignValueToReactanceCommand should not be null");
    Assert.notNull(
        command.getReactanceId(), "AssignValueToReactanceCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignValueToReactanceCommand assignment should not be null");
  }

  /**
   * handles unassign Value validation for a Reactance
   *
   * @param command UnAssignValueFromReactanceCommand
   */
  public void validate(UnAssignValueFromReactanceCommand command) throws Exception {
    Assert.notNull(command, "UnAssignValueFromReactanceCommand should not be null");
    Assert.notNull(
        command.getReactanceId(),
        "UnAssignValueFromReactanceCommand identifier should not be null");
  }
}
