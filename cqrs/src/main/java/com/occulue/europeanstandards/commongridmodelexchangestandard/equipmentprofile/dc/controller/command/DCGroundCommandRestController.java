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
 * Implements Spring Controller command CQRS processing for entity DCGround.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/DCGround")
public class DCGroundCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a DCGround. if not key provided, calls create, otherwise calls save
   *
   * @param DCGround dCGround
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateDCGroundCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture = DCGroundBusinessDelegate.getDCGroundInstance().createDCGround(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a DCGround. if no key provided, calls create, otherwise calls save
   *
   * @param DCGround dCGround
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateDCGroundCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateDCGroundCommand
      // -----------------------------------------------
      completableFuture = DCGroundBusinessDelegate.getDCGroundInstance().updateDCGround(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "DCGroundController:update() - successfully update DCGround - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a DCGround entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID dCGroundId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteDCGroundCommand command = new DeleteDCGroundCommand(dCGroundId);

    try {
      DCGroundBusinessDelegate delegate = DCGroundBusinessDelegate.getDCGroundInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING, "Successfully deleted DCGround with key " + command.getDCGroundId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Inductance on DCGround
   *
   * @param command AssignInductanceToDCGroundCommand
   */
  @PutMapping("/assignInductance")
  public void assignInductance(@RequestBody AssignInductanceToDCGroundCommand command) {
    try {
      DCGroundBusinessDelegate.getDCGroundInstance().assignInductance(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Inductance", exc);
    }
  }

  /**
   * unassign Inductance on DCGround
   *
   * @param command UnAssignInductanceFromDCGroundCommand
   */
  @PutMapping("/unAssignInductance")
  public void unAssignInductance(
      @RequestBody(required = true) UnAssignInductanceFromDCGroundCommand command) {
    try {
      DCGroundBusinessDelegate.getDCGroundInstance().unAssignInductance(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Inductance", exc);
    }
  }

  /**
   * save R on DCGround
   *
   * @param command AssignRToDCGroundCommand
   */
  @PutMapping("/assignR")
  public void assignR(@RequestBody AssignRToDCGroundCommand command) {
    try {
      DCGroundBusinessDelegate.getDCGroundInstance().assignR(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign R", exc);
    }
  }

  /**
   * unassign R on DCGround
   *
   * @param command UnAssignRFromDCGroundCommand
   */
  @PutMapping("/unAssignR")
  public void unAssignR(@RequestBody(required = true) UnAssignRFromDCGroundCommand command) {
    try {
      DCGroundBusinessDelegate.getDCGroundInstance().unAssignR(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign R", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected DCGround dCGround = null;
  private static final Logger LOGGER =
      Logger.getLogger(DCGroundCommandRestController.class.getName());
}
