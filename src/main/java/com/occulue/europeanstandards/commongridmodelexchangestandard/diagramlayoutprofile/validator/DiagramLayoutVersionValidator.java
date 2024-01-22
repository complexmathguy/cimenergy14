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
package com.occulue.europeanstandards.commongridmodelexchangestandard.diagramlayoutprofile.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class DiagramLayoutVersionValidator {

  /** default constructor */
  protected DiagramLayoutVersionValidator() {}

  /** factory method */
  public static DiagramLayoutVersionValidator getInstance() {
    return new DiagramLayoutVersionValidator();
  }

  /** handles creation validation for a DiagramLayoutVersion */
  public void validate(CreateDiagramLayoutVersionCommand diagramLayoutVersion) throws Exception {
    Assert.notNull(diagramLayoutVersion, "CreateDiagramLayoutVersionCommand should not be null");
    //		Assert.isNull( diagramLayoutVersion.getDiagramLayoutVersionId(),
    // "CreateDiagramLayoutVersionCommand identifier should be null" );
  }

  /** handles update validation for a DiagramLayoutVersion */
  public void validate(UpdateDiagramLayoutVersionCommand diagramLayoutVersion) throws Exception {
    Assert.notNull(diagramLayoutVersion, "UpdateDiagramLayoutVersionCommand should not be null");
    Assert.notNull(
        diagramLayoutVersion.getDiagramLayoutVersionId(),
        "UpdateDiagramLayoutVersionCommand identifier should not be null");
  }

  /** handles delete validation for a DiagramLayoutVersion */
  public void validate(DeleteDiagramLayoutVersionCommand diagramLayoutVersion) throws Exception {
    Assert.notNull(diagramLayoutVersion, "{commandAlias} should not be null");
    Assert.notNull(
        diagramLayoutVersion.getDiagramLayoutVersionId(),
        "DeleteDiagramLayoutVersionCommand identifier should not be null");
  }

  /** handles fetchOne validation for a DiagramLayoutVersion */
  public void validate(DiagramLayoutVersionFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "DiagramLayoutVersionFetchOneSummary should not be null");
    Assert.notNull(
        summary.getDiagramLayoutVersionId(),
        "DiagramLayoutVersionFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign BaseUML validation for a DiagramLayoutVersion
   *
   * @param command AssignBaseUMLToDiagramLayoutVersionCommand
   */
  public void validate(AssignBaseUMLToDiagramLayoutVersionCommand command) throws Exception {
    Assert.notNull(command, "AssignBaseUMLToDiagramLayoutVersionCommand should not be null");
    Assert.notNull(
        command.getDiagramLayoutVersionId(),
        "AssignBaseUMLToDiagramLayoutVersionCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignBaseUMLToDiagramLayoutVersionCommand assignment should not be null");
  }

  /**
   * handles unassign BaseUML validation for a DiagramLayoutVersion
   *
   * @param command UnAssignBaseUMLFromDiagramLayoutVersionCommand
   */
  public void validate(UnAssignBaseUMLFromDiagramLayoutVersionCommand command) throws Exception {
    Assert.notNull(command, "UnAssignBaseUMLFromDiagramLayoutVersionCommand should not be null");
    Assert.notNull(
        command.getDiagramLayoutVersionId(),
        "UnAssignBaseUMLFromDiagramLayoutVersionCommand identifier should not be null");
  }
  /**
   * handles assign BaseURI validation for a DiagramLayoutVersion
   *
   * @param command AssignBaseURIToDiagramLayoutVersionCommand
   */
  public void validate(AssignBaseURIToDiagramLayoutVersionCommand command) throws Exception {
    Assert.notNull(command, "AssignBaseURIToDiagramLayoutVersionCommand should not be null");
    Assert.notNull(
        command.getDiagramLayoutVersionId(),
        "AssignBaseURIToDiagramLayoutVersionCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignBaseURIToDiagramLayoutVersionCommand assignment should not be null");
  }

  /**
   * handles unassign BaseURI validation for a DiagramLayoutVersion
   *
   * @param command UnAssignBaseURIFromDiagramLayoutVersionCommand
   */
  public void validate(UnAssignBaseURIFromDiagramLayoutVersionCommand command) throws Exception {
    Assert.notNull(command, "UnAssignBaseURIFromDiagramLayoutVersionCommand should not be null");
    Assert.notNull(
        command.getDiagramLayoutVersionId(),
        "UnAssignBaseURIFromDiagramLayoutVersionCommand identifier should not be null");
  }
  /**
   * handles assign Date validation for a DiagramLayoutVersion
   *
   * @param command AssignDateToDiagramLayoutVersionCommand
   */
  public void validate(AssignDateToDiagramLayoutVersionCommand command) throws Exception {
    Assert.notNull(command, "AssignDateToDiagramLayoutVersionCommand should not be null");
    Assert.notNull(
        command.getDiagramLayoutVersionId(),
        "AssignDateToDiagramLayoutVersionCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignDateToDiagramLayoutVersionCommand assignment should not be null");
  }

  /**
   * handles unassign Date validation for a DiagramLayoutVersion
   *
   * @param command UnAssignDateFromDiagramLayoutVersionCommand
   */
  public void validate(UnAssignDateFromDiagramLayoutVersionCommand command) throws Exception {
    Assert.notNull(command, "UnAssignDateFromDiagramLayoutVersionCommand should not be null");
    Assert.notNull(
        command.getDiagramLayoutVersionId(),
        "UnAssignDateFromDiagramLayoutVersionCommand identifier should not be null");
  }
  /**
   * handles assign DifferenceModelURI validation for a DiagramLayoutVersion
   *
   * @param command AssignDifferenceModelURIToDiagramLayoutVersionCommand
   */
  public void validate(AssignDifferenceModelURIToDiagramLayoutVersionCommand command)
      throws Exception {
    Assert.notNull(
        command, "AssignDifferenceModelURIToDiagramLayoutVersionCommand should not be null");
    Assert.notNull(
        command.getDiagramLayoutVersionId(),
        "AssignDifferenceModelURIToDiagramLayoutVersionCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignDifferenceModelURIToDiagramLayoutVersionCommand assignment should not be null");
  }

  /**
   * handles unassign DifferenceModelURI validation for a DiagramLayoutVersion
   *
   * @param command UnAssignDifferenceModelURIFromDiagramLayoutVersionCommand
   */
  public void validate(UnAssignDifferenceModelURIFromDiagramLayoutVersionCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignDifferenceModelURIFromDiagramLayoutVersionCommand should not be null");
    Assert.notNull(
        command.getDiagramLayoutVersionId(),
        "UnAssignDifferenceModelURIFromDiagramLayoutVersionCommand identifier should not be null");
  }
  /**
   * handles assign EntsoeUML validation for a DiagramLayoutVersion
   *
   * @param command AssignEntsoeUMLToDiagramLayoutVersionCommand
   */
  public void validate(AssignEntsoeUMLToDiagramLayoutVersionCommand command) throws Exception {
    Assert.notNull(command, "AssignEntsoeUMLToDiagramLayoutVersionCommand should not be null");
    Assert.notNull(
        command.getDiagramLayoutVersionId(),
        "AssignEntsoeUMLToDiagramLayoutVersionCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignEntsoeUMLToDiagramLayoutVersionCommand assignment should not be null");
  }

  /**
   * handles unassign EntsoeUML validation for a DiagramLayoutVersion
   *
   * @param command UnAssignEntsoeUMLFromDiagramLayoutVersionCommand
   */
  public void validate(UnAssignEntsoeUMLFromDiagramLayoutVersionCommand command) throws Exception {
    Assert.notNull(command, "UnAssignEntsoeUMLFromDiagramLayoutVersionCommand should not be null");
    Assert.notNull(
        command.getDiagramLayoutVersionId(),
        "UnAssignEntsoeUMLFromDiagramLayoutVersionCommand identifier should not be null");
  }
  /**
   * handles assign EntsoeURI validation for a DiagramLayoutVersion
   *
   * @param command AssignEntsoeURIToDiagramLayoutVersionCommand
   */
  public void validate(AssignEntsoeURIToDiagramLayoutVersionCommand command) throws Exception {
    Assert.notNull(command, "AssignEntsoeURIToDiagramLayoutVersionCommand should not be null");
    Assert.notNull(
        command.getDiagramLayoutVersionId(),
        "AssignEntsoeURIToDiagramLayoutVersionCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignEntsoeURIToDiagramLayoutVersionCommand assignment should not be null");
  }

  /**
   * handles unassign EntsoeURI validation for a DiagramLayoutVersion
   *
   * @param command UnAssignEntsoeURIFromDiagramLayoutVersionCommand
   */
  public void validate(UnAssignEntsoeURIFromDiagramLayoutVersionCommand command) throws Exception {
    Assert.notNull(command, "UnAssignEntsoeURIFromDiagramLayoutVersionCommand should not be null");
    Assert.notNull(
        command.getDiagramLayoutVersionId(),
        "UnAssignEntsoeURIFromDiagramLayoutVersionCommand identifier should not be null");
  }
  /**
   * handles assign ModelDescriptionURI validation for a DiagramLayoutVersion
   *
   * @param command AssignModelDescriptionURIToDiagramLayoutVersionCommand
   */
  public void validate(AssignModelDescriptionURIToDiagramLayoutVersionCommand command)
      throws Exception {
    Assert.notNull(
        command, "AssignModelDescriptionURIToDiagramLayoutVersionCommand should not be null");
    Assert.notNull(
        command.getDiagramLayoutVersionId(),
        "AssignModelDescriptionURIToDiagramLayoutVersionCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignModelDescriptionURIToDiagramLayoutVersionCommand assignment should not be null");
  }

  /**
   * handles unassign ModelDescriptionURI validation for a DiagramLayoutVersion
   *
   * @param command UnAssignModelDescriptionURIFromDiagramLayoutVersionCommand
   */
  public void validate(UnAssignModelDescriptionURIFromDiagramLayoutVersionCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignModelDescriptionURIFromDiagramLayoutVersionCommand should not be null");
    Assert.notNull(
        command.getDiagramLayoutVersionId(),
        "UnAssignModelDescriptionURIFromDiagramLayoutVersionCommand identifier should not be null");
  }
  /**
   * handles assign NamespaceRDF validation for a DiagramLayoutVersion
   *
   * @param command AssignNamespaceRDFToDiagramLayoutVersionCommand
   */
  public void validate(AssignNamespaceRDFToDiagramLayoutVersionCommand command) throws Exception {
    Assert.notNull(command, "AssignNamespaceRDFToDiagramLayoutVersionCommand should not be null");
    Assert.notNull(
        command.getDiagramLayoutVersionId(),
        "AssignNamespaceRDFToDiagramLayoutVersionCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignNamespaceRDFToDiagramLayoutVersionCommand assignment should not be null");
  }

  /**
   * handles unassign NamespaceRDF validation for a DiagramLayoutVersion
   *
   * @param command UnAssignNamespaceRDFFromDiagramLayoutVersionCommand
   */
  public void validate(UnAssignNamespaceRDFFromDiagramLayoutVersionCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignNamespaceRDFFromDiagramLayoutVersionCommand should not be null");
    Assert.notNull(
        command.getDiagramLayoutVersionId(),
        "UnAssignNamespaceRDFFromDiagramLayoutVersionCommand identifier should not be null");
  }
  /**
   * handles assign NamespaceUML validation for a DiagramLayoutVersion
   *
   * @param command AssignNamespaceUMLToDiagramLayoutVersionCommand
   */
  public void validate(AssignNamespaceUMLToDiagramLayoutVersionCommand command) throws Exception {
    Assert.notNull(command, "AssignNamespaceUMLToDiagramLayoutVersionCommand should not be null");
    Assert.notNull(
        command.getDiagramLayoutVersionId(),
        "AssignNamespaceUMLToDiagramLayoutVersionCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignNamespaceUMLToDiagramLayoutVersionCommand assignment should not be null");
  }

  /**
   * handles unassign NamespaceUML validation for a DiagramLayoutVersion
   *
   * @param command UnAssignNamespaceUMLFromDiagramLayoutVersionCommand
   */
  public void validate(UnAssignNamespaceUMLFromDiagramLayoutVersionCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignNamespaceUMLFromDiagramLayoutVersionCommand should not be null");
    Assert.notNull(
        command.getDiagramLayoutVersionId(),
        "UnAssignNamespaceUMLFromDiagramLayoutVersionCommand identifier should not be null");
  }
  /**
   * handles assign ShortName validation for a DiagramLayoutVersion
   *
   * @param command AssignShortNameToDiagramLayoutVersionCommand
   */
  public void validate(AssignShortNameToDiagramLayoutVersionCommand command) throws Exception {
    Assert.notNull(command, "AssignShortNameToDiagramLayoutVersionCommand should not be null");
    Assert.notNull(
        command.getDiagramLayoutVersionId(),
        "AssignShortNameToDiagramLayoutVersionCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignShortNameToDiagramLayoutVersionCommand assignment should not be null");
  }

  /**
   * handles unassign ShortName validation for a DiagramLayoutVersion
   *
   * @param command UnAssignShortNameFromDiagramLayoutVersionCommand
   */
  public void validate(UnAssignShortNameFromDiagramLayoutVersionCommand command) throws Exception {
    Assert.notNull(command, "UnAssignShortNameFromDiagramLayoutVersionCommand should not be null");
    Assert.notNull(
        command.getDiagramLayoutVersionId(),
        "UnAssignShortNameFromDiagramLayoutVersionCommand identifier should not be null");
  }
}
