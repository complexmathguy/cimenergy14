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
 * Implements Spring Controller command CQRS processing for entity OverexcLimX2.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/OverexcLimX2")
public class OverexcLimX2CommandRestController extends BaseSpringRestController {

  /**
   * Handles create a OverexcLimX2. if not key provided, calls create, otherwise calls save
   *
   * @param OverexcLimX2 overexcLimX2
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateOverexcLimX2Command command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          OverexcLimX2BusinessDelegate.getOverexcLimX2Instance().createOverexcLimX2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a OverexcLimX2. if no key provided, calls create, otherwise calls save
   *
   * @param OverexcLimX2 overexcLimX2
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateOverexcLimX2Command command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateOverexcLimX2Command
      // -----------------------------------------------
      completableFuture =
          OverexcLimX2BusinessDelegate.getOverexcLimX2Instance().updateOverexcLimX2(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "OverexcLimX2Controller:update() - successfully update OverexcLimX2 - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a OverexcLimX2 entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID overexcLimX2Id) {
    CompletableFuture<Void> completableFuture = null;
    DeleteOverexcLimX2Command command = new DeleteOverexcLimX2Command(overexcLimX2Id);

    try {
      OverexcLimX2BusinessDelegate delegate =
          OverexcLimX2BusinessDelegate.getOverexcLimX2Instance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted OverexcLimX2 with key " + command.getOverexcLimX2Id());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Efd1 on OverexcLimX2
   *
   * @param command AssignEfd1ToOverexcLimX2Command
   */
  @PutMapping("/assignEfd1")
  public void assignEfd1(@RequestBody AssignEfd1ToOverexcLimX2Command command) {
    try {
      OverexcLimX2BusinessDelegate.getOverexcLimX2Instance().assignEfd1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Efd1", exc);
    }
  }

  /**
   * unassign Efd1 on OverexcLimX2
   *
   * @param command UnAssignEfd1FromOverexcLimX2Command
   */
  @PutMapping("/unAssignEfd1")
  public void unAssignEfd1(
      @RequestBody(required = true) UnAssignEfd1FromOverexcLimX2Command command) {
    try {
      OverexcLimX2BusinessDelegate.getOverexcLimX2Instance().unAssignEfd1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Efd1", exc);
    }
  }

  /**
   * save Efd2 on OverexcLimX2
   *
   * @param command AssignEfd2ToOverexcLimX2Command
   */
  @PutMapping("/assignEfd2")
  public void assignEfd2(@RequestBody AssignEfd2ToOverexcLimX2Command command) {
    try {
      OverexcLimX2BusinessDelegate.getOverexcLimX2Instance().assignEfd2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Efd2", exc);
    }
  }

  /**
   * unassign Efd2 on OverexcLimX2
   *
   * @param command UnAssignEfd2FromOverexcLimX2Command
   */
  @PutMapping("/unAssignEfd2")
  public void unAssignEfd2(
      @RequestBody(required = true) UnAssignEfd2FromOverexcLimX2Command command) {
    try {
      OverexcLimX2BusinessDelegate.getOverexcLimX2Instance().unAssignEfd2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Efd2", exc);
    }
  }

