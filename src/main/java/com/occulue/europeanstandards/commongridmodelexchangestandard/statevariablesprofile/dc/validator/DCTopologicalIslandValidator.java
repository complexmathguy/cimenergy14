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
package com.occulue.europeanstandards.commongridmodelexchangestandard.statevariablesprofile.dc.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class DCTopologicalIslandValidator {

  /** default constructor */
  protected DCTopologicalIslandValidator() {}

  /** factory method */
  public static DCTopologicalIslandValidator getInstance() {
    return new DCTopologicalIslandValidator();
  }

  /** handles creation validation for a DCTopologicalIsland */
  public void validate(CreateDCTopologicalIslandCommand dCTopologicalIsland) throws Exception {
    Assert.notNull(dCTopologicalIsland, "CreateDCTopologicalIslandCommand should not be null");
    //		Assert.isNull( dCTopologicalIsland.getDCTopologicalIslandId(),
    // "CreateDCTopologicalIslandCommand identifier should be null" );
  }

  /** handles update validation for a DCTopologicalIsland */
  public void validate(UpdateDCTopologicalIslandCommand dCTopologicalIsland) throws Exception {
    Assert.notNull(dCTopologicalIsland, "UpdateDCTopologicalIslandCommand should not be null");
    Assert.notNull(
        dCTopologicalIsland.getDCTopologicalIslandId(),
        "UpdateDCTopologicalIslandCommand identifier should not be null");
  }

  /** handles delete validation for a DCTopologicalIsland */
  public void validate(DeleteDCTopologicalIslandCommand dCTopologicalIsland) throws Exception {
    Assert.notNull(dCTopologicalIsland, "{commandAlias} should not be null");
    Assert.notNull(
        dCTopologicalIsland.getDCTopologicalIslandId(),
        "DeleteDCTopologicalIslandCommand identifier should not be null");
  }

  /** handles fetchOne validation for a DCTopologicalIsland */
  public void validate(DCTopologicalIslandFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "DCTopologicalIslandFetchOneSummary should not be null");
    Assert.notNull(
        summary.getDCTopologicalIslandId(),
        "DCTopologicalIslandFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign DCTopologicalIsland validation for a DCTopologicalIsland
   *
   * @param command AssignDCTopologicalIslandToDCTopologicalIslandCommand
   */
  public void validate(AssignDCTopologicalIslandToDCTopologicalIslandCommand command)
      throws Exception {
    Assert.notNull(
        command, "AssignDCTopologicalIslandToDCTopologicalIslandCommand should not be null");
    Assert.notNull(
        command.getDCTopologicalIslandId(),
        "AssignDCTopologicalIslandToDCTopologicalIslandCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignDCTopologicalIslandToDCTopologicalIslandCommand assignment should not be null");
  }

  /**
   * handles unassign DCTopologicalIsland validation for a DCTopologicalIsland
   *
   * @param command UnAssignDCTopologicalIslandFromDCTopologicalIslandCommand
   */
  public void validate(UnAssignDCTopologicalIslandFromDCTopologicalIslandCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignDCTopologicalIslandFromDCTopologicalIslandCommand should not be null");
    Assert.notNull(
        command.getDCTopologicalIslandId(),
        "UnAssignDCTopologicalIslandFromDCTopologicalIslandCommand identifier should not be null");
  }
}
