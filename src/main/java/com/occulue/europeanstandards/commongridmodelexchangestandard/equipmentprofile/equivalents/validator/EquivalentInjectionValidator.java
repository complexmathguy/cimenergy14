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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.equivalents.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class EquivalentInjectionValidator {

  /** default constructor */
  protected EquivalentInjectionValidator() {}

  /** factory method */
  public static EquivalentInjectionValidator getInstance() {
    return new EquivalentInjectionValidator();
  }

  /** handles creation validation for a EquivalentInjection */
  public void validate(CreateEquivalentInjectionCommand equivalentInjection) throws Exception {
    Assert.notNull(equivalentInjection, "CreateEquivalentInjectionCommand should not be null");
    //		Assert.isNull( equivalentInjection.getEquivalentInjectionId(),
    // "CreateEquivalentInjectionCommand identifier should be null" );
  }

  /** handles update validation for a EquivalentInjection */
  public void validate(UpdateEquivalentInjectionCommand equivalentInjection) throws Exception {
    Assert.notNull(equivalentInjection, "UpdateEquivalentInjectionCommand should not be null");
    Assert.notNull(
        equivalentInjection.getEquivalentInjectionId(),
        "UpdateEquivalentInjectionCommand identifier should not be null");
  }

  /** handles delete validation for a EquivalentInjection */
  public void validate(DeleteEquivalentInjectionCommand equivalentInjection) throws Exception {
    Assert.notNull(equivalentInjection, "{commandAlias} should not be null");
    Assert.notNull(
        equivalentInjection.getEquivalentInjectionId(),
        "DeleteEquivalentInjectionCommand identifier should not be null");
  }

  /** handles fetchOne validation for a EquivalentInjection */
  public void validate(EquivalentInjectionFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "EquivalentInjectionFetchOneSummary should not be null");
    Assert.notNull(
        summary.getEquivalentInjectionId(),
        "EquivalentInjectionFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign MaxP validation for a EquivalentInjection
   *
   * @param command AssignMaxPToEquivalentInjectionCommand
   */
  public void validate(AssignMaxPToEquivalentInjectionCommand command) throws Exception {
    Assert.notNull(command, "AssignMaxPToEquivalentInjectionCommand should not be null");
    Assert.notNull(
        command.getEquivalentInjectionId(),
        "AssignMaxPToEquivalentInjectionCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignMaxPToEquivalentInjectionCommand assignment should not be null");
  }

  /**
   * handles unassign MaxP validation for a EquivalentInjection
   *
   * @param command UnAssignMaxPFromEquivalentInjectionCommand
   */
  public void validate(UnAssignMaxPFromEquivalentInjectionCommand command) throws Exception {
    Assert.notNull(command, "UnAssignMaxPFromEquivalentInjectionCommand should not be null");
    Assert.notNull(
        command.getEquivalentInjectionId(),
        "UnAssignMaxPFromEquivalentInjectionCommand identifier should not be null");
  }
  /**
   * handles assign MaxQ validation for a EquivalentInjection
   *
   * @param command AssignMaxQToEquivalentInjectionCommand
   */
  public void validate(AssignMaxQToEquivalentInjectionCommand command) throws Exception {
    Assert.notNull(command, "AssignMaxQToEquivalentInjectionCommand should not be null");
    Assert.notNull(
        command.getEquivalentInjectionId(),
        "AssignMaxQToEquivalentInjectionCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignMaxQToEquivalentInjectionCommand assignment should not be null");
  }

  /**
   * handles unassign MaxQ validation for a EquivalentInjection
   *
   * @param command UnAssignMaxQFromEquivalentInjectionCommand
   */
  public void validate(UnAssignMaxQFromEquivalentInjectionCommand command) throws Exception {
    Assert.notNull(command, "UnAssignMaxQFromEquivalentInjectionCommand should not be null");
    Assert.notNull(
        command.getEquivalentInjectionId(),
        "UnAssignMaxQFromEquivalentInjectionCommand identifier should not be null");
  }
  /**
   * handles assign MinP validation for a EquivalentInjection
   *
   * @param command AssignMinPToEquivalentInjectionCommand
   */
  public void validate(AssignMinPToEquivalentInjectionCommand command) throws Exception {
    Assert.notNull(command, "AssignMinPToEquivalentInjectionCommand should not be null");
    Assert.notNull(
        command.getEquivalentInjectionId(),
        "AssignMinPToEquivalentInjectionCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignMinPToEquivalentInjectionCommand assignment should not be null");
  }

  /**
   * handles unassign MinP validation for a EquivalentInjection
   *
   * @param command UnAssignMinPFromEquivalentInjectionCommand
   */
  public void validate(UnAssignMinPFromEquivalentInjectionCommand command) throws Exception {
    Assert.notNull(command, "UnAssignMinPFromEquivalentInjectionCommand should not be null");
    Assert.notNull(
        command.getEquivalentInjectionId(),
        "UnAssignMinPFromEquivalentInjectionCommand identifier should not be null");
  }
  /**
   * handles assign MinQ validation for a EquivalentInjection
   *
   * @param command AssignMinQToEquivalentInjectionCommand
   */
  public void validate(AssignMinQToEquivalentInjectionCommand command) throws Exception {
    Assert.notNull(command, "AssignMinQToEquivalentInjectionCommand should not be null");
    Assert.notNull(
        command.getEquivalentInjectionId(),
        "AssignMinQToEquivalentInjectionCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignMinQToEquivalentInjectionCommand assignment should not be null");
  }

  /**
   * handles unassign MinQ validation for a EquivalentInjection
   *
   * @param command UnAssignMinQFromEquivalentInjectionCommand
   */
  public void validate(UnAssignMinQFromEquivalentInjectionCommand command) throws Exception {
    Assert.notNull(command, "UnAssignMinQFromEquivalentInjectionCommand should not be null");
    Assert.notNull(
        command.getEquivalentInjectionId(),
        "UnAssignMinQFromEquivalentInjectionCommand identifier should not be null");
  }
  /**
   * handles assign R validation for a EquivalentInjection
   *
   * @param command AssignRToEquivalentInjectionCommand
   */
  public void validate(AssignRToEquivalentInjectionCommand command) throws Exception {
    Assert.notNull(command, "AssignRToEquivalentInjectionCommand should not be null");
    Assert.notNull(
        command.getEquivalentInjectionId(),
        "AssignRToEquivalentInjectionCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignRToEquivalentInjectionCommand assignment should not be null");
  }

  /**
   * handles unassign R validation for a EquivalentInjection
   *
   * @param command UnAssignRFromEquivalentInjectionCommand
   */
  public void validate(UnAssignRFromEquivalentInjectionCommand command) throws Exception {
    Assert.notNull(command, "UnAssignRFromEquivalentInjectionCommand should not be null");
    Assert.notNull(
        command.getEquivalentInjectionId(),
        "UnAssignRFromEquivalentInjectionCommand identifier should not be null");
  }
  /**
   * handles assign R0 validation for a EquivalentInjection
   *
   * @param command AssignR0ToEquivalentInjectionCommand
   */
  public void validate(AssignR0ToEquivalentInjectionCommand command) throws Exception {
    Assert.notNull(command, "AssignR0ToEquivalentInjectionCommand should not be null");
    Assert.notNull(
        command.getEquivalentInjectionId(),
        "AssignR0ToEquivalentInjectionCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignR0ToEquivalentInjectionCommand assignment should not be null");
  }

  /**
   * handles unassign R0 validation for a EquivalentInjection
   *
   * @param command UnAssignR0FromEquivalentInjectionCommand
   */
  public void validate(UnAssignR0FromEquivalentInjectionCommand command) throws Exception {
    Assert.notNull(command, "UnAssignR0FromEquivalentInjectionCommand should not be null");
    Assert.notNull(
        command.getEquivalentInjectionId(),
        "UnAssignR0FromEquivalentInjectionCommand identifier should not be null");
  }
  /**
   * handles assign R2 validation for a EquivalentInjection
   *
   * @param command AssignR2ToEquivalentInjectionCommand
   */
  public void validate(AssignR2ToEquivalentInjectionCommand command) throws Exception {
    Assert.notNull(command, "AssignR2ToEquivalentInjectionCommand should not be null");
    Assert.notNull(
        command.getEquivalentInjectionId(),
        "AssignR2ToEquivalentInjectionCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignR2ToEquivalentInjectionCommand assignment should not be null");
  }

  /**
   * handles unassign R2 validation for a EquivalentInjection
   *
   * @param command UnAssignR2FromEquivalentInjectionCommand
   */
  public void validate(UnAssignR2FromEquivalentInjectionCommand command) throws Exception {
    Assert.notNull(command, "UnAssignR2FromEquivalentInjectionCommand should not be null");
    Assert.notNull(
        command.getEquivalentInjectionId(),
        "UnAssignR2FromEquivalentInjectionCommand identifier should not be null");
  }
  /**
   * handles assign RegulationCapability validation for a EquivalentInjection
   *
   * @param command AssignRegulationCapabilityToEquivalentInjectionCommand
   */
  public void validate(AssignRegulationCapabilityToEquivalentInjectionCommand command)
      throws Exception {
    Assert.notNull(
        command, "AssignRegulationCapabilityToEquivalentInjectionCommand should not be null");
    Assert.notNull(
        command.getEquivalentInjectionId(),
        "AssignRegulationCapabilityToEquivalentInjectionCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignRegulationCapabilityToEquivalentInjectionCommand assignment should not be null");
  }

  /**
   * handles unassign RegulationCapability validation for a EquivalentInjection
   *
   * @param command UnAssignRegulationCapabilityFromEquivalentInjectionCommand
   */
  public void validate(UnAssignRegulationCapabilityFromEquivalentInjectionCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignRegulationCapabilityFromEquivalentInjectionCommand should not be null");
    Assert.notNull(
        command.getEquivalentInjectionId(),
        "UnAssignRegulationCapabilityFromEquivalentInjectionCommand identifier should not be null");
  }
  /**
   * handles assign X validation for a EquivalentInjection
   *
   * @param command AssignXToEquivalentInjectionCommand
   */
  public void validate(AssignXToEquivalentInjectionCommand command) throws Exception {
    Assert.notNull(command, "AssignXToEquivalentInjectionCommand should not be null");
    Assert.notNull(
        command.getEquivalentInjectionId(),
        "AssignXToEquivalentInjectionCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignXToEquivalentInjectionCommand assignment should not be null");
  }

  /**
   * handles unassign X validation for a EquivalentInjection
   *
   * @param command UnAssignXFromEquivalentInjectionCommand
   */
  public void validate(UnAssignXFromEquivalentInjectionCommand command) throws Exception {
    Assert.notNull(command, "UnAssignXFromEquivalentInjectionCommand should not be null");
    Assert.notNull(
        command.getEquivalentInjectionId(),
        "UnAssignXFromEquivalentInjectionCommand identifier should not be null");
  }
  /**
   * handles assign X0 validation for a EquivalentInjection
   *
   * @param command AssignX0ToEquivalentInjectionCommand
   */
  public void validate(AssignX0ToEquivalentInjectionCommand command) throws Exception {
    Assert.notNull(command, "AssignX0ToEquivalentInjectionCommand should not be null");
    Assert.notNull(
        command.getEquivalentInjectionId(),
        "AssignX0ToEquivalentInjectionCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignX0ToEquivalentInjectionCommand assignment should not be null");
  }

  /**
   * handles unassign X0 validation for a EquivalentInjection
   *
   * @param command UnAssignX0FromEquivalentInjectionCommand
   */
  public void validate(UnAssignX0FromEquivalentInjectionCommand command) throws Exception {
    Assert.notNull(command, "UnAssignX0FromEquivalentInjectionCommand should not be null");
    Assert.notNull(
        command.getEquivalentInjectionId(),
        "UnAssignX0FromEquivalentInjectionCommand identifier should not be null");
  }
  /**
   * handles assign X2 validation for a EquivalentInjection
   *
   * @param command AssignX2ToEquivalentInjectionCommand
   */
  public void validate(AssignX2ToEquivalentInjectionCommand command) throws Exception {
    Assert.notNull(command, "AssignX2ToEquivalentInjectionCommand should not be null");
    Assert.notNull(
        command.getEquivalentInjectionId(),
        "AssignX2ToEquivalentInjectionCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignX2ToEquivalentInjectionCommand assignment should not be null");
  }

  /**
   * handles unassign X2 validation for a EquivalentInjection
   *
   * @param command UnAssignX2FromEquivalentInjectionCommand
   */
  public void validate(UnAssignX2FromEquivalentInjectionCommand command) throws Exception {
    Assert.notNull(command, "UnAssignX2FromEquivalentInjectionCommand should not be null");
    Assert.notNull(
        command.getEquivalentInjectionId(),
        "UnAssignX2FromEquivalentInjectionCommand identifier should not be null");
  }

  /**
   * handles add to EquivalentInjection validation for a EquivalentInjection
   *
   * @param command AssignEquivalentInjectionToEquivalentInjectionCommand
   */
  public void validate(AssignEquivalentInjectionToEquivalentInjectionCommand command)
      throws Exception {
    Assert.notNull(
        command, "AssignEquivalentInjectionToEquivalentInjectionCommand should not be null");
    Assert.notNull(
        command.getEquivalentInjectionId(),
        "AssignEquivalentInjectionToEquivalentInjectionCommand identifier should not be null");
    Assert.notNull(
        command.getAddTo(),
        "AssignEquivalentInjectionToEquivalentInjectionCommand addTo attribute should not be null");
  }

  /**
   * handles remove from EquivalentInjection validation for a EquivalentInjection
   *
   * @param command RemoveEquivalentInjectionFromEquivalentInjectionCommand
   */
  public void validate(RemoveEquivalentInjectionFromEquivalentInjectionCommand command)
      throws Exception {
    Assert.notNull(
        command, "RemoveEquivalentInjectionFromEquivalentInjectionCommand should not be null");
    Assert.notNull(
        command.getEquivalentInjectionId(),
        "RemoveEquivalentInjectionFromEquivalentInjectionCommand identifier should not be null");
    Assert.notNull(
        command.getRemoveFrom(),
        "RemoveEquivalentInjectionFromEquivalentInjectionCommand removeFrom attribute should not be null");
    Assert.notNull(
        command.getRemoveFrom().getEquivalentInjectionId(),
        "RemoveEquivalentInjectionFromEquivalentInjectionCommand removeFrom attribubte identifier should not be null");
  }
}
