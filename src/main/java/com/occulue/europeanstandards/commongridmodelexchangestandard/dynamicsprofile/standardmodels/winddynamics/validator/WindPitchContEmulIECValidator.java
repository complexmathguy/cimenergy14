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

public class WindPitchContEmulIECValidator {

  /** default constructor */
  protected WindPitchContEmulIECValidator() {}

  /** factory method */
  public static WindPitchContEmulIECValidator getInstance() {
    return new WindPitchContEmulIECValidator();
  }

  /** handles creation validation for a WindPitchContEmulIEC */
  public void validate(CreateWindPitchContEmulIECCommand windPitchContEmulIEC) throws Exception {
    Assert.notNull(windPitchContEmulIEC, "CreateWindPitchContEmulIECCommand should not be null");
    //		Assert.isNull( windPitchContEmulIEC.getWindPitchContEmulIECId(),
    // "CreateWindPitchContEmulIECCommand identifier should be null" );
  }

  /** handles update validation for a WindPitchContEmulIEC */
  public void validate(UpdateWindPitchContEmulIECCommand windPitchContEmulIEC) throws Exception {
    Assert.notNull(windPitchContEmulIEC, "UpdateWindPitchContEmulIECCommand should not be null");
    Assert.notNull(
        windPitchContEmulIEC.getWindPitchContEmulIECId(),
        "UpdateWindPitchContEmulIECCommand identifier should not be null");
  }

  /** handles delete validation for a WindPitchContEmulIEC */
  public void validate(DeleteWindPitchContEmulIECCommand windPitchContEmulIEC) throws Exception {
    Assert.notNull(windPitchContEmulIEC, "{commandAlias} should not be null");
    Assert.notNull(
        windPitchContEmulIEC.getWindPitchContEmulIECId(),
        "DeleteWindPitchContEmulIECCommand identifier should not be null");
  }

