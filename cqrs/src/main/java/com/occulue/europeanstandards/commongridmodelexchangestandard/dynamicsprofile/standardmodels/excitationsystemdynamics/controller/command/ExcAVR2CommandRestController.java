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
 * Implements Spring Controller command CQRS processing for entity ExcAVR2.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcAVR2")
public class ExcAVR2CommandRestController extends BaseSpringRestController {

  /**
   * Handles create a ExcAVR2. if not key provided, calls create, otherwise calls save
   *
   * @param ExcAVR2 excAVR2
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateExcAVR2Command command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture = ExcAVR2BusinessDelegate.getExcAVR2Instance().createExcAVR2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a ExcAVR2. if no key provided, calls create, otherwise calls save
   *
   * @param ExcAVR2 excAVR2
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateExcAVR2Command command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateExcAVR2Command
      // -----------------------------------------------
      completableFuture = ExcAVR2BusinessDelegate.getExcAVR2Instance().updateExcAVR2(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "ExcAVR2Controller:update() - successfully update ExcAVR2 - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a ExcAVR2 entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID excAVR2Id) {
    CompletableFuture<Void> completableFuture = null;
    DeleteExcAVR2Command command = new DeleteExcAVR2Command(excAVR2Id);

    try {
      ExcAVR2BusinessDelegate delegate = ExcAVR2BusinessDelegate.getExcAVR2Instance();

      completableFuture = delegate.delete(command);
      LOGGER.log(Level.WARNING, "Successfully deleted ExcAVR2 with key " + command.getExcAVR2Id());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save E1 on ExcAVR2
   *
   * @param command AssignE1ToExcAVR2Command
   */
  @PutMapping("/assignE1")
  public void assignE1(@RequestBody AssignE1ToExcAVR2Command command) {
    try {
      ExcAVR2BusinessDelegate.getExcAVR2Instance().assignE1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign E1", exc);
    }
  }

  /**
   * unassign E1 on ExcAVR2
   *
   * @param command UnAssignE1FromExcAVR2Command
   */
  @PutMapping("/unAssignE1")
  public void unAssignE1(@RequestBody(required = true) UnAssignE1FromExcAVR2Command command) {
    try {
      ExcAVR2BusinessDelegate.getExcAVR2Instance().unAssignE1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign E1", exc);
    }
  }

  /**
   * save E2 on ExcAVR2
   *
   * @param command AssignE2ToExcAVR2Command
   */
  @PutMapping("/assignE2")
  public void assignE2(@RequestBody AssignE2ToExcAVR2Command command) {
    try {
      ExcAVR2BusinessDelegate.getExcAVR2Instance().assignE2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign E2", exc);
    }
  }

  /**
   * unassign E2 on ExcAVR2
   *
   * @param command UnAssignE2FromExcAVR2Command
   */
  @PutMapping("/unAssignE2")
  public void unAssignE2(@RequestBody(required = true) UnAssignE2FromExcAVR2Command command) {
    try {
      ExcAVR2BusinessDelegate.getExcAVR2Instance().unAssignE2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign E2", exc);
    }
  }

