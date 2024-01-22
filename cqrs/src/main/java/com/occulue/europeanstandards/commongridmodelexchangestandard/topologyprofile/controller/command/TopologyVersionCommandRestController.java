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
package com.occulue.europeanstandards.commongridmodelexchangestandard.topologyprofile.controller.command;

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
 * Implements Spring Controller command CQRS processing for entity TopologyVersion.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/TopologyVersion")
public class TopologyVersionCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a TopologyVersion. if not key provided, calls create, otherwise calls save
   *
   * @param TopologyVersion topologyVersion
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateTopologyVersionCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          TopologyVersionBusinessDelegate.getTopologyVersionInstance()
              .createTopologyVersion(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a TopologyVersion. if no key provided, calls create, otherwise calls save
   *
   * @param TopologyVersion topologyVersion
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateTopologyVersionCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateTopologyVersionCommand
      // -----------------------------------------------
      completableFuture =
          TopologyVersionBusinessDelegate.getTopologyVersionInstance()
              .updateTopologyVersion(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "TopologyVersionController:update() - successfully update TopologyVersion - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a TopologyVersion entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID topologyVersionId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteTopologyVersionCommand command = new DeleteTopologyVersionCommand(topologyVersionId);

    try {
      TopologyVersionBusinessDelegate delegate =
          TopologyVersionBusinessDelegate.getTopologyVersionInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted TopologyVersion with key " + command.getTopologyVersionId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save BaseUML on TopologyVersion
   *
   * @param command AssignBaseUMLToTopologyVersionCommand
   */
  @PutMapping("/assignBaseUML")
  public void assignBaseUML(@RequestBody AssignBaseUMLToTopologyVersionCommand command) {
    try {
      TopologyVersionBusinessDelegate.getTopologyVersionInstance().assignBaseUML(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign BaseUML", exc);
    }
  }

  /**
   * unassign BaseUML on TopologyVersion
   *
   * @param command UnAssignBaseUMLFromTopologyVersionCommand
   */
  @PutMapping("/unAssignBaseUML")
  public void unAssignBaseUML(
      @RequestBody(required = true) UnAssignBaseUMLFromTopologyVersionCommand command) {
    try {
      TopologyVersionBusinessDelegate.getTopologyVersionInstance().unAssignBaseUML(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign BaseUML", exc);
    }
  }

  /**
   * save BaseURI on TopologyVersion
   *
   * @param command AssignBaseURIToTopologyVersionCommand
   */
  @PutMapping("/assignBaseURI")
  public void assignBaseURI(@RequestBody AssignBaseURIToTopologyVersionCommand command) {
    try {
      TopologyVersionBusinessDelegate.getTopologyVersionInstance().assignBaseURI(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign BaseURI", exc);
    }
  }

  /**
   * unassign BaseURI on TopologyVersion
   *
   * @param command UnAssignBaseURIFromTopologyVersionCommand
   */
  @PutMapping("/unAssignBaseURI")
  public void unAssignBaseURI(
      @RequestBody(required = true) UnAssignBaseURIFromTopologyVersionCommand command) {
    try {
      TopologyVersionBusinessDelegate.getTopologyVersionInstance().unAssignBaseURI(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign BaseURI", exc);
    }
  }

  /**
   * save Date on TopologyVersion
   *
   * @param command AssignDateToTopologyVersionCommand
   */
  @PutMapping("/assignDate")
  public void assignDate(@RequestBody AssignDateToTopologyVersionCommand command) {
    try {
      TopologyVersionBusinessDelegate.getTopologyVersionInstance().assignDate(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Date", exc);
    }
  }

  /**
   * unassign Date on TopologyVersion
   *
   * @param command UnAssignDateFromTopologyVersionCommand
   */
  @PutMapping("/unAssignDate")
  public void unAssignDate(
      @RequestBody(required = true) UnAssignDateFromTopologyVersionCommand command) {
    try {
      TopologyVersionBusinessDelegate.getTopologyVersionInstance().unAssignDate(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Date", exc);
    }
  }

  /**
   * save DifferenceModelURI on TopologyVersion
   *
   * @param command AssignDifferenceModelURIToTopologyVersionCommand
   */
  @PutMapping("/assignDifferenceModelURI")
  public void assignDifferenceModelURI(
      @RequestBody AssignDifferenceModelURIToTopologyVersionCommand command) {
    try {
      TopologyVersionBusinessDelegate.getTopologyVersionInstance()
          .assignDifferenceModelURI(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign DifferenceModelURI", exc);
    }
  }

  /**
   * unassign DifferenceModelURI on TopologyVersion
   *
   * @param command UnAssignDifferenceModelURIFromTopologyVersionCommand
   */
  @PutMapping("/unAssignDifferenceModelURI")
  public void unAssignDifferenceModelURI(
      @RequestBody(required = true) UnAssignDifferenceModelURIFromTopologyVersionCommand command) {
    try {
      TopologyVersionBusinessDelegate.getTopologyVersionInstance()
          .unAssignDifferenceModelURI(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign DifferenceModelURI", exc);
    }
  }

  /**
   * save EntsoeUML on TopologyVersion
   *
   * @param command AssignEntsoeUMLToTopologyVersionCommand
   */
  @PutMapping("/assignEntsoeUML")
  public void assignEntsoeUML(@RequestBody AssignEntsoeUMLToTopologyVersionCommand command) {
    try {
      TopologyVersionBusinessDelegate.getTopologyVersionInstance().assignEntsoeUML(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign EntsoeUML", exc);
    }
  }

  /**
   * unassign EntsoeUML on TopologyVersion
   *
   * @param command UnAssignEntsoeUMLFromTopologyVersionCommand
   */
  @PutMapping("/unAssignEntsoeUML")
  public void unAssignEntsoeUML(
      @RequestBody(required = true) UnAssignEntsoeUMLFromTopologyVersionCommand command) {
    try {
      TopologyVersionBusinessDelegate.getTopologyVersionInstance().unAssignEntsoeUML(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign EntsoeUML", exc);
    }
  }

  /**
   * save EntsoeURI on TopologyVersion
   *
   * @param command AssignEntsoeURIToTopologyVersionCommand
   */
  @PutMapping("/assignEntsoeURI")
  public void assignEntsoeURI(@RequestBody AssignEntsoeURIToTopologyVersionCommand command) {
    try {
      TopologyVersionBusinessDelegate.getTopologyVersionInstance().assignEntsoeURI(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign EntsoeURI", exc);
    }
  }

  /**
   * unassign EntsoeURI on TopologyVersion
   *
   * @param command UnAssignEntsoeURIFromTopologyVersionCommand
   */
  @PutMapping("/unAssignEntsoeURI")
  public void unAssignEntsoeURI(
      @RequestBody(required = true) UnAssignEntsoeURIFromTopologyVersionCommand command) {
    try {
      TopologyVersionBusinessDelegate.getTopologyVersionInstance().unAssignEntsoeURI(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign EntsoeURI", exc);
    }
  }

  /**
   * save ModelDescriptionURI on TopologyVersion
   *
   * @param command AssignModelDescriptionURIToTopologyVersionCommand
   */
  @PutMapping("/assignModelDescriptionURI")
  public void assignModelDescriptionURI(
      @RequestBody AssignModelDescriptionURIToTopologyVersionCommand command) {
    try {
      TopologyVersionBusinessDelegate.getTopologyVersionInstance()
          .assignModelDescriptionURI(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign ModelDescriptionURI", exc);
    }
  }

  /**
   * unassign ModelDescriptionURI on TopologyVersion
   *
   * @param command UnAssignModelDescriptionURIFromTopologyVersionCommand
   */
  @PutMapping("/unAssignModelDescriptionURI")
  public void unAssignModelDescriptionURI(
      @RequestBody(required = true) UnAssignModelDescriptionURIFromTopologyVersionCommand command) {
    try {
      TopologyVersionBusinessDelegate.getTopologyVersionInstance()
          .unAssignModelDescriptionURI(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign ModelDescriptionURI", exc);
    }
  }

  /**
   * save NamespaceRDF on TopologyVersion
   *
   * @param command AssignNamespaceRDFToTopologyVersionCommand
   */
  @PutMapping("/assignNamespaceRDF")
  public void assignNamespaceRDF(@RequestBody AssignNamespaceRDFToTopologyVersionCommand command) {
    try {
      TopologyVersionBusinessDelegate.getTopologyVersionInstance().assignNamespaceRDF(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign NamespaceRDF", exc);
    }
  }

  /**
   * unassign NamespaceRDF on TopologyVersion
   *
   * @param command UnAssignNamespaceRDFFromTopologyVersionCommand
   */
  @PutMapping("/unAssignNamespaceRDF")
  public void unAssignNamespaceRDF(
      @RequestBody(required = true) UnAssignNamespaceRDFFromTopologyVersionCommand command) {
    try {
      TopologyVersionBusinessDelegate.getTopologyVersionInstance().unAssignNamespaceRDF(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign NamespaceRDF", exc);
    }
  }

  /**
   * save NamespaceUML on TopologyVersion
   *
   * @param command AssignNamespaceUMLToTopologyVersionCommand
   */
  @PutMapping("/assignNamespaceUML")
  public void assignNamespaceUML(@RequestBody AssignNamespaceUMLToTopologyVersionCommand command) {
    try {
      TopologyVersionBusinessDelegate.getTopologyVersionInstance().assignNamespaceUML(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign NamespaceUML", exc);
    }
  }

  /**
   * unassign NamespaceUML on TopologyVersion
   *
   * @param command UnAssignNamespaceUMLFromTopologyVersionCommand
   */
  @PutMapping("/unAssignNamespaceUML")
  public void unAssignNamespaceUML(
      @RequestBody(required = true) UnAssignNamespaceUMLFromTopologyVersionCommand command) {
    try {
      TopologyVersionBusinessDelegate.getTopologyVersionInstance().unAssignNamespaceUML(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign NamespaceUML", exc);
    }
  }

  /**
   * save ShortName on TopologyVersion
   *
   * @param command AssignShortNameToTopologyVersionCommand
   */
  @PutMapping("/assignShortName")
  public void assignShortName(@RequestBody AssignShortNameToTopologyVersionCommand command) {
    try {
      TopologyVersionBusinessDelegate.getTopologyVersionInstance().assignShortName(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign ShortName", exc);
    }
  }

  /**
   * unassign ShortName on TopologyVersion
   *
   * @param command UnAssignShortNameFromTopologyVersionCommand
   */
  @PutMapping("/unAssignShortName")
  public void unAssignShortName(
      @RequestBody(required = true) UnAssignShortNameFromTopologyVersionCommand command) {
    try {
      TopologyVersionBusinessDelegate.getTopologyVersionInstance().unAssignShortName(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign ShortName", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected TopologyVersion topologyVersion = null;
  private static final Logger LOGGER =
      Logger.getLogger(TopologyVersionCommandRestController.class.getName());
}
