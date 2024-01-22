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
 * Implements Spring Controller command CQRS processing for entity ExcIEEEST2A.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcIEEEST2A")
public class ExcIEEEST2ACommandRestController extends BaseSpringRestController {

  /**
   * Handles create a ExcIEEEST2A. if not key provided, calls create, otherwise calls save
   *
   * @param ExcIEEEST2A excIEEEST2A
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateExcIEEEST2ACommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          ExcIEEEST2ABusinessDelegate.getExcIEEEST2AInstance().createExcIEEEST2A(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a ExcIEEEST2A. if no key provided, calls create, otherwise calls save
   *
   * @param ExcIEEEST2A excIEEEST2A
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateExcIEEEST2ACommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateExcIEEEST2ACommand
      // -----------------------------------------------
      completableFuture =
          ExcIEEEST2ABusinessDelegate.getExcIEEEST2AInstance().updateExcIEEEST2A(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "ExcIEEEST2AController:update() - successfully update ExcIEEEST2A - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a ExcIEEEST2A entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID excIEEEST2AId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteExcIEEEST2ACommand command = new DeleteExcIEEEST2ACommand(excIEEEST2AId);

    try {
      ExcIEEEST2ABusinessDelegate delegate = ExcIEEEST2ABusinessDelegate.getExcIEEEST2AInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING, "Successfully deleted ExcIEEEST2A with key " + command.getExcIEEEST2AId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Efdmax on ExcIEEEST2A
   *
   * @param command AssignEfdmaxToExcIEEEST2ACommand
   */
  @PutMapping("/assignEfdmax")
  public void assignEfdmax(@RequestBody AssignEfdmaxToExcIEEEST2ACommand command) {
    try {
      ExcIEEEST2ABusinessDelegate.getExcIEEEST2AInstance().assignEfdmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Efdmax", exc);
    }
  }

  /**
   * unassign Efdmax on ExcIEEEST2A
   *
   * @param command UnAssignEfdmaxFromExcIEEEST2ACommand
   */
  @PutMapping("/unAssignEfdmax")
  public void unAssignEfdmax(
      @RequestBody(required = true) UnAssignEfdmaxFromExcIEEEST2ACommand command) {
    try {
      ExcIEEEST2ABusinessDelegate.getExcIEEEST2AInstance().unAssignEfdmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Efdmax", exc);
    }
  }

