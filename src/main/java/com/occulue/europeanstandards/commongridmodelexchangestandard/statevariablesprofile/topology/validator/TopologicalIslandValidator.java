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
package com.occulue.europeanstandards.commongridmodelexchangestandard.statevariablesprofile.topology.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class TopologicalIslandValidator {

  /** default constructor */
  protected TopologicalIslandValidator() {}

  /** factory method */
  public static TopologicalIslandValidator getInstance() {
    return new TopologicalIslandValidator();
  }

  /** handles creation validation for a TopologicalIsland */
  public void validate(CreateTopologicalIslandCommand topologicalIsland) throws Exception {
    Assert.notNull(topologicalIsland, "CreateTopologicalIslandCommand should not be null");
    //		Assert.isNull( topologicalIsland.getTopologicalIslandId(), "CreateTopologicalIslandCommand
    // identifier should be null" );
  }

  /** handles update validation for a TopologicalIsland */
  public void validate(UpdateTopologicalIslandCommand topologicalIsland) throws Exception {
    Assert.notNull(topologicalIsland, "UpdateTopologicalIslandCommand should not be null");
    Assert.notNull(
        topologicalIsland.getTopologicalIslandId(),
        "UpdateTopologicalIslandCommand identifier should not be null");
  }

  /** handles delete validation for a TopologicalIsland */
  public void validate(DeleteTopologicalIslandCommand topologicalIsland) throws Exception {
    Assert.notNull(topologicalIsland, "{commandAlias} should not be null");
    Assert.notNull(
        topologicalIsland.getTopologicalIslandId(),
        "DeleteTopologicalIslandCommand identifier should not be null");
  }

  /** handles fetchOne validation for a TopologicalIsland */
  public void validate(TopologicalIslandFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "TopologicalIslandFetchOneSummary should not be null");
    Assert.notNull(
        summary.getTopologicalIslandId(),
        "TopologicalIslandFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign TopologicalIsland validation for a TopologicalIsland
   *
   * @param command AssignTopologicalIslandToTopologicalIslandCommand
   */
  public void validate(AssignTopologicalIslandToTopologicalIslandCommand command) throws Exception {
    Assert.notNull(command, "AssignTopologicalIslandToTopologicalIslandCommand should not be null");
    Assert.notNull(
        command.getTopologicalIslandId(),
        "AssignTopologicalIslandToTopologicalIslandCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignTopologicalIslandToTopologicalIslandCommand assignment should not be null");
  }

  /**
   * handles unassign TopologicalIsland validation for a TopologicalIsland
   *
   * @param command UnAssignTopologicalIslandFromTopologicalIslandCommand
   */
  public void validate(UnAssignTopologicalIslandFromTopologicalIslandCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignTopologicalIslandFromTopologicalIslandCommand should not be null");
    Assert.notNull(
        command.getTopologicalIslandId(),
        "UnAssignTopologicalIslandFromTopologicalIslandCommand identifier should not be null");
  }
  /**
   * handles assign AngleRefTopologicalIsland validation for a TopologicalIsland
   *
   * @param command AssignAngleRefTopologicalIslandToTopologicalIslandCommand
   */
  public void validate(AssignAngleRefTopologicalIslandToTopologicalIslandCommand command)
      throws Exception {
    Assert.notNull(
        command, "AssignAngleRefTopologicalIslandToTopologicalIslandCommand should not be null");
    Assert.notNull(
        command.getTopologicalIslandId(),
        "AssignAngleRefTopologicalIslandToTopologicalIslandCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignAngleRefTopologicalIslandToTopologicalIslandCommand assignment should not be null");
  }

  /**
   * handles unassign AngleRefTopologicalIsland validation for a TopologicalIsland
   *
   * @param command UnAssignAngleRefTopologicalIslandFromTopologicalIslandCommand
   */
  public void validate(UnAssignAngleRefTopologicalIslandFromTopologicalIslandCommand command)
      throws Exception {
    Assert.notNull(
        command,
        "UnAssignAngleRefTopologicalIslandFromTopologicalIslandCommand should not be null");
    Assert.notNull(
        command.getTopologicalIslandId(),
        "UnAssignAngleRefTopologicalIslandFromTopologicalIslandCommand identifier should not be null");
  }
}
