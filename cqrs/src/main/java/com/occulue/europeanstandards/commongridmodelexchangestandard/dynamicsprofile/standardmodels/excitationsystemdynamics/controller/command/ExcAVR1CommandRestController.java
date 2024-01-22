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
 * Implements Spring Controller command CQRS processing for entity ExcAVR1.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcAVR1")
public class ExcAVR1CommandRestController extends BaseSpringRestController {

  /**
   * Handles create a ExcAVR1. if not key provided, calls create, otherwise calls save
   *
   * @param ExcAVR1 excAVR1
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateExcAVR1Command command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture = ExcAVR1BusinessDelegate.getExcAVR1Instance().createExcAVR1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a ExcAVR1. if no key provided, calls create, otherwise calls save
   *
   * @param ExcAVR1 excAVR1
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateExcAVR1Command command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateExcAVR1Command
      // -----------------------------------------------
      completableFuture = ExcAVR1BusinessDelegate.getExcAVR1Instance().updateExcAVR1(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "ExcAVR1Controller:update() - successfully update ExcAVR1 - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a ExcAVR1 entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID excAVR1Id) {
    CompletableFuture<Void> completableFuture = null;
    DeleteExcAVR1Command command = new DeleteExcAVR1Command(excAVR1Id);

    try {
      ExcAVR1BusinessDelegate delegate = ExcAVR1BusinessDelegate.getExcAVR1Instance();

      completableFuture = delegate.delete(command);
      LOGGER.log(Level.WARNING, "Successfully deleted ExcAVR1 with key " + command.getExcAVR1Id());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save E1 on ExcAVR1
   *
   * @param command AssignE1ToExcAVR1Command
   */
  @PutMapping("/assignE1")
  public void assignE1(@RequestBody AssignE1ToExcAVR1Command command) {
    try {
      ExcAVR1BusinessDelegate.getExcAVR1Instance().assignE1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign E1", exc);
    }
  }

  /**
   * unassign E1 on ExcAVR1
   *
   * @param command UnAssignE1FromExcAVR1Command
   */
  @PutMapping("/unAssignE1")
  public void unAssignE1(@RequestBody(required = true) UnAssignE1FromExcAVR1Command command) {
    try {
      ExcAVR1BusinessDelegate.getExcAVR1Instance().unAssignE1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign E1", exc);
    }
  }

  /**
   * save E2 on ExcAVR1
   *
   * @param command AssignE2ToExcAVR1Command
   */
  @PutMapping("/assignE2")
  public void assignE2(@RequestBody AssignE2ToExcAVR1Command command) {
    try {
      ExcAVR1BusinessDelegate.getExcAVR1Instance().assignE2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign E2", exc);
    }
  }

  /**
   * unassign E2 on ExcAVR1
   *
   * @param command UnAssignE2FromExcAVR1Command
   */
  @PutMapping("/unAssignE2")
  public void unAssignE2(@RequestBody(required = true) UnAssignE2FromExcAVR1Command command) {
    try {
      ExcAVR1BusinessDelegate.getExcAVR1Instance().unAssignE2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign E2", exc);
    }
  }

