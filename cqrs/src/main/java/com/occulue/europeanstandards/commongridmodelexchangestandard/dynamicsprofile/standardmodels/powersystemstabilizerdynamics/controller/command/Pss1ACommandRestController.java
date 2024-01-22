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
 * Implements Spring Controller command CQRS processing for entity Pss1A.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/Pss1A")
public class Pss1ACommandRestController extends BaseSpringRestController {

  /**
   * Handles create a Pss1A. if not key provided, calls create, otherwise calls save
   *
   * @param Pss1A pss1A
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(@RequestBody(required = true) CreatePss1ACommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture = Pss1ABusinessDelegate.getPss1AInstance().createPss1A(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a Pss1A. if no key provided, calls create, otherwise calls save
   *
   * @param Pss1A pss1A
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(@RequestBody(required = true) UpdatePss1ACommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdatePss1ACommand
      // -----------------------------------------------
      completableFuture = Pss1ABusinessDelegate.getPss1AInstance().updatePss1A(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "Pss1AController:update() - successfully update Pss1A - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a Pss1A entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID pss1AId) {
    CompletableFuture<Void> completableFuture = null;
    DeletePss1ACommand command = new DeletePss1ACommand(pss1AId);

    try {
      Pss1ABusinessDelegate delegate = Pss1ABusinessDelegate.getPss1AInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(Level.WARNING, "Successfully deleted Pss1A with key " + command.getPss1AId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save A1 on Pss1A
   *
   * @param command AssignA1ToPss1ACommand
   */
  @PutMapping("/assignA1")
  public void assignA1(@RequestBody AssignA1ToPss1ACommand command) {
    try {
      Pss1ABusinessDelegate.getPss1AInstance().assignA1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign A1", exc);
    }
  }

  /**
   * unassign A1 on Pss1A
   *
   * @param command UnAssignA1FromPss1ACommand
   */
  @PutMapping("/unAssignA1")
  public void unAssignA1(@RequestBody(required = true) UnAssignA1FromPss1ACommand command) {
    try {
      Pss1ABusinessDelegate.getPss1AInstance().unAssignA1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign A1", exc);
    }
  }

  /**
   * save A2 on Pss1A
   *
   * @param command AssignA2ToPss1ACommand
   */
  @PutMapping("/assignA2")
  public void assignA2(@RequestBody AssignA2ToPss1ACommand command) {
    try {
      Pss1ABusinessDelegate.getPss1AInstance().assignA2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign A2", exc);
    }
  }

  /**
   * unassign A2 on Pss1A
   *
   * @param command UnAssignA2FromPss1ACommand
   */
  @PutMapping("/unAssignA2")
  public void unAssignA2(@RequestBody(required = true) UnAssignA2FromPss1ACommand command) {
    try {
      Pss1ABusinessDelegate.getPss1AInstance().unAssignA2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign A2", exc);
    }
  }

