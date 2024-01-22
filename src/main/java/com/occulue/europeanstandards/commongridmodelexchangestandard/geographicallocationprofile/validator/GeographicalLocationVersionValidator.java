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
package com.occulue.europeanstandards.commongridmodelexchangestandard.geographicallocationprofile.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class GeographicalLocationVersionValidator {

  /** default constructor */
  protected GeographicalLocationVersionValidator() {}

  /** factory method */
  public static GeographicalLocationVersionValidator getInstance() {
    return new GeographicalLocationVersionValidator();
  }

  /** handles creation validation for a GeographicalLocationVersion */
  public void validate(CreateGeographicalLocationVersionCommand geographicalLocationVersion)
      throws Exception {
    Assert.notNull(
        geographicalLocationVersion, "CreateGeographicalLocationVersionCommand should not be null");
    //		Assert.isNull( geographicalLocationVersion.getGeographicalLocationVersionId(),
    // "CreateGeographicalLocationVersionCommand identifier should be null" );
  }

  /** handles update validation for a GeographicalLocationVersion */
  public void validate(UpdateGeographicalLocationVersionCommand geographicalLocationVersion)
      throws Exception {
    Assert.notNull(
        geographicalLocationVersion, "UpdateGeographicalLocationVersionCommand should not be null");
    Assert.notNull(
        geographicalLocationVersion.getGeographicalLocationVersionId(),
        "UpdateGeographicalLocationVersionCommand identifier should not be null");
  }

  /** handles delete validation for a GeographicalLocationVersion */
  public void validate(DeleteGeographicalLocationVersionCommand geographicalLocationVersion)
      throws Exception {
    Assert.notNull(geographicalLocationVersion, "{commandAlias} should not be null");
    Assert.notNull(
        geographicalLocationVersion.getGeographicalLocationVersionId(),
        "DeleteGeographicalLocationVersionCommand identifier should not be null");
  }

  /** handles fetchOne validation for a GeographicalLocationVersion */
  public void validate(GeographicalLocationVersionFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "GeographicalLocationVersionFetchOneSummary should not be null");
    Assert.notNull(
        summary.getGeographicalLocationVersionId(),
        "GeographicalLocationVersionFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign BaseUML validation for a GeographicalLocationVersion
   *
   * @param command AssignBaseUMLToGeographicalLocationVersionCommand
   */
  public void validate(AssignBaseUMLToGeographicalLocationVersionCommand command) throws Exception {
    Assert.notNull(command, "AssignBaseUMLToGeographicalLocationVersionCommand should not be null");
    Assert.notNull(
        command.getGeographicalLocationVersionId(),
        "AssignBaseUMLToGeographicalLocationVersionCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignBaseUMLToGeographicalLocationVersionCommand assignment should not be null");
  }

  /**
   * handles unassign BaseUML validation for a GeographicalLocationVersion
   *
   * @param command UnAssignBaseUMLFromGeographicalLocationVersionCommand
   */
  public void validate(UnAssignBaseUMLFromGeographicalLocationVersionCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignBaseUMLFromGeographicalLocationVersionCommand should not be null");
    Assert.notNull(
        command.getGeographicalLocationVersionId(),
        "UnAssignBaseUMLFromGeographicalLocationVersionCommand identifier should not be null");
  }
  /**
   * handles assign BaseURI validation for a GeographicalLocationVersion
   *
   * @param command AssignBaseURIToGeographicalLocationVersionCommand
   */
  public void validate(AssignBaseURIToGeographicalLocationVersionCommand command) throws Exception {
    Assert.notNull(command, "AssignBaseURIToGeographicalLocationVersionCommand should not be null");
    Assert.notNull(
        command.getGeographicalLocationVersionId(),
        "AssignBaseURIToGeographicalLocationVersionCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignBaseURIToGeographicalLocationVersionCommand assignment should not be null");
  }

  /**
   * handles unassign BaseURI validation for a GeographicalLocationVersion
   *
   * @param command UnAssignBaseURIFromGeographicalLocationVersionCommand
   */
  public void validate(UnAssignBaseURIFromGeographicalLocationVersionCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignBaseURIFromGeographicalLocationVersionCommand should not be null");
    Assert.notNull(
        command.getGeographicalLocationVersionId(),
        "UnAssignBaseURIFromGeographicalLocationVersionCommand identifier should not be null");
  }
  /**
   * handles assign Date validation for a GeographicalLocationVersion
   *
   * @param command AssignDateToGeographicalLocationVersionCommand
   */
  public void validate(AssignDateToGeographicalLocationVersionCommand command) throws Exception {
    Assert.notNull(command, "AssignDateToGeographicalLocationVersionCommand should not be null");
    Assert.notNull(
        command.getGeographicalLocationVersionId(),
        "AssignDateToGeographicalLocationVersionCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignDateToGeographicalLocationVersionCommand assignment should not be null");
  }

  /**
   * handles unassign Date validation for a GeographicalLocationVersion
   *
   * @param command UnAssignDateFromGeographicalLocationVersionCommand
   */
  public void validate(UnAssignDateFromGeographicalLocationVersionCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignDateFromGeographicalLocationVersionCommand should not be null");
    Assert.notNull(
        command.getGeographicalLocationVersionId(),
        "UnAssignDateFromGeographicalLocationVersionCommand identifier should not be null");
  }
  /**
   * handles assign DifferenceModelURI validation for a GeographicalLocationVersion
   *
   * @param command AssignDifferenceModelURIToGeographicalLocationVersionCommand
   */
  public void validate(AssignDifferenceModelURIToGeographicalLocationVersionCommand command)
      throws Exception {
    Assert.notNull(
        command, "AssignDifferenceModelURIToGeographicalLocationVersionCommand should not be null");
    Assert.notNull(
        command.getGeographicalLocationVersionId(),
        "AssignDifferenceModelURIToGeographicalLocationVersionCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignDifferenceModelURIToGeographicalLocationVersionCommand assignment should not be null");
  }

  /**
   * handles unassign DifferenceModelURI validation for a GeographicalLocationVersion
   *
   * @param command UnAssignDifferenceModelURIFromGeographicalLocationVersionCommand
   */
  public void validate(UnAssignDifferenceModelURIFromGeographicalLocationVersionCommand command)
      throws Exception {
    Assert.notNull(
        command,
        "UnAssignDifferenceModelURIFromGeographicalLocationVersionCommand should not be null");
    Assert.notNull(
        command.getGeographicalLocationVersionId(),
        "UnAssignDifferenceModelURIFromGeographicalLocationVersionCommand identifier should not be null");
  }
  /**
   * handles assign EntsoeUML validation for a GeographicalLocationVersion
   *
   * @param command AssignEntsoeUMLToGeographicalLocationVersionCommand
   */
  public void validate(AssignEntsoeUMLToGeographicalLocationVersionCommand command)
      throws Exception {
    Assert.notNull(
        command, "AssignEntsoeUMLToGeographicalLocationVersionCommand should not be null");
    Assert.notNull(
        command.getGeographicalLocationVersionId(),
        "AssignEntsoeUMLToGeographicalLocationVersionCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignEntsoeUMLToGeographicalLocationVersionCommand assignment should not be null");
  }

  /**
   * handles unassign EntsoeUML validation for a GeographicalLocationVersion
   *
   * @param command UnAssignEntsoeUMLFromGeographicalLocationVersionCommand
   */
  public void validate(UnAssignEntsoeUMLFromGeographicalLocationVersionCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignEntsoeUMLFromGeographicalLocationVersionCommand should not be null");
    Assert.notNull(
        command.getGeographicalLocationVersionId(),
        "UnAssignEntsoeUMLFromGeographicalLocationVersionCommand identifier should not be null");
  }
  /**
   * handles assign EntsoeURI validation for a GeographicalLocationVersion
   *
   * @param command AssignEntsoeURIToGeographicalLocationVersionCommand
   */
  public void validate(AssignEntsoeURIToGeographicalLocationVersionCommand command)
      throws Exception {
    Assert.notNull(
        command, "AssignEntsoeURIToGeographicalLocationVersionCommand should not be null");
    Assert.notNull(
        command.getGeographicalLocationVersionId(),
        "AssignEntsoeURIToGeographicalLocationVersionCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignEntsoeURIToGeographicalLocationVersionCommand assignment should not be null");
  }

  /**
   * handles unassign EntsoeURI validation for a GeographicalLocationVersion
   *
   * @param command UnAssignEntsoeURIFromGeographicalLocationVersionCommand
   */
  public void validate(UnAssignEntsoeURIFromGeographicalLocationVersionCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignEntsoeURIFromGeographicalLocationVersionCommand should not be null");
    Assert.notNull(
        command.getGeographicalLocationVersionId(),
        "UnAssignEntsoeURIFromGeographicalLocationVersionCommand identifier should not be null");
  }
  /**
   * handles assign ModelDescriptionURI validation for a GeographicalLocationVersion
   *
   * @param command AssignModelDescriptionURIToGeographicalLocationVersionCommand
   */
  public void validate(AssignModelDescriptionURIToGeographicalLocationVersionCommand command)
      throws Exception {
    Assert.notNull(
        command,
        "AssignModelDescriptionURIToGeographicalLocationVersionCommand should not be null");
    Assert.notNull(
        command.getGeographicalLocationVersionId(),
        "AssignModelDescriptionURIToGeographicalLocationVersionCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignModelDescriptionURIToGeographicalLocationVersionCommand assignment should not be null");
  }

  /**
   * handles unassign ModelDescriptionURI validation for a GeographicalLocationVersion
   *
   * @param command UnAssignModelDescriptionURIFromGeographicalLocationVersionCommand
   */
  public void validate(UnAssignModelDescriptionURIFromGeographicalLocationVersionCommand command)
      throws Exception {
    Assert.notNull(
        command,
        "UnAssignModelDescriptionURIFromGeographicalLocationVersionCommand should not be null");
    Assert.notNull(
        command.getGeographicalLocationVersionId(),
        "UnAssignModelDescriptionURIFromGeographicalLocationVersionCommand identifier should not be null");
  }
  /**
   * handles assign NamespaceRDF validation for a GeographicalLocationVersion
   *
   * @param command AssignNamespaceRDFToGeographicalLocationVersionCommand
   */
  public void validate(AssignNamespaceRDFToGeographicalLocationVersionCommand command)
      throws Exception {
    Assert.notNull(
        command, "AssignNamespaceRDFToGeographicalLocationVersionCommand should not be null");
    Assert.notNull(
        command.getGeographicalLocationVersionId(),
        "AssignNamespaceRDFToGeographicalLocationVersionCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignNamespaceRDFToGeographicalLocationVersionCommand assignment should not be null");
  }

  /**
   * handles unassign NamespaceRDF validation for a GeographicalLocationVersion
   *
   * @param command UnAssignNamespaceRDFFromGeographicalLocationVersionCommand
   */
  public void validate(UnAssignNamespaceRDFFromGeographicalLocationVersionCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignNamespaceRDFFromGeographicalLocationVersionCommand should not be null");
    Assert.notNull(
        command.getGeographicalLocationVersionId(),
        "UnAssignNamespaceRDFFromGeographicalLocationVersionCommand identifier should not be null");
  }
  /**
   * handles assign NamespaceUML validation for a GeographicalLocationVersion
   *
   * @param command AssignNamespaceUMLToGeographicalLocationVersionCommand
   */
  public void validate(AssignNamespaceUMLToGeographicalLocationVersionCommand command)
      throws Exception {
    Assert.notNull(
        command, "AssignNamespaceUMLToGeographicalLocationVersionCommand should not be null");
    Assert.notNull(
        command.getGeographicalLocationVersionId(),
        "AssignNamespaceUMLToGeographicalLocationVersionCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignNamespaceUMLToGeographicalLocationVersionCommand assignment should not be null");
  }

  /**
   * handles unassign NamespaceUML validation for a GeographicalLocationVersion
   *
   * @param command UnAssignNamespaceUMLFromGeographicalLocationVersionCommand
   */
  public void validate(UnAssignNamespaceUMLFromGeographicalLocationVersionCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignNamespaceUMLFromGeographicalLocationVersionCommand should not be null");
    Assert.notNull(
        command.getGeographicalLocationVersionId(),
        "UnAssignNamespaceUMLFromGeographicalLocationVersionCommand identifier should not be null");
  }
  /**
   * handles assign ShortName validation for a GeographicalLocationVersion
   *
   * @param command AssignShortNameToGeographicalLocationVersionCommand
   */
  public void validate(AssignShortNameToGeographicalLocationVersionCommand command)
      throws Exception {
    Assert.notNull(
        command, "AssignShortNameToGeographicalLocationVersionCommand should not be null");
    Assert.notNull(
        command.getGeographicalLocationVersionId(),
        "AssignShortNameToGeographicalLocationVersionCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignShortNameToGeographicalLocationVersionCommand assignment should not be null");
  }

  /**
   * handles unassign ShortName validation for a GeographicalLocationVersion
   *
   * @param command UnAssignShortNameFromGeographicalLocationVersionCommand
   */
  public void validate(UnAssignShortNameFromGeographicalLocationVersionCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignShortNameFromGeographicalLocationVersionCommand should not be null");
    Assert.notNull(
        command.getGeographicalLocationVersionId(),
        "UnAssignShortNameFromGeographicalLocationVersionCommand identifier should not be null");
  }
}
