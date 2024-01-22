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

public class DCTerminalValidator {

  /** default constructor */
  protected DCTerminalValidator() {}

  /** factory method */
  public static DCTerminalValidator getInstance() {
    return new DCTerminalValidator();
  }

  /** handles creation validation for a DCTerminal */
  public void validate(CreateDCTerminalCommand dCTerminal) throws Exception {
    Assert.notNull(dCTerminal, "CreateDCTerminalCommand should not be null");
    //		Assert.isNull( dCTerminal.getDCTerminalId(), "CreateDCTerminalCommand identifier should be
    // null" );
  }

  /** handles update validation for a DCTerminal */
  public void validate(UpdateDCTerminalCommand dCTerminal) throws Exception {
    Assert.notNull(dCTerminal, "UpdateDCTerminalCommand should not be null");
    Assert.notNull(
        dCTerminal.getDCTerminalId(), "UpdateDCTerminalCommand identifier should not be null");
  }

  /** handles delete validation for a DCTerminal */
  public void validate(DeleteDCTerminalCommand dCTerminal) throws Exception {
    Assert.notNull(dCTerminal, "{commandAlias} should not be null");
    Assert.notNull(
        dCTerminal.getDCTerminalId(), "DeleteDCTerminalCommand identifier should not be null");
  }

  /** handles fetchOne validation for a DCTerminal */
  public void validate(DCTerminalFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "DCTerminalFetchOneSummary should not be null");
    Assert.notNull(
        summary.getDCTerminalId(), "DCTerminalFetchOneSummary identifier should not be null");
  }

  /**
   * handles add to DCTerminals validation for a DCTerminal
   *
   * @param command AssignDCTerminalsToDCTerminalCommand
   */
  public void validate(AssignDCTerminalsToDCTerminalCommand command) throws Exception {
    Assert.notNull(command, "AssignDCTerminalsToDCTerminalCommand should not be null");
    Assert.notNull(
        command.getDCTerminalId(),
        "AssignDCTerminalsToDCTerminalCommand identifier should not be null");
    Assert.notNull(
        command.getAddTo(),
        "AssignDCTerminalsToDCTerminalCommand addTo attribute should not be null");
  }

  /**
   * handles remove from DCTerminals validation for a DCTerminal
   *
   * @param command RemoveDCTerminalsFromDCTerminalCommand
   */
  public void validate(RemoveDCTerminalsFromDCTerminalCommand command) throws Exception {
    Assert.notNull(command, "RemoveDCTerminalsFromDCTerminalCommand should not be null");
    Assert.notNull(
        command.getDCTerminalId(),
        "RemoveDCTerminalsFromDCTerminalCommand identifier should not be null");
    Assert.notNull(
        command.getRemoveFrom(),
        "RemoveDCTerminalsFromDCTerminalCommand removeFrom attribute should not be null");
    Assert.notNull(
        command.getRemoveFrom().getDCTerminalId(),
        "RemoveDCTerminalsFromDCTerminalCommand removeFrom attribubte identifier should not be null");
  }
}
