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
 * Implements Spring Controller command CQRS processing for entity PU.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/PU")
public class PUCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a PU. if not key provided, calls create, otherwise calls save
   *
   * @param PU pU
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(@RequestBody(required = true) CreatePUCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture = PUBusinessDelegate.getPUInstance().createPU(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a PU. if no key provided, calls create, otherwise calls save
   *
   * @param PU pU
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(@RequestBody(required = true) UpdatePUCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdatePUCommand
      // -----------------------------------------------
      completableFuture = PUBusinessDelegate.getPUInstance().updatePU(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING, "PUController:update() - successfully update PU - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a PU entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID pUId) {
    CompletableFuture<Void> completableFuture = null;
    DeletePUCommand command = new DeletePUCommand(pUId);

    try {
      PUBusinessDelegate delegate = PUBusinessDelegate.getPUInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(Level.WARNING, "Successfully deleted PU with key " + command.getPUId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Value on PU
   *
   * @param command AssignValueToPUCommand
   */
  @PutMapping("/assignValue")
  public void assignValue(@RequestBody AssignValueToPUCommand command) {
    try {
      PUBusinessDelegate.getPUInstance().assignValue(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Value", exc);
    }
  }

  /**
   * unassign Value on PU
   *
   * @param command UnAssignValueFromPUCommand
   */
  @PutMapping("/unAssignValue")
  public void unAssignValue(@RequestBody(required = true) UnAssignValueFromPUCommand command) {
    try {
      PUBusinessDelegate.getPUInstance().unAssignValue(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Value", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected PU pU = null;
  private static final Logger LOGGER = Logger.getLogger(PUCommandRestController.class.getName());
}
