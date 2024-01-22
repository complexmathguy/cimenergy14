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
package com.occulue.europeanstandards.commongridmodelexchangestandard.topologyprofile.dc.controller.query;

import com.occulue.api.*;
import com.occulue.controller.*;
import com.occulue.delegate.*;
import com.occulue.entity.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.web.bind.annotation.*;

/**
 * Implements Spring Controller query CQRS processing for entity DCTopologicalNode.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/DCTopologicalNode")
public class DCTopologicalNodeQueryRestController extends BaseSpringRestController {

  /**
   * Handles loading a DCTopologicalNode using a UUID
   *
   * @param UUID dCTopologicalNodeId
   * @return DCTopologicalNode
   */
  @GetMapping("/load")
  public DCTopologicalNode load(@RequestParam(required = true) UUID dCTopologicalNodeId) {
    DCTopologicalNode entity = null;

    try {
      entity =
          DCTopologicalNodeBusinessDelegate.getDCTopologicalNodeInstance()
              .getDCTopologicalNode(new DCTopologicalNodeFetchOneSummary(dCTopologicalNodeId));
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "failed to load DCTopologicalNode using Id " + dCTopologicalNodeId);
      return null;
    }

    return entity;
  }

  /**
   * Handles loading all DCTopologicalNode business objects
   *
   * @return Set<DCTopologicalNode>
   */
  @GetMapping("/")
  public List<DCTopologicalNode> loadAll() {
    List<DCTopologicalNode> dCTopologicalNodeList = null;

    try {
      // load the DCTopologicalNode
      dCTopologicalNodeList =
          DCTopologicalNodeBusinessDelegate.getDCTopologicalNodeInstance()
              .getAllDCTopologicalNode();

      if (dCTopologicalNodeList != null)
        LOGGER.log(Level.INFO, "successfully loaded all DCTopologicalNodes");
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "failed to load all DCTopologicalNodes ", exc);
      return null;
    }

    return dCTopologicalNodeList;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected DCTopologicalNode dCTopologicalNode = null;
  private static final Logger LOGGER =
      Logger.getLogger(DCTopologicalNodeQueryRestController.class.getName());
}
