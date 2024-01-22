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
 * Implements Spring Controller command CQRS processing for entity ExcIEEEDC3A.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcIEEEDC3A")
public class ExcIEEEDC3ACommandRestController extends BaseSpringRestController {

  /**
   * Handles create a ExcIEEEDC3A. if not key provided, calls create, otherwise calls save
   *
   * @param ExcIEEEDC3A excIEEEDC3A
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateExcIEEEDC3ACommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          ExcIEEEDC3ABusinessDelegate.getExcIEEEDC3AInstance().createExcIEEEDC3A(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a ExcIEEEDC3A. if no key provided, calls create, otherwise calls save
   *
   * @param ExcIEEEDC3A excIEEEDC3A
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateExcIEEEDC3ACommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateExcIEEEDC3ACommand
      // -----------------------------------------------
      completableFuture =
          ExcIEEEDC3ABusinessDelegate.getExcIEEEDC3AInstance().updateExcIEEEDC3A(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "ExcIEEEDC3AController:update() - successfully update ExcIEEEDC3A - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a ExcIEEEDC3A entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID excIEEEDC3AId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteExcIEEEDC3ACommand command = new DeleteExcIEEEDC3ACommand(excIEEEDC3AId);

    try {
      ExcIEEEDC3ABusinessDelegate delegate = ExcIEEEDC3ABusinessDelegate.getExcIEEEDC3AInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING, "Successfully deleted ExcIEEEDC3A with key " + command.getExcIEEEDC3AId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Efd1 on ExcIEEEDC3A
   *
   * @param command AssignEfd1ToExcIEEEDC3ACommand
   */
  @PutMapping("/assignEfd1")
  public void assignEfd1(@RequestBody AssignEfd1ToExcIEEEDC3ACommand command) {
    try {
      ExcIEEEDC3ABusinessDelegate.getExcIEEEDC3AInstance().assignEfd1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Efd1", exc);
    }
  }

  /**
   * unassign Efd1 on ExcIEEEDC3A
   *
   * @param command UnAssignEfd1FromExcIEEEDC3ACommand
   */
  @PutMapping("/unAssignEfd1")
  public void unAssignEfd1(
      @RequestBody(required = true) UnAssignEfd1FromExcIEEEDC3ACommand command) {
    try {
      ExcIEEEDC3ABusinessDelegate.getExcIEEEDC3AInstance().unAssignEfd1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Efd1", exc);
    }
  }

  /**
   * save Efd2 on ExcIEEEDC3A
   *
   * @param command AssignEfd2ToExcIEEEDC3ACommand
   */
  @PutMapping("/assignEfd2")
  public void assignEfd2(@RequestBody AssignEfd2ToExcIEEEDC3ACommand command) {
    try {
      ExcIEEEDC3ABusinessDelegate.getExcIEEEDC3AInstance().assignEfd2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Efd2", exc);
    }
  }

  /**
   * unassign Efd2 on ExcIEEEDC3A
   *
   * @param command UnAssignEfd2FromExcIEEEDC3ACommand
   */
  @PutMapping("/unAssignEfd2")
  public void unAssignEfd2(
      @RequestBody(required = true) UnAssignEfd2FromExcIEEEDC3ACommand command) {
    try {
      ExcIEEEDC3ABusinessDelegate.getExcIEEEDC3AInstance().unAssignEfd2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Efd2", exc);
    }
  }

