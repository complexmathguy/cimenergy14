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
 * Implements Spring Controller command CQRS processing for entity ExcIEEEDC1A.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcIEEEDC1A")
public class ExcIEEEDC1ACommandRestController extends BaseSpringRestController {

  /**
   * Handles create a ExcIEEEDC1A. if not key provided, calls create, otherwise calls save
   *
   * @param ExcIEEEDC1A excIEEEDC1A
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateExcIEEEDC1ACommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          ExcIEEEDC1ABusinessDelegate.getExcIEEEDC1AInstance().createExcIEEEDC1A(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a ExcIEEEDC1A. if no key provided, calls create, otherwise calls save
   *
   * @param ExcIEEEDC1A excIEEEDC1A
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateExcIEEEDC1ACommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateExcIEEEDC1ACommand
      // -----------------------------------------------
      completableFuture =
          ExcIEEEDC1ABusinessDelegate.getExcIEEEDC1AInstance().updateExcIEEEDC1A(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "ExcIEEEDC1AController:update() - successfully update ExcIEEEDC1A - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a ExcIEEEDC1A entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID excIEEEDC1AId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteExcIEEEDC1ACommand command = new DeleteExcIEEEDC1ACommand(excIEEEDC1AId);

    try {
      ExcIEEEDC1ABusinessDelegate delegate = ExcIEEEDC1ABusinessDelegate.getExcIEEEDC1AInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING, "Successfully deleted ExcIEEEDC1A with key " + command.getExcIEEEDC1AId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Efd1 on ExcIEEEDC1A
   *
   * @param command AssignEfd1ToExcIEEEDC1ACommand
   */
  @PutMapping("/assignEfd1")
  public void assignEfd1(@RequestBody AssignEfd1ToExcIEEEDC1ACommand command) {
    try {
      ExcIEEEDC1ABusinessDelegate.getExcIEEEDC1AInstance().assignEfd1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Efd1", exc);
    }
  }

  /**
   * unassign Efd1 on ExcIEEEDC1A
   *
   * @param command UnAssignEfd1FromExcIEEEDC1ACommand
   */
  @PutMapping("/unAssignEfd1")
  public void unAssignEfd1(
      @RequestBody(required = true) UnAssignEfd1FromExcIEEEDC1ACommand command) {
    try {
      ExcIEEEDC1ABusinessDelegate.getExcIEEEDC1AInstance().unAssignEfd1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Efd1", exc);
    }
  }

  /**
   * save Efd2 on ExcIEEEDC1A
   *
   * @param command AssignEfd2ToExcIEEEDC1ACommand
   */
  @PutMapping("/assignEfd2")
  public void assignEfd2(@RequestBody AssignEfd2ToExcIEEEDC1ACommand command) {
    try {
      ExcIEEEDC1ABusinessDelegate.getExcIEEEDC1AInstance().assignEfd2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Efd2", exc);
    }
  }

  /**
   * unassign Efd2 on ExcIEEEDC1A
   *
   * @param command UnAssignEfd2FromExcIEEEDC1ACommand
   */
  @PutMapping("/unAssignEfd2")
  public void unAssignEfd2(
      @RequestBody(required = true) UnAssignEfd2FromExcIEEEDC1ACommand command) {
    try {
      ExcIEEEDC1ABusinessDelegate.getExcIEEEDC1AInstance().unAssignEfd2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Efd2", exc);
    }
  }

