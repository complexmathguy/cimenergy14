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
 * Implements Spring Controller command CQRS processing for entity LoadComposite.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/LoadComposite")
public class LoadCompositeCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a LoadComposite. if not key provided, calls create, otherwise calls save
   *
   * @param LoadComposite loadComposite
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateLoadCompositeCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          LoadCompositeBusinessDelegate.getLoadCompositeInstance().createLoadComposite(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a LoadComposite. if no key provided, calls create, otherwise calls save
   *
   * @param LoadComposite loadComposite
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateLoadCompositeCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateLoadCompositeCommand
      // -----------------------------------------------
      completableFuture =
          LoadCompositeBusinessDelegate.getLoadCompositeInstance().updateLoadComposite(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "LoadCompositeController:update() - successfully update LoadComposite - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a LoadComposite entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID loadCompositeId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteLoadCompositeCommand command = new DeleteLoadCompositeCommand(loadCompositeId);

    try {
      LoadCompositeBusinessDelegate delegate =
          LoadCompositeBusinessDelegate.getLoadCompositeInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted LoadComposite with key " + command.getLoadCompositeId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Epfd on LoadComposite
   *
   * @param command AssignEpfdToLoadCompositeCommand
   */
  @PutMapping("/assignEpfd")
  public void assignEpfd(@RequestBody AssignEpfdToLoadCompositeCommand command) {
    try {
      LoadCompositeBusinessDelegate.getLoadCompositeInstance().assignEpfd(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Epfd", exc);
    }
  }

  /**
   * unassign Epfd on LoadComposite
   *
   * @param command UnAssignEpfdFromLoadCompositeCommand
   */
  @PutMapping("/unAssignEpfd")
  public void unAssignEpfd(
      @RequestBody(required = true) UnAssignEpfdFromLoadCompositeCommand command) {
    try {
      LoadCompositeBusinessDelegate.getLoadCompositeInstance().unAssignEpfd(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Epfd", exc);
    }
  }

  /**
   * save Epfs on LoadComposite
   *
   * @param command AssignEpfsToLoadCompositeCommand
   */
  @PutMapping("/assignEpfs")
  public void assignEpfs(@RequestBody AssignEpfsToLoadCompositeCommand command) {
    try {
      LoadCompositeBusinessDelegate.getLoadCompositeInstance().assignEpfs(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Epfs", exc);
    }
  }

  /**
   * unassign Epfs on LoadComposite
   *
   * @param command UnAssignEpfsFromLoadCompositeCommand
   */
  @PutMapping("/unAssignEpfs")
  public void unAssignEpfs(
      @RequestBody(required = true) UnAssignEpfsFromLoadCompositeCommand command) {
    try {
      LoadCompositeBusinessDelegate.getLoadCompositeInstance().unAssignEpfs(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Epfs", exc);
    }
  }

  /**
   * save Epvd on LoadComposite
   *
   * @param command AssignEpvdToLoadCompositeCommand
   */
  @PutMapping("/assignEpvd")
  public void assignEpvd(@RequestBody AssignEpvdToLoadCompositeCommand command) {
    try {
      LoadCompositeBusinessDelegate.getLoadCompositeInstance().assignEpvd(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Epvd", exc);
    }
  }

  /**
   * unassign Epvd on LoadComposite
   *
   * @param command UnAssignEpvdFromLoadCompositeCommand
   */
  @PutMapping("/unAssignEpvd")
  public void unAssignEpvd(
      @RequestBody(required = true) UnAssignEpvdFromLoadCompositeCommand command) {
    try {
      LoadCompositeBusinessDelegate.getLoadCompositeInstance().unAssignEpvd(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Epvd", exc);
    }
  }

  /**
   * save Epvs on LoadComposite
   *
   * @param command AssignEpvsToLoadCompositeCommand
   */
  @PutMapping("/assignEpvs")
  public void assignEpvs(@RequestBody AssignEpvsToLoadCompositeCommand command) {
    try {
      LoadCompositeBusinessDelegate.getLoadCompositeInstance().assignEpvs(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Epvs", exc);
    }
  }

  /**
   * unassign Epvs on LoadComposite
   *
   * @param command UnAssignEpvsFromLoadCompositeCommand
   */
  @PutMapping("/unAssignEpvs")
  public void unAssignEpvs(
      @RequestBody(required = true) UnAssignEpvsFromLoadCompositeCommand command) {
    try {
      LoadCompositeBusinessDelegate.getLoadCompositeInstance().unAssignEpvs(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Epvs", exc);
    }
  }

  /**
   * save Eqfd on LoadComposite
   *
   * @param command AssignEqfdToLoadCompositeCommand
   */
  @PutMapping("/assignEqfd")
  public void assignEqfd(@RequestBody AssignEqfdToLoadCompositeCommand command) {
    try {
      LoadCompositeBusinessDelegate.getLoadCompositeInstance().assignEqfd(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Eqfd", exc);
    }
  }

  /**
   * unassign Eqfd on LoadComposite
   *
   * @param command UnAssignEqfdFromLoadCompositeCommand
   */
  @PutMapping("/unAssignEqfd")
  public void unAssignEqfd(
      @RequestBody(required = true) UnAssignEqfdFromLoadCompositeCommand command) {
    try {
      LoadCompositeBusinessDelegate.getLoadCompositeInstance().unAssignEqfd(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Eqfd", exc);
    }
  }

  /**
   * save Eqfs on LoadComposite
   *
   * @param command AssignEqfsToLoadCompositeCommand
   */
  @PutMapping("/assignEqfs")
  public void assignEqfs(@RequestBody AssignEqfsToLoadCompositeCommand command) {
    try {
      LoadCompositeBusinessDelegate.getLoadCompositeInstance().assignEqfs(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Eqfs", exc);
    }
  }

  /**
   * unassign Eqfs on LoadComposite
   *
   * @param command UnAssignEqfsFromLoadCompositeCommand
   */
  @PutMapping("/unAssignEqfs")
  public void unAssignEqfs(
      @RequestBody(required = true) UnAssignEqfsFromLoadCompositeCommand command) {
    try {
      LoadCompositeBusinessDelegate.getLoadCompositeInstance().unAssignEqfs(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Eqfs", exc);
    }
  }

  /**
   * save Eqvd on LoadComposite
   *
   * @param command AssignEqvdToLoadCompositeCommand
   */
  @PutMapping("/assignEqvd")
  public void assignEqvd(@RequestBody AssignEqvdToLoadCompositeCommand command) {
    try {
      LoadCompositeBusinessDelegate.getLoadCompositeInstance().assignEqvd(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Eqvd", exc);
    }
  }

  /**
   * unassign Eqvd on LoadComposite
   *
   * @param command UnAssignEqvdFromLoadCompositeCommand
   */
  @PutMapping("/unAssignEqvd")
  public void unAssignEqvd(
      @RequestBody(required = true) UnAssignEqvdFromLoadCompositeCommand command) {
    try {
      LoadCompositeBusinessDelegate.getLoadCompositeInstance().unAssignEqvd(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Eqvd", exc);
    }
  }

  /**
   * save Eqvs on LoadComposite
   *
   * @param command AssignEqvsToLoadCompositeCommand
   */
  @PutMapping("/assignEqvs")
  public void assignEqvs(@RequestBody AssignEqvsToLoadCompositeCommand command) {
    try {
      LoadCompositeBusinessDelegate.getLoadCompositeInstance().assignEqvs(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Eqvs", exc);
    }
  }

  /**
   * unassign Eqvs on LoadComposite
   *
   * @param command UnAssignEqvsFromLoadCompositeCommand
   */
  @PutMapping("/unAssignEqvs")
  public void unAssignEqvs(
      @RequestBody(required = true) UnAssignEqvsFromLoadCompositeCommand command) {
    try {
      LoadCompositeBusinessDelegate.getLoadCompositeInstance().unAssignEqvs(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Eqvs", exc);
    }
  }

  /**
   * save H on LoadComposite
   *
   * @param command AssignHToLoadCompositeCommand
   */
  @PutMapping("/assignH")
  public void assignH(@RequestBody AssignHToLoadCompositeCommand command) {
    try {
      LoadCompositeBusinessDelegate.getLoadCompositeInstance().assignH(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign H", exc);
    }
  }

  /**
   * unassign H on LoadComposite
   *
   * @param command UnAssignHFromLoadCompositeCommand
   */
  @PutMapping("/unAssignH")
  public void unAssignH(@RequestBody(required = true) UnAssignHFromLoadCompositeCommand command) {
    try {
      LoadCompositeBusinessDelegate.getLoadCompositeInstance().unAssignH(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign H", exc);
    }
  }

  /**
   * save Lfrac on LoadComposite
   *
   * @param command AssignLfracToLoadCompositeCommand
   */
  @PutMapping("/assignLfrac")
  public void assignLfrac(@RequestBody AssignLfracToLoadCompositeCommand command) {
    try {
      LoadCompositeBusinessDelegate.getLoadCompositeInstance().assignLfrac(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Lfrac", exc);
    }
  }

  /**
   * unassign Lfrac on LoadComposite
   *
   * @param command UnAssignLfracFromLoadCompositeCommand
   */
  @PutMapping("/unAssignLfrac")
  public void unAssignLfrac(
      @RequestBody(required = true) UnAssignLfracFromLoadCompositeCommand command) {
    try {
      LoadCompositeBusinessDelegate.getLoadCompositeInstance().unAssignLfrac(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Lfrac", exc);
    }
  }

  /**
   * save Pfrac on LoadComposite
   *
   * @param command AssignPfracToLoadCompositeCommand
   */
  @PutMapping("/assignPfrac")
  public void assignPfrac(@RequestBody AssignPfracToLoadCompositeCommand command) {
    try {
      LoadCompositeBusinessDelegate.getLoadCompositeInstance().assignPfrac(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Pfrac", exc);
    }
  }

  /**
   * unassign Pfrac on LoadComposite
   *
   * @param command UnAssignPfracFromLoadCompositeCommand
   */
  @PutMapping("/unAssignPfrac")
  public void unAssignPfrac(
      @RequestBody(required = true) UnAssignPfracFromLoadCompositeCommand command) {
    try {
      LoadCompositeBusinessDelegate.getLoadCompositeInstance().unAssignPfrac(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Pfrac", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected LoadComposite loadComposite = null;
  private static final Logger LOGGER =
      Logger.getLogger(LoadCompositeCommandRestController.class.getName());
}
