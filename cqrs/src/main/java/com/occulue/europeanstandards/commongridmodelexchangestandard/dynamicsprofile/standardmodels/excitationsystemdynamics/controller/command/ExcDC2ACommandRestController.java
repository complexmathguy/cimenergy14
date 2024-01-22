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
 * Implements Spring Controller command CQRS processing for entity ExcDC2A.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcDC2A")
public class ExcDC2ACommandRestController extends BaseSpringRestController {

  /**
   * Handles create a ExcDC2A. if not key provided, calls create, otherwise calls save
   *
   * @param ExcDC2A excDC2A
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateExcDC2ACommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture = ExcDC2ABusinessDelegate.getExcDC2AInstance().createExcDC2A(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a ExcDC2A. if no key provided, calls create, otherwise calls save
   *
   * @param ExcDC2A excDC2A
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateExcDC2ACommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateExcDC2ACommand
      // -----------------------------------------------
      completableFuture = ExcDC2ABusinessDelegate.getExcDC2AInstance().updateExcDC2A(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "ExcDC2AController:update() - successfully update ExcDC2A - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a ExcDC2A entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID excDC2AId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteExcDC2ACommand command = new DeleteExcDC2ACommand(excDC2AId);

    try {
      ExcDC2ABusinessDelegate delegate = ExcDC2ABusinessDelegate.getExcDC2AInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(Level.WARNING, "Successfully deleted ExcDC2A with key " + command.getExcDC2AId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Efd1 on ExcDC2A
   *
   * @param command AssignEfd1ToExcDC2ACommand
   */
  @PutMapping("/assignEfd1")
  public void assignEfd1(@RequestBody AssignEfd1ToExcDC2ACommand command) {
    try {
      ExcDC2ABusinessDelegate.getExcDC2AInstance().assignEfd1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Efd1", exc);
    }
  }

  /**
   * unassign Efd1 on ExcDC2A
   *
   * @param command UnAssignEfd1FromExcDC2ACommand
   */
  @PutMapping("/unAssignEfd1")
  public void unAssignEfd1(@RequestBody(required = true) UnAssignEfd1FromExcDC2ACommand command) {
    try {
      ExcDC2ABusinessDelegate.getExcDC2AInstance().unAssignEfd1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Efd1", exc);
    }
  }

  /**
   * save Efd2 on ExcDC2A
   *
   * @param command AssignEfd2ToExcDC2ACommand
   */
  @PutMapping("/assignEfd2")
  public void assignEfd2(@RequestBody AssignEfd2ToExcDC2ACommand command) {
    try {
      ExcDC2ABusinessDelegate.getExcDC2AInstance().assignEfd2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Efd2", exc);
    }
  }

  /**
   * unassign Efd2 on ExcDC2A
   *
   * @param command UnAssignEfd2FromExcDC2ACommand
   */
  @PutMapping("/unAssignEfd2")
  public void unAssignEfd2(@RequestBody(required = true) UnAssignEfd2FromExcDC2ACommand command) {
    try {
      ExcDC2ABusinessDelegate.getExcDC2AInstance().unAssignEfd2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Efd2", exc);
    }
  }

