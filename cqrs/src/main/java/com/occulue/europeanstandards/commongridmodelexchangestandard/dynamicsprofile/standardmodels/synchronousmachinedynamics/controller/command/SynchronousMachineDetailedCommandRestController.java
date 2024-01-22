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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.synchronousmachinedynamics.controller.command;

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
 * Implements Spring Controller command CQRS processing for entity SynchronousMachineDetailed.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/SynchronousMachineDetailed")
public class SynchronousMachineDetailedCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a SynchronousMachineDetailed. if not key provided, calls create, otherwise calls
   * save
   *
   * @param SynchronousMachineDetailed synchronousMachineDetailed
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateSynchronousMachineDetailedCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          SynchronousMachineDetailedBusinessDelegate.getSynchronousMachineDetailedInstance()
              .createSynchronousMachineDetailed(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a SynchronousMachineDetailed. if no key provided, calls create, otherwise
   * calls save
   *
   * @param SynchronousMachineDetailed synchronousMachineDetailed
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateSynchronousMachineDetailedCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateSynchronousMachineDetailedCommand
      // -----------------------------------------------
      completableFuture =
          SynchronousMachineDetailedBusinessDelegate.getSynchronousMachineDetailedInstance()
              .updateSynchronousMachineDetailed(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "SynchronousMachineDetailedController:update() - successfully update SynchronousMachineDetailed - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a SynchronousMachineDetailed entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(
      @RequestParam(required = true) UUID synchronousMachineDetailedId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteSynchronousMachineDetailedCommand command =
        new DeleteSynchronousMachineDetailedCommand(synchronousMachineDetailedId);

    try {
      SynchronousMachineDetailedBusinessDelegate delegate =
          SynchronousMachineDetailedBusinessDelegate.getSynchronousMachineDetailedInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted SynchronousMachineDetailed with key "
              + command.getSynchronousMachineDetailedId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save EfdBaseRatio on SynchronousMachineDetailed
   *
   * @param command AssignEfdBaseRatioToSynchronousMachineDetailedCommand
   */
  @PutMapping("/assignEfdBaseRatio")
  public void assignEfdBaseRatio(
      @RequestBody AssignEfdBaseRatioToSynchronousMachineDetailedCommand command) {
    try {
      SynchronousMachineDetailedBusinessDelegate.getSynchronousMachineDetailedInstance()
          .assignEfdBaseRatio(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign EfdBaseRatio", exc);
    }
  }

  /**
   * unassign EfdBaseRatio on SynchronousMachineDetailed
   *
   * @param command UnAssignEfdBaseRatioFromSynchronousMachineDetailedCommand
   */
  @PutMapping("/unAssignEfdBaseRatio")
  public void unAssignEfdBaseRatio(
      @RequestBody(required = true)
          UnAssignEfdBaseRatioFromSynchronousMachineDetailedCommand command) {
    try {
      SynchronousMachineDetailedBusinessDelegate.getSynchronousMachineDetailedInstance()
          .unAssignEfdBaseRatio(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign EfdBaseRatio", exc);
    }
  }

  /**
   * save IfdBaseValue on SynchronousMachineDetailed
   *
   * @param command AssignIfdBaseValueToSynchronousMachineDetailedCommand
   */
  @PutMapping("/assignIfdBaseValue")
  public void assignIfdBaseValue(
      @RequestBody AssignIfdBaseValueToSynchronousMachineDetailedCommand command) {
    try {
      SynchronousMachineDetailedBusinessDelegate.getSynchronousMachineDetailedInstance()
          .assignIfdBaseValue(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign IfdBaseValue", exc);
    }
  }

  /**
   * unassign IfdBaseValue on SynchronousMachineDetailed
   *
   * @param command UnAssignIfdBaseValueFromSynchronousMachineDetailedCommand
   */
  @PutMapping("/unAssignIfdBaseValue")
  public void unAssignIfdBaseValue(
      @RequestBody(required = true)
          UnAssignIfdBaseValueFromSynchronousMachineDetailedCommand command) {
    try {
      SynchronousMachineDetailedBusinessDelegate.getSynchronousMachineDetailedInstance()
          .unAssignIfdBaseValue(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign IfdBaseValue", exc);
    }
  }

  /**
   * save SaturationFactor120QAxis on SynchronousMachineDetailed
   *
   * @param command AssignSaturationFactor120QAxisToSynchronousMachineDetailedCommand
   */
  @PutMapping("/assignSaturationFactor120QAxis")
  public void assignSaturationFactor120QAxis(
      @RequestBody AssignSaturationFactor120QAxisToSynchronousMachineDetailedCommand command) {
    try {
      SynchronousMachineDetailedBusinessDelegate.getSynchronousMachineDetailedInstance()
          .assignSaturationFactor120QAxis(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign SaturationFactor120QAxis", exc);
    }
  }

  /**
   * unassign SaturationFactor120QAxis on SynchronousMachineDetailed
   *
   * @param command UnAssignSaturationFactor120QAxisFromSynchronousMachineDetailedCommand
   */
  @PutMapping("/unAssignSaturationFactor120QAxis")
  public void unAssignSaturationFactor120QAxis(
      @RequestBody(required = true)
          UnAssignSaturationFactor120QAxisFromSynchronousMachineDetailedCommand command) {
    try {
      SynchronousMachineDetailedBusinessDelegate.getSynchronousMachineDetailedInstance()
          .unAssignSaturationFactor120QAxis(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign SaturationFactor120QAxis", exc);
    }
  }

  /**
   * save SaturationFactorQAxis on SynchronousMachineDetailed
   *
   * @param command AssignSaturationFactorQAxisToSynchronousMachineDetailedCommand
   */
  @PutMapping("/assignSaturationFactorQAxis")
  public void assignSaturationFactorQAxis(
      @RequestBody AssignSaturationFactorQAxisToSynchronousMachineDetailedCommand command) {
    try {
      SynchronousMachineDetailedBusinessDelegate.getSynchronousMachineDetailedInstance()
          .assignSaturationFactorQAxis(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign SaturationFactorQAxis", exc);
    }
  }

  /**
   * unassign SaturationFactorQAxis on SynchronousMachineDetailed
   *
   * @param command UnAssignSaturationFactorQAxisFromSynchronousMachineDetailedCommand
   */
  @PutMapping("/unAssignSaturationFactorQAxis")
  public void unAssignSaturationFactorQAxis(
      @RequestBody(required = true)
          UnAssignSaturationFactorQAxisFromSynchronousMachineDetailedCommand command) {
    try {
      SynchronousMachineDetailedBusinessDelegate.getSynchronousMachineDetailedInstance()
          .unAssignSaturationFactorQAxis(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign SaturationFactorQAxis", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected SynchronousMachineDetailed synchronousMachineDetailed = null;
  private static final Logger LOGGER =
      Logger.getLogger(SynchronousMachineDetailedCommandRestController.class.getName());
}
