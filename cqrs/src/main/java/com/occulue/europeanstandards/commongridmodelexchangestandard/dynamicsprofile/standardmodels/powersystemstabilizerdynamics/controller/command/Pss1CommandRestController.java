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
 * Implements Spring Controller command CQRS processing for entity Pss1.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/Pss1")
public class Pss1CommandRestController extends BaseSpringRestController {

  /**
   * Handles create a Pss1. if not key provided, calls create, otherwise calls save
   *
   * @param Pss1 pss1
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(@RequestBody(required = true) CreatePss1Command command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture = Pss1BusinessDelegate.getPss1Instance().createPss1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a Pss1. if no key provided, calls create, otherwise calls save
   *
   * @param Pss1 pss1
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(@RequestBody(required = true) UpdatePss1Command command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdatePss1Command
      // -----------------------------------------------
      completableFuture = Pss1BusinessDelegate.getPss1Instance().updatePss1(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "Pss1Controller:update() - successfully update Pss1 - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a Pss1 entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID pss1Id) {
    CompletableFuture<Void> completableFuture = null;
    DeletePss1Command command = new DeletePss1Command(pss1Id);

    try {
      Pss1BusinessDelegate delegate = Pss1BusinessDelegate.getPss1Instance();

      completableFuture = delegate.delete(command);
      LOGGER.log(Level.WARNING, "Successfully deleted Pss1 with key " + command.getPss1Id());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Kf on Pss1
   *
   * @param command AssignKfToPss1Command
   */
  @PutMapping("/assignKf")
  public void assignKf(@RequestBody AssignKfToPss1Command command) {
    try {
      Pss1BusinessDelegate.getPss1Instance().assignKf(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kf", exc);
    }
  }

  /**
   * unassign Kf on Pss1
   *
   * @param command UnAssignKfFromPss1Command
   */
  @PutMapping("/unAssignKf")
  public void unAssignKf(@RequestBody(required = true) UnAssignKfFromPss1Command command) {
    try {
      Pss1BusinessDelegate.getPss1Instance().unAssignKf(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kf", exc);
    }
  }

  /**
   * save Kpe on Pss1
   *
   * @param command AssignKpeToPss1Command
   */
  @PutMapping("/assignKpe")
  public void assignKpe(@RequestBody AssignKpeToPss1Command command) {
    try {
      Pss1BusinessDelegate.getPss1Instance().assignKpe(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kpe", exc);
    }
  }

  /**
   * unassign Kpe on Pss1
   *
   * @param command UnAssignKpeFromPss1Command
   */
  @PutMapping("/unAssignKpe")
  public void unAssignKpe(@RequestBody(required = true) UnAssignKpeFromPss1Command command) {
    try {
      Pss1BusinessDelegate.getPss1Instance().unAssignKpe(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kpe", exc);
    }
  }

  /**
   * save Ks on Pss1
   *
   * @param command AssignKsToPss1Command
   */
  @PutMapping("/assignKs")
  public void assignKs(@RequestBody AssignKsToPss1Command command) {
    try {
      Pss1BusinessDelegate.getPss1Instance().assignKs(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ks", exc);
    }
  }

  /**
   * unassign Ks on Pss1
   *
   * @param command UnAssignKsFromPss1Command
   */
  @PutMapping("/unAssignKs")
  public void unAssignKs(@RequestBody(required = true) UnAssignKsFromPss1Command command) {
    try {
      Pss1BusinessDelegate.getPss1Instance().unAssignKs(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ks", exc);
    }
  }

  /**
   * save Kw on Pss1
   *
   * @param command AssignKwToPss1Command
   */
  @PutMapping("/assignKw")
  public void assignKw(@RequestBody AssignKwToPss1Command command) {
    try {
      Pss1BusinessDelegate.getPss1Instance().assignKw(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kw", exc);
    }
  }

  /**
   * unassign Kw on Pss1
   *
   * @param command UnAssignKwFromPss1Command
   */
  @PutMapping("/unAssignKw")
  public void unAssignKw(@RequestBody(required = true) UnAssignKwFromPss1Command command) {
    try {
      Pss1BusinessDelegate.getPss1Instance().unAssignKw(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kw", exc);
    }
  }

  /**
   * save Pmin on Pss1
   *
   * @param command AssignPminToPss1Command
   */
  @PutMapping("/assignPmin")
  public void assignPmin(@RequestBody AssignPminToPss1Command command) {
    try {
      Pss1BusinessDelegate.getPss1Instance().assignPmin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Pmin", exc);
    }
  }

  /**
   * unassign Pmin on Pss1
   *
   * @param command UnAssignPminFromPss1Command
   */
  @PutMapping("/unAssignPmin")
  public void unAssignPmin(@RequestBody(required = true) UnAssignPminFromPss1Command command) {
    try {
      Pss1BusinessDelegate.getPss1Instance().unAssignPmin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Pmin", exc);
    }
  }

  /**
   * save T10 on Pss1
   *
   * @param command AssignT10ToPss1Command
   */
  @PutMapping("/assignT10")
  public void assignT10(@RequestBody AssignT10ToPss1Command command) {
    try {
      Pss1BusinessDelegate.getPss1Instance().assignT10(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T10", exc);
    }
  }

  /**
   * unassign T10 on Pss1
   *
   * @param command UnAssignT10FromPss1Command
   */
  @PutMapping("/unAssignT10")
  public void unAssignT10(@RequestBody(required = true) UnAssignT10FromPss1Command command) {
    try {
      Pss1BusinessDelegate.getPss1Instance().unAssignT10(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T10", exc);
    }
  }

  /**
   * save T5 on Pss1
   *
   * @param command AssignT5ToPss1Command
   */
  @PutMapping("/assignT5")
  public void assignT5(@RequestBody AssignT5ToPss1Command command) {
    try {
      Pss1BusinessDelegate.getPss1Instance().assignT5(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T5", exc);
    }
  }

  /**
   * unassign T5 on Pss1
   *
   * @param command UnAssignT5FromPss1Command
   */
  @PutMapping("/unAssignT5")
  public void unAssignT5(@RequestBody(required = true) UnAssignT5FromPss1Command command) {
    try {
      Pss1BusinessDelegate.getPss1Instance().unAssignT5(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T5", exc);
    }
  }

  /**
   * save T6 on Pss1
   *
   * @param command AssignT6ToPss1Command
   */
  @PutMapping("/assignT6")
  public void assignT6(@RequestBody AssignT6ToPss1Command command) {
    try {
      Pss1BusinessDelegate.getPss1Instance().assignT6(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T6", exc);
    }
  }

  /**
   * unassign T6 on Pss1
   *
   * @param command UnAssignT6FromPss1Command
   */
  @PutMapping("/unAssignT6")
  public void unAssignT6(@RequestBody(required = true) UnAssignT6FromPss1Command command) {
    try {
      Pss1BusinessDelegate.getPss1Instance().unAssignT6(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T6", exc);
    }
  }

  /**
   * save T7 on Pss1
   *
   * @param command AssignT7ToPss1Command
   */
  @PutMapping("/assignT7")
  public void assignT7(@RequestBody AssignT7ToPss1Command command) {
    try {
      Pss1BusinessDelegate.getPss1Instance().assignT7(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T7", exc);
    }
  }

  /**
   * unassign T7 on Pss1
   *
   * @param command UnAssignT7FromPss1Command
   */
  @PutMapping("/unAssignT7")
  public void unAssignT7(@RequestBody(required = true) UnAssignT7FromPss1Command command) {
    try {
      Pss1BusinessDelegate.getPss1Instance().unAssignT7(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T7", exc);
    }
  }

  /**
   * save T8 on Pss1
   *
   * @param command AssignT8ToPss1Command
   */
  @PutMapping("/assignT8")
  public void assignT8(@RequestBody AssignT8ToPss1Command command) {
    try {
      Pss1BusinessDelegate.getPss1Instance().assignT8(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T8", exc);
    }
  }

  /**
   * unassign T8 on Pss1
   *
   * @param command UnAssignT8FromPss1Command
   */
  @PutMapping("/unAssignT8")
  public void unAssignT8(@RequestBody(required = true) UnAssignT8FromPss1Command command) {
    try {
      Pss1BusinessDelegate.getPss1Instance().unAssignT8(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T8", exc);
    }
  }

  /**
   * save T9 on Pss1
   *
   * @param command AssignT9ToPss1Command
   */
  @PutMapping("/assignT9")
  public void assignT9(@RequestBody AssignT9ToPss1Command command) {
    try {
      Pss1BusinessDelegate.getPss1Instance().assignT9(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T9", exc);
    }
  }

  /**
   * unassign T9 on Pss1
   *
   * @param command UnAssignT9FromPss1Command
   */
  @PutMapping("/unAssignT9")
  public void unAssignT9(@RequestBody(required = true) UnAssignT9FromPss1Command command) {
    try {
      Pss1BusinessDelegate.getPss1Instance().unAssignT9(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T9", exc);
    }
  }

  /**
   * save Tpe on Pss1
   *
   * @param command AssignTpeToPss1Command
   */
  @PutMapping("/assignTpe")
  public void assignTpe(@RequestBody AssignTpeToPss1Command command) {
    try {
      Pss1BusinessDelegate.getPss1Instance().assignTpe(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tpe", exc);
    }
  }

  /**
   * unassign Tpe on Pss1
   *
   * @param command UnAssignTpeFromPss1Command
   */
  @PutMapping("/unAssignTpe")
  public void unAssignTpe(@RequestBody(required = true) UnAssignTpeFromPss1Command command) {
    try {
      Pss1BusinessDelegate.getPss1Instance().unAssignTpe(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tpe", exc);
    }
  }

  /**
   * save Vadat on Pss1
   *
   * @param command AssignVadatToPss1Command
   */
  @PutMapping("/assignVadat")
  public void assignVadat(@RequestBody AssignVadatToPss1Command command) {
    try {
      Pss1BusinessDelegate.getPss1Instance().assignVadat(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vadat", exc);
    }
  }

  /**
   * unassign Vadat on Pss1
   *
   * @param command UnAssignVadatFromPss1Command
   */
  @PutMapping("/unAssignVadat")
  public void unAssignVadat(@RequestBody(required = true) UnAssignVadatFromPss1Command command) {
    try {
      Pss1BusinessDelegate.getPss1Instance().unAssignVadat(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vadat", exc);
    }
  }

  /**
   * save Vsmn on Pss1
   *
   * @param command AssignVsmnToPss1Command
   */
  @PutMapping("/assignVsmn")
  public void assignVsmn(@RequestBody AssignVsmnToPss1Command command) {
    try {
      Pss1BusinessDelegate.getPss1Instance().assignVsmn(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vsmn", exc);
    }
  }

  /**
   * unassign Vsmn on Pss1
   *
   * @param command UnAssignVsmnFromPss1Command
   */
  @PutMapping("/unAssignVsmn")
  public void unAssignVsmn(@RequestBody(required = true) UnAssignVsmnFromPss1Command command) {
    try {
      Pss1BusinessDelegate.getPss1Instance().unAssignVsmn(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vsmn", exc);
    }
  }

  /**
   * save Vsmx on Pss1
   *
   * @param command AssignVsmxToPss1Command
   */
  @PutMapping("/assignVsmx")
  public void assignVsmx(@RequestBody AssignVsmxToPss1Command command) {
    try {
      Pss1BusinessDelegate.getPss1Instance().assignVsmx(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vsmx", exc);
    }
  }

  /**
   * unassign Vsmx on Pss1
   *
   * @param command UnAssignVsmxFromPss1Command
   */
  @PutMapping("/unAssignVsmx")
  public void unAssignVsmx(@RequestBody(required = true) UnAssignVsmxFromPss1Command command) {
    try {
      Pss1BusinessDelegate.getPss1Instance().unAssignVsmx(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vsmx", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected Pss1 pss1 = null;
  private static final Logger LOGGER = Logger.getLogger(Pss1CommandRestController.class.getName());
}
