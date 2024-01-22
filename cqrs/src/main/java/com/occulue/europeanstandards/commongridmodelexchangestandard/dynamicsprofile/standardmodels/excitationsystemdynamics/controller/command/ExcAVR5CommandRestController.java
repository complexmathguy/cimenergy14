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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.excitationsystemdynamics.controller.command;

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
 * Implements Spring Controller command CQRS processing for entity ExcAVR5.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcAVR5")
public class ExcAVR5CommandRestController extends BaseSpringRestController {

  /**
   * Handles create a ExcAVR5. if not key provided, calls create, otherwise calls save
   *
   * @param ExcAVR5 excAVR5
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateExcAVR5Command command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture = ExcAVR5BusinessDelegate.getExcAVR5Instance().createExcAVR5(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a ExcAVR5. if no key provided, calls create, otherwise calls save
   *
   * @param ExcAVR5 excAVR5
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateExcAVR5Command command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateExcAVR5Command
      // -----------------------------------------------
      completableFuture = ExcAVR5BusinessDelegate.getExcAVR5Instance().updateExcAVR5(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "ExcAVR5Controller:update() - successfully update ExcAVR5 - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a ExcAVR5 entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID excAVR5Id) {
    CompletableFuture<Void> completableFuture = null;
    DeleteExcAVR5Command command = new DeleteExcAVR5Command(excAVR5Id);

    try {
      ExcAVR5BusinessDelegate delegate = ExcAVR5BusinessDelegate.getExcAVR5Instance();

      completableFuture = delegate.delete(command);
      LOGGER.log(Level.WARNING, "Successfully deleted ExcAVR5 with key " + command.getExcAVR5Id());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Ka on ExcAVR5
   *
   * @param command AssignKaToExcAVR5Command
   */
  @PutMapping("/assignKa")
  public void assignKa(@RequestBody AssignKaToExcAVR5Command command) {
    try {
      ExcAVR5BusinessDelegate.getExcAVR5Instance().assignKa(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ka", exc);
    }
  }

  /**
   * unassign Ka on ExcAVR5
   *
   * @param command UnAssignKaFromExcAVR5Command
   */
  @PutMapping("/unAssignKa")
  public void unAssignKa(@RequestBody(required = true) UnAssignKaFromExcAVR5Command command) {
    try {
      ExcAVR5BusinessDelegate.getExcAVR5Instance().unAssignKa(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ka", exc);
    }
  }

  /**
   * save Rex on ExcAVR5
   *
   * @param command AssignRexToExcAVR5Command
   */
  @PutMapping("/assignRex")
  public void assignRex(@RequestBody AssignRexToExcAVR5Command command) {
    try {
      ExcAVR5BusinessDelegate.getExcAVR5Instance().assignRex(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Rex", exc);
    }
  }

  /**
   * unassign Rex on ExcAVR5
   *
   * @param command UnAssignRexFromExcAVR5Command
   */
  @PutMapping("/unAssignRex")
  public void unAssignRex(@RequestBody(required = true) UnAssignRexFromExcAVR5Command command) {
    try {
      ExcAVR5BusinessDelegate.getExcAVR5Instance().unAssignRex(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Rex", exc);
    }
  }

  /**
   * save Ta on ExcAVR5
   *
   * @param command AssignTaToExcAVR5Command
   */
  @PutMapping("/assignTa")
  public void assignTa(@RequestBody AssignTaToExcAVR5Command command) {
    try {
      ExcAVR5BusinessDelegate.getExcAVR5Instance().assignTa(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ta", exc);
    }
  }

  /**
   * unassign Ta on ExcAVR5
   *
   * @param command UnAssignTaFromExcAVR5Command
   */
  @PutMapping("/unAssignTa")
  public void unAssignTa(@RequestBody(required = true) UnAssignTaFromExcAVR5Command command) {
    try {
      ExcAVR5BusinessDelegate.getExcAVR5Instance().unAssignTa(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ta", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected ExcAVR5 excAVR5 = null;
  private static final Logger LOGGER =
      Logger.getLogger(ExcAVR5CommandRestController.class.getName());
}
