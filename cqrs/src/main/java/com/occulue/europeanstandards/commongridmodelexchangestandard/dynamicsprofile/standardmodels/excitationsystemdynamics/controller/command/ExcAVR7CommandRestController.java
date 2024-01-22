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
 * Implements Spring Controller command CQRS processing for entity ExcAVR7.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcAVR7")
public class ExcAVR7CommandRestController extends BaseSpringRestController {

  /**
   * Handles create a ExcAVR7. if not key provided, calls create, otherwise calls save
   *
   * @param ExcAVR7 excAVR7
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateExcAVR7Command command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture = ExcAVR7BusinessDelegate.getExcAVR7Instance().createExcAVR7(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a ExcAVR7. if no key provided, calls create, otherwise calls save
   *
   * @param ExcAVR7 excAVR7
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateExcAVR7Command command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateExcAVR7Command
      // -----------------------------------------------
      completableFuture = ExcAVR7BusinessDelegate.getExcAVR7Instance().updateExcAVR7(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "ExcAVR7Controller:update() - successfully update ExcAVR7 - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a ExcAVR7 entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID excAVR7Id) {
    CompletableFuture<Void> completableFuture = null;
    DeleteExcAVR7Command command = new DeleteExcAVR7Command(excAVR7Id);

    try {
      ExcAVR7BusinessDelegate delegate = ExcAVR7BusinessDelegate.getExcAVR7Instance();

      completableFuture = delegate.delete(command);
      LOGGER.log(Level.WARNING, "Successfully deleted ExcAVR7 with key " + command.getExcAVR7Id());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save A1 on ExcAVR7
   *
   * @param command AssignA1ToExcAVR7Command
   */
  @PutMapping("/assignA1")
  public void assignA1(@RequestBody AssignA1ToExcAVR7Command command) {
    try {
      ExcAVR7BusinessDelegate.getExcAVR7Instance().assignA1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign A1", exc);
    }
  }

  /**
   * unassign A1 on ExcAVR7
   *
   * @param command UnAssignA1FromExcAVR7Command
   */
  @PutMapping("/unAssignA1")
  public void unAssignA1(@RequestBody(required = true) UnAssignA1FromExcAVR7Command command) {
    try {
      ExcAVR7BusinessDelegate.getExcAVR7Instance().unAssignA1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign A1", exc);
    }
  }

  /**
   * save A2 on ExcAVR7
   *
   * @param command AssignA2ToExcAVR7Command
   */
  @PutMapping("/assignA2")
  public void assignA2(@RequestBody AssignA2ToExcAVR7Command command) {
    try {
      ExcAVR7BusinessDelegate.getExcAVR7Instance().assignA2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign A2", exc);
    }
  }

  /**
   * unassign A2 on ExcAVR7
   *
   * @param command UnAssignA2FromExcAVR7Command
   */
  @PutMapping("/unAssignA2")
  public void unAssignA2(@RequestBody(required = true) UnAssignA2FromExcAVR7Command command) {
    try {
      ExcAVR7BusinessDelegate.getExcAVR7Instance().unAssignA2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign A2", exc);
    }
  }

