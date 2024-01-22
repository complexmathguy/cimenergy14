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
 * Implements Spring Controller command CQRS processing for entity SvInjection.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/SvInjection")
public class SvInjectionCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a SvInjection. if not key provided, calls create, otherwise calls save
   *
   * @param SvInjection svInjection
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateSvInjectionCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          SvInjectionBusinessDelegate.getSvInjectionInstance().createSvInjection(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a SvInjection. if no key provided, calls create, otherwise calls save
   *
   * @param SvInjection svInjection
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateSvInjectionCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateSvInjectionCommand
      // -----------------------------------------------
      completableFuture =
          SvInjectionBusinessDelegate.getSvInjectionInstance().updateSvInjection(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "SvInjectionController:update() - successfully update SvInjection - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a SvInjection entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID svInjectionId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteSvInjectionCommand command = new DeleteSvInjectionCommand(svInjectionId);

    try {
      SvInjectionBusinessDelegate delegate = SvInjectionBusinessDelegate.getSvInjectionInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING, "Successfully deleted SvInjection with key " + command.getSvInjectionId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save PInjection on SvInjection
   *
   * @param command AssignPInjectionToSvInjectionCommand
   */
  @PutMapping("/assignPInjection")
  public void assignPInjection(@RequestBody AssignPInjectionToSvInjectionCommand command) {
    try {
      SvInjectionBusinessDelegate.getSvInjectionInstance().assignPInjection(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign PInjection", exc);
    }
  }

  /**
   * unassign PInjection on SvInjection
   *
   * @param command UnAssignPInjectionFromSvInjectionCommand
   */
  @PutMapping("/unAssignPInjection")
  public void unAssignPInjection(
      @RequestBody(required = true) UnAssignPInjectionFromSvInjectionCommand command) {
    try {
      SvInjectionBusinessDelegate.getSvInjectionInstance().unAssignPInjection(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign PInjection", exc);
    }
  }

  /**
   * save QInjection on SvInjection
   *
   * @param command AssignQInjectionToSvInjectionCommand
   */
  @PutMapping("/assignQInjection")
  public void assignQInjection(@RequestBody AssignQInjectionToSvInjectionCommand command) {
    try {
      SvInjectionBusinessDelegate.getSvInjectionInstance().assignQInjection(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign QInjection", exc);
    }
  }

  /**
   * unassign QInjection on SvInjection
   *
   * @param command UnAssignQInjectionFromSvInjectionCommand
   */
  @PutMapping("/unAssignQInjection")
  public void unAssignQInjection(
      @RequestBody(required = true) UnAssignQInjectionFromSvInjectionCommand command) {
    try {
      SvInjectionBusinessDelegate.getSvInjectionInstance().unAssignQInjection(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign QInjection", exc);
    }
  }

  /**
   * save SvInjection on SvInjection
   *
   * @param command AssignSvInjectionToSvInjectionCommand
   */
  @PutMapping("/assignSvInjection")
  public void assignSvInjection(@RequestBody AssignSvInjectionToSvInjectionCommand command) {
    try {
      SvInjectionBusinessDelegate.getSvInjectionInstance().assignSvInjection(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign SvInjection", exc);
    }
  }

  /**
   * unassign SvInjection on SvInjection
   *
   * @param command UnAssignSvInjectionFromSvInjectionCommand
   */
  @PutMapping("/unAssignSvInjection")
  public void unAssignSvInjection(
      @RequestBody(required = true) UnAssignSvInjectionFromSvInjectionCommand command) {
    try {
      SvInjectionBusinessDelegate.getSvInjectionInstance().unAssignSvInjection(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign SvInjection", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected SvInjection svInjection = null;
  private static final Logger LOGGER =
      Logger.getLogger(SvInjectionCommandRestController.class.getName());
}
