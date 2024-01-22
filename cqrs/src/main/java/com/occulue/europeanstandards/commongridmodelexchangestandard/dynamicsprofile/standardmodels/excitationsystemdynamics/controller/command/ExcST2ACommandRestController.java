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
 * Implements Spring Controller command CQRS processing for entity ExcST2A.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcST2A")
public class ExcST2ACommandRestController extends BaseSpringRestController {

  /**
   * Handles create a ExcST2A. if not key provided, calls create, otherwise calls save
   *
   * @param ExcST2A excST2A
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateExcST2ACommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture = ExcST2ABusinessDelegate.getExcST2AInstance().createExcST2A(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a ExcST2A. if no key provided, calls create, otherwise calls save
   *
   * @param ExcST2A excST2A
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateExcST2ACommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateExcST2ACommand
      // -----------------------------------------------
      completableFuture = ExcST2ABusinessDelegate.getExcST2AInstance().updateExcST2A(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "ExcST2AController:update() - successfully update ExcST2A - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a ExcST2A entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID excST2AId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteExcST2ACommand command = new DeleteExcST2ACommand(excST2AId);

    try {
      ExcST2ABusinessDelegate delegate = ExcST2ABusinessDelegate.getExcST2AInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(Level.WARNING, "Successfully deleted ExcST2A with key " + command.getExcST2AId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Efdmax on ExcST2A
   *
   * @param command AssignEfdmaxToExcST2ACommand
   */
  @PutMapping("/assignEfdmax")
  public void assignEfdmax(@RequestBody AssignEfdmaxToExcST2ACommand command) {
    try {
      ExcST2ABusinessDelegate.getExcST2AInstance().assignEfdmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Efdmax", exc);
    }
  }

  /**
   * unassign Efdmax on ExcST2A
   *
   * @param command UnAssignEfdmaxFromExcST2ACommand
   */
  @PutMapping("/unAssignEfdmax")
  public void unAssignEfdmax(
      @RequestBody(required = true) UnAssignEfdmaxFromExcST2ACommand command) {
    try {
      ExcST2ABusinessDelegate.getExcST2AInstance().unAssignEfdmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Efdmax", exc);
    }
  }

