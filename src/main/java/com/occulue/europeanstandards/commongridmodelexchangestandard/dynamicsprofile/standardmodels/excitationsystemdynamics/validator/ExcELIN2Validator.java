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

public class ExcELIN2Validator {

  /** default constructor */
  protected ExcELIN2Validator() {}

  /** factory method */
  public static ExcELIN2Validator getInstance() {
    return new ExcELIN2Validator();
  }

  /** handles creation validation for a ExcELIN2 */
  public void validate(CreateExcELIN2Command excELIN2) throws Exception {
    Assert.notNull(excELIN2, "CreateExcELIN2Command should not be null");
    //		Assert.isNull( excELIN2.getExcELIN2Id(), "CreateExcELIN2Command identifier should be null"
    // );
  }

  /** handles update validation for a ExcELIN2 */
  public void validate(UpdateExcELIN2Command excELIN2) throws Exception {
    Assert.notNull(excELIN2, "UpdateExcELIN2Command should not be null");
    Assert.notNull(excELIN2.getExcELIN2Id(), "UpdateExcELIN2Command identifier should not be null");
  }

  /** handles delete validation for a ExcELIN2 */
  public void validate(DeleteExcELIN2Command excELIN2) throws Exception {
    Assert.notNull(excELIN2, "{commandAlias} should not be null");
    Assert.notNull(excELIN2.getExcELIN2Id(), "DeleteExcELIN2Command identifier should not be null");
  }

