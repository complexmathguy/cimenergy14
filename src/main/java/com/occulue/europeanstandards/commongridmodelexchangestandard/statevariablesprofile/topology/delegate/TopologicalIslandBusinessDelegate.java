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
package com.occulue.europeanstandards.commongridmodelexchangestandard.statevariablesprofile.topology.delegate;

import com.occulue.api.*;
import com.occulue.delegate.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.statevariablesprofile.topology.validator.*;
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
 * TopologicalIsland business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of TopologicalIsland related services in the case of a
 *       TopologicalIsland business related service failing.
 *   <li>Exposes a simpler, uniform TopologicalIsland interface to the business tier, making it easy
 *       for clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill TopologicalIsland business
 *       related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class TopologicalIslandBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public TopologicalIslandBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * TopologicalIsland Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return TopologicalIslandBusinessDelegate
   */
  public static TopologicalIslandBusinessDelegate getTopologicalIslandInstance() {
    return (new TopologicalIslandBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createTopologicalIsland(CreateTopologicalIslandCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getTopologicalIslandId() == null)
        command.setTopologicalIslandId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      TopologicalIslandValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateTopologicalIslandCommand - by convention the future return value for a
      // create command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateTopologicalIslandCommand of TopologicalIsland is "
              + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create TopologicalIsland - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateTopologicalIslandCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateTopologicalIsland(UpdateTopologicalIslandCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      TopologicalIslandValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateTopologicalIslandCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save TopologicalIsland - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteTopologicalIslandCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteTopologicalIslandCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      TopologicalIslandValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteTopologicalIslandCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg =
          "Unable to delete TopologicalIsland using Id = " + command.getTopologicalIslandId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the TopologicalIsland via TopologicalIslandFetchOneSummary
   *
   * @param summary TopologicalIslandFetchOneSummary
   * @return TopologicalIslandFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public TopologicalIsland getTopologicalIsland(TopologicalIslandFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException("TopologicalIslandFetchOneSummary arg cannot be null");

    TopologicalIsland entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      TopologicalIslandValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a TopologicalIsland
      // --------------------------------------
      CompletableFuture<TopologicalIsland> futureEntity =
          queryGateway.query(
              new FindTopologicalIslandQuery(
                  new LoadTopologicalIslandFilter(summary.getTopologicalIslandId())),
              ResponseTypes.instanceOf(TopologicalIsland.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg =
          "Unable to locate TopologicalIsland with id " + summary.getTopologicalIslandId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all TopologicalIslands
   *
   * @return List<TopologicalIsland>
   * @exception ProcessingException Thrown if any problems
   */
  public List<TopologicalIsland> getAllTopologicalIsland() throws ProcessingException {
    List<TopologicalIsland> list = null;

    try {
      CompletableFuture<List<TopologicalIsland>> futureList =
          queryGateway.query(
              new FindAllTopologicalIslandQuery(),
              ResponseTypes.multipleInstancesOf(TopologicalIsland.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all TopologicalIsland";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign TopologicalIsland on TopologicalIsland
   *
   * @param command AssignTopologicalIslandToTopologicalIslandCommand
   * @exception ProcessingException
   */
  public void assignTopologicalIsland(AssignTopologicalIslandToTopologicalIslandCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getTopologicalIslandId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.statevariablesprofile.topology
            .delegate.TopologicalIslandBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.statevariablesprofile
                .topology.delegate.TopologicalIslandBusinessDelegate.getTopologicalIslandInstance();
    TopologicalIslandBusinessDelegate parentDelegate =
        TopologicalIslandBusinessDelegate.getTopologicalIslandInstance();
    UUID childId = command.getAssignment().getTopologicalIslandId();
    TopologicalIsland child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      TopologicalIslandValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get TopologicalIsland using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign TopologicalIsland on TopologicalIsland
   *
   * @param command UnAssignTopologicalIslandFromTopologicalIslandCommand
   * @exception ProcessingException
   */
  public void unAssignTopologicalIsland(
      UnAssignTopologicalIslandFromTopologicalIslandCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      TopologicalIslandValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign TopologicalIsland on TopologicalIsland";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign AngleRefTopologicalIsland on TopologicalIsland
   *
   * @param command AssignAngleRefTopologicalIslandToTopologicalIslandCommand
   * @exception ProcessingException
   */
  public void assignAngleRefTopologicalIsland(
      AssignAngleRefTopologicalIslandToTopologicalIslandCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getTopologicalIslandId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.statevariablesprofile.topology
            .delegate.TopologicalIslandBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.statevariablesprofile
                .topology.delegate.TopologicalIslandBusinessDelegate.getTopologicalIslandInstance();
    TopologicalIslandBusinessDelegate parentDelegate =
        TopologicalIslandBusinessDelegate.getTopologicalIslandInstance();
    UUID childId = command.getAssignment().getTopologicalIslandId();
    TopologicalIsland child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      TopologicalIslandValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get TopologicalIsland using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign AngleRefTopologicalIsland on TopologicalIsland
   *
   * @param command UnAssignAngleRefTopologicalIslandFromTopologicalIslandCommand
   * @exception ProcessingException
   */
  public void unAssignAngleRefTopologicalIsland(
      UnAssignAngleRefTopologicalIslandFromTopologicalIslandCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      TopologicalIslandValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign AngleRefTopologicalIsland on TopologicalIsland";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return TopologicalIsland
   */
  private TopologicalIsland load(UUID id) throws ProcessingException {
    topologicalIsland =
        TopologicalIslandBusinessDelegate.getTopologicalIslandInstance()
            .getTopologicalIsland(new TopologicalIslandFetchOneSummary(id));
    return topologicalIsland;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private TopologicalIsland topologicalIsland = null;
  private static final Logger LOGGER =
      Logger.getLogger(TopologicalIslandBusinessDelegate.class.getName());
}
