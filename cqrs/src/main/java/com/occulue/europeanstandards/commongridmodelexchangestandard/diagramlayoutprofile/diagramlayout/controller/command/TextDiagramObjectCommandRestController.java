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
package com.occulue.europeanstandards.commongridmodelexchangestandard.diagramlayoutprofile.diagramlayout.controller.command;

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
 * Implements Spring Controller command CQRS processing for entity TextDiagramObject.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/TextDiagramObject")
public class TextDiagramObjectCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a TextDiagramObject. if not key provided, calls create, otherwise calls save
   *
   * @param TextDiagramObject textDiagramObject
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateTextDiagramObjectCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          TextDiagramObjectBusinessDelegate.getTextDiagramObjectInstance()
              .createTextDiagramObject(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a TextDiagramObject. if no key provided, calls create, otherwise calls save
   *
   * @param TextDiagramObject textDiagramObject
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateTextDiagramObjectCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateTextDiagramObjectCommand
      // -----------------------------------------------
      completableFuture =
          TextDiagramObjectBusinessDelegate.getTextDiagramObjectInstance()
              .updateTextDiagramObject(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "TextDiagramObjectController:update() - successfully update TextDiagramObject - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a TextDiagramObject entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID textDiagramObjectId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteTextDiagramObjectCommand command =
        new DeleteTextDiagramObjectCommand(textDiagramObjectId);

    try {
      TextDiagramObjectBusinessDelegate delegate =
          TextDiagramObjectBusinessDelegate.getTextDiagramObjectInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted TextDiagramObject with key " + command.getTextDiagramObjectId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Text on TextDiagramObject
   *
   * @param command AssignTextToTextDiagramObjectCommand
   */
  @PutMapping("/assignText")
  public void assignText(@RequestBody AssignTextToTextDiagramObjectCommand command) {
    try {
      TextDiagramObjectBusinessDelegate.getTextDiagramObjectInstance().assignText(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Text", exc);
    }
  }

  /**
   * unassign Text on TextDiagramObject
   *
   * @param command UnAssignTextFromTextDiagramObjectCommand
   */
  @PutMapping("/unAssignText")
  public void unAssignText(
      @RequestBody(required = true) UnAssignTextFromTextDiagramObjectCommand command) {
    try {
      TextDiagramObjectBusinessDelegate.getTextDiagramObjectInstance().unAssignText(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Text", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected TextDiagramObject textDiagramObject = null;
  private static final Logger LOGGER =
      Logger.getLogger(TextDiagramObjectCommandRestController.class.getName());
}
