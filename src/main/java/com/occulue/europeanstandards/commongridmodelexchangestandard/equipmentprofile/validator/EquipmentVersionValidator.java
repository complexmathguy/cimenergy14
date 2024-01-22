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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class EquipmentVersionValidator {

  /** default constructor */
  protected EquipmentVersionValidator() {}

  /** factory method */
  public static EquipmentVersionValidator getInstance() {
    return new EquipmentVersionValidator();
  }

  /** handles creation validation for a EquipmentVersion */
  public void validate(CreateEquipmentVersionCommand equipmentVersion) throws Exception {
    Assert.notNull(equipmentVersion, "CreateEquipmentVersionCommand should not be null");
    //		Assert.isNull( equipmentVersion.getEquipmentVersionId(), "CreateEquipmentVersionCommand
    // identifier should be null" );
  }

  /** handles update validation for a EquipmentVersion */
  public void validate(UpdateEquipmentVersionCommand equipmentVersion) throws Exception {
    Assert.notNull(equipmentVersion, "UpdateEquipmentVersionCommand should not be null");
    Assert.notNull(
        equipmentVersion.getEquipmentVersionId(),
        "UpdateEquipmentVersionCommand identifier should not be null");
  }

  /** handles delete validation for a EquipmentVersion */
  public void validate(DeleteEquipmentVersionCommand equipmentVersion) throws Exception {
    Assert.notNull(equipmentVersion, "{commandAlias} should not be null");
    Assert.notNull(
        equipmentVersion.getEquipmentVersionId(),
        "DeleteEquipmentVersionCommand identifier should not be null");
  }

  /** handles fetchOne validation for a EquipmentVersion */
  public void validate(EquipmentVersionFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "EquipmentVersionFetchOneSummary should not be null");
    Assert.notNull(
        summary.getEquipmentVersionId(),
        "EquipmentVersionFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign BaseUML validation for a EquipmentVersion
   *
   * @param command AssignBaseUMLToEquipmentVersionCommand
   */
  public void validate(AssignBaseUMLToEquipmentVersionCommand command) throws Exception {
    Assert.notNull(command, "AssignBaseUMLToEquipmentVersionCommand should not be null");
    Assert.notNull(
        command.getEquipmentVersionId(),
        "AssignBaseUMLToEquipmentVersionCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignBaseUMLToEquipmentVersionCommand assignment should not be null");
  }

  /**
   * handles unassign BaseUML validation for a EquipmentVersion
   *
   * @param command UnAssignBaseUMLFromEquipmentVersionCommand
   */
  public void validate(UnAssignBaseUMLFromEquipmentVersionCommand command) throws Exception {
    Assert.notNull(command, "UnAssignBaseUMLFromEquipmentVersionCommand should not be null");
    Assert.notNull(
        command.getEquipmentVersionId(),
        "UnAssignBaseUMLFromEquipmentVersionCommand identifier should not be null");
  }
  /**
   * handles assign BaseURIcore validation for a EquipmentVersion
   *
   * @param command AssignBaseURIcoreToEquipmentVersionCommand
   */
  public void validate(AssignBaseURIcoreToEquipmentVersionCommand command) throws Exception {
    Assert.notNull(command, "AssignBaseURIcoreToEquipmentVersionCommand should not be null");
    Assert.notNull(
        command.getEquipmentVersionId(),
        "AssignBaseURIcoreToEquipmentVersionCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignBaseURIcoreToEquipmentVersionCommand assignment should not be null");
  }

  /**
   * handles unassign BaseURIcore validation for a EquipmentVersion
   *
   * @param command UnAssignBaseURIcoreFromEquipmentVersionCommand
   */
  public void validate(UnAssignBaseURIcoreFromEquipmentVersionCommand command) throws Exception {
    Assert.notNull(command, "UnAssignBaseURIcoreFromEquipmentVersionCommand should not be null");
    Assert.notNull(
        command.getEquipmentVersionId(),
        "UnAssignBaseURIcoreFromEquipmentVersionCommand identifier should not be null");
  }
  /**
   * handles assign BaseURIoperation validation for a EquipmentVersion
   *
   * @param command AssignBaseURIoperationToEquipmentVersionCommand
   */
  public void validate(AssignBaseURIoperationToEquipmentVersionCommand command) throws Exception {
    Assert.notNull(command, "AssignBaseURIoperationToEquipmentVersionCommand should not be null");
    Assert.notNull(
        command.getEquipmentVersionId(),
        "AssignBaseURIoperationToEquipmentVersionCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignBaseURIoperationToEquipmentVersionCommand assignment should not be null");
  }

  /**
   * handles unassign BaseURIoperation validation for a EquipmentVersion
   *
   * @param command UnAssignBaseURIoperationFromEquipmentVersionCommand
   */
  public void validate(UnAssignBaseURIoperationFromEquipmentVersionCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignBaseURIoperationFromEquipmentVersionCommand should not be null");
    Assert.notNull(
        command.getEquipmentVersionId(),
        "UnAssignBaseURIoperationFromEquipmentVersionCommand identifier should not be null");
  }
  /**
   * handles assign BaseURIshortCircuit validation for a EquipmentVersion
   *
   * @param command AssignBaseURIshortCircuitToEquipmentVersionCommand
   */
  public void validate(AssignBaseURIshortCircuitToEquipmentVersionCommand command)
      throws Exception {
    Assert.notNull(
        command, "AssignBaseURIshortCircuitToEquipmentVersionCommand should not be null");
    Assert.notNull(
        command.getEquipmentVersionId(),
        "AssignBaseURIshortCircuitToEquipmentVersionCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignBaseURIshortCircuitToEquipmentVersionCommand assignment should not be null");
  }

  /**
   * handles unassign BaseURIshortCircuit validation for a EquipmentVersion
   *
   * @param command UnAssignBaseURIshortCircuitFromEquipmentVersionCommand
   */
  public void validate(UnAssignBaseURIshortCircuitFromEquipmentVersionCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignBaseURIshortCircuitFromEquipmentVersionCommand should not be null");
    Assert.notNull(
        command.getEquipmentVersionId(),
        "UnAssignBaseURIshortCircuitFromEquipmentVersionCommand identifier should not be null");
  }
  /**
   * handles assign Date validation for a EquipmentVersion
   *
   * @param command AssignDateToEquipmentVersionCommand
   */
  public void validate(AssignDateToEquipmentVersionCommand command) throws Exception {
    Assert.notNull(command, "AssignDateToEquipmentVersionCommand should not be null");
    Assert.notNull(
        command.getEquipmentVersionId(),
        "AssignDateToEquipmentVersionCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignDateToEquipmentVersionCommand assignment should not be null");
  }

  /**
   * handles unassign Date validation for a EquipmentVersion
   *
   * @param command UnAssignDateFromEquipmentVersionCommand
   */
  public void validate(UnAssignDateFromEquipmentVersionCommand command) throws Exception {
    Assert.notNull(command, "UnAssignDateFromEquipmentVersionCommand should not be null");
    Assert.notNull(
        command.getEquipmentVersionId(),
        "UnAssignDateFromEquipmentVersionCommand identifier should not be null");
  }
  /**
   * handles assign DifferenceModelURI validation for a EquipmentVersion
   *
   * @param command AssignDifferenceModelURIToEquipmentVersionCommand
   */
  public void validate(AssignDifferenceModelURIToEquipmentVersionCommand command) throws Exception {
    Assert.notNull(command, "AssignDifferenceModelURIToEquipmentVersionCommand should not be null");
    Assert.notNull(
        command.getEquipmentVersionId(),
        "AssignDifferenceModelURIToEquipmentVersionCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignDifferenceModelURIToEquipmentVersionCommand assignment should not be null");
  }

  /**
   * handles unassign DifferenceModelURI validation for a EquipmentVersion
   *
   * @param command UnAssignDifferenceModelURIFromEquipmentVersionCommand
   */
  public void validate(UnAssignDifferenceModelURIFromEquipmentVersionCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignDifferenceModelURIFromEquipmentVersionCommand should not be null");
    Assert.notNull(
        command.getEquipmentVersionId(),
        "UnAssignDifferenceModelURIFromEquipmentVersionCommand identifier should not be null");
  }
  /**
   * handles assign EntsoeUML validation for a EquipmentVersion
   *
   * @param command AssignEntsoeUMLToEquipmentVersionCommand
   */
  public void validate(AssignEntsoeUMLToEquipmentVersionCommand command) throws Exception {
    Assert.notNull(command, "AssignEntsoeUMLToEquipmentVersionCommand should not be null");
    Assert.notNull(
        command.getEquipmentVersionId(),
        "AssignEntsoeUMLToEquipmentVersionCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignEntsoeUMLToEquipmentVersionCommand assignment should not be null");
  }

  /**
   * handles unassign EntsoeUML validation for a EquipmentVersion
   *
   * @param command UnAssignEntsoeUMLFromEquipmentVersionCommand
   */
  public void validate(UnAssignEntsoeUMLFromEquipmentVersionCommand command) throws Exception {
    Assert.notNull(command, "UnAssignEntsoeUMLFromEquipmentVersionCommand should not be null");
    Assert.notNull(
        command.getEquipmentVersionId(),
        "UnAssignEntsoeUMLFromEquipmentVersionCommand identifier should not be null");
  }
  /**
   * handles assign EntsoeURIcore validation for a EquipmentVersion
   *
   * @param command AssignEntsoeURIcoreToEquipmentVersionCommand
   */
  public void validate(AssignEntsoeURIcoreToEquipmentVersionCommand command) throws Exception {
    Assert.notNull(command, "AssignEntsoeURIcoreToEquipmentVersionCommand should not be null");
    Assert.notNull(
        command.getEquipmentVersionId(),
        "AssignEntsoeURIcoreToEquipmentVersionCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignEntsoeURIcoreToEquipmentVersionCommand assignment should not be null");
  }

  /**
   * handles unassign EntsoeURIcore validation for a EquipmentVersion
   *
   * @param command UnAssignEntsoeURIcoreFromEquipmentVersionCommand
   */
  public void validate(UnAssignEntsoeURIcoreFromEquipmentVersionCommand command) throws Exception {
    Assert.notNull(command, "UnAssignEntsoeURIcoreFromEquipmentVersionCommand should not be null");
    Assert.notNull(
        command.getEquipmentVersionId(),
        "UnAssignEntsoeURIcoreFromEquipmentVersionCommand identifier should not be null");
  }
  /**
   * handles assign EntsoeURIoperation validation for a EquipmentVersion
   *
   * @param command AssignEntsoeURIoperationToEquipmentVersionCommand
   */
  public void validate(AssignEntsoeURIoperationToEquipmentVersionCommand command) throws Exception {
    Assert.notNull(command, "AssignEntsoeURIoperationToEquipmentVersionCommand should not be null");
    Assert.notNull(
        command.getEquipmentVersionId(),
        "AssignEntsoeURIoperationToEquipmentVersionCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignEntsoeURIoperationToEquipmentVersionCommand assignment should not be null");
  }

  /**
   * handles unassign EntsoeURIoperation validation for a EquipmentVersion
   *
   * @param command UnAssignEntsoeURIoperationFromEquipmentVersionCommand
   */
  public void validate(UnAssignEntsoeURIoperationFromEquipmentVersionCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignEntsoeURIoperationFromEquipmentVersionCommand should not be null");
    Assert.notNull(
        command.getEquipmentVersionId(),
        "UnAssignEntsoeURIoperationFromEquipmentVersionCommand identifier should not be null");
  }
  /**
   * handles assign EntsoeURIshortCircuit validation for a EquipmentVersion
   *
   * @param command AssignEntsoeURIshortCircuitToEquipmentVersionCommand
   */
  public void validate(AssignEntsoeURIshortCircuitToEquipmentVersionCommand command)
      throws Exception {
    Assert.notNull(
        command, "AssignEntsoeURIshortCircuitToEquipmentVersionCommand should not be null");
    Assert.notNull(
        command.getEquipmentVersionId(),
        "AssignEntsoeURIshortCircuitToEquipmentVersionCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignEntsoeURIshortCircuitToEquipmentVersionCommand assignment should not be null");
  }

  /**
   * handles unassign EntsoeURIshortCircuit validation for a EquipmentVersion
   *
   * @param command UnAssignEntsoeURIshortCircuitFromEquipmentVersionCommand
   */
  public void validate(UnAssignEntsoeURIshortCircuitFromEquipmentVersionCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignEntsoeURIshortCircuitFromEquipmentVersionCommand should not be null");
    Assert.notNull(
        command.getEquipmentVersionId(),
        "UnAssignEntsoeURIshortCircuitFromEquipmentVersionCommand identifier should not be null");
  }
  /**
   * handles assign ModelDescriptionURI validation for a EquipmentVersion
   *
   * @param command AssignModelDescriptionURIToEquipmentVersionCommand
   */
  public void validate(AssignModelDescriptionURIToEquipmentVersionCommand command)
      throws Exception {
    Assert.notNull(
        command, "AssignModelDescriptionURIToEquipmentVersionCommand should not be null");
    Assert.notNull(
        command.getEquipmentVersionId(),
        "AssignModelDescriptionURIToEquipmentVersionCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignModelDescriptionURIToEquipmentVersionCommand assignment should not be null");
  }

  /**
   * handles unassign ModelDescriptionURI validation for a EquipmentVersion
   *
   * @param command UnAssignModelDescriptionURIFromEquipmentVersionCommand
   */
  public void validate(UnAssignModelDescriptionURIFromEquipmentVersionCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignModelDescriptionURIFromEquipmentVersionCommand should not be null");
    Assert.notNull(
        command.getEquipmentVersionId(),
        "UnAssignModelDescriptionURIFromEquipmentVersionCommand identifier should not be null");
  }
  /**
   * handles assign NamespaceRDF validation for a EquipmentVersion
   *
   * @param command AssignNamespaceRDFToEquipmentVersionCommand
   */
  public void validate(AssignNamespaceRDFToEquipmentVersionCommand command) throws Exception {
    Assert.notNull(command, "AssignNamespaceRDFToEquipmentVersionCommand should not be null");
    Assert.notNull(
        command.getEquipmentVersionId(),
        "AssignNamespaceRDFToEquipmentVersionCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignNamespaceRDFToEquipmentVersionCommand assignment should not be null");
  }

  /**
   * handles unassign NamespaceRDF validation for a EquipmentVersion
   *
   * @param command UnAssignNamespaceRDFFromEquipmentVersionCommand
   */
  public void validate(UnAssignNamespaceRDFFromEquipmentVersionCommand command) throws Exception {
    Assert.notNull(command, "UnAssignNamespaceRDFFromEquipmentVersionCommand should not be null");
    Assert.notNull(
        command.getEquipmentVersionId(),
        "UnAssignNamespaceRDFFromEquipmentVersionCommand identifier should not be null");
  }
  /**
   * handles assign NamespaceUML validation for a EquipmentVersion
   *
   * @param command AssignNamespaceUMLToEquipmentVersionCommand
   */
  public void validate(AssignNamespaceUMLToEquipmentVersionCommand command) throws Exception {
    Assert.notNull(command, "AssignNamespaceUMLToEquipmentVersionCommand should not be null");
    Assert.notNull(
        command.getEquipmentVersionId(),
        "AssignNamespaceUMLToEquipmentVersionCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignNamespaceUMLToEquipmentVersionCommand assignment should not be null");
  }

  /**
   * handles unassign NamespaceUML validation for a EquipmentVersion
   *
   * @param command UnAssignNamespaceUMLFromEquipmentVersionCommand
   */
  public void validate(UnAssignNamespaceUMLFromEquipmentVersionCommand command) throws Exception {
    Assert.notNull(command, "UnAssignNamespaceUMLFromEquipmentVersionCommand should not be null");
    Assert.notNull(
        command.getEquipmentVersionId(),
        "UnAssignNamespaceUMLFromEquipmentVersionCommand identifier should not be null");
  }
  /**
   * handles assign ShortName validation for a EquipmentVersion
   *
   * @param command AssignShortNameToEquipmentVersionCommand
   */
  public void validate(AssignShortNameToEquipmentVersionCommand command) throws Exception {
    Assert.notNull(command, "AssignShortNameToEquipmentVersionCommand should not be null");
    Assert.notNull(
        command.getEquipmentVersionId(),
        "AssignShortNameToEquipmentVersionCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignShortNameToEquipmentVersionCommand assignment should not be null");
  }

  /**
   * handles unassign ShortName validation for a EquipmentVersion
   *
   * @param command UnAssignShortNameFromEquipmentVersionCommand
   */
  public void validate(UnAssignShortNameFromEquipmentVersionCommand command) throws Exception {
    Assert.notNull(command, "UnAssignShortNameFromEquipmentVersionCommand should not be null");
    Assert.notNull(
        command.getEquipmentVersionId(),
        "UnAssignShortNameFromEquipmentVersionCommand identifier should not be null");
  }
}
