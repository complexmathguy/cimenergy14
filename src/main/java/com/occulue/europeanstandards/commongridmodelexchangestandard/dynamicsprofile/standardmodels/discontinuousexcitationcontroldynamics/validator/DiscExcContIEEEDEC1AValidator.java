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

public class DiscExcContIEEEDEC1AValidator {

  /** default constructor */
  protected DiscExcContIEEEDEC1AValidator() {}

  /** factory method */
  public static DiscExcContIEEEDEC1AValidator getInstance() {
    return new DiscExcContIEEEDEC1AValidator();
  }

  /** handles creation validation for a DiscExcContIEEEDEC1A */
  public void validate(CreateDiscExcContIEEEDEC1ACommand discExcContIEEEDEC1A) throws Exception {
    Assert.notNull(discExcContIEEEDEC1A, "CreateDiscExcContIEEEDEC1ACommand should not be null");
    //		Assert.isNull( discExcContIEEEDEC1A.getDiscExcContIEEEDEC1AId(),
    // "CreateDiscExcContIEEEDEC1ACommand identifier should be null" );
  }

  /** handles update validation for a DiscExcContIEEEDEC1A */
  public void validate(UpdateDiscExcContIEEEDEC1ACommand discExcContIEEEDEC1A) throws Exception {
    Assert.notNull(discExcContIEEEDEC1A, "UpdateDiscExcContIEEEDEC1ACommand should not be null");
    Assert.notNull(
        discExcContIEEEDEC1A.getDiscExcContIEEEDEC1AId(),
        "UpdateDiscExcContIEEEDEC1ACommand identifier should not be null");
  }

  /** handles delete validation for a DiscExcContIEEEDEC1A */
  public void validate(DeleteDiscExcContIEEEDEC1ACommand discExcContIEEEDEC1A) throws Exception {
    Assert.notNull(discExcContIEEEDEC1A, "{commandAlias} should not be null");
    Assert.notNull(
        discExcContIEEEDEC1A.getDiscExcContIEEEDEC1AId(),
        "DeleteDiscExcContIEEEDEC1ACommand identifier should not be null");
  }

