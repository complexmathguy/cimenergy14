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
package com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class DomainVersionValidator {

  /** default constructor */
  protected DomainVersionValidator() {}

  /** factory method */
  public static DomainVersionValidator getInstance() {
    return new DomainVersionValidator();
  }

  /** handles creation validation for a DomainVersion */
  public void validate(CreateDomainVersionCommand domainVersion) throws Exception {
    Assert.notNull(domainVersion, "CreateDomainVersionCommand should not be null");
    //		Assert.isNull( domainVersion.getDomainVersionId(), "CreateDomainVersionCommand identifier
    // should be null" );
  }

  /** handles update validation for a DomainVersion */
  public void validate(UpdateDomainVersionCommand domainVersion) throws Exception {
    Assert.notNull(domainVersion, "UpdateDomainVersionCommand should not be null");
    Assert.notNull(
        domainVersion.getDomainVersionId(),
        "UpdateDomainVersionCommand identifier should not be null");
  }

  /** handles delete validation for a DomainVersion */
  public void validate(DeleteDomainVersionCommand domainVersion) throws Exception {
    Assert.notNull(domainVersion, "{commandAlias} should not be null");
    Assert.notNull(
        domainVersion.getDomainVersionId(),
        "DeleteDomainVersionCommand identifier should not be null");
  }

  /** handles fetchOne validation for a DomainVersion */
  public void validate(DomainVersionFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "DomainVersionFetchOneSummary should not be null");
    Assert.notNull(
        summary.getDomainVersionId(), "DomainVersionFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign BaseUML validation for a DomainVersion
   *
   * @param command AssignBaseUMLToDomainVersionCommand
   */
  public void validate(AssignBaseUMLToDomainVersionCommand command) throws Exception {
    Assert.notNull(command, "AssignBaseUMLToDomainVersionCommand should not be null");
    Assert.notNull(
        command.getDomainVersionId(),
        "AssignBaseUMLToDomainVersionCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignBaseUMLToDomainVersionCommand assignment should not be null");
  }

  /**
   * handles unassign BaseUML validation for a DomainVersion
   *
   * @param command UnAssignBaseUMLFromDomainVersionCommand
   */
  public void validate(UnAssignBaseUMLFromDomainVersionCommand command) throws Exception {
    Assert.notNull(command, "UnAssignBaseUMLFromDomainVersionCommand should not be null");
    Assert.notNull(
        command.getDomainVersionId(),
        "UnAssignBaseUMLFromDomainVersionCommand identifier should not be null");
  }
  /**
   * handles assign Date validation for a DomainVersion
   *
   * @param command AssignDateToDomainVersionCommand
   */
  public void validate(AssignDateToDomainVersionCommand command) throws Exception {
    Assert.notNull(command, "AssignDateToDomainVersionCommand should not be null");
    Assert.notNull(
        command.getDomainVersionId(),
        "AssignDateToDomainVersionCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignDateToDomainVersionCommand assignment should not be null");
  }

  /**
   * handles unassign Date validation for a DomainVersion
   *
   * @param command UnAssignDateFromDomainVersionCommand
   */
  public void validate(UnAssignDateFromDomainVersionCommand command) throws Exception {
    Assert.notNull(command, "UnAssignDateFromDomainVersionCommand should not be null");
    Assert.notNull(
        command.getDomainVersionId(),
        "UnAssignDateFromDomainVersionCommand identifier should not be null");
  }
  /**
   * handles assign EntsoeUML validation for a DomainVersion
   *
   * @param command AssignEntsoeUMLToDomainVersionCommand
   */
  public void validate(AssignEntsoeUMLToDomainVersionCommand command) throws Exception {
    Assert.notNull(command, "AssignEntsoeUMLToDomainVersionCommand should not be null");
    Assert.notNull(
        command.getDomainVersionId(),
        "AssignEntsoeUMLToDomainVersionCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignEntsoeUMLToDomainVersionCommand assignment should not be null");
  }

  /**
   * handles unassign EntsoeUML validation for a DomainVersion
   *
   * @param command UnAssignEntsoeUMLFromDomainVersionCommand
   */
  public void validate(UnAssignEntsoeUMLFromDomainVersionCommand command) throws Exception {
    Assert.notNull(command, "UnAssignEntsoeUMLFromDomainVersionCommand should not be null");
    Assert.notNull(
        command.getDomainVersionId(),
        "UnAssignEntsoeUMLFromDomainVersionCommand identifier should not be null");
  }
  /**
   * handles assign Version validation for a DomainVersion
   *
   * @param command AssignVersionToDomainVersionCommand
   */
  public void validate(AssignVersionToDomainVersionCommand command) throws Exception {
    Assert.notNull(command, "AssignVersionToDomainVersionCommand should not be null");
    Assert.notNull(
        command.getDomainVersionId(),
        "AssignVersionToDomainVersionCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignVersionToDomainVersionCommand assignment should not be null");
  }

  /**
   * handles unassign Version validation for a DomainVersion
   *
   * @param command UnAssignVersionFromDomainVersionCommand
   */
  public void validate(UnAssignVersionFromDomainVersionCommand command) throws Exception {
    Assert.notNull(command, "UnAssignVersionFromDomainVersionCommand should not be null");
    Assert.notNull(
        command.getDomainVersionId(),
        "UnAssignVersionFromDomainVersionCommand identifier should not be null");
  }
}
