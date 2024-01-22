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
package com.occulue.europeanstandards.commongridmodelexchangestandard.topologyboundaryprofile.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class TopologyBoundaryVersionValidator {

  /** default constructor */
  protected TopologyBoundaryVersionValidator() {}

  /** factory method */
  public static TopologyBoundaryVersionValidator getInstance() {
    return new TopologyBoundaryVersionValidator();
  }

  /** handles creation validation for a TopologyBoundaryVersion */
  public void validate(CreateTopologyBoundaryVersionCommand topologyBoundaryVersion)
      throws Exception {
    Assert.notNull(
        topologyBoundaryVersion, "CreateTopologyBoundaryVersionCommand should not be null");
    //		Assert.isNull( topologyBoundaryVersion.getTopologyBoundaryVersionId(),
    // "CreateTopologyBoundaryVersionCommand identifier should be null" );
  }

  /** handles update validation for a TopologyBoundaryVersion */
  public void validate(UpdateTopologyBoundaryVersionCommand topologyBoundaryVersion)
      throws Exception {
    Assert.notNull(
        topologyBoundaryVersion, "UpdateTopologyBoundaryVersionCommand should not be null");
    Assert.notNull(
        topologyBoundaryVersion.getTopologyBoundaryVersionId(),
        "UpdateTopologyBoundaryVersionCommand identifier should not be null");
  }

  /** handles delete validation for a TopologyBoundaryVersion */
  public void validate(DeleteTopologyBoundaryVersionCommand topologyBoundaryVersion)
      throws Exception {
    Assert.notNull(topologyBoundaryVersion, "{commandAlias} should not be null");
    Assert.notNull(
        topologyBoundaryVersion.getTopologyBoundaryVersionId(),
        "DeleteTopologyBoundaryVersionCommand identifier should not be null");
  }

  /** handles fetchOne validation for a TopologyBoundaryVersion */
  public void validate(TopologyBoundaryVersionFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "TopologyBoundaryVersionFetchOneSummary should not be null");
    Assert.notNull(
        summary.getTopologyBoundaryVersionId(),
        "TopologyBoundaryVersionFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign BaseUML validation for a TopologyBoundaryVersion
   *
   * @param command AssignBaseUMLToTopologyBoundaryVersionCommand
   */
  public void validate(AssignBaseUMLToTopologyBoundaryVersionCommand command) throws Exception {
    Assert.notNull(command, "AssignBaseUMLToTopologyBoundaryVersionCommand should not be null");
    Assert.notNull(
        command.getTopologyBoundaryVersionId(),
        "AssignBaseUMLToTopologyBoundaryVersionCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignBaseUMLToTopologyBoundaryVersionCommand assignment should not be null");
  }

  /**
   * handles unassign BaseUML validation for a TopologyBoundaryVersion
   *
   * @param command UnAssignBaseUMLFromTopologyBoundaryVersionCommand
   */
  public void validate(UnAssignBaseUMLFromTopologyBoundaryVersionCommand command) throws Exception {
    Assert.notNull(command, "UnAssignBaseUMLFromTopologyBoundaryVersionCommand should not be null");
    Assert.notNull(
        command.getTopologyBoundaryVersionId(),
        "UnAssignBaseUMLFromTopologyBoundaryVersionCommand identifier should not be null");
  }
  /**
   * handles assign BaseURI validation for a TopologyBoundaryVersion
   *
   * @param command AssignBaseURIToTopologyBoundaryVersionCommand
   */
  public void validate(AssignBaseURIToTopologyBoundaryVersionCommand command) throws Exception {
    Assert.notNull(command, "AssignBaseURIToTopologyBoundaryVersionCommand should not be null");
    Assert.notNull(
        command.getTopologyBoundaryVersionId(),
        "AssignBaseURIToTopologyBoundaryVersionCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignBaseURIToTopologyBoundaryVersionCommand assignment should not be null");
  }

  /**
   * handles unassign BaseURI validation for a TopologyBoundaryVersion
   *
   * @param command UnAssignBaseURIFromTopologyBoundaryVersionCommand
   */
  public void validate(UnAssignBaseURIFromTopologyBoundaryVersionCommand command) throws Exception {
    Assert.notNull(command, "UnAssignBaseURIFromTopologyBoundaryVersionCommand should not be null");
    Assert.notNull(
        command.getTopologyBoundaryVersionId(),
        "UnAssignBaseURIFromTopologyBoundaryVersionCommand identifier should not be null");
  }
  /**
   * handles assign Date validation for a TopologyBoundaryVersion
   *
   * @param command AssignDateToTopologyBoundaryVersionCommand
   */
  public void validate(AssignDateToTopologyBoundaryVersionCommand command) throws Exception {
    Assert.notNull(command, "AssignDateToTopologyBoundaryVersionCommand should not be null");
    Assert.notNull(
        command.getTopologyBoundaryVersionId(),
        "AssignDateToTopologyBoundaryVersionCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignDateToTopologyBoundaryVersionCommand assignment should not be null");
  }

  /**
   * handles unassign Date validation for a TopologyBoundaryVersion
   *
   * @param command UnAssignDateFromTopologyBoundaryVersionCommand
   */
  public void validate(UnAssignDateFromTopologyBoundaryVersionCommand command) throws Exception {
    Assert.notNull(command, "UnAssignDateFromTopologyBoundaryVersionCommand should not be null");
    Assert.notNull(
        command.getTopologyBoundaryVersionId(),
        "UnAssignDateFromTopologyBoundaryVersionCommand identifier should not be null");
  }
  /**
   * handles assign DifferenceModelURI validation for a TopologyBoundaryVersion
   *
   * @param command AssignDifferenceModelURIToTopologyBoundaryVersionCommand
   */
  public void validate(AssignDifferenceModelURIToTopologyBoundaryVersionCommand command)
      throws Exception {
    Assert.notNull(
        command, "AssignDifferenceModelURIToTopologyBoundaryVersionCommand should not be null");
    Assert.notNull(
        command.getTopologyBoundaryVersionId(),
        "AssignDifferenceModelURIToTopologyBoundaryVersionCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignDifferenceModelURIToTopologyBoundaryVersionCommand assignment should not be null");
  }

  /**
   * handles unassign DifferenceModelURI validation for a TopologyBoundaryVersion
   *
   * @param command UnAssignDifferenceModelURIFromTopologyBoundaryVersionCommand
   */
  public void validate(UnAssignDifferenceModelURIFromTopologyBoundaryVersionCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignDifferenceModelURIFromTopologyBoundaryVersionCommand should not be null");
    Assert.notNull(
        command.getTopologyBoundaryVersionId(),
        "UnAssignDifferenceModelURIFromTopologyBoundaryVersionCommand identifier should not be null");
  }
  /**
   * handles assign EntsoeUML validation for a TopologyBoundaryVersion
   *
   * @param command AssignEntsoeUMLToTopologyBoundaryVersionCommand
   */
  public void validate(AssignEntsoeUMLToTopologyBoundaryVersionCommand command) throws Exception {
    Assert.notNull(command, "AssignEntsoeUMLToTopologyBoundaryVersionCommand should not be null");
    Assert.notNull(
        command.getTopologyBoundaryVersionId(),
        "AssignEntsoeUMLToTopologyBoundaryVersionCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignEntsoeUMLToTopologyBoundaryVersionCommand assignment should not be null");
  }

  /**
   * handles unassign EntsoeUML validation for a TopologyBoundaryVersion
   *
   * @param command UnAssignEntsoeUMLFromTopologyBoundaryVersionCommand
   */
  public void validate(UnAssignEntsoeUMLFromTopologyBoundaryVersionCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignEntsoeUMLFromTopologyBoundaryVersionCommand should not be null");
    Assert.notNull(
        command.getTopologyBoundaryVersionId(),
        "UnAssignEntsoeUMLFromTopologyBoundaryVersionCommand identifier should not be null");
  }
  /**
   * handles assign EntsoeURI validation for a TopologyBoundaryVersion
   *
   * @param command AssignEntsoeURIToTopologyBoundaryVersionCommand
   */
  public void validate(AssignEntsoeURIToTopologyBoundaryVersionCommand command) throws Exception {
    Assert.notNull(command, "AssignEntsoeURIToTopologyBoundaryVersionCommand should not be null");
    Assert.notNull(
        command.getTopologyBoundaryVersionId(),
        "AssignEntsoeURIToTopologyBoundaryVersionCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignEntsoeURIToTopologyBoundaryVersionCommand assignment should not be null");
  }

  /**
   * handles unassign EntsoeURI validation for a TopologyBoundaryVersion
   *
   * @param command UnAssignEntsoeURIFromTopologyBoundaryVersionCommand
   */
  public void validate(UnAssignEntsoeURIFromTopologyBoundaryVersionCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignEntsoeURIFromTopologyBoundaryVersionCommand should not be null");
    Assert.notNull(
        command.getTopologyBoundaryVersionId(),
        "UnAssignEntsoeURIFromTopologyBoundaryVersionCommand identifier should not be null");
  }
  /**
   * handles assign ModelDescriptionURI validation for a TopologyBoundaryVersion
   *
   * @param command AssignModelDescriptionURIToTopologyBoundaryVersionCommand
   */
  public void validate(AssignModelDescriptionURIToTopologyBoundaryVersionCommand command)
      throws Exception {
    Assert.notNull(
        command, "AssignModelDescriptionURIToTopologyBoundaryVersionCommand should not be null");
    Assert.notNull(
        command.getTopologyBoundaryVersionId(),
        "AssignModelDescriptionURIToTopologyBoundaryVersionCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignModelDescriptionURIToTopologyBoundaryVersionCommand assignment should not be null");
  }

  /**
   * handles unassign ModelDescriptionURI validation for a TopologyBoundaryVersion
   *
   * @param command UnAssignModelDescriptionURIFromTopologyBoundaryVersionCommand
   */
  public void validate(UnAssignModelDescriptionURIFromTopologyBoundaryVersionCommand command)
      throws Exception {
    Assert.notNull(
        command,
        "UnAssignModelDescriptionURIFromTopologyBoundaryVersionCommand should not be null");
    Assert.notNull(
        command.getTopologyBoundaryVersionId(),
        "UnAssignModelDescriptionURIFromTopologyBoundaryVersionCommand identifier should not be null");
  }
  /**
   * handles assign NamespaceRDF validation for a TopologyBoundaryVersion
   *
   * @param command AssignNamespaceRDFToTopologyBoundaryVersionCommand
   */
  public void validate(AssignNamespaceRDFToTopologyBoundaryVersionCommand command)
      throws Exception {
    Assert.notNull(
        command, "AssignNamespaceRDFToTopologyBoundaryVersionCommand should not be null");
    Assert.notNull(
        command.getTopologyBoundaryVersionId(),
        "AssignNamespaceRDFToTopologyBoundaryVersionCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignNamespaceRDFToTopologyBoundaryVersionCommand assignment should not be null");
  }

  /**
   * handles unassign NamespaceRDF validation for a TopologyBoundaryVersion
   *
   * @param command UnAssignNamespaceRDFFromTopologyBoundaryVersionCommand
   */
  public void validate(UnAssignNamespaceRDFFromTopologyBoundaryVersionCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignNamespaceRDFFromTopologyBoundaryVersionCommand should not be null");
    Assert.notNull(
        command.getTopologyBoundaryVersionId(),
        "UnAssignNamespaceRDFFromTopologyBoundaryVersionCommand identifier should not be null");
  }
  /**
   * handles assign NamespaceUML validation for a TopologyBoundaryVersion
   *
   * @param command AssignNamespaceUMLToTopologyBoundaryVersionCommand
   */
  public void validate(AssignNamespaceUMLToTopologyBoundaryVersionCommand command)
      throws Exception {
    Assert.notNull(
        command, "AssignNamespaceUMLToTopologyBoundaryVersionCommand should not be null");
    Assert.notNull(
        command.getTopologyBoundaryVersionId(),
        "AssignNamespaceUMLToTopologyBoundaryVersionCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignNamespaceUMLToTopologyBoundaryVersionCommand assignment should not be null");
  }

  /**
   * handles unassign NamespaceUML validation for a TopologyBoundaryVersion
   *
   * @param command UnAssignNamespaceUMLFromTopologyBoundaryVersionCommand
   */
  public void validate(UnAssignNamespaceUMLFromTopologyBoundaryVersionCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignNamespaceUMLFromTopologyBoundaryVersionCommand should not be null");
    Assert.notNull(
        command.getTopologyBoundaryVersionId(),
        "UnAssignNamespaceUMLFromTopologyBoundaryVersionCommand identifier should not be null");
  }
  /**
   * handles assign ShortName validation for a TopologyBoundaryVersion
   *
   * @param command AssignShortNameToTopologyBoundaryVersionCommand
   */
  public void validate(AssignShortNameToTopologyBoundaryVersionCommand command) throws Exception {
    Assert.notNull(command, "AssignShortNameToTopologyBoundaryVersionCommand should not be null");
    Assert.notNull(
        command.getTopologyBoundaryVersionId(),
        "AssignShortNameToTopologyBoundaryVersionCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignShortNameToTopologyBoundaryVersionCommand assignment should not be null");
  }

  /**
   * handles unassign ShortName validation for a TopologyBoundaryVersion
   *
   * @param command UnAssignShortNameFromTopologyBoundaryVersionCommand
   */
  public void validate(UnAssignShortNameFromTopologyBoundaryVersionCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignShortNameFromTopologyBoundaryVersionCommand should not be null");
    Assert.notNull(
        command.getTopologyBoundaryVersionId(),
        "UnAssignShortNameFromTopologyBoundaryVersionCommand identifier should not be null");
  }
}
