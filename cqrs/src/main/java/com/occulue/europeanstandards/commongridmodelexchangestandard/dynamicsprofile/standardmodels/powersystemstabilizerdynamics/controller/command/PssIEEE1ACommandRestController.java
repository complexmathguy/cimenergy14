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
 * Implements Spring Controller command CQRS processing for entity PssIEEE1A.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/PssIEEE1A")
public class PssIEEE1ACommandRestController extends BaseSpringRestController {

  /**
   * Handles create a PssIEEE1A. if not key provided, calls create, otherwise calls save
   *
   * @param PssIEEE1A pssIEEE1A
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreatePssIEEE1ACommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture = PssIEEE1ABusinessDelegate.getPssIEEE1AInstance().createPssIEEE1A(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a PssIEEE1A. if no key provided, calls create, otherwise calls save
   *
   * @param PssIEEE1A pssIEEE1A
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdatePssIEEE1ACommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdatePssIEEE1ACommand
      // -----------------------------------------------
      completableFuture = PssIEEE1ABusinessDelegate.getPssIEEE1AInstance().updatePssIEEE1A(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "PssIEEE1AController:update() - successfully update PssIEEE1A - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a PssIEEE1A entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID pssIEEE1AId) {
    CompletableFuture<Void> completableFuture = null;
    DeletePssIEEE1ACommand command = new DeletePssIEEE1ACommand(pssIEEE1AId);

    try {
      PssIEEE1ABusinessDelegate delegate = PssIEEE1ABusinessDelegate.getPssIEEE1AInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING, "Successfully deleted PssIEEE1A with key " + command.getPssIEEE1AId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save A1 on PssIEEE1A
   *
   * @param command AssignA1ToPssIEEE1ACommand
   */
  @PutMapping("/assignA1")
  public void assignA1(@RequestBody AssignA1ToPssIEEE1ACommand command) {
    try {
      PssIEEE1ABusinessDelegate.getPssIEEE1AInstance().assignA1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign A1", exc);
    }
  }

  /**
   * unassign A1 on PssIEEE1A
   *
   * @param command UnAssignA1FromPssIEEE1ACommand
   */
  @PutMapping("/unAssignA1")
  public void unAssignA1(@RequestBody(required = true) UnAssignA1FromPssIEEE1ACommand command) {
    try {
      PssIEEE1ABusinessDelegate.getPssIEEE1AInstance().unAssignA1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign A1", exc);
    }
  }

  /**
   * save A2 on PssIEEE1A
   *
   * @param command AssignA2ToPssIEEE1ACommand
   */
  @PutMapping("/assignA2")
  public void assignA2(@RequestBody AssignA2ToPssIEEE1ACommand command) {
    try {
      PssIEEE1ABusinessDelegate.getPssIEEE1AInstance().assignA2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign A2", exc);
    }
  }

  /**
   * unassign A2 on PssIEEE1A
   *
   * @param command UnAssignA2FromPssIEEE1ACommand
   */
  @PutMapping("/unAssignA2")
  public void unAssignA2(@RequestBody(required = true) UnAssignA2FromPssIEEE1ACommand command) {
    try {
      PssIEEE1ABusinessDelegate.getPssIEEE1AInstance().unAssignA2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign A2", exc);
    }
  }

