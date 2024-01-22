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

public class ExcIEEEDC3AValidator {

  /** default constructor */
  protected ExcIEEEDC3AValidator() {}

  /** factory method */
  public static ExcIEEEDC3AValidator getInstance() {
    return new ExcIEEEDC3AValidator();
  }

  /** handles creation validation for a ExcIEEEDC3A */
  public void validate(CreateExcIEEEDC3ACommand excIEEEDC3A) throws Exception {
    Assert.notNull(excIEEEDC3A, "CreateExcIEEEDC3ACommand should not be null");
    //		Assert.isNull( excIEEEDC3A.getExcIEEEDC3AId(), "CreateExcIEEEDC3ACommand identifier should
    // be null" );
  }

  /** handles update validation for a ExcIEEEDC3A */
  public void validate(UpdateExcIEEEDC3ACommand excIEEEDC3A) throws Exception {
    Assert.notNull(excIEEEDC3A, "UpdateExcIEEEDC3ACommand should not be null");
    Assert.notNull(
        excIEEEDC3A.getExcIEEEDC3AId(), "UpdateExcIEEEDC3ACommand identifier should not be null");
  }

  /** handles delete validation for a ExcIEEEDC3A */
  public void validate(DeleteExcIEEEDC3ACommand excIEEEDC3A) throws Exception {
    Assert.notNull(excIEEEDC3A, "{commandAlias} should not be null");
    Assert.notNull(
        excIEEEDC3A.getExcIEEEDC3AId(), "DeleteExcIEEEDC3ACommand identifier should not be null");
  }

  /** handles fetchOne validation for a ExcIEEEDC3A */
  public void validate(ExcIEEEDC3AFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "ExcIEEEDC3AFetchOneSummary should not be null");
    Assert.notNull(
        summary.getExcIEEEDC3AId(), "ExcIEEEDC3AFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Efd1 validation for a ExcIEEEDC3A
   *
   * @param command AssignEfd1ToExcIEEEDC3ACommand
   */
  public void validate(AssignEfd1ToExcIEEEDC3ACommand command) throws Exception {
    Assert.notNull(command, "AssignEfd1ToExcIEEEDC3ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEDC3AId(), "AssignEfd1ToExcIEEEDC3ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignEfd1ToExcIEEEDC3ACommand assignment should not be null");
  }

  /**
   * handles unassign Efd1 validation for a ExcIEEEDC3A
   *
   * @param command UnAssignEfd1FromExcIEEEDC3ACommand
   */
  public void validate(UnAssignEfd1FromExcIEEEDC3ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignEfd1FromExcIEEEDC3ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEDC3AId(),
        "UnAssignEfd1FromExcIEEEDC3ACommand identifier should not be null");
  }
  /**
   * handles assign Efd2 validation for a ExcIEEEDC3A
   *
   * @param command AssignEfd2ToExcIEEEDC3ACommand
   */
  public void validate(AssignEfd2ToExcIEEEDC3ACommand command) throws Exception {
    Assert.notNull(command, "AssignEfd2ToExcIEEEDC3ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEDC3AId(), "AssignEfd2ToExcIEEEDC3ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignEfd2ToExcIEEEDC3ACommand assignment should not be null");
  }

  /**
   * handles unassign Efd2 validation for a ExcIEEEDC3A
   *
   * @param command UnAssignEfd2FromExcIEEEDC3ACommand
   */
  public void validate(UnAssignEfd2FromExcIEEEDC3ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignEfd2FromExcIEEEDC3ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEDC3AId(),
        "UnAssignEfd2FromExcIEEEDC3ACommand identifier should not be null");
  }
  /**
   * handles assign Exclim validation for a ExcIEEEDC3A
   *
   * @param command AssignExclimToExcIEEEDC3ACommand
   */
  public void validate(AssignExclimToExcIEEEDC3ACommand command) throws Exception {
    Assert.notNull(command, "AssignExclimToExcIEEEDC3ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEDC3AId(),
        "AssignExclimToExcIEEEDC3ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignExclimToExcIEEEDC3ACommand assignment should not be null");
  }

  /**
   * handles unassign Exclim validation for a ExcIEEEDC3A
   *
   * @param command UnAssignExclimFromExcIEEEDC3ACommand
   */
  public void validate(UnAssignExclimFromExcIEEEDC3ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignExclimFromExcIEEEDC3ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEDC3AId(),
        "UnAssignExclimFromExcIEEEDC3ACommand identifier should not be null");
  }
  /**
   * handles assign Ke validation for a ExcIEEEDC3A
   *
   * @param command AssignKeToExcIEEEDC3ACommand
   */
  public void validate(AssignKeToExcIEEEDC3ACommand command) throws Exception {
    Assert.notNull(command, "AssignKeToExcIEEEDC3ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEDC3AId(), "AssignKeToExcIEEEDC3ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKeToExcIEEEDC3ACommand assignment should not be null");
  }

  /**
   * handles unassign Ke validation for a ExcIEEEDC3A
   *
   * @param command UnAssignKeFromExcIEEEDC3ACommand
   */
  public void validate(UnAssignKeFromExcIEEEDC3ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignKeFromExcIEEEDC3ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEDC3AId(),
        "UnAssignKeFromExcIEEEDC3ACommand identifier should not be null");
  }
  /**
   * handles assign Kv validation for a ExcIEEEDC3A
   *
   * @param command AssignKvToExcIEEEDC3ACommand
   */
  public void validate(AssignKvToExcIEEEDC3ACommand command) throws Exception {
    Assert.notNull(command, "AssignKvToExcIEEEDC3ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEDC3AId(), "AssignKvToExcIEEEDC3ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKvToExcIEEEDC3ACommand assignment should not be null");
  }

  /**
   * handles unassign Kv validation for a ExcIEEEDC3A
   *
   * @param command UnAssignKvFromExcIEEEDC3ACommand
   */
  public void validate(UnAssignKvFromExcIEEEDC3ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignKvFromExcIEEEDC3ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEDC3AId(),
        "UnAssignKvFromExcIEEEDC3ACommand identifier should not be null");
  }
  /**
   * handles assign Seefd1 validation for a ExcIEEEDC3A
   *
   * @param command AssignSeefd1ToExcIEEEDC3ACommand
   */
  public void validate(AssignSeefd1ToExcIEEEDC3ACommand command) throws Exception {
    Assert.notNull(command, "AssignSeefd1ToExcIEEEDC3ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEDC3AId(),
        "AssignSeefd1ToExcIEEEDC3ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignSeefd1ToExcIEEEDC3ACommand assignment should not be null");
  }

