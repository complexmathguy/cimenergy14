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

public class ExcIEEEAC5AValidator {

  /** default constructor */
  protected ExcIEEEAC5AValidator() {}

  /** factory method */
  public static ExcIEEEAC5AValidator getInstance() {
    return new ExcIEEEAC5AValidator();
  }

  /** handles creation validation for a ExcIEEEAC5A */
  public void validate(CreateExcIEEEAC5ACommand excIEEEAC5A) throws Exception {
    Assert.notNull(excIEEEAC5A, "CreateExcIEEEAC5ACommand should not be null");
    //		Assert.isNull( excIEEEAC5A.getExcIEEEAC5AId(), "CreateExcIEEEAC5ACommand identifier should
    // be null" );
  }

  /** handles update validation for a ExcIEEEAC5A */
  public void validate(UpdateExcIEEEAC5ACommand excIEEEAC5A) throws Exception {
    Assert.notNull(excIEEEAC5A, "UpdateExcIEEEAC5ACommand should not be null");
    Assert.notNull(
        excIEEEAC5A.getExcIEEEAC5AId(), "UpdateExcIEEEAC5ACommand identifier should not be null");
  }

  /** handles delete validation for a ExcIEEEAC5A */
  public void validate(DeleteExcIEEEAC5ACommand excIEEEAC5A) throws Exception {
    Assert.notNull(excIEEEAC5A, "{commandAlias} should not be null");
    Assert.notNull(
        excIEEEAC5A.getExcIEEEAC5AId(), "DeleteExcIEEEAC5ACommand identifier should not be null");
  }

  /** handles fetchOne validation for a ExcIEEEAC5A */
  public void validate(ExcIEEEAC5AFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "ExcIEEEAC5AFetchOneSummary should not be null");
    Assert.notNull(
        summary.getExcIEEEAC5AId(), "ExcIEEEAC5AFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Efd1 validation for a ExcIEEEAC5A
   *
   * @param command AssignEfd1ToExcIEEEAC5ACommand
   */
  public void validate(AssignEfd1ToExcIEEEAC5ACommand command) throws Exception {
    Assert.notNull(command, "AssignEfd1ToExcIEEEAC5ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC5AId(), "AssignEfd1ToExcIEEEAC5ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignEfd1ToExcIEEEAC5ACommand assignment should not be null");
  }

  /**
   * handles unassign Efd1 validation for a ExcIEEEAC5A
   *
   * @param command UnAssignEfd1FromExcIEEEAC5ACommand
   */
  public void validate(UnAssignEfd1FromExcIEEEAC5ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignEfd1FromExcIEEEAC5ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC5AId(),
        "UnAssignEfd1FromExcIEEEAC5ACommand identifier should not be null");
  }
  /**
   * handles assign Efd2 validation for a ExcIEEEAC5A
   *
   * @param command AssignEfd2ToExcIEEEAC5ACommand
   */
  public void validate(AssignEfd2ToExcIEEEAC5ACommand command) throws Exception {
    Assert.notNull(command, "AssignEfd2ToExcIEEEAC5ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC5AId(), "AssignEfd2ToExcIEEEAC5ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignEfd2ToExcIEEEAC5ACommand assignment should not be null");
  }

  /**
   * handles unassign Efd2 validation for a ExcIEEEAC5A
   *
   * @param command UnAssignEfd2FromExcIEEEAC5ACommand
   */
  public void validate(UnAssignEfd2FromExcIEEEAC5ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignEfd2FromExcIEEEAC5ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC5AId(),
        "UnAssignEfd2FromExcIEEEAC5ACommand identifier should not be null");
  }
  /**
   * handles assign Ka validation for a ExcIEEEAC5A
   *
   * @param command AssignKaToExcIEEEAC5ACommand
   */
  public void validate(AssignKaToExcIEEEAC5ACommand command) throws Exception {
    Assert.notNull(command, "AssignKaToExcIEEEAC5ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC5AId(), "AssignKaToExcIEEEAC5ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKaToExcIEEEAC5ACommand assignment should not be null");
  }

  /**
   * handles unassign Ka validation for a ExcIEEEAC5A
   *
   * @param command UnAssignKaFromExcIEEEAC5ACommand
   */
  public void validate(UnAssignKaFromExcIEEEAC5ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignKaFromExcIEEEAC5ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC5AId(),
        "UnAssignKaFromExcIEEEAC5ACommand identifier should not be null");
  }
  /**
   * handles assign Ke validation for a ExcIEEEAC5A
   *
   * @param command AssignKeToExcIEEEAC5ACommand
   */
  public void validate(AssignKeToExcIEEEAC5ACommand command) throws Exception {
    Assert.notNull(command, "AssignKeToExcIEEEAC5ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC5AId(), "AssignKeToExcIEEEAC5ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKeToExcIEEEAC5ACommand assignment should not be null");
  }

  /**
   * handles unassign Ke validation for a ExcIEEEAC5A
   *
   * @param command UnAssignKeFromExcIEEEAC5ACommand
   */
  public void validate(UnAssignKeFromExcIEEEAC5ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignKeFromExcIEEEAC5ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC5AId(),
        "UnAssignKeFromExcIEEEAC5ACommand identifier should not be null");
  }
  /**
   * handles assign Kf validation for a ExcIEEEAC5A
   *
   * @param command AssignKfToExcIEEEAC5ACommand
   */
  public void validate(AssignKfToExcIEEEAC5ACommand command) throws Exception {
    Assert.notNull(command, "AssignKfToExcIEEEAC5ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC5AId(), "AssignKfToExcIEEEAC5ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKfToExcIEEEAC5ACommand assignment should not be null");
  }

  /**
   * handles unassign Kf validation for a ExcIEEEAC5A
   *
   * @param command UnAssignKfFromExcIEEEAC5ACommand
   */
  public void validate(UnAssignKfFromExcIEEEAC5ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignKfFromExcIEEEAC5ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC5AId(),
        "UnAssignKfFromExcIEEEAC5ACommand identifier should not be null");
  }
  /**
   * handles assign Seefd1 validation for a ExcIEEEAC5A
   *
   * @param command AssignSeefd1ToExcIEEEAC5ACommand
   */
  public void validate(AssignSeefd1ToExcIEEEAC5ACommand command) throws Exception {
    Assert.notNull(command, "AssignSeefd1ToExcIEEEAC5ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC5AId(),
        "AssignSeefd1ToExcIEEEAC5ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignSeefd1ToExcIEEEAC5ACommand assignment should not be null");
  }

  /**
   * handles unassign Seefd1 validation for a ExcIEEEAC5A
   *
   * @param command UnAssignSeefd1FromExcIEEEAC5ACommand
   */
  public void validate(UnAssignSeefd1FromExcIEEEAC5ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignSeefd1FromExcIEEEAC5ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC5AId(),
        "UnAssignSeefd1FromExcIEEEAC5ACommand identifier should not be null");
  }
  /**
   * handles assign Seefd2 validation for a ExcIEEEAC5A
   *
   * @param command AssignSeefd2ToExcIEEEAC5ACommand
   */
  public void validate(AssignSeefd2ToExcIEEEAC5ACommand command) throws Exception {
    Assert.notNull(command, "AssignSeefd2ToExcIEEEAC5ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC5AId(),
        "AssignSeefd2ToExcIEEEAC5ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignSeefd2ToExcIEEEAC5ACommand assignment should not be null");
  }

