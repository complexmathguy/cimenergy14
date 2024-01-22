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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.core.controller.command;

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
 * Implements Spring Controller command CQRS processing for entity RegularTimePoint.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/RegularTimePoint")
public class RegularTimePointCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a RegularTimePoint. if not key provided, calls create, otherwise calls save
   *
   * @param RegularTimePoint regularTimePoint
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateRegularTimePointCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          RegularTimePointBusinessDelegate.getRegularTimePointInstance()
              .createRegularTimePoint(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a RegularTimePoint. if no key provided, calls create, otherwise calls save
   *
   * @param RegularTimePoint regularTimePoint
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateRegularTimePointCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateRegularTimePointCommand
      // -----------------------------------------------
      completableFuture =
          RegularTimePointBusinessDelegate.getRegularTimePointInstance()
              .updateRegularTimePoint(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "RegularTimePointController:update() - successfully update RegularTimePoint - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a RegularTimePoint entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID regularTimePointId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteRegularTimePointCommand command = new DeleteRegularTimePointCommand(regularTimePointId);

    try {
      RegularTimePointBusinessDelegate delegate =
          RegularTimePointBusinessDelegate.getRegularTimePointInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted RegularTimePoint with key " + command.getRegularTimePointId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save SequenceNumber on RegularTimePoint
   *
   * @param command AssignSequenceNumberToRegularTimePointCommand
   */
  @PutMapping("/assignSequenceNumber")
  public void assignSequenceNumber(
      @RequestBody AssignSequenceNumberToRegularTimePointCommand command) {
    try {
      RegularTimePointBusinessDelegate.getRegularTimePointInstance().assignSequenceNumber(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign SequenceNumber", exc);
    }
  }

  /**
   * unassign SequenceNumber on RegularTimePoint
   *
   * @param command UnAssignSequenceNumberFromRegularTimePointCommand
   */
  @PutMapping("/unAssignSequenceNumber")
  public void unAssignSequenceNumber(
      @RequestBody(required = true) UnAssignSequenceNumberFromRegularTimePointCommand command) {
    try {
      RegularTimePointBusinessDelegate.getRegularTimePointInstance()
          .unAssignSequenceNumber(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign SequenceNumber", exc);
    }
  }

  /**
   * save Value1 on RegularTimePoint
   *
   * @param command AssignValue1ToRegularTimePointCommand
   */
  @PutMapping("/assignValue1")
  public void assignValue1(@RequestBody AssignValue1ToRegularTimePointCommand command) {
    try {
      RegularTimePointBusinessDelegate.getRegularTimePointInstance().assignValue1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Value1", exc);
    }
  }

  /**
   * unassign Value1 on RegularTimePoint
   *
   * @param command UnAssignValue1FromRegularTimePointCommand
   */
  @PutMapping("/unAssignValue1")
  public void unAssignValue1(
      @RequestBody(required = true) UnAssignValue1FromRegularTimePointCommand command) {
    try {
      RegularTimePointBusinessDelegate.getRegularTimePointInstance().unAssignValue1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Value1", exc);
    }
  }

  /**
   * save Value2 on RegularTimePoint
   *
   * @param command AssignValue2ToRegularTimePointCommand
   */
  @PutMapping("/assignValue2")
  public void assignValue2(@RequestBody AssignValue2ToRegularTimePointCommand command) {
    try {
      RegularTimePointBusinessDelegate.getRegularTimePointInstance().assignValue2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Value2", exc);
    }
  }

  /**
   * unassign Value2 on RegularTimePoint
   *
   * @param command UnAssignValue2FromRegularTimePointCommand
   */
  @PutMapping("/unAssignValue2")
  public void unAssignValue2(
      @RequestBody(required = true) UnAssignValue2FromRegularTimePointCommand command) {
    try {
      RegularTimePointBusinessDelegate.getRegularTimePointInstance().unAssignValue2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Value2", exc);
    }
  }

  /**
   * save TimePoints on RegularTimePoint
   *
   * @param command AssignTimePointsToRegularTimePointCommand
   */
  @PutMapping("/addToTimePoints")
  public void addToTimePoints(
      @RequestBody(required = true) AssignTimePointsToRegularTimePointCommand command) {
    try {
      RegularTimePointBusinessDelegate.getRegularTimePointInstance().addToTimePoints(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to add to Set TimePoints", exc);
    }
  }

  /**
   * remove TimePoints on RegularTimePoint
   *
   * @param command RemoveTimePointsFromRegularTimePointCommand
   */
  @PutMapping("/removeFromTimePoints")
  public void removeFromTimePoints(
      @RequestBody(required = true) RemoveTimePointsFromRegularTimePointCommand command) {
    try {
      RegularTimePointBusinessDelegate.getRegularTimePointInstance().removeFromTimePoints(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to remove from Set TimePoints", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected RegularTimePoint regularTimePoint = null;
  private static final Logger LOGGER =
      Logger.getLogger(RegularTimePointCommandRestController.class.getName());
}
