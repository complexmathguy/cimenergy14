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
 * Implements Spring Controller command CQRS processing for entity ExcSK.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcSK")
public class ExcSKCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a ExcSK. if not key provided, calls create, otherwise calls save
   *
   * @param ExcSK excSK
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(@RequestBody(required = true) CreateExcSKCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture = ExcSKBusinessDelegate.getExcSKInstance().createExcSK(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a ExcSK. if no key provided, calls create, otherwise calls save
   *
   * @param ExcSK excSK
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(@RequestBody(required = true) UpdateExcSKCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateExcSKCommand
      // -----------------------------------------------
      completableFuture = ExcSKBusinessDelegate.getExcSKInstance().updateExcSK(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "ExcSKController:update() - successfully update ExcSK - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a ExcSK entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID excSKId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteExcSKCommand command = new DeleteExcSKCommand(excSKId);

    try {
      ExcSKBusinessDelegate delegate = ExcSKBusinessDelegate.getExcSKInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(Level.WARNING, "Successfully deleted ExcSK with key " + command.getExcSKId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Efdmax on ExcSK
   *
   * @param command AssignEfdmaxToExcSKCommand
   */
  @PutMapping("/assignEfdmax")
  public void assignEfdmax(@RequestBody AssignEfdmaxToExcSKCommand command) {
    try {
      ExcSKBusinessDelegate.getExcSKInstance().assignEfdmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Efdmax", exc);
    }
  }

  /**
   * unassign Efdmax on ExcSK
   *
   * @param command UnAssignEfdmaxFromExcSKCommand
   */
  @PutMapping("/unAssignEfdmax")
  public void unAssignEfdmax(@RequestBody(required = true) UnAssignEfdmaxFromExcSKCommand command) {
    try {
      ExcSKBusinessDelegate.getExcSKInstance().unAssignEfdmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Efdmax", exc);
    }
  }

  /**
   * save Efdmin on ExcSK
   *
   * @param command AssignEfdminToExcSKCommand
   */
  @PutMapping("/assignEfdmin")
  public void assignEfdmin(@RequestBody AssignEfdminToExcSKCommand command) {
    try {
      ExcSKBusinessDelegate.getExcSKInstance().assignEfdmin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Efdmin", exc);
    }
  }

  /**
   * unassign Efdmin on ExcSK
   *
   * @param command UnAssignEfdminFromExcSKCommand
   */
  @PutMapping("/unAssignEfdmin")
  public void unAssignEfdmin(@RequestBody(required = true) UnAssignEfdminFromExcSKCommand command) {
    try {
      ExcSKBusinessDelegate.getExcSKInstance().unAssignEfdmin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Efdmin", exc);
    }
  }

  /**
   * save Emax on ExcSK
   *
   * @param command AssignEmaxToExcSKCommand
   */
  @PutMapping("/assignEmax")
  public void assignEmax(@RequestBody AssignEmaxToExcSKCommand command) {
    try {
      ExcSKBusinessDelegate.getExcSKInstance().assignEmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Emax", exc);
    }
  }

  /**
   * unassign Emax on ExcSK
   *
   * @param command UnAssignEmaxFromExcSKCommand
   */
  @PutMapping("/unAssignEmax")
  public void unAssignEmax(@RequestBody(required = true) UnAssignEmaxFromExcSKCommand command) {
    try {
      ExcSKBusinessDelegate.getExcSKInstance().unAssignEmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Emax", exc);
    }
  }

  /**
   * save Emin on ExcSK
   *
   * @param command AssignEminToExcSKCommand
   */
  @PutMapping("/assignEmin")
  public void assignEmin(@RequestBody AssignEminToExcSKCommand command) {
    try {
      ExcSKBusinessDelegate.getExcSKInstance().assignEmin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Emin", exc);
    }
  }

  /**
   * unassign Emin on ExcSK
   *
   * @param command UnAssignEminFromExcSKCommand
   */
  @PutMapping("/unAssignEmin")
  public void unAssignEmin(@RequestBody(required = true) UnAssignEminFromExcSKCommand command) {
    try {
      ExcSKBusinessDelegate.getExcSKInstance().unAssignEmin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Emin", exc);
    }
  }

  /**
   * save K on ExcSK
   *
   * @param command AssignKToExcSKCommand
   */
  @PutMapping("/assignK")
  public void assignK(@RequestBody AssignKToExcSKCommand command) {
    try {
      ExcSKBusinessDelegate.getExcSKInstance().assignK(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign K", exc);
    }
  }

  /**
   * unassign K on ExcSK
   *
   * @param command UnAssignKFromExcSKCommand
   */
  @PutMapping("/unAssignK")
  public void unAssignK(@RequestBody(required = true) UnAssignKFromExcSKCommand command) {
    try {
      ExcSKBusinessDelegate.getExcSKInstance().unAssignK(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign K", exc);
    }
  }

  /**
   * save K1 on ExcSK
   *
   * @param command AssignK1ToExcSKCommand
   */
  @PutMapping("/assignK1")
  public void assignK1(@RequestBody AssignK1ToExcSKCommand command) {
    try {
      ExcSKBusinessDelegate.getExcSKInstance().assignK1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign K1", exc);
    }
  }

  /**
   * unassign K1 on ExcSK
   *
   * @param command UnAssignK1FromExcSKCommand
   */
  @PutMapping("/unAssignK1")
  public void unAssignK1(@RequestBody(required = true) UnAssignK1FromExcSKCommand command) {
    try {
      ExcSKBusinessDelegate.getExcSKInstance().unAssignK1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign K1", exc);
    }
  }

  /**
   * save K2 on ExcSK
   *
   * @param command AssignK2ToExcSKCommand
   */
  @PutMapping("/assignK2")
  public void assignK2(@RequestBody AssignK2ToExcSKCommand command) {
    try {
      ExcSKBusinessDelegate.getExcSKInstance().assignK2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign K2", exc);
    }
  }

  /**
   * unassign K2 on ExcSK
   *
   * @param command UnAssignK2FromExcSKCommand
   */
  @PutMapping("/unAssignK2")
  public void unAssignK2(@RequestBody(required = true) UnAssignK2FromExcSKCommand command) {
    try {
      ExcSKBusinessDelegate.getExcSKInstance().unAssignK2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign K2", exc);
    }
  }

  /**
   * save Kc on ExcSK
   *
   * @param command AssignKcToExcSKCommand
   */
  @PutMapping("/assignKc")
  public void assignKc(@RequestBody AssignKcToExcSKCommand command) {
    try {
      ExcSKBusinessDelegate.getExcSKInstance().assignKc(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kc", exc);
    }
  }

  /**
   * unassign Kc on ExcSK
   *
   * @param command UnAssignKcFromExcSKCommand
   */
  @PutMapping("/unAssignKc")
  public void unAssignKc(@RequestBody(required = true) UnAssignKcFromExcSKCommand command) {
    try {
      ExcSKBusinessDelegate.getExcSKInstance().unAssignKc(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kc", exc);
    }
  }

  /**
   * save Kce on ExcSK
   *
   * @param command AssignKceToExcSKCommand
   */
  @PutMapping("/assignKce")
  public void assignKce(@RequestBody AssignKceToExcSKCommand command) {
    try {
      ExcSKBusinessDelegate.getExcSKInstance().assignKce(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kce", exc);
    }
  }

  /**
   * unassign Kce on ExcSK
   *
   * @param command UnAssignKceFromExcSKCommand
   */
  @PutMapping("/unAssignKce")
  public void unAssignKce(@RequestBody(required = true) UnAssignKceFromExcSKCommand command) {
    try {
      ExcSKBusinessDelegate.getExcSKInstance().unAssignKce(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kce", exc);
    }
  }

  /**
   * save Kd on ExcSK
   *
   * @param command AssignKdToExcSKCommand
   */
  @PutMapping("/assignKd")
  public void assignKd(@RequestBody AssignKdToExcSKCommand command) {
    try {
      ExcSKBusinessDelegate.getExcSKInstance().assignKd(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kd", exc);
    }
  }

  /**
   * unassign Kd on ExcSK
   *
   * @param command UnAssignKdFromExcSKCommand
   */
  @PutMapping("/unAssignKd")
  public void unAssignKd(@RequestBody(required = true) UnAssignKdFromExcSKCommand command) {
    try {
      ExcSKBusinessDelegate.getExcSKInstance().unAssignKd(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kd", exc);
    }
  }

  /**
   * save Kgob on ExcSK
   *
   * @param command AssignKgobToExcSKCommand
   */
  @PutMapping("/assignKgob")
  public void assignKgob(@RequestBody AssignKgobToExcSKCommand command) {
    try {
      ExcSKBusinessDelegate.getExcSKInstance().assignKgob(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kgob", exc);
    }
  }

  /**
   * unassign Kgob on ExcSK
   *
   * @param command UnAssignKgobFromExcSKCommand
   */
  @PutMapping("/unAssignKgob")
  public void unAssignKgob(@RequestBody(required = true) UnAssignKgobFromExcSKCommand command) {
    try {
      ExcSKBusinessDelegate.getExcSKInstance().unAssignKgob(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kgob", exc);
    }
  }

  /**
   * save Kp on ExcSK
   *
   * @param command AssignKpToExcSKCommand
   */
  @PutMapping("/assignKp")
  public void assignKp(@RequestBody AssignKpToExcSKCommand command) {
    try {
      ExcSKBusinessDelegate.getExcSKInstance().assignKp(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kp", exc);
    }
  }

  /**
   * unassign Kp on ExcSK
   *
   * @param command UnAssignKpFromExcSKCommand
   */
  @PutMapping("/unAssignKp")
  public void unAssignKp(@RequestBody(required = true) UnAssignKpFromExcSKCommand command) {
    try {
      ExcSKBusinessDelegate.getExcSKInstance().unAssignKp(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kp", exc);
    }
  }

  /**
   * save Kqi on ExcSK
   *
   * @param command AssignKqiToExcSKCommand
   */
  @PutMapping("/assignKqi")
  public void assignKqi(@RequestBody AssignKqiToExcSKCommand command) {
    try {
      ExcSKBusinessDelegate.getExcSKInstance().assignKqi(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kqi", exc);
    }
  }

  /**
   * unassign Kqi on ExcSK
   *
   * @param command UnAssignKqiFromExcSKCommand
   */
  @PutMapping("/unAssignKqi")
  public void unAssignKqi(@RequestBody(required = true) UnAssignKqiFromExcSKCommand command) {
    try {
      ExcSKBusinessDelegate.getExcSKInstance().unAssignKqi(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kqi", exc);
    }
  }

  /**
   * save Kqob on ExcSK
   *
   * @param command AssignKqobToExcSKCommand
   */
  @PutMapping("/assignKqob")
  public void assignKqob(@RequestBody AssignKqobToExcSKCommand command) {
    try {
      ExcSKBusinessDelegate.getExcSKInstance().assignKqob(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kqob", exc);
    }
  }

  /**
   * unassign Kqob on ExcSK
   *
   * @param command UnAssignKqobFromExcSKCommand
   */
  @PutMapping("/unAssignKqob")
  public void unAssignKqob(@RequestBody(required = true) UnAssignKqobFromExcSKCommand command) {
    try {
      ExcSKBusinessDelegate.getExcSKInstance().unAssignKqob(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kqob", exc);
    }
  }

  /**
   * save Kqp on ExcSK
   *
   * @param command AssignKqpToExcSKCommand
   */
  @PutMapping("/assignKqp")
  public void assignKqp(@RequestBody AssignKqpToExcSKCommand command) {
    try {
      ExcSKBusinessDelegate.getExcSKInstance().assignKqp(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kqp", exc);
    }
  }

  /**
   * unassign Kqp on ExcSK
   *
   * @param command UnAssignKqpFromExcSKCommand
   */
  @PutMapping("/unAssignKqp")
  public void unAssignKqp(@RequestBody(required = true) UnAssignKqpFromExcSKCommand command) {
    try {
      ExcSKBusinessDelegate.getExcSKInstance().unAssignKqp(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kqp", exc);
    }
  }

  /**
   * save Nq on ExcSK
   *
   * @param command AssignNqToExcSKCommand
   */
  @PutMapping("/assignNq")
  public void assignNq(@RequestBody AssignNqToExcSKCommand command) {
    try {
      ExcSKBusinessDelegate.getExcSKInstance().assignNq(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Nq", exc);
    }
  }

  /**
   * unassign Nq on ExcSK
   *
   * @param command UnAssignNqFromExcSKCommand
   */
  @PutMapping("/unAssignNq")
  public void unAssignNq(@RequestBody(required = true) UnAssignNqFromExcSKCommand command) {
    try {
      ExcSKBusinessDelegate.getExcSKInstance().unAssignNq(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Nq", exc);
    }
  }

  /**
   * save Qconoff on ExcSK
   *
   * @param command AssignQconoffToExcSKCommand
   */
  @PutMapping("/assignQconoff")
  public void assignQconoff(@RequestBody AssignQconoffToExcSKCommand command) {
    try {
      ExcSKBusinessDelegate.getExcSKInstance().assignQconoff(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Qconoff", exc);
    }
  }

  /**
   * unassign Qconoff on ExcSK
   *
   * @param command UnAssignQconoffFromExcSKCommand
   */
  @PutMapping("/unAssignQconoff")
  public void unAssignQconoff(
      @RequestBody(required = true) UnAssignQconoffFromExcSKCommand command) {
    try {
      ExcSKBusinessDelegate.getExcSKInstance().unAssignQconoff(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Qconoff", exc);
    }
  }

  /**
   * save Qz on ExcSK
   *
   * @param command AssignQzToExcSKCommand
   */
  @PutMapping("/assignQz")
  public void assignQz(@RequestBody AssignQzToExcSKCommand command) {
    try {
      ExcSKBusinessDelegate.getExcSKInstance().assignQz(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Qz", exc);
    }
  }

  /**
   * unassign Qz on ExcSK
   *
   * @param command UnAssignQzFromExcSKCommand
   */
  @PutMapping("/unAssignQz")
  public void unAssignQz(@RequestBody(required = true) UnAssignQzFromExcSKCommand command) {
    try {
      ExcSKBusinessDelegate.getExcSKInstance().unAssignQz(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Qz", exc);
    }
  }

  /**
   * save Remote on ExcSK
   *
   * @param command AssignRemoteToExcSKCommand
   */
  @PutMapping("/assignRemote")
  public void assignRemote(@RequestBody AssignRemoteToExcSKCommand command) {
    try {
      ExcSKBusinessDelegate.getExcSKInstance().assignRemote(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Remote", exc);
    }
  }

  /**
   * unassign Remote on ExcSK
   *
   * @param command UnAssignRemoteFromExcSKCommand
   */
  @PutMapping("/unAssignRemote")
  public void unAssignRemote(@RequestBody(required = true) UnAssignRemoteFromExcSKCommand command) {
    try {
      ExcSKBusinessDelegate.getExcSKInstance().unAssignRemote(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Remote", exc);
    }
  }

  /**
   * save Sbase on ExcSK
   *
   * @param command AssignSbaseToExcSKCommand
   */
  @PutMapping("/assignSbase")
  public void assignSbase(@RequestBody AssignSbaseToExcSKCommand command) {
    try {
      ExcSKBusinessDelegate.getExcSKInstance().assignSbase(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Sbase", exc);
    }
  }

  /**
   * unassign Sbase on ExcSK
   *
   * @param command UnAssignSbaseFromExcSKCommand
   */
  @PutMapping("/unAssignSbase")
  public void unAssignSbase(@RequestBody(required = true) UnAssignSbaseFromExcSKCommand command) {
    try {
      ExcSKBusinessDelegate.getExcSKInstance().unAssignSbase(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Sbase", exc);
    }
  }

  /**
   * save Tc on ExcSK
   *
   * @param command AssignTcToExcSKCommand
   */
  @PutMapping("/assignTc")
  public void assignTc(@RequestBody AssignTcToExcSKCommand command) {
    try {
      ExcSKBusinessDelegate.getExcSKInstance().assignTc(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tc", exc);
    }
  }

  /**
   * unassign Tc on ExcSK
   *
   * @param command UnAssignTcFromExcSKCommand
   */
  @PutMapping("/unAssignTc")
  public void unAssignTc(@RequestBody(required = true) UnAssignTcFromExcSKCommand command) {
    try {
      ExcSKBusinessDelegate.getExcSKInstance().unAssignTc(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tc", exc);
    }
  }

  /**
   * save Te on ExcSK
   *
   * @param command AssignTeToExcSKCommand
   */
  @PutMapping("/assignTe")
  public void assignTe(@RequestBody AssignTeToExcSKCommand command) {
    try {
      ExcSKBusinessDelegate.getExcSKInstance().assignTe(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Te", exc);
    }
  }

  /**
   * unassign Te on ExcSK
   *
   * @param command UnAssignTeFromExcSKCommand
   */
  @PutMapping("/unAssignTe")
  public void unAssignTe(@RequestBody(required = true) UnAssignTeFromExcSKCommand command) {
    try {
      ExcSKBusinessDelegate.getExcSKInstance().unAssignTe(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Te", exc);
    }
  }

  /**
   * save Ti on ExcSK
   *
   * @param command AssignTiToExcSKCommand
   */
  @PutMapping("/assignTi")
  public void assignTi(@RequestBody AssignTiToExcSKCommand command) {
    try {
      ExcSKBusinessDelegate.getExcSKInstance().assignTi(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ti", exc);
    }
  }

  /**
   * unassign Ti on ExcSK
   *
   * @param command UnAssignTiFromExcSKCommand
   */
  @PutMapping("/unAssignTi")
  public void unAssignTi(@RequestBody(required = true) UnAssignTiFromExcSKCommand command) {
    try {
      ExcSKBusinessDelegate.getExcSKInstance().unAssignTi(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ti", exc);
    }
  }

  /**
   * save Tp on ExcSK
   *
   * @param command AssignTpToExcSKCommand
   */
  @PutMapping("/assignTp")
  public void assignTp(@RequestBody AssignTpToExcSKCommand command) {
    try {
      ExcSKBusinessDelegate.getExcSKInstance().assignTp(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tp", exc);
    }
  }

  /**
   * unassign Tp on ExcSK
   *
   * @param command UnAssignTpFromExcSKCommand
   */
  @PutMapping("/unAssignTp")
  public void unAssignTp(@RequestBody(required = true) UnAssignTpFromExcSKCommand command) {
    try {
      ExcSKBusinessDelegate.getExcSKInstance().unAssignTp(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tp", exc);
    }
  }

  /**
   * save Tr on ExcSK
   *
   * @param command AssignTrToExcSKCommand
   */
  @PutMapping("/assignTr")
  public void assignTr(@RequestBody AssignTrToExcSKCommand command) {
    try {
      ExcSKBusinessDelegate.getExcSKInstance().assignTr(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tr", exc);
    }
  }

  /**
   * unassign Tr on ExcSK
   *
   * @param command UnAssignTrFromExcSKCommand
   */
  @PutMapping("/unAssignTr")
  public void unAssignTr(@RequestBody(required = true) UnAssignTrFromExcSKCommand command) {
    try {
      ExcSKBusinessDelegate.getExcSKInstance().unAssignTr(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tr", exc);
    }
  }

  /**
   * save Uimax on ExcSK
   *
   * @param command AssignUimaxToExcSKCommand
   */
  @PutMapping("/assignUimax")
  public void assignUimax(@RequestBody AssignUimaxToExcSKCommand command) {
    try {
      ExcSKBusinessDelegate.getExcSKInstance().assignUimax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Uimax", exc);
    }
  }

  /**
   * unassign Uimax on ExcSK
   *
   * @param command UnAssignUimaxFromExcSKCommand
   */
  @PutMapping("/unAssignUimax")
  public void unAssignUimax(@RequestBody(required = true) UnAssignUimaxFromExcSKCommand command) {
    try {
      ExcSKBusinessDelegate.getExcSKInstance().unAssignUimax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Uimax", exc);
    }
  }

  /**
   * save Uimin on ExcSK
   *
   * @param command AssignUiminToExcSKCommand
   */
  @PutMapping("/assignUimin")
  public void assignUimin(@RequestBody AssignUiminToExcSKCommand command) {
    try {
      ExcSKBusinessDelegate.getExcSKInstance().assignUimin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Uimin", exc);
    }
  }

  /**
   * unassign Uimin on ExcSK
   *
   * @param command UnAssignUiminFromExcSKCommand
   */
  @PutMapping("/unAssignUimin")
  public void unAssignUimin(@RequestBody(required = true) UnAssignUiminFromExcSKCommand command) {
    try {
      ExcSKBusinessDelegate.getExcSKInstance().unAssignUimin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Uimin", exc);
    }
  }

  /**
   * save Urmax on ExcSK
   *
   * @param command AssignUrmaxToExcSKCommand
   */
  @PutMapping("/assignUrmax")
  public void assignUrmax(@RequestBody AssignUrmaxToExcSKCommand command) {
    try {
      ExcSKBusinessDelegate.getExcSKInstance().assignUrmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Urmax", exc);
    }
  }

  /**
   * unassign Urmax on ExcSK
   *
   * @param command UnAssignUrmaxFromExcSKCommand
   */
  @PutMapping("/unAssignUrmax")
  public void unAssignUrmax(@RequestBody(required = true) UnAssignUrmaxFromExcSKCommand command) {
    try {
      ExcSKBusinessDelegate.getExcSKInstance().unAssignUrmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Urmax", exc);
    }
  }

  /**
   * save Urmin on ExcSK
   *
   * @param command AssignUrminToExcSKCommand
   */
  @PutMapping("/assignUrmin")
  public void assignUrmin(@RequestBody AssignUrminToExcSKCommand command) {
    try {
      ExcSKBusinessDelegate.getExcSKInstance().assignUrmin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Urmin", exc);
    }
  }

  /**
   * unassign Urmin on ExcSK
   *
   * @param command UnAssignUrminFromExcSKCommand
   */
  @PutMapping("/unAssignUrmin")
  public void unAssignUrmin(@RequestBody(required = true) UnAssignUrminFromExcSKCommand command) {
    try {
      ExcSKBusinessDelegate.getExcSKInstance().unAssignUrmin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Urmin", exc);
    }
  }

  /**
   * save Vtmax on ExcSK
   *
   * @param command AssignVtmaxToExcSKCommand
   */
  @PutMapping("/assignVtmax")
  public void assignVtmax(@RequestBody AssignVtmaxToExcSKCommand command) {
    try {
      ExcSKBusinessDelegate.getExcSKInstance().assignVtmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vtmax", exc);
    }
  }

  /**
   * unassign Vtmax on ExcSK
   *
   * @param command UnAssignVtmaxFromExcSKCommand
   */
  @PutMapping("/unAssignVtmax")
  public void unAssignVtmax(@RequestBody(required = true) UnAssignVtmaxFromExcSKCommand command) {
    try {
      ExcSKBusinessDelegate.getExcSKInstance().unAssignVtmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vtmax", exc);
    }
  }

  /**
   * save Vtmin on ExcSK
   *
   * @param command AssignVtminToExcSKCommand
   */
  @PutMapping("/assignVtmin")
  public void assignVtmin(@RequestBody AssignVtminToExcSKCommand command) {
    try {
      ExcSKBusinessDelegate.getExcSKInstance().assignVtmin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vtmin", exc);
    }
  }

  /**
   * unassign Vtmin on ExcSK
   *
   * @param command UnAssignVtminFromExcSKCommand
   */
  @PutMapping("/unAssignVtmin")
  public void unAssignVtmin(@RequestBody(required = true) UnAssignVtminFromExcSKCommand command) {
    try {
      ExcSKBusinessDelegate.getExcSKInstance().unAssignVtmin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vtmin", exc);
    }
  }

  /**
   * save Yp on ExcSK
   *
   * @param command AssignYpToExcSKCommand
   */
  @PutMapping("/assignYp")
  public void assignYp(@RequestBody AssignYpToExcSKCommand command) {
    try {
      ExcSKBusinessDelegate.getExcSKInstance().assignYp(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Yp", exc);
    }
  }

  /**
   * unassign Yp on ExcSK
   *
   * @param command UnAssignYpFromExcSKCommand
   */
  @PutMapping("/unAssignYp")
  public void unAssignYp(@RequestBody(required = true) UnAssignYpFromExcSKCommand command) {
    try {
      ExcSKBusinessDelegate.getExcSKInstance().unAssignYp(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Yp", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected ExcSK excSK = null;
  private static final Logger LOGGER = Logger.getLogger(ExcSKCommandRestController.class.getName());
}
