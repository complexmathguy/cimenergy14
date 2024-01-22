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
package com.occulue.europeanstandards.extension.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class ExtensionVersionValidator {

  /** default constructor */
  protected ExtensionVersionValidator() {}

  /** factory method */
  public static ExtensionVersionValidator getInstance() {
    return new ExtensionVersionValidator();
  }

  /** handles creation validation for a ExtensionVersion */
  public void validate(CreateExtensionVersionCommand extensionVersion) throws Exception {
    Assert.notNull(extensionVersion, "CreateExtensionVersionCommand should not be null");
    //		Assert.isNull( extensionVersion.getExtensionVersionId(), "CreateExtensionVersionCommand
    // identifier should be null" );
  }

  /** handles update validation for a ExtensionVersion */
  public void validate(UpdateExtensionVersionCommand extensionVersion) throws Exception {
    Assert.notNull(extensionVersion, "UpdateExtensionVersionCommand should not be null");
    Assert.notNull(
        extensionVersion.getExtensionVersionId(),
        "UpdateExtensionVersionCommand identifier should not be null");
  }

  /** handles delete validation for a ExtensionVersion */
  public void validate(DeleteExtensionVersionCommand extensionVersion) throws Exception {
    Assert.notNull(extensionVersion, "{commandAlias} should not be null");
    Assert.notNull(
        extensionVersion.getExtensionVersionId(),
        "DeleteExtensionVersionCommand identifier should not be null");
  }

  /** handles fetchOne validation for a ExtensionVersion */
  public void validate(ExtensionVersionFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "ExtensionVersionFetchOneSummary should not be null");
    Assert.notNull(
        summary.getExtensionVersionId(),
        "ExtensionVersionFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Date validation for a ExtensionVersion
   *
   * @param command AssignDateToExtensionVersionCommand
   */
  public void validate(AssignDateToExtensionVersionCommand command) throws Exception {
    Assert.notNull(command, "AssignDateToExtensionVersionCommand should not be null");
    Assert.notNull(
        command.getExtensionVersionId(),
        "AssignDateToExtensionVersionCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignDateToExtensionVersionCommand assignment should not be null");
  }

  /**
   * handles unassign Date validation for a ExtensionVersion
   *
   * @param command UnAssignDateFromExtensionVersionCommand
   */
  public void validate(UnAssignDateFromExtensionVersionCommand command) throws Exception {
    Assert.notNull(command, "UnAssignDateFromExtensionVersionCommand should not be null");
    Assert.notNull(
        command.getExtensionVersionId(),
        "UnAssignDateFromExtensionVersionCommand identifier should not be null");
  }
  /**
   * handles assign NamespaceURI validation for a ExtensionVersion
   *
   * @param command AssignNamespaceURIToExtensionVersionCommand
   */
  public void validate(AssignNamespaceURIToExtensionVersionCommand command) throws Exception {
    Assert.notNull(command, "AssignNamespaceURIToExtensionVersionCommand should not be null");
    Assert.notNull(
        command.getExtensionVersionId(),
        "AssignNamespaceURIToExtensionVersionCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignNamespaceURIToExtensionVersionCommand assignment should not be null");
  }

  /**
   * handles unassign NamespaceURI validation for a ExtensionVersion
   *
   * @param command UnAssignNamespaceURIFromExtensionVersionCommand
   */
  public void validate(UnAssignNamespaceURIFromExtensionVersionCommand command) throws Exception {
    Assert.notNull(command, "UnAssignNamespaceURIFromExtensionVersionCommand should not be null");
    Assert.notNull(
        command.getExtensionVersionId(),
        "UnAssignNamespaceURIFromExtensionVersionCommand identifier should not be null");
  }
}
