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
 * Implements Spring Controller command CQRS processing for entity NonlinearShuntCompensatorPoint.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/NonlinearShuntCompensatorPoint")
public class NonlinearShuntCompensatorPointCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a NonlinearShuntCompensatorPoint. if not key provided, calls create, otherwise
   * calls save
   *
   * @param NonlinearShuntCompensatorPoint nonlinearShuntCompensatorPoint
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateNonlinearShuntCompensatorPointCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          NonlinearShuntCompensatorPointBusinessDelegate.getNonlinearShuntCompensatorPointInstance()
              .createNonlinearShuntCompensatorPoint(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a NonlinearShuntCompensatorPoint. if no key provided, calls create, otherwise
   * calls save
   *
   * @param NonlinearShuntCompensatorPoint nonlinearShuntCompensatorPoint
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateNonlinearShuntCompensatorPointCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateNonlinearShuntCompensatorPointCommand
      // -----------------------------------------------
      completableFuture =
          NonlinearShuntCompensatorPointBusinessDelegate.getNonlinearShuntCompensatorPointInstance()
              .updateNonlinearShuntCompensatorPoint(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "NonlinearShuntCompensatorPointController:update() - successfully update NonlinearShuntCompensatorPoint - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a NonlinearShuntCompensatorPoint entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(
      @RequestParam(required = true) UUID nonlinearShuntCompensatorPointId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteNonlinearShuntCompensatorPointCommand command =
        new DeleteNonlinearShuntCompensatorPointCommand(nonlinearShuntCompensatorPointId);

    try {
      NonlinearShuntCompensatorPointBusinessDelegate delegate =
          NonlinearShuntCompensatorPointBusinessDelegate
              .getNonlinearShuntCompensatorPointInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted NonlinearShuntCompensatorPoint with key "
              + command.getNonlinearShuntCompensatorPointId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save B on NonlinearShuntCompensatorPoint
   *
   * @param command AssignBToNonlinearShuntCompensatorPointCommand
   */
  @PutMapping("/assignB")
  public void assignB(@RequestBody AssignBToNonlinearShuntCompensatorPointCommand command) {
    try {
      NonlinearShuntCompensatorPointBusinessDelegate.getNonlinearShuntCompensatorPointInstance()
          .assignB(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign B", exc);
    }
  }

  /**
   * unassign B on NonlinearShuntCompensatorPoint
   *
   * @param command UnAssignBFromNonlinearShuntCompensatorPointCommand
   */
  @PutMapping("/unAssignB")
  public void unAssignB(
      @RequestBody(required = true) UnAssignBFromNonlinearShuntCompensatorPointCommand command) {
    try {
      NonlinearShuntCompensatorPointBusinessDelegate.getNonlinearShuntCompensatorPointInstance()
          .unAssignB(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign B", exc);
    }
  }

  /**
   * save B0 on NonlinearShuntCompensatorPoint
   *
   * @param command AssignB0ToNonlinearShuntCompensatorPointCommand
   */
  @PutMapping("/assignB0")
  public void assignB0(@RequestBody AssignB0ToNonlinearShuntCompensatorPointCommand command) {
    try {
      NonlinearShuntCompensatorPointBusinessDelegate.getNonlinearShuntCompensatorPointInstance()
          .assignB0(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign B0", exc);
    }
  }

  /**
   * unassign B0 on NonlinearShuntCompensatorPoint
   *
   * @param command UnAssignB0FromNonlinearShuntCompensatorPointCommand
   */
  @PutMapping("/unAssignB0")
  public void unAssignB0(
      @RequestBody(required = true) UnAssignB0FromNonlinearShuntCompensatorPointCommand command) {
    try {
      NonlinearShuntCompensatorPointBusinessDelegate.getNonlinearShuntCompensatorPointInstance()
          .unAssignB0(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign B0", exc);
    }
  }

  /**
   * save G on NonlinearShuntCompensatorPoint
   *
   * @param command AssignGToNonlinearShuntCompensatorPointCommand
   */
  @PutMapping("/assignG")
  public void assignG(@RequestBody AssignGToNonlinearShuntCompensatorPointCommand command) {
    try {
      NonlinearShuntCompensatorPointBusinessDelegate.getNonlinearShuntCompensatorPointInstance()
          .assignG(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign G", exc);
    }
  }

  /**
   * unassign G on NonlinearShuntCompensatorPoint
   *
   * @param command UnAssignGFromNonlinearShuntCompensatorPointCommand
   */
  @PutMapping("/unAssignG")
  public void unAssignG(
      @RequestBody(required = true) UnAssignGFromNonlinearShuntCompensatorPointCommand command) {
    try {
      NonlinearShuntCompensatorPointBusinessDelegate.getNonlinearShuntCompensatorPointInstance()
          .unAssignG(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign G", exc);
    }
  }

  /**
   * save G0 on NonlinearShuntCompensatorPoint
   *
   * @param command AssignG0ToNonlinearShuntCompensatorPointCommand
   */
  @PutMapping("/assignG0")
  public void assignG0(@RequestBody AssignG0ToNonlinearShuntCompensatorPointCommand command) {
    try {
      NonlinearShuntCompensatorPointBusinessDelegate.getNonlinearShuntCompensatorPointInstance()
          .assignG0(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign G0", exc);
    }
  }

  /**
   * unassign G0 on NonlinearShuntCompensatorPoint
   *
   * @param command UnAssignG0FromNonlinearShuntCompensatorPointCommand
   */
  @PutMapping("/unAssignG0")
  public void unAssignG0(
      @RequestBody(required = true) UnAssignG0FromNonlinearShuntCompensatorPointCommand command) {
    try {
      NonlinearShuntCompensatorPointBusinessDelegate.getNonlinearShuntCompensatorPointInstance()
          .unAssignG0(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign G0", exc);
    }
  }

  /**
   * save SectionNumber on NonlinearShuntCompensatorPoint
   *
   * @param command AssignSectionNumberToNonlinearShuntCompensatorPointCommand
   */
  @PutMapping("/assignSectionNumber")
  public void assignSectionNumber(
      @RequestBody AssignSectionNumberToNonlinearShuntCompensatorPointCommand command) {
    try {
      NonlinearShuntCompensatorPointBusinessDelegate.getNonlinearShuntCompensatorPointInstance()
          .assignSectionNumber(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign SectionNumber", exc);
    }
  }

  /**
   * unassign SectionNumber on NonlinearShuntCompensatorPoint
   *
   * @param command UnAssignSectionNumberFromNonlinearShuntCompensatorPointCommand
   */
  @PutMapping("/unAssignSectionNumber")
  public void unAssignSectionNumber(
      @RequestBody(required = true)
          UnAssignSectionNumberFromNonlinearShuntCompensatorPointCommand command) {
    try {
      NonlinearShuntCompensatorPointBusinessDelegate.getNonlinearShuntCompensatorPointInstance()
          .unAssignSectionNumber(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign SectionNumber", exc);
    }
  }

  /**
   * save NonlinearShuntCompensatorPoints on NonlinearShuntCompensatorPoint
   *
   * @param command AssignNonlinearShuntCompensatorPointsToNonlinearShuntCompensatorPointCommand
   */
  @PutMapping("/addToNonlinearShuntCompensatorPoints")
  public void addToNonlinearShuntCompensatorPoints(
      @RequestBody(required = true)
          AssignNonlinearShuntCompensatorPointsToNonlinearShuntCompensatorPointCommand command) {
    try {
      NonlinearShuntCompensatorPointBusinessDelegate.getNonlinearShuntCompensatorPointInstance()
          .addToNonlinearShuntCompensatorPoints(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to add to Set NonlinearShuntCompensatorPoints", exc);
    }
  }

  /**
   * remove NonlinearShuntCompensatorPoints on NonlinearShuntCompensatorPoint
   *
   * @param command RemoveNonlinearShuntCompensatorPointsFromNonlinearShuntCompensatorPointCommand
   */
  @PutMapping("/removeFromNonlinearShuntCompensatorPoints")
  public void removeFromNonlinearShuntCompensatorPoints(
      @RequestBody(required = true)
          RemoveNonlinearShuntCompensatorPointsFromNonlinearShuntCompensatorPointCommand command) {
    try {
      NonlinearShuntCompensatorPointBusinessDelegate.getNonlinearShuntCompensatorPointInstance()
          .removeFromNonlinearShuntCompensatorPoints(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to remove from Set NonlinearShuntCompensatorPoints", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected NonlinearShuntCompensatorPoint nonlinearShuntCompensatorPoint = null;
  private static final Logger LOGGER =
      Logger.getLogger(NonlinearShuntCompensatorPointCommandRestController.class.getName());
}
