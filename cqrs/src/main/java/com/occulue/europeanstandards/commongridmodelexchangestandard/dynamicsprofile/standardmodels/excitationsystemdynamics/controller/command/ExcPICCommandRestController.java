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
 * Implements Spring Controller command CQRS processing for entity ExcPIC.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcPIC")
public class ExcPICCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a ExcPIC. if not key provided, calls create, otherwise calls save
   *
   * @param ExcPIC excPIC
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(@RequestBody(required = true) CreateExcPICCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture = ExcPICBusinessDelegate.getExcPICInstance().createExcPIC(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a ExcPIC. if no key provided, calls create, otherwise calls save
   *
   * @param ExcPIC excPIC
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(@RequestBody(required = true) UpdateExcPICCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateExcPICCommand
      // -----------------------------------------------
      completableFuture = ExcPICBusinessDelegate.getExcPICInstance().updateExcPIC(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "ExcPICController:update() - successfully update ExcPIC - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a ExcPIC entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID excPICId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteExcPICCommand command = new DeleteExcPICCommand(excPICId);

    try {
      ExcPICBusinessDelegate delegate = ExcPICBusinessDelegate.getExcPICInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(Level.WARNING, "Successfully deleted ExcPIC with key " + command.getExcPICId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save E1 on ExcPIC
   *
   * @param command AssignE1ToExcPICCommand
   */
  @PutMapping("/assignE1")
  public void assignE1(@RequestBody AssignE1ToExcPICCommand command) {
    try {
      ExcPICBusinessDelegate.getExcPICInstance().assignE1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign E1", exc);
    }
  }

  /**
   * unassign E1 on ExcPIC
   *
   * @param command UnAssignE1FromExcPICCommand
   */
  @PutMapping("/unAssignE1")
  public void unAssignE1(@RequestBody(required = true) UnAssignE1FromExcPICCommand command) {
    try {
      ExcPICBusinessDelegate.getExcPICInstance().unAssignE1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign E1", exc);
    }
  }

  /**
   * save E2 on ExcPIC
   *
   * @param command AssignE2ToExcPICCommand
   */
  @PutMapping("/assignE2")
  public void assignE2(@RequestBody AssignE2ToExcPICCommand command) {
    try {
      ExcPICBusinessDelegate.getExcPICInstance().assignE2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign E2", exc);
    }
  }

  /**
   * unassign E2 on ExcPIC
   *
   * @param command UnAssignE2FromExcPICCommand
   */
  @PutMapping("/unAssignE2")
  public void unAssignE2(@RequestBody(required = true) UnAssignE2FromExcPICCommand command) {
    try {
      ExcPICBusinessDelegate.getExcPICInstance().unAssignE2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign E2", exc);
    }
  }

  /**
   * save Efdmax on ExcPIC
   *
   * @param command AssignEfdmaxToExcPICCommand
   */
  @PutMapping("/assignEfdmax")
  public void assignEfdmax(@RequestBody AssignEfdmaxToExcPICCommand command) {
    try {
      ExcPICBusinessDelegate.getExcPICInstance().assignEfdmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Efdmax", exc);
    }
  }

  /**
   * unassign Efdmax on ExcPIC
   *
   * @param command UnAssignEfdmaxFromExcPICCommand
   */
  @PutMapping("/unAssignEfdmax")
  public void unAssignEfdmax(
      @RequestBody(required = true) UnAssignEfdmaxFromExcPICCommand command) {
    try {
      ExcPICBusinessDelegate.getExcPICInstance().unAssignEfdmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Efdmax", exc);
    }
  }

  /**
   * save Efdmin on ExcPIC
   *
   * @param command AssignEfdminToExcPICCommand
   */
  @PutMapping("/assignEfdmin")
  public void assignEfdmin(@RequestBody AssignEfdminToExcPICCommand command) {
    try {
      ExcPICBusinessDelegate.getExcPICInstance().assignEfdmin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Efdmin", exc);
    }
  }

  /**
   * unassign Efdmin on ExcPIC
   *
   * @param command UnAssignEfdminFromExcPICCommand
   */
  @PutMapping("/unAssignEfdmin")
  public void unAssignEfdmin(
      @RequestBody(required = true) UnAssignEfdminFromExcPICCommand command) {
    try {
      ExcPICBusinessDelegate.getExcPICInstance().unAssignEfdmin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Efdmin", exc);
    }
  }

  /**
   * save Ka on ExcPIC
   *
   * @param command AssignKaToExcPICCommand
   */
  @PutMapping("/assignKa")
  public void assignKa(@RequestBody AssignKaToExcPICCommand command) {
    try {
      ExcPICBusinessDelegate.getExcPICInstance().assignKa(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ka", exc);
    }
  }

  /**
   * unassign Ka on ExcPIC
   *
   * @param command UnAssignKaFromExcPICCommand
   */
  @PutMapping("/unAssignKa")
  public void unAssignKa(@RequestBody(required = true) UnAssignKaFromExcPICCommand command) {
    try {
      ExcPICBusinessDelegate.getExcPICInstance().unAssignKa(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ka", exc);
    }
  }

  /**
   * save Kc on ExcPIC
   *
   * @param command AssignKcToExcPICCommand
   */
  @PutMapping("/assignKc")
  public void assignKc(@RequestBody AssignKcToExcPICCommand command) {
    try {
      ExcPICBusinessDelegate.getExcPICInstance().assignKc(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kc", exc);
    }
  }

  /**
   * unassign Kc on ExcPIC
   *
   * @param command UnAssignKcFromExcPICCommand
   */
  @PutMapping("/unAssignKc")
  public void unAssignKc(@RequestBody(required = true) UnAssignKcFromExcPICCommand command) {
    try {
      ExcPICBusinessDelegate.getExcPICInstance().unAssignKc(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kc", exc);
    }
  }

  /**
   * save Ke on ExcPIC
   *
   * @param command AssignKeToExcPICCommand
   */
  @PutMapping("/assignKe")
  public void assignKe(@RequestBody AssignKeToExcPICCommand command) {
    try {
      ExcPICBusinessDelegate.getExcPICInstance().assignKe(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ke", exc);
    }
  }

  /**
   * unassign Ke on ExcPIC
   *
   * @param command UnAssignKeFromExcPICCommand
   */
  @PutMapping("/unAssignKe")
  public void unAssignKe(@RequestBody(required = true) UnAssignKeFromExcPICCommand command) {
    try {
      ExcPICBusinessDelegate.getExcPICInstance().unAssignKe(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ke", exc);
    }
  }

  /**
   * save Kf on ExcPIC
   *
   * @param command AssignKfToExcPICCommand
   */
  @PutMapping("/assignKf")
  public void assignKf(@RequestBody AssignKfToExcPICCommand command) {
    try {
      ExcPICBusinessDelegate.getExcPICInstance().assignKf(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kf", exc);
    }
  }

  /**
   * unassign Kf on ExcPIC
   *
   * @param command UnAssignKfFromExcPICCommand
   */
  @PutMapping("/unAssignKf")
  public void unAssignKf(@RequestBody(required = true) UnAssignKfFromExcPICCommand command) {
    try {
      ExcPICBusinessDelegate.getExcPICInstance().unAssignKf(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kf", exc);
    }
  }

  /**
   * save Ki on ExcPIC
   *
   * @param command AssignKiToExcPICCommand
   */
  @PutMapping("/assignKi")
  public void assignKi(@RequestBody AssignKiToExcPICCommand command) {
    try {
      ExcPICBusinessDelegate.getExcPICInstance().assignKi(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ki", exc);
    }
  }

  /**
   * unassign Ki on ExcPIC
   *
   * @param command UnAssignKiFromExcPICCommand
   */
  @PutMapping("/unAssignKi")
  public void unAssignKi(@RequestBody(required = true) UnAssignKiFromExcPICCommand command) {
    try {
      ExcPICBusinessDelegate.getExcPICInstance().unAssignKi(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ki", exc);
    }
  }

  /**
   * save Kp on ExcPIC
   *
   * @param command AssignKpToExcPICCommand
   */
  @PutMapping("/assignKp")
  public void assignKp(@RequestBody AssignKpToExcPICCommand command) {
    try {
      ExcPICBusinessDelegate.getExcPICInstance().assignKp(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kp", exc);
    }
  }

  /**
   * unassign Kp on ExcPIC
   *
   * @param command UnAssignKpFromExcPICCommand
   */
  @PutMapping("/unAssignKp")
  public void unAssignKp(@RequestBody(required = true) UnAssignKpFromExcPICCommand command) {
    try {
      ExcPICBusinessDelegate.getExcPICInstance().unAssignKp(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kp", exc);
    }
  }

  /**
   * save Se1 on ExcPIC
   *
   * @param command AssignSe1ToExcPICCommand
   */
  @PutMapping("/assignSe1")
  public void assignSe1(@RequestBody AssignSe1ToExcPICCommand command) {
    try {
      ExcPICBusinessDelegate.getExcPICInstance().assignSe1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Se1", exc);
    }
  }

  /**
   * unassign Se1 on ExcPIC
   *
   * @param command UnAssignSe1FromExcPICCommand
   */
  @PutMapping("/unAssignSe1")
  public void unAssignSe1(@RequestBody(required = true) UnAssignSe1FromExcPICCommand command) {
    try {
      ExcPICBusinessDelegate.getExcPICInstance().unAssignSe1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Se1", exc);
    }
  }

  /**
   * save Se2 on ExcPIC
   *
   * @param command AssignSe2ToExcPICCommand
   */
  @PutMapping("/assignSe2")
  public void assignSe2(@RequestBody AssignSe2ToExcPICCommand command) {
    try {
      ExcPICBusinessDelegate.getExcPICInstance().assignSe2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Se2", exc);
    }
  }

  /**
   * unassign Se2 on ExcPIC
   *
   * @param command UnAssignSe2FromExcPICCommand
   */
  @PutMapping("/unAssignSe2")
  public void unAssignSe2(@RequestBody(required = true) UnAssignSe2FromExcPICCommand command) {
    try {
      ExcPICBusinessDelegate.getExcPICInstance().unAssignSe2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Se2", exc);
    }
  }

  /**
   * save Ta1 on ExcPIC
   *
   * @param command AssignTa1ToExcPICCommand
   */
  @PutMapping("/assignTa1")
  public void assignTa1(@RequestBody AssignTa1ToExcPICCommand command) {
    try {
      ExcPICBusinessDelegate.getExcPICInstance().assignTa1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ta1", exc);
    }
  }

  /**
   * unassign Ta1 on ExcPIC
   *
   * @param command UnAssignTa1FromExcPICCommand
   */
  @PutMapping("/unAssignTa1")
  public void unAssignTa1(@RequestBody(required = true) UnAssignTa1FromExcPICCommand command) {
    try {
      ExcPICBusinessDelegate.getExcPICInstance().unAssignTa1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ta1", exc);
    }
  }

  /**
   * save Ta2 on ExcPIC
   *
   * @param command AssignTa2ToExcPICCommand
   */
  @PutMapping("/assignTa2")
  public void assignTa2(@RequestBody AssignTa2ToExcPICCommand command) {
    try {
      ExcPICBusinessDelegate.getExcPICInstance().assignTa2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ta2", exc);
    }
  }

  /**
   * unassign Ta2 on ExcPIC
   *
   * @param command UnAssignTa2FromExcPICCommand
   */
  @PutMapping("/unAssignTa2")
  public void unAssignTa2(@RequestBody(required = true) UnAssignTa2FromExcPICCommand command) {
    try {
      ExcPICBusinessDelegate.getExcPICInstance().unAssignTa2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ta2", exc);
    }
  }

  /**
   * save Ta3 on ExcPIC
   *
   * @param command AssignTa3ToExcPICCommand
   */
  @PutMapping("/assignTa3")
  public void assignTa3(@RequestBody AssignTa3ToExcPICCommand command) {
    try {
      ExcPICBusinessDelegate.getExcPICInstance().assignTa3(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ta3", exc);
    }
  }

  /**
   * unassign Ta3 on ExcPIC
   *
   * @param command UnAssignTa3FromExcPICCommand
   */
  @PutMapping("/unAssignTa3")
  public void unAssignTa3(@RequestBody(required = true) UnAssignTa3FromExcPICCommand command) {
    try {
      ExcPICBusinessDelegate.getExcPICInstance().unAssignTa3(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ta3", exc);
    }
  }

  /**
   * save Ta4 on ExcPIC
   *
   * @param command AssignTa4ToExcPICCommand
   */
  @PutMapping("/assignTa4")
  public void assignTa4(@RequestBody AssignTa4ToExcPICCommand command) {
    try {
      ExcPICBusinessDelegate.getExcPICInstance().assignTa4(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ta4", exc);
    }
  }

  /**
   * unassign Ta4 on ExcPIC
   *
   * @param command UnAssignTa4FromExcPICCommand
   */
  @PutMapping("/unAssignTa4")
  public void unAssignTa4(@RequestBody(required = true) UnAssignTa4FromExcPICCommand command) {
    try {
      ExcPICBusinessDelegate.getExcPICInstance().unAssignTa4(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ta4", exc);
    }
  }

  /**
   * save Te on ExcPIC
   *
   * @param command AssignTeToExcPICCommand
   */
  @PutMapping("/assignTe")
  public void assignTe(@RequestBody AssignTeToExcPICCommand command) {
    try {
      ExcPICBusinessDelegate.getExcPICInstance().assignTe(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Te", exc);
    }
  }

  /**
   * unassign Te on ExcPIC
   *
   * @param command UnAssignTeFromExcPICCommand
   */
  @PutMapping("/unAssignTe")
  public void unAssignTe(@RequestBody(required = true) UnAssignTeFromExcPICCommand command) {
    try {
      ExcPICBusinessDelegate.getExcPICInstance().unAssignTe(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Te", exc);
    }
  }

  /**
   * save Tf1 on ExcPIC
   *
   * @param command AssignTf1ToExcPICCommand
   */
  @PutMapping("/assignTf1")
  public void assignTf1(@RequestBody AssignTf1ToExcPICCommand command) {
    try {
      ExcPICBusinessDelegate.getExcPICInstance().assignTf1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tf1", exc);
    }
  }

  /**
   * unassign Tf1 on ExcPIC
   *
   * @param command UnAssignTf1FromExcPICCommand
   */
  @PutMapping("/unAssignTf1")
  public void unAssignTf1(@RequestBody(required = true) UnAssignTf1FromExcPICCommand command) {
    try {
      ExcPICBusinessDelegate.getExcPICInstance().unAssignTf1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tf1", exc);
    }
  }

  /**
   * save Tf2 on ExcPIC
   *
   * @param command AssignTf2ToExcPICCommand
   */
  @PutMapping("/assignTf2")
  public void assignTf2(@RequestBody AssignTf2ToExcPICCommand command) {
    try {
      ExcPICBusinessDelegate.getExcPICInstance().assignTf2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tf2", exc);
    }
  }

  /**
   * unassign Tf2 on ExcPIC
   *
   * @param command UnAssignTf2FromExcPICCommand
   */
  @PutMapping("/unAssignTf2")
  public void unAssignTf2(@RequestBody(required = true) UnAssignTf2FromExcPICCommand command) {
    try {
      ExcPICBusinessDelegate.getExcPICInstance().unAssignTf2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tf2", exc);
    }
  }

  /**
   * save Vr1 on ExcPIC
   *
   * @param command AssignVr1ToExcPICCommand
   */
  @PutMapping("/assignVr1")
  public void assignVr1(@RequestBody AssignVr1ToExcPICCommand command) {
    try {
      ExcPICBusinessDelegate.getExcPICInstance().assignVr1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vr1", exc);
    }
  }

  /**
   * unassign Vr1 on ExcPIC
   *
   * @param command UnAssignVr1FromExcPICCommand
   */
  @PutMapping("/unAssignVr1")
  public void unAssignVr1(@RequestBody(required = true) UnAssignVr1FromExcPICCommand command) {
    try {
      ExcPICBusinessDelegate.getExcPICInstance().unAssignVr1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vr1", exc);
    }
  }

  /**
   * save Vr2 on ExcPIC
   *
   * @param command AssignVr2ToExcPICCommand
   */
  @PutMapping("/assignVr2")
  public void assignVr2(@RequestBody AssignVr2ToExcPICCommand command) {
    try {
      ExcPICBusinessDelegate.getExcPICInstance().assignVr2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vr2", exc);
    }
  }

  /**
   * unassign Vr2 on ExcPIC
   *
   * @param command UnAssignVr2FromExcPICCommand
   */
  @PutMapping("/unAssignVr2")
  public void unAssignVr2(@RequestBody(required = true) UnAssignVr2FromExcPICCommand command) {
    try {
      ExcPICBusinessDelegate.getExcPICInstance().unAssignVr2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vr2", exc);
    }
  }

  /**
   * save Vrmax on ExcPIC
   *
   * @param command AssignVrmaxToExcPICCommand
   */
  @PutMapping("/assignVrmax")
  public void assignVrmax(@RequestBody AssignVrmaxToExcPICCommand command) {
    try {
      ExcPICBusinessDelegate.getExcPICInstance().assignVrmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vrmax", exc);
    }
  }

  /**
   * unassign Vrmax on ExcPIC
   *
   * @param command UnAssignVrmaxFromExcPICCommand
   */
  @PutMapping("/unAssignVrmax")
  public void unAssignVrmax(@RequestBody(required = true) UnAssignVrmaxFromExcPICCommand command) {
    try {
      ExcPICBusinessDelegate.getExcPICInstance().unAssignVrmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vrmax", exc);
    }
  }

  /**
   * save Vrmin on ExcPIC
   *
   * @param command AssignVrminToExcPICCommand
   */
  @PutMapping("/assignVrmin")
  public void assignVrmin(@RequestBody AssignVrminToExcPICCommand command) {
    try {
      ExcPICBusinessDelegate.getExcPICInstance().assignVrmin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vrmin", exc);
    }
  }

  /**
   * unassign Vrmin on ExcPIC
   *
   * @param command UnAssignVrminFromExcPICCommand
   */
  @PutMapping("/unAssignVrmin")
  public void unAssignVrmin(@RequestBody(required = true) UnAssignVrminFromExcPICCommand command) {
    try {
      ExcPICBusinessDelegate.getExcPICInstance().unAssignVrmin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vrmin", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected ExcPIC excPIC = null;
  private static final Logger LOGGER =
      Logger.getLogger(ExcPICCommandRestController.class.getName());
}