  /**
   * save Efd3 on OverexcLimX2
   *
   * @param command AssignEfd3ToOverexcLimX2Command
   */
  @PutMapping("/assignEfd3")
  public void assignEfd3(@RequestBody AssignEfd3ToOverexcLimX2Command command) {
    try {
      OverexcLimX2BusinessDelegate.getOverexcLimX2Instance().assignEfd3(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Efd3", exc);
    }
  }

  /**
   * unassign Efd3 on OverexcLimX2
   *
   * @param command UnAssignEfd3FromOverexcLimX2Command
   */
  @PutMapping("/unAssignEfd3")
  public void unAssignEfd3(
      @RequestBody(required = true) UnAssignEfd3FromOverexcLimX2Command command) {
    try {
      OverexcLimX2BusinessDelegate.getOverexcLimX2Instance().unAssignEfd3(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Efd3", exc);
    }
  }

  /**
   * save Efddes on OverexcLimX2
   *
   * @param command AssignEfddesToOverexcLimX2Command
   */
  @PutMapping("/assignEfddes")
  public void assignEfddes(@RequestBody AssignEfddesToOverexcLimX2Command command) {
    try {
      OverexcLimX2BusinessDelegate.getOverexcLimX2Instance().assignEfddes(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Efddes", exc);
    }
  }

  /**
   * unassign Efddes on OverexcLimX2
   *
   * @param command UnAssignEfddesFromOverexcLimX2Command
   */
  @PutMapping("/unAssignEfddes")
  public void unAssignEfddes(
      @RequestBody(required = true) UnAssignEfddesFromOverexcLimX2Command command) {
    try {
      OverexcLimX2BusinessDelegate.getOverexcLimX2Instance().unAssignEfddes(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Efddes", exc);
    }
  }

  /**
   * save Efdrated on OverexcLimX2
   *
   * @param command AssignEfdratedToOverexcLimX2Command
   */
  @PutMapping("/assignEfdrated")
  public void assignEfdrated(@RequestBody AssignEfdratedToOverexcLimX2Command command) {
    try {
      OverexcLimX2BusinessDelegate.getOverexcLimX2Instance().assignEfdrated(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Efdrated", exc);
    }
  }

  /**
   * unassign Efdrated on OverexcLimX2
   *
   * @param command UnAssignEfdratedFromOverexcLimX2Command
   */
  @PutMapping("/unAssignEfdrated")
  public void unAssignEfdrated(
      @RequestBody(required = true) UnAssignEfdratedFromOverexcLimX2Command command) {
    try {
      OverexcLimX2BusinessDelegate.getOverexcLimX2Instance().unAssignEfdrated(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Efdrated", exc);
    }
  }

  /**
   * save Kmx on OverexcLimX2
   *
   * @param command AssignKmxToOverexcLimX2Command
   */
  @PutMapping("/assignKmx")
  public void assignKmx(@RequestBody AssignKmxToOverexcLimX2Command command) {
    try {
      OverexcLimX2BusinessDelegate.getOverexcLimX2Instance().assignKmx(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kmx", exc);
    }
  }

  /**
   * unassign Kmx on OverexcLimX2
   *
   * @param command UnAssignKmxFromOverexcLimX2Command
   */
  @PutMapping("/unAssignKmx")
  public void unAssignKmx(
      @RequestBody(required = true) UnAssignKmxFromOverexcLimX2Command command) {
    try {
      OverexcLimX2BusinessDelegate.getOverexcLimX2Instance().unAssignKmx(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kmx", exc);
    }
  }

  /**
   * save M on OverexcLimX2
   *
   * @param command AssignMToOverexcLimX2Command
   */
  @PutMapping("/assignM")
  public void assignM(@RequestBody AssignMToOverexcLimX2Command command) {
    try {
      OverexcLimX2BusinessDelegate.getOverexcLimX2Instance().assignM(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign M", exc);
    }
  }

  /**
   * unassign M on OverexcLimX2
   *
   * @param command UnAssignMFromOverexcLimX2Command
   */
  @PutMapping("/unAssignM")
  public void unAssignM(@RequestBody(required = true) UnAssignMFromOverexcLimX2Command command) {
    try {
      OverexcLimX2BusinessDelegate.getOverexcLimX2Instance().unAssignM(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign M", exc);
    }
  }

  /**
   * save T1 on OverexcLimX2
   *
   * @param command AssignT1ToOverexcLimX2Command
   */
  @PutMapping("/assignT1")
  public void assignT1(@RequestBody AssignT1ToOverexcLimX2Command command) {
    try {
      OverexcLimX2BusinessDelegate.getOverexcLimX2Instance().assignT1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T1", exc);
    }
  }

  /**
   * unassign T1 on OverexcLimX2
   *
   * @param command UnAssignT1FromOverexcLimX2Command
   */
  @PutMapping("/unAssignT1")
  public void unAssignT1(@RequestBody(required = true) UnAssignT1FromOverexcLimX2Command command) {
    try {
      OverexcLimX2BusinessDelegate.getOverexcLimX2Instance().unAssignT1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T1", exc);
    }
  }

  /**
   * save T2 on OverexcLimX2
   *
   * @param command AssignT2ToOverexcLimX2Command
   */
  @PutMapping("/assignT2")
  public void assignT2(@RequestBody AssignT2ToOverexcLimX2Command command) {
    try {
      OverexcLimX2BusinessDelegate.getOverexcLimX2Instance().assignT2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T2", exc);
    }
  }

  /**
   * unassign T2 on OverexcLimX2
   *
   * @param command UnAssignT2FromOverexcLimX2Command
   */
  @PutMapping("/unAssignT2")
  public void unAssignT2(@RequestBody(required = true) UnAssignT2FromOverexcLimX2Command command) {
    try {
      OverexcLimX2BusinessDelegate.getOverexcLimX2Instance().unAssignT2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T2", exc);
    }
  }

  /**
   * save T3 on OverexcLimX2
   *
   * @param command AssignT3ToOverexcLimX2Command
   */
  @PutMapping("/assignT3")
  public void assignT3(@RequestBody AssignT3ToOverexcLimX2Command command) {
    try {
      OverexcLimX2BusinessDelegate.getOverexcLimX2Instance().assignT3(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T3", exc);
    }
  }

  /**
   * unassign T3 on OverexcLimX2
   *
   * @param command UnAssignT3FromOverexcLimX2Command
   */
  @PutMapping("/unAssignT3")
  public void unAssignT3(@RequestBody(required = true) UnAssignT3FromOverexcLimX2Command command) {
    try {
      OverexcLimX2BusinessDelegate.getOverexcLimX2Instance().unAssignT3(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T3", exc);
    }
  }

  /**
   * save Vlow on OverexcLimX2
   *
   * @param command AssignVlowToOverexcLimX2Command
   */
  @PutMapping("/assignVlow")
  public void assignVlow(@RequestBody AssignVlowToOverexcLimX2Command command) {
    try {
      OverexcLimX2BusinessDelegate.getOverexcLimX2Instance().assignVlow(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vlow", exc);
    }
  }

  /**
   * unassign Vlow on OverexcLimX2
   *
   * @param command UnAssignVlowFromOverexcLimX2Command
   */
  @PutMapping("/unAssignVlow")
  public void unAssignVlow(
      @RequestBody(required = true) UnAssignVlowFromOverexcLimX2Command command) {
    try {
      OverexcLimX2BusinessDelegate.getOverexcLimX2Instance().unAssignVlow(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vlow", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected OverexcLimX2 overexcLimX2 = null;
  private static final Logger LOGGER =
      Logger.getLogger(OverexcLimX2CommandRestController.class.getName());
}
