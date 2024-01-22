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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentboundaryprofile.core.controller.command;

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
 * Implements Spring Controller command CQRS processing for entity ConnectivityNode.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ConnectivityNode")
public class ConnectivityNodeCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a ConnectivityNode. if not key provided, calls create, otherwise calls save
   *
   * @param ConnectivityNode connectivityNode
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateConnectivityNodeCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          ConnectivityNodeBusinessDelegate.getConnectivityNodeInstance()
              .createConnectivityNode(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a ConnectivityNode. if no key provided, calls create, otherwise calls save
   *
   * @param ConnectivityNode connectivityNode
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateConnectivityNodeCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateConnectivityNodeCommand
      // -----------------------------------------------
      completableFuture =
          ConnectivityNodeBusinessDelegate.getConnectivityNodeInstance()
              .updateConnectivityNode(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "ConnectivityNodeController:update() - successfully update ConnectivityNode - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a ConnectivityNode entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID connectivityNodeId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteConnectivityNodeCommand command = new DeleteConnectivityNodeCommand(connectivityNodeId);

    try {
      ConnectivityNodeBusinessDelegate delegate =
          ConnectivityNodeBusinessDelegate.getConnectivityNodeInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted ConnectivityNode with key " + command.getConnectivityNodeId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save BoundaryPoint on ConnectivityNode
   *
   * @param command AssignBoundaryPointToConnectivityNodeCommand
   */
  @PutMapping("/assignBoundaryPoint")
  public void assignBoundaryPoint(
      @RequestBody AssignBoundaryPointToConnectivityNodeCommand command) {
    try {
      ConnectivityNodeBusinessDelegate.getConnectivityNodeInstance().assignBoundaryPoint(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign BoundaryPoint", exc);
    }
  }

  /**
   * unassign BoundaryPoint on ConnectivityNode
   *
   * @param command UnAssignBoundaryPointFromConnectivityNodeCommand
   */
  @PutMapping("/unAssignBoundaryPoint")
  public void unAssignBoundaryPoint(
      @RequestBody(required = true) UnAssignBoundaryPointFromConnectivityNodeCommand command) {
    try {
      ConnectivityNodeBusinessDelegate.getConnectivityNodeInstance().unAssignBoundaryPoint(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign BoundaryPoint", exc);
    }
  }

  /**
   * save FromEndIsoCode on ConnectivityNode
   *
   * @param command AssignFromEndIsoCodeToConnectivityNodeCommand
   */
  @PutMapping("/assignFromEndIsoCode")
  public void assignFromEndIsoCode(
      @RequestBody AssignFromEndIsoCodeToConnectivityNodeCommand command) {
    try {
      ConnectivityNodeBusinessDelegate.getConnectivityNodeInstance().assignFromEndIsoCode(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign FromEndIsoCode", exc);
    }
  }

  /**
   * unassign FromEndIsoCode on ConnectivityNode
   *
   * @param command UnAssignFromEndIsoCodeFromConnectivityNodeCommand
   */
  @PutMapping("/unAssignFromEndIsoCode")
  public void unAssignFromEndIsoCode(
      @RequestBody(required = true) UnAssignFromEndIsoCodeFromConnectivityNodeCommand command) {
    try {
      ConnectivityNodeBusinessDelegate.getConnectivityNodeInstance()
          .unAssignFromEndIsoCode(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign FromEndIsoCode", exc);
    }
  }

  /**
   * save FromEndName on ConnectivityNode
   *
   * @param command AssignFromEndNameToConnectivityNodeCommand
   */
  @PutMapping("/assignFromEndName")
  public void assignFromEndName(@RequestBody AssignFromEndNameToConnectivityNodeCommand command) {
    try {
      ConnectivityNodeBusinessDelegate.getConnectivityNodeInstance().assignFromEndName(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign FromEndName", exc);
    }
  }

  /**
   * unassign FromEndName on ConnectivityNode
   *
   * @param command UnAssignFromEndNameFromConnectivityNodeCommand
   */
  @PutMapping("/unAssignFromEndName")
  public void unAssignFromEndName(
      @RequestBody(required = true) UnAssignFromEndNameFromConnectivityNodeCommand command) {
    try {
      ConnectivityNodeBusinessDelegate.getConnectivityNodeInstance().unAssignFromEndName(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign FromEndName", exc);
    }
  }

  /**
   * save FromEndNameTso on ConnectivityNode
   *
   * @param command AssignFromEndNameTsoToConnectivityNodeCommand
   */
  @PutMapping("/assignFromEndNameTso")
  public void assignFromEndNameTso(
      @RequestBody AssignFromEndNameTsoToConnectivityNodeCommand command) {
    try {
      ConnectivityNodeBusinessDelegate.getConnectivityNodeInstance().assignFromEndNameTso(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign FromEndNameTso", exc);
    }
  }

  /**
   * unassign FromEndNameTso on ConnectivityNode
   *
   * @param command UnAssignFromEndNameTsoFromConnectivityNodeCommand
   */
  @PutMapping("/unAssignFromEndNameTso")
  public void unAssignFromEndNameTso(
      @RequestBody(required = true) UnAssignFromEndNameTsoFromConnectivityNodeCommand command) {
    try {
      ConnectivityNodeBusinessDelegate.getConnectivityNodeInstance()
          .unAssignFromEndNameTso(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign FromEndNameTso", exc);
    }
  }

  /**
   * save ToEndIsoCode on ConnectivityNode
   *
   * @param command AssignToEndIsoCodeToConnectivityNodeCommand
   */
  @PutMapping("/assignToEndIsoCode")
  public void assignToEndIsoCode(@RequestBody AssignToEndIsoCodeToConnectivityNodeCommand command) {
    try {
      ConnectivityNodeBusinessDelegate.getConnectivityNodeInstance().assignToEndIsoCode(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign ToEndIsoCode", exc);
    }
  }

  /**
   * unassign ToEndIsoCode on ConnectivityNode
   *
   * @param command UnAssignToEndIsoCodeFromConnectivityNodeCommand
   */
  @PutMapping("/unAssignToEndIsoCode")
  public void unAssignToEndIsoCode(
      @RequestBody(required = true) UnAssignToEndIsoCodeFromConnectivityNodeCommand command) {
    try {
      ConnectivityNodeBusinessDelegate.getConnectivityNodeInstance().unAssignToEndIsoCode(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign ToEndIsoCode", exc);
    }
  }

  /**
   * save ToEndName on ConnectivityNode
   *
   * @param command AssignToEndNameToConnectivityNodeCommand
   */
  @PutMapping("/assignToEndName")
  public void assignToEndName(@RequestBody AssignToEndNameToConnectivityNodeCommand command) {
    try {
      ConnectivityNodeBusinessDelegate.getConnectivityNodeInstance().assignToEndName(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign ToEndName", exc);
    }
  }

  /**
   * unassign ToEndName on ConnectivityNode
   *
   * @param command UnAssignToEndNameFromConnectivityNodeCommand
   */
  @PutMapping("/unAssignToEndName")
  public void unAssignToEndName(
      @RequestBody(required = true) UnAssignToEndNameFromConnectivityNodeCommand command) {
    try {
      ConnectivityNodeBusinessDelegate.getConnectivityNodeInstance().unAssignToEndName(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign ToEndName", exc);
    }
  }

  /**
   * save ToEndNameTso on ConnectivityNode
   *
   * @param command AssignToEndNameTsoToConnectivityNodeCommand
   */
  @PutMapping("/assignToEndNameTso")
  public void assignToEndNameTso(@RequestBody AssignToEndNameTsoToConnectivityNodeCommand command) {
    try {
      ConnectivityNodeBusinessDelegate.getConnectivityNodeInstance().assignToEndNameTso(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign ToEndNameTso", exc);
    }
  }

  /**
   * unassign ToEndNameTso on ConnectivityNode
   *
   * @param command UnAssignToEndNameTsoFromConnectivityNodeCommand
   */
  @PutMapping("/unAssignToEndNameTso")
  public void unAssignToEndNameTso(
      @RequestBody(required = true) UnAssignToEndNameTsoFromConnectivityNodeCommand command) {
    try {
      ConnectivityNodeBusinessDelegate.getConnectivityNodeInstance().unAssignToEndNameTso(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign ToEndNameTso", exc);
    }
  }

  /**
   * save ConnectivityNodes on ConnectivityNode
   *
   * @param command AssignConnectivityNodesToConnectivityNodeCommand
   */
  @PutMapping("/addToConnectivityNodes")
  public void addToConnectivityNodes(
      @RequestBody(required = true) AssignConnectivityNodesToConnectivityNodeCommand command) {
    try {
      ConnectivityNodeBusinessDelegate.getConnectivityNodeInstance()
          .addToConnectivityNodes(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to add to Set ConnectivityNodes", exc);
    }
  }

  /**
   * remove ConnectivityNodes on ConnectivityNode
   *
   * @param command RemoveConnectivityNodesFromConnectivityNodeCommand
   */
  @PutMapping("/removeFromConnectivityNodes")
  public void removeFromConnectivityNodes(
      @RequestBody(required = true) RemoveConnectivityNodesFromConnectivityNodeCommand command) {
    try {
      ConnectivityNodeBusinessDelegate.getConnectivityNodeInstance()
          .removeFromConnectivityNodes(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to remove from Set ConnectivityNodes", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected ConnectivityNode connectivityNode = null;
  private static final Logger LOGGER =
      Logger.getLogger(ConnectivityNodeCommandRestController.class.getName());
}
