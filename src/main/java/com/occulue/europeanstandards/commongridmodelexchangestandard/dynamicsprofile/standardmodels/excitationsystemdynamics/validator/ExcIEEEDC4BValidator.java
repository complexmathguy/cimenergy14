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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.excitationsystemdynamics.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class ExcIEEEDC4BValidator {

  /** default constructor */
  protected ExcIEEEDC4BValidator() {}

  /** factory method */
  public static ExcIEEEDC4BValidator getInstance() {
    return new ExcIEEEDC4BValidator();
  }

  /** handles creation validation for a ExcIEEEDC4B */
  public void validate(CreateExcIEEEDC4BCommand excIEEEDC4B) throws Exception {
    Assert.notNull(excIEEEDC4B, "CreateExcIEEEDC4BCommand should not be null");
    //		Assert.isNull( excIEEEDC4B.getExcIEEEDC4BId(), "CreateExcIEEEDC4BCommand identifier should
    // be null" );
  }

  /** handles update validation for a ExcIEEEDC4B */
  public void validate(UpdateExcIEEEDC4BCommand excIEEEDC4B) throws Exception {
    Assert.notNull(excIEEEDC4B, "UpdateExcIEEEDC4BCommand should not be null");
    Assert.notNull(
        excIEEEDC4B.getExcIEEEDC4BId(), "UpdateExcIEEEDC4BCommand identifier should not be null");
  }

  /** handles delete validation for a ExcIEEEDC4B */
  public void validate(DeleteExcIEEEDC4BCommand excIEEEDC4B) throws Exception {
    Assert.notNull(excIEEEDC4B, "{commandAlias} should not be null");
    Assert.notNull(
        excIEEEDC4B.getExcIEEEDC4BId(), "DeleteExcIEEEDC4BCommand identifier should not be null");
  }

  /** handles fetchOne validation for a ExcIEEEDC4B */
  public void validate(ExcIEEEDC4BFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "ExcIEEEDC4BFetchOneSummary should not be null");
    Assert.notNull(
        summary.getExcIEEEDC4BId(), "ExcIEEEDC4BFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Efd1 validation for a ExcIEEEDC4B
   *
   * @param command AssignEfd1ToExcIEEEDC4BCommand
   */
  public void validate(AssignEfd1ToExcIEEEDC4BCommand command) throws Exception {
    Assert.notNull(command, "AssignEfd1ToExcIEEEDC4BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEDC4BId(), "AssignEfd1ToExcIEEEDC4BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignEfd1ToExcIEEEDC4BCommand assignment should not be null");
  }

  /**
   * handles unassign Efd1 validation for a ExcIEEEDC4B
   *
   * @param command UnAssignEfd1FromExcIEEEDC4BCommand
   */
  public void validate(UnAssignEfd1FromExcIEEEDC4BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignEfd1FromExcIEEEDC4BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEDC4BId(),
        "UnAssignEfd1FromExcIEEEDC4BCommand identifier should not be null");
  }
  /**
   * handles assign Efd2 validation for a ExcIEEEDC4B
   *
   * @param command AssignEfd2ToExcIEEEDC4BCommand
   */
  public void validate(AssignEfd2ToExcIEEEDC4BCommand command) throws Exception {
    Assert.notNull(command, "AssignEfd2ToExcIEEEDC4BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEDC4BId(), "AssignEfd2ToExcIEEEDC4BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignEfd2ToExcIEEEDC4BCommand assignment should not be null");
  }

  /**
   * handles unassign Efd2 validation for a ExcIEEEDC4B
   *
   * @param command UnAssignEfd2FromExcIEEEDC4BCommand
   */
  public void validate(UnAssignEfd2FromExcIEEEDC4BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignEfd2FromExcIEEEDC4BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEDC4BId(),
        "UnAssignEfd2FromExcIEEEDC4BCommand identifier should not be null");
  }
  /**
   * handles assign Ka validation for a ExcIEEEDC4B
   *
   * @param command AssignKaToExcIEEEDC4BCommand
   */
  public void validate(AssignKaToExcIEEEDC4BCommand command) throws Exception {
    Assert.notNull(command, "AssignKaToExcIEEEDC4BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEDC4BId(), "AssignKaToExcIEEEDC4BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKaToExcIEEEDC4BCommand assignment should not be null");
  }

  /**
   * handles unassign Ka validation for a ExcIEEEDC4B
   *
   * @param command UnAssignKaFromExcIEEEDC4BCommand
   */
  public void validate(UnAssignKaFromExcIEEEDC4BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKaFromExcIEEEDC4BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEDC4BId(),
        "UnAssignKaFromExcIEEEDC4BCommand identifier should not be null");
  }
  /**
   * handles assign Kd validation for a ExcIEEEDC4B
   *
   * @param command AssignKdToExcIEEEDC4BCommand
   */
  public void validate(AssignKdToExcIEEEDC4BCommand command) throws Exception {
    Assert.notNull(command, "AssignKdToExcIEEEDC4BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEDC4BId(), "AssignKdToExcIEEEDC4BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKdToExcIEEEDC4BCommand assignment should not be null");
  }

  /**
   * handles unassign Kd validation for a ExcIEEEDC4B
   *
   * @param command UnAssignKdFromExcIEEEDC4BCommand
   */
  public void validate(UnAssignKdFromExcIEEEDC4BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKdFromExcIEEEDC4BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEDC4BId(),
        "UnAssignKdFromExcIEEEDC4BCommand identifier should not be null");
  }
  /**
   * handles assign Ke validation for a ExcIEEEDC4B
   *
   * @param command AssignKeToExcIEEEDC4BCommand
   */
  public void validate(AssignKeToExcIEEEDC4BCommand command) throws Exception {
    Assert.notNull(command, "AssignKeToExcIEEEDC4BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEDC4BId(), "AssignKeToExcIEEEDC4BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKeToExcIEEEDC4BCommand assignment should not be null");
  }

  /**
   * handles unassign Ke validation for a ExcIEEEDC4B
   *
   * @param command UnAssignKeFromExcIEEEDC4BCommand
   */
  public void validate(UnAssignKeFromExcIEEEDC4BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKeFromExcIEEEDC4BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEDC4BId(),
        "UnAssignKeFromExcIEEEDC4BCommand identifier should not be null");
  }
  /**
   * handles assign Kf validation for a ExcIEEEDC4B
   *
   * @param command AssignKfToExcIEEEDC4BCommand
   */
  public void validate(AssignKfToExcIEEEDC4BCommand command) throws Exception {
    Assert.notNull(command, "AssignKfToExcIEEEDC4BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEDC4BId(), "AssignKfToExcIEEEDC4BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKfToExcIEEEDC4BCommand assignment should not be null");
  }

  /**
   * handles unassign Kf validation for a ExcIEEEDC4B
   *
   * @param command UnAssignKfFromExcIEEEDC4BCommand
   */
  public void validate(UnAssignKfFromExcIEEEDC4BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKfFromExcIEEEDC4BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEDC4BId(),
        "UnAssignKfFromExcIEEEDC4BCommand identifier should not be null");
  }
  /**
   * handles assign Ki validation for a ExcIEEEDC4B
   *
   * @param command AssignKiToExcIEEEDC4BCommand
   */
  public void validate(AssignKiToExcIEEEDC4BCommand command) throws Exception {
    Assert.notNull(command, "AssignKiToExcIEEEDC4BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEDC4BId(), "AssignKiToExcIEEEDC4BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKiToExcIEEEDC4BCommand assignment should not be null");
  }

  /**
   * handles unassign Ki validation for a ExcIEEEDC4B
   *
   * @param command UnAssignKiFromExcIEEEDC4BCommand
   */
  public void validate(UnAssignKiFromExcIEEEDC4BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKiFromExcIEEEDC4BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEDC4BId(),
        "UnAssignKiFromExcIEEEDC4BCommand identifier should not be null");
  }
  /**
   * handles assign Kp validation for a ExcIEEEDC4B
   *
   * @param command AssignKpToExcIEEEDC4BCommand
   */
  public void validate(AssignKpToExcIEEEDC4BCommand command) throws Exception {
    Assert.notNull(command, "AssignKpToExcIEEEDC4BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEDC4BId(), "AssignKpToExcIEEEDC4BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKpToExcIEEEDC4BCommand assignment should not be null");
  }

  /**
   * handles unassign Kp validation for a ExcIEEEDC4B
   *
   * @param command UnAssignKpFromExcIEEEDC4BCommand
   */
  public void validate(UnAssignKpFromExcIEEEDC4BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKpFromExcIEEEDC4BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEDC4BId(),
        "UnAssignKpFromExcIEEEDC4BCommand identifier should not be null");
  }
  /**
   * handles assign Oelin validation for a ExcIEEEDC4B
   *
   * @param command AssignOelinToExcIEEEDC4BCommand
   */
  public void validate(AssignOelinToExcIEEEDC4BCommand command) throws Exception {
    Assert.notNull(command, "AssignOelinToExcIEEEDC4BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEDC4BId(),
        "AssignOelinToExcIEEEDC4BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignOelinToExcIEEEDC4BCommand assignment should not be null");
  }

  /**
   * handles unassign Oelin validation for a ExcIEEEDC4B
   *
   * @param command UnAssignOelinFromExcIEEEDC4BCommand
   */
  public void validate(UnAssignOelinFromExcIEEEDC4BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignOelinFromExcIEEEDC4BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEDC4BId(),
        "UnAssignOelinFromExcIEEEDC4BCommand identifier should not be null");
  }
  /**
   * handles assign Seefd1 validation for a ExcIEEEDC4B
   *
   * @param command AssignSeefd1ToExcIEEEDC4BCommand
   */
  public void validate(AssignSeefd1ToExcIEEEDC4BCommand command) throws Exception {
    Assert.notNull(command, "AssignSeefd1ToExcIEEEDC4BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEDC4BId(),
        "AssignSeefd1ToExcIEEEDC4BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignSeefd1ToExcIEEEDC4BCommand assignment should not be null");
  }

  /**
   * handles unassign Seefd1 validation for a ExcIEEEDC4B
   *
   * @param command UnAssignSeefd1FromExcIEEEDC4BCommand
   */
  public void validate(UnAssignSeefd1FromExcIEEEDC4BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignSeefd1FromExcIEEEDC4BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEDC4BId(),
        "UnAssignSeefd1FromExcIEEEDC4BCommand identifier should not be null");
  }
  /**
   * handles assign Seefd2 validation for a ExcIEEEDC4B
   *
   * @param command AssignSeefd2ToExcIEEEDC4BCommand
   */
  public void validate(AssignSeefd2ToExcIEEEDC4BCommand command) throws Exception {
    Assert.notNull(command, "AssignSeefd2ToExcIEEEDC4BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEDC4BId(),
        "AssignSeefd2ToExcIEEEDC4BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignSeefd2ToExcIEEEDC4BCommand assignment should not be null");
  }

  /**
   * handles unassign Seefd2 validation for a ExcIEEEDC4B
   *
   * @param command UnAssignSeefd2FromExcIEEEDC4BCommand
   */
  public void validate(UnAssignSeefd2FromExcIEEEDC4BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignSeefd2FromExcIEEEDC4BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEDC4BId(),
        "UnAssignSeefd2FromExcIEEEDC4BCommand identifier should not be null");
  }
  /**
   * handles assign Ta validation for a ExcIEEEDC4B
   *
   * @param command AssignTaToExcIEEEDC4BCommand
   */
  public void validate(AssignTaToExcIEEEDC4BCommand command) throws Exception {
    Assert.notNull(command, "AssignTaToExcIEEEDC4BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEDC4BId(), "AssignTaToExcIEEEDC4BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTaToExcIEEEDC4BCommand assignment should not be null");
  }

  /**
   * handles unassign Ta validation for a ExcIEEEDC4B
   *
   * @param command UnAssignTaFromExcIEEEDC4BCommand
   */
  public void validate(UnAssignTaFromExcIEEEDC4BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTaFromExcIEEEDC4BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEDC4BId(),
        "UnAssignTaFromExcIEEEDC4BCommand identifier should not be null");
  }
  /**
   * handles assign Td validation for a ExcIEEEDC4B
   *
   * @param command AssignTdToExcIEEEDC4BCommand
   */
  public void validate(AssignTdToExcIEEEDC4BCommand command) throws Exception {
    Assert.notNull(command, "AssignTdToExcIEEEDC4BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEDC4BId(), "AssignTdToExcIEEEDC4BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTdToExcIEEEDC4BCommand assignment should not be null");
  }

  /**
   * handles unassign Td validation for a ExcIEEEDC4B
   *
   * @param command UnAssignTdFromExcIEEEDC4BCommand
   */
  public void validate(UnAssignTdFromExcIEEEDC4BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTdFromExcIEEEDC4BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEDC4BId(),
        "UnAssignTdFromExcIEEEDC4BCommand identifier should not be null");
  }
  /**
   * handles assign Te validation for a ExcIEEEDC4B
   *
   * @param command AssignTeToExcIEEEDC4BCommand
   */
  public void validate(AssignTeToExcIEEEDC4BCommand command) throws Exception {
    Assert.notNull(command, "AssignTeToExcIEEEDC4BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEDC4BId(), "AssignTeToExcIEEEDC4BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTeToExcIEEEDC4BCommand assignment should not be null");
  }

  /**
   * handles unassign Te validation for a ExcIEEEDC4B
   *
   * @param command UnAssignTeFromExcIEEEDC4BCommand
   */
  public void validate(UnAssignTeFromExcIEEEDC4BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTeFromExcIEEEDC4BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEDC4BId(),
        "UnAssignTeFromExcIEEEDC4BCommand identifier should not be null");
  }
  /**
   * handles assign Tf validation for a ExcIEEEDC4B
   *
   * @param command AssignTfToExcIEEEDC4BCommand
   */
  public void validate(AssignTfToExcIEEEDC4BCommand command) throws Exception {
    Assert.notNull(command, "AssignTfToExcIEEEDC4BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEDC4BId(), "AssignTfToExcIEEEDC4BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTfToExcIEEEDC4BCommand assignment should not be null");
  }

  /**
   * handles unassign Tf validation for a ExcIEEEDC4B
   *
   * @param command UnAssignTfFromExcIEEEDC4BCommand
   */
  public void validate(UnAssignTfFromExcIEEEDC4BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTfFromExcIEEEDC4BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEDC4BId(),
        "UnAssignTfFromExcIEEEDC4BCommand identifier should not be null");
  }
  /**
   * handles assign Uelin validation for a ExcIEEEDC4B
   *
   * @param command AssignUelinToExcIEEEDC4BCommand
   */
  public void validate(AssignUelinToExcIEEEDC4BCommand command) throws Exception {
    Assert.notNull(command, "AssignUelinToExcIEEEDC4BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEDC4BId(),
        "AssignUelinToExcIEEEDC4BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignUelinToExcIEEEDC4BCommand assignment should not be null");
  }

  /**
   * handles unassign Uelin validation for a ExcIEEEDC4B
   *
   * @param command UnAssignUelinFromExcIEEEDC4BCommand
   */
  public void validate(UnAssignUelinFromExcIEEEDC4BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignUelinFromExcIEEEDC4BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEDC4BId(),
        "UnAssignUelinFromExcIEEEDC4BCommand identifier should not be null");
  }
  /**
   * handles assign Vemin validation for a ExcIEEEDC4B
   *
   * @param command AssignVeminToExcIEEEDC4BCommand
   */
  public void validate(AssignVeminToExcIEEEDC4BCommand command) throws Exception {
    Assert.notNull(command, "AssignVeminToExcIEEEDC4BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEDC4BId(),
        "AssignVeminToExcIEEEDC4BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVeminToExcIEEEDC4BCommand assignment should not be null");
  }

  /**
   * handles unassign Vemin validation for a ExcIEEEDC4B
   *
   * @param command UnAssignVeminFromExcIEEEDC4BCommand
   */
  public void validate(UnAssignVeminFromExcIEEEDC4BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignVeminFromExcIEEEDC4BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEDC4BId(),
        "UnAssignVeminFromExcIEEEDC4BCommand identifier should not be null");
  }
  /**
   * handles assign Vrmax validation for a ExcIEEEDC4B
   *
   * @param command AssignVrmaxToExcIEEEDC4BCommand
   */
  public void validate(AssignVrmaxToExcIEEEDC4BCommand command) throws Exception {
    Assert.notNull(command, "AssignVrmaxToExcIEEEDC4BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEDC4BId(),
        "AssignVrmaxToExcIEEEDC4BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVrmaxToExcIEEEDC4BCommand assignment should not be null");
  }

  /**
   * handles unassign Vrmax validation for a ExcIEEEDC4B
   *
   * @param command UnAssignVrmaxFromExcIEEEDC4BCommand
   */
  public void validate(UnAssignVrmaxFromExcIEEEDC4BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignVrmaxFromExcIEEEDC4BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEDC4BId(),
        "UnAssignVrmaxFromExcIEEEDC4BCommand identifier should not be null");
  }
  /**
   * handles assign Vrmin validation for a ExcIEEEDC4B
   *
   * @param command AssignVrminToExcIEEEDC4BCommand
   */
  public void validate(AssignVrminToExcIEEEDC4BCommand command) throws Exception {
    Assert.notNull(command, "AssignVrminToExcIEEEDC4BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEDC4BId(),
        "AssignVrminToExcIEEEDC4BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVrminToExcIEEEDC4BCommand assignment should not be null");
  }

  /**
   * handles unassign Vrmin validation for a ExcIEEEDC4B
   *
   * @param command UnAssignVrminFromExcIEEEDC4BCommand
   */
  public void validate(UnAssignVrminFromExcIEEEDC4BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignVrminFromExcIEEEDC4BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEDC4BId(),
        "UnAssignVrminFromExcIEEEDC4BCommand identifier should not be null");
  }
}
