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
package com.occulue.europeanstandards.commongridmodelexchangestandard.topologyprofile.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class TopologyVersionValidator {

  /** default constructor */
  protected TopologyVersionValidator() {}

  /** factory method */
  public static TopologyVersionValidator getInstance() {
    return new TopologyVersionValidator();
  }

  /** handles creation validation for a TopologyVersion */
  public void validate(CreateTopologyVersionCommand topologyVersion) throws Exception {
    Assert.notNull(topologyVersion, "CreateTopologyVersionCommand should not be null");
    //		Assert.isNull( topologyVersion.getTopologyVersionId(), "CreateTopologyVersionCommand
    // identifier should be null" );
  }

  /** handles update validation for a TopologyVersion */
  public void validate(UpdateTopologyVersionCommand topologyVersion) throws Exception {
    Assert.notNull(topologyVersion, "UpdateTopologyVersionCommand should not be null");
    Assert.notNull(
        topologyVersion.getTopologyVersionId(),
        "UpdateTopologyVersionCommand identifier should not be null");
  }

  /** handles delete validation for a TopologyVersion */
  public void validate(DeleteTopologyVersionCommand topologyVersion) throws Exception {
    Assert.notNull(topologyVersion, "{commandAlias} should not be null");
    Assert.notNull(
        topologyVersion.getTopologyVersionId(),
        "DeleteTopologyVersionCommand identifier should not be null");
  }

  /** handles fetchOne validation for a TopologyVersion */
  public void validate(TopologyVersionFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "TopologyVersionFetchOneSummary should not be null");
    Assert.notNull(
        summary.getTopologyVersionId(),
        "TopologyVersionFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign BaseUML validation for a TopologyVersion
   *
   * @param command AssignBaseUMLToTopologyVersionCommand
   */
  public void validate(AssignBaseUMLToTopologyVersionCommand command) throws Exception {
    Assert.notNull(command, "AssignBaseUMLToTopologyVersionCommand should not be null");
    Assert.notNull(
        command.getTopologyVersionId(),
        "AssignBaseUMLToTopologyVersionCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignBaseUMLToTopologyVersionCommand assignment should not be null");
  }

  /**
   * handles unassign BaseUML validation for a TopologyVersion
   *
   * @param command UnAssignBaseUMLFromTopologyVersionCommand
   */
  public void validate(UnAssignBaseUMLFromTopologyVersionCommand command) throws Exception {
    Assert.notNull(command, "UnAssignBaseUMLFromTopologyVersionCommand should not be null");
    Assert.notNull(
        command.getTopologyVersionId(),
        "UnAssignBaseUMLFromTopologyVersionCommand identifier should not be null");
  }
  /**
   * handles assign BaseURI validation for a TopologyVersion
   *
   * @param command AssignBaseURIToTopologyVersionCommand
   */
  public void validate(AssignBaseURIToTopologyVersionCommand command) throws Exception {
    Assert.notNull(command, "AssignBaseURIToTopologyVersionCommand should not be null");
    Assert.notNull(
        command.getTopologyVersionId(),
        "AssignBaseURIToTopologyVersionCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignBaseURIToTopologyVersionCommand assignment should not be null");
  }

  /**
   * handles unassign BaseURI validation for a TopologyVersion
   *
   * @param command UnAssignBaseURIFromTopologyVersionCommand
   */
  public void validate(UnAssignBaseURIFromTopologyVersionCommand command) throws Exception {
    Assert.notNull(command, "UnAssignBaseURIFromTopologyVersionCommand should not be null");
    Assert.notNull(
        command.getTopologyVersionId(),
        "UnAssignBaseURIFromTopologyVersionCommand identifier should not be null");
  }
  /**
   * handles assign Date validation for a TopologyVersion
   *
   * @param command AssignDateToTopologyVersionCommand
   */
  public void validate(AssignDateToTopologyVersionCommand command) throws Exception {
    Assert.notNull(command, "AssignDateToTopologyVersionCommand should not be null");
    Assert.notNull(
        command.getTopologyVersionId(),
        "AssignDateToTopologyVersionCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignDateToTopologyVersionCommand assignment should not be null");
  }

  /**
   * handles unassign Date validation for a TopologyVersion
   *
   * @param command UnAssignDateFromTopologyVersionCommand
   */
  public void validate(UnAssignDateFromTopologyVersionCommand command) throws Exception {
    Assert.notNull(command, "UnAssignDateFromTopologyVersionCommand should not be null");
    Assert.notNull(
        command.getTopologyVersionId(),
        "UnAssignDateFromTopologyVersionCommand identifier should not be null");
  }
  /**
   * handles assign DifferenceModelURI validation for a TopologyVersion
   *
   * @param command AssignDifferenceModelURIToTopologyVersionCommand
   */
  public void validate(AssignDifferenceModelURIToTopologyVersionCommand command) throws Exception {
    Assert.notNull(command, "AssignDifferenceModelURIToTopologyVersionCommand should not be null");
    Assert.notNull(
        command.getTopologyVersionId(),
        "AssignDifferenceModelURIToTopologyVersionCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignDifferenceModelURIToTopologyVersionCommand assignment should not be null");
  }

  /**
   * handles unassign DifferenceModelURI validation for a TopologyVersion
   *
   * @param command UnAssignDifferenceModelURIFromTopologyVersionCommand
   */
  public void validate(UnAssignDifferenceModelURIFromTopologyVersionCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignDifferenceModelURIFromTopologyVersionCommand should not be null");
    Assert.notNull(
        command.getTopologyVersionId(),
        "UnAssignDifferenceModelURIFromTopologyVersionCommand identifier should not be null");
  }
  /**
   * handles assign EntsoeUML validation for a TopologyVersion
   *
   * @param command AssignEntsoeUMLToTopologyVersionCommand
   */
  public void validate(AssignEntsoeUMLToTopologyVersionCommand command) throws Exception {
    Assert.notNull(command, "AssignEntsoeUMLToTopologyVersionCommand should not be null");
    Assert.notNull(
        command.getTopologyVersionId(),
        "AssignEntsoeUMLToTopologyVersionCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignEntsoeUMLToTopologyVersionCommand assignment should not be null");
  }

  /**
   * handles unassign EntsoeUML validation for a TopologyVersion
   *
   * @param command UnAssignEntsoeUMLFromTopologyVersionCommand
   */
  public void validate(UnAssignEntsoeUMLFromTopologyVersionCommand command) throws Exception {
    Assert.notNull(command, "UnAssignEntsoeUMLFromTopologyVersionCommand should not be null");
    Assert.notNull(
        command.getTopologyVersionId(),
        "UnAssignEntsoeUMLFromTopologyVersionCommand identifier should not be null");
  }
  /**
   * handles assign EntsoeURI validation for a TopologyVersion
   *
   * @param command AssignEntsoeURIToTopologyVersionCommand
   */
  public void validate(AssignEntsoeURIToTopologyVersionCommand command) throws Exception {
    Assert.notNull(command, "AssignEntsoeURIToTopologyVersionCommand should not be null");
    Assert.notNull(
        command.getTopologyVersionId(),
        "AssignEntsoeURIToTopologyVersionCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignEntsoeURIToTopologyVersionCommand assignment should not be null");
  }

  /**
   * handles unassign EntsoeURI validation for a TopologyVersion
   *
   * @param command UnAssignEntsoeURIFromTopologyVersionCommand
   */
  public void validate(UnAssignEntsoeURIFromTopologyVersionCommand command) throws Exception {
    Assert.notNull(command, "UnAssignEntsoeURIFromTopologyVersionCommand should not be null");
    Assert.notNull(
        command.getTopologyVersionId(),
        "UnAssignEntsoeURIFromTopologyVersionCommand identifier should not be null");
  }
  /**
   * handles assign ModelDescriptionURI validation for a TopologyVersion
   *
   * @param command AssignModelDescriptionURIToTopologyVersionCommand
   */
  public void validate(AssignModelDescriptionURIToTopologyVersionCommand command) throws Exception {
    Assert.notNull(command, "AssignModelDescriptionURIToTopologyVersionCommand should not be null");
    Assert.notNull(
        command.getTopologyVersionId(),
        "AssignModelDescriptionURIToTopologyVersionCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignModelDescriptionURIToTopologyVersionCommand assignment should not be null");
  }

  /**
   * handles unassign ModelDescriptionURI validation for a TopologyVersion
   *
   * @param command UnAssignModelDescriptionURIFromTopologyVersionCommand
   */
  public void validate(UnAssignModelDescriptionURIFromTopologyVersionCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignModelDescriptionURIFromTopologyVersionCommand should not be null");
    Assert.notNull(
        command.getTopologyVersionId(),
        "UnAssignModelDescriptionURIFromTopologyVersionCommand identifier should not be null");
  }
  /**
   * handles assign NamespaceRDF validation for a TopologyVersion
   *
   * @param command AssignNamespaceRDFToTopologyVersionCommand
   */
  public void validate(AssignNamespaceRDFToTopologyVersionCommand command) throws Exception {
    Assert.notNull(command, "AssignNamespaceRDFToTopologyVersionCommand should not be null");
    Assert.notNull(
        command.getTopologyVersionId(),
        "AssignNamespaceRDFToTopologyVersionCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignNamespaceRDFToTopologyVersionCommand assignment should not be null");
  }

  /**
   * handles unassign NamespaceRDF validation for a TopologyVersion
   *
   * @param command UnAssignNamespaceRDFFromTopologyVersionCommand
   */
  public void validate(UnAssignNamespaceRDFFromTopologyVersionCommand command) throws Exception {
    Assert.notNull(command, "UnAssignNamespaceRDFFromTopologyVersionCommand should not be null");
    Assert.notNull(
        command.getTopologyVersionId(),
        "UnAssignNamespaceRDFFromTopologyVersionCommand identifier should not be null");
  }
  /**
   * handles assign NamespaceUML validation for a TopologyVersion
   *
   * @param command AssignNamespaceUMLToTopologyVersionCommand
   */
  public void validate(AssignNamespaceUMLToTopologyVersionCommand command) throws Exception {
    Assert.notNull(command, "AssignNamespaceUMLToTopologyVersionCommand should not be null");
    Assert.notNull(
        command.getTopologyVersionId(),
        "AssignNamespaceUMLToTopologyVersionCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignNamespaceUMLToTopologyVersionCommand assignment should not be null");
  }

  /**
   * handles unassign NamespaceUML validation for a TopologyVersion
   *
   * @param command UnAssignNamespaceUMLFromTopologyVersionCommand
   */
  public void validate(UnAssignNamespaceUMLFromTopologyVersionCommand command) throws Exception {
    Assert.notNull(command, "UnAssignNamespaceUMLFromTopologyVersionCommand should not be null");
    Assert.notNull(
        command.getTopologyVersionId(),
        "UnAssignNamespaceUMLFromTopologyVersionCommand identifier should not be null");
  }
  /**
   * handles assign ShortName validation for a TopologyVersion
   *
   * @param command AssignShortNameToTopologyVersionCommand
   */
  public void validate(AssignShortNameToTopologyVersionCommand command) throws Exception {
    Assert.notNull(command, "AssignShortNameToTopologyVersionCommand should not be null");
    Assert.notNull(
        command.getTopologyVersionId(),
        "AssignShortNameToTopologyVersionCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignShortNameToTopologyVersionCommand assignment should not be null");
  }

  /**
   * handles unassign ShortName validation for a TopologyVersion
   *
   * @param command UnAssignShortNameFromTopologyVersionCommand
   */
  public void validate(UnAssignShortNameFromTopologyVersionCommand command) throws Exception {
    Assert.notNull(command, "UnAssignShortNameFromTopologyVersionCommand should not be null");
    Assert.notNull(
        command.getTopologyVersionId(),
        "UnAssignShortNameFromTopologyVersionCommand identifier should not be null");
  }
}
