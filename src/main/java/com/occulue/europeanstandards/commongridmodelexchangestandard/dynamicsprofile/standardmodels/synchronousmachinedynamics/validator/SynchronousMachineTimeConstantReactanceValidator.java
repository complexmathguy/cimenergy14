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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.synchronousmachinedynamics.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class SynchronousMachineTimeConstantReactanceValidator {

  /** default constructor */
  protected SynchronousMachineTimeConstantReactanceValidator() {}

  /** factory method */
  public static SynchronousMachineTimeConstantReactanceValidator getInstance() {
    return new SynchronousMachineTimeConstantReactanceValidator();
  }

  /** handles creation validation for a SynchronousMachineTimeConstantReactance */
  public void validate(
      CreateSynchronousMachineTimeConstantReactanceCommand synchronousMachineTimeConstantReactance)
      throws Exception {
    Assert.notNull(
        synchronousMachineTimeConstantReactance,
        "CreateSynchronousMachineTimeConstantReactanceCommand should not be null");
    //		Assert.isNull(
    // synchronousMachineTimeConstantReactance.getSynchronousMachineTimeConstantReactanceId(),
    // "CreateSynchronousMachineTimeConstantReactanceCommand identifier should be null" );
  }

  /** handles update validation for a SynchronousMachineTimeConstantReactance */
  public void validate(
      UpdateSynchronousMachineTimeConstantReactanceCommand synchronousMachineTimeConstantReactance)
      throws Exception {
    Assert.notNull(
        synchronousMachineTimeConstantReactance,
        "UpdateSynchronousMachineTimeConstantReactanceCommand should not be null");
    Assert.notNull(
        synchronousMachineTimeConstantReactance.getSynchronousMachineTimeConstantReactanceId(),
        "UpdateSynchronousMachineTimeConstantReactanceCommand identifier should not be null");
  }

  /** handles delete validation for a SynchronousMachineTimeConstantReactance */
  public void validate(
      DeleteSynchronousMachineTimeConstantReactanceCommand synchronousMachineTimeConstantReactance)
      throws Exception {
    Assert.notNull(synchronousMachineTimeConstantReactance, "{commandAlias} should not be null");
    Assert.notNull(
        synchronousMachineTimeConstantReactance.getSynchronousMachineTimeConstantReactanceId(),
        "DeleteSynchronousMachineTimeConstantReactanceCommand identifier should not be null");
  }

  /** handles fetchOne validation for a SynchronousMachineTimeConstantReactance */
  public void validate(SynchronousMachineTimeConstantReactanceFetchOneSummary summary)
      throws Exception {
    Assert.notNull(
        summary, "SynchronousMachineTimeConstantReactanceFetchOneSummary should not be null");
    Assert.notNull(
        summary.getSynchronousMachineTimeConstantReactanceId(),
        "SynchronousMachineTimeConstantReactanceFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Ks validation for a SynchronousMachineTimeConstantReactance
   *
   * @param command AssignKsToSynchronousMachineTimeConstantReactanceCommand
   */
  public void validate(AssignKsToSynchronousMachineTimeConstantReactanceCommand command)
      throws Exception {
    Assert.notNull(
        command, "AssignKsToSynchronousMachineTimeConstantReactanceCommand should not be null");
    Assert.notNull(
        command.getSynchronousMachineTimeConstantReactanceId(),
        "AssignKsToSynchronousMachineTimeConstantReactanceCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignKsToSynchronousMachineTimeConstantReactanceCommand assignment should not be null");
  }

  /**
   * handles unassign Ks validation for a SynchronousMachineTimeConstantReactance
   *
   * @param command UnAssignKsFromSynchronousMachineTimeConstantReactanceCommand
   */
  public void validate(UnAssignKsFromSynchronousMachineTimeConstantReactanceCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignKsFromSynchronousMachineTimeConstantReactanceCommand should not be null");
    Assert.notNull(
        command.getSynchronousMachineTimeConstantReactanceId(),
        "UnAssignKsFromSynchronousMachineTimeConstantReactanceCommand identifier should not be null");
  }
  /**
   * handles assign Tc validation for a SynchronousMachineTimeConstantReactance
   *
   * @param command AssignTcToSynchronousMachineTimeConstantReactanceCommand
   */
  public void validate(AssignTcToSynchronousMachineTimeConstantReactanceCommand command)
      throws Exception {
    Assert.notNull(
        command, "AssignTcToSynchronousMachineTimeConstantReactanceCommand should not be null");
    Assert.notNull(
        command.getSynchronousMachineTimeConstantReactanceId(),
        "AssignTcToSynchronousMachineTimeConstantReactanceCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignTcToSynchronousMachineTimeConstantReactanceCommand assignment should not be null");
  }

  /**
   * handles unassign Tc validation for a SynchronousMachineTimeConstantReactance
   *
   * @param command UnAssignTcFromSynchronousMachineTimeConstantReactanceCommand
   */
  public void validate(UnAssignTcFromSynchronousMachineTimeConstantReactanceCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignTcFromSynchronousMachineTimeConstantReactanceCommand should not be null");
    Assert.notNull(
        command.getSynchronousMachineTimeConstantReactanceId(),
        "UnAssignTcFromSynchronousMachineTimeConstantReactanceCommand identifier should not be null");
  }
  /**
   * handles assign Tpdo validation for a SynchronousMachineTimeConstantReactance
   *
   * @param command AssignTpdoToSynchronousMachineTimeConstantReactanceCommand
   */
  public void validate(AssignTpdoToSynchronousMachineTimeConstantReactanceCommand command)
      throws Exception {
    Assert.notNull(
        command, "AssignTpdoToSynchronousMachineTimeConstantReactanceCommand should not be null");
    Assert.notNull(
        command.getSynchronousMachineTimeConstantReactanceId(),
        "AssignTpdoToSynchronousMachineTimeConstantReactanceCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignTpdoToSynchronousMachineTimeConstantReactanceCommand assignment should not be null");
  }

  /**
   * handles unassign Tpdo validation for a SynchronousMachineTimeConstantReactance
   *
   * @param command UnAssignTpdoFromSynchronousMachineTimeConstantReactanceCommand
   */
  public void validate(UnAssignTpdoFromSynchronousMachineTimeConstantReactanceCommand command)
      throws Exception {
    Assert.notNull(
        command,
        "UnAssignTpdoFromSynchronousMachineTimeConstantReactanceCommand should not be null");
    Assert.notNull(
        command.getSynchronousMachineTimeConstantReactanceId(),
        "UnAssignTpdoFromSynchronousMachineTimeConstantReactanceCommand identifier should not be null");
  }
  /**
   * handles assign Tppdo validation for a SynchronousMachineTimeConstantReactance
   *
   * @param command AssignTppdoToSynchronousMachineTimeConstantReactanceCommand
   */
  public void validate(AssignTppdoToSynchronousMachineTimeConstantReactanceCommand command)
      throws Exception {
    Assert.notNull(
        command, "AssignTppdoToSynchronousMachineTimeConstantReactanceCommand should not be null");
    Assert.notNull(
        command.getSynchronousMachineTimeConstantReactanceId(),
        "AssignTppdoToSynchronousMachineTimeConstantReactanceCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignTppdoToSynchronousMachineTimeConstantReactanceCommand assignment should not be null");
  }

  /**
   * handles unassign Tppdo validation for a SynchronousMachineTimeConstantReactance
   *
   * @param command UnAssignTppdoFromSynchronousMachineTimeConstantReactanceCommand
   */
  public void validate(UnAssignTppdoFromSynchronousMachineTimeConstantReactanceCommand command)
      throws Exception {
    Assert.notNull(
        command,
        "UnAssignTppdoFromSynchronousMachineTimeConstantReactanceCommand should not be null");
    Assert.notNull(
        command.getSynchronousMachineTimeConstantReactanceId(),
        "UnAssignTppdoFromSynchronousMachineTimeConstantReactanceCommand identifier should not be null");
  }
  /**
   * handles assign Tppqo validation for a SynchronousMachineTimeConstantReactance
   *
   * @param command AssignTppqoToSynchronousMachineTimeConstantReactanceCommand
   */
  public void validate(AssignTppqoToSynchronousMachineTimeConstantReactanceCommand command)
      throws Exception {
    Assert.notNull(
        command, "AssignTppqoToSynchronousMachineTimeConstantReactanceCommand should not be null");
    Assert.notNull(
        command.getSynchronousMachineTimeConstantReactanceId(),
        "AssignTppqoToSynchronousMachineTimeConstantReactanceCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignTppqoToSynchronousMachineTimeConstantReactanceCommand assignment should not be null");
  }

  /**
   * handles unassign Tppqo validation for a SynchronousMachineTimeConstantReactance
   *
   * @param command UnAssignTppqoFromSynchronousMachineTimeConstantReactanceCommand
   */
  public void validate(UnAssignTppqoFromSynchronousMachineTimeConstantReactanceCommand command)
      throws Exception {
    Assert.notNull(
        command,
        "UnAssignTppqoFromSynchronousMachineTimeConstantReactanceCommand should not be null");
    Assert.notNull(
        command.getSynchronousMachineTimeConstantReactanceId(),
        "UnAssignTppqoFromSynchronousMachineTimeConstantReactanceCommand identifier should not be null");
  }
  /**
   * handles assign Tpqo validation for a SynchronousMachineTimeConstantReactance
   *
   * @param command AssignTpqoToSynchronousMachineTimeConstantReactanceCommand
   */
  public void validate(AssignTpqoToSynchronousMachineTimeConstantReactanceCommand command)
      throws Exception {
    Assert.notNull(
        command, "AssignTpqoToSynchronousMachineTimeConstantReactanceCommand should not be null");
    Assert.notNull(
        command.getSynchronousMachineTimeConstantReactanceId(),
        "AssignTpqoToSynchronousMachineTimeConstantReactanceCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignTpqoToSynchronousMachineTimeConstantReactanceCommand assignment should not be null");
  }

  /**
   * handles unassign Tpqo validation for a SynchronousMachineTimeConstantReactance
   *
   * @param command UnAssignTpqoFromSynchronousMachineTimeConstantReactanceCommand
   */
  public void validate(UnAssignTpqoFromSynchronousMachineTimeConstantReactanceCommand command)
      throws Exception {
    Assert.notNull(
        command,
        "UnAssignTpqoFromSynchronousMachineTimeConstantReactanceCommand should not be null");
    Assert.notNull(
        command.getSynchronousMachineTimeConstantReactanceId(),
        "UnAssignTpqoFromSynchronousMachineTimeConstantReactanceCommand identifier should not be null");
  }
  /**
   * handles assign XDirectSubtrans validation for a SynchronousMachineTimeConstantReactance
   *
   * @param command AssignXDirectSubtransToSynchronousMachineTimeConstantReactanceCommand
   */
  public void validate(
      AssignXDirectSubtransToSynchronousMachineTimeConstantReactanceCommand command)
      throws Exception {
    Assert.notNull(
        command,
        "AssignXDirectSubtransToSynchronousMachineTimeConstantReactanceCommand should not be null");
    Assert.notNull(
        command.getSynchronousMachineTimeConstantReactanceId(),
        "AssignXDirectSubtransToSynchronousMachineTimeConstantReactanceCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignXDirectSubtransToSynchronousMachineTimeConstantReactanceCommand assignment should not be null");
  }

  /**
   * handles unassign XDirectSubtrans validation for a SynchronousMachineTimeConstantReactance
   *
   * @param command UnAssignXDirectSubtransFromSynchronousMachineTimeConstantReactanceCommand
   */
  public void validate(
      UnAssignXDirectSubtransFromSynchronousMachineTimeConstantReactanceCommand command)
      throws Exception {
    Assert.notNull(
        command,
        "UnAssignXDirectSubtransFromSynchronousMachineTimeConstantReactanceCommand should not be null");
    Assert.notNull(
        command.getSynchronousMachineTimeConstantReactanceId(),
        "UnAssignXDirectSubtransFromSynchronousMachineTimeConstantReactanceCommand identifier should not be null");
  }
  /**
   * handles assign XDirectSync validation for a SynchronousMachineTimeConstantReactance
   *
   * @param command AssignXDirectSyncToSynchronousMachineTimeConstantReactanceCommand
   */
  public void validate(AssignXDirectSyncToSynchronousMachineTimeConstantReactanceCommand command)
      throws Exception {
    Assert.notNull(
        command,
        "AssignXDirectSyncToSynchronousMachineTimeConstantReactanceCommand should not be null");
    Assert.notNull(
        command.getSynchronousMachineTimeConstantReactanceId(),
        "AssignXDirectSyncToSynchronousMachineTimeConstantReactanceCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignXDirectSyncToSynchronousMachineTimeConstantReactanceCommand assignment should not be null");
  }

  /**
   * handles unassign XDirectSync validation for a SynchronousMachineTimeConstantReactance
   *
   * @param command UnAssignXDirectSyncFromSynchronousMachineTimeConstantReactanceCommand
   */
  public void validate(
      UnAssignXDirectSyncFromSynchronousMachineTimeConstantReactanceCommand command)
      throws Exception {
    Assert.notNull(
        command,
        "UnAssignXDirectSyncFromSynchronousMachineTimeConstantReactanceCommand should not be null");
    Assert.notNull(
        command.getSynchronousMachineTimeConstantReactanceId(),
        "UnAssignXDirectSyncFromSynchronousMachineTimeConstantReactanceCommand identifier should not be null");
  }
  /**
   * handles assign XDirectTrans validation for a SynchronousMachineTimeConstantReactance
   *
   * @param command AssignXDirectTransToSynchronousMachineTimeConstantReactanceCommand
   */
  public void validate(AssignXDirectTransToSynchronousMachineTimeConstantReactanceCommand command)
      throws Exception {
    Assert.notNull(
        command,
        "AssignXDirectTransToSynchronousMachineTimeConstantReactanceCommand should not be null");
    Assert.notNull(
        command.getSynchronousMachineTimeConstantReactanceId(),
        "AssignXDirectTransToSynchronousMachineTimeConstantReactanceCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignXDirectTransToSynchronousMachineTimeConstantReactanceCommand assignment should not be null");
  }

  /**
   * handles unassign XDirectTrans validation for a SynchronousMachineTimeConstantReactance
   *
   * @param command UnAssignXDirectTransFromSynchronousMachineTimeConstantReactanceCommand
   */
  public void validate(
      UnAssignXDirectTransFromSynchronousMachineTimeConstantReactanceCommand command)
      throws Exception {
    Assert.notNull(
        command,
        "UnAssignXDirectTransFromSynchronousMachineTimeConstantReactanceCommand should not be null");
    Assert.notNull(
        command.getSynchronousMachineTimeConstantReactanceId(),
        "UnAssignXDirectTransFromSynchronousMachineTimeConstantReactanceCommand identifier should not be null");
  }
  /**
   * handles assign XQuadSubtrans validation for a SynchronousMachineTimeConstantReactance
   *
   * @param command AssignXQuadSubtransToSynchronousMachineTimeConstantReactanceCommand
   */
  public void validate(AssignXQuadSubtransToSynchronousMachineTimeConstantReactanceCommand command)
      throws Exception {
    Assert.notNull(
        command,
        "AssignXQuadSubtransToSynchronousMachineTimeConstantReactanceCommand should not be null");
    Assert.notNull(
        command.getSynchronousMachineTimeConstantReactanceId(),
        "AssignXQuadSubtransToSynchronousMachineTimeConstantReactanceCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignXQuadSubtransToSynchronousMachineTimeConstantReactanceCommand assignment should not be null");
  }

  /**
   * handles unassign XQuadSubtrans validation for a SynchronousMachineTimeConstantReactance
   *
   * @param command UnAssignXQuadSubtransFromSynchronousMachineTimeConstantReactanceCommand
   */
  public void validate(
      UnAssignXQuadSubtransFromSynchronousMachineTimeConstantReactanceCommand command)
      throws Exception {
    Assert.notNull(
        command,
        "UnAssignXQuadSubtransFromSynchronousMachineTimeConstantReactanceCommand should not be null");
    Assert.notNull(
        command.getSynchronousMachineTimeConstantReactanceId(),
        "UnAssignXQuadSubtransFromSynchronousMachineTimeConstantReactanceCommand identifier should not be null");
  }
  /**
   * handles assign XQuadSync validation for a SynchronousMachineTimeConstantReactance
   *
   * @param command AssignXQuadSyncToSynchronousMachineTimeConstantReactanceCommand
   */
  public void validate(AssignXQuadSyncToSynchronousMachineTimeConstantReactanceCommand command)
      throws Exception {
    Assert.notNull(
        command,
        "AssignXQuadSyncToSynchronousMachineTimeConstantReactanceCommand should not be null");
    Assert.notNull(
        command.getSynchronousMachineTimeConstantReactanceId(),
        "AssignXQuadSyncToSynchronousMachineTimeConstantReactanceCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignXQuadSyncToSynchronousMachineTimeConstantReactanceCommand assignment should not be null");
  }

  /**
   * handles unassign XQuadSync validation for a SynchronousMachineTimeConstantReactance
   *
   * @param command UnAssignXQuadSyncFromSynchronousMachineTimeConstantReactanceCommand
   */
  public void validate(UnAssignXQuadSyncFromSynchronousMachineTimeConstantReactanceCommand command)
      throws Exception {
    Assert.notNull(
        command,
        "UnAssignXQuadSyncFromSynchronousMachineTimeConstantReactanceCommand should not be null");
    Assert.notNull(
        command.getSynchronousMachineTimeConstantReactanceId(),
        "UnAssignXQuadSyncFromSynchronousMachineTimeConstantReactanceCommand identifier should not be null");
  }
  /**
   * handles assign XQuadTrans validation for a SynchronousMachineTimeConstantReactance
   *
   * @param command AssignXQuadTransToSynchronousMachineTimeConstantReactanceCommand
   */
  public void validate(AssignXQuadTransToSynchronousMachineTimeConstantReactanceCommand command)
      throws Exception {
    Assert.notNull(
        command,
        "AssignXQuadTransToSynchronousMachineTimeConstantReactanceCommand should not be null");
    Assert.notNull(
        command.getSynchronousMachineTimeConstantReactanceId(),
        "AssignXQuadTransToSynchronousMachineTimeConstantReactanceCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignXQuadTransToSynchronousMachineTimeConstantReactanceCommand assignment should not be null");
  }

  /**
   * handles unassign XQuadTrans validation for a SynchronousMachineTimeConstantReactance
   *
   * @param command UnAssignXQuadTransFromSynchronousMachineTimeConstantReactanceCommand
   */
  public void validate(UnAssignXQuadTransFromSynchronousMachineTimeConstantReactanceCommand command)
      throws Exception {
    Assert.notNull(
        command,
        "UnAssignXQuadTransFromSynchronousMachineTimeConstantReactanceCommand should not be null");
    Assert.notNull(
        command.getSynchronousMachineTimeConstantReactanceId(),
        "UnAssignXQuadTransFromSynchronousMachineTimeConstantReactanceCommand identifier should not be null");
  }
}