  /**
   * handles unassign Seefd1 validation for a ExcIEEEDC3A
   *
   * @param command UnAssignSeefd1FromExcIEEEDC3ACommand
   */
  public void validate(UnAssignSeefd1FromExcIEEEDC3ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignSeefd1FromExcIEEEDC3ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEDC3AId(),
        "UnAssignSeefd1FromExcIEEEDC3ACommand identifier should not be null");
  }
  /**
   * handles assign Seefd2 validation for a ExcIEEEDC3A
   *
   * @param command AssignSeefd2ToExcIEEEDC3ACommand
   */
  public void validate(AssignSeefd2ToExcIEEEDC3ACommand command) throws Exception {
    Assert.notNull(command, "AssignSeefd2ToExcIEEEDC3ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEDC3AId(),
        "AssignSeefd2ToExcIEEEDC3ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignSeefd2ToExcIEEEDC3ACommand assignment should not be null");
  }

  /**
   * handles unassign Seefd2 validation for a ExcIEEEDC3A
   *
   * @param command UnAssignSeefd2FromExcIEEEDC3ACommand
   */
  public void validate(UnAssignSeefd2FromExcIEEEDC3ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignSeefd2FromExcIEEEDC3ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEDC3AId(),
        "UnAssignSeefd2FromExcIEEEDC3ACommand identifier should not be null");
  }
  /**
   * handles assign Te validation for a ExcIEEEDC3A
   *
   * @param command AssignTeToExcIEEEDC3ACommand
   */
  public void validate(AssignTeToExcIEEEDC3ACommand command) throws Exception {
    Assert.notNull(command, "AssignTeToExcIEEEDC3ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEDC3AId(), "AssignTeToExcIEEEDC3ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTeToExcIEEEDC3ACommand assignment should not be null");
  }

  /**
   * handles unassign Te validation for a ExcIEEEDC3A
   *
   * @param command UnAssignTeFromExcIEEEDC3ACommand
   */
  public void validate(UnAssignTeFromExcIEEEDC3ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignTeFromExcIEEEDC3ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEDC3AId(),
        "UnAssignTeFromExcIEEEDC3ACommand identifier should not be null");
  }
  /**
   * handles assign Trh validation for a ExcIEEEDC3A
   *
   * @param command AssignTrhToExcIEEEDC3ACommand
   */
  public void validate(AssignTrhToExcIEEEDC3ACommand command) throws Exception {
    Assert.notNull(command, "AssignTrhToExcIEEEDC3ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEDC3AId(), "AssignTrhToExcIEEEDC3ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTrhToExcIEEEDC3ACommand assignment should not be null");
  }

  /**
   * handles unassign Trh validation for a ExcIEEEDC3A
   *
   * @param command UnAssignTrhFromExcIEEEDC3ACommand
   */
  public void validate(UnAssignTrhFromExcIEEEDC3ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignTrhFromExcIEEEDC3ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEDC3AId(),
        "UnAssignTrhFromExcIEEEDC3ACommand identifier should not be null");
  }
  /**
   * handles assign Vrmax validation for a ExcIEEEDC3A
   *
   * @param command AssignVrmaxToExcIEEEDC3ACommand
   */
  public void validate(AssignVrmaxToExcIEEEDC3ACommand command) throws Exception {
    Assert.notNull(command, "AssignVrmaxToExcIEEEDC3ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEDC3AId(),
        "AssignVrmaxToExcIEEEDC3ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVrmaxToExcIEEEDC3ACommand assignment should not be null");
  }

  /**
   * handles unassign Vrmax validation for a ExcIEEEDC3A
   *
   * @param command UnAssignVrmaxFromExcIEEEDC3ACommand
   */
  public void validate(UnAssignVrmaxFromExcIEEEDC3ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignVrmaxFromExcIEEEDC3ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEDC3AId(),
        "UnAssignVrmaxFromExcIEEEDC3ACommand identifier should not be null");
  }
  /**
   * handles assign Vrmin validation for a ExcIEEEDC3A
   *
   * @param command AssignVrminToExcIEEEDC3ACommand
   */
  public void validate(AssignVrminToExcIEEEDC3ACommand command) throws Exception {
    Assert.notNull(command, "AssignVrminToExcIEEEDC3ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEDC3AId(),
        "AssignVrminToExcIEEEDC3ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVrminToExcIEEEDC3ACommand assignment should not be null");
  }

  /**
   * handles unassign Vrmin validation for a ExcIEEEDC3A
   *
   * @param command UnAssignVrminFromExcIEEEDC3ACommand
   */
  public void validate(UnAssignVrminFromExcIEEEDC3ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignVrminFromExcIEEEDC3ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEDC3AId(),
        "UnAssignVrminFromExcIEEEDC3ACommand identifier should not be null");
  }
}
