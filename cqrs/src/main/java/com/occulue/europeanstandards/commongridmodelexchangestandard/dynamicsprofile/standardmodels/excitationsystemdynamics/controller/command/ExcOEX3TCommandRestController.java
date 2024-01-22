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
 * Implements Spring Controller command CQRS processing for entity ExcOEX3T.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcOEX3T")
public class ExcOEX3TCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a ExcOEX3T. if not key provided, calls create, otherwise calls save
   *
   * @param ExcOEX3T excOEX3T
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateExcOEX3TCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture = ExcOEX3TBusinessDelegate.getExcOEX3TInstance().createExcOEX3T(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a ExcOEX3T. if no key provided, calls create, otherwise calls save
   *
   * @param ExcOEX3T excOEX3T
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateExcOEX3TCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateExcOEX3TCommand
      // -----------------------------------------------
      completableFuture = ExcOEX3TBusinessDelegate.getExcOEX3TInstance().updateExcOEX3T(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "ExcOEX3TController:update() - successfully update ExcOEX3T - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a ExcOEX3T entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID excOEX3TId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteExcOEX3TCommand command = new DeleteExcOEX3TCommand(excOEX3TId);

    try {
      ExcOEX3TBusinessDelegate delegate = ExcOEX3TBusinessDelegate.getExcOEX3TInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING, "Successfully deleted ExcOEX3T with key " + command.getExcOEX3TId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save E1 on ExcOEX3T
   *
   * @param command AssignE1ToExcOEX3TCommand
   */
  @PutMapping("/assignE1")
  public void assignE1(@RequestBody AssignE1ToExcOEX3TCommand command) {
    try {
      ExcOEX3TBusinessDelegate.getExcOEX3TInstance().assignE1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign E1", exc);
    }
  }

  /**
   * unassign E1 on ExcOEX3T
   *
   * @param command UnAssignE1FromExcOEX3TCommand
   */
  @PutMapping("/unAssignE1")
  public void unAssignE1(@RequestBody(required = true) UnAssignE1FromExcOEX3TCommand command) {
    try {
      ExcOEX3TBusinessDelegate.getExcOEX3TInstance().unAssignE1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign E1", exc);
    }
  }

  /**
   * save E2 on ExcOEX3T
   *
   * @param command AssignE2ToExcOEX3TCommand
   */
  @PutMapping("/assignE2")
  public void assignE2(@RequestBody AssignE2ToExcOEX3TCommand command) {
    try {
      ExcOEX3TBusinessDelegate.getExcOEX3TInstance().assignE2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign E2", exc);
    }
  }

  /**
   * unassign E2 on ExcOEX3T
   *
   * @param command UnAssignE2FromExcOEX3TCommand
   */
  @PutMapping("/unAssignE2")
  public void unAssignE2(@RequestBody(required = true) UnAssignE2FromExcOEX3TCommand command) {
    try {
      ExcOEX3TBusinessDelegate.getExcOEX3TInstance().unAssignE2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign E2", exc);
    }
  }

  /**
   * save Ka on ExcOEX3T
   *
   * @param command AssignKaToExcOEX3TCommand
   */
  @PutMapping("/assignKa")
  public void assignKa(@RequestBody AssignKaToExcOEX3TCommand command) {
    try {
      ExcOEX3TBusinessDelegate.getExcOEX3TInstance().assignKa(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ka", exc);
    }
  }

  /**
   * unassign Ka on ExcOEX3T
   *
   * @param command UnAssignKaFromExcOEX3TCommand
   */
  @PutMapping("/unAssignKa")
  public void unAssignKa(@RequestBody(required = true) UnAssignKaFromExcOEX3TCommand command) {
    try {
      ExcOEX3TBusinessDelegate.getExcOEX3TInstance().unAssignKa(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ka", exc);
    }
  }

  /**
   * save Kc on ExcOEX3T
   *
   * @param command AssignKcToExcOEX3TCommand
   */
  @PutMapping("/assignKc")
  public void assignKc(@RequestBody AssignKcToExcOEX3TCommand command) {
    try {
      ExcOEX3TBusinessDelegate.getExcOEX3TInstance().assignKc(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kc", exc);
    }
  }

  /**
   * unassign Kc on ExcOEX3T
   *
   * @param command UnAssignKcFromExcOEX3TCommand
   */
  @PutMapping("/unAssignKc")
  public void unAssignKc(@RequestBody(required = true) UnAssignKcFromExcOEX3TCommand command) {
    try {
      ExcOEX3TBusinessDelegate.getExcOEX3TInstance().unAssignKc(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kc", exc);
    }
  }

  /**
   * save Kd on ExcOEX3T
   *
   * @param command AssignKdToExcOEX3TCommand
   */
  @PutMapping("/assignKd")
  public void assignKd(@RequestBody AssignKdToExcOEX3TCommand command) {
    try {
      ExcOEX3TBusinessDelegate.getExcOEX3TInstance().assignKd(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kd", exc);
    }
  }

  /**
   * unassign Kd on ExcOEX3T
   *
   * @param command UnAssignKdFromExcOEX3TCommand
   */
  @PutMapping("/unAssignKd")
  public void unAssignKd(@RequestBody(required = true) UnAssignKdFromExcOEX3TCommand command) {
    try {
      ExcOEX3TBusinessDelegate.getExcOEX3TInstance().unAssignKd(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kd", exc);
    }
  }

  /**
   * save Ke on ExcOEX3T
   *
   * @param command AssignKeToExcOEX3TCommand
   */
  @PutMapping("/assignKe")
  public void assignKe(@RequestBody AssignKeToExcOEX3TCommand command) {
    try {
      ExcOEX3TBusinessDelegate.getExcOEX3TInstance().assignKe(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ke", exc);
    }
  }

  /**
   * unassign Ke on ExcOEX3T
   *
   * @param command UnAssignKeFromExcOEX3TCommand
   */
  @PutMapping("/unAssignKe")
  public void unAssignKe(@RequestBody(required = true) UnAssignKeFromExcOEX3TCommand command) {
    try {
      ExcOEX3TBusinessDelegate.getExcOEX3TInstance().unAssignKe(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ke", exc);
    }
  }

  /**
   * save Kf on ExcOEX3T
   *
   * @param command AssignKfToExcOEX3TCommand
   */
  @PutMapping("/assignKf")
  public void assignKf(@RequestBody AssignKfToExcOEX3TCommand command) {
    try {
      ExcOEX3TBusinessDelegate.getExcOEX3TInstance().assignKf(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kf", exc);
    }
  }

  /**
   * unassign Kf on ExcOEX3T
   *
   * @param command UnAssignKfFromExcOEX3TCommand
   */
  @PutMapping("/unAssignKf")
  public void unAssignKf(@RequestBody(required = true) UnAssignKfFromExcOEX3TCommand command) {
    try {
      ExcOEX3TBusinessDelegate.getExcOEX3TInstance().unAssignKf(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kf", exc);
    }
  }

  /**
   * save See1 on ExcOEX3T
   *
   * @param command AssignSee1ToExcOEX3TCommand
   */
  @PutMapping("/assignSee1")
  public void assignSee1(@RequestBody AssignSee1ToExcOEX3TCommand command) {
    try {
      ExcOEX3TBusinessDelegate.getExcOEX3TInstance().assignSee1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign See1", exc);
    }
  }

  /**
   * unassign See1 on ExcOEX3T
   *
   * @param command UnAssignSee1FromExcOEX3TCommand
   */
  @PutMapping("/unAssignSee1")
  public void unAssignSee1(@RequestBody(required = true) UnAssignSee1FromExcOEX3TCommand command) {
    try {
      ExcOEX3TBusinessDelegate.getExcOEX3TInstance().unAssignSee1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign See1", exc);
    }
  }

  /**
   * save See2 on ExcOEX3T
   *
   * @param command AssignSee2ToExcOEX3TCommand
   */
  @PutMapping("/assignSee2")
  public void assignSee2(@RequestBody AssignSee2ToExcOEX3TCommand command) {
    try {
      ExcOEX3TBusinessDelegate.getExcOEX3TInstance().assignSee2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign See2", exc);
    }
  }

  /**
   * unassign See2 on ExcOEX3T
   *
   * @param command UnAssignSee2FromExcOEX3TCommand
   */
  @PutMapping("/unAssignSee2")
  public void unAssignSee2(@RequestBody(required = true) UnAssignSee2FromExcOEX3TCommand command) {
    try {
      ExcOEX3TBusinessDelegate.getExcOEX3TInstance().unAssignSee2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign See2", exc);
    }
  }

  /**
   * save T1 on ExcOEX3T
   *
   * @param command AssignT1ToExcOEX3TCommand
   */
  @PutMapping("/assignT1")
  public void assignT1(@RequestBody AssignT1ToExcOEX3TCommand command) {
    try {
      ExcOEX3TBusinessDelegate.getExcOEX3TInstance().assignT1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T1", exc);
    }
  }

  /**
   * unassign T1 on ExcOEX3T
   *
   * @param command UnAssignT1FromExcOEX3TCommand
   */
  @PutMapping("/unAssignT1")
  public void unAssignT1(@RequestBody(required = true) UnAssignT1FromExcOEX3TCommand command) {
    try {
      ExcOEX3TBusinessDelegate.getExcOEX3TInstance().unAssignT1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T1", exc);
    }
  }

  /**
   * save T2 on ExcOEX3T
   *
   * @param command AssignT2ToExcOEX3TCommand
   */
  @PutMapping("/assignT2")
  public void assignT2(@RequestBody AssignT2ToExcOEX3TCommand command) {
    try {
      ExcOEX3TBusinessDelegate.getExcOEX3TInstance().assignT2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T2", exc);
    }
  }

  /**
   * unassign T2 on ExcOEX3T
   *
   * @param command UnAssignT2FromExcOEX3TCommand
   */
  @PutMapping("/unAssignT2")
  public void unAssignT2(@RequestBody(required = true) UnAssignT2FromExcOEX3TCommand command) {
    try {
      ExcOEX3TBusinessDelegate.getExcOEX3TInstance().unAssignT2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T2", exc);
    }
  }

  /**
   * save T3 on ExcOEX3T
   *
   * @param command AssignT3ToExcOEX3TCommand
   */
  @PutMapping("/assignT3")
  public void assignT3(@RequestBody AssignT3ToExcOEX3TCommand command) {
    try {
      ExcOEX3TBusinessDelegate.getExcOEX3TInstance().assignT3(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T3", exc);
    }
  }

  /**
   * unassign T3 on ExcOEX3T
   *
   * @param command UnAssignT3FromExcOEX3TCommand
   */
  @PutMapping("/unAssignT3")
  public void unAssignT3(@RequestBody(required = true) UnAssignT3FromExcOEX3TCommand command) {
    try {
      ExcOEX3TBusinessDelegate.getExcOEX3TInstance().unAssignT3(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T3", exc);
    }
  }

  /**
   * save T4 on ExcOEX3T
   *
   * @param command AssignT4ToExcOEX3TCommand
   */
  @PutMapping("/assignT4")
  public void assignT4(@RequestBody AssignT4ToExcOEX3TCommand command) {
    try {
      ExcOEX3TBusinessDelegate.getExcOEX3TInstance().assignT4(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T4", exc);
    }
  }

  /**
   * unassign T4 on ExcOEX3T
   *
   * @param command UnAssignT4FromExcOEX3TCommand
   */
  @PutMapping("/unAssignT4")
  public void unAssignT4(@RequestBody(required = true) UnAssignT4FromExcOEX3TCommand command) {
    try {
      ExcOEX3TBusinessDelegate.getExcOEX3TInstance().unAssignT4(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T4", exc);
    }
  }

  /**
   * save T5 on ExcOEX3T
   *
   * @param command AssignT5ToExcOEX3TCommand
   */
  @PutMapping("/assignT5")
  public void assignT5(@RequestBody AssignT5ToExcOEX3TCommand command) {
    try {
      ExcOEX3TBusinessDelegate.getExcOEX3TInstance().assignT5(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T5", exc);
    }
  }

  /**
   * unassign T5 on ExcOEX3T
   *
   * @param command UnAssignT5FromExcOEX3TCommand
   */
  @PutMapping("/unAssignT5")
  public void unAssignT5(@RequestBody(required = true) UnAssignT5FromExcOEX3TCommand command) {
    try {
      ExcOEX3TBusinessDelegate.getExcOEX3TInstance().unAssignT5(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T5", exc);
    }
  }

  /**
   * save T6 on ExcOEX3T
   *
   * @param command AssignT6ToExcOEX3TCommand
   */
  @PutMapping("/assignT6")
  public void assignT6(@RequestBody AssignT6ToExcOEX3TCommand command) {
    try {
      ExcOEX3TBusinessDelegate.getExcOEX3TInstance().assignT6(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T6", exc);
    }
  }

  /**
   * unassign T6 on ExcOEX3T
   *
   * @param command UnAssignT6FromExcOEX3TCommand
   */
  @PutMapping("/unAssignT6")
  public void unAssignT6(@RequestBody(required = true) UnAssignT6FromExcOEX3TCommand command) {
    try {
      ExcOEX3TBusinessDelegate.getExcOEX3TInstance().unAssignT6(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T6", exc);
    }
  }

  /**
   * save Te on ExcOEX3T
   *
   * @param command AssignTeToExcOEX3TCommand
   */
  @PutMapping("/assignTe")
  public void assignTe(@RequestBody AssignTeToExcOEX3TCommand command) {
    try {
      ExcOEX3TBusinessDelegate.getExcOEX3TInstance().assignTe(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Te", exc);
    }
  }

  /**
   * unassign Te on ExcOEX3T
   *
   * @param command UnAssignTeFromExcOEX3TCommand
   */
  @PutMapping("/unAssignTe")
  public void unAssignTe(@RequestBody(required = true) UnAssignTeFromExcOEX3TCommand command) {
    try {
      ExcOEX3TBusinessDelegate.getExcOEX3TInstance().unAssignTe(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Te", exc);
    }
  }

  /**
   * save Tf on ExcOEX3T
   *
   * @param command AssignTfToExcOEX3TCommand
   */
  @PutMapping("/assignTf")
  public void assignTf(@RequestBody AssignTfToExcOEX3TCommand command) {
    try {
      ExcOEX3TBusinessDelegate.getExcOEX3TInstance().assignTf(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tf", exc);
    }
  }

  /**
   * unassign Tf on ExcOEX3T
   *
   * @param command UnAssignTfFromExcOEX3TCommand
   */
  @PutMapping("/unAssignTf")
  public void unAssignTf(@RequestBody(required = true) UnAssignTfFromExcOEX3TCommand command) {
    try {
      ExcOEX3TBusinessDelegate.getExcOEX3TInstance().unAssignTf(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tf", exc);
    }
  }

  /**
   * save Vrmax on ExcOEX3T
   *
   * @param command AssignVrmaxToExcOEX3TCommand
   */
  @PutMapping("/assignVrmax")
  public void assignVrmax(@RequestBody AssignVrmaxToExcOEX3TCommand command) {
    try {
      ExcOEX3TBusinessDelegate.getExcOEX3TInstance().assignVrmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vrmax", exc);
    }
  }

  /**
   * unassign Vrmax on ExcOEX3T
   *
   * @param command UnAssignVrmaxFromExcOEX3TCommand
   */
  @PutMapping("/unAssignVrmax")
  public void unAssignVrmax(
      @RequestBody(required = true) UnAssignVrmaxFromExcOEX3TCommand command) {
    try {
      ExcOEX3TBusinessDelegate.getExcOEX3TInstance().unAssignVrmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vrmax", exc);
    }
  }

  /**
   * save Vrmin on ExcOEX3T
   *
   * @param command AssignVrminToExcOEX3TCommand
   */
  @PutMapping("/assignVrmin")
  public void assignVrmin(@RequestBody AssignVrminToExcOEX3TCommand command) {
    try {
      ExcOEX3TBusinessDelegate.getExcOEX3TInstance().assignVrmin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vrmin", exc);
    }
  }

  /**
   * unassign Vrmin on ExcOEX3T
   *
   * @param command UnAssignVrminFromExcOEX3TCommand
   */
  @PutMapping("/unAssignVrmin")
  public void unAssignVrmin(
      @RequestBody(required = true) UnAssignVrminFromExcOEX3TCommand command) {
    try {
      ExcOEX3TBusinessDelegate.getExcOEX3TInstance().unAssignVrmin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vrmin", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected ExcOEX3T excOEX3T = null;
  private static final Logger LOGGER =
      Logger.getLogger(ExcOEX3TCommandRestController.class.getName());
}
