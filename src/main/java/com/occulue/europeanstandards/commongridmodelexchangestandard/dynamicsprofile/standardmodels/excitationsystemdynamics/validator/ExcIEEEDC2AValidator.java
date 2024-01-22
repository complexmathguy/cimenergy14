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

public class ExcIEEEDC2AValidator {

  /** default constructor */
  protected ExcIEEEDC2AValidator() {}

  /** factory method */
  public static ExcIEEEDC2AValidator getInstance() {
    return new ExcIEEEDC2AValidator();
  }

  /** handles creation validation for a ExcIEEEDC2A */
  public void validate(CreateExcIEEEDC2ACommand excIEEEDC2A) throws Exception {
    Assert.notNull(excIEEEDC2A, "CreateExcIEEEDC2ACommand should not be null");
    //		Assert.isNull( excIEEEDC2A.getExcIEEEDC2AId(), "CreateExcIEEEDC2ACommand identifier should
    // be null" );
  }

  /** handles update validation for a ExcIEEEDC2A */
  public void validate(UpdateExcIEEEDC2ACommand excIEEEDC2A) throws Exception {
    Assert.notNull(excIEEEDC2A, "UpdateExcIEEEDC2ACommand should not be null");
    Assert.notNull(
        excIEEEDC2A.getExcIEEEDC2AId(), "UpdateExcIEEEDC2ACommand identifier should not be null");
  }

  /** handles delete validation for a ExcIEEEDC2A */
  public void validate(DeleteExcIEEEDC2ACommand excIEEEDC2A) throws Exception {
    Assert.notNull(excIEEEDC2A, "{commandAlias} should not be null");
    Assert.notNull(
        excIEEEDC2A.getExcIEEEDC2AId(), "DeleteExcIEEEDC2ACommand identifier should not be null");
  }

