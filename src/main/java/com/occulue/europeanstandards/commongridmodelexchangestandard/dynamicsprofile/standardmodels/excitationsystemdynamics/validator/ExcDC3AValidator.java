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

public class ExcDC3AValidator {

  /** default constructor */
  protected ExcDC3AValidator() {}

  /** factory method */
  public static ExcDC3AValidator getInstance() {
    return new ExcDC3AValidator();
  }

  /** handles creation validation for a ExcDC3A */
  public void validate(CreateExcDC3ACommand excDC3A) throws Exception {
    Assert.notNull(excDC3A, "CreateExcDC3ACommand should not be null");
    //		Assert.isNull( excDC3A.getExcDC3AId(), "CreateExcDC3ACommand identifier should be null" );
  }

  /** handles update validation for a ExcDC3A */
  public void validate(UpdateExcDC3ACommand excDC3A) throws Exception {
    Assert.notNull(excDC3A, "UpdateExcDC3ACommand should not be null");
    Assert.notNull(excDC3A.getExcDC3AId(), "UpdateExcDC3ACommand identifier should not be null");
  }

  /** handles delete validation for a ExcDC3A */
  public void validate(DeleteExcDC3ACommand excDC3A) throws Exception {
    Assert.notNull(excDC3A, "{commandAlias} should not be null");
    Assert.notNull(excDC3A.getExcDC3AId(), "DeleteExcDC3ACommand identifier should not be null");
  }

