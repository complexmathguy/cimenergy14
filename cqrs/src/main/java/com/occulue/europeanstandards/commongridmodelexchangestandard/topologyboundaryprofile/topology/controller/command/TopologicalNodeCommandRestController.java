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
package com.occulue.europeanstandards.commongridmodelexchangestandard.topologyboundaryprofile.topology.controller.command;

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
 * Implements Spring Controller command CQRS processing for entity TopologicalNode.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/TopologicalNode")
public class TopologicalNodeCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a TopologicalNode. if not key provided, calls create, otherwise calls save
   *
   * @param TopologicalNode topologicalNode
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateTopologicalNodeCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          TopologicalNodeBusinessDelegate.getTopologicalNodeInstance()
              .createTopologicalNode(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a TopologicalNode. if no key provided, calls create, otherwise calls save
   *
   * @param TopologicalNode topologicalNode
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateTopologicalNodeCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateTopologicalNodeCommand
      // -----------------------------------------------
      completableFuture =
          TopologicalNodeBusinessDelegate.getTopologicalNodeInstance()
              .updateTopologicalNode(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "TopologicalNodeController:update() - successfully update TopologicalNode - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a TopologicalNode entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID topologicalNodeId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteTopologicalNodeCommand command = new DeleteTopologicalNodeCommand(topologicalNodeId);

    try {
      TopologicalNodeBusinessDelegate delegate =
          TopologicalNodeBusinessDelegate.getTopologicalNodeInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted TopologicalNode with key " + command.getTopologicalNodeId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save BoundaryPoint on TopologicalNode
   *
   * @param command AssignBoundaryPointToTopologicalNodeCommand
   */
  @PutMapping("/assignBoundaryPoint")
  public void assignBoundaryPoint(
      @RequestBody AssignBoundaryPointToTopologicalNodeCommand command) {
    try {
      TopologicalNodeBusinessDelegate.getTopologicalNodeInstance().assignBoundaryPoint(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign BoundaryPoint", exc);
    }
  }

  /**
   * unassign BoundaryPoint on TopologicalNode
   *
   * @param command UnAssignBoundaryPointFromTopologicalNodeCommand
   */
  @PutMapping("/unAssignBoundaryPoint")
  public void unAssignBoundaryPoint(
      @RequestBody(required = true) UnAssignBoundaryPointFromTopologicalNodeCommand command) {
    try {
      TopologicalNodeBusinessDelegate.getTopologicalNodeInstance().unAssignBoundaryPoint(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign BoundaryPoint", exc);
    }
  }

  /**
   * save FromEndIsoCode on TopologicalNode
   *
   * @param command AssignFromEndIsoCodeToTopologicalNodeCommand
   */
  @PutMapping("/assignFromEndIsoCode")
  public void assignFromEndIsoCode(
      @RequestBody AssignFromEndIsoCodeToTopologicalNodeCommand command) {
    try {
      TopologicalNodeBusinessDelegate.getTopologicalNodeInstance().assignFromEndIsoCode(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign FromEndIsoCode", exc);
    }
  }

  /**
   * unassign FromEndIsoCode on TopologicalNode
   *
   * @param command UnAssignFromEndIsoCodeFromTopologicalNodeCommand
   */
  @PutMapping("/unAssignFromEndIsoCode")
  public void unAssignFromEndIsoCode(
      @RequestBody(required = true) UnAssignFromEndIsoCodeFromTopologicalNodeCommand command) {
    try {
      TopologicalNodeBusinessDelegate.getTopologicalNodeInstance().unAssignFromEndIsoCode(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign FromEndIsoCode", exc);
    }
  }

  /**
   * save FromEndName on TopologicalNode
   *
   * @param command AssignFromEndNameToTopologicalNodeCommand
   */
  @PutMapping("/assignFromEndName")
  public void assignFromEndName(@RequestBody AssignFromEndNameToTopologicalNodeCommand command) {
    try {
      TopologicalNodeBusinessDelegate.getTopologicalNodeInstance().assignFromEndName(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign FromEndName", exc);
    }
  }

  /**
   * unassign FromEndName on TopologicalNode
   *
   * @param command UnAssignFromEndNameFromTopologicalNodeCommand
   */
  @PutMapping("/unAssignFromEndName")
  public void unAssignFromEndName(
      @RequestBody(required = true) UnAssignFromEndNameFromTopologicalNodeCommand command) {
    try {
      TopologicalNodeBusinessDelegate.getTopologicalNodeInstance().unAssignFromEndName(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign FromEndName", exc);
    }
  }

  /**
   * save FromEndNameTso on TopologicalNode
   *
   * @param command AssignFromEndNameTsoToTopologicalNodeCommand
   */
  @PutMapping("/assignFromEndNameTso")
  public void assignFromEndNameTso(
      @RequestBody AssignFromEndNameTsoToTopologicalNodeCommand command) {
    try {
      TopologicalNodeBusinessDelegate.getTopologicalNodeInstance().assignFromEndNameTso(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign FromEndNameTso", exc);
    }
  }

  /**
   * unassign FromEndNameTso on TopologicalNode
   *
   * @param command UnAssignFromEndNameTsoFromTopologicalNodeCommand
   */
  @PutMapping("/unAssignFromEndNameTso")
  public void unAssignFromEndNameTso(
      @RequestBody(required = true) UnAssignFromEndNameTsoFromTopologicalNodeCommand command) {
    try {
      TopologicalNodeBusinessDelegate.getTopologicalNodeInstance().unAssignFromEndNameTso(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign FromEndNameTso", exc);
    }
  }

  /**
   * save ToEndIsoCode on TopologicalNode
   *
   * @param command AssignToEndIsoCodeToTopologicalNodeCommand
   */
  @PutMapping("/assignToEndIsoCode")
  public void assignToEndIsoCode(@RequestBody AssignToEndIsoCodeToTopologicalNodeCommand command) {
    try {
      TopologicalNodeBusinessDelegate.getTopologicalNodeInstance().assignToEndIsoCode(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign ToEndIsoCode", exc);
    }
  }

  /**
   * unassign ToEndIsoCode on TopologicalNode
   *
   * @param command UnAssignToEndIsoCodeFromTopologicalNodeCommand
   */
  @PutMapping("/unAssignToEndIsoCode")
  public void unAssignToEndIsoCode(
      @RequestBody(required = true) UnAssignToEndIsoCodeFromTopologicalNodeCommand command) {
    try {
      TopologicalNodeBusinessDelegate.getTopologicalNodeInstance().unAssignToEndIsoCode(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign ToEndIsoCode", exc);
    }
  }

  /**
   * save ToEndName on TopologicalNode
   *
   * @param command AssignToEndNameToTopologicalNodeCommand
   */
  @PutMapping("/assignToEndName")
  public void assignToEndName(@RequestBody AssignToEndNameToTopologicalNodeCommand command) {
    try {
      TopologicalNodeBusinessDelegate.getTopologicalNodeInstance().assignToEndName(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign ToEndName", exc);
    }
  }

  /**
   * unassign ToEndName on TopologicalNode
   *
   * @param command UnAssignToEndNameFromTopologicalNodeCommand
   */
  @PutMapping("/unAssignToEndName")
  public void unAssignToEndName(
      @RequestBody(required = true) UnAssignToEndNameFromTopologicalNodeCommand command) {
    try {
      TopologicalNodeBusinessDelegate.getTopologicalNodeInstance().unAssignToEndName(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign ToEndName", exc);
    }
  }

  /**
   * save ToEndNameTso on TopologicalNode
   *
   * @param command AssignToEndNameTsoToTopologicalNodeCommand
   */
  @PutMapping("/assignToEndNameTso")
  public void assignToEndNameTso(@RequestBody AssignToEndNameTsoToTopologicalNodeCommand command) {
    try {
      TopologicalNodeBusinessDelegate.getTopologicalNodeInstance().assignToEndNameTso(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign ToEndNameTso", exc);
    }
  }

  /**
   * unassign ToEndNameTso on TopologicalNode
   *
   * @param command UnAssignToEndNameTsoFromTopologicalNodeCommand
   */
  @PutMapping("/unAssignToEndNameTso")
  public void unAssignToEndNameTso(
      @RequestBody(required = true) UnAssignToEndNameTsoFromTopologicalNodeCommand command) {
    try {
      TopologicalNodeBusinessDelegate.getTopologicalNodeInstance().unAssignToEndNameTso(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign ToEndNameTso", exc);
    }
  }

  /**
   * save TopologicalNode on TopologicalNode
   *
   * @param command AssignTopologicalNodeToTopologicalNodeCommand
   */
  @PutMapping("/addToTopologicalNode")
  public void addToTopologicalNode(
      @RequestBody(required = true) AssignTopologicalNodeToTopologicalNodeCommand command) {
    try {
      TopologicalNodeBusinessDelegate.getTopologicalNodeInstance().addToTopologicalNode(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to add to Set TopologicalNode", exc);
    }
  }

  /**
   * remove TopologicalNode on TopologicalNode
   *
   * @param command RemoveTopologicalNodeFromTopologicalNodeCommand
   */
  @PutMapping("/removeFromTopologicalNode")
  public void removeFromTopologicalNode(
      @RequestBody(required = true) RemoveTopologicalNodeFromTopologicalNodeCommand command) {
    try {
      TopologicalNodeBusinessDelegate.getTopologicalNodeInstance()
          .removeFromTopologicalNode(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to remove from Set TopologicalNode", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected TopologicalNode topologicalNode = null;
  private static final Logger LOGGER =
      Logger.getLogger(TopologicalNodeCommandRestController.class.getName());
}