  /**
   * save Ka on ExcAVR2
   *
   * @param command AssignKaToExcAVR2Command
   */
  @PutMapping("/assignKa")
  public void assignKa(@RequestBody AssignKaToExcAVR2Command command) {
    try {
      ExcAVR2BusinessDelegate.getExcAVR2Instance().assignKa(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ka", exc);
    }
  }

  /**
   * unassign Ka on ExcAVR2
   *
   * @param command UnAssignKaFromExcAVR2Command
   */
  @PutMapping("/unAssignKa")
  public void unAssignKa(@RequestBody(required = true) UnAssignKaFromExcAVR2Command command) {
    try {
      ExcAVR2BusinessDelegate.getExcAVR2Instance().unAssignKa(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ka", exc);
    }
  }

  /**
   * save Kf on ExcAVR2
   *
   * @param command AssignKfToExcAVR2Command
   */
  @PutMapping("/assignKf")
  public void assignKf(@RequestBody AssignKfToExcAVR2Command command) {
    try {
      ExcAVR2BusinessDelegate.getExcAVR2Instance().assignKf(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kf", exc);
    }
  }

  /**
   * unassign Kf on ExcAVR2
   *
   * @param command UnAssignKfFromExcAVR2Command
   */
  @PutMapping("/unAssignKf")
  public void unAssignKf(@RequestBody(required = true) UnAssignKfFromExcAVR2Command command) {
    try {
      ExcAVR2BusinessDelegate.getExcAVR2Instance().unAssignKf(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kf", exc);
    }
  }

  /**
   * save Se1 on ExcAVR2
   *
   * @param command AssignSe1ToExcAVR2Command
   */
  @PutMapping("/assignSe1")
  public void assignSe1(@RequestBody AssignSe1ToExcAVR2Command command) {
    try {
      ExcAVR2BusinessDelegate.getExcAVR2Instance().assignSe1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Se1", exc);
    }
  }

  /**
   * unassign Se1 on ExcAVR2
   *
   * @param command UnAssignSe1FromExcAVR2Command
   */
  @PutMapping("/unAssignSe1")
  public void unAssignSe1(@RequestBody(required = true) UnAssignSe1FromExcAVR2Command command) {
    try {
      ExcAVR2BusinessDelegate.getExcAVR2Instance().unAssignSe1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Se1", exc);
    }
  }

  /**
   * save Se2 on ExcAVR2
   *
   * @param command AssignSe2ToExcAVR2Command
   */
  @PutMapping("/assignSe2")
  public void assignSe2(@RequestBody AssignSe2ToExcAVR2Command command) {
    try {
      ExcAVR2BusinessDelegate.getExcAVR2Instance().assignSe2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Se2", exc);
    }
  }

  /**
   * unassign Se2 on ExcAVR2
   *
   * @param command UnAssignSe2FromExcAVR2Command
   */
  @PutMapping("/unAssignSe2")
  public void unAssignSe2(@RequestBody(required = true) UnAssignSe2FromExcAVR2Command command) {
    try {
      ExcAVR2BusinessDelegate.getExcAVR2Instance().unAssignSe2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Se2", exc);
    }
  }

  /**
   * save Ta on ExcAVR2
   *
   * @param command AssignTaToExcAVR2Command
   */
  @PutMapping("/assignTa")
  public void assignTa(@RequestBody AssignTaToExcAVR2Command command) {
    try {
      ExcAVR2BusinessDelegate.getExcAVR2Instance().assignTa(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ta", exc);
    }
  }

  /**
   * unassign Ta on ExcAVR2
   *
   * @param command UnAssignTaFromExcAVR2Command
   */
  @PutMapping("/unAssignTa")
  public void unAssignTa(@RequestBody(required = true) UnAssignTaFromExcAVR2Command command) {
    try {
      ExcAVR2BusinessDelegate.getExcAVR2Instance().unAssignTa(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ta", exc);
    }
  }

  /**
   * save Tb on ExcAVR2
   *
   * @param command AssignTbToExcAVR2Command
   */
  @PutMapping("/assignTb")
  public void assignTb(@RequestBody AssignTbToExcAVR2Command command) {
    try {
      ExcAVR2BusinessDelegate.getExcAVR2Instance().assignTb(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tb", exc);
    }
  }

  /**
   * unassign Tb on ExcAVR2
   *
   * @param command UnAssignTbFromExcAVR2Command
   */
  @PutMapping("/unAssignTb")
  public void unAssignTb(@RequestBody(required = true) UnAssignTbFromExcAVR2Command command) {
    try {
      ExcAVR2BusinessDelegate.getExcAVR2Instance().unAssignTb(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tb", exc);
    }
  }

  /**
   * save Te on ExcAVR2
   *
   * @param command AssignTeToExcAVR2Command
   */
  @PutMapping("/assignTe")
  public void assignTe(@RequestBody AssignTeToExcAVR2Command command) {
    try {
      ExcAVR2BusinessDelegate.getExcAVR2Instance().assignTe(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Te", exc);
    }
  }

  /**
   * unassign Te on ExcAVR2
   *
   * @param command UnAssignTeFromExcAVR2Command
   */
  @PutMapping("/unAssignTe")
  public void unAssignTe(@RequestBody(required = true) UnAssignTeFromExcAVR2Command command) {
    try {
      ExcAVR2BusinessDelegate.getExcAVR2Instance().unAssignTe(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Te", exc);
    }
  }

  /**
   * save Tf1 on ExcAVR2
   *
   * @param command AssignTf1ToExcAVR2Command
   */
  @PutMapping("/assignTf1")
  public void assignTf1(@RequestBody AssignTf1ToExcAVR2Command command) {
    try {
      ExcAVR2BusinessDelegate.getExcAVR2Instance().assignTf1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tf1", exc);
    }
  }

  /**
   * unassign Tf1 on ExcAVR2
   *
   * @param command UnAssignTf1FromExcAVR2Command
   */
  @PutMapping("/unAssignTf1")
  public void unAssignTf1(@RequestBody(required = true) UnAssignTf1FromExcAVR2Command command) {
    try {
      ExcAVR2BusinessDelegate.getExcAVR2Instance().unAssignTf1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tf1", exc);
    }
  }

  /**
   * save Tf2 on ExcAVR2
   *
   * @param command AssignTf2ToExcAVR2Command
   */
  @PutMapping("/assignTf2")
  public void assignTf2(@RequestBody AssignTf2ToExcAVR2Command command) {
    try {
      ExcAVR2BusinessDelegate.getExcAVR2Instance().assignTf2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tf2", exc);
    }
  }

  /**
   * unassign Tf2 on ExcAVR2
   *
   * @param command UnAssignTf2FromExcAVR2Command
   */
  @PutMapping("/unAssignTf2")
  public void unAssignTf2(@RequestBody(required = true) UnAssignTf2FromExcAVR2Command command) {
    try {
      ExcAVR2BusinessDelegate.getExcAVR2Instance().unAssignTf2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tf2", exc);
    }
  }

  /**
   * save Vrmn on ExcAVR2
   *
   * @param command AssignVrmnToExcAVR2Command
   */
  @PutMapping("/assignVrmn")
  public void assignVrmn(@RequestBody AssignVrmnToExcAVR2Command command) {
    try {
      ExcAVR2BusinessDelegate.getExcAVR2Instance().assignVrmn(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vrmn", exc);
    }
  }

  /**
   * unassign Vrmn on ExcAVR2
   *
   * @param command UnAssignVrmnFromExcAVR2Command
   */
  @PutMapping("/unAssignVrmn")
  public void unAssignVrmn(@RequestBody(required = true) UnAssignVrmnFromExcAVR2Command command) {
    try {
      ExcAVR2BusinessDelegate.getExcAVR2Instance().unAssignVrmn(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vrmn", exc);
    }
  }

  /**
   * save Vrmx on ExcAVR2
   *
   * @param command AssignVrmxToExcAVR2Command
   */
  @PutMapping("/assignVrmx")
  public void assignVrmx(@RequestBody AssignVrmxToExcAVR2Command command) {
    try {
      ExcAVR2BusinessDelegate.getExcAVR2Instance().assignVrmx(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vrmx", exc);
    }
  }

  /**
   * unassign Vrmx on ExcAVR2
   *
   * @param command UnAssignVrmxFromExcAVR2Command
   */
  @PutMapping("/unAssignVrmx")
  public void unAssignVrmx(@RequestBody(required = true) UnAssignVrmxFromExcAVR2Command command) {
    try {
      ExcAVR2BusinessDelegate.getExcAVR2Instance().unAssignVrmx(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vrmx", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected ExcAVR2 excAVR2 = null;
  private static final Logger LOGGER =
      Logger.getLogger(ExcAVR2CommandRestController.class.getName());
}
