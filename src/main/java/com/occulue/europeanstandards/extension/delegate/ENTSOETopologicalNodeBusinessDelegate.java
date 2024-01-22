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
package com.occulue.europeanstandards.extension.delegate;

import com.occulue.api.*;
import com.occulue.delegate.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.extension.validator.*;
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
 * ENTSOETopologicalNode business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of ENTSOETopologicalNode related services in the case of a
 *       ENTSOETopologicalNode business related service failing.
 *   <li>Exposes a simpler, uniform ENTSOETopologicalNode interface to the business tier, making it
 *       easy for clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill ENTSOETopologicalNode
 *       business related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class ENTSOETopologicalNodeBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public ENTSOETopologicalNodeBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * ENTSOETopologicalNode Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return ENTSOETopologicalNodeBusinessDelegate
   */
  public static ENTSOETopologicalNodeBusinessDelegate getENTSOETopologicalNodeInstance() {
    return (new ENTSOETopologicalNodeBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createENTSOETopologicalNode(
      CreateENTSOETopologicalNodeCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getENTSOETopologicalNodeId() == null)
        command.setENTSOETopologicalNodeId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      ENTSOETopologicalNodeValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateENTSOETopologicalNodeCommand - by convention the future return value for a
      // create command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateENTSOETopologicalNodeCommand of ENTSOETopologicalNode is "
              + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create ENTSOETopologicalNode - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateENTSOETopologicalNodeCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateENTSOETopologicalNode(
      UpdateENTSOETopologicalNodeCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      ENTSOETopologicalNodeValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateENTSOETopologicalNodeCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save ENTSOETopologicalNode - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteENTSOETopologicalNodeCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteENTSOETopologicalNodeCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ENTSOETopologicalNodeValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteENTSOETopologicalNodeCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg =
          "Unable to delete ENTSOETopologicalNode using Id = "
              + command.getENTSOETopologicalNodeId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the ENTSOETopologicalNode via ENTSOETopologicalNodeFetchOneSummary
   *
   * @param summary ENTSOETopologicalNodeFetchOneSummary
   * @return ENTSOETopologicalNodeFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public ENTSOETopologicalNode getENTSOETopologicalNode(
      ENTSOETopologicalNodeFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException("ENTSOETopologicalNodeFetchOneSummary arg cannot be null");

    ENTSOETopologicalNode entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      ENTSOETopologicalNodeValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a ENTSOETopologicalNode
      // --------------------------------------
      CompletableFuture<ENTSOETopologicalNode> futureEntity =
          queryGateway.query(
              new FindENTSOETopologicalNodeQuery(
                  new LoadENTSOETopologicalNodeFilter(summary.getENTSOETopologicalNodeId())),
              ResponseTypes.instanceOf(ENTSOETopologicalNode.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg =
          "Unable to locate ENTSOETopologicalNode with id " + summary.getENTSOETopologicalNodeId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all ENTSOETopologicalNodes
   *
   * @return List<ENTSOETopologicalNode>
   * @exception ProcessingException Thrown if any problems
   */
  public List<ENTSOETopologicalNode> getAllENTSOETopologicalNode() throws ProcessingException {
    List<ENTSOETopologicalNode> list = null;

    try {
      CompletableFuture<List<ENTSOETopologicalNode>> futureList =
          queryGateway.query(
              new FindAllENTSOETopologicalNodeQuery(),
              ResponseTypes.multipleInstancesOf(ENTSOETopologicalNode.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all ENTSOETopologicalNode";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return ENTSOETopologicalNode
   */
  private ENTSOETopologicalNode load(UUID id) throws ProcessingException {
    eNTSOETopologicalNode =
        ENTSOETopologicalNodeBusinessDelegate.getENTSOETopologicalNodeInstance()
            .getENTSOETopologicalNode(new ENTSOETopologicalNodeFetchOneSummary(id));
    return eNTSOETopologicalNode;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private ENTSOETopologicalNode eNTSOETopologicalNode = null;
  private static final Logger LOGGER =
      Logger.getLogger(ENTSOETopologicalNodeBusinessDelegate.class.getName());
}
