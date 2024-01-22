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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.winddynamics.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class WindContQIECValidator {

  /** default constructor */
  protected WindContQIECValidator() {}

  /** factory method */
  public static WindContQIECValidator getInstance() {
    return new WindContQIECValidator();
  }

  /** handles creation validation for a WindContQIEC */
  public void validate(CreateWindContQIECCommand windContQIEC) throws Exception {
    Assert.notNull(windContQIEC, "CreateWindContQIECCommand should not be null");
    //		Assert.isNull( windContQIEC.getWindContQIECId(), "CreateWindContQIECCommand identifier
    // should be null" );
  }

  /** handles update validation for a WindContQIEC */
  public void validate(UpdateWindContQIECCommand windContQIEC) throws Exception {
    Assert.notNull(windContQIEC, "UpdateWindContQIECCommand should not be null");
    Assert.notNull(
        windContQIEC.getWindContQIECId(),
        "UpdateWindContQIECCommand identifier should not be null");
  }

  /** handles delete validation for a WindContQIEC */
  public void validate(DeleteWindContQIECCommand windContQIEC) throws Exception {
    Assert.notNull(windContQIEC, "{commandAlias} should not be null");
    Assert.notNull(
        windContQIEC.getWindContQIECId(),
        "DeleteWindContQIECCommand identifier should not be null");
  }

  /** handles fetchOne validation for a WindContQIEC */
  public void validate(WindContQIECFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "WindContQIECFetchOneSummary should not be null");
    Assert.notNull(
        summary.getWindContQIECId(), "WindContQIECFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Iqh1 validation for a WindContQIEC
   *
   * @param command AssignIqh1ToWindContQIECCommand
   */
  public void validate(AssignIqh1ToWindContQIECCommand command) throws Exception {
    Assert.notNull(command, "AssignIqh1ToWindContQIECCommand should not be null");
    Assert.notNull(
        command.getWindContQIECId(),
        "AssignIqh1ToWindContQIECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignIqh1ToWindContQIECCommand assignment should not be null");
  }

  /**
   * handles unassign Iqh1 validation for a WindContQIEC
   *
   * @param command UnAssignIqh1FromWindContQIECCommand
   */
  public void validate(UnAssignIqh1FromWindContQIECCommand command) throws Exception {
    Assert.notNull(command, "UnAssignIqh1FromWindContQIECCommand should not be null");
    Assert.notNull(
        command.getWindContQIECId(),
        "UnAssignIqh1FromWindContQIECCommand identifier should not be null");
  }
  /**
   * handles assign Iqmax validation for a WindContQIEC
   *
   * @param command AssignIqmaxToWindContQIECCommand
   */
  public void validate(AssignIqmaxToWindContQIECCommand command) throws Exception {
    Assert.notNull(command, "AssignIqmaxToWindContQIECCommand should not be null");
    Assert.notNull(
        command.getWindContQIECId(),
        "AssignIqmaxToWindContQIECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignIqmaxToWindContQIECCommand assignment should not be null");
  }

  /**
   * handles unassign Iqmax validation for a WindContQIEC
   *
   * @param command UnAssignIqmaxFromWindContQIECCommand
   */
  public void validate(UnAssignIqmaxFromWindContQIECCommand command) throws Exception {
    Assert.notNull(command, "UnAssignIqmaxFromWindContQIECCommand should not be null");
    Assert.notNull(
        command.getWindContQIECId(),
        "UnAssignIqmaxFromWindContQIECCommand identifier should not be null");
  }
  /**
   * handles assign Iqmin validation for a WindContQIEC
   *
   * @param command AssignIqminToWindContQIECCommand
   */
  public void validate(AssignIqminToWindContQIECCommand command) throws Exception {
    Assert.notNull(command, "AssignIqminToWindContQIECCommand should not be null");
    Assert.notNull(
        command.getWindContQIECId(),
        "AssignIqminToWindContQIECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignIqminToWindContQIECCommand assignment should not be null");
  }

  /**
   * handles unassign Iqmin validation for a WindContQIEC
   *
   * @param command UnAssignIqminFromWindContQIECCommand
   */
  public void validate(UnAssignIqminFromWindContQIECCommand command) throws Exception {
    Assert.notNull(command, "UnAssignIqminFromWindContQIECCommand should not be null");
    Assert.notNull(
        command.getWindContQIECId(),
        "UnAssignIqminFromWindContQIECCommand identifier should not be null");
  }
  /**
   * handles assign Iqpost validation for a WindContQIEC
   *
   * @param command AssignIqpostToWindContQIECCommand
   */
  public void validate(AssignIqpostToWindContQIECCommand command) throws Exception {
    Assert.notNull(command, "AssignIqpostToWindContQIECCommand should not be null");
    Assert.notNull(
        command.getWindContQIECId(),
        "AssignIqpostToWindContQIECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignIqpostToWindContQIECCommand assignment should not be null");
  }

  /**
   * handles unassign Iqpost validation for a WindContQIEC
   *
   * @param command UnAssignIqpostFromWindContQIECCommand
   */
  public void validate(UnAssignIqpostFromWindContQIECCommand command) throws Exception {
    Assert.notNull(command, "UnAssignIqpostFromWindContQIECCommand should not be null");
    Assert.notNull(
        command.getWindContQIECId(),
        "UnAssignIqpostFromWindContQIECCommand identifier should not be null");
  }
  /**
   * handles assign Kiq validation for a WindContQIEC
   *
   * @param command AssignKiqToWindContQIECCommand
   */
  public void validate(AssignKiqToWindContQIECCommand command) throws Exception {
    Assert.notNull(command, "AssignKiqToWindContQIECCommand should not be null");
    Assert.notNull(
        command.getWindContQIECId(),
        "AssignKiqToWindContQIECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKiqToWindContQIECCommand assignment should not be null");
  }

  /**
   * handles unassign Kiq validation for a WindContQIEC
   *
   * @param command UnAssignKiqFromWindContQIECCommand
   */
  public void validate(UnAssignKiqFromWindContQIECCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKiqFromWindContQIECCommand should not be null");
    Assert.notNull(
        command.getWindContQIECId(),
        "UnAssignKiqFromWindContQIECCommand identifier should not be null");
  }
  /**
   * handles assign Kiu validation for a WindContQIEC
   *
   * @param command AssignKiuToWindContQIECCommand
   */
  public void validate(AssignKiuToWindContQIECCommand command) throws Exception {
    Assert.notNull(command, "AssignKiuToWindContQIECCommand should not be null");
    Assert.notNull(
        command.getWindContQIECId(),
        "AssignKiuToWindContQIECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKiuToWindContQIECCommand assignment should not be null");
  }

  /**
   * handles unassign Kiu validation for a WindContQIEC
   *
   * @param command UnAssignKiuFromWindContQIECCommand
   */
  public void validate(UnAssignKiuFromWindContQIECCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKiuFromWindContQIECCommand should not be null");
    Assert.notNull(
        command.getWindContQIECId(),
        "UnAssignKiuFromWindContQIECCommand identifier should not be null");
  }
  /**
   * handles assign Kpq validation for a WindContQIEC
   *
   * @param command AssignKpqToWindContQIECCommand
   */
  public void validate(AssignKpqToWindContQIECCommand command) throws Exception {
    Assert.notNull(command, "AssignKpqToWindContQIECCommand should not be null");
    Assert.notNull(
        command.getWindContQIECId(),
        "AssignKpqToWindContQIECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKpqToWindContQIECCommand assignment should not be null");
  }

  /**
   * handles unassign Kpq validation for a WindContQIEC
   *
   * @param command UnAssignKpqFromWindContQIECCommand
   */
  public void validate(UnAssignKpqFromWindContQIECCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKpqFromWindContQIECCommand should not be null");
    Assert.notNull(
        command.getWindContQIECId(),
        "UnAssignKpqFromWindContQIECCommand identifier should not be null");
  }
  /**
   * handles assign Kpu validation for a WindContQIEC
   *
   * @param command AssignKpuToWindContQIECCommand
   */
  public void validate(AssignKpuToWindContQIECCommand command) throws Exception {
    Assert.notNull(command, "AssignKpuToWindContQIECCommand should not be null");
    Assert.notNull(
        command.getWindContQIECId(),
        "AssignKpuToWindContQIECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKpuToWindContQIECCommand assignment should not be null");
  }

  /**
   * handles unassign Kpu validation for a WindContQIEC
   *
   * @param command UnAssignKpuFromWindContQIECCommand
   */
  public void validate(UnAssignKpuFromWindContQIECCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKpuFromWindContQIECCommand should not be null");
    Assert.notNull(
        command.getWindContQIECId(),
        "UnAssignKpuFromWindContQIECCommand identifier should not be null");
  }
  /**
   * handles assign Kqv validation for a WindContQIEC
   *
   * @param command AssignKqvToWindContQIECCommand
   */
  public void validate(AssignKqvToWindContQIECCommand command) throws Exception {
    Assert.notNull(command, "AssignKqvToWindContQIECCommand should not be null");
    Assert.notNull(
        command.getWindContQIECId(),
        "AssignKqvToWindContQIECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKqvToWindContQIECCommand assignment should not be null");
  }

  /**
   * handles unassign Kqv validation for a WindContQIEC
   *
   * @param command UnAssignKqvFromWindContQIECCommand
   */
  public void validate(UnAssignKqvFromWindContQIECCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKqvFromWindContQIECCommand should not be null");
    Assert.notNull(
        command.getWindContQIECId(),
        "UnAssignKqvFromWindContQIECCommand identifier should not be null");
  }
  /**
   * handles assign Qmax validation for a WindContQIEC
   *
   * @param command AssignQmaxToWindContQIECCommand
   */
  public void validate(AssignQmaxToWindContQIECCommand command) throws Exception {
    Assert.notNull(command, "AssignQmaxToWindContQIECCommand should not be null");
    Assert.notNull(
        command.getWindContQIECId(),
        "AssignQmaxToWindContQIECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignQmaxToWindContQIECCommand assignment should not be null");
  }

  /**
   * handles unassign Qmax validation for a WindContQIEC
   *
   * @param command UnAssignQmaxFromWindContQIECCommand
   */
  public void validate(UnAssignQmaxFromWindContQIECCommand command) throws Exception {
    Assert.notNull(command, "UnAssignQmaxFromWindContQIECCommand should not be null");
    Assert.notNull(
        command.getWindContQIECId(),
        "UnAssignQmaxFromWindContQIECCommand identifier should not be null");
  }
  /**
   * handles assign Qmin validation for a WindContQIEC
   *
   * @param command AssignQminToWindContQIECCommand
   */
  public void validate(AssignQminToWindContQIECCommand command) throws Exception {
    Assert.notNull(command, "AssignQminToWindContQIECCommand should not be null");
    Assert.notNull(
        command.getWindContQIECId(),
        "AssignQminToWindContQIECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignQminToWindContQIECCommand assignment should not be null");
  }

  /**
   * handles unassign Qmin validation for a WindContQIEC
   *
   * @param command UnAssignQminFromWindContQIECCommand
   */
  public void validate(UnAssignQminFromWindContQIECCommand command) throws Exception {
    Assert.notNull(command, "UnAssignQminFromWindContQIECCommand should not be null");
    Assert.notNull(
        command.getWindContQIECId(),
        "UnAssignQminFromWindContQIECCommand identifier should not be null");
  }
  /**
   * handles assign Rdroop validation for a WindContQIEC
   *
   * @param command AssignRdroopToWindContQIECCommand
   */
  public void validate(AssignRdroopToWindContQIECCommand command) throws Exception {
    Assert.notNull(command, "AssignRdroopToWindContQIECCommand should not be null");
    Assert.notNull(
        command.getWindContQIECId(),
        "AssignRdroopToWindContQIECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignRdroopToWindContQIECCommand assignment should not be null");
  }

  /**
   * handles unassign Rdroop validation for a WindContQIEC
   *
   * @param command UnAssignRdroopFromWindContQIECCommand
   */
  public void validate(UnAssignRdroopFromWindContQIECCommand command) throws Exception {
    Assert.notNull(command, "UnAssignRdroopFromWindContQIECCommand should not be null");
    Assert.notNull(
        command.getWindContQIECId(),
        "UnAssignRdroopFromWindContQIECCommand identifier should not be null");
  }
  /**
   * handles assign Tiq validation for a WindContQIEC
   *
   * @param command AssignTiqToWindContQIECCommand
   */
  public void validate(AssignTiqToWindContQIECCommand command) throws Exception {
    Assert.notNull(command, "AssignTiqToWindContQIECCommand should not be null");
    Assert.notNull(
        command.getWindContQIECId(),
        "AssignTiqToWindContQIECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTiqToWindContQIECCommand assignment should not be null");
  }

  /**
   * handles unassign Tiq validation for a WindContQIEC
   *
   * @param command UnAssignTiqFromWindContQIECCommand
   */
  public void validate(UnAssignTiqFromWindContQIECCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTiqFromWindContQIECCommand should not be null");
    Assert.notNull(
        command.getWindContQIECId(),
        "UnAssignTiqFromWindContQIECCommand identifier should not be null");
  }
  /**
   * handles assign Tpfilt validation for a WindContQIEC
   *
   * @param command AssignTpfiltToWindContQIECCommand
   */
  public void validate(AssignTpfiltToWindContQIECCommand command) throws Exception {
    Assert.notNull(command, "AssignTpfiltToWindContQIECCommand should not be null");
    Assert.notNull(
        command.getWindContQIECId(),
        "AssignTpfiltToWindContQIECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTpfiltToWindContQIECCommand assignment should not be null");
  }

  /**
   * handles unassign Tpfilt validation for a WindContQIEC
   *
   * @param command UnAssignTpfiltFromWindContQIECCommand
   */
  public void validate(UnAssignTpfiltFromWindContQIECCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTpfiltFromWindContQIECCommand should not be null");
    Assert.notNull(
        command.getWindContQIECId(),
        "UnAssignTpfiltFromWindContQIECCommand identifier should not be null");
  }
  /**
   * handles assign Tpost validation for a WindContQIEC
   *
   * @param command AssignTpostToWindContQIECCommand
   */
  public void validate(AssignTpostToWindContQIECCommand command) throws Exception {
    Assert.notNull(command, "AssignTpostToWindContQIECCommand should not be null");
    Assert.notNull(
        command.getWindContQIECId(),
        "AssignTpostToWindContQIECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTpostToWindContQIECCommand assignment should not be null");
  }

  /**
   * handles unassign Tpost validation for a WindContQIEC
   *
   * @param command UnAssignTpostFromWindContQIECCommand
   */
  public void validate(UnAssignTpostFromWindContQIECCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTpostFromWindContQIECCommand should not be null");
    Assert.notNull(
        command.getWindContQIECId(),
        "UnAssignTpostFromWindContQIECCommand identifier should not be null");
  }
  /**
   * handles assign Tqord validation for a WindContQIEC
   *
   * @param command AssignTqordToWindContQIECCommand
   */
  public void validate(AssignTqordToWindContQIECCommand command) throws Exception {
    Assert.notNull(command, "AssignTqordToWindContQIECCommand should not be null");
    Assert.notNull(
        command.getWindContQIECId(),
        "AssignTqordToWindContQIECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTqordToWindContQIECCommand assignment should not be null");
  }

  /**
   * handles unassign Tqord validation for a WindContQIEC
   *
   * @param command UnAssignTqordFromWindContQIECCommand
   */
  public void validate(UnAssignTqordFromWindContQIECCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTqordFromWindContQIECCommand should not be null");
    Assert.notNull(
        command.getWindContQIECId(),
        "UnAssignTqordFromWindContQIECCommand identifier should not be null");
  }
  /**
   * handles assign Tufilt validation for a WindContQIEC
   *
   * @param command AssignTufiltToWindContQIECCommand
   */
  public void validate(AssignTufiltToWindContQIECCommand command) throws Exception {
    Assert.notNull(command, "AssignTufiltToWindContQIECCommand should not be null");
    Assert.notNull(
        command.getWindContQIECId(),
        "AssignTufiltToWindContQIECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTufiltToWindContQIECCommand assignment should not be null");
  }

  /**
   * handles unassign Tufilt validation for a WindContQIEC
   *
   * @param command UnAssignTufiltFromWindContQIECCommand
   */
  public void validate(UnAssignTufiltFromWindContQIECCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTufiltFromWindContQIECCommand should not be null");
    Assert.notNull(
        command.getWindContQIECId(),
        "UnAssignTufiltFromWindContQIECCommand identifier should not be null");
  }
  /**
   * handles assign Udb1 validation for a WindContQIEC
   *
   * @param command AssignUdb1ToWindContQIECCommand
   */
  public void validate(AssignUdb1ToWindContQIECCommand command) throws Exception {
    Assert.notNull(command, "AssignUdb1ToWindContQIECCommand should not be null");
    Assert.notNull(
        command.getWindContQIECId(),
        "AssignUdb1ToWindContQIECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignUdb1ToWindContQIECCommand assignment should not be null");
  }

  /**
   * handles unassign Udb1 validation for a WindContQIEC
   *
   * @param command UnAssignUdb1FromWindContQIECCommand
   */
  public void validate(UnAssignUdb1FromWindContQIECCommand command) throws Exception {
    Assert.notNull(command, "UnAssignUdb1FromWindContQIECCommand should not be null");
    Assert.notNull(
        command.getWindContQIECId(),
        "UnAssignUdb1FromWindContQIECCommand identifier should not be null");
  }
  /**
   * handles assign Udb2 validation for a WindContQIEC
   *
   * @param command AssignUdb2ToWindContQIECCommand
   */
  public void validate(AssignUdb2ToWindContQIECCommand command) throws Exception {
    Assert.notNull(command, "AssignUdb2ToWindContQIECCommand should not be null");
    Assert.notNull(
        command.getWindContQIECId(),
        "AssignUdb2ToWindContQIECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignUdb2ToWindContQIECCommand assignment should not be null");
  }

  /**
   * handles unassign Udb2 validation for a WindContQIEC
   *
   * @param command UnAssignUdb2FromWindContQIECCommand
   */
  public void validate(UnAssignUdb2FromWindContQIECCommand command) throws Exception {
    Assert.notNull(command, "UnAssignUdb2FromWindContQIECCommand should not be null");
    Assert.notNull(
        command.getWindContQIECId(),
        "UnAssignUdb2FromWindContQIECCommand identifier should not be null");
  }
  /**
   * handles assign Umax validation for a WindContQIEC
   *
   * @param command AssignUmaxToWindContQIECCommand
   */
  public void validate(AssignUmaxToWindContQIECCommand command) throws Exception {
    Assert.notNull(command, "AssignUmaxToWindContQIECCommand should not be null");
    Assert.notNull(
        command.getWindContQIECId(),
        "AssignUmaxToWindContQIECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignUmaxToWindContQIECCommand assignment should not be null");
  }

  /**
   * handles unassign Umax validation for a WindContQIEC
   *
   * @param command UnAssignUmaxFromWindContQIECCommand
   */
  public void validate(UnAssignUmaxFromWindContQIECCommand command) throws Exception {
    Assert.notNull(command, "UnAssignUmaxFromWindContQIECCommand should not be null");
    Assert.notNull(
        command.getWindContQIECId(),
        "UnAssignUmaxFromWindContQIECCommand identifier should not be null");
  }
  /**
   * handles assign Umin validation for a WindContQIEC
   *
   * @param command AssignUminToWindContQIECCommand
   */
  public void validate(AssignUminToWindContQIECCommand command) throws Exception {
    Assert.notNull(command, "AssignUminToWindContQIECCommand should not be null");
    Assert.notNull(
        command.getWindContQIECId(),
        "AssignUminToWindContQIECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignUminToWindContQIECCommand assignment should not be null");
  }

  /**
   * handles unassign Umin validation for a WindContQIEC
   *
   * @param command UnAssignUminFromWindContQIECCommand
   */
  public void validate(UnAssignUminFromWindContQIECCommand command) throws Exception {
    Assert.notNull(command, "UnAssignUminFromWindContQIECCommand should not be null");
    Assert.notNull(
        command.getWindContQIECId(),
        "UnAssignUminFromWindContQIECCommand identifier should not be null");
  }
  /**
   * handles assign Uqdip validation for a WindContQIEC
   *
   * @param command AssignUqdipToWindContQIECCommand
   */
  public void validate(AssignUqdipToWindContQIECCommand command) throws Exception {
    Assert.notNull(command, "AssignUqdipToWindContQIECCommand should not be null");
    Assert.notNull(
        command.getWindContQIECId(),
        "AssignUqdipToWindContQIECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignUqdipToWindContQIECCommand assignment should not be null");
  }

  /**
   * handles unassign Uqdip validation for a WindContQIEC
   *
   * @param command UnAssignUqdipFromWindContQIECCommand
   */
  public void validate(UnAssignUqdipFromWindContQIECCommand command) throws Exception {
    Assert.notNull(command, "UnAssignUqdipFromWindContQIECCommand should not be null");
    Assert.notNull(
        command.getWindContQIECId(),
        "UnAssignUqdipFromWindContQIECCommand identifier should not be null");
  }
  /**
   * handles assign Uref0 validation for a WindContQIEC
   *
   * @param command AssignUref0ToWindContQIECCommand
   */
  public void validate(AssignUref0ToWindContQIECCommand command) throws Exception {
    Assert.notNull(command, "AssignUref0ToWindContQIECCommand should not be null");
    Assert.notNull(
        command.getWindContQIECId(),
        "AssignUref0ToWindContQIECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignUref0ToWindContQIECCommand assignment should not be null");
  }

  /**
   * handles unassign Uref0 validation for a WindContQIEC
   *
   * @param command UnAssignUref0FromWindContQIECCommand
   */
  public void validate(UnAssignUref0FromWindContQIECCommand command) throws Exception {
    Assert.notNull(command, "UnAssignUref0FromWindContQIECCommand should not be null");
    Assert.notNull(
        command.getWindContQIECId(),
        "UnAssignUref0FromWindContQIECCommand identifier should not be null");
  }
  /**
   * handles assign Xdroop validation for a WindContQIEC
   *
   * @param command AssignXdroopToWindContQIECCommand
   */
  public void validate(AssignXdroopToWindContQIECCommand command) throws Exception {
    Assert.notNull(command, "AssignXdroopToWindContQIECCommand should not be null");
    Assert.notNull(
        command.getWindContQIECId(),
        "AssignXdroopToWindContQIECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignXdroopToWindContQIECCommand assignment should not be null");
  }

  /**
   * handles unassign Xdroop validation for a WindContQIEC
   *
   * @param command UnAssignXdroopFromWindContQIECCommand
   */
  public void validate(UnAssignXdroopFromWindContQIECCommand command) throws Exception {
    Assert.notNull(command, "UnAssignXdroopFromWindContQIECCommand should not be null");
    Assert.notNull(
        command.getWindContQIECId(),
        "UnAssignXdroopFromWindContQIECCommand identifier should not be null");
  }
}
