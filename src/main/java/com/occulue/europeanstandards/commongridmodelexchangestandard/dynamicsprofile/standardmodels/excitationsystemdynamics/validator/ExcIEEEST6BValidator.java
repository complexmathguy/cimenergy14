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

public class ExcIEEEST6BValidator {

  /** default constructor */
  protected ExcIEEEST6BValidator() {}

  /** factory method */
  public static ExcIEEEST6BValidator getInstance() {
    return new ExcIEEEST6BValidator();
  }

  /** handles creation validation for a ExcIEEEST6B */
  public void validate(CreateExcIEEEST6BCommand excIEEEST6B) throws Exception {
    Assert.notNull(excIEEEST6B, "CreateExcIEEEST6BCommand should not be null");
    //		Assert.isNull( excIEEEST6B.getExcIEEEST6BId(), "CreateExcIEEEST6BCommand identifier should
    // be null" );
  }

  /** handles update validation for a ExcIEEEST6B */
  public void validate(UpdateExcIEEEST6BCommand excIEEEST6B) throws Exception {
    Assert.notNull(excIEEEST6B, "UpdateExcIEEEST6BCommand should not be null");
    Assert.notNull(
        excIEEEST6B.getExcIEEEST6BId(), "UpdateExcIEEEST6BCommand identifier should not be null");
  }

  /** handles delete validation for a ExcIEEEST6B */
  public void validate(DeleteExcIEEEST6BCommand excIEEEST6B) throws Exception {
    Assert.notNull(excIEEEST6B, "{commandAlias} should not be null");
    Assert.notNull(
        excIEEEST6B.getExcIEEEST6BId(), "DeleteExcIEEEST6BCommand identifier should not be null");
  }

