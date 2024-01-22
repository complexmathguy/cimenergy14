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
package com.occulue.europeanstandards.commongridmodelexchangestandard.topologyprofile.dc.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class DCTopologicalNodeValidator {

  /** default constructor */
  protected DCTopologicalNodeValidator() {}

  /** factory method */
  public static DCTopologicalNodeValidator getInstance() {
    return new DCTopologicalNodeValidator();
  }

  /** handles creation validation for a DCTopologicalNode */
  public void validate(CreateDCTopologicalNodeCommand dCTopologicalNode) throws Exception {
    Assert.notNull(dCTopologicalNode, "CreateDCTopologicalNodeCommand should not be null");
    //		Assert.isNull( dCTopologicalNode.getDCTopologicalNodeId(), "CreateDCTopologicalNodeCommand
    // identifier should be null" );
  }

  /** handles update validation for a DCTopologicalNode */
  public void validate(UpdateDCTopologicalNodeCommand dCTopologicalNode) throws Exception {
    Assert.notNull(dCTopologicalNode, "UpdateDCTopologicalNodeCommand should not be null");
    Assert.notNull(
        dCTopologicalNode.getDCTopologicalNodeId(),
        "UpdateDCTopologicalNodeCommand identifier should not be null");
  }

  /** handles delete validation for a DCTopologicalNode */
  public void validate(DeleteDCTopologicalNodeCommand dCTopologicalNode) throws Exception {
    Assert.notNull(dCTopologicalNode, "{commandAlias} should not be null");
    Assert.notNull(
        dCTopologicalNode.getDCTopologicalNodeId(),
        "DeleteDCTopologicalNodeCommand identifier should not be null");
  }

  /** handles fetchOne validation for a DCTopologicalNode */
  public void validate(DCTopologicalNodeFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "DCTopologicalNodeFetchOneSummary should not be null");
    Assert.notNull(
        summary.getDCTopologicalNodeId(),
        "DCTopologicalNodeFetchOneSummary identifier should not be null");
  }

  /**
   * handles add to DCTopologicalNode validation for a DCTopologicalNode
   *
   * @param command AssignDCTopologicalNodeToDCTopologicalNodeCommand
   */
  public void validate(AssignDCTopologicalNodeToDCTopologicalNodeCommand command) throws Exception {
    Assert.notNull(command, "AssignDCTopologicalNodeToDCTopologicalNodeCommand should not be null");
    Assert.notNull(
        command.getDCTopologicalNodeId(),
        "AssignDCTopologicalNodeToDCTopologicalNodeCommand identifier should not be null");
    Assert.notNull(
        command.getAddTo(),
        "AssignDCTopologicalNodeToDCTopologicalNodeCommand addTo attribute should not be null");
  }

  /**
   * handles remove from DCTopologicalNode validation for a DCTopologicalNode
   *
   * @param command RemoveDCTopologicalNodeFromDCTopologicalNodeCommand
   */
  public void validate(RemoveDCTopologicalNodeFromDCTopologicalNodeCommand command)
      throws Exception {
    Assert.notNull(
        command, "RemoveDCTopologicalNodeFromDCTopologicalNodeCommand should not be null");
    Assert.notNull(
        command.getDCTopologicalNodeId(),
        "RemoveDCTopologicalNodeFromDCTopologicalNodeCommand identifier should not be null");
    Assert.notNull(
        command.getRemoveFrom(),
        "RemoveDCTopologicalNodeFromDCTopologicalNodeCommand removeFrom attribute should not be null");
    Assert.notNull(
        command.getRemoveFrom().getDCTopologicalNodeId(),
        "RemoveDCTopologicalNodeFromDCTopologicalNodeCommand removeFrom attribubte identifier should not be null");
  }
}