  /**
   * save Exclim on ExcIEEEDC1A
   *
   * @param command AssignExclimToExcIEEEDC1ACommand
   */
  @PutMapping("/assignExclim")
  public void assignExclim(@RequestBody AssignExclimToExcIEEEDC1ACommand command) {
    try {
      ExcIEEEDC1ABusinessDelegate.getExcIEEEDC1AInstance().assignExclim(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Exclim", exc);
    }
  }

  /**
   * unassign Exclim on ExcIEEEDC1A
   *
   * @param command UnAssignExclimFromExcIEEEDC1ACommand
   */
  @PutMapping("/unAssignExclim")
  public void unAssignExclim(
      @RequestBody(required = true) UnAssignExclimFromExcIEEEDC1ACommand command) {
    try {
      ExcIEEEDC1ABusinessDelegate.getExcIEEEDC1AInstance().unAssignExclim(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Exclim", exc);
    }
  }

  /**
   * save Ka on ExcIEEEDC1A
   *
   * @param command AssignKaToExcIEEEDC1ACommand
   */
  @PutMapping("/assignKa")
  public void assignKa(@RequestBody AssignKaToExcIEEEDC1ACommand command) {
    try {
      ExcIEEEDC1ABusinessDelegate.getExcIEEEDC1AInstance().assignKa(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ka", exc);
    }
  }

  /**
   * unassign Ka on ExcIEEEDC1A
   *
   * @param command UnAssignKaFromExcIEEEDC1ACommand
   */
  @PutMapping("/unAssignKa")
  public void unAssignKa(@RequestBody(required = true) UnAssignKaFromExcIEEEDC1ACommand command) {
    try {
      ExcIEEEDC1ABusinessDelegate.getExcIEEEDC1AInstance().unAssignKa(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ka", exc);
    }
  }

  /**
   * save Ke on ExcIEEEDC1A
   *
   * @param command AssignKeToExcIEEEDC1ACommand
   */
  @PutMapping("/assignKe")
  public void assignKe(@RequestBody AssignKeToExcIEEEDC1ACommand command) {
    try {
      ExcIEEEDC1ABusinessDelegate.getExcIEEEDC1AInstance().assignKe(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ke", exc);
    }
  }

  /**
   * unassign Ke on ExcIEEEDC1A
   *
   * @param command UnAssignKeFromExcIEEEDC1ACommand
   */
  @PutMapping("/unAssignKe")
  public void unAssignKe(@RequestBody(required = true) UnAssignKeFromExcIEEEDC1ACommand command) {
    try {
      ExcIEEEDC1ABusinessDelegate.getExcIEEEDC1AInstance().unAssignKe(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ke", exc);
    }
  }

  /**
   * save Kf on ExcIEEEDC1A
   *
   * @param command AssignKfToExcIEEEDC1ACommand
   */
  @PutMapping("/assignKf")
  public void assignKf(@RequestBody AssignKfToExcIEEEDC1ACommand command) {
    try {
      ExcIEEEDC1ABusinessDelegate.getExcIEEEDC1AInstance().assignKf(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kf", exc);
    }
  }

  /**
   * unassign Kf on ExcIEEEDC1A
   *
   * @param command UnAssignKfFromExcIEEEDC1ACommand
   */
  @PutMapping("/unAssignKf")
  public void unAssignKf(@RequestBody(required = true) UnAssignKfFromExcIEEEDC1ACommand command) {
    try {
      ExcIEEEDC1ABusinessDelegate.getExcIEEEDC1AInstance().unAssignKf(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kf", exc);
    }
  }

  /**
   * save Seefd1 on ExcIEEEDC1A
   *
   * @param command AssignSeefd1ToExcIEEEDC1ACommand
   */
  @PutMapping("/assignSeefd1")
  public void assignSeefd1(@RequestBody AssignSeefd1ToExcIEEEDC1ACommand command) {
    try {
      ExcIEEEDC1ABusinessDelegate.getExcIEEEDC1AInstance().assignSeefd1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Seefd1", exc);
    }
  }

  /**
   * unassign Seefd1 on ExcIEEEDC1A
   *
   * @param command UnAssignSeefd1FromExcIEEEDC1ACommand
   */
  @PutMapping("/unAssignSeefd1")
  public void unAssignSeefd1(
      @RequestBody(required = true) UnAssignSeefd1FromExcIEEEDC1ACommand command) {
    try {
      ExcIEEEDC1ABusinessDelegate.getExcIEEEDC1AInstance().unAssignSeefd1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Seefd1", exc);
    }
  }

  /**
   * save Seefd2 on ExcIEEEDC1A
   *
   * @param command AssignSeefd2ToExcIEEEDC1ACommand
   */
  @PutMapping("/assignSeefd2")
  public void assignSeefd2(@RequestBody AssignSeefd2ToExcIEEEDC1ACommand command) {
    try {
      ExcIEEEDC1ABusinessDelegate.getExcIEEEDC1AInstance().assignSeefd2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Seefd2", exc);
    }
  }

  /**
   * unassign Seefd2 on ExcIEEEDC1A
   *
   * @param command UnAssignSeefd2FromExcIEEEDC1ACommand
   */
  @PutMapping("/unAssignSeefd2")
  public void unAssignSeefd2(
      @RequestBody(required = true) UnAssignSeefd2FromExcIEEEDC1ACommand command) {
    try {
      ExcIEEEDC1ABusinessDelegate.getExcIEEEDC1AInstance().unAssignSeefd2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Seefd2", exc);
    }
  }

  /**
   * save Ta on ExcIEEEDC1A
   *
   * @param command AssignTaToExcIEEEDC1ACommand
   */
  @PutMapping("/assignTa")
  public void assignTa(@RequestBody AssignTaToExcIEEEDC1ACommand command) {
    try {
      ExcIEEEDC1ABusinessDelegate.getExcIEEEDC1AInstance().assignTa(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ta", exc);
    }
  }

  /**
   * unassign Ta on ExcIEEEDC1A
   *
   * @param command UnAssignTaFromExcIEEEDC1ACommand
   */
  @PutMapping("/unAssignTa")
  public void unAssignTa(@RequestBody(required = true) UnAssignTaFromExcIEEEDC1ACommand command) {
    try {
      ExcIEEEDC1ABusinessDelegate.getExcIEEEDC1AInstance().unAssignTa(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ta", exc);
    }
  }

  /**
   * save Tb on ExcIEEEDC1A
   *
   * @param command AssignTbToExcIEEEDC1ACommand
   */
  @PutMapping("/assignTb")
  public void assignTb(@RequestBody AssignTbToExcIEEEDC1ACommand command) {
    try {
      ExcIEEEDC1ABusinessDelegate.getExcIEEEDC1AInstance().assignTb(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tb", exc);
    }
  }

  /**
   * unassign Tb on ExcIEEEDC1A
   *
   * @param command UnAssignTbFromExcIEEEDC1ACommand
   */
  @PutMapping("/unAssignTb")
  public void unAssignTb(@RequestBody(required = true) UnAssignTbFromExcIEEEDC1ACommand command) {
    try {
      ExcIEEEDC1ABusinessDelegate.getExcIEEEDC1AInstance().unAssignTb(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tb", exc);
    }
  }

  /**
   * save Tc on ExcIEEEDC1A
   *
   * @param command AssignTcToExcIEEEDC1ACommand
   */
  @PutMapping("/assignTc")
  public void assignTc(@RequestBody AssignTcToExcIEEEDC1ACommand command) {
    try {
      ExcIEEEDC1ABusinessDelegate.getExcIEEEDC1AInstance().assignTc(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tc", exc);
    }
  }

  /**
   * unassign Tc on ExcIEEEDC1A
   *
   * @param command UnAssignTcFromExcIEEEDC1ACommand
   */
  @PutMapping("/unAssignTc")
  public void unAssignTc(@RequestBody(required = true) UnAssignTcFromExcIEEEDC1ACommand command) {
    try {
      ExcIEEEDC1ABusinessDelegate.getExcIEEEDC1AInstance().unAssignTc(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tc", exc);
    }
  }

  /**
   * save Te on ExcIEEEDC1A
   *
   * @param command AssignTeToExcIEEEDC1ACommand
   */
  @PutMapping("/assignTe")
  public void assignTe(@RequestBody AssignTeToExcIEEEDC1ACommand command) {
    try {
      ExcIEEEDC1ABusinessDelegate.getExcIEEEDC1AInstance().assignTe(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Te", exc);
    }
  }

  /**
   * unassign Te on ExcIEEEDC1A
   *
   * @param command UnAssignTeFromExcIEEEDC1ACommand
   */
  @PutMapping("/unAssignTe")
  public void unAssignTe(@RequestBody(required = true) UnAssignTeFromExcIEEEDC1ACommand command) {
    try {
      ExcIEEEDC1ABusinessDelegate.getExcIEEEDC1AInstance().unAssignTe(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Te", exc);
    }
  }

  /**
   * save Tf on ExcIEEEDC1A
   *
   * @param command AssignTfToExcIEEEDC1ACommand
   */
  @PutMapping("/assignTf")
  public void assignTf(@RequestBody AssignTfToExcIEEEDC1ACommand command) {
    try {
      ExcIEEEDC1ABusinessDelegate.getExcIEEEDC1AInstance().assignTf(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tf", exc);
    }
  }

  /**
   * unassign Tf on ExcIEEEDC1A
   *
   * @param command UnAssignTfFromExcIEEEDC1ACommand
   */
  @PutMapping("/unAssignTf")
  public void unAssignTf(@RequestBody(required = true) UnAssignTfFromExcIEEEDC1ACommand command) {
    try {
      ExcIEEEDC1ABusinessDelegate.getExcIEEEDC1AInstance().unAssignTf(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tf", exc);
    }
  }

  /**
   * save Uelin on ExcIEEEDC1A
   *
   * @param command AssignUelinToExcIEEEDC1ACommand
   */
  @PutMapping("/assignUelin")
  public void assignUelin(@RequestBody AssignUelinToExcIEEEDC1ACommand command) {
    try {
      ExcIEEEDC1ABusinessDelegate.getExcIEEEDC1AInstance().assignUelin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Uelin", exc);
    }
  }

  /**
   * unassign Uelin on ExcIEEEDC1A
   *
   * @param command UnAssignUelinFromExcIEEEDC1ACommand
   */
  @PutMapping("/unAssignUelin")
  public void unAssignUelin(
      @RequestBody(required = true) UnAssignUelinFromExcIEEEDC1ACommand command) {
    try {
      ExcIEEEDC1ABusinessDelegate.getExcIEEEDC1AInstance().unAssignUelin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Uelin", exc);
    }
  }

  /**
   * save Vrmax on ExcIEEEDC1A
   *
   * @param command AssignVrmaxToExcIEEEDC1ACommand
   */
  @PutMapping("/assignVrmax")
  public void assignVrmax(@RequestBody AssignVrmaxToExcIEEEDC1ACommand command) {
    try {
      ExcIEEEDC1ABusinessDelegate.getExcIEEEDC1AInstance().assignVrmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vrmax", exc);
    }
  }

  /**
   * unassign Vrmax on ExcIEEEDC1A
   *
   * @param command UnAssignVrmaxFromExcIEEEDC1ACommand
   */
  @PutMapping("/unAssignVrmax")
  public void unAssignVrmax(
      @RequestBody(required = true) UnAssignVrmaxFromExcIEEEDC1ACommand command) {
    try {
      ExcIEEEDC1ABusinessDelegate.getExcIEEEDC1AInstance().unAssignVrmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vrmax", exc);
    }
  }

  /**
   * save Vrmin on ExcIEEEDC1A
   *
   * @param command AssignVrminToExcIEEEDC1ACommand
   */
  @PutMapping("/assignVrmin")
  public void assignVrmin(@RequestBody AssignVrminToExcIEEEDC1ACommand command) {
    try {
      ExcIEEEDC1ABusinessDelegate.getExcIEEEDC1AInstance().assignVrmin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vrmin", exc);
    }
  }

  /**
   * unassign Vrmin on ExcIEEEDC1A
   *
   * @param command UnAssignVrminFromExcIEEEDC1ACommand
   */
  @PutMapping("/unAssignVrmin")
  public void unAssignVrmin(
      @RequestBody(required = true) UnAssignVrminFromExcIEEEDC1ACommand command) {
    try {
      ExcIEEEDC1ABusinessDelegate.getExcIEEEDC1AInstance().unAssignVrmin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vrmin", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected ExcIEEEDC1A excIEEEDC1A = null;
  private static final Logger LOGGER =
      Logger.getLogger(ExcIEEEDC1ACommandRestController.class.getName());
}
