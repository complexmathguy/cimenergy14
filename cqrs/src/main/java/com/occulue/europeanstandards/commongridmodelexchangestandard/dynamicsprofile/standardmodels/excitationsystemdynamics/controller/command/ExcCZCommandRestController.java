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
 * Implements Spring Controller command CQRS processing for entity ExcCZ.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcCZ")
public class ExcCZCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a ExcCZ. if not key provided, calls create, otherwise calls save
   *
   * @param ExcCZ excCZ
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(@RequestBody(required = true) CreateExcCZCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture = ExcCZBusinessDelegate.getExcCZInstance().createExcCZ(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a ExcCZ. if no key provided, calls create, otherwise calls save
   *
   * @param ExcCZ excCZ
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(@RequestBody(required = true) UpdateExcCZCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateExcCZCommand
      // -----------------------------------------------
      completableFuture = ExcCZBusinessDelegate.getExcCZInstance().updateExcCZ(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "ExcCZController:update() - successfully update ExcCZ - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a ExcCZ entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID excCZId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteExcCZCommand command = new DeleteExcCZCommand(excCZId);

    try {
      ExcCZBusinessDelegate delegate = ExcCZBusinessDelegate.getExcCZInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(Level.WARNING, "Successfully deleted ExcCZ with key " + command.getExcCZId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Efdmax on ExcCZ
   *
   * @param command AssignEfdmaxToExcCZCommand
   */
  @PutMapping("/assignEfdmax")
  public void assignEfdmax(@RequestBody AssignEfdmaxToExcCZCommand command) {
    try {
      ExcCZBusinessDelegate.getExcCZInstance().assignEfdmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Efdmax", exc);
    }
  }

  /**
   * unassign Efdmax on ExcCZ
   *
   * @param command UnAssignEfdmaxFromExcCZCommand
   */
  @PutMapping("/unAssignEfdmax")
  public void unAssignEfdmax(@RequestBody(required = true) UnAssignEfdmaxFromExcCZCommand command) {
    try {
      ExcCZBusinessDelegate.getExcCZInstance().unAssignEfdmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Efdmax", exc);
    }
  }

  /**
   * save Efdmin on ExcCZ
   *
   * @param command AssignEfdminToExcCZCommand
   */
  @PutMapping("/assignEfdmin")
  public void assignEfdmin(@RequestBody AssignEfdminToExcCZCommand command) {
    try {
      ExcCZBusinessDelegate.getExcCZInstance().assignEfdmin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Efdmin", exc);
    }
  }

  /**
   * unassign Efdmin on ExcCZ
   *
   * @param command UnAssignEfdminFromExcCZCommand
   */
  @PutMapping("/unAssignEfdmin")
  public void unAssignEfdmin(@RequestBody(required = true) UnAssignEfdminFromExcCZCommand command) {
    try {
      ExcCZBusinessDelegate.getExcCZInstance().unAssignEfdmin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Efdmin", exc);
    }
  }

  /**
   * save Ka on ExcCZ
   *
   * @param command AssignKaToExcCZCommand
   */
  @PutMapping("/assignKa")
  public void assignKa(@RequestBody AssignKaToExcCZCommand command) {
    try {
      ExcCZBusinessDelegate.getExcCZInstance().assignKa(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ka", exc);
    }
  }

  /**
   * unassign Ka on ExcCZ
   *
   * @param command UnAssignKaFromExcCZCommand
   */
  @PutMapping("/unAssignKa")
  public void unAssignKa(@RequestBody(required = true) UnAssignKaFromExcCZCommand command) {
    try {
      ExcCZBusinessDelegate.getExcCZInstance().unAssignKa(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ka", exc);
    }
  }

  /**
   * save Ke on ExcCZ
   *
   * @param command AssignKeToExcCZCommand
   */
  @PutMapping("/assignKe")
  public void assignKe(@RequestBody AssignKeToExcCZCommand command) {
    try {
      ExcCZBusinessDelegate.getExcCZInstance().assignKe(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ke", exc);
    }
  }

  /**
   * unassign Ke on ExcCZ
   *
   * @param command UnAssignKeFromExcCZCommand
   */
  @PutMapping("/unAssignKe")
  public void unAssignKe(@RequestBody(required = true) UnAssignKeFromExcCZCommand command) {
    try {
      ExcCZBusinessDelegate.getExcCZInstance().unAssignKe(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ke", exc);
    }
  }

  /**
   * save Kp on ExcCZ
   *
   * @param command AssignKpToExcCZCommand
   */
  @PutMapping("/assignKp")
  public void assignKp(@RequestBody AssignKpToExcCZCommand command) {
    try {
      ExcCZBusinessDelegate.getExcCZInstance().assignKp(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kp", exc);
    }
  }

  /**
   * unassign Kp on ExcCZ
   *
   * @param command UnAssignKpFromExcCZCommand
   */
  @PutMapping("/unAssignKp")
  public void unAssignKp(@RequestBody(required = true) UnAssignKpFromExcCZCommand command) {
    try {
      ExcCZBusinessDelegate.getExcCZInstance().unAssignKp(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kp", exc);
    }
  }

  /**
   * save Ta on ExcCZ
   *
   * @param command AssignTaToExcCZCommand
   */
  @PutMapping("/assignTa")
  public void assignTa(@RequestBody AssignTaToExcCZCommand command) {
    try {
      ExcCZBusinessDelegate.getExcCZInstance().assignTa(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ta", exc);
    }
  }

  /**
   * unassign Ta on ExcCZ
   *
   * @param command UnAssignTaFromExcCZCommand
   */
  @PutMapping("/unAssignTa")
  public void unAssignTa(@RequestBody(required = true) UnAssignTaFromExcCZCommand command) {
    try {
      ExcCZBusinessDelegate.getExcCZInstance().unAssignTa(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ta", exc);
    }
  }

  /**
   * save Tc on ExcCZ
   *
   * @param command AssignTcToExcCZCommand
   */
  @PutMapping("/assignTc")
  public void assignTc(@RequestBody AssignTcToExcCZCommand command) {
    try {
      ExcCZBusinessDelegate.getExcCZInstance().assignTc(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tc", exc);
    }
  }

  /**
   * unassign Tc on ExcCZ
   *
   * @param command UnAssignTcFromExcCZCommand
   */
  @PutMapping("/unAssignTc")
  public void unAssignTc(@RequestBody(required = true) UnAssignTcFromExcCZCommand command) {
    try {
      ExcCZBusinessDelegate.getExcCZInstance().unAssignTc(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tc", exc);
    }
  }

  /**
   * save Te on ExcCZ
   *
   * @param command AssignTeToExcCZCommand
   */
  @PutMapping("/assignTe")
  public void assignTe(@RequestBody AssignTeToExcCZCommand command) {
    try {
      ExcCZBusinessDelegate.getExcCZInstance().assignTe(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Te", exc);
    }
  }

  /**
   * unassign Te on ExcCZ
   *
   * @param command UnAssignTeFromExcCZCommand
   */
  @PutMapping("/unAssignTe")
  public void unAssignTe(@RequestBody(required = true) UnAssignTeFromExcCZCommand command) {
    try {
      ExcCZBusinessDelegate.getExcCZInstance().unAssignTe(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Te", exc);
    }
  }

  /**
   * save Vrmax on ExcCZ
   *
   * @param command AssignVrmaxToExcCZCommand
   */
  @PutMapping("/assignVrmax")
  public void assignVrmax(@RequestBody AssignVrmaxToExcCZCommand command) {
    try {
      ExcCZBusinessDelegate.getExcCZInstance().assignVrmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vrmax", exc);
    }
  }

  /**
   * unassign Vrmax on ExcCZ
   *
   * @param command UnAssignVrmaxFromExcCZCommand
   */
  @PutMapping("/unAssignVrmax")
  public void unAssignVrmax(@RequestBody(required = true) UnAssignVrmaxFromExcCZCommand command) {
    try {
      ExcCZBusinessDelegate.getExcCZInstance().unAssignVrmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vrmax", exc);
    }
  }

  /**
   * save Vrmin on ExcCZ
   *
   * @param command AssignVrminToExcCZCommand
   */
  @PutMapping("/assignVrmin")
  public void assignVrmin(@RequestBody AssignVrminToExcCZCommand command) {
    try {
      ExcCZBusinessDelegate.getExcCZInstance().assignVrmin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vrmin", exc);
    }
  }

  /**
   * unassign Vrmin on ExcCZ
   *
   * @param command UnAssignVrminFromExcCZCommand
   */
  @PutMapping("/unAssignVrmin")
  public void unAssignVrmin(@RequestBody(required = true) UnAssignVrminFromExcCZCommand command) {
    try {
      ExcCZBusinessDelegate.getExcCZInstance().unAssignVrmin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vrmin", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected ExcCZ excCZ = null;
  private static final Logger LOGGER = Logger.getLogger(ExcCZCommandRestController.class.getName());
}
