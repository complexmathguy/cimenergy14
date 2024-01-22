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
 * Implements Spring Controller command CQRS processing for entity ACDCConverter.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ACDCConverter")
public class ACDCConverterCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a ACDCConverter. if not key provided, calls create, otherwise calls save
   *
   * @param ACDCConverter aCDCConverter
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateACDCConverterCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          ACDCConverterBusinessDelegate.getACDCConverterInstance().createACDCConverter(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a ACDCConverter. if no key provided, calls create, otherwise calls save
   *
   * @param ACDCConverter aCDCConverter
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateACDCConverterCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateACDCConverterCommand
      // -----------------------------------------------
      completableFuture =
          ACDCConverterBusinessDelegate.getACDCConverterInstance().updateACDCConverter(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "ACDCConverterController:update() - successfully update ACDCConverter - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a ACDCConverter entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID aCDCConverterId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteACDCConverterCommand command = new DeleteACDCConverterCommand(aCDCConverterId);

    try {
      ACDCConverterBusinessDelegate delegate =
          ACDCConverterBusinessDelegate.getACDCConverterInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted ACDCConverter with key " + command.getACDCConverterId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save BaseS on ACDCConverter
   *
   * @param command AssignBaseSToACDCConverterCommand
   */
  @PutMapping("/assignBaseS")
  public void assignBaseS(@RequestBody AssignBaseSToACDCConverterCommand command) {
    try {
      ACDCConverterBusinessDelegate.getACDCConverterInstance().assignBaseS(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign BaseS", exc);
    }
  }

  /**
   * unassign BaseS on ACDCConverter
   *
   * @param command UnAssignBaseSFromACDCConverterCommand
   */
  @PutMapping("/unAssignBaseS")
  public void unAssignBaseS(
      @RequestBody(required = true) UnAssignBaseSFromACDCConverterCommand command) {
    try {
      ACDCConverterBusinessDelegate.getACDCConverterInstance().unAssignBaseS(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign BaseS", exc);
    }
  }

  /**
   * save IdleLoss on ACDCConverter
   *
   * @param command AssignIdleLossToACDCConverterCommand
   */
  @PutMapping("/assignIdleLoss")
  public void assignIdleLoss(@RequestBody AssignIdleLossToACDCConverterCommand command) {
    try {
      ACDCConverterBusinessDelegate.getACDCConverterInstance().assignIdleLoss(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign IdleLoss", exc);
    }
  }

  /**
   * unassign IdleLoss on ACDCConverter
   *
   * @param command UnAssignIdleLossFromACDCConverterCommand
   */
  @PutMapping("/unAssignIdleLoss")
  public void unAssignIdleLoss(
      @RequestBody(required = true) UnAssignIdleLossFromACDCConverterCommand command) {
    try {
      ACDCConverterBusinessDelegate.getACDCConverterInstance().unAssignIdleLoss(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign IdleLoss", exc);
    }
  }

  /**
   * save MaxUdc on ACDCConverter
   *
   * @param command AssignMaxUdcToACDCConverterCommand
   */
  @PutMapping("/assignMaxUdc")
  public void assignMaxUdc(@RequestBody AssignMaxUdcToACDCConverterCommand command) {
    try {
      ACDCConverterBusinessDelegate.getACDCConverterInstance().assignMaxUdc(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign MaxUdc", exc);
    }
  }

  /**
   * unassign MaxUdc on ACDCConverter
   *
   * @param command UnAssignMaxUdcFromACDCConverterCommand
   */
  @PutMapping("/unAssignMaxUdc")
  public void unAssignMaxUdc(
      @RequestBody(required = true) UnAssignMaxUdcFromACDCConverterCommand command) {
    try {
      ACDCConverterBusinessDelegate.getACDCConverterInstance().unAssignMaxUdc(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign MaxUdc", exc);
    }
  }

  /**
   * save MinUdc on ACDCConverter
   *
   * @param command AssignMinUdcToACDCConverterCommand
   */
  @PutMapping("/assignMinUdc")
  public void assignMinUdc(@RequestBody AssignMinUdcToACDCConverterCommand command) {
    try {
      ACDCConverterBusinessDelegate.getACDCConverterInstance().assignMinUdc(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign MinUdc", exc);
    }
  }

  /**
   * unassign MinUdc on ACDCConverter
   *
   * @param command UnAssignMinUdcFromACDCConverterCommand
   */
  @PutMapping("/unAssignMinUdc")
  public void unAssignMinUdc(
      @RequestBody(required = true) UnAssignMinUdcFromACDCConverterCommand command) {
    try {
      ACDCConverterBusinessDelegate.getACDCConverterInstance().unAssignMinUdc(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign MinUdc", exc);
    }
  }

  /**
   * save NumberOfValves on ACDCConverter
   *
   * @param command AssignNumberOfValvesToACDCConverterCommand
   */
  @PutMapping("/assignNumberOfValves")
  public void assignNumberOfValves(
      @RequestBody AssignNumberOfValvesToACDCConverterCommand command) {
    try {
      ACDCConverterBusinessDelegate.getACDCConverterInstance().assignNumberOfValves(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign NumberOfValves", exc);
    }
  }

  /**
   * unassign NumberOfValves on ACDCConverter
   *
   * @param command UnAssignNumberOfValvesFromACDCConverterCommand
   */
  @PutMapping("/unAssignNumberOfValves")
  public void unAssignNumberOfValves(
      @RequestBody(required = true) UnAssignNumberOfValvesFromACDCConverterCommand command) {
    try {
      ACDCConverterBusinessDelegate.getACDCConverterInstance().unAssignNumberOfValves(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign NumberOfValves", exc);
    }
  }

  /**
   * save RatedUdc on ACDCConverter
   *
   * @param command AssignRatedUdcToACDCConverterCommand
   */
  @PutMapping("/assignRatedUdc")
  public void assignRatedUdc(@RequestBody AssignRatedUdcToACDCConverterCommand command) {
    try {
      ACDCConverterBusinessDelegate.getACDCConverterInstance().assignRatedUdc(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign RatedUdc", exc);
    }
  }

  /**
   * unassign RatedUdc on ACDCConverter
   *
   * @param command UnAssignRatedUdcFromACDCConverterCommand
   */
  @PutMapping("/unAssignRatedUdc")
  public void unAssignRatedUdc(
      @RequestBody(required = true) UnAssignRatedUdcFromACDCConverterCommand command) {
    try {
      ACDCConverterBusinessDelegate.getACDCConverterInstance().unAssignRatedUdc(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign RatedUdc", exc);
    }
  }

  /**
   * save ResistiveLoss on ACDCConverter
   *
   * @param command AssignResistiveLossToACDCConverterCommand
   */
  @PutMapping("/assignResistiveLoss")
  public void assignResistiveLoss(@RequestBody AssignResistiveLossToACDCConverterCommand command) {
    try {
      ACDCConverterBusinessDelegate.getACDCConverterInstance().assignResistiveLoss(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign ResistiveLoss", exc);
    }
  }

  /**
   * unassign ResistiveLoss on ACDCConverter
   *
   * @param command UnAssignResistiveLossFromACDCConverterCommand
   */
  @PutMapping("/unAssignResistiveLoss")
  public void unAssignResistiveLoss(
      @RequestBody(required = true) UnAssignResistiveLossFromACDCConverterCommand command) {
    try {
      ACDCConverterBusinessDelegate.getACDCConverterInstance().unAssignResistiveLoss(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign ResistiveLoss", exc);
    }
  }

  /**
   * save SwitchingLoss on ACDCConverter
   *
   * @param command AssignSwitchingLossToACDCConverterCommand
   */
  @PutMapping("/assignSwitchingLoss")
  public void assignSwitchingLoss(@RequestBody AssignSwitchingLossToACDCConverterCommand command) {
    try {
      ACDCConverterBusinessDelegate.getACDCConverterInstance().assignSwitchingLoss(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign SwitchingLoss", exc);
    }
  }

  /**
   * unassign SwitchingLoss on ACDCConverter
   *
   * @param command UnAssignSwitchingLossFromACDCConverterCommand
   */
  @PutMapping("/unAssignSwitchingLoss")
  public void unAssignSwitchingLoss(
      @RequestBody(required = true) UnAssignSwitchingLossFromACDCConverterCommand command) {
    try {
      ACDCConverterBusinessDelegate.getACDCConverterInstance().unAssignSwitchingLoss(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign SwitchingLoss", exc);
    }
  }

  /**
   * save ValveU0 on ACDCConverter
   *
   * @param command AssignValveU0ToACDCConverterCommand
   */
  @PutMapping("/assignValveU0")
  public void assignValveU0(@RequestBody AssignValveU0ToACDCConverterCommand command) {
    try {
      ACDCConverterBusinessDelegate.getACDCConverterInstance().assignValveU0(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign ValveU0", exc);
    }
  }

  /**
   * unassign ValveU0 on ACDCConverter
   *
   * @param command UnAssignValveU0FromACDCConverterCommand
   */
  @PutMapping("/unAssignValveU0")
  public void unAssignValveU0(
      @RequestBody(required = true) UnAssignValveU0FromACDCConverterCommand command) {
    try {
      ACDCConverterBusinessDelegate.getACDCConverterInstance().unAssignValveU0(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign ValveU0", exc);
    }
  }

  /**
   * save ConverterDCSides on ACDCConverter
   *
   * @param command AssignConverterDCSidesToACDCConverterCommand
   */
  @PutMapping("/addToConverterDCSides")
  public void addToConverterDCSides(
      @RequestBody(required = true) AssignConverterDCSidesToACDCConverterCommand command) {
    try {
      ACDCConverterBusinessDelegate.getACDCConverterInstance().addToConverterDCSides(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to add to Set ConverterDCSides", exc);
    }
  }

  /**
   * remove ConverterDCSides on ACDCConverter
   *
   * @param command RemoveConverterDCSidesFromACDCConverterCommand
   */
  @PutMapping("/removeFromConverterDCSides")
  public void removeFromConverterDCSides(
      @RequestBody(required = true) RemoveConverterDCSidesFromACDCConverterCommand command) {
    try {
      ACDCConverterBusinessDelegate.getACDCConverterInstance().removeFromConverterDCSides(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to remove from Set ConverterDCSides", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected ACDCConverter aCDCConverter = null;
  private static final Logger LOGGER =
      Logger.getLogger(ACDCConverterCommandRestController.class.getName());
}
