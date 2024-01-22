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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.core.controller.command;

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
 * Implements Spring Controller command CQRS processing for entity VoltageLevel.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/VoltageLevel")
public class VoltageLevelCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a VoltageLevel. if not key provided, calls create, otherwise calls save
   *
   * @param VoltageLevel voltageLevel
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateVoltageLevelCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          VoltageLevelBusinessDelegate.getVoltageLevelInstance().createVoltageLevel(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a VoltageLevel. if no key provided, calls create, otherwise calls save
   *
   * @param VoltageLevel voltageLevel
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateVoltageLevelCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateVoltageLevelCommand
      // -----------------------------------------------
      completableFuture =
          VoltageLevelBusinessDelegate.getVoltageLevelInstance().updateVoltageLevel(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "VoltageLevelController:update() - successfully update VoltageLevel - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a VoltageLevel entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID voltageLevelId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteVoltageLevelCommand command = new DeleteVoltageLevelCommand(voltageLevelId);

    try {
      VoltageLevelBusinessDelegate delegate =
          VoltageLevelBusinessDelegate.getVoltageLevelInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted VoltageLevel with key " + command.getVoltageLevelId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save HighVoltageLimit on VoltageLevel
   *
   * @param command AssignHighVoltageLimitToVoltageLevelCommand
   */
  @PutMapping("/assignHighVoltageLimit")
  public void assignHighVoltageLimit(
      @RequestBody AssignHighVoltageLimitToVoltageLevelCommand command) {
    try {
      VoltageLevelBusinessDelegate.getVoltageLevelInstance().assignHighVoltageLimit(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign HighVoltageLimit", exc);
    }
  }

  /**
   * unassign HighVoltageLimit on VoltageLevel
   *
   * @param command UnAssignHighVoltageLimitFromVoltageLevelCommand
   */
  @PutMapping("/unAssignHighVoltageLimit")
  public void unAssignHighVoltageLimit(
      @RequestBody(required = true) UnAssignHighVoltageLimitFromVoltageLevelCommand command) {
    try {
      VoltageLevelBusinessDelegate.getVoltageLevelInstance().unAssignHighVoltageLimit(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign HighVoltageLimit", exc);
    }
  }

  /**
   * save LowVoltageLimit on VoltageLevel
   *
   * @param command AssignLowVoltageLimitToVoltageLevelCommand
   */
  @PutMapping("/assignLowVoltageLimit")
  public void assignLowVoltageLimit(
      @RequestBody AssignLowVoltageLimitToVoltageLevelCommand command) {
    try {
      VoltageLevelBusinessDelegate.getVoltageLevelInstance().assignLowVoltageLimit(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign LowVoltageLimit", exc);
    }
  }

  /**
   * unassign LowVoltageLimit on VoltageLevel
   *
   * @param command UnAssignLowVoltageLimitFromVoltageLevelCommand
   */
  @PutMapping("/unAssignLowVoltageLimit")
  public void unAssignLowVoltageLimit(
      @RequestBody(required = true) UnAssignLowVoltageLimitFromVoltageLevelCommand command) {
    try {
      VoltageLevelBusinessDelegate.getVoltageLevelInstance().unAssignLowVoltageLimit(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign LowVoltageLimit", exc);
    }
  }

  /**
   * save VoltageLevel on VoltageLevel
   *
   * @param command AssignVoltageLevelToVoltageLevelCommand
   */
  @PutMapping("/addToVoltageLevel")
  public void addToVoltageLevel(
      @RequestBody(required = true) AssignVoltageLevelToVoltageLevelCommand command) {
    try {
      VoltageLevelBusinessDelegate.getVoltageLevelInstance().addToVoltageLevel(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to add to Set VoltageLevel", exc);
    }
  }

  /**
   * remove VoltageLevel on VoltageLevel
   *
   * @param command RemoveVoltageLevelFromVoltageLevelCommand
   */
  @PutMapping("/removeFromVoltageLevel")
  public void removeFromVoltageLevel(
      @RequestBody(required = true) RemoveVoltageLevelFromVoltageLevelCommand command) {
    try {
      VoltageLevelBusinessDelegate.getVoltageLevelInstance().removeFromVoltageLevel(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to remove from Set VoltageLevel", exc);
    }
  }

  /**
   * save VoltageLevels on VoltageLevel
   *
   * @param command AssignVoltageLevelsToVoltageLevelCommand
   */
  @PutMapping("/addToVoltageLevels")
  public void addToVoltageLevels(
      @RequestBody(required = true) AssignVoltageLevelsToVoltageLevelCommand command) {
    try {
      VoltageLevelBusinessDelegate.getVoltageLevelInstance().addToVoltageLevels(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to add to Set VoltageLevels", exc);
    }
  }

  /**
   * remove VoltageLevels on VoltageLevel
   *
   * @param command RemoveVoltageLevelsFromVoltageLevelCommand
   */
  @PutMapping("/removeFromVoltageLevels")
  public void removeFromVoltageLevels(
      @RequestBody(required = true) RemoveVoltageLevelsFromVoltageLevelCommand command) {
    try {
      VoltageLevelBusinessDelegate.getVoltageLevelInstance().removeFromVoltageLevels(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to remove from Set VoltageLevels", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected VoltageLevel voltageLevel = null;
  private static final Logger LOGGER =
      Logger.getLogger(VoltageLevelCommandRestController.class.getName());
}
