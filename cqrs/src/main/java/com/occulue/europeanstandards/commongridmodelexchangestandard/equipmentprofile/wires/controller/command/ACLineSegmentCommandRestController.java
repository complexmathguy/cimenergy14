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
 * Implements Spring Controller command CQRS processing for entity ACLineSegment.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ACLineSegment")
public class ACLineSegmentCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a ACLineSegment. if not key provided, calls create, otherwise calls save
   *
   * @param ACLineSegment aCLineSegment
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateACLineSegmentCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          ACLineSegmentBusinessDelegate.getACLineSegmentInstance().createACLineSegment(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a ACLineSegment. if no key provided, calls create, otherwise calls save
   *
   * @param ACLineSegment aCLineSegment
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateACLineSegmentCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateACLineSegmentCommand
      // -----------------------------------------------
      completableFuture =
          ACLineSegmentBusinessDelegate.getACLineSegmentInstance().updateACLineSegment(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "ACLineSegmentController:update() - successfully update ACLineSegment - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a ACLineSegment entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID aCLineSegmentId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteACLineSegmentCommand command = new DeleteACLineSegmentCommand(aCLineSegmentId);

    try {
      ACLineSegmentBusinessDelegate delegate =
          ACLineSegmentBusinessDelegate.getACLineSegmentInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted ACLineSegment with key " + command.getACLineSegmentId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save B0ch on ACLineSegment
   *
   * @param command AssignB0chToACLineSegmentCommand
   */
  @PutMapping("/assignB0ch")
  public void assignB0ch(@RequestBody AssignB0chToACLineSegmentCommand command) {
    try {
      ACLineSegmentBusinessDelegate.getACLineSegmentInstance().assignB0ch(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign B0ch", exc);
    }
  }

  /**
   * unassign B0ch on ACLineSegment
   *
   * @param command UnAssignB0chFromACLineSegmentCommand
   */
  @PutMapping("/unAssignB0ch")
  public void unAssignB0ch(
      @RequestBody(required = true) UnAssignB0chFromACLineSegmentCommand command) {
    try {
      ACLineSegmentBusinessDelegate.getACLineSegmentInstance().unAssignB0ch(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign B0ch", exc);
    }
  }

  /**
   * save Bch on ACLineSegment
   *
   * @param command AssignBchToACLineSegmentCommand
   */
  @PutMapping("/assignBch")
  public void assignBch(@RequestBody AssignBchToACLineSegmentCommand command) {
    try {
      ACLineSegmentBusinessDelegate.getACLineSegmentInstance().assignBch(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Bch", exc);
    }
  }

  /**
   * unassign Bch on ACLineSegment
   *
   * @param command UnAssignBchFromACLineSegmentCommand
   */
  @PutMapping("/unAssignBch")
  public void unAssignBch(
      @RequestBody(required = true) UnAssignBchFromACLineSegmentCommand command) {
    try {
      ACLineSegmentBusinessDelegate.getACLineSegmentInstance().unAssignBch(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Bch", exc);
    }
  }

  /**
   * save G0ch on ACLineSegment
   *
   * @param command AssignG0chToACLineSegmentCommand
   */
  @PutMapping("/assignG0ch")
  public void assignG0ch(@RequestBody AssignG0chToACLineSegmentCommand command) {
    try {
      ACLineSegmentBusinessDelegate.getACLineSegmentInstance().assignG0ch(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign G0ch", exc);
    }
  }

  /**
   * unassign G0ch on ACLineSegment
   *
   * @param command UnAssignG0chFromACLineSegmentCommand
   */
  @PutMapping("/unAssignG0ch")
  public void unAssignG0ch(
      @RequestBody(required = true) UnAssignG0chFromACLineSegmentCommand command) {
    try {
      ACLineSegmentBusinessDelegate.getACLineSegmentInstance().unAssignG0ch(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign G0ch", exc);
    }
  }

  /**
   * save Gch on ACLineSegment
   *
   * @param command AssignGchToACLineSegmentCommand
   */
  @PutMapping("/assignGch")
  public void assignGch(@RequestBody AssignGchToACLineSegmentCommand command) {
    try {
      ACLineSegmentBusinessDelegate.getACLineSegmentInstance().assignGch(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Gch", exc);
    }
  }

  /**
   * unassign Gch on ACLineSegment
   *
   * @param command UnAssignGchFromACLineSegmentCommand
   */
  @PutMapping("/unAssignGch")
  public void unAssignGch(
      @RequestBody(required = true) UnAssignGchFromACLineSegmentCommand command) {
    try {
      ACLineSegmentBusinessDelegate.getACLineSegmentInstance().unAssignGch(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Gch", exc);
    }
  }

  /**
   * save R on ACLineSegment
   *
   * @param command AssignRToACLineSegmentCommand
   */
  @PutMapping("/assignR")
  public void assignR(@RequestBody AssignRToACLineSegmentCommand command) {
    try {
      ACLineSegmentBusinessDelegate.getACLineSegmentInstance().assignR(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign R", exc);
    }
  }

  /**
   * unassign R on ACLineSegment
   *
   * @param command UnAssignRFromACLineSegmentCommand
   */
  @PutMapping("/unAssignR")
  public void unAssignR(@RequestBody(required = true) UnAssignRFromACLineSegmentCommand command) {
    try {
      ACLineSegmentBusinessDelegate.getACLineSegmentInstance().unAssignR(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign R", exc);
    }
  }

  /**
   * save R0 on ACLineSegment
   *
   * @param command AssignR0ToACLineSegmentCommand
   */
  @PutMapping("/assignR0")
  public void assignR0(@RequestBody AssignR0ToACLineSegmentCommand command) {
    try {
      ACLineSegmentBusinessDelegate.getACLineSegmentInstance().assignR0(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign R0", exc);
    }
  }

  /**
   * unassign R0 on ACLineSegment
   *
   * @param command UnAssignR0FromACLineSegmentCommand
   */
  @PutMapping("/unAssignR0")
  public void unAssignR0(@RequestBody(required = true) UnAssignR0FromACLineSegmentCommand command) {
    try {
      ACLineSegmentBusinessDelegate.getACLineSegmentInstance().unAssignR0(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign R0", exc);
    }
  }

  /**
   * save ShortCircuitEndTemperature on ACLineSegment
   *
   * @param command AssignShortCircuitEndTemperatureToACLineSegmentCommand
   */
  @PutMapping("/assignShortCircuitEndTemperature")
  public void assignShortCircuitEndTemperature(
      @RequestBody AssignShortCircuitEndTemperatureToACLineSegmentCommand command) {
    try {
      ACLineSegmentBusinessDelegate.getACLineSegmentInstance()
          .assignShortCircuitEndTemperature(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign ShortCircuitEndTemperature", exc);
    }
  }

  /**
   * unassign ShortCircuitEndTemperature on ACLineSegment
   *
   * @param command UnAssignShortCircuitEndTemperatureFromACLineSegmentCommand
   */
  @PutMapping("/unAssignShortCircuitEndTemperature")
  public void unAssignShortCircuitEndTemperature(
      @RequestBody(required = true)
          UnAssignShortCircuitEndTemperatureFromACLineSegmentCommand command) {
    try {
      ACLineSegmentBusinessDelegate.getACLineSegmentInstance()
          .unAssignShortCircuitEndTemperature(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign ShortCircuitEndTemperature", exc);
    }
  }

  /**
   * save X on ACLineSegment
   *
   * @param command AssignXToACLineSegmentCommand
   */
  @PutMapping("/assignX")
  public void assignX(@RequestBody AssignXToACLineSegmentCommand command) {
    try {
      ACLineSegmentBusinessDelegate.getACLineSegmentInstance().assignX(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign X", exc);
    }
  }

  /**
   * unassign X on ACLineSegment
   *
   * @param command UnAssignXFromACLineSegmentCommand
   */
  @PutMapping("/unAssignX")
  public void unAssignX(@RequestBody(required = true) UnAssignXFromACLineSegmentCommand command) {
    try {
      ACLineSegmentBusinessDelegate.getACLineSegmentInstance().unAssignX(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign X", exc);
    }
  }

  /**
   * save X0 on ACLineSegment
   *
   * @param command AssignX0ToACLineSegmentCommand
   */
  @PutMapping("/assignX0")
  public void assignX0(@RequestBody AssignX0ToACLineSegmentCommand command) {
    try {
      ACLineSegmentBusinessDelegate.getACLineSegmentInstance().assignX0(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign X0", exc);
    }
  }

  /**
   * unassign X0 on ACLineSegment
   *
   * @param command UnAssignX0FromACLineSegmentCommand
   */
  @PutMapping("/unAssignX0")
  public void unAssignX0(@RequestBody(required = true) UnAssignX0FromACLineSegmentCommand command) {
    try {
      ACLineSegmentBusinessDelegate.getACLineSegmentInstance().unAssignX0(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign X0", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected ACLineSegment aCLineSegment = null;
  private static final Logger LOGGER =
      Logger.getLogger(ACLineSegmentCommandRestController.class.getName());
}
