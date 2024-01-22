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
 * Implements Spring Controller command CQRS processing for entity PssWECC.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/PssWECC")
public class PssWECCCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a PssWECC. if not key provided, calls create, otherwise calls save
   *
   * @param PssWECC pssWECC
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreatePssWECCCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture = PssWECCBusinessDelegate.getPssWECCInstance().createPssWECC(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a PssWECC. if no key provided, calls create, otherwise calls save
   *
   * @param PssWECC pssWECC
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdatePssWECCCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdatePssWECCCommand
      // -----------------------------------------------
      completableFuture = PssWECCBusinessDelegate.getPssWECCInstance().updatePssWECC(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "PssWECCController:update() - successfully update PssWECC - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a PssWECC entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID pssWECCId) {
    CompletableFuture<Void> completableFuture = null;
    DeletePssWECCCommand command = new DeletePssWECCCommand(pssWECCId);

    try {
      PssWECCBusinessDelegate delegate = PssWECCBusinessDelegate.getPssWECCInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(Level.WARNING, "Successfully deleted PssWECC with key " + command.getPssWECCId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save K1 on PssWECC
   *
   * @param command AssignK1ToPssWECCCommand
   */
  @PutMapping("/assignK1")
  public void assignK1(@RequestBody AssignK1ToPssWECCCommand command) {
    try {
      PssWECCBusinessDelegate.getPssWECCInstance().assignK1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign K1", exc);
    }
  }

  /**
   * unassign K1 on PssWECC
   *
   * @param command UnAssignK1FromPssWECCCommand
   */
  @PutMapping("/unAssignK1")
  public void unAssignK1(@RequestBody(required = true) UnAssignK1FromPssWECCCommand command) {
    try {
      PssWECCBusinessDelegate.getPssWECCInstance().unAssignK1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign K1", exc);
    }
  }

  /**
   * save K2 on PssWECC
   *
   * @param command AssignK2ToPssWECCCommand
   */
  @PutMapping("/assignK2")
  public void assignK2(@RequestBody AssignK2ToPssWECCCommand command) {
    try {
      PssWECCBusinessDelegate.getPssWECCInstance().assignK2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign K2", exc);
    }
  }

  /**
   * unassign K2 on PssWECC
   *
   * @param command UnAssignK2FromPssWECCCommand
   */
  @PutMapping("/unAssignK2")
  public void unAssignK2(@RequestBody(required = true) UnAssignK2FromPssWECCCommand command) {
    try {
      PssWECCBusinessDelegate.getPssWECCInstance().unAssignK2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign K2", exc);
    }
  }

  /**
   * save T1 on PssWECC
   *
   * @param command AssignT1ToPssWECCCommand
   */
  @PutMapping("/assignT1")
  public void assignT1(@RequestBody AssignT1ToPssWECCCommand command) {
    try {
      PssWECCBusinessDelegate.getPssWECCInstance().assignT1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T1", exc);
    }
  }

  /**
   * unassign T1 on PssWECC
   *
   * @param command UnAssignT1FromPssWECCCommand
   */
  @PutMapping("/unAssignT1")
  public void unAssignT1(@RequestBody(required = true) UnAssignT1FromPssWECCCommand command) {
    try {
      PssWECCBusinessDelegate.getPssWECCInstance().unAssignT1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T1", exc);
    }
  }

  /**
   * save T10 on PssWECC
   *
   * @param command AssignT10ToPssWECCCommand
   */
  @PutMapping("/assignT10")
  public void assignT10(@RequestBody AssignT10ToPssWECCCommand command) {
    try {
      PssWECCBusinessDelegate.getPssWECCInstance().assignT10(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T10", exc);
    }
  }

  /**
   * unassign T10 on PssWECC
   *
   * @param command UnAssignT10FromPssWECCCommand
   */
  @PutMapping("/unAssignT10")
  public void unAssignT10(@RequestBody(required = true) UnAssignT10FromPssWECCCommand command) {
    try {
      PssWECCBusinessDelegate.getPssWECCInstance().unAssignT10(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T10", exc);
    }
  }

  /**
   * save T2 on PssWECC
   *
   * @param command AssignT2ToPssWECCCommand
   */
  @PutMapping("/assignT2")
  public void assignT2(@RequestBody AssignT2ToPssWECCCommand command) {
    try {
      PssWECCBusinessDelegate.getPssWECCInstance().assignT2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T2", exc);
    }
  }

  /**
   * unassign T2 on PssWECC
   *
   * @param command UnAssignT2FromPssWECCCommand
   */
  @PutMapping("/unAssignT2")
  public void unAssignT2(@RequestBody(required = true) UnAssignT2FromPssWECCCommand command) {
    try {
      PssWECCBusinessDelegate.getPssWECCInstance().unAssignT2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T2", exc);
    }
  }

  /**
   * save T3 on PssWECC
   *
   * @param command AssignT3ToPssWECCCommand
   */
  @PutMapping("/assignT3")
  public void assignT3(@RequestBody AssignT3ToPssWECCCommand command) {
    try {
      PssWECCBusinessDelegate.getPssWECCInstance().assignT3(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T3", exc);
    }
  }

  /**
   * unassign T3 on PssWECC
   *
   * @param command UnAssignT3FromPssWECCCommand
   */
  @PutMapping("/unAssignT3")
  public void unAssignT3(@RequestBody(required = true) UnAssignT3FromPssWECCCommand command) {
    try {
      PssWECCBusinessDelegate.getPssWECCInstance().unAssignT3(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T3", exc);
    }
  }

  /**
   * save T4 on PssWECC
   *
   * @param command AssignT4ToPssWECCCommand
   */
  @PutMapping("/assignT4")
  public void assignT4(@RequestBody AssignT4ToPssWECCCommand command) {
    try {
      PssWECCBusinessDelegate.getPssWECCInstance().assignT4(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T4", exc);
    }
  }

  /**
   * unassign T4 on PssWECC
   *
   * @param command UnAssignT4FromPssWECCCommand
   */
  @PutMapping("/unAssignT4")
  public void unAssignT4(@RequestBody(required = true) UnAssignT4FromPssWECCCommand command) {
    try {
      PssWECCBusinessDelegate.getPssWECCInstance().unAssignT4(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T4", exc);
    }
  }

  /**
   * save T5 on PssWECC
   *
   * @param command AssignT5ToPssWECCCommand
   */
  @PutMapping("/assignT5")
  public void assignT5(@RequestBody AssignT5ToPssWECCCommand command) {
    try {
      PssWECCBusinessDelegate.getPssWECCInstance().assignT5(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T5", exc);
    }
  }

  /**
   * unassign T5 on PssWECC
   *
   * @param command UnAssignT5FromPssWECCCommand
   */
  @PutMapping("/unAssignT5")
  public void unAssignT5(@RequestBody(required = true) UnAssignT5FromPssWECCCommand command) {
    try {
      PssWECCBusinessDelegate.getPssWECCInstance().unAssignT5(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T5", exc);
    }
  }

  /**
   * save T6 on PssWECC
   *
   * @param command AssignT6ToPssWECCCommand
   */
  @PutMapping("/assignT6")
  public void assignT6(@RequestBody AssignT6ToPssWECCCommand command) {
    try {
      PssWECCBusinessDelegate.getPssWECCInstance().assignT6(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T6", exc);
    }
  }

  /**
   * unassign T6 on PssWECC
   *
   * @param command UnAssignT6FromPssWECCCommand
   */
  @PutMapping("/unAssignT6")
  public void unAssignT6(@RequestBody(required = true) UnAssignT6FromPssWECCCommand command) {
    try {
      PssWECCBusinessDelegate.getPssWECCInstance().unAssignT6(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T6", exc);
    }
  }

  /**
   * save T7 on PssWECC
   *
   * @param command AssignT7ToPssWECCCommand
   */
  @PutMapping("/assignT7")
  public void assignT7(@RequestBody AssignT7ToPssWECCCommand command) {
    try {
      PssWECCBusinessDelegate.getPssWECCInstance().assignT7(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T7", exc);
    }
  }

  /**
   * unassign T7 on PssWECC
   *
   * @param command UnAssignT7FromPssWECCCommand
   */
  @PutMapping("/unAssignT7")
  public void unAssignT7(@RequestBody(required = true) UnAssignT7FromPssWECCCommand command) {
    try {
      PssWECCBusinessDelegate.getPssWECCInstance().unAssignT7(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T7", exc);
    }
  }

  /**
   * save T8 on PssWECC
   *
   * @param command AssignT8ToPssWECCCommand
   */
  @PutMapping("/assignT8")
  public void assignT8(@RequestBody AssignT8ToPssWECCCommand command) {
    try {
      PssWECCBusinessDelegate.getPssWECCInstance().assignT8(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T8", exc);
    }
  }

  /**
   * unassign T8 on PssWECC
   *
   * @param command UnAssignT8FromPssWECCCommand
   */
  @PutMapping("/unAssignT8")
  public void unAssignT8(@RequestBody(required = true) UnAssignT8FromPssWECCCommand command) {
    try {
      PssWECCBusinessDelegate.getPssWECCInstance().unAssignT8(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T8", exc);
    }
  }

  /**
   * save T9 on PssWECC
   *
   * @param command AssignT9ToPssWECCCommand
   */
  @PutMapping("/assignT9")
  public void assignT9(@RequestBody AssignT9ToPssWECCCommand command) {
    try {
      PssWECCBusinessDelegate.getPssWECCInstance().assignT9(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T9", exc);
    }
  }

  /**
   * unassign T9 on PssWECC
   *
   * @param command UnAssignT9FromPssWECCCommand
   */
  @PutMapping("/unAssignT9")
  public void unAssignT9(@RequestBody(required = true) UnAssignT9FromPssWECCCommand command) {
    try {
      PssWECCBusinessDelegate.getPssWECCInstance().unAssignT9(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T9", exc);
    }
  }

  /**
   * save Vcl on PssWECC
   *
   * @param command AssignVclToPssWECCCommand
   */
  @PutMapping("/assignVcl")
  public void assignVcl(@RequestBody AssignVclToPssWECCCommand command) {
    try {
      PssWECCBusinessDelegate.getPssWECCInstance().assignVcl(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vcl", exc);
    }
  }

  /**
   * unassign Vcl on PssWECC
   *
   * @param command UnAssignVclFromPssWECCCommand
   */
  @PutMapping("/unAssignVcl")
  public void unAssignVcl(@RequestBody(required = true) UnAssignVclFromPssWECCCommand command) {
    try {
      PssWECCBusinessDelegate.getPssWECCInstance().unAssignVcl(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vcl", exc);
    }
  }

  /**
   * save Vcu on PssWECC
   *
   * @param command AssignVcuToPssWECCCommand
   */
  @PutMapping("/assignVcu")
  public void assignVcu(@RequestBody AssignVcuToPssWECCCommand command) {
    try {
      PssWECCBusinessDelegate.getPssWECCInstance().assignVcu(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vcu", exc);
    }
  }

  /**
   * unassign Vcu on PssWECC
   *
   * @param command UnAssignVcuFromPssWECCCommand
   */
  @PutMapping("/unAssignVcu")
  public void unAssignVcu(@RequestBody(required = true) UnAssignVcuFromPssWECCCommand command) {
    try {
      PssWECCBusinessDelegate.getPssWECCInstance().unAssignVcu(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vcu", exc);
    }
  }

  /**
   * save Vsmax on PssWECC
   *
   * @param command AssignVsmaxToPssWECCCommand
   */
  @PutMapping("/assignVsmax")
  public void assignVsmax(@RequestBody AssignVsmaxToPssWECCCommand command) {
    try {
      PssWECCBusinessDelegate.getPssWECCInstance().assignVsmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vsmax", exc);
    }
  }

  /**
   * unassign Vsmax on PssWECC
   *
   * @param command UnAssignVsmaxFromPssWECCCommand
   */
  @PutMapping("/unAssignVsmax")
  public void unAssignVsmax(@RequestBody(required = true) UnAssignVsmaxFromPssWECCCommand command) {
    try {
      PssWECCBusinessDelegate.getPssWECCInstance().unAssignVsmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vsmax", exc);
    }
  }

  /**
   * save Vsmin on PssWECC
   *
   * @param command AssignVsminToPssWECCCommand
   */
  @PutMapping("/assignVsmin")
  public void assignVsmin(@RequestBody AssignVsminToPssWECCCommand command) {
    try {
      PssWECCBusinessDelegate.getPssWECCInstance().assignVsmin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vsmin", exc);
    }
  }

  /**
   * unassign Vsmin on PssWECC
   *
   * @param command UnAssignVsminFromPssWECCCommand
   */
  @PutMapping("/unAssignVsmin")
  public void unAssignVsmin(@RequestBody(required = true) UnAssignVsminFromPssWECCCommand command) {
    try {
      PssWECCBusinessDelegate.getPssWECCInstance().unAssignVsmin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vsmin", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected PssWECC pssWECC = null;
  private static final Logger LOGGER =
      Logger.getLogger(PssWECCCommandRestController.class.getName());
}
