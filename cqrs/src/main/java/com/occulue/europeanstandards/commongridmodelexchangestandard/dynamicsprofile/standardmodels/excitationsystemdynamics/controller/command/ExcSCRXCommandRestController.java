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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.excitationsystemdynamics.controller.command;

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
 * Implements Spring Controller command CQRS processing for entity ExcSCRX.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcSCRX")
public class ExcSCRXCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a ExcSCRX. if not key provided, calls create, otherwise calls save
   *
   * @param ExcSCRX excSCRX
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateExcSCRXCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture = ExcSCRXBusinessDelegate.getExcSCRXInstance().createExcSCRX(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a ExcSCRX. if no key provided, calls create, otherwise calls save
   *
   * @param ExcSCRX excSCRX
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateExcSCRXCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateExcSCRXCommand
      // -----------------------------------------------
      completableFuture = ExcSCRXBusinessDelegate.getExcSCRXInstance().updateExcSCRX(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "ExcSCRXController:update() - successfully update ExcSCRX - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a ExcSCRX entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID excSCRXId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteExcSCRXCommand command = new DeleteExcSCRXCommand(excSCRXId);

    try {
      ExcSCRXBusinessDelegate delegate = ExcSCRXBusinessDelegate.getExcSCRXInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(Level.WARNING, "Successfully deleted ExcSCRX with key " + command.getExcSCRXId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Cswitch on ExcSCRX
   *
   * @param command AssignCswitchToExcSCRXCommand
   */
  @PutMapping("/assignCswitch")
  public void assignCswitch(@RequestBody AssignCswitchToExcSCRXCommand command) {
    try {
      ExcSCRXBusinessDelegate.getExcSCRXInstance().assignCswitch(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Cswitch", exc);
    }
  }

  /**
   * unassign Cswitch on ExcSCRX
   *
   * @param command UnAssignCswitchFromExcSCRXCommand
   */
  @PutMapping("/unAssignCswitch")
  public void unAssignCswitch(
      @RequestBody(required = true) UnAssignCswitchFromExcSCRXCommand command) {
    try {
      ExcSCRXBusinessDelegate.getExcSCRXInstance().unAssignCswitch(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Cswitch", exc);
    }
  }

  /**
   * save Emax on ExcSCRX
   *
   * @param command AssignEmaxToExcSCRXCommand
   */
  @PutMapping("/assignEmax")
  public void assignEmax(@RequestBody AssignEmaxToExcSCRXCommand command) {
    try {
      ExcSCRXBusinessDelegate.getExcSCRXInstance().assignEmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Emax", exc);
    }
  }

  /**
   * unassign Emax on ExcSCRX
   *
   * @param command UnAssignEmaxFromExcSCRXCommand
   */
  @PutMapping("/unAssignEmax")
  public void unAssignEmax(@RequestBody(required = true) UnAssignEmaxFromExcSCRXCommand command) {
    try {
      ExcSCRXBusinessDelegate.getExcSCRXInstance().unAssignEmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Emax", exc);
    }
  }

  /**
   * save Emin on ExcSCRX
   *
   * @param command AssignEminToExcSCRXCommand
   */
  @PutMapping("/assignEmin")
  public void assignEmin(@RequestBody AssignEminToExcSCRXCommand command) {
    try {
      ExcSCRXBusinessDelegate.getExcSCRXInstance().assignEmin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Emin", exc);
    }
  }

  /**
   * unassign Emin on ExcSCRX
   *
   * @param command UnAssignEminFromExcSCRXCommand
   */
  @PutMapping("/unAssignEmin")
  public void unAssignEmin(@RequestBody(required = true) UnAssignEminFromExcSCRXCommand command) {
    try {
      ExcSCRXBusinessDelegate.getExcSCRXInstance().unAssignEmin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Emin", exc);
    }
  }

  /**
   * save K on ExcSCRX
   *
   * @param command AssignKToExcSCRXCommand
   */
  @PutMapping("/assignK")
  public void assignK(@RequestBody AssignKToExcSCRXCommand command) {
    try {
      ExcSCRXBusinessDelegate.getExcSCRXInstance().assignK(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign K", exc);
    }
  }

  /**
   * unassign K on ExcSCRX
   *
   * @param command UnAssignKFromExcSCRXCommand
   */
  @PutMapping("/unAssignK")
  public void unAssignK(@RequestBody(required = true) UnAssignKFromExcSCRXCommand command) {
    try {
      ExcSCRXBusinessDelegate.getExcSCRXInstance().unAssignK(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign K", exc);
    }
  }

  /**
   * save Rcrfd on ExcSCRX
   *
   * @param command AssignRcrfdToExcSCRXCommand
   */
  @PutMapping("/assignRcrfd")
  public void assignRcrfd(@RequestBody AssignRcrfdToExcSCRXCommand command) {
    try {
      ExcSCRXBusinessDelegate.getExcSCRXInstance().assignRcrfd(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Rcrfd", exc);
    }
  }

  /**
   * unassign Rcrfd on ExcSCRX
   *
   * @param command UnAssignRcrfdFromExcSCRXCommand
   */
  @PutMapping("/unAssignRcrfd")
  public void unAssignRcrfd(@RequestBody(required = true) UnAssignRcrfdFromExcSCRXCommand command) {
    try {
      ExcSCRXBusinessDelegate.getExcSCRXInstance().unAssignRcrfd(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Rcrfd", exc);
    }
  }

  /**
   * save Tatb on ExcSCRX
   *
   * @param command AssignTatbToExcSCRXCommand
   */
  @PutMapping("/assignTatb")
  public void assignTatb(@RequestBody AssignTatbToExcSCRXCommand command) {
    try {
      ExcSCRXBusinessDelegate.getExcSCRXInstance().assignTatb(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tatb", exc);
    }
  }

  /**
   * unassign Tatb on ExcSCRX
   *
   * @param command UnAssignTatbFromExcSCRXCommand
   */
  @PutMapping("/unAssignTatb")
  public void unAssignTatb(@RequestBody(required = true) UnAssignTatbFromExcSCRXCommand command) {
    try {
      ExcSCRXBusinessDelegate.getExcSCRXInstance().unAssignTatb(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tatb", exc);
    }
  }

  /**
   * save Tb on ExcSCRX
   *
   * @param command AssignTbToExcSCRXCommand
   */
  @PutMapping("/assignTb")
  public void assignTb(@RequestBody AssignTbToExcSCRXCommand command) {
    try {
      ExcSCRXBusinessDelegate.getExcSCRXInstance().assignTb(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tb", exc);
    }
  }

  /**
   * unassign Tb on ExcSCRX
   *
   * @param command UnAssignTbFromExcSCRXCommand
   */
  @PutMapping("/unAssignTb")
  public void unAssignTb(@RequestBody(required = true) UnAssignTbFromExcSCRXCommand command) {
    try {
      ExcSCRXBusinessDelegate.getExcSCRXInstance().unAssignTb(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tb", exc);
    }
  }

  /**
   * save Te on ExcSCRX
   *
   * @param command AssignTeToExcSCRXCommand
   */
  @PutMapping("/assignTe")
  public void assignTe(@RequestBody AssignTeToExcSCRXCommand command) {
    try {
      ExcSCRXBusinessDelegate.getExcSCRXInstance().assignTe(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Te", exc);
    }
  }

  /**
   * unassign Te on ExcSCRX
   *
   * @param command UnAssignTeFromExcSCRXCommand
   */
  @PutMapping("/unAssignTe")
  public void unAssignTe(@RequestBody(required = true) UnAssignTeFromExcSCRXCommand command) {
    try {
      ExcSCRXBusinessDelegate.getExcSCRXInstance().unAssignTe(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Te", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected ExcSCRX excSCRX = null;
  private static final Logger LOGGER =
      Logger.getLogger(ExcSCRXCommandRestController.class.getName());
}
