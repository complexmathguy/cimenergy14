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
 * Implements Spring Controller command CQRS processing for entity ExcSEXS.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcSEXS")
public class ExcSEXSCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a ExcSEXS. if not key provided, calls create, otherwise calls save
   *
   * @param ExcSEXS excSEXS
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateExcSEXSCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture = ExcSEXSBusinessDelegate.getExcSEXSInstance().createExcSEXS(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a ExcSEXS. if no key provided, calls create, otherwise calls save
   *
   * @param ExcSEXS excSEXS
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateExcSEXSCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateExcSEXSCommand
      // -----------------------------------------------
      completableFuture = ExcSEXSBusinessDelegate.getExcSEXSInstance().updateExcSEXS(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "ExcSEXSController:update() - successfully update ExcSEXS - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a ExcSEXS entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID excSEXSId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteExcSEXSCommand command = new DeleteExcSEXSCommand(excSEXSId);

    try {
      ExcSEXSBusinessDelegate delegate = ExcSEXSBusinessDelegate.getExcSEXSInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(Level.WARNING, "Successfully deleted ExcSEXS with key " + command.getExcSEXSId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Efdmax on ExcSEXS
   *
   * @param command AssignEfdmaxToExcSEXSCommand
   */
  @PutMapping("/assignEfdmax")
  public void assignEfdmax(@RequestBody AssignEfdmaxToExcSEXSCommand command) {
    try {
      ExcSEXSBusinessDelegate.getExcSEXSInstance().assignEfdmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Efdmax", exc);
    }
  }

  /**
   * unassign Efdmax on ExcSEXS
   *
   * @param command UnAssignEfdmaxFromExcSEXSCommand
   */
  @PutMapping("/unAssignEfdmax")
  public void unAssignEfdmax(
      @RequestBody(required = true) UnAssignEfdmaxFromExcSEXSCommand command) {
    try {
      ExcSEXSBusinessDelegate.getExcSEXSInstance().unAssignEfdmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Efdmax", exc);
    }
  }

  /**
   * save Efdmin on ExcSEXS
   *
   * @param command AssignEfdminToExcSEXSCommand
   */
  @PutMapping("/assignEfdmin")
  public void assignEfdmin(@RequestBody AssignEfdminToExcSEXSCommand command) {
    try {
      ExcSEXSBusinessDelegate.getExcSEXSInstance().assignEfdmin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Efdmin", exc);
    }
  }

  /**
   * unassign Efdmin on ExcSEXS
   *
   * @param command UnAssignEfdminFromExcSEXSCommand
   */
  @PutMapping("/unAssignEfdmin")
  public void unAssignEfdmin(
      @RequestBody(required = true) UnAssignEfdminFromExcSEXSCommand command) {
    try {
      ExcSEXSBusinessDelegate.getExcSEXSInstance().unAssignEfdmin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Efdmin", exc);
    }
  }

  /**
   * save Emax on ExcSEXS
   *
   * @param command AssignEmaxToExcSEXSCommand
   */
  @PutMapping("/assignEmax")
  public void assignEmax(@RequestBody AssignEmaxToExcSEXSCommand command) {
    try {
      ExcSEXSBusinessDelegate.getExcSEXSInstance().assignEmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Emax", exc);
    }
  }

  /**
   * unassign Emax on ExcSEXS
   *
   * @param command UnAssignEmaxFromExcSEXSCommand
   */
  @PutMapping("/unAssignEmax")
  public void unAssignEmax(@RequestBody(required = true) UnAssignEmaxFromExcSEXSCommand command) {
    try {
      ExcSEXSBusinessDelegate.getExcSEXSInstance().unAssignEmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Emax", exc);
    }
  }

  /**
   * save Emin on ExcSEXS
   *
   * @param command AssignEminToExcSEXSCommand
   */
  @PutMapping("/assignEmin")
  public void assignEmin(@RequestBody AssignEminToExcSEXSCommand command) {
    try {
      ExcSEXSBusinessDelegate.getExcSEXSInstance().assignEmin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Emin", exc);
    }
  }

  /**
   * unassign Emin on ExcSEXS
   *
   * @param command UnAssignEminFromExcSEXSCommand
   */
  @PutMapping("/unAssignEmin")
  public void unAssignEmin(@RequestBody(required = true) UnAssignEminFromExcSEXSCommand command) {
    try {
      ExcSEXSBusinessDelegate.getExcSEXSInstance().unAssignEmin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Emin", exc);
    }
  }

  /**
   * save K on ExcSEXS
   *
   * @param command AssignKToExcSEXSCommand
   */
  @PutMapping("/assignK")
  public void assignK(@RequestBody AssignKToExcSEXSCommand command) {
    try {
      ExcSEXSBusinessDelegate.getExcSEXSInstance().assignK(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign K", exc);
    }
  }

  /**
   * unassign K on ExcSEXS
   *
   * @param command UnAssignKFromExcSEXSCommand
   */
  @PutMapping("/unAssignK")
  public void unAssignK(@RequestBody(required = true) UnAssignKFromExcSEXSCommand command) {
    try {
      ExcSEXSBusinessDelegate.getExcSEXSInstance().unAssignK(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign K", exc);
    }
  }

  /**
   * save Kc on ExcSEXS
   *
   * @param command AssignKcToExcSEXSCommand
   */
  @PutMapping("/assignKc")
  public void assignKc(@RequestBody AssignKcToExcSEXSCommand command) {
    try {
      ExcSEXSBusinessDelegate.getExcSEXSInstance().assignKc(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kc", exc);
    }
  }

  /**
   * unassign Kc on ExcSEXS
   *
   * @param command UnAssignKcFromExcSEXSCommand
   */
  @PutMapping("/unAssignKc")
  public void unAssignKc(@RequestBody(required = true) UnAssignKcFromExcSEXSCommand command) {
    try {
      ExcSEXSBusinessDelegate.getExcSEXSInstance().unAssignKc(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kc", exc);
    }
  }

  /**
   * save Tatb on ExcSEXS
   *
   * @param command AssignTatbToExcSEXSCommand
   */
  @PutMapping("/assignTatb")
  public void assignTatb(@RequestBody AssignTatbToExcSEXSCommand command) {
    try {
      ExcSEXSBusinessDelegate.getExcSEXSInstance().assignTatb(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tatb", exc);
    }
  }

  /**
   * unassign Tatb on ExcSEXS
   *
   * @param command UnAssignTatbFromExcSEXSCommand
   */
  @PutMapping("/unAssignTatb")
  public void unAssignTatb(@RequestBody(required = true) UnAssignTatbFromExcSEXSCommand command) {
    try {
      ExcSEXSBusinessDelegate.getExcSEXSInstance().unAssignTatb(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tatb", exc);
    }
  }

  /**
   * save Tb on ExcSEXS
   *
   * @param command AssignTbToExcSEXSCommand
   */
  @PutMapping("/assignTb")
  public void assignTb(@RequestBody AssignTbToExcSEXSCommand command) {
    try {
      ExcSEXSBusinessDelegate.getExcSEXSInstance().assignTb(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tb", exc);
    }
  }

  /**
   * unassign Tb on ExcSEXS
   *
   * @param command UnAssignTbFromExcSEXSCommand
   */
  @PutMapping("/unAssignTb")
  public void unAssignTb(@RequestBody(required = true) UnAssignTbFromExcSEXSCommand command) {
    try {
      ExcSEXSBusinessDelegate.getExcSEXSInstance().unAssignTb(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tb", exc);
    }
  }

  /**
   * save Tc on ExcSEXS
   *
   * @param command AssignTcToExcSEXSCommand
   */
  @PutMapping("/assignTc")
  public void assignTc(@RequestBody AssignTcToExcSEXSCommand command) {
    try {
      ExcSEXSBusinessDelegate.getExcSEXSInstance().assignTc(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tc", exc);
    }
  }

  /**
   * unassign Tc on ExcSEXS
   *
   * @param command UnAssignTcFromExcSEXSCommand
   */
  @PutMapping("/unAssignTc")
  public void unAssignTc(@RequestBody(required = true) UnAssignTcFromExcSEXSCommand command) {
    try {
      ExcSEXSBusinessDelegate.getExcSEXSInstance().unAssignTc(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tc", exc);
    }
  }

  /**
   * save Te on ExcSEXS
   *
   * @param command AssignTeToExcSEXSCommand
   */
  @PutMapping("/assignTe")
  public void assignTe(@RequestBody AssignTeToExcSEXSCommand command) {
    try {
      ExcSEXSBusinessDelegate.getExcSEXSInstance().assignTe(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Te", exc);
    }
  }

  /**
   * unassign Te on ExcSEXS
   *
   * @param command UnAssignTeFromExcSEXSCommand
   */
  @PutMapping("/unAssignTe")
  public void unAssignTe(@RequestBody(required = true) UnAssignTeFromExcSEXSCommand command) {
    try {
      ExcSEXSBusinessDelegate.getExcSEXSInstance().unAssignTe(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Te", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected ExcSEXS excSEXS = null;
  private static final Logger LOGGER =
      Logger.getLogger(ExcSEXSCommandRestController.class.getName());
}
