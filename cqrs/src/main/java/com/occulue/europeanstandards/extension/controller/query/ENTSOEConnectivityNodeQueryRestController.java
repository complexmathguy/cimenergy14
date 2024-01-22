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
package com.occulue.europeanstandards.extension.controller.query;

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
 * Implements Spring Controller query CQRS processing for entity ENTSOEConnectivityNode.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ENTSOEConnectivityNode")
public class ENTSOEConnectivityNodeQueryRestController extends BaseSpringRestController {

  /**
   * Handles loading a ENTSOEConnectivityNode using a UUID
   *
   * @param UUID eNTSOEConnectivityNodeId
   * @return ENTSOEConnectivityNode
   */
  @GetMapping("/load")
  public ENTSOEConnectivityNode load(@RequestParam(required = true) UUID eNTSOEConnectivityNodeId) {
    ENTSOEConnectivityNode entity = null;

    try {
      entity =
          ENTSOEConnectivityNodeBusinessDelegate.getENTSOEConnectivityNodeInstance()
              .getENTSOEConnectivityNode(
                  new ENTSOEConnectivityNodeFetchOneSummary(eNTSOEConnectivityNodeId));
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "failed to load ENTSOEConnectivityNode using Id " + eNTSOEConnectivityNodeId);
      return null;
    }

    return entity;
  }

  /**
   * Handles loading all ENTSOEConnectivityNode business objects
   *
   * @return Set<ENTSOEConnectivityNode>
   */
  @GetMapping("/")
  public List<ENTSOEConnectivityNode> loadAll() {
    List<ENTSOEConnectivityNode> eNTSOEConnectivityNodeList = null;

    try {
      // load the ENTSOEConnectivityNode
      eNTSOEConnectivityNodeList =
          ENTSOEConnectivityNodeBusinessDelegate.getENTSOEConnectivityNodeInstance()
              .getAllENTSOEConnectivityNode();

      if (eNTSOEConnectivityNodeList != null)
        LOGGER.log(Level.INFO, "successfully loaded all ENTSOEConnectivityNodes");
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "failed to load all ENTSOEConnectivityNodes ", exc);
      return null;
    }

    return eNTSOEConnectivityNodeList;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected ENTSOEConnectivityNode eNTSOEConnectivityNode = null;
  private static final Logger LOGGER =
      Logger.getLogger(ENTSOEConnectivityNodeQueryRestController.class.getName());
}
