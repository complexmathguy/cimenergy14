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
 * Implements Spring Controller command CQRS processing for entity WindProtectionIEC.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/WindProtectionIEC")
public class WindProtectionIECCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a WindProtectionIEC. if not key provided, calls create, otherwise calls save
   *
   * @param WindProtectionIEC windProtectionIEC
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateWindProtectionIECCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          WindProtectionIECBusinessDelegate.getWindProtectionIECInstance()
              .createWindProtectionIEC(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a WindProtectionIEC. if no key provided, calls create, otherwise calls save
   *
   * @param WindProtectionIEC windProtectionIEC
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateWindProtectionIECCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateWindProtectionIECCommand
      // -----------------------------------------------
      completableFuture =
          WindProtectionIECBusinessDelegate.getWindProtectionIECInstance()
              .updateWindProtectionIEC(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "WindProtectionIECController:update() - successfully update WindProtectionIEC - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a WindProtectionIEC entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID windProtectionIECId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteWindProtectionIECCommand command =
        new DeleteWindProtectionIECCommand(windProtectionIECId);

    try {
      WindProtectionIECBusinessDelegate delegate =
          WindProtectionIECBusinessDelegate.getWindProtectionIECInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted WindProtectionIEC with key " + command.getWindProtectionIECId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Fover on WindProtectionIEC
   *
   * @param command AssignFoverToWindProtectionIECCommand
   */
  @PutMapping("/assignFover")
  public void assignFover(@RequestBody AssignFoverToWindProtectionIECCommand command) {
    try {
      WindProtectionIECBusinessDelegate.getWindProtectionIECInstance().assignFover(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Fover", exc);
    }
  }

  /**
   * unassign Fover on WindProtectionIEC
   *
   * @param command UnAssignFoverFromWindProtectionIECCommand
   */
  @PutMapping("/unAssignFover")
  public void unAssignFover(
      @RequestBody(required = true) UnAssignFoverFromWindProtectionIECCommand command) {
    try {
      WindProtectionIECBusinessDelegate.getWindProtectionIECInstance().unAssignFover(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Fover", exc);
    }
  }

  /**
   * save Funder on WindProtectionIEC
   *
   * @param command AssignFunderToWindProtectionIECCommand
   */
  @PutMapping("/assignFunder")
  public void assignFunder(@RequestBody AssignFunderToWindProtectionIECCommand command) {
    try {
      WindProtectionIECBusinessDelegate.getWindProtectionIECInstance().assignFunder(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Funder", exc);
    }
  }

  /**
   * unassign Funder on WindProtectionIEC
   *
   * @param command UnAssignFunderFromWindProtectionIECCommand
   */
  @PutMapping("/unAssignFunder")
  public void unAssignFunder(
      @RequestBody(required = true) UnAssignFunderFromWindProtectionIECCommand command) {
    try {
      WindProtectionIECBusinessDelegate.getWindProtectionIECInstance().unAssignFunder(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Funder", exc);
    }
  }

  /**
   * save Tfover on WindProtectionIEC
   *
   * @param command AssignTfoverToWindProtectionIECCommand
   */
  @PutMapping("/assignTfover")
  public void assignTfover(@RequestBody AssignTfoverToWindProtectionIECCommand command) {
    try {
      WindProtectionIECBusinessDelegate.getWindProtectionIECInstance().assignTfover(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tfover", exc);
    }
  }

  /**
   * unassign Tfover on WindProtectionIEC
   *
   * @param command UnAssignTfoverFromWindProtectionIECCommand
   */
  @PutMapping("/unAssignTfover")
  public void unAssignTfover(
      @RequestBody(required = true) UnAssignTfoverFromWindProtectionIECCommand command) {
    try {
      WindProtectionIECBusinessDelegate.getWindProtectionIECInstance().unAssignTfover(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tfover", exc);
    }
  }

  /**
   * save Tfunder on WindProtectionIEC
   *
   * @param command AssignTfunderToWindProtectionIECCommand
   */
  @PutMapping("/assignTfunder")
  public void assignTfunder(@RequestBody AssignTfunderToWindProtectionIECCommand command) {
    try {
      WindProtectionIECBusinessDelegate.getWindProtectionIECInstance().assignTfunder(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tfunder", exc);
    }
  }

  /**
   * unassign Tfunder on WindProtectionIEC
   *
   * @param command UnAssignTfunderFromWindProtectionIECCommand
   */
  @PutMapping("/unAssignTfunder")
  public void unAssignTfunder(
      @RequestBody(required = true) UnAssignTfunderFromWindProtectionIECCommand command) {
    try {
      WindProtectionIECBusinessDelegate.getWindProtectionIECInstance().unAssignTfunder(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tfunder", exc);
    }
  }

  /**
   * save Tuover on WindProtectionIEC
   *
   * @param command AssignTuoverToWindProtectionIECCommand
   */
  @PutMapping("/assignTuover")
  public void assignTuover(@RequestBody AssignTuoverToWindProtectionIECCommand command) {
    try {
      WindProtectionIECBusinessDelegate.getWindProtectionIECInstance().assignTuover(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tuover", exc);
    }
  }

  /**
   * unassign Tuover on WindProtectionIEC
   *
   * @param command UnAssignTuoverFromWindProtectionIECCommand
   */
  @PutMapping("/unAssignTuover")
  public void unAssignTuover(
      @RequestBody(required = true) UnAssignTuoverFromWindProtectionIECCommand command) {
    try {
      WindProtectionIECBusinessDelegate.getWindProtectionIECInstance().unAssignTuover(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tuover", exc);
    }
  }

  /**
   * save Tuunder on WindProtectionIEC
   *
   * @param command AssignTuunderToWindProtectionIECCommand
   */
  @PutMapping("/assignTuunder")
  public void assignTuunder(@RequestBody AssignTuunderToWindProtectionIECCommand command) {
    try {
      WindProtectionIECBusinessDelegate.getWindProtectionIECInstance().assignTuunder(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tuunder", exc);
    }
  }

  /**
   * unassign Tuunder on WindProtectionIEC
   *
   * @param command UnAssignTuunderFromWindProtectionIECCommand
   */
  @PutMapping("/unAssignTuunder")
  public void unAssignTuunder(
      @RequestBody(required = true) UnAssignTuunderFromWindProtectionIECCommand command) {
    try {
      WindProtectionIECBusinessDelegate.getWindProtectionIECInstance().unAssignTuunder(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tuunder", exc);
    }
  }

  /**
   * save Uover on WindProtectionIEC
   *
   * @param command AssignUoverToWindProtectionIECCommand
   */
  @PutMapping("/assignUover")
  public void assignUover(@RequestBody AssignUoverToWindProtectionIECCommand command) {
    try {
      WindProtectionIECBusinessDelegate.getWindProtectionIECInstance().assignUover(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Uover", exc);
    }
  }

  /**
   * unassign Uover on WindProtectionIEC
   *
   * @param command UnAssignUoverFromWindProtectionIECCommand
   */
  @PutMapping("/unAssignUover")
  public void unAssignUover(
      @RequestBody(required = true) UnAssignUoverFromWindProtectionIECCommand command) {
    try {
      WindProtectionIECBusinessDelegate.getWindProtectionIECInstance().unAssignUover(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Uover", exc);
    }
  }

  /**
   * save Uunder on WindProtectionIEC
   *
   * @param command AssignUunderToWindProtectionIECCommand
   */
  @PutMapping("/assignUunder")
  public void assignUunder(@RequestBody AssignUunderToWindProtectionIECCommand command) {
    try {
      WindProtectionIECBusinessDelegate.getWindProtectionIECInstance().assignUunder(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Uunder", exc);
    }
  }

  /**
   * unassign Uunder on WindProtectionIEC
   *
   * @param command UnAssignUunderFromWindProtectionIECCommand
   */
  @PutMapping("/unAssignUunder")
  public void unAssignUunder(
      @RequestBody(required = true) UnAssignUunderFromWindProtectionIECCommand command) {
    try {
      WindProtectionIECBusinessDelegate.getWindProtectionIECInstance().unAssignUunder(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Uunder", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected WindProtectionIEC windProtectionIEC = null;
  private static final Logger LOGGER =
      Logger.getLogger(WindProtectionIECCommandRestController.class.getName());
}
