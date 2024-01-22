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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.overexcitationlimiterdynamics.controller.command;

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
 * Implements Spring Controller command CQRS processing for entity OverexcLimX1.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/OverexcLimX1")
public class OverexcLimX1CommandRestController extends BaseSpringRestController {

  /**
   * Handles create a OverexcLimX1. if not key provided, calls create, otherwise calls save
   *
   * @param OverexcLimX1 overexcLimX1
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateOverexcLimX1Command command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          OverexcLimX1BusinessDelegate.getOverexcLimX1Instance().createOverexcLimX1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a OverexcLimX1. if no key provided, calls create, otherwise calls save
   *
   * @param OverexcLimX1 overexcLimX1
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateOverexcLimX1Command command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateOverexcLimX1Command
      // -----------------------------------------------
      completableFuture =
          OverexcLimX1BusinessDelegate.getOverexcLimX1Instance().updateOverexcLimX1(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "OverexcLimX1Controller:update() - successfully update OverexcLimX1 - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a OverexcLimX1 entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID overexcLimX1Id) {
    CompletableFuture<Void> completableFuture = null;
    DeleteOverexcLimX1Command command = new DeleteOverexcLimX1Command(overexcLimX1Id);

    try {
      OverexcLimX1BusinessDelegate delegate =
          OverexcLimX1BusinessDelegate.getOverexcLimX1Instance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted OverexcLimX1 with key " + command.getOverexcLimX1Id());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Efd1 on OverexcLimX1
   *
   * @param command AssignEfd1ToOverexcLimX1Command
   */
  @PutMapping("/assignEfd1")
  public void assignEfd1(@RequestBody AssignEfd1ToOverexcLimX1Command command) {
    try {
      OverexcLimX1BusinessDelegate.getOverexcLimX1Instance().assignEfd1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Efd1", exc);
    }
  }

  /**
   * unassign Efd1 on OverexcLimX1
   *
   * @param command UnAssignEfd1FromOverexcLimX1Command
   */
  @PutMapping("/unAssignEfd1")
  public void unAssignEfd1(
      @RequestBody(required = true) UnAssignEfd1FromOverexcLimX1Command command) {
    try {
      OverexcLimX1BusinessDelegate.getOverexcLimX1Instance().unAssignEfd1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Efd1", exc);
    }
  }

  /**
   * save Efd2 on OverexcLimX1
   *
   * @param command AssignEfd2ToOverexcLimX1Command
   */
  @PutMapping("/assignEfd2")
  public void assignEfd2(@RequestBody AssignEfd2ToOverexcLimX1Command command) {
    try {
      OverexcLimX1BusinessDelegate.getOverexcLimX1Instance().assignEfd2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Efd2", exc);
    }
  }

  /**
   * unassign Efd2 on OverexcLimX1
   *
   * @param command UnAssignEfd2FromOverexcLimX1Command
   */
  @PutMapping("/unAssignEfd2")
  public void unAssignEfd2(
      @RequestBody(required = true) UnAssignEfd2FromOverexcLimX1Command command) {
    try {
      OverexcLimX1BusinessDelegate.getOverexcLimX1Instance().unAssignEfd2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Efd2", exc);
    }
  }