  /**
   * save Exclim on ExcDC2A
   *
   * @param command AssignExclimToExcDC2ACommand
   */
  @PutMapping("/assignExclim")
  public void assignExclim(@RequestBody AssignExclimToExcDC2ACommand command) {
    try {
      ExcDC2ABusinessDelegate.getExcDC2AInstance().assignExclim(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Exclim", exc);
    }
  }

  /**
   * unassign Exclim on ExcDC2A
   *
   * @param command UnAssignExclimFromExcDC2ACommand
   */
  @PutMapping("/unAssignExclim")
  public void unAssignExclim(
      @RequestBody(required = true) UnAssignExclimFromExcDC2ACommand command) {
    try {
      ExcDC2ABusinessDelegate.getExcDC2AInstance().unAssignExclim(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Exclim", exc);
    }
  }

  /**
   * save Ka on ExcDC2A
   *
   * @param command AssignKaToExcDC2ACommand
   */
  @PutMapping("/assignKa")
  public void assignKa(@RequestBody AssignKaToExcDC2ACommand command) {
    try {
      ExcDC2ABusinessDelegate.getExcDC2AInstance().assignKa(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ka", exc);
    }
  }

  /**
   * unassign Ka on ExcDC2A
   *
   * @param command UnAssignKaFromExcDC2ACommand
   */
  @PutMapping("/unAssignKa")
  public void unAssignKa(@RequestBody(required = true) UnAssignKaFromExcDC2ACommand command) {
    try {
      ExcDC2ABusinessDelegate.getExcDC2AInstance().unAssignKa(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ka", exc);
    }
  }

  /**
   * save Ke on ExcDC2A
   *
   * @param command AssignKeToExcDC2ACommand
   */
  @PutMapping("/assignKe")
  public void assignKe(@RequestBody AssignKeToExcDC2ACommand command) {
    try {
      ExcDC2ABusinessDelegate.getExcDC2AInstance().assignKe(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ke", exc);
    }
  }

  /**
   * unassign Ke on ExcDC2A
   *
   * @param command UnAssignKeFromExcDC2ACommand
   */
  @PutMapping("/unAssignKe")
  public void unAssignKe(@RequestBody(required = true) UnAssignKeFromExcDC2ACommand command) {
    try {
      ExcDC2ABusinessDelegate.getExcDC2AInstance().unAssignKe(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ke", exc);
    }
  }

  /**
   * save Kf on ExcDC2A
   *
   * @param command AssignKfToExcDC2ACommand
   */
  @PutMapping("/assignKf")
  public void assignKf(@RequestBody AssignKfToExcDC2ACommand command) {
    try {
      ExcDC2ABusinessDelegate.getExcDC2AInstance().assignKf(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kf", exc);
    }
  }

  /**
   * unassign Kf on ExcDC2A
   *
   * @param command UnAssignKfFromExcDC2ACommand
   */
  @PutMapping("/unAssignKf")
  public void unAssignKf(@RequestBody(required = true) UnAssignKfFromExcDC2ACommand command) {
    try {
      ExcDC2ABusinessDelegate.getExcDC2AInstance().unAssignKf(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kf", exc);
    }
  }

  /**
   * save Ks on ExcDC2A
   *
   * @param command AssignKsToExcDC2ACommand
   */
  @PutMapping("/assignKs")
  public void assignKs(@RequestBody AssignKsToExcDC2ACommand command) {
    try {
      ExcDC2ABusinessDelegate.getExcDC2AInstance().assignKs(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ks", exc);
    }
  }

  /**
   * unassign Ks on ExcDC2A
   *
   * @param command UnAssignKsFromExcDC2ACommand
   */
  @PutMapping("/unAssignKs")
  public void unAssignKs(@RequestBody(required = true) UnAssignKsFromExcDC2ACommand command) {
    try {
      ExcDC2ABusinessDelegate.getExcDC2AInstance().unAssignKs(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ks", exc);
    }
  }

  /**
   * save Seefd1 on ExcDC2A
   *
   * @param command AssignSeefd1ToExcDC2ACommand
   */
  @PutMapping("/assignSeefd1")
  public void assignSeefd1(@RequestBody AssignSeefd1ToExcDC2ACommand command) {
    try {
      ExcDC2ABusinessDelegate.getExcDC2AInstance().assignSeefd1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Seefd1", exc);
    }
  }

  /**
   * unassign Seefd1 on ExcDC2A
   *
   * @param command UnAssignSeefd1FromExcDC2ACommand
   */
  @PutMapping("/unAssignSeefd1")
  public void unAssignSeefd1(
      @RequestBody(required = true) UnAssignSeefd1FromExcDC2ACommand command) {
    try {
      ExcDC2ABusinessDelegate.getExcDC2AInstance().unAssignSeefd1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Seefd1", exc);
    }
  }

  /**
   * save Seefd2 on ExcDC2A
   *
   * @param command AssignSeefd2ToExcDC2ACommand
   */
  @PutMapping("/assignSeefd2")
  public void assignSeefd2(@RequestBody AssignSeefd2ToExcDC2ACommand command) {
    try {
      ExcDC2ABusinessDelegate.getExcDC2AInstance().assignSeefd2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Seefd2", exc);
    }
  }

  /**
   * unassign Seefd2 on ExcDC2A
   *
   * @param command UnAssignSeefd2FromExcDC2ACommand
   */
  @PutMapping("/unAssignSeefd2")
  public void unAssignSeefd2(
      @RequestBody(required = true) UnAssignSeefd2FromExcDC2ACommand command) {
    try {
      ExcDC2ABusinessDelegate.getExcDC2AInstance().unAssignSeefd2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Seefd2", exc);
    }
  }

  /**
   * save Ta on ExcDC2A
   *
   * @param command AssignTaToExcDC2ACommand
   */
  @PutMapping("/assignTa")
  public void assignTa(@RequestBody AssignTaToExcDC2ACommand command) {
    try {
      ExcDC2ABusinessDelegate.getExcDC2AInstance().assignTa(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ta", exc);
    }
  }

  /**
   * unassign Ta on ExcDC2A
   *
   * @param command UnAssignTaFromExcDC2ACommand
   */
  @PutMapping("/unAssignTa")
  public void unAssignTa(@RequestBody(required = true) UnAssignTaFromExcDC2ACommand command) {
    try {
      ExcDC2ABusinessDelegate.getExcDC2AInstance().unAssignTa(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ta", exc);
    }
  }

  /**
   * save Tb on ExcDC2A
   *
   * @param command AssignTbToExcDC2ACommand
   */
  @PutMapping("/assignTb")
  public void assignTb(@RequestBody AssignTbToExcDC2ACommand command) {
    try {
      ExcDC2ABusinessDelegate.getExcDC2AInstance().assignTb(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tb", exc);
    }
  }

  /**
   * unassign Tb on ExcDC2A
   *
   * @param command UnAssignTbFromExcDC2ACommand
   */
  @PutMapping("/unAssignTb")
  public void unAssignTb(@RequestBody(required = true) UnAssignTbFromExcDC2ACommand command) {
    try {
      ExcDC2ABusinessDelegate.getExcDC2AInstance().unAssignTb(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tb", exc);
    }
  }

  /**
   * save Tc on ExcDC2A
   *
   * @param command AssignTcToExcDC2ACommand
   */
  @PutMapping("/assignTc")
  public void assignTc(@RequestBody AssignTcToExcDC2ACommand command) {
    try {
      ExcDC2ABusinessDelegate.getExcDC2AInstance().assignTc(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tc", exc);
    }
  }

  /**
   * unassign Tc on ExcDC2A
   *
   * @param command UnAssignTcFromExcDC2ACommand
   */
  @PutMapping("/unAssignTc")
  public void unAssignTc(@RequestBody(required = true) UnAssignTcFromExcDC2ACommand command) {
    try {
      ExcDC2ABusinessDelegate.getExcDC2AInstance().unAssignTc(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tc", exc);
    }
  }

  /**
   * save Te on ExcDC2A
   *
   * @param command AssignTeToExcDC2ACommand
   */
  @PutMapping("/assignTe")
  public void assignTe(@RequestBody AssignTeToExcDC2ACommand command) {
    try {
      ExcDC2ABusinessDelegate.getExcDC2AInstance().assignTe(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Te", exc);
    }
  }

  /**
   * unassign Te on ExcDC2A
   *
   * @param command UnAssignTeFromExcDC2ACommand
   */
  @PutMapping("/unAssignTe")
  public void unAssignTe(@RequestBody(required = true) UnAssignTeFromExcDC2ACommand command) {
    try {
      ExcDC2ABusinessDelegate.getExcDC2AInstance().unAssignTe(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Te", exc);
    }
  }

  /**
   * save Tf on ExcDC2A
   *
   * @param command AssignTfToExcDC2ACommand
   */
  @PutMapping("/assignTf")
  public void assignTf(@RequestBody AssignTfToExcDC2ACommand command) {
    try {
      ExcDC2ABusinessDelegate.getExcDC2AInstance().assignTf(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tf", exc);
    }
  }

  /**
   * unassign Tf on ExcDC2A
   *
   * @param command UnAssignTfFromExcDC2ACommand
   */
  @PutMapping("/unAssignTf")
  public void unAssignTf(@RequestBody(required = true) UnAssignTfFromExcDC2ACommand command) {
    try {
      ExcDC2ABusinessDelegate.getExcDC2AInstance().unAssignTf(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tf", exc);
    }
  }

  /**
   * save Tf1 on ExcDC2A
   *
   * @param command AssignTf1ToExcDC2ACommand
   */
  @PutMapping("/assignTf1")
  public void assignTf1(@RequestBody AssignTf1ToExcDC2ACommand command) {
    try {
      ExcDC2ABusinessDelegate.getExcDC2AInstance().assignTf1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tf1", exc);
    }
  }

  /**
   * unassign Tf1 on ExcDC2A
   *
   * @param command UnAssignTf1FromExcDC2ACommand
   */
  @PutMapping("/unAssignTf1")
  public void unAssignTf1(@RequestBody(required = true) UnAssignTf1FromExcDC2ACommand command) {
    try {
      ExcDC2ABusinessDelegate.getExcDC2AInstance().unAssignTf1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tf1", exc);
    }
  }

  /**
   * save Vrmax on ExcDC2A
   *
   * @param command AssignVrmaxToExcDC2ACommand
   */
  @PutMapping("/assignVrmax")
  public void assignVrmax(@RequestBody AssignVrmaxToExcDC2ACommand command) {
    try {
      ExcDC2ABusinessDelegate.getExcDC2AInstance().assignVrmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vrmax", exc);
    }
  }

  /**
   * unassign Vrmax on ExcDC2A
   *
   * @param command UnAssignVrmaxFromExcDC2ACommand
   */
  @PutMapping("/unAssignVrmax")
  public void unAssignVrmax(@RequestBody(required = true) UnAssignVrmaxFromExcDC2ACommand command) {
    try {
      ExcDC2ABusinessDelegate.getExcDC2AInstance().unAssignVrmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vrmax", exc);
    }
  }

  /**
   * save Vrmin on ExcDC2A
   *
   * @param command AssignVrminToExcDC2ACommand
   */
  @PutMapping("/assignVrmin")
  public void assignVrmin(@RequestBody AssignVrminToExcDC2ACommand command) {
    try {
      ExcDC2ABusinessDelegate.getExcDC2AInstance().assignVrmin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vrmin", exc);
    }
  }

  /**
   * unassign Vrmin on ExcDC2A
   *
   * @param command UnAssignVrminFromExcDC2ACommand
   */
  @PutMapping("/unAssignVrmin")
  public void unAssignVrmin(@RequestBody(required = true) UnAssignVrminFromExcDC2ACommand command) {
    try {
      ExcDC2ABusinessDelegate.getExcDC2AInstance().unAssignVrmin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vrmin", exc);
    }
  }

  /**
   * save Vtlim on ExcDC2A
   *
   * @param command AssignVtlimToExcDC2ACommand
   */
  @PutMapping("/assignVtlim")
  public void assignVtlim(@RequestBody AssignVtlimToExcDC2ACommand command) {
    try {
      ExcDC2ABusinessDelegate.getExcDC2AInstance().assignVtlim(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vtlim", exc);
    }
  }

  /**
   * unassign Vtlim on ExcDC2A
   *
   * @param command UnAssignVtlimFromExcDC2ACommand
   */
  @PutMapping("/unAssignVtlim")
  public void unAssignVtlim(@RequestBody(required = true) UnAssignVtlimFromExcDC2ACommand command) {
    try {
      ExcDC2ABusinessDelegate.getExcDC2AInstance().unAssignVtlim(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vtlim", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected ExcDC2A excDC2A = null;
  private static final Logger LOGGER =
      Logger.getLogger(ExcDC2ACommandRestController.class.getName());
}
