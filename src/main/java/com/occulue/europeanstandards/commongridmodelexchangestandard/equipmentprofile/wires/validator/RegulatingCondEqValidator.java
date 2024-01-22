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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class RegulatingCondEqValidator {

  /** default constructor */
  protected RegulatingCondEqValidator() {}

  /** factory method */
  public static RegulatingCondEqValidator getInstance() {
    return new RegulatingCondEqValidator();
  }

  /** handles creation validation for a RegulatingCondEq */
  public void validate(CreateRegulatingCondEqCommand regulatingCondEq) throws Exception {
    Assert.notNull(regulatingCondEq, "CreateRegulatingCondEqCommand should not be null");
    //		Assert.isNull( regulatingCondEq.getRegulatingCondEqId(), "CreateRegulatingCondEqCommand
    // identifier should be null" );
  }

  /** handles update validation for a RegulatingCondEq */
  public void validate(UpdateRegulatingCondEqCommand regulatingCondEq) throws Exception {
    Assert.notNull(regulatingCondEq, "UpdateRegulatingCondEqCommand should not be null");
    Assert.notNull(
        regulatingCondEq.getRegulatingCondEqId(),
        "UpdateRegulatingCondEqCommand identifier should not be null");
  }

  /** handles delete validation for a RegulatingCondEq */
  public void validate(DeleteRegulatingCondEqCommand regulatingCondEq) throws Exception {
    Assert.notNull(regulatingCondEq, "{commandAlias} should not be null");
    Assert.notNull(
        regulatingCondEq.getRegulatingCondEqId(),
        "DeleteRegulatingCondEqCommand identifier should not be null");
  }

  /** handles fetchOne validation for a RegulatingCondEq */
  public void validate(RegulatingCondEqFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "RegulatingCondEqFetchOneSummary should not be null");
    Assert.notNull(
        summary.getRegulatingCondEqId(),
        "RegulatingCondEqFetchOneSummary identifier should not be null");
  }

  /**
   * handles add to RegulatingCondEq validation for a RegulatingCondEq
   *
   * @param command AssignRegulatingCondEqToRegulatingCondEqCommand
   */
  public void validate(AssignRegulatingCondEqToRegulatingCondEqCommand command) throws Exception {
    Assert.notNull(command, "AssignRegulatingCondEqToRegulatingCondEqCommand should not be null");
    Assert.notNull(
        command.getRegulatingCondEqId(),
        "AssignRegulatingCondEqToRegulatingCondEqCommand identifier should not be null");
    Assert.notNull(
        command.getAddTo(),
        "AssignRegulatingCondEqToRegulatingCondEqCommand addTo attribute should not be null");
  }

  /**
   * handles remove from RegulatingCondEq validation for a RegulatingCondEq
   *
   * @param command RemoveRegulatingCondEqFromRegulatingCondEqCommand
   */
  public void validate(RemoveRegulatingCondEqFromRegulatingCondEqCommand command) throws Exception {
    Assert.notNull(command, "RemoveRegulatingCondEqFromRegulatingCondEqCommand should not be null");
    Assert.notNull(
        command.getRegulatingCondEqId(),
        "RemoveRegulatingCondEqFromRegulatingCondEqCommand identifier should not be null");
    Assert.notNull(
        command.getRemoveFrom(),
        "RemoveRegulatingCondEqFromRegulatingCondEqCommand removeFrom attribute should not be null");
    Assert.notNull(
        command.getRemoveFrom().getRegulatingCondEqId(),
        "RemoveRegulatingCondEqFromRegulatingCondEqCommand removeFrom attribubte identifier should not be null");
  }
}
