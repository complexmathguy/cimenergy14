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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class MutualCouplingValidator {

  /** default constructor */
  protected MutualCouplingValidator() {}

  /** factory method */
  public static MutualCouplingValidator getInstance() {
    return new MutualCouplingValidator();
  }

  /** handles creation validation for a MutualCoupling */
  public void validate(CreateMutualCouplingCommand mutualCoupling) throws Exception {
    Assert.notNull(mutualCoupling, "CreateMutualCouplingCommand should not be null");
    //		Assert.isNull( mutualCoupling.getMutualCouplingId(), "CreateMutualCouplingCommand identifier
    // should be null" );
  }

  /** handles update validation for a MutualCoupling */
  public void validate(UpdateMutualCouplingCommand mutualCoupling) throws Exception {
    Assert.notNull(mutualCoupling, "UpdateMutualCouplingCommand should not be null");
    Assert.notNull(
        mutualCoupling.getMutualCouplingId(),
        "UpdateMutualCouplingCommand identifier should not be null");
  }

  /** handles delete validation for a MutualCoupling */
  public void validate(DeleteMutualCouplingCommand mutualCoupling) throws Exception {
    Assert.notNull(mutualCoupling, "{commandAlias} should not be null");
    Assert.notNull(
        mutualCoupling.getMutualCouplingId(),
        "DeleteMutualCouplingCommand identifier should not be null");
  }

  /** handles fetchOne validation for a MutualCoupling */
  public void validate(MutualCouplingFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "MutualCouplingFetchOneSummary should not be null");
    Assert.notNull(
        summary.getMutualCouplingId(),
        "MutualCouplingFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign B0ch validation for a MutualCoupling
   *
   * @param command AssignB0chToMutualCouplingCommand
   */
  public void validate(AssignB0chToMutualCouplingCommand command) throws Exception {
    Assert.notNull(command, "AssignB0chToMutualCouplingCommand should not be null");
    Assert.notNull(
        command.getMutualCouplingId(),
        "AssignB0chToMutualCouplingCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignB0chToMutualCouplingCommand assignment should not be null");
  }

  /**
   * handles unassign B0ch validation for a MutualCoupling
   *
   * @param command UnAssignB0chFromMutualCouplingCommand
   */
  public void validate(UnAssignB0chFromMutualCouplingCommand command) throws Exception {
    Assert.notNull(command, "UnAssignB0chFromMutualCouplingCommand should not be null");
    Assert.notNull(
        command.getMutualCouplingId(),
        "UnAssignB0chFromMutualCouplingCommand identifier should not be null");
  }
  /**
   * handles assign Distance11 validation for a MutualCoupling
   *
   * @param command AssignDistance11ToMutualCouplingCommand
   */
  public void validate(AssignDistance11ToMutualCouplingCommand command) throws Exception {
    Assert.notNull(command, "AssignDistance11ToMutualCouplingCommand should not be null");
    Assert.notNull(
        command.getMutualCouplingId(),
        "AssignDistance11ToMutualCouplingCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignDistance11ToMutualCouplingCommand assignment should not be null");
  }

  /**
   * handles unassign Distance11 validation for a MutualCoupling
   *
   * @param command UnAssignDistance11FromMutualCouplingCommand
   */
  public void validate(UnAssignDistance11FromMutualCouplingCommand command) throws Exception {
    Assert.notNull(command, "UnAssignDistance11FromMutualCouplingCommand should not be null");
    Assert.notNull(
        command.getMutualCouplingId(),
        "UnAssignDistance11FromMutualCouplingCommand identifier should not be null");
  }
  /**
   * handles assign Distance12 validation for a MutualCoupling
   *
   * @param command AssignDistance12ToMutualCouplingCommand
   */
  public void validate(AssignDistance12ToMutualCouplingCommand command) throws Exception {
    Assert.notNull(command, "AssignDistance12ToMutualCouplingCommand should not be null");
    Assert.notNull(
        command.getMutualCouplingId(),
        "AssignDistance12ToMutualCouplingCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignDistance12ToMutualCouplingCommand assignment should not be null");
  }

  /**
   * handles unassign Distance12 validation for a MutualCoupling
   *
   * @param command UnAssignDistance12FromMutualCouplingCommand
   */
  public void validate(UnAssignDistance12FromMutualCouplingCommand command) throws Exception {
    Assert.notNull(command, "UnAssignDistance12FromMutualCouplingCommand should not be null");
    Assert.notNull(
        command.getMutualCouplingId(),
        "UnAssignDistance12FromMutualCouplingCommand identifier should not be null");
  }
  /**
   * handles assign Distance21 validation for a MutualCoupling
   *
   * @param command AssignDistance21ToMutualCouplingCommand
   */
  public void validate(AssignDistance21ToMutualCouplingCommand command) throws Exception {
    Assert.notNull(command, "AssignDistance21ToMutualCouplingCommand should not be null");
    Assert.notNull(
        command.getMutualCouplingId(),
        "AssignDistance21ToMutualCouplingCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignDistance21ToMutualCouplingCommand assignment should not be null");
  }

  /**
   * handles unassign Distance21 validation for a MutualCoupling
   *
   * @param command UnAssignDistance21FromMutualCouplingCommand
   */
  public void validate(UnAssignDistance21FromMutualCouplingCommand command) throws Exception {
    Assert.notNull(command, "UnAssignDistance21FromMutualCouplingCommand should not be null");
    Assert.notNull(
        command.getMutualCouplingId(),
        "UnAssignDistance21FromMutualCouplingCommand identifier should not be null");
  }
  /**
   * handles assign Distance22 validation for a MutualCoupling
   *
   * @param command AssignDistance22ToMutualCouplingCommand
   */
  public void validate(AssignDistance22ToMutualCouplingCommand command) throws Exception {
    Assert.notNull(command, "AssignDistance22ToMutualCouplingCommand should not be null");
    Assert.notNull(
        command.getMutualCouplingId(),
        "AssignDistance22ToMutualCouplingCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignDistance22ToMutualCouplingCommand assignment should not be null");
  }

  /**
   * handles unassign Distance22 validation for a MutualCoupling
   *
   * @param command UnAssignDistance22FromMutualCouplingCommand
   */
  public void validate(UnAssignDistance22FromMutualCouplingCommand command) throws Exception {
    Assert.notNull(command, "UnAssignDistance22FromMutualCouplingCommand should not be null");
    Assert.notNull(
        command.getMutualCouplingId(),
        "UnAssignDistance22FromMutualCouplingCommand identifier should not be null");
  }
  /**
   * handles assign G0ch validation for a MutualCoupling
   *
   * @param command AssignG0chToMutualCouplingCommand
   */
  public void validate(AssignG0chToMutualCouplingCommand command) throws Exception {
    Assert.notNull(command, "AssignG0chToMutualCouplingCommand should not be null");
    Assert.notNull(
        command.getMutualCouplingId(),
        "AssignG0chToMutualCouplingCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignG0chToMutualCouplingCommand assignment should not be null");
  }

  /**
   * handles unassign G0ch validation for a MutualCoupling
   *
   * @param command UnAssignG0chFromMutualCouplingCommand
   */
  public void validate(UnAssignG0chFromMutualCouplingCommand command) throws Exception {
    Assert.notNull(command, "UnAssignG0chFromMutualCouplingCommand should not be null");
    Assert.notNull(
        command.getMutualCouplingId(),
        "UnAssignG0chFromMutualCouplingCommand identifier should not be null");
  }
  /**
   * handles assign R0 validation for a MutualCoupling
   *
   * @param command AssignR0ToMutualCouplingCommand
   */
  public void validate(AssignR0ToMutualCouplingCommand command) throws Exception {
    Assert.notNull(command, "AssignR0ToMutualCouplingCommand should not be null");
    Assert.notNull(
        command.getMutualCouplingId(),
        "AssignR0ToMutualCouplingCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignR0ToMutualCouplingCommand assignment should not be null");
  }

  /**
   * handles unassign R0 validation for a MutualCoupling
   *
   * @param command UnAssignR0FromMutualCouplingCommand
   */
  public void validate(UnAssignR0FromMutualCouplingCommand command) throws Exception {
    Assert.notNull(command, "UnAssignR0FromMutualCouplingCommand should not be null");
    Assert.notNull(
        command.getMutualCouplingId(),
        "UnAssignR0FromMutualCouplingCommand identifier should not be null");
  }
  /**
   * handles assign X0 validation for a MutualCoupling
   *
   * @param command AssignX0ToMutualCouplingCommand
   */
  public void validate(AssignX0ToMutualCouplingCommand command) throws Exception {
    Assert.notNull(command, "AssignX0ToMutualCouplingCommand should not be null");
    Assert.notNull(
        command.getMutualCouplingId(),
        "AssignX0ToMutualCouplingCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignX0ToMutualCouplingCommand assignment should not be null");
  }

  /**
   * handles unassign X0 validation for a MutualCoupling
   *
   * @param command UnAssignX0FromMutualCouplingCommand
   */
  public void validate(UnAssignX0FromMutualCouplingCommand command) throws Exception {
    Assert.notNull(command, "UnAssignX0FromMutualCouplingCommand should not be null");
    Assert.notNull(
        command.getMutualCouplingId(),
        "UnAssignX0FromMutualCouplingCommand identifier should not be null");
  }

  /**
   * handles add to HasSecondMutualCoupling validation for a MutualCoupling
   *
   * @param command AssignHasSecondMutualCouplingToMutualCouplingCommand
   */
  public void validate(AssignHasSecondMutualCouplingToMutualCouplingCommand command)
      throws Exception {
    Assert.notNull(
        command, "AssignHasSecondMutualCouplingToMutualCouplingCommand should not be null");
    Assert.notNull(
        command.getMutualCouplingId(),
        "AssignHasSecondMutualCouplingToMutualCouplingCommand identifier should not be null");
    Assert.notNull(
        command.getAddTo(),
        "AssignHasSecondMutualCouplingToMutualCouplingCommand addTo attribute should not be null");
  }

  /**
   * handles remove from HasSecondMutualCoupling validation for a MutualCoupling
   *
   * @param command RemoveHasSecondMutualCouplingFromMutualCouplingCommand
   */
  public void validate(RemoveHasSecondMutualCouplingFromMutualCouplingCommand command)
      throws Exception {
    Assert.notNull(
        command, "RemoveHasSecondMutualCouplingFromMutualCouplingCommand should not be null");
    Assert.notNull(
        command.getMutualCouplingId(),
        "RemoveHasSecondMutualCouplingFromMutualCouplingCommand identifier should not be null");
    Assert.notNull(
        command.getRemoveFrom(),
        "RemoveHasSecondMutualCouplingFromMutualCouplingCommand removeFrom attribute should not be null");
    Assert.notNull(
        command.getRemoveFrom().getMutualCouplingId(),
        "RemoveHasSecondMutualCouplingFromMutualCouplingCommand removeFrom attribubte identifier should not be null");
  }

  /**
   * handles add to HasFirstMutualCoupling validation for a MutualCoupling
   *
   * @param command AssignHasFirstMutualCouplingToMutualCouplingCommand
   */
  public void validate(AssignHasFirstMutualCouplingToMutualCouplingCommand command)
      throws Exception {
    Assert.notNull(
        command, "AssignHasFirstMutualCouplingToMutualCouplingCommand should not be null");
    Assert.notNull(
        command.getMutualCouplingId(),
        "AssignHasFirstMutualCouplingToMutualCouplingCommand identifier should not be null");
    Assert.notNull(
        command.getAddTo(),
        "AssignHasFirstMutualCouplingToMutualCouplingCommand addTo attribute should not be null");
  }

  /**
   * handles remove from HasFirstMutualCoupling validation for a MutualCoupling
   *
   * @param command RemoveHasFirstMutualCouplingFromMutualCouplingCommand
   */
  public void validate(RemoveHasFirstMutualCouplingFromMutualCouplingCommand command)
      throws Exception {
    Assert.notNull(
        command, "RemoveHasFirstMutualCouplingFromMutualCouplingCommand should not be null");
    Assert.notNull(
        command.getMutualCouplingId(),
        "RemoveHasFirstMutualCouplingFromMutualCouplingCommand identifier should not be null");
    Assert.notNull(
        command.getRemoveFrom(),
        "RemoveHasFirstMutualCouplingFromMutualCouplingCommand removeFrom attribute should not be null");
    Assert.notNull(
        command.getRemoveFrom().getMutualCouplingId(),
        "RemoveHasFirstMutualCouplingFromMutualCouplingCommand removeFrom attribubte identifier should not be null");
  }
}
