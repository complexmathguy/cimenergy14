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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class DynamicsVersionValidator {

  /** default constructor */
  protected DynamicsVersionValidator() {}

  /** factory method */
  public static DynamicsVersionValidator getInstance() {
    return new DynamicsVersionValidator();
  }

  /** handles creation validation for a DynamicsVersion */
  public void validate(CreateDynamicsVersionCommand dynamicsVersion) throws Exception {
    Assert.notNull(dynamicsVersion, "CreateDynamicsVersionCommand should not be null");
    //		Assert.isNull( dynamicsVersion.getDynamicsVersionId(), "CreateDynamicsVersionCommand
    // identifier should be null" );
  }

  /** handles update validation for a DynamicsVersion */
  public void validate(UpdateDynamicsVersionCommand dynamicsVersion) throws Exception {
    Assert.notNull(dynamicsVersion, "UpdateDynamicsVersionCommand should not be null");
    Assert.notNull(
        dynamicsVersion.getDynamicsVersionId(),
        "UpdateDynamicsVersionCommand identifier should not be null");
  }

  /** handles delete validation for a DynamicsVersion */
  public void validate(DeleteDynamicsVersionCommand dynamicsVersion) throws Exception {
    Assert.notNull(dynamicsVersion, "{commandAlias} should not be null");
    Assert.notNull(
        dynamicsVersion.getDynamicsVersionId(),
        "DeleteDynamicsVersionCommand identifier should not be null");
  }

  /** handles fetchOne validation for a DynamicsVersion */
  public void validate(DynamicsVersionFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "DynamicsVersionFetchOneSummary should not be null");
    Assert.notNull(
        summary.getDynamicsVersionId(),
        "DynamicsVersionFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign BaseUML validation for a DynamicsVersion
   *
   * @param command AssignBaseUMLToDynamicsVersionCommand
   */
  public void validate(AssignBaseUMLToDynamicsVersionCommand command) throws Exception {
    Assert.notNull(command, "AssignBaseUMLToDynamicsVersionCommand should not be null");
    Assert.notNull(
        command.getDynamicsVersionId(),
        "AssignBaseUMLToDynamicsVersionCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignBaseUMLToDynamicsVersionCommand assignment should not be null");
  }

  /**
   * handles unassign BaseUML validation for a DynamicsVersion
   *
   * @param command UnAssignBaseUMLFromDynamicsVersionCommand
   */
  public void validate(UnAssignBaseUMLFromDynamicsVersionCommand command) throws Exception {
    Assert.notNull(command, "UnAssignBaseUMLFromDynamicsVersionCommand should not be null");
    Assert.notNull(
        command.getDynamicsVersionId(),
        "UnAssignBaseUMLFromDynamicsVersionCommand identifier should not be null");
  }
  /**
   * handles assign BaseURI validation for a DynamicsVersion
   *
   * @param command AssignBaseURIToDynamicsVersionCommand
   */
  public void validate(AssignBaseURIToDynamicsVersionCommand command) throws Exception {
    Assert.notNull(command, "AssignBaseURIToDynamicsVersionCommand should not be null");
    Assert.notNull(
        command.getDynamicsVersionId(),
        "AssignBaseURIToDynamicsVersionCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignBaseURIToDynamicsVersionCommand assignment should not be null");
  }

  /**
   * handles unassign BaseURI validation for a DynamicsVersion
   *
   * @param command UnAssignBaseURIFromDynamicsVersionCommand
   */
  public void validate(UnAssignBaseURIFromDynamicsVersionCommand command) throws Exception {
    Assert.notNull(command, "UnAssignBaseURIFromDynamicsVersionCommand should not be null");
    Assert.notNull(
        command.getDynamicsVersionId(),
        "UnAssignBaseURIFromDynamicsVersionCommand identifier should not be null");
  }
  /**
   * handles assign Date validation for a DynamicsVersion
   *
   * @param command AssignDateToDynamicsVersionCommand
   */
  public void validate(AssignDateToDynamicsVersionCommand command) throws Exception {
    Assert.notNull(command, "AssignDateToDynamicsVersionCommand should not be null");
    Assert.notNull(
        command.getDynamicsVersionId(),
        "AssignDateToDynamicsVersionCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignDateToDynamicsVersionCommand assignment should not be null");
  }

  /**
   * handles unassign Date validation for a DynamicsVersion
   *
   * @param command UnAssignDateFromDynamicsVersionCommand
   */
  public void validate(UnAssignDateFromDynamicsVersionCommand command) throws Exception {
    Assert.notNull(command, "UnAssignDateFromDynamicsVersionCommand should not be null");
    Assert.notNull(
        command.getDynamicsVersionId(),
        "UnAssignDateFromDynamicsVersionCommand identifier should not be null");
  }
  /**
   * handles assign DifferenceModelURI validation for a DynamicsVersion
   *
   * @param command AssignDifferenceModelURIToDynamicsVersionCommand
   */
  public void validate(AssignDifferenceModelURIToDynamicsVersionCommand command) throws Exception {
    Assert.notNull(command, "AssignDifferenceModelURIToDynamicsVersionCommand should not be null");
    Assert.notNull(
        command.getDynamicsVersionId(),
        "AssignDifferenceModelURIToDynamicsVersionCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignDifferenceModelURIToDynamicsVersionCommand assignment should not be null");
  }

  /**
   * handles unassign DifferenceModelURI validation for a DynamicsVersion
   *
   * @param command UnAssignDifferenceModelURIFromDynamicsVersionCommand
   */
  public void validate(UnAssignDifferenceModelURIFromDynamicsVersionCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignDifferenceModelURIFromDynamicsVersionCommand should not be null");
    Assert.notNull(
        command.getDynamicsVersionId(),
        "UnAssignDifferenceModelURIFromDynamicsVersionCommand identifier should not be null");
  }
  /**
   * handles assign EntsoeUML validation for a DynamicsVersion
   *
   * @param command AssignEntsoeUMLToDynamicsVersionCommand
   */
  public void validate(AssignEntsoeUMLToDynamicsVersionCommand command) throws Exception {
    Assert.notNull(command, "AssignEntsoeUMLToDynamicsVersionCommand should not be null");
    Assert.notNull(
        command.getDynamicsVersionId(),
        "AssignEntsoeUMLToDynamicsVersionCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignEntsoeUMLToDynamicsVersionCommand assignment should not be null");
  }

  /**
   * handles unassign EntsoeUML validation for a DynamicsVersion
   *
   * @param command UnAssignEntsoeUMLFromDynamicsVersionCommand
   */
  public void validate(UnAssignEntsoeUMLFromDynamicsVersionCommand command) throws Exception {
    Assert.notNull(command, "UnAssignEntsoeUMLFromDynamicsVersionCommand should not be null");
    Assert.notNull(
        command.getDynamicsVersionId(),
        "UnAssignEntsoeUMLFromDynamicsVersionCommand identifier should not be null");
  }
  /**
   * handles assign EntsoeURI validation for a DynamicsVersion
   *
   * @param command AssignEntsoeURIToDynamicsVersionCommand
   */
  public void validate(AssignEntsoeURIToDynamicsVersionCommand command) throws Exception {
    Assert.notNull(command, "AssignEntsoeURIToDynamicsVersionCommand should not be null");
    Assert.notNull(
        command.getDynamicsVersionId(),
        "AssignEntsoeURIToDynamicsVersionCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignEntsoeURIToDynamicsVersionCommand assignment should not be null");
  }

  /**
   * handles unassign EntsoeURI validation for a DynamicsVersion
   *
   * @param command UnAssignEntsoeURIFromDynamicsVersionCommand
   */
  public void validate(UnAssignEntsoeURIFromDynamicsVersionCommand command) throws Exception {
    Assert.notNull(command, "UnAssignEntsoeURIFromDynamicsVersionCommand should not be null");
    Assert.notNull(
        command.getDynamicsVersionId(),
        "UnAssignEntsoeURIFromDynamicsVersionCommand identifier should not be null");
  }
  /**
   * handles assign ModelDescriptionURI validation for a DynamicsVersion
   *
   * @param command AssignModelDescriptionURIToDynamicsVersionCommand
   */
  public void validate(AssignModelDescriptionURIToDynamicsVersionCommand command) throws Exception {
    Assert.notNull(command, "AssignModelDescriptionURIToDynamicsVersionCommand should not be null");
    Assert.notNull(
        command.getDynamicsVersionId(),
        "AssignModelDescriptionURIToDynamicsVersionCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignModelDescriptionURIToDynamicsVersionCommand assignment should not be null");
  }

  /**
   * handles unassign ModelDescriptionURI validation for a DynamicsVersion
   *
   * @param command UnAssignModelDescriptionURIFromDynamicsVersionCommand
   */
  public void validate(UnAssignModelDescriptionURIFromDynamicsVersionCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignModelDescriptionURIFromDynamicsVersionCommand should not be null");
    Assert.notNull(
        command.getDynamicsVersionId(),
        "UnAssignModelDescriptionURIFromDynamicsVersionCommand identifier should not be null");
  }
  /**
   * handles assign NamespaceRDF validation for a DynamicsVersion
   *
   * @param command AssignNamespaceRDFToDynamicsVersionCommand
   */
  public void validate(AssignNamespaceRDFToDynamicsVersionCommand command) throws Exception {
    Assert.notNull(command, "AssignNamespaceRDFToDynamicsVersionCommand should not be null");
    Assert.notNull(
        command.getDynamicsVersionId(),
        "AssignNamespaceRDFToDynamicsVersionCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignNamespaceRDFToDynamicsVersionCommand assignment should not be null");
  }

  /**
   * handles unassign NamespaceRDF validation for a DynamicsVersion
   *
   * @param command UnAssignNamespaceRDFFromDynamicsVersionCommand
   */
  public void validate(UnAssignNamespaceRDFFromDynamicsVersionCommand command) throws Exception {
    Assert.notNull(command, "UnAssignNamespaceRDFFromDynamicsVersionCommand should not be null");
    Assert.notNull(
        command.getDynamicsVersionId(),
        "UnAssignNamespaceRDFFromDynamicsVersionCommand identifier should not be null");
  }
  /**
   * handles assign NamespaceUML validation for a DynamicsVersion
   *
   * @param command AssignNamespaceUMLToDynamicsVersionCommand
   */
  public void validate(AssignNamespaceUMLToDynamicsVersionCommand command) throws Exception {
    Assert.notNull(command, "AssignNamespaceUMLToDynamicsVersionCommand should not be null");
    Assert.notNull(
        command.getDynamicsVersionId(),
        "AssignNamespaceUMLToDynamicsVersionCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignNamespaceUMLToDynamicsVersionCommand assignment should not be null");
  }

  /**
   * handles unassign NamespaceUML validation for a DynamicsVersion
   *
   * @param command UnAssignNamespaceUMLFromDynamicsVersionCommand
   */
  public void validate(UnAssignNamespaceUMLFromDynamicsVersionCommand command) throws Exception {
    Assert.notNull(command, "UnAssignNamespaceUMLFromDynamicsVersionCommand should not be null");
    Assert.notNull(
        command.getDynamicsVersionId(),
        "UnAssignNamespaceUMLFromDynamicsVersionCommand identifier should not be null");
  }
  /**
   * handles assign ShortName validation for a DynamicsVersion
   *
   * @param command AssignShortNameToDynamicsVersionCommand
   */
  public void validate(AssignShortNameToDynamicsVersionCommand command) throws Exception {
    Assert.notNull(command, "AssignShortNameToDynamicsVersionCommand should not be null");
    Assert.notNull(
        command.getDynamicsVersionId(),
        "AssignShortNameToDynamicsVersionCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignShortNameToDynamicsVersionCommand assignment should not be null");
  }

  /**
   * handles unassign ShortName validation for a DynamicsVersion
   *
   * @param command UnAssignShortNameFromDynamicsVersionCommand
   */
  public void validate(UnAssignShortNameFromDynamicsVersionCommand command) throws Exception {
    Assert.notNull(command, "UnAssignShortNameFromDynamicsVersionCommand should not be null");
    Assert.notNull(
        command.getDynamicsVersionId(),
        "UnAssignShortNameFromDynamicsVersionCommand identifier should not be null");
  }
}
