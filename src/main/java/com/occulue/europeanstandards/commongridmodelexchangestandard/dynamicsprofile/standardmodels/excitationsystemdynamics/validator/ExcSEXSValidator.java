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

public class ExcSEXSValidator {

  /** default constructor */
  protected ExcSEXSValidator() {}

  /** factory method */
  public static ExcSEXSValidator getInstance() {
    return new ExcSEXSValidator();
  }

  /** handles creation validation for a ExcSEXS */
  public void validate(CreateExcSEXSCommand excSEXS) throws Exception {
    Assert.notNull(excSEXS, "CreateExcSEXSCommand should not be null");
    //		Assert.isNull( excSEXS.getExcSEXSId(), "CreateExcSEXSCommand identifier should be null" );
  }

  /** handles update validation for a ExcSEXS */
  public void validate(UpdateExcSEXSCommand excSEXS) throws Exception {
    Assert.notNull(excSEXS, "UpdateExcSEXSCommand should not be null");
    Assert.notNull(excSEXS.getExcSEXSId(), "UpdateExcSEXSCommand identifier should not be null");
  }

  /** handles delete validation for a ExcSEXS */
  public void validate(DeleteExcSEXSCommand excSEXS) throws Exception {
    Assert.notNull(excSEXS, "{commandAlias} should not be null");
    Assert.notNull(excSEXS.getExcSEXSId(), "DeleteExcSEXSCommand identifier should not be null");
  }

