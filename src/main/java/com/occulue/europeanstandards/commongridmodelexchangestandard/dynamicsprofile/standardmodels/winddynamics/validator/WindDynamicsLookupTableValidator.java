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

public class WindDynamicsLookupTableValidator {

  /** default constructor */
  protected WindDynamicsLookupTableValidator() {}

  /** factory method */
  public static WindDynamicsLookupTableValidator getInstance() {
    return new WindDynamicsLookupTableValidator();
  }

  /** handles creation validation for a WindDynamicsLookupTable */
  public void validate(CreateWindDynamicsLookupTableCommand windDynamicsLookupTable)
      throws Exception {
    Assert.notNull(
        windDynamicsLookupTable, "CreateWindDynamicsLookupTableCommand should not be null");
    //		Assert.isNull( windDynamicsLookupTable.getWindDynamicsLookupTableId(),
    // "CreateWindDynamicsLookupTableCommand identifier should be null" );
  }

  /** handles update validation for a WindDynamicsLookupTable */
  public void validate(UpdateWindDynamicsLookupTableCommand windDynamicsLookupTable)
      throws Exception {
    Assert.notNull(
        windDynamicsLookupTable, "UpdateWindDynamicsLookupTableCommand should not be null");
    Assert.notNull(
        windDynamicsLookupTable.getWindDynamicsLookupTableId(),
        "UpdateWindDynamicsLookupTableCommand identifier should not be null");
  }

  /** handles delete validation for a WindDynamicsLookupTable */
  public void validate(DeleteWindDynamicsLookupTableCommand windDynamicsLookupTable)
      throws Exception {
    Assert.notNull(windDynamicsLookupTable, "{commandAlias} should not be null");
    Assert.notNull(
        windDynamicsLookupTable.getWindDynamicsLookupTableId(),
        "DeleteWindDynamicsLookupTableCommand identifier should not be null");
  }

  /** handles fetchOne validation for a WindDynamicsLookupTable */
  public void validate(WindDynamicsLookupTableFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "WindDynamicsLookupTableFetchOneSummary should not be null");
    Assert.notNull(
        summary.getWindDynamicsLookupTableId(),
        "WindDynamicsLookupTableFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Input validation for a WindDynamicsLookupTable
   *
   * @param command AssignInputToWindDynamicsLookupTableCommand
   */
  public void validate(AssignInputToWindDynamicsLookupTableCommand command) throws Exception {
    Assert.notNull(command, "AssignInputToWindDynamicsLookupTableCommand should not be null");
    Assert.notNull(
        command.getWindDynamicsLookupTableId(),
        "AssignInputToWindDynamicsLookupTableCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignInputToWindDynamicsLookupTableCommand assignment should not be null");
  }

  /**
   * handles unassign Input validation for a WindDynamicsLookupTable
   *
   * @param command UnAssignInputFromWindDynamicsLookupTableCommand
   */
  public void validate(UnAssignInputFromWindDynamicsLookupTableCommand command) throws Exception {
    Assert.notNull(command, "UnAssignInputFromWindDynamicsLookupTableCommand should not be null");
    Assert.notNull(
        command.getWindDynamicsLookupTableId(),
        "UnAssignInputFromWindDynamicsLookupTableCommand identifier should not be null");
  }
  /**
   * handles assign Output validation for a WindDynamicsLookupTable
   *
   * @param command AssignOutputToWindDynamicsLookupTableCommand
   */
  public void validate(AssignOutputToWindDynamicsLookupTableCommand command) throws Exception {
    Assert.notNull(command, "AssignOutputToWindDynamicsLookupTableCommand should not be null");
    Assert.notNull(
        command.getWindDynamicsLookupTableId(),
        "AssignOutputToWindDynamicsLookupTableCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignOutputToWindDynamicsLookupTableCommand assignment should not be null");
  }

  /**
   * handles unassign Output validation for a WindDynamicsLookupTable
   *
   * @param command UnAssignOutputFromWindDynamicsLookupTableCommand
   */
  public void validate(UnAssignOutputFromWindDynamicsLookupTableCommand command) throws Exception {
    Assert.notNull(command, "UnAssignOutputFromWindDynamicsLookupTableCommand should not be null");
    Assert.notNull(
        command.getWindDynamicsLookupTableId(),
        "UnAssignOutputFromWindDynamicsLookupTableCommand identifier should not be null");
  }
  /**
   * handles assign Sequence validation for a WindDynamicsLookupTable
   *
   * @param command AssignSequenceToWindDynamicsLookupTableCommand
   */
  public void validate(AssignSequenceToWindDynamicsLookupTableCommand command) throws Exception {
    Assert.notNull(command, "AssignSequenceToWindDynamicsLookupTableCommand should not be null");
    Assert.notNull(
        command.getWindDynamicsLookupTableId(),
        "AssignSequenceToWindDynamicsLookupTableCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignSequenceToWindDynamicsLookupTableCommand assignment should not be null");
  }

  /**
   * handles unassign Sequence validation for a WindDynamicsLookupTable
   *
   * @param command UnAssignSequenceFromWindDynamicsLookupTableCommand
   */
  public void validate(UnAssignSequenceFromWindDynamicsLookupTableCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignSequenceFromWindDynamicsLookupTableCommand should not be null");
    Assert.notNull(
        command.getWindDynamicsLookupTableId(),
        "UnAssignSequenceFromWindDynamicsLookupTableCommand identifier should not be null");
  }

  /**
   * handles add to WindDynamicsLookupTable validation for a WindDynamicsLookupTable
   *
   * @param command AssignWindDynamicsLookupTableToWindDynamicsLookupTableCommand
   */
  public void validate(AssignWindDynamicsLookupTableToWindDynamicsLookupTableCommand command)
      throws Exception {
    Assert.notNull(
        command,
        "AssignWindDynamicsLookupTableToWindDynamicsLookupTableCommand should not be null");
    Assert.notNull(
        command.getWindDynamicsLookupTableId(),
        "AssignWindDynamicsLookupTableToWindDynamicsLookupTableCommand identifier should not be null");
    Assert.notNull(
        command.getAddTo(),
        "AssignWindDynamicsLookupTableToWindDynamicsLookupTableCommand addTo attribute should not be null");
  }

  /**
   * handles remove from WindDynamicsLookupTable validation for a WindDynamicsLookupTable
   *
   * @param command RemoveWindDynamicsLookupTableFromWindDynamicsLookupTableCommand
   */
  public void validate(RemoveWindDynamicsLookupTableFromWindDynamicsLookupTableCommand command)
      throws Exception {
    Assert.notNull(
        command,
        "RemoveWindDynamicsLookupTableFromWindDynamicsLookupTableCommand should not be null");
    Assert.notNull(
        command.getWindDynamicsLookupTableId(),
        "RemoveWindDynamicsLookupTableFromWindDynamicsLookupTableCommand identifier should not be null");
    Assert.notNull(
        command.getRemoveFrom(),
        "RemoveWindDynamicsLookupTableFromWindDynamicsLookupTableCommand removeFrom attribute should not be null");
    Assert.notNull(
        command.getRemoveFrom().getWindDynamicsLookupTableId(),
        "RemoveWindDynamicsLookupTableFromWindDynamicsLookupTableCommand removeFrom attribubte identifier should not be null");
  }
}