  /**
   * save A3 on Pss1A
   *
   * @param command AssignA3ToPss1ACommand
   */
  @PutMapping("/assignA3")
  public void assignA3(@RequestBody AssignA3ToPss1ACommand command) {
    try {
      Pss1ABusinessDelegate.getPss1AInstance().assignA3(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign A3", exc);
    }
  }

  /**
   * unassign A3 on Pss1A
   *
   * @param command UnAssignA3FromPss1ACommand
   */
  @PutMapping("/unAssignA3")
  public void unAssignA3(@RequestBody(required = true) UnAssignA3FromPss1ACommand command) {
    try {
      Pss1ABusinessDelegate.getPss1AInstance().unAssignA3(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign A3", exc);
    }
  }

  /**
   * save A4 on Pss1A
   *
   * @param command AssignA4ToPss1ACommand
   */
  @PutMapping("/assignA4")
  public void assignA4(@RequestBody AssignA4ToPss1ACommand command) {
    try {
      Pss1ABusinessDelegate.getPss1AInstance().assignA4(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign A4", exc);
    }
  }

  /**
   * unassign A4 on Pss1A
   *
   * @param command UnAssignA4FromPss1ACommand
   */
  @PutMapping("/unAssignA4")
  public void unAssignA4(@RequestBody(required = true) UnAssignA4FromPss1ACommand command) {
    try {
      Pss1ABusinessDelegate.getPss1AInstance().unAssignA4(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign A4", exc);
    }
  }

  /**
   * save A5 on Pss1A
   *
   * @param command AssignA5ToPss1ACommand
   */
  @PutMapping("/assignA5")
  public void assignA5(@RequestBody AssignA5ToPss1ACommand command) {
    try {
      Pss1ABusinessDelegate.getPss1AInstance().assignA5(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign A5", exc);
    }
  }

  /**
   * unassign A5 on Pss1A
   *
   * @param command UnAssignA5FromPss1ACommand
   */
  @PutMapping("/unAssignA5")
  public void unAssignA5(@RequestBody(required = true) UnAssignA5FromPss1ACommand command) {
    try {
      Pss1ABusinessDelegate.getPss1AInstance().unAssignA5(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign A5", exc);
    }
  }

  /**
   * save A6 on Pss1A
   *
   * @param command AssignA6ToPss1ACommand
   */
  @PutMapping("/assignA6")
  public void assignA6(@RequestBody AssignA6ToPss1ACommand command) {
    try {
      Pss1ABusinessDelegate.getPss1AInstance().assignA6(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign A6", exc);
    }
  }

  /**
   * unassign A6 on Pss1A
   *
   * @param command UnAssignA6FromPss1ACommand
   */
  @PutMapping("/unAssignA6")
  public void unAssignA6(@RequestBody(required = true) UnAssignA6FromPss1ACommand command) {
    try {
      Pss1ABusinessDelegate.getPss1AInstance().unAssignA6(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign A6", exc);
    }
  }

  /**
   * save A7 on Pss1A
   *
   * @param command AssignA7ToPss1ACommand
   */
  @PutMapping("/assignA7")
  public void assignA7(@RequestBody AssignA7ToPss1ACommand command) {
    try {
      Pss1ABusinessDelegate.getPss1AInstance().assignA7(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign A7", exc);
    }
  }

  /**
   * unassign A7 on Pss1A
   *
   * @param command UnAssignA7FromPss1ACommand
   */
  @PutMapping("/unAssignA7")
  public void unAssignA7(@RequestBody(required = true) UnAssignA7FromPss1ACommand command) {
    try {
      Pss1ABusinessDelegate.getPss1AInstance().unAssignA7(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign A7", exc);
    }
  }

  /**
   * save A8 on Pss1A
   *
   * @param command AssignA8ToPss1ACommand
   */
  @PutMapping("/assignA8")
  public void assignA8(@RequestBody AssignA8ToPss1ACommand command) {
    try {
      Pss1ABusinessDelegate.getPss1AInstance().assignA8(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign A8", exc);
    }
  }

  /**
   * unassign A8 on Pss1A
   *
   * @param command UnAssignA8FromPss1ACommand
   */
  @PutMapping("/unAssignA8")
  public void unAssignA8(@RequestBody(required = true) UnAssignA8FromPss1ACommand command) {
    try {
      Pss1ABusinessDelegate.getPss1AInstance().unAssignA8(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign A8", exc);
    }
  }

  /**
   * save Kd on Pss1A
   *
   * @param command AssignKdToPss1ACommand
   */
  @PutMapping("/assignKd")
  public void assignKd(@RequestBody AssignKdToPss1ACommand command) {
    try {
      Pss1ABusinessDelegate.getPss1AInstance().assignKd(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kd", exc);
    }
  }

  /**
   * unassign Kd on Pss1A
   *
   * @param command UnAssignKdFromPss1ACommand
   */
  @PutMapping("/unAssignKd")
  public void unAssignKd(@RequestBody(required = true) UnAssignKdFromPss1ACommand command) {
    try {
      Pss1ABusinessDelegate.getPss1AInstance().unAssignKd(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kd", exc);
    }
  }

  /**
   * save Ks on Pss1A
   *
   * @param command AssignKsToPss1ACommand
   */
  @PutMapping("/assignKs")
  public void assignKs(@RequestBody AssignKsToPss1ACommand command) {
    try {
      Pss1ABusinessDelegate.getPss1AInstance().assignKs(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ks", exc);
    }
  }

  /**
   * unassign Ks on Pss1A
   *
   * @param command UnAssignKsFromPss1ACommand
   */
  @PutMapping("/unAssignKs")
  public void unAssignKs(@RequestBody(required = true) UnAssignKsFromPss1ACommand command) {
    try {
      Pss1ABusinessDelegate.getPss1AInstance().unAssignKs(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ks", exc);
    }
  }

  /**
   * save T1 on Pss1A
   *
   * @param command AssignT1ToPss1ACommand
   */
  @PutMapping("/assignT1")
  public void assignT1(@RequestBody AssignT1ToPss1ACommand command) {
    try {
      Pss1ABusinessDelegate.getPss1AInstance().assignT1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T1", exc);
    }
  }

  /**
   * unassign T1 on Pss1A
   *
   * @param command UnAssignT1FromPss1ACommand
   */
  @PutMapping("/unAssignT1")
  public void unAssignT1(@RequestBody(required = true) UnAssignT1FromPss1ACommand command) {
    try {
      Pss1ABusinessDelegate.getPss1AInstance().unAssignT1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T1", exc);
    }
  }

  /**
   * save T2 on Pss1A
   *
   * @param command AssignT2ToPss1ACommand
   */
  @PutMapping("/assignT2")
  public void assignT2(@RequestBody AssignT2ToPss1ACommand command) {
    try {
      Pss1ABusinessDelegate.getPss1AInstance().assignT2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T2", exc);
    }
  }

  /**
   * unassign T2 on Pss1A
   *
   * @param command UnAssignT2FromPss1ACommand
   */
  @PutMapping("/unAssignT2")
  public void unAssignT2(@RequestBody(required = true) UnAssignT2FromPss1ACommand command) {
    try {
      Pss1ABusinessDelegate.getPss1AInstance().unAssignT2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T2", exc);
    }
  }

  /**
   * save T3 on Pss1A
   *
   * @param command AssignT3ToPss1ACommand
   */
  @PutMapping("/assignT3")
  public void assignT3(@RequestBody AssignT3ToPss1ACommand command) {
    try {
      Pss1ABusinessDelegate.getPss1AInstance().assignT3(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T3", exc);
    }
  }

  /**
   * unassign T3 on Pss1A
   *
   * @param command UnAssignT3FromPss1ACommand
   */
  @PutMapping("/unAssignT3")
  public void unAssignT3(@RequestBody(required = true) UnAssignT3FromPss1ACommand command) {
    try {
      Pss1ABusinessDelegate.getPss1AInstance().unAssignT3(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T3", exc);
    }
  }

  /**
   * save T4 on Pss1A
   *
   * @param command AssignT4ToPss1ACommand
   */
  @PutMapping("/assignT4")
  public void assignT4(@RequestBody AssignT4ToPss1ACommand command) {
    try {
      Pss1ABusinessDelegate.getPss1AInstance().assignT4(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T4", exc);
    }
  }

  /**
   * unassign T4 on Pss1A
   *
   * @param command UnAssignT4FromPss1ACommand
   */
  @PutMapping("/unAssignT4")
  public void unAssignT4(@RequestBody(required = true) UnAssignT4FromPss1ACommand command) {
    try {
      Pss1ABusinessDelegate.getPss1AInstance().unAssignT4(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T4", exc);
    }
  }

  /**
   * save T5 on Pss1A
   *
   * @param command AssignT5ToPss1ACommand
   */
  @PutMapping("/assignT5")
  public void assignT5(@RequestBody AssignT5ToPss1ACommand command) {
    try {
      Pss1ABusinessDelegate.getPss1AInstance().assignT5(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T5", exc);
    }
  }

  /**
   * unassign T5 on Pss1A
   *
   * @param command UnAssignT5FromPss1ACommand
   */
  @PutMapping("/unAssignT5")
  public void unAssignT5(@RequestBody(required = true) UnAssignT5FromPss1ACommand command) {
    try {
      Pss1ABusinessDelegate.getPss1AInstance().unAssignT5(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T5", exc);
    }
  }

  /**
   * save T6 on Pss1A
   *
   * @param command AssignT6ToPss1ACommand
   */
  @PutMapping("/assignT6")
  public void assignT6(@RequestBody AssignT6ToPss1ACommand command) {
    try {
      Pss1ABusinessDelegate.getPss1AInstance().assignT6(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T6", exc);
    }
  }

  /**
   * unassign T6 on Pss1A
   *
   * @param command UnAssignT6FromPss1ACommand
   */
  @PutMapping("/unAssignT6")
  public void unAssignT6(@RequestBody(required = true) UnAssignT6FromPss1ACommand command) {
    try {
      Pss1ABusinessDelegate.getPss1AInstance().unAssignT6(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T6", exc);
    }
  }

  /**
   * save Tdelay on Pss1A
   *
   * @param command AssignTdelayToPss1ACommand
   */
  @PutMapping("/assignTdelay")
  public void assignTdelay(@RequestBody AssignTdelayToPss1ACommand command) {
    try {
      Pss1ABusinessDelegate.getPss1AInstance().assignTdelay(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tdelay", exc);
    }
  }

  /**
   * unassign Tdelay on Pss1A
   *
   * @param command UnAssignTdelayFromPss1ACommand
   */
  @PutMapping("/unAssignTdelay")
  public void unAssignTdelay(@RequestBody(required = true) UnAssignTdelayFromPss1ACommand command) {
    try {
      Pss1ABusinessDelegate.getPss1AInstance().unAssignTdelay(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tdelay", exc);
    }
  }

  /**
   * save Vcl on Pss1A
   *
   * @param command AssignVclToPss1ACommand
   */
  @PutMapping("/assignVcl")
  public void assignVcl(@RequestBody AssignVclToPss1ACommand command) {
    try {
      Pss1ABusinessDelegate.getPss1AInstance().assignVcl(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vcl", exc);
    }
  }

  /**
   * unassign Vcl on Pss1A
   *
   * @param command UnAssignVclFromPss1ACommand
   */
  @PutMapping("/unAssignVcl")
  public void unAssignVcl(@RequestBody(required = true) UnAssignVclFromPss1ACommand command) {
    try {
      Pss1ABusinessDelegate.getPss1AInstance().unAssignVcl(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vcl", exc);
    }
  }

  /**
   * save Vcu on Pss1A
   *
   * @param command AssignVcuToPss1ACommand
   */
  @PutMapping("/assignVcu")
  public void assignVcu(@RequestBody AssignVcuToPss1ACommand command) {
    try {
      Pss1ABusinessDelegate.getPss1AInstance().assignVcu(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vcu", exc);
    }
  }

  /**
   * unassign Vcu on Pss1A
   *
   * @param command UnAssignVcuFromPss1ACommand
   */
  @PutMapping("/unAssignVcu")
  public void unAssignVcu(@RequestBody(required = true) UnAssignVcuFromPss1ACommand command) {
    try {
      Pss1ABusinessDelegate.getPss1AInstance().unAssignVcu(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vcu", exc);
    }
  }

  /**
   * save Vrmax on Pss1A
   *
   * @param command AssignVrmaxToPss1ACommand
   */
  @PutMapping("/assignVrmax")
  public void assignVrmax(@RequestBody AssignVrmaxToPss1ACommand command) {
    try {
      Pss1ABusinessDelegate.getPss1AInstance().assignVrmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vrmax", exc);
    }
  }

  /**
   * unassign Vrmax on Pss1A
   *
   * @param command UnAssignVrmaxFromPss1ACommand
   */
  @PutMapping("/unAssignVrmax")
  public void unAssignVrmax(@RequestBody(required = true) UnAssignVrmaxFromPss1ACommand command) {
    try {
      Pss1ABusinessDelegate.getPss1AInstance().unAssignVrmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vrmax", exc);
    }
  }

  /**
   * save Vrmin on Pss1A
   *
   * @param command AssignVrminToPss1ACommand
   */
  @PutMapping("/assignVrmin")
  public void assignVrmin(@RequestBody AssignVrminToPss1ACommand command) {
    try {
      Pss1ABusinessDelegate.getPss1AInstance().assignVrmin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vrmin", exc);
    }
  }

  /**
   * unassign Vrmin on Pss1A
   *
   * @param command UnAssignVrminFromPss1ACommand
   */
  @PutMapping("/unAssignVrmin")
  public void unAssignVrmin(@RequestBody(required = true) UnAssignVrminFromPss1ACommand command) {
    try {
      Pss1ABusinessDelegate.getPss1AInstance().unAssignVrmin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vrmin", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected Pss1A pss1A = null;
  private static final Logger LOGGER = Logger.getLogger(Pss1ACommandRestController.class.getName());
}