  /** handles fetchOne validation for a ExcSEXS */
  public void validate(ExcSEXSFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "ExcSEXSFetchOneSummary should not be null");
    Assert.notNull(summary.getExcSEXSId(), "ExcSEXSFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Efdmax validation for a ExcSEXS
   *
   * @param command AssignEfdmaxToExcSEXSCommand
   */
  public void validate(AssignEfdmaxToExcSEXSCommand command) throws Exception {
    Assert.notNull(command, "AssignEfdmaxToExcSEXSCommand should not be null");
    Assert.notNull(
        command.getExcSEXSId(), "AssignEfdmaxToExcSEXSCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignEfdmaxToExcSEXSCommand assignment should not be null");
  }

  /**
   * handles unassign Efdmax validation for a ExcSEXS
   *
   * @param command UnAssignEfdmaxFromExcSEXSCommand
   */
  public void validate(UnAssignEfdmaxFromExcSEXSCommand command) throws Exception {
    Assert.notNull(command, "UnAssignEfdmaxFromExcSEXSCommand should not be null");
    Assert.notNull(
        command.getExcSEXSId(), "UnAssignEfdmaxFromExcSEXSCommand identifier should not be null");
  }
  /**
   * handles assign Efdmin validation for a ExcSEXS
   *
   * @param command AssignEfdminToExcSEXSCommand
   */
  public void validate(AssignEfdminToExcSEXSCommand command) throws Exception {
    Assert.notNull(command, "AssignEfdminToExcSEXSCommand should not be null");
    Assert.notNull(
        command.getExcSEXSId(), "AssignEfdminToExcSEXSCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignEfdminToExcSEXSCommand assignment should not be null");
  }

  /**
   * handles unassign Efdmin validation for a ExcSEXS
   *
   * @param command UnAssignEfdminFromExcSEXSCommand
   */
  public void validate(UnAssignEfdminFromExcSEXSCommand command) throws Exception {
    Assert.notNull(command, "UnAssignEfdminFromExcSEXSCommand should not be null");
    Assert.notNull(
        command.getExcSEXSId(), "UnAssignEfdminFromExcSEXSCommand identifier should not be null");
  }
  /**
   * handles assign Emax validation for a ExcSEXS
   *
   * @param command AssignEmaxToExcSEXSCommand
   */
  public void validate(AssignEmaxToExcSEXSCommand command) throws Exception {
    Assert.notNull(command, "AssignEmaxToExcSEXSCommand should not be null");
    Assert.notNull(
        command.getExcSEXSId(), "AssignEmaxToExcSEXSCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignEmaxToExcSEXSCommand assignment should not be null");
  }

  /**
   * handles unassign Emax validation for a ExcSEXS
   *
   * @param command UnAssignEmaxFromExcSEXSCommand
   */
  public void validate(UnAssignEmaxFromExcSEXSCommand command) throws Exception {
    Assert.notNull(command, "UnAssignEmaxFromExcSEXSCommand should not be null");
    Assert.notNull(
        command.getExcSEXSId(), "UnAssignEmaxFromExcSEXSCommand identifier should not be null");
  }
  /**
   * handles assign Emin validation for a ExcSEXS
   *
   * @param command AssignEminToExcSEXSCommand
   */
  public void validate(AssignEminToExcSEXSCommand command) throws Exception {
    Assert.notNull(command, "AssignEminToExcSEXSCommand should not be null");
    Assert.notNull(
        command.getExcSEXSId(), "AssignEminToExcSEXSCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignEminToExcSEXSCommand assignment should not be null");
  }

  /**
   * handles unassign Emin validation for a ExcSEXS
   *
   * @param command UnAssignEminFromExcSEXSCommand
   */
  public void validate(UnAssignEminFromExcSEXSCommand command) throws Exception {
    Assert.notNull(command, "UnAssignEminFromExcSEXSCommand should not be null");
    Assert.notNull(
        command.getExcSEXSId(), "UnAssignEminFromExcSEXSCommand identifier should not be null");
  }
  /**
   * handles assign K validation for a ExcSEXS
   *
   * @param command AssignKToExcSEXSCommand
   */
  public void validate(AssignKToExcSEXSCommand command) throws Exception {
    Assert.notNull(command, "AssignKToExcSEXSCommand should not be null");
    Assert.notNull(command.getExcSEXSId(), "AssignKToExcSEXSCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKToExcSEXSCommand assignment should not be null");
  }

  /**
   * handles unassign K validation for a ExcSEXS
   *
   * @param command UnAssignKFromExcSEXSCommand
   */
  public void validate(UnAssignKFromExcSEXSCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKFromExcSEXSCommand should not be null");
    Assert.notNull(
        command.getExcSEXSId(), "UnAssignKFromExcSEXSCommand identifier should not be null");
  }
  /**
   * handles assign Kc validation for a ExcSEXS
   *
   * @param command AssignKcToExcSEXSCommand
   */
  public void validate(AssignKcToExcSEXSCommand command) throws Exception {
    Assert.notNull(command, "AssignKcToExcSEXSCommand should not be null");
    Assert.notNull(
        command.getExcSEXSId(), "AssignKcToExcSEXSCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKcToExcSEXSCommand assignment should not be null");
  }

  /**
   * handles unassign Kc validation for a ExcSEXS
   *
   * @param command UnAssignKcFromExcSEXSCommand
   */
  public void validate(UnAssignKcFromExcSEXSCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKcFromExcSEXSCommand should not be null");
    Assert.notNull(
        command.getExcSEXSId(), "UnAssignKcFromExcSEXSCommand identifier should not be null");
  }
  /**
   * handles assign Tatb validation for a ExcSEXS
   *
   * @param command AssignTatbToExcSEXSCommand
   */
  public void validate(AssignTatbToExcSEXSCommand command) throws Exception {
    Assert.notNull(command, "AssignTatbToExcSEXSCommand should not be null");
    Assert.notNull(
        command.getExcSEXSId(), "AssignTatbToExcSEXSCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTatbToExcSEXSCommand assignment should not be null");
  }

  /**
   * handles unassign Tatb validation for a ExcSEXS
   *
   * @param command UnAssignTatbFromExcSEXSCommand
   */
  public void validate(UnAssignTatbFromExcSEXSCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTatbFromExcSEXSCommand should not be null");
    Assert.notNull(
        command.getExcSEXSId(), "UnAssignTatbFromExcSEXSCommand identifier should not be null");
  }
  /**
   * handles assign Tb validation for a ExcSEXS
   *
   * @param command AssignTbToExcSEXSCommand
   */
  public void validate(AssignTbToExcSEXSCommand command) throws Exception {
    Assert.notNull(command, "AssignTbToExcSEXSCommand should not be null");
    Assert.notNull(
        command.getExcSEXSId(), "AssignTbToExcSEXSCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTbToExcSEXSCommand assignment should not be null");
  }

  /**
   * handles unassign Tb validation for a ExcSEXS
   *
   * @param command UnAssignTbFromExcSEXSCommand
   */
  public void validate(UnAssignTbFromExcSEXSCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTbFromExcSEXSCommand should not be null");
    Assert.notNull(
        command.getExcSEXSId(), "UnAssignTbFromExcSEXSCommand identifier should not be null");
  }
  /**
   * handles assign Tc validation for a ExcSEXS
   *
   * @param command AssignTcToExcSEXSCommand
   */
  public void validate(AssignTcToExcSEXSCommand command) throws Exception {
    Assert.notNull(command, "AssignTcToExcSEXSCommand should not be null");
    Assert.notNull(
        command.getExcSEXSId(), "AssignTcToExcSEXSCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTcToExcSEXSCommand assignment should not be null");
  }

  /**
   * handles unassign Tc validation for a ExcSEXS
   *
   * @param command UnAssignTcFromExcSEXSCommand
   */
  public void validate(UnAssignTcFromExcSEXSCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTcFromExcSEXSCommand should not be null");
    Assert.notNull(
        command.getExcSEXSId(), "UnAssignTcFromExcSEXSCommand identifier should not be null");
  }
  /**
   * handles assign Te validation for a ExcSEXS
   *
   * @param command AssignTeToExcSEXSCommand
   */
  public void validate(AssignTeToExcSEXSCommand command) throws Exception {
    Assert.notNull(command, "AssignTeToExcSEXSCommand should not be null");
    Assert.notNull(
        command.getExcSEXSId(), "AssignTeToExcSEXSCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTeToExcSEXSCommand assignment should not be null");
  }

  /**
   * handles unassign Te validation for a ExcSEXS
   *
   * @param command UnAssignTeFromExcSEXSCommand
   */
  public void validate(UnAssignTeFromExcSEXSCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTeFromExcSEXSCommand should not be null");
    Assert.notNull(
        command.getExcSEXSId(), "UnAssignTeFromExcSEXSCommand identifier should not be null");
  }
}
