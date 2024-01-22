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

public class ExcAVR7Validator {

  /** default constructor */
  protected ExcAVR7Validator() {}

  /** factory method */
  public static ExcAVR7Validator getInstance() {
    return new ExcAVR7Validator();
  }

  /** handles creation validation for a ExcAVR7 */
  public void validate(CreateExcAVR7Command excAVR7) throws Exception {
    Assert.notNull(excAVR7, "CreateExcAVR7Command should not be null");
    //		Assert.isNull( excAVR7.getExcAVR7Id(), "CreateExcAVR7Command identifier should be null" );
  }

  /** handles update validation for a ExcAVR7 */
  public void validate(UpdateExcAVR7Command excAVR7) throws Exception {
    Assert.notNull(excAVR7, "UpdateExcAVR7Command should not be null");
    Assert.notNull(excAVR7.getExcAVR7Id(), "UpdateExcAVR7Command identifier should not be null");
  }

  /** handles delete validation for a ExcAVR7 */
  public void validate(DeleteExcAVR7Command excAVR7) throws Exception {
    Assert.notNull(excAVR7, "{commandAlias} should not be null");
    Assert.notNull(excAVR7.getExcAVR7Id(), "DeleteExcAVR7Command identifier should not be null");
  }

  /** handles fetchOne validation for a ExcAVR7 */
  public void validate(ExcAVR7FetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "ExcAVR7FetchOneSummary should not be null");
    Assert.notNull(summary.getExcAVR7Id(), "ExcAVR7FetchOneSummary identifier should not be null");
  }

  /**
   * handles assign A1 validation for a ExcAVR7
   *
   * @param command AssignA1ToExcAVR7Command
   */
  public void validate(AssignA1ToExcAVR7Command command) throws Exception {
    Assert.notNull(command, "AssignA1ToExcAVR7Command should not be null");
    Assert.notNull(
        command.getExcAVR7Id(), "AssignA1ToExcAVR7Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignA1ToExcAVR7Command assignment should not be null");
  }

  /**
   * handles unassign A1 validation for a ExcAVR7
   *
   * @param command UnAssignA1FromExcAVR7Command
   */
  public void validate(UnAssignA1FromExcAVR7Command command) throws Exception {
    Assert.notNull(command, "UnAssignA1FromExcAVR7Command should not be null");
    Assert.notNull(
        command.getExcAVR7Id(), "UnAssignA1FromExcAVR7Command identifier should not be null");
  }
  /**
   * handles assign A2 validation for a ExcAVR7
   *
   * @param command AssignA2ToExcAVR7Command
   */
  public void validate(AssignA2ToExcAVR7Command command) throws Exception {
    Assert.notNull(command, "AssignA2ToExcAVR7Command should not be null");
    Assert.notNull(
        command.getExcAVR7Id(), "AssignA2ToExcAVR7Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignA2ToExcAVR7Command assignment should not be null");
  }

  /**
   * handles unassign A2 validation for a ExcAVR7
   *
   * @param command UnAssignA2FromExcAVR7Command
   */
  public void validate(UnAssignA2FromExcAVR7Command command) throws Exception {
    Assert.notNull(command, "UnAssignA2FromExcAVR7Command should not be null");
    Assert.notNull(
        command.getExcAVR7Id(), "UnAssignA2FromExcAVR7Command identifier should not be null");
  }
  /**
   * handles assign A3 validation for a ExcAVR7
   *
   * @param command AssignA3ToExcAVR7Command
   */
  public void validate(AssignA3ToExcAVR7Command command) throws Exception {
    Assert.notNull(command, "AssignA3ToExcAVR7Command should not be null");
    Assert.notNull(
        command.getExcAVR7Id(), "AssignA3ToExcAVR7Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignA3ToExcAVR7Command assignment should not be null");
  }

  /**
   * handles unassign A3 validation for a ExcAVR7
   *
   * @param command UnAssignA3FromExcAVR7Command
   */
  public void validate(UnAssignA3FromExcAVR7Command command) throws Exception {
    Assert.notNull(command, "UnAssignA3FromExcAVR7Command should not be null");
    Assert.notNull(
        command.getExcAVR7Id(), "UnAssignA3FromExcAVR7Command identifier should not be null");
  }
  /**
   * handles assign A4 validation for a ExcAVR7
   *
   * @param command AssignA4ToExcAVR7Command
   */
  public void validate(AssignA4ToExcAVR7Command command) throws Exception {
    Assert.notNull(command, "AssignA4ToExcAVR7Command should not be null");
    Assert.notNull(
        command.getExcAVR7Id(), "AssignA4ToExcAVR7Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignA4ToExcAVR7Command assignment should not be null");
  }

  /**
   * handles unassign A4 validation for a ExcAVR7
   *
   * @param command UnAssignA4FromExcAVR7Command
   */
  public void validate(UnAssignA4FromExcAVR7Command command) throws Exception {
    Assert.notNull(command, "UnAssignA4FromExcAVR7Command should not be null");
    Assert.notNull(
        command.getExcAVR7Id(), "UnAssignA4FromExcAVR7Command identifier should not be null");
  }
  /**
   * handles assign A5 validation for a ExcAVR7
   *
   * @param command AssignA5ToExcAVR7Command
   */
  public void validate(AssignA5ToExcAVR7Command command) throws Exception {
    Assert.notNull(command, "AssignA5ToExcAVR7Command should not be null");
    Assert.notNull(
        command.getExcAVR7Id(), "AssignA5ToExcAVR7Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignA5ToExcAVR7Command assignment should not be null");
  }

  /**
   * handles unassign A5 validation for a ExcAVR7
   *
   * @param command UnAssignA5FromExcAVR7Command
   */
  public void validate(UnAssignA5FromExcAVR7Command command) throws Exception {
    Assert.notNull(command, "UnAssignA5FromExcAVR7Command should not be null");
    Assert.notNull(
        command.getExcAVR7Id(), "UnAssignA5FromExcAVR7Command identifier should not be null");
  }
  /**
   * handles assign A6 validation for a ExcAVR7
   *
   * @param command AssignA6ToExcAVR7Command
   */
  public void validate(AssignA6ToExcAVR7Command command) throws Exception {
    Assert.notNull(command, "AssignA6ToExcAVR7Command should not be null");
    Assert.notNull(
        command.getExcAVR7Id(), "AssignA6ToExcAVR7Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignA6ToExcAVR7Command assignment should not be null");
  }

  /**
   * handles unassign A6 validation for a ExcAVR7
   *
   * @param command UnAssignA6FromExcAVR7Command
   */
  public void validate(UnAssignA6FromExcAVR7Command command) throws Exception {
    Assert.notNull(command, "UnAssignA6FromExcAVR7Command should not be null");
    Assert.notNull(
        command.getExcAVR7Id(), "UnAssignA6FromExcAVR7Command identifier should not be null");
  }
  /**
   * handles assign K1 validation for a ExcAVR7
   *
   * @param command AssignK1ToExcAVR7Command
   */
  public void validate(AssignK1ToExcAVR7Command command) throws Exception {
    Assert.notNull(command, "AssignK1ToExcAVR7Command should not be null");
    Assert.notNull(
        command.getExcAVR7Id(), "AssignK1ToExcAVR7Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignK1ToExcAVR7Command assignment should not be null");
  }

  /**
   * handles unassign K1 validation for a ExcAVR7
   *
   * @param command UnAssignK1FromExcAVR7Command
   */
  public void validate(UnAssignK1FromExcAVR7Command command) throws Exception {
    Assert.notNull(command, "UnAssignK1FromExcAVR7Command should not be null");
    Assert.notNull(
        command.getExcAVR7Id(), "UnAssignK1FromExcAVR7Command identifier should not be null");
  }
  /**
   * handles assign K3 validation for a ExcAVR7
   *
   * @param command AssignK3ToExcAVR7Command
   */
  public void validate(AssignK3ToExcAVR7Command command) throws Exception {
    Assert.notNull(command, "AssignK3ToExcAVR7Command should not be null");
    Assert.notNull(
        command.getExcAVR7Id(), "AssignK3ToExcAVR7Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignK3ToExcAVR7Command assignment should not be null");
  }

  /**
   * handles unassign K3 validation for a ExcAVR7
   *
   * @param command UnAssignK3FromExcAVR7Command
   */
  public void validate(UnAssignK3FromExcAVR7Command command) throws Exception {
    Assert.notNull(command, "UnAssignK3FromExcAVR7Command should not be null");
    Assert.notNull(
        command.getExcAVR7Id(), "UnAssignK3FromExcAVR7Command identifier should not be null");
  }
  /**
   * handles assign K5 validation for a ExcAVR7
   *
   * @param command AssignK5ToExcAVR7Command
   */
  public void validate(AssignK5ToExcAVR7Command command) throws Exception {
    Assert.notNull(command, "AssignK5ToExcAVR7Command should not be null");
    Assert.notNull(
        command.getExcAVR7Id(), "AssignK5ToExcAVR7Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignK5ToExcAVR7Command assignment should not be null");
  }

  /**
   * handles unassign K5 validation for a ExcAVR7
   *
   * @param command UnAssignK5FromExcAVR7Command
   */
  public void validate(UnAssignK5FromExcAVR7Command command) throws Exception {
    Assert.notNull(command, "UnAssignK5FromExcAVR7Command should not be null");
    Assert.notNull(
        command.getExcAVR7Id(), "UnAssignK5FromExcAVR7Command identifier should not be null");
  }
  /**
   * handles assign T1 validation for a ExcAVR7
   *
   * @param command AssignT1ToExcAVR7Command
   */
  public void validate(AssignT1ToExcAVR7Command command) throws Exception {
    Assert.notNull(command, "AssignT1ToExcAVR7Command should not be null");
    Assert.notNull(
        command.getExcAVR7Id(), "AssignT1ToExcAVR7Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT1ToExcAVR7Command assignment should not be null");
  }

  /**
   * handles unassign T1 validation for a ExcAVR7
   *
   * @param command UnAssignT1FromExcAVR7Command
   */
  public void validate(UnAssignT1FromExcAVR7Command command) throws Exception {
    Assert.notNull(command, "UnAssignT1FromExcAVR7Command should not be null");
    Assert.notNull(
        command.getExcAVR7Id(), "UnAssignT1FromExcAVR7Command identifier should not be null");
  }
  /**
   * handles assign T2 validation for a ExcAVR7
   *
   * @param command AssignT2ToExcAVR7Command
   */
  public void validate(AssignT2ToExcAVR7Command command) throws Exception {
    Assert.notNull(command, "AssignT2ToExcAVR7Command should not be null");
    Assert.notNull(
        command.getExcAVR7Id(), "AssignT2ToExcAVR7Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT2ToExcAVR7Command assignment should not be null");
  }

  /**
   * handles unassign T2 validation for a ExcAVR7
   *
   * @param command UnAssignT2FromExcAVR7Command
   */
  public void validate(UnAssignT2FromExcAVR7Command command) throws Exception {
    Assert.notNull(command, "UnAssignT2FromExcAVR7Command should not be null");
    Assert.notNull(
        command.getExcAVR7Id(), "UnAssignT2FromExcAVR7Command identifier should not be null");
  }
  /**
   * handles assign T3 validation for a ExcAVR7
   *
   * @param command AssignT3ToExcAVR7Command
   */
  public void validate(AssignT3ToExcAVR7Command command) throws Exception {
    Assert.notNull(command, "AssignT3ToExcAVR7Command should not be null");
    Assert.notNull(
        command.getExcAVR7Id(), "AssignT3ToExcAVR7Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT3ToExcAVR7Command assignment should not be null");
  }

  /**
   * handles unassign T3 validation for a ExcAVR7
   *
   * @param command UnAssignT3FromExcAVR7Command
   */
  public void validate(UnAssignT3FromExcAVR7Command command) throws Exception {
    Assert.notNull(command, "UnAssignT3FromExcAVR7Command should not be null");
    Assert.notNull(
        command.getExcAVR7Id(), "UnAssignT3FromExcAVR7Command identifier should not be null");
  }
  /**
   * handles assign T4 validation for a ExcAVR7
   *
   * @param command AssignT4ToExcAVR7Command
   */
  public void validate(AssignT4ToExcAVR7Command command) throws Exception {
    Assert.notNull(command, "AssignT4ToExcAVR7Command should not be null");
    Assert.notNull(
        command.getExcAVR7Id(), "AssignT4ToExcAVR7Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT4ToExcAVR7Command assignment should not be null");
  }

  /**
   * handles unassign T4 validation for a ExcAVR7
   *
   * @param command UnAssignT4FromExcAVR7Command
   */
  public void validate(UnAssignT4FromExcAVR7Command command) throws Exception {
    Assert.notNull(command, "UnAssignT4FromExcAVR7Command should not be null");
    Assert.notNull(
        command.getExcAVR7Id(), "UnAssignT4FromExcAVR7Command identifier should not be null");
  }
  /**
   * handles assign T5 validation for a ExcAVR7
   *
   * @param command AssignT5ToExcAVR7Command
   */
  public void validate(AssignT5ToExcAVR7Command command) throws Exception {
    Assert.notNull(command, "AssignT5ToExcAVR7Command should not be null");
    Assert.notNull(
        command.getExcAVR7Id(), "AssignT5ToExcAVR7Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT5ToExcAVR7Command assignment should not be null");
  }

  /**
   * handles unassign T5 validation for a ExcAVR7
   *
   * @param command UnAssignT5FromExcAVR7Command
   */
  public void validate(UnAssignT5FromExcAVR7Command command) throws Exception {
    Assert.notNull(command, "UnAssignT5FromExcAVR7Command should not be null");
    Assert.notNull(
        command.getExcAVR7Id(), "UnAssignT5FromExcAVR7Command identifier should not be null");
  }
  /**
   * handles assign T6 validation for a ExcAVR7
   *
   * @param command AssignT6ToExcAVR7Command
   */
  public void validate(AssignT6ToExcAVR7Command command) throws Exception {
    Assert.notNull(command, "AssignT6ToExcAVR7Command should not be null");
    Assert.notNull(
        command.getExcAVR7Id(), "AssignT6ToExcAVR7Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT6ToExcAVR7Command assignment should not be null");
  }

  /**
   * handles unassign T6 validation for a ExcAVR7
   *
   * @param command UnAssignT6FromExcAVR7Command
   */
  public void validate(UnAssignT6FromExcAVR7Command command) throws Exception {
    Assert.notNull(command, "UnAssignT6FromExcAVR7Command should not be null");
    Assert.notNull(
        command.getExcAVR7Id(), "UnAssignT6FromExcAVR7Command identifier should not be null");
  }
  /**
   * handles assign Vmax1 validation for a ExcAVR7
   *
   * @param command AssignVmax1ToExcAVR7Command
   */
  public void validate(AssignVmax1ToExcAVR7Command command) throws Exception {
    Assert.notNull(command, "AssignVmax1ToExcAVR7Command should not be null");
    Assert.notNull(
        command.getExcAVR7Id(), "AssignVmax1ToExcAVR7Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVmax1ToExcAVR7Command assignment should not be null");
  }

  /**
   * handles unassign Vmax1 validation for a ExcAVR7
   *
   * @param command UnAssignVmax1FromExcAVR7Command
   */
  public void validate(UnAssignVmax1FromExcAVR7Command command) throws Exception {
    Assert.notNull(command, "UnAssignVmax1FromExcAVR7Command should not be null");
    Assert.notNull(
        command.getExcAVR7Id(), "UnAssignVmax1FromExcAVR7Command identifier should not be null");
  }
  /**
   * handles assign Vmax3 validation for a ExcAVR7
   *
   * @param command AssignVmax3ToExcAVR7Command
   */
  public void validate(AssignVmax3ToExcAVR7Command command) throws Exception {
    Assert.notNull(command, "AssignVmax3ToExcAVR7Command should not be null");
    Assert.notNull(
        command.getExcAVR7Id(), "AssignVmax3ToExcAVR7Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVmax3ToExcAVR7Command assignment should not be null");
  }

  /**
   * handles unassign Vmax3 validation for a ExcAVR7
   *
   * @param command UnAssignVmax3FromExcAVR7Command
   */
  public void validate(UnAssignVmax3FromExcAVR7Command command) throws Exception {
    Assert.notNull(command, "UnAssignVmax3FromExcAVR7Command should not be null");
    Assert.notNull(
        command.getExcAVR7Id(), "UnAssignVmax3FromExcAVR7Command identifier should not be null");
  }
  /**
   * handles assign Vmax5 validation for a ExcAVR7
   *
   * @param command AssignVmax5ToExcAVR7Command
   */
  public void validate(AssignVmax5ToExcAVR7Command command) throws Exception {
    Assert.notNull(command, "AssignVmax5ToExcAVR7Command should not be null");
    Assert.notNull(
        command.getExcAVR7Id(), "AssignVmax5ToExcAVR7Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVmax5ToExcAVR7Command assignment should not be null");
  }

  /**
   * handles unassign Vmax5 validation for a ExcAVR7
   *
   * @param command UnAssignVmax5FromExcAVR7Command
   */
  public void validate(UnAssignVmax5FromExcAVR7Command command) throws Exception {
    Assert.notNull(command, "UnAssignVmax5FromExcAVR7Command should not be null");
    Assert.notNull(
        command.getExcAVR7Id(), "UnAssignVmax5FromExcAVR7Command identifier should not be null");
  }
  /**
   * handles assign Vmin1 validation for a ExcAVR7
   *
   * @param command AssignVmin1ToExcAVR7Command
   */
  public void validate(AssignVmin1ToExcAVR7Command command) throws Exception {
    Assert.notNull(command, "AssignVmin1ToExcAVR7Command should not be null");
    Assert.notNull(
        command.getExcAVR7Id(), "AssignVmin1ToExcAVR7Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVmin1ToExcAVR7Command assignment should not be null");
  }

  /**
   * handles unassign Vmin1 validation for a ExcAVR7
   *
   * @param command UnAssignVmin1FromExcAVR7Command
   */
  public void validate(UnAssignVmin1FromExcAVR7Command command) throws Exception {
    Assert.notNull(command, "UnAssignVmin1FromExcAVR7Command should not be null");
    Assert.notNull(
        command.getExcAVR7Id(), "UnAssignVmin1FromExcAVR7Command identifier should not be null");
  }
  /**
   * handles assign Vmin3 validation for a ExcAVR7
   *
   * @param command AssignVmin3ToExcAVR7Command
   */
  public void validate(AssignVmin3ToExcAVR7Command command) throws Exception {
    Assert.notNull(command, "AssignVmin3ToExcAVR7Command should not be null");
    Assert.notNull(
        command.getExcAVR7Id(), "AssignVmin3ToExcAVR7Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVmin3ToExcAVR7Command assignment should not be null");
  }

  /**
   * handles unassign Vmin3 validation for a ExcAVR7
   *
   * @param command UnAssignVmin3FromExcAVR7Command
   */
  public void validate(UnAssignVmin3FromExcAVR7Command command) throws Exception {
    Assert.notNull(command, "UnAssignVmin3FromExcAVR7Command should not be null");
    Assert.notNull(
        command.getExcAVR7Id(), "UnAssignVmin3FromExcAVR7Command identifier should not be null");
  }
  /**
   * handles assign Vmin5 validation for a ExcAVR7
   *
   * @param command AssignVmin5ToExcAVR7Command
   */
  public void validate(AssignVmin5ToExcAVR7Command command) throws Exception {
    Assert.notNull(command, "AssignVmin5ToExcAVR7Command should not be null");
    Assert.notNull(
        command.getExcAVR7Id(), "AssignVmin5ToExcAVR7Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVmin5ToExcAVR7Command assignment should not be null");
  }

  /**
   * handles unassign Vmin5 validation for a ExcAVR7
   *
   * @param command UnAssignVmin5FromExcAVR7Command
   */
  public void validate(UnAssignVmin5FromExcAVR7Command command) throws Exception {
    Assert.notNull(command, "UnAssignVmin5FromExcAVR7Command should not be null");
    Assert.notNull(
        command.getExcAVR7Id(), "UnAssignVmin5FromExcAVR7Command identifier should not be null");
  }
}
