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

public class WindPlantFreqPcontrolIECValidator {

  /** default constructor */
  protected WindPlantFreqPcontrolIECValidator() {}

  /** factory method */
  public static WindPlantFreqPcontrolIECValidator getInstance() {
    return new WindPlantFreqPcontrolIECValidator();
  }

  /** handles creation validation for a WindPlantFreqPcontrolIEC */
  public void validate(CreateWindPlantFreqPcontrolIECCommand windPlantFreqPcontrolIEC)
      throws Exception {
    Assert.notNull(
        windPlantFreqPcontrolIEC, "CreateWindPlantFreqPcontrolIECCommand should not be null");
    //		Assert.isNull( windPlantFreqPcontrolIEC.getWindPlantFreqPcontrolIECId(),
    // "CreateWindPlantFreqPcontrolIECCommand identifier should be null" );
  }

  /** handles update validation for a WindPlantFreqPcontrolIEC */
  public void validate(UpdateWindPlantFreqPcontrolIECCommand windPlantFreqPcontrolIEC)
      throws Exception {
    Assert.notNull(
        windPlantFreqPcontrolIEC, "UpdateWindPlantFreqPcontrolIECCommand should not be null");
    Assert.notNull(
        windPlantFreqPcontrolIEC.getWindPlantFreqPcontrolIECId(),
        "UpdateWindPlantFreqPcontrolIECCommand identifier should not be null");
  }

  /** handles delete validation for a WindPlantFreqPcontrolIEC */
  public void validate(DeleteWindPlantFreqPcontrolIECCommand windPlantFreqPcontrolIEC)
      throws Exception {
    Assert.notNull(windPlantFreqPcontrolIEC, "{commandAlias} should not be null");
    Assert.notNull(
        windPlantFreqPcontrolIEC.getWindPlantFreqPcontrolIECId(),
        "DeleteWindPlantFreqPcontrolIECCommand identifier should not be null");
  }