  /**
   * save Ka on ExcAVR1
   *
   * @param command AssignKaToExcAVR1Command
   */
  @PutMapping("/assignKa")
  public void assignKa(@RequestBody AssignKaToExcAVR1Command command) {
    try {
      ExcAVR1BusinessDelegate.getExcAVR1Instance().assignKa(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ka", exc);
    }
  }

  /**
   * unassign Ka on ExcAVR1
   *
   * @param command UnAssignKaFromExcAVR1Command
   */
  @PutMapping("/unAssignKa")
  public void unAssignKa(@RequestBody(required = true) UnAssignKaFromExcAVR1Command command) {
    try {
      ExcAVR1BusinessDelegate.getExcAVR1Instance().unAssignKa(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ka", exc);
    }
  }

  /**
   * save Kf on ExcAVR1
   *
   * @param command AssignKfToExcAVR1Command
   */
  @PutMapping("/assignKf")
  public void assignKf(@RequestBody AssignKfToExcAVR1Command command) {
    try {
      ExcAVR1BusinessDelegate.getExcAVR1Instance().assignKf(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kf", exc);
    }
  }

  /**
   * unassign Kf on ExcAVR1
   *
   * @param command UnAssignKfFromExcAVR1Command
   */
  @PutMapping("/unAssignKf")
  public void unAssignKf(@RequestBody(required = true) UnAssignKfFromExcAVR1Command command) {
    try {
      ExcAVR1BusinessDelegate.getExcAVR1Instance().unAssignKf(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kf", exc);
    }
  }

  /**
   * save Se1 on ExcAVR1
   *
   * @param command AssignSe1ToExcAVR1Command
   */
  @PutMapping("/assignSe1")
  public void assignSe1(@RequestBody AssignSe1ToExcAVR1Command command) {
    try {
      ExcAVR1BusinessDelegate.getExcAVR1Instance().assignSe1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Se1", exc);
    }
  }

  /**
   * unassign Se1 on ExcAVR1
   *
   * @param command UnAssignSe1FromExcAVR1Command
   */
  @PutMapping("/unAssignSe1")
  public void unAssignSe1(@RequestBody(required = true) UnAssignSe1FromExcAVR1Command command) {
    try {
      ExcAVR1BusinessDelegate.getExcAVR1Instance().unAssignSe1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Se1", exc);
    }
  }

  /**
   * save Se2 on ExcAVR1
   *
   * @param command AssignSe2ToExcAVR1Command
   */
  @PutMapping("/assignSe2")
  public void assignSe2(@RequestBody AssignSe2ToExcAVR1Command command) {
    try {
      ExcAVR1BusinessDelegate.getExcAVR1Instance().assignSe2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Se2", exc);
    }
  }

  /**
   * unassign Se2 on ExcAVR1
   *
   * @param command UnAssignSe2FromExcAVR1Command
   */
  @PutMapping("/unAssignSe2")
  public void unAssignSe2(@RequestBody(required = true) UnAssignSe2FromExcAVR1Command command) {
    try {
      ExcAVR1BusinessDelegate.getExcAVR1Instance().unAssignSe2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Se2", exc);
    }
  }

  /**
   * save Ta on ExcAVR1
   *
   * @param command AssignTaToExcAVR1Command
   */
  @PutMapping("/assignTa")
  public void assignTa(@RequestBody AssignTaToExcAVR1Command command) {
    try {
      ExcAVR1BusinessDelegate.getExcAVR1Instance().assignTa(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ta", exc);
    }
  }

  /**
   * unassign Ta on ExcAVR1
   *
   * @param command UnAssignTaFromExcAVR1Command
   */
  @PutMapping("/unAssignTa")
  public void unAssignTa(@RequestBody(required = true) UnAssignTaFromExcAVR1Command command) {
    try {
      ExcAVR1BusinessDelegate.getExcAVR1Instance().unAssignTa(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ta", exc);
    }
  }

  /**
   * save Tb on ExcAVR1
   *
   * @param command AssignTbToExcAVR1Command
   */
  @PutMapping("/assignTb")
  public void assignTb(@RequestBody AssignTbToExcAVR1Command command) {
    try {
      ExcAVR1BusinessDelegate.getExcAVR1Instance().assignTb(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tb", exc);
    }
  }

  /**
   * unassign Tb on ExcAVR1
   *
   * @param command UnAssignTbFromExcAVR1Command
   */
  @PutMapping("/unAssignTb")
  public void unAssignTb(@RequestBody(required = true) UnAssignTbFromExcAVR1Command command) {
    try {
      ExcAVR1BusinessDelegate.getExcAVR1Instance().unAssignTb(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tb", exc);
    }
  }

  /**
   * save Te on ExcAVR1
   *
   * @param command AssignTeToExcAVR1Command
   */
  @PutMapping("/assignTe")
  public void assignTe(@RequestBody AssignTeToExcAVR1Command command) {
    try {
      ExcAVR1BusinessDelegate.getExcAVR1Instance().assignTe(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Te", exc);
    }
  }

  /**
   * unassign Te on ExcAVR1
   *
   * @param command UnAssignTeFromExcAVR1Command
   */
  @PutMapping("/unAssignTe")
  public void unAssignTe(@RequestBody(required = true) UnAssignTeFromExcAVR1Command command) {
    try {
      ExcAVR1BusinessDelegate.getExcAVR1Instance().unAssignTe(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Te", exc);
    }
  }

  /**
   * save Tf on ExcAVR1
   *
   * @param command AssignTfToExcAVR1Command
   */
  @PutMapping("/assignTf")
  public void assignTf(@RequestBody AssignTfToExcAVR1Command command) {
    try {
      ExcAVR1BusinessDelegate.getExcAVR1Instance().assignTf(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tf", exc);
    }
  }

  /**
   * unassign Tf on ExcAVR1
   *
   * @param command UnAssignTfFromExcAVR1Command
   */
  @PutMapping("/unAssignTf")
  public void unAssignTf(@RequestBody(required = true) UnAssignTfFromExcAVR1Command command) {
    try {
      ExcAVR1BusinessDelegate.getExcAVR1Instance().unAssignTf(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tf", exc);
    }
  }

  /**
   * save Vrmn on ExcAVR1
   *
   * @param command AssignVrmnToExcAVR1Command
   */
  @PutMapping("/assignVrmn")
  public void assignVrmn(@RequestBody AssignVrmnToExcAVR1Command command) {
    try {
      ExcAVR1BusinessDelegate.getExcAVR1Instance().assignVrmn(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vrmn", exc);
    }
  }

  /**
   * unassign Vrmn on ExcAVR1
   *
   * @param command UnAssignVrmnFromExcAVR1Command
   */
  @PutMapping("/unAssignVrmn")
  public void unAssignVrmn(@RequestBody(required = true) UnAssignVrmnFromExcAVR1Command command) {
    try {
      ExcAVR1BusinessDelegate.getExcAVR1Instance().unAssignVrmn(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vrmn", exc);
    }
  }

  /**
   * save Vrmx on ExcAVR1
   *
   * @param command AssignVrmxToExcAVR1Command
   */
  @PutMapping("/assignVrmx")
  public void assignVrmx(@RequestBody AssignVrmxToExcAVR1Command command) {
    try {
      ExcAVR1BusinessDelegate.getExcAVR1Instance().assignVrmx(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vrmx", exc);
    }
  }

  /**
   * unassign Vrmx on ExcAVR1
   *
   * @param command UnAssignVrmxFromExcAVR1Command
   */
  @PutMapping("/unAssignVrmx")
  public void unAssignVrmx(@RequestBody(required = true) UnAssignVrmxFromExcAVR1Command command) {
    try {
      ExcAVR1BusinessDelegate.getExcAVR1Instance().unAssignVrmx(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vrmx", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected ExcAVR1 excAVR1 = null;
  private static final Logger LOGGER =
      Logger.getLogger(ExcAVR1CommandRestController.class.getName());
}
