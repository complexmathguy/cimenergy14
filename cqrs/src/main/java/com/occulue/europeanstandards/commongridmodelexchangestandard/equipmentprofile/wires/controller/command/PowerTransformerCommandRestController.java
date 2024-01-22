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
 * Implements Spring Controller command CQRS processing for entity PowerTransformer.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/PowerTransformer")
public class PowerTransformerCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a PowerTransformer. if not key provided, calls create, otherwise calls save
   *
   * @param PowerTransformer powerTransformer
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreatePowerTransformerCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          PowerTransformerBusinessDelegate.getPowerTransformerInstance()
              .createPowerTransformer(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a PowerTransformer. if no key provided, calls create, otherwise calls save
   *
   * @param PowerTransformer powerTransformer
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdatePowerTransformerCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdatePowerTransformerCommand
      // -----------------------------------------------
      completableFuture =
          PowerTransformerBusinessDelegate.getPowerTransformerInstance()
              .updatePowerTransformer(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "PowerTransformerController:update() - successfully update PowerTransformer - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a PowerTransformer entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID powerTransformerId) {
    CompletableFuture<Void> completableFuture = null;
    DeletePowerTransformerCommand command = new DeletePowerTransformerCommand(powerTransformerId);

    try {
      PowerTransformerBusinessDelegate delegate =
          PowerTransformerBusinessDelegate.getPowerTransformerInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted PowerTransformer with key " + command.getPowerTransformerId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save BeforeShCircuitHighestOperatingCurrent on PowerTransformer
   *
   * @param command AssignBeforeShCircuitHighestOperatingCurrentToPowerTransformerCommand
   */
  @PutMapping("/assignBeforeShCircuitHighestOperatingCurrent")
  public void assignBeforeShCircuitHighestOperatingCurrent(
      @RequestBody AssignBeforeShCircuitHighestOperatingCurrentToPowerTransformerCommand command) {
    try {
      PowerTransformerBusinessDelegate.getPowerTransformerInstance()
          .assignBeforeShCircuitHighestOperatingCurrent(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign BeforeShCircuitHighestOperatingCurrent", exc);
    }
  }

  /**
   * unassign BeforeShCircuitHighestOperatingCurrent on PowerTransformer
   *
   * @param command UnAssignBeforeShCircuitHighestOperatingCurrentFromPowerTransformerCommand
   */
  @PutMapping("/unAssignBeforeShCircuitHighestOperatingCurrent")
  public void unAssignBeforeShCircuitHighestOperatingCurrent(
      @RequestBody(required = true)
          UnAssignBeforeShCircuitHighestOperatingCurrentFromPowerTransformerCommand command) {
    try {
      PowerTransformerBusinessDelegate.getPowerTransformerInstance()
          .unAssignBeforeShCircuitHighestOperatingCurrent(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign BeforeShCircuitHighestOperatingCurrent", exc);
    }
  }

  /**
   * save BeforeShCircuitHighestOperatingVoltage on PowerTransformer
   *
   * @param command AssignBeforeShCircuitHighestOperatingVoltageToPowerTransformerCommand
   */
  @PutMapping("/assignBeforeShCircuitHighestOperatingVoltage")
  public void assignBeforeShCircuitHighestOperatingVoltage(
      @RequestBody AssignBeforeShCircuitHighestOperatingVoltageToPowerTransformerCommand command) {
    try {
      PowerTransformerBusinessDelegate.getPowerTransformerInstance()
          .assignBeforeShCircuitHighestOperatingVoltage(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign BeforeShCircuitHighestOperatingVoltage", exc);
    }
  }

  /**
   * unassign BeforeShCircuitHighestOperatingVoltage on PowerTransformer
   *
   * @param command UnAssignBeforeShCircuitHighestOperatingVoltageFromPowerTransformerCommand
   */
  @PutMapping("/unAssignBeforeShCircuitHighestOperatingVoltage")
  public void unAssignBeforeShCircuitHighestOperatingVoltage(
      @RequestBody(required = true)
          UnAssignBeforeShCircuitHighestOperatingVoltageFromPowerTransformerCommand command) {
    try {
      PowerTransformerBusinessDelegate.getPowerTransformerInstance()
          .unAssignBeforeShCircuitHighestOperatingVoltage(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign BeforeShCircuitHighestOperatingVoltage", exc);
    }
  }

  /**
   * save BeforeShortCircuitAnglePf on PowerTransformer
   *
   * @param command AssignBeforeShortCircuitAnglePfToPowerTransformerCommand
   */
  @PutMapping("/assignBeforeShortCircuitAnglePf")
  public void assignBeforeShortCircuitAnglePf(
      @RequestBody AssignBeforeShortCircuitAnglePfToPowerTransformerCommand command) {
    try {
      PowerTransformerBusinessDelegate.getPowerTransformerInstance()
          .assignBeforeShortCircuitAnglePf(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign BeforeShortCircuitAnglePf", exc);
    }
  }

  /**
   * unassign BeforeShortCircuitAnglePf on PowerTransformer
   *
   * @param command UnAssignBeforeShortCircuitAnglePfFromPowerTransformerCommand
   */
  @PutMapping("/unAssignBeforeShortCircuitAnglePf")
  public void unAssignBeforeShortCircuitAnglePf(
      @RequestBody(required = true)
          UnAssignBeforeShortCircuitAnglePfFromPowerTransformerCommand command) {
    try {
      PowerTransformerBusinessDelegate.getPowerTransformerInstance()
          .unAssignBeforeShortCircuitAnglePf(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign BeforeShortCircuitAnglePf", exc);
    }
  }

  /**
   * save HighSideMinOperatingU on PowerTransformer
   *
   * @param command AssignHighSideMinOperatingUToPowerTransformerCommand
   */
  @PutMapping("/assignHighSideMinOperatingU")
  public void assignHighSideMinOperatingU(
      @RequestBody AssignHighSideMinOperatingUToPowerTransformerCommand command) {
    try {
      PowerTransformerBusinessDelegate.getPowerTransformerInstance()
          .assignHighSideMinOperatingU(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign HighSideMinOperatingU", exc);
    }
  }

  /**
   * unassign HighSideMinOperatingU on PowerTransformer
   *
   * @param command UnAssignHighSideMinOperatingUFromPowerTransformerCommand
   */
  @PutMapping("/unAssignHighSideMinOperatingU")
  public void unAssignHighSideMinOperatingU(
      @RequestBody(required = true)
          UnAssignHighSideMinOperatingUFromPowerTransformerCommand command) {
    try {
      PowerTransformerBusinessDelegate.getPowerTransformerInstance()
          .unAssignHighSideMinOperatingU(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign HighSideMinOperatingU", exc);
    }
  }

  /**
   * save PartOfGeneratorUnitFlag on PowerTransformer
   *
   * @param command AssignPartOfGeneratorUnitFlagToPowerTransformerCommand
   */
  @PutMapping("/assignPartOfGeneratorUnitFlag")
  public void assignPartOfGeneratorUnitFlag(
      @RequestBody AssignPartOfGeneratorUnitFlagToPowerTransformerCommand command) {
    try {
      PowerTransformerBusinessDelegate.getPowerTransformerInstance()
          .assignPartOfGeneratorUnitFlag(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign PartOfGeneratorUnitFlag", exc);
    }
  }

  /**
   * unassign PartOfGeneratorUnitFlag on PowerTransformer
   *
   * @param command UnAssignPartOfGeneratorUnitFlagFromPowerTransformerCommand
   */
  @PutMapping("/unAssignPartOfGeneratorUnitFlag")
  public void unAssignPartOfGeneratorUnitFlag(
      @RequestBody(required = true)
          UnAssignPartOfGeneratorUnitFlagFromPowerTransformerCommand command) {
    try {
      PowerTransformerBusinessDelegate.getPowerTransformerInstance()
          .unAssignPartOfGeneratorUnitFlag(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign PartOfGeneratorUnitFlag", exc);
    }
  }

  /**
   * save OperationalValuesConsidered on PowerTransformer
   *
   * @param command AssignOperationalValuesConsideredToPowerTransformerCommand
   */
  @PutMapping("/assignOperationalValuesConsidered")
  public void assignOperationalValuesConsidered(
      @RequestBody AssignOperationalValuesConsideredToPowerTransformerCommand command) {
    try {
      PowerTransformerBusinessDelegate.getPowerTransformerInstance()
          .assignOperationalValuesConsidered(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign OperationalValuesConsidered", exc);
    }
  }

  /**
   * unassign OperationalValuesConsidered on PowerTransformer
   *
   * @param command UnAssignOperationalValuesConsideredFromPowerTransformerCommand
   */
  @PutMapping("/unAssignOperationalValuesConsidered")
  public void unAssignOperationalValuesConsidered(
      @RequestBody(required = true)
          UnAssignOperationalValuesConsideredFromPowerTransformerCommand command) {
    try {
      PowerTransformerBusinessDelegate.getPowerTransformerInstance()
          .unAssignOperationalValuesConsidered(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign OperationalValuesConsidered", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected PowerTransformer powerTransformer = null;
  private static final Logger LOGGER =
      Logger.getLogger(PowerTransformerCommandRestController.class.getName());
}
