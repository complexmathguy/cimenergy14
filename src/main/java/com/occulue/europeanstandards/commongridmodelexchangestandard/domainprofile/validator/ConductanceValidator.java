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

public class ConductanceValidator {

  /** default constructor */
  protected ConductanceValidator() {}

  /** factory method */
  public static ConductanceValidator getInstance() {
    return new ConductanceValidator();
  }

  /** handles creation validation for a Conductance */
  public void validate(CreateConductanceCommand conductance) throws Exception {
    Assert.notNull(conductance, "CreateConductanceCommand should not be null");
    //		Assert.isNull( conductance.getConductanceId(), "CreateConductanceCommand identifier should
    // be null" );
  }

  /** handles update validation for a Conductance */
  public void validate(UpdateConductanceCommand conductance) throws Exception {
    Assert.notNull(conductance, "UpdateConductanceCommand should not be null");
    Assert.notNull(
        conductance.getConductanceId(), "UpdateConductanceCommand identifier should not be null");
  }

  /** handles delete validation for a Conductance */
  public void validate(DeleteConductanceCommand conductance) throws Exception {
    Assert.notNull(conductance, "{commandAlias} should not be null");
    Assert.notNull(
        conductance.getConductanceId(), "DeleteConductanceCommand identifier should not be null");
  }

  /** handles fetchOne validation for a Conductance */
  public void validate(ConductanceFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "ConductanceFetchOneSummary should not be null");
    Assert.notNull(
        summary.getConductanceId(), "ConductanceFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Value validation for a Conductance
   *
   * @param command AssignValueToConductanceCommand
   */
  public void validate(AssignValueToConductanceCommand command) throws Exception {
    Assert.notNull(command, "AssignValueToConductanceCommand should not be null");
    Assert.notNull(
        command.getConductanceId(),
        "AssignValueToConductanceCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignValueToConductanceCommand assignment should not be null");
  }

  /**
   * handles unassign Value validation for a Conductance
   *
   * @param command UnAssignValueFromConductanceCommand
   */
  public void validate(UnAssignValueFromConductanceCommand command) throws Exception {
    Assert.notNull(command, "UnAssignValueFromConductanceCommand should not be null");
    Assert.notNull(
        command.getConductanceId(),
        "UnAssignValueFromConductanceCommand identifier should not be null");
  }
}
