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

public class InductanceValidator {

  /** default constructor */
  protected InductanceValidator() {}

  /** factory method */
  public static InductanceValidator getInstance() {
    return new InductanceValidator();
  }

  /** handles creation validation for a Inductance */
  public void validate(CreateInductanceCommand inductance) throws Exception {
    Assert.notNull(inductance, "CreateInductanceCommand should not be null");
    //		Assert.isNull( inductance.getInductanceId(), "CreateInductanceCommand identifier should be
    // null" );
  }

  /** handles update validation for a Inductance */
  public void validate(UpdateInductanceCommand inductance) throws Exception {
    Assert.notNull(inductance, "UpdateInductanceCommand should not be null");
    Assert.notNull(
        inductance.getInductanceId(), "UpdateInductanceCommand identifier should not be null");
  }

  /** handles delete validation for a Inductance */
  public void validate(DeleteInductanceCommand inductance) throws Exception {
    Assert.notNull(inductance, "{commandAlias} should not be null");
    Assert.notNull(
        inductance.getInductanceId(), "DeleteInductanceCommand identifier should not be null");
  }

  /** handles fetchOne validation for a Inductance */
  public void validate(InductanceFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "InductanceFetchOneSummary should not be null");
    Assert.notNull(
        summary.getInductanceId(), "InductanceFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Value validation for a Inductance
   *
   * @param command AssignValueToInductanceCommand
   */
  public void validate(AssignValueToInductanceCommand command) throws Exception {
    Assert.notNull(command, "AssignValueToInductanceCommand should not be null");
    Assert.notNull(
        command.getInductanceId(), "AssignValueToInductanceCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignValueToInductanceCommand assignment should not be null");
  }

  /**
   * handles unassign Value validation for a Inductance
   *
   * @param command UnAssignValueFromInductanceCommand
   */
  public void validate(UnAssignValueFromInductanceCommand command) throws Exception {
    Assert.notNull(command, "UnAssignValueFromInductanceCommand should not be null");
    Assert.notNull(
        command.getInductanceId(),
        "UnAssignValueFromInductanceCommand identifier should not be null");
  }
}
