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
package com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.controller.command;

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
 * Implements Spring Controller command CQRS processing for entity PerCent.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/PerCent")
public class PerCentCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a PerCent. if not key provided, calls create, otherwise calls save
   *
   * @param PerCent perCent
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreatePerCentCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture = PerCentBusinessDelegate.getPerCentInstance().createPerCent(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a PerCent. if no key provided, calls create, otherwise calls save
   *
   * @param PerCent perCent
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdatePerCentCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdatePerCentCommand
      // -----------------------------------------------
      completableFuture = PerCentBusinessDelegate.getPerCentInstance().updatePerCent(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "PerCentController:update() - successfully update PerCent - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a PerCent entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID perCentId) {
    CompletableFuture<Void> completableFuture = null;
    DeletePerCentCommand command = new DeletePerCentCommand(perCentId);

    try {
      PerCentBusinessDelegate delegate = PerCentBusinessDelegate.getPerCentInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(Level.WARNING, "Successfully deleted PerCent with key " + command.getPerCentId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Value on PerCent
   *
   * @param command AssignValueToPerCentCommand
   */
  @PutMapping("/assignValue")
  public void assignValue(@RequestBody AssignValueToPerCentCommand command) {
    try {
      PerCentBusinessDelegate.getPerCentInstance().assignValue(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Value", exc);
    }
  }

  /**
   * unassign Value on PerCent
   *
   * @param command UnAssignValueFromPerCentCommand
   */
  @PutMapping("/unAssignValue")
  public void unAssignValue(@RequestBody(required = true) UnAssignValueFromPerCentCommand command) {
    try {
      PerCentBusinessDelegate.getPerCentInstance().unAssignValue(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Value", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected PerCent perCent = null;
  private static final Logger LOGGER =
      Logger.getLogger(PerCentCommandRestController.class.getName());
}