  /**
   * save Exclim on ExcIEEEDC3A
   *
   * @param command AssignExclimToExcIEEEDC3ACommand
   */
  @PutMapping("/assignExclim")
  public void assignExclim(@RequestBody AssignExclimToExcIEEEDC3ACommand command) {
    try {
      ExcIEEEDC3ABusinessDelegate.getExcIEEEDC3AInstance().assignExclim(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Exclim", exc);
    }
  }

  /**
   * unassign Exclim on ExcIEEEDC3A
   *
   * @param command UnAssignExclimFromExcIEEEDC3ACommand
   */
  @PutMapping("/unAssignExclim")
  public void unAssignExclim(
      @RequestBody(required = true) UnAssignExclimFromExcIEEEDC3ACommand command) {
    try {
      ExcIEEEDC3ABusinessDelegate.getExcIEEEDC3AInstance().unAssignExclim(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Exclim", exc);
    }
  }

  /**
   * save Ke on ExcIEEEDC3A
   *
   * @param command AssignKeToExcIEEEDC3ACommand
   */
  @PutMapping("/assignKe")
  public void assignKe(@RequestBody AssignKeToExcIEEEDC3ACommand command) {
    try {
      ExcIEEEDC3ABusinessDelegate.getExcIEEEDC3AInstance().assignKe(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ke", exc);
    }
  }

  /**
   * unassign Ke on ExcIEEEDC3A
   *
   * @param command UnAssignKeFromExcIEEEDC3ACommand
   */
  @PutMapping("/unAssignKe")
  public void unAssignKe(@RequestBody(required = true) UnAssignKeFromExcIEEEDC3ACommand command) {
    try {
      ExcIEEEDC3ABusinessDelegate.getExcIEEEDC3AInstance().unAssignKe(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ke", exc);
    }
  }

  /**
   * save Kv on ExcIEEEDC3A
   *
   * @param command AssignKvToExcIEEEDC3ACommand
   */
  @PutMapping("/assignKv")
  public void assignKv(@RequestBody AssignKvToExcIEEEDC3ACommand command) {
    try {
      ExcIEEEDC3ABusinessDelegate.getExcIEEEDC3AInstance().assignKv(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kv", exc);
    }
  }

  /**
   * unassign Kv on ExcIEEEDC3A
   *
   * @param command UnAssignKvFromExcIEEEDC3ACommand
   */
  @PutMapping("/unAssignKv")
  public void unAssignKv(@RequestBody(required = true) UnAssignKvFromExcIEEEDC3ACommand command) {
    try {
      ExcIEEEDC3ABusinessDelegate.getExcIEEEDC3AInstance().unAssignKv(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kv", exc);
    }
  }

  /**
   * save Seefd1 on ExcIEEEDC3A
   *
   * @param command AssignSeefd1ToExcIEEEDC3ACommand
   */
  @PutMapping("/assignSeefd1")
  public void assignSeefd1(@RequestBody AssignSeefd1ToExcIEEEDC3ACommand command) {
    try {
      ExcIEEEDC3ABusinessDelegate.getExcIEEEDC3AInstance().assignSeefd1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Seefd1", exc);
    }
  }

  /**
   * unassign Seefd1 on ExcIEEEDC3A
   *
   * @param command UnAssignSeefd1FromExcIEEEDC3ACommand
   */
  @PutMapping("/unAssignSeefd1")
  public void unAssignSeefd1(
      @RequestBody(required = true) UnAssignSeefd1FromExcIEEEDC3ACommand command) {
    try {
      ExcIEEEDC3ABusinessDelegate.getExcIEEEDC3AInstance().unAssignSeefd1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Seefd1", exc);
    }
  }

  /**
   * save Seefd2 on ExcIEEEDC3A
   *
   * @param command AssignSeefd2ToExcIEEEDC3ACommand
   */
  @PutMapping("/assignSeefd2")
  public void assignSeefd2(@RequestBody AssignSeefd2ToExcIEEEDC3ACommand command) {
    try {
      ExcIEEEDC3ABusinessDelegate.getExcIEEEDC3AInstance().assignSeefd2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Seefd2", exc);
    }
  }

  /**
   * unassign Seefd2 on ExcIEEEDC3A
   *
   * @param command UnAssignSeefd2FromExcIEEEDC3ACommand
   */
  @PutMapping("/unAssignSeefd2")
  public void unAssignSeefd2(
      @RequestBody(required = true) UnAssignSeefd2FromExcIEEEDC3ACommand command) {
    try {
      ExcIEEEDC3ABusinessDelegate.getExcIEEEDC3AInstance().unAssignSeefd2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Seefd2", exc);
    }
  }

  /**
   * save Te on ExcIEEEDC3A
   *
   * @param command AssignTeToExcIEEEDC3ACommand
   */
  @PutMapping("/assignTe")
  public void assignTe(@RequestBody AssignTeToExcIEEEDC3ACommand command) {
    try {
      ExcIEEEDC3ABusinessDelegate.getExcIEEEDC3AInstance().assignTe(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Te", exc);
    }
  }

  /**
   * unassign Te on ExcIEEEDC3A
   *
   * @param command UnAssignTeFromExcIEEEDC3ACommand
   */
  @PutMapping("/unAssignTe")
  public void unAssignTe(@RequestBody(required = true) UnAssignTeFromExcIEEEDC3ACommand command) {
    try {
      ExcIEEEDC3ABusinessDelegate.getExcIEEEDC3AInstance().unAssignTe(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Te", exc);
    }
  }

  /**
   * save Trh on ExcIEEEDC3A
   *
   * @param command AssignTrhToExcIEEEDC3ACommand
   */
  @PutMapping("/assignTrh")
  public void assignTrh(@RequestBody AssignTrhToExcIEEEDC3ACommand command) {
    try {
      ExcIEEEDC3ABusinessDelegate.getExcIEEEDC3AInstance().assignTrh(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Trh", exc);
    }
  }

  /**
   * unassign Trh on ExcIEEEDC3A
   *
   * @param command UnAssignTrhFromExcIEEEDC3ACommand
   */
  @PutMapping("/unAssignTrh")
  public void unAssignTrh(@RequestBody(required = true) UnAssignTrhFromExcIEEEDC3ACommand command) {
    try {
      ExcIEEEDC3ABusinessDelegate.getExcIEEEDC3AInstance().unAssignTrh(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Trh", exc);
    }
  }

  /**
   * save Vrmax on ExcIEEEDC3A
   *
   * @param command AssignVrmaxToExcIEEEDC3ACommand
   */
  @PutMapping("/assignVrmax")
  public void assignVrmax(@RequestBody AssignVrmaxToExcIEEEDC3ACommand command) {
    try {
      ExcIEEEDC3ABusinessDelegate.getExcIEEEDC3AInstance().assignVrmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vrmax", exc);
    }
  }

  /**
   * unassign Vrmax on ExcIEEEDC3A
   *
   * @param command UnAssignVrmaxFromExcIEEEDC3ACommand
   */
  @PutMapping("/unAssignVrmax")
  public void unAssignVrmax(
      @RequestBody(required = true) UnAssignVrmaxFromExcIEEEDC3ACommand command) {
    try {
      ExcIEEEDC3ABusinessDelegate.getExcIEEEDC3AInstance().unAssignVrmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vrmax", exc);
    }
  }

  /**
   * save Vrmin on ExcIEEEDC3A
   *
   * @param command AssignVrminToExcIEEEDC3ACommand
   */
  @PutMapping("/assignVrmin")
  public void assignVrmin(@RequestBody AssignVrminToExcIEEEDC3ACommand command) {
    try {
      ExcIEEEDC3ABusinessDelegate.getExcIEEEDC3AInstance().assignVrmin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vrmin", exc);
    }
  }

  /**
   * unassign Vrmin on ExcIEEEDC3A
   *
   * @param command UnAssignVrminFromExcIEEEDC3ACommand
   */
  @PutMapping("/unAssignVrmin")
  public void unAssignVrmin(
      @RequestBody(required = true) UnAssignVrminFromExcIEEEDC3ACommand command) {
    try {
      ExcIEEEDC3ABusinessDelegate.getExcIEEEDC3AInstance().unAssignVrmin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vrmin", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected ExcIEEEDC3A excIEEEDC3A = null;
  private static final Logger LOGGER =
      Logger.getLogger(ExcIEEEDC3ACommandRestController.class.getName());
}
