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
package com.occulue.europeanstandards.commongridmodelexchangestandard.statevariablesprofile.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class StateVariablesVersionValidator {

  /** default constructor */
  protected StateVariablesVersionValidator() {}

  /** factory method */
  public static StateVariablesVersionValidator getInstance() {
    return new StateVariablesVersionValidator();
  }

  /** handles creation validation for a StateVariablesVersion */
  public void validate(CreateStateVariablesVersionCommand stateVariablesVersion) throws Exception {
    Assert.notNull(stateVariablesVersion, "CreateStateVariablesVersionCommand should not be null");
    //		Assert.isNull( stateVariablesVersion.getStateVariablesVersionId(),
    // "CreateStateVariablesVersionCommand identifier should be null" );
  }

  /** handles update validation for a StateVariablesVersion */
  public void validate(UpdateStateVariablesVersionCommand stateVariablesVersion) throws Exception {
    Assert.notNull(stateVariablesVersion, "UpdateStateVariablesVersionCommand should not be null");
    Assert.notNull(
        stateVariablesVersion.getStateVariablesVersionId(),
        "UpdateStateVariablesVersionCommand identifier should not be null");
  }

  /** handles delete validation for a StateVariablesVersion */
  public void validate(DeleteStateVariablesVersionCommand stateVariablesVersion) throws Exception {
    Assert.notNull(stateVariablesVersion, "{commandAlias} should not be null");
    Assert.notNull(
        stateVariablesVersion.getStateVariablesVersionId(),
        "DeleteStateVariablesVersionCommand identifier should not be null");
  }

  /** handles fetchOne validation for a StateVariablesVersion */
  public void validate(StateVariablesVersionFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "StateVariablesVersionFetchOneSummary should not be null");
    Assert.notNull(
        summary.getStateVariablesVersionId(),
        "StateVariablesVersionFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign BaseUML validation for a StateVariablesVersion
   *
   * @param command AssignBaseUMLToStateVariablesVersionCommand
   */
  public void validate(AssignBaseUMLToStateVariablesVersionCommand command) throws Exception {
    Assert.notNull(command, "AssignBaseUMLToStateVariablesVersionCommand should not be null");
    Assert.notNull(
        command.getStateVariablesVersionId(),
        "AssignBaseUMLToStateVariablesVersionCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignBaseUMLToStateVariablesVersionCommand assignment should not be null");
  }

  /**
   * handles unassign BaseUML validation for a StateVariablesVersion
   *
   * @param command UnAssignBaseUMLFromStateVariablesVersionCommand
   */
  public void validate(UnAssignBaseUMLFromStateVariablesVersionCommand command) throws Exception {
    Assert.notNull(command, "UnAssignBaseUMLFromStateVariablesVersionCommand should not be null");
    Assert.notNull(
        command.getStateVariablesVersionId(),
        "UnAssignBaseUMLFromStateVariablesVersionCommand identifier should not be null");
  }
  /**
   * handles assign BaseURI validation for a StateVariablesVersion
   *
   * @param command AssignBaseURIToStateVariablesVersionCommand
   */
  public void validate(AssignBaseURIToStateVariablesVersionCommand command) throws Exception {
    Assert.notNull(command, "AssignBaseURIToStateVariablesVersionCommand should not be null");
    Assert.notNull(
        command.getStateVariablesVersionId(),
        "AssignBaseURIToStateVariablesVersionCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignBaseURIToStateVariablesVersionCommand assignment should not be null");
  }

  /**
   * handles unassign BaseURI validation for a StateVariablesVersion
   *
   * @param command UnAssignBaseURIFromStateVariablesVersionCommand
   */
  public void validate(UnAssignBaseURIFromStateVariablesVersionCommand command) throws Exception {
    Assert.notNull(command, "UnAssignBaseURIFromStateVariablesVersionCommand should not be null");
    Assert.notNull(
        command.getStateVariablesVersionId(),
        "UnAssignBaseURIFromStateVariablesVersionCommand identifier should not be null");
  }
  /**
   * handles assign Date validation for a StateVariablesVersion
   *
   * @param command AssignDateToStateVariablesVersionCommand
   */
  public void validate(AssignDateToStateVariablesVersionCommand command) throws Exception {
    Assert.notNull(command, "AssignDateToStateVariablesVersionCommand should not be null");
    Assert.notNull(
        command.getStateVariablesVersionId(),
        "AssignDateToStateVariablesVersionCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignDateToStateVariablesVersionCommand assignment should not be null");
  }

  /**
   * handles unassign Date validation for a StateVariablesVersion
   *
   * @param command UnAssignDateFromStateVariablesVersionCommand
   */
  public void validate(UnAssignDateFromStateVariablesVersionCommand command) throws Exception {
    Assert.notNull(command, "UnAssignDateFromStateVariablesVersionCommand should not be null");
    Assert.notNull(
        command.getStateVariablesVersionId(),
        "UnAssignDateFromStateVariablesVersionCommand identifier should not be null");
  }
  /**
   * handles assign DifferenceModelURI validation for a StateVariablesVersion
   *
   * @param command AssignDifferenceModelURIToStateVariablesVersionCommand
   */
  public void validate(AssignDifferenceModelURIToStateVariablesVersionCommand command)
      throws Exception {
    Assert.notNull(
        command, "AssignDifferenceModelURIToStateVariablesVersionCommand should not be null");
    Assert.notNull(
        command.getStateVariablesVersionId(),
        "AssignDifferenceModelURIToStateVariablesVersionCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignDifferenceModelURIToStateVariablesVersionCommand assignment should not be null");
  }

  /**
   * handles unassign DifferenceModelURI validation for a StateVariablesVersion
   *
   * @param command UnAssignDifferenceModelURIFromStateVariablesVersionCommand
   */
  public void validate(UnAssignDifferenceModelURIFromStateVariablesVersionCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignDifferenceModelURIFromStateVariablesVersionCommand should not be null");
    Assert.notNull(
        command.getStateVariablesVersionId(),
        "UnAssignDifferenceModelURIFromStateVariablesVersionCommand identifier should not be null");
  }
  /**
   * handles assign EntsoeUML validation for a StateVariablesVersion
   *
   * @param command AssignEntsoeUMLToStateVariablesVersionCommand
   */
  public void validate(AssignEntsoeUMLToStateVariablesVersionCommand command) throws Exception {
    Assert.notNull(command, "AssignEntsoeUMLToStateVariablesVersionCommand should not be null");
    Assert.notNull(
        command.getStateVariablesVersionId(),
        "AssignEntsoeUMLToStateVariablesVersionCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignEntsoeUMLToStateVariablesVersionCommand assignment should not be null");
  }

  /**
   * handles unassign EntsoeUML validation for a StateVariablesVersion
   *
   * @param command UnAssignEntsoeUMLFromStateVariablesVersionCommand
   */
  public void validate(UnAssignEntsoeUMLFromStateVariablesVersionCommand command) throws Exception {
    Assert.notNull(command, "UnAssignEntsoeUMLFromStateVariablesVersionCommand should not be null");
    Assert.notNull(
        command.getStateVariablesVersionId(),
        "UnAssignEntsoeUMLFromStateVariablesVersionCommand identifier should not be null");
  }
  /**
   * handles assign EntsoeURI validation for a StateVariablesVersion
   *
   * @param command AssignEntsoeURIToStateVariablesVersionCommand
   */
  public void validate(AssignEntsoeURIToStateVariablesVersionCommand command) throws Exception {
    Assert.notNull(command, "AssignEntsoeURIToStateVariablesVersionCommand should not be null");
    Assert.notNull(
        command.getStateVariablesVersionId(),
        "AssignEntsoeURIToStateVariablesVersionCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignEntsoeURIToStateVariablesVersionCommand assignment should not be null");
  }

  /**
   * handles unassign EntsoeURI validation for a StateVariablesVersion
   *
   * @param command UnAssignEntsoeURIFromStateVariablesVersionCommand
   */
  public void validate(UnAssignEntsoeURIFromStateVariablesVersionCommand command) throws Exception {
    Assert.notNull(command, "UnAssignEntsoeURIFromStateVariablesVersionCommand should not be null");
    Assert.notNull(
        command.getStateVariablesVersionId(),
        "UnAssignEntsoeURIFromStateVariablesVersionCommand identifier should not be null");
  }
  /**
   * handles assign ModelDescriptionURI validation for a StateVariablesVersion
   *
   * @param command AssignModelDescriptionURIToStateVariablesVersionCommand
   */
  public void validate(AssignModelDescriptionURIToStateVariablesVersionCommand command)
      throws Exception {
    Assert.notNull(
        command, "AssignModelDescriptionURIToStateVariablesVersionCommand should not be null");
    Assert.notNull(
        command.getStateVariablesVersionId(),
        "AssignModelDescriptionURIToStateVariablesVersionCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignModelDescriptionURIToStateVariablesVersionCommand assignment should not be null");
  }

  /**
   * handles unassign ModelDescriptionURI validation for a StateVariablesVersion
   *
   * @param command UnAssignModelDescriptionURIFromStateVariablesVersionCommand
   */
  public void validate(UnAssignModelDescriptionURIFromStateVariablesVersionCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignModelDescriptionURIFromStateVariablesVersionCommand should not be null");
    Assert.notNull(
        command.getStateVariablesVersionId(),
        "UnAssignModelDescriptionURIFromStateVariablesVersionCommand identifier should not be null");
  }
  /**
   * handles assign NamespaceRDF validation for a StateVariablesVersion
   *
   * @param command AssignNamespaceRDFToStateVariablesVersionCommand
   */
  public void validate(AssignNamespaceRDFToStateVariablesVersionCommand command) throws Exception {
    Assert.notNull(command, "AssignNamespaceRDFToStateVariablesVersionCommand should not be null");
    Assert.notNull(
        command.getStateVariablesVersionId(),
        "AssignNamespaceRDFToStateVariablesVersionCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignNamespaceRDFToStateVariablesVersionCommand assignment should not be null");
  }

  /**
   * handles unassign NamespaceRDF validation for a StateVariablesVersion
   *
   * @param command UnAssignNamespaceRDFFromStateVariablesVersionCommand
   */
  public void validate(UnAssignNamespaceRDFFromStateVariablesVersionCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignNamespaceRDFFromStateVariablesVersionCommand should not be null");
    Assert.notNull(
        command.getStateVariablesVersionId(),
        "UnAssignNamespaceRDFFromStateVariablesVersionCommand identifier should not be null");
  }
  /**
   * handles assign NamespaceUML validation for a StateVariablesVersion
   *
   * @param command AssignNamespaceUMLToStateVariablesVersionCommand
   */
  public void validate(AssignNamespaceUMLToStateVariablesVersionCommand command) throws Exception {
    Assert.notNull(command, "AssignNamespaceUMLToStateVariablesVersionCommand should not be null");
    Assert.notNull(
        command.getStateVariablesVersionId(),
        "AssignNamespaceUMLToStateVariablesVersionCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignNamespaceUMLToStateVariablesVersionCommand assignment should not be null");
  }

  /**
   * handles unassign NamespaceUML validation for a StateVariablesVersion
   *
   * @param command UnAssignNamespaceUMLFromStateVariablesVersionCommand
   */
  public void validate(UnAssignNamespaceUMLFromStateVariablesVersionCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignNamespaceUMLFromStateVariablesVersionCommand should not be null");
    Assert.notNull(
        command.getStateVariablesVersionId(),
        "UnAssignNamespaceUMLFromStateVariablesVersionCommand identifier should not be null");
  }
  /**
   * handles assign ShortName validation for a StateVariablesVersion
   *
   * @param command AssignShortNameToStateVariablesVersionCommand
   */
  public void validate(AssignShortNameToStateVariablesVersionCommand command) throws Exception {
    Assert.notNull(command, "AssignShortNameToStateVariablesVersionCommand should not be null");
    Assert.notNull(
        command.getStateVariablesVersionId(),
        "AssignShortNameToStateVariablesVersionCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignShortNameToStateVariablesVersionCommand assignment should not be null");
  }

  /**
   * handles unassign ShortName validation for a StateVariablesVersion
   *
   * @param command UnAssignShortNameFromStateVariablesVersionCommand
   */
  public void validate(UnAssignShortNameFromStateVariablesVersionCommand command) throws Exception {
    Assert.notNull(command, "UnAssignShortNameFromStateVariablesVersionCommand should not be null");
    Assert.notNull(
        command.getStateVariablesVersionId(),
        "UnAssignShortNameFromStateVariablesVersionCommand identifier should not be null");
  }
}
