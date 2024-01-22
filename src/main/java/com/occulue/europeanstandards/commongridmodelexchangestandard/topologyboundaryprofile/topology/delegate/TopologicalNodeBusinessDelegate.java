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
package com.occulue.europeanstandards.commongridmodelexchangestandard.topologyboundaryprofile.topology.delegate;

import com.occulue.api.*;
import com.occulue.delegate.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.topologyboundaryprofile.topology.validator.*;
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
 * TopologicalNode business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of TopologicalNode related services in the case of a
 *       TopologicalNode business related service failing.
 *   <li>Exposes a simpler, uniform TopologicalNode interface to the business tier, making it easy
 *       for clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill TopologicalNode business
 *       related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class TopologicalNodeBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public TopologicalNodeBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * TopologicalNode Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return TopologicalNodeBusinessDelegate
   */
  public static TopologicalNodeBusinessDelegate getTopologicalNodeInstance() {
    return (new TopologicalNodeBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createTopologicalNode(CreateTopologicalNodeCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getTopologicalNodeId() == null) command.setTopologicalNodeId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      TopologicalNodeValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateTopologicalNodeCommand - by convention the future return value for a create
      // command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateTopologicalNodeCommand of TopologicalNode is "
              + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create TopologicalNode - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateTopologicalNodeCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateTopologicalNode(UpdateTopologicalNodeCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      TopologicalNodeValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateTopologicalNodeCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save TopologicalNode - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteTopologicalNodeCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteTopologicalNodeCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      TopologicalNodeValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteTopologicalNodeCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg =
          "Unable to delete TopologicalNode using Id = " + command.getTopologicalNodeId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the TopologicalNode via TopologicalNodeFetchOneSummary
   *
   * @param summary TopologicalNodeFetchOneSummary
   * @return TopologicalNodeFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public TopologicalNode getTopologicalNode(TopologicalNodeFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException("TopologicalNodeFetchOneSummary arg cannot be null");

    TopologicalNode entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      TopologicalNodeValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a TopologicalNode
      // --------------------------------------
      CompletableFuture<TopologicalNode> futureEntity =
          queryGateway.query(
              new FindTopologicalNodeQuery(
                  new LoadTopologicalNodeFilter(summary.getTopologicalNodeId())),
              ResponseTypes.instanceOf(TopologicalNode.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg =
          "Unable to locate TopologicalNode with id " + summary.getTopologicalNodeId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all TopologicalNodes
   *
   * @return List<TopologicalNode>
   * @exception ProcessingException Thrown if any problems
   */
  public List<TopologicalNode> getAllTopologicalNode() throws ProcessingException {
    List<TopologicalNode> list = null;

    try {
      CompletableFuture<List<TopologicalNode>> futureList =
          queryGateway.query(
              new FindAllTopologicalNodeQuery(),
              ResponseTypes.multipleInstancesOf(TopologicalNode.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all TopologicalNode";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign BoundaryPoint on TopologicalNode
   *
   * @param command AssignBoundaryPointToTopologicalNodeCommand
   * @exception ProcessingException
   */
  public void assignBoundaryPoint(AssignBoundaryPointToTopologicalNodeCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getTopologicalNodeId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .BooleanProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .BooleanProxyBusinessDelegate.getBooleanProxyInstance();
    TopologicalNodeBusinessDelegate parentDelegate =
        TopologicalNodeBusinessDelegate.getTopologicalNodeInstance();
    UUID childId = command.getAssignment().getBooleanProxyId();
    BooleanProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      TopologicalNodeValidator.getInstance().validate(command);

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
   * unAssign BoundaryPoint on TopologicalNode
   *
   * @param command UnAssignBoundaryPointFromTopologicalNodeCommand
   * @exception ProcessingException
   */
  public void unAssignBoundaryPoint(UnAssignBoundaryPointFromTopologicalNodeCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      TopologicalNodeValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign BoundaryPoint on TopologicalNode";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign FromEndIsoCode on TopologicalNode
   *
   * @param command AssignFromEndIsoCodeToTopologicalNodeCommand
   * @exception ProcessingException
   */
  public void assignFromEndIsoCode(AssignFromEndIsoCodeToTopologicalNodeCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getTopologicalNodeId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .StringProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .StringProxyBusinessDelegate.getStringProxyInstance();
    TopologicalNodeBusinessDelegate parentDelegate =
        TopologicalNodeBusinessDelegate.getTopologicalNodeInstance();
    UUID childId = command.getAssignment().getStringProxyId();
    StringProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      TopologicalNodeValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get StringProxy using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign FromEndIsoCode on TopologicalNode
   *
   * @param command UnAssignFromEndIsoCodeFromTopologicalNodeCommand
   * @exception ProcessingException
   */
  public void unAssignFromEndIsoCode(UnAssignFromEndIsoCodeFromTopologicalNodeCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      TopologicalNodeValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign FromEndIsoCode on TopologicalNode";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign FromEndName on TopologicalNode
   *
   * @param command AssignFromEndNameToTopologicalNodeCommand
   * @exception ProcessingException
   */
  public void assignFromEndName(AssignFromEndNameToTopologicalNodeCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getTopologicalNodeId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .StringProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .StringProxyBusinessDelegate.getStringProxyInstance();
    TopologicalNodeBusinessDelegate parentDelegate =
        TopologicalNodeBusinessDelegate.getTopologicalNodeInstance();
    UUID childId = command.getAssignment().getStringProxyId();
    StringProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      TopologicalNodeValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get StringProxy using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign FromEndName on TopologicalNode
   *
   * @param command UnAssignFromEndNameFromTopologicalNodeCommand
   * @exception ProcessingException
   */
  public void unAssignFromEndName(UnAssignFromEndNameFromTopologicalNodeCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      TopologicalNodeValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign FromEndName on TopologicalNode";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign FromEndNameTso on TopologicalNode
   *
   * @param command AssignFromEndNameTsoToTopologicalNodeCommand
   * @exception ProcessingException
   */
  public void assignFromEndNameTso(AssignFromEndNameTsoToTopologicalNodeCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getTopologicalNodeId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .StringProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .StringProxyBusinessDelegate.getStringProxyInstance();
    TopologicalNodeBusinessDelegate parentDelegate =
        TopologicalNodeBusinessDelegate.getTopologicalNodeInstance();
    UUID childId = command.getAssignment().getStringProxyId();
    StringProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      TopologicalNodeValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get StringProxy using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign FromEndNameTso on TopologicalNode
   *
   * @param command UnAssignFromEndNameTsoFromTopologicalNodeCommand
   * @exception ProcessingException
   */
  public void unAssignFromEndNameTso(UnAssignFromEndNameTsoFromTopologicalNodeCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      TopologicalNodeValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign FromEndNameTso on TopologicalNode";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign ToEndIsoCode on TopologicalNode
   *
   * @param command AssignToEndIsoCodeToTopologicalNodeCommand
   * @exception ProcessingException
   */
  public void assignToEndIsoCode(AssignToEndIsoCodeToTopologicalNodeCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getTopologicalNodeId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .StringProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .StringProxyBusinessDelegate.getStringProxyInstance();
    TopologicalNodeBusinessDelegate parentDelegate =
        TopologicalNodeBusinessDelegate.getTopologicalNodeInstance();
    UUID childId = command.getAssignment().getStringProxyId();
    StringProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      TopologicalNodeValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get StringProxy using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign ToEndIsoCode on TopologicalNode
   *
   * @param command UnAssignToEndIsoCodeFromTopologicalNodeCommand
   * @exception ProcessingException
   */
  public void unAssignToEndIsoCode(UnAssignToEndIsoCodeFromTopologicalNodeCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      TopologicalNodeValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign ToEndIsoCode on TopologicalNode";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign ToEndName on TopologicalNode
   *
   * @param command AssignToEndNameToTopologicalNodeCommand
   * @exception ProcessingException
   */
  public void assignToEndName(AssignToEndNameToTopologicalNodeCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getTopologicalNodeId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .StringProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .StringProxyBusinessDelegate.getStringProxyInstance();
    TopologicalNodeBusinessDelegate parentDelegate =
        TopologicalNodeBusinessDelegate.getTopologicalNodeInstance();
    UUID childId = command.getAssignment().getStringProxyId();
    StringProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      TopologicalNodeValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get StringProxy using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign ToEndName on TopologicalNode
   *
   * @param command UnAssignToEndNameFromTopologicalNodeCommand
   * @exception ProcessingException
   */
  public void unAssignToEndName(UnAssignToEndNameFromTopologicalNodeCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      TopologicalNodeValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign ToEndName on TopologicalNode";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign ToEndNameTso on TopologicalNode
   *
   * @param command AssignToEndNameTsoToTopologicalNodeCommand
   * @exception ProcessingException
   */
  public void assignToEndNameTso(AssignToEndNameTsoToTopologicalNodeCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getTopologicalNodeId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .StringProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .StringProxyBusinessDelegate.getStringProxyInstance();
    TopologicalNodeBusinessDelegate parentDelegate =
        TopologicalNodeBusinessDelegate.getTopologicalNodeInstance();
    UUID childId = command.getAssignment().getStringProxyId();
    StringProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      TopologicalNodeValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get StringProxy using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign ToEndNameTso on TopologicalNode
   *
   * @param command UnAssignToEndNameTsoFromTopologicalNodeCommand
   * @exception ProcessingException
   */
  public void unAssignToEndNameTso(UnAssignToEndNameTsoFromTopologicalNodeCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      TopologicalNodeValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign ToEndNameTso on TopologicalNode";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * add TopologicalNode to TopologicalNode
   *
   * @param command AssignTopologicalNodeToTopologicalNodeCommand
   * @exception ProcessingException
   */
  public void addToTopologicalNode(AssignTopologicalNodeToTopologicalNodeCommand command)
      throws ProcessingException {

    // -------------------------------------------
    // load the parent
    // -------------------------------------------
    load(command.getTopologicalNodeId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.topologyboundaryprofile.topology
            .delegate.TopologicalNodeBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.topologyboundaryprofile
                .topology.delegate.TopologicalNodeBusinessDelegate.getTopologicalNodeInstance();
    TopologicalNodeBusinessDelegate parentDelegate =
        TopologicalNodeBusinessDelegate.getTopologicalNodeInstance();
    UUID childId = command.getAddTo().getTopologicalNodeId();

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      TopologicalNodeValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to add a TopologicalNode as TopologicalNode to TopologicalNode";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * remove TopologicalNode from TopologicalNode
   *
   * @param command RemoveTopologicalNodeFromTopologicalNodeCommand
   * @exception ProcessingException
   */
  public void removeFromTopologicalNode(RemoveTopologicalNodeFromTopologicalNodeCommand command)
      throws ProcessingException {

    com.occulue.europeanstandards.commongridmodelexchangestandard.topologyboundaryprofile.topology
            .delegate.TopologicalNodeBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.topologyboundaryprofile
                .topology.delegate.TopologicalNodeBusinessDelegate.getTopologicalNodeInstance();
    UUID childId = command.getRemoveFrom().getTopologicalNodeId();

    try {

      // --------------------------------------
      // validate the command
      // --------------------------------------
      TopologicalNodeValidator.getInstance().validate(command);

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
   * @return TopologicalNode
   */
  private TopologicalNode load(UUID id) throws ProcessingException {
    topologicalNode =
        TopologicalNodeBusinessDelegate.getTopologicalNodeInstance()
            .getTopologicalNode(new TopologicalNodeFetchOneSummary(id));
    return topologicalNode;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private TopologicalNode topologicalNode = null;
  private static final Logger LOGGER =
      Logger.getLogger(TopologicalNodeBusinessDelegate.class.getName());
}
