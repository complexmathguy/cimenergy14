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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.dc.delegate;

import com.occulue.api.*;
import com.occulue.delegate.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.dc.validator.*;
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
 * DCNode business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of DCNode related services in the case of a DCNode business related
 *       service failing.
 *   <li>Exposes a simpler, uniform DCNode interface to the business tier, making it easy for
 *       clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill DCNode business related
 *       services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class DCNodeBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public DCNodeBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * DCNode Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return DCNodeBusinessDelegate
   */
  public static DCNodeBusinessDelegate getDCNodeInstance() {
    return (new DCNodeBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createDCNode(CreateDCNodeCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getDCNodeId() == null) command.setDCNodeId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      DCNodeValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateDCNodeCommand - by convention the future return value for a create command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateDCNodeCommand of DCNode is " + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create DCNode - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateDCNodeCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateDCNode(UpdateDCNodeCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      DCNodeValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateDCNodeCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save DCNode - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteDCNodeCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteDCNodeCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      DCNodeValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteDCNodeCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to delete DCNode using Id = " + command.getDCNodeId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the DCNode via DCNodeFetchOneSummary
   *
   * @param summary DCNodeFetchOneSummary
   * @return DCNodeFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public DCNode getDCNode(DCNodeFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException("DCNodeFetchOneSummary arg cannot be null");

    DCNode entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      DCNodeValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a DCNode
      // --------------------------------------
      CompletableFuture<DCNode> futureEntity =
          queryGateway.query(
              new FindDCNodeQuery(new LoadDCNodeFilter(summary.getDCNodeId())),
              ResponseTypes.instanceOf(DCNode.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg = "Unable to locate DCNode with id " + summary.getDCNodeId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all DCNodes
   *
   * @return List<DCNode>
   * @exception ProcessingException Thrown if any problems
   */
  public List<DCNode> getAllDCNode() throws ProcessingException {
    List<DCNode> list = null;

    try {
      CompletableFuture<List<DCNode>> futureList =
          queryGateway.query(
              new FindAllDCNodeQuery(), ResponseTypes.multipleInstancesOf(DCNode.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all DCNode";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * add DCNode to DCNodes
   *
   * @param command AssignDCNodesToDCNodeCommand
   * @exception ProcessingException
   */
  public void addToDCNodes(AssignDCNodesToDCNodeCommand command) throws ProcessingException {

    // -------------------------------------------
    // load the parent
    // -------------------------------------------
    load(command.getDCNodeId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.dc.delegate
            .DCNodeBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.dc
                .delegate.DCNodeBusinessDelegate.getDCNodeInstance();
    DCNodeBusinessDelegate parentDelegate = DCNodeBusinessDelegate.getDCNodeInstance();
    UUID childId = command.getAddTo().getDCNodeId();

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      DCNodeValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to add a DCNode as DCNodes to DCNode";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * remove DCNode from DCNodes
   *
   * @param command RemoveDCNodesFromDCNodeCommand
   * @exception ProcessingException
   */
  public void removeFromDCNodes(RemoveDCNodesFromDCNodeCommand command) throws ProcessingException {

    com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.dc.delegate
            .DCNodeBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.dc
                .delegate.DCNodeBusinessDelegate.getDCNodeInstance();
    UUID childId = command.getRemoveFrom().getDCNodeId();

    try {

      // --------------------------------------
      // validate the command
      // --------------------------------------
      DCNodeValidator.getInstance().validate(command);

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
   * @return DCNode
   */
  private DCNode load(UUID id) throws ProcessingException {
    dCNode = DCNodeBusinessDelegate.getDCNodeInstance().getDCNode(new DCNodeFetchOneSummary(id));
    return dCNode;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private DCNode dCNode = null;
  private static final Logger LOGGER = Logger.getLogger(DCNodeBusinessDelegate.class.getName());
}
