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

public class WindGenType4IECValidator {

  /** default constructor */
  protected WindGenType4IECValidator() {}

  /** factory method */
  public static WindGenType4IECValidator getInstance() {
    return new WindGenType4IECValidator();
  }

  /** handles creation validation for a WindGenType4IEC */
  public void validate(CreateWindGenType4IECCommand windGenType4IEC) throws Exception {
    Assert.notNull(windGenType4IEC, "CreateWindGenType4IECCommand should not be null");
    //		Assert.isNull( windGenType4IEC.getWindGenType4IECId(), "CreateWindGenType4IECCommand
    // identifier should be null" );
  }

  /** handles update validation for a WindGenType4IEC */
  public void validate(UpdateWindGenType4IECCommand windGenType4IEC) throws Exception {
    Assert.notNull(windGenType4IEC, "UpdateWindGenType4IECCommand should not be null");
    Assert.notNull(
        windGenType4IEC.getWindGenType4IECId(),
        "UpdateWindGenType4IECCommand identifier should not be null");
  }

  /** handles delete validation for a WindGenType4IEC */
  public void validate(DeleteWindGenType4IECCommand windGenType4IEC) throws Exception {
    Assert.notNull(windGenType4IEC, "{commandAlias} should not be null");
    Assert.notNull(
        windGenType4IEC.getWindGenType4IECId(),
        "DeleteWindGenType4IECCommand identifier should not be null");
  }

  /** handles fetchOne validation for a WindGenType4IEC */
  public void validate(WindGenType4IECFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "WindGenType4IECFetchOneSummary should not be null");
    Assert.notNull(
        summary.getWindGenType4IECId(),
        "WindGenType4IECFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Dipmax validation for a WindGenType4IEC
   *
   * @param command AssignDipmaxToWindGenType4IECCommand
   */
  public void validate(AssignDipmaxToWindGenType4IECCommand command) throws Exception {
    Assert.notNull(command, "AssignDipmaxToWindGenType4IECCommand should not be null");
    Assert.notNull(
        command.getWindGenType4IECId(),
        "AssignDipmaxToWindGenType4IECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignDipmaxToWindGenType4IECCommand assignment should not be null");
  }

  /**
   * handles unassign Dipmax validation for a WindGenType4IEC
   *
   * @param command UnAssignDipmaxFromWindGenType4IECCommand
   */
  public void validate(UnAssignDipmaxFromWindGenType4IECCommand command) throws Exception {
    Assert.notNull(command, "UnAssignDipmaxFromWindGenType4IECCommand should not be null");
    Assert.notNull(
        command.getWindGenType4IECId(),
        "UnAssignDipmaxFromWindGenType4IECCommand identifier should not be null");
  }
  /**
   * handles assign Diqmax validation for a WindGenType4IEC
   *
   * @param command AssignDiqmaxToWindGenType4IECCommand
   */
  public void validate(AssignDiqmaxToWindGenType4IECCommand command) throws Exception {
    Assert.notNull(command, "AssignDiqmaxToWindGenType4IECCommand should not be null");
    Assert.notNull(
        command.getWindGenType4IECId(),
        "AssignDiqmaxToWindGenType4IECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignDiqmaxToWindGenType4IECCommand assignment should not be null");
  }

  /**
   * handles unassign Diqmax validation for a WindGenType4IEC
   *
   * @param command UnAssignDiqmaxFromWindGenType4IECCommand
   */
  public void validate(UnAssignDiqmaxFromWindGenType4IECCommand command) throws Exception {
    Assert.notNull(command, "UnAssignDiqmaxFromWindGenType4IECCommand should not be null");
    Assert.notNull(
        command.getWindGenType4IECId(),
        "UnAssignDiqmaxFromWindGenType4IECCommand identifier should not be null");
  }
  /**
   * handles assign Diqmin validation for a WindGenType4IEC
   *
   * @param command AssignDiqminToWindGenType4IECCommand
   */
  public void validate(AssignDiqminToWindGenType4IECCommand command) throws Exception {
    Assert.notNull(command, "AssignDiqminToWindGenType4IECCommand should not be null");
    Assert.notNull(
        command.getWindGenType4IECId(),
        "AssignDiqminToWindGenType4IECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignDiqminToWindGenType4IECCommand assignment should not be null");
  }

  /**
   * handles unassign Diqmin validation for a WindGenType4IEC
   *
   * @param command UnAssignDiqminFromWindGenType4IECCommand
   */
  public void validate(UnAssignDiqminFromWindGenType4IECCommand command) throws Exception {
    Assert.notNull(command, "UnAssignDiqminFromWindGenType4IECCommand should not be null");
    Assert.notNull(
        command.getWindGenType4IECId(),
        "UnAssignDiqminFromWindGenType4IECCommand identifier should not be null");
  }
  /**
   * handles assign Tg validation for a WindGenType4IEC
   *
   * @param command AssignTgToWindGenType4IECCommand
   */
  public void validate(AssignTgToWindGenType4IECCommand command) throws Exception {
    Assert.notNull(command, "AssignTgToWindGenType4IECCommand should not be null");
    Assert.notNull(
        command.getWindGenType4IECId(),
        "AssignTgToWindGenType4IECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTgToWindGenType4IECCommand assignment should not be null");
  }

  /**
   * handles unassign Tg validation for a WindGenType4IEC
   *
   * @param command UnAssignTgFromWindGenType4IECCommand
   */
  public void validate(UnAssignTgFromWindGenType4IECCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTgFromWindGenType4IECCommand should not be null");
    Assert.notNull(
        command.getWindGenType4IECId(),
        "UnAssignTgFromWindGenType4IECCommand identifier should not be null");
  }
}
