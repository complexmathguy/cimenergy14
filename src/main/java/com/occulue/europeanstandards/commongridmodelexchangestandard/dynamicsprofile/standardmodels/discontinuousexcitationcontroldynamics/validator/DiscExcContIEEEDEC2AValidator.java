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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.discontinuousexcitationcontroldynamics.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class DiscExcContIEEEDEC2AValidator {

  /** default constructor */
  protected DiscExcContIEEEDEC2AValidator() {}

  /** factory method */
  public static DiscExcContIEEEDEC2AValidator getInstance() {
    return new DiscExcContIEEEDEC2AValidator();
  }

  /** handles creation validation for a DiscExcContIEEEDEC2A */
  public void validate(CreateDiscExcContIEEEDEC2ACommand discExcContIEEEDEC2A) throws Exception {
    Assert.notNull(discExcContIEEEDEC2A, "CreateDiscExcContIEEEDEC2ACommand should not be null");
    //		Assert.isNull( discExcContIEEEDEC2A.getDiscExcContIEEEDEC2AId(),
    // "CreateDiscExcContIEEEDEC2ACommand identifier should be null" );
  }

  /** handles update validation for a DiscExcContIEEEDEC2A */
  public void validate(UpdateDiscExcContIEEEDEC2ACommand discExcContIEEEDEC2A) throws Exception {
    Assert.notNull(discExcContIEEEDEC2A, "UpdateDiscExcContIEEEDEC2ACommand should not be null");
    Assert.notNull(
        discExcContIEEEDEC2A.getDiscExcContIEEEDEC2AId(),
        "UpdateDiscExcContIEEEDEC2ACommand identifier should not be null");
  }

  /** handles delete validation for a DiscExcContIEEEDEC2A */
  public void validate(DeleteDiscExcContIEEEDEC2ACommand discExcContIEEEDEC2A) throws Exception {
    Assert.notNull(discExcContIEEEDEC2A, "{commandAlias} should not be null");
    Assert.notNull(
        discExcContIEEEDEC2A.getDiscExcContIEEEDEC2AId(),
        "DeleteDiscExcContIEEEDEC2ACommand identifier should not be null");
  }

  /** handles fetchOne validation for a DiscExcContIEEEDEC2A */
  public void validate(DiscExcContIEEEDEC2AFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "DiscExcContIEEEDEC2AFetchOneSummary should not be null");
    Assert.notNull(
        summary.getDiscExcContIEEEDEC2AId(),
        "DiscExcContIEEEDEC2AFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Td1 validation for a DiscExcContIEEEDEC2A
   *
   * @param command AssignTd1ToDiscExcContIEEEDEC2ACommand
   */
  public void validate(AssignTd1ToDiscExcContIEEEDEC2ACommand command) throws Exception {
    Assert.notNull(command, "AssignTd1ToDiscExcContIEEEDEC2ACommand should not be null");
    Assert.notNull(
        command.getDiscExcContIEEEDEC2AId(),
        "AssignTd1ToDiscExcContIEEEDEC2ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignTd1ToDiscExcContIEEEDEC2ACommand assignment should not be null");
  }

  /**
   * handles unassign Td1 validation for a DiscExcContIEEEDEC2A
   *
   * @param command UnAssignTd1FromDiscExcContIEEEDEC2ACommand
   */
  public void validate(UnAssignTd1FromDiscExcContIEEEDEC2ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignTd1FromDiscExcContIEEEDEC2ACommand should not be null");
    Assert.notNull(
        command.getDiscExcContIEEEDEC2AId(),
        "UnAssignTd1FromDiscExcContIEEEDEC2ACommand identifier should not be null");
  }
  /**
   * handles assign Td2 validation for a DiscExcContIEEEDEC2A
   *
   * @param command AssignTd2ToDiscExcContIEEEDEC2ACommand
   */
  public void validate(AssignTd2ToDiscExcContIEEEDEC2ACommand command) throws Exception {
    Assert.notNull(command, "AssignTd2ToDiscExcContIEEEDEC2ACommand should not be null");
    Assert.notNull(
        command.getDiscExcContIEEEDEC2AId(),
        "AssignTd2ToDiscExcContIEEEDEC2ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignTd2ToDiscExcContIEEEDEC2ACommand assignment should not be null");
  }

  /**
   * handles unassign Td2 validation for a DiscExcContIEEEDEC2A
   *
   * @param command UnAssignTd2FromDiscExcContIEEEDEC2ACommand
   */
  public void validate(UnAssignTd2FromDiscExcContIEEEDEC2ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignTd2FromDiscExcContIEEEDEC2ACommand should not be null");
    Assert.notNull(
        command.getDiscExcContIEEEDEC2AId(),
        "UnAssignTd2FromDiscExcContIEEEDEC2ACommand identifier should not be null");
  }
  /**
   * handles assign Vdmax validation for a DiscExcContIEEEDEC2A
   *
   * @param command AssignVdmaxToDiscExcContIEEEDEC2ACommand
   */
  public void validate(AssignVdmaxToDiscExcContIEEEDEC2ACommand command) throws Exception {
    Assert.notNull(command, "AssignVdmaxToDiscExcContIEEEDEC2ACommand should not be null");
    Assert.notNull(
        command.getDiscExcContIEEEDEC2AId(),
        "AssignVdmaxToDiscExcContIEEEDEC2ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignVdmaxToDiscExcContIEEEDEC2ACommand assignment should not be null");
  }

  /**
   * handles unassign Vdmax validation for a DiscExcContIEEEDEC2A
   *
   * @param command UnAssignVdmaxFromDiscExcContIEEEDEC2ACommand
   */
  public void validate(UnAssignVdmaxFromDiscExcContIEEEDEC2ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignVdmaxFromDiscExcContIEEEDEC2ACommand should not be null");
    Assert.notNull(
        command.getDiscExcContIEEEDEC2AId(),
        "UnAssignVdmaxFromDiscExcContIEEEDEC2ACommand identifier should not be null");
  }
  /**
   * handles assign Vdmin validation for a DiscExcContIEEEDEC2A
   *
   * @param command AssignVdminToDiscExcContIEEEDEC2ACommand
   */
  public void validate(AssignVdminToDiscExcContIEEEDEC2ACommand command) throws Exception {
    Assert.notNull(command, "AssignVdminToDiscExcContIEEEDEC2ACommand should not be null");
    Assert.notNull(
        command.getDiscExcContIEEEDEC2AId(),
        "AssignVdminToDiscExcContIEEEDEC2ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignVdminToDiscExcContIEEEDEC2ACommand assignment should not be null");
  }

  /**
   * handles unassign Vdmin validation for a DiscExcContIEEEDEC2A
   *
   * @param command UnAssignVdminFromDiscExcContIEEEDEC2ACommand
   */
  public void validate(UnAssignVdminFromDiscExcContIEEEDEC2ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignVdminFromDiscExcContIEEEDEC2ACommand should not be null");
    Assert.notNull(
        command.getDiscExcContIEEEDEC2AId(),
        "UnAssignVdminFromDiscExcContIEEEDEC2ACommand identifier should not be null");
  }
  /**
   * handles assign Vk validation for a DiscExcContIEEEDEC2A
   *
   * @param command AssignVkToDiscExcContIEEEDEC2ACommand
   */
  public void validate(AssignVkToDiscExcContIEEEDEC2ACommand command) throws Exception {
    Assert.notNull(command, "AssignVkToDiscExcContIEEEDEC2ACommand should not be null");
    Assert.notNull(
        command.getDiscExcContIEEEDEC2AId(),
        "AssignVkToDiscExcContIEEEDEC2ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignVkToDiscExcContIEEEDEC2ACommand assignment should not be null");
  }

  /**
   * handles unassign Vk validation for a DiscExcContIEEEDEC2A
   *
   * @param command UnAssignVkFromDiscExcContIEEEDEC2ACommand
   */
  public void validate(UnAssignVkFromDiscExcContIEEEDEC2ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignVkFromDiscExcContIEEEDEC2ACommand should not be null");
    Assert.notNull(
        command.getDiscExcContIEEEDEC2AId(),
        "UnAssignVkFromDiscExcContIEEEDEC2ACommand identifier should not be null");
  }
}
