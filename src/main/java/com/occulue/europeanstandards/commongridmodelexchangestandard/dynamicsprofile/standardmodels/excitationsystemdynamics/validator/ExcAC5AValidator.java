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

public class ExcAC5AValidator {

  /** default constructor */
  protected ExcAC5AValidator() {}

  /** factory method */
  public static ExcAC5AValidator getInstance() {
    return new ExcAC5AValidator();
  }

  /** handles creation validation for a ExcAC5A */
  public void validate(CreateExcAC5ACommand excAC5A) throws Exception {
    Assert.notNull(excAC5A, "CreateExcAC5ACommand should not be null");
    //		Assert.isNull( excAC5A.getExcAC5AId(), "CreateExcAC5ACommand identifier should be null" );
  }

  /** handles update validation for a ExcAC5A */
  public void validate(UpdateExcAC5ACommand excAC5A) throws Exception {
    Assert.notNull(excAC5A, "UpdateExcAC5ACommand should not be null");
    Assert.notNull(excAC5A.getExcAC5AId(), "UpdateExcAC5ACommand identifier should not be null");
  }

  /** handles delete validation for a ExcAC5A */
  public void validate(DeleteExcAC5ACommand excAC5A) throws Exception {
    Assert.notNull(excAC5A, "{commandAlias} should not be null");
    Assert.notNull(excAC5A.getExcAC5AId(), "DeleteExcAC5ACommand identifier should not be null");
  }

