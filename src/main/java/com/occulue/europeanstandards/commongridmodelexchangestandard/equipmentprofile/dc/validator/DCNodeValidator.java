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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.dc.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class DCNodeValidator {

  /** default constructor */
  protected DCNodeValidator() {}

  /** factory method */
  public static DCNodeValidator getInstance() {
    return new DCNodeValidator();
  }

  /** handles creation validation for a DCNode */
  public void validate(CreateDCNodeCommand dCNode) throws Exception {
    Assert.notNull(dCNode, "CreateDCNodeCommand should not be null");
    //		Assert.isNull( dCNode.getDCNodeId(), "CreateDCNodeCommand identifier should be null" );
  }

  /** handles update validation for a DCNode */
  public void validate(UpdateDCNodeCommand dCNode) throws Exception {
    Assert.notNull(dCNode, "UpdateDCNodeCommand should not be null");
    Assert.notNull(dCNode.getDCNodeId(), "UpdateDCNodeCommand identifier should not be null");
  }

  /** handles delete validation for a DCNode */
  public void validate(DeleteDCNodeCommand dCNode) throws Exception {
    Assert.notNull(dCNode, "{commandAlias} should not be null");
    Assert.notNull(dCNode.getDCNodeId(), "DeleteDCNodeCommand identifier should not be null");
  }

  /** handles fetchOne validation for a DCNode */
  public void validate(DCNodeFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "DCNodeFetchOneSummary should not be null");
    Assert.notNull(summary.getDCNodeId(), "DCNodeFetchOneSummary identifier should not be null");
  }

  /**
   * handles add to DCNodes validation for a DCNode
   *
   * @param command AssignDCNodesToDCNodeCommand
   */
  public void validate(AssignDCNodesToDCNodeCommand command) throws Exception {
    Assert.notNull(command, "AssignDCNodesToDCNodeCommand should not be null");
    Assert.notNull(
        command.getDCNodeId(), "AssignDCNodesToDCNodeCommand identifier should not be null");
    Assert.notNull(
        command.getAddTo(), "AssignDCNodesToDCNodeCommand addTo attribute should not be null");
  }

  /**
   * handles remove from DCNodes validation for a DCNode
   *
   * @param command RemoveDCNodesFromDCNodeCommand
   */
  public void validate(RemoveDCNodesFromDCNodeCommand command) throws Exception {
    Assert.notNull(command, "RemoveDCNodesFromDCNodeCommand should not be null");
    Assert.notNull(
        command.getDCNodeId(), "RemoveDCNodesFromDCNodeCommand identifier should not be null");
    Assert.notNull(
        command.getRemoveFrom(),
        "RemoveDCNodesFromDCNodeCommand removeFrom attribute should not be null");
    Assert.notNull(
        command.getRemoveFrom().getDCNodeId(),
        "RemoveDCNodesFromDCNodeCommand removeFrom attribubte identifier should not be null");
  }
}