  /**
   * save A3 on ExcAVR7
   *
   * @param command AssignA3ToExcAVR7Command
   */
  @PutMapping("/assignA3")
  public void assignA3(@RequestBody AssignA3ToExcAVR7Command command) {
    try {
      ExcAVR7BusinessDelegate.getExcAVR7Instance().assignA3(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign A3", exc);
    }
  }

  /**
   * unassign A3 on ExcAVR7
   *
   * @param command UnAssignA3FromExcAVR7Command
   */
  @PutMapping("/unAssignA3")
  public void unAssignA3(@RequestBody(required = true) UnAssignA3FromExcAVR7Command command) {
    try {
      ExcAVR7BusinessDelegate.getExcAVR7Instance().unAssignA3(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign A3", exc);
    }
  }

  /**
   * save A4 on ExcAVR7
   *
   * @param command AssignA4ToExcAVR7Command
   */
  @PutMapping("/assignA4")
  public void assignA4(@RequestBody AssignA4ToExcAVR7Command command) {
    try {
      ExcAVR7BusinessDelegate.getExcAVR7Instance().assignA4(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign A4", exc);
    }
  }

  /**
   * unassign A4 on ExcAVR7
   *
   * @param command UnAssignA4FromExcAVR7Command
   */
  @PutMapping("/unAssignA4")
  public void unAssignA4(@RequestBody(required = true) UnAssignA4FromExcAVR7Command command) {
    try {
      ExcAVR7BusinessDelegate.getExcAVR7Instance().unAssignA4(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign A4", exc);
    }
  }

  /**
   * save A5 on ExcAVR7
   *
   * @param command AssignA5ToExcAVR7Command
   */
  @PutMapping("/assignA5")
  public void assignA5(@RequestBody AssignA5ToExcAVR7Command command) {
    try {
      ExcAVR7BusinessDelegate.getExcAVR7Instance().assignA5(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign A5", exc);
    }
  }

  /**
   * unassign A5 on ExcAVR7
   *
   * @param command UnAssignA5FromExcAVR7Command
   */
  @PutMapping("/unAssignA5")
  public void unAssignA5(@RequestBody(required = true) UnAssignA5FromExcAVR7Command command) {
    try {
      ExcAVR7BusinessDelegate.getExcAVR7Instance().unAssignA5(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign A5", exc);
    }
  }

  /**
   * save A6 on ExcAVR7
   *
   * @param command AssignA6ToExcAVR7Command
   */
  @PutMapping("/assignA6")
  public void assignA6(@RequestBody AssignA6ToExcAVR7Command command) {
    try {
      ExcAVR7BusinessDelegate.getExcAVR7Instance().assignA6(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign A6", exc);
    }
  }

  /**
   * unassign A6 on ExcAVR7
   *
   * @param command UnAssignA6FromExcAVR7Command
   */
  @PutMapping("/unAssignA6")
  public void unAssignA6(@RequestBody(required = true) UnAssignA6FromExcAVR7Command command) {
    try {
      ExcAVR7BusinessDelegate.getExcAVR7Instance().unAssignA6(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign A6", exc);
    }
  }

  /**
   * save K1 on ExcAVR7
   *
   * @param command AssignK1ToExcAVR7Command
   */
  @PutMapping("/assignK1")
  public void assignK1(@RequestBody AssignK1ToExcAVR7Command command) {
    try {
      ExcAVR7BusinessDelegate.getExcAVR7Instance().assignK1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign K1", exc);
    }
  }

  /**
   * unassign K1 on ExcAVR7
   *
   * @param command UnAssignK1FromExcAVR7Command
   */
  @PutMapping("/unAssignK1")
  public void unAssignK1(@RequestBody(required = true) UnAssignK1FromExcAVR7Command command) {
    try {
      ExcAVR7BusinessDelegate.getExcAVR7Instance().unAssignK1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign K1", exc);
    }
  }

  /**
   * save K3 on ExcAVR7
   *
   * @param command AssignK3ToExcAVR7Command
   */
  @PutMapping("/assignK3")
  public void assignK3(@RequestBody AssignK3ToExcAVR7Command command) {
    try {
      ExcAVR7BusinessDelegate.getExcAVR7Instance().assignK3(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign K3", exc);
    }
  }

  /**
   * unassign K3 on ExcAVR7
   *
   * @param command UnAssignK3FromExcAVR7Command
   */
  @PutMapping("/unAssignK3")
  public void unAssignK3(@RequestBody(required = true) UnAssignK3FromExcAVR7Command command) {
    try {
      ExcAVR7BusinessDelegate.getExcAVR7Instance().unAssignK3(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign K3", exc);
    }
  }

  /**
   * save K5 on ExcAVR7
   *
   * @param command AssignK5ToExcAVR7Command
   */
  @PutMapping("/assignK5")
  public void assignK5(@RequestBody AssignK5ToExcAVR7Command command) {
    try {
      ExcAVR7BusinessDelegate.getExcAVR7Instance().assignK5(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign K5", exc);
    }
  }

  /**
   * unassign K5 on ExcAVR7
   *
   * @param command UnAssignK5FromExcAVR7Command
   */
  @PutMapping("/unAssignK5")
  public void unAssignK5(@RequestBody(required = true) UnAssignK5FromExcAVR7Command command) {
    try {
      ExcAVR7BusinessDelegate.getExcAVR7Instance().unAssignK5(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign K5", exc);
    }
  }

  /**
   * save T1 on ExcAVR7
   *
   * @param command AssignT1ToExcAVR7Command
   */
  @PutMapping("/assignT1")
  public void assignT1(@RequestBody AssignT1ToExcAVR7Command command) {
    try {
      ExcAVR7BusinessDelegate.getExcAVR7Instance().assignT1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T1", exc);
    }
  }

  /**
   * unassign T1 on ExcAVR7
   *
   * @param command UnAssignT1FromExcAVR7Command
   */
  @PutMapping("/unAssignT1")
  public void unAssignT1(@RequestBody(required = true) UnAssignT1FromExcAVR7Command command) {
    try {
      ExcAVR7BusinessDelegate.getExcAVR7Instance().unAssignT1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T1", exc);
    }
  }

  /**
   * save T2 on ExcAVR7
   *
   * @param command AssignT2ToExcAVR7Command
   */
  @PutMapping("/assignT2")
  public void assignT2(@RequestBody AssignT2ToExcAVR7Command command) {
    try {
      ExcAVR7BusinessDelegate.getExcAVR7Instance().assignT2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T2", exc);
    }
  }

  /**
   * unassign T2 on ExcAVR7
   *
   * @param command UnAssignT2FromExcAVR7Command
   */
  @PutMapping("/unAssignT2")
  public void unAssignT2(@RequestBody(required = true) UnAssignT2FromExcAVR7Command command) {
    try {
      ExcAVR7BusinessDelegate.getExcAVR7Instance().unAssignT2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T2", exc);
    }
  }

  /**
   * save T3 on ExcAVR7
   *
   * @param command AssignT3ToExcAVR7Command
   */
  @PutMapping("/assignT3")
  public void assignT3(@RequestBody AssignT3ToExcAVR7Command command) {
    try {
      ExcAVR7BusinessDelegate.getExcAVR7Instance().assignT3(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T3", exc);
    }
  }

  /**
   * unassign T3 on ExcAVR7
   *
   * @param command UnAssignT3FromExcAVR7Command
   */
  @PutMapping("/unAssignT3")
  public void unAssignT3(@RequestBody(required = true) UnAssignT3FromExcAVR7Command command) {
    try {
      ExcAVR7BusinessDelegate.getExcAVR7Instance().unAssignT3(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T3", exc);
    }
  }

  /**
   * save T4 on ExcAVR7
   *
   * @param command AssignT4ToExcAVR7Command
   */
  @PutMapping("/assignT4")
  public void assignT4(@RequestBody AssignT4ToExcAVR7Command command) {
    try {
      ExcAVR7BusinessDelegate.getExcAVR7Instance().assignT4(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T4", exc);
    }
  }

  /**
   * unassign T4 on ExcAVR7
   *
   * @param command UnAssignT4FromExcAVR7Command
   */
  @PutMapping("/unAssignT4")
  public void unAssignT4(@RequestBody(required = true) UnAssignT4FromExcAVR7Command command) {
    try {
      ExcAVR7BusinessDelegate.getExcAVR7Instance().unAssignT4(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T4", exc);
    }
  }

  /**
   * save T5 on ExcAVR7
   *
   * @param command AssignT5ToExcAVR7Command
   */
  @PutMapping("/assignT5")
  public void assignT5(@RequestBody AssignT5ToExcAVR7Command command) {
    try {
      ExcAVR7BusinessDelegate.getExcAVR7Instance().assignT5(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T5", exc);
    }
  }

  /**
   * unassign T5 on ExcAVR7
   *
   * @param command UnAssignT5FromExcAVR7Command
   */
  @PutMapping("/unAssignT5")
  public void unAssignT5(@RequestBody(required = true) UnAssignT5FromExcAVR7Command command) {
    try {
      ExcAVR7BusinessDelegate.getExcAVR7Instance().unAssignT5(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T5", exc);
    }
  }

  /**
   * save T6 on ExcAVR7
   *
   * @param command AssignT6ToExcAVR7Command
   */
  @PutMapping("/assignT6")
  public void assignT6(@RequestBody AssignT6ToExcAVR7Command command) {
    try {
      ExcAVR7BusinessDelegate.getExcAVR7Instance().assignT6(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T6", exc);
    }
  }

  /**
   * unassign T6 on ExcAVR7
   *
   * @param command UnAssignT6FromExcAVR7Command
   */
  @PutMapping("/unAssignT6")
  public void unAssignT6(@RequestBody(required = true) UnAssignT6FromExcAVR7Command command) {
    try {
      ExcAVR7BusinessDelegate.getExcAVR7Instance().unAssignT6(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T6", exc);
    }
  }

  /**
   * save Vmax1 on ExcAVR7
   *
   * @param command AssignVmax1ToExcAVR7Command
   */
  @PutMapping("/assignVmax1")
  public void assignVmax1(@RequestBody AssignVmax1ToExcAVR7Command command) {
    try {
      ExcAVR7BusinessDelegate.getExcAVR7Instance().assignVmax1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vmax1", exc);
    }
  }

  /**
   * unassign Vmax1 on ExcAVR7
   *
   * @param command UnAssignVmax1FromExcAVR7Command
   */
  @PutMapping("/unAssignVmax1")
  public void unAssignVmax1(@RequestBody(required = true) UnAssignVmax1FromExcAVR7Command command) {
    try {
      ExcAVR7BusinessDelegate.getExcAVR7Instance().unAssignVmax1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vmax1", exc);
    }
  }

  /**
   * save Vmax3 on ExcAVR7
   *
   * @param command AssignVmax3ToExcAVR7Command
   */
  @PutMapping("/assignVmax3")
  public void assignVmax3(@RequestBody AssignVmax3ToExcAVR7Command command) {
    try {
      ExcAVR7BusinessDelegate.getExcAVR7Instance().assignVmax3(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vmax3", exc);
    }
  }

  /**
   * unassign Vmax3 on ExcAVR7
   *
   * @param command UnAssignVmax3FromExcAVR7Command
   */
  @PutMapping("/unAssignVmax3")
  public void unAssignVmax3(@RequestBody(required = true) UnAssignVmax3FromExcAVR7Command command) {
    try {
      ExcAVR7BusinessDelegate.getExcAVR7Instance().unAssignVmax3(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vmax3", exc);
    }
  }

  /**
   * save Vmax5 on ExcAVR7
   *
   * @param command AssignVmax5ToExcAVR7Command
   */
  @PutMapping("/assignVmax5")
  public void assignVmax5(@RequestBody AssignVmax5ToExcAVR7Command command) {
    try {
      ExcAVR7BusinessDelegate.getExcAVR7Instance().assignVmax5(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vmax5", exc);
    }
  }

  /**
   * unassign Vmax5 on ExcAVR7
   *
   * @param command UnAssignVmax5FromExcAVR7Command
   */
  @PutMapping("/unAssignVmax5")
  public void unAssignVmax5(@RequestBody(required = true) UnAssignVmax5FromExcAVR7Command command) {
    try {
      ExcAVR7BusinessDelegate.getExcAVR7Instance().unAssignVmax5(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vmax5", exc);
    }
  }

  /**
   * save Vmin1 on ExcAVR7
   *
   * @param command AssignVmin1ToExcAVR7Command
   */
  @PutMapping("/assignVmin1")
  public void assignVmin1(@RequestBody AssignVmin1ToExcAVR7Command command) {
    try {
      ExcAVR7BusinessDelegate.getExcAVR7Instance().assignVmin1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vmin1", exc);
    }
  }

  /**
   * unassign Vmin1 on ExcAVR7
   *
   * @param command UnAssignVmin1FromExcAVR7Command
   */
  @PutMapping("/unAssignVmin1")
  public void unAssignVmin1(@RequestBody(required = true) UnAssignVmin1FromExcAVR7Command command) {
    try {
      ExcAVR7BusinessDelegate.getExcAVR7Instance().unAssignVmin1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vmin1", exc);
    }
  }

  /**
   * save Vmin3 on ExcAVR7
   *
   * @param command AssignVmin3ToExcAVR7Command
   */
  @PutMapping("/assignVmin3")
  public void assignVmin3(@RequestBody AssignVmin3ToExcAVR7Command command) {
    try {
      ExcAVR7BusinessDelegate.getExcAVR7Instance().assignVmin3(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vmin3", exc);
    }
  }

  /**
   * unassign Vmin3 on ExcAVR7
   *
   * @param command UnAssignVmin3FromExcAVR7Command
   */
  @PutMapping("/unAssignVmin3")
  public void unAssignVmin3(@RequestBody(required = true) UnAssignVmin3FromExcAVR7Command command) {
    try {
      ExcAVR7BusinessDelegate.getExcAVR7Instance().unAssignVmin3(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vmin3", exc);
    }
  }

  /**
   * save Vmin5 on ExcAVR7
   *
   * @param command AssignVmin5ToExcAVR7Command
   */
  @PutMapping("/assignVmin5")
  public void assignVmin5(@RequestBody AssignVmin5ToExcAVR7Command command) {
    try {
      ExcAVR7BusinessDelegate.getExcAVR7Instance().assignVmin5(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vmin5", exc);
    }
  }

  /**
   * unassign Vmin5 on ExcAVR7
   *
   * @param command UnAssignVmin5FromExcAVR7Command
   */
  @PutMapping("/unAssignVmin5")
  public void unAssignVmin5(@RequestBody(required = true) UnAssignVmin5FromExcAVR7Command command) {
    try {
      ExcAVR7BusinessDelegate.getExcAVR7Instance().unAssignVmin5(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vmin5", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected ExcAVR7 excAVR7 = null;
  private static final Logger LOGGER =
      Logger.getLogger(ExcAVR7CommandRestController.class.getName());
}