  /** handles fetchOne validation for a ExcAC5A */
  public void validate(ExcAC5AFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "ExcAC5AFetchOneSummary should not be null");
    Assert.notNull(summary.getExcAC5AId(), "ExcAC5AFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign A validation for a ExcAC5A
   *
   * @param command AssignAToExcAC5ACommand
   */
  public void validate(AssignAToExcAC5ACommand command) throws Exception {
    Assert.notNull(command, "AssignAToExcAC5ACommand should not be null");
    Assert.notNull(command.getExcAC5AId(), "AssignAToExcAC5ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignAToExcAC5ACommand assignment should not be null");
  }

  /**
   * handles unassign A validation for a ExcAC5A
   *
   * @param command UnAssignAFromExcAC5ACommand
   */
  public void validate(UnAssignAFromExcAC5ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignAFromExcAC5ACommand should not be null");
    Assert.notNull(
        command.getExcAC5AId(), "UnAssignAFromExcAC5ACommand identifier should not be null");
  }
  /**
   * handles assign Efd1 validation for a ExcAC5A
   *
   * @param command AssignEfd1ToExcAC5ACommand
   */
  public void validate(AssignEfd1ToExcAC5ACommand command) throws Exception {
    Assert.notNull(command, "AssignEfd1ToExcAC5ACommand should not be null");
    Assert.notNull(
        command.getExcAC5AId(), "AssignEfd1ToExcAC5ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignEfd1ToExcAC5ACommand assignment should not be null");
  }

  /**
   * handles unassign Efd1 validation for a ExcAC5A
   *
   * @param command UnAssignEfd1FromExcAC5ACommand
   */
  public void validate(UnAssignEfd1FromExcAC5ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignEfd1FromExcAC5ACommand should not be null");
    Assert.notNull(
        command.getExcAC5AId(), "UnAssignEfd1FromExcAC5ACommand identifier should not be null");
  }
  /**
   * handles assign Efd2 validation for a ExcAC5A
   *
   * @param command AssignEfd2ToExcAC5ACommand
   */
  public void validate(AssignEfd2ToExcAC5ACommand command) throws Exception {
    Assert.notNull(command, "AssignEfd2ToExcAC5ACommand should not be null");
    Assert.notNull(
        command.getExcAC5AId(), "AssignEfd2ToExcAC5ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignEfd2ToExcAC5ACommand assignment should not be null");
  }

  /**
   * handles unassign Efd2 validation for a ExcAC5A
   *
   * @param command UnAssignEfd2FromExcAC5ACommand
   */
  public void validate(UnAssignEfd2FromExcAC5ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignEfd2FromExcAC5ACommand should not be null");
    Assert.notNull(
        command.getExcAC5AId(), "UnAssignEfd2FromExcAC5ACommand identifier should not be null");
  }
  /**
   * handles assign Ka validation for a ExcAC5A
   *
   * @param command AssignKaToExcAC5ACommand
   */
  public void validate(AssignKaToExcAC5ACommand command) throws Exception {
    Assert.notNull(command, "AssignKaToExcAC5ACommand should not be null");
    Assert.notNull(
        command.getExcAC5AId(), "AssignKaToExcAC5ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKaToExcAC5ACommand assignment should not be null");
  }

  /**
   * handles unassign Ka validation for a ExcAC5A
   *
   * @param command UnAssignKaFromExcAC5ACommand
   */
  public void validate(UnAssignKaFromExcAC5ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignKaFromExcAC5ACommand should not be null");
    Assert.notNull(
        command.getExcAC5AId(), "UnAssignKaFromExcAC5ACommand identifier should not be null");
  }
  /**
   * handles assign Ke validation for a ExcAC5A
   *
   * @param command AssignKeToExcAC5ACommand
   */
  public void validate(AssignKeToExcAC5ACommand command) throws Exception {
    Assert.notNull(command, "AssignKeToExcAC5ACommand should not be null");
    Assert.notNull(
        command.getExcAC5AId(), "AssignKeToExcAC5ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKeToExcAC5ACommand assignment should not be null");
  }

  /**
   * handles unassign Ke validation for a ExcAC5A
   *
   * @param command UnAssignKeFromExcAC5ACommand
   */
  public void validate(UnAssignKeFromExcAC5ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignKeFromExcAC5ACommand should not be null");
    Assert.notNull(
        command.getExcAC5AId(), "UnAssignKeFromExcAC5ACommand identifier should not be null");
  }
  /**
   * handles assign Kf validation for a ExcAC5A
   *
   * @param command AssignKfToExcAC5ACommand
   */
  public void validate(AssignKfToExcAC5ACommand command) throws Exception {
    Assert.notNull(command, "AssignKfToExcAC5ACommand should not be null");
    Assert.notNull(
        command.getExcAC5AId(), "AssignKfToExcAC5ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKfToExcAC5ACommand assignment should not be null");
  }

  /**
   * handles unassign Kf validation for a ExcAC5A
   *
   * @param command UnAssignKfFromExcAC5ACommand
   */
  public void validate(UnAssignKfFromExcAC5ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignKfFromExcAC5ACommand should not be null");
    Assert.notNull(
        command.getExcAC5AId(), "UnAssignKfFromExcAC5ACommand identifier should not be null");
  }
  /**
   * handles assign Ks validation for a ExcAC5A
   *
   * @param command AssignKsToExcAC5ACommand
   */
  public void validate(AssignKsToExcAC5ACommand command) throws Exception {
    Assert.notNull(command, "AssignKsToExcAC5ACommand should not be null");
    Assert.notNull(
        command.getExcAC5AId(), "AssignKsToExcAC5ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKsToExcAC5ACommand assignment should not be null");
  }

  /**
   * handles unassign Ks validation for a ExcAC5A
   *
   * @param command UnAssignKsFromExcAC5ACommand
   */
  public void validate(UnAssignKsFromExcAC5ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignKsFromExcAC5ACommand should not be null");
    Assert.notNull(
        command.getExcAC5AId(), "UnAssignKsFromExcAC5ACommand identifier should not be null");
  }
  /**
   * handles assign Seefd1 validation for a ExcAC5A
   *
   * @param command AssignSeefd1ToExcAC5ACommand
   */
  public void validate(AssignSeefd1ToExcAC5ACommand command) throws Exception {
    Assert.notNull(command, "AssignSeefd1ToExcAC5ACommand should not be null");
    Assert.notNull(
        command.getExcAC5AId(), "AssignSeefd1ToExcAC5ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignSeefd1ToExcAC5ACommand assignment should not be null");
  }

  /**
   * handles unassign Seefd1 validation for a ExcAC5A
   *
   * @param command UnAssignSeefd1FromExcAC5ACommand
   */
  public void validate(UnAssignSeefd1FromExcAC5ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignSeefd1FromExcAC5ACommand should not be null");
    Assert.notNull(
        command.getExcAC5AId(), "UnAssignSeefd1FromExcAC5ACommand identifier should not be null");
  }
  /**
   * handles assign Seefd2 validation for a ExcAC5A
   *
   * @param command AssignSeefd2ToExcAC5ACommand
   */
  public void validate(AssignSeefd2ToExcAC5ACommand command) throws Exception {
    Assert.notNull(command, "AssignSeefd2ToExcAC5ACommand should not be null");
    Assert.notNull(
        command.getExcAC5AId(), "AssignSeefd2ToExcAC5ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignSeefd2ToExcAC5ACommand assignment should not be null");
  }

  /**
   * handles unassign Seefd2 validation for a ExcAC5A
   *
   * @param command UnAssignSeefd2FromExcAC5ACommand
   */
  public void validate(UnAssignSeefd2FromExcAC5ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignSeefd2FromExcAC5ACommand should not be null");
    Assert.notNull(
        command.getExcAC5AId(), "UnAssignSeefd2FromExcAC5ACommand identifier should not be null");
  }
  /**
   * handles assign Ta validation for a ExcAC5A
   *
   * @param command AssignTaToExcAC5ACommand
   */
  public void validate(AssignTaToExcAC5ACommand command) throws Exception {
    Assert.notNull(command, "AssignTaToExcAC5ACommand should not be null");
    Assert.notNull(
        command.getExcAC5AId(), "AssignTaToExcAC5ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTaToExcAC5ACommand assignment should not be null");
  }

  /**
   * handles unassign Ta validation for a ExcAC5A
   *
   * @param command UnAssignTaFromExcAC5ACommand
   */
  public void validate(UnAssignTaFromExcAC5ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignTaFromExcAC5ACommand should not be null");
    Assert.notNull(
        command.getExcAC5AId(), "UnAssignTaFromExcAC5ACommand identifier should not be null");
  }
  /**
   * handles assign Tb validation for a ExcAC5A
   *
   * @param command AssignTbToExcAC5ACommand
   */
  public void validate(AssignTbToExcAC5ACommand command) throws Exception {
    Assert.notNull(command, "AssignTbToExcAC5ACommand should not be null");
    Assert.notNull(
        command.getExcAC5AId(), "AssignTbToExcAC5ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTbToExcAC5ACommand assignment should not be null");
  }

  /**
   * handles unassign Tb validation for a ExcAC5A
   *
   * @param command UnAssignTbFromExcAC5ACommand
   */
  public void validate(UnAssignTbFromExcAC5ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignTbFromExcAC5ACommand should not be null");
    Assert.notNull(
        command.getExcAC5AId(), "UnAssignTbFromExcAC5ACommand identifier should not be null");
  }
  /**
   * handles assign Tc validation for a ExcAC5A
   *
   * @param command AssignTcToExcAC5ACommand
   */
  public void validate(AssignTcToExcAC5ACommand command) throws Exception {
    Assert.notNull(command, "AssignTcToExcAC5ACommand should not be null");
    Assert.notNull(
        command.getExcAC5AId(), "AssignTcToExcAC5ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTcToExcAC5ACommand assignment should not be null");
  }

  /**
   * handles unassign Tc validation for a ExcAC5A
   *
   * @param command UnAssignTcFromExcAC5ACommand
   */
  public void validate(UnAssignTcFromExcAC5ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignTcFromExcAC5ACommand should not be null");
    Assert.notNull(
        command.getExcAC5AId(), "UnAssignTcFromExcAC5ACommand identifier should not be null");
  }
  /**
   * handles assign Te validation for a ExcAC5A
   *
   * @param command AssignTeToExcAC5ACommand
   */
  public void validate(AssignTeToExcAC5ACommand command) throws Exception {
    Assert.notNull(command, "AssignTeToExcAC5ACommand should not be null");
    Assert.notNull(
        command.getExcAC5AId(), "AssignTeToExcAC5ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTeToExcAC5ACommand assignment should not be null");
  }

  /**
   * handles unassign Te validation for a ExcAC5A
   *
   * @param command UnAssignTeFromExcAC5ACommand
   */
  public void validate(UnAssignTeFromExcAC5ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignTeFromExcAC5ACommand should not be null");
    Assert.notNull(
        command.getExcAC5AId(), "UnAssignTeFromExcAC5ACommand identifier should not be null");
  }
  /**
   * handles assign Tf1 validation for a ExcAC5A
   *
   * @param command AssignTf1ToExcAC5ACommand
   */
  public void validate(AssignTf1ToExcAC5ACommand command) throws Exception {
    Assert.notNull(command, "AssignTf1ToExcAC5ACommand should not be null");
    Assert.notNull(
        command.getExcAC5AId(), "AssignTf1ToExcAC5ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTf1ToExcAC5ACommand assignment should not be null");
  }

  /**
   * handles unassign Tf1 validation for a ExcAC5A
   *
   * @param command UnAssignTf1FromExcAC5ACommand
   */
  public void validate(UnAssignTf1FromExcAC5ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignTf1FromExcAC5ACommand should not be null");
    Assert.notNull(
        command.getExcAC5AId(), "UnAssignTf1FromExcAC5ACommand identifier should not be null");
  }
  /**
   * handles assign Tf2 validation for a ExcAC5A
   *
   * @param command AssignTf2ToExcAC5ACommand
   */
  public void validate(AssignTf2ToExcAC5ACommand command) throws Exception {
    Assert.notNull(command, "AssignTf2ToExcAC5ACommand should not be null");
    Assert.notNull(
        command.getExcAC5AId(), "AssignTf2ToExcAC5ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTf2ToExcAC5ACommand assignment should not be null");
  }

  /**
   * handles unassign Tf2 validation for a ExcAC5A
   *
   * @param command UnAssignTf2FromExcAC5ACommand
   */
  public void validate(UnAssignTf2FromExcAC5ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignTf2FromExcAC5ACommand should not be null");
    Assert.notNull(
        command.getExcAC5AId(), "UnAssignTf2FromExcAC5ACommand identifier should not be null");
  }
  /**
   * handles assign Tf3 validation for a ExcAC5A
   *
   * @param command AssignTf3ToExcAC5ACommand
   */
  public void validate(AssignTf3ToExcAC5ACommand command) throws Exception {
    Assert.notNull(command, "AssignTf3ToExcAC5ACommand should not be null");
    Assert.notNull(
        command.getExcAC5AId(), "AssignTf3ToExcAC5ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTf3ToExcAC5ACommand assignment should not be null");
  }

  /**
   * handles unassign Tf3 validation for a ExcAC5A
   *
   * @param command UnAssignTf3FromExcAC5ACommand
   */
  public void validate(UnAssignTf3FromExcAC5ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignTf3FromExcAC5ACommand should not be null");
    Assert.notNull(
        command.getExcAC5AId(), "UnAssignTf3FromExcAC5ACommand identifier should not be null");
  }
  /**
   * handles assign Vrmax validation for a ExcAC5A
   *
   * @param command AssignVrmaxToExcAC5ACommand
   */
  public void validate(AssignVrmaxToExcAC5ACommand command) throws Exception {
    Assert.notNull(command, "AssignVrmaxToExcAC5ACommand should not be null");
    Assert.notNull(
        command.getExcAC5AId(), "AssignVrmaxToExcAC5ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVrmaxToExcAC5ACommand assignment should not be null");
  }

  /**
   * handles unassign Vrmax validation for a ExcAC5A
   *
   * @param command UnAssignVrmaxFromExcAC5ACommand
   */
  public void validate(UnAssignVrmaxFromExcAC5ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignVrmaxFromExcAC5ACommand should not be null");
    Assert.notNull(
        command.getExcAC5AId(), "UnAssignVrmaxFromExcAC5ACommand identifier should not be null");
  }
  /**
   * handles assign Vrmin validation for a ExcAC5A
   *
   * @param command AssignVrminToExcAC5ACommand
   */
  public void validate(AssignVrminToExcAC5ACommand command) throws Exception {
    Assert.notNull(command, "AssignVrminToExcAC5ACommand should not be null");
    Assert.notNull(
        command.getExcAC5AId(), "AssignVrminToExcAC5ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVrminToExcAC5ACommand assignment should not be null");
  }

  /**
   * handles unassign Vrmin validation for a ExcAC5A
   *
   * @param command UnAssignVrminFromExcAC5ACommand
   */
  public void validate(UnAssignVrminFromExcAC5ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignVrminFromExcAC5ACommand should not be null");
    Assert.notNull(
        command.getExcAC5AId(), "UnAssignVrminFromExcAC5ACommand identifier should not be null");
  }
}
