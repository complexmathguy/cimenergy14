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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.powersystemstabilizerdynamics.controller.command;

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
 * Implements Spring Controller command CQRS processing for entity PssELIN2.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/PssELIN2")
public class PssELIN2CommandRestController extends BaseSpringRestController {

  /**
   * Handles create a PssELIN2. if not key provided, calls create, otherwise calls save
   *
   * @param PssELIN2 pssELIN2
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreatePssELIN2Command command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture = PssELIN2BusinessDelegate.getPssELIN2Instance().createPssELIN2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a PssELIN2. if no key provided, calls create, otherwise calls save
   *
   * @param PssELIN2 pssELIN2
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdatePssELIN2Command command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdatePssELIN2Command
      // -----------------------------------------------
      completableFuture = PssELIN2BusinessDelegate.getPssELIN2Instance().updatePssELIN2(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "PssELIN2Controller:update() - successfully update PssELIN2 - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a PssELIN2 entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID pssELIN2Id) {
    CompletableFuture<Void> completableFuture = null;
    DeletePssELIN2Command command = new DeletePssELIN2Command(pssELIN2Id);

    try {
      PssELIN2BusinessDelegate delegate = PssELIN2BusinessDelegate.getPssELIN2Instance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING, "Successfully deleted PssELIN2 with key " + command.getPssELIN2Id());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Apss on PssELIN2
   *
   * @param command AssignApssToPssELIN2Command
   */
  @PutMapping("/assignApss")
  public void assignApss(@RequestBody AssignApssToPssELIN2Command command) {
    try {
      PssELIN2BusinessDelegate.getPssELIN2Instance().assignApss(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Apss", exc);
    }
  }

  /**
   * unassign Apss on PssELIN2
   *
   * @param command UnAssignApssFromPssELIN2Command
   */
  @PutMapping("/unAssignApss")
  public void unAssignApss(@RequestBody(required = true) UnAssignApssFromPssELIN2Command command) {
    try {
      PssELIN2BusinessDelegate.getPssELIN2Instance().unAssignApss(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Apss", exc);
    }
  }

  /**
   * save Ks1 on PssELIN2
   *
   * @param command AssignKs1ToPssELIN2Command
   */
  @PutMapping("/assignKs1")
  public void assignKs1(@RequestBody AssignKs1ToPssELIN2Command command) {
    try {
      PssELIN2BusinessDelegate.getPssELIN2Instance().assignKs1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ks1", exc);
    }
  }

  /**
   * unassign Ks1 on PssELIN2
   *
   * @param command UnAssignKs1FromPssELIN2Command
   */
  @PutMapping("/unAssignKs1")
  public void unAssignKs1(@RequestBody(required = true) UnAssignKs1FromPssELIN2Command command) {
    try {
      PssELIN2BusinessDelegate.getPssELIN2Instance().unAssignKs1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ks1", exc);
    }
  }

  /**
   * save Ks2 on PssELIN2
   *
   * @param command AssignKs2ToPssELIN2Command
   */
  @PutMapping("/assignKs2")
  public void assignKs2(@RequestBody AssignKs2ToPssELIN2Command command) {
    try {
      PssELIN2BusinessDelegate.getPssELIN2Instance().assignKs2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ks2", exc);
    }
  }

  /**
   * unassign Ks2 on PssELIN2
   *
   * @param command UnAssignKs2FromPssELIN2Command
   */
  @PutMapping("/unAssignKs2")
  public void unAssignKs2(@RequestBody(required = true) UnAssignKs2FromPssELIN2Command command) {
    try {
      PssELIN2BusinessDelegate.getPssELIN2Instance().unAssignKs2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ks2", exc);
    }
  }

  /**
   * save Ppss on PssELIN2
   *
   * @param command AssignPpssToPssELIN2Command
   */
  @PutMapping("/assignPpss")
  public void assignPpss(@RequestBody AssignPpssToPssELIN2Command command) {
    try {
      PssELIN2BusinessDelegate.getPssELIN2Instance().assignPpss(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ppss", exc);
    }
  }

  /**
   * unassign Ppss on PssELIN2
   *
   * @param command UnAssignPpssFromPssELIN2Command
   */
  @PutMapping("/unAssignPpss")
  public void unAssignPpss(@RequestBody(required = true) UnAssignPpssFromPssELIN2Command command) {
    try {
      PssELIN2BusinessDelegate.getPssELIN2Instance().unAssignPpss(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ppss", exc);
    }
  }

  /**
   * save Psslim on PssELIN2
   *
   * @param command AssignPsslimToPssELIN2Command
   */
  @PutMapping("/assignPsslim")
  public void assignPsslim(@RequestBody AssignPsslimToPssELIN2Command command) {
    try {
      PssELIN2BusinessDelegate.getPssELIN2Instance().assignPsslim(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Psslim", exc);
    }
  }

  /**
   * unassign Psslim on PssELIN2
   *
   * @param command UnAssignPsslimFromPssELIN2Command
   */
  @PutMapping("/unAssignPsslim")
  public void unAssignPsslim(
      @RequestBody(required = true) UnAssignPsslimFromPssELIN2Command command) {
    try {
      PssELIN2BusinessDelegate.getPssELIN2Instance().unAssignPsslim(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Psslim", exc);
    }
  }

  /**
   * save Ts1 on PssELIN2
   *
   * @param command AssignTs1ToPssELIN2Command
   */
  @PutMapping("/assignTs1")
  public void assignTs1(@RequestBody AssignTs1ToPssELIN2Command command) {
    try {
      PssELIN2BusinessDelegate.getPssELIN2Instance().assignTs1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ts1", exc);
    }
  }

  /**
   * unassign Ts1 on PssELIN2
   *
   * @param command UnAssignTs1FromPssELIN2Command
   */
  @PutMapping("/unAssignTs1")
  public void unAssignTs1(@RequestBody(required = true) UnAssignTs1FromPssELIN2Command command) {
    try {
      PssELIN2BusinessDelegate.getPssELIN2Instance().unAssignTs1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ts1", exc);
    }
  }

  /**
   * save Ts2 on PssELIN2
   *
   * @param command AssignTs2ToPssELIN2Command
   */
  @PutMapping("/assignTs2")
  public void assignTs2(@RequestBody AssignTs2ToPssELIN2Command command) {
    try {
      PssELIN2BusinessDelegate.getPssELIN2Instance().assignTs2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ts2", exc);
    }
  }

  /**
   * unassign Ts2 on PssELIN2
   *
   * @param command UnAssignTs2FromPssELIN2Command
   */
  @PutMapping("/unAssignTs2")
  public void unAssignTs2(@RequestBody(required = true) UnAssignTs2FromPssELIN2Command command) {
    try {
      PssELIN2BusinessDelegate.getPssELIN2Instance().unAssignTs2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ts2", exc);
    }
  }

  /**
   * save Ts3 on PssELIN2
   *
   * @param command AssignTs3ToPssELIN2Command
   */
  @PutMapping("/assignTs3")
  public void assignTs3(@RequestBody AssignTs3ToPssELIN2Command command) {
    try {
      PssELIN2BusinessDelegate.getPssELIN2Instance().assignTs3(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ts3", exc);
    }
  }

  /**
   * unassign Ts3 on PssELIN2
   *
   * @param command UnAssignTs3FromPssELIN2Command
   */
  @PutMapping("/unAssignTs3")
  public void unAssignTs3(@RequestBody(required = true) UnAssignTs3FromPssELIN2Command command) {
    try {
      PssELIN2BusinessDelegate.getPssELIN2Instance().unAssignTs3(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ts3", exc);
    }
  }

  /**
   * save Ts4 on PssELIN2
   *
   * @param command AssignTs4ToPssELIN2Command
   */
  @PutMapping("/assignTs4")
  public void assignTs4(@RequestBody AssignTs4ToPssELIN2Command command) {
    try {
      PssELIN2BusinessDelegate.getPssELIN2Instance().assignTs4(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ts4", exc);
    }
  }

  /**
   * unassign Ts4 on PssELIN2
   *
   * @param command UnAssignTs4FromPssELIN2Command
   */
  @PutMapping("/unAssignTs4")
  public void unAssignTs4(@RequestBody(required = true) UnAssignTs4FromPssELIN2Command command) {
    try {
      PssELIN2BusinessDelegate.getPssELIN2Instance().unAssignTs4(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ts4", exc);
    }
  }

  /**
   * save Ts5 on PssELIN2
   *
   * @param command AssignTs5ToPssELIN2Command
   */
  @PutMapping("/assignTs5")
  public void assignTs5(@RequestBody AssignTs5ToPssELIN2Command command) {
    try {
      PssELIN2BusinessDelegate.getPssELIN2Instance().assignTs5(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ts5", exc);
    }
  }

  /**
   * unassign Ts5 on PssELIN2
   *
   * @param command UnAssignTs5FromPssELIN2Command
   */
  @PutMapping("/unAssignTs5")
  public void unAssignTs5(@RequestBody(required = true) UnAssignTs5FromPssELIN2Command command) {
    try {
      PssELIN2BusinessDelegate.getPssELIN2Instance().unAssignTs5(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ts5", exc);
    }
  }

  /**
   * save Ts6 on PssELIN2
   *
   * @param command AssignTs6ToPssELIN2Command
   */
  @PutMapping("/assignTs6")
  public void assignTs6(@RequestBody AssignTs6ToPssELIN2Command command) {
    try {
      PssELIN2BusinessDelegate.getPssELIN2Instance().assignTs6(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ts6", exc);
    }
  }

  /**
   * unassign Ts6 on PssELIN2
   *
   * @param command UnAssignTs6FromPssELIN2Command
   */
  @PutMapping("/unAssignTs6")
  public void unAssignTs6(@RequestBody(required = true) UnAssignTs6FromPssELIN2Command command) {
    try {
      PssELIN2BusinessDelegate.getPssELIN2Instance().unAssignTs6(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ts6", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected PssELIN2 pssELIN2 = null;
  private static final Logger LOGGER =
      Logger.getLogger(PssELIN2CommandRestController.class.getName());
}
