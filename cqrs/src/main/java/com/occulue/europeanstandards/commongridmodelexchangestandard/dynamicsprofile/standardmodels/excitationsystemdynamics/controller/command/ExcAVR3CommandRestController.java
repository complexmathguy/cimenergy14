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
 * Implements Spring Controller command CQRS processing for entity ExcAVR3.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcAVR3")
public class ExcAVR3CommandRestController extends BaseSpringRestController {

  /**
   * Handles create a ExcAVR3. if not key provided, calls create, otherwise calls save
   *
   * @param ExcAVR3 excAVR3
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateExcAVR3Command command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture = ExcAVR3BusinessDelegate.getExcAVR3Instance().createExcAVR3(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a ExcAVR3. if no key provided, calls create, otherwise calls save
   *
   * @param ExcAVR3 excAVR3
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateExcAVR3Command command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateExcAVR3Command
      // -----------------------------------------------
      completableFuture = ExcAVR3BusinessDelegate.getExcAVR3Instance().updateExcAVR3(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "ExcAVR3Controller:update() - successfully update ExcAVR3 - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a ExcAVR3 entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID excAVR3Id) {
    CompletableFuture<Void> completableFuture = null;
    DeleteExcAVR3Command command = new DeleteExcAVR3Command(excAVR3Id);

    try {
      ExcAVR3BusinessDelegate delegate = ExcAVR3BusinessDelegate.getExcAVR3Instance();

      completableFuture = delegate.delete(command);
      LOGGER.log(Level.WARNING, "Successfully deleted ExcAVR3 with key " + command.getExcAVR3Id());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save E1 on ExcAVR3
   *
   * @param command AssignE1ToExcAVR3Command
   */
  @PutMapping("/assignE1")
  public void assignE1(@RequestBody AssignE1ToExcAVR3Command command) {
    try {
      ExcAVR3BusinessDelegate.getExcAVR3Instance().assignE1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign E1", exc);
    }
  }

  /**
   * unassign E1 on ExcAVR3
   *
   * @param command UnAssignE1FromExcAVR3Command
   */
  @PutMapping("/unAssignE1")
  public void unAssignE1(@RequestBody(required = true) UnAssignE1FromExcAVR3Command command) {
    try {
      ExcAVR3BusinessDelegate.getExcAVR3Instance().unAssignE1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign E1", exc);
    }
  }

  /**
   * save E2 on ExcAVR3
   *
   * @param command AssignE2ToExcAVR3Command
   */
  @PutMapping("/assignE2")
  public void assignE2(@RequestBody AssignE2ToExcAVR3Command command) {
    try {
      ExcAVR3BusinessDelegate.getExcAVR3Instance().assignE2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign E2", exc);
    }
  }

  /**
   * unassign E2 on ExcAVR3
   *
   * @param command UnAssignE2FromExcAVR3Command
   */
  @PutMapping("/unAssignE2")
  public void unAssignE2(@RequestBody(required = true) UnAssignE2FromExcAVR3Command command) {
    try {
      ExcAVR3BusinessDelegate.getExcAVR3Instance().unAssignE2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign E2", exc);
    }
  }