  /** handles fetchOne validation for a ExcIEEEST6B */
  public void validate(ExcIEEEST6BFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "ExcIEEEST6BFetchOneSummary should not be null");
    Assert.notNull(
        summary.getExcIEEEST6BId(), "ExcIEEEST6BFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Ilr validation for a ExcIEEEST6B
   *
   * @param command AssignIlrToExcIEEEST6BCommand
   */
  public void validate(AssignIlrToExcIEEEST6BCommand command) throws Exception {
    Assert.notNull(command, "AssignIlrToExcIEEEST6BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEST6BId(), "AssignIlrToExcIEEEST6BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignIlrToExcIEEEST6BCommand assignment should not be null");
  }

  /**
   * handles unassign Ilr validation for a ExcIEEEST6B
   *
   * @param command UnAssignIlrFromExcIEEEST6BCommand
   */
  public void validate(UnAssignIlrFromExcIEEEST6BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignIlrFromExcIEEEST6BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEST6BId(),
        "UnAssignIlrFromExcIEEEST6BCommand identifier should not be null");
  }
  /**
   * handles assign Kci validation for a ExcIEEEST6B
   *
   * @param command AssignKciToExcIEEEST6BCommand
   */
  public void validate(AssignKciToExcIEEEST6BCommand command) throws Exception {
    Assert.notNull(command, "AssignKciToExcIEEEST6BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEST6BId(), "AssignKciToExcIEEEST6BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKciToExcIEEEST6BCommand assignment should not be null");
  }

  /**
   * handles unassign Kci validation for a ExcIEEEST6B
   *
   * @param command UnAssignKciFromExcIEEEST6BCommand
   */
  public void validate(UnAssignKciFromExcIEEEST6BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKciFromExcIEEEST6BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEST6BId(),
        "UnAssignKciFromExcIEEEST6BCommand identifier should not be null");
  }
  /**
   * handles assign Kff validation for a ExcIEEEST6B
   *
   * @param command AssignKffToExcIEEEST6BCommand
   */
  public void validate(AssignKffToExcIEEEST6BCommand command) throws Exception {
    Assert.notNull(command, "AssignKffToExcIEEEST6BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEST6BId(), "AssignKffToExcIEEEST6BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKffToExcIEEEST6BCommand assignment should not be null");
  }

  /**
   * handles unassign Kff validation for a ExcIEEEST6B
   *
   * @param command UnAssignKffFromExcIEEEST6BCommand
   */
  public void validate(UnAssignKffFromExcIEEEST6BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKffFromExcIEEEST6BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEST6BId(),
        "UnAssignKffFromExcIEEEST6BCommand identifier should not be null");
  }
  /**
   * handles assign Kg validation for a ExcIEEEST6B
   *
   * @param command AssignKgToExcIEEEST6BCommand
   */
  public void validate(AssignKgToExcIEEEST6BCommand command) throws Exception {
    Assert.notNull(command, "AssignKgToExcIEEEST6BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEST6BId(), "AssignKgToExcIEEEST6BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKgToExcIEEEST6BCommand assignment should not be null");
  }

  /**
   * handles unassign Kg validation for a ExcIEEEST6B
   *
   * @param command UnAssignKgFromExcIEEEST6BCommand
   */
  public void validate(UnAssignKgFromExcIEEEST6BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKgFromExcIEEEST6BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEST6BId(),
        "UnAssignKgFromExcIEEEST6BCommand identifier should not be null");
  }
  /**
   * handles assign Kia validation for a ExcIEEEST6B
   *
   * @param command AssignKiaToExcIEEEST6BCommand
   */
  public void validate(AssignKiaToExcIEEEST6BCommand command) throws Exception {
    Assert.notNull(command, "AssignKiaToExcIEEEST6BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEST6BId(), "AssignKiaToExcIEEEST6BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKiaToExcIEEEST6BCommand assignment should not be null");
  }

  /**
   * handles unassign Kia validation for a ExcIEEEST6B
   *
   * @param command UnAssignKiaFromExcIEEEST6BCommand
   */
  public void validate(UnAssignKiaFromExcIEEEST6BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKiaFromExcIEEEST6BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEST6BId(),
        "UnAssignKiaFromExcIEEEST6BCommand identifier should not be null");
  }
  /**
   * handles assign Klr validation for a ExcIEEEST6B
   *
   * @param command AssignKlrToExcIEEEST6BCommand
   */
  public void validate(AssignKlrToExcIEEEST6BCommand command) throws Exception {
    Assert.notNull(command, "AssignKlrToExcIEEEST6BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEST6BId(), "AssignKlrToExcIEEEST6BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKlrToExcIEEEST6BCommand assignment should not be null");
  }

  /**
   * handles unassign Klr validation for a ExcIEEEST6B
   *
   * @param command UnAssignKlrFromExcIEEEST6BCommand
   */
  public void validate(UnAssignKlrFromExcIEEEST6BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKlrFromExcIEEEST6BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEST6BId(),
        "UnAssignKlrFromExcIEEEST6BCommand identifier should not be null");
  }
  /**
   * handles assign Km validation for a ExcIEEEST6B
   *
   * @param command AssignKmToExcIEEEST6BCommand
   */
  public void validate(AssignKmToExcIEEEST6BCommand command) throws Exception {
    Assert.notNull(command, "AssignKmToExcIEEEST6BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEST6BId(), "AssignKmToExcIEEEST6BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKmToExcIEEEST6BCommand assignment should not be null");
  }

  /**
   * handles unassign Km validation for a ExcIEEEST6B
   *
   * @param command UnAssignKmFromExcIEEEST6BCommand
   */
  public void validate(UnAssignKmFromExcIEEEST6BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKmFromExcIEEEST6BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEST6BId(),
        "UnAssignKmFromExcIEEEST6BCommand identifier should not be null");
  }
  /**
   * handles assign Kpa validation for a ExcIEEEST6B
   *
   * @param command AssignKpaToExcIEEEST6BCommand
   */
  public void validate(AssignKpaToExcIEEEST6BCommand command) throws Exception {
    Assert.notNull(command, "AssignKpaToExcIEEEST6BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEST6BId(), "AssignKpaToExcIEEEST6BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKpaToExcIEEEST6BCommand assignment should not be null");
  }

  /**
   * handles unassign Kpa validation for a ExcIEEEST6B
   *
   * @param command UnAssignKpaFromExcIEEEST6BCommand
   */
  public void validate(UnAssignKpaFromExcIEEEST6BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKpaFromExcIEEEST6BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEST6BId(),
        "UnAssignKpaFromExcIEEEST6BCommand identifier should not be null");
  }
  /**
   * handles assign Tg validation for a ExcIEEEST6B
   *
   * @param command AssignTgToExcIEEEST6BCommand
   */
  public void validate(AssignTgToExcIEEEST6BCommand command) throws Exception {
    Assert.notNull(command, "AssignTgToExcIEEEST6BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEST6BId(), "AssignTgToExcIEEEST6BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTgToExcIEEEST6BCommand assignment should not be null");
  }

  /**
   * handles unassign Tg validation for a ExcIEEEST6B
   *
   * @param command UnAssignTgFromExcIEEEST6BCommand
   */
  public void validate(UnAssignTgFromExcIEEEST6BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTgFromExcIEEEST6BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEST6BId(),
        "UnAssignTgFromExcIEEEST6BCommand identifier should not be null");
  }
  /**
   * handles assign Vamax validation for a ExcIEEEST6B
   *
   * @param command AssignVamaxToExcIEEEST6BCommand
   */
  public void validate(AssignVamaxToExcIEEEST6BCommand command) throws Exception {
    Assert.notNull(command, "AssignVamaxToExcIEEEST6BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEST6BId(),
        "AssignVamaxToExcIEEEST6BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVamaxToExcIEEEST6BCommand assignment should not be null");
  }

  /**
   * handles unassign Vamax validation for a ExcIEEEST6B
   *
   * @param command UnAssignVamaxFromExcIEEEST6BCommand
   */
  public void validate(UnAssignVamaxFromExcIEEEST6BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignVamaxFromExcIEEEST6BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEST6BId(),
        "UnAssignVamaxFromExcIEEEST6BCommand identifier should not be null");
  }
  /**
   * handles assign Vamin validation for a ExcIEEEST6B
   *
   * @param command AssignVaminToExcIEEEST6BCommand
   */
  public void validate(AssignVaminToExcIEEEST6BCommand command) throws Exception {
    Assert.notNull(command, "AssignVaminToExcIEEEST6BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEST6BId(),
        "AssignVaminToExcIEEEST6BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVaminToExcIEEEST6BCommand assignment should not be null");
  }

