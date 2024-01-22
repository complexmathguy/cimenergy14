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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentboundaryprofile.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class EquipmentBoundaryVersionValidator {

  /** default constructor */
  protected EquipmentBoundaryVersionValidator() {}

  /** factory method */
  public static EquipmentBoundaryVersionValidator getInstance() {
    return new EquipmentBoundaryVersionValidator();
  }

  /** handles creation validation for a EquipmentBoundaryVersion */
  public void validate(CreateEquipmentBoundaryVersionCommand equipmentBoundaryVersion)
      throws Exception {
    Assert.notNull(
        equipmentBoundaryVersion, "CreateEquipmentBoundaryVersionCommand should not be null");
    //		Assert.isNull( equipmentBoundaryVersion.getEquipmentBoundaryVersionId(),
    // "CreateEquipmentBoundaryVersionCommand identifier should be null" );
  }

  /** handles update validation for a EquipmentBoundaryVersion */
  public void validate(UpdateEquipmentBoundaryVersionCommand equipmentBoundaryVersion)
      throws Exception {
    Assert.notNull(
        equipmentBoundaryVersion, "UpdateEquipmentBoundaryVersionCommand should not be null");
    Assert.notNull(
        equipmentBoundaryVersion.getEquipmentBoundaryVersionId(),
        "UpdateEquipmentBoundaryVersionCommand identifier should not be null");
  }

  /** handles delete validation for a EquipmentBoundaryVersion */
  public void validate(DeleteEquipmentBoundaryVersionCommand equipmentBoundaryVersion)
      throws Exception {
    Assert.notNull(equipmentBoundaryVersion, "{commandAlias} should not be null");
    Assert.notNull(
        equipmentBoundaryVersion.getEquipmentBoundaryVersionId(),
        "DeleteEquipmentBoundaryVersionCommand identifier should not be null");
  }

  /** handles fetchOne validation for a EquipmentBoundaryVersion */
  public void validate(EquipmentBoundaryVersionFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "EquipmentBoundaryVersionFetchOneSummary should not be null");
    Assert.notNull(
        summary.getEquipmentBoundaryVersionId(),
        "EquipmentBoundaryVersionFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign BaseUML validation for a EquipmentBoundaryVersion
   *
   * @param command AssignBaseUMLToEquipmentBoundaryVersionCommand
   */
  public void validate(AssignBaseUMLToEquipmentBoundaryVersionCommand command) throws Exception {
    Assert.notNull(command, "AssignBaseUMLToEquipmentBoundaryVersionCommand should not be null");
    Assert.notNull(
        command.getEquipmentBoundaryVersionId(),
        "AssignBaseUMLToEquipmentBoundaryVersionCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignBaseUMLToEquipmentBoundaryVersionCommand assignment should not be null");
  }

  /**
   * handles unassign BaseUML validation for a EquipmentBoundaryVersion
   *
   * @param command UnAssignBaseUMLFromEquipmentBoundaryVersionCommand
   */
  public void validate(UnAssignBaseUMLFromEquipmentBoundaryVersionCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignBaseUMLFromEquipmentBoundaryVersionCommand should not be null");
    Assert.notNull(
        command.getEquipmentBoundaryVersionId(),
        "UnAssignBaseUMLFromEquipmentBoundaryVersionCommand identifier should not be null");
  }
  /**
   * handles assign BaseURI validation for a EquipmentBoundaryVersion
   *
   * @param command AssignBaseURIToEquipmentBoundaryVersionCommand
   */
  public void validate(AssignBaseURIToEquipmentBoundaryVersionCommand command) throws Exception {
    Assert.notNull(command, "AssignBaseURIToEquipmentBoundaryVersionCommand should not be null");
    Assert.notNull(
        command.getEquipmentBoundaryVersionId(),
        "AssignBaseURIToEquipmentBoundaryVersionCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignBaseURIToEquipmentBoundaryVersionCommand assignment should not be null");
  }

  /**
   * handles unassign BaseURI validation for a EquipmentBoundaryVersion
   *
   * @param command UnAssignBaseURIFromEquipmentBoundaryVersionCommand
   */
  public void validate(UnAssignBaseURIFromEquipmentBoundaryVersionCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignBaseURIFromEquipmentBoundaryVersionCommand should not be null");
    Assert.notNull(
        command.getEquipmentBoundaryVersionId(),
        "UnAssignBaseURIFromEquipmentBoundaryVersionCommand identifier should not be null");
  }
  /**
   * handles assign Date validation for a EquipmentBoundaryVersion
   *
   * @param command AssignDateToEquipmentBoundaryVersionCommand
   */
  public void validate(AssignDateToEquipmentBoundaryVersionCommand command) throws Exception {
    Assert.notNull(command, "AssignDateToEquipmentBoundaryVersionCommand should not be null");
    Assert.notNull(
        command.getEquipmentBoundaryVersionId(),
        "AssignDateToEquipmentBoundaryVersionCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignDateToEquipmentBoundaryVersionCommand assignment should not be null");
  }

  /**
   * handles unassign Date validation for a EquipmentBoundaryVersion
   *
   * @param command UnAssignDateFromEquipmentBoundaryVersionCommand
   */
  public void validate(UnAssignDateFromEquipmentBoundaryVersionCommand command) throws Exception {
    Assert.notNull(command, "UnAssignDateFromEquipmentBoundaryVersionCommand should not be null");
    Assert.notNull(
        command.getEquipmentBoundaryVersionId(),
        "UnAssignDateFromEquipmentBoundaryVersionCommand identifier should not be null");
  }
  /**
   * handles assign DifferenceModelURI validation for a EquipmentBoundaryVersion
   *
   * @param command AssignDifferenceModelURIToEquipmentBoundaryVersionCommand
   */
  public void validate(AssignDifferenceModelURIToEquipmentBoundaryVersionCommand command)
      throws Exception {
    Assert.notNull(
        command, "AssignDifferenceModelURIToEquipmentBoundaryVersionCommand should not be null");
    Assert.notNull(
        command.getEquipmentBoundaryVersionId(),
        "AssignDifferenceModelURIToEquipmentBoundaryVersionCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignDifferenceModelURIToEquipmentBoundaryVersionCommand assignment should not be null");
  }

  /**
   * handles unassign DifferenceModelURI validation for a EquipmentBoundaryVersion
   *
   * @param command UnAssignDifferenceModelURIFromEquipmentBoundaryVersionCommand
   */
  public void validate(UnAssignDifferenceModelURIFromEquipmentBoundaryVersionCommand command)
      throws Exception {
    Assert.notNull(
        command,
        "UnAssignDifferenceModelURIFromEquipmentBoundaryVersionCommand should not be null");
    Assert.notNull(
        command.getEquipmentBoundaryVersionId(),
        "UnAssignDifferenceModelURIFromEquipmentBoundaryVersionCommand identifier should not be null");
  }
  /**
   * handles assign EntsoeUML validation for a EquipmentBoundaryVersion
   *
   * @param command AssignEntsoeUMLToEquipmentBoundaryVersionCommand
   */
  public void validate(AssignEntsoeUMLToEquipmentBoundaryVersionCommand command) throws Exception {
    Assert.notNull(command, "AssignEntsoeUMLToEquipmentBoundaryVersionCommand should not be null");
    Assert.notNull(
        command.getEquipmentBoundaryVersionId(),
        "AssignEntsoeUMLToEquipmentBoundaryVersionCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignEntsoeUMLToEquipmentBoundaryVersionCommand assignment should not be null");
  }

  /**
   * handles unassign EntsoeUML validation for a EquipmentBoundaryVersion
   *
   * @param command UnAssignEntsoeUMLFromEquipmentBoundaryVersionCommand
   */
  public void validate(UnAssignEntsoeUMLFromEquipmentBoundaryVersionCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignEntsoeUMLFromEquipmentBoundaryVersionCommand should not be null");
    Assert.notNull(
        command.getEquipmentBoundaryVersionId(),
        "UnAssignEntsoeUMLFromEquipmentBoundaryVersionCommand identifier should not be null");
  }
  /**
   * handles assign EntsoeURIcore validation for a EquipmentBoundaryVersion
   *
   * @param command AssignEntsoeURIcoreToEquipmentBoundaryVersionCommand
   */
  public void validate(AssignEntsoeURIcoreToEquipmentBoundaryVersionCommand command)
      throws Exception {
    Assert.notNull(
        command, "AssignEntsoeURIcoreToEquipmentBoundaryVersionCommand should not be null");
    Assert.notNull(
        command.getEquipmentBoundaryVersionId(),
        "AssignEntsoeURIcoreToEquipmentBoundaryVersionCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignEntsoeURIcoreToEquipmentBoundaryVersionCommand assignment should not be null");
  }

  /**
   * handles unassign EntsoeURIcore validation for a EquipmentBoundaryVersion
   *
   * @param command UnAssignEntsoeURIcoreFromEquipmentBoundaryVersionCommand
   */
  public void validate(UnAssignEntsoeURIcoreFromEquipmentBoundaryVersionCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignEntsoeURIcoreFromEquipmentBoundaryVersionCommand should not be null");
    Assert.notNull(
        command.getEquipmentBoundaryVersionId(),
        "UnAssignEntsoeURIcoreFromEquipmentBoundaryVersionCommand identifier should not be null");
  }
  /**
   * handles assign EntsoeURIoperation validation for a EquipmentBoundaryVersion
   *
   * @param command AssignEntsoeURIoperationToEquipmentBoundaryVersionCommand
   */
  public void validate(AssignEntsoeURIoperationToEquipmentBoundaryVersionCommand command)
      throws Exception {
    Assert.notNull(
        command, "AssignEntsoeURIoperationToEquipmentBoundaryVersionCommand should not be null");
    Assert.notNull(
        command.getEquipmentBoundaryVersionId(),
        "AssignEntsoeURIoperationToEquipmentBoundaryVersionCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignEntsoeURIoperationToEquipmentBoundaryVersionCommand assignment should not be null");
  }

  /**
   * handles unassign EntsoeURIoperation validation for a EquipmentBoundaryVersion
   *
   * @param command UnAssignEntsoeURIoperationFromEquipmentBoundaryVersionCommand
   */
  public void validate(UnAssignEntsoeURIoperationFromEquipmentBoundaryVersionCommand command)
      throws Exception {
    Assert.notNull(
        command,
        "UnAssignEntsoeURIoperationFromEquipmentBoundaryVersionCommand should not be null");
    Assert.notNull(
        command.getEquipmentBoundaryVersionId(),
        "UnAssignEntsoeURIoperationFromEquipmentBoundaryVersionCommand identifier should not be null");
  }
  /**
   * handles assign ModelDescriptionURI validation for a EquipmentBoundaryVersion
   *
   * @param command AssignModelDescriptionURIToEquipmentBoundaryVersionCommand
   */
  public void validate(AssignModelDescriptionURIToEquipmentBoundaryVersionCommand command)
      throws Exception {
    Assert.notNull(
        command, "AssignModelDescriptionURIToEquipmentBoundaryVersionCommand should not be null");
    Assert.notNull(
        command.getEquipmentBoundaryVersionId(),
        "AssignModelDescriptionURIToEquipmentBoundaryVersionCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignModelDescriptionURIToEquipmentBoundaryVersionCommand assignment should not be null");
  }

  /**
   * handles unassign ModelDescriptionURI validation for a EquipmentBoundaryVersion
   *
   * @param command UnAssignModelDescriptionURIFromEquipmentBoundaryVersionCommand
   */
  public void validate(UnAssignModelDescriptionURIFromEquipmentBoundaryVersionCommand command)
      throws Exception {
    Assert.notNull(
        command,
        "UnAssignModelDescriptionURIFromEquipmentBoundaryVersionCommand should not be null");
    Assert.notNull(
        command.getEquipmentBoundaryVersionId(),
        "UnAssignModelDescriptionURIFromEquipmentBoundaryVersionCommand identifier should not be null");
  }
  /**
   * handles assign NamespaceRDF validation for a EquipmentBoundaryVersion
   *
   * @param command AssignNamespaceRDFToEquipmentBoundaryVersionCommand
   */
  public void validate(AssignNamespaceRDFToEquipmentBoundaryVersionCommand command)
      throws Exception {
    Assert.notNull(
        command, "AssignNamespaceRDFToEquipmentBoundaryVersionCommand should not be null");
    Assert.notNull(
        command.getEquipmentBoundaryVersionId(),
        "AssignNamespaceRDFToEquipmentBoundaryVersionCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignNamespaceRDFToEquipmentBoundaryVersionCommand assignment should not be null");
  }

  /**
   * handles unassign NamespaceRDF validation for a EquipmentBoundaryVersion
   *
   * @param command UnAssignNamespaceRDFFromEquipmentBoundaryVersionCommand
   */
  public void validate(UnAssignNamespaceRDFFromEquipmentBoundaryVersionCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignNamespaceRDFFromEquipmentBoundaryVersionCommand should not be null");
    Assert.notNull(
        command.getEquipmentBoundaryVersionId(),
        "UnAssignNamespaceRDFFromEquipmentBoundaryVersionCommand identifier should not be null");
  }
  /**
   * handles assign NamespaceUML validation for a EquipmentBoundaryVersion
   *
   * @param command AssignNamespaceUMLToEquipmentBoundaryVersionCommand
   */
  public void validate(AssignNamespaceUMLToEquipmentBoundaryVersionCommand command)
      throws Exception {
    Assert.notNull(
        command, "AssignNamespaceUMLToEquipmentBoundaryVersionCommand should not be null");
    Assert.notNull(
        command.getEquipmentBoundaryVersionId(),
        "AssignNamespaceUMLToEquipmentBoundaryVersionCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignNamespaceUMLToEquipmentBoundaryVersionCommand assignment should not be null");
  }

  /**
   * handles unassign NamespaceUML validation for a EquipmentBoundaryVersion
   *
   * @param command UnAssignNamespaceUMLFromEquipmentBoundaryVersionCommand
   */
  public void validate(UnAssignNamespaceUMLFromEquipmentBoundaryVersionCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignNamespaceUMLFromEquipmentBoundaryVersionCommand should not be null");
    Assert.notNull(
        command.getEquipmentBoundaryVersionId(),
        "UnAssignNamespaceUMLFromEquipmentBoundaryVersionCommand identifier should not be null");
  }
  /**
   * handles assign ShortName validation for a EquipmentBoundaryVersion
   *
   * @param command AssignShortNameToEquipmentBoundaryVersionCommand
   */
  public void validate(AssignShortNameToEquipmentBoundaryVersionCommand command) throws Exception {
    Assert.notNull(command, "AssignShortNameToEquipmentBoundaryVersionCommand should not be null");
    Assert.notNull(
        command.getEquipmentBoundaryVersionId(),
        "AssignShortNameToEquipmentBoundaryVersionCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignShortNameToEquipmentBoundaryVersionCommand assignment should not be null");
  }

  /**
   * handles unassign ShortName validation for a EquipmentBoundaryVersion
   *
   * @param command UnAssignShortNameFromEquipmentBoundaryVersionCommand
   */
  public void validate(UnAssignShortNameFromEquipmentBoundaryVersionCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignShortNameFromEquipmentBoundaryVersionCommand should not be null");
    Assert.notNull(
        command.getEquipmentBoundaryVersionId(),
        "UnAssignShortNameFromEquipmentBoundaryVersionCommand identifier should not be null");
  }
}