  /**
   * save Ka on ExcAVR3
   *
   * @param command AssignKaToExcAVR3Command
   */
  @PutMapping("/assignKa")
  public void assignKa(@RequestBody AssignKaToExcAVR3Command command) {
    try {
      ExcAVR3BusinessDelegate.getExcAVR3Instance().assignKa(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ka", exc);
    }
  }

  /**
   * unassign Ka on ExcAVR3
   *
   * @param command UnAssignKaFromExcAVR3Command
   */
  @PutMapping("/unAssignKa")
  public void unAssignKa(@RequestBody(required = true) UnAssignKaFromExcAVR3Command command) {
    try {
      ExcAVR3BusinessDelegate.getExcAVR3Instance().unAssignKa(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ka", exc);
    }
  }

  /**
   * save Se1 on ExcAVR3
   *
   * @param command AssignSe1ToExcAVR3Command
   */
  @PutMapping("/assignSe1")
  public void assignSe1(@RequestBody AssignSe1ToExcAVR3Command command) {
    try {
      ExcAVR3BusinessDelegate.getExcAVR3Instance().assignSe1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Se1", exc);
    }
  }

  /**
   * unassign Se1 on ExcAVR3
   *
   * @param command UnAssignSe1FromExcAVR3Command
   */
  @PutMapping("/unAssignSe1")
  public void unAssignSe1(@RequestBody(required = true) UnAssignSe1FromExcAVR3Command command) {
    try {
      ExcAVR3BusinessDelegate.getExcAVR3Instance().unAssignSe1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Se1", exc);
    }
  }

  /**
   * save Se2 on ExcAVR3
   *
   * @param command AssignSe2ToExcAVR3Command
   */
  @PutMapping("/assignSe2")
  public void assignSe2(@RequestBody AssignSe2ToExcAVR3Command command) {
    try {
      ExcAVR3BusinessDelegate.getExcAVR3Instance().assignSe2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Se2", exc);
    }
  }

  /**
   * unassign Se2 on ExcAVR3
   *
   * @param command UnAssignSe2FromExcAVR3Command
   */
  @PutMapping("/unAssignSe2")
  public void unAssignSe2(@RequestBody(required = true) UnAssignSe2FromExcAVR3Command command) {
    try {
      ExcAVR3BusinessDelegate.getExcAVR3Instance().unAssignSe2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Se2", exc);
    }
  }

  /**
   * save T1 on ExcAVR3
   *
   * @param command AssignT1ToExcAVR3Command
   */
  @PutMapping("/assignT1")
  public void assignT1(@RequestBody AssignT1ToExcAVR3Command command) {
    try {
      ExcAVR3BusinessDelegate.getExcAVR3Instance().assignT1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T1", exc);
    }
  }

  /**
   * unassign T1 on ExcAVR3
   *
   * @param command UnAssignT1FromExcAVR3Command
   */
  @PutMapping("/unAssignT1")
  public void unAssignT1(@RequestBody(required = true) UnAssignT1FromExcAVR3Command command) {
    try {
      ExcAVR3BusinessDelegate.getExcAVR3Instance().unAssignT1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T1", exc);
    }
  }

  /**
   * save T2 on ExcAVR3
   *
   * @param command AssignT2ToExcAVR3Command
   */
  @PutMapping("/assignT2")
  public void assignT2(@RequestBody AssignT2ToExcAVR3Command command) {
    try {
      ExcAVR3BusinessDelegate.getExcAVR3Instance().assignT2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T2", exc);
    }
  }

  /**
   * unassign T2 on ExcAVR3
   *
   * @param command UnAssignT2FromExcAVR3Command
   */
  @PutMapping("/unAssignT2")
  public void unAssignT2(@RequestBody(required = true) UnAssignT2FromExcAVR3Command command) {
    try {
      ExcAVR3BusinessDelegate.getExcAVR3Instance().unAssignT2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T2", exc);
    }
  }

  /**
   * save T3 on ExcAVR3
   *
   * @param command AssignT3ToExcAVR3Command
   */
  @PutMapping("/assignT3")
  public void assignT3(@RequestBody AssignT3ToExcAVR3Command command) {
    try {
      ExcAVR3BusinessDelegate.getExcAVR3Instance().assignT3(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T3", exc);
    }
  }

  /**
   * unassign T3 on ExcAVR3
   *
   * @param command UnAssignT3FromExcAVR3Command
   */
  @PutMapping("/unAssignT3")
  public void unAssignT3(@RequestBody(required = true) UnAssignT3FromExcAVR3Command command) {
    try {
      ExcAVR3BusinessDelegate.getExcAVR3Instance().unAssignT3(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T3", exc);
    }
  }

  /**
   * save T4 on ExcAVR3
   *
   * @param command AssignT4ToExcAVR3Command
   */
  @PutMapping("/assignT4")
  public void assignT4(@RequestBody AssignT4ToExcAVR3Command command) {
    try {
      ExcAVR3BusinessDelegate.getExcAVR3Instance().assignT4(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T4", exc);
    }
  }

  /**
   * unassign T4 on ExcAVR3
   *
   * @param command UnAssignT4FromExcAVR3Command
   */
  @PutMapping("/unAssignT4")
  public void unAssignT4(@RequestBody(required = true) UnAssignT4FromExcAVR3Command command) {
    try {
      ExcAVR3BusinessDelegate.getExcAVR3Instance().unAssignT4(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T4", exc);
    }
  }

  /**
   * save Te on ExcAVR3
   *
   * @param command AssignTeToExcAVR3Command
   */
  @PutMapping("/assignTe")
  public void assignTe(@RequestBody AssignTeToExcAVR3Command command) {
    try {
      ExcAVR3BusinessDelegate.getExcAVR3Instance().assignTe(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Te", exc);
    }
  }

  /**
   * unassign Te on ExcAVR3
   *
   * @param command UnAssignTeFromExcAVR3Command
   */
  @PutMapping("/unAssignTe")
  public void unAssignTe(@RequestBody(required = true) UnAssignTeFromExcAVR3Command command) {
    try {
      ExcAVR3BusinessDelegate.getExcAVR3Instance().unAssignTe(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Te", exc);
    }
  }

  /**
   * save Vrmn on ExcAVR3
   *
   * @param command AssignVrmnToExcAVR3Command
   */
  @PutMapping("/assignVrmn")
  public void assignVrmn(@RequestBody AssignVrmnToExcAVR3Command command) {
    try {
      ExcAVR3BusinessDelegate.getExcAVR3Instance().assignVrmn(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vrmn", exc);
    }
  }

  /**
   * unassign Vrmn on ExcAVR3
   *
   * @param command UnAssignVrmnFromExcAVR3Command
   */
  @PutMapping("/unAssignVrmn")
  public void unAssignVrmn(@RequestBody(required = true) UnAssignVrmnFromExcAVR3Command command) {
    try {
      ExcAVR3BusinessDelegate.getExcAVR3Instance().unAssignVrmn(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vrmn", exc);
    }
  }

  /**
   * save Vrmx on ExcAVR3
   *
   * @param command AssignVrmxToExcAVR3Command
   */
  @PutMapping("/assignVrmx")
  public void assignVrmx(@RequestBody AssignVrmxToExcAVR3Command command) {
    try {
      ExcAVR3BusinessDelegate.getExcAVR3Instance().assignVrmx(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vrmx", exc);
    }
  }

  /**
   * unassign Vrmx on ExcAVR3
   *
   * @param command UnAssignVrmxFromExcAVR3Command
   */
  @PutMapping("/unAssignVrmx")
  public void unAssignVrmx(@RequestBody(required = true) UnAssignVrmxFromExcAVR3Command command) {
    try {
      ExcAVR3BusinessDelegate.getExcAVR3Instance().unAssignVrmx(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vrmx", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected ExcAVR3 excAVR3 = null;
  private static final Logger LOGGER =
      Logger.getLogger(ExcAVR3CommandRestController.class.getName());
}
