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

public class ExcELIN1Validator {

  /** default constructor */
  protected ExcELIN1Validator() {}

  /** factory method */
  public static ExcELIN1Validator getInstance() {
    return new ExcELIN1Validator();
  }

  /** handles creation validation for a ExcELIN1 */
  public void validate(CreateExcELIN1Command excELIN1) throws Exception {
    Assert.notNull(excELIN1, "CreateExcELIN1Command should not be null");
    //		Assert.isNull( excELIN1.getExcELIN1Id(), "CreateExcELIN1Command identifier should be null"
    // );
  }

  /** handles update validation for a ExcELIN1 */
  public void validate(UpdateExcELIN1Command excELIN1) throws Exception {
    Assert.notNull(excELIN1, "UpdateExcELIN1Command should not be null");
    Assert.notNull(excELIN1.getExcELIN1Id(), "UpdateExcELIN1Command identifier should not be null");
  }

  /** handles delete validation for a ExcELIN1 */
  public void validate(DeleteExcELIN1Command excELIN1) throws Exception {
    Assert.notNull(excELIN1, "{commandAlias} should not be null");
    Assert.notNull(excELIN1.getExcELIN1Id(), "DeleteExcELIN1Command identifier should not be null");
  }

  /** handles fetchOne validation for a ExcELIN1 */
  public void validate(ExcELIN1FetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "ExcELIN1FetchOneSummary should not be null");
    Assert.notNull(
        summary.getExcELIN1Id(), "ExcELIN1FetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Dpnf validation for a ExcELIN1
   *
   * @param command AssignDpnfToExcELIN1Command
   */
  public void validate(AssignDpnfToExcELIN1Command command) throws Exception {
    Assert.notNull(command, "AssignDpnfToExcELIN1Command should not be null");
    Assert.notNull(
        command.getExcELIN1Id(), "AssignDpnfToExcELIN1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignDpnfToExcELIN1Command assignment should not be null");
  }

  /**
   * handles unassign Dpnf validation for a ExcELIN1
   *
   * @param command UnAssignDpnfFromExcELIN1Command
   */
  public void validate(UnAssignDpnfFromExcELIN1Command command) throws Exception {
    Assert.notNull(command, "UnAssignDpnfFromExcELIN1Command should not be null");
    Assert.notNull(
        command.getExcELIN1Id(), "UnAssignDpnfFromExcELIN1Command identifier should not be null");
  }
  /**
   * handles assign Efmax validation for a ExcELIN1
   *
   * @param command AssignEfmaxToExcELIN1Command
   */
  public void validate(AssignEfmaxToExcELIN1Command command) throws Exception {
    Assert.notNull(command, "AssignEfmaxToExcELIN1Command should not be null");
    Assert.notNull(
        command.getExcELIN1Id(), "AssignEfmaxToExcELIN1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignEfmaxToExcELIN1Command assignment should not be null");
  }

  /**
   * handles unassign Efmax validation for a ExcELIN1
   *
   * @param command UnAssignEfmaxFromExcELIN1Command
   */
  public void validate(UnAssignEfmaxFromExcELIN1Command command) throws Exception {
    Assert.notNull(command, "UnAssignEfmaxFromExcELIN1Command should not be null");
    Assert.notNull(
        command.getExcELIN1Id(), "UnAssignEfmaxFromExcELIN1Command identifier should not be null");
  }
  /**
   * handles assign Efmin validation for a ExcELIN1
   *
   * @param command AssignEfminToExcELIN1Command
   */
  public void validate(AssignEfminToExcELIN1Command command) throws Exception {
    Assert.notNull(command, "AssignEfminToExcELIN1Command should not be null");
    Assert.notNull(
        command.getExcELIN1Id(), "AssignEfminToExcELIN1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignEfminToExcELIN1Command assignment should not be null");
  }

  /**
   * handles unassign Efmin validation for a ExcELIN1
   *
   * @param command UnAssignEfminFromExcELIN1Command
   */
  public void validate(UnAssignEfminFromExcELIN1Command command) throws Exception {
    Assert.notNull(command, "UnAssignEfminFromExcELIN1Command should not be null");
    Assert.notNull(
        command.getExcELIN1Id(), "UnAssignEfminFromExcELIN1Command identifier should not be null");
  }
  /**
   * handles assign Ks1 validation for a ExcELIN1
   *
   * @param command AssignKs1ToExcELIN1Command
   */
  public void validate(AssignKs1ToExcELIN1Command command) throws Exception {
    Assert.notNull(command, "AssignKs1ToExcELIN1Command should not be null");
    Assert.notNull(
        command.getExcELIN1Id(), "AssignKs1ToExcELIN1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKs1ToExcELIN1Command assignment should not be null");
  }

  /**
   * handles unassign Ks1 validation for a ExcELIN1
   *
   * @param command UnAssignKs1FromExcELIN1Command
   */
  public void validate(UnAssignKs1FromExcELIN1Command command) throws Exception {
    Assert.notNull(command, "UnAssignKs1FromExcELIN1Command should not be null");
    Assert.notNull(
        command.getExcELIN1Id(), "UnAssignKs1FromExcELIN1Command identifier should not be null");
  }
  /**
   * handles assign Ks2 validation for a ExcELIN1
   *
   * @param command AssignKs2ToExcELIN1Command
   */
  public void validate(AssignKs2ToExcELIN1Command command) throws Exception {
    Assert.notNull(command, "AssignKs2ToExcELIN1Command should not be null");
    Assert.notNull(
        command.getExcELIN1Id(), "AssignKs2ToExcELIN1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKs2ToExcELIN1Command assignment should not be null");
  }

  /**
   * handles unassign Ks2 validation for a ExcELIN1
   *
   * @param command UnAssignKs2FromExcELIN1Command
   */
  public void validate(UnAssignKs2FromExcELIN1Command command) throws Exception {
    Assert.notNull(command, "UnAssignKs2FromExcELIN1Command should not be null");
    Assert.notNull(
        command.getExcELIN1Id(), "UnAssignKs2FromExcELIN1Command identifier should not be null");
  }
  /**
   * handles assign Smax validation for a ExcELIN1
   *
   * @param command AssignSmaxToExcELIN1Command
   */
  public void validate(AssignSmaxToExcELIN1Command command) throws Exception {
    Assert.notNull(command, "AssignSmaxToExcELIN1Command should not be null");
    Assert.notNull(
        command.getExcELIN1Id(), "AssignSmaxToExcELIN1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignSmaxToExcELIN1Command assignment should not be null");
  }

  /**
   * handles unassign Smax validation for a ExcELIN1
   *
   * @param command UnAssignSmaxFromExcELIN1Command
   */
  public void validate(UnAssignSmaxFromExcELIN1Command command) throws Exception {
    Assert.notNull(command, "UnAssignSmaxFromExcELIN1Command should not be null");
    Assert.notNull(
        command.getExcELIN1Id(), "UnAssignSmaxFromExcELIN1Command identifier should not be null");
  }
  /**
   * handles assign Tfi validation for a ExcELIN1
   *
   * @param command AssignTfiToExcELIN1Command
   */
  public void validate(AssignTfiToExcELIN1Command command) throws Exception {
    Assert.notNull(command, "AssignTfiToExcELIN1Command should not be null");
    Assert.notNull(
        command.getExcELIN1Id(), "AssignTfiToExcELIN1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTfiToExcELIN1Command assignment should not be null");
  }

  /**
   * handles unassign Tfi validation for a ExcELIN1
   *
   * @param command UnAssignTfiFromExcELIN1Command
   */
  public void validate(UnAssignTfiFromExcELIN1Command command) throws Exception {
    Assert.notNull(command, "UnAssignTfiFromExcELIN1Command should not be null");
    Assert.notNull(
        command.getExcELIN1Id(), "UnAssignTfiFromExcELIN1Command identifier should not be null");
  }
  /**
   * handles assign Tnu validation for a ExcELIN1
   *
   * @param command AssignTnuToExcELIN1Command
   */
  public void validate(AssignTnuToExcELIN1Command command) throws Exception {
    Assert.notNull(command, "AssignTnuToExcELIN1Command should not be null");
    Assert.notNull(
        command.getExcELIN1Id(), "AssignTnuToExcELIN1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTnuToExcELIN1Command assignment should not be null");
  }

  /**
   * handles unassign Tnu validation for a ExcELIN1
   *
   * @param command UnAssignTnuFromExcELIN1Command
   */
  public void validate(UnAssignTnuFromExcELIN1Command command) throws Exception {
    Assert.notNull(command, "UnAssignTnuFromExcELIN1Command should not be null");
    Assert.notNull(
        command.getExcELIN1Id(), "UnAssignTnuFromExcELIN1Command identifier should not be null");
  }
  /**
   * handles assign Ts1 validation for a ExcELIN1
   *
   * @param command AssignTs1ToExcELIN1Command
   */
  public void validate(AssignTs1ToExcELIN1Command command) throws Exception {
    Assert.notNull(command, "AssignTs1ToExcELIN1Command should not be null");
    Assert.notNull(
        command.getExcELIN1Id(), "AssignTs1ToExcELIN1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTs1ToExcELIN1Command assignment should not be null");
  }

  /**
   * handles unassign Ts1 validation for a ExcELIN1
   *
   * @param command UnAssignTs1FromExcELIN1Command
   */
  public void validate(UnAssignTs1FromExcELIN1Command command) throws Exception {
    Assert.notNull(command, "UnAssignTs1FromExcELIN1Command should not be null");
    Assert.notNull(
        command.getExcELIN1Id(), "UnAssignTs1FromExcELIN1Command identifier should not be null");
  }
  /**
   * handles assign Ts2 validation for a ExcELIN1
   *
   * @param command AssignTs2ToExcELIN1Command
   */
  public void validate(AssignTs2ToExcELIN1Command command) throws Exception {
    Assert.notNull(command, "AssignTs2ToExcELIN1Command should not be null");
    Assert.notNull(
        command.getExcELIN1Id(), "AssignTs2ToExcELIN1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTs2ToExcELIN1Command assignment should not be null");
  }

  /**
   * handles unassign Ts2 validation for a ExcELIN1
   *
   * @param command UnAssignTs2FromExcELIN1Command
   */
  public void validate(UnAssignTs2FromExcELIN1Command command) throws Exception {
    Assert.notNull(command, "UnAssignTs2FromExcELIN1Command should not be null");
    Assert.notNull(
        command.getExcELIN1Id(), "UnAssignTs2FromExcELIN1Command identifier should not be null");
  }
  /**
   * handles assign Tsw validation for a ExcELIN1
   *
   * @param command AssignTswToExcELIN1Command
   */
  public void validate(AssignTswToExcELIN1Command command) throws Exception {
    Assert.notNull(command, "AssignTswToExcELIN1Command should not be null");
    Assert.notNull(
        command.getExcELIN1Id(), "AssignTswToExcELIN1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTswToExcELIN1Command assignment should not be null");
  }

  /**
   * handles unassign Tsw validation for a ExcELIN1
   *
   * @param command UnAssignTswFromExcELIN1Command
   */
  public void validate(UnAssignTswFromExcELIN1Command command) throws Exception {
    Assert.notNull(command, "UnAssignTswFromExcELIN1Command should not be null");
    Assert.notNull(
        command.getExcELIN1Id(), "UnAssignTswFromExcELIN1Command identifier should not be null");
  }
  /**
   * handles assign Vpi validation for a ExcELIN1
   *
   * @param command AssignVpiToExcELIN1Command
   */
  public void validate(AssignVpiToExcELIN1Command command) throws Exception {
    Assert.notNull(command, "AssignVpiToExcELIN1Command should not be null");
    Assert.notNull(
        command.getExcELIN1Id(), "AssignVpiToExcELIN1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVpiToExcELIN1Command assignment should not be null");
  }

  /**
   * handles unassign Vpi validation for a ExcELIN1
   *
   * @param command UnAssignVpiFromExcELIN1Command
   */
  public void validate(UnAssignVpiFromExcELIN1Command command) throws Exception {
    Assert.notNull(command, "UnAssignVpiFromExcELIN1Command should not be null");
    Assert.notNull(
        command.getExcELIN1Id(), "UnAssignVpiFromExcELIN1Command identifier should not be null");
  }
  /**
   * handles assign Vpnf validation for a ExcELIN1
   *
   * @param command AssignVpnfToExcELIN1Command
   */
  public void validate(AssignVpnfToExcELIN1Command command) throws Exception {
    Assert.notNull(command, "AssignVpnfToExcELIN1Command should not be null");
    Assert.notNull(
        command.getExcELIN1Id(), "AssignVpnfToExcELIN1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVpnfToExcELIN1Command assignment should not be null");
  }

  /**
   * handles unassign Vpnf validation for a ExcELIN1
   *
   * @param command UnAssignVpnfFromExcELIN1Command
   */
  public void validate(UnAssignVpnfFromExcELIN1Command command) throws Exception {
    Assert.notNull(command, "UnAssignVpnfFromExcELIN1Command should not be null");
    Assert.notNull(
        command.getExcELIN1Id(), "UnAssignVpnfFromExcELIN1Command identifier should not be null");
  }
  /**
   * handles assign Vpu validation for a ExcELIN1
   *
   * @param command AssignVpuToExcELIN1Command
   */
  public void validate(AssignVpuToExcELIN1Command command) throws Exception {
    Assert.notNull(command, "AssignVpuToExcELIN1Command should not be null");
    Assert.notNull(
        command.getExcELIN1Id(), "AssignVpuToExcELIN1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVpuToExcELIN1Command assignment should not be null");
  }

  /**
   * handles unassign Vpu validation for a ExcELIN1
   *
   * @param command UnAssignVpuFromExcELIN1Command
   */
  public void validate(UnAssignVpuFromExcELIN1Command command) throws Exception {
    Assert.notNull(command, "UnAssignVpuFromExcELIN1Command should not be null");
    Assert.notNull(
        command.getExcELIN1Id(), "UnAssignVpuFromExcELIN1Command identifier should not be null");
  }
  /**
   * handles assign Xe validation for a ExcELIN1
   *
   * @param command AssignXeToExcELIN1Command
   */
  public void validate(AssignXeToExcELIN1Command command) throws Exception {
    Assert.notNull(command, "AssignXeToExcELIN1Command should not be null");
    Assert.notNull(
        command.getExcELIN1Id(), "AssignXeToExcELIN1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignXeToExcELIN1Command assignment should not be null");
  }

  /**
   * handles unassign Xe validation for a ExcELIN1
   *
   * @param command UnAssignXeFromExcELIN1Command
   */
  public void validate(UnAssignXeFromExcELIN1Command command) throws Exception {
    Assert.notNull(command, "UnAssignXeFromExcELIN1Command should not be null");
    Assert.notNull(
        command.getExcELIN1Id(), "UnAssignXeFromExcELIN1Command identifier should not be null");
  }
}
