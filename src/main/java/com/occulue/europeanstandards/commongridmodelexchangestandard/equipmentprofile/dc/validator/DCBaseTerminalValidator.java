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

public class DCBaseTerminalValidator {

  /** default constructor */
  protected DCBaseTerminalValidator() {}

  /** factory method */
  public static DCBaseTerminalValidator getInstance() {
    return new DCBaseTerminalValidator();
  }

  /** handles creation validation for a DCBaseTerminal */
  public void validate(CreateDCBaseTerminalCommand dCBaseTerminal) throws Exception {
    Assert.notNull(dCBaseTerminal, "CreateDCBaseTerminalCommand should not be null");
    //		Assert.isNull( dCBaseTerminal.getDCBaseTerminalId(), "CreateDCBaseTerminalCommand identifier
    // should be null" );
  }

  /** handles update validation for a DCBaseTerminal */
  public void validate(UpdateDCBaseTerminalCommand dCBaseTerminal) throws Exception {
    Assert.notNull(dCBaseTerminal, "UpdateDCBaseTerminalCommand should not be null");
    Assert.notNull(
        dCBaseTerminal.getDCBaseTerminalId(),
        "UpdateDCBaseTerminalCommand identifier should not be null");
  }

  /** handles delete validation for a DCBaseTerminal */
  public void validate(DeleteDCBaseTerminalCommand dCBaseTerminal) throws Exception {
    Assert.notNull(dCBaseTerminal, "{commandAlias} should not be null");
    Assert.notNull(
        dCBaseTerminal.getDCBaseTerminalId(),
        "DeleteDCBaseTerminalCommand identifier should not be null");
  }

  /** handles fetchOne validation for a DCBaseTerminal */
  public void validate(DCBaseTerminalFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "DCBaseTerminalFetchOneSummary should not be null");
    Assert.notNull(
        summary.getDCBaseTerminalId(),
        "DCBaseTerminalFetchOneSummary identifier should not be null");
  }

  /**
   * handles add to DCTerminals validation for a DCBaseTerminal
   *
   * @param command AssignDCTerminalsToDCBaseTerminalCommand
   */
  public void validate(AssignDCTerminalsToDCBaseTerminalCommand command) throws Exception {
    Assert.notNull(command, "AssignDCTerminalsToDCBaseTerminalCommand should not be null");
    Assert.notNull(
        command.getDCBaseTerminalId(),
        "AssignDCTerminalsToDCBaseTerminalCommand identifier should not be null");
    Assert.notNull(
        command.getAddTo(),
        "AssignDCTerminalsToDCBaseTerminalCommand addTo attribute should not be null");
  }

  /**
   * handles remove from DCTerminals validation for a DCBaseTerminal
   *
   * @param command RemoveDCTerminalsFromDCBaseTerminalCommand
   */
  public void validate(RemoveDCTerminalsFromDCBaseTerminalCommand command) throws Exception {
    Assert.notNull(command, "RemoveDCTerminalsFromDCBaseTerminalCommand should not be null");
    Assert.notNull(
        command.getDCBaseTerminalId(),
        "RemoveDCTerminalsFromDCBaseTerminalCommand identifier should not be null");
    Assert.notNull(
        command.getRemoveFrom(),
        "RemoveDCTerminalsFromDCBaseTerminalCommand removeFrom attribute should not be null");
    Assert.notNull(
        command.getRemoveFrom().getDCBaseTerminalId(),
        "RemoveDCTerminalsFromDCBaseTerminalCommand removeFrom attribubte identifier should not be null");
  }
}
