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
 * Implements Spring Controller command CQRS processing for entity SeriesCompensator.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/SeriesCompensator")
public class SeriesCompensatorCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a SeriesCompensator. if not key provided, calls create, otherwise calls save
   *
   * @param SeriesCompensator seriesCompensator
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateSeriesCompensatorCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          SeriesCompensatorBusinessDelegate.getSeriesCompensatorInstance()
              .createSeriesCompensator(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a SeriesCompensator. if no key provided, calls create, otherwise calls save
   *
   * @param SeriesCompensator seriesCompensator
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateSeriesCompensatorCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateSeriesCompensatorCommand
      // -----------------------------------------------
      completableFuture =
          SeriesCompensatorBusinessDelegate.getSeriesCompensatorInstance()
              .updateSeriesCompensator(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "SeriesCompensatorController:update() - successfully update SeriesCompensator - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a SeriesCompensator entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID seriesCompensatorId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteSeriesCompensatorCommand command =
        new DeleteSeriesCompensatorCommand(seriesCompensatorId);

    try {
      SeriesCompensatorBusinessDelegate delegate =
          SeriesCompensatorBusinessDelegate.getSeriesCompensatorInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted SeriesCompensator with key " + command.getSeriesCompensatorId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save R on SeriesCompensator
   *
   * @param command AssignRToSeriesCompensatorCommand
   */
  @PutMapping("/assignR")
  public void assignR(@RequestBody AssignRToSeriesCompensatorCommand command) {
    try {
      SeriesCompensatorBusinessDelegate.getSeriesCompensatorInstance().assignR(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign R", exc);
    }
  }

  /**
   * unassign R on SeriesCompensator
   *
   * @param command UnAssignRFromSeriesCompensatorCommand
   */
  @PutMapping("/unAssignR")
  public void unAssignR(
      @RequestBody(required = true) UnAssignRFromSeriesCompensatorCommand command) {
    try {
      SeriesCompensatorBusinessDelegate.getSeriesCompensatorInstance().unAssignR(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign R", exc);
    }
  }

  /**
   * save R0 on SeriesCompensator
   *
   * @param command AssignR0ToSeriesCompensatorCommand
   */
  @PutMapping("/assignR0")
  public void assignR0(@RequestBody AssignR0ToSeriesCompensatorCommand command) {
    try {
      SeriesCompensatorBusinessDelegate.getSeriesCompensatorInstance().assignR0(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign R0", exc);
    }
  }

  /**
   * unassign R0 on SeriesCompensator
   *
   * @param command UnAssignR0FromSeriesCompensatorCommand
   */
  @PutMapping("/unAssignR0")
  public void unAssignR0(
      @RequestBody(required = true) UnAssignR0FromSeriesCompensatorCommand command) {
    try {
      SeriesCompensatorBusinessDelegate.getSeriesCompensatorInstance().unAssignR0(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign R0", exc);
    }
  }

  /**
   * save VaristorPresent on SeriesCompensator
   *
   * @param command AssignVaristorPresentToSeriesCompensatorCommand
   */
  @PutMapping("/assignVaristorPresent")
  public void assignVaristorPresent(
      @RequestBody AssignVaristorPresentToSeriesCompensatorCommand command) {
    try {
      SeriesCompensatorBusinessDelegate.getSeriesCompensatorInstance()
          .assignVaristorPresent(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign VaristorPresent", exc);
    }
  }

  /**
   * unassign VaristorPresent on SeriesCompensator
   *
   * @param command UnAssignVaristorPresentFromSeriesCompensatorCommand
   */
  @PutMapping("/unAssignVaristorPresent")
  public void unAssignVaristorPresent(
      @RequestBody(required = true) UnAssignVaristorPresentFromSeriesCompensatorCommand command) {
    try {
      SeriesCompensatorBusinessDelegate.getSeriesCompensatorInstance()
          .unAssignVaristorPresent(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign VaristorPresent", exc);
    }
  }

  /**
   * save VaristorRatedCurrent on SeriesCompensator
   *
   * @param command AssignVaristorRatedCurrentToSeriesCompensatorCommand
   */
  @PutMapping("/assignVaristorRatedCurrent")
  public void assignVaristorRatedCurrent(
      @RequestBody AssignVaristorRatedCurrentToSeriesCompensatorCommand command) {
    try {
      SeriesCompensatorBusinessDelegate.getSeriesCompensatorInstance()
          .assignVaristorRatedCurrent(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign VaristorRatedCurrent", exc);
    }
  }

  /**
   * unassign VaristorRatedCurrent on SeriesCompensator
   *
   * @param command UnAssignVaristorRatedCurrentFromSeriesCompensatorCommand
   */
  @PutMapping("/unAssignVaristorRatedCurrent")
  public void unAssignVaristorRatedCurrent(
      @RequestBody(required = true)
          UnAssignVaristorRatedCurrentFromSeriesCompensatorCommand command) {
    try {
      SeriesCompensatorBusinessDelegate.getSeriesCompensatorInstance()
          .unAssignVaristorRatedCurrent(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign VaristorRatedCurrent", exc);
    }
  }

  /**
   * save VaristorVoltageThreshold on SeriesCompensator
   *
   * @param command AssignVaristorVoltageThresholdToSeriesCompensatorCommand
   */
  @PutMapping("/assignVaristorVoltageThreshold")
  public void assignVaristorVoltageThreshold(
      @RequestBody AssignVaristorVoltageThresholdToSeriesCompensatorCommand command) {
    try {
      SeriesCompensatorBusinessDelegate.getSeriesCompensatorInstance()
          .assignVaristorVoltageThreshold(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign VaristorVoltageThreshold", exc);
    }
  }

  /**
   * unassign VaristorVoltageThreshold on SeriesCompensator
   *
   * @param command UnAssignVaristorVoltageThresholdFromSeriesCompensatorCommand
   */
  @PutMapping("/unAssignVaristorVoltageThreshold")
  public void unAssignVaristorVoltageThreshold(
      @RequestBody(required = true)
          UnAssignVaristorVoltageThresholdFromSeriesCompensatorCommand command) {
    try {
      SeriesCompensatorBusinessDelegate.getSeriesCompensatorInstance()
          .unAssignVaristorVoltageThreshold(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign VaristorVoltageThreshold", exc);
    }
  }

  /**
   * save X on SeriesCompensator
   *
   * @param command AssignXToSeriesCompensatorCommand
   */
  @PutMapping("/assignX")
  public void assignX(@RequestBody AssignXToSeriesCompensatorCommand command) {
    try {
      SeriesCompensatorBusinessDelegate.getSeriesCompensatorInstance().assignX(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign X", exc);
    }
  }

  /**
   * unassign X on SeriesCompensator
   *
   * @param command UnAssignXFromSeriesCompensatorCommand
   */
  @PutMapping("/unAssignX")
  public void unAssignX(
      @RequestBody(required = true) UnAssignXFromSeriesCompensatorCommand command) {
    try {
      SeriesCompensatorBusinessDelegate.getSeriesCompensatorInstance().unAssignX(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign X", exc);
    }
  }

  /**
   * save X0 on SeriesCompensator
   *
   * @param command AssignX0ToSeriesCompensatorCommand
   */
  @PutMapping("/assignX0")
  public void assignX0(@RequestBody AssignX0ToSeriesCompensatorCommand command) {
    try {
      SeriesCompensatorBusinessDelegate.getSeriesCompensatorInstance().assignX0(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign X0", exc);
    }
  }

  /**
   * unassign X0 on SeriesCompensator
   *
   * @param command UnAssignX0FromSeriesCompensatorCommand
   */
  @PutMapping("/unAssignX0")
  public void unAssignX0(
      @RequestBody(required = true) UnAssignX0FromSeriesCompensatorCommand command) {
    try {
      SeriesCompensatorBusinessDelegate.getSeriesCompensatorInstance().unAssignX0(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign X0", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected SeriesCompensator seriesCompensator = null;
  private static final Logger LOGGER =
      Logger.getLogger(SeriesCompensatorCommandRestController.class.getName());
}
