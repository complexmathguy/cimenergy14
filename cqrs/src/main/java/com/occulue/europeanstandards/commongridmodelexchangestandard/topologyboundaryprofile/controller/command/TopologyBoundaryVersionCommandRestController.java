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
package com.occulue.europeanstandards.commongridmodelexchangestandard.topologyboundaryprofile.controller.command;

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
 * Implements Spring Controller command CQRS processing for entity TopologyBoundaryVersion.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/TopologyBoundaryVersion")
public class TopologyBoundaryVersionCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a TopologyBoundaryVersion. if not key provided, calls create, otherwise calls
   * save
   *
   * @param TopologyBoundaryVersion topologyBoundaryVersion
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateTopologyBoundaryVersionCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          TopologyBoundaryVersionBusinessDelegate.getTopologyBoundaryVersionInstance()
              .createTopologyBoundaryVersion(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a TopologyBoundaryVersion. if no key provided, calls create, otherwise calls
   * save
   *
   * @param TopologyBoundaryVersion topologyBoundaryVersion
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateTopologyBoundaryVersionCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateTopologyBoundaryVersionCommand
      // -----------------------------------------------
      completableFuture =
          TopologyBoundaryVersionBusinessDelegate.getTopologyBoundaryVersionInstance()
              .updateTopologyBoundaryVersion(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "TopologyBoundaryVersionController:update() - successfully update TopologyBoundaryVersion - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a TopologyBoundaryVersion entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(
      @RequestParam(required = true) UUID topologyBoundaryVersionId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteTopologyBoundaryVersionCommand command =
        new DeleteTopologyBoundaryVersionCommand(topologyBoundaryVersionId);

    try {
      TopologyBoundaryVersionBusinessDelegate delegate =
          TopologyBoundaryVersionBusinessDelegate.getTopologyBoundaryVersionInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted TopologyBoundaryVersion with key "
              + command.getTopologyBoundaryVersionId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save BaseUML on TopologyBoundaryVersion
   *
   * @param command AssignBaseUMLToTopologyBoundaryVersionCommand
   */
  @PutMapping("/assignBaseUML")
  public void assignBaseUML(@RequestBody AssignBaseUMLToTopologyBoundaryVersionCommand command) {
    try {
      TopologyBoundaryVersionBusinessDelegate.getTopologyBoundaryVersionInstance()
          .assignBaseUML(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign BaseUML", exc);
    }
  }

  /**
   * unassign BaseUML on TopologyBoundaryVersion
   *
   * @param command UnAssignBaseUMLFromTopologyBoundaryVersionCommand
   */
  @PutMapping("/unAssignBaseUML")
  public void unAssignBaseUML(
      @RequestBody(required = true) UnAssignBaseUMLFromTopologyBoundaryVersionCommand command) {
    try {
      TopologyBoundaryVersionBusinessDelegate.getTopologyBoundaryVersionInstance()
          .unAssignBaseUML(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign BaseUML", exc);
    }
  }

  /**
   * save BaseURI on TopologyBoundaryVersion
   *
   * @param command AssignBaseURIToTopologyBoundaryVersionCommand
   */
  @PutMapping("/assignBaseURI")
  public void assignBaseURI(@RequestBody AssignBaseURIToTopologyBoundaryVersionCommand command) {
    try {
      TopologyBoundaryVersionBusinessDelegate.getTopologyBoundaryVersionInstance()
          .assignBaseURI(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign BaseURI", exc);
    }
  }

  /**
   * unassign BaseURI on TopologyBoundaryVersion
   *
   * @param command UnAssignBaseURIFromTopologyBoundaryVersionCommand
   */
  @PutMapping("/unAssignBaseURI")
  public void unAssignBaseURI(
      @RequestBody(required = true) UnAssignBaseURIFromTopologyBoundaryVersionCommand command) {
    try {
      TopologyBoundaryVersionBusinessDelegate.getTopologyBoundaryVersionInstance()
          .unAssignBaseURI(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign BaseURI", exc);
    }
  }

  /**
   * save Date on TopologyBoundaryVersion
   *
   * @param command AssignDateToTopologyBoundaryVersionCommand
   */
  @PutMapping("/assignDate")
  public void assignDate(@RequestBody AssignDateToTopologyBoundaryVersionCommand command) {
    try {
      TopologyBoundaryVersionBusinessDelegate.getTopologyBoundaryVersionInstance()
          .assignDate(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Date", exc);
    }
  }

  /**
   * unassign Date on TopologyBoundaryVersion
   *
   * @param command UnAssignDateFromTopologyBoundaryVersionCommand
   */
  @PutMapping("/unAssignDate")
  public void unAssignDate(
      @RequestBody(required = true) UnAssignDateFromTopologyBoundaryVersionCommand command) {
    try {
      TopologyBoundaryVersionBusinessDelegate.getTopologyBoundaryVersionInstance()
          .unAssignDate(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Date", exc);
    }
  }

  /**
   * save DifferenceModelURI on TopologyBoundaryVersion
   *
   * @param command AssignDifferenceModelURIToTopologyBoundaryVersionCommand
   */
  @PutMapping("/assignDifferenceModelURI")
  public void assignDifferenceModelURI(
      @RequestBody AssignDifferenceModelURIToTopologyBoundaryVersionCommand command) {
    try {
      TopologyBoundaryVersionBusinessDelegate.getTopologyBoundaryVersionInstance()
          .assignDifferenceModelURI(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign DifferenceModelURI", exc);
    }
  }

  /**
   * unassign DifferenceModelURI on TopologyBoundaryVersion
   *
   * @param command UnAssignDifferenceModelURIFromTopologyBoundaryVersionCommand
   */
  @PutMapping("/unAssignDifferenceModelURI")
  public void unAssignDifferenceModelURI(
      @RequestBody(required = true)
          UnAssignDifferenceModelURIFromTopologyBoundaryVersionCommand command) {
    try {
      TopologyBoundaryVersionBusinessDelegate.getTopologyBoundaryVersionInstance()
          .unAssignDifferenceModelURI(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign DifferenceModelURI", exc);
    }
  }

  /**
   * save EntsoeUML on TopologyBoundaryVersion
   *
   * @param command AssignEntsoeUMLToTopologyBoundaryVersionCommand
   */
  @PutMapping("/assignEntsoeUML")
  public void assignEntsoeUML(
      @RequestBody AssignEntsoeUMLToTopologyBoundaryVersionCommand command) {
    try {
      TopologyBoundaryVersionBusinessDelegate.getTopologyBoundaryVersionInstance()
          .assignEntsoeUML(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign EntsoeUML", exc);
    }
  }

  /**
   * unassign EntsoeUML on TopologyBoundaryVersion
   *
   * @param command UnAssignEntsoeUMLFromTopologyBoundaryVersionCommand
   */
  @PutMapping("/unAssignEntsoeUML")
  public void unAssignEntsoeUML(
      @RequestBody(required = true) UnAssignEntsoeUMLFromTopologyBoundaryVersionCommand command) {
    try {
      TopologyBoundaryVersionBusinessDelegate.getTopologyBoundaryVersionInstance()
          .unAssignEntsoeUML(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign EntsoeUML", exc);
    }
  }

  /**
   * save EntsoeURI on TopologyBoundaryVersion
   *
   * @param command AssignEntsoeURIToTopologyBoundaryVersionCommand
   */
  @PutMapping("/assignEntsoeURI")
  public void assignEntsoeURI(
      @RequestBody AssignEntsoeURIToTopologyBoundaryVersionCommand command) {
    try {
      TopologyBoundaryVersionBusinessDelegate.getTopologyBoundaryVersionInstance()
          .assignEntsoeURI(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign EntsoeURI", exc);
    }
  }

  /**
   * unassign EntsoeURI on TopologyBoundaryVersion
   *
   * @param command UnAssignEntsoeURIFromTopologyBoundaryVersionCommand
   */
  @PutMapping("/unAssignEntsoeURI")
  public void unAssignEntsoeURI(
      @RequestBody(required = true) UnAssignEntsoeURIFromTopologyBoundaryVersionCommand command) {
    try {
      TopologyBoundaryVersionBusinessDelegate.getTopologyBoundaryVersionInstance()
          .unAssignEntsoeURI(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign EntsoeURI", exc);
    }
  }

  /**
   * save ModelDescriptionURI on TopologyBoundaryVersion
   *
   * @param command AssignModelDescriptionURIToTopologyBoundaryVersionCommand
   */
  @PutMapping("/assignModelDescriptionURI")
  public void assignModelDescriptionURI(
      @RequestBody AssignModelDescriptionURIToTopologyBoundaryVersionCommand command) {
    try {
      TopologyBoundaryVersionBusinessDelegate.getTopologyBoundaryVersionInstance()
          .assignModelDescriptionURI(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign ModelDescriptionURI", exc);
    }
  }

  /**
   * unassign ModelDescriptionURI on TopologyBoundaryVersion
   *
   * @param command UnAssignModelDescriptionURIFromTopologyBoundaryVersionCommand
   */
  @PutMapping("/unAssignModelDescriptionURI")
  public void unAssignModelDescriptionURI(
      @RequestBody(required = true)
          UnAssignModelDescriptionURIFromTopologyBoundaryVersionCommand command) {
    try {
      TopologyBoundaryVersionBusinessDelegate.getTopologyBoundaryVersionInstance()
          .unAssignModelDescriptionURI(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign ModelDescriptionURI", exc);
    }
  }

  /**
   * save NamespaceRDF on TopologyBoundaryVersion
   *
   * @param command AssignNamespaceRDFToTopologyBoundaryVersionCommand
   */
  @PutMapping("/assignNamespaceRDF")
  public void assignNamespaceRDF(
      @RequestBody AssignNamespaceRDFToTopologyBoundaryVersionCommand command) {
    try {
      TopologyBoundaryVersionBusinessDelegate.getTopologyBoundaryVersionInstance()
          .assignNamespaceRDF(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign NamespaceRDF", exc);
    }
  }

  /**
   * unassign NamespaceRDF on TopologyBoundaryVersion
   *
   * @param command UnAssignNamespaceRDFFromTopologyBoundaryVersionCommand
   */
  @PutMapping("/unAssignNamespaceRDF")
  public void unAssignNamespaceRDF(
      @RequestBody(required = true)
          UnAssignNamespaceRDFFromTopologyBoundaryVersionCommand command) {
    try {
      TopologyBoundaryVersionBusinessDelegate.getTopologyBoundaryVersionInstance()
          .unAssignNamespaceRDF(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign NamespaceRDF", exc);
    }
  }

  /**
   * save NamespaceUML on TopologyBoundaryVersion
   *
   * @param command AssignNamespaceUMLToTopologyBoundaryVersionCommand
   */
  @PutMapping("/assignNamespaceUML")
  public void assignNamespaceUML(
      @RequestBody AssignNamespaceUMLToTopologyBoundaryVersionCommand command) {
    try {
      TopologyBoundaryVersionBusinessDelegate.getTopologyBoundaryVersionInstance()
          .assignNamespaceUML(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign NamespaceUML", exc);
    }
  }

  /**
   * unassign NamespaceUML on TopologyBoundaryVersion
   *
   * @param command UnAssignNamespaceUMLFromTopologyBoundaryVersionCommand
   */
  @PutMapping("/unAssignNamespaceUML")
  public void unAssignNamespaceUML(
      @RequestBody(required = true)
          UnAssignNamespaceUMLFromTopologyBoundaryVersionCommand command) {
    try {
      TopologyBoundaryVersionBusinessDelegate.getTopologyBoundaryVersionInstance()
          .unAssignNamespaceUML(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign NamespaceUML", exc);
    }
  }

  /**
   * save ShortName on TopologyBoundaryVersion
   *
   * @param command AssignShortNameToTopologyBoundaryVersionCommand
   */
  @PutMapping("/assignShortName")
  public void assignShortName(
      @RequestBody AssignShortNameToTopologyBoundaryVersionCommand command) {
    try {
      TopologyBoundaryVersionBusinessDelegate.getTopologyBoundaryVersionInstance()
          .assignShortName(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign ShortName", exc);
    }
  }

  /**
   * unassign ShortName on TopologyBoundaryVersion
   *
   * @param command UnAssignShortNameFromTopologyBoundaryVersionCommand
   */
  @PutMapping("/unAssignShortName")
  public void unAssignShortName(
      @RequestBody(required = true) UnAssignShortNameFromTopologyBoundaryVersionCommand command) {
    try {
      TopologyBoundaryVersionBusinessDelegate.getTopologyBoundaryVersionInstance()
          .unAssignShortName(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign ShortName", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected TopologyBoundaryVersion topologyBoundaryVersion = null;
  private static final Logger LOGGER =
      Logger.getLogger(TopologyBoundaryVersionCommandRestController.class.getName());
}
