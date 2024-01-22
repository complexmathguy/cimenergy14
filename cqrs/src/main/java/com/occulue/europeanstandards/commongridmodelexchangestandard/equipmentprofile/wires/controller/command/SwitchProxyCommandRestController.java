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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.controller.command;

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
 * Implements Spring Controller command CQRS processing for entity SwitchProxy.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/SwitchProxy")
public class SwitchProxyCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a SwitchProxy. if not key provided, calls create, otherwise calls save
   *
   * @param SwitchProxy switchProxy
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateSwitchProxyCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          SwitchProxyBusinessDelegate.getSwitchProxyInstance().createSwitchProxy(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a SwitchProxy. if no key provided, calls create, otherwise calls save
   *
   * @param SwitchProxy switchProxy
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateSwitchProxyCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateSwitchProxyCommand
      // -----------------------------------------------
      completableFuture =
          SwitchProxyBusinessDelegate.getSwitchProxyInstance().updateSwitchProxy(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "SwitchProxyController:update() - successfully update SwitchProxy - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a SwitchProxy entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID switchProxyId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteSwitchProxyCommand command = new DeleteSwitchProxyCommand(switchProxyId);

    try {
      SwitchProxyBusinessDelegate delegate = SwitchProxyBusinessDelegate.getSwitchProxyInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING, "Successfully deleted SwitchProxy with key " + command.getSwitchProxyId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save NormalOpen on SwitchProxy
   *
   * @param command AssignNormalOpenToSwitchProxyCommand
   */
  @PutMapping("/assignNormalOpen")
  public void assignNormalOpen(@RequestBody AssignNormalOpenToSwitchProxyCommand command) {
    try {
      SwitchProxyBusinessDelegate.getSwitchProxyInstance().assignNormalOpen(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign NormalOpen", exc);
    }
  }

  /**
   * unassign NormalOpen on SwitchProxy
   *
   * @param command UnAssignNormalOpenFromSwitchProxyCommand
   */
  @PutMapping("/unAssignNormalOpen")
  public void unAssignNormalOpen(
      @RequestBody(required = true) UnAssignNormalOpenFromSwitchProxyCommand command) {
    try {
      SwitchProxyBusinessDelegate.getSwitchProxyInstance().unAssignNormalOpen(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign NormalOpen", exc);
    }
  }

  /**
   * save RatedCurrent on SwitchProxy
   *
   * @param command AssignRatedCurrentToSwitchProxyCommand
   */
  @PutMapping("/assignRatedCurrent")
  public void assignRatedCurrent(@RequestBody AssignRatedCurrentToSwitchProxyCommand command) {
    try {
      SwitchProxyBusinessDelegate.getSwitchProxyInstance().assignRatedCurrent(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign RatedCurrent", exc);
    }
  }

  /**
   * unassign RatedCurrent on SwitchProxy
   *
   * @param command UnAssignRatedCurrentFromSwitchProxyCommand
   */
  @PutMapping("/unAssignRatedCurrent")
  public void unAssignRatedCurrent(
      @RequestBody(required = true) UnAssignRatedCurrentFromSwitchProxyCommand command) {
    try {
      SwitchProxyBusinessDelegate.getSwitchProxyInstance().unAssignRatedCurrent(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign RatedCurrent", exc);
    }
  }

  /**
   * save Retained on SwitchProxy
   *
   * @param command AssignRetainedToSwitchProxyCommand
   */
  @PutMapping("/assignRetained")
  public void assignRetained(@RequestBody AssignRetainedToSwitchProxyCommand command) {
    try {
      SwitchProxyBusinessDelegate.getSwitchProxyInstance().assignRetained(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Retained", exc);
    }
  }

  /**
   * unassign Retained on SwitchProxy
   *
   * @param command UnAssignRetainedFromSwitchProxyCommand
   */
  @PutMapping("/unAssignRetained")
  public void unAssignRetained(
      @RequestBody(required = true) UnAssignRetainedFromSwitchProxyCommand command) {
    try {
      SwitchProxyBusinessDelegate.getSwitchProxyInstance().unAssignRetained(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Retained", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected SwitchProxy switchProxy = null;
  private static final Logger LOGGER =
      Logger.getLogger(SwitchProxyCommandRestController.class.getName());
}