  /**
   * save Ka on ExcIEEEST2A
   *
   * @param command AssignKaToExcIEEEST2ACommand
   */
  @PutMapping("/assignKa")
  public void assignKa(@RequestBody AssignKaToExcIEEEST2ACommand command) {
    try {
      ExcIEEEST2ABusinessDelegate.getExcIEEEST2AInstance().assignKa(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ka", exc);
    }
  }

  /**
   * unassign Ka on ExcIEEEST2A
   *
   * @param command UnAssignKaFromExcIEEEST2ACommand
   */
  @PutMapping("/unAssignKa")
  public void unAssignKa(@RequestBody(required = true) UnAssignKaFromExcIEEEST2ACommand command) {
    try {
      ExcIEEEST2ABusinessDelegate.getExcIEEEST2AInstance().unAssignKa(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ka", exc);
    }
  }

  /**
   * save Kc on ExcIEEEST2A
   *
   * @param command AssignKcToExcIEEEST2ACommand
   */
  @PutMapping("/assignKc")
  public void assignKc(@RequestBody AssignKcToExcIEEEST2ACommand command) {
    try {
      ExcIEEEST2ABusinessDelegate.getExcIEEEST2AInstance().assignKc(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kc", exc);
    }
  }

  /**
   * unassign Kc on ExcIEEEST2A
   *
   * @param command UnAssignKcFromExcIEEEST2ACommand
   */
  @PutMapping("/unAssignKc")
  public void unAssignKc(@RequestBody(required = true) UnAssignKcFromExcIEEEST2ACommand command) {
    try {
      ExcIEEEST2ABusinessDelegate.getExcIEEEST2AInstance().unAssignKc(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kc", exc);
    }
  }

  /**
   * save Ke on ExcIEEEST2A
   *
   * @param command AssignKeToExcIEEEST2ACommand
   */
  @PutMapping("/assignKe")
  public void assignKe(@RequestBody AssignKeToExcIEEEST2ACommand command) {
    try {
      ExcIEEEST2ABusinessDelegate.getExcIEEEST2AInstance().assignKe(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ke", exc);
    }
  }

  /**
   * unassign Ke on ExcIEEEST2A
   *
   * @param command UnAssignKeFromExcIEEEST2ACommand
   */
  @PutMapping("/unAssignKe")
  public void unAssignKe(@RequestBody(required = true) UnAssignKeFromExcIEEEST2ACommand command) {
    try {
      ExcIEEEST2ABusinessDelegate.getExcIEEEST2AInstance().unAssignKe(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ke", exc);
    }
  }

  /**
   * save Kf on ExcIEEEST2A
   *
   * @param command AssignKfToExcIEEEST2ACommand
   */
  @PutMapping("/assignKf")
  public void assignKf(@RequestBody AssignKfToExcIEEEST2ACommand command) {
    try {
      ExcIEEEST2ABusinessDelegate.getExcIEEEST2AInstance().assignKf(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kf", exc);
    }
  }

  /**
   * unassign Kf on ExcIEEEST2A
   *
   * @param command UnAssignKfFromExcIEEEST2ACommand
   */
  @PutMapping("/unAssignKf")
  public void unAssignKf(@RequestBody(required = true) UnAssignKfFromExcIEEEST2ACommand command) {
    try {
      ExcIEEEST2ABusinessDelegate.getExcIEEEST2AInstance().unAssignKf(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kf", exc);
    }
  }

  /**
   * save Ki on ExcIEEEST2A
   *
   * @param command AssignKiToExcIEEEST2ACommand
   */
  @PutMapping("/assignKi")
  public void assignKi(@RequestBody AssignKiToExcIEEEST2ACommand command) {
    try {
      ExcIEEEST2ABusinessDelegate.getExcIEEEST2AInstance().assignKi(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ki", exc);
    }
  }

  /**
   * unassign Ki on ExcIEEEST2A
   *
   * @param command UnAssignKiFromExcIEEEST2ACommand
   */
  @PutMapping("/unAssignKi")
  public void unAssignKi(@RequestBody(required = true) UnAssignKiFromExcIEEEST2ACommand command) {
    try {
      ExcIEEEST2ABusinessDelegate.getExcIEEEST2AInstance().unAssignKi(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ki", exc);
    }
  }

  /**
   * save Kp on ExcIEEEST2A
   *
   * @param command AssignKpToExcIEEEST2ACommand
   */
  @PutMapping("/assignKp")
  public void assignKp(@RequestBody AssignKpToExcIEEEST2ACommand command) {
    try {
      ExcIEEEST2ABusinessDelegate.getExcIEEEST2AInstance().assignKp(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kp", exc);
    }
  }

  /**
   * unassign Kp on ExcIEEEST2A
   *
   * @param command UnAssignKpFromExcIEEEST2ACommand
   */
  @PutMapping("/unAssignKp")
  public void unAssignKp(@RequestBody(required = true) UnAssignKpFromExcIEEEST2ACommand command) {
    try {
      ExcIEEEST2ABusinessDelegate.getExcIEEEST2AInstance().unAssignKp(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kp", exc);
    }
  }

  /**
   * save Ta on ExcIEEEST2A
   *
   * @param command AssignTaToExcIEEEST2ACommand
   */
  @PutMapping("/assignTa")
  public void assignTa(@RequestBody AssignTaToExcIEEEST2ACommand command) {
    try {
      ExcIEEEST2ABusinessDelegate.getExcIEEEST2AInstance().assignTa(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ta", exc);
    }
  }

  /**
   * unassign Ta on ExcIEEEST2A
   *
   * @param command UnAssignTaFromExcIEEEST2ACommand
   */
  @PutMapping("/unAssignTa")
  public void unAssignTa(@RequestBody(required = true) UnAssignTaFromExcIEEEST2ACommand command) {
    try {
      ExcIEEEST2ABusinessDelegate.getExcIEEEST2AInstance().unAssignTa(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ta", exc);
    }
  }

  /**
   * save Te on ExcIEEEST2A
   *
   * @param command AssignTeToExcIEEEST2ACommand
   */
  @PutMapping("/assignTe")
  public void assignTe(@RequestBody AssignTeToExcIEEEST2ACommand command) {
    try {
      ExcIEEEST2ABusinessDelegate.getExcIEEEST2AInstance().assignTe(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Te", exc);
    }
  }

  /**
   * unassign Te on ExcIEEEST2A
   *
   * @param command UnAssignTeFromExcIEEEST2ACommand
   */
  @PutMapping("/unAssignTe")
  public void unAssignTe(@RequestBody(required = true) UnAssignTeFromExcIEEEST2ACommand command) {
    try {
      ExcIEEEST2ABusinessDelegate.getExcIEEEST2AInstance().unAssignTe(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Te", exc);
    }
  }

  /**
   * save Tf on ExcIEEEST2A
   *
   * @param command AssignTfToExcIEEEST2ACommand
   */
  @PutMapping("/assignTf")
  public void assignTf(@RequestBody AssignTfToExcIEEEST2ACommand command) {
    try {
      ExcIEEEST2ABusinessDelegate.getExcIEEEST2AInstance().assignTf(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tf", exc);
    }
  }

  /**
   * unassign Tf on ExcIEEEST2A
   *
   * @param command UnAssignTfFromExcIEEEST2ACommand
   */
  @PutMapping("/unAssignTf")
  public void unAssignTf(@RequestBody(required = true) UnAssignTfFromExcIEEEST2ACommand command) {
    try {
      ExcIEEEST2ABusinessDelegate.getExcIEEEST2AInstance().unAssignTf(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tf", exc);
    }
  }

  /**
   * save Uelin on ExcIEEEST2A
   *
   * @param command AssignUelinToExcIEEEST2ACommand
   */
  @PutMapping("/assignUelin")
  public void assignUelin(@RequestBody AssignUelinToExcIEEEST2ACommand command) {
    try {
      ExcIEEEST2ABusinessDelegate.getExcIEEEST2AInstance().assignUelin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Uelin", exc);
    }
  }

  /**
   * unassign Uelin on ExcIEEEST2A
   *
   * @param command UnAssignUelinFromExcIEEEST2ACommand
   */
  @PutMapping("/unAssignUelin")
  public void unAssignUelin(
      @RequestBody(required = true) UnAssignUelinFromExcIEEEST2ACommand command) {
    try {
      ExcIEEEST2ABusinessDelegate.getExcIEEEST2AInstance().unAssignUelin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Uelin", exc);
    }
  }

  /**
   * save Vrmax on ExcIEEEST2A
   *
   * @param command AssignVrmaxToExcIEEEST2ACommand
   */
  @PutMapping("/assignVrmax")
  public void assignVrmax(@RequestBody AssignVrmaxToExcIEEEST2ACommand command) {
    try {
      ExcIEEEST2ABusinessDelegate.getExcIEEEST2AInstance().assignVrmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vrmax", exc);
    }
  }

  /**
   * unassign Vrmax on ExcIEEEST2A
   *
   * @param command UnAssignVrmaxFromExcIEEEST2ACommand
   */
  @PutMapping("/unAssignVrmax")
  public void unAssignVrmax(
      @RequestBody(required = true) UnAssignVrmaxFromExcIEEEST2ACommand command) {
    try {
      ExcIEEEST2ABusinessDelegate.getExcIEEEST2AInstance().unAssignVrmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vrmax", exc);
    }
  }

  /**
   * save Vrmin on ExcIEEEST2A
   *
   * @param command AssignVrminToExcIEEEST2ACommand
   */
  @PutMapping("/assignVrmin")
  public void assignVrmin(@RequestBody AssignVrminToExcIEEEST2ACommand command) {
    try {
      ExcIEEEST2ABusinessDelegate.getExcIEEEST2AInstance().assignVrmin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vrmin", exc);
    }
  }

  /**
   * unassign Vrmin on ExcIEEEST2A
   *
   * @param command UnAssignVrminFromExcIEEEST2ACommand
   */
  @PutMapping("/unAssignVrmin")
  public void unAssignVrmin(
      @RequestBody(required = true) UnAssignVrminFromExcIEEEST2ACommand command) {
    try {
      ExcIEEEST2ABusinessDelegate.getExcIEEEST2AInstance().unAssignVrmin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vrmin", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected ExcIEEEST2A excIEEEST2A = null;
  private static final Logger LOGGER =
      Logger.getLogger(ExcIEEEST2ACommandRestController.class.getName());
}
