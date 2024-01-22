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
 * Implements Spring Controller command CQRS processing for entity DCLine.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/DCLine")
public class DCLineCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a DCLine. if not key provided, calls create, otherwise calls save
   *
   * @param DCLine dCLine
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(@RequestBody(required = true) CreateDCLineCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture = DCLineBusinessDelegate.getDCLineInstance().createDCLine(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a DCLine. if no key provided, calls create, otherwise calls save
   *
   * @param DCLine dCLine
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(@RequestBody(required = true) UpdateDCLineCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateDCLineCommand
      // -----------------------------------------------
      completableFuture = DCLineBusinessDelegate.getDCLineInstance().updateDCLine(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "DCLineController:update() - successfully update DCLine - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a DCLine entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID dCLineId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteDCLineCommand command = new DeleteDCLineCommand(dCLineId);

    try {
      DCLineBusinessDelegate delegate = DCLineBusinessDelegate.getDCLineInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(Level.WARNING, "Successfully deleted DCLine with key " + command.getDCLineId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save DCLines on DCLine
   *
   * @param command AssignDCLinesToDCLineCommand
   */
  @PutMapping("/addToDCLines")
  public void addToDCLines(@RequestBody(required = true) AssignDCLinesToDCLineCommand command) {
    try {
      DCLineBusinessDelegate.getDCLineInstance().addToDCLines(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to add to Set DCLines", exc);
    }
  }

  /**
   * remove DCLines on DCLine
   *
   * @param command RemoveDCLinesFromDCLineCommand
   */
  @PutMapping("/removeFromDCLines")
  public void removeFromDCLines(
      @RequestBody(required = true) RemoveDCLinesFromDCLineCommand command) {
    try {
      DCLineBusinessDelegate.getDCLineInstance().removeFromDCLines(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to remove from Set DCLines", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected DCLine dCLine = null;
  private static final Logger LOGGER =
      Logger.getLogger(DCLineCommandRestController.class.getName());
}
