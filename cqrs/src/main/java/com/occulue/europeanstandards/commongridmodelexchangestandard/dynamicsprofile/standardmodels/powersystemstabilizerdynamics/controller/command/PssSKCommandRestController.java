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
 * Implements Spring Controller command CQRS processing for entity PssSK.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/PssSK")
public class PssSKCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a PssSK. if not key provided, calls create, otherwise calls save
   *
   * @param PssSK pssSK
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(@RequestBody(required = true) CreatePssSKCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture = PssSKBusinessDelegate.getPssSKInstance().createPssSK(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a PssSK. if no key provided, calls create, otherwise calls save
   *
   * @param PssSK pssSK
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(@RequestBody(required = true) UpdatePssSKCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdatePssSKCommand
      // -----------------------------------------------
      completableFuture = PssSKBusinessDelegate.getPssSKInstance().updatePssSK(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "PssSKController:update() - successfully update PssSK - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a PssSK entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID pssSKId) {
    CompletableFuture<Void> completableFuture = null;
    DeletePssSKCommand command = new DeletePssSKCommand(pssSKId);

    try {
      PssSKBusinessDelegate delegate = PssSKBusinessDelegate.getPssSKInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(Level.WARNING, "Successfully deleted PssSK with key " + command.getPssSKId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save K1 on PssSK
   *
   * @param command AssignK1ToPssSKCommand
   */
  @PutMapping("/assignK1")
  public void assignK1(@RequestBody AssignK1ToPssSKCommand command) {
    try {
      PssSKBusinessDelegate.getPssSKInstance().assignK1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign K1", exc);
    }
  }

  /**
   * unassign K1 on PssSK
   *
   * @param command UnAssignK1FromPssSKCommand
   */
  @PutMapping("/unAssignK1")
  public void unAssignK1(@RequestBody(required = true) UnAssignK1FromPssSKCommand command) {
    try {
      PssSKBusinessDelegate.getPssSKInstance().unAssignK1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign K1", exc);
    }
  }

  /**
   * save K2 on PssSK
   *
   * @param command AssignK2ToPssSKCommand
   */
  @PutMapping("/assignK2")
  public void assignK2(@RequestBody AssignK2ToPssSKCommand command) {
    try {
      PssSKBusinessDelegate.getPssSKInstance().assignK2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign K2", exc);
    }
  }

  /**
   * unassign K2 on PssSK
   *
   * @param command UnAssignK2FromPssSKCommand
   */
  @PutMapping("/unAssignK2")
  public void unAssignK2(@RequestBody(required = true) UnAssignK2FromPssSKCommand command) {
    try {
      PssSKBusinessDelegate.getPssSKInstance().unAssignK2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign K2", exc);
    }
  }

  /**
   * save K3 on PssSK
   *
   * @param command AssignK3ToPssSKCommand
   */
  @PutMapping("/assignK3")
  public void assignK3(@RequestBody AssignK3ToPssSKCommand command) {
    try {
      PssSKBusinessDelegate.getPssSKInstance().assignK3(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign K3", exc);
    }
  }

  /**
   * unassign K3 on PssSK
   *
   * @param command UnAssignK3FromPssSKCommand
   */
  @PutMapping("/unAssignK3")
  public void unAssignK3(@RequestBody(required = true) UnAssignK3FromPssSKCommand command) {
    try {
      PssSKBusinessDelegate.getPssSKInstance().unAssignK3(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign K3", exc);
    }
  }

  /**
   * save T1 on PssSK
   *
   * @param command AssignT1ToPssSKCommand
   */
  @PutMapping("/assignT1")
  public void assignT1(@RequestBody AssignT1ToPssSKCommand command) {
    try {
      PssSKBusinessDelegate.getPssSKInstance().assignT1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T1", exc);
    }
  }

  /**
   * unassign T1 on PssSK
   *
   * @param command UnAssignT1FromPssSKCommand
   */
  @PutMapping("/unAssignT1")
  public void unAssignT1(@RequestBody(required = true) UnAssignT1FromPssSKCommand command) {
    try {
      PssSKBusinessDelegate.getPssSKInstance().unAssignT1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T1", exc);
    }
  }

  /**
   * save T2 on PssSK
   *
   * @param command AssignT2ToPssSKCommand
   */
  @PutMapping("/assignT2")
  public void assignT2(@RequestBody AssignT2ToPssSKCommand command) {
    try {
      PssSKBusinessDelegate.getPssSKInstance().assignT2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T2", exc);
    }
  }

  /**
   * unassign T2 on PssSK
   *
   * @param command UnAssignT2FromPssSKCommand
   */
  @PutMapping("/unAssignT2")
  public void unAssignT2(@RequestBody(required = true) UnAssignT2FromPssSKCommand command) {
    try {
      PssSKBusinessDelegate.getPssSKInstance().unAssignT2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T2", exc);
    }
  }

  /**
   * save T3 on PssSK
   *
   * @param command AssignT3ToPssSKCommand
   */
  @PutMapping("/assignT3")
  public void assignT3(@RequestBody AssignT3ToPssSKCommand command) {
    try {
      PssSKBusinessDelegate.getPssSKInstance().assignT3(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T3", exc);
    }
  }

  /**
   * unassign T3 on PssSK
   *
   * @param command UnAssignT3FromPssSKCommand
   */
  @PutMapping("/unAssignT3")
  public void unAssignT3(@RequestBody(required = true) UnAssignT3FromPssSKCommand command) {
    try {
      PssSKBusinessDelegate.getPssSKInstance().unAssignT3(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T3", exc);
    }
  }

  /**
   * save T4 on PssSK
   *
   * @param command AssignT4ToPssSKCommand
   */
  @PutMapping("/assignT4")
  public void assignT4(@RequestBody AssignT4ToPssSKCommand command) {
    try {
      PssSKBusinessDelegate.getPssSKInstance().assignT4(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T4", exc);
    }
  }

  /**
   * unassign T4 on PssSK
   *
   * @param command UnAssignT4FromPssSKCommand
   */
  @PutMapping("/unAssignT4")
  public void unAssignT4(@RequestBody(required = true) UnAssignT4FromPssSKCommand command) {
    try {
      PssSKBusinessDelegate.getPssSKInstance().unAssignT4(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T4", exc);
    }
  }

  /**
   * save T5 on PssSK
   *
   * @param command AssignT5ToPssSKCommand
   */
  @PutMapping("/assignT5")
  public void assignT5(@RequestBody AssignT5ToPssSKCommand command) {
    try {
      PssSKBusinessDelegate.getPssSKInstance().assignT5(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T5", exc);
    }
  }

  /**
   * unassign T5 on PssSK
   *
   * @param command UnAssignT5FromPssSKCommand
   */
  @PutMapping("/unAssignT5")
  public void unAssignT5(@RequestBody(required = true) UnAssignT5FromPssSKCommand command) {
    try {
      PssSKBusinessDelegate.getPssSKInstance().unAssignT5(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T5", exc);
    }
  }

  /**
   * save T6 on PssSK
   *
   * @param command AssignT6ToPssSKCommand
   */
  @PutMapping("/assignT6")
  public void assignT6(@RequestBody AssignT6ToPssSKCommand command) {
    try {
      PssSKBusinessDelegate.getPssSKInstance().assignT6(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T6", exc);
    }
  }

  /**
   * unassign T6 on PssSK
   *
   * @param command UnAssignT6FromPssSKCommand
   */
  @PutMapping("/unAssignT6")
  public void unAssignT6(@RequestBody(required = true) UnAssignT6FromPssSKCommand command) {
    try {
      PssSKBusinessDelegate.getPssSKInstance().unAssignT6(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T6", exc);
    }
  }

  /**
   * save Vsmax on PssSK
   *
   * @param command AssignVsmaxToPssSKCommand
   */
  @PutMapping("/assignVsmax")
  public void assignVsmax(@RequestBody AssignVsmaxToPssSKCommand command) {
    try {
      PssSKBusinessDelegate.getPssSKInstance().assignVsmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vsmax", exc);
    }
  }

  /**
   * unassign Vsmax on PssSK
   *
   * @param command UnAssignVsmaxFromPssSKCommand
   */
  @PutMapping("/unAssignVsmax")
  public void unAssignVsmax(@RequestBody(required = true) UnAssignVsmaxFromPssSKCommand command) {
    try {
      PssSKBusinessDelegate.getPssSKInstance().unAssignVsmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vsmax", exc);
    }
  }

  /**
   * save Vsmin on PssSK
   *
   * @param command AssignVsminToPssSKCommand
   */
  @PutMapping("/assignVsmin")
  public void assignVsmin(@RequestBody AssignVsminToPssSKCommand command) {
    try {
      PssSKBusinessDelegate.getPssSKInstance().assignVsmin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vsmin", exc);
    }
  }

  /**
   * unassign Vsmin on PssSK
   *
   * @param command UnAssignVsminFromPssSKCommand
   */
  @PutMapping("/unAssignVsmin")
  public void unAssignVsmin(@RequestBody(required = true) UnAssignVsminFromPssSKCommand command) {
    try {
      PssSKBusinessDelegate.getPssSKInstance().unAssignVsmin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vsmin", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected PssSK pssSK = null;
  private static final Logger LOGGER = Logger.getLogger(PssSKCommandRestController.class.getName());
}
