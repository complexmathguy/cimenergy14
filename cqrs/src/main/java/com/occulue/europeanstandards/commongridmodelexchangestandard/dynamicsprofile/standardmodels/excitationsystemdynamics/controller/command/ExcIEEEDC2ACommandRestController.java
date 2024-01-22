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
 * Implements Spring Controller command CQRS processing for entity ExcIEEEDC2A.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcIEEEDC2A")
public class ExcIEEEDC2ACommandRestController extends BaseSpringRestController {

  /**
   * Handles create a ExcIEEEDC2A. if not key provided, calls create, otherwise calls save
   *
   * @param ExcIEEEDC2A excIEEEDC2A
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateExcIEEEDC2ACommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          ExcIEEEDC2ABusinessDelegate.getExcIEEEDC2AInstance().createExcIEEEDC2A(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a ExcIEEEDC2A. if no key provided, calls create, otherwise calls save
   *
   * @param ExcIEEEDC2A excIEEEDC2A
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateExcIEEEDC2ACommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateExcIEEEDC2ACommand
      // -----------------------------------------------
      completableFuture =
          ExcIEEEDC2ABusinessDelegate.getExcIEEEDC2AInstance().updateExcIEEEDC2A(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "ExcIEEEDC2AController:update() - successfully update ExcIEEEDC2A - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a ExcIEEEDC2A entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID excIEEEDC2AId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteExcIEEEDC2ACommand command = new DeleteExcIEEEDC2ACommand(excIEEEDC2AId);

    try {
      ExcIEEEDC2ABusinessDelegate delegate = ExcIEEEDC2ABusinessDelegate.getExcIEEEDC2AInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING, "Successfully deleted ExcIEEEDC2A with key " + command.getExcIEEEDC2AId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Efd1 on ExcIEEEDC2A
   *
   * @param command AssignEfd1ToExcIEEEDC2ACommand
   */
  @PutMapping("/assignEfd1")
  public void assignEfd1(@RequestBody AssignEfd1ToExcIEEEDC2ACommand command) {
    try {
      ExcIEEEDC2ABusinessDelegate.getExcIEEEDC2AInstance().assignEfd1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Efd1", exc);
    }
  }

  /**
   * unassign Efd1 on ExcIEEEDC2A
   *
   * @param command UnAssignEfd1FromExcIEEEDC2ACommand
   */
  @PutMapping("/unAssignEfd1")
  public void unAssignEfd1(
      @RequestBody(required = true) UnAssignEfd1FromExcIEEEDC2ACommand command) {
    try {
      ExcIEEEDC2ABusinessDelegate.getExcIEEEDC2AInstance().unAssignEfd1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Efd1", exc);
    }
  }

  /**
   * save Efd2 on ExcIEEEDC2A
   *
   * @param command AssignEfd2ToExcIEEEDC2ACommand
   */
  @PutMapping("/assignEfd2")
  public void assignEfd2(@RequestBody AssignEfd2ToExcIEEEDC2ACommand command) {
    try {
      ExcIEEEDC2ABusinessDelegate.getExcIEEEDC2AInstance().assignEfd2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Efd2", exc);
    }
  }

  /**
   * unassign Efd2 on ExcIEEEDC2A
   *
   * @param command UnAssignEfd2FromExcIEEEDC2ACommand
   */
  @PutMapping("/unAssignEfd2")
  public void unAssignEfd2(
      @RequestBody(required = true) UnAssignEfd2FromExcIEEEDC2ACommand command) {
    try {
      ExcIEEEDC2ABusinessDelegate.getExcIEEEDC2AInstance().unAssignEfd2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Efd2", exc);
    }
  }

