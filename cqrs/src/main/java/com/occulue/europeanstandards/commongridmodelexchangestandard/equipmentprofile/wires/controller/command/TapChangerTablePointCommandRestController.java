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
 * Implements Spring Controller command CQRS processing for entity TapChangerTablePoint.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/TapChangerTablePoint")
public class TapChangerTablePointCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a TapChangerTablePoint. if not key provided, calls create, otherwise calls save
   *
   * @param TapChangerTablePoint tapChangerTablePoint
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateTapChangerTablePointCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          TapChangerTablePointBusinessDelegate.getTapChangerTablePointInstance()
              .createTapChangerTablePoint(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a TapChangerTablePoint. if no key provided, calls create, otherwise calls save
   *
   * @param TapChangerTablePoint tapChangerTablePoint
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateTapChangerTablePointCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateTapChangerTablePointCommand
      // -----------------------------------------------
      completableFuture =
          TapChangerTablePointBusinessDelegate.getTapChangerTablePointInstance()
              .updateTapChangerTablePoint(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "TapChangerTablePointController:update() - successfully update TapChangerTablePoint - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a TapChangerTablePoint entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(
      @RequestParam(required = true) UUID tapChangerTablePointId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteTapChangerTablePointCommand command =
        new DeleteTapChangerTablePointCommand(tapChangerTablePointId);

    try {
      TapChangerTablePointBusinessDelegate delegate =
          TapChangerTablePointBusinessDelegate.getTapChangerTablePointInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted TapChangerTablePoint with key "
              + command.getTapChangerTablePointId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save B on TapChangerTablePoint
   *
   * @param command AssignBToTapChangerTablePointCommand
   */
  @PutMapping("/assignB")
  public void assignB(@RequestBody AssignBToTapChangerTablePointCommand command) {
    try {
      TapChangerTablePointBusinessDelegate.getTapChangerTablePointInstance().assignB(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign B", exc);
    }
  }

  /**
   * unassign B on TapChangerTablePoint
   *
   * @param command UnAssignBFromTapChangerTablePointCommand
   */
  @PutMapping("/unAssignB")
  public void unAssignB(
      @RequestBody(required = true) UnAssignBFromTapChangerTablePointCommand command) {
    try {
      TapChangerTablePointBusinessDelegate.getTapChangerTablePointInstance().unAssignB(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign B", exc);
    }
  }

  /**
   * save G on TapChangerTablePoint
   *
   * @param command AssignGToTapChangerTablePointCommand
   */
  @PutMapping("/assignG")
  public void assignG(@RequestBody AssignGToTapChangerTablePointCommand command) {
    try {
      TapChangerTablePointBusinessDelegate.getTapChangerTablePointInstance().assignG(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign G", exc);
    }
  }

  /**
   * unassign G on TapChangerTablePoint
   *
   * @param command UnAssignGFromTapChangerTablePointCommand
   */
  @PutMapping("/unAssignG")
  public void unAssignG(
      @RequestBody(required = true) UnAssignGFromTapChangerTablePointCommand command) {
    try {
      TapChangerTablePointBusinessDelegate.getTapChangerTablePointInstance().unAssignG(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign G", exc);
    }
  }

  /**
   * save R on TapChangerTablePoint
   *
   * @param command AssignRToTapChangerTablePointCommand
   */
  @PutMapping("/assignR")
  public void assignR(@RequestBody AssignRToTapChangerTablePointCommand command) {
    try {
      TapChangerTablePointBusinessDelegate.getTapChangerTablePointInstance().assignR(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign R", exc);
    }
  }

  /**
   * unassign R on TapChangerTablePoint
   *
   * @param command UnAssignRFromTapChangerTablePointCommand
   */
  @PutMapping("/unAssignR")
  public void unAssignR(
      @RequestBody(required = true) UnAssignRFromTapChangerTablePointCommand command) {
    try {
      TapChangerTablePointBusinessDelegate.getTapChangerTablePointInstance().unAssignR(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign R", exc);
    }
  }

  /**
   * save Ratio on TapChangerTablePoint
   *
   * @param command AssignRatioToTapChangerTablePointCommand
   */
  @PutMapping("/assignRatio")
  public void assignRatio(@RequestBody AssignRatioToTapChangerTablePointCommand command) {
    try {
      TapChangerTablePointBusinessDelegate.getTapChangerTablePointInstance().assignRatio(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ratio", exc);
    }
  }

  /**
   * unassign Ratio on TapChangerTablePoint
   *
   * @param command UnAssignRatioFromTapChangerTablePointCommand
   */
  @PutMapping("/unAssignRatio")
  public void unAssignRatio(
      @RequestBody(required = true) UnAssignRatioFromTapChangerTablePointCommand command) {
    try {
      TapChangerTablePointBusinessDelegate.getTapChangerTablePointInstance().unAssignRatio(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ratio", exc);
    }
  }

  /**
   * save Step on TapChangerTablePoint
   *
   * @param command AssignStepToTapChangerTablePointCommand
   */
  @PutMapping("/assignStep")
  public void assignStep(@RequestBody AssignStepToTapChangerTablePointCommand command) {
    try {
      TapChangerTablePointBusinessDelegate.getTapChangerTablePointInstance().assignStep(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Step", exc);
    }
  }

  /**
   * unassign Step on TapChangerTablePoint
   *
   * @param command UnAssignStepFromTapChangerTablePointCommand
   */
  @PutMapping("/unAssignStep")
  public void unAssignStep(
      @RequestBody(required = true) UnAssignStepFromTapChangerTablePointCommand command) {
    try {
      TapChangerTablePointBusinessDelegate.getTapChangerTablePointInstance().unAssignStep(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Step", exc);
    }
  }

  /**
   * save X on TapChangerTablePoint
   *
   * @param command AssignXToTapChangerTablePointCommand
   */
  @PutMapping("/assignX")
  public void assignX(@RequestBody AssignXToTapChangerTablePointCommand command) {
    try {
      TapChangerTablePointBusinessDelegate.getTapChangerTablePointInstance().assignX(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign X", exc);
    }
  }

  /**
   * unassign X on TapChangerTablePoint
   *
   * @param command UnAssignXFromTapChangerTablePointCommand
   */
  @PutMapping("/unAssignX")
  public void unAssignX(
      @RequestBody(required = true) UnAssignXFromTapChangerTablePointCommand command) {
    try {
      TapChangerTablePointBusinessDelegate.getTapChangerTablePointInstance().unAssignX(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign X", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected TapChangerTablePoint tapChangerTablePoint = null;
  private static final Logger LOGGER =
      Logger.getLogger(TapChangerTablePointCommandRestController.class.getName());
}
