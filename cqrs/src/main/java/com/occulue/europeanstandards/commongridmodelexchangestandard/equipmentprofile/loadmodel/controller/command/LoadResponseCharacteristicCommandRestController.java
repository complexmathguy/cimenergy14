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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.loadmodel.controller.command;

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
 * Implements Spring Controller command CQRS processing for entity LoadResponseCharacteristic.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/LoadResponseCharacteristic")
public class LoadResponseCharacteristicCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a LoadResponseCharacteristic. if not key provided, calls create, otherwise calls
   * save
   *
   * @param LoadResponseCharacteristic loadResponseCharacteristic
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateLoadResponseCharacteristicCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          LoadResponseCharacteristicBusinessDelegate.getLoadResponseCharacteristicInstance()
              .createLoadResponseCharacteristic(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a LoadResponseCharacteristic. if no key provided, calls create, otherwise
   * calls save
   *
   * @param LoadResponseCharacteristic loadResponseCharacteristic
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateLoadResponseCharacteristicCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateLoadResponseCharacteristicCommand
      // -----------------------------------------------
      completableFuture =
          LoadResponseCharacteristicBusinessDelegate.getLoadResponseCharacteristicInstance()
              .updateLoadResponseCharacteristic(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "LoadResponseCharacteristicController:update() - successfully update LoadResponseCharacteristic - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a LoadResponseCharacteristic entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(
      @RequestParam(required = true) UUID loadResponseCharacteristicId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteLoadResponseCharacteristicCommand command =
        new DeleteLoadResponseCharacteristicCommand(loadResponseCharacteristicId);

    try {
      LoadResponseCharacteristicBusinessDelegate delegate =
          LoadResponseCharacteristicBusinessDelegate.getLoadResponseCharacteristicInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted LoadResponseCharacteristic with key "
              + command.getLoadResponseCharacteristicId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save ExponentModel on LoadResponseCharacteristic
   *
   * @param command AssignExponentModelToLoadResponseCharacteristicCommand
   */
  @PutMapping("/assignExponentModel")
  public void assignExponentModel(
      @RequestBody AssignExponentModelToLoadResponseCharacteristicCommand command) {
    try {
      LoadResponseCharacteristicBusinessDelegate.getLoadResponseCharacteristicInstance()
          .assignExponentModel(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign ExponentModel", exc);
    }
  }

  /**
   * unassign ExponentModel on LoadResponseCharacteristic
   *
   * @param command UnAssignExponentModelFromLoadResponseCharacteristicCommand
   */
  @PutMapping("/unAssignExponentModel")
  public void unAssignExponentModel(
      @RequestBody(required = true)
          UnAssignExponentModelFromLoadResponseCharacteristicCommand command) {
    try {
      LoadResponseCharacteristicBusinessDelegate.getLoadResponseCharacteristicInstance()
          .unAssignExponentModel(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign ExponentModel", exc);
    }
  }

  /**
   * save PConstantCurrent on LoadResponseCharacteristic
   *
   * @param command AssignPConstantCurrentToLoadResponseCharacteristicCommand
   */
  @PutMapping("/assignPConstantCurrent")
  public void assignPConstantCurrent(
      @RequestBody AssignPConstantCurrentToLoadResponseCharacteristicCommand command) {
    try {
      LoadResponseCharacteristicBusinessDelegate.getLoadResponseCharacteristicInstance()
          .assignPConstantCurrent(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign PConstantCurrent", exc);
    }
  }

  /**
   * unassign PConstantCurrent on LoadResponseCharacteristic
   *
   * @param command UnAssignPConstantCurrentFromLoadResponseCharacteristicCommand
   */
  @PutMapping("/unAssignPConstantCurrent")
  public void unAssignPConstantCurrent(
      @RequestBody(required = true)
          UnAssignPConstantCurrentFromLoadResponseCharacteristicCommand command) {
    try {
      LoadResponseCharacteristicBusinessDelegate.getLoadResponseCharacteristicInstance()
          .unAssignPConstantCurrent(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign PConstantCurrent", exc);
    }
  }

  /**
   * save PConstantImpedance on LoadResponseCharacteristic
   *
   * @param command AssignPConstantImpedanceToLoadResponseCharacteristicCommand
   */
  @PutMapping("/assignPConstantImpedance")
  public void assignPConstantImpedance(
      @RequestBody AssignPConstantImpedanceToLoadResponseCharacteristicCommand command) {
    try {
      LoadResponseCharacteristicBusinessDelegate.getLoadResponseCharacteristicInstance()
          .assignPConstantImpedance(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign PConstantImpedance", exc);
    }
  }

  /**
   * unassign PConstantImpedance on LoadResponseCharacteristic
   *
   * @param command UnAssignPConstantImpedanceFromLoadResponseCharacteristicCommand
   */
  @PutMapping("/unAssignPConstantImpedance")
  public void unAssignPConstantImpedance(
      @RequestBody(required = true)
          UnAssignPConstantImpedanceFromLoadResponseCharacteristicCommand command) {
    try {
      LoadResponseCharacteristicBusinessDelegate.getLoadResponseCharacteristicInstance()
          .unAssignPConstantImpedance(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign PConstantImpedance", exc);
    }
  }

  /**
   * save PConstantPower on LoadResponseCharacteristic
   *
   * @param command AssignPConstantPowerToLoadResponseCharacteristicCommand
   */
  @PutMapping("/assignPConstantPower")
  public void assignPConstantPower(
      @RequestBody AssignPConstantPowerToLoadResponseCharacteristicCommand command) {
    try {
      LoadResponseCharacteristicBusinessDelegate.getLoadResponseCharacteristicInstance()
          .assignPConstantPower(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign PConstantPower", exc);
    }
  }

  /**
   * unassign PConstantPower on LoadResponseCharacteristic
   *
   * @param command UnAssignPConstantPowerFromLoadResponseCharacteristicCommand
   */
  @PutMapping("/unAssignPConstantPower")
  public void unAssignPConstantPower(
      @RequestBody(required = true)
          UnAssignPConstantPowerFromLoadResponseCharacteristicCommand command) {
    try {
      LoadResponseCharacteristicBusinessDelegate.getLoadResponseCharacteristicInstance()
          .unAssignPConstantPower(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign PConstantPower", exc);
    }
  }

  /**
   * save PFrequencyExponent on LoadResponseCharacteristic
   *
   * @param command AssignPFrequencyExponentToLoadResponseCharacteristicCommand
   */
  @PutMapping("/assignPFrequencyExponent")
  public void assignPFrequencyExponent(
      @RequestBody AssignPFrequencyExponentToLoadResponseCharacteristicCommand command) {
    try {
      LoadResponseCharacteristicBusinessDelegate.getLoadResponseCharacteristicInstance()
          .assignPFrequencyExponent(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign PFrequencyExponent", exc);
    }
  }

  /**
   * unassign PFrequencyExponent on LoadResponseCharacteristic
   *
   * @param command UnAssignPFrequencyExponentFromLoadResponseCharacteristicCommand
   */
  @PutMapping("/unAssignPFrequencyExponent")
  public void unAssignPFrequencyExponent(
      @RequestBody(required = true)
          UnAssignPFrequencyExponentFromLoadResponseCharacteristicCommand command) {
    try {
      LoadResponseCharacteristicBusinessDelegate.getLoadResponseCharacteristicInstance()
          .unAssignPFrequencyExponent(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign PFrequencyExponent", exc);
    }
  }

  /**
   * save PVoltageExponent on LoadResponseCharacteristic
   *
   * @param command AssignPVoltageExponentToLoadResponseCharacteristicCommand
   */
  @PutMapping("/assignPVoltageExponent")
  public void assignPVoltageExponent(
      @RequestBody AssignPVoltageExponentToLoadResponseCharacteristicCommand command) {
    try {
      LoadResponseCharacteristicBusinessDelegate.getLoadResponseCharacteristicInstance()
          .assignPVoltageExponent(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign PVoltageExponent", exc);
    }
  }

  /**
   * unassign PVoltageExponent on LoadResponseCharacteristic
   *
   * @param command UnAssignPVoltageExponentFromLoadResponseCharacteristicCommand
   */
  @PutMapping("/unAssignPVoltageExponent")
  public void unAssignPVoltageExponent(
      @RequestBody(required = true)
          UnAssignPVoltageExponentFromLoadResponseCharacteristicCommand command) {
    try {
      LoadResponseCharacteristicBusinessDelegate.getLoadResponseCharacteristicInstance()
          .unAssignPVoltageExponent(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign PVoltageExponent", exc);
    }
  }

  /**
   * save QConstantCurrent on LoadResponseCharacteristic
   *
   * @param command AssignQConstantCurrentToLoadResponseCharacteristicCommand
   */
  @PutMapping("/assignQConstantCurrent")
  public void assignQConstantCurrent(
      @RequestBody AssignQConstantCurrentToLoadResponseCharacteristicCommand command) {
    try {
      LoadResponseCharacteristicBusinessDelegate.getLoadResponseCharacteristicInstance()
          .assignQConstantCurrent(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign QConstantCurrent", exc);
    }
  }

  /**
   * unassign QConstantCurrent on LoadResponseCharacteristic
   *
   * @param command UnAssignQConstantCurrentFromLoadResponseCharacteristicCommand
   */
  @PutMapping("/unAssignQConstantCurrent")
  public void unAssignQConstantCurrent(
      @RequestBody(required = true)
          UnAssignQConstantCurrentFromLoadResponseCharacteristicCommand command) {
    try {
      LoadResponseCharacteristicBusinessDelegate.getLoadResponseCharacteristicInstance()
          .unAssignQConstantCurrent(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign QConstantCurrent", exc);
    }
  }

  /**
   * save QConstantImpedance on LoadResponseCharacteristic
   *
   * @param command AssignQConstantImpedanceToLoadResponseCharacteristicCommand
   */
  @PutMapping("/assignQConstantImpedance")
  public void assignQConstantImpedance(
      @RequestBody AssignQConstantImpedanceToLoadResponseCharacteristicCommand command) {
    try {
      LoadResponseCharacteristicBusinessDelegate.getLoadResponseCharacteristicInstance()
          .assignQConstantImpedance(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign QConstantImpedance", exc);
    }
  }

  /**
   * unassign QConstantImpedance on LoadResponseCharacteristic
   *
   * @param command UnAssignQConstantImpedanceFromLoadResponseCharacteristicCommand
   */
  @PutMapping("/unAssignQConstantImpedance")
  public void unAssignQConstantImpedance(
      @RequestBody(required = true)
          UnAssignQConstantImpedanceFromLoadResponseCharacteristicCommand command) {
    try {
      LoadResponseCharacteristicBusinessDelegate.getLoadResponseCharacteristicInstance()
          .unAssignQConstantImpedance(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign QConstantImpedance", exc);
    }
  }

  /**
   * save QConstantPower on LoadResponseCharacteristic
   *
   * @param command AssignQConstantPowerToLoadResponseCharacteristicCommand
   */
  @PutMapping("/assignQConstantPower")
  public void assignQConstantPower(
      @RequestBody AssignQConstantPowerToLoadResponseCharacteristicCommand command) {
    try {
      LoadResponseCharacteristicBusinessDelegate.getLoadResponseCharacteristicInstance()
          .assignQConstantPower(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign QConstantPower", exc);
    }
  }

  /**
   * unassign QConstantPower on LoadResponseCharacteristic
   *
   * @param command UnAssignQConstantPowerFromLoadResponseCharacteristicCommand
   */
  @PutMapping("/unAssignQConstantPower")
  public void unAssignQConstantPower(
      @RequestBody(required = true)
          UnAssignQConstantPowerFromLoadResponseCharacteristicCommand command) {
    try {
      LoadResponseCharacteristicBusinessDelegate.getLoadResponseCharacteristicInstance()
          .unAssignQConstantPower(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign QConstantPower", exc);
    }
  }

  /**
   * save QFrequencyExponent on LoadResponseCharacteristic
   *
   * @param command AssignQFrequencyExponentToLoadResponseCharacteristicCommand
   */
  @PutMapping("/assignQFrequencyExponent")
  public void assignQFrequencyExponent(
      @RequestBody AssignQFrequencyExponentToLoadResponseCharacteristicCommand command) {
    try {
      LoadResponseCharacteristicBusinessDelegate.getLoadResponseCharacteristicInstance()
          .assignQFrequencyExponent(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign QFrequencyExponent", exc);
    }
  }

  /**
   * unassign QFrequencyExponent on LoadResponseCharacteristic
   *
   * @param command UnAssignQFrequencyExponentFromLoadResponseCharacteristicCommand
   */
  @PutMapping("/unAssignQFrequencyExponent")
  public void unAssignQFrequencyExponent(
      @RequestBody(required = true)
          UnAssignQFrequencyExponentFromLoadResponseCharacteristicCommand command) {
    try {
      LoadResponseCharacteristicBusinessDelegate.getLoadResponseCharacteristicInstance()
          .unAssignQFrequencyExponent(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign QFrequencyExponent", exc);
    }
  }

  /**
   * save QVoltageExponent on LoadResponseCharacteristic
   *
   * @param command AssignQVoltageExponentToLoadResponseCharacteristicCommand
   */
  @PutMapping("/assignQVoltageExponent")
  public void assignQVoltageExponent(
      @RequestBody AssignQVoltageExponentToLoadResponseCharacteristicCommand command) {
    try {
      LoadResponseCharacteristicBusinessDelegate.getLoadResponseCharacteristicInstance()
          .assignQVoltageExponent(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign QVoltageExponent", exc);
    }
  }

  /**
   * unassign QVoltageExponent on LoadResponseCharacteristic
   *
   * @param command UnAssignQVoltageExponentFromLoadResponseCharacteristicCommand
   */
  @PutMapping("/unAssignQVoltageExponent")
  public void unAssignQVoltageExponent(
      @RequestBody(required = true)
          UnAssignQVoltageExponentFromLoadResponseCharacteristicCommand command) {
    try {
      LoadResponseCharacteristicBusinessDelegate.getLoadResponseCharacteristicInstance()
          .unAssignQVoltageExponent(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign QVoltageExponent", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected LoadResponseCharacteristic loadResponseCharacteristic = null;
  private static final Logger LOGGER =
      Logger.getLogger(LoadResponseCharacteristicCommandRestController.class.getName());
}
