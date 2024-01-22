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
 * Implements Spring Controller command CQRS processing for entity ExcDC3A.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcDC3A")
public class ExcDC3ACommandRestController extends BaseSpringRestController {

  /**
   * Handles create a ExcDC3A. if not key provided, calls create, otherwise calls save
   *
   * @param ExcDC3A excDC3A
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateExcDC3ACommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture = ExcDC3ABusinessDelegate.getExcDC3AInstance().createExcDC3A(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a ExcDC3A. if no key provided, calls create, otherwise calls save
   *
   * @param ExcDC3A excDC3A
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateExcDC3ACommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateExcDC3ACommand
      // -----------------------------------------------
      completableFuture = ExcDC3ABusinessDelegate.getExcDC3AInstance().updateExcDC3A(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "ExcDC3AController:update() - successfully update ExcDC3A - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a ExcDC3A entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID excDC3AId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteExcDC3ACommand command = new DeleteExcDC3ACommand(excDC3AId);

    try {
      ExcDC3ABusinessDelegate delegate = ExcDC3ABusinessDelegate.getExcDC3AInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(Level.WARNING, "Successfully deleted ExcDC3A with key " + command.getExcDC3AId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Edfmax on ExcDC3A
   *
   * @param command AssignEdfmaxToExcDC3ACommand
   */
  @PutMapping("/assignEdfmax")
  public void assignEdfmax(@RequestBody AssignEdfmaxToExcDC3ACommand command) {
    try {
      ExcDC3ABusinessDelegate.getExcDC3AInstance().assignEdfmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Edfmax", exc);
    }
  }

  /**
   * unassign Edfmax on ExcDC3A
   *
   * @param command UnAssignEdfmaxFromExcDC3ACommand
   */
  @PutMapping("/unAssignEdfmax")
  public void unAssignEdfmax(
      @RequestBody(required = true) UnAssignEdfmaxFromExcDC3ACommand command) {
    try {
      ExcDC3ABusinessDelegate.getExcDC3AInstance().unAssignEdfmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Edfmax", exc);
    }
  }

  /**
   * save Efd1 on ExcDC3A
   *
   * @param command AssignEfd1ToExcDC3ACommand
   */
  @PutMapping("/assignEfd1")
  public void assignEfd1(@RequestBody AssignEfd1ToExcDC3ACommand command) {
    try {
      ExcDC3ABusinessDelegate.getExcDC3AInstance().assignEfd1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Efd1", exc);
    }
  }

  /**
   * unassign Efd1 on ExcDC3A
   *
   * @param command UnAssignEfd1FromExcDC3ACommand
   */
  @PutMapping("/unAssignEfd1")
  public void unAssignEfd1(@RequestBody(required = true) UnAssignEfd1FromExcDC3ACommand command) {
    try {
      ExcDC3ABusinessDelegate.getExcDC3AInstance().unAssignEfd1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Efd1", exc);
    }
  }

  /**
   * save Efd2 on ExcDC3A
   *
   * @param command AssignEfd2ToExcDC3ACommand
   */
  @PutMapping("/assignEfd2")
  public void assignEfd2(@RequestBody AssignEfd2ToExcDC3ACommand command) {
    try {
      ExcDC3ABusinessDelegate.getExcDC3AInstance().assignEfd2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Efd2", exc);
    }
  }

  /**
   * unassign Efd2 on ExcDC3A
   *
   * @param command UnAssignEfd2FromExcDC3ACommand
   */
  @PutMapping("/unAssignEfd2")
  public void unAssignEfd2(@RequestBody(required = true) UnAssignEfd2FromExcDC3ACommand command) {
    try {
      ExcDC3ABusinessDelegate.getExcDC3AInstance().unAssignEfd2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Efd2", exc);
    }
  }

