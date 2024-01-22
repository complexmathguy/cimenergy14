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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.loaddynamics.controller.command;

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
 * Implements Spring Controller command CQRS processing for entity LoadStatic.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/LoadStatic")
public class LoadStaticCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a LoadStatic. if not key provided, calls create, otherwise calls save
   *
   * @param LoadStatic loadStatic
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateLoadStaticCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          LoadStaticBusinessDelegate.getLoadStaticInstance().createLoadStatic(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a LoadStatic. if no key provided, calls create, otherwise calls save
   *
   * @param LoadStatic loadStatic
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateLoadStaticCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateLoadStaticCommand
      // -----------------------------------------------
      completableFuture =
          LoadStaticBusinessDelegate.getLoadStaticInstance().updateLoadStatic(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "LoadStaticController:update() - successfully update LoadStatic - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a LoadStatic entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID loadStaticId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteLoadStaticCommand command = new DeleteLoadStaticCommand(loadStaticId);

    try {
      LoadStaticBusinessDelegate delegate = LoadStaticBusinessDelegate.getLoadStaticInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING, "Successfully deleted LoadStatic with key " + command.getLoadStaticId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Ep1 on LoadStatic
   *
   * @param command AssignEp1ToLoadStaticCommand
   */
  @PutMapping("/assignEp1")
  public void assignEp1(@RequestBody AssignEp1ToLoadStaticCommand command) {
    try {
      LoadStaticBusinessDelegate.getLoadStaticInstance().assignEp1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ep1", exc);
    }
  }

  /**
   * unassign Ep1 on LoadStatic
   *
   * @param command UnAssignEp1FromLoadStaticCommand
   */
  @PutMapping("/unAssignEp1")
  public void unAssignEp1(@RequestBody(required = true) UnAssignEp1FromLoadStaticCommand command) {
    try {
      LoadStaticBusinessDelegate.getLoadStaticInstance().unAssignEp1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ep1", exc);
    }
  }

  /**
   * save Ep2 on LoadStatic
   *
   * @param command AssignEp2ToLoadStaticCommand
   */
  @PutMapping("/assignEp2")
  public void assignEp2(@RequestBody AssignEp2ToLoadStaticCommand command) {
    try {
      LoadStaticBusinessDelegate.getLoadStaticInstance().assignEp2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ep2", exc);
    }
  }

  /**
   * unassign Ep2 on LoadStatic
   *
   * @param command UnAssignEp2FromLoadStaticCommand
   */
  @PutMapping("/unAssignEp2")
  public void unAssignEp2(@RequestBody(required = true) UnAssignEp2FromLoadStaticCommand command) {
    try {
      LoadStaticBusinessDelegate.getLoadStaticInstance().unAssignEp2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ep2", exc);
    }
  }

  /**
   * save Ep3 on LoadStatic
   *
   * @param command AssignEp3ToLoadStaticCommand
   */
  @PutMapping("/assignEp3")
  public void assignEp3(@RequestBody AssignEp3ToLoadStaticCommand command) {
    try {
      LoadStaticBusinessDelegate.getLoadStaticInstance().assignEp3(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ep3", exc);
    }
  }

  /**
   * unassign Ep3 on LoadStatic
   *
   * @param command UnAssignEp3FromLoadStaticCommand
   */
  @PutMapping("/unAssignEp3")
  public void unAssignEp3(@RequestBody(required = true) UnAssignEp3FromLoadStaticCommand command) {
    try {
      LoadStaticBusinessDelegate.getLoadStaticInstance().unAssignEp3(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ep3", exc);
    }
  }

  /**
   * save Eq1 on LoadStatic
   *
   * @param command AssignEq1ToLoadStaticCommand
   */
  @PutMapping("/assignEq1")
  public void assignEq1(@RequestBody AssignEq1ToLoadStaticCommand command) {
    try {
      LoadStaticBusinessDelegate.getLoadStaticInstance().assignEq1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Eq1", exc);
    }
  }

  /**
   * unassign Eq1 on LoadStatic
   *
   * @param command UnAssignEq1FromLoadStaticCommand
   */
  @PutMapping("/unAssignEq1")
  public void unAssignEq1(@RequestBody(required = true) UnAssignEq1FromLoadStaticCommand command) {
    try {
      LoadStaticBusinessDelegate.getLoadStaticInstance().unAssignEq1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Eq1", exc);
    }
  }

  /**
   * save Eq2 on LoadStatic
   *
   * @param command AssignEq2ToLoadStaticCommand
   */
  @PutMapping("/assignEq2")
  public void assignEq2(@RequestBody AssignEq2ToLoadStaticCommand command) {
    try {
      LoadStaticBusinessDelegate.getLoadStaticInstance().assignEq2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Eq2", exc);
    }
  }

  /**
   * unassign Eq2 on LoadStatic
   *
   * @param command UnAssignEq2FromLoadStaticCommand
   */
  @PutMapping("/unAssignEq2")
  public void unAssignEq2(@RequestBody(required = true) UnAssignEq2FromLoadStaticCommand command) {
    try {
      LoadStaticBusinessDelegate.getLoadStaticInstance().unAssignEq2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Eq2", exc);
    }
  }

  /**
   * save Eq3 on LoadStatic
   *
   * @param command AssignEq3ToLoadStaticCommand
   */
  @PutMapping("/assignEq3")
  public void assignEq3(@RequestBody AssignEq3ToLoadStaticCommand command) {
    try {
      LoadStaticBusinessDelegate.getLoadStaticInstance().assignEq3(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Eq3", exc);
    }
  }

  /**
   * unassign Eq3 on LoadStatic
   *
   * @param command UnAssignEq3FromLoadStaticCommand
   */
  @PutMapping("/unAssignEq3")
  public void unAssignEq3(@RequestBody(required = true) UnAssignEq3FromLoadStaticCommand command) {
    try {
      LoadStaticBusinessDelegate.getLoadStaticInstance().unAssignEq3(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Eq3", exc);
    }
  }

  /**
   * save Kp1 on LoadStatic
   *
   * @param command AssignKp1ToLoadStaticCommand
   */
  @PutMapping("/assignKp1")
  public void assignKp1(@RequestBody AssignKp1ToLoadStaticCommand command) {
    try {
      LoadStaticBusinessDelegate.getLoadStaticInstance().assignKp1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kp1", exc);
    }
  }

  /**
   * unassign Kp1 on LoadStatic
   *
   * @param command UnAssignKp1FromLoadStaticCommand
   */
  @PutMapping("/unAssignKp1")
  public void unAssignKp1(@RequestBody(required = true) UnAssignKp1FromLoadStaticCommand command) {
    try {
      LoadStaticBusinessDelegate.getLoadStaticInstance().unAssignKp1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kp1", exc);
    }
  }

  /**
   * save Kp2 on LoadStatic
   *
   * @param command AssignKp2ToLoadStaticCommand
   */
  @PutMapping("/assignKp2")
  public void assignKp2(@RequestBody AssignKp2ToLoadStaticCommand command) {
    try {
      LoadStaticBusinessDelegate.getLoadStaticInstance().assignKp2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kp2", exc);
    }
  }

  /**
   * unassign Kp2 on LoadStatic
   *
   * @param command UnAssignKp2FromLoadStaticCommand
   */
  @PutMapping("/unAssignKp2")
  public void unAssignKp2(@RequestBody(required = true) UnAssignKp2FromLoadStaticCommand command) {
    try {
      LoadStaticBusinessDelegate.getLoadStaticInstance().unAssignKp2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kp2", exc);
    }
  }

  /**
   * save Kp3 on LoadStatic
   *
   * @param command AssignKp3ToLoadStaticCommand
   */
  @PutMapping("/assignKp3")
  public void assignKp3(@RequestBody AssignKp3ToLoadStaticCommand command) {
    try {
      LoadStaticBusinessDelegate.getLoadStaticInstance().assignKp3(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kp3", exc);
    }
  }

  /**
   * unassign Kp3 on LoadStatic
   *
   * @param command UnAssignKp3FromLoadStaticCommand
   */
  @PutMapping("/unAssignKp3")
  public void unAssignKp3(@RequestBody(required = true) UnAssignKp3FromLoadStaticCommand command) {
    try {
      LoadStaticBusinessDelegate.getLoadStaticInstance().unAssignKp3(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kp3", exc);
    }
  }

  /**
   * save Kp4 on LoadStatic
   *
   * @param command AssignKp4ToLoadStaticCommand
   */
  @PutMapping("/assignKp4")
  public void assignKp4(@RequestBody AssignKp4ToLoadStaticCommand command) {
    try {
      LoadStaticBusinessDelegate.getLoadStaticInstance().assignKp4(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kp4", exc);
    }
  }

  /**
   * unassign Kp4 on LoadStatic
   *
   * @param command UnAssignKp4FromLoadStaticCommand
   */
  @PutMapping("/unAssignKp4")
  public void unAssignKp4(@RequestBody(required = true) UnAssignKp4FromLoadStaticCommand command) {
    try {
      LoadStaticBusinessDelegate.getLoadStaticInstance().unAssignKp4(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kp4", exc);
    }
  }

  /**
   * save Kpf on LoadStatic
   *
   * @param command AssignKpfToLoadStaticCommand
   */
  @PutMapping("/assignKpf")
  public void assignKpf(@RequestBody AssignKpfToLoadStaticCommand command) {
    try {
      LoadStaticBusinessDelegate.getLoadStaticInstance().assignKpf(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kpf", exc);
    }
  }

  /**
   * unassign Kpf on LoadStatic
   *
   * @param command UnAssignKpfFromLoadStaticCommand
   */
  @PutMapping("/unAssignKpf")
  public void unAssignKpf(@RequestBody(required = true) UnAssignKpfFromLoadStaticCommand command) {
    try {
      LoadStaticBusinessDelegate.getLoadStaticInstance().unAssignKpf(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kpf", exc);
    }
  }

  /**
   * save Kq1 on LoadStatic
   *
   * @param command AssignKq1ToLoadStaticCommand
   */
  @PutMapping("/assignKq1")
  public void assignKq1(@RequestBody AssignKq1ToLoadStaticCommand command) {
    try {
      LoadStaticBusinessDelegate.getLoadStaticInstance().assignKq1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kq1", exc);
    }
  }

  /**
   * unassign Kq1 on LoadStatic
   *
   * @param command UnAssignKq1FromLoadStaticCommand
   */
  @PutMapping("/unAssignKq1")
  public void unAssignKq1(@RequestBody(required = true) UnAssignKq1FromLoadStaticCommand command) {
    try {
      LoadStaticBusinessDelegate.getLoadStaticInstance().unAssignKq1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kq1", exc);
    }
  }

  /**
   * save Kq2 on LoadStatic
   *
   * @param command AssignKq2ToLoadStaticCommand
   */
  @PutMapping("/assignKq2")
  public void assignKq2(@RequestBody AssignKq2ToLoadStaticCommand command) {
    try {
      LoadStaticBusinessDelegate.getLoadStaticInstance().assignKq2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kq2", exc);
    }
  }

  /**
   * unassign Kq2 on LoadStatic
   *
   * @param command UnAssignKq2FromLoadStaticCommand
   */
  @PutMapping("/unAssignKq2")
  public void unAssignKq2(@RequestBody(required = true) UnAssignKq2FromLoadStaticCommand command) {
    try {
      LoadStaticBusinessDelegate.getLoadStaticInstance().unAssignKq2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kq2", exc);
    }
  }

  /**
   * save Kq3 on LoadStatic
   *
   * @param command AssignKq3ToLoadStaticCommand
   */
  @PutMapping("/assignKq3")
  public void assignKq3(@RequestBody AssignKq3ToLoadStaticCommand command) {
    try {
      LoadStaticBusinessDelegate.getLoadStaticInstance().assignKq3(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kq3", exc);
    }
  }

  /**
   * unassign Kq3 on LoadStatic
   *
   * @param command UnAssignKq3FromLoadStaticCommand
   */
  @PutMapping("/unAssignKq3")
  public void unAssignKq3(@RequestBody(required = true) UnAssignKq3FromLoadStaticCommand command) {
    try {
      LoadStaticBusinessDelegate.getLoadStaticInstance().unAssignKq3(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kq3", exc);
    }
  }

  /**
   * save Kq4 on LoadStatic
   *
   * @param command AssignKq4ToLoadStaticCommand
   */
  @PutMapping("/assignKq4")
  public void assignKq4(@RequestBody AssignKq4ToLoadStaticCommand command) {
    try {
      LoadStaticBusinessDelegate.getLoadStaticInstance().assignKq4(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kq4", exc);
    }
  }

  /**
   * unassign Kq4 on LoadStatic
   *
   * @param command UnAssignKq4FromLoadStaticCommand
   */
  @PutMapping("/unAssignKq4")
  public void unAssignKq4(@RequestBody(required = true) UnAssignKq4FromLoadStaticCommand command) {
    try {
      LoadStaticBusinessDelegate.getLoadStaticInstance().unAssignKq4(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kq4", exc);
    }
  }

  /**
   * save Kqf on LoadStatic
   *
   * @param command AssignKqfToLoadStaticCommand
   */
  @PutMapping("/assignKqf")
  public void assignKqf(@RequestBody AssignKqfToLoadStaticCommand command) {
    try {
      LoadStaticBusinessDelegate.getLoadStaticInstance().assignKqf(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kqf", exc);
    }
  }

  /**
   * unassign Kqf on LoadStatic
   *
   * @param command UnAssignKqfFromLoadStaticCommand
   */
  @PutMapping("/unAssignKqf")
  public void unAssignKqf(@RequestBody(required = true) UnAssignKqfFromLoadStaticCommand command) {
    try {
      LoadStaticBusinessDelegate.getLoadStaticInstance().unAssignKqf(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kqf", exc);
    }
  }

  /**
   * save LoadStatic on LoadStatic
   *
   * @param command AssignLoadStaticToLoadStaticCommand
   */
  @PutMapping("/assignLoadStatic")
  public void assignLoadStatic(@RequestBody AssignLoadStaticToLoadStaticCommand command) {
    try {
      LoadStaticBusinessDelegate.getLoadStaticInstance().assignLoadStatic(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign LoadStatic", exc);
    }
  }

  /**
   * unassign LoadStatic on LoadStatic
   *
   * @param command UnAssignLoadStaticFromLoadStaticCommand
   */
  @PutMapping("/unAssignLoadStatic")
  public void unAssignLoadStatic(
      @RequestBody(required = true) UnAssignLoadStaticFromLoadStaticCommand command) {
    try {
      LoadStaticBusinessDelegate.getLoadStaticInstance().unAssignLoadStatic(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign LoadStatic", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected LoadStatic loadStatic = null;
  private static final Logger LOGGER =
      Logger.getLogger(LoadStaticCommandRestController.class.getName());
}
