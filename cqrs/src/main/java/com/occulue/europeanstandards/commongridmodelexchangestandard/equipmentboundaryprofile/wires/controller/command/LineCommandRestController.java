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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentboundaryprofile.wires.controller.command;

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
 * Implements Spring Controller command CQRS processing for entity Line.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/Line")
public class LineCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a Line. if not key provided, calls create, otherwise calls save
   *
   * @param Line line
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(@RequestBody(required = true) CreateLineCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture = LineBusinessDelegate.getLineInstance().createLine(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a Line. if no key provided, calls create, otherwise calls save
   *
   * @param Line line
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(@RequestBody(required = true) UpdateLineCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateLineCommand
      // -----------------------------------------------
      completableFuture = LineBusinessDelegate.getLineInstance().updateLine(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "LineController:update() - successfully update Line - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a Line entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID lineId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteLineCommand command = new DeleteLineCommand(lineId);

    try {
      LineBusinessDelegate delegate = LineBusinessDelegate.getLineInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(Level.WARNING, "Successfully deleted Line with key " + command.getLineId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Lines on Line
   *
   * @param command AssignLinesToLineCommand
   */
  @PutMapping("/addToLines")
  public void addToLines(@RequestBody(required = true) AssignLinesToLineCommand command) {
    try {
      LineBusinessDelegate.getLineInstance().addToLines(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to add to Set Lines", exc);
    }
  }

  /**
   * remove Lines on Line
   *
   * @param command RemoveLinesFromLineCommand
   */
  @PutMapping("/removeFromLines")
  public void removeFromLines(@RequestBody(required = true) RemoveLinesFromLineCommand command) {
    try {
      LineBusinessDelegate.getLineInstance().removeFromLines(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to remove from Set Lines", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected Line line = null;
  private static final Logger LOGGER = Logger.getLogger(LineCommandRestController.class.getName());
}
