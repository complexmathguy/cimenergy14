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
 * Implements Spring Controller command CQRS processing for entity VCompIEEEType1.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/VCompIEEEType1")
public class VCompIEEEType1CommandRestController extends BaseSpringRestController {

  /**
   * Handles create a VCompIEEEType1. if not key provided, calls create, otherwise calls save
   *
   * @param VCompIEEEType1 vCompIEEEType1
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateVCompIEEEType1Command command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          VCompIEEEType1BusinessDelegate.getVCompIEEEType1Instance().createVCompIEEEType1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a VCompIEEEType1. if no key provided, calls create, otherwise calls save
   *
   * @param VCompIEEEType1 vCompIEEEType1
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateVCompIEEEType1Command command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateVCompIEEEType1Command
      // -----------------------------------------------
      completableFuture =
          VCompIEEEType1BusinessDelegate.getVCompIEEEType1Instance().updateVCompIEEEType1(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "VCompIEEEType1Controller:update() - successfully update VCompIEEEType1 - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a VCompIEEEType1 entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID vCompIEEEType1Id) {
    CompletableFuture<Void> completableFuture = null;
    DeleteVCompIEEEType1Command command = new DeleteVCompIEEEType1Command(vCompIEEEType1Id);

    try {
      VCompIEEEType1BusinessDelegate delegate =
          VCompIEEEType1BusinessDelegate.getVCompIEEEType1Instance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted VCompIEEEType1 with key " + command.getVCompIEEEType1Id());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Rc on VCompIEEEType1
   *
   * @param command AssignRcToVCompIEEEType1Command
   */
  @PutMapping("/assignRc")
  public void assignRc(@RequestBody AssignRcToVCompIEEEType1Command command) {
    try {
      VCompIEEEType1BusinessDelegate.getVCompIEEEType1Instance().assignRc(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Rc", exc);
    }
  }

  /**
   * unassign Rc on VCompIEEEType1
   *
   * @param command UnAssignRcFromVCompIEEEType1Command
   */
  @PutMapping("/unAssignRc")
  public void unAssignRc(
      @RequestBody(required = true) UnAssignRcFromVCompIEEEType1Command command) {
    try {
      VCompIEEEType1BusinessDelegate.getVCompIEEEType1Instance().unAssignRc(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Rc", exc);
    }
  }

  /**
   * save Tr on VCompIEEEType1
   *
   * @param command AssignTrToVCompIEEEType1Command
   */
  @PutMapping("/assignTr")
  public void assignTr(@RequestBody AssignTrToVCompIEEEType1Command command) {
    try {
      VCompIEEEType1BusinessDelegate.getVCompIEEEType1Instance().assignTr(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tr", exc);
    }
  }

  /**
   * unassign Tr on VCompIEEEType1
   *
   * @param command UnAssignTrFromVCompIEEEType1Command
   */
  @PutMapping("/unAssignTr")
  public void unAssignTr(
      @RequestBody(required = true) UnAssignTrFromVCompIEEEType1Command command) {
    try {
      VCompIEEEType1BusinessDelegate.getVCompIEEEType1Instance().unAssignTr(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tr", exc);
    }
  }

  /**
   * save Xc on VCompIEEEType1
   *
   * @param command AssignXcToVCompIEEEType1Command
   */
  @PutMapping("/assignXc")
  public void assignXc(@RequestBody AssignXcToVCompIEEEType1Command command) {
    try {
      VCompIEEEType1BusinessDelegate.getVCompIEEEType1Instance().assignXc(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Xc", exc);
    }
  }

  /**
   * unassign Xc on VCompIEEEType1
   *
   * @param command UnAssignXcFromVCompIEEEType1Command
   */
  @PutMapping("/unAssignXc")
  public void unAssignXc(
      @RequestBody(required = true) UnAssignXcFromVCompIEEEType1Command command) {
    try {
      VCompIEEEType1BusinessDelegate.getVCompIEEEType1Instance().unAssignXc(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Xc", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected VCompIEEEType1 vCompIEEEType1 = null;
  private static final Logger LOGGER =
      Logger.getLogger(VCompIEEEType1CommandRestController.class.getName());
}
