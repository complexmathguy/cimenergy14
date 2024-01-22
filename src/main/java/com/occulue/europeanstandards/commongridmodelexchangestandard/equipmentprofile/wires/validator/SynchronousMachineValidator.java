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

public class SynchronousMachineValidator {

  /** default constructor */
  protected SynchronousMachineValidator() {}

  /** factory method */
  public static SynchronousMachineValidator getInstance() {
    return new SynchronousMachineValidator();
  }

  /** handles creation validation for a SynchronousMachine */
  public void validate(CreateSynchronousMachineCommand synchronousMachine) throws Exception {
    Assert.notNull(synchronousMachine, "CreateSynchronousMachineCommand should not be null");
    //		Assert.isNull( synchronousMachine.getSynchronousMachineId(),
    // "CreateSynchronousMachineCommand identifier should be null" );
  }

  /** handles update validation for a SynchronousMachine */
  public void validate(UpdateSynchronousMachineCommand synchronousMachine) throws Exception {
    Assert.notNull(synchronousMachine, "UpdateSynchronousMachineCommand should not be null");
    Assert.notNull(
        synchronousMachine.getSynchronousMachineId(),
        "UpdateSynchronousMachineCommand identifier should not be null");
  }

  /** handles delete validation for a SynchronousMachine */
  public void validate(DeleteSynchronousMachineCommand synchronousMachine) throws Exception {
    Assert.notNull(synchronousMachine, "{commandAlias} should not be null");
    Assert.notNull(
        synchronousMachine.getSynchronousMachineId(),
        "DeleteSynchronousMachineCommand identifier should not be null");
  }

