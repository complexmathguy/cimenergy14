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
 * Implements Spring Controller command CQRS processing for entity WindContRotorRIEC.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/WindContRotorRIEC")
public class WindContRotorRIECCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a WindContRotorRIEC. if not key provided, calls create, otherwise calls save
   *
   * @param WindContRotorRIEC windContRotorRIEC
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateWindContRotorRIECCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          WindContRotorRIECBusinessDelegate.getWindContRotorRIECInstance()
              .createWindContRotorRIEC(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a WindContRotorRIEC. if no key provided, calls create, otherwise calls save
   *
   * @param WindContRotorRIEC windContRotorRIEC
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateWindContRotorRIECCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateWindContRotorRIECCommand
      // -----------------------------------------------
      completableFuture =
          WindContRotorRIECBusinessDelegate.getWindContRotorRIECInstance()
              .updateWindContRotorRIEC(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "WindContRotorRIECController:update() - successfully update WindContRotorRIEC - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a WindContRotorRIEC entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID windContRotorRIECId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteWindContRotorRIECCommand command =
        new DeleteWindContRotorRIECCommand(windContRotorRIECId);

    try {
      WindContRotorRIECBusinessDelegate delegate =
          WindContRotorRIECBusinessDelegate.getWindContRotorRIECInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted WindContRotorRIEC with key " + command.getWindContRotorRIECId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Kirr on WindContRotorRIEC
   *
   * @param command AssignKirrToWindContRotorRIECCommand
   */
  @PutMapping("/assignKirr")
  public void assignKirr(@RequestBody AssignKirrToWindContRotorRIECCommand command) {
    try {
      WindContRotorRIECBusinessDelegate.getWindContRotorRIECInstance().assignKirr(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kirr", exc);
    }
  }

  /**
   * unassign Kirr on WindContRotorRIEC
   *
   * @param command UnAssignKirrFromWindContRotorRIECCommand
   */
  @PutMapping("/unAssignKirr")
  public void unAssignKirr(
      @RequestBody(required = true) UnAssignKirrFromWindContRotorRIECCommand command) {
    try {
      WindContRotorRIECBusinessDelegate.getWindContRotorRIECInstance().unAssignKirr(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kirr", exc);
    }
  }

  /**
   * save Komegafilt on WindContRotorRIEC
   *
   * @param command AssignKomegafiltToWindContRotorRIECCommand
   */
  @PutMapping("/assignKomegafilt")
  public void assignKomegafilt(@RequestBody AssignKomegafiltToWindContRotorRIECCommand command) {
    try {
      WindContRotorRIECBusinessDelegate.getWindContRotorRIECInstance().assignKomegafilt(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Komegafilt", exc);
    }
  }

  /**
   * unassign Komegafilt on WindContRotorRIEC
   *
   * @param command UnAssignKomegafiltFromWindContRotorRIECCommand
   */
  @PutMapping("/unAssignKomegafilt")
  public void unAssignKomegafilt(
      @RequestBody(required = true) UnAssignKomegafiltFromWindContRotorRIECCommand command) {
    try {
      WindContRotorRIECBusinessDelegate.getWindContRotorRIECInstance().unAssignKomegafilt(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Komegafilt", exc);
    }
  }

  /**
   * save Kpfilt on WindContRotorRIEC
   *
   * @param command AssignKpfiltToWindContRotorRIECCommand
   */
  @PutMapping("/assignKpfilt")
  public void assignKpfilt(@RequestBody AssignKpfiltToWindContRotorRIECCommand command) {
    try {
      WindContRotorRIECBusinessDelegate.getWindContRotorRIECInstance().assignKpfilt(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kpfilt", exc);
    }
  }

  /**
   * unassign Kpfilt on WindContRotorRIEC
   *
   * @param command UnAssignKpfiltFromWindContRotorRIECCommand
   */
  @PutMapping("/unAssignKpfilt")
  public void unAssignKpfilt(
      @RequestBody(required = true) UnAssignKpfiltFromWindContRotorRIECCommand command) {
    try {
      WindContRotorRIECBusinessDelegate.getWindContRotorRIECInstance().unAssignKpfilt(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kpfilt", exc);
    }
  }

  /**
   * save Kprr on WindContRotorRIEC
   *
   * @param command AssignKprrToWindContRotorRIECCommand
   */
  @PutMapping("/assignKprr")
  public void assignKprr(@RequestBody AssignKprrToWindContRotorRIECCommand command) {
    try {
      WindContRotorRIECBusinessDelegate.getWindContRotorRIECInstance().assignKprr(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kprr", exc);
    }
  }

  /**
   * unassign Kprr on WindContRotorRIEC
   *
   * @param command UnAssignKprrFromWindContRotorRIECCommand
   */
  @PutMapping("/unAssignKprr")
  public void unAssignKprr(
      @RequestBody(required = true) UnAssignKprrFromWindContRotorRIECCommand command) {
    try {
      WindContRotorRIECBusinessDelegate.getWindContRotorRIECInstance().unAssignKprr(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kprr", exc);
    }
  }

  /**
   * save Rmax on WindContRotorRIEC
   *
   * @param command AssignRmaxToWindContRotorRIECCommand
   */
  @PutMapping("/assignRmax")
  public void assignRmax(@RequestBody AssignRmaxToWindContRotorRIECCommand command) {
    try {
      WindContRotorRIECBusinessDelegate.getWindContRotorRIECInstance().assignRmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Rmax", exc);
    }
  }

  /**
   * unassign Rmax on WindContRotorRIEC
   *
   * @param command UnAssignRmaxFromWindContRotorRIECCommand
   */
  @PutMapping("/unAssignRmax")
  public void unAssignRmax(
      @RequestBody(required = true) UnAssignRmaxFromWindContRotorRIECCommand command) {
    try {
      WindContRotorRIECBusinessDelegate.getWindContRotorRIECInstance().unAssignRmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Rmax", exc);
    }
  }

  /**
   * save Rmin on WindContRotorRIEC
   *
   * @param command AssignRminToWindContRotorRIECCommand
   */
  @PutMapping("/assignRmin")
  public void assignRmin(@RequestBody AssignRminToWindContRotorRIECCommand command) {
    try {
      WindContRotorRIECBusinessDelegate.getWindContRotorRIECInstance().assignRmin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Rmin", exc);
    }
  }

  /**
   * unassign Rmin on WindContRotorRIEC
   *
   * @param command UnAssignRminFromWindContRotorRIECCommand
   */
  @PutMapping("/unAssignRmin")
  public void unAssignRmin(
      @RequestBody(required = true) UnAssignRminFromWindContRotorRIECCommand command) {
    try {
      WindContRotorRIECBusinessDelegate.getWindContRotorRIECInstance().unAssignRmin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Rmin", exc);
    }
  }

  /**
   * save Tomegafilt on WindContRotorRIEC
   *
   * @param command AssignTomegafiltToWindContRotorRIECCommand
   */
  @PutMapping("/assignTomegafilt")
  public void assignTomegafilt(@RequestBody AssignTomegafiltToWindContRotorRIECCommand command) {
    try {
      WindContRotorRIECBusinessDelegate.getWindContRotorRIECInstance().assignTomegafilt(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tomegafilt", exc);
    }
  }

  /**
   * unassign Tomegafilt on WindContRotorRIEC
   *
   * @param command UnAssignTomegafiltFromWindContRotorRIECCommand
   */
  @PutMapping("/unAssignTomegafilt")
  public void unAssignTomegafilt(
      @RequestBody(required = true) UnAssignTomegafiltFromWindContRotorRIECCommand command) {
    try {
      WindContRotorRIECBusinessDelegate.getWindContRotorRIECInstance().unAssignTomegafilt(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tomegafilt", exc);
    }
  }

  /**
   * save Tpfilt on WindContRotorRIEC
   *
   * @param command AssignTpfiltToWindContRotorRIECCommand
   */
  @PutMapping("/assignTpfilt")
  public void assignTpfilt(@RequestBody AssignTpfiltToWindContRotorRIECCommand command) {
    try {
      WindContRotorRIECBusinessDelegate.getWindContRotorRIECInstance().assignTpfilt(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tpfilt", exc);
    }
  }

  /**
   * unassign Tpfilt on WindContRotorRIEC
   *
   * @param command UnAssignTpfiltFromWindContRotorRIECCommand
   */
  @PutMapping("/unAssignTpfilt")
  public void unAssignTpfilt(
      @RequestBody(required = true) UnAssignTpfiltFromWindContRotorRIECCommand command) {
    try {
      WindContRotorRIECBusinessDelegate.getWindContRotorRIECInstance().unAssignTpfilt(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tpfilt", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected WindContRotorRIEC windContRotorRIEC = null;
  private static final Logger LOGGER =
      Logger.getLogger(WindContRotorRIECCommandRestController.class.getName());
}
