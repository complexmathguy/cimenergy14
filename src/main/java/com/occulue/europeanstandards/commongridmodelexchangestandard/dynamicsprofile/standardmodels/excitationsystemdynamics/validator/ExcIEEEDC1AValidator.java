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

public class ExcIEEEDC1AValidator {

  /** default constructor */
  protected ExcIEEEDC1AValidator() {}

  /** factory method */
  public static ExcIEEEDC1AValidator getInstance() {
    return new ExcIEEEDC1AValidator();
  }

  /** handles creation validation for a ExcIEEEDC1A */
  public void validate(CreateExcIEEEDC1ACommand excIEEEDC1A) throws Exception {
    Assert.notNull(excIEEEDC1A, "CreateExcIEEEDC1ACommand should not be null");
    //		Assert.isNull( excIEEEDC1A.getExcIEEEDC1AId(), "CreateExcIEEEDC1ACommand identifier should
    // be null" );
  }

  /** handles update validation for a ExcIEEEDC1A */
  public void validate(UpdateExcIEEEDC1ACommand excIEEEDC1A) throws Exception {
    Assert.notNull(excIEEEDC1A, "UpdateExcIEEEDC1ACommand should not be null");
    Assert.notNull(
        excIEEEDC1A.getExcIEEEDC1AId(), "UpdateExcIEEEDC1ACommand identifier should not be null");
  }

  /** handles delete validation for a ExcIEEEDC1A */
  public void validate(DeleteExcIEEEDC1ACommand excIEEEDC1A) throws Exception {
    Assert.notNull(excIEEEDC1A, "{commandAlias} should not be null");
    Assert.notNull(
        excIEEEDC1A.getExcIEEEDC1AId(), "DeleteExcIEEEDC1ACommand identifier should not be null");
  }

