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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.winddynamics.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class WindContPType4bIECValidator {

  /** default constructor */
  protected WindContPType4bIECValidator() {}

  /** factory method */
  public static WindContPType4bIECValidator getInstance() {
    return new WindContPType4bIECValidator();
  }

  /** handles creation validation for a WindContPType4bIEC */
  public void validate(CreateWindContPType4bIECCommand windContPType4bIEC) throws Exception {
    Assert.notNull(windContPType4bIEC, "CreateWindContPType4bIECCommand should not be null");
    //		Assert.isNull( windContPType4bIEC.getWindContPType4bIECId(),
    // "CreateWindContPType4bIECCommand identifier should be null" );
  }

  /** handles update validation for a WindContPType4bIEC */
  public void validate(UpdateWindContPType4bIECCommand windContPType4bIEC) throws Exception {
    Assert.notNull(windContPType4bIEC, "UpdateWindContPType4bIECCommand should not be null");
    Assert.notNull(
        windContPType4bIEC.getWindContPType4bIECId(),
        "UpdateWindContPType4bIECCommand identifier should not be null");
  }

  /** handles delete validation for a WindContPType4bIEC */
  public void validate(DeleteWindContPType4bIECCommand windContPType4bIEC) throws Exception {
    Assert.notNull(windContPType4bIEC, "{commandAlias} should not be null");
    Assert.notNull(
        windContPType4bIEC.getWindContPType4bIECId(),
        "DeleteWindContPType4bIECCommand identifier should not be null");
  }

  /** handles fetchOne validation for a WindContPType4bIEC */
  public void validate(WindContPType4bIECFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "WindContPType4bIECFetchOneSummary should not be null");
    Assert.notNull(
        summary.getWindContPType4bIECId(),
        "WindContPType4bIECFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Dpmax validation for a WindContPType4bIEC
   *
   * @param command AssignDpmaxToWindContPType4bIECCommand
   */
  public void validate(AssignDpmaxToWindContPType4bIECCommand command) throws Exception {
    Assert.notNull(command, "AssignDpmaxToWindContPType4bIECCommand should not be null");
    Assert.notNull(
        command.getWindContPType4bIECId(),
        "AssignDpmaxToWindContPType4bIECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignDpmaxToWindContPType4bIECCommand assignment should not be null");
  }

  /**
   * handles unassign Dpmax validation for a WindContPType4bIEC
   *
   * @param command UnAssignDpmaxFromWindContPType4bIECCommand
   */
  public void validate(UnAssignDpmaxFromWindContPType4bIECCommand command) throws Exception {
    Assert.notNull(command, "UnAssignDpmaxFromWindContPType4bIECCommand should not be null");
    Assert.notNull(
        command.getWindContPType4bIECId(),
        "UnAssignDpmaxFromWindContPType4bIECCommand identifier should not be null");
  }
  /**
   * handles assign Tpaero validation for a WindContPType4bIEC
   *
   * @param command AssignTpaeroToWindContPType4bIECCommand
   */
  public void validate(AssignTpaeroToWindContPType4bIECCommand command) throws Exception {
    Assert.notNull(command, "AssignTpaeroToWindContPType4bIECCommand should not be null");
    Assert.notNull(
        command.getWindContPType4bIECId(),
        "AssignTpaeroToWindContPType4bIECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignTpaeroToWindContPType4bIECCommand assignment should not be null");
  }

  /**
   * handles unassign Tpaero validation for a WindContPType4bIEC
   *
   * @param command UnAssignTpaeroFromWindContPType4bIECCommand
   */
  public void validate(UnAssignTpaeroFromWindContPType4bIECCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTpaeroFromWindContPType4bIECCommand should not be null");
    Assert.notNull(
        command.getWindContPType4bIECId(),
        "UnAssignTpaeroFromWindContPType4bIECCommand identifier should not be null");
  }
  /**
   * handles assign Tpord validation for a WindContPType4bIEC
   *
   * @param command AssignTpordToWindContPType4bIECCommand
   */
  public void validate(AssignTpordToWindContPType4bIECCommand command) throws Exception {
    Assert.notNull(command, "AssignTpordToWindContPType4bIECCommand should not be null");
    Assert.notNull(
        command.getWindContPType4bIECId(),
        "AssignTpordToWindContPType4bIECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignTpordToWindContPType4bIECCommand assignment should not be null");
  }

  /**
   * handles unassign Tpord validation for a WindContPType4bIEC
   *
   * @param command UnAssignTpordFromWindContPType4bIECCommand
   */
  public void validate(UnAssignTpordFromWindContPType4bIECCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTpordFromWindContPType4bIECCommand should not be null");
    Assert.notNull(
        command.getWindContPType4bIECId(),
        "UnAssignTpordFromWindContPType4bIECCommand identifier should not be null");
  }
  /**
   * handles assign Tufilt validation for a WindContPType4bIEC
   *
   * @param command AssignTufiltToWindContPType4bIECCommand
   */
  public void validate(AssignTufiltToWindContPType4bIECCommand command) throws Exception {
    Assert.notNull(command, "AssignTufiltToWindContPType4bIECCommand should not be null");
    Assert.notNull(
        command.getWindContPType4bIECId(),
        "AssignTufiltToWindContPType4bIECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignTufiltToWindContPType4bIECCommand assignment should not be null");
  }

  /**
   * handles unassign Tufilt validation for a WindContPType4bIEC
   *
   * @param command UnAssignTufiltFromWindContPType4bIECCommand
   */
  public void validate(UnAssignTufiltFromWindContPType4bIECCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTufiltFromWindContPType4bIECCommand should not be null");
    Assert.notNull(
        command.getWindContPType4bIECId(),
        "UnAssignTufiltFromWindContPType4bIECCommand identifier should not be null");
  }
}