  /** handles fetchOne validation for a ExcDC3A */
  public void validate(ExcDC3AFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "ExcDC3AFetchOneSummary should not be null");
    Assert.notNull(summary.getExcDC3AId(), "ExcDC3AFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Edfmax validation for a ExcDC3A
   *
   * @param command AssignEdfmaxToExcDC3ACommand
   */
  public void validate(AssignEdfmaxToExcDC3ACommand command) throws Exception {
    Assert.notNull(command, "AssignEdfmaxToExcDC3ACommand should not be null");
    Assert.notNull(
        command.getExcDC3AId(), "AssignEdfmaxToExcDC3ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignEdfmaxToExcDC3ACommand assignment should not be null");
  }

  /**
   * handles unassign Edfmax validation for a ExcDC3A
   *
   * @param command UnAssignEdfmaxFromExcDC3ACommand
   */
  public void validate(UnAssignEdfmaxFromExcDC3ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignEdfmaxFromExcDC3ACommand should not be null");
    Assert.notNull(
        command.getExcDC3AId(), "UnAssignEdfmaxFromExcDC3ACommand identifier should not be null");
  }
  /**
   * handles assign Efd1 validation for a ExcDC3A
   *
   * @param command AssignEfd1ToExcDC3ACommand
   */
  public void validate(AssignEfd1ToExcDC3ACommand command) throws Exception {
    Assert.notNull(command, "AssignEfd1ToExcDC3ACommand should not be null");
    Assert.notNull(
        command.getExcDC3AId(), "AssignEfd1ToExcDC3ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignEfd1ToExcDC3ACommand assignment should not be null");
  }

  /**
   * handles unassign Efd1 validation for a ExcDC3A
   *
   * @param command UnAssignEfd1FromExcDC3ACommand
   */
  public void validate(UnAssignEfd1FromExcDC3ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignEfd1FromExcDC3ACommand should not be null");
    Assert.notNull(
        command.getExcDC3AId(), "UnAssignEfd1FromExcDC3ACommand identifier should not be null");
  }
  /**
   * handles assign Efd2 validation for a ExcDC3A
   *
   * @param command AssignEfd2ToExcDC3ACommand
   */
  public void validate(AssignEfd2ToExcDC3ACommand command) throws Exception {
    Assert.notNull(command, "AssignEfd2ToExcDC3ACommand should not be null");
    Assert.notNull(
        command.getExcDC3AId(), "AssignEfd2ToExcDC3ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignEfd2ToExcDC3ACommand assignment should not be null");
  }

  /**
   * handles unassign Efd2 validation for a ExcDC3A
   *
   * @param command UnAssignEfd2FromExcDC3ACommand
   */
  public void validate(UnAssignEfd2FromExcDC3ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignEfd2FromExcDC3ACommand should not be null");
    Assert.notNull(
        command.getExcDC3AId(), "UnAssignEfd2FromExcDC3ACommand identifier should not be null");
  }
  /**
   * handles assign Efdlim validation for a ExcDC3A
   *
   * @param command AssignEfdlimToExcDC3ACommand
   */
  public void validate(AssignEfdlimToExcDC3ACommand command) throws Exception {
    Assert.notNull(command, "AssignEfdlimToExcDC3ACommand should not be null");
    Assert.notNull(
        command.getExcDC3AId(), "AssignEfdlimToExcDC3ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignEfdlimToExcDC3ACommand assignment should not be null");
  }

  /**
   * handles unassign Efdlim validation for a ExcDC3A
   *
   * @param command UnAssignEfdlimFromExcDC3ACommand
   */
  public void validate(UnAssignEfdlimFromExcDC3ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignEfdlimFromExcDC3ACommand should not be null");
    Assert.notNull(
        command.getExcDC3AId(), "UnAssignEfdlimFromExcDC3ACommand identifier should not be null");
  }
  /**
   * handles assign Efdmin validation for a ExcDC3A
   *
   * @param command AssignEfdminToExcDC3ACommand
   */
  public void validate(AssignEfdminToExcDC3ACommand command) throws Exception {
    Assert.notNull(command, "AssignEfdminToExcDC3ACommand should not be null");
    Assert.notNull(
        command.getExcDC3AId(), "AssignEfdminToExcDC3ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignEfdminToExcDC3ACommand assignment should not be null");
  }

  /**
   * handles unassign Efdmin validation for a ExcDC3A
   *
   * @param command UnAssignEfdminFromExcDC3ACommand
   */
  public void validate(UnAssignEfdminFromExcDC3ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignEfdminFromExcDC3ACommand should not be null");
    Assert.notNull(
        command.getExcDC3AId(), "UnAssignEfdminFromExcDC3ACommand identifier should not be null");
  }
  /**
   * handles assign Exclim validation for a ExcDC3A
   *
   * @param command AssignExclimToExcDC3ACommand
   */
  public void validate(AssignExclimToExcDC3ACommand command) throws Exception {
    Assert.notNull(command, "AssignExclimToExcDC3ACommand should not be null");
    Assert.notNull(
        command.getExcDC3AId(), "AssignExclimToExcDC3ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignExclimToExcDC3ACommand assignment should not be null");
  }

  /**
   * handles unassign Exclim validation for a ExcDC3A
   *
   * @param command UnAssignExclimFromExcDC3ACommand
   */
  public void validate(UnAssignExclimFromExcDC3ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignExclimFromExcDC3ACommand should not be null");
    Assert.notNull(
        command.getExcDC3AId(), "UnAssignExclimFromExcDC3ACommand identifier should not be null");
  }
  /**
   * handles assign Ke validation for a ExcDC3A
   *
   * @param command AssignKeToExcDC3ACommand
   */
  public void validate(AssignKeToExcDC3ACommand command) throws Exception {
    Assert.notNull(command, "AssignKeToExcDC3ACommand should not be null");
    Assert.notNull(
        command.getExcDC3AId(), "AssignKeToExcDC3ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKeToExcDC3ACommand assignment should not be null");
  }

  /**
   * handles unassign Ke validation for a ExcDC3A
   *
   * @param command UnAssignKeFromExcDC3ACommand
   */
  public void validate(UnAssignKeFromExcDC3ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignKeFromExcDC3ACommand should not be null");
    Assert.notNull(
        command.getExcDC3AId(), "UnAssignKeFromExcDC3ACommand identifier should not be null");
  }
  /**
   * handles assign Kr validation for a ExcDC3A
   *
   * @param command AssignKrToExcDC3ACommand
   */
  public void validate(AssignKrToExcDC3ACommand command) throws Exception {
    Assert.notNull(command, "AssignKrToExcDC3ACommand should not be null");
    Assert.notNull(
        command.getExcDC3AId(), "AssignKrToExcDC3ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKrToExcDC3ACommand assignment should not be null");
  }

  /**
   * handles unassign Kr validation for a ExcDC3A
   *
   * @param command UnAssignKrFromExcDC3ACommand
   */
  public void validate(UnAssignKrFromExcDC3ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignKrFromExcDC3ACommand should not be null");
    Assert.notNull(
        command.getExcDC3AId(), "UnAssignKrFromExcDC3ACommand identifier should not be null");
  }
  /**
   * handles assign Ks validation for a ExcDC3A
   *
   * @param command AssignKsToExcDC3ACommand
   */
  public void validate(AssignKsToExcDC3ACommand command) throws Exception {
    Assert.notNull(command, "AssignKsToExcDC3ACommand should not be null");
    Assert.notNull(
        command.getExcDC3AId(), "AssignKsToExcDC3ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKsToExcDC3ACommand assignment should not be null");
  }

  /**
   * handles unassign Ks validation for a ExcDC3A
   *
   * @param command UnAssignKsFromExcDC3ACommand
   */
  public void validate(UnAssignKsFromExcDC3ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignKsFromExcDC3ACommand should not be null");
    Assert.notNull(
        command.getExcDC3AId(), "UnAssignKsFromExcDC3ACommand identifier should not be null");
  }
  /**
   * handles assign Kv validation for a ExcDC3A
   *
   * @param command AssignKvToExcDC3ACommand
   */
  public void validate(AssignKvToExcDC3ACommand command) throws Exception {
    Assert.notNull(command, "AssignKvToExcDC3ACommand should not be null");
    Assert.notNull(
        command.getExcDC3AId(), "AssignKvToExcDC3ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKvToExcDC3ACommand assignment should not be null");
  }

  /**
   * handles unassign Kv validation for a ExcDC3A
   *
   * @param command UnAssignKvFromExcDC3ACommand
   */
  public void validate(UnAssignKvFromExcDC3ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignKvFromExcDC3ACommand should not be null");
    Assert.notNull(
        command.getExcDC3AId(), "UnAssignKvFromExcDC3ACommand identifier should not be null");
  }
  /**
   * handles assign Seefd1 validation for a ExcDC3A
   *
   * @param command AssignSeefd1ToExcDC3ACommand
   */
  public void validate(AssignSeefd1ToExcDC3ACommand command) throws Exception {
    Assert.notNull(command, "AssignSeefd1ToExcDC3ACommand should not be null");
    Assert.notNull(
        command.getExcDC3AId(), "AssignSeefd1ToExcDC3ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignSeefd1ToExcDC3ACommand assignment should not be null");
  }

  /**
   * handles unassign Seefd1 validation for a ExcDC3A
   *
   * @param command UnAssignSeefd1FromExcDC3ACommand
   */
  public void validate(UnAssignSeefd1FromExcDC3ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignSeefd1FromExcDC3ACommand should not be null");
    Assert.notNull(
        command.getExcDC3AId(), "UnAssignSeefd1FromExcDC3ACommand identifier should not be null");
  }
  /**
   * handles assign Seefd2 validation for a ExcDC3A
   *
   * @param command AssignSeefd2ToExcDC3ACommand
   */
  public void validate(AssignSeefd2ToExcDC3ACommand command) throws Exception {
    Assert.notNull(command, "AssignSeefd2ToExcDC3ACommand should not be null");
    Assert.notNull(
        command.getExcDC3AId(), "AssignSeefd2ToExcDC3ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignSeefd2ToExcDC3ACommand assignment should not be null");
  }

  /**
   * handles unassign Seefd2 validation for a ExcDC3A
   *
   * @param command UnAssignSeefd2FromExcDC3ACommand
   */
  public void validate(UnAssignSeefd2FromExcDC3ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignSeefd2FromExcDC3ACommand should not be null");
    Assert.notNull(
        command.getExcDC3AId(), "UnAssignSeefd2FromExcDC3ACommand identifier should not be null");
  }
  /**
   * handles assign Te validation for a ExcDC3A
   *
   * @param command AssignTeToExcDC3ACommand
   */
  public void validate(AssignTeToExcDC3ACommand command) throws Exception {
    Assert.notNull(command, "AssignTeToExcDC3ACommand should not be null");
    Assert.notNull(
        command.getExcDC3AId(), "AssignTeToExcDC3ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTeToExcDC3ACommand assignment should not be null");
  }

  /**
   * handles unassign Te validation for a ExcDC3A
   *
   * @param command UnAssignTeFromExcDC3ACommand
   */
  public void validate(UnAssignTeFromExcDC3ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignTeFromExcDC3ACommand should not be null");
    Assert.notNull(
        command.getExcDC3AId(), "UnAssignTeFromExcDC3ACommand identifier should not be null");
  }
  /**
   * handles assign Trh validation for a ExcDC3A
   *
   * @param command AssignTrhToExcDC3ACommand
   */
  public void validate(AssignTrhToExcDC3ACommand command) throws Exception {
    Assert.notNull(command, "AssignTrhToExcDC3ACommand should not be null");
    Assert.notNull(
        command.getExcDC3AId(), "AssignTrhToExcDC3ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTrhToExcDC3ACommand assignment should not be null");
  }

  /**
   * handles unassign Trh validation for a ExcDC3A
   *
   * @param command UnAssignTrhFromExcDC3ACommand
   */
  public void validate(UnAssignTrhFromExcDC3ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignTrhFromExcDC3ACommand should not be null");
    Assert.notNull(
        command.getExcDC3AId(), "UnAssignTrhFromExcDC3ACommand identifier should not be null");
  }
  /**
   * handles assign Vrmax validation for a ExcDC3A
   *
   * @param command AssignVrmaxToExcDC3ACommand
   */
  public void validate(AssignVrmaxToExcDC3ACommand command) throws Exception {
    Assert.notNull(command, "AssignVrmaxToExcDC3ACommand should not be null");
    Assert.notNull(
        command.getExcDC3AId(), "AssignVrmaxToExcDC3ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVrmaxToExcDC3ACommand assignment should not be null");
  }

  /**
   * handles unassign Vrmax validation for a ExcDC3A
   *
   * @param command UnAssignVrmaxFromExcDC3ACommand
   */
  public void validate(UnAssignVrmaxFromExcDC3ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignVrmaxFromExcDC3ACommand should not be null");
    Assert.notNull(
        command.getExcDC3AId(), "UnAssignVrmaxFromExcDC3ACommand identifier should not be null");
  }
  /**
   * handles assign Vrmin validation for a ExcDC3A
   *
   * @param command AssignVrminToExcDC3ACommand
   */
  public void validate(AssignVrminToExcDC3ACommand command) throws Exception {
    Assert.notNull(command, "AssignVrminToExcDC3ACommand should not be null");
    Assert.notNull(
        command.getExcDC3AId(), "AssignVrminToExcDC3ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVrminToExcDC3ACommand assignment should not be null");
  }

  /**
   * handles unassign Vrmin validation for a ExcDC3A
   *
   * @param command UnAssignVrminFromExcDC3ACommand
   */
  public void validate(UnAssignVrminFromExcDC3ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignVrminFromExcDC3ACommand should not be null");
    Assert.notNull(
        command.getExcDC3AId(), "UnAssignVrminFromExcDC3ACommand identifier should not be null");
  }
}