  /** handles fetchOne validation for a SynchronousMachine */
  public void validate(SynchronousMachineFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "SynchronousMachineFetchOneSummary should not be null");
    Assert.notNull(
        summary.getSynchronousMachineId(),
        "SynchronousMachineFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Earthing validation for a SynchronousMachine
   *
   * @param command AssignEarthingToSynchronousMachineCommand
   */
  public void validate(AssignEarthingToSynchronousMachineCommand command) throws Exception {
    Assert.notNull(command, "AssignEarthingToSynchronousMachineCommand should not be null");
    Assert.notNull(
        command.getSynchronousMachineId(),
        "AssignEarthingToSynchronousMachineCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignEarthingToSynchronousMachineCommand assignment should not be null");
  }

  /**
   * handles unassign Earthing validation for a SynchronousMachine
   *
   * @param command UnAssignEarthingFromSynchronousMachineCommand
   */
  public void validate(UnAssignEarthingFromSynchronousMachineCommand command) throws Exception {
    Assert.notNull(command, "UnAssignEarthingFromSynchronousMachineCommand should not be null");
    Assert.notNull(
        command.getSynchronousMachineId(),
        "UnAssignEarthingFromSynchronousMachineCommand identifier should not be null");
  }
  /**
   * handles assign EarthingStarPointR validation for a SynchronousMachine
   *
   * @param command AssignEarthingStarPointRToSynchronousMachineCommand
   */
  public void validate(AssignEarthingStarPointRToSynchronousMachineCommand command)
      throws Exception {
    Assert.notNull(
        command, "AssignEarthingStarPointRToSynchronousMachineCommand should not be null");
    Assert.notNull(
        command.getSynchronousMachineId(),
        "AssignEarthingStarPointRToSynchronousMachineCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignEarthingStarPointRToSynchronousMachineCommand assignment should not be null");
  }

  /**
   * handles unassign EarthingStarPointR validation for a SynchronousMachine
   *
   * @param command UnAssignEarthingStarPointRFromSynchronousMachineCommand
   */
  public void validate(UnAssignEarthingStarPointRFromSynchronousMachineCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignEarthingStarPointRFromSynchronousMachineCommand should not be null");
    Assert.notNull(
        command.getSynchronousMachineId(),
        "UnAssignEarthingStarPointRFromSynchronousMachineCommand identifier should not be null");
  }
  /**
   * handles assign EarthingStarPointX validation for a SynchronousMachine
   *
   * @param command AssignEarthingStarPointXToSynchronousMachineCommand
   */
  public void validate(AssignEarthingStarPointXToSynchronousMachineCommand command)
      throws Exception {
    Assert.notNull(
        command, "AssignEarthingStarPointXToSynchronousMachineCommand should not be null");
    Assert.notNull(
        command.getSynchronousMachineId(),
        "AssignEarthingStarPointXToSynchronousMachineCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignEarthingStarPointXToSynchronousMachineCommand assignment should not be null");
  }

  /**
   * handles unassign EarthingStarPointX validation for a SynchronousMachine
   *
   * @param command UnAssignEarthingStarPointXFromSynchronousMachineCommand
   */
  public void validate(UnAssignEarthingStarPointXFromSynchronousMachineCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignEarthingStarPointXFromSynchronousMachineCommand should not be null");
    Assert.notNull(
        command.getSynchronousMachineId(),
        "UnAssignEarthingStarPointXFromSynchronousMachineCommand identifier should not be null");
  }
  /**
   * handles assign Ikk validation for a SynchronousMachine
   *
   * @param command AssignIkkToSynchronousMachineCommand
   */
  public void validate(AssignIkkToSynchronousMachineCommand command) throws Exception {
    Assert.notNull(command, "AssignIkkToSynchronousMachineCommand should not be null");
    Assert.notNull(
        command.getSynchronousMachineId(),
        "AssignIkkToSynchronousMachineCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignIkkToSynchronousMachineCommand assignment should not be null");
  }

  /**
   * handles unassign Ikk validation for a SynchronousMachine
   *
   * @param command UnAssignIkkFromSynchronousMachineCommand
   */
  public void validate(UnAssignIkkFromSynchronousMachineCommand command) throws Exception {
    Assert.notNull(command, "UnAssignIkkFromSynchronousMachineCommand should not be null");
    Assert.notNull(
        command.getSynchronousMachineId(),
        "UnAssignIkkFromSynchronousMachineCommand identifier should not be null");
  }
  /**
   * handles assign MaxQ validation for a SynchronousMachine
   *
   * @param command AssignMaxQToSynchronousMachineCommand
   */
  public void validate(AssignMaxQToSynchronousMachineCommand command) throws Exception {
    Assert.notNull(command, "AssignMaxQToSynchronousMachineCommand should not be null");
    Assert.notNull(
        command.getSynchronousMachineId(),
        "AssignMaxQToSynchronousMachineCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignMaxQToSynchronousMachineCommand assignment should not be null");
  }

  /**
   * handles unassign MaxQ validation for a SynchronousMachine
   *
   * @param command UnAssignMaxQFromSynchronousMachineCommand
   */
  public void validate(UnAssignMaxQFromSynchronousMachineCommand command) throws Exception {
    Assert.notNull(command, "UnAssignMaxQFromSynchronousMachineCommand should not be null");
    Assert.notNull(
        command.getSynchronousMachineId(),
        "UnAssignMaxQFromSynchronousMachineCommand identifier should not be null");
  }
  /**
   * handles assign MinQ validation for a SynchronousMachine
   *
   * @param command AssignMinQToSynchronousMachineCommand
   */
  public void validate(AssignMinQToSynchronousMachineCommand command) throws Exception {
    Assert.notNull(command, "AssignMinQToSynchronousMachineCommand should not be null");
    Assert.notNull(
        command.getSynchronousMachineId(),
        "AssignMinQToSynchronousMachineCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignMinQToSynchronousMachineCommand assignment should not be null");
  }

  /**
   * handles unassign MinQ validation for a SynchronousMachine
   *
   * @param command UnAssignMinQFromSynchronousMachineCommand
   */
  public void validate(UnAssignMinQFromSynchronousMachineCommand command) throws Exception {
    Assert.notNull(command, "UnAssignMinQFromSynchronousMachineCommand should not be null");
    Assert.notNull(
        command.getSynchronousMachineId(),
        "UnAssignMinQFromSynchronousMachineCommand identifier should not be null");
  }
  /**
   * handles assign Mu validation for a SynchronousMachine
   *
   * @param command AssignMuToSynchronousMachineCommand
   */
  public void validate(AssignMuToSynchronousMachineCommand command) throws Exception {
    Assert.notNull(command, "AssignMuToSynchronousMachineCommand should not be null");
    Assert.notNull(
        command.getSynchronousMachineId(),
        "AssignMuToSynchronousMachineCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignMuToSynchronousMachineCommand assignment should not be null");
  }

  /**
   * handles unassign Mu validation for a SynchronousMachine
   *
   * @param command UnAssignMuFromSynchronousMachineCommand
   */
  public void validate(UnAssignMuFromSynchronousMachineCommand command) throws Exception {
    Assert.notNull(command, "UnAssignMuFromSynchronousMachineCommand should not be null");
    Assert.notNull(
        command.getSynchronousMachineId(),
        "UnAssignMuFromSynchronousMachineCommand identifier should not be null");
  }
  /**
   * handles assign QPercent validation for a SynchronousMachine
   *
   * @param command AssignQPercentToSynchronousMachineCommand
   */
  public void validate(AssignQPercentToSynchronousMachineCommand command) throws Exception {
    Assert.notNull(command, "AssignQPercentToSynchronousMachineCommand should not be null");
    Assert.notNull(
        command.getSynchronousMachineId(),
        "AssignQPercentToSynchronousMachineCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignQPercentToSynchronousMachineCommand assignment should not be null");
  }

  /**
   * handles unassign QPercent validation for a SynchronousMachine
   *
   * @param command UnAssignQPercentFromSynchronousMachineCommand
   */
  public void validate(UnAssignQPercentFromSynchronousMachineCommand command) throws Exception {
    Assert.notNull(command, "UnAssignQPercentFromSynchronousMachineCommand should not be null");
    Assert.notNull(
        command.getSynchronousMachineId(),
        "UnAssignQPercentFromSynchronousMachineCommand identifier should not be null");
  }
  /**
   * handles assign R validation for a SynchronousMachine
   *
   * @param command AssignRToSynchronousMachineCommand
   */
  public void validate(AssignRToSynchronousMachineCommand command) throws Exception {
    Assert.notNull(command, "AssignRToSynchronousMachineCommand should not be null");
    Assert.notNull(
        command.getSynchronousMachineId(),
        "AssignRToSynchronousMachineCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignRToSynchronousMachineCommand assignment should not be null");
  }

  /**
   * handles unassign R validation for a SynchronousMachine
   *
   * @param command UnAssignRFromSynchronousMachineCommand
   */
  public void validate(UnAssignRFromSynchronousMachineCommand command) throws Exception {
    Assert.notNull(command, "UnAssignRFromSynchronousMachineCommand should not be null");
    Assert.notNull(
        command.getSynchronousMachineId(),
        "UnAssignRFromSynchronousMachineCommand identifier should not be null");
  }
  /**
   * handles assign R0 validation for a SynchronousMachine
   *
   * @param command AssignR0ToSynchronousMachineCommand
   */
  public void validate(AssignR0ToSynchronousMachineCommand command) throws Exception {
    Assert.notNull(command, "AssignR0ToSynchronousMachineCommand should not be null");
    Assert.notNull(
        command.getSynchronousMachineId(),
        "AssignR0ToSynchronousMachineCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignR0ToSynchronousMachineCommand assignment should not be null");
  }

  /**
   * handles unassign R0 validation for a SynchronousMachine
   *
   * @param command UnAssignR0FromSynchronousMachineCommand
   */
  public void validate(UnAssignR0FromSynchronousMachineCommand command) throws Exception {
    Assert.notNull(command, "UnAssignR0FromSynchronousMachineCommand should not be null");
    Assert.notNull(
        command.getSynchronousMachineId(),
        "UnAssignR0FromSynchronousMachineCommand identifier should not be null");
  }
  /**
   * handles assign R2 validation for a SynchronousMachine
   *
   * @param command AssignR2ToSynchronousMachineCommand
   */
  public void validate(AssignR2ToSynchronousMachineCommand command) throws Exception {
    Assert.notNull(command, "AssignR2ToSynchronousMachineCommand should not be null");
    Assert.notNull(
        command.getSynchronousMachineId(),
        "AssignR2ToSynchronousMachineCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignR2ToSynchronousMachineCommand assignment should not be null");
  }

  /**
   * handles unassign R2 validation for a SynchronousMachine
   *
   * @param command UnAssignR2FromSynchronousMachineCommand
   */
  public void validate(UnAssignR2FromSynchronousMachineCommand command) throws Exception {
    Assert.notNull(command, "UnAssignR2FromSynchronousMachineCommand should not be null");
    Assert.notNull(
        command.getSynchronousMachineId(),
        "UnAssignR2FromSynchronousMachineCommand identifier should not be null");
  }
  /**
   * handles assign SatDirectSubtransX validation for a SynchronousMachine
   *
   * @param command AssignSatDirectSubtransXToSynchronousMachineCommand
   */
  public void validate(AssignSatDirectSubtransXToSynchronousMachineCommand command)
      throws Exception {
    Assert.notNull(
        command, "AssignSatDirectSubtransXToSynchronousMachineCommand should not be null");
    Assert.notNull(
        command.getSynchronousMachineId(),
        "AssignSatDirectSubtransXToSynchronousMachineCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignSatDirectSubtransXToSynchronousMachineCommand assignment should not be null");
  }

  /**
   * handles unassign SatDirectSubtransX validation for a SynchronousMachine
   *
   * @param command UnAssignSatDirectSubtransXFromSynchronousMachineCommand
   */
  public void validate(UnAssignSatDirectSubtransXFromSynchronousMachineCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignSatDirectSubtransXFromSynchronousMachineCommand should not be null");
    Assert.notNull(
        command.getSynchronousMachineId(),
        "UnAssignSatDirectSubtransXFromSynchronousMachineCommand identifier should not be null");
  }
  /**
   * handles assign SatDirectSyncX validation for a SynchronousMachine
   *
   * @param command AssignSatDirectSyncXToSynchronousMachineCommand
   */
  public void validate(AssignSatDirectSyncXToSynchronousMachineCommand command) throws Exception {
    Assert.notNull(command, "AssignSatDirectSyncXToSynchronousMachineCommand should not be null");
    Assert.notNull(
        command.getSynchronousMachineId(),
        "AssignSatDirectSyncXToSynchronousMachineCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignSatDirectSyncXToSynchronousMachineCommand assignment should not be null");
  }

  /**
   * handles unassign SatDirectSyncX validation for a SynchronousMachine
   *
   * @param command UnAssignSatDirectSyncXFromSynchronousMachineCommand
   */
  public void validate(UnAssignSatDirectSyncXFromSynchronousMachineCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignSatDirectSyncXFromSynchronousMachineCommand should not be null");
    Assert.notNull(
        command.getSynchronousMachineId(),
        "UnAssignSatDirectSyncXFromSynchronousMachineCommand identifier should not be null");
  }
  /**
   * handles assign SatDirectTransX validation for a SynchronousMachine
   *
   * @param command AssignSatDirectTransXToSynchronousMachineCommand
   */
  public void validate(AssignSatDirectTransXToSynchronousMachineCommand command) throws Exception {
    Assert.notNull(command, "AssignSatDirectTransXToSynchronousMachineCommand should not be null");
    Assert.notNull(
        command.getSynchronousMachineId(),
        "AssignSatDirectTransXToSynchronousMachineCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignSatDirectTransXToSynchronousMachineCommand assignment should not be null");
  }

  /**
   * handles unassign SatDirectTransX validation for a SynchronousMachine
   *
   * @param command UnAssignSatDirectTransXFromSynchronousMachineCommand
   */
  public void validate(UnAssignSatDirectTransXFromSynchronousMachineCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignSatDirectTransXFromSynchronousMachineCommand should not be null");
    Assert.notNull(
        command.getSynchronousMachineId(),
        "UnAssignSatDirectTransXFromSynchronousMachineCommand identifier should not be null");
  }
  /**
   * handles assign VoltageRegulationRange validation for a SynchronousMachine
   *
   * @param command AssignVoltageRegulationRangeToSynchronousMachineCommand
   */
  public void validate(AssignVoltageRegulationRangeToSynchronousMachineCommand command)
      throws Exception {
    Assert.notNull(
        command, "AssignVoltageRegulationRangeToSynchronousMachineCommand should not be null");
    Assert.notNull(
        command.getSynchronousMachineId(),
        "AssignVoltageRegulationRangeToSynchronousMachineCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignVoltageRegulationRangeToSynchronousMachineCommand assignment should not be null");
  }

  /**
   * handles unassign VoltageRegulationRange validation for a SynchronousMachine
   *
   * @param command UnAssignVoltageRegulationRangeFromSynchronousMachineCommand
   */
  public void validate(UnAssignVoltageRegulationRangeFromSynchronousMachineCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignVoltageRegulationRangeFromSynchronousMachineCommand should not be null");
    Assert.notNull(
        command.getSynchronousMachineId(),
        "UnAssignVoltageRegulationRangeFromSynchronousMachineCommand identifier should not be null");
  }
  /**
   * handles assign X0 validation for a SynchronousMachine
   *
   * @param command AssignX0ToSynchronousMachineCommand
   */
  public void validate(AssignX0ToSynchronousMachineCommand command) throws Exception {
    Assert.notNull(command, "AssignX0ToSynchronousMachineCommand should not be null");
    Assert.notNull(
        command.getSynchronousMachineId(),
        "AssignX0ToSynchronousMachineCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignX0ToSynchronousMachineCommand assignment should not be null");
  }

  /**
   * handles unassign X0 validation for a SynchronousMachine
   *
   * @param command UnAssignX0FromSynchronousMachineCommand
   */
  public void validate(UnAssignX0FromSynchronousMachineCommand command) throws Exception {
    Assert.notNull(command, "UnAssignX0FromSynchronousMachineCommand should not be null");
    Assert.notNull(
        command.getSynchronousMachineId(),
        "UnAssignX0FromSynchronousMachineCommand identifier should not be null");
  }
  /**
   * handles assign X2 validation for a SynchronousMachine
   *
   * @param command AssignX2ToSynchronousMachineCommand
   */
  public void validate(AssignX2ToSynchronousMachineCommand command) throws Exception {
    Assert.notNull(command, "AssignX2ToSynchronousMachineCommand should not be null");
    Assert.notNull(
        command.getSynchronousMachineId(),
        "AssignX2ToSynchronousMachineCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignX2ToSynchronousMachineCommand assignment should not be null");
  }

  /**
   * handles unassign X2 validation for a SynchronousMachine
   *
   * @param command UnAssignX2FromSynchronousMachineCommand
   */
  public void validate(UnAssignX2FromSynchronousMachineCommand command) throws Exception {
    Assert.notNull(command, "UnAssignX2FromSynchronousMachineCommand should not be null");
    Assert.notNull(
        command.getSynchronousMachineId(),
        "UnAssignX2FromSynchronousMachineCommand identifier should not be null");
  }

  /**
   * handles add to InitiallyUsedBySynchronousMachines validation for a SynchronousMachine
   *
   * @param command AssignInitiallyUsedBySynchronousMachinesToSynchronousMachineCommand
   */
  public void validate(AssignInitiallyUsedBySynchronousMachinesToSynchronousMachineCommand command)
      throws Exception {
    Assert.notNull(
        command,
        "AssignInitiallyUsedBySynchronousMachinesToSynchronousMachineCommand should not be null");
    Assert.notNull(
        command.getSynchronousMachineId(),
        "AssignInitiallyUsedBySynchronousMachinesToSynchronousMachineCommand identifier should not be null");
    Assert.notNull(
        command.getAddTo(),
        "AssignInitiallyUsedBySynchronousMachinesToSynchronousMachineCommand addTo attribute should not be null");
  }

  /**
   * handles remove from InitiallyUsedBySynchronousMachines validation for a SynchronousMachine
   *
   * @param command RemoveInitiallyUsedBySynchronousMachinesFromSynchronousMachineCommand
   */
  public void validate(
      RemoveInitiallyUsedBySynchronousMachinesFromSynchronousMachineCommand command)
      throws Exception {
    Assert.notNull(
        command,
        "RemoveInitiallyUsedBySynchronousMachinesFromSynchronousMachineCommand should not be null");
    Assert.notNull(
        command.getSynchronousMachineId(),
        "RemoveInitiallyUsedBySynchronousMachinesFromSynchronousMachineCommand identifier should not be null");
    Assert.notNull(
        command.getRemoveFrom(),
        "RemoveInitiallyUsedBySynchronousMachinesFromSynchronousMachineCommand removeFrom attribute should not be null");
    Assert.notNull(
        command.getRemoveFrom().getSynchronousMachineId(),
        "RemoveInitiallyUsedBySynchronousMachinesFromSynchronousMachineCommand removeFrom attribubte identifier should not be null");
  }
}
