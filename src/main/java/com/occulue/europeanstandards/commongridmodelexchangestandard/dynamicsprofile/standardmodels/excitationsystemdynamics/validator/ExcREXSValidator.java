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

public class ExcREXSValidator {

  /** default constructor */
  protected ExcREXSValidator() {}

  /** factory method */
  public static ExcREXSValidator getInstance() {
    return new ExcREXSValidator();
  }

  /** handles creation validation for a ExcREXS */
  public void validate(CreateExcREXSCommand excREXS) throws Exception {
    Assert.notNull(excREXS, "CreateExcREXSCommand should not be null");
    //		Assert.isNull( excREXS.getExcREXSId(), "CreateExcREXSCommand identifier should be null" );
  }

  /** handles update validation for a ExcREXS */
  public void validate(UpdateExcREXSCommand excREXS) throws Exception {
    Assert.notNull(excREXS, "UpdateExcREXSCommand should not be null");
    Assert.notNull(excREXS.getExcREXSId(), "UpdateExcREXSCommand identifier should not be null");
  }

  /** handles delete validation for a ExcREXS */
  public void validate(DeleteExcREXSCommand excREXS) throws Exception {
    Assert.notNull(excREXS, "{commandAlias} should not be null");
    Assert.notNull(excREXS.getExcREXSId(), "DeleteExcREXSCommand identifier should not be null");
  }