  /** handles fetchOne validation for a ExcELIN2 */
  public void validate(ExcELIN2FetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "ExcELIN2FetchOneSummary should not be null");
    Assert.notNull(
        summary.getExcELIN2Id(), "ExcELIN2FetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Efdbas validation for a ExcELIN2
   *
   * @param command AssignEfdbasToExcELIN2Command
   */
  public void validate(AssignEfdbasToExcELIN2Command command) throws Exception {
    Assert.notNull(command, "AssignEfdbasToExcELIN2Command should not be null");
    Assert.notNull(
        command.getExcELIN2Id(), "AssignEfdbasToExcELIN2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignEfdbasToExcELIN2Command assignment should not be null");
  }

  /**
   * handles unassign Efdbas validation for a ExcELIN2
   *
   * @param command UnAssignEfdbasFromExcELIN2Command
   */
  public void validate(UnAssignEfdbasFromExcELIN2Command command) throws Exception {
    Assert.notNull(command, "UnAssignEfdbasFromExcELIN2Command should not be null");
    Assert.notNull(
        command.getExcELIN2Id(), "UnAssignEfdbasFromExcELIN2Command identifier should not be null");
  }
  /**
   * handles assign Iefmax validation for a ExcELIN2
   *
   * @param command AssignIefmaxToExcELIN2Command
   */
  public void validate(AssignIefmaxToExcELIN2Command command) throws Exception {
    Assert.notNull(command, "AssignIefmaxToExcELIN2Command should not be null");
    Assert.notNull(
        command.getExcELIN2Id(), "AssignIefmaxToExcELIN2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignIefmaxToExcELIN2Command assignment should not be null");
  }

  /**
   * handles unassign Iefmax validation for a ExcELIN2
   *
   * @param command UnAssignIefmaxFromExcELIN2Command
   */
  public void validate(UnAssignIefmaxFromExcELIN2Command command) throws Exception {
    Assert.notNull(command, "UnAssignIefmaxFromExcELIN2Command should not be null");
    Assert.notNull(
        command.getExcELIN2Id(), "UnAssignIefmaxFromExcELIN2Command identifier should not be null");
  }
  /**
   * handles assign Iefmax2 validation for a ExcELIN2
   *
   * @param command AssignIefmax2ToExcELIN2Command
   */
  public void validate(AssignIefmax2ToExcELIN2Command command) throws Exception {
    Assert.notNull(command, "AssignIefmax2ToExcELIN2Command should not be null");
    Assert.notNull(
        command.getExcELIN2Id(), "AssignIefmax2ToExcELIN2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignIefmax2ToExcELIN2Command assignment should not be null");
  }

  /**
   * handles unassign Iefmax2 validation for a ExcELIN2
   *
   * @param command UnAssignIefmax2FromExcELIN2Command
   */
  public void validate(UnAssignIefmax2FromExcELIN2Command command) throws Exception {
    Assert.notNull(command, "UnAssignIefmax2FromExcELIN2Command should not be null");
    Assert.notNull(
        command.getExcELIN2Id(),
        "UnAssignIefmax2FromExcELIN2Command identifier should not be null");
  }
  /**
   * handles assign Iefmin validation for a ExcELIN2
   *
   * @param command AssignIefminToExcELIN2Command
   */
  public void validate(AssignIefminToExcELIN2Command command) throws Exception {
    Assert.notNull(command, "AssignIefminToExcELIN2Command should not be null");
    Assert.notNull(
        command.getExcELIN2Id(), "AssignIefminToExcELIN2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignIefminToExcELIN2Command assignment should not be null");
  }

  /**
   * handles unassign Iefmin validation for a ExcELIN2
   *
   * @param command UnAssignIefminFromExcELIN2Command
   */
  public void validate(UnAssignIefminFromExcELIN2Command command) throws Exception {
    Assert.notNull(command, "UnAssignIefminFromExcELIN2Command should not be null");
    Assert.notNull(
        command.getExcELIN2Id(), "UnAssignIefminFromExcELIN2Command identifier should not be null");
  }
  /**
   * handles assign K1 validation for a ExcELIN2
   *
   * @param command AssignK1ToExcELIN2Command
   */
  public void validate(AssignK1ToExcELIN2Command command) throws Exception {
    Assert.notNull(command, "AssignK1ToExcELIN2Command should not be null");
    Assert.notNull(
        command.getExcELIN2Id(), "AssignK1ToExcELIN2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignK1ToExcELIN2Command assignment should not be null");
  }

  /**
   * handles unassign K1 validation for a ExcELIN2
   *
   * @param command UnAssignK1FromExcELIN2Command
   */
  public void validate(UnAssignK1FromExcELIN2Command command) throws Exception {
    Assert.notNull(command, "UnAssignK1FromExcELIN2Command should not be null");
    Assert.notNull(
        command.getExcELIN2Id(), "UnAssignK1FromExcELIN2Command identifier should not be null");
  }
  /**
   * handles assign K1ec validation for a ExcELIN2
   *
   * @param command AssignK1ecToExcELIN2Command
   */
  public void validate(AssignK1ecToExcELIN2Command command) throws Exception {
    Assert.notNull(command, "AssignK1ecToExcELIN2Command should not be null");
    Assert.notNull(
        command.getExcELIN2Id(), "AssignK1ecToExcELIN2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignK1ecToExcELIN2Command assignment should not be null");
  }

  /**
   * handles unassign K1ec validation for a ExcELIN2
   *
   * @param command UnAssignK1ecFromExcELIN2Command
   */
  public void validate(UnAssignK1ecFromExcELIN2Command command) throws Exception {
    Assert.notNull(command, "UnAssignK1ecFromExcELIN2Command should not be null");
    Assert.notNull(
        command.getExcELIN2Id(), "UnAssignK1ecFromExcELIN2Command identifier should not be null");
  }
  /**
   * handles assign K2 validation for a ExcELIN2
   *
   * @param command AssignK2ToExcELIN2Command
   */
  public void validate(AssignK2ToExcELIN2Command command) throws Exception {
    Assert.notNull(command, "AssignK2ToExcELIN2Command should not be null");
    Assert.notNull(
        command.getExcELIN2Id(), "AssignK2ToExcELIN2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignK2ToExcELIN2Command assignment should not be null");
  }

  /**
   * handles unassign K2 validation for a ExcELIN2
   *
   * @param command UnAssignK2FromExcELIN2Command
   */
  public void validate(UnAssignK2FromExcELIN2Command command) throws Exception {
    Assert.notNull(command, "UnAssignK2FromExcELIN2Command should not be null");
    Assert.notNull(
        command.getExcELIN2Id(), "UnAssignK2FromExcELIN2Command identifier should not be null");
  }
  /**
   * handles assign K3 validation for a ExcELIN2
   *
   * @param command AssignK3ToExcELIN2Command
   */
  public void validate(AssignK3ToExcELIN2Command command) throws Exception {
    Assert.notNull(command, "AssignK3ToExcELIN2Command should not be null");
    Assert.notNull(
        command.getExcELIN2Id(), "AssignK3ToExcELIN2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignK3ToExcELIN2Command assignment should not be null");
  }

  /**
   * handles unassign K3 validation for a ExcELIN2
   *
   * @param command UnAssignK3FromExcELIN2Command
   */
  public void validate(UnAssignK3FromExcELIN2Command command) throws Exception {
    Assert.notNull(command, "UnAssignK3FromExcELIN2Command should not be null");
    Assert.notNull(
        command.getExcELIN2Id(), "UnAssignK3FromExcELIN2Command identifier should not be null");
  }
  /**
   * handles assign K4 validation for a ExcELIN2
   *
   * @param command AssignK4ToExcELIN2Command
   */
  public void validate(AssignK4ToExcELIN2Command command) throws Exception {
    Assert.notNull(command, "AssignK4ToExcELIN2Command should not be null");
    Assert.notNull(
        command.getExcELIN2Id(), "AssignK4ToExcELIN2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignK4ToExcELIN2Command assignment should not be null");
  }

  /**
   * handles unassign K4 validation for a ExcELIN2
   *
   * @param command UnAssignK4FromExcELIN2Command
   */
  public void validate(UnAssignK4FromExcELIN2Command command) throws Exception {
    Assert.notNull(command, "UnAssignK4FromExcELIN2Command should not be null");
    Assert.notNull(
        command.getExcELIN2Id(), "UnAssignK4FromExcELIN2Command identifier should not be null");
  }
  /**
   * handles assign Kd1 validation for a ExcELIN2
   *
   * @param command AssignKd1ToExcELIN2Command
   */
  public void validate(AssignKd1ToExcELIN2Command command) throws Exception {
    Assert.notNull(command, "AssignKd1ToExcELIN2Command should not be null");
    Assert.notNull(
        command.getExcELIN2Id(), "AssignKd1ToExcELIN2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKd1ToExcELIN2Command assignment should not be null");
  }

  /**
   * handles unassign Kd1 validation for a ExcELIN2
   *
   * @param command UnAssignKd1FromExcELIN2Command
   */
  public void validate(UnAssignKd1FromExcELIN2Command command) throws Exception {
    Assert.notNull(command, "UnAssignKd1FromExcELIN2Command should not be null");
    Assert.notNull(
        command.getExcELIN2Id(), "UnAssignKd1FromExcELIN2Command identifier should not be null");
  }
  /**
   * handles assign Ke2 validation for a ExcELIN2
   *
   * @param command AssignKe2ToExcELIN2Command
   */
  public void validate(AssignKe2ToExcELIN2Command command) throws Exception {
    Assert.notNull(command, "AssignKe2ToExcELIN2Command should not be null");
    Assert.notNull(
        command.getExcELIN2Id(), "AssignKe2ToExcELIN2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKe2ToExcELIN2Command assignment should not be null");
  }

  /**
   * handles unassign Ke2 validation for a ExcELIN2
   *
   * @param command UnAssignKe2FromExcELIN2Command
   */
  public void validate(UnAssignKe2FromExcELIN2Command command) throws Exception {
    Assert.notNull(command, "UnAssignKe2FromExcELIN2Command should not be null");
    Assert.notNull(
        command.getExcELIN2Id(), "UnAssignKe2FromExcELIN2Command identifier should not be null");
  }
  /**
   * handles assign Ketb validation for a ExcELIN2
   *
   * @param command AssignKetbToExcELIN2Command
   */
  public void validate(AssignKetbToExcELIN2Command command) throws Exception {
    Assert.notNull(command, "AssignKetbToExcELIN2Command should not be null");
    Assert.notNull(
        command.getExcELIN2Id(), "AssignKetbToExcELIN2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKetbToExcELIN2Command assignment should not be null");
  }

  /**
   * handles unassign Ketb validation for a ExcELIN2
   *
   * @param command UnAssignKetbFromExcELIN2Command
   */
  public void validate(UnAssignKetbFromExcELIN2Command command) throws Exception {
    Assert.notNull(command, "UnAssignKetbFromExcELIN2Command should not be null");
    Assert.notNull(
        command.getExcELIN2Id(), "UnAssignKetbFromExcELIN2Command identifier should not be null");
  }
  /**
   * handles assign Pid1max validation for a ExcELIN2
   *
   * @param command AssignPid1maxToExcELIN2Command
   */
  public void validate(AssignPid1maxToExcELIN2Command command) throws Exception {
    Assert.notNull(command, "AssignPid1maxToExcELIN2Command should not be null");
    Assert.notNull(
        command.getExcELIN2Id(), "AssignPid1maxToExcELIN2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignPid1maxToExcELIN2Command assignment should not be null");
  }

  /**
   * handles unassign Pid1max validation for a ExcELIN2
   *
   * @param command UnAssignPid1maxFromExcELIN2Command
   */
  public void validate(UnAssignPid1maxFromExcELIN2Command command) throws Exception {
    Assert.notNull(command, "UnAssignPid1maxFromExcELIN2Command should not be null");
    Assert.notNull(
        command.getExcELIN2Id(),
        "UnAssignPid1maxFromExcELIN2Command identifier should not be null");
  }
  /**
   * handles assign Seve1 validation for a ExcELIN2
   *
   * @param command AssignSeve1ToExcELIN2Command
   */
  public void validate(AssignSeve1ToExcELIN2Command command) throws Exception {
    Assert.notNull(command, "AssignSeve1ToExcELIN2Command should not be null");
    Assert.notNull(
        command.getExcELIN2Id(), "AssignSeve1ToExcELIN2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignSeve1ToExcELIN2Command assignment should not be null");
  }

  /**
   * handles unassign Seve1 validation for a ExcELIN2
   *
   * @param command UnAssignSeve1FromExcELIN2Command
   */
  public void validate(UnAssignSeve1FromExcELIN2Command command) throws Exception {
    Assert.notNull(command, "UnAssignSeve1FromExcELIN2Command should not be null");
    Assert.notNull(
        command.getExcELIN2Id(), "UnAssignSeve1FromExcELIN2Command identifier should not be null");
  }
  /**
   * handles assign Seve2 validation for a ExcELIN2
   *
   * @param command AssignSeve2ToExcELIN2Command
   */
  public void validate(AssignSeve2ToExcELIN2Command command) throws Exception {
    Assert.notNull(command, "AssignSeve2ToExcELIN2Command should not be null");
    Assert.notNull(
        command.getExcELIN2Id(), "AssignSeve2ToExcELIN2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignSeve2ToExcELIN2Command assignment should not be null");
  }

  /**
   * handles unassign Seve2 validation for a ExcELIN2
   *
   * @param command UnAssignSeve2FromExcELIN2Command
   */
  public void validate(UnAssignSeve2FromExcELIN2Command command) throws Exception {
    Assert.notNull(command, "UnAssignSeve2FromExcELIN2Command should not be null");
    Assert.notNull(
        command.getExcELIN2Id(), "UnAssignSeve2FromExcELIN2Command identifier should not be null");
  }
  /**
   * handles assign Tb1 validation for a ExcELIN2
   *
   * @param command AssignTb1ToExcELIN2Command
   */
  public void validate(AssignTb1ToExcELIN2Command command) throws Exception {
    Assert.notNull(command, "AssignTb1ToExcELIN2Command should not be null");
    Assert.notNull(
        command.getExcELIN2Id(), "AssignTb1ToExcELIN2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTb1ToExcELIN2Command assignment should not be null");
  }

  /**
   * handles unassign Tb1 validation for a ExcELIN2
   *
   * @param command UnAssignTb1FromExcELIN2Command
   */
  public void validate(UnAssignTb1FromExcELIN2Command command) throws Exception {
    Assert.notNull(command, "UnAssignTb1FromExcELIN2Command should not be null");
    Assert.notNull(
        command.getExcELIN2Id(), "UnAssignTb1FromExcELIN2Command identifier should not be null");
  }
  /**
   * handles assign Te validation for a ExcELIN2
   *
   * @param command AssignTeToExcELIN2Command
   */
  public void validate(AssignTeToExcELIN2Command command) throws Exception {
    Assert.notNull(command, "AssignTeToExcELIN2Command should not be null");
    Assert.notNull(
        command.getExcELIN2Id(), "AssignTeToExcELIN2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTeToExcELIN2Command assignment should not be null");
  }

  /**
   * handles unassign Te validation for a ExcELIN2
   *
   * @param command UnAssignTeFromExcELIN2Command
   */
  public void validate(UnAssignTeFromExcELIN2Command command) throws Exception {
    Assert.notNull(command, "UnAssignTeFromExcELIN2Command should not be null");
    Assert.notNull(
        command.getExcELIN2Id(), "UnAssignTeFromExcELIN2Command identifier should not be null");
  }
  /**
   * handles assign Te2 validation for a ExcELIN2
   *
   * @param command AssignTe2ToExcELIN2Command
   */
  public void validate(AssignTe2ToExcELIN2Command command) throws Exception {
    Assert.notNull(command, "AssignTe2ToExcELIN2Command should not be null");
    Assert.notNull(
        command.getExcELIN2Id(), "AssignTe2ToExcELIN2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTe2ToExcELIN2Command assignment should not be null");
  }

  /**
   * handles unassign Te2 validation for a ExcELIN2
   *
   * @param command UnAssignTe2FromExcELIN2Command
   */
  public void validate(UnAssignTe2FromExcELIN2Command command) throws Exception {
    Assert.notNull(command, "UnAssignTe2FromExcELIN2Command should not be null");
    Assert.notNull(
        command.getExcELIN2Id(), "UnAssignTe2FromExcELIN2Command identifier should not be null");
  }
  /**
   * handles assign Ti1 validation for a ExcELIN2
   *
   * @param command AssignTi1ToExcELIN2Command
   */
  public void validate(AssignTi1ToExcELIN2Command command) throws Exception {
    Assert.notNull(command, "AssignTi1ToExcELIN2Command should not be null");
    Assert.notNull(
        command.getExcELIN2Id(), "AssignTi1ToExcELIN2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTi1ToExcELIN2Command assignment should not be null");
  }

  /**
   * handles unassign Ti1 validation for a ExcELIN2
   *
   * @param command UnAssignTi1FromExcELIN2Command
   */
  public void validate(UnAssignTi1FromExcELIN2Command command) throws Exception {
    Assert.notNull(command, "UnAssignTi1FromExcELIN2Command should not be null");
    Assert.notNull(
        command.getExcELIN2Id(), "UnAssignTi1FromExcELIN2Command identifier should not be null");
  }
  /**
   * handles assign Ti3 validation for a ExcELIN2
   *
   * @param command AssignTi3ToExcELIN2Command
   */
  public void validate(AssignTi3ToExcELIN2Command command) throws Exception {
    Assert.notNull(command, "AssignTi3ToExcELIN2Command should not be null");
    Assert.notNull(
        command.getExcELIN2Id(), "AssignTi3ToExcELIN2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTi3ToExcELIN2Command assignment should not be null");
  }

  /**
   * handles unassign Ti3 validation for a ExcELIN2
   *
   * @param command UnAssignTi3FromExcELIN2Command
   */
  public void validate(UnAssignTi3FromExcELIN2Command command) throws Exception {
    Assert.notNull(command, "UnAssignTi3FromExcELIN2Command should not be null");
    Assert.notNull(
        command.getExcELIN2Id(), "UnAssignTi3FromExcELIN2Command identifier should not be null");
  }
  /**
   * handles assign Ti4 validation for a ExcELIN2
   *
   * @param command AssignTi4ToExcELIN2Command
   */
  public void validate(AssignTi4ToExcELIN2Command command) throws Exception {
    Assert.notNull(command, "AssignTi4ToExcELIN2Command should not be null");
    Assert.notNull(
        command.getExcELIN2Id(), "AssignTi4ToExcELIN2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTi4ToExcELIN2Command assignment should not be null");
  }

  /**
   * handles unassign Ti4 validation for a ExcELIN2
   *
   * @param command UnAssignTi4FromExcELIN2Command
   */
  public void validate(UnAssignTi4FromExcELIN2Command command) throws Exception {
    Assert.notNull(command, "UnAssignTi4FromExcELIN2Command should not be null");
    Assert.notNull(
        command.getExcELIN2Id(), "UnAssignTi4FromExcELIN2Command identifier should not be null");
  }
  /**
   * handles assign Tr4 validation for a ExcELIN2
   *
   * @param command AssignTr4ToExcELIN2Command
   */
  public void validate(AssignTr4ToExcELIN2Command command) throws Exception {
    Assert.notNull(command, "AssignTr4ToExcELIN2Command should not be null");
    Assert.notNull(
        command.getExcELIN2Id(), "AssignTr4ToExcELIN2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTr4ToExcELIN2Command assignment should not be null");
  }

  /**
   * handles unassign Tr4 validation for a ExcELIN2
   *
   * @param command UnAssignTr4FromExcELIN2Command
   */
  public void validate(UnAssignTr4FromExcELIN2Command command) throws Exception {
    Assert.notNull(command, "UnAssignTr4FromExcELIN2Command should not be null");
    Assert.notNull(
        command.getExcELIN2Id(), "UnAssignTr4FromExcELIN2Command identifier should not be null");
  }
  /**
   * handles assign Upmax validation for a ExcELIN2
   *
   * @param command AssignUpmaxToExcELIN2Command
   */
  public void validate(AssignUpmaxToExcELIN2Command command) throws Exception {
    Assert.notNull(command, "AssignUpmaxToExcELIN2Command should not be null");
    Assert.notNull(
        command.getExcELIN2Id(), "AssignUpmaxToExcELIN2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignUpmaxToExcELIN2Command assignment should not be null");
  }

  /**
   * handles unassign Upmax validation for a ExcELIN2
   *
   * @param command UnAssignUpmaxFromExcELIN2Command
   */
  public void validate(UnAssignUpmaxFromExcELIN2Command command) throws Exception {
    Assert.notNull(command, "UnAssignUpmaxFromExcELIN2Command should not be null");
    Assert.notNull(
        command.getExcELIN2Id(), "UnAssignUpmaxFromExcELIN2Command identifier should not be null");
  }
  /**
   * handles assign Upmin validation for a ExcELIN2
   *
   * @param command AssignUpminToExcELIN2Command
   */
  public void validate(AssignUpminToExcELIN2Command command) throws Exception {
    Assert.notNull(command, "AssignUpminToExcELIN2Command should not be null");
    Assert.notNull(
        command.getExcELIN2Id(), "AssignUpminToExcELIN2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignUpminToExcELIN2Command assignment should not be null");
  }

  /**
   * handles unassign Upmin validation for a ExcELIN2
   *
   * @param command UnAssignUpminFromExcELIN2Command
   */
  public void validate(UnAssignUpminFromExcELIN2Command command) throws Exception {
    Assert.notNull(command, "UnAssignUpminFromExcELIN2Command should not be null");
    Assert.notNull(
        command.getExcELIN2Id(), "UnAssignUpminFromExcELIN2Command identifier should not be null");
  }
  /**
   * handles assign Ve1 validation for a ExcELIN2
   *
   * @param command AssignVe1ToExcELIN2Command
   */
  public void validate(AssignVe1ToExcELIN2Command command) throws Exception {
    Assert.notNull(command, "AssignVe1ToExcELIN2Command should not be null");
    Assert.notNull(
        command.getExcELIN2Id(), "AssignVe1ToExcELIN2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVe1ToExcELIN2Command assignment should not be null");
  }

  /**
   * handles unassign Ve1 validation for a ExcELIN2
   *
   * @param command UnAssignVe1FromExcELIN2Command
   */
  public void validate(UnAssignVe1FromExcELIN2Command command) throws Exception {
    Assert.notNull(command, "UnAssignVe1FromExcELIN2Command should not be null");
    Assert.notNull(
        command.getExcELIN2Id(), "UnAssignVe1FromExcELIN2Command identifier should not be null");
  }
  /**
   * handles assign Ve2 validation for a ExcELIN2
   *
   * @param command AssignVe2ToExcELIN2Command
   */
  public void validate(AssignVe2ToExcELIN2Command command) throws Exception {
    Assert.notNull(command, "AssignVe2ToExcELIN2Command should not be null");
    Assert.notNull(
        command.getExcELIN2Id(), "AssignVe2ToExcELIN2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVe2ToExcELIN2Command assignment should not be null");
  }

  /**
   * handles unassign Ve2 validation for a ExcELIN2
   *
   * @param command UnAssignVe2FromExcELIN2Command
   */
  public void validate(UnAssignVe2FromExcELIN2Command command) throws Exception {
    Assert.notNull(command, "UnAssignVe2FromExcELIN2Command should not be null");
    Assert.notNull(
        command.getExcELIN2Id(), "UnAssignVe2FromExcELIN2Command identifier should not be null");
  }
  /**
   * handles assign Xp validation for a ExcELIN2
   *
   * @param command AssignXpToExcELIN2Command
   */
  public void validate(AssignXpToExcELIN2Command command) throws Exception {
    Assert.notNull(command, "AssignXpToExcELIN2Command should not be null");
    Assert.notNull(
        command.getExcELIN2Id(), "AssignXpToExcELIN2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignXpToExcELIN2Command assignment should not be null");
  }

  /**
   * handles unassign Xp validation for a ExcELIN2
   *
   * @param command UnAssignXpFromExcELIN2Command
   */
  public void validate(UnAssignXpFromExcELIN2Command command) throws Exception {
    Assert.notNull(command, "UnAssignXpFromExcELIN2Command should not be null");
    Assert.notNull(
        command.getExcELIN2Id(), "UnAssignXpFromExcELIN2Command identifier should not be null");
  }
}