  /** handles fetchOne validation for a WindPlantFreqPcontrolIEC */
  public void validate(WindPlantFreqPcontrolIECFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "WindPlantFreqPcontrolIECFetchOneSummary should not be null");
    Assert.notNull(
        summary.getWindPlantFreqPcontrolIECId(),
        "WindPlantFreqPcontrolIECFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Dprefmax validation for a WindPlantFreqPcontrolIEC
   *
   * @param command AssignDprefmaxToWindPlantFreqPcontrolIECCommand
   */
  public void validate(AssignDprefmaxToWindPlantFreqPcontrolIECCommand command) throws Exception {
    Assert.notNull(command, "AssignDprefmaxToWindPlantFreqPcontrolIECCommand should not be null");
    Assert.notNull(
        command.getWindPlantFreqPcontrolIECId(),
        "AssignDprefmaxToWindPlantFreqPcontrolIECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignDprefmaxToWindPlantFreqPcontrolIECCommand assignment should not be null");
  }

  /**
   * handles unassign Dprefmax validation for a WindPlantFreqPcontrolIEC
   *
   * @param command UnAssignDprefmaxFromWindPlantFreqPcontrolIECCommand
   */
  public void validate(UnAssignDprefmaxFromWindPlantFreqPcontrolIECCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignDprefmaxFromWindPlantFreqPcontrolIECCommand should not be null");
    Assert.notNull(
        command.getWindPlantFreqPcontrolIECId(),
        "UnAssignDprefmaxFromWindPlantFreqPcontrolIECCommand identifier should not be null");
  }
  /**
   * handles assign Dprefmin validation for a WindPlantFreqPcontrolIEC
   *
   * @param command AssignDprefminToWindPlantFreqPcontrolIECCommand
   */
  public void validate(AssignDprefminToWindPlantFreqPcontrolIECCommand command) throws Exception {
    Assert.notNull(command, "AssignDprefminToWindPlantFreqPcontrolIECCommand should not be null");
    Assert.notNull(
        command.getWindPlantFreqPcontrolIECId(),
        "AssignDprefminToWindPlantFreqPcontrolIECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignDprefminToWindPlantFreqPcontrolIECCommand assignment should not be null");
  }

  /**
   * handles unassign Dprefmin validation for a WindPlantFreqPcontrolIEC
   *
   * @param command UnAssignDprefminFromWindPlantFreqPcontrolIECCommand
   */
  public void validate(UnAssignDprefminFromWindPlantFreqPcontrolIECCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignDprefminFromWindPlantFreqPcontrolIECCommand should not be null");
    Assert.notNull(
        command.getWindPlantFreqPcontrolIECId(),
        "UnAssignDprefminFromWindPlantFreqPcontrolIECCommand identifier should not be null");
  }
  /**
   * handles assign Kiwpp validation for a WindPlantFreqPcontrolIEC
   *
   * @param command AssignKiwppToWindPlantFreqPcontrolIECCommand
   */
  public void validate(AssignKiwppToWindPlantFreqPcontrolIECCommand command) throws Exception {
    Assert.notNull(command, "AssignKiwppToWindPlantFreqPcontrolIECCommand should not be null");
    Assert.notNull(
        command.getWindPlantFreqPcontrolIECId(),
        "AssignKiwppToWindPlantFreqPcontrolIECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignKiwppToWindPlantFreqPcontrolIECCommand assignment should not be null");
  }

  /**
   * handles unassign Kiwpp validation for a WindPlantFreqPcontrolIEC
   *
   * @param command UnAssignKiwppFromWindPlantFreqPcontrolIECCommand
   */
  public void validate(UnAssignKiwppFromWindPlantFreqPcontrolIECCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKiwppFromWindPlantFreqPcontrolIECCommand should not be null");
    Assert.notNull(
        command.getWindPlantFreqPcontrolIECId(),
        "UnAssignKiwppFromWindPlantFreqPcontrolIECCommand identifier should not be null");
  }
  /**
   * handles assign Kpwpp validation for a WindPlantFreqPcontrolIEC
   *
   * @param command AssignKpwppToWindPlantFreqPcontrolIECCommand
   */
  public void validate(AssignKpwppToWindPlantFreqPcontrolIECCommand command) throws Exception {
    Assert.notNull(command, "AssignKpwppToWindPlantFreqPcontrolIECCommand should not be null");
    Assert.notNull(
        command.getWindPlantFreqPcontrolIECId(),
        "AssignKpwppToWindPlantFreqPcontrolIECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignKpwppToWindPlantFreqPcontrolIECCommand assignment should not be null");
  }

  /**
   * handles unassign Kpwpp validation for a WindPlantFreqPcontrolIEC
   *
   * @param command UnAssignKpwppFromWindPlantFreqPcontrolIECCommand
   */
  public void validate(UnAssignKpwppFromWindPlantFreqPcontrolIECCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKpwppFromWindPlantFreqPcontrolIECCommand should not be null");
    Assert.notNull(
        command.getWindPlantFreqPcontrolIECId(),
        "UnAssignKpwppFromWindPlantFreqPcontrolIECCommand identifier should not be null");
  }
  /**
   * handles assign Prefmax validation for a WindPlantFreqPcontrolIEC
   *
   * @param command AssignPrefmaxToWindPlantFreqPcontrolIECCommand
   */
  public void validate(AssignPrefmaxToWindPlantFreqPcontrolIECCommand command) throws Exception {
    Assert.notNull(command, "AssignPrefmaxToWindPlantFreqPcontrolIECCommand should not be null");
    Assert.notNull(
        command.getWindPlantFreqPcontrolIECId(),
        "AssignPrefmaxToWindPlantFreqPcontrolIECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignPrefmaxToWindPlantFreqPcontrolIECCommand assignment should not be null");
  }

  /**
   * handles unassign Prefmax validation for a WindPlantFreqPcontrolIEC
   *
   * @param command UnAssignPrefmaxFromWindPlantFreqPcontrolIECCommand
   */
  public void validate(UnAssignPrefmaxFromWindPlantFreqPcontrolIECCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignPrefmaxFromWindPlantFreqPcontrolIECCommand should not be null");
    Assert.notNull(
        command.getWindPlantFreqPcontrolIECId(),
        "UnAssignPrefmaxFromWindPlantFreqPcontrolIECCommand identifier should not be null");
  }
  /**
   * handles assign Prefmin validation for a WindPlantFreqPcontrolIEC
   *
   * @param command AssignPrefminToWindPlantFreqPcontrolIECCommand
   */
  public void validate(AssignPrefminToWindPlantFreqPcontrolIECCommand command) throws Exception {
    Assert.notNull(command, "AssignPrefminToWindPlantFreqPcontrolIECCommand should not be null");
    Assert.notNull(
        command.getWindPlantFreqPcontrolIECId(),
        "AssignPrefminToWindPlantFreqPcontrolIECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignPrefminToWindPlantFreqPcontrolIECCommand assignment should not be null");
  }

  /**
   * handles unassign Prefmin validation for a WindPlantFreqPcontrolIEC
   *
   * @param command UnAssignPrefminFromWindPlantFreqPcontrolIECCommand
   */
  public void validate(UnAssignPrefminFromWindPlantFreqPcontrolIECCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignPrefminFromWindPlantFreqPcontrolIECCommand should not be null");
    Assert.notNull(
        command.getWindPlantFreqPcontrolIECId(),
        "UnAssignPrefminFromWindPlantFreqPcontrolIECCommand identifier should not be null");
  }
  /**
   * handles assign Tpft validation for a WindPlantFreqPcontrolIEC
   *
   * @param command AssignTpftToWindPlantFreqPcontrolIECCommand
   */
  public void validate(AssignTpftToWindPlantFreqPcontrolIECCommand command) throws Exception {
    Assert.notNull(command, "AssignTpftToWindPlantFreqPcontrolIECCommand should not be null");
    Assert.notNull(
        command.getWindPlantFreqPcontrolIECId(),
        "AssignTpftToWindPlantFreqPcontrolIECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignTpftToWindPlantFreqPcontrolIECCommand assignment should not be null");
  }

  /**
   * handles unassign Tpft validation for a WindPlantFreqPcontrolIEC
   *
   * @param command UnAssignTpftFromWindPlantFreqPcontrolIECCommand
   */
  public void validate(UnAssignTpftFromWindPlantFreqPcontrolIECCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTpftFromWindPlantFreqPcontrolIECCommand should not be null");
    Assert.notNull(
        command.getWindPlantFreqPcontrolIECId(),
        "UnAssignTpftFromWindPlantFreqPcontrolIECCommand identifier should not be null");
  }
  /**
   * handles assign Tpfv validation for a WindPlantFreqPcontrolIEC
   *
   * @param command AssignTpfvToWindPlantFreqPcontrolIECCommand
   */
  public void validate(AssignTpfvToWindPlantFreqPcontrolIECCommand command) throws Exception {
    Assert.notNull(command, "AssignTpfvToWindPlantFreqPcontrolIECCommand should not be null");
    Assert.notNull(
        command.getWindPlantFreqPcontrolIECId(),
        "AssignTpfvToWindPlantFreqPcontrolIECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignTpfvToWindPlantFreqPcontrolIECCommand assignment should not be null");
  }

  /**
   * handles unassign Tpfv validation for a WindPlantFreqPcontrolIEC
   *
   * @param command UnAssignTpfvFromWindPlantFreqPcontrolIECCommand
   */
  public void validate(UnAssignTpfvFromWindPlantFreqPcontrolIECCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTpfvFromWindPlantFreqPcontrolIECCommand should not be null");
    Assert.notNull(
        command.getWindPlantFreqPcontrolIECId(),
        "UnAssignTpfvFromWindPlantFreqPcontrolIECCommand identifier should not be null");
  }
  /**
   * handles assign Twpffilt validation for a WindPlantFreqPcontrolIEC
   *
   * @param command AssignTwpffiltToWindPlantFreqPcontrolIECCommand
   */
  public void validate(AssignTwpffiltToWindPlantFreqPcontrolIECCommand command) throws Exception {
    Assert.notNull(command, "AssignTwpffiltToWindPlantFreqPcontrolIECCommand should not be null");
    Assert.notNull(
        command.getWindPlantFreqPcontrolIECId(),
        "AssignTwpffiltToWindPlantFreqPcontrolIECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignTwpffiltToWindPlantFreqPcontrolIECCommand assignment should not be null");
  }

  /**
   * handles unassign Twpffilt validation for a WindPlantFreqPcontrolIEC
   *
   * @param command UnAssignTwpffiltFromWindPlantFreqPcontrolIECCommand
   */
  public void validate(UnAssignTwpffiltFromWindPlantFreqPcontrolIECCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignTwpffiltFromWindPlantFreqPcontrolIECCommand should not be null");
    Assert.notNull(
        command.getWindPlantFreqPcontrolIECId(),
        "UnAssignTwpffiltFromWindPlantFreqPcontrolIECCommand identifier should not be null");
  }
  /**
   * handles assign Twppfilt validation for a WindPlantFreqPcontrolIEC
   *
   * @param command AssignTwppfiltToWindPlantFreqPcontrolIECCommand
   */
  public void validate(AssignTwppfiltToWindPlantFreqPcontrolIECCommand command) throws Exception {
    Assert.notNull(command, "AssignTwppfiltToWindPlantFreqPcontrolIECCommand should not be null");
    Assert.notNull(
        command.getWindPlantFreqPcontrolIECId(),
        "AssignTwppfiltToWindPlantFreqPcontrolIECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignTwppfiltToWindPlantFreqPcontrolIECCommand assignment should not be null");
  }

  /**
   * handles unassign Twppfilt validation for a WindPlantFreqPcontrolIEC
   *
   * @param command UnAssignTwppfiltFromWindPlantFreqPcontrolIECCommand
   */
  public void validate(UnAssignTwppfiltFromWindPlantFreqPcontrolIECCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignTwppfiltFromWindPlantFreqPcontrolIECCommand should not be null");
    Assert.notNull(
        command.getWindPlantFreqPcontrolIECId(),
        "UnAssignTwppfiltFromWindPlantFreqPcontrolIECCommand identifier should not be null");
  }
}
