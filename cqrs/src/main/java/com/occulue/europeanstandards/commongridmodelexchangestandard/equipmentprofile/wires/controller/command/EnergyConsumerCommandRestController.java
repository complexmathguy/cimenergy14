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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.controller.command;

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
 * Implements Spring Controller command CQRS processing for entity EnergyConsumer.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/EnergyConsumer")
public class EnergyConsumerCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a EnergyConsumer. if not key provided, calls create, otherwise calls save
   *
   * @param EnergyConsumer energyConsumer
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateEnergyConsumerCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          EnergyConsumerBusinessDelegate.getEnergyConsumerInstance().createEnergyConsumer(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a EnergyConsumer. if no key provided, calls create, otherwise calls save
   *
   * @param EnergyConsumer energyConsumer
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateEnergyConsumerCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateEnergyConsumerCommand
      // -----------------------------------------------
      completableFuture =
          EnergyConsumerBusinessDelegate.getEnergyConsumerInstance().updateEnergyConsumer(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "EnergyConsumerController:update() - successfully update EnergyConsumer - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a EnergyConsumer entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID energyConsumerId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteEnergyConsumerCommand command = new DeleteEnergyConsumerCommand(energyConsumerId);

    try {
      EnergyConsumerBusinessDelegate delegate =
          EnergyConsumerBusinessDelegate.getEnergyConsumerInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted EnergyConsumer with key " + command.getEnergyConsumerId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Pfixed on EnergyConsumer
   *
   * @param command AssignPfixedToEnergyConsumerCommand
   */
  @PutMapping("/assignPfixed")
  public void assignPfixed(@RequestBody AssignPfixedToEnergyConsumerCommand command) {
    try {
      EnergyConsumerBusinessDelegate.getEnergyConsumerInstance().assignPfixed(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Pfixed", exc);
    }
  }

  /**
   * unassign Pfixed on EnergyConsumer
   *
   * @param command UnAssignPfixedFromEnergyConsumerCommand
   */
  @PutMapping("/unAssignPfixed")
  public void unAssignPfixed(
      @RequestBody(required = true) UnAssignPfixedFromEnergyConsumerCommand command) {
    try {
      EnergyConsumerBusinessDelegate.getEnergyConsumerInstance().unAssignPfixed(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Pfixed", exc);
    }
  }

  /**
   * save PfixedPct on EnergyConsumer
   *
   * @param command AssignPfixedPctToEnergyConsumerCommand
   */
  @PutMapping("/assignPfixedPct")
  public void assignPfixedPct(@RequestBody AssignPfixedPctToEnergyConsumerCommand command) {
    try {
      EnergyConsumerBusinessDelegate.getEnergyConsumerInstance().assignPfixedPct(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign PfixedPct", exc);
    }
  }

  /**
   * unassign PfixedPct on EnergyConsumer
   *
   * @param command UnAssignPfixedPctFromEnergyConsumerCommand
   */
  @PutMapping("/unAssignPfixedPct")
  public void unAssignPfixedPct(
      @RequestBody(required = true) UnAssignPfixedPctFromEnergyConsumerCommand command) {
    try {
      EnergyConsumerBusinessDelegate.getEnergyConsumerInstance().unAssignPfixedPct(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign PfixedPct", exc);
    }
  }

  /**
   * save Qfixed on EnergyConsumer
   *
   * @param command AssignQfixedToEnergyConsumerCommand
   */
  @PutMapping("/assignQfixed")
  public void assignQfixed(@RequestBody AssignQfixedToEnergyConsumerCommand command) {
    try {
      EnergyConsumerBusinessDelegate.getEnergyConsumerInstance().assignQfixed(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Qfixed", exc);
    }
  }

  /**
   * unassign Qfixed on EnergyConsumer
   *
   * @param command UnAssignQfixedFromEnergyConsumerCommand
   */
  @PutMapping("/unAssignQfixed")
  public void unAssignQfixed(
      @RequestBody(required = true) UnAssignQfixedFromEnergyConsumerCommand command) {
    try {
      EnergyConsumerBusinessDelegate.getEnergyConsumerInstance().unAssignQfixed(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Qfixed", exc);
    }
  }

  /**
   * save QfixedPct on EnergyConsumer
   *
   * @param command AssignQfixedPctToEnergyConsumerCommand
   */
  @PutMapping("/assignQfixedPct")
  public void assignQfixedPct(@RequestBody AssignQfixedPctToEnergyConsumerCommand command) {
    try {
      EnergyConsumerBusinessDelegate.getEnergyConsumerInstance().assignQfixedPct(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign QfixedPct", exc);
    }
  }

  /**
   * unassign QfixedPct on EnergyConsumer
   *
   * @param command UnAssignQfixedPctFromEnergyConsumerCommand
   */
  @PutMapping("/unAssignQfixedPct")
  public void unAssignQfixedPct(
      @RequestBody(required = true) UnAssignQfixedPctFromEnergyConsumerCommand command) {
    try {
      EnergyConsumerBusinessDelegate.getEnergyConsumerInstance().unAssignQfixedPct(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign QfixedPct", exc);
    }
  }

  /**
   * save EnergyConsumer on EnergyConsumer
   *
   * @param command AssignEnergyConsumerToEnergyConsumerCommand
   */
  @PutMapping("/addToEnergyConsumer")
  public void addToEnergyConsumer(
      @RequestBody(required = true) AssignEnergyConsumerToEnergyConsumerCommand command) {
    try {
      EnergyConsumerBusinessDelegate.getEnergyConsumerInstance().addToEnergyConsumer(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to add to Set EnergyConsumer", exc);
    }
  }

  /**
   * remove EnergyConsumer on EnergyConsumer
   *
   * @param command RemoveEnergyConsumerFromEnergyConsumerCommand
   */
  @PutMapping("/removeFromEnergyConsumer")
  public void removeFromEnergyConsumer(
      @RequestBody(required = true) RemoveEnergyConsumerFromEnergyConsumerCommand command) {
    try {
      EnergyConsumerBusinessDelegate.getEnergyConsumerInstance().removeFromEnergyConsumer(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to remove from Set EnergyConsumer", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected EnergyConsumer energyConsumer = null;
  private static final Logger LOGGER =
      Logger.getLogger(EnergyConsumerCommandRestController.class.getName());
}
