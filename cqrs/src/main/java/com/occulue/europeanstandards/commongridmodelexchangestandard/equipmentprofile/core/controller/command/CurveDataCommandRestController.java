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
 * Implements Spring Controller command CQRS processing for entity CurveData.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/CurveData")
public class CurveDataCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a CurveData. if not key provided, calls create, otherwise calls save
   *
   * @param CurveData curveData
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateCurveDataCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture = CurveDataBusinessDelegate.getCurveDataInstance().createCurveData(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a CurveData. if no key provided, calls create, otherwise calls save
   *
   * @param CurveData curveData
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateCurveDataCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateCurveDataCommand
      // -----------------------------------------------
      completableFuture = CurveDataBusinessDelegate.getCurveDataInstance().updateCurveData(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "CurveDataController:update() - successfully update CurveData - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a CurveData entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID curveDataId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteCurveDataCommand command = new DeleteCurveDataCommand(curveDataId);

    try {
      CurveDataBusinessDelegate delegate = CurveDataBusinessDelegate.getCurveDataInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING, "Successfully deleted CurveData with key " + command.getCurveDataId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Xvalue on CurveData
   *
   * @param command AssignXvalueToCurveDataCommand
   */
  @PutMapping("/assignXvalue")
  public void assignXvalue(@RequestBody AssignXvalueToCurveDataCommand command) {
    try {
      CurveDataBusinessDelegate.getCurveDataInstance().assignXvalue(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Xvalue", exc);
    }
  }

  /**
   * unassign Xvalue on CurveData
   *
   * @param command UnAssignXvalueFromCurveDataCommand
   */
  @PutMapping("/unAssignXvalue")
  public void unAssignXvalue(
      @RequestBody(required = true) UnAssignXvalueFromCurveDataCommand command) {
    try {
      CurveDataBusinessDelegate.getCurveDataInstance().unAssignXvalue(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Xvalue", exc);
    }
  }

  /**
   * save Y1value on CurveData
   *
   * @param command AssignY1valueToCurveDataCommand
   */
  @PutMapping("/assignY1value")
  public void assignY1value(@RequestBody AssignY1valueToCurveDataCommand command) {
    try {
      CurveDataBusinessDelegate.getCurveDataInstance().assignY1value(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Y1value", exc);
    }
  }

  /**
   * unassign Y1value on CurveData
   *
   * @param command UnAssignY1valueFromCurveDataCommand
   */
  @PutMapping("/unAssignY1value")
  public void unAssignY1value(
      @RequestBody(required = true) UnAssignY1valueFromCurveDataCommand command) {
    try {
      CurveDataBusinessDelegate.getCurveDataInstance().unAssignY1value(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Y1value", exc);
    }
  }

  /**
   * save Y2value on CurveData
   *
   * @param command AssignY2valueToCurveDataCommand
   */
  @PutMapping("/assignY2value")
  public void assignY2value(@RequestBody AssignY2valueToCurveDataCommand command) {
    try {
      CurveDataBusinessDelegate.getCurveDataInstance().assignY2value(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Y2value", exc);
    }
  }

  /**
   * unassign Y2value on CurveData
   *
   * @param command UnAssignY2valueFromCurveDataCommand
   */
  @PutMapping("/unAssignY2value")
  public void unAssignY2value(
      @RequestBody(required = true) UnAssignY2valueFromCurveDataCommand command) {
    try {
      CurveDataBusinessDelegate.getCurveDataInstance().unAssignY2value(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Y2value", exc);
    }
  }

  /**
   * save CurveDatas on CurveData
   *
   * @param command AssignCurveDatasToCurveDataCommand
   */
  @PutMapping("/addToCurveDatas")
  public void addToCurveDatas(
      @RequestBody(required = true) AssignCurveDatasToCurveDataCommand command) {
    try {
      CurveDataBusinessDelegate.getCurveDataInstance().addToCurveDatas(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to add to Set CurveDatas", exc);
    }
  }

  /**
   * remove CurveDatas on CurveData
   *
   * @param command RemoveCurveDatasFromCurveDataCommand
   */
  @PutMapping("/removeFromCurveDatas")
  public void removeFromCurveDatas(
      @RequestBody(required = true) RemoveCurveDatasFromCurveDataCommand command) {
    try {
      CurveDataBusinessDelegate.getCurveDataInstance().removeFromCurveDatas(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to remove from Set CurveDatas", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected CurveData curveData = null;
  private static final Logger LOGGER =
      Logger.getLogger(CurveDataCommandRestController.class.getName());
}