  /** handles fetchOne validation for a ExcIEEEDC2A */
  public void validate(ExcIEEEDC2AFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "ExcIEEEDC2AFetchOneSummary should not be null");
    Assert.notNull(
        summary.getExcIEEEDC2AId(), "ExcIEEEDC2AFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Efd1 validation for a ExcIEEEDC2A
   *
   * @param command AssignEfd1ToExcIEEEDC2ACommand
   */
  public void validate(AssignEfd1ToExcIEEEDC2ACommand command) throws Exception {
    Assert.notNull(command, "AssignEfd1ToExcIEEEDC2ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEDC2AId(), "AssignEfd1ToExcIEEEDC2ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignEfd1ToExcIEEEDC2ACommand assignment should not be null");
  }

  /**
   * handles unassign Efd1 validation for a ExcIEEEDC2A
   *
   * @param command UnAssignEfd1FromExcIEEEDC2ACommand
   */
  public void validate(UnAssignEfd1FromExcIEEEDC2ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignEfd1FromExcIEEEDC2ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEDC2AId(),
        "UnAssignEfd1FromExcIEEEDC2ACommand identifier should not be null");
  }
  /**
   * handles assign Efd2 validation for a ExcIEEEDC2A
   *
   * @param command AssignEfd2ToExcIEEEDC2ACommand
   */
  public void validate(AssignEfd2ToExcIEEEDC2ACommand command) throws Exception {
    Assert.notNull(command, "AssignEfd2ToExcIEEEDC2ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEDC2AId(), "AssignEfd2ToExcIEEEDC2ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignEfd2ToExcIEEEDC2ACommand assignment should not be null");
  }

  /**
   * handles unassign Efd2 validation for a ExcIEEEDC2A
   *
   * @param command UnAssignEfd2FromExcIEEEDC2ACommand
   */
  public void validate(UnAssignEfd2FromExcIEEEDC2ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignEfd2FromExcIEEEDC2ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEDC2AId(),
        "UnAssignEfd2FromExcIEEEDC2ACommand identifier should not be null");
  }
  /**
   * handles assign Exclim validation for a ExcIEEEDC2A
   *
   * @param command AssignExclimToExcIEEEDC2ACommand
   */
  public void validate(AssignExclimToExcIEEEDC2ACommand command) throws Exception {
    Assert.notNull(command, "AssignExclimToExcIEEEDC2ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEDC2AId(),
        "AssignExclimToExcIEEEDC2ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignExclimToExcIEEEDC2ACommand assignment should not be null");
  }

  /**
   * handles unassign Exclim validation for a ExcIEEEDC2A
   *
   * @param command UnAssignExclimFromExcIEEEDC2ACommand
   */
  public void validate(UnAssignExclimFromExcIEEEDC2ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignExclimFromExcIEEEDC2ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEDC2AId(),
        "UnAssignExclimFromExcIEEEDC2ACommand identifier should not be null");
  }
  /**
   * handles assign Ka validation for a ExcIEEEDC2A
   *
   * @param command AssignKaToExcIEEEDC2ACommand
   */
  public void validate(AssignKaToExcIEEEDC2ACommand command) throws Exception {
    Assert.notNull(command, "AssignKaToExcIEEEDC2ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEDC2AId(), "AssignKaToExcIEEEDC2ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKaToExcIEEEDC2ACommand assignment should not be null");
  }

  /**
   * handles unassign Ka validation for a ExcIEEEDC2A
   *
   * @param command UnAssignKaFromExcIEEEDC2ACommand
   */
  public void validate(UnAssignKaFromExcIEEEDC2ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignKaFromExcIEEEDC2ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEDC2AId(),
        "UnAssignKaFromExcIEEEDC2ACommand identifier should not be null");
  }
  /**
   * handles assign Ke validation for a ExcIEEEDC2A
   *
   * @param command AssignKeToExcIEEEDC2ACommand
   */
  public void validate(AssignKeToExcIEEEDC2ACommand command) throws Exception {
    Assert.notNull(command, "AssignKeToExcIEEEDC2ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEDC2AId(), "AssignKeToExcIEEEDC2ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKeToExcIEEEDC2ACommand assignment should not be null");
  }

  /**
   * handles unassign Ke validation for a ExcIEEEDC2A
   *
   * @param command UnAssignKeFromExcIEEEDC2ACommand
   */
  public void validate(UnAssignKeFromExcIEEEDC2ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignKeFromExcIEEEDC2ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEDC2AId(),
        "UnAssignKeFromExcIEEEDC2ACommand identifier should not be null");
  }
  /**
   * handles assign Kf validation for a ExcIEEEDC2A
   *
   * @param command AssignKfToExcIEEEDC2ACommand
   */
  public void validate(AssignKfToExcIEEEDC2ACommand command) throws Exception {
    Assert.notNull(command, "AssignKfToExcIEEEDC2ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEDC2AId(), "AssignKfToExcIEEEDC2ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKfToExcIEEEDC2ACommand assignment should not be null");
  }

  /**
   * handles unassign Kf validation for a ExcIEEEDC2A
   *
   * @param command UnAssignKfFromExcIEEEDC2ACommand
   */
  public void validate(UnAssignKfFromExcIEEEDC2ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignKfFromExcIEEEDC2ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEDC2AId(),
        "UnAssignKfFromExcIEEEDC2ACommand identifier should not be null");
  }
  /**
   * handles assign Seefd1 validation for a ExcIEEEDC2A
   *
   * @param command AssignSeefd1ToExcIEEEDC2ACommand
   */
  public void validate(AssignSeefd1ToExcIEEEDC2ACommand command) throws Exception {
    Assert.notNull(command, "AssignSeefd1ToExcIEEEDC2ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEDC2AId(),
        "AssignSeefd1ToExcIEEEDC2ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignSeefd1ToExcIEEEDC2ACommand assignment should not be null");
  }

