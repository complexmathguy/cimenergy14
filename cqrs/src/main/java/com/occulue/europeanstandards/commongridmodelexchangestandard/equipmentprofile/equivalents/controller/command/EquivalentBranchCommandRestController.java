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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.equivalents.controller.command;

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
 * Implements Spring Controller command CQRS processing for entity EquivalentBranch.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/EquivalentBranch")
public class EquivalentBranchCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a EquivalentBranch. if not key provided, calls create, otherwise calls save
   *
   * @param EquivalentBranch equivalentBranch
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateEquivalentBranchCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          EquivalentBranchBusinessDelegate.getEquivalentBranchInstance()
              .createEquivalentBranch(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a EquivalentBranch. if no key provided, calls create, otherwise calls save
   *
   * @param EquivalentBranch equivalentBranch
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateEquivalentBranchCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateEquivalentBranchCommand
      // -----------------------------------------------
      completableFuture =
          EquivalentBranchBusinessDelegate.getEquivalentBranchInstance()
              .updateEquivalentBranch(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "EquivalentBranchController:update() - successfully update EquivalentBranch - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a EquivalentBranch entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID equivalentBranchId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteEquivalentBranchCommand command = new DeleteEquivalentBranchCommand(equivalentBranchId);

    try {
      EquivalentBranchBusinessDelegate delegate =
          EquivalentBranchBusinessDelegate.getEquivalentBranchInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted EquivalentBranch with key " + command.getEquivalentBranchId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save NegativeR12 on EquivalentBranch
   *
   * @param command AssignNegativeR12ToEquivalentBranchCommand
   */
  @PutMapping("/assignNegativeR12")
  public void assignNegativeR12(@RequestBody AssignNegativeR12ToEquivalentBranchCommand command) {
    try {
      EquivalentBranchBusinessDelegate.getEquivalentBranchInstance().assignNegativeR12(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign NegativeR12", exc);
    }
  }

  /**
   * unassign NegativeR12 on EquivalentBranch
   *
   * @param command UnAssignNegativeR12FromEquivalentBranchCommand
   */
  @PutMapping("/unAssignNegativeR12")
  public void unAssignNegativeR12(
      @RequestBody(required = true) UnAssignNegativeR12FromEquivalentBranchCommand command) {
    try {
      EquivalentBranchBusinessDelegate.getEquivalentBranchInstance().unAssignNegativeR12(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign NegativeR12", exc);
    }
  }

  /**
   * save NegativeR21 on EquivalentBranch
   *
   * @param command AssignNegativeR21ToEquivalentBranchCommand
   */
  @PutMapping("/assignNegativeR21")
  public void assignNegativeR21(@RequestBody AssignNegativeR21ToEquivalentBranchCommand command) {
    try {
      EquivalentBranchBusinessDelegate.getEquivalentBranchInstance().assignNegativeR21(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign NegativeR21", exc);
    }
  }

  /**
   * unassign NegativeR21 on EquivalentBranch
   *
   * @param command UnAssignNegativeR21FromEquivalentBranchCommand
   */
  @PutMapping("/unAssignNegativeR21")
  public void unAssignNegativeR21(
      @RequestBody(required = true) UnAssignNegativeR21FromEquivalentBranchCommand command) {
    try {
      EquivalentBranchBusinessDelegate.getEquivalentBranchInstance().unAssignNegativeR21(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign NegativeR21", exc);
    }
  }

  /**
   * save NegativeX12 on EquivalentBranch
   *
   * @param command AssignNegativeX12ToEquivalentBranchCommand
   */
  @PutMapping("/assignNegativeX12")
  public void assignNegativeX12(@RequestBody AssignNegativeX12ToEquivalentBranchCommand command) {
    try {
      EquivalentBranchBusinessDelegate.getEquivalentBranchInstance().assignNegativeX12(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign NegativeX12", exc);
    }
  }

  /**
   * unassign NegativeX12 on EquivalentBranch
   *
   * @param command UnAssignNegativeX12FromEquivalentBranchCommand
   */
  @PutMapping("/unAssignNegativeX12")
  public void unAssignNegativeX12(
      @RequestBody(required = true) UnAssignNegativeX12FromEquivalentBranchCommand command) {
    try {
      EquivalentBranchBusinessDelegate.getEquivalentBranchInstance().unAssignNegativeX12(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign NegativeX12", exc);
    }
  }

  /**
   * save NegativeX21 on EquivalentBranch
   *
   * @param command AssignNegativeX21ToEquivalentBranchCommand
   */
  @PutMapping("/assignNegativeX21")
  public void assignNegativeX21(@RequestBody AssignNegativeX21ToEquivalentBranchCommand command) {
    try {
      EquivalentBranchBusinessDelegate.getEquivalentBranchInstance().assignNegativeX21(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign NegativeX21", exc);
    }
  }

  /**
   * unassign NegativeX21 on EquivalentBranch
   *
   * @param command UnAssignNegativeX21FromEquivalentBranchCommand
   */
  @PutMapping("/unAssignNegativeX21")
  public void unAssignNegativeX21(
      @RequestBody(required = true) UnAssignNegativeX21FromEquivalentBranchCommand command) {
    try {
      EquivalentBranchBusinessDelegate.getEquivalentBranchInstance().unAssignNegativeX21(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign NegativeX21", exc);
    }
  }

  /**
   * save PositiveR12 on EquivalentBranch
   *
   * @param command AssignPositiveR12ToEquivalentBranchCommand
   */
  @PutMapping("/assignPositiveR12")
  public void assignPositiveR12(@RequestBody AssignPositiveR12ToEquivalentBranchCommand command) {
    try {
      EquivalentBranchBusinessDelegate.getEquivalentBranchInstance().assignPositiveR12(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign PositiveR12", exc);
    }
  }

  /**
   * unassign PositiveR12 on EquivalentBranch
   *
   * @param command UnAssignPositiveR12FromEquivalentBranchCommand
   */
  @PutMapping("/unAssignPositiveR12")
  public void unAssignPositiveR12(
      @RequestBody(required = true) UnAssignPositiveR12FromEquivalentBranchCommand command) {
    try {
      EquivalentBranchBusinessDelegate.getEquivalentBranchInstance().unAssignPositiveR12(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign PositiveR12", exc);
    }
  }

  /**
   * save PositiveR21 on EquivalentBranch
   *
   * @param command AssignPositiveR21ToEquivalentBranchCommand
   */
  @PutMapping("/assignPositiveR21")
  public void assignPositiveR21(@RequestBody AssignPositiveR21ToEquivalentBranchCommand command) {
    try {
      EquivalentBranchBusinessDelegate.getEquivalentBranchInstance().assignPositiveR21(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign PositiveR21", exc);
    }
  }

  /**
   * unassign PositiveR21 on EquivalentBranch
   *
   * @param command UnAssignPositiveR21FromEquivalentBranchCommand
   */
  @PutMapping("/unAssignPositiveR21")
  public void unAssignPositiveR21(
      @RequestBody(required = true) UnAssignPositiveR21FromEquivalentBranchCommand command) {
    try {
      EquivalentBranchBusinessDelegate.getEquivalentBranchInstance().unAssignPositiveR21(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign PositiveR21", exc);
    }
  }

  /**
   * save PositiveX12 on EquivalentBranch
   *
   * @param command AssignPositiveX12ToEquivalentBranchCommand
   */
  @PutMapping("/assignPositiveX12")
  public void assignPositiveX12(@RequestBody AssignPositiveX12ToEquivalentBranchCommand command) {
    try {
      EquivalentBranchBusinessDelegate.getEquivalentBranchInstance().assignPositiveX12(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign PositiveX12", exc);
    }
  }

  /**
   * unassign PositiveX12 on EquivalentBranch
   *
   * @param command UnAssignPositiveX12FromEquivalentBranchCommand
   */
  @PutMapping("/unAssignPositiveX12")
  public void unAssignPositiveX12(
      @RequestBody(required = true) UnAssignPositiveX12FromEquivalentBranchCommand command) {
    try {
      EquivalentBranchBusinessDelegate.getEquivalentBranchInstance().unAssignPositiveX12(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign PositiveX12", exc);
    }
  }

  /**
   * save PositiveX21 on EquivalentBranch
   *
   * @param command AssignPositiveX21ToEquivalentBranchCommand
   */
  @PutMapping("/assignPositiveX21")
  public void assignPositiveX21(@RequestBody AssignPositiveX21ToEquivalentBranchCommand command) {
    try {
      EquivalentBranchBusinessDelegate.getEquivalentBranchInstance().assignPositiveX21(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign PositiveX21", exc);
    }
  }

  /**
   * unassign PositiveX21 on EquivalentBranch
   *
   * @param command UnAssignPositiveX21FromEquivalentBranchCommand
   */
  @PutMapping("/unAssignPositiveX21")
  public void unAssignPositiveX21(
      @RequestBody(required = true) UnAssignPositiveX21FromEquivalentBranchCommand command) {
    try {
      EquivalentBranchBusinessDelegate.getEquivalentBranchInstance().unAssignPositiveX21(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign PositiveX21", exc);
    }
  }

  /**
   * save R on EquivalentBranch
   *
   * @param command AssignRToEquivalentBranchCommand
   */
  @PutMapping("/assignR")
  public void assignR(@RequestBody AssignRToEquivalentBranchCommand command) {
    try {
      EquivalentBranchBusinessDelegate.getEquivalentBranchInstance().assignR(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign R", exc);
    }
  }

  /**
   * unassign R on EquivalentBranch
   *
   * @param command UnAssignRFromEquivalentBranchCommand
   */
  @PutMapping("/unAssignR")
  public void unAssignR(
      @RequestBody(required = true) UnAssignRFromEquivalentBranchCommand command) {
    try {
      EquivalentBranchBusinessDelegate.getEquivalentBranchInstance().unAssignR(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign R", exc);
    }
  }

  /**
   * save R21 on EquivalentBranch
   *
   * @param command AssignR21ToEquivalentBranchCommand
   */
  @PutMapping("/assignR21")
  public void assignR21(@RequestBody AssignR21ToEquivalentBranchCommand command) {
    try {
      EquivalentBranchBusinessDelegate.getEquivalentBranchInstance().assignR21(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign R21", exc);
    }
  }

  /**
   * unassign R21 on EquivalentBranch
   *
   * @param command UnAssignR21FromEquivalentBranchCommand
   */
  @PutMapping("/unAssignR21")
  public void unAssignR21(
      @RequestBody(required = true) UnAssignR21FromEquivalentBranchCommand command) {
    try {
      EquivalentBranchBusinessDelegate.getEquivalentBranchInstance().unAssignR21(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign R21", exc);
    }
  }

  /**
   * save X on EquivalentBranch
   *
   * @param command AssignXToEquivalentBranchCommand
   */
  @PutMapping("/assignX")
  public void assignX(@RequestBody AssignXToEquivalentBranchCommand command) {
    try {
      EquivalentBranchBusinessDelegate.getEquivalentBranchInstance().assignX(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign X", exc);
    }
  }

  /**
   * unassign X on EquivalentBranch
   *
   * @param command UnAssignXFromEquivalentBranchCommand
   */
  @PutMapping("/unAssignX")
  public void unAssignX(
      @RequestBody(required = true) UnAssignXFromEquivalentBranchCommand command) {
    try {
      EquivalentBranchBusinessDelegate.getEquivalentBranchInstance().unAssignX(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign X", exc);
    }
  }

  /**
   * save X21 on EquivalentBranch
   *
   * @param command AssignX21ToEquivalentBranchCommand
   */
  @PutMapping("/assignX21")
  public void assignX21(@RequestBody AssignX21ToEquivalentBranchCommand command) {
    try {
      EquivalentBranchBusinessDelegate.getEquivalentBranchInstance().assignX21(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign X21", exc);
    }
  }

  /**
   * unassign X21 on EquivalentBranch
   *
   * @param command UnAssignX21FromEquivalentBranchCommand
   */
  @PutMapping("/unAssignX21")
  public void unAssignX21(
      @RequestBody(required = true) UnAssignX21FromEquivalentBranchCommand command) {
    try {
      EquivalentBranchBusinessDelegate.getEquivalentBranchInstance().unAssignX21(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign X21", exc);
    }
  }

  /**
   * save ZeroR12 on EquivalentBranch
   *
   * @param command AssignZeroR12ToEquivalentBranchCommand
   */
  @PutMapping("/assignZeroR12")
  public void assignZeroR12(@RequestBody AssignZeroR12ToEquivalentBranchCommand command) {
    try {
      EquivalentBranchBusinessDelegate.getEquivalentBranchInstance().assignZeroR12(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign ZeroR12", exc);
    }
  }

  /**
   * unassign ZeroR12 on EquivalentBranch
   *
   * @param command UnAssignZeroR12FromEquivalentBranchCommand
   */
  @PutMapping("/unAssignZeroR12")
  public void unAssignZeroR12(
      @RequestBody(required = true) UnAssignZeroR12FromEquivalentBranchCommand command) {
    try {
      EquivalentBranchBusinessDelegate.getEquivalentBranchInstance().unAssignZeroR12(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign ZeroR12", exc);
    }
  }

  /**
   * save ZeroR21 on EquivalentBranch
   *
   * @param command AssignZeroR21ToEquivalentBranchCommand
   */
  @PutMapping("/assignZeroR21")
  public void assignZeroR21(@RequestBody AssignZeroR21ToEquivalentBranchCommand command) {
    try {
      EquivalentBranchBusinessDelegate.getEquivalentBranchInstance().assignZeroR21(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign ZeroR21", exc);
    }
  }

  /**
   * unassign ZeroR21 on EquivalentBranch
   *
   * @param command UnAssignZeroR21FromEquivalentBranchCommand
   */
  @PutMapping("/unAssignZeroR21")
  public void unAssignZeroR21(
      @RequestBody(required = true) UnAssignZeroR21FromEquivalentBranchCommand command) {
    try {
      EquivalentBranchBusinessDelegate.getEquivalentBranchInstance().unAssignZeroR21(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign ZeroR21", exc);
    }
  }

  /**
   * save ZeroX12 on EquivalentBranch
   *
   * @param command AssignZeroX12ToEquivalentBranchCommand
   */
  @PutMapping("/assignZeroX12")
  public void assignZeroX12(@RequestBody AssignZeroX12ToEquivalentBranchCommand command) {
    try {
      EquivalentBranchBusinessDelegate.getEquivalentBranchInstance().assignZeroX12(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign ZeroX12", exc);
    }
  }

  /**
   * unassign ZeroX12 on EquivalentBranch
   *
   * @param command UnAssignZeroX12FromEquivalentBranchCommand
   */
  @PutMapping("/unAssignZeroX12")
  public void unAssignZeroX12(
      @RequestBody(required = true) UnAssignZeroX12FromEquivalentBranchCommand command) {
    try {
      EquivalentBranchBusinessDelegate.getEquivalentBranchInstance().unAssignZeroX12(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign ZeroX12", exc);
    }
  }

  /**
   * save ZeroX21 on EquivalentBranch
   *
   * @param command AssignZeroX21ToEquivalentBranchCommand
   */
  @PutMapping("/assignZeroX21")
  public void assignZeroX21(@RequestBody AssignZeroX21ToEquivalentBranchCommand command) {
    try {
      EquivalentBranchBusinessDelegate.getEquivalentBranchInstance().assignZeroX21(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign ZeroX21", exc);
    }
  }

  /**
   * unassign ZeroX21 on EquivalentBranch
   *
   * @param command UnAssignZeroX21FromEquivalentBranchCommand
   */
  @PutMapping("/unAssignZeroX21")
  public void unAssignZeroX21(
      @RequestBody(required = true) UnAssignZeroX21FromEquivalentBranchCommand command) {
    try {
      EquivalentBranchBusinessDelegate.getEquivalentBranchInstance().unAssignZeroX21(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign ZeroX21", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected EquivalentBranch equivalentBranch = null;
  private static final Logger LOGGER =
      Logger.getLogger(EquivalentBranchCommandRestController.class.getName());
}
