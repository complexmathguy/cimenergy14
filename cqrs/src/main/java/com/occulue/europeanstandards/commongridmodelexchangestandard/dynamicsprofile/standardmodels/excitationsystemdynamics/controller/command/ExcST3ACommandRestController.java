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
 * Implements Spring Controller command CQRS processing for entity ExcST3A.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcST3A")
public class ExcST3ACommandRestController extends BaseSpringRestController {

  /**
   * Handles create a ExcST3A. if not key provided, calls create, otherwise calls save
   *
   * @param ExcST3A excST3A
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateExcST3ACommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture = ExcST3ABusinessDelegate.getExcST3AInstance().createExcST3A(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a ExcST3A. if no key provided, calls create, otherwise calls save
   *
   * @param ExcST3A excST3A
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateExcST3ACommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateExcST3ACommand
      // -----------------------------------------------
      completableFuture = ExcST3ABusinessDelegate.getExcST3AInstance().updateExcST3A(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "ExcST3AController:update() - successfully update ExcST3A - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a ExcST3A entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID excST3AId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteExcST3ACommand command = new DeleteExcST3ACommand(excST3AId);

    try {
      ExcST3ABusinessDelegate delegate = ExcST3ABusinessDelegate.getExcST3AInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(Level.WARNING, "Successfully deleted ExcST3A with key " + command.getExcST3AId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Efdmax on ExcST3A
   *
   * @param command AssignEfdmaxToExcST3ACommand
   */
  @PutMapping("/assignEfdmax")
  public void assignEfdmax(@RequestBody AssignEfdmaxToExcST3ACommand command) {
    try {
      ExcST3ABusinessDelegate.getExcST3AInstance().assignEfdmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Efdmax", exc);
    }
  }

  /**
   * unassign Efdmax on ExcST3A
   *
   * @param command UnAssignEfdmaxFromExcST3ACommand
   */
  @PutMapping("/unAssignEfdmax")
  public void unAssignEfdmax(
      @RequestBody(required = true) UnAssignEfdmaxFromExcST3ACommand command) {
    try {
      ExcST3ABusinessDelegate.getExcST3AInstance().unAssignEfdmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Efdmax", exc);
    }
  }

