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
 * Implements Spring Controller command CQRS processing for entity ExcIEEEAC7B.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcIEEEAC7B")
public class ExcIEEEAC7BCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a ExcIEEEAC7B. if not key provided, calls create, otherwise calls save
   *
   * @param ExcIEEEAC7B excIEEEAC7B
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateExcIEEEAC7BCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          ExcIEEEAC7BBusinessDelegate.getExcIEEEAC7BInstance().createExcIEEEAC7B(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a ExcIEEEAC7B. if no key provided, calls create, otherwise calls save
   *
   * @param ExcIEEEAC7B excIEEEAC7B
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateExcIEEEAC7BCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateExcIEEEAC7BCommand
      // -----------------------------------------------
      completableFuture =
          ExcIEEEAC7BBusinessDelegate.getExcIEEEAC7BInstance().updateExcIEEEAC7B(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "ExcIEEEAC7BController:update() - successfully update ExcIEEEAC7B - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a ExcIEEEAC7B entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID excIEEEAC7BId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteExcIEEEAC7BCommand command = new DeleteExcIEEEAC7BCommand(excIEEEAC7BId);

    try {
      ExcIEEEAC7BBusinessDelegate delegate = ExcIEEEAC7BBusinessDelegate.getExcIEEEAC7BInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING, "Successfully deleted ExcIEEEAC7B with key " + command.getExcIEEEAC7BId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Kc on ExcIEEEAC7B
   *
   * @param command AssignKcToExcIEEEAC7BCommand
   */
  @PutMapping("/assignKc")
  public void assignKc(@RequestBody AssignKcToExcIEEEAC7BCommand command) {
    try {
      ExcIEEEAC7BBusinessDelegate.getExcIEEEAC7BInstance().assignKc(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kc", exc);
    }
  }

  /**
   * unassign Kc on ExcIEEEAC7B
   *
   * @param command UnAssignKcFromExcIEEEAC7BCommand
   */
  @PutMapping("/unAssignKc")
  public void unAssignKc(@RequestBody(required = true) UnAssignKcFromExcIEEEAC7BCommand command) {
    try {
      ExcIEEEAC7BBusinessDelegate.getExcIEEEAC7BInstance().unAssignKc(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kc", exc);
    }
  }

  /**
   * save Kd on ExcIEEEAC7B
   *
   * @param command AssignKdToExcIEEEAC7BCommand
   */
  @PutMapping("/assignKd")
  public void assignKd(@RequestBody AssignKdToExcIEEEAC7BCommand command) {
    try {
      ExcIEEEAC7BBusinessDelegate.getExcIEEEAC7BInstance().assignKd(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kd", exc);
    }
  }

  /**
   * unassign Kd on ExcIEEEAC7B
   *
   * @param command UnAssignKdFromExcIEEEAC7BCommand
   */
  @PutMapping("/unAssignKd")
  public void unAssignKd(@RequestBody(required = true) UnAssignKdFromExcIEEEAC7BCommand command) {
    try {
      ExcIEEEAC7BBusinessDelegate.getExcIEEEAC7BInstance().unAssignKd(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kd", exc);
    }
  }

  /**
   * save Kdr on ExcIEEEAC7B
   *
   * @param command AssignKdrToExcIEEEAC7BCommand
   */
  @PutMapping("/assignKdr")
  public void assignKdr(@RequestBody AssignKdrToExcIEEEAC7BCommand command) {
    try {
      ExcIEEEAC7BBusinessDelegate.getExcIEEEAC7BInstance().assignKdr(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kdr", exc);
    }
  }

  /**
   * unassign Kdr on ExcIEEEAC7B
   *
   * @param command UnAssignKdrFromExcIEEEAC7BCommand
   */
  @PutMapping("/unAssignKdr")
  public void unAssignKdr(@RequestBody(required = true) UnAssignKdrFromExcIEEEAC7BCommand command) {
    try {
      ExcIEEEAC7BBusinessDelegate.getExcIEEEAC7BInstance().unAssignKdr(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kdr", exc);
    }
  }

  /**
   * save Ke on ExcIEEEAC7B
   *
   * @param command AssignKeToExcIEEEAC7BCommand
   */
  @PutMapping("/assignKe")
  public void assignKe(@RequestBody AssignKeToExcIEEEAC7BCommand command) {
    try {
      ExcIEEEAC7BBusinessDelegate.getExcIEEEAC7BInstance().assignKe(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ke", exc);
    }
  }

  /**
   * unassign Ke on ExcIEEEAC7B
   *
   * @param command UnAssignKeFromExcIEEEAC7BCommand
   */
  @PutMapping("/unAssignKe")
  public void unAssignKe(@RequestBody(required = true) UnAssignKeFromExcIEEEAC7BCommand command) {
    try {
      ExcIEEEAC7BBusinessDelegate.getExcIEEEAC7BInstance().unAssignKe(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ke", exc);
    }
  }

  /**
   * save Kf1 on ExcIEEEAC7B
   *
   * @param command AssignKf1ToExcIEEEAC7BCommand
   */
  @PutMapping("/assignKf1")
  public void assignKf1(@RequestBody AssignKf1ToExcIEEEAC7BCommand command) {
    try {
      ExcIEEEAC7BBusinessDelegate.getExcIEEEAC7BInstance().assignKf1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kf1", exc);
    }
  }

  /**
   * unassign Kf1 on ExcIEEEAC7B
   *
   * @param command UnAssignKf1FromExcIEEEAC7BCommand
   */
  @PutMapping("/unAssignKf1")
  public void unAssignKf1(@RequestBody(required = true) UnAssignKf1FromExcIEEEAC7BCommand command) {
    try {
      ExcIEEEAC7BBusinessDelegate.getExcIEEEAC7BInstance().unAssignKf1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kf1", exc);
    }
  }

  /**
   * save Kf2 on ExcIEEEAC7B
   *
   * @param command AssignKf2ToExcIEEEAC7BCommand
   */
  @PutMapping("/assignKf2")
  public void assignKf2(@RequestBody AssignKf2ToExcIEEEAC7BCommand command) {
    try {
      ExcIEEEAC7BBusinessDelegate.getExcIEEEAC7BInstance().assignKf2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kf2", exc);
    }
  }

  /**
   * unassign Kf2 on ExcIEEEAC7B
   *
   * @param command UnAssignKf2FromExcIEEEAC7BCommand
   */
  @PutMapping("/unAssignKf2")
  public void unAssignKf2(@RequestBody(required = true) UnAssignKf2FromExcIEEEAC7BCommand command) {
    try {
      ExcIEEEAC7BBusinessDelegate.getExcIEEEAC7BInstance().unAssignKf2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kf2", exc);
    }
  }

  /**
   * save Kf3 on ExcIEEEAC7B
   *
   * @param command AssignKf3ToExcIEEEAC7BCommand
   */
  @PutMapping("/assignKf3")
  public void assignKf3(@RequestBody AssignKf3ToExcIEEEAC7BCommand command) {
    try {
      ExcIEEEAC7BBusinessDelegate.getExcIEEEAC7BInstance().assignKf3(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kf3", exc);
    }
  }

  /**
   * unassign Kf3 on ExcIEEEAC7B
   *
   * @param command UnAssignKf3FromExcIEEEAC7BCommand
   */
  @PutMapping("/unAssignKf3")
  public void unAssignKf3(@RequestBody(required = true) UnAssignKf3FromExcIEEEAC7BCommand command) {
    try {
      ExcIEEEAC7BBusinessDelegate.getExcIEEEAC7BInstance().unAssignKf3(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kf3", exc);
    }
  }

  /**
   * save Kia on ExcIEEEAC7B
   *
   * @param command AssignKiaToExcIEEEAC7BCommand
   */
  @PutMapping("/assignKia")
  public void assignKia(@RequestBody AssignKiaToExcIEEEAC7BCommand command) {
    try {
      ExcIEEEAC7BBusinessDelegate.getExcIEEEAC7BInstance().assignKia(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kia", exc);
    }
  }

  /**
   * unassign Kia on ExcIEEEAC7B
   *
   * @param command UnAssignKiaFromExcIEEEAC7BCommand
   */
  @PutMapping("/unAssignKia")
  public void unAssignKia(@RequestBody(required = true) UnAssignKiaFromExcIEEEAC7BCommand command) {
    try {
      ExcIEEEAC7BBusinessDelegate.getExcIEEEAC7BInstance().unAssignKia(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kia", exc);
    }
  }

  /**
   * save Kir on ExcIEEEAC7B
   *
   * @param command AssignKirToExcIEEEAC7BCommand
   */
  @PutMapping("/assignKir")
  public void assignKir(@RequestBody AssignKirToExcIEEEAC7BCommand command) {
    try {
      ExcIEEEAC7BBusinessDelegate.getExcIEEEAC7BInstance().assignKir(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kir", exc);
    }
  }

  /**
   * unassign Kir on ExcIEEEAC7B
   *
   * @param command UnAssignKirFromExcIEEEAC7BCommand
   */
  @PutMapping("/unAssignKir")
  public void unAssignKir(@RequestBody(required = true) UnAssignKirFromExcIEEEAC7BCommand command) {
    try {
      ExcIEEEAC7BBusinessDelegate.getExcIEEEAC7BInstance().unAssignKir(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kir", exc);
    }
  }

  /**
   * save Kl on ExcIEEEAC7B
   *
   * @param command AssignKlToExcIEEEAC7BCommand
   */
  @PutMapping("/assignKl")
  public void assignKl(@RequestBody AssignKlToExcIEEEAC7BCommand command) {
    try {
      ExcIEEEAC7BBusinessDelegate.getExcIEEEAC7BInstance().assignKl(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kl", exc);
    }
  }

  /**
   * unassign Kl on ExcIEEEAC7B
   *
   * @param command UnAssignKlFromExcIEEEAC7BCommand
   */
  @PutMapping("/unAssignKl")
  public void unAssignKl(@RequestBody(required = true) UnAssignKlFromExcIEEEAC7BCommand command) {
    try {
      ExcIEEEAC7BBusinessDelegate.getExcIEEEAC7BInstance().unAssignKl(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kl", exc);
    }
  }

  /**
   * save Kp on ExcIEEEAC7B
   *
   * @param command AssignKpToExcIEEEAC7BCommand
   */
  @PutMapping("/assignKp")
  public void assignKp(@RequestBody AssignKpToExcIEEEAC7BCommand command) {
    try {
      ExcIEEEAC7BBusinessDelegate.getExcIEEEAC7BInstance().assignKp(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kp", exc);
    }
  }

  /**
   * unassign Kp on ExcIEEEAC7B
   *
   * @param command UnAssignKpFromExcIEEEAC7BCommand
   */
  @PutMapping("/unAssignKp")
  public void unAssignKp(@RequestBody(required = true) UnAssignKpFromExcIEEEAC7BCommand command) {
    try {
      ExcIEEEAC7BBusinessDelegate.getExcIEEEAC7BInstance().unAssignKp(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kp", exc);
    }
  }

  /**
   * save Kpa on ExcIEEEAC7B
   *
   * @param command AssignKpaToExcIEEEAC7BCommand
   */
  @PutMapping("/assignKpa")
  public void assignKpa(@RequestBody AssignKpaToExcIEEEAC7BCommand command) {
    try {
      ExcIEEEAC7BBusinessDelegate.getExcIEEEAC7BInstance().assignKpa(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kpa", exc);
    }
  }

  /**
   * unassign Kpa on ExcIEEEAC7B
   *
   * @param command UnAssignKpaFromExcIEEEAC7BCommand
   */
  @PutMapping("/unAssignKpa")
  public void unAssignKpa(@RequestBody(required = true) UnAssignKpaFromExcIEEEAC7BCommand command) {
    try {
      ExcIEEEAC7BBusinessDelegate.getExcIEEEAC7BInstance().unAssignKpa(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kpa", exc);
    }
  }

  /**
   * save Kpr on ExcIEEEAC7B
   *
   * @param command AssignKprToExcIEEEAC7BCommand
   */
  @PutMapping("/assignKpr")
  public void assignKpr(@RequestBody AssignKprToExcIEEEAC7BCommand command) {
    try {
      ExcIEEEAC7BBusinessDelegate.getExcIEEEAC7BInstance().assignKpr(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kpr", exc);
    }
  }

  /**
   * unassign Kpr on ExcIEEEAC7B
   *
   * @param command UnAssignKprFromExcIEEEAC7BCommand
   */
  @PutMapping("/unAssignKpr")
  public void unAssignKpr(@RequestBody(required = true) UnAssignKprFromExcIEEEAC7BCommand command) {
    try {
      ExcIEEEAC7BBusinessDelegate.getExcIEEEAC7BInstance().unAssignKpr(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kpr", exc);
    }
  }

  /**
   * save Seve1 on ExcIEEEAC7B
   *
   * @param command AssignSeve1ToExcIEEEAC7BCommand
   */
  @PutMapping("/assignSeve1")
  public void assignSeve1(@RequestBody AssignSeve1ToExcIEEEAC7BCommand command) {
    try {
      ExcIEEEAC7BBusinessDelegate.getExcIEEEAC7BInstance().assignSeve1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Seve1", exc);
    }
  }

  /**
   * unassign Seve1 on ExcIEEEAC7B
   *
   * @param command UnAssignSeve1FromExcIEEEAC7BCommand
   */
  @PutMapping("/unAssignSeve1")
  public void unAssignSeve1(
      @RequestBody(required = true) UnAssignSeve1FromExcIEEEAC7BCommand command) {
    try {
      ExcIEEEAC7BBusinessDelegate.getExcIEEEAC7BInstance().unAssignSeve1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Seve1", exc);
    }
  }

  /**
   * save Seve2 on ExcIEEEAC7B
   *
   * @param command AssignSeve2ToExcIEEEAC7BCommand
   */
  @PutMapping("/assignSeve2")
  public void assignSeve2(@RequestBody AssignSeve2ToExcIEEEAC7BCommand command) {
    try {
      ExcIEEEAC7BBusinessDelegate.getExcIEEEAC7BInstance().assignSeve2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Seve2", exc);
    }
  }

  /**
   * unassign Seve2 on ExcIEEEAC7B
   *
   * @param command UnAssignSeve2FromExcIEEEAC7BCommand
   */
  @PutMapping("/unAssignSeve2")
  public void unAssignSeve2(
      @RequestBody(required = true) UnAssignSeve2FromExcIEEEAC7BCommand command) {
    try {
      ExcIEEEAC7BBusinessDelegate.getExcIEEEAC7BInstance().unAssignSeve2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Seve2", exc);
    }
  }

  /**
   * save Tdr on ExcIEEEAC7B
   *
   * @param command AssignTdrToExcIEEEAC7BCommand
   */
  @PutMapping("/assignTdr")
  public void assignTdr(@RequestBody AssignTdrToExcIEEEAC7BCommand command) {
    try {
      ExcIEEEAC7BBusinessDelegate.getExcIEEEAC7BInstance().assignTdr(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tdr", exc);
    }
  }

  /**
   * unassign Tdr on ExcIEEEAC7B
   *
   * @param command UnAssignTdrFromExcIEEEAC7BCommand
   */
  @PutMapping("/unAssignTdr")
  public void unAssignTdr(@RequestBody(required = true) UnAssignTdrFromExcIEEEAC7BCommand command) {
    try {
      ExcIEEEAC7BBusinessDelegate.getExcIEEEAC7BInstance().unAssignTdr(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tdr", exc);
    }
  }

  /**
   * save Te on ExcIEEEAC7B
   *
   * @param command AssignTeToExcIEEEAC7BCommand
   */
  @PutMapping("/assignTe")
  public void assignTe(@RequestBody AssignTeToExcIEEEAC7BCommand command) {
    try {
      ExcIEEEAC7BBusinessDelegate.getExcIEEEAC7BInstance().assignTe(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Te", exc);
    }
  }

  /**
   * unassign Te on ExcIEEEAC7B
   *
   * @param command UnAssignTeFromExcIEEEAC7BCommand
   */
  @PutMapping("/unAssignTe")
  public void unAssignTe(@RequestBody(required = true) UnAssignTeFromExcIEEEAC7BCommand command) {
    try {
      ExcIEEEAC7BBusinessDelegate.getExcIEEEAC7BInstance().unAssignTe(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Te", exc);
    }
  }

  /**
   * save Tf on ExcIEEEAC7B
   *
   * @param command AssignTfToExcIEEEAC7BCommand
   */
  @PutMapping("/assignTf")
  public void assignTf(@RequestBody AssignTfToExcIEEEAC7BCommand command) {
    try {
      ExcIEEEAC7BBusinessDelegate.getExcIEEEAC7BInstance().assignTf(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tf", exc);
    }
  }

  /**
   * unassign Tf on ExcIEEEAC7B
   *
   * @param command UnAssignTfFromExcIEEEAC7BCommand
   */
  @PutMapping("/unAssignTf")
  public void unAssignTf(@RequestBody(required = true) UnAssignTfFromExcIEEEAC7BCommand command) {
    try {
      ExcIEEEAC7BBusinessDelegate.getExcIEEEAC7BInstance().unAssignTf(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tf", exc);
    }
  }

  /**
   * save Vamax on ExcIEEEAC7B
   *
   * @param command AssignVamaxToExcIEEEAC7BCommand
   */
  @PutMapping("/assignVamax")
  public void assignVamax(@RequestBody AssignVamaxToExcIEEEAC7BCommand command) {
    try {
      ExcIEEEAC7BBusinessDelegate.getExcIEEEAC7BInstance().assignVamax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vamax", exc);
    }
  }

  /**
   * unassign Vamax on ExcIEEEAC7B
   *
   * @param command UnAssignVamaxFromExcIEEEAC7BCommand
   */
  @PutMapping("/unAssignVamax")
  public void unAssignVamax(
      @RequestBody(required = true) UnAssignVamaxFromExcIEEEAC7BCommand command) {
    try {
      ExcIEEEAC7BBusinessDelegate.getExcIEEEAC7BInstance().unAssignVamax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vamax", exc);
    }
  }

  /**
   * save Vamin on ExcIEEEAC7B
   *
   * @param command AssignVaminToExcIEEEAC7BCommand
   */
  @PutMapping("/assignVamin")
  public void assignVamin(@RequestBody AssignVaminToExcIEEEAC7BCommand command) {
    try {
      ExcIEEEAC7BBusinessDelegate.getExcIEEEAC7BInstance().assignVamin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vamin", exc);
    }
  }

  /**
   * unassign Vamin on ExcIEEEAC7B
   *
   * @param command UnAssignVaminFromExcIEEEAC7BCommand
   */
  @PutMapping("/unAssignVamin")
  public void unAssignVamin(
      @RequestBody(required = true) UnAssignVaminFromExcIEEEAC7BCommand command) {
    try {
      ExcIEEEAC7BBusinessDelegate.getExcIEEEAC7BInstance().unAssignVamin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vamin", exc);
    }
  }

  /**
   * save Ve1 on ExcIEEEAC7B
   *
   * @param command AssignVe1ToExcIEEEAC7BCommand
   */
  @PutMapping("/assignVe1")
  public void assignVe1(@RequestBody AssignVe1ToExcIEEEAC7BCommand command) {
    try {
      ExcIEEEAC7BBusinessDelegate.getExcIEEEAC7BInstance().assignVe1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ve1", exc);
    }
  }

  /**
   * unassign Ve1 on ExcIEEEAC7B
   *
   * @param command UnAssignVe1FromExcIEEEAC7BCommand
   */
  @PutMapping("/unAssignVe1")
  public void unAssignVe1(@RequestBody(required = true) UnAssignVe1FromExcIEEEAC7BCommand command) {
    try {
      ExcIEEEAC7BBusinessDelegate.getExcIEEEAC7BInstance().unAssignVe1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ve1", exc);
    }
  }

  /**
   * save Ve2 on ExcIEEEAC7B
   *
   * @param command AssignVe2ToExcIEEEAC7BCommand
   */
  @PutMapping("/assignVe2")
  public void assignVe2(@RequestBody AssignVe2ToExcIEEEAC7BCommand command) {
    try {
      ExcIEEEAC7BBusinessDelegate.getExcIEEEAC7BInstance().assignVe2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ve2", exc);
    }
  }

  /**
   * unassign Ve2 on ExcIEEEAC7B
   *
   * @param command UnAssignVe2FromExcIEEEAC7BCommand
   */
  @PutMapping("/unAssignVe2")
  public void unAssignVe2(@RequestBody(required = true) UnAssignVe2FromExcIEEEAC7BCommand command) {
    try {
      ExcIEEEAC7BBusinessDelegate.getExcIEEEAC7BInstance().unAssignVe2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ve2", exc);
    }
  }

  /**
   * save Vemin on ExcIEEEAC7B
   *
   * @param command AssignVeminToExcIEEEAC7BCommand
   */
  @PutMapping("/assignVemin")
  public void assignVemin(@RequestBody AssignVeminToExcIEEEAC7BCommand command) {
    try {
      ExcIEEEAC7BBusinessDelegate.getExcIEEEAC7BInstance().assignVemin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vemin", exc);
    }
  }

  /**
   * unassign Vemin on ExcIEEEAC7B
   *
   * @param command UnAssignVeminFromExcIEEEAC7BCommand
   */
  @PutMapping("/unAssignVemin")
  public void unAssignVemin(
      @RequestBody(required = true) UnAssignVeminFromExcIEEEAC7BCommand command) {
    try {
      ExcIEEEAC7BBusinessDelegate.getExcIEEEAC7BInstance().unAssignVemin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vemin", exc);
    }
  }

  /**
   * save Vfemax on ExcIEEEAC7B
   *
   * @param command AssignVfemaxToExcIEEEAC7BCommand
   */
  @PutMapping("/assignVfemax")
  public void assignVfemax(@RequestBody AssignVfemaxToExcIEEEAC7BCommand command) {
    try {
      ExcIEEEAC7BBusinessDelegate.getExcIEEEAC7BInstance().assignVfemax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vfemax", exc);
    }
  }

  /**
   * unassign Vfemax on ExcIEEEAC7B
   *
   * @param command UnAssignVfemaxFromExcIEEEAC7BCommand
   */
  @PutMapping("/unAssignVfemax")
  public void unAssignVfemax(
      @RequestBody(required = true) UnAssignVfemaxFromExcIEEEAC7BCommand command) {
    try {
      ExcIEEEAC7BBusinessDelegate.getExcIEEEAC7BInstance().unAssignVfemax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vfemax", exc);
    }
  }

  /**
   * save Vrmax on ExcIEEEAC7B
   *
   * @param command AssignVrmaxToExcIEEEAC7BCommand
   */
  @PutMapping("/assignVrmax")
  public void assignVrmax(@RequestBody AssignVrmaxToExcIEEEAC7BCommand command) {
    try {
      ExcIEEEAC7BBusinessDelegate.getExcIEEEAC7BInstance().assignVrmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vrmax", exc);
    }
  }

  /**
   * unassign Vrmax on ExcIEEEAC7B
   *
   * @param command UnAssignVrmaxFromExcIEEEAC7BCommand
   */
  @PutMapping("/unAssignVrmax")
  public void unAssignVrmax(
      @RequestBody(required = true) UnAssignVrmaxFromExcIEEEAC7BCommand command) {
    try {
      ExcIEEEAC7BBusinessDelegate.getExcIEEEAC7BInstance().unAssignVrmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vrmax", exc);
    }
  }

  /**
   * save Vrmin on ExcIEEEAC7B
   *
   * @param command AssignVrminToExcIEEEAC7BCommand
   */
  @PutMapping("/assignVrmin")
  public void assignVrmin(@RequestBody AssignVrminToExcIEEEAC7BCommand command) {
    try {
      ExcIEEEAC7BBusinessDelegate.getExcIEEEAC7BInstance().assignVrmin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vrmin", exc);
    }
  }

  /**
   * unassign Vrmin on ExcIEEEAC7B
   *
   * @param command UnAssignVrminFromExcIEEEAC7BCommand
   */
  @PutMapping("/unAssignVrmin")
  public void unAssignVrmin(
      @RequestBody(required = true) UnAssignVrminFromExcIEEEAC7BCommand command) {
    try {
      ExcIEEEAC7BBusinessDelegate.getExcIEEEAC7BInstance().unAssignVrmin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vrmin", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected ExcIEEEAC7B excIEEEAC7B = null;
  private static final Logger LOGGER =
      Logger.getLogger(ExcIEEEAC7BCommandRestController.class.getName());
}