  /** handles fetchOne validation for a WindPitchContEmulIEC */
  public void validate(WindPitchContEmulIECFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "WindPitchContEmulIECFetchOneSummary should not be null");
    Assert.notNull(
        summary.getWindPitchContEmulIECId(),
        "WindPitchContEmulIECFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Kdroop validation for a WindPitchContEmulIEC
   *
   * @param command AssignKdroopToWindPitchContEmulIECCommand
   */
  public void validate(AssignKdroopToWindPitchContEmulIECCommand command) throws Exception {
    Assert.notNull(command, "AssignKdroopToWindPitchContEmulIECCommand should not be null");
    Assert.notNull(
        command.getWindPitchContEmulIECId(),
        "AssignKdroopToWindPitchContEmulIECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignKdroopToWindPitchContEmulIECCommand assignment should not be null");
  }

  /**
   * handles unassign Kdroop validation for a WindPitchContEmulIEC
   *
   * @param command UnAssignKdroopFromWindPitchContEmulIECCommand
   */
  public void validate(UnAssignKdroopFromWindPitchContEmulIECCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKdroopFromWindPitchContEmulIECCommand should not be null");
    Assert.notNull(
        command.getWindPitchContEmulIECId(),
        "UnAssignKdroopFromWindPitchContEmulIECCommand identifier should not be null");
  }
  /**
   * handles assign Kipce validation for a WindPitchContEmulIEC
   *
   * @param command AssignKipceToWindPitchContEmulIECCommand
   */
  public void validate(AssignKipceToWindPitchContEmulIECCommand command) throws Exception {
    Assert.notNull(command, "AssignKipceToWindPitchContEmulIECCommand should not be null");
    Assert.notNull(
        command.getWindPitchContEmulIECId(),
        "AssignKipceToWindPitchContEmulIECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignKipceToWindPitchContEmulIECCommand assignment should not be null");
  }

  /**
   * handles unassign Kipce validation for a WindPitchContEmulIEC
   *
   * @param command UnAssignKipceFromWindPitchContEmulIECCommand
   */
  public void validate(UnAssignKipceFromWindPitchContEmulIECCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKipceFromWindPitchContEmulIECCommand should not be null");
    Assert.notNull(
        command.getWindPitchContEmulIECId(),
        "UnAssignKipceFromWindPitchContEmulIECCommand identifier should not be null");
  }
  /**
   * handles assign Komegaaero validation for a WindPitchContEmulIEC
   *
   * @param command AssignKomegaaeroToWindPitchContEmulIECCommand
   */
  public void validate(AssignKomegaaeroToWindPitchContEmulIECCommand command) throws Exception {
    Assert.notNull(command, "AssignKomegaaeroToWindPitchContEmulIECCommand should not be null");
    Assert.notNull(
        command.getWindPitchContEmulIECId(),
        "AssignKomegaaeroToWindPitchContEmulIECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignKomegaaeroToWindPitchContEmulIECCommand assignment should not be null");
  }

  /**
   * handles unassign Komegaaero validation for a WindPitchContEmulIEC
   *
   * @param command UnAssignKomegaaeroFromWindPitchContEmulIECCommand
   */
  public void validate(UnAssignKomegaaeroFromWindPitchContEmulIECCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKomegaaeroFromWindPitchContEmulIECCommand should not be null");
    Assert.notNull(
        command.getWindPitchContEmulIECId(),
        "UnAssignKomegaaeroFromWindPitchContEmulIECCommand identifier should not be null");
  }
  /**
   * handles assign Kppce validation for a WindPitchContEmulIEC
   *
   * @param command AssignKppceToWindPitchContEmulIECCommand
   */
  public void validate(AssignKppceToWindPitchContEmulIECCommand command) throws Exception {
    Assert.notNull(command, "AssignKppceToWindPitchContEmulIECCommand should not be null");
    Assert.notNull(
        command.getWindPitchContEmulIECId(),
        "AssignKppceToWindPitchContEmulIECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignKppceToWindPitchContEmulIECCommand assignment should not be null");
  }

  /**
   * handles unassign Kppce validation for a WindPitchContEmulIEC
   *
   * @param command UnAssignKppceFromWindPitchContEmulIECCommand
   */
  public void validate(UnAssignKppceFromWindPitchContEmulIECCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKppceFromWindPitchContEmulIECCommand should not be null");
    Assert.notNull(
        command.getWindPitchContEmulIECId(),
        "UnAssignKppceFromWindPitchContEmulIECCommand identifier should not be null");
  }
  /**
   * handles assign Omegaref validation for a WindPitchContEmulIEC
   *
   * @param command AssignOmegarefToWindPitchContEmulIECCommand
   */
  public void validate(AssignOmegarefToWindPitchContEmulIECCommand command) throws Exception {
    Assert.notNull(command, "AssignOmegarefToWindPitchContEmulIECCommand should not be null");
    Assert.notNull(
        command.getWindPitchContEmulIECId(),
        "AssignOmegarefToWindPitchContEmulIECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignOmegarefToWindPitchContEmulIECCommand assignment should not be null");
  }

  /**
   * handles unassign Omegaref validation for a WindPitchContEmulIEC
   *
   * @param command UnAssignOmegarefFromWindPitchContEmulIECCommand
   */
  public void validate(UnAssignOmegarefFromWindPitchContEmulIECCommand command) throws Exception {
    Assert.notNull(command, "UnAssignOmegarefFromWindPitchContEmulIECCommand should not be null");
    Assert.notNull(
        command.getWindPitchContEmulIECId(),
        "UnAssignOmegarefFromWindPitchContEmulIECCommand identifier should not be null");
  }
  /**
   * handles assign Pimax validation for a WindPitchContEmulIEC
   *
   * @param command AssignPimaxToWindPitchContEmulIECCommand
   */
  public void validate(AssignPimaxToWindPitchContEmulIECCommand command) throws Exception {
    Assert.notNull(command, "AssignPimaxToWindPitchContEmulIECCommand should not be null");
    Assert.notNull(
        command.getWindPitchContEmulIECId(),
        "AssignPimaxToWindPitchContEmulIECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignPimaxToWindPitchContEmulIECCommand assignment should not be null");
  }

  /**
   * handles unassign Pimax validation for a WindPitchContEmulIEC
   *
   * @param command UnAssignPimaxFromWindPitchContEmulIECCommand
   */
  public void validate(UnAssignPimaxFromWindPitchContEmulIECCommand command) throws Exception {
    Assert.notNull(command, "UnAssignPimaxFromWindPitchContEmulIECCommand should not be null");
    Assert.notNull(
        command.getWindPitchContEmulIECId(),
        "UnAssignPimaxFromWindPitchContEmulIECCommand identifier should not be null");
  }
  /**
   * handles assign Pimin validation for a WindPitchContEmulIEC
   *
   * @param command AssignPiminToWindPitchContEmulIECCommand
   */
  public void validate(AssignPiminToWindPitchContEmulIECCommand command) throws Exception {
    Assert.notNull(command, "AssignPiminToWindPitchContEmulIECCommand should not be null");
    Assert.notNull(
        command.getWindPitchContEmulIECId(),
        "AssignPiminToWindPitchContEmulIECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignPiminToWindPitchContEmulIECCommand assignment should not be null");
  }

  /**
   * handles unassign Pimin validation for a WindPitchContEmulIEC
   *
   * @param command UnAssignPiminFromWindPitchContEmulIECCommand
   */
  public void validate(UnAssignPiminFromWindPitchContEmulIECCommand command) throws Exception {
    Assert.notNull(command, "UnAssignPiminFromWindPitchContEmulIECCommand should not be null");
    Assert.notNull(
        command.getWindPitchContEmulIECId(),
        "UnAssignPiminFromWindPitchContEmulIECCommand identifier should not be null");
  }
  /**
   * handles assign T1 validation for a WindPitchContEmulIEC
   *
   * @param command AssignT1ToWindPitchContEmulIECCommand
   */
  public void validate(AssignT1ToWindPitchContEmulIECCommand command) throws Exception {
    Assert.notNull(command, "AssignT1ToWindPitchContEmulIECCommand should not be null");
    Assert.notNull(
        command.getWindPitchContEmulIECId(),
        "AssignT1ToWindPitchContEmulIECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignT1ToWindPitchContEmulIECCommand assignment should not be null");
  }

  /**
   * handles unassign T1 validation for a WindPitchContEmulIEC
   *
   * @param command UnAssignT1FromWindPitchContEmulIECCommand
   */
  public void validate(UnAssignT1FromWindPitchContEmulIECCommand command) throws Exception {
    Assert.notNull(command, "UnAssignT1FromWindPitchContEmulIECCommand should not be null");
    Assert.notNull(
        command.getWindPitchContEmulIECId(),
        "UnAssignT1FromWindPitchContEmulIECCommand identifier should not be null");
  }
  /**
   * handles assign T2 validation for a WindPitchContEmulIEC
   *
   * @param command AssignT2ToWindPitchContEmulIECCommand
   */
  public void validate(AssignT2ToWindPitchContEmulIECCommand command) throws Exception {
    Assert.notNull(command, "AssignT2ToWindPitchContEmulIECCommand should not be null");
    Assert.notNull(
        command.getWindPitchContEmulIECId(),
        "AssignT2ToWindPitchContEmulIECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignT2ToWindPitchContEmulIECCommand assignment should not be null");
  }

  /**
   * handles unassign T2 validation for a WindPitchContEmulIEC
   *
   * @param command UnAssignT2FromWindPitchContEmulIECCommand
   */
  public void validate(UnAssignT2FromWindPitchContEmulIECCommand command) throws Exception {
    Assert.notNull(command, "UnAssignT2FromWindPitchContEmulIECCommand should not be null");
    Assert.notNull(
        command.getWindPitchContEmulIECId(),
        "UnAssignT2FromWindPitchContEmulIECCommand identifier should not be null");
  }
  /**
   * handles assign Tpe validation for a WindPitchContEmulIEC
   *
   * @param command AssignTpeToWindPitchContEmulIECCommand
   */
  public void validate(AssignTpeToWindPitchContEmulIECCommand command) throws Exception {
    Assert.notNull(command, "AssignTpeToWindPitchContEmulIECCommand should not be null");
    Assert.notNull(
        command.getWindPitchContEmulIECId(),
        "AssignTpeToWindPitchContEmulIECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignTpeToWindPitchContEmulIECCommand assignment should not be null");
  }

  /**
   * handles unassign Tpe validation for a WindPitchContEmulIEC
   *
   * @param command UnAssignTpeFromWindPitchContEmulIECCommand
   */
  public void validate(UnAssignTpeFromWindPitchContEmulIECCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTpeFromWindPitchContEmulIECCommand should not be null");
    Assert.notNull(
        command.getWindPitchContEmulIECId(),
        "UnAssignTpeFromWindPitchContEmulIECCommand identifier should not be null");
  }
}