  /**
   * save Ks on PssIEEE1A
   *
   * @param command AssignKsToPssIEEE1ACommand
   */
  @PutMapping("/assignKs")
  public void assignKs(@RequestBody AssignKsToPssIEEE1ACommand command) {
    try {
      PssIEEE1ABusinessDelegate.getPssIEEE1AInstance().assignKs(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ks", exc);
    }
  }

  /**
   * unassign Ks on PssIEEE1A
   *
   * @param command UnAssignKsFromPssIEEE1ACommand
   */
  @PutMapping("/unAssignKs")
  public void unAssignKs(@RequestBody(required = true) UnAssignKsFromPssIEEE1ACommand command) {
    try {
      PssIEEE1ABusinessDelegate.getPssIEEE1AInstance().unAssignKs(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ks", exc);
    }
  }

  /**
   * save T1 on PssIEEE1A
   *
   * @param command AssignT1ToPssIEEE1ACommand
   */
  @PutMapping("/assignT1")
  public void assignT1(@RequestBody AssignT1ToPssIEEE1ACommand command) {
    try {
      PssIEEE1ABusinessDelegate.getPssIEEE1AInstance().assignT1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T1", exc);
    }
  }

  /**
   * unassign T1 on PssIEEE1A
   *
   * @param command UnAssignT1FromPssIEEE1ACommand
   */
  @PutMapping("/unAssignT1")
  public void unAssignT1(@RequestBody(required = true) UnAssignT1FromPssIEEE1ACommand command) {
    try {
      PssIEEE1ABusinessDelegate.getPssIEEE1AInstance().unAssignT1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T1", exc);
    }
  }

  /**
   * save T2 on PssIEEE1A
   *
   * @param command AssignT2ToPssIEEE1ACommand
   */
  @PutMapping("/assignT2")
  public void assignT2(@RequestBody AssignT2ToPssIEEE1ACommand command) {
    try {
      PssIEEE1ABusinessDelegate.getPssIEEE1AInstance().assignT2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T2", exc);
    }
  }

  /**
   * unassign T2 on PssIEEE1A
   *
   * @param command UnAssignT2FromPssIEEE1ACommand
   */
  @PutMapping("/unAssignT2")
  public void unAssignT2(@RequestBody(required = true) UnAssignT2FromPssIEEE1ACommand command) {
    try {
      PssIEEE1ABusinessDelegate.getPssIEEE1AInstance().unAssignT2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T2", exc);
    }
  }

  /**
   * save T3 on PssIEEE1A
   *
   * @param command AssignT3ToPssIEEE1ACommand
   */
  @PutMapping("/assignT3")
  public void assignT3(@RequestBody AssignT3ToPssIEEE1ACommand command) {
    try {
      PssIEEE1ABusinessDelegate.getPssIEEE1AInstance().assignT3(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T3", exc);
    }
  }

  /**
   * unassign T3 on PssIEEE1A
   *
   * @param command UnAssignT3FromPssIEEE1ACommand
   */
  @PutMapping("/unAssignT3")
  public void unAssignT3(@RequestBody(required = true) UnAssignT3FromPssIEEE1ACommand command) {
    try {
      PssIEEE1ABusinessDelegate.getPssIEEE1AInstance().unAssignT3(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T3", exc);
    }
  }

  /**
   * save T4 on PssIEEE1A
   *
   * @param command AssignT4ToPssIEEE1ACommand
   */
  @PutMapping("/assignT4")
  public void assignT4(@RequestBody AssignT4ToPssIEEE1ACommand command) {
    try {
      PssIEEE1ABusinessDelegate.getPssIEEE1AInstance().assignT4(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T4", exc);
    }
  }

  /**
   * unassign T4 on PssIEEE1A
   *
   * @param command UnAssignT4FromPssIEEE1ACommand
   */
  @PutMapping("/unAssignT4")
  public void unAssignT4(@RequestBody(required = true) UnAssignT4FromPssIEEE1ACommand command) {
    try {
      PssIEEE1ABusinessDelegate.getPssIEEE1AInstance().unAssignT4(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T4", exc);
    }
  }

  /**
   * save T5 on PssIEEE1A
   *
   * @param command AssignT5ToPssIEEE1ACommand
   */
  @PutMapping("/assignT5")
  public void assignT5(@RequestBody AssignT5ToPssIEEE1ACommand command) {
    try {
      PssIEEE1ABusinessDelegate.getPssIEEE1AInstance().assignT5(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T5", exc);
    }
  }

  /**
   * unassign T5 on PssIEEE1A
   *
   * @param command UnAssignT5FromPssIEEE1ACommand
   */
  @PutMapping("/unAssignT5")
  public void unAssignT5(@RequestBody(required = true) UnAssignT5FromPssIEEE1ACommand command) {
    try {
      PssIEEE1ABusinessDelegate.getPssIEEE1AInstance().unAssignT5(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T5", exc);
    }
  }

  /**
   * save T6 on PssIEEE1A
   *
   * @param command AssignT6ToPssIEEE1ACommand
   */
  @PutMapping("/assignT6")
  public void assignT6(@RequestBody AssignT6ToPssIEEE1ACommand command) {
    try {
      PssIEEE1ABusinessDelegate.getPssIEEE1AInstance().assignT6(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T6", exc);
    }
  }

  /**
   * unassign T6 on PssIEEE1A
   *
   * @param command UnAssignT6FromPssIEEE1ACommand
   */
  @PutMapping("/unAssignT6")
  public void unAssignT6(@RequestBody(required = true) UnAssignT6FromPssIEEE1ACommand command) {
    try {
      PssIEEE1ABusinessDelegate.getPssIEEE1AInstance().unAssignT6(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T6", exc);
    }
  }

  /**
   * save Vrmax on PssIEEE1A
   *
   * @param command AssignVrmaxToPssIEEE1ACommand
   */
  @PutMapping("/assignVrmax")
  public void assignVrmax(@RequestBody AssignVrmaxToPssIEEE1ACommand command) {
    try {
      PssIEEE1ABusinessDelegate.getPssIEEE1AInstance().assignVrmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vrmax", exc);
    }
  }

  /**
   * unassign Vrmax on PssIEEE1A
   *
   * @param command UnAssignVrmaxFromPssIEEE1ACommand
   */
  @PutMapping("/unAssignVrmax")
  public void unAssignVrmax(
      @RequestBody(required = true) UnAssignVrmaxFromPssIEEE1ACommand command) {
    try {
      PssIEEE1ABusinessDelegate.getPssIEEE1AInstance().unAssignVrmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vrmax", exc);
    }
  }

  /**
   * save Vrmin on PssIEEE1A
   *
   * @param command AssignVrminToPssIEEE1ACommand
   */
  @PutMapping("/assignVrmin")
  public void assignVrmin(@RequestBody AssignVrminToPssIEEE1ACommand command) {
    try {
      PssIEEE1ABusinessDelegate.getPssIEEE1AInstance().assignVrmin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vrmin", exc);
    }
  }

  /**
   * unassign Vrmin on PssIEEE1A
   *
   * @param command UnAssignVrminFromPssIEEE1ACommand
   */
  @PutMapping("/unAssignVrmin")
  public void unAssignVrmin(
      @RequestBody(required = true) UnAssignVrminFromPssIEEE1ACommand command) {
    try {
      PssIEEE1ABusinessDelegate.getPssIEEE1AInstance().unAssignVrmin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vrmin", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected PssIEEE1A pssIEEE1A = null;
  private static final Logger LOGGER =
      Logger.getLogger(PssIEEE1ACommandRestController.class.getName());
}