  /** handles fetchOne validation for a ExcIEEEDC1A */
  public void validate(ExcIEEEDC1AFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "ExcIEEEDC1AFetchOneSummary should not be null");
    Assert.notNull(
        summary.getExcIEEEDC1AId(), "ExcIEEEDC1AFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Efd1 validation for a ExcIEEEDC1A
   *
   * @param command AssignEfd1ToExcIEEEDC1ACommand
   */
  public void validate(AssignEfd1ToExcIEEEDC1ACommand command) throws Exception {
    Assert.notNull(command, "AssignEfd1ToExcIEEEDC1ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEDC1AId(), "AssignEfd1ToExcIEEEDC1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignEfd1ToExcIEEEDC1ACommand assignment should not be null");
  }

  /**
   * handles unassign Efd1 validation for a ExcIEEEDC1A
   *
   * @param command UnAssignEfd1FromExcIEEEDC1ACommand
   */
  public void validate(UnAssignEfd1FromExcIEEEDC1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignEfd1FromExcIEEEDC1ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEDC1AId(),
        "UnAssignEfd1FromExcIEEEDC1ACommand identifier should not be null");
  }
  /**
   * handles assign Efd2 validation for a ExcIEEEDC1A
   *
   * @param command AssignEfd2ToExcIEEEDC1ACommand
   */
  public void validate(AssignEfd2ToExcIEEEDC1ACommand command) throws Exception {
    Assert.notNull(command, "AssignEfd2ToExcIEEEDC1ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEDC1AId(), "AssignEfd2ToExcIEEEDC1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignEfd2ToExcIEEEDC1ACommand assignment should not be null");
  }

  /**
   * handles unassign Efd2 validation for a ExcIEEEDC1A
   *
   * @param command UnAssignEfd2FromExcIEEEDC1ACommand
   */
  public void validate(UnAssignEfd2FromExcIEEEDC1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignEfd2FromExcIEEEDC1ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEDC1AId(),
        "UnAssignEfd2FromExcIEEEDC1ACommand identifier should not be null");
  }
  /**
   * handles assign Exclim validation for a ExcIEEEDC1A
   *
   * @param command AssignExclimToExcIEEEDC1ACommand
   */
  public void validate(AssignExclimToExcIEEEDC1ACommand command) throws Exception {
    Assert.notNull(command, "AssignExclimToExcIEEEDC1ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEDC1AId(),
        "AssignExclimToExcIEEEDC1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignExclimToExcIEEEDC1ACommand assignment should not be null");
  }

  /**
   * handles unassign Exclim validation for a ExcIEEEDC1A
   *
   * @param command UnAssignExclimFromExcIEEEDC1ACommand
   */
  public void validate(UnAssignExclimFromExcIEEEDC1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignExclimFromExcIEEEDC1ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEDC1AId(),
        "UnAssignExclimFromExcIEEEDC1ACommand identifier should not be null");
  }
  /**
   * handles assign Ka validation for a ExcIEEEDC1A
   *
   * @param command AssignKaToExcIEEEDC1ACommand
   */
  public void validate(AssignKaToExcIEEEDC1ACommand command) throws Exception {
    Assert.notNull(command, "AssignKaToExcIEEEDC1ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEDC1AId(), "AssignKaToExcIEEEDC1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKaToExcIEEEDC1ACommand assignment should not be null");
  }

  /**
   * handles unassign Ka validation for a ExcIEEEDC1A
   *
   * @param command UnAssignKaFromExcIEEEDC1ACommand
   */
  public void validate(UnAssignKaFromExcIEEEDC1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignKaFromExcIEEEDC1ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEDC1AId(),
        "UnAssignKaFromExcIEEEDC1ACommand identifier should not be null");
  }
  /**
   * handles assign Ke validation for a ExcIEEEDC1A
   *
   * @param command AssignKeToExcIEEEDC1ACommand
   */
  public void validate(AssignKeToExcIEEEDC1ACommand command) throws Exception {
    Assert.notNull(command, "AssignKeToExcIEEEDC1ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEDC1AId(), "AssignKeToExcIEEEDC1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKeToExcIEEEDC1ACommand assignment should not be null");
  }

  /**
   * handles unassign Ke validation for a ExcIEEEDC1A
   *
   * @param command UnAssignKeFromExcIEEEDC1ACommand
   */
  public void validate(UnAssignKeFromExcIEEEDC1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignKeFromExcIEEEDC1ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEDC1AId(),
        "UnAssignKeFromExcIEEEDC1ACommand identifier should not be null");
  }
  /**
   * handles assign Kf validation for a ExcIEEEDC1A
   *
   * @param command AssignKfToExcIEEEDC1ACommand
   */
  public void validate(AssignKfToExcIEEEDC1ACommand command) throws Exception {
    Assert.notNull(command, "AssignKfToExcIEEEDC1ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEDC1AId(), "AssignKfToExcIEEEDC1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKfToExcIEEEDC1ACommand assignment should not be null");
  }

  /**
   * handles unassign Kf validation for a ExcIEEEDC1A
   *
   * @param command UnAssignKfFromExcIEEEDC1ACommand
   */
  public void validate(UnAssignKfFromExcIEEEDC1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignKfFromExcIEEEDC1ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEDC1AId(),
        "UnAssignKfFromExcIEEEDC1ACommand identifier should not be null");
  }
  /**
   * handles assign Seefd1 validation for a ExcIEEEDC1A
   *
   * @param command AssignSeefd1ToExcIEEEDC1ACommand
   */
  public void validate(AssignSeefd1ToExcIEEEDC1ACommand command) throws Exception {
    Assert.notNull(command, "AssignSeefd1ToExcIEEEDC1ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEDC1AId(),
        "AssignSeefd1ToExcIEEEDC1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignSeefd1ToExcIEEEDC1ACommand assignment should not be null");
  }

