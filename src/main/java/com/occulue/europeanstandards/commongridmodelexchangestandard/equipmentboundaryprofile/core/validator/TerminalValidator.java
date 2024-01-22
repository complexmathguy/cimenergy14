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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentboundaryprofile.core.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class TerminalValidator {

  /** default constructor */
  protected TerminalValidator() {}

  /** factory method */
  public static TerminalValidator getInstance() {
    return new TerminalValidator();
  }

  /** handles creation validation for a Terminal */
  public void validate(CreateTerminalCommand terminal) throws Exception {
    Assert.notNull(terminal, "CreateTerminalCommand should not be null");
    //		Assert.isNull( terminal.getTerminalId(), "CreateTerminalCommand identifier should be null"
    // );
  }

  /** handles update validation for a Terminal */
  public void validate(UpdateTerminalCommand terminal) throws Exception {
    Assert.notNull(terminal, "UpdateTerminalCommand should not be null");
    Assert.notNull(terminal.getTerminalId(), "UpdateTerminalCommand identifier should not be null");
  }

  /** handles delete validation for a Terminal */
  public void validate(DeleteTerminalCommand terminal) throws Exception {
    Assert.notNull(terminal, "{commandAlias} should not be null");
    Assert.notNull(terminal.getTerminalId(), "DeleteTerminalCommand identifier should not be null");
  }

  /** handles fetchOne validation for a Terminal */
  public void validate(TerminalFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "TerminalFetchOneSummary should not be null");
    Assert.notNull(
        summary.getTerminalId(), "TerminalFetchOneSummary identifier should not be null");
  }

  /**
   * handles add to Terminals validation for a Terminal
   *
   * @param command AssignTerminalsToTerminalCommand
   */
  public void validate(AssignTerminalsToTerminalCommand command) throws Exception {
    Assert.notNull(command, "AssignTerminalsToTerminalCommand should not be null");
    Assert.notNull(
        command.getTerminalId(), "AssignTerminalsToTerminalCommand identifier should not be null");
    Assert.notNull(
        command.getAddTo(), "AssignTerminalsToTerminalCommand addTo attribute should not be null");
  }

  /**
   * handles remove from Terminals validation for a Terminal
   *
   * @param command RemoveTerminalsFromTerminalCommand
   */
  public void validate(RemoveTerminalsFromTerminalCommand command) throws Exception {
    Assert.notNull(command, "RemoveTerminalsFromTerminalCommand should not be null");
    Assert.notNull(
        command.getTerminalId(),
        "RemoveTerminalsFromTerminalCommand identifier should not be null");
    Assert.notNull(
        command.getRemoveFrom(),
        "RemoveTerminalsFromTerminalCommand removeFrom attribute should not be null");
    Assert.notNull(
        command.getRemoveFrom().getTerminalId(),
        "RemoveTerminalsFromTerminalCommand removeFrom attribubte identifier should not be null");
  }
}
