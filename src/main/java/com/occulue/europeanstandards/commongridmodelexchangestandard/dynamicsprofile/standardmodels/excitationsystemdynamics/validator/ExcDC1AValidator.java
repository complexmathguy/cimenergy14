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

public class ExcDC1AValidator {

  /** default constructor */
  protected ExcDC1AValidator() {}

  /** factory method */
  public static ExcDC1AValidator getInstance() {
    return new ExcDC1AValidator();
  }

  /** handles creation validation for a ExcDC1A */
  public void validate(CreateExcDC1ACommand excDC1A) throws Exception {
    Assert.notNull(excDC1A, "CreateExcDC1ACommand should not be null");
    //		Assert.isNull( excDC1A.getExcDC1AId(), "CreateExcDC1ACommand identifier should be null" );
  }

  /** handles update validation for a ExcDC1A */
  public void validate(UpdateExcDC1ACommand excDC1A) throws Exception {
    Assert.notNull(excDC1A, "UpdateExcDC1ACommand should not be null");
    Assert.notNull(excDC1A.getExcDC1AId(), "UpdateExcDC1ACommand identifier should not be null");
  }

  /** handles delete validation for a ExcDC1A */
  public void validate(DeleteExcDC1ACommand excDC1A) throws Exception {
    Assert.notNull(excDC1A, "{commandAlias} should not be null");
    Assert.notNull(excDC1A.getExcDC1AId(), "DeleteExcDC1ACommand identifier should not be null");
  }