  /**
   * handles unassign Seefd1 validation for a ExcIEEEDC2A
   *
   * @param command UnAssignSeefd1FromExcIEEEDC2ACommand
   */
  public void validate(UnAssignSeefd1FromExcIEEEDC2ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignSeefd1FromExcIEEEDC2ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEDC2AId(),
        "UnAssignSeefd1FromExcIEEEDC2ACommand identifier should not be null");
  }
  /**
   * handles assign Seefd2 validation for a ExcIEEEDC2A
   *
   * @param command AssignSeefd2ToExcIEEEDC2ACommand
   */
  public void validate(AssignSeefd2ToExcIEEEDC2ACommand command) throws Exception {
    Assert.notNull(command, "AssignSeefd2ToExcIEEEDC2ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEDC2AId(),
        "AssignSeefd2ToExcIEEEDC2ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignSeefd2ToExcIEEEDC2ACommand assignment should not be null");
  }

  /**
   * handles unassign Seefd2 validation for a ExcIEEEDC2A
   *
   * @param command UnAssignSeefd2FromExcIEEEDC2ACommand
   */
  public void validate(UnAssignSeefd2FromExcIEEEDC2ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignSeefd2FromExcIEEEDC2ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEDC2AId(),
        "UnAssignSeefd2FromExcIEEEDC2ACommand identifier should not be null");
  }
  /**
   * handles assign Ta validation for a ExcIEEEDC2A
   *
   * @param command AssignTaToExcIEEEDC2ACommand
   */
  public void validate(AssignTaToExcIEEEDC2ACommand command) throws Exception {
    Assert.notNull(command, "AssignTaToExcIEEEDC2ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEDC2AId(), "AssignTaToExcIEEEDC2ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTaToExcIEEEDC2ACommand assignment should not be null");
  }

  /**
   * handles unassign Ta validation for a ExcIEEEDC2A
   *
   * @param command UnAssignTaFromExcIEEEDC2ACommand
   */
  public void validate(UnAssignTaFromExcIEEEDC2ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignTaFromExcIEEEDC2ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEDC2AId(),
        "UnAssignTaFromExcIEEEDC2ACommand identifier should not be null");
  }
  /**
   * handles assign Tb validation for a ExcIEEEDC2A
   *
   * @param command AssignTbToExcIEEEDC2ACommand
   */
  public void validate(AssignTbToExcIEEEDC2ACommand command) throws Exception {
    Assert.notNull(command, "AssignTbToExcIEEEDC2ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEDC2AId(), "AssignTbToExcIEEEDC2ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTbToExcIEEEDC2ACommand assignment should not be null");
  }

  /**
   * handles unassign Tb validation for a ExcIEEEDC2A
   *
   * @param command UnAssignTbFromExcIEEEDC2ACommand
   */
  public void validate(UnAssignTbFromExcIEEEDC2ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignTbFromExcIEEEDC2ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEDC2AId(),
        "UnAssignTbFromExcIEEEDC2ACommand identifier should not be null");
  }
  /**
   * handles assign Tc validation for a ExcIEEEDC2A
   *
   * @param command AssignTcToExcIEEEDC2ACommand
   */
  public void validate(AssignTcToExcIEEEDC2ACommand command) throws Exception {
    Assert.notNull(command, "AssignTcToExcIEEEDC2ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEDC2AId(), "AssignTcToExcIEEEDC2ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTcToExcIEEEDC2ACommand assignment should not be null");
  }

  /**
   * handles unassign Tc validation for a ExcIEEEDC2A
   *
   * @param command UnAssignTcFromExcIEEEDC2ACommand
   */
  public void validate(UnAssignTcFromExcIEEEDC2ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignTcFromExcIEEEDC2ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEDC2AId(),
        "UnAssignTcFromExcIEEEDC2ACommand identifier should not be null");
  }
  /**
   * handles assign Te validation for a ExcIEEEDC2A
   *
   * @param command AssignTeToExcIEEEDC2ACommand
   */
  public void validate(AssignTeToExcIEEEDC2ACommand command) throws Exception {
    Assert.notNull(command, "AssignTeToExcIEEEDC2ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEDC2AId(), "AssignTeToExcIEEEDC2ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTeToExcIEEEDC2ACommand assignment should not be null");
  }

  /**
   * handles unassign Te validation for a ExcIEEEDC2A
   *
   * @param command UnAssignTeFromExcIEEEDC2ACommand
   */
  public void validate(UnAssignTeFromExcIEEEDC2ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignTeFromExcIEEEDC2ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEDC2AId(),
        "UnAssignTeFromExcIEEEDC2ACommand identifier should not be null");
  }
  /**
   * handles assign Tf validation for a ExcIEEEDC2A
   *
   * @param command AssignTfToExcIEEEDC2ACommand
   */
  public void validate(AssignTfToExcIEEEDC2ACommand command) throws Exception {
    Assert.notNull(command, "AssignTfToExcIEEEDC2ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEDC2AId(), "AssignTfToExcIEEEDC2ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTfToExcIEEEDC2ACommand assignment should not be null");
  }

  /**
   * handles unassign Tf validation for a ExcIEEEDC2A
   *
   * @param command UnAssignTfFromExcIEEEDC2ACommand
   */
  public void validate(UnAssignTfFromExcIEEEDC2ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignTfFromExcIEEEDC2ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEDC2AId(),
        "UnAssignTfFromExcIEEEDC2ACommand identifier should not be null");
  }
  /**
   * handles assign Uelin validation for a ExcIEEEDC2A
   *
   * @param command AssignUelinToExcIEEEDC2ACommand
   */
  public void validate(AssignUelinToExcIEEEDC2ACommand command) throws Exception {
    Assert.notNull(command, "AssignUelinToExcIEEEDC2ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEDC2AId(),
        "AssignUelinToExcIEEEDC2ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignUelinToExcIEEEDC2ACommand assignment should not be null");
  }

  /**
   * handles unassign Uelin validation for a ExcIEEEDC2A
   *
   * @param command UnAssignUelinFromExcIEEEDC2ACommand
   */
  public void validate(UnAssignUelinFromExcIEEEDC2ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignUelinFromExcIEEEDC2ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEDC2AId(),
        "UnAssignUelinFromExcIEEEDC2ACommand identifier should not be null");
  }
  /**
   * handles assign Vrmax validation for a ExcIEEEDC2A
   *
   * @param command AssignVrmaxToExcIEEEDC2ACommand
   */
  public void validate(AssignVrmaxToExcIEEEDC2ACommand command) throws Exception {
    Assert.notNull(command, "AssignVrmaxToExcIEEEDC2ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEDC2AId(),
        "AssignVrmaxToExcIEEEDC2ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVrmaxToExcIEEEDC2ACommand assignment should not be null");
  }

  /**
   * handles unassign Vrmax validation for a ExcIEEEDC2A
   *
   * @param command UnAssignVrmaxFromExcIEEEDC2ACommand
   */
  public void validate(UnAssignVrmaxFromExcIEEEDC2ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignVrmaxFromExcIEEEDC2ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEDC2AId(),
        "UnAssignVrmaxFromExcIEEEDC2ACommand identifier should not be null");
  }
  /**
   * handles assign Vrmin validation for a ExcIEEEDC2A
   *
   * @param command AssignVrminToExcIEEEDC2ACommand
   */
  public void validate(AssignVrminToExcIEEEDC2ACommand command) throws Exception {
    Assert.notNull(command, "AssignVrminToExcIEEEDC2ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEDC2AId(),
        "AssignVrminToExcIEEEDC2ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVrminToExcIEEEDC2ACommand assignment should not be null");
  }

  /**
   * handles unassign Vrmin validation for a ExcIEEEDC2A
   *
   * @param command UnAssignVrminFromExcIEEEDC2ACommand
   */
  public void validate(UnAssignVrminFromExcIEEEDC2ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignVrminFromExcIEEEDC2ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEDC2AId(),
        "UnAssignVrminFromExcIEEEDC2ACommand identifier should not be null");
  }
}