  /** handles fetchOne validation for a DiscExcContIEEEDEC1A */
  public void validate(DiscExcContIEEEDEC1AFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "DiscExcContIEEEDEC1AFetchOneSummary should not be null");
    Assert.notNull(
        summary.getDiscExcContIEEEDEC1AId(),
        "DiscExcContIEEEDEC1AFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Esc validation for a DiscExcContIEEEDEC1A
   *
   * @param command AssignEscToDiscExcContIEEEDEC1ACommand
   */
  public void validate(AssignEscToDiscExcContIEEEDEC1ACommand command) throws Exception {
    Assert.notNull(command, "AssignEscToDiscExcContIEEEDEC1ACommand should not be null");
    Assert.notNull(
        command.getDiscExcContIEEEDEC1AId(),
        "AssignEscToDiscExcContIEEEDEC1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignEscToDiscExcContIEEEDEC1ACommand assignment should not be null");
  }

  /**
   * handles unassign Esc validation for a DiscExcContIEEEDEC1A
   *
   * @param command UnAssignEscFromDiscExcContIEEEDEC1ACommand
   */
  public void validate(UnAssignEscFromDiscExcContIEEEDEC1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignEscFromDiscExcContIEEEDEC1ACommand should not be null");
    Assert.notNull(
        command.getDiscExcContIEEEDEC1AId(),
        "UnAssignEscFromDiscExcContIEEEDEC1ACommand identifier should not be null");
  }
  /**
   * handles assign Kan validation for a DiscExcContIEEEDEC1A
   *
   * @param command AssignKanToDiscExcContIEEEDEC1ACommand
   */
  public void validate(AssignKanToDiscExcContIEEEDEC1ACommand command) throws Exception {
    Assert.notNull(command, "AssignKanToDiscExcContIEEEDEC1ACommand should not be null");
    Assert.notNull(
        command.getDiscExcContIEEEDEC1AId(),
        "AssignKanToDiscExcContIEEEDEC1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignKanToDiscExcContIEEEDEC1ACommand assignment should not be null");
  }

  /**
   * handles unassign Kan validation for a DiscExcContIEEEDEC1A
   *
   * @param command UnAssignKanFromDiscExcContIEEEDEC1ACommand
   */
  public void validate(UnAssignKanFromDiscExcContIEEEDEC1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignKanFromDiscExcContIEEEDEC1ACommand should not be null");
    Assert.notNull(
        command.getDiscExcContIEEEDEC1AId(),
        "UnAssignKanFromDiscExcContIEEEDEC1ACommand identifier should not be null");
  }
  /**
   * handles assign Ketl validation for a DiscExcContIEEEDEC1A
   *
   * @param command AssignKetlToDiscExcContIEEEDEC1ACommand
   */
  public void validate(AssignKetlToDiscExcContIEEEDEC1ACommand command) throws Exception {
    Assert.notNull(command, "AssignKetlToDiscExcContIEEEDEC1ACommand should not be null");
    Assert.notNull(
        command.getDiscExcContIEEEDEC1AId(),
        "AssignKetlToDiscExcContIEEEDEC1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignKetlToDiscExcContIEEEDEC1ACommand assignment should not be null");
  }

  /**
   * handles unassign Ketl validation for a DiscExcContIEEEDEC1A
   *
   * @param command UnAssignKetlFromDiscExcContIEEEDEC1ACommand
   */
  public void validate(UnAssignKetlFromDiscExcContIEEEDEC1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignKetlFromDiscExcContIEEEDEC1ACommand should not be null");
    Assert.notNull(
        command.getDiscExcContIEEEDEC1AId(),
        "UnAssignKetlFromDiscExcContIEEEDEC1ACommand identifier should not be null");
  }
  /**
   * handles assign Tan validation for a DiscExcContIEEEDEC1A
   *
   * @param command AssignTanToDiscExcContIEEEDEC1ACommand
   */
  public void validate(AssignTanToDiscExcContIEEEDEC1ACommand command) throws Exception {
    Assert.notNull(command, "AssignTanToDiscExcContIEEEDEC1ACommand should not be null");
    Assert.notNull(
        command.getDiscExcContIEEEDEC1AId(),
        "AssignTanToDiscExcContIEEEDEC1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignTanToDiscExcContIEEEDEC1ACommand assignment should not be null");
  }

  /**
   * handles unassign Tan validation for a DiscExcContIEEEDEC1A
   *
   * @param command UnAssignTanFromDiscExcContIEEEDEC1ACommand
   */
  public void validate(UnAssignTanFromDiscExcContIEEEDEC1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignTanFromDiscExcContIEEEDEC1ACommand should not be null");
    Assert.notNull(
        command.getDiscExcContIEEEDEC1AId(),
        "UnAssignTanFromDiscExcContIEEEDEC1ACommand identifier should not be null");
  }
  /**
   * handles assign Td validation for a DiscExcContIEEEDEC1A
   *
   * @param command AssignTdToDiscExcContIEEEDEC1ACommand
   */
  public void validate(AssignTdToDiscExcContIEEEDEC1ACommand command) throws Exception {
    Assert.notNull(command, "AssignTdToDiscExcContIEEEDEC1ACommand should not be null");
    Assert.notNull(
        command.getDiscExcContIEEEDEC1AId(),
        "AssignTdToDiscExcContIEEEDEC1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignTdToDiscExcContIEEEDEC1ACommand assignment should not be null");
  }

  /**
   * handles unassign Td validation for a DiscExcContIEEEDEC1A
   *
   * @param command UnAssignTdFromDiscExcContIEEEDEC1ACommand
   */
  public void validate(UnAssignTdFromDiscExcContIEEEDEC1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignTdFromDiscExcContIEEEDEC1ACommand should not be null");
    Assert.notNull(
        command.getDiscExcContIEEEDEC1AId(),
        "UnAssignTdFromDiscExcContIEEEDEC1ACommand identifier should not be null");
  }
  /**
   * handles assign Tl1 validation for a DiscExcContIEEEDEC1A
   *
   * @param command AssignTl1ToDiscExcContIEEEDEC1ACommand
   */
  public void validate(AssignTl1ToDiscExcContIEEEDEC1ACommand command) throws Exception {
    Assert.notNull(command, "AssignTl1ToDiscExcContIEEEDEC1ACommand should not be null");
    Assert.notNull(
        command.getDiscExcContIEEEDEC1AId(),
        "AssignTl1ToDiscExcContIEEEDEC1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignTl1ToDiscExcContIEEEDEC1ACommand assignment should not be null");
  }

  /**
   * handles unassign Tl1 validation for a DiscExcContIEEEDEC1A
   *
   * @param command UnAssignTl1FromDiscExcContIEEEDEC1ACommand
   */
  public void validate(UnAssignTl1FromDiscExcContIEEEDEC1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignTl1FromDiscExcContIEEEDEC1ACommand should not be null");
    Assert.notNull(
        command.getDiscExcContIEEEDEC1AId(),
        "UnAssignTl1FromDiscExcContIEEEDEC1ACommand identifier should not be null");
  }
  /**
   * handles assign Tl2 validation for a DiscExcContIEEEDEC1A
   *
   * @param command AssignTl2ToDiscExcContIEEEDEC1ACommand
   */
  public void validate(AssignTl2ToDiscExcContIEEEDEC1ACommand command) throws Exception {
    Assert.notNull(command, "AssignTl2ToDiscExcContIEEEDEC1ACommand should not be null");
    Assert.notNull(
        command.getDiscExcContIEEEDEC1AId(),
        "AssignTl2ToDiscExcContIEEEDEC1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignTl2ToDiscExcContIEEEDEC1ACommand assignment should not be null");
  }

  /**
   * handles unassign Tl2 validation for a DiscExcContIEEEDEC1A
   *
   * @param command UnAssignTl2FromDiscExcContIEEEDEC1ACommand
   */
  public void validate(UnAssignTl2FromDiscExcContIEEEDEC1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignTl2FromDiscExcContIEEEDEC1ACommand should not be null");
    Assert.notNull(
        command.getDiscExcContIEEEDEC1AId(),
        "UnAssignTl2FromDiscExcContIEEEDEC1ACommand identifier should not be null");
  }
  /**
   * handles assign Tw5 validation for a DiscExcContIEEEDEC1A
   *
   * @param command AssignTw5ToDiscExcContIEEEDEC1ACommand
   */
  public void validate(AssignTw5ToDiscExcContIEEEDEC1ACommand command) throws Exception {
    Assert.notNull(command, "AssignTw5ToDiscExcContIEEEDEC1ACommand should not be null");
    Assert.notNull(
        command.getDiscExcContIEEEDEC1AId(),
        "AssignTw5ToDiscExcContIEEEDEC1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignTw5ToDiscExcContIEEEDEC1ACommand assignment should not be null");
  }

  /**
   * handles unassign Tw5 validation for a DiscExcContIEEEDEC1A
   *
   * @param command UnAssignTw5FromDiscExcContIEEEDEC1ACommand
   */
  public void validate(UnAssignTw5FromDiscExcContIEEEDEC1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignTw5FromDiscExcContIEEEDEC1ACommand should not be null");
    Assert.notNull(
        command.getDiscExcContIEEEDEC1AId(),
        "UnAssignTw5FromDiscExcContIEEEDEC1ACommand identifier should not be null");
  }
  /**
   * handles assign Value validation for a DiscExcContIEEEDEC1A
   *
   * @param command AssignValueToDiscExcContIEEEDEC1ACommand
   */
  public void validate(AssignValueToDiscExcContIEEEDEC1ACommand command) throws Exception {
    Assert.notNull(command, "AssignValueToDiscExcContIEEEDEC1ACommand should not be null");
    Assert.notNull(
        command.getDiscExcContIEEEDEC1AId(),
        "AssignValueToDiscExcContIEEEDEC1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignValueToDiscExcContIEEEDEC1ACommand assignment should not be null");
  }

  /**
   * handles unassign Value validation for a DiscExcContIEEEDEC1A
   *
   * @param command UnAssignValueFromDiscExcContIEEEDEC1ACommand
   */
  public void validate(UnAssignValueFromDiscExcContIEEEDEC1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignValueFromDiscExcContIEEEDEC1ACommand should not be null");
    Assert.notNull(
        command.getDiscExcContIEEEDEC1AId(),
        "UnAssignValueFromDiscExcContIEEEDEC1ACommand identifier should not be null");
  }
  /**
   * handles assign Vanmax validation for a DiscExcContIEEEDEC1A
   *
   * @param command AssignVanmaxToDiscExcContIEEEDEC1ACommand
   */
  public void validate(AssignVanmaxToDiscExcContIEEEDEC1ACommand command) throws Exception {
    Assert.notNull(command, "AssignVanmaxToDiscExcContIEEEDEC1ACommand should not be null");
    Assert.notNull(
        command.getDiscExcContIEEEDEC1AId(),
        "AssignVanmaxToDiscExcContIEEEDEC1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignVanmaxToDiscExcContIEEEDEC1ACommand assignment should not be null");
  }

  /**
   * handles unassign Vanmax validation for a DiscExcContIEEEDEC1A
   *
   * @param command UnAssignVanmaxFromDiscExcContIEEEDEC1ACommand
   */
  public void validate(UnAssignVanmaxFromDiscExcContIEEEDEC1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignVanmaxFromDiscExcContIEEEDEC1ACommand should not be null");
    Assert.notNull(
        command.getDiscExcContIEEEDEC1AId(),
        "UnAssignVanmaxFromDiscExcContIEEEDEC1ACommand identifier should not be null");
  }
  /**
   * handles assign Vomax validation for a DiscExcContIEEEDEC1A
   *
   * @param command AssignVomaxToDiscExcContIEEEDEC1ACommand
   */
  public void validate(AssignVomaxToDiscExcContIEEEDEC1ACommand command) throws Exception {
    Assert.notNull(command, "AssignVomaxToDiscExcContIEEEDEC1ACommand should not be null");
    Assert.notNull(
        command.getDiscExcContIEEEDEC1AId(),
        "AssignVomaxToDiscExcContIEEEDEC1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignVomaxToDiscExcContIEEEDEC1ACommand assignment should not be null");
  }

  /**
   * handles unassign Vomax validation for a DiscExcContIEEEDEC1A
   *
   * @param command UnAssignVomaxFromDiscExcContIEEEDEC1ACommand
   */
  public void validate(UnAssignVomaxFromDiscExcContIEEEDEC1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignVomaxFromDiscExcContIEEEDEC1ACommand should not be null");
    Assert.notNull(
        command.getDiscExcContIEEEDEC1AId(),
        "UnAssignVomaxFromDiscExcContIEEEDEC1ACommand identifier should not be null");
  }
  /**
   * handles assign Vomin validation for a DiscExcContIEEEDEC1A
   *
   * @param command AssignVominToDiscExcContIEEEDEC1ACommand
   */
  public void validate(AssignVominToDiscExcContIEEEDEC1ACommand command) throws Exception {
    Assert.notNull(command, "AssignVominToDiscExcContIEEEDEC1ACommand should not be null");
    Assert.notNull(
        command.getDiscExcContIEEEDEC1AId(),
        "AssignVominToDiscExcContIEEEDEC1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignVominToDiscExcContIEEEDEC1ACommand assignment should not be null");
  }

  /**
   * handles unassign Vomin validation for a DiscExcContIEEEDEC1A
   *
   * @param command UnAssignVominFromDiscExcContIEEEDEC1ACommand
   */
  public void validate(UnAssignVominFromDiscExcContIEEEDEC1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignVominFromDiscExcContIEEEDEC1ACommand should not be null");
    Assert.notNull(
        command.getDiscExcContIEEEDEC1AId(),
        "UnAssignVominFromDiscExcContIEEEDEC1ACommand identifier should not be null");
  }
  /**
   * handles assign Vsmax validation for a DiscExcContIEEEDEC1A
   *
   * @param command AssignVsmaxToDiscExcContIEEEDEC1ACommand
   */
  public void validate(AssignVsmaxToDiscExcContIEEEDEC1ACommand command) throws Exception {
    Assert.notNull(command, "AssignVsmaxToDiscExcContIEEEDEC1ACommand should not be null");
    Assert.notNull(
        command.getDiscExcContIEEEDEC1AId(),
        "AssignVsmaxToDiscExcContIEEEDEC1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignVsmaxToDiscExcContIEEEDEC1ACommand assignment should not be null");
  }

  /**
   * handles unassign Vsmax validation for a DiscExcContIEEEDEC1A
   *
   * @param command UnAssignVsmaxFromDiscExcContIEEEDEC1ACommand
   */
  public void validate(UnAssignVsmaxFromDiscExcContIEEEDEC1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignVsmaxFromDiscExcContIEEEDEC1ACommand should not be null");
    Assert.notNull(
        command.getDiscExcContIEEEDEC1AId(),
        "UnAssignVsmaxFromDiscExcContIEEEDEC1ACommand identifier should not be null");
  }
  /**
   * handles assign Vsmin validation for a DiscExcContIEEEDEC1A
   *
   * @param command AssignVsminToDiscExcContIEEEDEC1ACommand
   */
  public void validate(AssignVsminToDiscExcContIEEEDEC1ACommand command) throws Exception {
    Assert.notNull(command, "AssignVsminToDiscExcContIEEEDEC1ACommand should not be null");
    Assert.notNull(
        command.getDiscExcContIEEEDEC1AId(),
        "AssignVsminToDiscExcContIEEEDEC1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignVsminToDiscExcContIEEEDEC1ACommand assignment should not be null");
  }

  /**
   * handles unassign Vsmin validation for a DiscExcContIEEEDEC1A
   *
   * @param command UnAssignVsminFromDiscExcContIEEEDEC1ACommand
   */
  public void validate(UnAssignVsminFromDiscExcContIEEEDEC1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignVsminFromDiscExcContIEEEDEC1ACommand should not be null");
    Assert.notNull(
        command.getDiscExcContIEEEDEC1AId(),
        "UnAssignVsminFromDiscExcContIEEEDEC1ACommand identifier should not be null");
  }
  /**
   * handles assign Vtc validation for a DiscExcContIEEEDEC1A
   *
   * @param command AssignVtcToDiscExcContIEEEDEC1ACommand
   */
  public void validate(AssignVtcToDiscExcContIEEEDEC1ACommand command) throws Exception {
    Assert.notNull(command, "AssignVtcToDiscExcContIEEEDEC1ACommand should not be null");
    Assert.notNull(
        command.getDiscExcContIEEEDEC1AId(),
        "AssignVtcToDiscExcContIEEEDEC1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignVtcToDiscExcContIEEEDEC1ACommand assignment should not be null");
  }

  /**
   * handles unassign Vtc validation for a DiscExcContIEEEDEC1A
   *
   * @param command UnAssignVtcFromDiscExcContIEEEDEC1ACommand
   */
  public void validate(UnAssignVtcFromDiscExcContIEEEDEC1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignVtcFromDiscExcContIEEEDEC1ACommand should not be null");
    Assert.notNull(
        command.getDiscExcContIEEEDEC1AId(),
        "UnAssignVtcFromDiscExcContIEEEDEC1ACommand identifier should not be null");
  }
  /**
   * handles assign Vtlmt validation for a DiscExcContIEEEDEC1A
   *
   * @param command AssignVtlmtToDiscExcContIEEEDEC1ACommand
   */
  public void validate(AssignVtlmtToDiscExcContIEEEDEC1ACommand command) throws Exception {
    Assert.notNull(command, "AssignVtlmtToDiscExcContIEEEDEC1ACommand should not be null");
    Assert.notNull(
        command.getDiscExcContIEEEDEC1AId(),
        "AssignVtlmtToDiscExcContIEEEDEC1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignVtlmtToDiscExcContIEEEDEC1ACommand assignment should not be null");
  }

  /**
   * handles unassign Vtlmt validation for a DiscExcContIEEEDEC1A
   *
   * @param command UnAssignVtlmtFromDiscExcContIEEEDEC1ACommand
   */
  public void validate(UnAssignVtlmtFromDiscExcContIEEEDEC1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignVtlmtFromDiscExcContIEEEDEC1ACommand should not be null");
    Assert.notNull(
        command.getDiscExcContIEEEDEC1AId(),
        "UnAssignVtlmtFromDiscExcContIEEEDEC1ACommand identifier should not be null");
  }
  /**
   * handles assign Vtm validation for a DiscExcContIEEEDEC1A
   *
   * @param command AssignVtmToDiscExcContIEEEDEC1ACommand
   */
  public void validate(AssignVtmToDiscExcContIEEEDEC1ACommand command) throws Exception {
    Assert.notNull(command, "AssignVtmToDiscExcContIEEEDEC1ACommand should not be null");
    Assert.notNull(
        command.getDiscExcContIEEEDEC1AId(),
        "AssignVtmToDiscExcContIEEEDEC1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignVtmToDiscExcContIEEEDEC1ACommand assignment should not be null");
  }

  /**
   * handles unassign Vtm validation for a DiscExcContIEEEDEC1A
   *
   * @param command UnAssignVtmFromDiscExcContIEEEDEC1ACommand
   */
  public void validate(UnAssignVtmFromDiscExcContIEEEDEC1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignVtmFromDiscExcContIEEEDEC1ACommand should not be null");
    Assert.notNull(
        command.getDiscExcContIEEEDEC1AId(),
        "UnAssignVtmFromDiscExcContIEEEDEC1ACommand identifier should not be null");
  }
  /**
   * handles assign Vtn validation for a DiscExcContIEEEDEC1A
   *
   * @param command AssignVtnToDiscExcContIEEEDEC1ACommand
   */
  public void validate(AssignVtnToDiscExcContIEEEDEC1ACommand command) throws Exception {
    Assert.notNull(command, "AssignVtnToDiscExcContIEEEDEC1ACommand should not be null");
    Assert.notNull(
        command.getDiscExcContIEEEDEC1AId(),
        "AssignVtnToDiscExcContIEEEDEC1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignVtnToDiscExcContIEEEDEC1ACommand assignment should not be null");
  }

  /**
   * handles unassign Vtn validation for a DiscExcContIEEEDEC1A
   *
   * @param command UnAssignVtnFromDiscExcContIEEEDEC1ACommand
   */
  public void validate(UnAssignVtnFromDiscExcContIEEEDEC1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignVtnFromDiscExcContIEEEDEC1ACommand should not be null");
    Assert.notNull(
        command.getDiscExcContIEEEDEC1AId(),
        "UnAssignVtnFromDiscExcContIEEEDEC1ACommand identifier should not be null");
  }
}
