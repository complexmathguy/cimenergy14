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
package com.occulue.europeanstandards.commongridmodelexchangestandard.steadystatehypothesisprofile.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class SteadyStateHypothesisVersionValidator {

  /** default constructor */
  protected SteadyStateHypothesisVersionValidator() {}

  /** factory method */
  public static SteadyStateHypothesisVersionValidator getInstance() {
    return new SteadyStateHypothesisVersionValidator();
  }

  /** handles creation validation for a SteadyStateHypothesisVersion */
  public void validate(CreateSteadyStateHypothesisVersionCommand steadyStateHypothesisVersion)
      throws Exception {
    Assert.notNull(
        steadyStateHypothesisVersion,
        "CreateSteadyStateHypothesisVersionCommand should not be null");
    //		Assert.isNull( steadyStateHypothesisVersion.getSteadyStateHypothesisVersionId(),
    // "CreateSteadyStateHypothesisVersionCommand identifier should be null" );
  }

  /** handles update validation for a SteadyStateHypothesisVersion */
  public void validate(UpdateSteadyStateHypothesisVersionCommand steadyStateHypothesisVersion)
      throws Exception {
    Assert.notNull(
        steadyStateHypothesisVersion,
        "UpdateSteadyStateHypothesisVersionCommand should not be null");
    Assert.notNull(
        steadyStateHypothesisVersion.getSteadyStateHypothesisVersionId(),
        "UpdateSteadyStateHypothesisVersionCommand identifier should not be null");
  }

  /** handles delete validation for a SteadyStateHypothesisVersion */
  public void validate(DeleteSteadyStateHypothesisVersionCommand steadyStateHypothesisVersion)
      throws Exception {
    Assert.notNull(steadyStateHypothesisVersion, "{commandAlias} should not be null");
    Assert.notNull(
        steadyStateHypothesisVersion.getSteadyStateHypothesisVersionId(),
        "DeleteSteadyStateHypothesisVersionCommand identifier should not be null");
  }

  /** handles fetchOne validation for a SteadyStateHypothesisVersion */
  public void validate(SteadyStateHypothesisVersionFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "SteadyStateHypothesisVersionFetchOneSummary should not be null");
    Assert.notNull(
        summary.getSteadyStateHypothesisVersionId(),
        "SteadyStateHypothesisVersionFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign BaseUML validation for a SteadyStateHypothesisVersion
   *
   * @param command AssignBaseUMLToSteadyStateHypothesisVersionCommand
   */
  public void validate(AssignBaseUMLToSteadyStateHypothesisVersionCommand command)
      throws Exception {
    Assert.notNull(
        command, "AssignBaseUMLToSteadyStateHypothesisVersionCommand should not be null");
    Assert.notNull(
        command.getSteadyStateHypothesisVersionId(),
        "AssignBaseUMLToSteadyStateHypothesisVersionCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignBaseUMLToSteadyStateHypothesisVersionCommand assignment should not be null");
  }

  /**
   * handles unassign BaseUML validation for a SteadyStateHypothesisVersion
   *
   * @param command UnAssignBaseUMLFromSteadyStateHypothesisVersionCommand
   */
  public void validate(UnAssignBaseUMLFromSteadyStateHypothesisVersionCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignBaseUMLFromSteadyStateHypothesisVersionCommand should not be null");
    Assert.notNull(
        command.getSteadyStateHypothesisVersionId(),
        "UnAssignBaseUMLFromSteadyStateHypothesisVersionCommand identifier should not be null");
  }
  /**
   * handles assign BaseURI validation for a SteadyStateHypothesisVersion
   *
   * @param command AssignBaseURIToSteadyStateHypothesisVersionCommand
   */
  public void validate(AssignBaseURIToSteadyStateHypothesisVersionCommand command)
      throws Exception {
    Assert.notNull(
        command, "AssignBaseURIToSteadyStateHypothesisVersionCommand should not be null");
    Assert.notNull(
        command.getSteadyStateHypothesisVersionId(),
        "AssignBaseURIToSteadyStateHypothesisVersionCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignBaseURIToSteadyStateHypothesisVersionCommand assignment should not be null");
  }

  /**
   * handles unassign BaseURI validation for a SteadyStateHypothesisVersion
   *
   * @param command UnAssignBaseURIFromSteadyStateHypothesisVersionCommand
   */
  public void validate(UnAssignBaseURIFromSteadyStateHypothesisVersionCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignBaseURIFromSteadyStateHypothesisVersionCommand should not be null");
    Assert.notNull(
        command.getSteadyStateHypothesisVersionId(),
        "UnAssignBaseURIFromSteadyStateHypothesisVersionCommand identifier should not be null");
  }
  /**
   * handles assign Date validation for a SteadyStateHypothesisVersion
   *
   * @param command AssignDateToSteadyStateHypothesisVersionCommand
   */
  public void validate(AssignDateToSteadyStateHypothesisVersionCommand command) throws Exception {
    Assert.notNull(command, "AssignDateToSteadyStateHypothesisVersionCommand should not be null");
    Assert.notNull(
        command.getSteadyStateHypothesisVersionId(),
        "AssignDateToSteadyStateHypothesisVersionCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignDateToSteadyStateHypothesisVersionCommand assignment should not be null");
  }

  /**
   * handles unassign Date validation for a SteadyStateHypothesisVersion
   *
   * @param command UnAssignDateFromSteadyStateHypothesisVersionCommand
   */
  public void validate(UnAssignDateFromSteadyStateHypothesisVersionCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignDateFromSteadyStateHypothesisVersionCommand should not be null");
    Assert.notNull(
        command.getSteadyStateHypothesisVersionId(),
        "UnAssignDateFromSteadyStateHypothesisVersionCommand identifier should not be null");
  }
  /**
   * handles assign DifferenceModelURI validation for a SteadyStateHypothesisVersion
   *
   * @param command AssignDifferenceModelURIToSteadyStateHypothesisVersionCommand
   */
  public void validate(AssignDifferenceModelURIToSteadyStateHypothesisVersionCommand command)
      throws Exception {
    Assert.notNull(
        command,
        "AssignDifferenceModelURIToSteadyStateHypothesisVersionCommand should not be null");
    Assert.notNull(
        command.getSteadyStateHypothesisVersionId(),
        "AssignDifferenceModelURIToSteadyStateHypothesisVersionCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignDifferenceModelURIToSteadyStateHypothesisVersionCommand assignment should not be null");
  }

  /**
   * handles unassign DifferenceModelURI validation for a SteadyStateHypothesisVersion
   *
   * @param command UnAssignDifferenceModelURIFromSteadyStateHypothesisVersionCommand
   */
  public void validate(UnAssignDifferenceModelURIFromSteadyStateHypothesisVersionCommand command)
      throws Exception {
    Assert.notNull(
        command,
        "UnAssignDifferenceModelURIFromSteadyStateHypothesisVersionCommand should not be null");
    Assert.notNull(
        command.getSteadyStateHypothesisVersionId(),
        "UnAssignDifferenceModelURIFromSteadyStateHypothesisVersionCommand identifier should not be null");
  }
  /**
   * handles assign EntsoeUML validation for a SteadyStateHypothesisVersion
   *
   * @param command AssignEntsoeUMLToSteadyStateHypothesisVersionCommand
   */
  public void validate(AssignEntsoeUMLToSteadyStateHypothesisVersionCommand command)
      throws Exception {
    Assert.notNull(
        command, "AssignEntsoeUMLToSteadyStateHypothesisVersionCommand should not be null");
    Assert.notNull(
        command.getSteadyStateHypothesisVersionId(),
        "AssignEntsoeUMLToSteadyStateHypothesisVersionCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignEntsoeUMLToSteadyStateHypothesisVersionCommand assignment should not be null");
  }

  /**
   * handles unassign EntsoeUML validation for a SteadyStateHypothesisVersion
   *
   * @param command UnAssignEntsoeUMLFromSteadyStateHypothesisVersionCommand
   */
  public void validate(UnAssignEntsoeUMLFromSteadyStateHypothesisVersionCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignEntsoeUMLFromSteadyStateHypothesisVersionCommand should not be null");
    Assert.notNull(
        command.getSteadyStateHypothesisVersionId(),
        "UnAssignEntsoeUMLFromSteadyStateHypothesisVersionCommand identifier should not be null");
  }
  /**
   * handles assign EntsoeURI validation for a SteadyStateHypothesisVersion
   *
   * @param command AssignEntsoeURIToSteadyStateHypothesisVersionCommand
   */
  public void validate(AssignEntsoeURIToSteadyStateHypothesisVersionCommand command)
      throws Exception {
    Assert.notNull(
        command, "AssignEntsoeURIToSteadyStateHypothesisVersionCommand should not be null");
    Assert.notNull(
        command.getSteadyStateHypothesisVersionId(),
        "AssignEntsoeURIToSteadyStateHypothesisVersionCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignEntsoeURIToSteadyStateHypothesisVersionCommand assignment should not be null");
  }

  /**
   * handles unassign EntsoeURI validation for a SteadyStateHypothesisVersion
   *
   * @param command UnAssignEntsoeURIFromSteadyStateHypothesisVersionCommand
   */
  public void validate(UnAssignEntsoeURIFromSteadyStateHypothesisVersionCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignEntsoeURIFromSteadyStateHypothesisVersionCommand should not be null");
    Assert.notNull(
        command.getSteadyStateHypothesisVersionId(),
        "UnAssignEntsoeURIFromSteadyStateHypothesisVersionCommand identifier should not be null");
  }
  /**
   * handles assign ModelDescriptionURI validation for a SteadyStateHypothesisVersion
   *
   * @param command AssignModelDescriptionURIToSteadyStateHypothesisVersionCommand
   */
  public void validate(AssignModelDescriptionURIToSteadyStateHypothesisVersionCommand command)
      throws Exception {
    Assert.notNull(
        command,
        "AssignModelDescriptionURIToSteadyStateHypothesisVersionCommand should not be null");
    Assert.notNull(
        command.getSteadyStateHypothesisVersionId(),
        "AssignModelDescriptionURIToSteadyStateHypothesisVersionCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignModelDescriptionURIToSteadyStateHypothesisVersionCommand assignment should not be null");
  }

  /**
   * handles unassign ModelDescriptionURI validation for a SteadyStateHypothesisVersion
   *
   * @param command UnAssignModelDescriptionURIFromSteadyStateHypothesisVersionCommand
   */
  public void validate(UnAssignModelDescriptionURIFromSteadyStateHypothesisVersionCommand command)
      throws Exception {
    Assert.notNull(
        command,
        "UnAssignModelDescriptionURIFromSteadyStateHypothesisVersionCommand should not be null");
    Assert.notNull(
        command.getSteadyStateHypothesisVersionId(),
        "UnAssignModelDescriptionURIFromSteadyStateHypothesisVersionCommand identifier should not be null");
  }
  /**
   * handles assign NamespaceRDF validation for a SteadyStateHypothesisVersion
   *
   * @param command AssignNamespaceRDFToSteadyStateHypothesisVersionCommand
   */
  public void validate(AssignNamespaceRDFToSteadyStateHypothesisVersionCommand command)
      throws Exception {
    Assert.notNull(
        command, "AssignNamespaceRDFToSteadyStateHypothesisVersionCommand should not be null");
    Assert.notNull(
        command.getSteadyStateHypothesisVersionId(),
        "AssignNamespaceRDFToSteadyStateHypothesisVersionCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignNamespaceRDFToSteadyStateHypothesisVersionCommand assignment should not be null");
  }

  /**
   * handles unassign NamespaceRDF validation for a SteadyStateHypothesisVersion
   *
   * @param command UnAssignNamespaceRDFFromSteadyStateHypothesisVersionCommand
   */
  public void validate(UnAssignNamespaceRDFFromSteadyStateHypothesisVersionCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignNamespaceRDFFromSteadyStateHypothesisVersionCommand should not be null");
    Assert.notNull(
        command.getSteadyStateHypothesisVersionId(),
        "UnAssignNamespaceRDFFromSteadyStateHypothesisVersionCommand identifier should not be null");
  }
  /**
   * handles assign NamespaceUML validation for a SteadyStateHypothesisVersion
   *
   * @param command AssignNamespaceUMLToSteadyStateHypothesisVersionCommand
   */
  public void validate(AssignNamespaceUMLToSteadyStateHypothesisVersionCommand command)
      throws Exception {
    Assert.notNull(
        command, "AssignNamespaceUMLToSteadyStateHypothesisVersionCommand should not be null");
    Assert.notNull(
        command.getSteadyStateHypothesisVersionId(),
        "AssignNamespaceUMLToSteadyStateHypothesisVersionCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignNamespaceUMLToSteadyStateHypothesisVersionCommand assignment should not be null");
  }

  /**
   * handles unassign NamespaceUML validation for a SteadyStateHypothesisVersion
   *
   * @param command UnAssignNamespaceUMLFromSteadyStateHypothesisVersionCommand
   */
  public void validate(UnAssignNamespaceUMLFromSteadyStateHypothesisVersionCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignNamespaceUMLFromSteadyStateHypothesisVersionCommand should not be null");
    Assert.notNull(
        command.getSteadyStateHypothesisVersionId(),
        "UnAssignNamespaceUMLFromSteadyStateHypothesisVersionCommand identifier should not be null");
  }
  /**
   * handles assign ShortName validation for a SteadyStateHypothesisVersion
   *
   * @param command AssignShortNameToSteadyStateHypothesisVersionCommand
   */
  public void validate(AssignShortNameToSteadyStateHypothesisVersionCommand command)
      throws Exception {
    Assert.notNull(
        command, "AssignShortNameToSteadyStateHypothesisVersionCommand should not be null");
    Assert.notNull(
        command.getSteadyStateHypothesisVersionId(),
        "AssignShortNameToSteadyStateHypothesisVersionCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignShortNameToSteadyStateHypothesisVersionCommand assignment should not be null");
  }

  /**
   * handles unassign ShortName validation for a SteadyStateHypothesisVersion
   *
   * @param command UnAssignShortNameFromSteadyStateHypothesisVersionCommand
   */
  public void validate(UnAssignShortNameFromSteadyStateHypothesisVersionCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignShortNameFromSteadyStateHypothesisVersionCommand should not be null");
    Assert.notNull(
        command.getSteadyStateHypothesisVersionId(),
        "UnAssignShortNameFromSteadyStateHypothesisVersionCommand identifier should not be null");
  }
}
