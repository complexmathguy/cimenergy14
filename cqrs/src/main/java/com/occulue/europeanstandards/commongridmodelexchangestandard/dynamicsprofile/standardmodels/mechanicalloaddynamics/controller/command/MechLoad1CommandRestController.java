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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.mechanicalloaddynamics.controller.command;

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
 * Implements Spring Controller command CQRS processing for entity MechLoad1.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/MechLoad1")
public class MechLoad1CommandRestController extends BaseSpringRestController {

  /**
   * Handles create a MechLoad1. if not key provided, calls create, otherwise calls save
   *
   * @param MechLoad1 mechLoad1
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateMechLoad1Command command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture = MechLoad1BusinessDelegate.getMechLoad1Instance().createMechLoad1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a MechLoad1. if no key provided, calls create, otherwise calls save
   *
   * @param MechLoad1 mechLoad1
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateMechLoad1Command command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateMechLoad1Command
      // -----------------------------------------------
      completableFuture = MechLoad1BusinessDelegate.getMechLoad1Instance().updateMechLoad1(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "MechLoad1Controller:update() - successfully update MechLoad1 - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a MechLoad1 entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID mechLoad1Id) {
    CompletableFuture<Void> completableFuture = null;
    DeleteMechLoad1Command command = new DeleteMechLoad1Command(mechLoad1Id);

    try {
      MechLoad1BusinessDelegate delegate = MechLoad1BusinessDelegate.getMechLoad1Instance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING, "Successfully deleted MechLoad1 with key " + command.getMechLoad1Id());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save A on MechLoad1
   *
   * @param command AssignAToMechLoad1Command
   */
  @PutMapping("/assignA")
  public void assignA(@RequestBody AssignAToMechLoad1Command command) {
    try {
      MechLoad1BusinessDelegate.getMechLoad1Instance().assignA(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign A", exc);
    }
  }

  /**
   * unassign A on MechLoad1
   *
   * @param command UnAssignAFromMechLoad1Command
   */
  @PutMapping("/unAssignA")
  public void unAssignA(@RequestBody(required = true) UnAssignAFromMechLoad1Command command) {
    try {
      MechLoad1BusinessDelegate.getMechLoad1Instance().unAssignA(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign A", exc);
    }
  }

  /**
   * save B on MechLoad1
   *
   * @param command AssignBToMechLoad1Command
   */
  @PutMapping("/assignB")
  public void assignB(@RequestBody AssignBToMechLoad1Command command) {
    try {
      MechLoad1BusinessDelegate.getMechLoad1Instance().assignB(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign B", exc);
    }
  }

  /**
   * unassign B on MechLoad1
   *
   * @param command UnAssignBFromMechLoad1Command
   */
  @PutMapping("/unAssignB")
  public void unAssignB(@RequestBody(required = true) UnAssignBFromMechLoad1Command command) {
    try {
      MechLoad1BusinessDelegate.getMechLoad1Instance().unAssignB(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign B", exc);
    }
  }

  /**
   * save D on MechLoad1
   *
   * @param command AssignDToMechLoad1Command
   */
  @PutMapping("/assignD")
  public void assignD(@RequestBody AssignDToMechLoad1Command command) {
    try {
      MechLoad1BusinessDelegate.getMechLoad1Instance().assignD(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign D", exc);
    }
  }

  /**
   * unassign D on MechLoad1
   *
   * @param command UnAssignDFromMechLoad1Command
   */
  @PutMapping("/unAssignD")
  public void unAssignD(@RequestBody(required = true) UnAssignDFromMechLoad1Command command) {
    try {
      MechLoad1BusinessDelegate.getMechLoad1Instance().unAssignD(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign D", exc);
    }
  }

  /**
   * save E on MechLoad1
   *
   * @param command AssignEToMechLoad1Command
   */
  @PutMapping("/assignE")
  public void assignE(@RequestBody AssignEToMechLoad1Command command) {
    try {
      MechLoad1BusinessDelegate.getMechLoad1Instance().assignE(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign E", exc);
    }
  }

  /**
   * unassign E on MechLoad1
   *
   * @param command UnAssignEFromMechLoad1Command
   */
  @PutMapping("/unAssignE")
  public void unAssignE(@RequestBody(required = true) UnAssignEFromMechLoad1Command command) {
    try {
      MechLoad1BusinessDelegate.getMechLoad1Instance().unAssignE(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign E", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected MechLoad1 mechLoad1 = null;
  private static final Logger LOGGER =
      Logger.getLogger(MechLoad1CommandRestController.class.getName());
}