  /**
   * save Kc on ExcST3A
   *
   * @param command AssignKcToExcST3ACommand
   */
  @PutMapping("/assignKc")
  public void assignKc(@RequestBody AssignKcToExcST3ACommand command) {
    try {
      ExcST3ABusinessDelegate.getExcST3AInstance().assignKc(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kc", exc);
    }
  }

  /**
   * unassign Kc on ExcST3A
   *
   * @param command UnAssignKcFromExcST3ACommand
   */
  @PutMapping("/unAssignKc")
  public void unAssignKc(@RequestBody(required = true) UnAssignKcFromExcST3ACommand command) {
    try {
      ExcST3ABusinessDelegate.getExcST3AInstance().unAssignKc(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kc", exc);
    }
  }

  /**
   * save Kg on ExcST3A
   *
   * @param command AssignKgToExcST3ACommand
   */
  @PutMapping("/assignKg")
  public void assignKg(@RequestBody AssignKgToExcST3ACommand command) {
    try {
      ExcST3ABusinessDelegate.getExcST3AInstance().assignKg(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kg", exc);
    }
  }

  /**
   * unassign Kg on ExcST3A
   *
   * @param command UnAssignKgFromExcST3ACommand
   */
  @PutMapping("/unAssignKg")
  public void unAssignKg(@RequestBody(required = true) UnAssignKgFromExcST3ACommand command) {
    try {
      ExcST3ABusinessDelegate.getExcST3AInstance().unAssignKg(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kg", exc);
    }
  }

  /**
   * save Ki on ExcST3A
   *
   * @param command AssignKiToExcST3ACommand
   */
  @PutMapping("/assignKi")
  public void assignKi(@RequestBody AssignKiToExcST3ACommand command) {
    try {
      ExcST3ABusinessDelegate.getExcST3AInstance().assignKi(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ki", exc);
    }
  }

  /**
   * unassign Ki on ExcST3A
   *
   * @param command UnAssignKiFromExcST3ACommand
   */
  @PutMapping("/unAssignKi")
  public void unAssignKi(@RequestBody(required = true) UnAssignKiFromExcST3ACommand command) {
    try {
      ExcST3ABusinessDelegate.getExcST3AInstance().unAssignKi(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ki", exc);
    }
  }

  /**
   * save Kj on ExcST3A
   *
   * @param command AssignKjToExcST3ACommand
   */
  @PutMapping("/assignKj")
  public void assignKj(@RequestBody AssignKjToExcST3ACommand command) {
    try {
      ExcST3ABusinessDelegate.getExcST3AInstance().assignKj(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kj", exc);
    }
  }

  /**
   * unassign Kj on ExcST3A
   *
   * @param command UnAssignKjFromExcST3ACommand
   */
  @PutMapping("/unAssignKj")
  public void unAssignKj(@RequestBody(required = true) UnAssignKjFromExcST3ACommand command) {
    try {
      ExcST3ABusinessDelegate.getExcST3AInstance().unAssignKj(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kj", exc);
    }
  }

  /**
   * save Km on ExcST3A
   *
   * @param command AssignKmToExcST3ACommand
   */
  @PutMapping("/assignKm")
  public void assignKm(@RequestBody AssignKmToExcST3ACommand command) {
    try {
      ExcST3ABusinessDelegate.getExcST3AInstance().assignKm(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Km", exc);
    }
  }

  /**
   * unassign Km on ExcST3A
   *
   * @param command UnAssignKmFromExcST3ACommand
   */
  @PutMapping("/unAssignKm")
  public void unAssignKm(@RequestBody(required = true) UnAssignKmFromExcST3ACommand command) {
    try {
      ExcST3ABusinessDelegate.getExcST3AInstance().unAssignKm(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Km", exc);
    }
  }

  /**
   * save Kp on ExcST3A
   *
   * @param command AssignKpToExcST3ACommand
   */
  @PutMapping("/assignKp")
  public void assignKp(@RequestBody AssignKpToExcST3ACommand command) {
    try {
      ExcST3ABusinessDelegate.getExcST3AInstance().assignKp(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kp", exc);
    }
  }

  /**
   * unassign Kp on ExcST3A
   *
   * @param command UnAssignKpFromExcST3ACommand
   */
  @PutMapping("/unAssignKp")
  public void unAssignKp(@RequestBody(required = true) UnAssignKpFromExcST3ACommand command) {
    try {
      ExcST3ABusinessDelegate.getExcST3AInstance().unAssignKp(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kp", exc);
    }
  }

  /**
   * save Ks on ExcST3A
   *
   * @param command AssignKsToExcST3ACommand
   */
  @PutMapping("/assignKs")
  public void assignKs(@RequestBody AssignKsToExcST3ACommand command) {
    try {
      ExcST3ABusinessDelegate.getExcST3AInstance().assignKs(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ks", exc);
    }
  }

  /**
   * unassign Ks on ExcST3A
   *
   * @param command UnAssignKsFromExcST3ACommand
   */
  @PutMapping("/unAssignKs")
  public void unAssignKs(@RequestBody(required = true) UnAssignKsFromExcST3ACommand command) {
    try {
      ExcST3ABusinessDelegate.getExcST3AInstance().unAssignKs(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ks", exc);
    }
  }

  /**
   * save Ks1 on ExcST3A
   *
   * @param command AssignKs1ToExcST3ACommand
   */
  @PutMapping("/assignKs1")
  public void assignKs1(@RequestBody AssignKs1ToExcST3ACommand command) {
    try {
      ExcST3ABusinessDelegate.getExcST3AInstance().assignKs1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ks1", exc);
    }
  }

  /**
   * unassign Ks1 on ExcST3A
   *
   * @param command UnAssignKs1FromExcST3ACommand
   */
  @PutMapping("/unAssignKs1")
  public void unAssignKs1(@RequestBody(required = true) UnAssignKs1FromExcST3ACommand command) {
    try {
      ExcST3ABusinessDelegate.getExcST3AInstance().unAssignKs1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ks1", exc);
    }
  }

  /**
   * save Tb on ExcST3A
   *
   * @param command AssignTbToExcST3ACommand
   */
  @PutMapping("/assignTb")
  public void assignTb(@RequestBody AssignTbToExcST3ACommand command) {
    try {
      ExcST3ABusinessDelegate.getExcST3AInstance().assignTb(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tb", exc);
    }
  }

  /**
   * unassign Tb on ExcST3A
   *
   * @param command UnAssignTbFromExcST3ACommand
   */
  @PutMapping("/unAssignTb")
  public void unAssignTb(@RequestBody(required = true) UnAssignTbFromExcST3ACommand command) {
    try {
      ExcST3ABusinessDelegate.getExcST3AInstance().unAssignTb(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tb", exc);
    }
  }

  /**
   * save Tc on ExcST3A
   *
   * @param command AssignTcToExcST3ACommand
   */
  @PutMapping("/assignTc")
  public void assignTc(@RequestBody AssignTcToExcST3ACommand command) {
    try {
      ExcST3ABusinessDelegate.getExcST3AInstance().assignTc(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tc", exc);
    }
  }

  /**
   * unassign Tc on ExcST3A
   *
   * @param command UnAssignTcFromExcST3ACommand
   */
  @PutMapping("/unAssignTc")
  public void unAssignTc(@RequestBody(required = true) UnAssignTcFromExcST3ACommand command) {
    try {
      ExcST3ABusinessDelegate.getExcST3AInstance().unAssignTc(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tc", exc);
    }
  }

  /**
   * save Thetap on ExcST3A
   *
   * @param command AssignThetapToExcST3ACommand
   */
  @PutMapping("/assignThetap")
  public void assignThetap(@RequestBody AssignThetapToExcST3ACommand command) {
    try {
      ExcST3ABusinessDelegate.getExcST3AInstance().assignThetap(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Thetap", exc);
    }
  }

  /**
   * unassign Thetap on ExcST3A
   *
   * @param command UnAssignThetapFromExcST3ACommand
   */
  @PutMapping("/unAssignThetap")
  public void unAssignThetap(
      @RequestBody(required = true) UnAssignThetapFromExcST3ACommand command) {
    try {
      ExcST3ABusinessDelegate.getExcST3AInstance().unAssignThetap(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Thetap", exc);
    }
  }

  /**
   * save Tm on ExcST3A
   *
   * @param command AssignTmToExcST3ACommand
   */
  @PutMapping("/assignTm")
  public void assignTm(@RequestBody AssignTmToExcST3ACommand command) {
    try {
      ExcST3ABusinessDelegate.getExcST3AInstance().assignTm(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tm", exc);
    }
  }

  /**
   * unassign Tm on ExcST3A
   *
   * @param command UnAssignTmFromExcST3ACommand
   */
  @PutMapping("/unAssignTm")
  public void unAssignTm(@RequestBody(required = true) UnAssignTmFromExcST3ACommand command) {
    try {
      ExcST3ABusinessDelegate.getExcST3AInstance().unAssignTm(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tm", exc);
    }
  }

  /**
   * save Vbmax on ExcST3A
   *
   * @param command AssignVbmaxToExcST3ACommand
   */
  @PutMapping("/assignVbmax")
  public void assignVbmax(@RequestBody AssignVbmaxToExcST3ACommand command) {
    try {
      ExcST3ABusinessDelegate.getExcST3AInstance().assignVbmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vbmax", exc);
    }
  }

  /**
   * unassign Vbmax on ExcST3A
   *
   * @param command UnAssignVbmaxFromExcST3ACommand
   */
  @PutMapping("/unAssignVbmax")
  public void unAssignVbmax(@RequestBody(required = true) UnAssignVbmaxFromExcST3ACommand command) {
    try {
      ExcST3ABusinessDelegate.getExcST3AInstance().unAssignVbmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vbmax", exc);
    }
  }

  /**
   * save Vgmax on ExcST3A
   *
   * @param command AssignVgmaxToExcST3ACommand
   */
  @PutMapping("/assignVgmax")
  public void assignVgmax(@RequestBody AssignVgmaxToExcST3ACommand command) {
    try {
      ExcST3ABusinessDelegate.getExcST3AInstance().assignVgmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vgmax", exc);
    }
  }

  /**
   * unassign Vgmax on ExcST3A
   *
   * @param command UnAssignVgmaxFromExcST3ACommand
   */
  @PutMapping("/unAssignVgmax")
  public void unAssignVgmax(@RequestBody(required = true) UnAssignVgmaxFromExcST3ACommand command) {
    try {
      ExcST3ABusinessDelegate.getExcST3AInstance().unAssignVgmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vgmax", exc);
    }
  }

  /**
   * save Vimax on ExcST3A
   *
   * @param command AssignVimaxToExcST3ACommand
   */
  @PutMapping("/assignVimax")
  public void assignVimax(@RequestBody AssignVimaxToExcST3ACommand command) {
    try {
      ExcST3ABusinessDelegate.getExcST3AInstance().assignVimax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vimax", exc);
    }
  }

  /**
   * unassign Vimax on ExcST3A
   *
   * @param command UnAssignVimaxFromExcST3ACommand
   */
  @PutMapping("/unAssignVimax")
  public void unAssignVimax(@RequestBody(required = true) UnAssignVimaxFromExcST3ACommand command) {
    try {
      ExcST3ABusinessDelegate.getExcST3AInstance().unAssignVimax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vimax", exc);
    }
  }

  /**
   * save Vimin on ExcST3A
   *
   * @param command AssignViminToExcST3ACommand
   */
  @PutMapping("/assignVimin")
  public void assignVimin(@RequestBody AssignViminToExcST3ACommand command) {
    try {
      ExcST3ABusinessDelegate.getExcST3AInstance().assignVimin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vimin", exc);
    }
  }

  /**
   * unassign Vimin on ExcST3A
   *
   * @param command UnAssignViminFromExcST3ACommand
   */
  @PutMapping("/unAssignVimin")
  public void unAssignVimin(@RequestBody(required = true) UnAssignViminFromExcST3ACommand command) {
    try {
      ExcST3ABusinessDelegate.getExcST3AInstance().unAssignVimin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vimin", exc);
    }
  }

  /**
   * save Vrmax on ExcST3A
   *
   * @param command AssignVrmaxToExcST3ACommand
   */
  @PutMapping("/assignVrmax")
  public void assignVrmax(@RequestBody AssignVrmaxToExcST3ACommand command) {
    try {
      ExcST3ABusinessDelegate.getExcST3AInstance().assignVrmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vrmax", exc);
    }
  }

  /**
   * unassign Vrmax on ExcST3A
   *
   * @param command UnAssignVrmaxFromExcST3ACommand
   */
  @PutMapping("/unAssignVrmax")
  public void unAssignVrmax(@RequestBody(required = true) UnAssignVrmaxFromExcST3ACommand command) {
    try {
      ExcST3ABusinessDelegate.getExcST3AInstance().unAssignVrmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vrmax", exc);
    }
  }

  /**
   * save Vrmin on ExcST3A
   *
   * @param command AssignVrminToExcST3ACommand
   */
  @PutMapping("/assignVrmin")
  public void assignVrmin(@RequestBody AssignVrminToExcST3ACommand command) {
    try {
      ExcST3ABusinessDelegate.getExcST3AInstance().assignVrmin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vrmin", exc);
    }
  }

  /**
   * unassign Vrmin on ExcST3A
   *
   * @param command UnAssignVrminFromExcST3ACommand
   */
  @PutMapping("/unAssignVrmin")
  public void unAssignVrmin(@RequestBody(required = true) UnAssignVrminFromExcST3ACommand command) {
    try {
      ExcST3ABusinessDelegate.getExcST3AInstance().unAssignVrmin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vrmin", exc);
    }
  }

  /**
   * save Xl on ExcST3A
   *
   * @param command AssignXlToExcST3ACommand
   */
  @PutMapping("/assignXl")
  public void assignXl(@RequestBody AssignXlToExcST3ACommand command) {
    try {
      ExcST3ABusinessDelegate.getExcST3AInstance().assignXl(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Xl", exc);
    }
  }

  /**
   * unassign Xl on ExcST3A
   *
   * @param command UnAssignXlFromExcST3ACommand
   */
  @PutMapping("/unAssignXl")
  public void unAssignXl(@RequestBody(required = true) UnAssignXlFromExcST3ACommand command) {
    try {
      ExcST3ABusinessDelegate.getExcST3AInstance().unAssignXl(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Xl", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected ExcST3A excST3A = null;
  private static final Logger LOGGER =
      Logger.getLogger(ExcST3ACommandRestController.class.getName());
}
