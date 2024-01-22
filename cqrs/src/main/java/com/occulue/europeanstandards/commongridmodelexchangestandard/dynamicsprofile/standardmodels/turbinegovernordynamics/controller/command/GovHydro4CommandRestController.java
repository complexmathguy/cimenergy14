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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.turbinegovernordynamics.controller.command;

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
 * Implements Spring Controller command CQRS processing for entity GovHydro4.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/GovHydro4")
public class GovHydro4CommandRestController extends BaseSpringRestController {

  /**
   * Handles create a GovHydro4. if not key provided, calls create, otherwise calls save
   *
   * @param GovHydro4 govHydro4
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateGovHydro4Command command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture = GovHydro4BusinessDelegate.getGovHydro4Instance().createGovHydro4(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a GovHydro4. if no key provided, calls create, otherwise calls save
   *
   * @param GovHydro4 govHydro4
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateGovHydro4Command command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateGovHydro4Command
      // -----------------------------------------------
      completableFuture = GovHydro4BusinessDelegate.getGovHydro4Instance().updateGovHydro4(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "GovHydro4Controller:update() - successfully update GovHydro4 - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a GovHydro4 entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID govHydro4Id) {
    CompletableFuture<Void> completableFuture = null;
    DeleteGovHydro4Command command = new DeleteGovHydro4Command(govHydro4Id);

    try {
      GovHydro4BusinessDelegate delegate = GovHydro4BusinessDelegate.getGovHydro4Instance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING, "Successfully deleted GovHydro4 with key " + command.getGovHydro4Id());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save At on GovHydro4
   *
   * @param command AssignAtToGovHydro4Command
   */
  @PutMapping("/assignAt")
  public void assignAt(@RequestBody AssignAtToGovHydro4Command command) {
    try {
      GovHydro4BusinessDelegate.getGovHydro4Instance().assignAt(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign At", exc);
    }
  }

  /**
   * unassign At on GovHydro4
   *
   * @param command UnAssignAtFromGovHydro4Command
   */
  @PutMapping("/unAssignAt")
  public void unAssignAt(@RequestBody(required = true) UnAssignAtFromGovHydro4Command command) {
    try {
      GovHydro4BusinessDelegate.getGovHydro4Instance().unAssignAt(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign At", exc);
    }
  }

  /**
   * save Bgv0 on GovHydro4
   *
   * @param command AssignBgv0ToGovHydro4Command
   */
  @PutMapping("/assignBgv0")
  public void assignBgv0(@RequestBody AssignBgv0ToGovHydro4Command command) {
    try {
      GovHydro4BusinessDelegate.getGovHydro4Instance().assignBgv0(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Bgv0", exc);
    }
  }

  /**
   * unassign Bgv0 on GovHydro4
   *
   * @param command UnAssignBgv0FromGovHydro4Command
   */
  @PutMapping("/unAssignBgv0")
  public void unAssignBgv0(@RequestBody(required = true) UnAssignBgv0FromGovHydro4Command command) {
    try {
      GovHydro4BusinessDelegate.getGovHydro4Instance().unAssignBgv0(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Bgv0", exc);
    }
  }

  /**
   * save Bgv1 on GovHydro4
   *
   * @param command AssignBgv1ToGovHydro4Command
   */
  @PutMapping("/assignBgv1")
  public void assignBgv1(@RequestBody AssignBgv1ToGovHydro4Command command) {
    try {
      GovHydro4BusinessDelegate.getGovHydro4Instance().assignBgv1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Bgv1", exc);
    }
  }

  /**
   * unassign Bgv1 on GovHydro4
   *
   * @param command UnAssignBgv1FromGovHydro4Command
   */
  @PutMapping("/unAssignBgv1")
  public void unAssignBgv1(@RequestBody(required = true) UnAssignBgv1FromGovHydro4Command command) {
    try {
      GovHydro4BusinessDelegate.getGovHydro4Instance().unAssignBgv1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Bgv1", exc);
    }
  }

  /**
   * save Bgv2 on GovHydro4
   *
   * @param command AssignBgv2ToGovHydro4Command
   */
  @PutMapping("/assignBgv2")
  public void assignBgv2(@RequestBody AssignBgv2ToGovHydro4Command command) {
    try {
      GovHydro4BusinessDelegate.getGovHydro4Instance().assignBgv2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Bgv2", exc);
    }
  }

  /**
   * unassign Bgv2 on GovHydro4
   *
   * @param command UnAssignBgv2FromGovHydro4Command
   */
  @PutMapping("/unAssignBgv2")
  public void unAssignBgv2(@RequestBody(required = true) UnAssignBgv2FromGovHydro4Command command) {
    try {
      GovHydro4BusinessDelegate.getGovHydro4Instance().unAssignBgv2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Bgv2", exc);
    }
  }

  /**
   * save Bgv3 on GovHydro4
   *
   * @param command AssignBgv3ToGovHydro4Command
   */
  @PutMapping("/assignBgv3")
  public void assignBgv3(@RequestBody AssignBgv3ToGovHydro4Command command) {
    try {
      GovHydro4BusinessDelegate.getGovHydro4Instance().assignBgv3(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Bgv3", exc);
    }
  }

  /**
   * unassign Bgv3 on GovHydro4
   *
   * @param command UnAssignBgv3FromGovHydro4Command
   */
  @PutMapping("/unAssignBgv3")
  public void unAssignBgv3(@RequestBody(required = true) UnAssignBgv3FromGovHydro4Command command) {
    try {
      GovHydro4BusinessDelegate.getGovHydro4Instance().unAssignBgv3(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Bgv3", exc);
    }
  }

  /**
   * save Bgv4 on GovHydro4
   *
   * @param command AssignBgv4ToGovHydro4Command
   */
  @PutMapping("/assignBgv4")
  public void assignBgv4(@RequestBody AssignBgv4ToGovHydro4Command command) {
    try {
      GovHydro4BusinessDelegate.getGovHydro4Instance().assignBgv4(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Bgv4", exc);
    }
  }

  /**
   * unassign Bgv4 on GovHydro4
   *
   * @param command UnAssignBgv4FromGovHydro4Command
   */
  @PutMapping("/unAssignBgv4")
  public void unAssignBgv4(@RequestBody(required = true) UnAssignBgv4FromGovHydro4Command command) {
    try {
      GovHydro4BusinessDelegate.getGovHydro4Instance().unAssignBgv4(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Bgv4", exc);
    }
  }

  /**
   * save Bgv5 on GovHydro4
   *
   * @param command AssignBgv5ToGovHydro4Command
   */
  @PutMapping("/assignBgv5")
  public void assignBgv5(@RequestBody AssignBgv5ToGovHydro4Command command) {
    try {
      GovHydro4BusinessDelegate.getGovHydro4Instance().assignBgv5(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Bgv5", exc);
    }
  }

  /**
   * unassign Bgv5 on GovHydro4
   *
   * @param command UnAssignBgv5FromGovHydro4Command
   */
  @PutMapping("/unAssignBgv5")
  public void unAssignBgv5(@RequestBody(required = true) UnAssignBgv5FromGovHydro4Command command) {
    try {
      GovHydro4BusinessDelegate.getGovHydro4Instance().unAssignBgv5(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Bgv5", exc);
    }
  }

  /**
   * save Bmax on GovHydro4
   *
   * @param command AssignBmaxToGovHydro4Command
   */
  @PutMapping("/assignBmax")
  public void assignBmax(@RequestBody AssignBmaxToGovHydro4Command command) {
    try {
      GovHydro4BusinessDelegate.getGovHydro4Instance().assignBmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Bmax", exc);
    }
  }

  /**
   * unassign Bmax on GovHydro4
   *
   * @param command UnAssignBmaxFromGovHydro4Command
   */
  @PutMapping("/unAssignBmax")
  public void unAssignBmax(@RequestBody(required = true) UnAssignBmaxFromGovHydro4Command command) {
    try {
      GovHydro4BusinessDelegate.getGovHydro4Instance().unAssignBmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Bmax", exc);
    }
  }

  /**
   * save Db1 on GovHydro4
   *
   * @param command AssignDb1ToGovHydro4Command
   */
  @PutMapping("/assignDb1")
  public void assignDb1(@RequestBody AssignDb1ToGovHydro4Command command) {
    try {
      GovHydro4BusinessDelegate.getGovHydro4Instance().assignDb1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Db1", exc);
    }
  }

  /**
   * unassign Db1 on GovHydro4
   *
   * @param command UnAssignDb1FromGovHydro4Command
   */
  @PutMapping("/unAssignDb1")
  public void unAssignDb1(@RequestBody(required = true) UnAssignDb1FromGovHydro4Command command) {
    try {
      GovHydro4BusinessDelegate.getGovHydro4Instance().unAssignDb1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Db1", exc);
    }
  }

  /**
   * save Db2 on GovHydro4
   *
   * @param command AssignDb2ToGovHydro4Command
   */
  @PutMapping("/assignDb2")
  public void assignDb2(@RequestBody AssignDb2ToGovHydro4Command command) {
    try {
      GovHydro4BusinessDelegate.getGovHydro4Instance().assignDb2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Db2", exc);
    }
  }

  /**
   * unassign Db2 on GovHydro4
   *
   * @param command UnAssignDb2FromGovHydro4Command
   */
  @PutMapping("/unAssignDb2")
  public void unAssignDb2(@RequestBody(required = true) UnAssignDb2FromGovHydro4Command command) {
    try {
      GovHydro4BusinessDelegate.getGovHydro4Instance().unAssignDb2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Db2", exc);
    }
  }

  /**
   * save Dturb on GovHydro4
   *
   * @param command AssignDturbToGovHydro4Command
   */
  @PutMapping("/assignDturb")
  public void assignDturb(@RequestBody AssignDturbToGovHydro4Command command) {
    try {
      GovHydro4BusinessDelegate.getGovHydro4Instance().assignDturb(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Dturb", exc);
    }
  }

  /**
   * unassign Dturb on GovHydro4
   *
   * @param command UnAssignDturbFromGovHydro4Command
   */
  @PutMapping("/unAssignDturb")
  public void unAssignDturb(
      @RequestBody(required = true) UnAssignDturbFromGovHydro4Command command) {
    try {
      GovHydro4BusinessDelegate.getGovHydro4Instance().unAssignDturb(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Dturb", exc);
    }
  }

  /**
   * save Eps on GovHydro4
   *
   * @param command AssignEpsToGovHydro4Command
   */
  @PutMapping("/assignEps")
  public void assignEps(@RequestBody AssignEpsToGovHydro4Command command) {
    try {
      GovHydro4BusinessDelegate.getGovHydro4Instance().assignEps(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Eps", exc);
    }
  }

  /**
   * unassign Eps on GovHydro4
   *
   * @param command UnAssignEpsFromGovHydro4Command
   */
  @PutMapping("/unAssignEps")
  public void unAssignEps(@RequestBody(required = true) UnAssignEpsFromGovHydro4Command command) {
    try {
      GovHydro4BusinessDelegate.getGovHydro4Instance().unAssignEps(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Eps", exc);
    }
  }

  /**
   * save Gmax on GovHydro4
   *
   * @param command AssignGmaxToGovHydro4Command
   */
  @PutMapping("/assignGmax")
  public void assignGmax(@RequestBody AssignGmaxToGovHydro4Command command) {
    try {
      GovHydro4BusinessDelegate.getGovHydro4Instance().assignGmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Gmax", exc);
    }
  }

  /**
   * unassign Gmax on GovHydro4
   *
   * @param command UnAssignGmaxFromGovHydro4Command
   */
  @PutMapping("/unAssignGmax")
  public void unAssignGmax(@RequestBody(required = true) UnAssignGmaxFromGovHydro4Command command) {
    try {
      GovHydro4BusinessDelegate.getGovHydro4Instance().unAssignGmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Gmax", exc);
    }
  }

  /**
   * save Gmin on GovHydro4
   *
   * @param command AssignGminToGovHydro4Command
   */
  @PutMapping("/assignGmin")
  public void assignGmin(@RequestBody AssignGminToGovHydro4Command command) {
    try {
      GovHydro4BusinessDelegate.getGovHydro4Instance().assignGmin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Gmin", exc);
    }
  }

  /**
   * unassign Gmin on GovHydro4
   *
   * @param command UnAssignGminFromGovHydro4Command
   */
  @PutMapping("/unAssignGmin")
  public void unAssignGmin(@RequestBody(required = true) UnAssignGminFromGovHydro4Command command) {
    try {
      GovHydro4BusinessDelegate.getGovHydro4Instance().unAssignGmin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Gmin", exc);
    }
  }

  /**
   * save Gv0 on GovHydro4
   *
   * @param command AssignGv0ToGovHydro4Command
   */
  @PutMapping("/assignGv0")
  public void assignGv0(@RequestBody AssignGv0ToGovHydro4Command command) {
    try {
      GovHydro4BusinessDelegate.getGovHydro4Instance().assignGv0(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Gv0", exc);
    }
  }

  /**
   * unassign Gv0 on GovHydro4
   *
   * @param command UnAssignGv0FromGovHydro4Command
   */
  @PutMapping("/unAssignGv0")
  public void unAssignGv0(@RequestBody(required = true) UnAssignGv0FromGovHydro4Command command) {
    try {
      GovHydro4BusinessDelegate.getGovHydro4Instance().unAssignGv0(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Gv0", exc);
    }
  }

  /**
   * save Gv1 on GovHydro4
   *
   * @param command AssignGv1ToGovHydro4Command
   */
  @PutMapping("/assignGv1")
  public void assignGv1(@RequestBody AssignGv1ToGovHydro4Command command) {
    try {
      GovHydro4BusinessDelegate.getGovHydro4Instance().assignGv1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Gv1", exc);
    }
  }

  /**
   * unassign Gv1 on GovHydro4
   *
   * @param command UnAssignGv1FromGovHydro4Command
   */
  @PutMapping("/unAssignGv1")
  public void unAssignGv1(@RequestBody(required = true) UnAssignGv1FromGovHydro4Command command) {
    try {
      GovHydro4BusinessDelegate.getGovHydro4Instance().unAssignGv1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Gv1", exc);
    }
  }

  /**
   * save Gv2 on GovHydro4
   *
   * @param command AssignGv2ToGovHydro4Command
   */
  @PutMapping("/assignGv2")
  public void assignGv2(@RequestBody AssignGv2ToGovHydro4Command command) {
    try {
      GovHydro4BusinessDelegate.getGovHydro4Instance().assignGv2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Gv2", exc);
    }
  }

  /**
   * unassign Gv2 on GovHydro4
   *
   * @param command UnAssignGv2FromGovHydro4Command
   */
  @PutMapping("/unAssignGv2")
  public void unAssignGv2(@RequestBody(required = true) UnAssignGv2FromGovHydro4Command command) {
    try {
      GovHydro4BusinessDelegate.getGovHydro4Instance().unAssignGv2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Gv2", exc);
    }
  }

  /**
   * save Gv3 on GovHydro4
   *
   * @param command AssignGv3ToGovHydro4Command
   */
  @PutMapping("/assignGv3")
  public void assignGv3(@RequestBody AssignGv3ToGovHydro4Command command) {
    try {
      GovHydro4BusinessDelegate.getGovHydro4Instance().assignGv3(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Gv3", exc);
    }
  }

  /**
   * unassign Gv3 on GovHydro4
   *
   * @param command UnAssignGv3FromGovHydro4Command
   */
  @PutMapping("/unAssignGv3")
  public void unAssignGv3(@RequestBody(required = true) UnAssignGv3FromGovHydro4Command command) {
    try {
      GovHydro4BusinessDelegate.getGovHydro4Instance().unAssignGv3(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Gv3", exc);
    }
  }

  /**
   * save Gv4 on GovHydro4
   *
   * @param command AssignGv4ToGovHydro4Command
   */
  @PutMapping("/assignGv4")
  public void assignGv4(@RequestBody AssignGv4ToGovHydro4Command command) {
    try {
      GovHydro4BusinessDelegate.getGovHydro4Instance().assignGv4(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Gv4", exc);
    }
  }

  /**
   * unassign Gv4 on GovHydro4
   *
   * @param command UnAssignGv4FromGovHydro4Command
   */
  @PutMapping("/unAssignGv4")
  public void unAssignGv4(@RequestBody(required = true) UnAssignGv4FromGovHydro4Command command) {
    try {
      GovHydro4BusinessDelegate.getGovHydro4Instance().unAssignGv4(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Gv4", exc);
    }
  }

  /**
   * save Gv5 on GovHydro4
   *
   * @param command AssignGv5ToGovHydro4Command
   */
  @PutMapping("/assignGv5")
  public void assignGv5(@RequestBody AssignGv5ToGovHydro4Command command) {
    try {
      GovHydro4BusinessDelegate.getGovHydro4Instance().assignGv5(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Gv5", exc);
    }
  }

  /**
   * unassign Gv5 on GovHydro4
   *
   * @param command UnAssignGv5FromGovHydro4Command
   */
  @PutMapping("/unAssignGv5")
  public void unAssignGv5(@RequestBody(required = true) UnAssignGv5FromGovHydro4Command command) {
    try {
      GovHydro4BusinessDelegate.getGovHydro4Instance().unAssignGv5(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Gv5", exc);
    }
  }

  /**
   * save Hdam on GovHydro4
   *
   * @param command AssignHdamToGovHydro4Command
   */
  @PutMapping("/assignHdam")
  public void assignHdam(@RequestBody AssignHdamToGovHydro4Command command) {
    try {
      GovHydro4BusinessDelegate.getGovHydro4Instance().assignHdam(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Hdam", exc);
    }
  }

  /**
   * unassign Hdam on GovHydro4
   *
   * @param command UnAssignHdamFromGovHydro4Command
   */
  @PutMapping("/unAssignHdam")
  public void unAssignHdam(@RequestBody(required = true) UnAssignHdamFromGovHydro4Command command) {
    try {
      GovHydro4BusinessDelegate.getGovHydro4Instance().unAssignHdam(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Hdam", exc);
    }
  }

  /**
   * save Mwbase on GovHydro4
   *
   * @param command AssignMwbaseToGovHydro4Command
   */
  @PutMapping("/assignMwbase")
  public void assignMwbase(@RequestBody AssignMwbaseToGovHydro4Command command) {
    try {
      GovHydro4BusinessDelegate.getGovHydro4Instance().assignMwbase(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Mwbase", exc);
    }
  }

  /**
   * unassign Mwbase on GovHydro4
   *
   * @param command UnAssignMwbaseFromGovHydro4Command
   */
  @PutMapping("/unAssignMwbase")
  public void unAssignMwbase(
      @RequestBody(required = true) UnAssignMwbaseFromGovHydro4Command command) {
    try {
      GovHydro4BusinessDelegate.getGovHydro4Instance().unAssignMwbase(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Mwbase", exc);
    }
  }

  /**
   * save Pgv0 on GovHydro4
   *
   * @param command AssignPgv0ToGovHydro4Command
   */
  @PutMapping("/assignPgv0")
  public void assignPgv0(@RequestBody AssignPgv0ToGovHydro4Command command) {
    try {
      GovHydro4BusinessDelegate.getGovHydro4Instance().assignPgv0(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Pgv0", exc);
    }
  }

  /**
   * unassign Pgv0 on GovHydro4
   *
   * @param command UnAssignPgv0FromGovHydro4Command
   */
  @PutMapping("/unAssignPgv0")
  public void unAssignPgv0(@RequestBody(required = true) UnAssignPgv0FromGovHydro4Command command) {
    try {
      GovHydro4BusinessDelegate.getGovHydro4Instance().unAssignPgv0(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Pgv0", exc);
    }
  }

  /**
   * save Pgv1 on GovHydro4
   *
   * @param command AssignPgv1ToGovHydro4Command
   */
  @PutMapping("/assignPgv1")
  public void assignPgv1(@RequestBody AssignPgv1ToGovHydro4Command command) {
    try {
      GovHydro4BusinessDelegate.getGovHydro4Instance().assignPgv1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Pgv1", exc);
    }
  }

  /**
   * unassign Pgv1 on GovHydro4
   *
   * @param command UnAssignPgv1FromGovHydro4Command
   */
  @PutMapping("/unAssignPgv1")
  public void unAssignPgv1(@RequestBody(required = true) UnAssignPgv1FromGovHydro4Command command) {
    try {
      GovHydro4BusinessDelegate.getGovHydro4Instance().unAssignPgv1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Pgv1", exc);
    }
  }

  /**
   * save Pgv2 on GovHydro4
   *
   * @param command AssignPgv2ToGovHydro4Command
   */
  @PutMapping("/assignPgv2")
  public void assignPgv2(@RequestBody AssignPgv2ToGovHydro4Command command) {
    try {
      GovHydro4BusinessDelegate.getGovHydro4Instance().assignPgv2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Pgv2", exc);
    }
  }

  /**
   * unassign Pgv2 on GovHydro4
   *
   * @param command UnAssignPgv2FromGovHydro4Command
   */
  @PutMapping("/unAssignPgv2")
  public void unAssignPgv2(@RequestBody(required = true) UnAssignPgv2FromGovHydro4Command command) {
    try {
      GovHydro4BusinessDelegate.getGovHydro4Instance().unAssignPgv2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Pgv2", exc);
    }
  }

  /**
   * save Pgv3 on GovHydro4
   *
   * @param command AssignPgv3ToGovHydro4Command
   */
  @PutMapping("/assignPgv3")
  public void assignPgv3(@RequestBody AssignPgv3ToGovHydro4Command command) {
    try {
      GovHydro4BusinessDelegate.getGovHydro4Instance().assignPgv3(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Pgv3", exc);
    }
  }

  /**
   * unassign Pgv3 on GovHydro4
   *
   * @param command UnAssignPgv3FromGovHydro4Command
   */
  @PutMapping("/unAssignPgv3")
  public void unAssignPgv3(@RequestBody(required = true) UnAssignPgv3FromGovHydro4Command command) {
    try {
      GovHydro4BusinessDelegate.getGovHydro4Instance().unAssignPgv3(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Pgv3", exc);
    }
  }

  /**
   * save Pgv4 on GovHydro4
   *
   * @param command AssignPgv4ToGovHydro4Command
   */
  @PutMapping("/assignPgv4")
  public void assignPgv4(@RequestBody AssignPgv4ToGovHydro4Command command) {
    try {
      GovHydro4BusinessDelegate.getGovHydro4Instance().assignPgv4(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Pgv4", exc);
    }
  }

  /**
   * unassign Pgv4 on GovHydro4
   *
   * @param command UnAssignPgv4FromGovHydro4Command
   */
  @PutMapping("/unAssignPgv4")
  public void unAssignPgv4(@RequestBody(required = true) UnAssignPgv4FromGovHydro4Command command) {
    try {
      GovHydro4BusinessDelegate.getGovHydro4Instance().unAssignPgv4(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Pgv4", exc);
    }
  }

  /**
   * save Pgv5 on GovHydro4
   *
   * @param command AssignPgv5ToGovHydro4Command
   */
  @PutMapping("/assignPgv5")
  public void assignPgv5(@RequestBody AssignPgv5ToGovHydro4Command command) {
    try {
      GovHydro4BusinessDelegate.getGovHydro4Instance().assignPgv5(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Pgv5", exc);
    }
  }

  /**
   * unassign Pgv5 on GovHydro4
   *
   * @param command UnAssignPgv5FromGovHydro4Command
   */
  @PutMapping("/unAssignPgv5")
  public void unAssignPgv5(@RequestBody(required = true) UnAssignPgv5FromGovHydro4Command command) {
    try {
      GovHydro4BusinessDelegate.getGovHydro4Instance().unAssignPgv5(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Pgv5", exc);
    }
  }

  /**
   * save Qn1 on GovHydro4
   *
   * @param command AssignQn1ToGovHydro4Command
   */
  @PutMapping("/assignQn1")
  public void assignQn1(@RequestBody AssignQn1ToGovHydro4Command command) {
    try {
      GovHydro4BusinessDelegate.getGovHydro4Instance().assignQn1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Qn1", exc);
    }
  }

  /**
   * unassign Qn1 on GovHydro4
   *
   * @param command UnAssignQn1FromGovHydro4Command
   */
  @PutMapping("/unAssignQn1")
  public void unAssignQn1(@RequestBody(required = true) UnAssignQn1FromGovHydro4Command command) {
    try {
      GovHydro4BusinessDelegate.getGovHydro4Instance().unAssignQn1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Qn1", exc);
    }
  }

  /**
   * save Rperm on GovHydro4
   *
   * @param command AssignRpermToGovHydro4Command
   */
  @PutMapping("/assignRperm")
  public void assignRperm(@RequestBody AssignRpermToGovHydro4Command command) {
    try {
      GovHydro4BusinessDelegate.getGovHydro4Instance().assignRperm(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Rperm", exc);
    }
  }

  /**
   * unassign Rperm on GovHydro4
   *
   * @param command UnAssignRpermFromGovHydro4Command
   */
  @PutMapping("/unAssignRperm")
  public void unAssignRperm(
      @RequestBody(required = true) UnAssignRpermFromGovHydro4Command command) {
    try {
      GovHydro4BusinessDelegate.getGovHydro4Instance().unAssignRperm(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Rperm", exc);
    }
  }

  /**
   * save Rtemp on GovHydro4
   *
   * @param command AssignRtempToGovHydro4Command
   */
  @PutMapping("/assignRtemp")
  public void assignRtemp(@RequestBody AssignRtempToGovHydro4Command command) {
    try {
      GovHydro4BusinessDelegate.getGovHydro4Instance().assignRtemp(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Rtemp", exc);
    }
  }

  /**
   * unassign Rtemp on GovHydro4
   *
   * @param command UnAssignRtempFromGovHydro4Command
   */
  @PutMapping("/unAssignRtemp")
  public void unAssignRtemp(
      @RequestBody(required = true) UnAssignRtempFromGovHydro4Command command) {
    try {
      GovHydro4BusinessDelegate.getGovHydro4Instance().unAssignRtemp(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Rtemp", exc);
    }
  }

  /**
   * save Tblade on GovHydro4
   *
   * @param command AssignTbladeToGovHydro4Command
   */
  @PutMapping("/assignTblade")
  public void assignTblade(@RequestBody AssignTbladeToGovHydro4Command command) {
    try {
      GovHydro4BusinessDelegate.getGovHydro4Instance().assignTblade(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tblade", exc);
    }
  }

  /**
   * unassign Tblade on GovHydro4
   *
   * @param command UnAssignTbladeFromGovHydro4Command
   */
  @PutMapping("/unAssignTblade")
  public void unAssignTblade(
      @RequestBody(required = true) UnAssignTbladeFromGovHydro4Command command) {
    try {
      GovHydro4BusinessDelegate.getGovHydro4Instance().unAssignTblade(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tblade", exc);
    }
  }

  /**
   * save Tg on GovHydro4
   *
   * @param command AssignTgToGovHydro4Command
   */
  @PutMapping("/assignTg")
  public void assignTg(@RequestBody AssignTgToGovHydro4Command command) {
    try {
      GovHydro4BusinessDelegate.getGovHydro4Instance().assignTg(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tg", exc);
    }
  }

  /**
   * unassign Tg on GovHydro4
   *
   * @param command UnAssignTgFromGovHydro4Command
   */
  @PutMapping("/unAssignTg")
  public void unAssignTg(@RequestBody(required = true) UnAssignTgFromGovHydro4Command command) {
    try {
      GovHydro4BusinessDelegate.getGovHydro4Instance().unAssignTg(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tg", exc);
    }
  }

  /**
   * save Tp on GovHydro4
   *
   * @param command AssignTpToGovHydro4Command
   */
  @PutMapping("/assignTp")
  public void assignTp(@RequestBody AssignTpToGovHydro4Command command) {
    try {
      GovHydro4BusinessDelegate.getGovHydro4Instance().assignTp(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tp", exc);
    }
  }

  /**
   * unassign Tp on GovHydro4
   *
   * @param command UnAssignTpFromGovHydro4Command
   */
  @PutMapping("/unAssignTp")
  public void unAssignTp(@RequestBody(required = true) UnAssignTpFromGovHydro4Command command) {
    try {
      GovHydro4BusinessDelegate.getGovHydro4Instance().unAssignTp(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tp", exc);
    }
  }

  /**
   * save Tr on GovHydro4
   *
   * @param command AssignTrToGovHydro4Command
   */
  @PutMapping("/assignTr")
  public void assignTr(@RequestBody AssignTrToGovHydro4Command command) {
    try {
      GovHydro4BusinessDelegate.getGovHydro4Instance().assignTr(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tr", exc);
    }
  }

  /**
   * unassign Tr on GovHydro4
   *
   * @param command UnAssignTrFromGovHydro4Command
   */
  @PutMapping("/unAssignTr")
  public void unAssignTr(@RequestBody(required = true) UnAssignTrFromGovHydro4Command command) {
    try {
      GovHydro4BusinessDelegate.getGovHydro4Instance().unAssignTr(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tr", exc);
    }
  }

  /**
   * save Tw on GovHydro4
   *
   * @param command AssignTwToGovHydro4Command
   */
  @PutMapping("/assignTw")
  public void assignTw(@RequestBody AssignTwToGovHydro4Command command) {
    try {
      GovHydro4BusinessDelegate.getGovHydro4Instance().assignTw(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tw", exc);
    }
  }

  /**
   * unassign Tw on GovHydro4
   *
   * @param command UnAssignTwFromGovHydro4Command
   */
  @PutMapping("/unAssignTw")
  public void unAssignTw(@RequestBody(required = true) UnAssignTwFromGovHydro4Command command) {
    try {
      GovHydro4BusinessDelegate.getGovHydro4Instance().unAssignTw(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tw", exc);
    }
  }

  /**
   * save Uc on GovHydro4
   *
   * @param command AssignUcToGovHydro4Command
   */
  @PutMapping("/assignUc")
  public void assignUc(@RequestBody AssignUcToGovHydro4Command command) {
    try {
      GovHydro4BusinessDelegate.getGovHydro4Instance().assignUc(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Uc", exc);
    }
  }

  /**
   * unassign Uc on GovHydro4
   *
   * @param command UnAssignUcFromGovHydro4Command
   */
  @PutMapping("/unAssignUc")
  public void unAssignUc(@RequestBody(required = true) UnAssignUcFromGovHydro4Command command) {
    try {
      GovHydro4BusinessDelegate.getGovHydro4Instance().unAssignUc(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Uc", exc);
    }
  }

  /**
   * save Uo on GovHydro4
   *
   * @param command AssignUoToGovHydro4Command
   */
  @PutMapping("/assignUo")
  public void assignUo(@RequestBody AssignUoToGovHydro4Command command) {
    try {
      GovHydro4BusinessDelegate.getGovHydro4Instance().assignUo(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Uo", exc);
    }
  }

  /**
   * unassign Uo on GovHydro4
   *
   * @param command UnAssignUoFromGovHydro4Command
   */
  @PutMapping("/unAssignUo")
  public void unAssignUo(@RequestBody(required = true) UnAssignUoFromGovHydro4Command command) {
    try {
      GovHydro4BusinessDelegate.getGovHydro4Instance().unAssignUo(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Uo", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected GovHydro4 govHydro4 = null;
  private static final Logger LOGGER =
      Logger.getLogger(GovHydro4CommandRestController.class.getName());
}