  /**
   * handles unassign Seefd1 validation for a ExcIEEEDC1A
   *
   * @param command UnAssignSeefd1FromExcIEEEDC1ACommand
   */
  public void validate(UnAssignSeefd1FromExcIEEEDC1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignSeefd1FromExcIEEEDC1ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEDC1AId(),
        "UnAssignSeefd1FromExcIEEEDC1ACommand identifier should not be null");
  }
  /**
   * handles assign Seefd2 validation for a ExcIEEEDC1A
   *
   * @param command AssignSeefd2ToExcIEEEDC1ACommand
   */
  public void validate(AssignSeefd2ToExcIEEEDC1ACommand command) throws Exception {
    Assert.notNull(command, "AssignSeefd2ToExcIEEEDC1ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEDC1AId(),
        "AssignSeefd2ToExcIEEEDC1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignSeefd2ToExcIEEEDC1ACommand assignment should not be null");
  }

  /**
   * handles unassign Seefd2 validation for a ExcIEEEDC1A
   *
   * @param command UnAssignSeefd2FromExcIEEEDC1ACommand
   */
  public void validate(UnAssignSeefd2FromExcIEEEDC1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignSeefd2FromExcIEEEDC1ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEDC1AId(),
        "UnAssignSeefd2FromExcIEEEDC1ACommand identifier should not be null");
  }
  /**
   * handles assign Ta validation for a ExcIEEEDC1A
   *
   * @param command AssignTaToExcIEEEDC1ACommand
   */
  public void validate(AssignTaToExcIEEEDC1ACommand command) throws Exception {
    Assert.notNull(command, "AssignTaToExcIEEEDC1ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEDC1AId(), "AssignTaToExcIEEEDC1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTaToExcIEEEDC1ACommand assignment should not be null");
  }

  /**
   * handles unassign Ta validation for a ExcIEEEDC1A
   *
   * @param command UnAssignTaFromExcIEEEDC1ACommand
   */
  public void validate(UnAssignTaFromExcIEEEDC1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignTaFromExcIEEEDC1ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEDC1AId(),
        "UnAssignTaFromExcIEEEDC1ACommand identifier should not be null");
  }
  /**
   * handles assign Tb validation for a ExcIEEEDC1A
   *
   * @param command AssignTbToExcIEEEDC1ACommand
   */
  public void validate(AssignTbToExcIEEEDC1ACommand command) throws Exception {
    Assert.notNull(command, "AssignTbToExcIEEEDC1ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEDC1AId(), "AssignTbToExcIEEEDC1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTbToExcIEEEDC1ACommand assignment should not be null");
  }

  /**
   * handles unassign Tb validation for a ExcIEEEDC1A
   *
   * @param command UnAssignTbFromExcIEEEDC1ACommand
   */
  public void validate(UnAssignTbFromExcIEEEDC1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignTbFromExcIEEEDC1ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEDC1AId(),
        "UnAssignTbFromExcIEEEDC1ACommand identifier should not be null");
  }
  /**
   * handles assign Tc validation for a ExcIEEEDC1A
   *
   * @param command AssignTcToExcIEEEDC1ACommand
   */
  public void validate(AssignTcToExcIEEEDC1ACommand command) throws Exception {
    Assert.notNull(command, "AssignTcToExcIEEEDC1ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEDC1AId(), "AssignTcToExcIEEEDC1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTcToExcIEEEDC1ACommand assignment should not be null");
  }

  /**
   * handles unassign Tc validation for a ExcIEEEDC1A
   *
   * @param command UnAssignTcFromExcIEEEDC1ACommand
   */
  public void validate(UnAssignTcFromExcIEEEDC1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignTcFromExcIEEEDC1ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEDC1AId(),
        "UnAssignTcFromExcIEEEDC1ACommand identifier should not be null");
  }
  /**
   * handles assign Te validation for a ExcIEEEDC1A
   *
   * @param command AssignTeToExcIEEEDC1ACommand
   */
  public void validate(AssignTeToExcIEEEDC1ACommand command) throws Exception {
    Assert.notNull(command, "AssignTeToExcIEEEDC1ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEDC1AId(), "AssignTeToExcIEEEDC1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTeToExcIEEEDC1ACommand assignment should not be null");
  }

  /**
   * handles unassign Te validation for a ExcIEEEDC1A
   *
   * @param command UnAssignTeFromExcIEEEDC1ACommand
   */
  public void validate(UnAssignTeFromExcIEEEDC1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignTeFromExcIEEEDC1ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEDC1AId(),
        "UnAssignTeFromExcIEEEDC1ACommand identifier should not be null");
  }
  /**
   * handles assign Tf validation for a ExcIEEEDC1A
   *
   * @param command AssignTfToExcIEEEDC1ACommand
   */
  public void validate(AssignTfToExcIEEEDC1ACommand command) throws Exception {
    Assert.notNull(command, "AssignTfToExcIEEEDC1ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEDC1AId(), "AssignTfToExcIEEEDC1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTfToExcIEEEDC1ACommand assignment should not be null");
  }

  /**
   * handles unassign Tf validation for a ExcIEEEDC1A
   *
   * @param command UnAssignTfFromExcIEEEDC1ACommand
   */
  public void validate(UnAssignTfFromExcIEEEDC1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignTfFromExcIEEEDC1ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEDC1AId(),
        "UnAssignTfFromExcIEEEDC1ACommand identifier should not be null");
  }
  /**
   * handles assign Uelin validation for a ExcIEEEDC1A
   *
   * @param command AssignUelinToExcIEEEDC1ACommand
   */
  public void validate(AssignUelinToExcIEEEDC1ACommand command) throws Exception {
    Assert.notNull(command, "AssignUelinToExcIEEEDC1ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEDC1AId(),
        "AssignUelinToExcIEEEDC1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignUelinToExcIEEEDC1ACommand assignment should not be null");
  }

  /**
   * handles unassign Uelin validation for a ExcIEEEDC1A
   *
   * @param command UnAssignUelinFromExcIEEEDC1ACommand
   */
  public void validate(UnAssignUelinFromExcIEEEDC1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignUelinFromExcIEEEDC1ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEDC1AId(),
        "UnAssignUelinFromExcIEEEDC1ACommand identifier should not be null");
  }
  /**
   * handles assign Vrmax validation for a ExcIEEEDC1A
   *
   * @param command AssignVrmaxToExcIEEEDC1ACommand
   */
  public void validate(AssignVrmaxToExcIEEEDC1ACommand command) throws Exception {
    Assert.notNull(command, "AssignVrmaxToExcIEEEDC1ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEDC1AId(),
        "AssignVrmaxToExcIEEEDC1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVrmaxToExcIEEEDC1ACommand assignment should not be null");
  }

  /**
   * handles unassign Vrmax validation for a ExcIEEEDC1A
   *
   * @param command UnAssignVrmaxFromExcIEEEDC1ACommand
   */
  public void validate(UnAssignVrmaxFromExcIEEEDC1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignVrmaxFromExcIEEEDC1ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEDC1AId(),
        "UnAssignVrmaxFromExcIEEEDC1ACommand identifier should not be null");
  }
  /**
   * handles assign Vrmin validation for a ExcIEEEDC1A
   *
   * @param command AssignVrminToExcIEEEDC1ACommand
   */
  public void validate(AssignVrminToExcIEEEDC1ACommand command) throws Exception {
    Assert.notNull(command, "AssignVrminToExcIEEEDC1ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEDC1AId(),
        "AssignVrminToExcIEEEDC1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVrminToExcIEEEDC1ACommand assignment should not be null");
  }

  /**
   * handles unassign Vrmin validation for a ExcIEEEDC1A
   *
   * @param command UnAssignVrminFromExcIEEEDC1ACommand
   */
  public void validate(UnAssignVrminFromExcIEEEDC1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignVrminFromExcIEEEDC1ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEDC1AId(),
        "UnAssignVrminFromExcIEEEDC1ACommand identifier should not be null");
  }
}
