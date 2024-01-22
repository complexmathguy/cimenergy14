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
package com.occulue.europeanstandards.commongridmodelexchangestandard.geographicallocationprofile.common.controller.command;

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
 * Implements Spring Controller command CQRS processing for entity CoordinateSystem.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/CoordinateSystem")
public class CoordinateSystemCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a CoordinateSystem. if not key provided, calls create, otherwise calls save
   *
   * @param CoordinateSystem coordinateSystem
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateCoordinateSystemCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          CoordinateSystemBusinessDelegate.getCoordinateSystemInstance()
              .createCoordinateSystem(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a CoordinateSystem. if no key provided, calls create, otherwise calls save
   *
   * @param CoordinateSystem coordinateSystem
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateCoordinateSystemCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateCoordinateSystemCommand
      // -----------------------------------------------
      completableFuture =
          CoordinateSystemBusinessDelegate.getCoordinateSystemInstance()
              .updateCoordinateSystem(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "CoordinateSystemController:update() - successfully update CoordinateSystem - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a CoordinateSystem entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID coordinateSystemId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteCoordinateSystemCommand command = new DeleteCoordinateSystemCommand(coordinateSystemId);

    try {
      CoordinateSystemBusinessDelegate delegate =
          CoordinateSystemBusinessDelegate.getCoordinateSystemInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted CoordinateSystem with key " + command.getCoordinateSystemId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save CrsUrn on CoordinateSystem
   *
   * @param command AssignCrsUrnToCoordinateSystemCommand
   */
  @PutMapping("/assignCrsUrn")
  public void assignCrsUrn(@RequestBody AssignCrsUrnToCoordinateSystemCommand command) {
    try {
      CoordinateSystemBusinessDelegate.getCoordinateSystemInstance().assignCrsUrn(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign CrsUrn", exc);
    }
  }

  /**
   * unassign CrsUrn on CoordinateSystem
   *
   * @param command UnAssignCrsUrnFromCoordinateSystemCommand
   */
  @PutMapping("/unAssignCrsUrn")
  public void unAssignCrsUrn(
      @RequestBody(required = true) UnAssignCrsUrnFromCoordinateSystemCommand command) {
    try {
      CoordinateSystemBusinessDelegate.getCoordinateSystemInstance().unAssignCrsUrn(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign CrsUrn", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected CoordinateSystem coordinateSystem = null;
  private static final Logger LOGGER =
      Logger.getLogger(CoordinateSystemCommandRestController.class.getName());
}
