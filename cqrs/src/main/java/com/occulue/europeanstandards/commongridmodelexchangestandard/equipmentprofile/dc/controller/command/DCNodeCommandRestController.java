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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.dc.controller.command;

import com.occulue.api.*;
import com.occulue.command.*;
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
 * Implements Spring Controller command CQRS processing for entity DCNode.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/DCNode")
public class DCNodeCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a DCNode. if not key provided, calls create, otherwise calls save
   *
   * @param DCNode dCNode
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(@RequestBody(required = true) CreateDCNodeCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture = DCNodeBusinessDelegate.getDCNodeInstance().createDCNode(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a DCNode. if no key provided, calls create, otherwise calls save
   *
   * @param DCNode dCNode
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(@RequestBody(required = true) UpdateDCNodeCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateDCNodeCommand
      // -----------------------------------------------
      completableFuture = DCNodeBusinessDelegate.getDCNodeInstance().updateDCNode(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "DCNodeController:update() - successfully update DCNode - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a DCNode entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID dCNodeId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteDCNodeCommand command = new DeleteDCNodeCommand(dCNodeId);

    try {
      DCNodeBusinessDelegate delegate = DCNodeBusinessDelegate.getDCNodeInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(Level.WARNING, "Successfully deleted DCNode with key " + command.getDCNodeId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save DCNodes on DCNode
   *
   * @param command AssignDCNodesToDCNodeCommand
   */
  @PutMapping("/addToDCNodes")
  public void addToDCNodes(@RequestBody(required = true) AssignDCNodesToDCNodeCommand command) {
    try {
      DCNodeBusinessDelegate.getDCNodeInstance().addToDCNodes(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to add to Set DCNodes", exc);
    }
  }

  /**
   * remove DCNodes on DCNode
   *
   * @param command RemoveDCNodesFromDCNodeCommand
   */
  @PutMapping("/removeFromDCNodes")
  public void removeFromDCNodes(
      @RequestBody(required = true) RemoveDCNodesFromDCNodeCommand command) {
    try {
      DCNodeBusinessDelegate.getDCNodeInstance().removeFromDCNodes(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to remove from Set DCNodes", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected DCNode dCNode = null;
  private static final Logger LOGGER =
      Logger.getLogger(DCNodeCommandRestController.class.getName());
}