  /**
   * handles unassign Seefd2 validation for a ExcIEEEAC5A
   *
   * @param command UnAssignSeefd2FromExcIEEEAC5ACommand
   */
  public void validate(UnAssignSeefd2FromExcIEEEAC5ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignSeefd2FromExcIEEEAC5ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC5AId(),
        "UnAssignSeefd2FromExcIEEEAC5ACommand identifier should not be null");
  }
  /**
   * handles assign Ta validation for a ExcIEEEAC5A
   *
   * @param command AssignTaToExcIEEEAC5ACommand
   */
  public void validate(AssignTaToExcIEEEAC5ACommand command) throws Exception {
    Assert.notNull(command, "AssignTaToExcIEEEAC5ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC5AId(), "AssignTaToExcIEEEAC5ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTaToExcIEEEAC5ACommand assignment should not be null");
  }

  /**
   * handles unassign Ta validation for a ExcIEEEAC5A
   *
   * @param command UnAssignTaFromExcIEEEAC5ACommand
   */
  public void validate(UnAssignTaFromExcIEEEAC5ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignTaFromExcIEEEAC5ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC5AId(),
        "UnAssignTaFromExcIEEEAC5ACommand identifier should not be null");
  }
  /**
   * handles assign Te validation for a ExcIEEEAC5A
   *
   * @param command AssignTeToExcIEEEAC5ACommand
   */
  public void validate(AssignTeToExcIEEEAC5ACommand command) throws Exception {
    Assert.notNull(command, "AssignTeToExcIEEEAC5ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC5AId(), "AssignTeToExcIEEEAC5ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTeToExcIEEEAC5ACommand assignment should not be null");
  }

  /**
   * handles unassign Te validation for a ExcIEEEAC5A
   *
   * @param command UnAssignTeFromExcIEEEAC5ACommand
   */
  public void validate(UnAssignTeFromExcIEEEAC5ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignTeFromExcIEEEAC5ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC5AId(),
        "UnAssignTeFromExcIEEEAC5ACommand identifier should not be null");
  }
  /**
   * handles assign Tf1 validation for a ExcIEEEAC5A
   *
   * @param command AssignTf1ToExcIEEEAC5ACommand
   */
  public void validate(AssignTf1ToExcIEEEAC5ACommand command) throws Exception {
    Assert.notNull(command, "AssignTf1ToExcIEEEAC5ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC5AId(), "AssignTf1ToExcIEEEAC5ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTf1ToExcIEEEAC5ACommand assignment should not be null");
  }

  /**
   * handles unassign Tf1 validation for a ExcIEEEAC5A
   *
   * @param command UnAssignTf1FromExcIEEEAC5ACommand
   */
  public void validate(UnAssignTf1FromExcIEEEAC5ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignTf1FromExcIEEEAC5ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC5AId(),
        "UnAssignTf1FromExcIEEEAC5ACommand identifier should not be null");
  }
  /**
   * handles assign Tf2 validation for a ExcIEEEAC5A
   *
   * @param command AssignTf2ToExcIEEEAC5ACommand
   */
  public void validate(AssignTf2ToExcIEEEAC5ACommand command) throws Exception {
    Assert.notNull(command, "AssignTf2ToExcIEEEAC5ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC5AId(), "AssignTf2ToExcIEEEAC5ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTf2ToExcIEEEAC5ACommand assignment should not be null");
  }

  /**
   * handles unassign Tf2 validation for a ExcIEEEAC5A
   *
   * @param command UnAssignTf2FromExcIEEEAC5ACommand
   */
  public void validate(UnAssignTf2FromExcIEEEAC5ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignTf2FromExcIEEEAC5ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC5AId(),
        "UnAssignTf2FromExcIEEEAC5ACommand identifier should not be null");
  }
  /**
   * handles assign Tf3 validation for a ExcIEEEAC5A
   *
   * @param command AssignTf3ToExcIEEEAC5ACommand
   */
  public void validate(AssignTf3ToExcIEEEAC5ACommand command) throws Exception {
    Assert.notNull(command, "AssignTf3ToExcIEEEAC5ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC5AId(), "AssignTf3ToExcIEEEAC5ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTf3ToExcIEEEAC5ACommand assignment should not be null");
  }

  /**
   * handles unassign Tf3 validation for a ExcIEEEAC5A
   *
   * @param command UnAssignTf3FromExcIEEEAC5ACommand
   */
  public void validate(UnAssignTf3FromExcIEEEAC5ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignTf3FromExcIEEEAC5ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC5AId(),
        "UnAssignTf3FromExcIEEEAC5ACommand identifier should not be null");
  }
  /**
   * handles assign Vrmax validation for a ExcIEEEAC5A
   *
   * @param command AssignVrmaxToExcIEEEAC5ACommand
   */
  public void validate(AssignVrmaxToExcIEEEAC5ACommand command) throws Exception {
    Assert.notNull(command, "AssignVrmaxToExcIEEEAC5ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC5AId(),
        "AssignVrmaxToExcIEEEAC5ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVrmaxToExcIEEEAC5ACommand assignment should not be null");
  }

  /**
   * handles unassign Vrmax validation for a ExcIEEEAC5A
   *
   * @param command UnAssignVrmaxFromExcIEEEAC5ACommand
   */
  public void validate(UnAssignVrmaxFromExcIEEEAC5ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignVrmaxFromExcIEEEAC5ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC5AId(),
        "UnAssignVrmaxFromExcIEEEAC5ACommand identifier should not be null");
  }
  /**
   * handles assign Vrmin validation for a ExcIEEEAC5A
   *
   * @param command AssignVrminToExcIEEEAC5ACommand
   */
  public void validate(AssignVrminToExcIEEEAC5ACommand command) throws Exception {
    Assert.notNull(command, "AssignVrminToExcIEEEAC5ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC5AId(),
        "AssignVrminToExcIEEEAC5ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVrminToExcIEEEAC5ACommand assignment should not be null");
  }

  /**
   * handles unassign Vrmin validation for a ExcIEEEAC5A
   *
   * @param command UnAssignVrminFromExcIEEEAC5ACommand
   */
  public void validate(UnAssignVrminFromExcIEEEAC5ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignVrminFromExcIEEEAC5ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC5AId(),
        "UnAssignVrminFromExcIEEEAC5ACommand identifier should not be null");
  }
}
