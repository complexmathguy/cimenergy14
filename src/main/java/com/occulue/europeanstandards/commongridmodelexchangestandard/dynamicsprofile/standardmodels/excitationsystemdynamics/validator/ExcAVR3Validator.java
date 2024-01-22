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

public class ExcAVR3Validator {

  /** default constructor */
  protected ExcAVR3Validator() {}

  /** factory method */
  public static ExcAVR3Validator getInstance() {
    return new ExcAVR3Validator();
  }

  /** handles creation validation for a ExcAVR3 */
  public void validate(CreateExcAVR3Command excAVR3) throws Exception {
    Assert.notNull(excAVR3, "CreateExcAVR3Command should not be null");
    //		Assert.isNull( excAVR3.getExcAVR3Id(), "CreateExcAVR3Command identifier should be null" );
  }

  /** handles update validation for a ExcAVR3 */
  public void validate(UpdateExcAVR3Command excAVR3) throws Exception {
    Assert.notNull(excAVR3, "UpdateExcAVR3Command should not be null");
    Assert.notNull(excAVR3.getExcAVR3Id(), "UpdateExcAVR3Command identifier should not be null");
  }

  /** handles delete validation for a ExcAVR3 */
  public void validate(DeleteExcAVR3Command excAVR3) throws Exception {
    Assert.notNull(excAVR3, "{commandAlias} should not be null");
    Assert.notNull(excAVR3.getExcAVR3Id(), "DeleteExcAVR3Command identifier should not be null");
  }