  /**
   * save Exclim on ExcIEEEDC2A
   *
   * @param command AssignExclimToExcIEEEDC2ACommand
   */
  @PutMapping("/assignExclim")
  public void assignExclim(@RequestBody AssignExclimToExcIEEEDC2ACommand command) {
    try {
      ExcIEEEDC2ABusinessDelegate.getExcIEEEDC2AInstance().assignExclim(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Exclim", exc);
    }
  }

  /**
   * unassign Exclim on ExcIEEEDC2A
   *
   * @param command UnAssignExclimFromExcIEEEDC2ACommand
   */
  @PutMapping("/unAssignExclim")
  public void unAssignExclim(
      @RequestBody(required = true) UnAssignExclimFromExcIEEEDC2ACommand command) {
    try {
      ExcIEEEDC2ABusinessDelegate.getExcIEEEDC2AInstance().unAssignExclim(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Exclim", exc);
    }
  }

  /**
   * save Ka on ExcIEEEDC2A
   *
   * @param command AssignKaToExcIEEEDC2ACommand
   */
  @PutMapping("/assignKa")
  public void assignKa(@RequestBody AssignKaToExcIEEEDC2ACommand command) {
    try {
      ExcIEEEDC2ABusinessDelegate.getExcIEEEDC2AInstance().assignKa(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ka", exc);
    }
  }

  /**
   * unassign Ka on ExcIEEEDC2A
   *
   * @param command UnAssignKaFromExcIEEEDC2ACommand
   */
  @PutMapping("/unAssignKa")
  public void unAssignKa(@RequestBody(required = true) UnAssignKaFromExcIEEEDC2ACommand command) {
    try {
      ExcIEEEDC2ABusinessDelegate.getExcIEEEDC2AInstance().unAssignKa(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ka", exc);
    }
  }

  /**
   * save Ke on ExcIEEEDC2A
   *
   * @param command AssignKeToExcIEEEDC2ACommand
   */
  @PutMapping("/assignKe")
  public void assignKe(@RequestBody AssignKeToExcIEEEDC2ACommand command) {
    try {
      ExcIEEEDC2ABusinessDelegate.getExcIEEEDC2AInstance().assignKe(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ke", exc);
    }
  }

  /**
   * unassign Ke on ExcIEEEDC2A
   *
   * @param command UnAssignKeFromExcIEEEDC2ACommand
   */
  @PutMapping("/unAssignKe")
  public void unAssignKe(@RequestBody(required = true) UnAssignKeFromExcIEEEDC2ACommand command) {
    try {
      ExcIEEEDC2ABusinessDelegate.getExcIEEEDC2AInstance().unAssignKe(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ke", exc);
    }
  }

  /**
   * save Kf on ExcIEEEDC2A
   *
   * @param command AssignKfToExcIEEEDC2ACommand
   */
  @PutMapping("/assignKf")
  public void assignKf(@RequestBody AssignKfToExcIEEEDC2ACommand command) {
    try {
      ExcIEEEDC2ABusinessDelegate.getExcIEEEDC2AInstance().assignKf(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kf", exc);
    }
  }

  /**
   * unassign Kf on ExcIEEEDC2A
   *
   * @param command UnAssignKfFromExcIEEEDC2ACommand
   */
  @PutMapping("/unAssignKf")
  public void unAssignKf(@RequestBody(required = true) UnAssignKfFromExcIEEEDC2ACommand command) {
    try {
      ExcIEEEDC2ABusinessDelegate.getExcIEEEDC2AInstance().unAssignKf(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kf", exc);
    }
  }

  /**
   * save Seefd1 on ExcIEEEDC2A
   *
   * @param command AssignSeefd1ToExcIEEEDC2ACommand
   */
  @PutMapping("/assignSeefd1")
  public void assignSeefd1(@RequestBody AssignSeefd1ToExcIEEEDC2ACommand command) {
    try {
      ExcIEEEDC2ABusinessDelegate.getExcIEEEDC2AInstance().assignSeefd1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Seefd1", exc);
    }
  }

  /**
   * unassign Seefd1 on ExcIEEEDC2A
   *
   * @param command UnAssignSeefd1FromExcIEEEDC2ACommand
   */
  @PutMapping("/unAssignSeefd1")
  public void unAssignSeefd1(
      @RequestBody(required = true) UnAssignSeefd1FromExcIEEEDC2ACommand command) {
    try {
      ExcIEEEDC2ABusinessDelegate.getExcIEEEDC2AInstance().unAssignSeefd1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Seefd1", exc);
    }
  }

  /**
   * save Seefd2 on ExcIEEEDC2A
   *
   * @param command AssignSeefd2ToExcIEEEDC2ACommand
   */
  @PutMapping("/assignSeefd2")
  public void assignSeefd2(@RequestBody AssignSeefd2ToExcIEEEDC2ACommand command) {
    try {
      ExcIEEEDC2ABusinessDelegate.getExcIEEEDC2AInstance().assignSeefd2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Seefd2", exc);
    }
  }

  /**
   * unassign Seefd2 on ExcIEEEDC2A
   *
   * @param command UnAssignSeefd2FromExcIEEEDC2ACommand
   */
  @PutMapping("/unAssignSeefd2")
  public void unAssignSeefd2(
      @RequestBody(required = true) UnAssignSeefd2FromExcIEEEDC2ACommand command) {
    try {
      ExcIEEEDC2ABusinessDelegate.getExcIEEEDC2AInstance().unAssignSeefd2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Seefd2", exc);
    }
  }

  /**
   * save Ta on ExcIEEEDC2A
   *
   * @param command AssignTaToExcIEEEDC2ACommand
   */
  @PutMapping("/assignTa")
  public void assignTa(@RequestBody AssignTaToExcIEEEDC2ACommand command) {
    try {
      ExcIEEEDC2ABusinessDelegate.getExcIEEEDC2AInstance().assignTa(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ta", exc);
    }
  }

  /**
   * unassign Ta on ExcIEEEDC2A
   *
   * @param command UnAssignTaFromExcIEEEDC2ACommand
   */
  @PutMapping("/unAssignTa")
  public void unAssignTa(@RequestBody(required = true) UnAssignTaFromExcIEEEDC2ACommand command) {
    try {
      ExcIEEEDC2ABusinessDelegate.getExcIEEEDC2AInstance().unAssignTa(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ta", exc);
    }
  }

  /**
   * save Tb on ExcIEEEDC2A
   *
   * @param command AssignTbToExcIEEEDC2ACommand
   */
  @PutMapping("/assignTb")
  public void assignTb(@RequestBody AssignTbToExcIEEEDC2ACommand command) {
    try {
      ExcIEEEDC2ABusinessDelegate.getExcIEEEDC2AInstance().assignTb(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tb", exc);
    }
  }

  /**
   * unassign Tb on ExcIEEEDC2A
   *
   * @param command UnAssignTbFromExcIEEEDC2ACommand
   */
  @PutMapping("/unAssignTb")
  public void unAssignTb(@RequestBody(required = true) UnAssignTbFromExcIEEEDC2ACommand command) {
    try {
      ExcIEEEDC2ABusinessDelegate.getExcIEEEDC2AInstance().unAssignTb(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tb", exc);
    }
  }

  /**
   * save Tc on ExcIEEEDC2A
   *
   * @param command AssignTcToExcIEEEDC2ACommand
   */
  @PutMapping("/assignTc")
  public void assignTc(@RequestBody AssignTcToExcIEEEDC2ACommand command) {
    try {
      ExcIEEEDC2ABusinessDelegate.getExcIEEEDC2AInstance().assignTc(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tc", exc);
    }
  }

  /**
   * unassign Tc on ExcIEEEDC2A
   *
   * @param command UnAssignTcFromExcIEEEDC2ACommand
   */
  @PutMapping("/unAssignTc")
  public void unAssignTc(@RequestBody(required = true) UnAssignTcFromExcIEEEDC2ACommand command) {
    try {
      ExcIEEEDC2ABusinessDelegate.getExcIEEEDC2AInstance().unAssignTc(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tc", exc);
    }
  }

  /**
   * save Te on ExcIEEEDC2A
   *
   * @param command AssignTeToExcIEEEDC2ACommand
   */
  @PutMapping("/assignTe")
  public void assignTe(@RequestBody AssignTeToExcIEEEDC2ACommand command) {
    try {
      ExcIEEEDC2ABusinessDelegate.getExcIEEEDC2AInstance().assignTe(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Te", exc);
    }
  }

  /**
   * unassign Te on ExcIEEEDC2A
   *
   * @param command UnAssignTeFromExcIEEEDC2ACommand
   */
  @PutMapping("/unAssignTe")
  public void unAssignTe(@RequestBody(required = true) UnAssignTeFromExcIEEEDC2ACommand command) {
    try {
      ExcIEEEDC2ABusinessDelegate.getExcIEEEDC2AInstance().unAssignTe(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Te", exc);
    }
  }

  /**
   * save Tf on ExcIEEEDC2A
   *
   * @param command AssignTfToExcIEEEDC2ACommand
   */
  @PutMapping("/assignTf")
  public void assignTf(@RequestBody AssignTfToExcIEEEDC2ACommand command) {
    try {
      ExcIEEEDC2ABusinessDelegate.getExcIEEEDC2AInstance().assignTf(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tf", exc);
    }
  }

  /**
   * unassign Tf on ExcIEEEDC2A
   *
   * @param command UnAssignTfFromExcIEEEDC2ACommand
   */
  @PutMapping("/unAssignTf")
  public void unAssignTf(@RequestBody(required = true) UnAssignTfFromExcIEEEDC2ACommand command) {
    try {
      ExcIEEEDC2ABusinessDelegate.getExcIEEEDC2AInstance().unAssignTf(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tf", exc);
    }
  }

  /**
   * save Uelin on ExcIEEEDC2A
   *
   * @param command AssignUelinToExcIEEEDC2ACommand
   */
  @PutMapping("/assignUelin")
  public void assignUelin(@RequestBody AssignUelinToExcIEEEDC2ACommand command) {
    try {
      ExcIEEEDC2ABusinessDelegate.getExcIEEEDC2AInstance().assignUelin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Uelin", exc);
    }
  }

  /**
   * unassign Uelin on ExcIEEEDC2A
   *
   * @param command UnAssignUelinFromExcIEEEDC2ACommand
   */
  @PutMapping("/unAssignUelin")
  public void unAssignUelin(
      @RequestBody(required = true) UnAssignUelinFromExcIEEEDC2ACommand command) {
    try {
      ExcIEEEDC2ABusinessDelegate.getExcIEEEDC2AInstance().unAssignUelin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Uelin", exc);
    }
  }

  /**
   * save Vrmax on ExcIEEEDC2A
   *
   * @param command AssignVrmaxToExcIEEEDC2ACommand
   */
  @PutMapping("/assignVrmax")
  public void assignVrmax(@RequestBody AssignVrmaxToExcIEEEDC2ACommand command) {
    try {
      ExcIEEEDC2ABusinessDelegate.getExcIEEEDC2AInstance().assignVrmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vrmax", exc);
    }
  }

  /**
   * unassign Vrmax on ExcIEEEDC2A
   *
   * @param command UnAssignVrmaxFromExcIEEEDC2ACommand
   */
  @PutMapping("/unAssignVrmax")
  public void unAssignVrmax(
      @RequestBody(required = true) UnAssignVrmaxFromExcIEEEDC2ACommand command) {
    try {
      ExcIEEEDC2ABusinessDelegate.getExcIEEEDC2AInstance().unAssignVrmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vrmax", exc);
    }
  }

  /**
   * save Vrmin on ExcIEEEDC2A
   *
   * @param command AssignVrminToExcIEEEDC2ACommand
   */
  @PutMapping("/assignVrmin")
  public void assignVrmin(@RequestBody AssignVrminToExcIEEEDC2ACommand command) {
    try {
      ExcIEEEDC2ABusinessDelegate.getExcIEEEDC2AInstance().assignVrmin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vrmin", exc);
    }
  }

  /**
   * unassign Vrmin on ExcIEEEDC2A
   *
   * @param command UnAssignVrminFromExcIEEEDC2ACommand
   */
  @PutMapping("/unAssignVrmin")
  public void unAssignVrmin(
      @RequestBody(required = true) UnAssignVrminFromExcIEEEDC2ACommand command) {
    try {
      ExcIEEEDC2ABusinessDelegate.getExcIEEEDC2AInstance().unAssignVrmin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vrmin", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected ExcIEEEDC2A excIEEEDC2A = null;
  private static final Logger LOGGER =
      Logger.getLogger(ExcIEEEDC2ACommandRestController.class.getName());
}
