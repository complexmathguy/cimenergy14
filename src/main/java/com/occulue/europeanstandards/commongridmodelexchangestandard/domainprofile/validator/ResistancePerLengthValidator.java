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

public class ResistancePerLengthValidator {

  /** default constructor */
  protected ResistancePerLengthValidator() {}

  /** factory method */
  public static ResistancePerLengthValidator getInstance() {
    return new ResistancePerLengthValidator();
  }

  /** handles creation validation for a ResistancePerLength */
  public void validate(CreateResistancePerLengthCommand resistancePerLength) throws Exception {
    Assert.notNull(resistancePerLength, "CreateResistancePerLengthCommand should not be null");
    //		Assert.isNull( resistancePerLength.getResistancePerLengthId(),
    // "CreateResistancePerLengthCommand identifier should be null" );
  }

  /** handles update validation for a ResistancePerLength */
  public void validate(UpdateResistancePerLengthCommand resistancePerLength) throws Exception {
    Assert.notNull(resistancePerLength, "UpdateResistancePerLengthCommand should not be null");
    Assert.notNull(
        resistancePerLength.getResistancePerLengthId(),
        "UpdateResistancePerLengthCommand identifier should not be null");
  }

  /** handles delete validation for a ResistancePerLength */
  public void validate(DeleteResistancePerLengthCommand resistancePerLength) throws Exception {
    Assert.notNull(resistancePerLength, "{commandAlias} should not be null");
    Assert.notNull(
        resistancePerLength.getResistancePerLengthId(),
        "DeleteResistancePerLengthCommand identifier should not be null");
  }

  /** handles fetchOne validation for a ResistancePerLength */
  public void validate(ResistancePerLengthFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "ResistancePerLengthFetchOneSummary should not be null");
    Assert.notNull(
        summary.getResistancePerLengthId(),
        "ResistancePerLengthFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Value validation for a ResistancePerLength
   *
   * @param command AssignValueToResistancePerLengthCommand
   */
  public void validate(AssignValueToResistancePerLengthCommand command) throws Exception {
    Assert.notNull(command, "AssignValueToResistancePerLengthCommand should not be null");
    Assert.notNull(
        command.getResistancePerLengthId(),
        "AssignValueToResistancePerLengthCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignValueToResistancePerLengthCommand assignment should not be null");
  }

  /**
   * handles unassign Value validation for a ResistancePerLength
   *
   * @param command UnAssignValueFromResistancePerLengthCommand
   */
  public void validate(UnAssignValueFromResistancePerLengthCommand command) throws Exception {
    Assert.notNull(command, "UnAssignValueFromResistancePerLengthCommand should not be null");
    Assert.notNull(
        command.getResistancePerLengthId(),
        "UnAssignValueFromResistancePerLengthCommand identifier should not be null");
  }
}
