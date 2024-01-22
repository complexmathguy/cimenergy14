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
 * Implements Spring Controller command CQRS processing for entity TransformerEnd.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/TransformerEnd")
public class TransformerEndCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a TransformerEnd. if not key provided, calls create, otherwise calls save
   *
   * @param TransformerEnd transformerEnd
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateTransformerEndCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          TransformerEndBusinessDelegate.getTransformerEndInstance().createTransformerEnd(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a TransformerEnd. if no key provided, calls create, otherwise calls save
   *
   * @param TransformerEnd transformerEnd
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateTransformerEndCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateTransformerEndCommand
      // -----------------------------------------------
      completableFuture =
          TransformerEndBusinessDelegate.getTransformerEndInstance().updateTransformerEnd(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "TransformerEndController:update() - successfully update TransformerEnd - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a TransformerEnd entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID transformerEndId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteTransformerEndCommand command = new DeleteTransformerEndCommand(transformerEndId);

    try {
      TransformerEndBusinessDelegate delegate =
          TransformerEndBusinessDelegate.getTransformerEndInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted TransformerEnd with key " + command.getTransformerEndId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save EndNumber on TransformerEnd
   *
   * @param command AssignEndNumberToTransformerEndCommand
   */
  @PutMapping("/assignEndNumber")
  public void assignEndNumber(@RequestBody AssignEndNumberToTransformerEndCommand command) {
    try {
      TransformerEndBusinessDelegate.getTransformerEndInstance().assignEndNumber(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign EndNumber", exc);
    }
  }

  /**
   * unassign EndNumber on TransformerEnd
   *
   * @param command UnAssignEndNumberFromTransformerEndCommand
   */
  @PutMapping("/unAssignEndNumber")
  public void unAssignEndNumber(
      @RequestBody(required = true) UnAssignEndNumberFromTransformerEndCommand command) {
    try {
      TransformerEndBusinessDelegate.getTransformerEndInstance().unAssignEndNumber(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign EndNumber", exc);
    }
  }

  /**
   * save Grounded on TransformerEnd
   *
   * @param command AssignGroundedToTransformerEndCommand
   */
  @PutMapping("/assignGrounded")
  public void assignGrounded(@RequestBody AssignGroundedToTransformerEndCommand command) {
    try {
      TransformerEndBusinessDelegate.getTransformerEndInstance().assignGrounded(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Grounded", exc);
    }
  }

  /**
   * unassign Grounded on TransformerEnd
   *
   * @param command UnAssignGroundedFromTransformerEndCommand
   */
  @PutMapping("/unAssignGrounded")
  public void unAssignGrounded(
      @RequestBody(required = true) UnAssignGroundedFromTransformerEndCommand command) {
    try {
      TransformerEndBusinessDelegate.getTransformerEndInstance().unAssignGrounded(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Grounded", exc);
    }
  }

  /**
   * save Rground on TransformerEnd
   *
   * @param command AssignRgroundToTransformerEndCommand
   */
  @PutMapping("/assignRground")
  public void assignRground(@RequestBody AssignRgroundToTransformerEndCommand command) {
    try {
      TransformerEndBusinessDelegate.getTransformerEndInstance().assignRground(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Rground", exc);
    }
  }

  /**
   * unassign Rground on TransformerEnd
   *
   * @param command UnAssignRgroundFromTransformerEndCommand
   */
  @PutMapping("/unAssignRground")
  public void unAssignRground(
      @RequestBody(required = true) UnAssignRgroundFromTransformerEndCommand command) {
    try {
      TransformerEndBusinessDelegate.getTransformerEndInstance().unAssignRground(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Rground", exc);
    }
  }

  /**
   * save Xground on TransformerEnd
   *
   * @param command AssignXgroundToTransformerEndCommand
   */
  @PutMapping("/assignXground")
  public void assignXground(@RequestBody AssignXgroundToTransformerEndCommand command) {
    try {
      TransformerEndBusinessDelegate.getTransformerEndInstance().assignXground(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Xground", exc);
    }
  }

  /**
   * unassign Xground on TransformerEnd
   *
   * @param command UnAssignXgroundFromTransformerEndCommand
   */
  @PutMapping("/unAssignXground")
  public void unAssignXground(
      @RequestBody(required = true) UnAssignXgroundFromTransformerEndCommand command) {
    try {
      TransformerEndBusinessDelegate.getTransformerEndInstance().unAssignXground(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Xground", exc);
    }
  }

  /**
   * save TransformerEnds on TransformerEnd
   *
   * @param command AssignTransformerEndsToTransformerEndCommand
   */
  @PutMapping("/addToTransformerEnds")
  public void addToTransformerEnds(
      @RequestBody(required = true) AssignTransformerEndsToTransformerEndCommand command) {
    try {
      TransformerEndBusinessDelegate.getTransformerEndInstance().addToTransformerEnds(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to add to Set TransformerEnds", exc);
    }
  }

  /**
   * remove TransformerEnds on TransformerEnd
   *
   * @param command RemoveTransformerEndsFromTransformerEndCommand
   */
  @PutMapping("/removeFromTransformerEnds")
  public void removeFromTransformerEnds(
      @RequestBody(required = true) RemoveTransformerEndsFromTransformerEndCommand command) {
    try {
      TransformerEndBusinessDelegate.getTransformerEndInstance().removeFromTransformerEnds(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to remove from Set TransformerEnds", exc);
    }
  }

  /**
   * save TransformerEnd on TransformerEnd
   *
   * @param command AssignTransformerEndToTransformerEndCommand
   */
  @PutMapping("/addToTransformerEnd")
  public void addToTransformerEnd(
      @RequestBody(required = true) AssignTransformerEndToTransformerEndCommand command) {
    try {
      TransformerEndBusinessDelegate.getTransformerEndInstance().addToTransformerEnd(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to add to Set TransformerEnd", exc);
    }
  }

  /**
   * remove TransformerEnd on TransformerEnd
   *
   * @param command RemoveTransformerEndFromTransformerEndCommand
   */
  @PutMapping("/removeFromTransformerEnd")
  public void removeFromTransformerEnd(
      @RequestBody(required = true) RemoveTransformerEndFromTransformerEndCommand command) {
    try {
      TransformerEndBusinessDelegate.getTransformerEndInstance().removeFromTransformerEnd(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to remove from Set TransformerEnd", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected TransformerEnd transformerEnd = null;
  private static final Logger LOGGER =
      Logger.getLogger(TransformerEndCommandRestController.class.getName());
}
