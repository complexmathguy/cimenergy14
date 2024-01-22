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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.dc.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class DCShuntValidator {

  /** default constructor */
  protected DCShuntValidator() {}

  /** factory method */
  public static DCShuntValidator getInstance() {
    return new DCShuntValidator();
  }

  /** handles creation validation for a DCShunt */
  public void validate(CreateDCShuntCommand dCShunt) throws Exception {
    Assert.notNull(dCShunt, "CreateDCShuntCommand should not be null");
    //		Assert.isNull( dCShunt.getDCShuntId(), "CreateDCShuntCommand identifier should be null" );
  }

  /** handles update validation for a DCShunt */
  public void validate(UpdateDCShuntCommand dCShunt) throws Exception {
    Assert.notNull(dCShunt, "UpdateDCShuntCommand should not be null");
    Assert.notNull(dCShunt.getDCShuntId(), "UpdateDCShuntCommand identifier should not be null");
  }

  /** handles delete validation for a DCShunt */
  public void validate(DeleteDCShuntCommand dCShunt) throws Exception {
    Assert.notNull(dCShunt, "{commandAlias} should not be null");
    Assert.notNull(dCShunt.getDCShuntId(), "DeleteDCShuntCommand identifier should not be null");
  }

  /** handles fetchOne validation for a DCShunt */
  public void validate(DCShuntFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "DCShuntFetchOneSummary should not be null");
    Assert.notNull(summary.getDCShuntId(), "DCShuntFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Capacitance validation for a DCShunt
   *
   * @param command AssignCapacitanceToDCShuntCommand
   */
  public void validate(AssignCapacitanceToDCShuntCommand command) throws Exception {
    Assert.notNull(command, "AssignCapacitanceToDCShuntCommand should not be null");
    Assert.notNull(
        command.getDCShuntId(), "AssignCapacitanceToDCShuntCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignCapacitanceToDCShuntCommand assignment should not be null");
  }

  /**
   * handles unassign Capacitance validation for a DCShunt
   *
   * @param command UnAssignCapacitanceFromDCShuntCommand
   */
  public void validate(UnAssignCapacitanceFromDCShuntCommand command) throws Exception {
    Assert.notNull(command, "UnAssignCapacitanceFromDCShuntCommand should not be null");
    Assert.notNull(
        command.getDCShuntId(),
        "UnAssignCapacitanceFromDCShuntCommand identifier should not be null");
  }
  /**
   * handles assign RatedUdc validation for a DCShunt
   *
   * @param command AssignRatedUdcToDCShuntCommand
   */
  public void validate(AssignRatedUdcToDCShuntCommand command) throws Exception {
    Assert.notNull(command, "AssignRatedUdcToDCShuntCommand should not be null");
    Assert.notNull(
        command.getDCShuntId(), "AssignRatedUdcToDCShuntCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignRatedUdcToDCShuntCommand assignment should not be null");
  }

  /**
   * handles unassign RatedUdc validation for a DCShunt
   *
   * @param command UnAssignRatedUdcFromDCShuntCommand
   */
  public void validate(UnAssignRatedUdcFromDCShuntCommand command) throws Exception {
    Assert.notNull(command, "UnAssignRatedUdcFromDCShuntCommand should not be null");
    Assert.notNull(
        command.getDCShuntId(), "UnAssignRatedUdcFromDCShuntCommand identifier should not be null");
  }
  /**
   * handles assign Resistance validation for a DCShunt
   *
   * @param command AssignResistanceToDCShuntCommand
   */
  public void validate(AssignResistanceToDCShuntCommand command) throws Exception {
    Assert.notNull(command, "AssignResistanceToDCShuntCommand should not be null");
    Assert.notNull(
        command.getDCShuntId(), "AssignResistanceToDCShuntCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignResistanceToDCShuntCommand assignment should not be null");
  }

  /**
   * handles unassign Resistance validation for a DCShunt
   *
   * @param command UnAssignResistanceFromDCShuntCommand
   */
  public void validate(UnAssignResistanceFromDCShuntCommand command) throws Exception {
    Assert.notNull(command, "UnAssignResistanceFromDCShuntCommand should not be null");
    Assert.notNull(
        command.getDCShuntId(),
        "UnAssignResistanceFromDCShuntCommand identifier should not be null");
  }
}
