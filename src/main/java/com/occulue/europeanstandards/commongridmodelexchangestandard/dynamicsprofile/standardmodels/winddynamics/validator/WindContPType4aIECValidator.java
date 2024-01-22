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

public class WindContPType4aIECValidator {

  /** default constructor */
  protected WindContPType4aIECValidator() {}

  /** factory method */
  public static WindContPType4aIECValidator getInstance() {
    return new WindContPType4aIECValidator();
  }

  /** handles creation validation for a WindContPType4aIEC */
  public void validate(CreateWindContPType4aIECCommand windContPType4aIEC) throws Exception {
    Assert.notNull(windContPType4aIEC, "CreateWindContPType4aIECCommand should not be null");
    //		Assert.isNull( windContPType4aIEC.getWindContPType4aIECId(),
    // "CreateWindContPType4aIECCommand identifier should be null" );
  }

  /** handles update validation for a WindContPType4aIEC */
  public void validate(UpdateWindContPType4aIECCommand windContPType4aIEC) throws Exception {
    Assert.notNull(windContPType4aIEC, "UpdateWindContPType4aIECCommand should not be null");
    Assert.notNull(
        windContPType4aIEC.getWindContPType4aIECId(),
        "UpdateWindContPType4aIECCommand identifier should not be null");
  }

  /** handles delete validation for a WindContPType4aIEC */
  public void validate(DeleteWindContPType4aIECCommand windContPType4aIEC) throws Exception {
    Assert.notNull(windContPType4aIEC, "{commandAlias} should not be null");
    Assert.notNull(
        windContPType4aIEC.getWindContPType4aIECId(),
        "DeleteWindContPType4aIECCommand identifier should not be null");
  }

  /** handles fetchOne validation for a WindContPType4aIEC */
  public void validate(WindContPType4aIECFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "WindContPType4aIECFetchOneSummary should not be null");
    Assert.notNull(
        summary.getWindContPType4aIECId(),
        "WindContPType4aIECFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Dpmax validation for a WindContPType4aIEC
   *
   * @param command AssignDpmaxToWindContPType4aIECCommand
   */
  public void validate(AssignDpmaxToWindContPType4aIECCommand command) throws Exception {
    Assert.notNull(command, "AssignDpmaxToWindContPType4aIECCommand should not be null");
    Assert.notNull(
        command.getWindContPType4aIECId(),
        "AssignDpmaxToWindContPType4aIECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignDpmaxToWindContPType4aIECCommand assignment should not be null");
  }

  /**
   * handles unassign Dpmax validation for a WindContPType4aIEC
   *
   * @param command UnAssignDpmaxFromWindContPType4aIECCommand
   */
  public void validate(UnAssignDpmaxFromWindContPType4aIECCommand command) throws Exception {
    Assert.notNull(command, "UnAssignDpmaxFromWindContPType4aIECCommand should not be null");
    Assert.notNull(
        command.getWindContPType4aIECId(),
        "UnAssignDpmaxFromWindContPType4aIECCommand identifier should not be null");
  }
  /**
   * handles assign Tpord validation for a WindContPType4aIEC
   *
   * @param command AssignTpordToWindContPType4aIECCommand
   */
  public void validate(AssignTpordToWindContPType4aIECCommand command) throws Exception {
    Assert.notNull(command, "AssignTpordToWindContPType4aIECCommand should not be null");
    Assert.notNull(
        command.getWindContPType4aIECId(),
        "AssignTpordToWindContPType4aIECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignTpordToWindContPType4aIECCommand assignment should not be null");
  }

  /**
   * handles unassign Tpord validation for a WindContPType4aIEC
   *
   * @param command UnAssignTpordFromWindContPType4aIECCommand
   */
  public void validate(UnAssignTpordFromWindContPType4aIECCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTpordFromWindContPType4aIECCommand should not be null");
    Assert.notNull(
        command.getWindContPType4aIECId(),
        "UnAssignTpordFromWindContPType4aIECCommand identifier should not be null");
  }
  /**
   * handles assign Tufilt validation for a WindContPType4aIEC
   *
   * @param command AssignTufiltToWindContPType4aIECCommand
   */
  public void validate(AssignTufiltToWindContPType4aIECCommand command) throws Exception {
    Assert.notNull(command, "AssignTufiltToWindContPType4aIECCommand should not be null");
    Assert.notNull(
        command.getWindContPType4aIECId(),
        "AssignTufiltToWindContPType4aIECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignTufiltToWindContPType4aIECCommand assignment should not be null");
  }

  /**
   * handles unassign Tufilt validation for a WindContPType4aIEC
   *
   * @param command UnAssignTufiltFromWindContPType4aIECCommand
   */
  public void validate(UnAssignTufiltFromWindContPType4aIECCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTufiltFromWindContPType4aIECCommand should not be null");
    Assert.notNull(
        command.getWindContPType4aIECId(),
        "UnAssignTufiltFromWindContPType4aIECCommand identifier should not be null");
  }
}
