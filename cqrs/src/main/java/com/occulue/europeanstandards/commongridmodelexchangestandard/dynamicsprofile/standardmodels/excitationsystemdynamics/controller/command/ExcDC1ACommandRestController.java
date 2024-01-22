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
 * Implements Spring Controller command CQRS processing for entity ExcDC1A.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcDC1A")
public class ExcDC1ACommandRestController extends BaseSpringRestController {

  /**
   * Handles create a ExcDC1A. if not key provided, calls create, otherwise calls save
   *
   * @param ExcDC1A excDC1A
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateExcDC1ACommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture = ExcDC1ABusinessDelegate.getExcDC1AInstance().createExcDC1A(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a ExcDC1A. if no key provided, calls create, otherwise calls save
   *
   * @param ExcDC1A excDC1A
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateExcDC1ACommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateExcDC1ACommand
      // -----------------------------------------------
      completableFuture = ExcDC1ABusinessDelegate.getExcDC1AInstance().updateExcDC1A(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "ExcDC1AController:update() - successfully update ExcDC1A - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a ExcDC1A entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID excDC1AId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteExcDC1ACommand command = new DeleteExcDC1ACommand(excDC1AId);

    try {
      ExcDC1ABusinessDelegate delegate = ExcDC1ABusinessDelegate.getExcDC1AInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(Level.WARNING, "Successfully deleted ExcDC1A with key " + command.getExcDC1AId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Edfmax on ExcDC1A
   *
   * @param command AssignEdfmaxToExcDC1ACommand
   */
  @PutMapping("/assignEdfmax")
  public void assignEdfmax(@RequestBody AssignEdfmaxToExcDC1ACommand command) {
    try {
      ExcDC1ABusinessDelegate.getExcDC1AInstance().assignEdfmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Edfmax", exc);
    }
  }

  /**
   * unassign Edfmax on ExcDC1A
   *
   * @param command UnAssignEdfmaxFromExcDC1ACommand
   */
  @PutMapping("/unAssignEdfmax")
  public void unAssignEdfmax(
      @RequestBody(required = true) UnAssignEdfmaxFromExcDC1ACommand command) {
    try {
      ExcDC1ABusinessDelegate.getExcDC1AInstance().unAssignEdfmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Edfmax", exc);
    }
  }

  /**
   * save Efd1 on ExcDC1A
   *
   * @param command AssignEfd1ToExcDC1ACommand
   */
  @PutMapping("/assignEfd1")
  public void assignEfd1(@RequestBody AssignEfd1ToExcDC1ACommand command) {
    try {
      ExcDC1ABusinessDelegate.getExcDC1AInstance().assignEfd1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Efd1", exc);
    }
  }

  /**
   * unassign Efd1 on ExcDC1A
   *
   * @param command UnAssignEfd1FromExcDC1ACommand
   */
  @PutMapping("/unAssignEfd1")
  public void unAssignEfd1(@RequestBody(required = true) UnAssignEfd1FromExcDC1ACommand command) {
    try {
      ExcDC1ABusinessDelegate.getExcDC1AInstance().unAssignEfd1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Efd1", exc);
    }
  }

  /**
   * save Efd2 on ExcDC1A
   *
   * @param command AssignEfd2ToExcDC1ACommand
   */
  @PutMapping("/assignEfd2")
  public void assignEfd2(@RequestBody AssignEfd2ToExcDC1ACommand command) {
    try {
      ExcDC1ABusinessDelegate.getExcDC1AInstance().assignEfd2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Efd2", exc);
    }
  }

  /**
   * unassign Efd2 on ExcDC1A
   *
   * @param command UnAssignEfd2FromExcDC1ACommand
   */
  @PutMapping("/unAssignEfd2")
  public void unAssignEfd2(@RequestBody(required = true) UnAssignEfd2FromExcDC1ACommand command) {
    try {
      ExcDC1ABusinessDelegate.getExcDC1AInstance().unAssignEfd2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Efd2", exc);
    }
  }

