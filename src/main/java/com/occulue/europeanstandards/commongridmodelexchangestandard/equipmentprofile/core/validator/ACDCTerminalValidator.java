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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.core.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class ACDCTerminalValidator {

  /** default constructor */
  protected ACDCTerminalValidator() {}

  /** factory method */
  public static ACDCTerminalValidator getInstance() {
    return new ACDCTerminalValidator();
  }

  /** handles creation validation for a ACDCTerminal */
  public void validate(CreateACDCTerminalCommand aCDCTerminal) throws Exception {
    Assert.notNull(aCDCTerminal, "CreateACDCTerminalCommand should not be null");
    //		Assert.isNull( aCDCTerminal.getACDCTerminalId(), "CreateACDCTerminalCommand identifier
    // should be null" );
  }

  /** handles update validation for a ACDCTerminal */
  public void validate(UpdateACDCTerminalCommand aCDCTerminal) throws Exception {
    Assert.notNull(aCDCTerminal, "UpdateACDCTerminalCommand should not be null");
    Assert.notNull(
        aCDCTerminal.getACDCTerminalId(),
        "UpdateACDCTerminalCommand identifier should not be null");
  }

  /** handles delete validation for a ACDCTerminal */
  public void validate(DeleteACDCTerminalCommand aCDCTerminal) throws Exception {
    Assert.notNull(aCDCTerminal, "{commandAlias} should not be null");
    Assert.notNull(
        aCDCTerminal.getACDCTerminalId(),
        "DeleteACDCTerminalCommand identifier should not be null");
  }

  /** handles fetchOne validation for a ACDCTerminal */
  public void validate(ACDCTerminalFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "ACDCTerminalFetchOneSummary should not be null");
    Assert.notNull(
        summary.getACDCTerminalId(), "ACDCTerminalFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign SequenceNumber validation for a ACDCTerminal
   *
   * @param command AssignSequenceNumberToACDCTerminalCommand
   */
  public void validate(AssignSequenceNumberToACDCTerminalCommand command) throws Exception {
    Assert.notNull(command, "AssignSequenceNumberToACDCTerminalCommand should not be null");
    Assert.notNull(
        command.getACDCTerminalId(),
        "AssignSequenceNumberToACDCTerminalCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignSequenceNumberToACDCTerminalCommand assignment should not be null");
  }

  /**
   * handles unassign SequenceNumber validation for a ACDCTerminal
   *
   * @param command UnAssignSequenceNumberFromACDCTerminalCommand
   */
  public void validate(UnAssignSequenceNumberFromACDCTerminalCommand command) throws Exception {
    Assert.notNull(command, "UnAssignSequenceNumberFromACDCTerminalCommand should not be null");
    Assert.notNull(
        command.getACDCTerminalId(),
        "UnAssignSequenceNumberFromACDCTerminalCommand identifier should not be null");
  }

  /**
   * handles add to Terminal validation for a ACDCTerminal
   *
   * @param command AssignTerminalToACDCTerminalCommand
   */
  public void validate(AssignTerminalToACDCTerminalCommand command) throws Exception {
    Assert.notNull(command, "AssignTerminalToACDCTerminalCommand should not be null");
    Assert.notNull(
        command.getACDCTerminalId(),
        "AssignTerminalToACDCTerminalCommand identifier should not be null");
    Assert.notNull(
        command.getAddTo(),
        "AssignTerminalToACDCTerminalCommand addTo attribute should not be null");
  }

  /**
   * handles remove from Terminal validation for a ACDCTerminal
   *
   * @param command RemoveTerminalFromACDCTerminalCommand
   */
  public void validate(RemoveTerminalFromACDCTerminalCommand command) throws Exception {
    Assert.notNull(command, "RemoveTerminalFromACDCTerminalCommand should not be null");
    Assert.notNull(
        command.getACDCTerminalId(),
        "RemoveTerminalFromACDCTerminalCommand identifier should not be null");
    Assert.notNull(
        command.getRemoveFrom(),
        "RemoveTerminalFromACDCTerminalCommand removeFrom attribute should not be null");
    Assert.notNull(
        command.getRemoveFrom().getACDCTerminalId(),
        "RemoveTerminalFromACDCTerminalCommand removeFrom attribubte identifier should not be null");
  }
}
