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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.voltagecompensatordynamics.controller.command;

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
 * Implements Spring Controller command CQRS processing for entity VCompIEEEType2.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/VCompIEEEType2")
public class VCompIEEEType2CommandRestController extends BaseSpringRestController {

  /**
   * Handles create a VCompIEEEType2. if not key provided, calls create, otherwise calls save
   *
   * @param VCompIEEEType2 vCompIEEEType2
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateVCompIEEEType2Command command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          VCompIEEEType2BusinessDelegate.getVCompIEEEType2Instance().createVCompIEEEType2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a VCompIEEEType2. if no key provided, calls create, otherwise calls save
   *
   * @param VCompIEEEType2 vCompIEEEType2
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateVCompIEEEType2Command command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateVCompIEEEType2Command
      // -----------------------------------------------
      completableFuture =
          VCompIEEEType2BusinessDelegate.getVCompIEEEType2Instance().updateVCompIEEEType2(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "VCompIEEEType2Controller:update() - successfully update VCompIEEEType2 - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a VCompIEEEType2 entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID vCompIEEEType2Id) {
    CompletableFuture<Void> completableFuture = null;
    DeleteVCompIEEEType2Command command = new DeleteVCompIEEEType2Command(vCompIEEEType2Id);

    try {
      VCompIEEEType2BusinessDelegate delegate =
          VCompIEEEType2BusinessDelegate.getVCompIEEEType2Instance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted VCompIEEEType2 with key " + command.getVCompIEEEType2Id());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Tr on VCompIEEEType2
   *
   * @param command AssignTrToVCompIEEEType2Command
   */
  @PutMapping("/assignTr")
  public void assignTr(@RequestBody AssignTrToVCompIEEEType2Command command) {
    try {
      VCompIEEEType2BusinessDelegate.getVCompIEEEType2Instance().assignTr(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tr", exc);
    }
  }

  /**
   * unassign Tr on VCompIEEEType2
   *
   * @param command UnAssignTrFromVCompIEEEType2Command
   */
  @PutMapping("/unAssignTr")
  public void unAssignTr(
      @RequestBody(required = true) UnAssignTrFromVCompIEEEType2Command command) {
    try {
      VCompIEEEType2BusinessDelegate.getVCompIEEEType2Instance().unAssignTr(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tr", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected VCompIEEEType2 vCompIEEEType2 = null;
  private static final Logger LOGGER =
      Logger.getLogger(VCompIEEEType2CommandRestController.class.getName());
}
