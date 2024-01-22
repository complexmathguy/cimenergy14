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

public class WindContRotorRIECValidator {

  /** default constructor */
  protected WindContRotorRIECValidator() {}

  /** factory method */
  public static WindContRotorRIECValidator getInstance() {
    return new WindContRotorRIECValidator();
  }

  /** handles creation validation for a WindContRotorRIEC */
  public void validate(CreateWindContRotorRIECCommand windContRotorRIEC) throws Exception {
    Assert.notNull(windContRotorRIEC, "CreateWindContRotorRIECCommand should not be null");
    //		Assert.isNull( windContRotorRIEC.getWindContRotorRIECId(), "CreateWindContRotorRIECCommand
    // identifier should be null" );
  }

  /** handles update validation for a WindContRotorRIEC */
  public void validate(UpdateWindContRotorRIECCommand windContRotorRIEC) throws Exception {
    Assert.notNull(windContRotorRIEC, "UpdateWindContRotorRIECCommand should not be null");
    Assert.notNull(
        windContRotorRIEC.getWindContRotorRIECId(),
        "UpdateWindContRotorRIECCommand identifier should not be null");
  }

  /** handles delete validation for a WindContRotorRIEC */
  public void validate(DeleteWindContRotorRIECCommand windContRotorRIEC) throws Exception {
    Assert.notNull(windContRotorRIEC, "{commandAlias} should not be null");
    Assert.notNull(
        windContRotorRIEC.getWindContRotorRIECId(),
        "DeleteWindContRotorRIECCommand identifier should not be null");
  }

