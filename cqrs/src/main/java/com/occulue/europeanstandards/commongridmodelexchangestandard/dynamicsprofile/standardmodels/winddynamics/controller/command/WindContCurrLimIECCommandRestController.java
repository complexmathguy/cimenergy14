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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.winddynamics.controller.command;

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
 * Implements Spring Controller command CQRS processing for entity WindContCurrLimIEC.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/WindContCurrLimIEC")
public class WindContCurrLimIECCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a WindContCurrLimIEC. if not key provided, calls create, otherwise calls save
   *
   * @param WindContCurrLimIEC windContCurrLimIEC
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateWindContCurrLimIECCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          WindContCurrLimIECBusinessDelegate.getWindContCurrLimIECInstance()
              .createWindContCurrLimIEC(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a WindContCurrLimIEC. if no key provided, calls create, otherwise calls save
   *
   * @param WindContCurrLimIEC windContCurrLimIEC
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateWindContCurrLimIECCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateWindContCurrLimIECCommand
      // -----------------------------------------------
      completableFuture =
          WindContCurrLimIECBusinessDelegate.getWindContCurrLimIECInstance()
              .updateWindContCurrLimIEC(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "WindContCurrLimIECController:update() - successfully update WindContCurrLimIEC - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a WindContCurrLimIEC entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID windContCurrLimIECId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteWindContCurrLimIECCommand command =
        new DeleteWindContCurrLimIECCommand(windContCurrLimIECId);

    try {
      WindContCurrLimIECBusinessDelegate delegate =
          WindContCurrLimIECBusinessDelegate.getWindContCurrLimIECInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted WindContCurrLimIEC with key " + command.getWindContCurrLimIECId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Imax on WindContCurrLimIEC
   *
   * @param command AssignImaxToWindContCurrLimIECCommand
   */
  @PutMapping("/assignImax")
  public void assignImax(@RequestBody AssignImaxToWindContCurrLimIECCommand command) {
    try {
      WindContCurrLimIECBusinessDelegate.getWindContCurrLimIECInstance().assignImax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Imax", exc);
    }
  }

  /**
   * unassign Imax on WindContCurrLimIEC
   *
   * @param command UnAssignImaxFromWindContCurrLimIECCommand
   */
  @PutMapping("/unAssignImax")
  public void unAssignImax(
      @RequestBody(required = true) UnAssignImaxFromWindContCurrLimIECCommand command) {
    try {
      WindContCurrLimIECBusinessDelegate.getWindContCurrLimIECInstance().unAssignImax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Imax", exc);
    }
  }

  /**
   * save Imaxdip on WindContCurrLimIEC
   *
   * @param command AssignImaxdipToWindContCurrLimIECCommand
   */
  @PutMapping("/assignImaxdip")
  public void assignImaxdip(@RequestBody AssignImaxdipToWindContCurrLimIECCommand command) {
    try {
      WindContCurrLimIECBusinessDelegate.getWindContCurrLimIECInstance().assignImaxdip(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Imaxdip", exc);
    }
  }

  /**
   * unassign Imaxdip on WindContCurrLimIEC
   *
   * @param command UnAssignImaxdipFromWindContCurrLimIECCommand
   */
  @PutMapping("/unAssignImaxdip")
  public void unAssignImaxdip(
      @RequestBody(required = true) UnAssignImaxdipFromWindContCurrLimIECCommand command) {
    try {
      WindContCurrLimIECBusinessDelegate.getWindContCurrLimIECInstance().unAssignImaxdip(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Imaxdip", exc);
    }
  }

  /**
   * save Mdfslim on WindContCurrLimIEC
   *
   * @param command AssignMdfslimToWindContCurrLimIECCommand
   */
  @PutMapping("/assignMdfslim")
  public void assignMdfslim(@RequestBody AssignMdfslimToWindContCurrLimIECCommand command) {
    try {
      WindContCurrLimIECBusinessDelegate.getWindContCurrLimIECInstance().assignMdfslim(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Mdfslim", exc);
    }
  }

  /**
   * unassign Mdfslim on WindContCurrLimIEC
   *
   * @param command UnAssignMdfslimFromWindContCurrLimIECCommand
   */
  @PutMapping("/unAssignMdfslim")
  public void unAssignMdfslim(
      @RequestBody(required = true) UnAssignMdfslimFromWindContCurrLimIECCommand command) {
    try {
      WindContCurrLimIECBusinessDelegate.getWindContCurrLimIECInstance().unAssignMdfslim(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Mdfslim", exc);
    }
  }

  /**
   * save Mqpri on WindContCurrLimIEC
   *
   * @param command AssignMqpriToWindContCurrLimIECCommand
   */
  @PutMapping("/assignMqpri")
  public void assignMqpri(@RequestBody AssignMqpriToWindContCurrLimIECCommand command) {
    try {
      WindContCurrLimIECBusinessDelegate.getWindContCurrLimIECInstance().assignMqpri(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Mqpri", exc);
    }
  }

  /**
   * unassign Mqpri on WindContCurrLimIEC
   *
   * @param command UnAssignMqpriFromWindContCurrLimIECCommand
   */
  @PutMapping("/unAssignMqpri")
  public void unAssignMqpri(
      @RequestBody(required = true) UnAssignMqpriFromWindContCurrLimIECCommand command) {
    try {
      WindContCurrLimIECBusinessDelegate.getWindContCurrLimIECInstance().unAssignMqpri(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Mqpri", exc);
    }
  }

  /**
   * save Tufilt on WindContCurrLimIEC
   *
   * @param command AssignTufiltToWindContCurrLimIECCommand
   */
  @PutMapping("/assignTufilt")
  public void assignTufilt(@RequestBody AssignTufiltToWindContCurrLimIECCommand command) {
    try {
      WindContCurrLimIECBusinessDelegate.getWindContCurrLimIECInstance().assignTufilt(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tufilt", exc);
    }
  }

  /**
   * unassign Tufilt on WindContCurrLimIEC
   *
   * @param command UnAssignTufiltFromWindContCurrLimIECCommand
   */
  @PutMapping("/unAssignTufilt")
  public void unAssignTufilt(
      @RequestBody(required = true) UnAssignTufiltFromWindContCurrLimIECCommand command) {
    try {
      WindContCurrLimIECBusinessDelegate.getWindContCurrLimIECInstance().unAssignTufilt(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tufilt", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected WindContCurrLimIEC windContCurrLimIEC = null;
  private static final Logger LOGGER =
      Logger.getLogger(WindContCurrLimIECCommandRestController.class.getName());
}