  /**
   * handles unassign Vamin validation for a ExcIEEEST6B
   *
   * @param command UnAssignVaminFromExcIEEEST6BCommand
   */
  public void validate(UnAssignVaminFromExcIEEEST6BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignVaminFromExcIEEEST6BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEST6BId(),
        "UnAssignVaminFromExcIEEEST6BCommand identifier should not be null");
  }
  /**
   * handles assign Vrmax validation for a ExcIEEEST6B
   *
   * @param command AssignVrmaxToExcIEEEST6BCommand
   */
  public void validate(AssignVrmaxToExcIEEEST6BCommand command) throws Exception {
    Assert.notNull(command, "AssignVrmaxToExcIEEEST6BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEST6BId(),
        "AssignVrmaxToExcIEEEST6BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVrmaxToExcIEEEST6BCommand assignment should not be null");
  }

  /**
   * handles unassign Vrmax validation for a ExcIEEEST6B
   *
   * @param command UnAssignVrmaxFromExcIEEEST6BCommand
   */
  public void validate(UnAssignVrmaxFromExcIEEEST6BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignVrmaxFromExcIEEEST6BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEST6BId(),
        "UnAssignVrmaxFromExcIEEEST6BCommand identifier should not be null");
  }
  /**
   * handles assign Vrmin validation for a ExcIEEEST6B
   *
   * @param command AssignVrminToExcIEEEST6BCommand
   */
  public void validate(AssignVrminToExcIEEEST6BCommand command) throws Exception {
    Assert.notNull(command, "AssignVrminToExcIEEEST6BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEST6BId(),
        "AssignVrminToExcIEEEST6BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVrminToExcIEEEST6BCommand assignment should not be null");
  }

  /**
   * handles unassign Vrmin validation for a ExcIEEEST6B
   *
   * @param command UnAssignVrminFromExcIEEEST6BCommand
   */
  public void validate(UnAssignVrminFromExcIEEEST6BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignVrminFromExcIEEEST6BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEST6BId(),
        "UnAssignVrminFromExcIEEEST6BCommand identifier should not be null");
  }
}