  /**
   * save Efdlim on ExcDC3A
   *
   * @param command AssignEfdlimToExcDC3ACommand
   */
  @PutMapping("/assignEfdlim")
  public void assignEfdlim(@RequestBody AssignEfdlimToExcDC3ACommand command) {
    try {
      ExcDC3ABusinessDelegate.getExcDC3AInstance().assignEfdlim(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Efdlim", exc);
    }
  }

  /**
   * unassign Efdlim on ExcDC3A
   *
   * @param command UnAssignEfdlimFromExcDC3ACommand
   */
  @PutMapping("/unAssignEfdlim")
  public void unAssignEfdlim(
      @RequestBody(required = true) UnAssignEfdlimFromExcDC3ACommand command) {
    try {
      ExcDC3ABusinessDelegate.getExcDC3AInstance().unAssignEfdlim(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Efdlim", exc);
    }
  }

  /**
   * save Efdmin on ExcDC3A
   *
   * @param command AssignEfdminToExcDC3ACommand
   */
  @PutMapping("/assignEfdmin")
  public void assignEfdmin(@RequestBody AssignEfdminToExcDC3ACommand command) {
    try {
      ExcDC3ABusinessDelegate.getExcDC3AInstance().assignEfdmin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Efdmin", exc);
    }
  }

  /**
   * unassign Efdmin on ExcDC3A
   *
   * @param command UnAssignEfdminFromExcDC3ACommand
   */
  @PutMapping("/unAssignEfdmin")
  public void unAssignEfdmin(
      @RequestBody(required = true) UnAssignEfdminFromExcDC3ACommand command) {
    try {
      ExcDC3ABusinessDelegate.getExcDC3AInstance().unAssignEfdmin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Efdmin", exc);
    }
  }

  /**
   * save Exclim on ExcDC3A
   *
   * @param command AssignExclimToExcDC3ACommand
   */
  @PutMapping("/assignExclim")
  public void assignExclim(@RequestBody AssignExclimToExcDC3ACommand command) {
    try {
      ExcDC3ABusinessDelegate.getExcDC3AInstance().assignExclim(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Exclim", exc);
    }
  }

  /**
   * unassign Exclim on ExcDC3A
   *
   * @param command UnAssignExclimFromExcDC3ACommand
   */
  @PutMapping("/unAssignExclim")
  public void unAssignExclim(
      @RequestBody(required = true) UnAssignExclimFromExcDC3ACommand command) {
    try {
      ExcDC3ABusinessDelegate.getExcDC3AInstance().unAssignExclim(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Exclim", exc);
    }
  }

  /**
   * save Ke on ExcDC3A
   *
   * @param command AssignKeToExcDC3ACommand
   */
  @PutMapping("/assignKe")
  public void assignKe(@RequestBody AssignKeToExcDC3ACommand command) {
    try {
      ExcDC3ABusinessDelegate.getExcDC3AInstance().assignKe(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ke", exc);
    }
  }

  /**
   * unassign Ke on ExcDC3A
   *
   * @param command UnAssignKeFromExcDC3ACommand
   */
  @PutMapping("/unAssignKe")
  public void unAssignKe(@RequestBody(required = true) UnAssignKeFromExcDC3ACommand command) {
    try {
      ExcDC3ABusinessDelegate.getExcDC3AInstance().unAssignKe(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ke", exc);
    }
  }

  /**
   * save Kr on ExcDC3A
   *
   * @param command AssignKrToExcDC3ACommand
   */
  @PutMapping("/assignKr")
  public void assignKr(@RequestBody AssignKrToExcDC3ACommand command) {
    try {
      ExcDC3ABusinessDelegate.getExcDC3AInstance().assignKr(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kr", exc);
    }
  }

  /**
   * unassign Kr on ExcDC3A
   *
   * @param command UnAssignKrFromExcDC3ACommand
   */
  @PutMapping("/unAssignKr")
  public void unAssignKr(@RequestBody(required = true) UnAssignKrFromExcDC3ACommand command) {
    try {
      ExcDC3ABusinessDelegate.getExcDC3AInstance().unAssignKr(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kr", exc);
    }
  }

  /**
   * save Ks on ExcDC3A
   *
   * @param command AssignKsToExcDC3ACommand
   */
  @PutMapping("/assignKs")
  public void assignKs(@RequestBody AssignKsToExcDC3ACommand command) {
    try {
      ExcDC3ABusinessDelegate.getExcDC3AInstance().assignKs(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ks", exc);
    }
  }

  /**
   * unassign Ks on ExcDC3A
   *
   * @param command UnAssignKsFromExcDC3ACommand
   */
  @PutMapping("/unAssignKs")
  public void unAssignKs(@RequestBody(required = true) UnAssignKsFromExcDC3ACommand command) {
    try {
      ExcDC3ABusinessDelegate.getExcDC3AInstance().unAssignKs(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ks", exc);
    }
  }

  /**
   * save Kv on ExcDC3A
   *
   * @param command AssignKvToExcDC3ACommand
   */
  @PutMapping("/assignKv")
  public void assignKv(@RequestBody AssignKvToExcDC3ACommand command) {
    try {
      ExcDC3ABusinessDelegate.getExcDC3AInstance().assignKv(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kv", exc);
    }
  }

  /**
   * unassign Kv on ExcDC3A
   *
   * @param command UnAssignKvFromExcDC3ACommand
   */
  @PutMapping("/unAssignKv")
  public void unAssignKv(@RequestBody(required = true) UnAssignKvFromExcDC3ACommand command) {
    try {
      ExcDC3ABusinessDelegate.getExcDC3AInstance().unAssignKv(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kv", exc);
    }
  }

  /**
   * save Seefd1 on ExcDC3A
   *
   * @param command AssignSeefd1ToExcDC3ACommand
   */
  @PutMapping("/assignSeefd1")
  public void assignSeefd1(@RequestBody AssignSeefd1ToExcDC3ACommand command) {
    try {
      ExcDC3ABusinessDelegate.getExcDC3AInstance().assignSeefd1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Seefd1", exc);
    }
  }

  /**
   * unassign Seefd1 on ExcDC3A
   *
   * @param command UnAssignSeefd1FromExcDC3ACommand
   */
  @PutMapping("/unAssignSeefd1")
  public void unAssignSeefd1(
      @RequestBody(required = true) UnAssignSeefd1FromExcDC3ACommand command) {
    try {
      ExcDC3ABusinessDelegate.getExcDC3AInstance().unAssignSeefd1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Seefd1", exc);
    }
  }

  /**
   * save Seefd2 on ExcDC3A
   *
   * @param command AssignSeefd2ToExcDC3ACommand
   */
  @PutMapping("/assignSeefd2")
  public void assignSeefd2(@RequestBody AssignSeefd2ToExcDC3ACommand command) {
    try {
      ExcDC3ABusinessDelegate.getExcDC3AInstance().assignSeefd2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Seefd2", exc);
    }
  }

  /**
   * unassign Seefd2 on ExcDC3A
   *
   * @param command UnAssignSeefd2FromExcDC3ACommand
   */
  @PutMapping("/unAssignSeefd2")
  public void unAssignSeefd2(
      @RequestBody(required = true) UnAssignSeefd2FromExcDC3ACommand command) {
    try {
      ExcDC3ABusinessDelegate.getExcDC3AInstance().unAssignSeefd2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Seefd2", exc);
    }
  }

  /**
   * save Te on ExcDC3A
   *
   * @param command AssignTeToExcDC3ACommand
   */
  @PutMapping("/assignTe")
  public void assignTe(@RequestBody AssignTeToExcDC3ACommand command) {
    try {
      ExcDC3ABusinessDelegate.getExcDC3AInstance().assignTe(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Te", exc);
    }
  }

  /**
   * unassign Te on ExcDC3A
   *
   * @param command UnAssignTeFromExcDC3ACommand
   */
  @PutMapping("/unAssignTe")
  public void unAssignTe(@RequestBody(required = true) UnAssignTeFromExcDC3ACommand command) {
    try {
      ExcDC3ABusinessDelegate.getExcDC3AInstance().unAssignTe(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Te", exc);
    }
  }

  /**
   * save Trh on ExcDC3A
   *
   * @param command AssignTrhToExcDC3ACommand
   */
  @PutMapping("/assignTrh")
  public void assignTrh(@RequestBody AssignTrhToExcDC3ACommand command) {
    try {
      ExcDC3ABusinessDelegate.getExcDC3AInstance().assignTrh(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Trh", exc);
    }
  }

  /**
   * unassign Trh on ExcDC3A
   *
   * @param command UnAssignTrhFromExcDC3ACommand
   */
  @PutMapping("/unAssignTrh")
  public void unAssignTrh(@RequestBody(required = true) UnAssignTrhFromExcDC3ACommand command) {
    try {
      ExcDC3ABusinessDelegate.getExcDC3AInstance().unAssignTrh(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Trh", exc);
    }
  }

  /**
   * save Vrmax on ExcDC3A
   *
   * @param command AssignVrmaxToExcDC3ACommand
   */
  @PutMapping("/assignVrmax")
  public void assignVrmax(@RequestBody AssignVrmaxToExcDC3ACommand command) {
    try {
      ExcDC3ABusinessDelegate.getExcDC3AInstance().assignVrmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vrmax", exc);
    }
  }

  /**
   * unassign Vrmax on ExcDC3A
   *
   * @param command UnAssignVrmaxFromExcDC3ACommand
   */
  @PutMapping("/unAssignVrmax")
  public void unAssignVrmax(@RequestBody(required = true) UnAssignVrmaxFromExcDC3ACommand command) {
    try {
      ExcDC3ABusinessDelegate.getExcDC3AInstance().unAssignVrmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vrmax", exc);
    }
  }

  /**
   * save Vrmin on ExcDC3A
   *
   * @param command AssignVrminToExcDC3ACommand
   */
  @PutMapping("/assignVrmin")
  public void assignVrmin(@RequestBody AssignVrminToExcDC3ACommand command) {
    try {
      ExcDC3ABusinessDelegate.getExcDC3AInstance().assignVrmin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vrmin", exc);
    }
  }

  /**
   * unassign Vrmin on ExcDC3A
   *
   * @param command UnAssignVrminFromExcDC3ACommand
   */
  @PutMapping("/unAssignVrmin")
  public void unAssignVrmin(@RequestBody(required = true) UnAssignVrminFromExcDC3ACommand command) {
    try {
      ExcDC3ABusinessDelegate.getExcDC3AInstance().unAssignVrmin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vrmin", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected ExcDC3A excDC3A = null;
  private static final Logger LOGGER =
      Logger.getLogger(ExcDC3ACommandRestController.class.getName());
}