  /** handles fetchOne validation for a ExcREXS */
  public void validate(ExcREXSFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "ExcREXSFetchOneSummary should not be null");
    Assert.notNull(summary.getExcREXSId(), "ExcREXSFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign E1 validation for a ExcREXS
   *
   * @param command AssignE1ToExcREXSCommand
   */
  public void validate(AssignE1ToExcREXSCommand command) throws Exception {
    Assert.notNull(command, "AssignE1ToExcREXSCommand should not be null");
    Assert.notNull(
        command.getExcREXSId(), "AssignE1ToExcREXSCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignE1ToExcREXSCommand assignment should not be null");
  }

  /**
   * handles unassign E1 validation for a ExcREXS
   *
   * @param command UnAssignE1FromExcREXSCommand
   */
  public void validate(UnAssignE1FromExcREXSCommand command) throws Exception {
    Assert.notNull(command, "UnAssignE1FromExcREXSCommand should not be null");
    Assert.notNull(
        command.getExcREXSId(), "UnAssignE1FromExcREXSCommand identifier should not be null");
  }
  /**
   * handles assign E2 validation for a ExcREXS
   *
   * @param command AssignE2ToExcREXSCommand
   */
  public void validate(AssignE2ToExcREXSCommand command) throws Exception {
    Assert.notNull(command, "AssignE2ToExcREXSCommand should not be null");
    Assert.notNull(
        command.getExcREXSId(), "AssignE2ToExcREXSCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignE2ToExcREXSCommand assignment should not be null");
  }

  /**
   * handles unassign E2 validation for a ExcREXS
   *
   * @param command UnAssignE2FromExcREXSCommand
   */
  public void validate(UnAssignE2FromExcREXSCommand command) throws Exception {
    Assert.notNull(command, "UnAssignE2FromExcREXSCommand should not be null");
    Assert.notNull(
        command.getExcREXSId(), "UnAssignE2FromExcREXSCommand identifier should not be null");
  }
  /**
   * handles assign Flimf validation for a ExcREXS
   *
   * @param command AssignFlimfToExcREXSCommand
   */
  public void validate(AssignFlimfToExcREXSCommand command) throws Exception {
    Assert.notNull(command, "AssignFlimfToExcREXSCommand should not be null");
    Assert.notNull(
        command.getExcREXSId(), "AssignFlimfToExcREXSCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignFlimfToExcREXSCommand assignment should not be null");
  }

  /**
   * handles unassign Flimf validation for a ExcREXS
   *
   * @param command UnAssignFlimfFromExcREXSCommand
   */
  public void validate(UnAssignFlimfFromExcREXSCommand command) throws Exception {
    Assert.notNull(command, "UnAssignFlimfFromExcREXSCommand should not be null");
    Assert.notNull(
        command.getExcREXSId(), "UnAssignFlimfFromExcREXSCommand identifier should not be null");
  }
  /**
   * handles assign Kc validation for a ExcREXS
   *
   * @param command AssignKcToExcREXSCommand
   */
  public void validate(AssignKcToExcREXSCommand command) throws Exception {
    Assert.notNull(command, "AssignKcToExcREXSCommand should not be null");
    Assert.notNull(
        command.getExcREXSId(), "AssignKcToExcREXSCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKcToExcREXSCommand assignment should not be null");
  }

  /**
   * handles unassign Kc validation for a ExcREXS
   *
   * @param command UnAssignKcFromExcREXSCommand
   */
  public void validate(UnAssignKcFromExcREXSCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKcFromExcREXSCommand should not be null");
    Assert.notNull(
        command.getExcREXSId(), "UnAssignKcFromExcREXSCommand identifier should not be null");
  }
  /**
   * handles assign Kd validation for a ExcREXS
   *
   * @param command AssignKdToExcREXSCommand
   */
  public void validate(AssignKdToExcREXSCommand command) throws Exception {
    Assert.notNull(command, "AssignKdToExcREXSCommand should not be null");
    Assert.notNull(
        command.getExcREXSId(), "AssignKdToExcREXSCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKdToExcREXSCommand assignment should not be null");
  }

  /**
   * handles unassign Kd validation for a ExcREXS
   *
   * @param command UnAssignKdFromExcREXSCommand
   */
  public void validate(UnAssignKdFromExcREXSCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKdFromExcREXSCommand should not be null");
    Assert.notNull(
        command.getExcREXSId(), "UnAssignKdFromExcREXSCommand identifier should not be null");
  }
  /**
   * handles assign Ke validation for a ExcREXS
   *
   * @param command AssignKeToExcREXSCommand
   */
  public void validate(AssignKeToExcREXSCommand command) throws Exception {
    Assert.notNull(command, "AssignKeToExcREXSCommand should not be null");
    Assert.notNull(
        command.getExcREXSId(), "AssignKeToExcREXSCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKeToExcREXSCommand assignment should not be null");
  }

  /**
   * handles unassign Ke validation for a ExcREXS
   *
   * @param command UnAssignKeFromExcREXSCommand
   */
  public void validate(UnAssignKeFromExcREXSCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKeFromExcREXSCommand should not be null");
    Assert.notNull(
        command.getExcREXSId(), "UnAssignKeFromExcREXSCommand identifier should not be null");
  }
  /**
   * handles assign Kefd validation for a ExcREXS
   *
   * @param command AssignKefdToExcREXSCommand
   */
  public void validate(AssignKefdToExcREXSCommand command) throws Exception {
    Assert.notNull(command, "AssignKefdToExcREXSCommand should not be null");
    Assert.notNull(
        command.getExcREXSId(), "AssignKefdToExcREXSCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKefdToExcREXSCommand assignment should not be null");
  }

  /**
   * handles unassign Kefd validation for a ExcREXS
   *
   * @param command UnAssignKefdFromExcREXSCommand
   */
  public void validate(UnAssignKefdFromExcREXSCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKefdFromExcREXSCommand should not be null");
    Assert.notNull(
        command.getExcREXSId(), "UnAssignKefdFromExcREXSCommand identifier should not be null");
  }
  /**
   * handles assign Kf validation for a ExcREXS
   *
   * @param command AssignKfToExcREXSCommand
   */
  public void validate(AssignKfToExcREXSCommand command) throws Exception {
    Assert.notNull(command, "AssignKfToExcREXSCommand should not be null");
    Assert.notNull(
        command.getExcREXSId(), "AssignKfToExcREXSCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKfToExcREXSCommand assignment should not be null");
  }

  /**
   * handles unassign Kf validation for a ExcREXS
   *
   * @param command UnAssignKfFromExcREXSCommand
   */
  public void validate(UnAssignKfFromExcREXSCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKfFromExcREXSCommand should not be null");
    Assert.notNull(
        command.getExcREXSId(), "UnAssignKfFromExcREXSCommand identifier should not be null");
  }
  /**
   * handles assign Kh validation for a ExcREXS
   *
   * @param command AssignKhToExcREXSCommand
   */
  public void validate(AssignKhToExcREXSCommand command) throws Exception {
    Assert.notNull(command, "AssignKhToExcREXSCommand should not be null");
    Assert.notNull(
        command.getExcREXSId(), "AssignKhToExcREXSCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKhToExcREXSCommand assignment should not be null");
  }

  /**
   * handles unassign Kh validation for a ExcREXS
   *
   * @param command UnAssignKhFromExcREXSCommand
   */
  public void validate(UnAssignKhFromExcREXSCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKhFromExcREXSCommand should not be null");
    Assert.notNull(
        command.getExcREXSId(), "UnAssignKhFromExcREXSCommand identifier should not be null");
  }
  /**
   * handles assign Kii validation for a ExcREXS
   *
   * @param command AssignKiiToExcREXSCommand
   */
  public void validate(AssignKiiToExcREXSCommand command) throws Exception {
    Assert.notNull(command, "AssignKiiToExcREXSCommand should not be null");
    Assert.notNull(
        command.getExcREXSId(), "AssignKiiToExcREXSCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKiiToExcREXSCommand assignment should not be null");
  }

  /**
   * handles unassign Kii validation for a ExcREXS
   *
   * @param command UnAssignKiiFromExcREXSCommand
   */
  public void validate(UnAssignKiiFromExcREXSCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKiiFromExcREXSCommand should not be null");
    Assert.notNull(
        command.getExcREXSId(), "UnAssignKiiFromExcREXSCommand identifier should not be null");
  }
  /**
   * handles assign Kip validation for a ExcREXS
   *
   * @param command AssignKipToExcREXSCommand
   */
  public void validate(AssignKipToExcREXSCommand command) throws Exception {
    Assert.notNull(command, "AssignKipToExcREXSCommand should not be null");
    Assert.notNull(
        command.getExcREXSId(), "AssignKipToExcREXSCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKipToExcREXSCommand assignment should not be null");
  }

  /**
   * handles unassign Kip validation for a ExcREXS
   *
   * @param command UnAssignKipFromExcREXSCommand
   */
  public void validate(UnAssignKipFromExcREXSCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKipFromExcREXSCommand should not be null");
    Assert.notNull(
        command.getExcREXSId(), "UnAssignKipFromExcREXSCommand identifier should not be null");
  }
  /**
   * handles assign Ks validation for a ExcREXS
   *
   * @param command AssignKsToExcREXSCommand
   */
  public void validate(AssignKsToExcREXSCommand command) throws Exception {
    Assert.notNull(command, "AssignKsToExcREXSCommand should not be null");
    Assert.notNull(
        command.getExcREXSId(), "AssignKsToExcREXSCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKsToExcREXSCommand assignment should not be null");
  }

  /**
   * handles unassign Ks validation for a ExcREXS
   *
   * @param command UnAssignKsFromExcREXSCommand
   */
  public void validate(UnAssignKsFromExcREXSCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKsFromExcREXSCommand should not be null");
    Assert.notNull(
        command.getExcREXSId(), "UnAssignKsFromExcREXSCommand identifier should not be null");
  }
  /**
   * handles assign Kvi validation for a ExcREXS
   *
   * @param command AssignKviToExcREXSCommand
   */
  public void validate(AssignKviToExcREXSCommand command) throws Exception {
    Assert.notNull(command, "AssignKviToExcREXSCommand should not be null");
    Assert.notNull(
        command.getExcREXSId(), "AssignKviToExcREXSCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKviToExcREXSCommand assignment should not be null");
  }

  /**
   * handles unassign Kvi validation for a ExcREXS
   *
   * @param command UnAssignKviFromExcREXSCommand
   */
  public void validate(UnAssignKviFromExcREXSCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKviFromExcREXSCommand should not be null");
    Assert.notNull(
        command.getExcREXSId(), "UnAssignKviFromExcREXSCommand identifier should not be null");
  }
  /**
   * handles assign Kvp validation for a ExcREXS
   *
   * @param command AssignKvpToExcREXSCommand
   */
  public void validate(AssignKvpToExcREXSCommand command) throws Exception {
    Assert.notNull(command, "AssignKvpToExcREXSCommand should not be null");
    Assert.notNull(
        command.getExcREXSId(), "AssignKvpToExcREXSCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKvpToExcREXSCommand assignment should not be null");
  }

  /**
   * handles unassign Kvp validation for a ExcREXS
   *
   * @param command UnAssignKvpFromExcREXSCommand
   */
  public void validate(UnAssignKvpFromExcREXSCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKvpFromExcREXSCommand should not be null");
    Assert.notNull(
        command.getExcREXSId(), "UnAssignKvpFromExcREXSCommand identifier should not be null");
  }
  /**
   * handles assign Kvphz validation for a ExcREXS
   *
   * @param command AssignKvphzToExcREXSCommand
   */
  public void validate(AssignKvphzToExcREXSCommand command) throws Exception {
    Assert.notNull(command, "AssignKvphzToExcREXSCommand should not be null");
    Assert.notNull(
        command.getExcREXSId(), "AssignKvphzToExcREXSCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKvphzToExcREXSCommand assignment should not be null");
  }

  /**
   * handles unassign Kvphz validation for a ExcREXS
   *
   * @param command UnAssignKvphzFromExcREXSCommand
   */
  public void validate(UnAssignKvphzFromExcREXSCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKvphzFromExcREXSCommand should not be null");
    Assert.notNull(
        command.getExcREXSId(), "UnAssignKvphzFromExcREXSCommand identifier should not be null");
  }
  /**
   * handles assign Nvphz validation for a ExcREXS
   *
   * @param command AssignNvphzToExcREXSCommand
   */
  public void validate(AssignNvphzToExcREXSCommand command) throws Exception {
    Assert.notNull(command, "AssignNvphzToExcREXSCommand should not be null");
    Assert.notNull(
        command.getExcREXSId(), "AssignNvphzToExcREXSCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignNvphzToExcREXSCommand assignment should not be null");
  }

  /**
   * handles unassign Nvphz validation for a ExcREXS
   *
   * @param command UnAssignNvphzFromExcREXSCommand
   */
  public void validate(UnAssignNvphzFromExcREXSCommand command) throws Exception {
    Assert.notNull(command, "UnAssignNvphzFromExcREXSCommand should not be null");
    Assert.notNull(
        command.getExcREXSId(), "UnAssignNvphzFromExcREXSCommand identifier should not be null");
  }
  /**
   * handles assign Se1 validation for a ExcREXS
   *
   * @param command AssignSe1ToExcREXSCommand
   */
  public void validate(AssignSe1ToExcREXSCommand command) throws Exception {
    Assert.notNull(command, "AssignSe1ToExcREXSCommand should not be null");
    Assert.notNull(
        command.getExcREXSId(), "AssignSe1ToExcREXSCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignSe1ToExcREXSCommand assignment should not be null");
  }

  /**
   * handles unassign Se1 validation for a ExcREXS
   *
   * @param command UnAssignSe1FromExcREXSCommand
   */
  public void validate(UnAssignSe1FromExcREXSCommand command) throws Exception {
    Assert.notNull(command, "UnAssignSe1FromExcREXSCommand should not be null");
    Assert.notNull(
        command.getExcREXSId(), "UnAssignSe1FromExcREXSCommand identifier should not be null");
  }
  /**
   * handles assign Se2 validation for a ExcREXS
   *
   * @param command AssignSe2ToExcREXSCommand
   */
  public void validate(AssignSe2ToExcREXSCommand command) throws Exception {
    Assert.notNull(command, "AssignSe2ToExcREXSCommand should not be null");
    Assert.notNull(
        command.getExcREXSId(), "AssignSe2ToExcREXSCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignSe2ToExcREXSCommand assignment should not be null");
  }

  /**
   * handles unassign Se2 validation for a ExcREXS
   *
   * @param command UnAssignSe2FromExcREXSCommand
   */
  public void validate(UnAssignSe2FromExcREXSCommand command) throws Exception {
    Assert.notNull(command, "UnAssignSe2FromExcREXSCommand should not be null");
    Assert.notNull(
        command.getExcREXSId(), "UnAssignSe2FromExcREXSCommand identifier should not be null");
  }
  /**
   * handles assign Ta validation for a ExcREXS
   *
   * @param command AssignTaToExcREXSCommand
   */
  public void validate(AssignTaToExcREXSCommand command) throws Exception {
    Assert.notNull(command, "AssignTaToExcREXSCommand should not be null");
    Assert.notNull(
        command.getExcREXSId(), "AssignTaToExcREXSCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTaToExcREXSCommand assignment should not be null");
  }

  /**
   * handles unassign Ta validation for a ExcREXS
   *
   * @param command UnAssignTaFromExcREXSCommand
   */
  public void validate(UnAssignTaFromExcREXSCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTaFromExcREXSCommand should not be null");
    Assert.notNull(
        command.getExcREXSId(), "UnAssignTaFromExcREXSCommand identifier should not be null");
  }
  /**
   * handles assign Tb1 validation for a ExcREXS
   *
   * @param command AssignTb1ToExcREXSCommand
   */
  public void validate(AssignTb1ToExcREXSCommand command) throws Exception {
    Assert.notNull(command, "AssignTb1ToExcREXSCommand should not be null");
    Assert.notNull(
        command.getExcREXSId(), "AssignTb1ToExcREXSCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTb1ToExcREXSCommand assignment should not be null");
  }

  /**
   * handles unassign Tb1 validation for a ExcREXS
   *
   * @param command UnAssignTb1FromExcREXSCommand
   */
  public void validate(UnAssignTb1FromExcREXSCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTb1FromExcREXSCommand should not be null");
    Assert.notNull(
        command.getExcREXSId(), "UnAssignTb1FromExcREXSCommand identifier should not be null");
  }
  /**
   * handles assign Tb2 validation for a ExcREXS
   *
   * @param command AssignTb2ToExcREXSCommand
   */
  public void validate(AssignTb2ToExcREXSCommand command) throws Exception {
    Assert.notNull(command, "AssignTb2ToExcREXSCommand should not be null");
    Assert.notNull(
        command.getExcREXSId(), "AssignTb2ToExcREXSCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTb2ToExcREXSCommand assignment should not be null");
  }

  /**
   * handles unassign Tb2 validation for a ExcREXS
   *
   * @param command UnAssignTb2FromExcREXSCommand
   */
  public void validate(UnAssignTb2FromExcREXSCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTb2FromExcREXSCommand should not be null");
    Assert.notNull(
        command.getExcREXSId(), "UnAssignTb2FromExcREXSCommand identifier should not be null");
  }
  /**
   * handles assign Tc1 validation for a ExcREXS
   *
   * @param command AssignTc1ToExcREXSCommand
   */
  public void validate(AssignTc1ToExcREXSCommand command) throws Exception {
    Assert.notNull(command, "AssignTc1ToExcREXSCommand should not be null");
    Assert.notNull(
        command.getExcREXSId(), "AssignTc1ToExcREXSCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTc1ToExcREXSCommand assignment should not be null");
  }

  /**
   * handles unassign Tc1 validation for a ExcREXS
   *
   * @param command UnAssignTc1FromExcREXSCommand
   */
  public void validate(UnAssignTc1FromExcREXSCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTc1FromExcREXSCommand should not be null");
    Assert.notNull(
        command.getExcREXSId(), "UnAssignTc1FromExcREXSCommand identifier should not be null");
  }
  /**
   * handles assign Tc2 validation for a ExcREXS
   *
   * @param command AssignTc2ToExcREXSCommand
   */
  public void validate(AssignTc2ToExcREXSCommand command) throws Exception {
    Assert.notNull(command, "AssignTc2ToExcREXSCommand should not be null");
    Assert.notNull(
        command.getExcREXSId(), "AssignTc2ToExcREXSCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTc2ToExcREXSCommand assignment should not be null");
  }

  /**
   * handles unassign Tc2 validation for a ExcREXS
   *
   * @param command UnAssignTc2FromExcREXSCommand
   */
  public void validate(UnAssignTc2FromExcREXSCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTc2FromExcREXSCommand should not be null");
    Assert.notNull(
        command.getExcREXSId(), "UnAssignTc2FromExcREXSCommand identifier should not be null");
  }
  /**
   * handles assign Te validation for a ExcREXS
   *
   * @param command AssignTeToExcREXSCommand
   */
  public void validate(AssignTeToExcREXSCommand command) throws Exception {
    Assert.notNull(command, "AssignTeToExcREXSCommand should not be null");
    Assert.notNull(
        command.getExcREXSId(), "AssignTeToExcREXSCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTeToExcREXSCommand assignment should not be null");
  }

  /**
   * handles unassign Te validation for a ExcREXS
   *
   * @param command UnAssignTeFromExcREXSCommand
   */
  public void validate(UnAssignTeFromExcREXSCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTeFromExcREXSCommand should not be null");
    Assert.notNull(
        command.getExcREXSId(), "UnAssignTeFromExcREXSCommand identifier should not be null");
  }
  /**
   * handles assign Tf validation for a ExcREXS
   *
   * @param command AssignTfToExcREXSCommand
   */
  public void validate(AssignTfToExcREXSCommand command) throws Exception {
    Assert.notNull(command, "AssignTfToExcREXSCommand should not be null");
    Assert.notNull(
        command.getExcREXSId(), "AssignTfToExcREXSCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTfToExcREXSCommand assignment should not be null");
  }

  /**
   * handles unassign Tf validation for a ExcREXS
   *
   * @param command UnAssignTfFromExcREXSCommand
   */
  public void validate(UnAssignTfFromExcREXSCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTfFromExcREXSCommand should not be null");
    Assert.notNull(
        command.getExcREXSId(), "UnAssignTfFromExcREXSCommand identifier should not be null");
  }
  /**
   * handles assign Tf1 validation for a ExcREXS
   *
   * @param command AssignTf1ToExcREXSCommand
   */
  public void validate(AssignTf1ToExcREXSCommand command) throws Exception {
    Assert.notNull(command, "AssignTf1ToExcREXSCommand should not be null");
    Assert.notNull(
        command.getExcREXSId(), "AssignTf1ToExcREXSCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTf1ToExcREXSCommand assignment should not be null");
  }

  /**
   * handles unassign Tf1 validation for a ExcREXS
   *
   * @param command UnAssignTf1FromExcREXSCommand
   */
  public void validate(UnAssignTf1FromExcREXSCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTf1FromExcREXSCommand should not be null");
    Assert.notNull(
        command.getExcREXSId(), "UnAssignTf1FromExcREXSCommand identifier should not be null");
  }
  /**
   * handles assign Tf2 validation for a ExcREXS
   *
   * @param command AssignTf2ToExcREXSCommand
   */
  public void validate(AssignTf2ToExcREXSCommand command) throws Exception {
    Assert.notNull(command, "AssignTf2ToExcREXSCommand should not be null");
    Assert.notNull(
        command.getExcREXSId(), "AssignTf2ToExcREXSCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTf2ToExcREXSCommand assignment should not be null");
  }

  /**
   * handles unassign Tf2 validation for a ExcREXS
   *
   * @param command UnAssignTf2FromExcREXSCommand
   */
  public void validate(UnAssignTf2FromExcREXSCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTf2FromExcREXSCommand should not be null");
    Assert.notNull(
        command.getExcREXSId(), "UnAssignTf2FromExcREXSCommand identifier should not be null");
  }
  /**
   * handles assign Tp validation for a ExcREXS
   *
   * @param command AssignTpToExcREXSCommand
   */
  public void validate(AssignTpToExcREXSCommand command) throws Exception {
    Assert.notNull(command, "AssignTpToExcREXSCommand should not be null");
    Assert.notNull(
        command.getExcREXSId(), "AssignTpToExcREXSCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTpToExcREXSCommand assignment should not be null");
  }

  /**
   * handles unassign Tp validation for a ExcREXS
   *
   * @param command UnAssignTpFromExcREXSCommand
   */
  public void validate(UnAssignTpFromExcREXSCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTpFromExcREXSCommand should not be null");
    Assert.notNull(
        command.getExcREXSId(), "UnAssignTpFromExcREXSCommand identifier should not be null");
  }
  /**
   * handles assign Vcmax validation for a ExcREXS
   *
   * @param command AssignVcmaxToExcREXSCommand
   */
  public void validate(AssignVcmaxToExcREXSCommand command) throws Exception {
    Assert.notNull(command, "AssignVcmaxToExcREXSCommand should not be null");
    Assert.notNull(
        command.getExcREXSId(), "AssignVcmaxToExcREXSCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVcmaxToExcREXSCommand assignment should not be null");
  }

  /**
   * handles unassign Vcmax validation for a ExcREXS
   *
   * @param command UnAssignVcmaxFromExcREXSCommand
   */
  public void validate(UnAssignVcmaxFromExcREXSCommand command) throws Exception {
    Assert.notNull(command, "UnAssignVcmaxFromExcREXSCommand should not be null");
    Assert.notNull(
        command.getExcREXSId(), "UnAssignVcmaxFromExcREXSCommand identifier should not be null");
  }
  /**
   * handles assign Vfmax validation for a ExcREXS
   *
   * @param command AssignVfmaxToExcREXSCommand
   */
  public void validate(AssignVfmaxToExcREXSCommand command) throws Exception {
    Assert.notNull(command, "AssignVfmaxToExcREXSCommand should not be null");
    Assert.notNull(
        command.getExcREXSId(), "AssignVfmaxToExcREXSCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVfmaxToExcREXSCommand assignment should not be null");
  }

  /**
   * handles unassign Vfmax validation for a ExcREXS
   *
   * @param command UnAssignVfmaxFromExcREXSCommand
   */
  public void validate(UnAssignVfmaxFromExcREXSCommand command) throws Exception {
    Assert.notNull(command, "UnAssignVfmaxFromExcREXSCommand should not be null");
    Assert.notNull(
        command.getExcREXSId(), "UnAssignVfmaxFromExcREXSCommand identifier should not be null");
  }
  /**
   * handles assign Vfmin validation for a ExcREXS
   *
   * @param command AssignVfminToExcREXSCommand
   */
  public void validate(AssignVfminToExcREXSCommand command) throws Exception {
    Assert.notNull(command, "AssignVfminToExcREXSCommand should not be null");
    Assert.notNull(
        command.getExcREXSId(), "AssignVfminToExcREXSCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVfminToExcREXSCommand assignment should not be null");
  }

  /**
   * handles unassign Vfmin validation for a ExcREXS
   *
   * @param command UnAssignVfminFromExcREXSCommand
   */
  public void validate(UnAssignVfminFromExcREXSCommand command) throws Exception {
    Assert.notNull(command, "UnAssignVfminFromExcREXSCommand should not be null");
    Assert.notNull(
        command.getExcREXSId(), "UnAssignVfminFromExcREXSCommand identifier should not be null");
  }
  /**
   * handles assign Vimax validation for a ExcREXS
   *
   * @param command AssignVimaxToExcREXSCommand
   */
  public void validate(AssignVimaxToExcREXSCommand command) throws Exception {
    Assert.notNull(command, "AssignVimaxToExcREXSCommand should not be null");
    Assert.notNull(
        command.getExcREXSId(), "AssignVimaxToExcREXSCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVimaxToExcREXSCommand assignment should not be null");
  }

  /**
   * handles unassign Vimax validation for a ExcREXS
   *
   * @param command UnAssignVimaxFromExcREXSCommand
   */
  public void validate(UnAssignVimaxFromExcREXSCommand command) throws Exception {
    Assert.notNull(command, "UnAssignVimaxFromExcREXSCommand should not be null");
    Assert.notNull(
        command.getExcREXSId(), "UnAssignVimaxFromExcREXSCommand identifier should not be null");
  }
  /**
   * handles assign Vrmax validation for a ExcREXS
   *
   * @param command AssignVrmaxToExcREXSCommand
   */
  public void validate(AssignVrmaxToExcREXSCommand command) throws Exception {
    Assert.notNull(command, "AssignVrmaxToExcREXSCommand should not be null");
    Assert.notNull(
        command.getExcREXSId(), "AssignVrmaxToExcREXSCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVrmaxToExcREXSCommand assignment should not be null");
  }

  /**
   * handles unassign Vrmax validation for a ExcREXS
   *
   * @param command UnAssignVrmaxFromExcREXSCommand
   */
  public void validate(UnAssignVrmaxFromExcREXSCommand command) throws Exception {
    Assert.notNull(command, "UnAssignVrmaxFromExcREXSCommand should not be null");
    Assert.notNull(
        command.getExcREXSId(), "UnAssignVrmaxFromExcREXSCommand identifier should not be null");
  }
  /**
   * handles assign Vrmin validation for a ExcREXS
   *
   * @param command AssignVrminToExcREXSCommand
   */
  public void validate(AssignVrminToExcREXSCommand command) throws Exception {
    Assert.notNull(command, "AssignVrminToExcREXSCommand should not be null");
    Assert.notNull(
        command.getExcREXSId(), "AssignVrminToExcREXSCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVrminToExcREXSCommand assignment should not be null");
  }

  /**
   * handles unassign Vrmin validation for a ExcREXS
   *
   * @param command UnAssignVrminFromExcREXSCommand
   */
  public void validate(UnAssignVrminFromExcREXSCommand command) throws Exception {
    Assert.notNull(command, "UnAssignVrminFromExcREXSCommand should not be null");
    Assert.notNull(
        command.getExcREXSId(), "UnAssignVrminFromExcREXSCommand identifier should not be null");
  }
  /**
   * handles assign Xc validation for a ExcREXS
   *
   * @param command AssignXcToExcREXSCommand
   */
  public void validate(AssignXcToExcREXSCommand command) throws Exception {
    Assert.notNull(command, "AssignXcToExcREXSCommand should not be null");
    Assert.notNull(
        command.getExcREXSId(), "AssignXcToExcREXSCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignXcToExcREXSCommand assignment should not be null");
  }

  /**
   * handles unassign Xc validation for a ExcREXS
   *
   * @param command UnAssignXcFromExcREXSCommand
   */
  public void validate(UnAssignXcFromExcREXSCommand command) throws Exception {
    Assert.notNull(command, "UnAssignXcFromExcREXSCommand should not be null");
    Assert.notNull(
        command.getExcREXSId(), "UnAssignXcFromExcREXSCommand identifier should not be null");
  }
}
