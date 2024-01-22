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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.loaddynamics.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class LoadCompositeValidator {

  /** default constructor */
  protected LoadCompositeValidator() {}

  /** factory method */
  public static LoadCompositeValidator getInstance() {
    return new LoadCompositeValidator();
  }

  /** handles creation validation for a LoadComposite */
  public void validate(CreateLoadCompositeCommand loadComposite) throws Exception {
    Assert.notNull(loadComposite, "CreateLoadCompositeCommand should not be null");
    //		Assert.isNull( loadComposite.getLoadCompositeId(), "CreateLoadCompositeCommand identifier
    // should be null" );
  }

  /** handles update validation for a LoadComposite */
  public void validate(UpdateLoadCompositeCommand loadComposite) throws Exception {
    Assert.notNull(loadComposite, "UpdateLoadCompositeCommand should not be null");
    Assert.notNull(
        loadComposite.getLoadCompositeId(),
        "UpdateLoadCompositeCommand identifier should not be null");
  }

  /** handles delete validation for a LoadComposite */
  public void validate(DeleteLoadCompositeCommand loadComposite) throws Exception {
    Assert.notNull(loadComposite, "{commandAlias} should not be null");
    Assert.notNull(
        loadComposite.getLoadCompositeId(),
        "DeleteLoadCompositeCommand identifier should not be null");
  }

  /** handles fetchOne validation for a LoadComposite */
  public void validate(LoadCompositeFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "LoadCompositeFetchOneSummary should not be null");
    Assert.notNull(
        summary.getLoadCompositeId(), "LoadCompositeFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Epfd validation for a LoadComposite
   *
   * @param command AssignEpfdToLoadCompositeCommand
   */
  public void validate(AssignEpfdToLoadCompositeCommand command) throws Exception {
    Assert.notNull(command, "AssignEpfdToLoadCompositeCommand should not be null");
    Assert.notNull(
        command.getLoadCompositeId(),
        "AssignEpfdToLoadCompositeCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignEpfdToLoadCompositeCommand assignment should not be null");
  }

  /**
   * handles unassign Epfd validation for a LoadComposite
   *
   * @param command UnAssignEpfdFromLoadCompositeCommand
   */
  public void validate(UnAssignEpfdFromLoadCompositeCommand command) throws Exception {
    Assert.notNull(command, "UnAssignEpfdFromLoadCompositeCommand should not be null");
    Assert.notNull(
        command.getLoadCompositeId(),
        "UnAssignEpfdFromLoadCompositeCommand identifier should not be null");
  }
  /**
   * handles assign Epfs validation for a LoadComposite
   *
   * @param command AssignEpfsToLoadCompositeCommand
   */
  public void validate(AssignEpfsToLoadCompositeCommand command) throws Exception {
    Assert.notNull(command, "AssignEpfsToLoadCompositeCommand should not be null");
    Assert.notNull(
        command.getLoadCompositeId(),
        "AssignEpfsToLoadCompositeCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignEpfsToLoadCompositeCommand assignment should not be null");
  }

  /**
   * handles unassign Epfs validation for a LoadComposite
   *
   * @param command UnAssignEpfsFromLoadCompositeCommand
   */
  public void validate(UnAssignEpfsFromLoadCompositeCommand command) throws Exception {
    Assert.notNull(command, "UnAssignEpfsFromLoadCompositeCommand should not be null");
    Assert.notNull(
        command.getLoadCompositeId(),
        "UnAssignEpfsFromLoadCompositeCommand identifier should not be null");
  }
  /**
   * handles assign Epvd validation for a LoadComposite
   *
   * @param command AssignEpvdToLoadCompositeCommand
   */
  public void validate(AssignEpvdToLoadCompositeCommand command) throws Exception {
    Assert.notNull(command, "AssignEpvdToLoadCompositeCommand should not be null");
    Assert.notNull(
        command.getLoadCompositeId(),
        "AssignEpvdToLoadCompositeCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignEpvdToLoadCompositeCommand assignment should not be null");
  }

  /**
   * handles unassign Epvd validation for a LoadComposite
   *
   * @param command UnAssignEpvdFromLoadCompositeCommand
   */
  public void validate(UnAssignEpvdFromLoadCompositeCommand command) throws Exception {
    Assert.notNull(command, "UnAssignEpvdFromLoadCompositeCommand should not be null");
    Assert.notNull(
        command.getLoadCompositeId(),
        "UnAssignEpvdFromLoadCompositeCommand identifier should not be null");
  }
  /**
   * handles assign Epvs validation for a LoadComposite
   *
   * @param command AssignEpvsToLoadCompositeCommand
   */
  public void validate(AssignEpvsToLoadCompositeCommand command) throws Exception {
    Assert.notNull(command, "AssignEpvsToLoadCompositeCommand should not be null");
    Assert.notNull(
        command.getLoadCompositeId(),
        "AssignEpvsToLoadCompositeCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignEpvsToLoadCompositeCommand assignment should not be null");
  }

  /**
   * handles unassign Epvs validation for a LoadComposite
   *
   * @param command UnAssignEpvsFromLoadCompositeCommand
   */
  public void validate(UnAssignEpvsFromLoadCompositeCommand command) throws Exception {
    Assert.notNull(command, "UnAssignEpvsFromLoadCompositeCommand should not be null");
    Assert.notNull(
        command.getLoadCompositeId(),
        "UnAssignEpvsFromLoadCompositeCommand identifier should not be null");
  }
  /**
   * handles assign Eqfd validation for a LoadComposite
   *
   * @param command AssignEqfdToLoadCompositeCommand
   */
  public void validate(AssignEqfdToLoadCompositeCommand command) throws Exception {
    Assert.notNull(command, "AssignEqfdToLoadCompositeCommand should not be null");
    Assert.notNull(
        command.getLoadCompositeId(),
        "AssignEqfdToLoadCompositeCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignEqfdToLoadCompositeCommand assignment should not be null");
  }

  /**
   * handles unassign Eqfd validation for a LoadComposite
   *
   * @param command UnAssignEqfdFromLoadCompositeCommand
   */
  public void validate(UnAssignEqfdFromLoadCompositeCommand command) throws Exception {
    Assert.notNull(command, "UnAssignEqfdFromLoadCompositeCommand should not be null");
    Assert.notNull(
        command.getLoadCompositeId(),
        "UnAssignEqfdFromLoadCompositeCommand identifier should not be null");
  }
  /**
   * handles assign Eqfs validation for a LoadComposite
   *
   * @param command AssignEqfsToLoadCompositeCommand
   */
  public void validate(AssignEqfsToLoadCompositeCommand command) throws Exception {
    Assert.notNull(command, "AssignEqfsToLoadCompositeCommand should not be null");
    Assert.notNull(
        command.getLoadCompositeId(),
        "AssignEqfsToLoadCompositeCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignEqfsToLoadCompositeCommand assignment should not be null");
  }

  /**
   * handles unassign Eqfs validation for a LoadComposite
   *
   * @param command UnAssignEqfsFromLoadCompositeCommand
   */
  public void validate(UnAssignEqfsFromLoadCompositeCommand command) throws Exception {
    Assert.notNull(command, "UnAssignEqfsFromLoadCompositeCommand should not be null");
    Assert.notNull(
        command.getLoadCompositeId(),
        "UnAssignEqfsFromLoadCompositeCommand identifier should not be null");
  }
  /**
   * handles assign Eqvd validation for a LoadComposite
   *
   * @param command AssignEqvdToLoadCompositeCommand
   */
  public void validate(AssignEqvdToLoadCompositeCommand command) throws Exception {
    Assert.notNull(command, "AssignEqvdToLoadCompositeCommand should not be null");
    Assert.notNull(
        command.getLoadCompositeId(),
        "AssignEqvdToLoadCompositeCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignEqvdToLoadCompositeCommand assignment should not be null");
  }

  /**
   * handles unassign Eqvd validation for a LoadComposite
   *
   * @param command UnAssignEqvdFromLoadCompositeCommand
   */
  public void validate(UnAssignEqvdFromLoadCompositeCommand command) throws Exception {
    Assert.notNull(command, "UnAssignEqvdFromLoadCompositeCommand should not be null");
    Assert.notNull(
        command.getLoadCompositeId(),
        "UnAssignEqvdFromLoadCompositeCommand identifier should not be null");
  }
  /**
   * handles assign Eqvs validation for a LoadComposite
   *
   * @param command AssignEqvsToLoadCompositeCommand
   */
  public void validate(AssignEqvsToLoadCompositeCommand command) throws Exception {
    Assert.notNull(command, "AssignEqvsToLoadCompositeCommand should not be null");
    Assert.notNull(
        command.getLoadCompositeId(),
        "AssignEqvsToLoadCompositeCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignEqvsToLoadCompositeCommand assignment should not be null");
  }

  /**
   * handles unassign Eqvs validation for a LoadComposite
   *
   * @param command UnAssignEqvsFromLoadCompositeCommand
   */
  public void validate(UnAssignEqvsFromLoadCompositeCommand command) throws Exception {
    Assert.notNull(command, "UnAssignEqvsFromLoadCompositeCommand should not be null");
    Assert.notNull(
        command.getLoadCompositeId(),
        "UnAssignEqvsFromLoadCompositeCommand identifier should not be null");
  }
  /**
   * handles assign H validation for a LoadComposite
   *
   * @param command AssignHToLoadCompositeCommand
   */
  public void validate(AssignHToLoadCompositeCommand command) throws Exception {
    Assert.notNull(command, "AssignHToLoadCompositeCommand should not be null");
    Assert.notNull(
        command.getLoadCompositeId(),
        "AssignHToLoadCompositeCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignHToLoadCompositeCommand assignment should not be null");
  }

  /**
   * handles unassign H validation for a LoadComposite
   *
   * @param command UnAssignHFromLoadCompositeCommand
   */
  public void validate(UnAssignHFromLoadCompositeCommand command) throws Exception {
    Assert.notNull(command, "UnAssignHFromLoadCompositeCommand should not be null");
    Assert.notNull(
        command.getLoadCompositeId(),
        "UnAssignHFromLoadCompositeCommand identifier should not be null");
  }
  /**
   * handles assign Lfrac validation for a LoadComposite
   *
   * @param command AssignLfracToLoadCompositeCommand
   */
  public void validate(AssignLfracToLoadCompositeCommand command) throws Exception {
    Assert.notNull(command, "AssignLfracToLoadCompositeCommand should not be null");
    Assert.notNull(
        command.getLoadCompositeId(),
        "AssignLfracToLoadCompositeCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignLfracToLoadCompositeCommand assignment should not be null");
  }

  /**
   * handles unassign Lfrac validation for a LoadComposite
   *
   * @param command UnAssignLfracFromLoadCompositeCommand
   */
  public void validate(UnAssignLfracFromLoadCompositeCommand command) throws Exception {
    Assert.notNull(command, "UnAssignLfracFromLoadCompositeCommand should not be null");
    Assert.notNull(
        command.getLoadCompositeId(),
        "UnAssignLfracFromLoadCompositeCommand identifier should not be null");
  }
  /**
   * handles assign Pfrac validation for a LoadComposite
   *
   * @param command AssignPfracToLoadCompositeCommand
   */
  public void validate(AssignPfracToLoadCompositeCommand command) throws Exception {
    Assert.notNull(command, "AssignPfracToLoadCompositeCommand should not be null");
    Assert.notNull(
        command.getLoadCompositeId(),
        "AssignPfracToLoadCompositeCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignPfracToLoadCompositeCommand assignment should not be null");
  }

  /**
   * handles unassign Pfrac validation for a LoadComposite
   *
   * @param command UnAssignPfracFromLoadCompositeCommand
   */
  public void validate(UnAssignPfracFromLoadCompositeCommand command) throws Exception {
    Assert.notNull(command, "UnAssignPfracFromLoadCompositeCommand should not be null");
    Assert.notNull(
        command.getLoadCompositeId(),
        "UnAssignPfracFromLoadCompositeCommand identifier should not be null");
  }
}
