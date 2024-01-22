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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.equivalents.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class EquivalentShuntValidator {

  /** default constructor */
  protected EquivalentShuntValidator() {}

  /** factory method */
  public static EquivalentShuntValidator getInstance() {
    return new EquivalentShuntValidator();
  }

  /** handles creation validation for a EquivalentShunt */
  public void validate(CreateEquivalentShuntCommand equivalentShunt) throws Exception {
    Assert.notNull(equivalentShunt, "CreateEquivalentShuntCommand should not be null");
    //		Assert.isNull( equivalentShunt.getEquivalentShuntId(), "CreateEquivalentShuntCommand
    // identifier should be null" );
  }

  /** handles update validation for a EquivalentShunt */
  public void validate(UpdateEquivalentShuntCommand equivalentShunt) throws Exception {
    Assert.notNull(equivalentShunt, "UpdateEquivalentShuntCommand should not be null");
    Assert.notNull(
        equivalentShunt.getEquivalentShuntId(),
        "UpdateEquivalentShuntCommand identifier should not be null");
  }

  /** handles delete validation for a EquivalentShunt */
  public void validate(DeleteEquivalentShuntCommand equivalentShunt) throws Exception {
    Assert.notNull(equivalentShunt, "{commandAlias} should not be null");
    Assert.notNull(
        equivalentShunt.getEquivalentShuntId(),
        "DeleteEquivalentShuntCommand identifier should not be null");
  }

  /** handles fetchOne validation for a EquivalentShunt */
  public void validate(EquivalentShuntFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "EquivalentShuntFetchOneSummary should not be null");
    Assert.notNull(
        summary.getEquivalentShuntId(),
        "EquivalentShuntFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign B validation for a EquivalentShunt
   *
   * @param command AssignBToEquivalentShuntCommand
   */
  public void validate(AssignBToEquivalentShuntCommand command) throws Exception {
    Assert.notNull(command, "AssignBToEquivalentShuntCommand should not be null");
    Assert.notNull(
        command.getEquivalentShuntId(),
        "AssignBToEquivalentShuntCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignBToEquivalentShuntCommand assignment should not be null");
  }

  /**
   * handles unassign B validation for a EquivalentShunt
   *
   * @param command UnAssignBFromEquivalentShuntCommand
   */
  public void validate(UnAssignBFromEquivalentShuntCommand command) throws Exception {
    Assert.notNull(command, "UnAssignBFromEquivalentShuntCommand should not be null");
    Assert.notNull(
        command.getEquivalentShuntId(),
        "UnAssignBFromEquivalentShuntCommand identifier should not be null");
  }
  /**
   * handles assign G validation for a EquivalentShunt
   *
   * @param command AssignGToEquivalentShuntCommand
   */
  public void validate(AssignGToEquivalentShuntCommand command) throws Exception {
    Assert.notNull(command, "AssignGToEquivalentShuntCommand should not be null");
    Assert.notNull(
        command.getEquivalentShuntId(),
        "AssignGToEquivalentShuntCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignGToEquivalentShuntCommand assignment should not be null");
  }

  /**
   * handles unassign G validation for a EquivalentShunt
   *
   * @param command UnAssignGFromEquivalentShuntCommand
   */
  public void validate(UnAssignGFromEquivalentShuntCommand command) throws Exception {
    Assert.notNull(command, "UnAssignGFromEquivalentShuntCommand should not be null");
    Assert.notNull(
        command.getEquivalentShuntId(),
        "UnAssignGFromEquivalentShuntCommand identifier should not be null");
  }
}
