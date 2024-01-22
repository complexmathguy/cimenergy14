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

public class WindPlantReactiveControlIECValidator {

  /** default constructor */
  protected WindPlantReactiveControlIECValidator() {}

  /** factory method */
  public static WindPlantReactiveControlIECValidator getInstance() {
    return new WindPlantReactiveControlIECValidator();
  }

  /** handles creation validation for a WindPlantReactiveControlIEC */
  public void validate(CreateWindPlantReactiveControlIECCommand windPlantReactiveControlIEC)
      throws Exception {
    Assert.notNull(
        windPlantReactiveControlIEC, "CreateWindPlantReactiveControlIECCommand should not be null");
    //		Assert.isNull( windPlantReactiveControlIEC.getWindPlantReactiveControlIECId(),
    // "CreateWindPlantReactiveControlIECCommand identifier should be null" );
  }

  /** handles update validation for a WindPlantReactiveControlIEC */
  public void validate(UpdateWindPlantReactiveControlIECCommand windPlantReactiveControlIEC)
      throws Exception {
    Assert.notNull(
        windPlantReactiveControlIEC, "UpdateWindPlantReactiveControlIECCommand should not be null");
    Assert.notNull(
        windPlantReactiveControlIEC.getWindPlantReactiveControlIECId(),
        "UpdateWindPlantReactiveControlIECCommand identifier should not be null");
  }

  /** handles delete validation for a WindPlantReactiveControlIEC */
  public void validate(DeleteWindPlantReactiveControlIECCommand windPlantReactiveControlIEC)
      throws Exception {
    Assert.notNull(windPlantReactiveControlIEC, "{commandAlias} should not be null");
    Assert.notNull(
        windPlantReactiveControlIEC.getWindPlantReactiveControlIECId(),
        "DeleteWindPlantReactiveControlIECCommand identifier should not be null");
  }

