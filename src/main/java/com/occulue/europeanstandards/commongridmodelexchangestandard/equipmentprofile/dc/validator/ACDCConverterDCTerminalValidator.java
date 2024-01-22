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

public class ACDCConverterDCTerminalValidator {

  /** default constructor */
  protected ACDCConverterDCTerminalValidator() {}

  /** factory method */
  public static ACDCConverterDCTerminalValidator getInstance() {
    return new ACDCConverterDCTerminalValidator();
  }

  /** handles creation validation for a ACDCConverterDCTerminal */
  public void validate(CreateACDCConverterDCTerminalCommand aCDCConverterDCTerminal)
      throws Exception {
    Assert.notNull(
        aCDCConverterDCTerminal, "CreateACDCConverterDCTerminalCommand should not be null");
    //		Assert.isNull( aCDCConverterDCTerminal.getACDCConverterDCTerminalId(),
    // "CreateACDCConverterDCTerminalCommand identifier should be null" );
  }

  /** handles update validation for a ACDCConverterDCTerminal */
  public void validate(UpdateACDCConverterDCTerminalCommand aCDCConverterDCTerminal)
      throws Exception {
    Assert.notNull(
        aCDCConverterDCTerminal, "UpdateACDCConverterDCTerminalCommand should not be null");
    Assert.notNull(
        aCDCConverterDCTerminal.getACDCConverterDCTerminalId(),
        "UpdateACDCConverterDCTerminalCommand identifier should not be null");
  }

  /** handles delete validation for a ACDCConverterDCTerminal */
  public void validate(DeleteACDCConverterDCTerminalCommand aCDCConverterDCTerminal)
      throws Exception {
    Assert.notNull(aCDCConverterDCTerminal, "{commandAlias} should not be null");
    Assert.notNull(
        aCDCConverterDCTerminal.getACDCConverterDCTerminalId(),
        "DeleteACDCConverterDCTerminalCommand identifier should not be null");
  }

  /** handles fetchOne validation for a ACDCConverterDCTerminal */
  public void validate(ACDCConverterDCTerminalFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "ACDCConverterDCTerminalFetchOneSummary should not be null");
    Assert.notNull(
        summary.getACDCConverterDCTerminalId(),
        "ACDCConverterDCTerminalFetchOneSummary identifier should not be null");
  }

  /**
   * handles add to DCTerminals validation for a ACDCConverterDCTerminal
   *
   * @param command AssignDCTerminalsToACDCConverterDCTerminalCommand
   */
  public void validate(AssignDCTerminalsToACDCConverterDCTerminalCommand command) throws Exception {
    Assert.notNull(command, "AssignDCTerminalsToACDCConverterDCTerminalCommand should not be null");
    Assert.notNull(
        command.getACDCConverterDCTerminalId(),
        "AssignDCTerminalsToACDCConverterDCTerminalCommand identifier should not be null");
    Assert.notNull(
        command.getAddTo(),
        "AssignDCTerminalsToACDCConverterDCTerminalCommand addTo attribute should not be null");
  }

  /**
   * handles remove from DCTerminals validation for a ACDCConverterDCTerminal
   *
   * @param command RemoveDCTerminalsFromACDCConverterDCTerminalCommand
   */
  public void validate(RemoveDCTerminalsFromACDCConverterDCTerminalCommand command)
      throws Exception {
    Assert.notNull(
        command, "RemoveDCTerminalsFromACDCConverterDCTerminalCommand should not be null");
    Assert.notNull(
        command.getACDCConverterDCTerminalId(),
        "RemoveDCTerminalsFromACDCConverterDCTerminalCommand identifier should not be null");
    Assert.notNull(
        command.getRemoveFrom(),
        "RemoveDCTerminalsFromACDCConverterDCTerminalCommand removeFrom attribute should not be null");
    Assert.notNull(
        command.getRemoveFrom().getACDCConverterDCTerminalId(),
        "RemoveDCTerminalsFromACDCConverterDCTerminalCommand removeFrom attribubte identifier should not be null");
  }
}
