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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.controlarea.delegate;

import com.occulue.api.*;
import com.occulue.delegate.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.controlarea.validator.*;
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
 * TieFlow business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of TieFlow related services in the case of a TieFlow business
 *       related service failing.
 *   <li>Exposes a simpler, uniform TieFlow interface to the business tier, making it easy for
 *       clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill TieFlow business related
 *       services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class TieFlowBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public TieFlowBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * TieFlow Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return TieFlowBusinessDelegate
   */
  public static TieFlowBusinessDelegate getTieFlowInstance() {
    return (new TieFlowBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createTieFlow(CreateTieFlowCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getTieFlowId() == null) command.setTieFlowId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      TieFlowValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateTieFlowCommand - by convention the future return value for a create command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateTieFlowCommand of TieFlow is " + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create TieFlow - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateTieFlowCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateTieFlow(UpdateTieFlowCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      TieFlowValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateTieFlowCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save TieFlow - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteTieFlowCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteTieFlowCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      TieFlowValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteTieFlowCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to delete TieFlow using Id = " + command.getTieFlowId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the TieFlow via TieFlowFetchOneSummary
   *
   * @param summary TieFlowFetchOneSummary
   * @return TieFlowFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public TieFlow getTieFlow(TieFlowFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException("TieFlowFetchOneSummary arg cannot be null");

    TieFlow entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      TieFlowValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a TieFlow
      // --------------------------------------
      CompletableFuture<TieFlow> futureEntity =
          queryGateway.query(
              new FindTieFlowQuery(new LoadTieFlowFilter(summary.getTieFlowId())),
              ResponseTypes.instanceOf(TieFlow.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg = "Unable to locate TieFlow with id " + summary.getTieFlowId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all TieFlows
   *
   * @return List<TieFlow>
   * @exception ProcessingException Thrown if any problems
   */
  public List<TieFlow> getAllTieFlow() throws ProcessingException {
    List<TieFlow> list = null;

    try {
      CompletableFuture<List<TieFlow>> futureList =
          queryGateway.query(
              new FindAllTieFlowQuery(), ResponseTypes.multipleInstancesOf(TieFlow.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all TieFlow";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign PositiveFlowIn on TieFlow
   *
   * @param command AssignPositiveFlowInToTieFlowCommand
   * @exception ProcessingException
   */
  public void assignPositiveFlowIn(AssignPositiveFlowInToTieFlowCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getTieFlowId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .BooleanProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .BooleanProxyBusinessDelegate.getBooleanProxyInstance();
    TieFlowBusinessDelegate parentDelegate = TieFlowBusinessDelegate.getTieFlowInstance();
    UUID childId = command.getAssignment().getBooleanProxyId();
    BooleanProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      TieFlowValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get BooleanProxy using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign PositiveFlowIn on TieFlow
   *
   * @param command UnAssignPositiveFlowInFromTieFlowCommand
   * @exception ProcessingException
   */
  public void unAssignPositiveFlowIn(UnAssignPositiveFlowInFromTieFlowCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      TieFlowValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign PositiveFlowIn on TieFlow";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * add TieFlow to TieFlow
   *
   * @param command AssignTieFlowToTieFlowCommand
   * @exception ProcessingException
   */
  public void addToTieFlow(AssignTieFlowToTieFlowCommand command) throws ProcessingException {

    // -------------------------------------------
    // load the parent
    // -------------------------------------------
    load(command.getTieFlowId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.controlarea
            .delegate.TieFlowBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile
                .controlarea.delegate.TieFlowBusinessDelegate.getTieFlowInstance();
    TieFlowBusinessDelegate parentDelegate = TieFlowBusinessDelegate.getTieFlowInstance();
    UUID childId = command.getAddTo().getTieFlowId();

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      TieFlowValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to add a TieFlow as TieFlow to TieFlow";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * remove TieFlow from TieFlow
   *
   * @param command RemoveTieFlowFromTieFlowCommand
   * @exception ProcessingException
   */
  public void removeFromTieFlow(RemoveTieFlowFromTieFlowCommand command)
      throws ProcessingException {

    com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.controlarea
            .delegate.TieFlowBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile
                .controlarea.delegate.TieFlowBusinessDelegate.getTieFlowInstance();
    UUID childId = command.getRemoveFrom().getTieFlowId();

    try {

      // --------------------------------------
      // validate the command
      // --------------------------------------
      TieFlowValidator.getInstance().validate(command);

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
   * @return TieFlow
   */
  private TieFlow load(UUID id) throws ProcessingException {
    tieFlow =
        TieFlowBusinessDelegate.getTieFlowInstance().getTieFlow(new TieFlowFetchOneSummary(id));
    return tieFlow;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private TieFlow tieFlow = null;
  private static final Logger LOGGER = Logger.getLogger(TieFlowBusinessDelegate.class.getName());
}
