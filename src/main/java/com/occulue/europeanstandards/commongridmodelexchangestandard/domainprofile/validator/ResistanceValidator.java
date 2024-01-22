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

public class ResistanceValidator {

  /** default constructor */
  protected ResistanceValidator() {}

  /** factory method */
  public static ResistanceValidator getInstance() {
    return new ResistanceValidator();
  }

  /** handles creation validation for a Resistance */
  public void validate(CreateResistanceCommand resistance) throws Exception {
    Assert.notNull(resistance, "CreateResistanceCommand should not be null");
    //		Assert.isNull( resistance.getResistanceId(), "CreateResistanceCommand identifier should be
    // null" );
  }

  /** handles update validation for a Resistance */
  public void validate(UpdateResistanceCommand resistance) throws Exception {
    Assert.notNull(resistance, "UpdateResistanceCommand should not be null");
    Assert.notNull(
        resistance.getResistanceId(), "UpdateResistanceCommand identifier should not be null");
  }

  /** handles delete validation for a Resistance */
  public void validate(DeleteResistanceCommand resistance) throws Exception {
    Assert.notNull(resistance, "{commandAlias} should not be null");
    Assert.notNull(
        resistance.getResistanceId(), "DeleteResistanceCommand identifier should not be null");
  }

  /** handles fetchOne validation for a Resistance */
  public void validate(ResistanceFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "ResistanceFetchOneSummary should not be null");
    Assert.notNull(
        summary.getResistanceId(), "ResistanceFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Value validation for a Resistance
   *
   * @param command AssignValueToResistanceCommand
   */
  public void validate(AssignValueToResistanceCommand command) throws Exception {
    Assert.notNull(command, "AssignValueToResistanceCommand should not be null");
    Assert.notNull(
        command.getResistanceId(), "AssignValueToResistanceCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignValueToResistanceCommand assignment should not be null");
  }

  /**
   * handles unassign Value validation for a Resistance
   *
   * @param command UnAssignValueFromResistanceCommand
   */
  public void validate(UnAssignValueFromResistanceCommand command) throws Exception {
    Assert.notNull(command, "UnAssignValueFromResistanceCommand should not be null");
    Assert.notNull(
        command.getResistanceId(),
        "UnAssignValueFromResistanceCommand identifier should not be null");
  }
}
