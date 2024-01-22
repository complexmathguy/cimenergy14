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
 * Implements Spring Controller command CQRS processing for entity AsynchronousMachine.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/AsynchronousMachine")
public class AsynchronousMachineCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a AsynchronousMachine. if not key provided, calls create, otherwise calls save
   *
   * @param AsynchronousMachine asynchronousMachine
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateAsynchronousMachineCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          AsynchronousMachineBusinessDelegate.getAsynchronousMachineInstance()
              .createAsynchronousMachine(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a AsynchronousMachine. if no key provided, calls create, otherwise calls save
   *
   * @param AsynchronousMachine asynchronousMachine
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateAsynchronousMachineCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateAsynchronousMachineCommand
      // -----------------------------------------------
      completableFuture =
          AsynchronousMachineBusinessDelegate.getAsynchronousMachineInstance()
              .updateAsynchronousMachine(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "AsynchronousMachineController:update() - successfully update AsynchronousMachine - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a AsynchronousMachine entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID asynchronousMachineId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteAsynchronousMachineCommand command =
        new DeleteAsynchronousMachineCommand(asynchronousMachineId);

    try {
      AsynchronousMachineBusinessDelegate delegate =
          AsynchronousMachineBusinessDelegate.getAsynchronousMachineInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted AsynchronousMachine with key "
              + command.getAsynchronousMachineId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save ConverterFedDrive on AsynchronousMachine
   *
   * @param command AssignConverterFedDriveToAsynchronousMachineCommand
   */
  @PutMapping("/assignConverterFedDrive")
  public void assignConverterFedDrive(
      @RequestBody AssignConverterFedDriveToAsynchronousMachineCommand command) {
    try {
      AsynchronousMachineBusinessDelegate.getAsynchronousMachineInstance()
          .assignConverterFedDrive(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign ConverterFedDrive", exc);
    }
  }

  /**
   * unassign ConverterFedDrive on AsynchronousMachine
   *
   * @param command UnAssignConverterFedDriveFromAsynchronousMachineCommand
   */
  @PutMapping("/unAssignConverterFedDrive")
  public void unAssignConverterFedDrive(
      @RequestBody(required = true)
          UnAssignConverterFedDriveFromAsynchronousMachineCommand command) {
    try {
      AsynchronousMachineBusinessDelegate.getAsynchronousMachineInstance()
          .unAssignConverterFedDrive(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign ConverterFedDrive", exc);
    }
  }

  /**
   * save Efficiency on AsynchronousMachine
   *
   * @param command AssignEfficiencyToAsynchronousMachineCommand
   */
  @PutMapping("/assignEfficiency")
  public void assignEfficiency(@RequestBody AssignEfficiencyToAsynchronousMachineCommand command) {
    try {
      AsynchronousMachineBusinessDelegate.getAsynchronousMachineInstance()
          .assignEfficiency(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Efficiency", exc);
    }
  }

  /**
   * unassign Efficiency on AsynchronousMachine
   *
   * @param command UnAssignEfficiencyFromAsynchronousMachineCommand
   */
  @PutMapping("/unAssignEfficiency")
  public void unAssignEfficiency(
      @RequestBody(required = true) UnAssignEfficiencyFromAsynchronousMachineCommand command) {
    try {
      AsynchronousMachineBusinessDelegate.getAsynchronousMachineInstance()
          .unAssignEfficiency(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Efficiency", exc);
    }
  }

  /**
   * save IaIrRatio on AsynchronousMachine
   *
   * @param command AssignIaIrRatioToAsynchronousMachineCommand
   */
  @PutMapping("/assignIaIrRatio")
  public void assignIaIrRatio(@RequestBody AssignIaIrRatioToAsynchronousMachineCommand command) {
    try {
      AsynchronousMachineBusinessDelegate.getAsynchronousMachineInstance().assignIaIrRatio(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign IaIrRatio", exc);
    }
  }

  /**
   * unassign IaIrRatio on AsynchronousMachine
   *
   * @param command UnAssignIaIrRatioFromAsynchronousMachineCommand
   */
  @PutMapping("/unAssignIaIrRatio")
  public void unAssignIaIrRatio(
      @RequestBody(required = true) UnAssignIaIrRatioFromAsynchronousMachineCommand command) {
    try {
      AsynchronousMachineBusinessDelegate.getAsynchronousMachineInstance()
          .unAssignIaIrRatio(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign IaIrRatio", exc);
    }
  }

  /**
   * save NominalFrequency on AsynchronousMachine
   *
   * @param command AssignNominalFrequencyToAsynchronousMachineCommand
   */
  @PutMapping("/assignNominalFrequency")
  public void assignNominalFrequency(
      @RequestBody AssignNominalFrequencyToAsynchronousMachineCommand command) {
    try {
      AsynchronousMachineBusinessDelegate.getAsynchronousMachineInstance()
          .assignNominalFrequency(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign NominalFrequency", exc);
    }
  }

  /**
   * unassign NominalFrequency on AsynchronousMachine
   *
   * @param command UnAssignNominalFrequencyFromAsynchronousMachineCommand
   */
  @PutMapping("/unAssignNominalFrequency")
  public void unAssignNominalFrequency(
      @RequestBody(required = true)
          UnAssignNominalFrequencyFromAsynchronousMachineCommand command) {
    try {
      AsynchronousMachineBusinessDelegate.getAsynchronousMachineInstance()
          .unAssignNominalFrequency(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign NominalFrequency", exc);
    }
  }

  /**
   * save NominalSpeed on AsynchronousMachine
   *
   * @param command AssignNominalSpeedToAsynchronousMachineCommand
   */
  @PutMapping("/assignNominalSpeed")
  public void assignNominalSpeed(
      @RequestBody AssignNominalSpeedToAsynchronousMachineCommand command) {
    try {
      AsynchronousMachineBusinessDelegate.getAsynchronousMachineInstance()
          .assignNominalSpeed(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign NominalSpeed", exc);
    }
  }

  /**
   * unassign NominalSpeed on AsynchronousMachine
   *
   * @param command UnAssignNominalSpeedFromAsynchronousMachineCommand
   */
  @PutMapping("/unAssignNominalSpeed")
  public void unAssignNominalSpeed(
      @RequestBody(required = true) UnAssignNominalSpeedFromAsynchronousMachineCommand command) {
    try {
      AsynchronousMachineBusinessDelegate.getAsynchronousMachineInstance()
          .unAssignNominalSpeed(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign NominalSpeed", exc);
    }
  }

  /**
   * save PolePairNumber on AsynchronousMachine
   *
   * @param command AssignPolePairNumberToAsynchronousMachineCommand
   */
  @PutMapping("/assignPolePairNumber")
  public void assignPolePairNumber(
      @RequestBody AssignPolePairNumberToAsynchronousMachineCommand command) {
    try {
      AsynchronousMachineBusinessDelegate.getAsynchronousMachineInstance()
          .assignPolePairNumber(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign PolePairNumber", exc);
    }
  }

  /**
   * unassign PolePairNumber on AsynchronousMachine
   *
   * @param command UnAssignPolePairNumberFromAsynchronousMachineCommand
   */
  @PutMapping("/unAssignPolePairNumber")
  public void unAssignPolePairNumber(
      @RequestBody(required = true) UnAssignPolePairNumberFromAsynchronousMachineCommand command) {
    try {
      AsynchronousMachineBusinessDelegate.getAsynchronousMachineInstance()
          .unAssignPolePairNumber(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign PolePairNumber", exc);
    }
  }

  /**
   * save RatedMechanicalPower on AsynchronousMachine
   *
   * @param command AssignRatedMechanicalPowerToAsynchronousMachineCommand
   */
  @PutMapping("/assignRatedMechanicalPower")
  public void assignRatedMechanicalPower(
      @RequestBody AssignRatedMechanicalPowerToAsynchronousMachineCommand command) {
    try {
      AsynchronousMachineBusinessDelegate.getAsynchronousMachineInstance()
          .assignRatedMechanicalPower(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign RatedMechanicalPower", exc);
    }
  }

  /**
   * unassign RatedMechanicalPower on AsynchronousMachine
   *
   * @param command UnAssignRatedMechanicalPowerFromAsynchronousMachineCommand
   */
  @PutMapping("/unAssignRatedMechanicalPower")
  public void unAssignRatedMechanicalPower(
      @RequestBody(required = true)
          UnAssignRatedMechanicalPowerFromAsynchronousMachineCommand command) {
    try {
      AsynchronousMachineBusinessDelegate.getAsynchronousMachineInstance()
          .unAssignRatedMechanicalPower(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign RatedMechanicalPower", exc);
    }
  }

  /**
   * save Reversible on AsynchronousMachine
   *
   * @param command AssignReversibleToAsynchronousMachineCommand
   */
  @PutMapping("/assignReversible")
  public void assignReversible(@RequestBody AssignReversibleToAsynchronousMachineCommand command) {
    try {
      AsynchronousMachineBusinessDelegate.getAsynchronousMachineInstance()
          .assignReversible(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Reversible", exc);
    }
  }

  /**
   * unassign Reversible on AsynchronousMachine
   *
   * @param command UnAssignReversibleFromAsynchronousMachineCommand
   */
  @PutMapping("/unAssignReversible")
  public void unAssignReversible(
      @RequestBody(required = true) UnAssignReversibleFromAsynchronousMachineCommand command) {
    try {
      AsynchronousMachineBusinessDelegate.getAsynchronousMachineInstance()
          .unAssignReversible(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Reversible", exc);
    }
  }

  /**
   * save RxLockedRotorRatio on AsynchronousMachine
   *
   * @param command AssignRxLockedRotorRatioToAsynchronousMachineCommand
   */
  @PutMapping("/assignRxLockedRotorRatio")
  public void assignRxLockedRotorRatio(
      @RequestBody AssignRxLockedRotorRatioToAsynchronousMachineCommand command) {
    try {
      AsynchronousMachineBusinessDelegate.getAsynchronousMachineInstance()
          .assignRxLockedRotorRatio(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign RxLockedRotorRatio", exc);
    }
  }

  /**
   * unassign RxLockedRotorRatio on AsynchronousMachine
   *
   * @param command UnAssignRxLockedRotorRatioFromAsynchronousMachineCommand
   */
  @PutMapping("/unAssignRxLockedRotorRatio")
  public void unAssignRxLockedRotorRatio(
      @RequestBody(required = true)
          UnAssignRxLockedRotorRatioFromAsynchronousMachineCommand command) {
    try {
      AsynchronousMachineBusinessDelegate.getAsynchronousMachineInstance()
          .unAssignRxLockedRotorRatio(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign RxLockedRotorRatio", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected AsynchronousMachine asynchronousMachine = null;
  private static final Logger LOGGER =
      Logger.getLogger(AsynchronousMachineCommandRestController.class.getName());
}
