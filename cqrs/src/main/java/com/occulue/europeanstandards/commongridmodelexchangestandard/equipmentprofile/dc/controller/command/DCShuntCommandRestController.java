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
 * Implements Spring Controller command CQRS processing for entity DCShunt.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/DCShunt")
public class DCShuntCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a DCShunt. if not key provided, calls create, otherwise calls save
   *
   * @param DCShunt dCShunt
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateDCShuntCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture = DCShuntBusinessDelegate.getDCShuntInstance().createDCShunt(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a DCShunt. if no key provided, calls create, otherwise calls save
   *
   * @param DCShunt dCShunt
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateDCShuntCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateDCShuntCommand
      // -----------------------------------------------
      completableFuture = DCShuntBusinessDelegate.getDCShuntInstance().updateDCShunt(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "DCShuntController:update() - successfully update DCShunt - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a DCShunt entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID dCShuntId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteDCShuntCommand command = new DeleteDCShuntCommand(dCShuntId);

    try {
      DCShuntBusinessDelegate delegate = DCShuntBusinessDelegate.getDCShuntInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(Level.WARNING, "Successfully deleted DCShunt with key " + command.getDCShuntId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Capacitance on DCShunt
   *
   * @param command AssignCapacitanceToDCShuntCommand
   */
  @PutMapping("/assignCapacitance")
  public void assignCapacitance(@RequestBody AssignCapacitanceToDCShuntCommand command) {
    try {
      DCShuntBusinessDelegate.getDCShuntInstance().assignCapacitance(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Capacitance", exc);
    }
  }

  /**
   * unassign Capacitance on DCShunt
   *
   * @param command UnAssignCapacitanceFromDCShuntCommand
   */
  @PutMapping("/unAssignCapacitance")
  public void unAssignCapacitance(
      @RequestBody(required = true) UnAssignCapacitanceFromDCShuntCommand command) {
    try {
      DCShuntBusinessDelegate.getDCShuntInstance().unAssignCapacitance(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Capacitance", exc);
    }
  }

  /**
   * save RatedUdc on DCShunt
   *
   * @param command AssignRatedUdcToDCShuntCommand
   */
  @PutMapping("/assignRatedUdc")
  public void assignRatedUdc(@RequestBody AssignRatedUdcToDCShuntCommand command) {
    try {
      DCShuntBusinessDelegate.getDCShuntInstance().assignRatedUdc(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign RatedUdc", exc);
    }
  }

  /**
   * unassign RatedUdc on DCShunt
   *
   * @param command UnAssignRatedUdcFromDCShuntCommand
   */
  @PutMapping("/unAssignRatedUdc")
  public void unAssignRatedUdc(
      @RequestBody(required = true) UnAssignRatedUdcFromDCShuntCommand command) {
    try {
      DCShuntBusinessDelegate.getDCShuntInstance().unAssignRatedUdc(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign RatedUdc", exc);
    }
  }

  /**
   * save Resistance on DCShunt
   *
   * @param command AssignResistanceToDCShuntCommand
   */
  @PutMapping("/assignResistance")
  public void assignResistance(@RequestBody AssignResistanceToDCShuntCommand command) {
    try {
      DCShuntBusinessDelegate.getDCShuntInstance().assignResistance(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Resistance", exc);
    }
  }

  /**
   * unassign Resistance on DCShunt
   *
   * @param command UnAssignResistanceFromDCShuntCommand
   */
  @PutMapping("/unAssignResistance")
  public void unAssignResistance(
      @RequestBody(required = true) UnAssignResistanceFromDCShuntCommand command) {
    try {
      DCShuntBusinessDelegate.getDCShuntInstance().unAssignResistance(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Resistance", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected DCShunt dCShunt = null;
  private static final Logger LOGGER =
      Logger.getLogger(DCShuntCommandRestController.class.getName());
}
