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

public class GroundingImpedanceValidator {

  /** default constructor */
  protected GroundingImpedanceValidator() {}

  /** factory method */
  public static GroundingImpedanceValidator getInstance() {
    return new GroundingImpedanceValidator();
  }

  /** handles creation validation for a GroundingImpedance */
  public void validate(CreateGroundingImpedanceCommand groundingImpedance) throws Exception {
    Assert.notNull(groundingImpedance, "CreateGroundingImpedanceCommand should not be null");
    //		Assert.isNull( groundingImpedance.getGroundingImpedanceId(),
    // "CreateGroundingImpedanceCommand identifier should be null" );
  }

  /** handles update validation for a GroundingImpedance */
  public void validate(UpdateGroundingImpedanceCommand groundingImpedance) throws Exception {
    Assert.notNull(groundingImpedance, "UpdateGroundingImpedanceCommand should not be null");
    Assert.notNull(
        groundingImpedance.getGroundingImpedanceId(),
        "UpdateGroundingImpedanceCommand identifier should not be null");
  }

  /** handles delete validation for a GroundingImpedance */
  public void validate(DeleteGroundingImpedanceCommand groundingImpedance) throws Exception {
    Assert.notNull(groundingImpedance, "{commandAlias} should not be null");
    Assert.notNull(
        groundingImpedance.getGroundingImpedanceId(),
        "DeleteGroundingImpedanceCommand identifier should not be null");
  }

  /** handles fetchOne validation for a GroundingImpedance */
  public void validate(GroundingImpedanceFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "GroundingImpedanceFetchOneSummary should not be null");
    Assert.notNull(
        summary.getGroundingImpedanceId(),
        "GroundingImpedanceFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign X validation for a GroundingImpedance
   *
   * @param command AssignXToGroundingImpedanceCommand
   */
  public void validate(AssignXToGroundingImpedanceCommand command) throws Exception {
    Assert.notNull(command, "AssignXToGroundingImpedanceCommand should not be null");
    Assert.notNull(
        command.getGroundingImpedanceId(),
        "AssignXToGroundingImpedanceCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignXToGroundingImpedanceCommand assignment should not be null");
  }

  /**
   * handles unassign X validation for a GroundingImpedance
   *
   * @param command UnAssignXFromGroundingImpedanceCommand
   */
  public void validate(UnAssignXFromGroundingImpedanceCommand command) throws Exception {
    Assert.notNull(command, "UnAssignXFromGroundingImpedanceCommand should not be null");
    Assert.notNull(
        command.getGroundingImpedanceId(),
        "UnAssignXFromGroundingImpedanceCommand identifier should not be null");
  }
}
