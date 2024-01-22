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
package com.occulue.europeanstandards.commongridmodelexchangestandard.statevariablesprofile.statevariables.controller.command;

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
 * Implements Spring Controller command CQRS processing for entity SvPowerFlow.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/SvPowerFlow")
public class SvPowerFlowCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a SvPowerFlow. if not key provided, calls create, otherwise calls save
   *
   * @param SvPowerFlow svPowerFlow
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateSvPowerFlowCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          SvPowerFlowBusinessDelegate.getSvPowerFlowInstance().createSvPowerFlow(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a SvPowerFlow. if no key provided, calls create, otherwise calls save
   *
   * @param SvPowerFlow svPowerFlow
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateSvPowerFlowCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateSvPowerFlowCommand
      // -----------------------------------------------
      completableFuture =
          SvPowerFlowBusinessDelegate.getSvPowerFlowInstance().updateSvPowerFlow(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "SvPowerFlowController:update() - successfully update SvPowerFlow - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a SvPowerFlow entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID svPowerFlowId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteSvPowerFlowCommand command = new DeleteSvPowerFlowCommand(svPowerFlowId);

    try {
      SvPowerFlowBusinessDelegate delegate = SvPowerFlowBusinessDelegate.getSvPowerFlowInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING, "Successfully deleted SvPowerFlow with key " + command.getSvPowerFlowId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save P on SvPowerFlow
   *
   * @param command AssignPToSvPowerFlowCommand
   */
  @PutMapping("/assignP")
  public void assignP(@RequestBody AssignPToSvPowerFlowCommand command) {
    try {
      SvPowerFlowBusinessDelegate.getSvPowerFlowInstance().assignP(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign P", exc);
    }
  }

  /**
   * unassign P on SvPowerFlow
   *
   * @param command UnAssignPFromSvPowerFlowCommand
   */
  @PutMapping("/unAssignP")
  public void unAssignP(@RequestBody(required = true) UnAssignPFromSvPowerFlowCommand command) {
    try {
      SvPowerFlowBusinessDelegate.getSvPowerFlowInstance().unAssignP(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign P", exc);
    }
  }

  /**
   * save Q on SvPowerFlow
   *
   * @param command AssignQToSvPowerFlowCommand
   */
  @PutMapping("/assignQ")
  public void assignQ(@RequestBody AssignQToSvPowerFlowCommand command) {
    try {
      SvPowerFlowBusinessDelegate.getSvPowerFlowInstance().assignQ(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Q", exc);
    }
  }

  /**
   * unassign Q on SvPowerFlow
   *
   * @param command UnAssignQFromSvPowerFlowCommand
   */
  @PutMapping("/unAssignQ")
  public void unAssignQ(@RequestBody(required = true) UnAssignQFromSvPowerFlowCommand command) {
    try {
      SvPowerFlowBusinessDelegate.getSvPowerFlowInstance().unAssignQ(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Q", exc);
    }
  }

  /**
   * save SvPowerFlow on SvPowerFlow
   *
   * @param command AssignSvPowerFlowToSvPowerFlowCommand
   */
  @PutMapping("/assignSvPowerFlow")
  public void assignSvPowerFlow(@RequestBody AssignSvPowerFlowToSvPowerFlowCommand command) {
    try {
      SvPowerFlowBusinessDelegate.getSvPowerFlowInstance().assignSvPowerFlow(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign SvPowerFlow", exc);
    }
  }

  /**
   * unassign SvPowerFlow on SvPowerFlow
   *
   * @param command UnAssignSvPowerFlowFromSvPowerFlowCommand
   */
  @PutMapping("/unAssignSvPowerFlow")
  public void unAssignSvPowerFlow(
      @RequestBody(required = true) UnAssignSvPowerFlowFromSvPowerFlowCommand command) {
    try {
      SvPowerFlowBusinessDelegate.getSvPowerFlowInstance().unAssignSvPowerFlow(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign SvPowerFlow", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected SvPowerFlow svPowerFlow = null;
  private static final Logger LOGGER =
      Logger.getLogger(SvPowerFlowCommandRestController.class.getName());
}