  /**
   * save Efd3 on OverexcLimX1
   *
   * @param command AssignEfd3ToOverexcLimX1Command
   */
  @PutMapping("/assignEfd3")
  public void assignEfd3(@RequestBody AssignEfd3ToOverexcLimX1Command command) {
    try {
      OverexcLimX1BusinessDelegate.getOverexcLimX1Instance().assignEfd3(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Efd3", exc);
    }
  }

  /**
   * unassign Efd3 on OverexcLimX1
   *
   * @param command UnAssignEfd3FromOverexcLimX1Command
   */
  @PutMapping("/unAssignEfd3")
  public void unAssignEfd3(
      @RequestBody(required = true) UnAssignEfd3FromOverexcLimX1Command command) {
    try {
      OverexcLimX1BusinessDelegate.getOverexcLimX1Instance().unAssignEfd3(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Efd3", exc);
    }
  }

  /**
   * save Efddes on OverexcLimX1
   *
   * @param command AssignEfddesToOverexcLimX1Command
   */
  @PutMapping("/assignEfddes")
  public void assignEfddes(@RequestBody AssignEfddesToOverexcLimX1Command command) {
    try {
      OverexcLimX1BusinessDelegate.getOverexcLimX1Instance().assignEfddes(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Efddes", exc);
    }
  }

  /**
   * unassign Efddes on OverexcLimX1
   *
   * @param command UnAssignEfddesFromOverexcLimX1Command
   */
  @PutMapping("/unAssignEfddes")
  public void unAssignEfddes(
      @RequestBody(required = true) UnAssignEfddesFromOverexcLimX1Command command) {
    try {
      OverexcLimX1BusinessDelegate.getOverexcLimX1Instance().unAssignEfddes(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Efddes", exc);
    }
  }

  /**
   * save Efdrated on OverexcLimX1
   *
   * @param command AssignEfdratedToOverexcLimX1Command
   */
  @PutMapping("/assignEfdrated")
  public void assignEfdrated(@RequestBody AssignEfdratedToOverexcLimX1Command command) {
    try {
      OverexcLimX1BusinessDelegate.getOverexcLimX1Instance().assignEfdrated(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Efdrated", exc);
    }
  }

  /**
   * unassign Efdrated on OverexcLimX1
   *
   * @param command UnAssignEfdratedFromOverexcLimX1Command
   */
  @PutMapping("/unAssignEfdrated")
  public void unAssignEfdrated(
      @RequestBody(required = true) UnAssignEfdratedFromOverexcLimX1Command command) {
    try {
      OverexcLimX1BusinessDelegate.getOverexcLimX1Instance().unAssignEfdrated(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Efdrated", exc);
    }
  }

  /**
   * save Kmx on OverexcLimX1
   *
   * @param command AssignKmxToOverexcLimX1Command
   */
  @PutMapping("/assignKmx")
  public void assignKmx(@RequestBody AssignKmxToOverexcLimX1Command command) {
    try {
      OverexcLimX1BusinessDelegate.getOverexcLimX1Instance().assignKmx(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kmx", exc);
    }
  }

  /**
   * unassign Kmx on OverexcLimX1
   *
   * @param command UnAssignKmxFromOverexcLimX1Command
   */
  @PutMapping("/unAssignKmx")
  public void unAssignKmx(
      @RequestBody(required = true) UnAssignKmxFromOverexcLimX1Command command) {
    try {
      OverexcLimX1BusinessDelegate.getOverexcLimX1Instance().unAssignKmx(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kmx", exc);
    }
  }

  /**
   * save T1 on OverexcLimX1
   *
   * @param command AssignT1ToOverexcLimX1Command
   */
  @PutMapping("/assignT1")
  public void assignT1(@RequestBody AssignT1ToOverexcLimX1Command command) {
    try {
      OverexcLimX1BusinessDelegate.getOverexcLimX1Instance().assignT1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T1", exc);
    }
  }

  /**
   * unassign T1 on OverexcLimX1
   *
   * @param command UnAssignT1FromOverexcLimX1Command
   */
  @PutMapping("/unAssignT1")
  public void unAssignT1(@RequestBody(required = true) UnAssignT1FromOverexcLimX1Command command) {
    try {
      OverexcLimX1BusinessDelegate.getOverexcLimX1Instance().unAssignT1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T1", exc);
    }
  }

  /**
   * save T2 on OverexcLimX1
   *
   * @param command AssignT2ToOverexcLimX1Command
   */
  @PutMapping("/assignT2")
  public void assignT2(@RequestBody AssignT2ToOverexcLimX1Command command) {
    try {
      OverexcLimX1BusinessDelegate.getOverexcLimX1Instance().assignT2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T2", exc);
    }
  }

  /**
   * unassign T2 on OverexcLimX1
   *
   * @param command UnAssignT2FromOverexcLimX1Command
   */
  @PutMapping("/unAssignT2")
  public void unAssignT2(@RequestBody(required = true) UnAssignT2FromOverexcLimX1Command command) {
    try {
      OverexcLimX1BusinessDelegate.getOverexcLimX1Instance().unAssignT2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T2", exc);
    }
  }

  /**
   * save T3 on OverexcLimX1
   *
   * @param command AssignT3ToOverexcLimX1Command
   */
  @PutMapping("/assignT3")
  public void assignT3(@RequestBody AssignT3ToOverexcLimX1Command command) {
    try {
      OverexcLimX1BusinessDelegate.getOverexcLimX1Instance().assignT3(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T3", exc);
    }
  }

  /**
   * unassign T3 on OverexcLimX1
   *
   * @param command UnAssignT3FromOverexcLimX1Command
   */
  @PutMapping("/unAssignT3")
  public void unAssignT3(@RequestBody(required = true) UnAssignT3FromOverexcLimX1Command command) {
    try {
      OverexcLimX1BusinessDelegate.getOverexcLimX1Instance().unAssignT3(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T3", exc);
    }
  }

  /**
   * save Vlow on OverexcLimX1
   *
   * @param command AssignVlowToOverexcLimX1Command
   */
  @PutMapping("/assignVlow")
  public void assignVlow(@RequestBody AssignVlowToOverexcLimX1Command command) {
    try {
      OverexcLimX1BusinessDelegate.getOverexcLimX1Instance().assignVlow(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vlow", exc);
    }
  }

  /**
   * unassign Vlow on OverexcLimX1
   *
   * @param command UnAssignVlowFromOverexcLimX1Command
   */
  @PutMapping("/unAssignVlow")
  public void unAssignVlow(
      @RequestBody(required = true) UnAssignVlowFromOverexcLimX1Command command) {
    try {
      OverexcLimX1BusinessDelegate.getOverexcLimX1Instance().unAssignVlow(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vlow", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected OverexcLimX1 overexcLimX1 = null;
  private static final Logger LOGGER =
      Logger.getLogger(OverexcLimX1CommandRestController.class.getName());
}
