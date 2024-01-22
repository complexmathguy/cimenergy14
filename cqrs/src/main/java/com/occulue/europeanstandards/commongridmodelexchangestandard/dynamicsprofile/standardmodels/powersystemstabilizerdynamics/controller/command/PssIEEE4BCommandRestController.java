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
 * Implements Spring Controller command CQRS processing for entity PssIEEE4B.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/PssIEEE4B")
public class PssIEEE4BCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a PssIEEE4B. if not key provided, calls create, otherwise calls save
   *
   * @param PssIEEE4B pssIEEE4B
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreatePssIEEE4BCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture = PssIEEE4BBusinessDelegate.getPssIEEE4BInstance().createPssIEEE4B(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a PssIEEE4B. if no key provided, calls create, otherwise calls save
   *
   * @param PssIEEE4B pssIEEE4B
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdatePssIEEE4BCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdatePssIEEE4BCommand
      // -----------------------------------------------
      completableFuture = PssIEEE4BBusinessDelegate.getPssIEEE4BInstance().updatePssIEEE4B(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "PssIEEE4BController:update() - successfully update PssIEEE4B - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a PssIEEE4B entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID pssIEEE4BId) {
    CompletableFuture<Void> completableFuture = null;
    DeletePssIEEE4BCommand command = new DeletePssIEEE4BCommand(pssIEEE4BId);

    try {
      PssIEEE4BBusinessDelegate delegate = PssIEEE4BBusinessDelegate.getPssIEEE4BInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING, "Successfully deleted PssIEEE4B with key " + command.getPssIEEE4BId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Bwh1 on PssIEEE4B
   *
   * @param command AssignBwh1ToPssIEEE4BCommand
   */
  @PutMapping("/assignBwh1")
  public void assignBwh1(@RequestBody AssignBwh1ToPssIEEE4BCommand command) {
    try {
      PssIEEE4BBusinessDelegate.getPssIEEE4BInstance().assignBwh1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Bwh1", exc);
    }
  }

  /**
   * unassign Bwh1 on PssIEEE4B
   *
   * @param command UnAssignBwh1FromPssIEEE4BCommand
   */
  @PutMapping("/unAssignBwh1")
  public void unAssignBwh1(@RequestBody(required = true) UnAssignBwh1FromPssIEEE4BCommand command) {
    try {
      PssIEEE4BBusinessDelegate.getPssIEEE4BInstance().unAssignBwh1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Bwh1", exc);
    }
  }

  /**
   * save Bwh2 on PssIEEE4B
   *
   * @param command AssignBwh2ToPssIEEE4BCommand
   */
  @PutMapping("/assignBwh2")
  public void assignBwh2(@RequestBody AssignBwh2ToPssIEEE4BCommand command) {
    try {
      PssIEEE4BBusinessDelegate.getPssIEEE4BInstance().assignBwh2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Bwh2", exc);
    }
  }

  /**
   * unassign Bwh2 on PssIEEE4B
   *
   * @param command UnAssignBwh2FromPssIEEE4BCommand
   */
  @PutMapping("/unAssignBwh2")
  public void unAssignBwh2(@RequestBody(required = true) UnAssignBwh2FromPssIEEE4BCommand command) {
    try {
      PssIEEE4BBusinessDelegate.getPssIEEE4BInstance().unAssignBwh2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Bwh2", exc);
    }
  }

  /**
   * save Bwl1 on PssIEEE4B
   *
   * @param command AssignBwl1ToPssIEEE4BCommand
   */
  @PutMapping("/assignBwl1")
  public void assignBwl1(@RequestBody AssignBwl1ToPssIEEE4BCommand command) {
    try {
      PssIEEE4BBusinessDelegate.getPssIEEE4BInstance().assignBwl1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Bwl1", exc);
    }
  }

  /**
   * unassign Bwl1 on PssIEEE4B
   *
   * @param command UnAssignBwl1FromPssIEEE4BCommand
   */
  @PutMapping("/unAssignBwl1")
  public void unAssignBwl1(@RequestBody(required = true) UnAssignBwl1FromPssIEEE4BCommand command) {
    try {
      PssIEEE4BBusinessDelegate.getPssIEEE4BInstance().unAssignBwl1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Bwl1", exc);
    }
  }

  /**
   * save Bwl2 on PssIEEE4B
   *
   * @param command AssignBwl2ToPssIEEE4BCommand
   */
  @PutMapping("/assignBwl2")
  public void assignBwl2(@RequestBody AssignBwl2ToPssIEEE4BCommand command) {
    try {
      PssIEEE4BBusinessDelegate.getPssIEEE4BInstance().assignBwl2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Bwl2", exc);
    }
  }

  /**
   * unassign Bwl2 on PssIEEE4B
   *
   * @param command UnAssignBwl2FromPssIEEE4BCommand
   */
  @PutMapping("/unAssignBwl2")
  public void unAssignBwl2(@RequestBody(required = true) UnAssignBwl2FromPssIEEE4BCommand command) {
    try {
      PssIEEE4BBusinessDelegate.getPssIEEE4BInstance().unAssignBwl2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Bwl2", exc);
    }
  }

  /**
   * save Kh on PssIEEE4B
   *
   * @param command AssignKhToPssIEEE4BCommand
   */
  @PutMapping("/assignKh")
  public void assignKh(@RequestBody AssignKhToPssIEEE4BCommand command) {
    try {
      PssIEEE4BBusinessDelegate.getPssIEEE4BInstance().assignKh(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kh", exc);
    }
  }

  /**
   * unassign Kh on PssIEEE4B
   *
   * @param command UnAssignKhFromPssIEEE4BCommand
   */
  @PutMapping("/unAssignKh")
  public void unAssignKh(@RequestBody(required = true) UnAssignKhFromPssIEEE4BCommand command) {
    try {
      PssIEEE4BBusinessDelegate.getPssIEEE4BInstance().unAssignKh(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kh", exc);
    }
  }

  /**
   * save Kh1 on PssIEEE4B
   *
   * @param command AssignKh1ToPssIEEE4BCommand
   */
  @PutMapping("/assignKh1")
  public void assignKh1(@RequestBody AssignKh1ToPssIEEE4BCommand command) {
    try {
      PssIEEE4BBusinessDelegate.getPssIEEE4BInstance().assignKh1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kh1", exc);
    }
  }

  /**
   * unassign Kh1 on PssIEEE4B
   *
   * @param command UnAssignKh1FromPssIEEE4BCommand
   */
  @PutMapping("/unAssignKh1")
  public void unAssignKh1(@RequestBody(required = true) UnAssignKh1FromPssIEEE4BCommand command) {
    try {
      PssIEEE4BBusinessDelegate.getPssIEEE4BInstance().unAssignKh1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kh1", exc);
    }
  }

  /**
   * save Kh11 on PssIEEE4B
   *
   * @param command AssignKh11ToPssIEEE4BCommand
   */
  @PutMapping("/assignKh11")
  public void assignKh11(@RequestBody AssignKh11ToPssIEEE4BCommand command) {
    try {
      PssIEEE4BBusinessDelegate.getPssIEEE4BInstance().assignKh11(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kh11", exc);
    }
  }

  /**
   * unassign Kh11 on PssIEEE4B
   *
   * @param command UnAssignKh11FromPssIEEE4BCommand
   */
  @PutMapping("/unAssignKh11")
  public void unAssignKh11(@RequestBody(required = true) UnAssignKh11FromPssIEEE4BCommand command) {
    try {
      PssIEEE4BBusinessDelegate.getPssIEEE4BInstance().unAssignKh11(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kh11", exc);
    }
  }

  /**
   * save Kh17 on PssIEEE4B
   *
   * @param command AssignKh17ToPssIEEE4BCommand
   */
  @PutMapping("/assignKh17")
  public void assignKh17(@RequestBody AssignKh17ToPssIEEE4BCommand command) {
    try {
      PssIEEE4BBusinessDelegate.getPssIEEE4BInstance().assignKh17(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kh17", exc);
    }
  }

  /**
   * unassign Kh17 on PssIEEE4B
   *
   * @param command UnAssignKh17FromPssIEEE4BCommand
   */
  @PutMapping("/unAssignKh17")
  public void unAssignKh17(@RequestBody(required = true) UnAssignKh17FromPssIEEE4BCommand command) {
    try {
      PssIEEE4BBusinessDelegate.getPssIEEE4BInstance().unAssignKh17(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kh17", exc);
    }
  }

  /**
   * save Kh2 on PssIEEE4B
   *
   * @param command AssignKh2ToPssIEEE4BCommand
   */
  @PutMapping("/assignKh2")
  public void assignKh2(@RequestBody AssignKh2ToPssIEEE4BCommand command) {
    try {
      PssIEEE4BBusinessDelegate.getPssIEEE4BInstance().assignKh2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kh2", exc);
    }
  }

  /**
   * unassign Kh2 on PssIEEE4B
   *
   * @param command UnAssignKh2FromPssIEEE4BCommand
   */
  @PutMapping("/unAssignKh2")
  public void unAssignKh2(@RequestBody(required = true) UnAssignKh2FromPssIEEE4BCommand command) {
    try {
      PssIEEE4BBusinessDelegate.getPssIEEE4BInstance().unAssignKh2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kh2", exc);
    }
  }

  /**
   * save Ki on PssIEEE4B
   *
   * @param command AssignKiToPssIEEE4BCommand
   */
  @PutMapping("/assignKi")
  public void assignKi(@RequestBody AssignKiToPssIEEE4BCommand command) {
    try {
      PssIEEE4BBusinessDelegate.getPssIEEE4BInstance().assignKi(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ki", exc);
    }
  }

  /**
   * unassign Ki on PssIEEE4B
   *
   * @param command UnAssignKiFromPssIEEE4BCommand
   */
  @PutMapping("/unAssignKi")
  public void unAssignKi(@RequestBody(required = true) UnAssignKiFromPssIEEE4BCommand command) {
    try {
      PssIEEE4BBusinessDelegate.getPssIEEE4BInstance().unAssignKi(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ki", exc);
    }
  }

  /**
   * save Ki1 on PssIEEE4B
   *
   * @param command AssignKi1ToPssIEEE4BCommand
   */
  @PutMapping("/assignKi1")
  public void assignKi1(@RequestBody AssignKi1ToPssIEEE4BCommand command) {
    try {
      PssIEEE4BBusinessDelegate.getPssIEEE4BInstance().assignKi1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ki1", exc);
    }
  }

  /**
   * unassign Ki1 on PssIEEE4B
   *
   * @param command UnAssignKi1FromPssIEEE4BCommand
   */
  @PutMapping("/unAssignKi1")
  public void unAssignKi1(@RequestBody(required = true) UnAssignKi1FromPssIEEE4BCommand command) {
    try {
      PssIEEE4BBusinessDelegate.getPssIEEE4BInstance().unAssignKi1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ki1", exc);
    }
  }

  /**
   * save Ki11 on PssIEEE4B
   *
   * @param command AssignKi11ToPssIEEE4BCommand
   */
  @PutMapping("/assignKi11")
  public void assignKi11(@RequestBody AssignKi11ToPssIEEE4BCommand command) {
    try {
      PssIEEE4BBusinessDelegate.getPssIEEE4BInstance().assignKi11(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ki11", exc);
    }
  }

  /**
   * unassign Ki11 on PssIEEE4B
   *
   * @param command UnAssignKi11FromPssIEEE4BCommand
   */
  @PutMapping("/unAssignKi11")
  public void unAssignKi11(@RequestBody(required = true) UnAssignKi11FromPssIEEE4BCommand command) {
    try {
      PssIEEE4BBusinessDelegate.getPssIEEE4BInstance().unAssignKi11(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ki11", exc);
    }
  }

  /**
   * save Ki17 on PssIEEE4B
   *
   * @param command AssignKi17ToPssIEEE4BCommand
   */
  @PutMapping("/assignKi17")
  public void assignKi17(@RequestBody AssignKi17ToPssIEEE4BCommand command) {
    try {
      PssIEEE4BBusinessDelegate.getPssIEEE4BInstance().assignKi17(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ki17", exc);
    }
  }

  /**
   * unassign Ki17 on PssIEEE4B
   *
   * @param command UnAssignKi17FromPssIEEE4BCommand
   */
  @PutMapping("/unAssignKi17")
  public void unAssignKi17(@RequestBody(required = true) UnAssignKi17FromPssIEEE4BCommand command) {
    try {
      PssIEEE4BBusinessDelegate.getPssIEEE4BInstance().unAssignKi17(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ki17", exc);
    }
  }

  /**
   * save Ki2 on PssIEEE4B
   *
   * @param command AssignKi2ToPssIEEE4BCommand
   */
  @PutMapping("/assignKi2")
  public void assignKi2(@RequestBody AssignKi2ToPssIEEE4BCommand command) {
    try {
      PssIEEE4BBusinessDelegate.getPssIEEE4BInstance().assignKi2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ki2", exc);
    }
  }

  /**
   * unassign Ki2 on PssIEEE4B
   *
   * @param command UnAssignKi2FromPssIEEE4BCommand
   */
  @PutMapping("/unAssignKi2")
  public void unAssignKi2(@RequestBody(required = true) UnAssignKi2FromPssIEEE4BCommand command) {
    try {
      PssIEEE4BBusinessDelegate.getPssIEEE4BInstance().unAssignKi2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ki2", exc);
    }
  }

  /**
   * save Kl on PssIEEE4B
   *
   * @param command AssignKlToPssIEEE4BCommand
   */
  @PutMapping("/assignKl")
  public void assignKl(@RequestBody AssignKlToPssIEEE4BCommand command) {
    try {
      PssIEEE4BBusinessDelegate.getPssIEEE4BInstance().assignKl(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kl", exc);
    }
  }

  /**
   * unassign Kl on PssIEEE4B
   *
   * @param command UnAssignKlFromPssIEEE4BCommand
   */
  @PutMapping("/unAssignKl")
  public void unAssignKl(@RequestBody(required = true) UnAssignKlFromPssIEEE4BCommand command) {
    try {
      PssIEEE4BBusinessDelegate.getPssIEEE4BInstance().unAssignKl(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kl", exc);
    }
  }

  /**
   * save Kl1 on PssIEEE4B
   *
   * @param command AssignKl1ToPssIEEE4BCommand
   */
  @PutMapping("/assignKl1")
  public void assignKl1(@RequestBody AssignKl1ToPssIEEE4BCommand command) {
    try {
      PssIEEE4BBusinessDelegate.getPssIEEE4BInstance().assignKl1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kl1", exc);
    }
  }

  /**
   * unassign Kl1 on PssIEEE4B
   *
   * @param command UnAssignKl1FromPssIEEE4BCommand
   */
  @PutMapping("/unAssignKl1")
  public void unAssignKl1(@RequestBody(required = true) UnAssignKl1FromPssIEEE4BCommand command) {
    try {
      PssIEEE4BBusinessDelegate.getPssIEEE4BInstance().unAssignKl1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kl1", exc);
    }
  }

  /**
   * save Kl11 on PssIEEE4B
   *
   * @param command AssignKl11ToPssIEEE4BCommand
   */
  @PutMapping("/assignKl11")
  public void assignKl11(@RequestBody AssignKl11ToPssIEEE4BCommand command) {
    try {
      PssIEEE4BBusinessDelegate.getPssIEEE4BInstance().assignKl11(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kl11", exc);
    }
  }

  /**
   * unassign Kl11 on PssIEEE4B
   *
   * @param command UnAssignKl11FromPssIEEE4BCommand
   */
  @PutMapping("/unAssignKl11")
  public void unAssignKl11(@RequestBody(required = true) UnAssignKl11FromPssIEEE4BCommand command) {
    try {
      PssIEEE4BBusinessDelegate.getPssIEEE4BInstance().unAssignKl11(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kl11", exc);
    }
  }

  /**
   * save Kl17 on PssIEEE4B
   *
   * @param command AssignKl17ToPssIEEE4BCommand
   */
  @PutMapping("/assignKl17")
  public void assignKl17(@RequestBody AssignKl17ToPssIEEE4BCommand command) {
    try {
      PssIEEE4BBusinessDelegate.getPssIEEE4BInstance().assignKl17(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kl17", exc);
    }
  }

  /**
   * unassign Kl17 on PssIEEE4B
   *
   * @param command UnAssignKl17FromPssIEEE4BCommand
   */
  @PutMapping("/unAssignKl17")
  public void unAssignKl17(@RequestBody(required = true) UnAssignKl17FromPssIEEE4BCommand command) {
    try {
      PssIEEE4BBusinessDelegate.getPssIEEE4BInstance().unAssignKl17(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kl17", exc);
    }
  }

  /**
   * save Kl2 on PssIEEE4B
   *
   * @param command AssignKl2ToPssIEEE4BCommand
   */
  @PutMapping("/assignKl2")
  public void assignKl2(@RequestBody AssignKl2ToPssIEEE4BCommand command) {
    try {
      PssIEEE4BBusinessDelegate.getPssIEEE4BInstance().assignKl2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kl2", exc);
    }
  }

  /**
   * unassign Kl2 on PssIEEE4B
   *
   * @param command UnAssignKl2FromPssIEEE4BCommand
   */
  @PutMapping("/unAssignKl2")
  public void unAssignKl2(@RequestBody(required = true) UnAssignKl2FromPssIEEE4BCommand command) {
    try {
      PssIEEE4BBusinessDelegate.getPssIEEE4BInstance().unAssignKl2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kl2", exc);
    }
  }

  /**
   * save Omeganh1 on PssIEEE4B
   *
   * @param command AssignOmeganh1ToPssIEEE4BCommand
   */
  @PutMapping("/assignOmeganh1")
  public void assignOmeganh1(@RequestBody AssignOmeganh1ToPssIEEE4BCommand command) {
    try {
      PssIEEE4BBusinessDelegate.getPssIEEE4BInstance().assignOmeganh1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Omeganh1", exc);
    }
  }

  /**
   * unassign Omeganh1 on PssIEEE4B
   *
   * @param command UnAssignOmeganh1FromPssIEEE4BCommand
   */
  @PutMapping("/unAssignOmeganh1")
  public void unAssignOmeganh1(
      @RequestBody(required = true) UnAssignOmeganh1FromPssIEEE4BCommand command) {
    try {
      PssIEEE4BBusinessDelegate.getPssIEEE4BInstance().unAssignOmeganh1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Omeganh1", exc);
    }
  }

  /**
   * save Omeganh2 on PssIEEE4B
   *
   * @param command AssignOmeganh2ToPssIEEE4BCommand
   */
  @PutMapping("/assignOmeganh2")
  public void assignOmeganh2(@RequestBody AssignOmeganh2ToPssIEEE4BCommand command) {
    try {
      PssIEEE4BBusinessDelegate.getPssIEEE4BInstance().assignOmeganh2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Omeganh2", exc);
    }
  }

  /**
   * unassign Omeganh2 on PssIEEE4B
   *
   * @param command UnAssignOmeganh2FromPssIEEE4BCommand
   */
  @PutMapping("/unAssignOmeganh2")
  public void unAssignOmeganh2(
      @RequestBody(required = true) UnAssignOmeganh2FromPssIEEE4BCommand command) {
    try {
      PssIEEE4BBusinessDelegate.getPssIEEE4BInstance().unAssignOmeganh2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Omeganh2", exc);
    }
  }

  /**
   * save Omeganl1 on PssIEEE4B
   *
   * @param command AssignOmeganl1ToPssIEEE4BCommand
   */
  @PutMapping("/assignOmeganl1")
  public void assignOmeganl1(@RequestBody AssignOmeganl1ToPssIEEE4BCommand command) {
    try {
      PssIEEE4BBusinessDelegate.getPssIEEE4BInstance().assignOmeganl1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Omeganl1", exc);
    }
  }

  /**
   * unassign Omeganl1 on PssIEEE4B
   *
   * @param command UnAssignOmeganl1FromPssIEEE4BCommand
   */
  @PutMapping("/unAssignOmeganl1")
  public void unAssignOmeganl1(
      @RequestBody(required = true) UnAssignOmeganl1FromPssIEEE4BCommand command) {
    try {
      PssIEEE4BBusinessDelegate.getPssIEEE4BInstance().unAssignOmeganl1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Omeganl1", exc);
    }
  }

  /**
   * save Omeganl2 on PssIEEE4B
   *
   * @param command AssignOmeganl2ToPssIEEE4BCommand
   */
  @PutMapping("/assignOmeganl2")
  public void assignOmeganl2(@RequestBody AssignOmeganl2ToPssIEEE4BCommand command) {
    try {
      PssIEEE4BBusinessDelegate.getPssIEEE4BInstance().assignOmeganl2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Omeganl2", exc);
    }
  }

  /**
   * unassign Omeganl2 on PssIEEE4B
   *
   * @param command UnAssignOmeganl2FromPssIEEE4BCommand
   */
  @PutMapping("/unAssignOmeganl2")
  public void unAssignOmeganl2(
      @RequestBody(required = true) UnAssignOmeganl2FromPssIEEE4BCommand command) {
    try {
      PssIEEE4BBusinessDelegate.getPssIEEE4BInstance().unAssignOmeganl2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Omeganl2", exc);
    }
  }

  /**
   * save Th1 on PssIEEE4B
   *
   * @param command AssignTh1ToPssIEEE4BCommand
   */
  @PutMapping("/assignTh1")
  public void assignTh1(@RequestBody AssignTh1ToPssIEEE4BCommand command) {
    try {
      PssIEEE4BBusinessDelegate.getPssIEEE4BInstance().assignTh1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Th1", exc);
    }
  }

  /**
   * unassign Th1 on PssIEEE4B
   *
   * @param command UnAssignTh1FromPssIEEE4BCommand
   */
  @PutMapping("/unAssignTh1")
  public void unAssignTh1(@RequestBody(required = true) UnAssignTh1FromPssIEEE4BCommand command) {
    try {
      PssIEEE4BBusinessDelegate.getPssIEEE4BInstance().unAssignTh1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Th1", exc);
    }
  }

  /**
   * save Th10 on PssIEEE4B
   *
   * @param command AssignTh10ToPssIEEE4BCommand
   */
  @PutMapping("/assignTh10")
  public void assignTh10(@RequestBody AssignTh10ToPssIEEE4BCommand command) {
    try {
      PssIEEE4BBusinessDelegate.getPssIEEE4BInstance().assignTh10(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Th10", exc);
    }
  }

  /**
   * unassign Th10 on PssIEEE4B
   *
   * @param command UnAssignTh10FromPssIEEE4BCommand
   */
  @PutMapping("/unAssignTh10")
  public void unAssignTh10(@RequestBody(required = true) UnAssignTh10FromPssIEEE4BCommand command) {
    try {
      PssIEEE4BBusinessDelegate.getPssIEEE4BInstance().unAssignTh10(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Th10", exc);
    }
  }

  /**
   * save Th11 on PssIEEE4B
   *
   * @param command AssignTh11ToPssIEEE4BCommand
   */
  @PutMapping("/assignTh11")
  public void assignTh11(@RequestBody AssignTh11ToPssIEEE4BCommand command) {
    try {
      PssIEEE4BBusinessDelegate.getPssIEEE4BInstance().assignTh11(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Th11", exc);
    }
  }

  /**
   * unassign Th11 on PssIEEE4B
   *
   * @param command UnAssignTh11FromPssIEEE4BCommand
   */
  @PutMapping("/unAssignTh11")
  public void unAssignTh11(@RequestBody(required = true) UnAssignTh11FromPssIEEE4BCommand command) {
    try {
      PssIEEE4BBusinessDelegate.getPssIEEE4BInstance().unAssignTh11(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Th11", exc);
    }
  }

  /**
   * save Th12 on PssIEEE4B
   *
   * @param command AssignTh12ToPssIEEE4BCommand
   */
  @PutMapping("/assignTh12")
  public void assignTh12(@RequestBody AssignTh12ToPssIEEE4BCommand command) {
    try {
      PssIEEE4BBusinessDelegate.getPssIEEE4BInstance().assignTh12(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Th12", exc);
    }
  }

  /**
   * unassign Th12 on PssIEEE4B
   *
   * @param command UnAssignTh12FromPssIEEE4BCommand
   */
  @PutMapping("/unAssignTh12")
  public void unAssignTh12(@RequestBody(required = true) UnAssignTh12FromPssIEEE4BCommand command) {
    try {
      PssIEEE4BBusinessDelegate.getPssIEEE4BInstance().unAssignTh12(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Th12", exc);
    }
  }

  /**
   * save Th2 on PssIEEE4B
   *
   * @param command AssignTh2ToPssIEEE4BCommand
   */
  @PutMapping("/assignTh2")
  public void assignTh2(@RequestBody AssignTh2ToPssIEEE4BCommand command) {
    try {
      PssIEEE4BBusinessDelegate.getPssIEEE4BInstance().assignTh2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Th2", exc);
    }
  }

  /**
   * unassign Th2 on PssIEEE4B
   *
   * @param command UnAssignTh2FromPssIEEE4BCommand
   */
  @PutMapping("/unAssignTh2")
  public void unAssignTh2(@RequestBody(required = true) UnAssignTh2FromPssIEEE4BCommand command) {
    try {
      PssIEEE4BBusinessDelegate.getPssIEEE4BInstance().unAssignTh2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Th2", exc);
    }
  }

  /**
   * save Th3 on PssIEEE4B
   *
   * @param command AssignTh3ToPssIEEE4BCommand
   */
  @PutMapping("/assignTh3")
  public void assignTh3(@RequestBody AssignTh3ToPssIEEE4BCommand command) {
    try {
      PssIEEE4BBusinessDelegate.getPssIEEE4BInstance().assignTh3(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Th3", exc);
    }
  }

  /**
   * unassign Th3 on PssIEEE4B
   *
   * @param command UnAssignTh3FromPssIEEE4BCommand
   */
  @PutMapping("/unAssignTh3")
  public void unAssignTh3(@RequestBody(required = true) UnAssignTh3FromPssIEEE4BCommand command) {
    try {
      PssIEEE4BBusinessDelegate.getPssIEEE4BInstance().unAssignTh3(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Th3", exc);
    }
  }

  /**
   * save Th4 on PssIEEE4B
   *
   * @param command AssignTh4ToPssIEEE4BCommand
   */
  @PutMapping("/assignTh4")
  public void assignTh4(@RequestBody AssignTh4ToPssIEEE4BCommand command) {
    try {
      PssIEEE4BBusinessDelegate.getPssIEEE4BInstance().assignTh4(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Th4", exc);
    }
  }

  /**
   * unassign Th4 on PssIEEE4B
   *
   * @param command UnAssignTh4FromPssIEEE4BCommand
   */
  @PutMapping("/unAssignTh4")
  public void unAssignTh4(@RequestBody(required = true) UnAssignTh4FromPssIEEE4BCommand command) {
    try {
      PssIEEE4BBusinessDelegate.getPssIEEE4BInstance().unAssignTh4(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Th4", exc);
    }
  }

  /**
   * save Th5 on PssIEEE4B
   *
   * @param command AssignTh5ToPssIEEE4BCommand
   */
  @PutMapping("/assignTh5")
  public void assignTh5(@RequestBody AssignTh5ToPssIEEE4BCommand command) {
    try {
      PssIEEE4BBusinessDelegate.getPssIEEE4BInstance().assignTh5(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Th5", exc);
    }
  }

  /**
   * unassign Th5 on PssIEEE4B
   *
   * @param command UnAssignTh5FromPssIEEE4BCommand
   */
  @PutMapping("/unAssignTh5")
  public void unAssignTh5(@RequestBody(required = true) UnAssignTh5FromPssIEEE4BCommand command) {
    try {
      PssIEEE4BBusinessDelegate.getPssIEEE4BInstance().unAssignTh5(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Th5", exc);
    }
  }

  /**
   * save Th6 on PssIEEE4B
   *
   * @param command AssignTh6ToPssIEEE4BCommand
   */
  @PutMapping("/assignTh6")
  public void assignTh6(@RequestBody AssignTh6ToPssIEEE4BCommand command) {
    try {
      PssIEEE4BBusinessDelegate.getPssIEEE4BInstance().assignTh6(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Th6", exc);
    }
  }

  /**
   * unassign Th6 on PssIEEE4B
   *
   * @param command UnAssignTh6FromPssIEEE4BCommand
   */
  @PutMapping("/unAssignTh6")
  public void unAssignTh6(@RequestBody(required = true) UnAssignTh6FromPssIEEE4BCommand command) {
    try {
      PssIEEE4BBusinessDelegate.getPssIEEE4BInstance().unAssignTh6(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Th6", exc);
    }
  }

  /**
   * save Th7 on PssIEEE4B
   *
   * @param command AssignTh7ToPssIEEE4BCommand
   */
  @PutMapping("/assignTh7")
  public void assignTh7(@RequestBody AssignTh7ToPssIEEE4BCommand command) {
    try {
      PssIEEE4BBusinessDelegate.getPssIEEE4BInstance().assignTh7(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Th7", exc);
    }
  }

  /**
   * unassign Th7 on PssIEEE4B
   *
   * @param command UnAssignTh7FromPssIEEE4BCommand
   */
  @PutMapping("/unAssignTh7")
  public void unAssignTh7(@RequestBody(required = true) UnAssignTh7FromPssIEEE4BCommand command) {
    try {
      PssIEEE4BBusinessDelegate.getPssIEEE4BInstance().unAssignTh7(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Th7", exc);
    }
  }

  /**
   * save Th8 on PssIEEE4B
   *
   * @param command AssignTh8ToPssIEEE4BCommand
   */
  @PutMapping("/assignTh8")
  public void assignTh8(@RequestBody AssignTh8ToPssIEEE4BCommand command) {
    try {
      PssIEEE4BBusinessDelegate.getPssIEEE4BInstance().assignTh8(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Th8", exc);
    }
  }

  /**
   * unassign Th8 on PssIEEE4B
   *
   * @param command UnAssignTh8FromPssIEEE4BCommand
   */
  @PutMapping("/unAssignTh8")
  public void unAssignTh8(@RequestBody(required = true) UnAssignTh8FromPssIEEE4BCommand command) {
    try {
      PssIEEE4BBusinessDelegate.getPssIEEE4BInstance().unAssignTh8(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Th8", exc);
    }
  }

  /**
   * save Th9 on PssIEEE4B
   *
   * @param command AssignTh9ToPssIEEE4BCommand
   */
  @PutMapping("/assignTh9")
  public void assignTh9(@RequestBody AssignTh9ToPssIEEE4BCommand command) {
    try {
      PssIEEE4BBusinessDelegate.getPssIEEE4BInstance().assignTh9(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Th9", exc);
    }
  }

  /**
   * unassign Th9 on PssIEEE4B
   *
   * @param command UnAssignTh9FromPssIEEE4BCommand
   */
  @PutMapping("/unAssignTh9")
  public void unAssignTh9(@RequestBody(required = true) UnAssignTh9FromPssIEEE4BCommand command) {
    try {
      PssIEEE4BBusinessDelegate.getPssIEEE4BInstance().unAssignTh9(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Th9", exc);
    }
  }

  /**
   * save Ti1 on PssIEEE4B
   *
   * @param command AssignTi1ToPssIEEE4BCommand
   */
  @PutMapping("/assignTi1")
  public void assignTi1(@RequestBody AssignTi1ToPssIEEE4BCommand command) {
    try {
      PssIEEE4BBusinessDelegate.getPssIEEE4BInstance().assignTi1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ti1", exc);
    }
  }

  /**
   * unassign Ti1 on PssIEEE4B
   *
   * @param command UnAssignTi1FromPssIEEE4BCommand
   */
  @PutMapping("/unAssignTi1")
  public void unAssignTi1(@RequestBody(required = true) UnAssignTi1FromPssIEEE4BCommand command) {
    try {
      PssIEEE4BBusinessDelegate.getPssIEEE4BInstance().unAssignTi1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ti1", exc);
    }
  }

  /**
   * save Ti10 on PssIEEE4B
   *
   * @param command AssignTi10ToPssIEEE4BCommand
   */
  @PutMapping("/assignTi10")
  public void assignTi10(@RequestBody AssignTi10ToPssIEEE4BCommand command) {
    try {
      PssIEEE4BBusinessDelegate.getPssIEEE4BInstance().assignTi10(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ti10", exc);
    }
  }

  /**
   * unassign Ti10 on PssIEEE4B
   *
   * @param command UnAssignTi10FromPssIEEE4BCommand
   */
  @PutMapping("/unAssignTi10")
  public void unAssignTi10(@RequestBody(required = true) UnAssignTi10FromPssIEEE4BCommand command) {
    try {
      PssIEEE4BBusinessDelegate.getPssIEEE4BInstance().unAssignTi10(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ti10", exc);
    }
  }

  /**
   * save Ti11 on PssIEEE4B
   *
   * @param command AssignTi11ToPssIEEE4BCommand
   */
  @PutMapping("/assignTi11")
  public void assignTi11(@RequestBody AssignTi11ToPssIEEE4BCommand command) {
    try {
      PssIEEE4BBusinessDelegate.getPssIEEE4BInstance().assignTi11(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ti11", exc);
    }
  }

  /**
   * unassign Ti11 on PssIEEE4B
   *
   * @param command UnAssignTi11FromPssIEEE4BCommand
   */
  @PutMapping("/unAssignTi11")
  public void unAssignTi11(@RequestBody(required = true) UnAssignTi11FromPssIEEE4BCommand command) {
    try {
      PssIEEE4BBusinessDelegate.getPssIEEE4BInstance().unAssignTi11(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ti11", exc);
    }
  }

  /**
   * save Ti12 on PssIEEE4B
   *
   * @param command AssignTi12ToPssIEEE4BCommand
   */
  @PutMapping("/assignTi12")
  public void assignTi12(@RequestBody AssignTi12ToPssIEEE4BCommand command) {
    try {
      PssIEEE4BBusinessDelegate.getPssIEEE4BInstance().assignTi12(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ti12", exc);
    }
  }

  /**
   * unassign Ti12 on PssIEEE4B
   *
   * @param command UnAssignTi12FromPssIEEE4BCommand
   */
  @PutMapping("/unAssignTi12")
  public void unAssignTi12(@RequestBody(required = true) UnAssignTi12FromPssIEEE4BCommand command) {
    try {
      PssIEEE4BBusinessDelegate.getPssIEEE4BInstance().unAssignTi12(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ti12", exc);
    }
  }

  /**
   * save Ti2 on PssIEEE4B
   *
   * @param command AssignTi2ToPssIEEE4BCommand
   */
  @PutMapping("/assignTi2")
  public void assignTi2(@RequestBody AssignTi2ToPssIEEE4BCommand command) {
    try {
      PssIEEE4BBusinessDelegate.getPssIEEE4BInstance().assignTi2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ti2", exc);
    }
  }

  /**
   * unassign Ti2 on PssIEEE4B
   *
   * @param command UnAssignTi2FromPssIEEE4BCommand
   */
  @PutMapping("/unAssignTi2")
  public void unAssignTi2(@RequestBody(required = true) UnAssignTi2FromPssIEEE4BCommand command) {
    try {
      PssIEEE4BBusinessDelegate.getPssIEEE4BInstance().unAssignTi2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ti2", exc);
    }
  }

  /**
   * save Ti3 on PssIEEE4B
   *
   * @param command AssignTi3ToPssIEEE4BCommand
   */
  @PutMapping("/assignTi3")
  public void assignTi3(@RequestBody AssignTi3ToPssIEEE4BCommand command) {
    try {
      PssIEEE4BBusinessDelegate.getPssIEEE4BInstance().assignTi3(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ti3", exc);
    }
  }

  /**
   * unassign Ti3 on PssIEEE4B
   *
   * @param command UnAssignTi3FromPssIEEE4BCommand
   */
  @PutMapping("/unAssignTi3")
  public void unAssignTi3(@RequestBody(required = true) UnAssignTi3FromPssIEEE4BCommand command) {
    try {
      PssIEEE4BBusinessDelegate.getPssIEEE4BInstance().unAssignTi3(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ti3", exc);
    }
  }

  /**
   * save Ti4 on PssIEEE4B
   *
   * @param command AssignTi4ToPssIEEE4BCommand
   */
  @PutMapping("/assignTi4")
  public void assignTi4(@RequestBody AssignTi4ToPssIEEE4BCommand command) {
    try {
      PssIEEE4BBusinessDelegate.getPssIEEE4BInstance().assignTi4(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ti4", exc);
    }
  }

  /**
   * unassign Ti4 on PssIEEE4B
   *
   * @param command UnAssignTi4FromPssIEEE4BCommand
   */
  @PutMapping("/unAssignTi4")
  public void unAssignTi4(@RequestBody(required = true) UnAssignTi4FromPssIEEE4BCommand command) {
    try {
      PssIEEE4BBusinessDelegate.getPssIEEE4BInstance().unAssignTi4(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ti4", exc);
    }
  }

  /**
   * save Ti5 on PssIEEE4B
   *
   * @param command AssignTi5ToPssIEEE4BCommand
   */
  @PutMapping("/assignTi5")
  public void assignTi5(@RequestBody AssignTi5ToPssIEEE4BCommand command) {
    try {
      PssIEEE4BBusinessDelegate.getPssIEEE4BInstance().assignTi5(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ti5", exc);
    }
  }

  /**
   * unassign Ti5 on PssIEEE4B
   *
   * @param command UnAssignTi5FromPssIEEE4BCommand
   */
  @PutMapping("/unAssignTi5")
  public void unAssignTi5(@RequestBody(required = true) UnAssignTi5FromPssIEEE4BCommand command) {
    try {
      PssIEEE4BBusinessDelegate.getPssIEEE4BInstance().unAssignTi5(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ti5", exc);
    }
  }

  /**
   * save Ti6 on PssIEEE4B
   *
   * @param command AssignTi6ToPssIEEE4BCommand
   */
  @PutMapping("/assignTi6")
  public void assignTi6(@RequestBody AssignTi6ToPssIEEE4BCommand command) {
    try {
      PssIEEE4BBusinessDelegate.getPssIEEE4BInstance().assignTi6(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ti6", exc);
    }
  }

  /**
   * unassign Ti6 on PssIEEE4B
   *
   * @param command UnAssignTi6FromPssIEEE4BCommand
   */
  @PutMapping("/unAssignTi6")
  public void unAssignTi6(@RequestBody(required = true) UnAssignTi6FromPssIEEE4BCommand command) {
    try {
      PssIEEE4BBusinessDelegate.getPssIEEE4BInstance().unAssignTi6(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ti6", exc);
    }
  }

  /**
   * save Ti7 on PssIEEE4B
   *
   * @param command AssignTi7ToPssIEEE4BCommand
   */
  @PutMapping("/assignTi7")
  public void assignTi7(@RequestBody AssignTi7ToPssIEEE4BCommand command) {
    try {
      PssIEEE4BBusinessDelegate.getPssIEEE4BInstance().assignTi7(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ti7", exc);
    }
  }

  /**
   * unassign Ti7 on PssIEEE4B
   *
   * @param command UnAssignTi7FromPssIEEE4BCommand
   */
  @PutMapping("/unAssignTi7")
  public void unAssignTi7(@RequestBody(required = true) UnAssignTi7FromPssIEEE4BCommand command) {
    try {
      PssIEEE4BBusinessDelegate.getPssIEEE4BInstance().unAssignTi7(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ti7", exc);
    }
  }

  /**
   * save Ti8 on PssIEEE4B
   *
   * @param command AssignTi8ToPssIEEE4BCommand
   */
  @PutMapping("/assignTi8")
  public void assignTi8(@RequestBody AssignTi8ToPssIEEE4BCommand command) {
    try {
      PssIEEE4BBusinessDelegate.getPssIEEE4BInstance().assignTi8(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ti8", exc);
    }
  }

  /**
   * unassign Ti8 on PssIEEE4B
   *
   * @param command UnAssignTi8FromPssIEEE4BCommand
   */
  @PutMapping("/unAssignTi8")
  public void unAssignTi8(@RequestBody(required = true) UnAssignTi8FromPssIEEE4BCommand command) {
    try {
      PssIEEE4BBusinessDelegate.getPssIEEE4BInstance().unAssignTi8(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ti8", exc);
    }
  }

  /**
   * save Ti9 on PssIEEE4B
   *
   * @param command AssignTi9ToPssIEEE4BCommand
   */
  @PutMapping("/assignTi9")
  public void assignTi9(@RequestBody AssignTi9ToPssIEEE4BCommand command) {
    try {
      PssIEEE4BBusinessDelegate.getPssIEEE4BInstance().assignTi9(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ti9", exc);
    }
  }

  /**
   * unassign Ti9 on PssIEEE4B
   *
   * @param command UnAssignTi9FromPssIEEE4BCommand
   */
  @PutMapping("/unAssignTi9")
  public void unAssignTi9(@RequestBody(required = true) UnAssignTi9FromPssIEEE4BCommand command) {
    try {
      PssIEEE4BBusinessDelegate.getPssIEEE4BInstance().unAssignTi9(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ti9", exc);
    }
  }

  /**
   * save Tl1 on PssIEEE4B
   *
   * @param command AssignTl1ToPssIEEE4BCommand
   */
  @PutMapping("/assignTl1")
  public void assignTl1(@RequestBody AssignTl1ToPssIEEE4BCommand command) {
    try {
      PssIEEE4BBusinessDelegate.getPssIEEE4BInstance().assignTl1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tl1", exc);
    }
  }

  /**
   * unassign Tl1 on PssIEEE4B
   *
   * @param command UnAssignTl1FromPssIEEE4BCommand
   */
  @PutMapping("/unAssignTl1")
  public void unAssignTl1(@RequestBody(required = true) UnAssignTl1FromPssIEEE4BCommand command) {
    try {
      PssIEEE4BBusinessDelegate.getPssIEEE4BInstance().unAssignTl1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tl1", exc);
    }
  }

  /**
   * save Tl10 on PssIEEE4B
   *
   * @param command AssignTl10ToPssIEEE4BCommand
   */
  @PutMapping("/assignTl10")
  public void assignTl10(@RequestBody AssignTl10ToPssIEEE4BCommand command) {
    try {
      PssIEEE4BBusinessDelegate.getPssIEEE4BInstance().assignTl10(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tl10", exc);
    }
  }

  /**
   * unassign Tl10 on PssIEEE4B
   *
   * @param command UnAssignTl10FromPssIEEE4BCommand
   */
  @PutMapping("/unAssignTl10")
  public void unAssignTl10(@RequestBody(required = true) UnAssignTl10FromPssIEEE4BCommand command) {
    try {
      PssIEEE4BBusinessDelegate.getPssIEEE4BInstance().unAssignTl10(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tl10", exc);
    }
  }

  /**
   * save Tl11 on PssIEEE4B
   *
   * @param command AssignTl11ToPssIEEE4BCommand
   */
  @PutMapping("/assignTl11")
  public void assignTl11(@RequestBody AssignTl11ToPssIEEE4BCommand command) {
    try {
      PssIEEE4BBusinessDelegate.getPssIEEE4BInstance().assignTl11(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tl11", exc);
    }
  }

  /**
   * unassign Tl11 on PssIEEE4B
   *
   * @param command UnAssignTl11FromPssIEEE4BCommand
   */
  @PutMapping("/unAssignTl11")
  public void unAssignTl11(@RequestBody(required = true) UnAssignTl11FromPssIEEE4BCommand command) {
    try {
      PssIEEE4BBusinessDelegate.getPssIEEE4BInstance().unAssignTl11(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tl11", exc);
    }
  }

  /**
   * save Tl12 on PssIEEE4B
   *
   * @param command AssignTl12ToPssIEEE4BCommand
   */
  @PutMapping("/assignTl12")
  public void assignTl12(@RequestBody AssignTl12ToPssIEEE4BCommand command) {
    try {
      PssIEEE4BBusinessDelegate.getPssIEEE4BInstance().assignTl12(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tl12", exc);
    }
  }

  /**
   * unassign Tl12 on PssIEEE4B
   *
   * @param command UnAssignTl12FromPssIEEE4BCommand
   */
  @PutMapping("/unAssignTl12")
  public void unAssignTl12(@RequestBody(required = true) UnAssignTl12FromPssIEEE4BCommand command) {
    try {
      PssIEEE4BBusinessDelegate.getPssIEEE4BInstance().unAssignTl12(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tl12", exc);
    }
  }

  /**
   * save Tl2 on PssIEEE4B
   *
   * @param command AssignTl2ToPssIEEE4BCommand
   */
  @PutMapping("/assignTl2")
  public void assignTl2(@RequestBody AssignTl2ToPssIEEE4BCommand command) {
    try {
      PssIEEE4BBusinessDelegate.getPssIEEE4BInstance().assignTl2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tl2", exc);
    }
  }

  /**
   * unassign Tl2 on PssIEEE4B
   *
   * @param command UnAssignTl2FromPssIEEE4BCommand
   */
  @PutMapping("/unAssignTl2")
  public void unAssignTl2(@RequestBody(required = true) UnAssignTl2FromPssIEEE4BCommand command) {
    try {
      PssIEEE4BBusinessDelegate.getPssIEEE4BInstance().unAssignTl2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tl2", exc);
    }
  }

  /**
   * save Tl3 on PssIEEE4B
   *
   * @param command AssignTl3ToPssIEEE4BCommand
   */
  @PutMapping("/assignTl3")
  public void assignTl3(@RequestBody AssignTl3ToPssIEEE4BCommand command) {
    try {
      PssIEEE4BBusinessDelegate.getPssIEEE4BInstance().assignTl3(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tl3", exc);
    }
  }

  /**
   * unassign Tl3 on PssIEEE4B
   *
   * @param command UnAssignTl3FromPssIEEE4BCommand
   */
  @PutMapping("/unAssignTl3")
  public void unAssignTl3(@RequestBody(required = true) UnAssignTl3FromPssIEEE4BCommand command) {
    try {
      PssIEEE4BBusinessDelegate.getPssIEEE4BInstance().unAssignTl3(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tl3", exc);
    }
  }

  /**
   * save Tl4 on PssIEEE4B
   *
   * @param command AssignTl4ToPssIEEE4BCommand
   */
  @PutMapping("/assignTl4")
  public void assignTl4(@RequestBody AssignTl4ToPssIEEE4BCommand command) {
    try {
      PssIEEE4BBusinessDelegate.getPssIEEE4BInstance().assignTl4(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tl4", exc);
    }
  }

  /**
   * unassign Tl4 on PssIEEE4B
   *
   * @param command UnAssignTl4FromPssIEEE4BCommand
   */
  @PutMapping("/unAssignTl4")
  public void unAssignTl4(@RequestBody(required = true) UnAssignTl4FromPssIEEE4BCommand command) {
    try {
      PssIEEE4BBusinessDelegate.getPssIEEE4BInstance().unAssignTl4(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tl4", exc);
    }
  }

  /**
   * save Tl5 on PssIEEE4B
   *
   * @param command AssignTl5ToPssIEEE4BCommand
   */
  @PutMapping("/assignTl5")
  public void assignTl5(@RequestBody AssignTl5ToPssIEEE4BCommand command) {
    try {
      PssIEEE4BBusinessDelegate.getPssIEEE4BInstance().assignTl5(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tl5", exc);
    }
  }

  /**
   * unassign Tl5 on PssIEEE4B
   *
   * @param command UnAssignTl5FromPssIEEE4BCommand
   */
  @PutMapping("/unAssignTl5")
  public void unAssignTl5(@RequestBody(required = true) UnAssignTl5FromPssIEEE4BCommand command) {
    try {
      PssIEEE4BBusinessDelegate.getPssIEEE4BInstance().unAssignTl5(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tl5", exc);
    }
  }

  /**
   * save Tl6 on PssIEEE4B
   *
   * @param command AssignTl6ToPssIEEE4BCommand
   */
  @PutMapping("/assignTl6")
  public void assignTl6(@RequestBody AssignTl6ToPssIEEE4BCommand command) {
    try {
      PssIEEE4BBusinessDelegate.getPssIEEE4BInstance().assignTl6(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tl6", exc);
    }
  }

  /**
   * unassign Tl6 on PssIEEE4B
   *
   * @param command UnAssignTl6FromPssIEEE4BCommand
   */
  @PutMapping("/unAssignTl6")
  public void unAssignTl6(@RequestBody(required = true) UnAssignTl6FromPssIEEE4BCommand command) {
    try {
      PssIEEE4BBusinessDelegate.getPssIEEE4BInstance().unAssignTl6(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tl6", exc);
    }
  }

  /**
   * save Tl7 on PssIEEE4B
   *
   * @param command AssignTl7ToPssIEEE4BCommand
   */
  @PutMapping("/assignTl7")
  public void assignTl7(@RequestBody AssignTl7ToPssIEEE4BCommand command) {
    try {
      PssIEEE4BBusinessDelegate.getPssIEEE4BInstance().assignTl7(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tl7", exc);
    }
  }

  /**
   * unassign Tl7 on PssIEEE4B
   *
   * @param command UnAssignTl7FromPssIEEE4BCommand
   */
  @PutMapping("/unAssignTl7")
  public void unAssignTl7(@RequestBody(required = true) UnAssignTl7FromPssIEEE4BCommand command) {
    try {
      PssIEEE4BBusinessDelegate.getPssIEEE4BInstance().unAssignTl7(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tl7", exc);
    }
  }

  /**
   * save Tl8 on PssIEEE4B
   *
   * @param command AssignTl8ToPssIEEE4BCommand
   */
  @PutMapping("/assignTl8")
  public void assignTl8(@RequestBody AssignTl8ToPssIEEE4BCommand command) {
    try {
      PssIEEE4BBusinessDelegate.getPssIEEE4BInstance().assignTl8(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tl8", exc);
    }
  }

  /**
   * unassign Tl8 on PssIEEE4B
   *
   * @param command UnAssignTl8FromPssIEEE4BCommand
   */
  @PutMapping("/unAssignTl8")
  public void unAssignTl8(@RequestBody(required = true) UnAssignTl8FromPssIEEE4BCommand command) {
    try {
      PssIEEE4BBusinessDelegate.getPssIEEE4BInstance().unAssignTl8(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tl8", exc);
    }
  }

  /**
   * save Tl9 on PssIEEE4B
   *
   * @param command AssignTl9ToPssIEEE4BCommand
   */
  @PutMapping("/assignTl9")
  public void assignTl9(@RequestBody AssignTl9ToPssIEEE4BCommand command) {
    try {
      PssIEEE4BBusinessDelegate.getPssIEEE4BInstance().assignTl9(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tl9", exc);
    }
  }

  /**
   * unassign Tl9 on PssIEEE4B
   *
   * @param command UnAssignTl9FromPssIEEE4BCommand
   */
  @PutMapping("/unAssignTl9")
  public void unAssignTl9(@RequestBody(required = true) UnAssignTl9FromPssIEEE4BCommand command) {
    try {
      PssIEEE4BBusinessDelegate.getPssIEEE4BInstance().unAssignTl9(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tl9", exc);
    }
  }

  /**
   * save Vhmax on PssIEEE4B
   *
   * @param command AssignVhmaxToPssIEEE4BCommand
   */
  @PutMapping("/assignVhmax")
  public void assignVhmax(@RequestBody AssignVhmaxToPssIEEE4BCommand command) {
    try {
      PssIEEE4BBusinessDelegate.getPssIEEE4BInstance().assignVhmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vhmax", exc);
    }
  }

  /**
   * unassign Vhmax on PssIEEE4B
   *
   * @param command UnAssignVhmaxFromPssIEEE4BCommand
   */
  @PutMapping("/unAssignVhmax")
  public void unAssignVhmax(
      @RequestBody(required = true) UnAssignVhmaxFromPssIEEE4BCommand command) {
    try {
      PssIEEE4BBusinessDelegate.getPssIEEE4BInstance().unAssignVhmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vhmax", exc);
    }
  }

  /**
   * save Vhmin on PssIEEE4B
   *
   * @param command AssignVhminToPssIEEE4BCommand
   */
  @PutMapping("/assignVhmin")
  public void assignVhmin(@RequestBody AssignVhminToPssIEEE4BCommand command) {
    try {
      PssIEEE4BBusinessDelegate.getPssIEEE4BInstance().assignVhmin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vhmin", exc);
    }
  }

  /**
   * unassign Vhmin on PssIEEE4B
   *
   * @param command UnAssignVhminFromPssIEEE4BCommand
   */
  @PutMapping("/unAssignVhmin")
  public void unAssignVhmin(
      @RequestBody(required = true) UnAssignVhminFromPssIEEE4BCommand command) {
    try {
      PssIEEE4BBusinessDelegate.getPssIEEE4BInstance().unAssignVhmin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vhmin", exc);
    }
  }

  /**
   * save Vimax on PssIEEE4B
   *
   * @param command AssignVimaxToPssIEEE4BCommand
   */
  @PutMapping("/assignVimax")
  public void assignVimax(@RequestBody AssignVimaxToPssIEEE4BCommand command) {
    try {
      PssIEEE4BBusinessDelegate.getPssIEEE4BInstance().assignVimax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vimax", exc);
    }
  }

  /**
   * unassign Vimax on PssIEEE4B
   *
   * @param command UnAssignVimaxFromPssIEEE4BCommand
   */
  @PutMapping("/unAssignVimax")
  public void unAssignVimax(
      @RequestBody(required = true) UnAssignVimaxFromPssIEEE4BCommand command) {
    try {
      PssIEEE4BBusinessDelegate.getPssIEEE4BInstance().unAssignVimax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vimax", exc);
    }
  }

  /**
   * save Vimin on PssIEEE4B
   *
   * @param command AssignViminToPssIEEE4BCommand
   */
  @PutMapping("/assignVimin")
  public void assignVimin(@RequestBody AssignViminToPssIEEE4BCommand command) {
    try {
      PssIEEE4BBusinessDelegate.getPssIEEE4BInstance().assignVimin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vimin", exc);
    }
  }

  /**
   * unassign Vimin on PssIEEE4B
   *
   * @param command UnAssignViminFromPssIEEE4BCommand
   */
  @PutMapping("/unAssignVimin")
  public void unAssignVimin(
      @RequestBody(required = true) UnAssignViminFromPssIEEE4BCommand command) {
    try {
      PssIEEE4BBusinessDelegate.getPssIEEE4BInstance().unAssignVimin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vimin", exc);
    }
  }

  /**
   * save Vlmax on PssIEEE4B
   *
   * @param command AssignVlmaxToPssIEEE4BCommand
   */
  @PutMapping("/assignVlmax")
  public void assignVlmax(@RequestBody AssignVlmaxToPssIEEE4BCommand command) {
    try {
      PssIEEE4BBusinessDelegate.getPssIEEE4BInstance().assignVlmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vlmax", exc);
    }
  }

  /**
   * unassign Vlmax on PssIEEE4B
   *
   * @param command UnAssignVlmaxFromPssIEEE4BCommand
   */
  @PutMapping("/unAssignVlmax")
  public void unAssignVlmax(
      @RequestBody(required = true) UnAssignVlmaxFromPssIEEE4BCommand command) {
    try {
      PssIEEE4BBusinessDelegate.getPssIEEE4BInstance().unAssignVlmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vlmax", exc);
    }
  }

  /**
   * save Vlmin on PssIEEE4B
   *
   * @param command AssignVlminToPssIEEE4BCommand
   */
  @PutMapping("/assignVlmin")
  public void assignVlmin(@RequestBody AssignVlminToPssIEEE4BCommand command) {
    try {
      PssIEEE4BBusinessDelegate.getPssIEEE4BInstance().assignVlmin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vlmin", exc);
    }
  }

  /**
   * unassign Vlmin on PssIEEE4B
   *
   * @param command UnAssignVlminFromPssIEEE4BCommand
   */
  @PutMapping("/unAssignVlmin")
  public void unAssignVlmin(
      @RequestBody(required = true) UnAssignVlminFromPssIEEE4BCommand command) {
    try {
      PssIEEE4BBusinessDelegate.getPssIEEE4BInstance().unAssignVlmin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vlmin", exc);
    }
  }

  /**
   * save Vstmax on PssIEEE4B
   *
   * @param command AssignVstmaxToPssIEEE4BCommand
   */
  @PutMapping("/assignVstmax")
  public void assignVstmax(@RequestBody AssignVstmaxToPssIEEE4BCommand command) {
    try {
      PssIEEE4BBusinessDelegate.getPssIEEE4BInstance().assignVstmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vstmax", exc);
    }
  }

  /**
   * unassign Vstmax on PssIEEE4B
   *
   * @param command UnAssignVstmaxFromPssIEEE4BCommand
   */
  @PutMapping("/unAssignVstmax")
  public void unAssignVstmax(
      @RequestBody(required = true) UnAssignVstmaxFromPssIEEE4BCommand command) {
    try {
      PssIEEE4BBusinessDelegate.getPssIEEE4BInstance().unAssignVstmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vstmax", exc);
    }
  }

  /**
   * save Vstmin on PssIEEE4B
   *
   * @param command AssignVstminToPssIEEE4BCommand
   */
  @PutMapping("/assignVstmin")
  public void assignVstmin(@RequestBody AssignVstminToPssIEEE4BCommand command) {
    try {
      PssIEEE4BBusinessDelegate.getPssIEEE4BInstance().assignVstmin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vstmin", exc);
    }
  }

  /**
   * unassign Vstmin on PssIEEE4B
   *
   * @param command UnAssignVstminFromPssIEEE4BCommand
   */
  @PutMapping("/unAssignVstmin")
  public void unAssignVstmin(
      @RequestBody(required = true) UnAssignVstminFromPssIEEE4BCommand command) {
    try {
      PssIEEE4BBusinessDelegate.getPssIEEE4BInstance().unAssignVstmin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vstmin", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected PssIEEE4B pssIEEE4B = null;
  private static final Logger LOGGER =
      Logger.getLogger(PssIEEE4BCommandRestController.class.getName());
}