  /**
   * save Efdmin on ExcDC1A
   *
   * @param command AssignEfdminToExcDC1ACommand
   */
  @PutMapping("/assignEfdmin")
  public void assignEfdmin(@RequestBody AssignEfdminToExcDC1ACommand command) {
    try {
      ExcDC1ABusinessDelegate.getExcDC1AInstance().assignEfdmin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Efdmin", exc);
    }
  }

  /**
   * unassign Efdmin on ExcDC1A
   *
   * @param command UnAssignEfdminFromExcDC1ACommand
   */
  @PutMapping("/unAssignEfdmin")
  public void unAssignEfdmin(
      @RequestBody(required = true) UnAssignEfdminFromExcDC1ACommand command) {
    try {
      ExcDC1ABusinessDelegate.getExcDC1AInstance().unAssignEfdmin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Efdmin", exc);
    }
  }

  /**
   * save Exclim on ExcDC1A
   *
   * @param command AssignExclimToExcDC1ACommand
   */
  @PutMapping("/assignExclim")
  public void assignExclim(@RequestBody AssignExclimToExcDC1ACommand command) {
    try {
      ExcDC1ABusinessDelegate.getExcDC1AInstance().assignExclim(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Exclim", exc);
    }
  }

  /**
   * unassign Exclim on ExcDC1A
   *
   * @param command UnAssignExclimFromExcDC1ACommand
   */
  @PutMapping("/unAssignExclim")
  public void unAssignExclim(
      @RequestBody(required = true) UnAssignExclimFromExcDC1ACommand command) {
    try {
      ExcDC1ABusinessDelegate.getExcDC1AInstance().unAssignExclim(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Exclim", exc);
    }
  }

  /**
   * save Ka on ExcDC1A
   *
   * @param command AssignKaToExcDC1ACommand
   */
  @PutMapping("/assignKa")
  public void assignKa(@RequestBody AssignKaToExcDC1ACommand command) {
    try {
      ExcDC1ABusinessDelegate.getExcDC1AInstance().assignKa(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ka", exc);
    }
  }

  /**
   * unassign Ka on ExcDC1A
   *
   * @param command UnAssignKaFromExcDC1ACommand
   */
  @PutMapping("/unAssignKa")
  public void unAssignKa(@RequestBody(required = true) UnAssignKaFromExcDC1ACommand command) {
    try {
      ExcDC1ABusinessDelegate.getExcDC1AInstance().unAssignKa(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ka", exc);
    }
  }

  /**
   * save Ke on ExcDC1A
   *
   * @param command AssignKeToExcDC1ACommand
   */
  @PutMapping("/assignKe")
  public void assignKe(@RequestBody AssignKeToExcDC1ACommand command) {
    try {
      ExcDC1ABusinessDelegate.getExcDC1AInstance().assignKe(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ke", exc);
    }
  }

  /**
   * unassign Ke on ExcDC1A
   *
   * @param command UnAssignKeFromExcDC1ACommand
   */
  @PutMapping("/unAssignKe")
  public void unAssignKe(@RequestBody(required = true) UnAssignKeFromExcDC1ACommand command) {
    try {
      ExcDC1ABusinessDelegate.getExcDC1AInstance().unAssignKe(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ke", exc);
    }
  }

  /**
   * save Kf on ExcDC1A
   *
   * @param command AssignKfToExcDC1ACommand
   */
  @PutMapping("/assignKf")
  public void assignKf(@RequestBody AssignKfToExcDC1ACommand command) {
    try {
      ExcDC1ABusinessDelegate.getExcDC1AInstance().assignKf(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kf", exc);
    }
  }

  /**
   * unassign Kf on ExcDC1A
   *
   * @param command UnAssignKfFromExcDC1ACommand
   */
  @PutMapping("/unAssignKf")
  public void unAssignKf(@RequestBody(required = true) UnAssignKfFromExcDC1ACommand command) {
    try {
      ExcDC1ABusinessDelegate.getExcDC1AInstance().unAssignKf(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kf", exc);
    }
  }

  /**
   * save Ks on ExcDC1A
   *
   * @param command AssignKsToExcDC1ACommand
   */
  @PutMapping("/assignKs")
  public void assignKs(@RequestBody AssignKsToExcDC1ACommand command) {
    try {
      ExcDC1ABusinessDelegate.getExcDC1AInstance().assignKs(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ks", exc);
    }
  }

  /**
   * unassign Ks on ExcDC1A
   *
   * @param command UnAssignKsFromExcDC1ACommand
   */
  @PutMapping("/unAssignKs")
  public void unAssignKs(@RequestBody(required = true) UnAssignKsFromExcDC1ACommand command) {
    try {
      ExcDC1ABusinessDelegate.getExcDC1AInstance().unAssignKs(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ks", exc);
    }
  }

  /**
   * save Seefd1 on ExcDC1A
   *
   * @param command AssignSeefd1ToExcDC1ACommand
   */
  @PutMapping("/assignSeefd1")
  public void assignSeefd1(@RequestBody AssignSeefd1ToExcDC1ACommand command) {
    try {
      ExcDC1ABusinessDelegate.getExcDC1AInstance().assignSeefd1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Seefd1", exc);
    }
  }

  /**
   * unassign Seefd1 on ExcDC1A
   *
   * @param command UnAssignSeefd1FromExcDC1ACommand
   */
  @PutMapping("/unAssignSeefd1")
  public void unAssignSeefd1(
      @RequestBody(required = true) UnAssignSeefd1FromExcDC1ACommand command) {
    try {
      ExcDC1ABusinessDelegate.getExcDC1AInstance().unAssignSeefd1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Seefd1", exc);
    }
  }

  /**
   * save Seefd2 on ExcDC1A
   *
   * @param command AssignSeefd2ToExcDC1ACommand
   */
  @PutMapping("/assignSeefd2")
  public void assignSeefd2(@RequestBody AssignSeefd2ToExcDC1ACommand command) {
    try {
      ExcDC1ABusinessDelegate.getExcDC1AInstance().assignSeefd2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Seefd2", exc);
    }
  }

  /**
   * unassign Seefd2 on ExcDC1A
   *
   * @param command UnAssignSeefd2FromExcDC1ACommand
   */
  @PutMapping("/unAssignSeefd2")
  public void unAssignSeefd2(
      @RequestBody(required = true) UnAssignSeefd2FromExcDC1ACommand command) {
    try {
      ExcDC1ABusinessDelegate.getExcDC1AInstance().unAssignSeefd2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Seefd2", exc);
    }
  }

  /**
   * save Ta on ExcDC1A
   *
   * @param command AssignTaToExcDC1ACommand
   */
  @PutMapping("/assignTa")
  public void assignTa(@RequestBody AssignTaToExcDC1ACommand command) {
    try {
      ExcDC1ABusinessDelegate.getExcDC1AInstance().assignTa(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ta", exc);
    }
  }

  /**
   * unassign Ta on ExcDC1A
   *
   * @param command UnAssignTaFromExcDC1ACommand
   */
  @PutMapping("/unAssignTa")
  public void unAssignTa(@RequestBody(required = true) UnAssignTaFromExcDC1ACommand command) {
    try {
      ExcDC1ABusinessDelegate.getExcDC1AInstance().unAssignTa(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ta", exc);
    }
  }

  /**
   * save Tb on ExcDC1A
   *
   * @param command AssignTbToExcDC1ACommand
   */
  @PutMapping("/assignTb")
  public void assignTb(@RequestBody AssignTbToExcDC1ACommand command) {
    try {
      ExcDC1ABusinessDelegate.getExcDC1AInstance().assignTb(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tb", exc);
    }
  }

  /**
   * unassign Tb on ExcDC1A
   *
   * @param command UnAssignTbFromExcDC1ACommand
   */
  @PutMapping("/unAssignTb")
  public void unAssignTb(@RequestBody(required = true) UnAssignTbFromExcDC1ACommand command) {
    try {
      ExcDC1ABusinessDelegate.getExcDC1AInstance().unAssignTb(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tb", exc);
    }
  }

  /**
   * save Tc on ExcDC1A
   *
   * @param command AssignTcToExcDC1ACommand
   */
  @PutMapping("/assignTc")
  public void assignTc(@RequestBody AssignTcToExcDC1ACommand command) {
    try {
      ExcDC1ABusinessDelegate.getExcDC1AInstance().assignTc(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tc", exc);
    }
  }

  /**
   * unassign Tc on ExcDC1A
   *
   * @param command UnAssignTcFromExcDC1ACommand
   */
  @PutMapping("/unAssignTc")
  public void unAssignTc(@RequestBody(required = true) UnAssignTcFromExcDC1ACommand command) {
    try {
      ExcDC1ABusinessDelegate.getExcDC1AInstance().unAssignTc(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tc", exc);
    }
  }

  /**
   * save Te on ExcDC1A
   *
   * @param command AssignTeToExcDC1ACommand
   */
  @PutMapping("/assignTe")
  public void assignTe(@RequestBody AssignTeToExcDC1ACommand command) {
    try {
      ExcDC1ABusinessDelegate.getExcDC1AInstance().assignTe(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Te", exc);
    }
  }

  /**
   * unassign Te on ExcDC1A
   *
   * @param command UnAssignTeFromExcDC1ACommand
   */
  @PutMapping("/unAssignTe")
  public void unAssignTe(@RequestBody(required = true) UnAssignTeFromExcDC1ACommand command) {
    try {
      ExcDC1ABusinessDelegate.getExcDC1AInstance().unAssignTe(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Te", exc);
    }
  }

  /**
   * save Tf on ExcDC1A
   *
   * @param command AssignTfToExcDC1ACommand
   */
  @PutMapping("/assignTf")
  public void assignTf(@RequestBody AssignTfToExcDC1ACommand command) {
    try {
      ExcDC1ABusinessDelegate.getExcDC1AInstance().assignTf(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tf", exc);
    }
  }

  /**
   * unassign Tf on ExcDC1A
   *
   * @param command UnAssignTfFromExcDC1ACommand
   */
  @PutMapping("/unAssignTf")
  public void unAssignTf(@RequestBody(required = true) UnAssignTfFromExcDC1ACommand command) {
    try {
      ExcDC1ABusinessDelegate.getExcDC1AInstance().unAssignTf(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tf", exc);
    }
  }

  /**
   * save Vrmax on ExcDC1A
   *
   * @param command AssignVrmaxToExcDC1ACommand
   */
  @PutMapping("/assignVrmax")
  public void assignVrmax(@RequestBody AssignVrmaxToExcDC1ACommand command) {
    try {
      ExcDC1ABusinessDelegate.getExcDC1AInstance().assignVrmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vrmax", exc);
    }
  }

  /**
   * unassign Vrmax on ExcDC1A
   *
   * @param command UnAssignVrmaxFromExcDC1ACommand
   */
  @PutMapping("/unAssignVrmax")
  public void unAssignVrmax(@RequestBody(required = true) UnAssignVrmaxFromExcDC1ACommand command) {
    try {
      ExcDC1ABusinessDelegate.getExcDC1AInstance().unAssignVrmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vrmax", exc);
    }
  }

  /**
   * save Vrmin on ExcDC1A
   *
   * @param command AssignVrminToExcDC1ACommand
   */
  @PutMapping("/assignVrmin")
  public void assignVrmin(@RequestBody AssignVrminToExcDC1ACommand command) {
    try {
      ExcDC1ABusinessDelegate.getExcDC1AInstance().assignVrmin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vrmin", exc);
    }
  }

  /**
   * unassign Vrmin on ExcDC1A
   *
   * @param command UnAssignVrminFromExcDC1ACommand
   */
  @PutMapping("/unAssignVrmin")
  public void unAssignVrmin(@RequestBody(required = true) UnAssignVrminFromExcDC1ACommand command) {
    try {
      ExcDC1ABusinessDelegate.getExcDC1AInstance().unAssignVrmin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vrmin", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected ExcDC1A excDC1A = null;
  private static final Logger LOGGER =
      Logger.getLogger(ExcDC1ACommandRestController.class.getName());
}