  /** handles fetchOne validation for a WindPlantReactiveControlIEC */
  public void validate(WindPlantReactiveControlIECFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "WindPlantReactiveControlIECFetchOneSummary should not be null");
    Assert.notNull(
        summary.getWindPlantReactiveControlIECId(),
        "WindPlantReactiveControlIECFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Kiwpx validation for a WindPlantReactiveControlIEC
   *
   * @param command AssignKiwpxToWindPlantReactiveControlIECCommand
   */
  public void validate(AssignKiwpxToWindPlantReactiveControlIECCommand command) throws Exception {
    Assert.notNull(command, "AssignKiwpxToWindPlantReactiveControlIECCommand should not be null");
    Assert.notNull(
        command.getWindPlantReactiveControlIECId(),
        "AssignKiwpxToWindPlantReactiveControlIECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignKiwpxToWindPlantReactiveControlIECCommand assignment should not be null");
  }

  /**
   * handles unassign Kiwpx validation for a WindPlantReactiveControlIEC
   *
   * @param command UnAssignKiwpxFromWindPlantReactiveControlIECCommand
   */
  public void validate(UnAssignKiwpxFromWindPlantReactiveControlIECCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignKiwpxFromWindPlantReactiveControlIECCommand should not be null");
    Assert.notNull(
        command.getWindPlantReactiveControlIECId(),
        "UnAssignKiwpxFromWindPlantReactiveControlIECCommand identifier should not be null");
  }
  /**
   * handles assign Kpwpx validation for a WindPlantReactiveControlIEC
   *
   * @param command AssignKpwpxToWindPlantReactiveControlIECCommand
   */
  public void validate(AssignKpwpxToWindPlantReactiveControlIECCommand command) throws Exception {
    Assert.notNull(command, "AssignKpwpxToWindPlantReactiveControlIECCommand should not be null");
    Assert.notNull(
        command.getWindPlantReactiveControlIECId(),
        "AssignKpwpxToWindPlantReactiveControlIECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignKpwpxToWindPlantReactiveControlIECCommand assignment should not be null");
  }

  /**
   * handles unassign Kpwpx validation for a WindPlantReactiveControlIEC
   *
   * @param command UnAssignKpwpxFromWindPlantReactiveControlIECCommand
   */
  public void validate(UnAssignKpwpxFromWindPlantReactiveControlIECCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignKpwpxFromWindPlantReactiveControlIECCommand should not be null");
    Assert.notNull(
        command.getWindPlantReactiveControlIECId(),
        "UnAssignKpwpxFromWindPlantReactiveControlIECCommand identifier should not be null");
  }
  /**
   * handles assign Kwpqu validation for a WindPlantReactiveControlIEC
   *
   * @param command AssignKwpquToWindPlantReactiveControlIECCommand
   */
  public void validate(AssignKwpquToWindPlantReactiveControlIECCommand command) throws Exception {
    Assert.notNull(command, "AssignKwpquToWindPlantReactiveControlIECCommand should not be null");
    Assert.notNull(
        command.getWindPlantReactiveControlIECId(),
        "AssignKwpquToWindPlantReactiveControlIECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignKwpquToWindPlantReactiveControlIECCommand assignment should not be null");
  }

  /**
   * handles unassign Kwpqu validation for a WindPlantReactiveControlIEC
   *
   * @param command UnAssignKwpquFromWindPlantReactiveControlIECCommand
   */
  public void validate(UnAssignKwpquFromWindPlantReactiveControlIECCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignKwpquFromWindPlantReactiveControlIECCommand should not be null");
    Assert.notNull(
        command.getWindPlantReactiveControlIECId(),
        "UnAssignKwpquFromWindPlantReactiveControlIECCommand identifier should not be null");
  }
  /**
   * handles assign Mwppf validation for a WindPlantReactiveControlIEC
   *
   * @param command AssignMwppfToWindPlantReactiveControlIECCommand
   */
  public void validate(AssignMwppfToWindPlantReactiveControlIECCommand command) throws Exception {
    Assert.notNull(command, "AssignMwppfToWindPlantReactiveControlIECCommand should not be null");
    Assert.notNull(
        command.getWindPlantReactiveControlIECId(),
        "AssignMwppfToWindPlantReactiveControlIECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignMwppfToWindPlantReactiveControlIECCommand assignment should not be null");
  }

  /**
   * handles unassign Mwppf validation for a WindPlantReactiveControlIEC
   *
   * @param command UnAssignMwppfFromWindPlantReactiveControlIECCommand
   */
  public void validate(UnAssignMwppfFromWindPlantReactiveControlIECCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignMwppfFromWindPlantReactiveControlIECCommand should not be null");
    Assert.notNull(
        command.getWindPlantReactiveControlIECId(),
        "UnAssignMwppfFromWindPlantReactiveControlIECCommand identifier should not be null");
  }
  /**
   * handles assign Mwpu validation for a WindPlantReactiveControlIEC
   *
   * @param command AssignMwpuToWindPlantReactiveControlIECCommand
   */
  public void validate(AssignMwpuToWindPlantReactiveControlIECCommand command) throws Exception {
    Assert.notNull(command, "AssignMwpuToWindPlantReactiveControlIECCommand should not be null");
    Assert.notNull(
        command.getWindPlantReactiveControlIECId(),
        "AssignMwpuToWindPlantReactiveControlIECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignMwpuToWindPlantReactiveControlIECCommand assignment should not be null");
  }

  /**
   * handles unassign Mwpu validation for a WindPlantReactiveControlIEC
   *
   * @param command UnAssignMwpuFromWindPlantReactiveControlIECCommand
   */
  public void validate(UnAssignMwpuFromWindPlantReactiveControlIECCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignMwpuFromWindPlantReactiveControlIECCommand should not be null");
    Assert.notNull(
        command.getWindPlantReactiveControlIECId(),
        "UnAssignMwpuFromWindPlantReactiveControlIECCommand identifier should not be null");
  }
  /**
   * handles assign Twppfilt validation for a WindPlantReactiveControlIEC
   *
   * @param command AssignTwppfiltToWindPlantReactiveControlIECCommand
   */
  public void validate(AssignTwppfiltToWindPlantReactiveControlIECCommand command)
      throws Exception {
    Assert.notNull(
        command, "AssignTwppfiltToWindPlantReactiveControlIECCommand should not be null");
    Assert.notNull(
        command.getWindPlantReactiveControlIECId(),
        "AssignTwppfiltToWindPlantReactiveControlIECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignTwppfiltToWindPlantReactiveControlIECCommand assignment should not be null");
  }

  /**
   * handles unassign Twppfilt validation for a WindPlantReactiveControlIEC
   *
   * @param command UnAssignTwppfiltFromWindPlantReactiveControlIECCommand
   */
  public void validate(UnAssignTwppfiltFromWindPlantReactiveControlIECCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignTwppfiltFromWindPlantReactiveControlIECCommand should not be null");
    Assert.notNull(
        command.getWindPlantReactiveControlIECId(),
        "UnAssignTwppfiltFromWindPlantReactiveControlIECCommand identifier should not be null");
  }
  /**
   * handles assign Twpqfilt validation for a WindPlantReactiveControlIEC
   *
   * @param command AssignTwpqfiltToWindPlantReactiveControlIECCommand
   */
  public void validate(AssignTwpqfiltToWindPlantReactiveControlIECCommand command)
      throws Exception {
    Assert.notNull(
        command, "AssignTwpqfiltToWindPlantReactiveControlIECCommand should not be null");
    Assert.notNull(
        command.getWindPlantReactiveControlIECId(),
        "AssignTwpqfiltToWindPlantReactiveControlIECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignTwpqfiltToWindPlantReactiveControlIECCommand assignment should not be null");
  }

  /**
   * handles unassign Twpqfilt validation for a WindPlantReactiveControlIEC
   *
   * @param command UnAssignTwpqfiltFromWindPlantReactiveControlIECCommand
   */
  public void validate(UnAssignTwpqfiltFromWindPlantReactiveControlIECCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignTwpqfiltFromWindPlantReactiveControlIECCommand should not be null");
    Assert.notNull(
        command.getWindPlantReactiveControlIECId(),
        "UnAssignTwpqfiltFromWindPlantReactiveControlIECCommand identifier should not be null");
  }
  /**
   * handles assign Twpufilt validation for a WindPlantReactiveControlIEC
   *
   * @param command AssignTwpufiltToWindPlantReactiveControlIECCommand
   */
  public void validate(AssignTwpufiltToWindPlantReactiveControlIECCommand command)
      throws Exception {
    Assert.notNull(
        command, "AssignTwpufiltToWindPlantReactiveControlIECCommand should not be null");
    Assert.notNull(
        command.getWindPlantReactiveControlIECId(),
        "AssignTwpufiltToWindPlantReactiveControlIECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignTwpufiltToWindPlantReactiveControlIECCommand assignment should not be null");
  }

  /**
   * handles unassign Twpufilt validation for a WindPlantReactiveControlIEC
   *
   * @param command UnAssignTwpufiltFromWindPlantReactiveControlIECCommand
   */
  public void validate(UnAssignTwpufiltFromWindPlantReactiveControlIECCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignTwpufiltFromWindPlantReactiveControlIECCommand should not be null");
    Assert.notNull(
        command.getWindPlantReactiveControlIECId(),
        "UnAssignTwpufiltFromWindPlantReactiveControlIECCommand identifier should not be null");
  }
  /**
   * handles assign Txft validation for a WindPlantReactiveControlIEC
   *
   * @param command AssignTxftToWindPlantReactiveControlIECCommand
   */
  public void validate(AssignTxftToWindPlantReactiveControlIECCommand command) throws Exception {
    Assert.notNull(command, "AssignTxftToWindPlantReactiveControlIECCommand should not be null");
    Assert.notNull(
        command.getWindPlantReactiveControlIECId(),
        "AssignTxftToWindPlantReactiveControlIECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignTxftToWindPlantReactiveControlIECCommand assignment should not be null");
  }

  /**
   * handles unassign Txft validation for a WindPlantReactiveControlIEC
   *
   * @param command UnAssignTxftFromWindPlantReactiveControlIECCommand
   */
  public void validate(UnAssignTxftFromWindPlantReactiveControlIECCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignTxftFromWindPlantReactiveControlIECCommand should not be null");
    Assert.notNull(
        command.getWindPlantReactiveControlIECId(),
        "UnAssignTxftFromWindPlantReactiveControlIECCommand identifier should not be null");
  }
  /**
   * handles assign Txfv validation for a WindPlantReactiveControlIEC
   *
   * @param command AssignTxfvToWindPlantReactiveControlIECCommand
   */
  public void validate(AssignTxfvToWindPlantReactiveControlIECCommand command) throws Exception {
    Assert.notNull(command, "AssignTxfvToWindPlantReactiveControlIECCommand should not be null");
    Assert.notNull(
        command.getWindPlantReactiveControlIECId(),
        "AssignTxfvToWindPlantReactiveControlIECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignTxfvToWindPlantReactiveControlIECCommand assignment should not be null");
  }

  /**
   * handles unassign Txfv validation for a WindPlantReactiveControlIEC
   *
   * @param command UnAssignTxfvFromWindPlantReactiveControlIECCommand
   */
  public void validate(UnAssignTxfvFromWindPlantReactiveControlIECCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignTxfvFromWindPlantReactiveControlIECCommand should not be null");
    Assert.notNull(
        command.getWindPlantReactiveControlIECId(),
        "UnAssignTxfvFromWindPlantReactiveControlIECCommand identifier should not be null");
  }
  /**
   * handles assign Uwpqdip validation for a WindPlantReactiveControlIEC
   *
   * @param command AssignUwpqdipToWindPlantReactiveControlIECCommand
   */
  public void validate(AssignUwpqdipToWindPlantReactiveControlIECCommand command) throws Exception {
    Assert.notNull(command, "AssignUwpqdipToWindPlantReactiveControlIECCommand should not be null");
    Assert.notNull(
        command.getWindPlantReactiveControlIECId(),
        "AssignUwpqdipToWindPlantReactiveControlIECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignUwpqdipToWindPlantReactiveControlIECCommand assignment should not be null");
  }

  /**
   * handles unassign Uwpqdip validation for a WindPlantReactiveControlIEC
   *
   * @param command UnAssignUwpqdipFromWindPlantReactiveControlIECCommand
   */
  public void validate(UnAssignUwpqdipFromWindPlantReactiveControlIECCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignUwpqdipFromWindPlantReactiveControlIECCommand should not be null");
    Assert.notNull(
        command.getWindPlantReactiveControlIECId(),
        "UnAssignUwpqdipFromWindPlantReactiveControlIECCommand identifier should not be null");
  }
  /**
   * handles assign Xrefmax validation for a WindPlantReactiveControlIEC
   *
   * @param command AssignXrefmaxToWindPlantReactiveControlIECCommand
   */
  public void validate(AssignXrefmaxToWindPlantReactiveControlIECCommand command) throws Exception {
    Assert.notNull(command, "AssignXrefmaxToWindPlantReactiveControlIECCommand should not be null");
    Assert.notNull(
        command.getWindPlantReactiveControlIECId(),
        "AssignXrefmaxToWindPlantReactiveControlIECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignXrefmaxToWindPlantReactiveControlIECCommand assignment should not be null");
  }

  /**
   * handles unassign Xrefmax validation for a WindPlantReactiveControlIEC
   *
   * @param command UnAssignXrefmaxFromWindPlantReactiveControlIECCommand
   */
  public void validate(UnAssignXrefmaxFromWindPlantReactiveControlIECCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignXrefmaxFromWindPlantReactiveControlIECCommand should not be null");
    Assert.notNull(
        command.getWindPlantReactiveControlIECId(),
        "UnAssignXrefmaxFromWindPlantReactiveControlIECCommand identifier should not be null");
  }
  /**
   * handles assign Xrefmin validation for a WindPlantReactiveControlIEC
   *
   * @param command AssignXrefminToWindPlantReactiveControlIECCommand
   */
  public void validate(AssignXrefminToWindPlantReactiveControlIECCommand command) throws Exception {
    Assert.notNull(command, "AssignXrefminToWindPlantReactiveControlIECCommand should not be null");
    Assert.notNull(
        command.getWindPlantReactiveControlIECId(),
        "AssignXrefminToWindPlantReactiveControlIECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignXrefminToWindPlantReactiveControlIECCommand assignment should not be null");
  }

  /**
   * handles unassign Xrefmin validation for a WindPlantReactiveControlIEC
   *
   * @param command UnAssignXrefminFromWindPlantReactiveControlIECCommand
   */
  public void validate(UnAssignXrefminFromWindPlantReactiveControlIECCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignXrefminFromWindPlantReactiveControlIECCommand should not be null");
    Assert.notNull(
        command.getWindPlantReactiveControlIECId(),
        "UnAssignXrefminFromWindPlantReactiveControlIECCommand identifier should not be null");
  }
}