  /** handles fetchOne validation for a WindContRotorRIEC */
  public void validate(WindContRotorRIECFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "WindContRotorRIECFetchOneSummary should not be null");
    Assert.notNull(
        summary.getWindContRotorRIECId(),
        "WindContRotorRIECFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Kirr validation for a WindContRotorRIEC
   *
   * @param command AssignKirrToWindContRotorRIECCommand
   */
  public void validate(AssignKirrToWindContRotorRIECCommand command) throws Exception {
    Assert.notNull(command, "AssignKirrToWindContRotorRIECCommand should not be null");
    Assert.notNull(
        command.getWindContRotorRIECId(),
        "AssignKirrToWindContRotorRIECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignKirrToWindContRotorRIECCommand assignment should not be null");
  }

  /**
   * handles unassign Kirr validation for a WindContRotorRIEC
   *
   * @param command UnAssignKirrFromWindContRotorRIECCommand
   */
  public void validate(UnAssignKirrFromWindContRotorRIECCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKirrFromWindContRotorRIECCommand should not be null");
    Assert.notNull(
        command.getWindContRotorRIECId(),
        "UnAssignKirrFromWindContRotorRIECCommand identifier should not be null");
  }
  /**
   * handles assign Komegafilt validation for a WindContRotorRIEC
   *
   * @param command AssignKomegafiltToWindContRotorRIECCommand
   */
  public void validate(AssignKomegafiltToWindContRotorRIECCommand command) throws Exception {
    Assert.notNull(command, "AssignKomegafiltToWindContRotorRIECCommand should not be null");
    Assert.notNull(
        command.getWindContRotorRIECId(),
        "AssignKomegafiltToWindContRotorRIECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignKomegafiltToWindContRotorRIECCommand assignment should not be null");
  }

  /**
   * handles unassign Komegafilt validation for a WindContRotorRIEC
   *
   * @param command UnAssignKomegafiltFromWindContRotorRIECCommand
   */
  public void validate(UnAssignKomegafiltFromWindContRotorRIECCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKomegafiltFromWindContRotorRIECCommand should not be null");
    Assert.notNull(
        command.getWindContRotorRIECId(),
        "UnAssignKomegafiltFromWindContRotorRIECCommand identifier should not be null");
  }
  /**
   * handles assign Kpfilt validation for a WindContRotorRIEC
   *
   * @param command AssignKpfiltToWindContRotorRIECCommand
   */
  public void validate(AssignKpfiltToWindContRotorRIECCommand command) throws Exception {
    Assert.notNull(command, "AssignKpfiltToWindContRotorRIECCommand should not be null");
    Assert.notNull(
        command.getWindContRotorRIECId(),
        "AssignKpfiltToWindContRotorRIECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignKpfiltToWindContRotorRIECCommand assignment should not be null");
  }

  /**
   * handles unassign Kpfilt validation for a WindContRotorRIEC
   *
   * @param command UnAssignKpfiltFromWindContRotorRIECCommand
   */
  public void validate(UnAssignKpfiltFromWindContRotorRIECCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKpfiltFromWindContRotorRIECCommand should not be null");
    Assert.notNull(
        command.getWindContRotorRIECId(),
        "UnAssignKpfiltFromWindContRotorRIECCommand identifier should not be null");
  }
  /**
   * handles assign Kprr validation for a WindContRotorRIEC
   *
   * @param command AssignKprrToWindContRotorRIECCommand
   */
  public void validate(AssignKprrToWindContRotorRIECCommand command) throws Exception {
    Assert.notNull(command, "AssignKprrToWindContRotorRIECCommand should not be null");
    Assert.notNull(
        command.getWindContRotorRIECId(),
        "AssignKprrToWindContRotorRIECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignKprrToWindContRotorRIECCommand assignment should not be null");
  }

  /**
   * handles unassign Kprr validation for a WindContRotorRIEC
   *
   * @param command UnAssignKprrFromWindContRotorRIECCommand
   */
  public void validate(UnAssignKprrFromWindContRotorRIECCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKprrFromWindContRotorRIECCommand should not be null");
    Assert.notNull(
        command.getWindContRotorRIECId(),
        "UnAssignKprrFromWindContRotorRIECCommand identifier should not be null");
  }
  /**
   * handles assign Rmax validation for a WindContRotorRIEC
   *
   * @param command AssignRmaxToWindContRotorRIECCommand
   */
  public void validate(AssignRmaxToWindContRotorRIECCommand command) throws Exception {
    Assert.notNull(command, "AssignRmaxToWindContRotorRIECCommand should not be null");
    Assert.notNull(
        command.getWindContRotorRIECId(),
        "AssignRmaxToWindContRotorRIECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignRmaxToWindContRotorRIECCommand assignment should not be null");
  }

  /**
   * handles unassign Rmax validation for a WindContRotorRIEC
   *
   * @param command UnAssignRmaxFromWindContRotorRIECCommand
   */
  public void validate(UnAssignRmaxFromWindContRotorRIECCommand command) throws Exception {
    Assert.notNull(command, "UnAssignRmaxFromWindContRotorRIECCommand should not be null");
    Assert.notNull(
        command.getWindContRotorRIECId(),
        "UnAssignRmaxFromWindContRotorRIECCommand identifier should not be null");
  }
  /**
   * handles assign Rmin validation for a WindContRotorRIEC
   *
   * @param command AssignRminToWindContRotorRIECCommand
   */
  public void validate(AssignRminToWindContRotorRIECCommand command) throws Exception {
    Assert.notNull(command, "AssignRminToWindContRotorRIECCommand should not be null");
    Assert.notNull(
        command.getWindContRotorRIECId(),
        "AssignRminToWindContRotorRIECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignRminToWindContRotorRIECCommand assignment should not be null");
  }

  /**
   * handles unassign Rmin validation for a WindContRotorRIEC
   *
   * @param command UnAssignRminFromWindContRotorRIECCommand
   */
  public void validate(UnAssignRminFromWindContRotorRIECCommand command) throws Exception {
    Assert.notNull(command, "UnAssignRminFromWindContRotorRIECCommand should not be null");
    Assert.notNull(
        command.getWindContRotorRIECId(),
        "UnAssignRminFromWindContRotorRIECCommand identifier should not be null");
  }
  /**
   * handles assign Tomegafilt validation for a WindContRotorRIEC
   *
   * @param command AssignTomegafiltToWindContRotorRIECCommand
   */
  public void validate(AssignTomegafiltToWindContRotorRIECCommand command) throws Exception {
    Assert.notNull(command, "AssignTomegafiltToWindContRotorRIECCommand should not be null");
    Assert.notNull(
        command.getWindContRotorRIECId(),
        "AssignTomegafiltToWindContRotorRIECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignTomegafiltToWindContRotorRIECCommand assignment should not be null");
  }

  /**
   * handles unassign Tomegafilt validation for a WindContRotorRIEC
   *
   * @param command UnAssignTomegafiltFromWindContRotorRIECCommand
   */
  public void validate(UnAssignTomegafiltFromWindContRotorRIECCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTomegafiltFromWindContRotorRIECCommand should not be null");
    Assert.notNull(
        command.getWindContRotorRIECId(),
        "UnAssignTomegafiltFromWindContRotorRIECCommand identifier should not be null");
  }
  /**
   * handles assign Tpfilt validation for a WindContRotorRIEC
   *
   * @param command AssignTpfiltToWindContRotorRIECCommand
   */
  public void validate(AssignTpfiltToWindContRotorRIECCommand command) throws Exception {
    Assert.notNull(command, "AssignTpfiltToWindContRotorRIECCommand should not be null");
    Assert.notNull(
        command.getWindContRotorRIECId(),
        "AssignTpfiltToWindContRotorRIECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignTpfiltToWindContRotorRIECCommand assignment should not be null");
  }

  /**
   * handles unassign Tpfilt validation for a WindContRotorRIEC
   *
   * @param command UnAssignTpfiltFromWindContRotorRIECCommand
   */
  public void validate(UnAssignTpfiltFromWindContRotorRIECCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTpfiltFromWindContRotorRIECCommand should not be null");
    Assert.notNull(
        command.getWindContRotorRIECId(),
        "UnAssignTpfiltFromWindContRotorRIECCommand identifier should not be null");
  }
}