  /** handles fetchOne validation for a ExcAVR3 */
  public void validate(ExcAVR3FetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "ExcAVR3FetchOneSummary should not be null");
    Assert.notNull(summary.getExcAVR3Id(), "ExcAVR3FetchOneSummary identifier should not be null");
  }

  /**
   * handles assign E1 validation for a ExcAVR3
   *
   * @param command AssignE1ToExcAVR3Command
   */
  public void validate(AssignE1ToExcAVR3Command command) throws Exception {
    Assert.notNull(command, "AssignE1ToExcAVR3Command should not be null");
    Assert.notNull(
        command.getExcAVR3Id(), "AssignE1ToExcAVR3Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignE1ToExcAVR3Command assignment should not be null");
  }

  /**
   * handles unassign E1 validation for a ExcAVR3
   *
   * @param command UnAssignE1FromExcAVR3Command
   */
  public void validate(UnAssignE1FromExcAVR3Command command) throws Exception {
    Assert.notNull(command, "UnAssignE1FromExcAVR3Command should not be null");
    Assert.notNull(
        command.getExcAVR3Id(), "UnAssignE1FromExcAVR3Command identifier should not be null");
  }
  /**
   * handles assign E2 validation for a ExcAVR3
   *
   * @param command AssignE2ToExcAVR3Command
   */
  public void validate(AssignE2ToExcAVR3Command command) throws Exception {
    Assert.notNull(command, "AssignE2ToExcAVR3Command should not be null");
    Assert.notNull(
        command.getExcAVR3Id(), "AssignE2ToExcAVR3Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignE2ToExcAVR3Command assignment should not be null");
  }

  /**
   * handles unassign E2 validation for a ExcAVR3
   *
   * @param command UnAssignE2FromExcAVR3Command
   */
  public void validate(UnAssignE2FromExcAVR3Command command) throws Exception {
    Assert.notNull(command, "UnAssignE2FromExcAVR3Command should not be null");
    Assert.notNull(
        command.getExcAVR3Id(), "UnAssignE2FromExcAVR3Command identifier should not be null");
  }
  /**
   * handles assign Ka validation for a ExcAVR3
   *
   * @param command AssignKaToExcAVR3Command
   */
  public void validate(AssignKaToExcAVR3Command command) throws Exception {
    Assert.notNull(command, "AssignKaToExcAVR3Command should not be null");
    Assert.notNull(
        command.getExcAVR3Id(), "AssignKaToExcAVR3Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKaToExcAVR3Command assignment should not be null");
  }

  /**
   * handles unassign Ka validation for a ExcAVR3
   *
   * @param command UnAssignKaFromExcAVR3Command
   */
  public void validate(UnAssignKaFromExcAVR3Command command) throws Exception {
    Assert.notNull(command, "UnAssignKaFromExcAVR3Command should not be null");
    Assert.notNull(
        command.getExcAVR3Id(), "UnAssignKaFromExcAVR3Command identifier should not be null");
  }
  /**
   * handles assign Se1 validation for a ExcAVR3
   *
   * @param command AssignSe1ToExcAVR3Command
   */
  public void validate(AssignSe1ToExcAVR3Command command) throws Exception {
    Assert.notNull(command, "AssignSe1ToExcAVR3Command should not be null");
    Assert.notNull(
        command.getExcAVR3Id(), "AssignSe1ToExcAVR3Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignSe1ToExcAVR3Command assignment should not be null");
  }

  /**
   * handles unassign Se1 validation for a ExcAVR3
   *
   * @param command UnAssignSe1FromExcAVR3Command
   */
  public void validate(UnAssignSe1FromExcAVR3Command command) throws Exception {
    Assert.notNull(command, "UnAssignSe1FromExcAVR3Command should not be null");
    Assert.notNull(
        command.getExcAVR3Id(), "UnAssignSe1FromExcAVR3Command identifier should not be null");
  }
  /**
   * handles assign Se2 validation for a ExcAVR3
   *
   * @param command AssignSe2ToExcAVR3Command
   */
  public void validate(AssignSe2ToExcAVR3Command command) throws Exception {
    Assert.notNull(command, "AssignSe2ToExcAVR3Command should not be null");
    Assert.notNull(
        command.getExcAVR3Id(), "AssignSe2ToExcAVR3Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignSe2ToExcAVR3Command assignment should not be null");
  }

  /**
   * handles unassign Se2 validation for a ExcAVR3
   *
   * @param command UnAssignSe2FromExcAVR3Command
   */
  public void validate(UnAssignSe2FromExcAVR3Command command) throws Exception {
    Assert.notNull(command, "UnAssignSe2FromExcAVR3Command should not be null");
    Assert.notNull(
        command.getExcAVR3Id(), "UnAssignSe2FromExcAVR3Command identifier should not be null");
  }
  /**
   * handles assign T1 validation for a ExcAVR3
   *
   * @param command AssignT1ToExcAVR3Command
   */
  public void validate(AssignT1ToExcAVR3Command command) throws Exception {
    Assert.notNull(command, "AssignT1ToExcAVR3Command should not be null");
    Assert.notNull(
        command.getExcAVR3Id(), "AssignT1ToExcAVR3Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT1ToExcAVR3Command assignment should not be null");
  }

  /**
   * handles unassign T1 validation for a ExcAVR3
   *
   * @param command UnAssignT1FromExcAVR3Command
   */
  public void validate(UnAssignT1FromExcAVR3Command command) throws Exception {
    Assert.notNull(command, "UnAssignT1FromExcAVR3Command should not be null");
    Assert.notNull(
        command.getExcAVR3Id(), "UnAssignT1FromExcAVR3Command identifier should not be null");
  }
  /**
   * handles assign T2 validation for a ExcAVR3
   *
   * @param command AssignT2ToExcAVR3Command
   */
  public void validate(AssignT2ToExcAVR3Command command) throws Exception {
    Assert.notNull(command, "AssignT2ToExcAVR3Command should not be null");
    Assert.notNull(
        command.getExcAVR3Id(), "AssignT2ToExcAVR3Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT2ToExcAVR3Command assignment should not be null");
  }

  /**
   * handles unassign T2 validation for a ExcAVR3
   *
   * @param command UnAssignT2FromExcAVR3Command
   */
  public void validate(UnAssignT2FromExcAVR3Command command) throws Exception {
    Assert.notNull(command, "UnAssignT2FromExcAVR3Command should not be null");
    Assert.notNull(
        command.getExcAVR3Id(), "UnAssignT2FromExcAVR3Command identifier should not be null");
  }
  /**
   * handles assign T3 validation for a ExcAVR3
   *
   * @param command AssignT3ToExcAVR3Command
   */
  public void validate(AssignT3ToExcAVR3Command command) throws Exception {
    Assert.notNull(command, "AssignT3ToExcAVR3Command should not be null");
    Assert.notNull(
        command.getExcAVR3Id(), "AssignT3ToExcAVR3Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT3ToExcAVR3Command assignment should not be null");
  }

  /**
   * handles unassign T3 validation for a ExcAVR3
   *
   * @param command UnAssignT3FromExcAVR3Command
   */
  public void validate(UnAssignT3FromExcAVR3Command command) throws Exception {
    Assert.notNull(command, "UnAssignT3FromExcAVR3Command should not be null");
    Assert.notNull(
        command.getExcAVR3Id(), "UnAssignT3FromExcAVR3Command identifier should not be null");
  }
  /**
   * handles assign T4 validation for a ExcAVR3
   *
   * @param command AssignT4ToExcAVR3Command
   */
  public void validate(AssignT4ToExcAVR3Command command) throws Exception {
    Assert.notNull(command, "AssignT4ToExcAVR3Command should not be null");
    Assert.notNull(
        command.getExcAVR3Id(), "AssignT4ToExcAVR3Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT4ToExcAVR3Command assignment should not be null");
  }

  /**
   * handles unassign T4 validation for a ExcAVR3
   *
   * @param command UnAssignT4FromExcAVR3Command
   */
  public void validate(UnAssignT4FromExcAVR3Command command) throws Exception {
    Assert.notNull(command, "UnAssignT4FromExcAVR3Command should not be null");
    Assert.notNull(
        command.getExcAVR3Id(), "UnAssignT4FromExcAVR3Command identifier should not be null");
  }
  /**
   * handles assign Te validation for a ExcAVR3
   *
   * @param command AssignTeToExcAVR3Command
   */
  public void validate(AssignTeToExcAVR3Command command) throws Exception {
    Assert.notNull(command, "AssignTeToExcAVR3Command should not be null");
    Assert.notNull(
        command.getExcAVR3Id(), "AssignTeToExcAVR3Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTeToExcAVR3Command assignment should not be null");
  }

  /**
   * handles unassign Te validation for a ExcAVR3
   *
   * @param command UnAssignTeFromExcAVR3Command
   */
  public void validate(UnAssignTeFromExcAVR3Command command) throws Exception {
    Assert.notNull(command, "UnAssignTeFromExcAVR3Command should not be null");
    Assert.notNull(
        command.getExcAVR3Id(), "UnAssignTeFromExcAVR3Command identifier should not be null");
  }
  /**
   * handles assign Vrmn validation for a ExcAVR3
   *
   * @param command AssignVrmnToExcAVR3Command
   */
  public void validate(AssignVrmnToExcAVR3Command command) throws Exception {
    Assert.notNull(command, "AssignVrmnToExcAVR3Command should not be null");
    Assert.notNull(
        command.getExcAVR3Id(), "AssignVrmnToExcAVR3Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVrmnToExcAVR3Command assignment should not be null");
  }

  /**
   * handles unassign Vrmn validation for a ExcAVR3
   *
   * @param command UnAssignVrmnFromExcAVR3Command
   */
  public void validate(UnAssignVrmnFromExcAVR3Command command) throws Exception {
    Assert.notNull(command, "UnAssignVrmnFromExcAVR3Command should not be null");
    Assert.notNull(
        command.getExcAVR3Id(), "UnAssignVrmnFromExcAVR3Command identifier should not be null");
  }
  /**
   * handles assign Vrmx validation for a ExcAVR3
   *
   * @param command AssignVrmxToExcAVR3Command
   */
  public void validate(AssignVrmxToExcAVR3Command command) throws Exception {
    Assert.notNull(command, "AssignVrmxToExcAVR3Command should not be null");
    Assert.notNull(
        command.getExcAVR3Id(), "AssignVrmxToExcAVR3Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVrmxToExcAVR3Command assignment should not be null");
  }

  /**
   * handles unassign Vrmx validation for a ExcAVR3
   *
   * @param command UnAssignVrmxFromExcAVR3Command
   */
  public void validate(UnAssignVrmxFromExcAVR3Command command) throws Exception {
    Assert.notNull(command, "UnAssignVrmxFromExcAVR3Command should not be null");
    Assert.notNull(
        command.getExcAVR3Id(), "UnAssignVrmxFromExcAVR3Command identifier should not be null");
  }
}