  /** handles fetchOne validation for a ExcDC1A */
  public void validate(ExcDC1AFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "ExcDC1AFetchOneSummary should not be null");
    Assert.notNull(summary.getExcDC1AId(), "ExcDC1AFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Edfmax validation for a ExcDC1A
   *
   * @param command AssignEdfmaxToExcDC1ACommand
   */
  public void validate(AssignEdfmaxToExcDC1ACommand command) throws Exception {
    Assert.notNull(command, "AssignEdfmaxToExcDC1ACommand should not be null");
    Assert.notNull(
        command.getExcDC1AId(), "AssignEdfmaxToExcDC1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignEdfmaxToExcDC1ACommand assignment should not be null");
  }

  /**
   * handles unassign Edfmax validation for a ExcDC1A
   *
   * @param command UnAssignEdfmaxFromExcDC1ACommand
   */
  public void validate(UnAssignEdfmaxFromExcDC1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignEdfmaxFromExcDC1ACommand should not be null");
    Assert.notNull(
        command.getExcDC1AId(), "UnAssignEdfmaxFromExcDC1ACommand identifier should not be null");
  }
  /**
   * handles assign Efd1 validation for a ExcDC1A
   *
   * @param command AssignEfd1ToExcDC1ACommand
   */
  public void validate(AssignEfd1ToExcDC1ACommand command) throws Exception {
    Assert.notNull(command, "AssignEfd1ToExcDC1ACommand should not be null");
    Assert.notNull(
        command.getExcDC1AId(), "AssignEfd1ToExcDC1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignEfd1ToExcDC1ACommand assignment should not be null");
  }

  /**
   * handles unassign Efd1 validation for a ExcDC1A
   *
   * @param command UnAssignEfd1FromExcDC1ACommand
   */
  public void validate(UnAssignEfd1FromExcDC1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignEfd1FromExcDC1ACommand should not be null");
    Assert.notNull(
        command.getExcDC1AId(), "UnAssignEfd1FromExcDC1ACommand identifier should not be null");
  }
  /**
   * handles assign Efd2 validation for a ExcDC1A
   *
   * @param command AssignEfd2ToExcDC1ACommand
   */
  public void validate(AssignEfd2ToExcDC1ACommand command) throws Exception {
    Assert.notNull(command, "AssignEfd2ToExcDC1ACommand should not be null");
    Assert.notNull(
        command.getExcDC1AId(), "AssignEfd2ToExcDC1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignEfd2ToExcDC1ACommand assignment should not be null");
  }

  /**
   * handles unassign Efd2 validation for a ExcDC1A
   *
   * @param command UnAssignEfd2FromExcDC1ACommand
   */
  public void validate(UnAssignEfd2FromExcDC1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignEfd2FromExcDC1ACommand should not be null");
    Assert.notNull(
        command.getExcDC1AId(), "UnAssignEfd2FromExcDC1ACommand identifier should not be null");
  }
  /**
   * handles assign Efdmin validation for a ExcDC1A
   *
   * @param command AssignEfdminToExcDC1ACommand
   */
  public void validate(AssignEfdminToExcDC1ACommand command) throws Exception {
    Assert.notNull(command, "AssignEfdminToExcDC1ACommand should not be null");
    Assert.notNull(
        command.getExcDC1AId(), "AssignEfdminToExcDC1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignEfdminToExcDC1ACommand assignment should not be null");
  }

  /**
   * handles unassign Efdmin validation for a ExcDC1A
   *
   * @param command UnAssignEfdminFromExcDC1ACommand
   */
  public void validate(UnAssignEfdminFromExcDC1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignEfdminFromExcDC1ACommand should not be null");
    Assert.notNull(
        command.getExcDC1AId(), "UnAssignEfdminFromExcDC1ACommand identifier should not be null");
  }
  /**
   * handles assign Exclim validation for a ExcDC1A
   *
   * @param command AssignExclimToExcDC1ACommand
   */
  public void validate(AssignExclimToExcDC1ACommand command) throws Exception {
    Assert.notNull(command, "AssignExclimToExcDC1ACommand should not be null");
    Assert.notNull(
        command.getExcDC1AId(), "AssignExclimToExcDC1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignExclimToExcDC1ACommand assignment should not be null");
  }

  /**
   * handles unassign Exclim validation for a ExcDC1A
   *
   * @param command UnAssignExclimFromExcDC1ACommand
   */
  public void validate(UnAssignExclimFromExcDC1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignExclimFromExcDC1ACommand should not be null");
    Assert.notNull(
        command.getExcDC1AId(), "UnAssignExclimFromExcDC1ACommand identifier should not be null");
  }
  /**
   * handles assign Ka validation for a ExcDC1A
   *
   * @param command AssignKaToExcDC1ACommand
   */
  public void validate(AssignKaToExcDC1ACommand command) throws Exception {
    Assert.notNull(command, "AssignKaToExcDC1ACommand should not be null");
    Assert.notNull(
        command.getExcDC1AId(), "AssignKaToExcDC1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKaToExcDC1ACommand assignment should not be null");
  }

  /**
   * handles unassign Ka validation for a ExcDC1A
   *
   * @param command UnAssignKaFromExcDC1ACommand
   */
  public void validate(UnAssignKaFromExcDC1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignKaFromExcDC1ACommand should not be null");
    Assert.notNull(
        command.getExcDC1AId(), "UnAssignKaFromExcDC1ACommand identifier should not be null");
  }
  /**
   * handles assign Ke validation for a ExcDC1A
   *
   * @param command AssignKeToExcDC1ACommand
   */
  public void validate(AssignKeToExcDC1ACommand command) throws Exception {
    Assert.notNull(command, "AssignKeToExcDC1ACommand should not be null");
    Assert.notNull(
        command.getExcDC1AId(), "AssignKeToExcDC1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKeToExcDC1ACommand assignment should not be null");
  }

  /**
   * handles unassign Ke validation for a ExcDC1A
   *
   * @param command UnAssignKeFromExcDC1ACommand
   */
  public void validate(UnAssignKeFromExcDC1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignKeFromExcDC1ACommand should not be null");
    Assert.notNull(
        command.getExcDC1AId(), "UnAssignKeFromExcDC1ACommand identifier should not be null");
  }
  /**
   * handles assign Kf validation for a ExcDC1A
   *
   * @param command AssignKfToExcDC1ACommand
   */
  public void validate(AssignKfToExcDC1ACommand command) throws Exception {
    Assert.notNull(command, "AssignKfToExcDC1ACommand should not be null");
    Assert.notNull(
        command.getExcDC1AId(), "AssignKfToExcDC1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKfToExcDC1ACommand assignment should not be null");
  }

  /**
   * handles unassign Kf validation for a ExcDC1A
   *
   * @param command UnAssignKfFromExcDC1ACommand
   */
  public void validate(UnAssignKfFromExcDC1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignKfFromExcDC1ACommand should not be null");
    Assert.notNull(
        command.getExcDC1AId(), "UnAssignKfFromExcDC1ACommand identifier should not be null");
  }
  /**
   * handles assign Ks validation for a ExcDC1A
   *
   * @param command AssignKsToExcDC1ACommand
   */
  public void validate(AssignKsToExcDC1ACommand command) throws Exception {
    Assert.notNull(command, "AssignKsToExcDC1ACommand should not be null");
    Assert.notNull(
        command.getExcDC1AId(), "AssignKsToExcDC1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKsToExcDC1ACommand assignment should not be null");
  }

  /**
   * handles unassign Ks validation for a ExcDC1A
   *
   * @param command UnAssignKsFromExcDC1ACommand
   */
  public void validate(UnAssignKsFromExcDC1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignKsFromExcDC1ACommand should not be null");
    Assert.notNull(
        command.getExcDC1AId(), "UnAssignKsFromExcDC1ACommand identifier should not be null");
  }
  /**
   * handles assign Seefd1 validation for a ExcDC1A
   *
   * @param command AssignSeefd1ToExcDC1ACommand
   */
  public void validate(AssignSeefd1ToExcDC1ACommand command) throws Exception {
    Assert.notNull(command, "AssignSeefd1ToExcDC1ACommand should not be null");
    Assert.notNull(
        command.getExcDC1AId(), "AssignSeefd1ToExcDC1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignSeefd1ToExcDC1ACommand assignment should not be null");
  }

  /**
   * handles unassign Seefd1 validation for a ExcDC1A
   *
   * @param command UnAssignSeefd1FromExcDC1ACommand
   */
  public void validate(UnAssignSeefd1FromExcDC1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignSeefd1FromExcDC1ACommand should not be null");
    Assert.notNull(
        command.getExcDC1AId(), "UnAssignSeefd1FromExcDC1ACommand identifier should not be null");
  }
  /**
   * handles assign Seefd2 validation for a ExcDC1A
   *
   * @param command AssignSeefd2ToExcDC1ACommand
   */
  public void validate(AssignSeefd2ToExcDC1ACommand command) throws Exception {
    Assert.notNull(command, "AssignSeefd2ToExcDC1ACommand should not be null");
    Assert.notNull(
        command.getExcDC1AId(), "AssignSeefd2ToExcDC1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignSeefd2ToExcDC1ACommand assignment should not be null");
  }

  /**
   * handles unassign Seefd2 validation for a ExcDC1A
   *
   * @param command UnAssignSeefd2FromExcDC1ACommand
   */
  public void validate(UnAssignSeefd2FromExcDC1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignSeefd2FromExcDC1ACommand should not be null");
    Assert.notNull(
        command.getExcDC1AId(), "UnAssignSeefd2FromExcDC1ACommand identifier should not be null");
  }
  /**
   * handles assign Ta validation for a ExcDC1A
   *
   * @param command AssignTaToExcDC1ACommand
   */
  public void validate(AssignTaToExcDC1ACommand command) throws Exception {
    Assert.notNull(command, "AssignTaToExcDC1ACommand should not be null");
    Assert.notNull(
        command.getExcDC1AId(), "AssignTaToExcDC1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTaToExcDC1ACommand assignment should not be null");
  }

  /**
   * handles unassign Ta validation for a ExcDC1A
   *
   * @param command UnAssignTaFromExcDC1ACommand
   */
  public void validate(UnAssignTaFromExcDC1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignTaFromExcDC1ACommand should not be null");
    Assert.notNull(
        command.getExcDC1AId(), "UnAssignTaFromExcDC1ACommand identifier should not be null");
  }
  /**
   * handles assign Tb validation for a ExcDC1A
   *
   * @param command AssignTbToExcDC1ACommand
   */
  public void validate(AssignTbToExcDC1ACommand command) throws Exception {
    Assert.notNull(command, "AssignTbToExcDC1ACommand should not be null");
    Assert.notNull(
        command.getExcDC1AId(), "AssignTbToExcDC1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTbToExcDC1ACommand assignment should not be null");
  }

  /**
   * handles unassign Tb validation for a ExcDC1A
   *
   * @param command UnAssignTbFromExcDC1ACommand
   */
  public void validate(UnAssignTbFromExcDC1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignTbFromExcDC1ACommand should not be null");
    Assert.notNull(
        command.getExcDC1AId(), "UnAssignTbFromExcDC1ACommand identifier should not be null");
  }
  /**
   * handles assign Tc validation for a ExcDC1A
   *
   * @param command AssignTcToExcDC1ACommand
   */
  public void validate(AssignTcToExcDC1ACommand command) throws Exception {
    Assert.notNull(command, "AssignTcToExcDC1ACommand should not be null");
    Assert.notNull(
        command.getExcDC1AId(), "AssignTcToExcDC1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTcToExcDC1ACommand assignment should not be null");
  }

  /**
   * handles unassign Tc validation for a ExcDC1A
   *
   * @param command UnAssignTcFromExcDC1ACommand
   */
  public void validate(UnAssignTcFromExcDC1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignTcFromExcDC1ACommand should not be null");
    Assert.notNull(
        command.getExcDC1AId(), "UnAssignTcFromExcDC1ACommand identifier should not be null");
  }
  /**
   * handles assign Te validation for a ExcDC1A
   *
   * @param command AssignTeToExcDC1ACommand
   */
  public void validate(AssignTeToExcDC1ACommand command) throws Exception {
    Assert.notNull(command, "AssignTeToExcDC1ACommand should not be null");
    Assert.notNull(
        command.getExcDC1AId(), "AssignTeToExcDC1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTeToExcDC1ACommand assignment should not be null");
  }

  /**
   * handles unassign Te validation for a ExcDC1A
   *
   * @param command UnAssignTeFromExcDC1ACommand
   */
  public void validate(UnAssignTeFromExcDC1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignTeFromExcDC1ACommand should not be null");
    Assert.notNull(
        command.getExcDC1AId(), "UnAssignTeFromExcDC1ACommand identifier should not be null");
  }
  /**
   * handles assign Tf validation for a ExcDC1A
   *
   * @param command AssignTfToExcDC1ACommand
   */
  public void validate(AssignTfToExcDC1ACommand command) throws Exception {
    Assert.notNull(command, "AssignTfToExcDC1ACommand should not be null");
    Assert.notNull(
        command.getExcDC1AId(), "AssignTfToExcDC1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTfToExcDC1ACommand assignment should not be null");
  }

  /**
   * handles unassign Tf validation for a ExcDC1A
   *
   * @param command UnAssignTfFromExcDC1ACommand
   */
  public void validate(UnAssignTfFromExcDC1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignTfFromExcDC1ACommand should not be null");
    Assert.notNull(
        command.getExcDC1AId(), "UnAssignTfFromExcDC1ACommand identifier should not be null");
  }
  /**
   * handles assign Vrmax validation for a ExcDC1A
   *
   * @param command AssignVrmaxToExcDC1ACommand
   */
  public void validate(AssignVrmaxToExcDC1ACommand command) throws Exception {
    Assert.notNull(command, "AssignVrmaxToExcDC1ACommand should not be null");
    Assert.notNull(
        command.getExcDC1AId(), "AssignVrmaxToExcDC1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVrmaxToExcDC1ACommand assignment should not be null");
  }

  /**
   * handles unassign Vrmax validation for a ExcDC1A
   *
   * @param command UnAssignVrmaxFromExcDC1ACommand
   */
  public void validate(UnAssignVrmaxFromExcDC1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignVrmaxFromExcDC1ACommand should not be null");
    Assert.notNull(
        command.getExcDC1AId(), "UnAssignVrmaxFromExcDC1ACommand identifier should not be null");
  }
  /**
   * handles assign Vrmin validation for a ExcDC1A
   *
   * @param command AssignVrminToExcDC1ACommand
   */
  public void validate(AssignVrminToExcDC1ACommand command) throws Exception {
    Assert.notNull(command, "AssignVrminToExcDC1ACommand should not be null");
    Assert.notNull(
        command.getExcDC1AId(), "AssignVrminToExcDC1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVrminToExcDC1ACommand assignment should not be null");
  }

  /**
   * handles unassign Vrmin validation for a ExcDC1A
   *
   * @param command UnAssignVrminFromExcDC1ACommand
   */
  public void validate(UnAssignVrminFromExcDC1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignVrminFromExcDC1ACommand should not be null");
    Assert.notNull(
        command.getExcDC1AId(), "UnAssignVrminFromExcDC1ACommand identifier should not be null");
  }
}