  /**
   * save Ka on ExcST2A
   *
   * @param command AssignKaToExcST2ACommand
   */
  @PutMapping("/assignKa")
  public void assignKa(@RequestBody AssignKaToExcST2ACommand command) {
    try {
      ExcST2ABusinessDelegate.getExcST2AInstance().assignKa(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ka", exc);
    }
  }

  /**
   * unassign Ka on ExcST2A
   *
   * @param command UnAssignKaFromExcST2ACommand
   */
  @PutMapping("/unAssignKa")
  public void unAssignKa(@RequestBody(required = true) UnAssignKaFromExcST2ACommand command) {
    try {
      ExcST2ABusinessDelegate.getExcST2AInstance().unAssignKa(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ka", exc);
    }
  }

  /**
   * save Kc on ExcST2A
   *
   * @param command AssignKcToExcST2ACommand
   */
  @PutMapping("/assignKc")
  public void assignKc(@RequestBody AssignKcToExcST2ACommand command) {
    try {
      ExcST2ABusinessDelegate.getExcST2AInstance().assignKc(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kc", exc);
    }
  }

  /**
   * unassign Kc on ExcST2A
   *
   * @param command UnAssignKcFromExcST2ACommand
   */
  @PutMapping("/unAssignKc")
  public void unAssignKc(@RequestBody(required = true) UnAssignKcFromExcST2ACommand command) {
    try {
      ExcST2ABusinessDelegate.getExcST2AInstance().unAssignKc(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kc", exc);
    }
  }

  /**
   * save Ke on ExcST2A
   *
   * @param command AssignKeToExcST2ACommand
   */
  @PutMapping("/assignKe")
  public void assignKe(@RequestBody AssignKeToExcST2ACommand command) {
    try {
      ExcST2ABusinessDelegate.getExcST2AInstance().assignKe(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ke", exc);
    }
  }

  /**
   * unassign Ke on ExcST2A
   *
   * @param command UnAssignKeFromExcST2ACommand
   */
  @PutMapping("/unAssignKe")
  public void unAssignKe(@RequestBody(required = true) UnAssignKeFromExcST2ACommand command) {
    try {
      ExcST2ABusinessDelegate.getExcST2AInstance().unAssignKe(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ke", exc);
    }
  }

  /**
   * save Kf on ExcST2A
   *
   * @param command AssignKfToExcST2ACommand
   */
  @PutMapping("/assignKf")
  public void assignKf(@RequestBody AssignKfToExcST2ACommand command) {
    try {
      ExcST2ABusinessDelegate.getExcST2AInstance().assignKf(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kf", exc);
    }
  }

  /**
   * unassign Kf on ExcST2A
   *
   * @param command UnAssignKfFromExcST2ACommand
   */
  @PutMapping("/unAssignKf")
  public void unAssignKf(@RequestBody(required = true) UnAssignKfFromExcST2ACommand command) {
    try {
      ExcST2ABusinessDelegate.getExcST2AInstance().unAssignKf(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kf", exc);
    }
  }

  /**
   * save Ki on ExcST2A
   *
   * @param command AssignKiToExcST2ACommand
   */
  @PutMapping("/assignKi")
  public void assignKi(@RequestBody AssignKiToExcST2ACommand command) {
    try {
      ExcST2ABusinessDelegate.getExcST2AInstance().assignKi(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ki", exc);
    }
  }

  /**
   * unassign Ki on ExcST2A
   *
   * @param command UnAssignKiFromExcST2ACommand
   */
  @PutMapping("/unAssignKi")
  public void unAssignKi(@RequestBody(required = true) UnAssignKiFromExcST2ACommand command) {
    try {
      ExcST2ABusinessDelegate.getExcST2AInstance().unAssignKi(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ki", exc);
    }
  }

  /**
   * save Kp on ExcST2A
   *
   * @param command AssignKpToExcST2ACommand
   */
  @PutMapping("/assignKp")
  public void assignKp(@RequestBody AssignKpToExcST2ACommand command) {
    try {
      ExcST2ABusinessDelegate.getExcST2AInstance().assignKp(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kp", exc);
    }
  }

  /**
   * unassign Kp on ExcST2A
   *
   * @param command UnAssignKpFromExcST2ACommand
   */
  @PutMapping("/unAssignKp")
  public void unAssignKp(@RequestBody(required = true) UnAssignKpFromExcST2ACommand command) {
    try {
      ExcST2ABusinessDelegate.getExcST2AInstance().unAssignKp(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kp", exc);
    }
  }

  /**
   * save Ta on ExcST2A
   *
   * @param command AssignTaToExcST2ACommand
   */
  @PutMapping("/assignTa")
  public void assignTa(@RequestBody AssignTaToExcST2ACommand command) {
    try {
      ExcST2ABusinessDelegate.getExcST2AInstance().assignTa(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ta", exc);
    }
  }

  /**
   * unassign Ta on ExcST2A
   *
   * @param command UnAssignTaFromExcST2ACommand
   */
  @PutMapping("/unAssignTa")
  public void unAssignTa(@RequestBody(required = true) UnAssignTaFromExcST2ACommand command) {
    try {
      ExcST2ABusinessDelegate.getExcST2AInstance().unAssignTa(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ta", exc);
    }
  }

  /**
   * save Tb on ExcST2A
   *
   * @param command AssignTbToExcST2ACommand
   */
  @PutMapping("/assignTb")
  public void assignTb(@RequestBody AssignTbToExcST2ACommand command) {
    try {
      ExcST2ABusinessDelegate.getExcST2AInstance().assignTb(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tb", exc);
    }
  }

  /**
   * unassign Tb on ExcST2A
   *
   * @param command UnAssignTbFromExcST2ACommand
   */
  @PutMapping("/unAssignTb")
  public void unAssignTb(@RequestBody(required = true) UnAssignTbFromExcST2ACommand command) {
    try {
      ExcST2ABusinessDelegate.getExcST2AInstance().unAssignTb(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tb", exc);
    }
  }

  /**
   * save Tc on ExcST2A
   *
   * @param command AssignTcToExcST2ACommand
   */
  @PutMapping("/assignTc")
  public void assignTc(@RequestBody AssignTcToExcST2ACommand command) {
    try {
      ExcST2ABusinessDelegate.getExcST2AInstance().assignTc(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tc", exc);
    }
  }

  /**
   * unassign Tc on ExcST2A
   *
   * @param command UnAssignTcFromExcST2ACommand
   */
  @PutMapping("/unAssignTc")
  public void unAssignTc(@RequestBody(required = true) UnAssignTcFromExcST2ACommand command) {
    try {
      ExcST2ABusinessDelegate.getExcST2AInstance().unAssignTc(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tc", exc);
    }
  }

  /**
   * save Te on ExcST2A
   *
   * @param command AssignTeToExcST2ACommand
   */
  @PutMapping("/assignTe")
  public void assignTe(@RequestBody AssignTeToExcST2ACommand command) {
    try {
      ExcST2ABusinessDelegate.getExcST2AInstance().assignTe(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Te", exc);
    }
  }

  /**
   * unassign Te on ExcST2A
   *
   * @param command UnAssignTeFromExcST2ACommand
   */
  @PutMapping("/unAssignTe")
  public void unAssignTe(@RequestBody(required = true) UnAssignTeFromExcST2ACommand command) {
    try {
      ExcST2ABusinessDelegate.getExcST2AInstance().unAssignTe(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Te", exc);
    }
  }

  /**
   * save Tf on ExcST2A
   *
   * @param command AssignTfToExcST2ACommand
   */
  @PutMapping("/assignTf")
  public void assignTf(@RequestBody AssignTfToExcST2ACommand command) {
    try {
      ExcST2ABusinessDelegate.getExcST2AInstance().assignTf(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tf", exc);
    }
  }

  /**
   * unassign Tf on ExcST2A
   *
   * @param command UnAssignTfFromExcST2ACommand
   */
  @PutMapping("/unAssignTf")
  public void unAssignTf(@RequestBody(required = true) UnAssignTfFromExcST2ACommand command) {
    try {
      ExcST2ABusinessDelegate.getExcST2AInstance().unAssignTf(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tf", exc);
    }
  }

  /**
   * save Uelin on ExcST2A
   *
   * @param command AssignUelinToExcST2ACommand
   */
  @PutMapping("/assignUelin")
  public void assignUelin(@RequestBody AssignUelinToExcST2ACommand command) {
    try {
      ExcST2ABusinessDelegate.getExcST2AInstance().assignUelin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Uelin", exc);
    }
  }

  /**
   * unassign Uelin on ExcST2A
   *
   * @param command UnAssignUelinFromExcST2ACommand
   */
  @PutMapping("/unAssignUelin")
  public void unAssignUelin(@RequestBody(required = true) UnAssignUelinFromExcST2ACommand command) {
    try {
      ExcST2ABusinessDelegate.getExcST2AInstance().unAssignUelin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Uelin", exc);
    }
  }

  /**
   * save Vrmax on ExcST2A
   *
   * @param command AssignVrmaxToExcST2ACommand
   */
  @PutMapping("/assignVrmax")
  public void assignVrmax(@RequestBody AssignVrmaxToExcST2ACommand command) {
    try {
      ExcST2ABusinessDelegate.getExcST2AInstance().assignVrmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vrmax", exc);
    }
  }

  /**
   * unassign Vrmax on ExcST2A
   *
   * @param command UnAssignVrmaxFromExcST2ACommand
   */
  @PutMapping("/unAssignVrmax")
  public void unAssignVrmax(@RequestBody(required = true) UnAssignVrmaxFromExcST2ACommand command) {
    try {
      ExcST2ABusinessDelegate.getExcST2AInstance().unAssignVrmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vrmax", exc);
    }
  }

  /**
   * save Vrmin on ExcST2A
   *
   * @param command AssignVrminToExcST2ACommand
   */
  @PutMapping("/assignVrmin")
  public void assignVrmin(@RequestBody AssignVrminToExcST2ACommand command) {
    try {
      ExcST2ABusinessDelegate.getExcST2AInstance().assignVrmin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vrmin", exc);
    }
  }

  /**
   * unassign Vrmin on ExcST2A
   *
   * @param command UnAssignVrminFromExcST2ACommand
   */
  @PutMapping("/unAssignVrmin")
  public void unAssignVrmin(@RequestBody(required = true) UnAssignVrminFromExcST2ACommand command) {
    try {
      ExcST2ABusinessDelegate.getExcST2AInstance().unAssignVrmin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vrmin", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected ExcST2A excST2A = null;
  private static final Logger LOGGER =
      Logger.getLogger(ExcST2ACommandRestController.class.getName());
}
