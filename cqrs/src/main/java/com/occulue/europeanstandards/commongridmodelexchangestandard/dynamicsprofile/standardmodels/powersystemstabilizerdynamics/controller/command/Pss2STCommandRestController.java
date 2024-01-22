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
 * Implements Spring Controller command CQRS processing for entity Pss2ST.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/Pss2ST")
public class Pss2STCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a Pss2ST. if not key provided, calls create, otherwise calls save
   *
   * @param Pss2ST pss2ST
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(@RequestBody(required = true) CreatePss2STCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture = Pss2STBusinessDelegate.getPss2STInstance().createPss2ST(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a Pss2ST. if no key provided, calls create, otherwise calls save
   *
   * @param Pss2ST pss2ST
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(@RequestBody(required = true) UpdatePss2STCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdatePss2STCommand
      // -----------------------------------------------
      completableFuture = Pss2STBusinessDelegate.getPss2STInstance().updatePss2ST(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "Pss2STController:update() - successfully update Pss2ST - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a Pss2ST entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID pss2STId) {
    CompletableFuture<Void> completableFuture = null;
    DeletePss2STCommand command = new DeletePss2STCommand(pss2STId);

    try {
      Pss2STBusinessDelegate delegate = Pss2STBusinessDelegate.getPss2STInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(Level.WARNING, "Successfully deleted Pss2ST with key " + command.getPss2STId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save K1 on Pss2ST
   *
   * @param command AssignK1ToPss2STCommand
   */
  @PutMapping("/assignK1")
  public void assignK1(@RequestBody AssignK1ToPss2STCommand command) {
    try {
      Pss2STBusinessDelegate.getPss2STInstance().assignK1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign K1", exc);
    }
  }

  /**
   * unassign K1 on Pss2ST
   *
   * @param command UnAssignK1FromPss2STCommand
   */
  @PutMapping("/unAssignK1")
  public void unAssignK1(@RequestBody(required = true) UnAssignK1FromPss2STCommand command) {
    try {
      Pss2STBusinessDelegate.getPss2STInstance().unAssignK1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign K1", exc);
    }
  }

  /**
   * save K2 on Pss2ST
   *
   * @param command AssignK2ToPss2STCommand
   */
  @PutMapping("/assignK2")
  public void assignK2(@RequestBody AssignK2ToPss2STCommand command) {
    try {
      Pss2STBusinessDelegate.getPss2STInstance().assignK2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign K2", exc);
    }
  }

  /**
   * unassign K2 on Pss2ST
   *
   * @param command UnAssignK2FromPss2STCommand
   */
  @PutMapping("/unAssignK2")
  public void unAssignK2(@RequestBody(required = true) UnAssignK2FromPss2STCommand command) {
    try {
      Pss2STBusinessDelegate.getPss2STInstance().unAssignK2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign K2", exc);
    }
  }

  /**
   * save Lsmax on Pss2ST
   *
   * @param command AssignLsmaxToPss2STCommand
   */
  @PutMapping("/assignLsmax")
  public void assignLsmax(@RequestBody AssignLsmaxToPss2STCommand command) {
    try {
      Pss2STBusinessDelegate.getPss2STInstance().assignLsmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Lsmax", exc);
    }
  }

  /**
   * unassign Lsmax on Pss2ST
   *
   * @param command UnAssignLsmaxFromPss2STCommand
   */
  @PutMapping("/unAssignLsmax")
  public void unAssignLsmax(@RequestBody(required = true) UnAssignLsmaxFromPss2STCommand command) {
    try {
      Pss2STBusinessDelegate.getPss2STInstance().unAssignLsmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Lsmax", exc);
    }
  }

  /**
   * save Lsmin on Pss2ST
   *
   * @param command AssignLsminToPss2STCommand
   */
  @PutMapping("/assignLsmin")
  public void assignLsmin(@RequestBody AssignLsminToPss2STCommand command) {
    try {
      Pss2STBusinessDelegate.getPss2STInstance().assignLsmin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Lsmin", exc);
    }
  }

  /**
   * unassign Lsmin on Pss2ST
   *
   * @param command UnAssignLsminFromPss2STCommand
   */
  @PutMapping("/unAssignLsmin")
  public void unAssignLsmin(@RequestBody(required = true) UnAssignLsminFromPss2STCommand command) {
    try {
      Pss2STBusinessDelegate.getPss2STInstance().unAssignLsmin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Lsmin", exc);
    }
  }

  /**
   * save T1 on Pss2ST
   *
   * @param command AssignT1ToPss2STCommand
   */
  @PutMapping("/assignT1")
  public void assignT1(@RequestBody AssignT1ToPss2STCommand command) {
    try {
      Pss2STBusinessDelegate.getPss2STInstance().assignT1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T1", exc);
    }
  }

  /**
   * unassign T1 on Pss2ST
   *
   * @param command UnAssignT1FromPss2STCommand
   */
  @PutMapping("/unAssignT1")
  public void unAssignT1(@RequestBody(required = true) UnAssignT1FromPss2STCommand command) {
    try {
      Pss2STBusinessDelegate.getPss2STInstance().unAssignT1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T1", exc);
    }
  }

  /**
   * save T10 on Pss2ST
   *
   * @param command AssignT10ToPss2STCommand
   */
  @PutMapping("/assignT10")
  public void assignT10(@RequestBody AssignT10ToPss2STCommand command) {
    try {
      Pss2STBusinessDelegate.getPss2STInstance().assignT10(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T10", exc);
    }
  }

  /**
   * unassign T10 on Pss2ST
   *
   * @param command UnAssignT10FromPss2STCommand
   */
  @PutMapping("/unAssignT10")
  public void unAssignT10(@RequestBody(required = true) UnAssignT10FromPss2STCommand command) {
    try {
      Pss2STBusinessDelegate.getPss2STInstance().unAssignT10(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T10", exc);
    }
  }

  /**
   * save T2 on Pss2ST
   *
   * @param command AssignT2ToPss2STCommand
   */
  @PutMapping("/assignT2")
  public void assignT2(@RequestBody AssignT2ToPss2STCommand command) {
    try {
      Pss2STBusinessDelegate.getPss2STInstance().assignT2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T2", exc);
    }
  }

  /**
   * unassign T2 on Pss2ST
   *
   * @param command UnAssignT2FromPss2STCommand
   */
  @PutMapping("/unAssignT2")
  public void unAssignT2(@RequestBody(required = true) UnAssignT2FromPss2STCommand command) {
    try {
      Pss2STBusinessDelegate.getPss2STInstance().unAssignT2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T2", exc);
    }
  }

  /**
   * save T3 on Pss2ST
   *
   * @param command AssignT3ToPss2STCommand
   */
  @PutMapping("/assignT3")
  public void assignT3(@RequestBody AssignT3ToPss2STCommand command) {
    try {
      Pss2STBusinessDelegate.getPss2STInstance().assignT3(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T3", exc);
    }
  }

  /**
   * unassign T3 on Pss2ST
   *
   * @param command UnAssignT3FromPss2STCommand
   */
  @PutMapping("/unAssignT3")
  public void unAssignT3(@RequestBody(required = true) UnAssignT3FromPss2STCommand command) {
    try {
      Pss2STBusinessDelegate.getPss2STInstance().unAssignT3(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T3", exc);
    }
  }

  /**
   * save T4 on Pss2ST
   *
   * @param command AssignT4ToPss2STCommand
   */
  @PutMapping("/assignT4")
  public void assignT4(@RequestBody AssignT4ToPss2STCommand command) {
    try {
      Pss2STBusinessDelegate.getPss2STInstance().assignT4(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T4", exc);
    }
  }

  /**
   * unassign T4 on Pss2ST
   *
   * @param command UnAssignT4FromPss2STCommand
   */
  @PutMapping("/unAssignT4")
  public void unAssignT4(@RequestBody(required = true) UnAssignT4FromPss2STCommand command) {
    try {
      Pss2STBusinessDelegate.getPss2STInstance().unAssignT4(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T4", exc);
    }
  }

  /**
   * save T5 on Pss2ST
   *
   * @param command AssignT5ToPss2STCommand
   */
  @PutMapping("/assignT5")
  public void assignT5(@RequestBody AssignT5ToPss2STCommand command) {
    try {
      Pss2STBusinessDelegate.getPss2STInstance().assignT5(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T5", exc);
    }
  }

  /**
   * unassign T5 on Pss2ST
   *
   * @param command UnAssignT5FromPss2STCommand
   */
  @PutMapping("/unAssignT5")
  public void unAssignT5(@RequestBody(required = true) UnAssignT5FromPss2STCommand command) {
    try {
      Pss2STBusinessDelegate.getPss2STInstance().unAssignT5(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T5", exc);
    }
  }

  /**
   * save T6 on Pss2ST
   *
   * @param command AssignT6ToPss2STCommand
   */
  @PutMapping("/assignT6")
  public void assignT6(@RequestBody AssignT6ToPss2STCommand command) {
    try {
      Pss2STBusinessDelegate.getPss2STInstance().assignT6(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T6", exc);
    }
  }

  /**
   * unassign T6 on Pss2ST
   *
   * @param command UnAssignT6FromPss2STCommand
   */
  @PutMapping("/unAssignT6")
  public void unAssignT6(@RequestBody(required = true) UnAssignT6FromPss2STCommand command) {
    try {
      Pss2STBusinessDelegate.getPss2STInstance().unAssignT6(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T6", exc);
    }
  }

  /**
   * save T7 on Pss2ST
   *
   * @param command AssignT7ToPss2STCommand
   */
  @PutMapping("/assignT7")
  public void assignT7(@RequestBody AssignT7ToPss2STCommand command) {
    try {
      Pss2STBusinessDelegate.getPss2STInstance().assignT7(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T7", exc);
    }
  }

  /**
   * unassign T7 on Pss2ST
   *
   * @param command UnAssignT7FromPss2STCommand
   */
  @PutMapping("/unAssignT7")
  public void unAssignT7(@RequestBody(required = true) UnAssignT7FromPss2STCommand command) {
    try {
      Pss2STBusinessDelegate.getPss2STInstance().unAssignT7(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T7", exc);
    }
  }

  /**
   * save T8 on Pss2ST
   *
   * @param command AssignT8ToPss2STCommand
   */
  @PutMapping("/assignT8")
  public void assignT8(@RequestBody AssignT8ToPss2STCommand command) {
    try {
      Pss2STBusinessDelegate.getPss2STInstance().assignT8(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T8", exc);
    }
  }

  /**
   * unassign T8 on Pss2ST
   *
   * @param command UnAssignT8FromPss2STCommand
   */
  @PutMapping("/unAssignT8")
  public void unAssignT8(@RequestBody(required = true) UnAssignT8FromPss2STCommand command) {
    try {
      Pss2STBusinessDelegate.getPss2STInstance().unAssignT8(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T8", exc);
    }
  }

  /**
   * save T9 on Pss2ST
   *
   * @param command AssignT9ToPss2STCommand
   */
  @PutMapping("/assignT9")
  public void assignT9(@RequestBody AssignT9ToPss2STCommand command) {
    try {
      Pss2STBusinessDelegate.getPss2STInstance().assignT9(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T9", exc);
    }
  }

  /**
   * unassign T9 on Pss2ST
   *
   * @param command UnAssignT9FromPss2STCommand
   */
  @PutMapping("/unAssignT9")
  public void unAssignT9(@RequestBody(required = true) UnAssignT9FromPss2STCommand command) {
    try {
      Pss2STBusinessDelegate.getPss2STInstance().unAssignT9(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T9", exc);
    }
  }

  /**
   * save Vcl on Pss2ST
   *
   * @param command AssignVclToPss2STCommand
   */
  @PutMapping("/assignVcl")
  public void assignVcl(@RequestBody AssignVclToPss2STCommand command) {
    try {
      Pss2STBusinessDelegate.getPss2STInstance().assignVcl(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vcl", exc);
    }
  }

  /**
   * unassign Vcl on Pss2ST
   *
   * @param command UnAssignVclFromPss2STCommand
   */
  @PutMapping("/unAssignVcl")
  public void unAssignVcl(@RequestBody(required = true) UnAssignVclFromPss2STCommand command) {
    try {
      Pss2STBusinessDelegate.getPss2STInstance().unAssignVcl(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vcl", exc);
    }
  }

  /**
   * save Vcu on Pss2ST
   *
   * @param command AssignVcuToPss2STCommand
   */
  @PutMapping("/assignVcu")
  public void assignVcu(@RequestBody AssignVcuToPss2STCommand command) {
    try {
      Pss2STBusinessDelegate.getPss2STInstance().assignVcu(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vcu", exc);
    }
  }

  /**
   * unassign Vcu on Pss2ST
   *
   * @param command UnAssignVcuFromPss2STCommand
   */
  @PutMapping("/unAssignVcu")
  public void unAssignVcu(@RequestBody(required = true) UnAssignVcuFromPss2STCommand command) {
    try {
      Pss2STBusinessDelegate.getPss2STInstance().unAssignVcu(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vcu", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected Pss2ST pss2ST = null;
  private static final Logger LOGGER =
      Logger.getLogger(Pss2STCommandRestController.class.getName());
}
