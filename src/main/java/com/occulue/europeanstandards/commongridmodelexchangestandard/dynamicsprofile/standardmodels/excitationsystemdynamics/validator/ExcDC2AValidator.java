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

public class ExcDC2AValidator {

  /** default constructor */
  protected ExcDC2AValidator() {}

  /** factory method */
  public static ExcDC2AValidator getInstance() {
    return new ExcDC2AValidator();
  }

  /** handles creation validation for a ExcDC2A */
  public void validate(CreateExcDC2ACommand excDC2A) throws Exception {
    Assert.notNull(excDC2A, "CreateExcDC2ACommand should not be null");
    //		Assert.isNull( excDC2A.getExcDC2AId(), "CreateExcDC2ACommand identifier should be null" );
  }

  /** handles update validation for a ExcDC2A */
  public void validate(UpdateExcDC2ACommand excDC2A) throws Exception {
    Assert.notNull(excDC2A, "UpdateExcDC2ACommand should not be null");
    Assert.notNull(excDC2A.getExcDC2AId(), "UpdateExcDC2ACommand identifier should not be null");
  }

  /** handles delete validation for a ExcDC2A */
  public void validate(DeleteExcDC2ACommand excDC2A) throws Exception {
    Assert.notNull(excDC2A, "{commandAlias} should not be null");
    Assert.notNull(excDC2A.getExcDC2AId(), "DeleteExcDC2ACommand identifier should not be null");
  }

