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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.powersystemstabilizerdynamics.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class PssIEEE4BValidator {

  /** default constructor */
  protected PssIEEE4BValidator() {}

  /** factory method */
  public static PssIEEE4BValidator getInstance() {
    return new PssIEEE4BValidator();
  }

  /** handles creation validation for a PssIEEE4B */
  public void validate(CreatePssIEEE4BCommand pssIEEE4B) throws Exception {
    Assert.notNull(pssIEEE4B, "CreatePssIEEE4BCommand should not be null");
    //		Assert.isNull( pssIEEE4B.getPssIEEE4BId(), "CreatePssIEEE4BCommand identifier should be
    // null" );
  }

  /** handles update validation for a PssIEEE4B */
  public void validate(UpdatePssIEEE4BCommand pssIEEE4B) throws Exception {
    Assert.notNull(pssIEEE4B, "UpdatePssIEEE4BCommand should not be null");
    Assert.notNull(
        pssIEEE4B.getPssIEEE4BId(), "UpdatePssIEEE4BCommand identifier should not be null");
  }

  /** handles delete validation for a PssIEEE4B */
  public void validate(DeletePssIEEE4BCommand pssIEEE4B) throws Exception {
    Assert.notNull(pssIEEE4B, "{commandAlias} should not be null");
    Assert.notNull(
        pssIEEE4B.getPssIEEE4BId(), "DeletePssIEEE4BCommand identifier should not be null");
  }

  /** handles fetchOne validation for a PssIEEE4B */
  public void validate(PssIEEE4BFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "PssIEEE4BFetchOneSummary should not be null");
    Assert.notNull(
        summary.getPssIEEE4BId(), "PssIEEE4BFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Bwh1 validation for a PssIEEE4B
   *
   * @param command AssignBwh1ToPssIEEE4BCommand
   */
  public void validate(AssignBwh1ToPssIEEE4BCommand command) throws Exception {
    Assert.notNull(command, "AssignBwh1ToPssIEEE4BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE4BId(), "AssignBwh1ToPssIEEE4BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignBwh1ToPssIEEE4BCommand assignment should not be null");
  }

  /**
   * handles unassign Bwh1 validation for a PssIEEE4B
   *
   * @param command UnAssignBwh1FromPssIEEE4BCommand
   */
  public void validate(UnAssignBwh1FromPssIEEE4BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignBwh1FromPssIEEE4BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE4BId(), "UnAssignBwh1FromPssIEEE4BCommand identifier should not be null");
  }
  /**
   * handles assign Bwh2 validation for a PssIEEE4B
   *
   * @param command AssignBwh2ToPssIEEE4BCommand
   */
  public void validate(AssignBwh2ToPssIEEE4BCommand command) throws Exception {
    Assert.notNull(command, "AssignBwh2ToPssIEEE4BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE4BId(), "AssignBwh2ToPssIEEE4BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignBwh2ToPssIEEE4BCommand assignment should not be null");
  }

  /**
   * handles unassign Bwh2 validation for a PssIEEE4B
   *
   * @param command UnAssignBwh2FromPssIEEE4BCommand
   */
  public void validate(UnAssignBwh2FromPssIEEE4BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignBwh2FromPssIEEE4BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE4BId(), "UnAssignBwh2FromPssIEEE4BCommand identifier should not be null");
  }
  /**
   * handles assign Bwl1 validation for a PssIEEE4B
   *
   * @param command AssignBwl1ToPssIEEE4BCommand
   */
  public void validate(AssignBwl1ToPssIEEE4BCommand command) throws Exception {
    Assert.notNull(command, "AssignBwl1ToPssIEEE4BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE4BId(), "AssignBwl1ToPssIEEE4BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignBwl1ToPssIEEE4BCommand assignment should not be null");
  }

  /**
   * handles unassign Bwl1 validation for a PssIEEE4B
   *
   * @param command UnAssignBwl1FromPssIEEE4BCommand
   */
  public void validate(UnAssignBwl1FromPssIEEE4BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignBwl1FromPssIEEE4BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE4BId(), "UnAssignBwl1FromPssIEEE4BCommand identifier should not be null");
  }
  /**
   * handles assign Bwl2 validation for a PssIEEE4B
   *
   * @param command AssignBwl2ToPssIEEE4BCommand
   */
  public void validate(AssignBwl2ToPssIEEE4BCommand command) throws Exception {
    Assert.notNull(command, "AssignBwl2ToPssIEEE4BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE4BId(), "AssignBwl2ToPssIEEE4BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignBwl2ToPssIEEE4BCommand assignment should not be null");
  }

  /**
   * handles unassign Bwl2 validation for a PssIEEE4B
   *
   * @param command UnAssignBwl2FromPssIEEE4BCommand
   */
  public void validate(UnAssignBwl2FromPssIEEE4BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignBwl2FromPssIEEE4BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE4BId(), "UnAssignBwl2FromPssIEEE4BCommand identifier should not be null");
  }
  /**
   * handles assign Kh validation for a PssIEEE4B
   *
   * @param command AssignKhToPssIEEE4BCommand
   */
  public void validate(AssignKhToPssIEEE4BCommand command) throws Exception {
    Assert.notNull(command, "AssignKhToPssIEEE4BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE4BId(), "AssignKhToPssIEEE4BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKhToPssIEEE4BCommand assignment should not be null");
  }

  /**
   * handles unassign Kh validation for a PssIEEE4B
   *
   * @param command UnAssignKhFromPssIEEE4BCommand
   */
  public void validate(UnAssignKhFromPssIEEE4BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKhFromPssIEEE4BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE4BId(), "UnAssignKhFromPssIEEE4BCommand identifier should not be null");
  }
  /**
   * handles assign Kh1 validation for a PssIEEE4B
   *
   * @param command AssignKh1ToPssIEEE4BCommand
   */
  public void validate(AssignKh1ToPssIEEE4BCommand command) throws Exception {
    Assert.notNull(command, "AssignKh1ToPssIEEE4BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE4BId(), "AssignKh1ToPssIEEE4BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKh1ToPssIEEE4BCommand assignment should not be null");
  }

  /**
   * handles unassign Kh1 validation for a PssIEEE4B
   *
   * @param command UnAssignKh1FromPssIEEE4BCommand
   */
  public void validate(UnAssignKh1FromPssIEEE4BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKh1FromPssIEEE4BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE4BId(), "UnAssignKh1FromPssIEEE4BCommand identifier should not be null");
  }
  /**
   * handles assign Kh11 validation for a PssIEEE4B
   *
   * @param command AssignKh11ToPssIEEE4BCommand
   */
  public void validate(AssignKh11ToPssIEEE4BCommand command) throws Exception {
    Assert.notNull(command, "AssignKh11ToPssIEEE4BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE4BId(), "AssignKh11ToPssIEEE4BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKh11ToPssIEEE4BCommand assignment should not be null");
  }

  /**
   * handles unassign Kh11 validation for a PssIEEE4B
   *
   * @param command UnAssignKh11FromPssIEEE4BCommand
   */
  public void validate(UnAssignKh11FromPssIEEE4BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKh11FromPssIEEE4BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE4BId(), "UnAssignKh11FromPssIEEE4BCommand identifier should not be null");
  }
  /**
   * handles assign Kh17 validation for a PssIEEE4B
   *
   * @param command AssignKh17ToPssIEEE4BCommand
   */
  public void validate(AssignKh17ToPssIEEE4BCommand command) throws Exception {
    Assert.notNull(command, "AssignKh17ToPssIEEE4BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE4BId(), "AssignKh17ToPssIEEE4BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKh17ToPssIEEE4BCommand assignment should not be null");
  }

  /**
   * handles unassign Kh17 validation for a PssIEEE4B
   *
   * @param command UnAssignKh17FromPssIEEE4BCommand
   */
  public void validate(UnAssignKh17FromPssIEEE4BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKh17FromPssIEEE4BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE4BId(), "UnAssignKh17FromPssIEEE4BCommand identifier should not be null");
  }
  /**
   * handles assign Kh2 validation for a PssIEEE4B
   *
   * @param command AssignKh2ToPssIEEE4BCommand
   */
  public void validate(AssignKh2ToPssIEEE4BCommand command) throws Exception {
    Assert.notNull(command, "AssignKh2ToPssIEEE4BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE4BId(), "AssignKh2ToPssIEEE4BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKh2ToPssIEEE4BCommand assignment should not be null");
  }

  /**
   * handles unassign Kh2 validation for a PssIEEE4B
   *
   * @param command UnAssignKh2FromPssIEEE4BCommand
   */
  public void validate(UnAssignKh2FromPssIEEE4BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKh2FromPssIEEE4BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE4BId(), "UnAssignKh2FromPssIEEE4BCommand identifier should not be null");
  }
  /**
   * handles assign Ki validation for a PssIEEE4B
   *
   * @param command AssignKiToPssIEEE4BCommand
   */
  public void validate(AssignKiToPssIEEE4BCommand command) throws Exception {
    Assert.notNull(command, "AssignKiToPssIEEE4BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE4BId(), "AssignKiToPssIEEE4BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKiToPssIEEE4BCommand assignment should not be null");
  }

  /**
   * handles unassign Ki validation for a PssIEEE4B
   *
   * @param command UnAssignKiFromPssIEEE4BCommand
   */
  public void validate(UnAssignKiFromPssIEEE4BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKiFromPssIEEE4BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE4BId(), "UnAssignKiFromPssIEEE4BCommand identifier should not be null");
  }
  /**
   * handles assign Ki1 validation for a PssIEEE4B
   *
   * @param command AssignKi1ToPssIEEE4BCommand
   */
  public void validate(AssignKi1ToPssIEEE4BCommand command) throws Exception {
    Assert.notNull(command, "AssignKi1ToPssIEEE4BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE4BId(), "AssignKi1ToPssIEEE4BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKi1ToPssIEEE4BCommand assignment should not be null");
  }

  /**
   * handles unassign Ki1 validation for a PssIEEE4B
   *
   * @param command UnAssignKi1FromPssIEEE4BCommand
   */
  public void validate(UnAssignKi1FromPssIEEE4BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKi1FromPssIEEE4BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE4BId(), "UnAssignKi1FromPssIEEE4BCommand identifier should not be null");
  }
  /**
   * handles assign Ki11 validation for a PssIEEE4B
   *
   * @param command AssignKi11ToPssIEEE4BCommand
   */
  public void validate(AssignKi11ToPssIEEE4BCommand command) throws Exception {
    Assert.notNull(command, "AssignKi11ToPssIEEE4BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE4BId(), "AssignKi11ToPssIEEE4BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKi11ToPssIEEE4BCommand assignment should not be null");
  }

  /**
   * handles unassign Ki11 validation for a PssIEEE4B
   *
   * @param command UnAssignKi11FromPssIEEE4BCommand
   */
  public void validate(UnAssignKi11FromPssIEEE4BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKi11FromPssIEEE4BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE4BId(), "UnAssignKi11FromPssIEEE4BCommand identifier should not be null");
  }
  /**
   * handles assign Ki17 validation for a PssIEEE4B
   *
   * @param command AssignKi17ToPssIEEE4BCommand
   */
  public void validate(AssignKi17ToPssIEEE4BCommand command) throws Exception {
    Assert.notNull(command, "AssignKi17ToPssIEEE4BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE4BId(), "AssignKi17ToPssIEEE4BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKi17ToPssIEEE4BCommand assignment should not be null");
  }

  /**
   * handles unassign Ki17 validation for a PssIEEE4B
   *
   * @param command UnAssignKi17FromPssIEEE4BCommand
   */
  public void validate(UnAssignKi17FromPssIEEE4BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKi17FromPssIEEE4BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE4BId(), "UnAssignKi17FromPssIEEE4BCommand identifier should not be null");
  }
  /**
   * handles assign Ki2 validation for a PssIEEE4B
   *
   * @param command AssignKi2ToPssIEEE4BCommand
   */
  public void validate(AssignKi2ToPssIEEE4BCommand command) throws Exception {
    Assert.notNull(command, "AssignKi2ToPssIEEE4BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE4BId(), "AssignKi2ToPssIEEE4BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKi2ToPssIEEE4BCommand assignment should not be null");
  }

  /**
   * handles unassign Ki2 validation for a PssIEEE4B
   *
   * @param command UnAssignKi2FromPssIEEE4BCommand
   */
  public void validate(UnAssignKi2FromPssIEEE4BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKi2FromPssIEEE4BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE4BId(), "UnAssignKi2FromPssIEEE4BCommand identifier should not be null");
  }
  /**
   * handles assign Kl validation for a PssIEEE4B
   *
   * @param command AssignKlToPssIEEE4BCommand
   */
  public void validate(AssignKlToPssIEEE4BCommand command) throws Exception {
    Assert.notNull(command, "AssignKlToPssIEEE4BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE4BId(), "AssignKlToPssIEEE4BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKlToPssIEEE4BCommand assignment should not be null");
  }

  /**
   * handles unassign Kl validation for a PssIEEE4B
   *
   * @param command UnAssignKlFromPssIEEE4BCommand
   */
  public void validate(UnAssignKlFromPssIEEE4BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKlFromPssIEEE4BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE4BId(), "UnAssignKlFromPssIEEE4BCommand identifier should not be null");
  }
  /**
   * handles assign Kl1 validation for a PssIEEE4B
   *
   * @param command AssignKl1ToPssIEEE4BCommand
   */
  public void validate(AssignKl1ToPssIEEE4BCommand command) throws Exception {
    Assert.notNull(command, "AssignKl1ToPssIEEE4BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE4BId(), "AssignKl1ToPssIEEE4BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKl1ToPssIEEE4BCommand assignment should not be null");
  }

  /**
   * handles unassign Kl1 validation for a PssIEEE4B
   *
   * @param command UnAssignKl1FromPssIEEE4BCommand
   */
  public void validate(UnAssignKl1FromPssIEEE4BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKl1FromPssIEEE4BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE4BId(), "UnAssignKl1FromPssIEEE4BCommand identifier should not be null");
  }
  /**
   * handles assign Kl11 validation for a PssIEEE4B
   *
   * @param command AssignKl11ToPssIEEE4BCommand
   */
  public void validate(AssignKl11ToPssIEEE4BCommand command) throws Exception {
    Assert.notNull(command, "AssignKl11ToPssIEEE4BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE4BId(), "AssignKl11ToPssIEEE4BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKl11ToPssIEEE4BCommand assignment should not be null");
  }

  /**
   * handles unassign Kl11 validation for a PssIEEE4B
   *
   * @param command UnAssignKl11FromPssIEEE4BCommand
   */
  public void validate(UnAssignKl11FromPssIEEE4BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKl11FromPssIEEE4BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE4BId(), "UnAssignKl11FromPssIEEE4BCommand identifier should not be null");
  }
  /**
   * handles assign Kl17 validation for a PssIEEE4B
   *
   * @param command AssignKl17ToPssIEEE4BCommand
   */
  public void validate(AssignKl17ToPssIEEE4BCommand command) throws Exception {
    Assert.notNull(command, "AssignKl17ToPssIEEE4BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE4BId(), "AssignKl17ToPssIEEE4BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKl17ToPssIEEE4BCommand assignment should not be null");
  }

  /**
   * handles unassign Kl17 validation for a PssIEEE4B
   *
   * @param command UnAssignKl17FromPssIEEE4BCommand
   */
  public void validate(UnAssignKl17FromPssIEEE4BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKl17FromPssIEEE4BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE4BId(), "UnAssignKl17FromPssIEEE4BCommand identifier should not be null");
  }
  /**
   * handles assign Kl2 validation for a PssIEEE4B
   *
   * @param command AssignKl2ToPssIEEE4BCommand
   */
  public void validate(AssignKl2ToPssIEEE4BCommand command) throws Exception {
    Assert.notNull(command, "AssignKl2ToPssIEEE4BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE4BId(), "AssignKl2ToPssIEEE4BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKl2ToPssIEEE4BCommand assignment should not be null");
  }

  /**
   * handles unassign Kl2 validation for a PssIEEE4B
   *
   * @param command UnAssignKl2FromPssIEEE4BCommand
   */
  public void validate(UnAssignKl2FromPssIEEE4BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKl2FromPssIEEE4BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE4BId(), "UnAssignKl2FromPssIEEE4BCommand identifier should not be null");
  }
  /**
   * handles assign Omeganh1 validation for a PssIEEE4B
   *
   * @param command AssignOmeganh1ToPssIEEE4BCommand
   */
  public void validate(AssignOmeganh1ToPssIEEE4BCommand command) throws Exception {
    Assert.notNull(command, "AssignOmeganh1ToPssIEEE4BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE4BId(), "AssignOmeganh1ToPssIEEE4BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignOmeganh1ToPssIEEE4BCommand assignment should not be null");
  }

  /**
   * handles unassign Omeganh1 validation for a PssIEEE4B
   *
   * @param command UnAssignOmeganh1FromPssIEEE4BCommand
   */
  public void validate(UnAssignOmeganh1FromPssIEEE4BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignOmeganh1FromPssIEEE4BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE4BId(),
        "UnAssignOmeganh1FromPssIEEE4BCommand identifier should not be null");
  }
  /**
   * handles assign Omeganh2 validation for a PssIEEE4B
   *
   * @param command AssignOmeganh2ToPssIEEE4BCommand
   */
  public void validate(AssignOmeganh2ToPssIEEE4BCommand command) throws Exception {
    Assert.notNull(command, "AssignOmeganh2ToPssIEEE4BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE4BId(), "AssignOmeganh2ToPssIEEE4BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignOmeganh2ToPssIEEE4BCommand assignment should not be null");
  }

  /**
   * handles unassign Omeganh2 validation for a PssIEEE4B
   *
   * @param command UnAssignOmeganh2FromPssIEEE4BCommand
   */
  public void validate(UnAssignOmeganh2FromPssIEEE4BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignOmeganh2FromPssIEEE4BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE4BId(),
        "UnAssignOmeganh2FromPssIEEE4BCommand identifier should not be null");
  }
  /**
   * handles assign Omeganl1 validation for a PssIEEE4B
   *
   * @param command AssignOmeganl1ToPssIEEE4BCommand
   */
  public void validate(AssignOmeganl1ToPssIEEE4BCommand command) throws Exception {
    Assert.notNull(command, "AssignOmeganl1ToPssIEEE4BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE4BId(), "AssignOmeganl1ToPssIEEE4BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignOmeganl1ToPssIEEE4BCommand assignment should not be null");
  }

  /**
   * handles unassign Omeganl1 validation for a PssIEEE4B
   *
   * @param command UnAssignOmeganl1FromPssIEEE4BCommand
   */
  public void validate(UnAssignOmeganl1FromPssIEEE4BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignOmeganl1FromPssIEEE4BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE4BId(),
        "UnAssignOmeganl1FromPssIEEE4BCommand identifier should not be null");
  }
  /**
   * handles assign Omeganl2 validation for a PssIEEE4B
   *
   * @param command AssignOmeganl2ToPssIEEE4BCommand
   */
  public void validate(AssignOmeganl2ToPssIEEE4BCommand command) throws Exception {
    Assert.notNull(command, "AssignOmeganl2ToPssIEEE4BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE4BId(), "AssignOmeganl2ToPssIEEE4BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignOmeganl2ToPssIEEE4BCommand assignment should not be null");
  }

  /**
   * handles unassign Omeganl2 validation for a PssIEEE4B
   *
   * @param command UnAssignOmeganl2FromPssIEEE4BCommand
   */
  public void validate(UnAssignOmeganl2FromPssIEEE4BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignOmeganl2FromPssIEEE4BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE4BId(),
        "UnAssignOmeganl2FromPssIEEE4BCommand identifier should not be null");
  }
  /**
   * handles assign Th1 validation for a PssIEEE4B
   *
   * @param command AssignTh1ToPssIEEE4BCommand
   */
  public void validate(AssignTh1ToPssIEEE4BCommand command) throws Exception {
    Assert.notNull(command, "AssignTh1ToPssIEEE4BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE4BId(), "AssignTh1ToPssIEEE4BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTh1ToPssIEEE4BCommand assignment should not be null");
  }

  /**
   * handles unassign Th1 validation for a PssIEEE4B
   *
   * @param command UnAssignTh1FromPssIEEE4BCommand
   */
  public void validate(UnAssignTh1FromPssIEEE4BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTh1FromPssIEEE4BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE4BId(), "UnAssignTh1FromPssIEEE4BCommand identifier should not be null");
  }
  /**
   * handles assign Th10 validation for a PssIEEE4B
   *
   * @param command AssignTh10ToPssIEEE4BCommand
   */
  public void validate(AssignTh10ToPssIEEE4BCommand command) throws Exception {
    Assert.notNull(command, "AssignTh10ToPssIEEE4BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE4BId(), "AssignTh10ToPssIEEE4BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTh10ToPssIEEE4BCommand assignment should not be null");
  }

  /**
   * handles unassign Th10 validation for a PssIEEE4B
   *
   * @param command UnAssignTh10FromPssIEEE4BCommand
   */
  public void validate(UnAssignTh10FromPssIEEE4BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTh10FromPssIEEE4BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE4BId(), "UnAssignTh10FromPssIEEE4BCommand identifier should not be null");
  }
  /**
   * handles assign Th11 validation for a PssIEEE4B
   *
   * @param command AssignTh11ToPssIEEE4BCommand
   */
  public void validate(AssignTh11ToPssIEEE4BCommand command) throws Exception {
    Assert.notNull(command, "AssignTh11ToPssIEEE4BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE4BId(), "AssignTh11ToPssIEEE4BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTh11ToPssIEEE4BCommand assignment should not be null");
  }

  /**
   * handles unassign Th11 validation for a PssIEEE4B
   *
   * @param command UnAssignTh11FromPssIEEE4BCommand
   */
  public void validate(UnAssignTh11FromPssIEEE4BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTh11FromPssIEEE4BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE4BId(), "UnAssignTh11FromPssIEEE4BCommand identifier should not be null");
  }
  /**
   * handles assign Th12 validation for a PssIEEE4B
   *
   * @param command AssignTh12ToPssIEEE4BCommand
   */
  public void validate(AssignTh12ToPssIEEE4BCommand command) throws Exception {
    Assert.notNull(command, "AssignTh12ToPssIEEE4BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE4BId(), "AssignTh12ToPssIEEE4BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTh12ToPssIEEE4BCommand assignment should not be null");
  }

  /**
   * handles unassign Th12 validation for a PssIEEE4B
   *
   * @param command UnAssignTh12FromPssIEEE4BCommand
   */
  public void validate(UnAssignTh12FromPssIEEE4BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTh12FromPssIEEE4BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE4BId(), "UnAssignTh12FromPssIEEE4BCommand identifier should not be null");
  }
  /**
   * handles assign Th2 validation for a PssIEEE4B
   *
   * @param command AssignTh2ToPssIEEE4BCommand
   */
  public void validate(AssignTh2ToPssIEEE4BCommand command) throws Exception {
    Assert.notNull(command, "AssignTh2ToPssIEEE4BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE4BId(), "AssignTh2ToPssIEEE4BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTh2ToPssIEEE4BCommand assignment should not be null");
  }

  /**
   * handles unassign Th2 validation for a PssIEEE4B
   *
   * @param command UnAssignTh2FromPssIEEE4BCommand
   */
  public void validate(UnAssignTh2FromPssIEEE4BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTh2FromPssIEEE4BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE4BId(), "UnAssignTh2FromPssIEEE4BCommand identifier should not be null");
  }
  /**
   * handles assign Th3 validation for a PssIEEE4B
   *
   * @param command AssignTh3ToPssIEEE4BCommand
   */
  public void validate(AssignTh3ToPssIEEE4BCommand command) throws Exception {
    Assert.notNull(command, "AssignTh3ToPssIEEE4BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE4BId(), "AssignTh3ToPssIEEE4BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTh3ToPssIEEE4BCommand assignment should not be null");
  }

  /**
   * handles unassign Th3 validation for a PssIEEE4B
   *
   * @param command UnAssignTh3FromPssIEEE4BCommand
   */
  public void validate(UnAssignTh3FromPssIEEE4BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTh3FromPssIEEE4BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE4BId(), "UnAssignTh3FromPssIEEE4BCommand identifier should not be null");
  }
  /**
   * handles assign Th4 validation for a PssIEEE4B
   *
   * @param command AssignTh4ToPssIEEE4BCommand
   */
  public void validate(AssignTh4ToPssIEEE4BCommand command) throws Exception {
    Assert.notNull(command, "AssignTh4ToPssIEEE4BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE4BId(), "AssignTh4ToPssIEEE4BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTh4ToPssIEEE4BCommand assignment should not be null");
  }

  /**
   * handles unassign Th4 validation for a PssIEEE4B
   *
   * @param command UnAssignTh4FromPssIEEE4BCommand
   */
  public void validate(UnAssignTh4FromPssIEEE4BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTh4FromPssIEEE4BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE4BId(), "UnAssignTh4FromPssIEEE4BCommand identifier should not be null");
  }
  /**
   * handles assign Th5 validation for a PssIEEE4B
   *
   * @param command AssignTh5ToPssIEEE4BCommand
   */
  public void validate(AssignTh5ToPssIEEE4BCommand command) throws Exception {
    Assert.notNull(command, "AssignTh5ToPssIEEE4BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE4BId(), "AssignTh5ToPssIEEE4BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTh5ToPssIEEE4BCommand assignment should not be null");
  }

  /**
   * handles unassign Th5 validation for a PssIEEE4B
   *
   * @param command UnAssignTh5FromPssIEEE4BCommand
   */
  public void validate(UnAssignTh5FromPssIEEE4BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTh5FromPssIEEE4BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE4BId(), "UnAssignTh5FromPssIEEE4BCommand identifier should not be null");
  }
  /**
   * handles assign Th6 validation for a PssIEEE4B
   *
   * @param command AssignTh6ToPssIEEE4BCommand
   */
  public void validate(AssignTh6ToPssIEEE4BCommand command) throws Exception {
    Assert.notNull(command, "AssignTh6ToPssIEEE4BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE4BId(), "AssignTh6ToPssIEEE4BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTh6ToPssIEEE4BCommand assignment should not be null");
  }

  /**
   * handles unassign Th6 validation for a PssIEEE4B
   *
   * @param command UnAssignTh6FromPssIEEE4BCommand
   */
  public void validate(UnAssignTh6FromPssIEEE4BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTh6FromPssIEEE4BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE4BId(), "UnAssignTh6FromPssIEEE4BCommand identifier should not be null");
  }
  /**
   * handles assign Th7 validation for a PssIEEE4B
   *
   * @param command AssignTh7ToPssIEEE4BCommand
   */
  public void validate(AssignTh7ToPssIEEE4BCommand command) throws Exception {
    Assert.notNull(command, "AssignTh7ToPssIEEE4BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE4BId(), "AssignTh7ToPssIEEE4BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTh7ToPssIEEE4BCommand assignment should not be null");
  }

  /**
   * handles unassign Th7 validation for a PssIEEE4B
   *
   * @param command UnAssignTh7FromPssIEEE4BCommand
   */
  public void validate(UnAssignTh7FromPssIEEE4BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTh7FromPssIEEE4BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE4BId(), "UnAssignTh7FromPssIEEE4BCommand identifier should not be null");
  }
  /**
   * handles assign Th8 validation for a PssIEEE4B
   *
   * @param command AssignTh8ToPssIEEE4BCommand
   */
  public void validate(AssignTh8ToPssIEEE4BCommand command) throws Exception {
    Assert.notNull(command, "AssignTh8ToPssIEEE4BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE4BId(), "AssignTh8ToPssIEEE4BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTh8ToPssIEEE4BCommand assignment should not be null");
  }

  /**
   * handles unassign Th8 validation for a PssIEEE4B
   *
   * @param command UnAssignTh8FromPssIEEE4BCommand
   */
  public void validate(UnAssignTh8FromPssIEEE4BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTh8FromPssIEEE4BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE4BId(), "UnAssignTh8FromPssIEEE4BCommand identifier should not be null");
  }
  /**
   * handles assign Th9 validation for a PssIEEE4B
   *
   * @param command AssignTh9ToPssIEEE4BCommand
   */
  public void validate(AssignTh9ToPssIEEE4BCommand command) throws Exception {
    Assert.notNull(command, "AssignTh9ToPssIEEE4BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE4BId(), "AssignTh9ToPssIEEE4BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTh9ToPssIEEE4BCommand assignment should not be null");
  }

  /**
   * handles unassign Th9 validation for a PssIEEE4B
   *
   * @param command UnAssignTh9FromPssIEEE4BCommand
   */
  public void validate(UnAssignTh9FromPssIEEE4BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTh9FromPssIEEE4BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE4BId(), "UnAssignTh9FromPssIEEE4BCommand identifier should not be null");
  }
  /**
   * handles assign Ti1 validation for a PssIEEE4B
   *
   * @param command AssignTi1ToPssIEEE4BCommand
   */
  public void validate(AssignTi1ToPssIEEE4BCommand command) throws Exception {
    Assert.notNull(command, "AssignTi1ToPssIEEE4BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE4BId(), "AssignTi1ToPssIEEE4BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTi1ToPssIEEE4BCommand assignment should not be null");
  }

  /**
   * handles unassign Ti1 validation for a PssIEEE4B
   *
   * @param command UnAssignTi1FromPssIEEE4BCommand
   */
  public void validate(UnAssignTi1FromPssIEEE4BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTi1FromPssIEEE4BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE4BId(), "UnAssignTi1FromPssIEEE4BCommand identifier should not be null");
  }
  /**
   * handles assign Ti10 validation for a PssIEEE4B
   *
   * @param command AssignTi10ToPssIEEE4BCommand
   */
  public void validate(AssignTi10ToPssIEEE4BCommand command) throws Exception {
    Assert.notNull(command, "AssignTi10ToPssIEEE4BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE4BId(), "AssignTi10ToPssIEEE4BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTi10ToPssIEEE4BCommand assignment should not be null");
  }

  /**
   * handles unassign Ti10 validation for a PssIEEE4B
   *
   * @param command UnAssignTi10FromPssIEEE4BCommand
   */
  public void validate(UnAssignTi10FromPssIEEE4BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTi10FromPssIEEE4BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE4BId(), "UnAssignTi10FromPssIEEE4BCommand identifier should not be null");
  }
  /**
   * handles assign Ti11 validation for a PssIEEE4B
   *
   * @param command AssignTi11ToPssIEEE4BCommand
   */
  public void validate(AssignTi11ToPssIEEE4BCommand command) throws Exception {
    Assert.notNull(command, "AssignTi11ToPssIEEE4BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE4BId(), "AssignTi11ToPssIEEE4BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTi11ToPssIEEE4BCommand assignment should not be null");
  }

  /**
   * handles unassign Ti11 validation for a PssIEEE4B
   *
   * @param command UnAssignTi11FromPssIEEE4BCommand
   */
  public void validate(UnAssignTi11FromPssIEEE4BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTi11FromPssIEEE4BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE4BId(), "UnAssignTi11FromPssIEEE4BCommand identifier should not be null");
  }
  /**
   * handles assign Ti12 validation for a PssIEEE4B
   *
   * @param command AssignTi12ToPssIEEE4BCommand
   */
  public void validate(AssignTi12ToPssIEEE4BCommand command) throws Exception {
    Assert.notNull(command, "AssignTi12ToPssIEEE4BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE4BId(), "AssignTi12ToPssIEEE4BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTi12ToPssIEEE4BCommand assignment should not be null");
  }

  /**
   * handles unassign Ti12 validation for a PssIEEE4B
   *
   * @param command UnAssignTi12FromPssIEEE4BCommand
   */
  public void validate(UnAssignTi12FromPssIEEE4BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTi12FromPssIEEE4BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE4BId(), "UnAssignTi12FromPssIEEE4BCommand identifier should not be null");
  }
  /**
   * handles assign Ti2 validation for a PssIEEE4B
   *
   * @param command AssignTi2ToPssIEEE4BCommand
   */
  public void validate(AssignTi2ToPssIEEE4BCommand command) throws Exception {
    Assert.notNull(command, "AssignTi2ToPssIEEE4BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE4BId(), "AssignTi2ToPssIEEE4BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTi2ToPssIEEE4BCommand assignment should not be null");
  }

  /**
   * handles unassign Ti2 validation for a PssIEEE4B
   *
   * @param command UnAssignTi2FromPssIEEE4BCommand
   */
  public void validate(UnAssignTi2FromPssIEEE4BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTi2FromPssIEEE4BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE4BId(), "UnAssignTi2FromPssIEEE4BCommand identifier should not be null");
  }
  /**
   * handles assign Ti3 validation for a PssIEEE4B
   *
   * @param command AssignTi3ToPssIEEE4BCommand
   */
  public void validate(AssignTi3ToPssIEEE4BCommand command) throws Exception {
    Assert.notNull(command, "AssignTi3ToPssIEEE4BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE4BId(), "AssignTi3ToPssIEEE4BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTi3ToPssIEEE4BCommand assignment should not be null");
  }

  /**
   * handles unassign Ti3 validation for a PssIEEE4B
   *
   * @param command UnAssignTi3FromPssIEEE4BCommand
   */
  public void validate(UnAssignTi3FromPssIEEE4BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTi3FromPssIEEE4BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE4BId(), "UnAssignTi3FromPssIEEE4BCommand identifier should not be null");
  }
  /**
   * handles assign Ti4 validation for a PssIEEE4B
   *
   * @param command AssignTi4ToPssIEEE4BCommand
   */
  public void validate(AssignTi4ToPssIEEE4BCommand command) throws Exception {
    Assert.notNull(command, "AssignTi4ToPssIEEE4BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE4BId(), "AssignTi4ToPssIEEE4BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTi4ToPssIEEE4BCommand assignment should not be null");
  }

  /**
   * handles unassign Ti4 validation for a PssIEEE4B
   *
   * @param command UnAssignTi4FromPssIEEE4BCommand
   */
  public void validate(UnAssignTi4FromPssIEEE4BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTi4FromPssIEEE4BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE4BId(), "UnAssignTi4FromPssIEEE4BCommand identifier should not be null");
  }
  /**
   * handles assign Ti5 validation for a PssIEEE4B
   *
   * @param command AssignTi5ToPssIEEE4BCommand
   */
  public void validate(AssignTi5ToPssIEEE4BCommand command) throws Exception {
    Assert.notNull(command, "AssignTi5ToPssIEEE4BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE4BId(), "AssignTi5ToPssIEEE4BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTi5ToPssIEEE4BCommand assignment should not be null");
  }

  /**
   * handles unassign Ti5 validation for a PssIEEE4B
   *
   * @param command UnAssignTi5FromPssIEEE4BCommand
   */
  public void validate(UnAssignTi5FromPssIEEE4BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTi5FromPssIEEE4BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE4BId(), "UnAssignTi5FromPssIEEE4BCommand identifier should not be null");
  }
  /**
   * handles assign Ti6 validation for a PssIEEE4B
   *
   * @param command AssignTi6ToPssIEEE4BCommand
   */
  public void validate(AssignTi6ToPssIEEE4BCommand command) throws Exception {
    Assert.notNull(command, "AssignTi6ToPssIEEE4BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE4BId(), "AssignTi6ToPssIEEE4BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTi6ToPssIEEE4BCommand assignment should not be null");
  }

  /**
   * handles unassign Ti6 validation for a PssIEEE4B
   *
   * @param command UnAssignTi6FromPssIEEE4BCommand
   */
  public void validate(UnAssignTi6FromPssIEEE4BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTi6FromPssIEEE4BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE4BId(), "UnAssignTi6FromPssIEEE4BCommand identifier should not be null");
  }
  /**
   * handles assign Ti7 validation for a PssIEEE4B
   *
   * @param command AssignTi7ToPssIEEE4BCommand
   */
  public void validate(AssignTi7ToPssIEEE4BCommand command) throws Exception {
    Assert.notNull(command, "AssignTi7ToPssIEEE4BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE4BId(), "AssignTi7ToPssIEEE4BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTi7ToPssIEEE4BCommand assignment should not be null");
  }

  /**
   * handles unassign Ti7 validation for a PssIEEE4B
   *
   * @param command UnAssignTi7FromPssIEEE4BCommand
   */
  public void validate(UnAssignTi7FromPssIEEE4BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTi7FromPssIEEE4BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE4BId(), "UnAssignTi7FromPssIEEE4BCommand identifier should not be null");
  }
  /**
   * handles assign Ti8 validation for a PssIEEE4B
   *
   * @param command AssignTi8ToPssIEEE4BCommand
   */
  public void validate(AssignTi8ToPssIEEE4BCommand command) throws Exception {
    Assert.notNull(command, "AssignTi8ToPssIEEE4BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE4BId(), "AssignTi8ToPssIEEE4BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTi8ToPssIEEE4BCommand assignment should not be null");
  }

  /**
   * handles unassign Ti8 validation for a PssIEEE4B
   *
   * @param command UnAssignTi8FromPssIEEE4BCommand
   */
  public void validate(UnAssignTi8FromPssIEEE4BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTi8FromPssIEEE4BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE4BId(), "UnAssignTi8FromPssIEEE4BCommand identifier should not be null");
  }
  /**
   * handles assign Ti9 validation for a PssIEEE4B
   *
   * @param command AssignTi9ToPssIEEE4BCommand
   */
  public void validate(AssignTi9ToPssIEEE4BCommand command) throws Exception {
    Assert.notNull(command, "AssignTi9ToPssIEEE4BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE4BId(), "AssignTi9ToPssIEEE4BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTi9ToPssIEEE4BCommand assignment should not be null");
  }

  /**
   * handles unassign Ti9 validation for a PssIEEE4B
   *
   * @param command UnAssignTi9FromPssIEEE4BCommand
   */
  public void validate(UnAssignTi9FromPssIEEE4BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTi9FromPssIEEE4BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE4BId(), "UnAssignTi9FromPssIEEE4BCommand identifier should not be null");
  }
  /**
   * handles assign Tl1 validation for a PssIEEE4B
   *
   * @param command AssignTl1ToPssIEEE4BCommand
   */
  public void validate(AssignTl1ToPssIEEE4BCommand command) throws Exception {
    Assert.notNull(command, "AssignTl1ToPssIEEE4BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE4BId(), "AssignTl1ToPssIEEE4BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTl1ToPssIEEE4BCommand assignment should not be null");
  }

  /**
   * handles unassign Tl1 validation for a PssIEEE4B
   *
   * @param command UnAssignTl1FromPssIEEE4BCommand
   */
  public void validate(UnAssignTl1FromPssIEEE4BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTl1FromPssIEEE4BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE4BId(), "UnAssignTl1FromPssIEEE4BCommand identifier should not be null");
  }
  /**
   * handles assign Tl10 validation for a PssIEEE4B
   *
   * @param command AssignTl10ToPssIEEE4BCommand
   */
  public void validate(AssignTl10ToPssIEEE4BCommand command) throws Exception {
    Assert.notNull(command, "AssignTl10ToPssIEEE4BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE4BId(), "AssignTl10ToPssIEEE4BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTl10ToPssIEEE4BCommand assignment should not be null");
  }

  /**
   * handles unassign Tl10 validation for a PssIEEE4B
   *
   * @param command UnAssignTl10FromPssIEEE4BCommand
   */
  public void validate(UnAssignTl10FromPssIEEE4BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTl10FromPssIEEE4BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE4BId(), "UnAssignTl10FromPssIEEE4BCommand identifier should not be null");
  }
  /**
   * handles assign Tl11 validation for a PssIEEE4B
   *
   * @param command AssignTl11ToPssIEEE4BCommand
   */
  public void validate(AssignTl11ToPssIEEE4BCommand command) throws Exception {
    Assert.notNull(command, "AssignTl11ToPssIEEE4BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE4BId(), "AssignTl11ToPssIEEE4BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTl11ToPssIEEE4BCommand assignment should not be null");
  }

  /**
   * handles unassign Tl11 validation for a PssIEEE4B
   *
   * @param command UnAssignTl11FromPssIEEE4BCommand
   */
  public void validate(UnAssignTl11FromPssIEEE4BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTl11FromPssIEEE4BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE4BId(), "UnAssignTl11FromPssIEEE4BCommand identifier should not be null");
  }
  /**
   * handles assign Tl12 validation for a PssIEEE4B
   *
   * @param command AssignTl12ToPssIEEE4BCommand
   */
  public void validate(AssignTl12ToPssIEEE4BCommand command) throws Exception {
    Assert.notNull(command, "AssignTl12ToPssIEEE4BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE4BId(), "AssignTl12ToPssIEEE4BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTl12ToPssIEEE4BCommand assignment should not be null");
  }

  /**
   * handles unassign Tl12 validation for a PssIEEE4B
   *
   * @param command UnAssignTl12FromPssIEEE4BCommand
   */
  public void validate(UnAssignTl12FromPssIEEE4BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTl12FromPssIEEE4BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE4BId(), "UnAssignTl12FromPssIEEE4BCommand identifier should not be null");
  }
  /**
   * handles assign Tl2 validation for a PssIEEE4B
   *
   * @param command AssignTl2ToPssIEEE4BCommand
   */
  public void validate(AssignTl2ToPssIEEE4BCommand command) throws Exception {
    Assert.notNull(command, "AssignTl2ToPssIEEE4BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE4BId(), "AssignTl2ToPssIEEE4BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTl2ToPssIEEE4BCommand assignment should not be null");
  }

  /**
   * handles unassign Tl2 validation for a PssIEEE4B
   *
   * @param command UnAssignTl2FromPssIEEE4BCommand
   */
  public void validate(UnAssignTl2FromPssIEEE4BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTl2FromPssIEEE4BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE4BId(), "UnAssignTl2FromPssIEEE4BCommand identifier should not be null");
  }
  /**
   * handles assign Tl3 validation for a PssIEEE4B
   *
   * @param command AssignTl3ToPssIEEE4BCommand
   */
  public void validate(AssignTl3ToPssIEEE4BCommand command) throws Exception {
    Assert.notNull(command, "AssignTl3ToPssIEEE4BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE4BId(), "AssignTl3ToPssIEEE4BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTl3ToPssIEEE4BCommand assignment should not be null");
  }

  /**
   * handles unassign Tl3 validation for a PssIEEE4B
   *
   * @param command UnAssignTl3FromPssIEEE4BCommand
   */
  public void validate(UnAssignTl3FromPssIEEE4BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTl3FromPssIEEE4BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE4BId(), "UnAssignTl3FromPssIEEE4BCommand identifier should not be null");
  }
  /**
   * handles assign Tl4 validation for a PssIEEE4B
   *
   * @param command AssignTl4ToPssIEEE4BCommand
   */
  public void validate(AssignTl4ToPssIEEE4BCommand command) throws Exception {
    Assert.notNull(command, "AssignTl4ToPssIEEE4BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE4BId(), "AssignTl4ToPssIEEE4BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTl4ToPssIEEE4BCommand assignment should not be null");
  }

  /**
   * handles unassign Tl4 validation for a PssIEEE4B
   *
   * @param command UnAssignTl4FromPssIEEE4BCommand
   */
  public void validate(UnAssignTl4FromPssIEEE4BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTl4FromPssIEEE4BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE4BId(), "UnAssignTl4FromPssIEEE4BCommand identifier should not be null");
  }
  /**
   * handles assign Tl5 validation for a PssIEEE4B
   *
   * @param command AssignTl5ToPssIEEE4BCommand
   */
  public void validate(AssignTl5ToPssIEEE4BCommand command) throws Exception {
    Assert.notNull(command, "AssignTl5ToPssIEEE4BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE4BId(), "AssignTl5ToPssIEEE4BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTl5ToPssIEEE4BCommand assignment should not be null");
  }

  /**
   * handles unassign Tl5 validation for a PssIEEE4B
   *
   * @param command UnAssignTl5FromPssIEEE4BCommand
   */
  public void validate(UnAssignTl5FromPssIEEE4BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTl5FromPssIEEE4BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE4BId(), "UnAssignTl5FromPssIEEE4BCommand identifier should not be null");
  }
  /**
   * handles assign Tl6 validation for a PssIEEE4B
   *
   * @param command AssignTl6ToPssIEEE4BCommand
   */
  public void validate(AssignTl6ToPssIEEE4BCommand command) throws Exception {
    Assert.notNull(command, "AssignTl6ToPssIEEE4BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE4BId(), "AssignTl6ToPssIEEE4BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTl6ToPssIEEE4BCommand assignment should not be null");
  }

  /**
   * handles unassign Tl6 validation for a PssIEEE4B
   *
   * @param command UnAssignTl6FromPssIEEE4BCommand
   */
  public void validate(UnAssignTl6FromPssIEEE4BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTl6FromPssIEEE4BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE4BId(), "UnAssignTl6FromPssIEEE4BCommand identifier should not be null");
  }
  /**
   * handles assign Tl7 validation for a PssIEEE4B
   *
   * @param command AssignTl7ToPssIEEE4BCommand
   */
  public void validate(AssignTl7ToPssIEEE4BCommand command) throws Exception {
    Assert.notNull(command, "AssignTl7ToPssIEEE4BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE4BId(), "AssignTl7ToPssIEEE4BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTl7ToPssIEEE4BCommand assignment should not be null");
  }

  /**
   * handles unassign Tl7 validation for a PssIEEE4B
   *
   * @param command UnAssignTl7FromPssIEEE4BCommand
   */
  public void validate(UnAssignTl7FromPssIEEE4BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTl7FromPssIEEE4BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE4BId(), "UnAssignTl7FromPssIEEE4BCommand identifier should not be null");
  }
  /**
   * handles assign Tl8 validation for a PssIEEE4B
   *
   * @param command AssignTl8ToPssIEEE4BCommand
   */
  public void validate(AssignTl8ToPssIEEE4BCommand command) throws Exception {
    Assert.notNull(command, "AssignTl8ToPssIEEE4BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE4BId(), "AssignTl8ToPssIEEE4BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTl8ToPssIEEE4BCommand assignment should not be null");
  }

  /**
   * handles unassign Tl8 validation for a PssIEEE4B
   *
   * @param command UnAssignTl8FromPssIEEE4BCommand
   */
  public void validate(UnAssignTl8FromPssIEEE4BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTl8FromPssIEEE4BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE4BId(), "UnAssignTl8FromPssIEEE4BCommand identifier should not be null");
  }
  /**
   * handles assign Tl9 validation for a PssIEEE4B
   *
   * @param command AssignTl9ToPssIEEE4BCommand
   */
  public void validate(AssignTl9ToPssIEEE4BCommand command) throws Exception {
    Assert.notNull(command, "AssignTl9ToPssIEEE4BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE4BId(), "AssignTl9ToPssIEEE4BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTl9ToPssIEEE4BCommand assignment should not be null");
  }

  /**
   * handles unassign Tl9 validation for a PssIEEE4B
   *
   * @param command UnAssignTl9FromPssIEEE4BCommand
   */
  public void validate(UnAssignTl9FromPssIEEE4BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTl9FromPssIEEE4BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE4BId(), "UnAssignTl9FromPssIEEE4BCommand identifier should not be null");
  }
  /**
   * handles assign Vhmax validation for a PssIEEE4B
   *
   * @param command AssignVhmaxToPssIEEE4BCommand
   */
  public void validate(AssignVhmaxToPssIEEE4BCommand command) throws Exception {
    Assert.notNull(command, "AssignVhmaxToPssIEEE4BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE4BId(), "AssignVhmaxToPssIEEE4BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVhmaxToPssIEEE4BCommand assignment should not be null");
  }

  /**
   * handles unassign Vhmax validation for a PssIEEE4B
   *
   * @param command UnAssignVhmaxFromPssIEEE4BCommand
   */
  public void validate(UnAssignVhmaxFromPssIEEE4BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignVhmaxFromPssIEEE4BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE4BId(),
        "UnAssignVhmaxFromPssIEEE4BCommand identifier should not be null");
  }
  /**
   * handles assign Vhmin validation for a PssIEEE4B
   *
   * @param command AssignVhminToPssIEEE4BCommand
   */
  public void validate(AssignVhminToPssIEEE4BCommand command) throws Exception {
    Assert.notNull(command, "AssignVhminToPssIEEE4BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE4BId(), "AssignVhminToPssIEEE4BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVhminToPssIEEE4BCommand assignment should not be null");
  }

  /**
   * handles unassign Vhmin validation for a PssIEEE4B
   *
   * @param command UnAssignVhminFromPssIEEE4BCommand
   */
  public void validate(UnAssignVhminFromPssIEEE4BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignVhminFromPssIEEE4BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE4BId(),
        "UnAssignVhminFromPssIEEE4BCommand identifier should not be null");
  }
  /**
   * handles assign Vimax validation for a PssIEEE4B
   *
   * @param command AssignVimaxToPssIEEE4BCommand
   */
  public void validate(AssignVimaxToPssIEEE4BCommand command) throws Exception {
    Assert.notNull(command, "AssignVimaxToPssIEEE4BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE4BId(), "AssignVimaxToPssIEEE4BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVimaxToPssIEEE4BCommand assignment should not be null");
  }

  /**
   * handles unassign Vimax validation for a PssIEEE4B
   *
   * @param command UnAssignVimaxFromPssIEEE4BCommand
   */
  public void validate(UnAssignVimaxFromPssIEEE4BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignVimaxFromPssIEEE4BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE4BId(),
        "UnAssignVimaxFromPssIEEE4BCommand identifier should not be null");
  }
  /**
   * handles assign Vimin validation for a PssIEEE4B
   *
   * @param command AssignViminToPssIEEE4BCommand
   */
  public void validate(AssignViminToPssIEEE4BCommand command) throws Exception {
    Assert.notNull(command, "AssignViminToPssIEEE4BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE4BId(), "AssignViminToPssIEEE4BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignViminToPssIEEE4BCommand assignment should not be null");
  }

  /**
   * handles unassign Vimin validation for a PssIEEE4B
   *
   * @param command UnAssignViminFromPssIEEE4BCommand
   */
  public void validate(UnAssignViminFromPssIEEE4BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignViminFromPssIEEE4BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE4BId(),
        "UnAssignViminFromPssIEEE4BCommand identifier should not be null");
  }
  /**
   * handles assign Vlmax validation for a PssIEEE4B
   *
   * @param command AssignVlmaxToPssIEEE4BCommand
   */
  public void validate(AssignVlmaxToPssIEEE4BCommand command) throws Exception {
    Assert.notNull(command, "AssignVlmaxToPssIEEE4BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE4BId(), "AssignVlmaxToPssIEEE4BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVlmaxToPssIEEE4BCommand assignment should not be null");
  }

  /**
   * handles unassign Vlmax validation for a PssIEEE4B
   *
   * @param command UnAssignVlmaxFromPssIEEE4BCommand
   */
  public void validate(UnAssignVlmaxFromPssIEEE4BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignVlmaxFromPssIEEE4BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE4BId(),
        "UnAssignVlmaxFromPssIEEE4BCommand identifier should not be null");
  }
  /**
   * handles assign Vlmin validation for a PssIEEE4B
   *
   * @param command AssignVlminToPssIEEE4BCommand
   */
  public void validate(AssignVlminToPssIEEE4BCommand command) throws Exception {
    Assert.notNull(command, "AssignVlminToPssIEEE4BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE4BId(), "AssignVlminToPssIEEE4BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVlminToPssIEEE4BCommand assignment should not be null");
  }

  /**
   * handles unassign Vlmin validation for a PssIEEE4B
   *
   * @param command UnAssignVlminFromPssIEEE4BCommand
   */
  public void validate(UnAssignVlminFromPssIEEE4BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignVlminFromPssIEEE4BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE4BId(),
        "UnAssignVlminFromPssIEEE4BCommand identifier should not be null");
  }
  /**
   * handles assign Vstmax validation for a PssIEEE4B
   *
   * @param command AssignVstmaxToPssIEEE4BCommand
   */
  public void validate(AssignVstmaxToPssIEEE4BCommand command) throws Exception {
    Assert.notNull(command, "AssignVstmaxToPssIEEE4BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE4BId(), "AssignVstmaxToPssIEEE4BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVstmaxToPssIEEE4BCommand assignment should not be null");
  }

  /**
   * handles unassign Vstmax validation for a PssIEEE4B
   *
   * @param command UnAssignVstmaxFromPssIEEE4BCommand
   */
  public void validate(UnAssignVstmaxFromPssIEEE4BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignVstmaxFromPssIEEE4BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE4BId(),
        "UnAssignVstmaxFromPssIEEE4BCommand identifier should not be null");
  }
  /**
   * handles assign Vstmin validation for a PssIEEE4B
   *
   * @param command AssignVstminToPssIEEE4BCommand
   */
  public void validate(AssignVstminToPssIEEE4BCommand command) throws Exception {
    Assert.notNull(command, "AssignVstminToPssIEEE4BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE4BId(), "AssignVstminToPssIEEE4BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVstminToPssIEEE4BCommand assignment should not be null");
  }

  /**
   * handles unassign Vstmin validation for a PssIEEE4B
   *
   * @param command UnAssignVstminFromPssIEEE4BCommand
   */
  public void validate(UnAssignVstminFromPssIEEE4BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignVstminFromPssIEEE4BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE4BId(),
        "UnAssignVstminFromPssIEEE4BCommand identifier should not be null");
  }
}
