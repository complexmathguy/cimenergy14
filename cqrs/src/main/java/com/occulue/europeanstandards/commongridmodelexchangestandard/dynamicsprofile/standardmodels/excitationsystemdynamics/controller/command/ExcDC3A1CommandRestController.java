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
 * Implements Spring Controller command CQRS processing for entity ExcDC3A1.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcDC3A1")
public class ExcDC3A1CommandRestController extends BaseSpringRestController {

  /**
   * Handles create a ExcDC3A1. if not key provided, calls create, otherwise calls save
   *
   * @param ExcDC3A1 excDC3A1
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateExcDC3A1Command command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture = ExcDC3A1BusinessDelegate.getExcDC3A1Instance().createExcDC3A1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a ExcDC3A1. if no key provided, calls create, otherwise calls save
   *
   * @param ExcDC3A1 excDC3A1
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateExcDC3A1Command command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateExcDC3A1Command
      // -----------------------------------------------
      completableFuture = ExcDC3A1BusinessDelegate.getExcDC3A1Instance().updateExcDC3A1(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "ExcDC3A1Controller:update() - successfully update ExcDC3A1 - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a ExcDC3A1 entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID excDC3A1Id) {
    CompletableFuture<Void> completableFuture = null;
    DeleteExcDC3A1Command command = new DeleteExcDC3A1Command(excDC3A1Id);

    try {
      ExcDC3A1BusinessDelegate delegate = ExcDC3A1BusinessDelegate.getExcDC3A1Instance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING, "Successfully deleted ExcDC3A1 with key " + command.getExcDC3A1Id());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Exclim on ExcDC3A1
   *
   * @param command AssignExclimToExcDC3A1Command
   */
  @PutMapping("/assignExclim")
  public void assignExclim(@RequestBody AssignExclimToExcDC3A1Command command) {
    try {
      ExcDC3A1BusinessDelegate.getExcDC3A1Instance().assignExclim(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Exclim", exc);
    }
  }

  /**
   * unassign Exclim on ExcDC3A1
   *
   * @param command UnAssignExclimFromExcDC3A1Command
   */
  @PutMapping("/unAssignExclim")
  public void unAssignExclim(
      @RequestBody(required = true) UnAssignExclimFromExcDC3A1Command command) {
    try {
      ExcDC3A1BusinessDelegate.getExcDC3A1Instance().unAssignExclim(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Exclim", exc);
    }
  }

  /**
   * save Ka on ExcDC3A1
   *
   * @param command AssignKaToExcDC3A1Command
   */
  @PutMapping("/assignKa")
  public void assignKa(@RequestBody AssignKaToExcDC3A1Command command) {
    try {
      ExcDC3A1BusinessDelegate.getExcDC3A1Instance().assignKa(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ka", exc);
    }
  }

  /**
   * unassign Ka on ExcDC3A1
   *
   * @param command UnAssignKaFromExcDC3A1Command
   */
  @PutMapping("/unAssignKa")
  public void unAssignKa(@RequestBody(required = true) UnAssignKaFromExcDC3A1Command command) {
    try {
      ExcDC3A1BusinessDelegate.getExcDC3A1Instance().unAssignKa(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ka", exc);
    }
  }

  /**
   * save Ke on ExcDC3A1
   *
   * @param command AssignKeToExcDC3A1Command
   */
  @PutMapping("/assignKe")
  public void assignKe(@RequestBody AssignKeToExcDC3A1Command command) {
    try {
      ExcDC3A1BusinessDelegate.getExcDC3A1Instance().assignKe(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ke", exc);
    }
  }

  /**
   * unassign Ke on ExcDC3A1
   *
   * @param command UnAssignKeFromExcDC3A1Command
   */
  @PutMapping("/unAssignKe")
  public void unAssignKe(@RequestBody(required = true) UnAssignKeFromExcDC3A1Command command) {
    try {
      ExcDC3A1BusinessDelegate.getExcDC3A1Instance().unAssignKe(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ke", exc);
    }
  }

  /**
   * save Kf on ExcDC3A1
   *
   * @param command AssignKfToExcDC3A1Command
   */
  @PutMapping("/assignKf")
  public void assignKf(@RequestBody AssignKfToExcDC3A1Command command) {
    try {
      ExcDC3A1BusinessDelegate.getExcDC3A1Instance().assignKf(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kf", exc);
    }
  }

  /**
   * unassign Kf on ExcDC3A1
   *
   * @param command UnAssignKfFromExcDC3A1Command
   */
  @PutMapping("/unAssignKf")
  public void unAssignKf(@RequestBody(required = true) UnAssignKfFromExcDC3A1Command command) {
    try {
      ExcDC3A1BusinessDelegate.getExcDC3A1Instance().unAssignKf(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kf", exc);
    }
  }

  /**
   * save Ki on ExcDC3A1
   *
   * @param command AssignKiToExcDC3A1Command
   */
  @PutMapping("/assignKi")
  public void assignKi(@RequestBody AssignKiToExcDC3A1Command command) {
    try {
      ExcDC3A1BusinessDelegate.getExcDC3A1Instance().assignKi(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ki", exc);
    }
  }

  /**
   * unassign Ki on ExcDC3A1
   *
   * @param command UnAssignKiFromExcDC3A1Command
   */
  @PutMapping("/unAssignKi")
  public void unAssignKi(@RequestBody(required = true) UnAssignKiFromExcDC3A1Command command) {
    try {
      ExcDC3A1BusinessDelegate.getExcDC3A1Instance().unAssignKi(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ki", exc);
    }
  }

  /**
   * save Kp on ExcDC3A1
   *
   * @param command AssignKpToExcDC3A1Command
   */
  @PutMapping("/assignKp")
  public void assignKp(@RequestBody AssignKpToExcDC3A1Command command) {
    try {
      ExcDC3A1BusinessDelegate.getExcDC3A1Instance().assignKp(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kp", exc);
    }
  }

  /**
   * unassign Kp on ExcDC3A1
   *
   * @param command UnAssignKpFromExcDC3A1Command
   */
  @PutMapping("/unAssignKp")
  public void unAssignKp(@RequestBody(required = true) UnAssignKpFromExcDC3A1Command command) {
    try {
      ExcDC3A1BusinessDelegate.getExcDC3A1Instance().unAssignKp(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kp", exc);
    }
  }

  /**
   * save Ta on ExcDC3A1
   *
   * @param command AssignTaToExcDC3A1Command
   */
  @PutMapping("/assignTa")
  public void assignTa(@RequestBody AssignTaToExcDC3A1Command command) {
    try {
      ExcDC3A1BusinessDelegate.getExcDC3A1Instance().assignTa(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ta", exc);
    }
  }

  /**
   * unassign Ta on ExcDC3A1
   *
   * @param command UnAssignTaFromExcDC3A1Command
   */
  @PutMapping("/unAssignTa")
  public void unAssignTa(@RequestBody(required = true) UnAssignTaFromExcDC3A1Command command) {
    try {
      ExcDC3A1BusinessDelegate.getExcDC3A1Instance().unAssignTa(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ta", exc);
    }
  }

  /**
   * save Te on ExcDC3A1
   *
   * @param command AssignTeToExcDC3A1Command
   */
  @PutMapping("/assignTe")
  public void assignTe(@RequestBody AssignTeToExcDC3A1Command command) {
    try {
      ExcDC3A1BusinessDelegate.getExcDC3A1Instance().assignTe(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Te", exc);
    }
  }

  /**
   * unassign Te on ExcDC3A1
   *
   * @param command UnAssignTeFromExcDC3A1Command
   */
  @PutMapping("/unAssignTe")
  public void unAssignTe(@RequestBody(required = true) UnAssignTeFromExcDC3A1Command command) {
    try {
      ExcDC3A1BusinessDelegate.getExcDC3A1Instance().unAssignTe(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Te", exc);
    }
  }

  /**
   * save Tf on ExcDC3A1
   *
   * @param command AssignTfToExcDC3A1Command
   */
  @PutMapping("/assignTf")
  public void assignTf(@RequestBody AssignTfToExcDC3A1Command command) {
    try {
      ExcDC3A1BusinessDelegate.getExcDC3A1Instance().assignTf(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tf", exc);
    }
  }

  /**
   * unassign Tf on ExcDC3A1
   *
   * @param command UnAssignTfFromExcDC3A1Command
   */
  @PutMapping("/unAssignTf")
  public void unAssignTf(@RequestBody(required = true) UnAssignTfFromExcDC3A1Command command) {
    try {
      ExcDC3A1BusinessDelegate.getExcDC3A1Instance().unAssignTf(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tf", exc);
    }
  }

  /**
   * save Vb1max on ExcDC3A1
   *
   * @param command AssignVb1maxToExcDC3A1Command
   */
  @PutMapping("/assignVb1max")
  public void assignVb1max(@RequestBody AssignVb1maxToExcDC3A1Command command) {
    try {
      ExcDC3A1BusinessDelegate.getExcDC3A1Instance().assignVb1max(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vb1max", exc);
    }
  }

  /**
   * unassign Vb1max on ExcDC3A1
   *
   * @param command UnAssignVb1maxFromExcDC3A1Command
   */
  @PutMapping("/unAssignVb1max")
  public void unAssignVb1max(
      @RequestBody(required = true) UnAssignVb1maxFromExcDC3A1Command command) {
    try {
      ExcDC3A1BusinessDelegate.getExcDC3A1Instance().unAssignVb1max(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vb1max", exc);
    }
  }

  /**
   * save Vblim on ExcDC3A1
   *
   * @param command AssignVblimToExcDC3A1Command
   */
  @PutMapping("/assignVblim")
  public void assignVblim(@RequestBody AssignVblimToExcDC3A1Command command) {
    try {
      ExcDC3A1BusinessDelegate.getExcDC3A1Instance().assignVblim(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vblim", exc);
    }
  }

  /**
   * unassign Vblim on ExcDC3A1
   *
   * @param command UnAssignVblimFromExcDC3A1Command
   */
  @PutMapping("/unAssignVblim")
  public void unAssignVblim(
      @RequestBody(required = true) UnAssignVblimFromExcDC3A1Command command) {
    try {
      ExcDC3A1BusinessDelegate.getExcDC3A1Instance().unAssignVblim(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vblim", exc);
    }
  }

  /**
   * save Vbmax on ExcDC3A1
   *
   * @param command AssignVbmaxToExcDC3A1Command
   */
  @PutMapping("/assignVbmax")
  public void assignVbmax(@RequestBody AssignVbmaxToExcDC3A1Command command) {
    try {
      ExcDC3A1BusinessDelegate.getExcDC3A1Instance().assignVbmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vbmax", exc);
    }
  }

  /**
   * unassign Vbmax on ExcDC3A1
   *
   * @param command UnAssignVbmaxFromExcDC3A1Command
   */
  @PutMapping("/unAssignVbmax")
  public void unAssignVbmax(
      @RequestBody(required = true) UnAssignVbmaxFromExcDC3A1Command command) {
    try {
      ExcDC3A1BusinessDelegate.getExcDC3A1Instance().unAssignVbmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vbmax", exc);
    }
  }

  /**
   * save Vrmax on ExcDC3A1
   *
   * @param command AssignVrmaxToExcDC3A1Command
   */
  @PutMapping("/assignVrmax")
  public void assignVrmax(@RequestBody AssignVrmaxToExcDC3A1Command command) {
    try {
      ExcDC3A1BusinessDelegate.getExcDC3A1Instance().assignVrmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vrmax", exc);
    }
  }

  /**
   * unassign Vrmax on ExcDC3A1
   *
   * @param command UnAssignVrmaxFromExcDC3A1Command
   */
  @PutMapping("/unAssignVrmax")
  public void unAssignVrmax(
      @RequestBody(required = true) UnAssignVrmaxFromExcDC3A1Command command) {
    try {
      ExcDC3A1BusinessDelegate.getExcDC3A1Instance().unAssignVrmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vrmax", exc);
    }
  }

  /**
   * save Vrmin on ExcDC3A1
   *
   * @param command AssignVrminToExcDC3A1Command
   */
  @PutMapping("/assignVrmin")
  public void assignVrmin(@RequestBody AssignVrminToExcDC3A1Command command) {
    try {
      ExcDC3A1BusinessDelegate.getExcDC3A1Instance().assignVrmin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vrmin", exc);
    }
  }

  /**
   * unassign Vrmin on ExcDC3A1
   *
   * @param command UnAssignVrminFromExcDC3A1Command
   */
  @PutMapping("/unAssignVrmin")
  public void unAssignVrmin(
      @RequestBody(required = true) UnAssignVrminFromExcDC3A1Command command) {
    try {
      ExcDC3A1BusinessDelegate.getExcDC3A1Instance().unAssignVrmin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vrmin", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected ExcDC3A1 excDC3A1 = null;
  private static final Logger LOGGER =
      Logger.getLogger(ExcDC3A1CommandRestController.class.getName());
}