  /** handles fetchOne validation for a ExcDC2A */
  public void validate(ExcDC2AFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "ExcDC2AFetchOneSummary should not be null");
    Assert.notNull(summary.getExcDC2AId(), "ExcDC2AFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Efd1 validation for a ExcDC2A
   *
   * @param command AssignEfd1ToExcDC2ACommand
   */
  public void validate(AssignEfd1ToExcDC2ACommand command) throws Exception {
    Assert.notNull(command, "AssignEfd1ToExcDC2ACommand should not be null");
    Assert.notNull(
        command.getExcDC2AId(), "AssignEfd1ToExcDC2ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignEfd1ToExcDC2ACommand assignment should not be null");
  }

  /**
   * handles unassign Efd1 validation for a ExcDC2A
   *
   * @param command UnAssignEfd1FromExcDC2ACommand
   */
  public void validate(UnAssignEfd1FromExcDC2ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignEfd1FromExcDC2ACommand should not be null");
    Assert.notNull(
        command.getExcDC2AId(), "UnAssignEfd1FromExcDC2ACommand identifier should not be null");
  }
  /**
   * handles assign Efd2 validation for a ExcDC2A
   *
   * @param command AssignEfd2ToExcDC2ACommand
   */
  public void validate(AssignEfd2ToExcDC2ACommand command) throws Exception {
    Assert.notNull(command, "AssignEfd2ToExcDC2ACommand should not be null");
    Assert.notNull(
        command.getExcDC2AId(), "AssignEfd2ToExcDC2ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignEfd2ToExcDC2ACommand assignment should not be null");
  }

  /**
   * handles unassign Efd2 validation for a ExcDC2A
   *
   * @param command UnAssignEfd2FromExcDC2ACommand
   */
  public void validate(UnAssignEfd2FromExcDC2ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignEfd2FromExcDC2ACommand should not be null");
    Assert.notNull(
        command.getExcDC2AId(), "UnAssignEfd2FromExcDC2ACommand identifier should not be null");
  }
  /**
   * handles assign Exclim validation for a ExcDC2A
   *
   * @param command AssignExclimToExcDC2ACommand
   */
  public void validate(AssignExclimToExcDC2ACommand command) throws Exception {
    Assert.notNull(command, "AssignExclimToExcDC2ACommand should not be null");
    Assert.notNull(
        command.getExcDC2AId(), "AssignExclimToExcDC2ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignExclimToExcDC2ACommand assignment should not be null");
  }

  /**
   * handles unassign Exclim validation for a ExcDC2A
   *
   * @param command UnAssignExclimFromExcDC2ACommand
   */
  public void validate(UnAssignExclimFromExcDC2ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignExclimFromExcDC2ACommand should not be null");
    Assert.notNull(
        command.getExcDC2AId(), "UnAssignExclimFromExcDC2ACommand identifier should not be null");
  }
  /**
   * handles assign Ka validation for a ExcDC2A
   *
   * @param command AssignKaToExcDC2ACommand
   */
  public void validate(AssignKaToExcDC2ACommand command) throws Exception {
    Assert.notNull(command, "AssignKaToExcDC2ACommand should not be null");
    Assert.notNull(
        command.getExcDC2AId(), "AssignKaToExcDC2ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKaToExcDC2ACommand assignment should not be null");
  }

  /**
   * handles unassign Ka validation for a ExcDC2A
   *
   * @param command UnAssignKaFromExcDC2ACommand
   */
  public void validate(UnAssignKaFromExcDC2ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignKaFromExcDC2ACommand should not be null");
    Assert.notNull(
        command.getExcDC2AId(), "UnAssignKaFromExcDC2ACommand identifier should not be null");
  }
  /**
   * handles assign Ke validation for a ExcDC2A
   *
   * @param command AssignKeToExcDC2ACommand
   */
  public void validate(AssignKeToExcDC2ACommand command) throws Exception {
    Assert.notNull(command, "AssignKeToExcDC2ACommand should not be null");
    Assert.notNull(
        command.getExcDC2AId(), "AssignKeToExcDC2ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKeToExcDC2ACommand assignment should not be null");
  }

  /**
   * handles unassign Ke validation for a ExcDC2A
   *
   * @param command UnAssignKeFromExcDC2ACommand
   */
  public void validate(UnAssignKeFromExcDC2ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignKeFromExcDC2ACommand should not be null");
    Assert.notNull(
        command.getExcDC2AId(), "UnAssignKeFromExcDC2ACommand identifier should not be null");
  }
  /**
   * handles assign Kf validation for a ExcDC2A
   *
   * @param command AssignKfToExcDC2ACommand
   */
  public void validate(AssignKfToExcDC2ACommand command) throws Exception {
    Assert.notNull(command, "AssignKfToExcDC2ACommand should not be null");
    Assert.notNull(
        command.getExcDC2AId(), "AssignKfToExcDC2ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKfToExcDC2ACommand assignment should not be null");
  }

  /**
   * handles unassign Kf validation for a ExcDC2A
   *
   * @param command UnAssignKfFromExcDC2ACommand
   */
  public void validate(UnAssignKfFromExcDC2ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignKfFromExcDC2ACommand should not be null");
    Assert.notNull(
        command.getExcDC2AId(), "UnAssignKfFromExcDC2ACommand identifier should not be null");
  }
  /**
   * handles assign Ks validation for a ExcDC2A
   *
   * @param command AssignKsToExcDC2ACommand
   */
  public void validate(AssignKsToExcDC2ACommand command) throws Exception {
    Assert.notNull(command, "AssignKsToExcDC2ACommand should not be null");
    Assert.notNull(
        command.getExcDC2AId(), "AssignKsToExcDC2ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKsToExcDC2ACommand assignment should not be null");
  }

  /**
   * handles unassign Ks validation for a ExcDC2A
   *
   * @param command UnAssignKsFromExcDC2ACommand
   */
  public void validate(UnAssignKsFromExcDC2ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignKsFromExcDC2ACommand should not be null");
    Assert.notNull(
        command.getExcDC2AId(), "UnAssignKsFromExcDC2ACommand identifier should not be null");
  }
  /**
   * handles assign Seefd1 validation for a ExcDC2A
   *
   * @param command AssignSeefd1ToExcDC2ACommand
   */
  public void validate(AssignSeefd1ToExcDC2ACommand command) throws Exception {
    Assert.notNull(command, "AssignSeefd1ToExcDC2ACommand should not be null");
    Assert.notNull(
        command.getExcDC2AId(), "AssignSeefd1ToExcDC2ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignSeefd1ToExcDC2ACommand assignment should not be null");
  }

  /**
   * handles unassign Seefd1 validation for a ExcDC2A
   *
   * @param command UnAssignSeefd1FromExcDC2ACommand
   */
  public void validate(UnAssignSeefd1FromExcDC2ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignSeefd1FromExcDC2ACommand should not be null");
    Assert.notNull(
        command.getExcDC2AId(), "UnAssignSeefd1FromExcDC2ACommand identifier should not be null");
  }
  /**
   * handles assign Seefd2 validation for a ExcDC2A
   *
   * @param command AssignSeefd2ToExcDC2ACommand
   */
  public void validate(AssignSeefd2ToExcDC2ACommand command) throws Exception {
    Assert.notNull(command, "AssignSeefd2ToExcDC2ACommand should not be null");
    Assert.notNull(
        command.getExcDC2AId(), "AssignSeefd2ToExcDC2ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignSeefd2ToExcDC2ACommand assignment should not be null");
  }

  /**
   * handles unassign Seefd2 validation for a ExcDC2A
   *
   * @param command UnAssignSeefd2FromExcDC2ACommand
   */
  public void validate(UnAssignSeefd2FromExcDC2ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignSeefd2FromExcDC2ACommand should not be null");
    Assert.notNull(
        command.getExcDC2AId(), "UnAssignSeefd2FromExcDC2ACommand identifier should not be null");
  }
  /**
   * handles assign Ta validation for a ExcDC2A
   *
   * @param command AssignTaToExcDC2ACommand
   */
  public void validate(AssignTaToExcDC2ACommand command) throws Exception {
    Assert.notNull(command, "AssignTaToExcDC2ACommand should not be null");
    Assert.notNull(
        command.getExcDC2AId(), "AssignTaToExcDC2ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTaToExcDC2ACommand assignment should not be null");
  }

  /**
   * handles unassign Ta validation for a ExcDC2A
   *
   * @param command UnAssignTaFromExcDC2ACommand
   */
  public void validate(UnAssignTaFromExcDC2ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignTaFromExcDC2ACommand should not be null");
    Assert.notNull(
        command.getExcDC2AId(), "UnAssignTaFromExcDC2ACommand identifier should not be null");
  }
  /**
   * handles assign Tb validation for a ExcDC2A
   *
   * @param command AssignTbToExcDC2ACommand
   */
  public void validate(AssignTbToExcDC2ACommand command) throws Exception {
    Assert.notNull(command, "AssignTbToExcDC2ACommand should not be null");
    Assert.notNull(
        command.getExcDC2AId(), "AssignTbToExcDC2ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTbToExcDC2ACommand assignment should not be null");
  }

  /**
   * handles unassign Tb validation for a ExcDC2A
   *
   * @param command UnAssignTbFromExcDC2ACommand
   */
  public void validate(UnAssignTbFromExcDC2ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignTbFromExcDC2ACommand should not be null");
    Assert.notNull(
        command.getExcDC2AId(), "UnAssignTbFromExcDC2ACommand identifier should not be null");
  }
  /**
   * handles assign Tc validation for a ExcDC2A
   *
   * @param command AssignTcToExcDC2ACommand
   */
  public void validate(AssignTcToExcDC2ACommand command) throws Exception {
    Assert.notNull(command, "AssignTcToExcDC2ACommand should not be null");
    Assert.notNull(
        command.getExcDC2AId(), "AssignTcToExcDC2ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTcToExcDC2ACommand assignment should not be null");
  }

  /**
   * handles unassign Tc validation for a ExcDC2A
   *
   * @param command UnAssignTcFromExcDC2ACommand
   */
  public void validate(UnAssignTcFromExcDC2ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignTcFromExcDC2ACommand should not be null");
    Assert.notNull(
        command.getExcDC2AId(), "UnAssignTcFromExcDC2ACommand identifier should not be null");
  }
  /**
   * handles assign Te validation for a ExcDC2A
   *
   * @param command AssignTeToExcDC2ACommand
   */
  public void validate(AssignTeToExcDC2ACommand command) throws Exception {
    Assert.notNull(command, "AssignTeToExcDC2ACommand should not be null");
    Assert.notNull(
        command.getExcDC2AId(), "AssignTeToExcDC2ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTeToExcDC2ACommand assignment should not be null");
  }

  /**
   * handles unassign Te validation for a ExcDC2A
   *
   * @param command UnAssignTeFromExcDC2ACommand
   */
  public void validate(UnAssignTeFromExcDC2ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignTeFromExcDC2ACommand should not be null");
    Assert.notNull(
        command.getExcDC2AId(), "UnAssignTeFromExcDC2ACommand identifier should not be null");
  }
  /**
   * handles assign Tf validation for a ExcDC2A
   *
   * @param command AssignTfToExcDC2ACommand
   */
  public void validate(AssignTfToExcDC2ACommand command) throws Exception {
    Assert.notNull(command, "AssignTfToExcDC2ACommand should not be null");
    Assert.notNull(
        command.getExcDC2AId(), "AssignTfToExcDC2ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTfToExcDC2ACommand assignment should not be null");
  }

  /**
   * handles unassign Tf validation for a ExcDC2A
   *
   * @param command UnAssignTfFromExcDC2ACommand
   */
  public void validate(UnAssignTfFromExcDC2ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignTfFromExcDC2ACommand should not be null");
    Assert.notNull(
        command.getExcDC2AId(), "UnAssignTfFromExcDC2ACommand identifier should not be null");
  }
  /**
   * handles assign Tf1 validation for a ExcDC2A
   *
   * @param command AssignTf1ToExcDC2ACommand
   */
  public void validate(AssignTf1ToExcDC2ACommand command) throws Exception {
    Assert.notNull(command, "AssignTf1ToExcDC2ACommand should not be null");
    Assert.notNull(
        command.getExcDC2AId(), "AssignTf1ToExcDC2ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTf1ToExcDC2ACommand assignment should not be null");
  }

  /**
   * handles unassign Tf1 validation for a ExcDC2A
   *
   * @param command UnAssignTf1FromExcDC2ACommand
   */
  public void validate(UnAssignTf1FromExcDC2ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignTf1FromExcDC2ACommand should not be null");
    Assert.notNull(
        command.getExcDC2AId(), "UnAssignTf1FromExcDC2ACommand identifier should not be null");
  }
  /**
   * handles assign Vrmax validation for a ExcDC2A
   *
   * @param command AssignVrmaxToExcDC2ACommand
   */
  public void validate(AssignVrmaxToExcDC2ACommand command) throws Exception {
    Assert.notNull(command, "AssignVrmaxToExcDC2ACommand should not be null");
    Assert.notNull(
        command.getExcDC2AId(), "AssignVrmaxToExcDC2ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVrmaxToExcDC2ACommand assignment should not be null");
  }

  /**
   * handles unassign Vrmax validation for a ExcDC2A
   *
   * @param command UnAssignVrmaxFromExcDC2ACommand
   */
  public void validate(UnAssignVrmaxFromExcDC2ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignVrmaxFromExcDC2ACommand should not be null");
    Assert.notNull(
        command.getExcDC2AId(), "UnAssignVrmaxFromExcDC2ACommand identifier should not be null");
  }
  /**
   * handles assign Vrmin validation for a ExcDC2A
   *
   * @param command AssignVrminToExcDC2ACommand
   */
  public void validate(AssignVrminToExcDC2ACommand command) throws Exception {
    Assert.notNull(command, "AssignVrminToExcDC2ACommand should not be null");
    Assert.notNull(
        command.getExcDC2AId(), "AssignVrminToExcDC2ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVrminToExcDC2ACommand assignment should not be null");
  }

  /**
   * handles unassign Vrmin validation for a ExcDC2A
   *
   * @param command UnAssignVrminFromExcDC2ACommand
   */
  public void validate(UnAssignVrminFromExcDC2ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignVrminFromExcDC2ACommand should not be null");
    Assert.notNull(
        command.getExcDC2AId(), "UnAssignVrminFromExcDC2ACommand identifier should not be null");
  }
  /**
   * handles assign Vtlim validation for a ExcDC2A
   *
   * @param command AssignVtlimToExcDC2ACommand
   */
  public void validate(AssignVtlimToExcDC2ACommand command) throws Exception {
    Assert.notNull(command, "AssignVtlimToExcDC2ACommand should not be null");
    Assert.notNull(
        command.getExcDC2AId(), "AssignVtlimToExcDC2ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVtlimToExcDC2ACommand assignment should not be null");
  }

  /**
   * handles unassign Vtlim validation for a ExcDC2A
   *
   * @param command UnAssignVtlimFromExcDC2ACommand
   */
  public void validate(UnAssignVtlimFromExcDC2ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignVtlimFromExcDC2ACommand should not be null");
    Assert.notNull(
        command.getExcDC2AId(), "UnAssignVtlimFromExcDC2ACommand identifier should not be null");
  }
}
