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
package com.occulue.europeanstandards.commongridmodelexchangestandard.diagramlayoutprofile.diagramlayout.delegate;

import com.occulue.api.*;
import com.occulue.delegate.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.diagramlayoutprofile.diagramlayout.validator.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.axonframework.queryhandling.QueryUpdateEmitter;

/**
 * Diagram business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of Diagram related services in the case of a Diagram business
 *       related service failing.
 *   <li>Exposes a simpler, uniform Diagram interface to the business tier, making it easy for
 *       clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill Diagram business related
 *       services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class DiagramBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public DiagramBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * Diagram Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return DiagramBusinessDelegate
   */
  public static DiagramBusinessDelegate getDiagramInstance() {
    return (new DiagramBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createDiagram(CreateDiagramCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getDiagramId() == null) command.setDiagramId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      DiagramValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateDiagramCommand - by convention the future return value for a create command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateDiagramCommand of Diagram is " + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create Diagram - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateDiagramCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateDiagram(UpdateDiagramCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      DiagramValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateDiagramCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save Diagram - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteDiagramCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteDiagramCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      DiagramValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteDiagramCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to delete Diagram using Id = " + command.getDiagramId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the Diagram via DiagramFetchOneSummary
   *
   * @param summary DiagramFetchOneSummary
   * @return DiagramFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public Diagram getDiagram(DiagramFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException("DiagramFetchOneSummary arg cannot be null");

    Diagram entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      DiagramValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a Diagram
      // --------------------------------------
      CompletableFuture<Diagram> futureEntity =
          queryGateway.query(
              new FindDiagramQuery(new LoadDiagramFilter(summary.getDiagramId())),
              ResponseTypes.instanceOf(Diagram.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg = "Unable to locate Diagram with id " + summary.getDiagramId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all Diagrams
   *
   * @return List<Diagram>
   * @exception ProcessingException Thrown if any problems
   */
  public List<Diagram> getAllDiagram() throws ProcessingException {
    List<Diagram> list = null;

    try {
      CompletableFuture<List<Diagram>> futureList =
          queryGateway.query(
              new FindAllDiagramQuery(), ResponseTypes.multipleInstancesOf(Diagram.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all Diagram";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign X1InitialView on Diagram
   *
   * @param command AssignX1InitialViewToDiagramCommand
   * @exception ProcessingException
   */
  public void assignX1InitialView(AssignX1InitialViewToDiagramCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getDiagramId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .Simple_FloatBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .Simple_FloatBusinessDelegate.getSimple_FloatInstance();
    DiagramBusinessDelegate parentDelegate = DiagramBusinessDelegate.getDiagramInstance();
    UUID childId = command.getAssignment().getSimple_FloatId();
    Simple_Float child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      DiagramValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get Simple_Float using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign X1InitialView on Diagram
   *
   * @param command UnAssignX1InitialViewFromDiagramCommand
   * @exception ProcessingException
   */
  public void unAssignX1InitialView(UnAssignX1InitialViewFromDiagramCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      DiagramValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign X1InitialView on Diagram";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign X2InitialView on Diagram
   *
   * @param command AssignX2InitialViewToDiagramCommand
   * @exception ProcessingException
   */
  public void assignX2InitialView(AssignX2InitialViewToDiagramCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getDiagramId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .Simple_FloatBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .Simple_FloatBusinessDelegate.getSimple_FloatInstance();
    DiagramBusinessDelegate parentDelegate = DiagramBusinessDelegate.getDiagramInstance();
    UUID childId = command.getAssignment().getSimple_FloatId();
    Simple_Float child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      DiagramValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get Simple_Float using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign X2InitialView on Diagram
   *
   * @param command UnAssignX2InitialViewFromDiagramCommand
   * @exception ProcessingException
   */
  public void unAssignX2InitialView(UnAssignX2InitialViewFromDiagramCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      DiagramValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign X2InitialView on Diagram";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Y1InitialView on Diagram
   *
   * @param command AssignY1InitialViewToDiagramCommand
   * @exception ProcessingException
   */
  public void assignY1InitialView(AssignY1InitialViewToDiagramCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getDiagramId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .Simple_FloatBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .Simple_FloatBusinessDelegate.getSimple_FloatInstance();
    DiagramBusinessDelegate parentDelegate = DiagramBusinessDelegate.getDiagramInstance();
    UUID childId = command.getAssignment().getSimple_FloatId();
    Simple_Float child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      DiagramValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get Simple_Float using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign Y1InitialView on Diagram
   *
   * @param command UnAssignY1InitialViewFromDiagramCommand
   * @exception ProcessingException
   */
  public void unAssignY1InitialView(UnAssignY1InitialViewFromDiagramCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      DiagramValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Y1InitialView on Diagram";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Y2InitialView on Diagram
   *
   * @param command AssignY2InitialViewToDiagramCommand
   * @exception ProcessingException
   */
  public void assignY2InitialView(AssignY2InitialViewToDiagramCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getDiagramId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .Simple_FloatBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .Simple_FloatBusinessDelegate.getSimple_FloatInstance();
    DiagramBusinessDelegate parentDelegate = DiagramBusinessDelegate.getDiagramInstance();
    UUID childId = command.getAssignment().getSimple_FloatId();
    Simple_Float child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      DiagramValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get Simple_Float using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign Y2InitialView on Diagram
   *
   * @param command UnAssignY2InitialViewFromDiagramCommand
   * @exception ProcessingException
   */
  public void unAssignY2InitialView(UnAssignY2InitialViewFromDiagramCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      DiagramValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Y2InitialView on Diagram";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * add Diagram to Diagram
   *
   * @param command AssignDiagramToDiagramCommand
   * @exception ProcessingException
   */
  public void addToDiagram(AssignDiagramToDiagramCommand command) throws ProcessingException {

    // -------------------------------------------
    // load the parent
    // -------------------------------------------
    load(command.getDiagramId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.diagramlayoutprofile.diagramlayout
            .delegate.DiagramBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.diagramlayoutprofile
                .diagramlayout.delegate.DiagramBusinessDelegate.getDiagramInstance();
    DiagramBusinessDelegate parentDelegate = DiagramBusinessDelegate.getDiagramInstance();
    UUID childId = command.getAddTo().getDiagramId();

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      DiagramValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to add a Diagram as Diagram to Diagram";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * remove Diagram from Diagram
   *
   * @param command RemoveDiagramFromDiagramCommand
   * @exception ProcessingException
   */
  public void removeFromDiagram(RemoveDiagramFromDiagramCommand command)
      throws ProcessingException {

    com.occulue.europeanstandards.commongridmodelexchangestandard.diagramlayoutprofile.diagramlayout
            .delegate.DiagramBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.diagramlayoutprofile
                .diagramlayout.delegate.DiagramBusinessDelegate.getDiagramInstance();
    UUID childId = command.getRemoveFrom().getDiagramId();

    try {

      // --------------------------------------
      // validate the command
      // --------------------------------------
      DiagramValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Exception exc) {
      final String msg = "Failed to remove child using Id " + childId;
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return Diagram
   */
  private Diagram load(UUID id) throws ProcessingException {
    diagram =
        DiagramBusinessDelegate.getDiagramInstance().getDiagram(new DiagramFetchOneSummary(id));
    return diagram;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private Diagram diagram = null;
  private static final Logger LOGGER = Logger.getLogger(DiagramBusinessDelegate.class.getName());
}
